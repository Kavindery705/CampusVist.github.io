package com.files;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.files.Entites.UserBean;
import com.files.Entites.UserDao;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		UserDao db = new UserDao();
		String adminuser = request.getParameter("ausername");
		System.out.println(adminuser);
		String adminpass = request.getParameter("apassword");
		UserBean ub = db.getUser(adminuser, adminpass);
		if(ub!=null)
		{
			System.out.println("hello");
			 System.out.println(ub.getId());
			 request.setAttribute("id", ub.getId());
			if(adminuser.equals("Admin0001") && adminpass.equals(ub.getPassword()))
			{
				pw.print("<script>alert('Admin Logged in')</script>");
				request.getRequestDispatcher("adminProfile.jsp").forward(request, response);
			}
		}
		else
		{
			pw.print("<script>alert('Either id or password incorrect')</script>");
			request.getRequestDispatcher("Adminlogin.jsp").include(request, response);
		}
		
	}

}
