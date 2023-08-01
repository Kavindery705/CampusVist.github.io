package com.files;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;

/**
 * Servlet Filter implementation class OtpVerify
 */
public class OtpVerify extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public OtpVerify() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		String from = "youremail@gmail.com";
		String to = request.getParameter("email");
		System.out.println(to);
		String sub ="otp for registration ";
		String otp = genrateOtp();
		String message ="your otp "+otp;

		Properties properties = System.getProperties();

		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");

		Session session = Session.getInstance(properties, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication("youremail@gmail.com", "yourapppassword");
			}
			 
		});
		session.setDebug(true);

		MimeMessage m = new MimeMessage(session);
		
		try {
			m.setFrom(from);
			m.addRecipient(RecipientType.TO,new InternetAddress(to));
			m.setSubject(sub);
			m.setText(message);
			Transport.send(m);
			System.out.println("otp sent");
			pw.print("<script>otp sent successfully</script>");
			request.setAttribute("otp",otp);
			
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

		chain.doFilter(request, response);
	}
private String genrateOtp() {
	int len = 4;
	String numbers = "0123456789";
	Random random = new Random();
	char otp[] = new char[len];
	for(int i =0;i<otp.length;i++)
	{
		otp[i] = numbers.charAt(random.nextInt(numbers.length()));
	}
	return String.valueOf(otp);
}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
