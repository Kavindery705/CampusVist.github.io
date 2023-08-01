package com.files;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.files.Entites.UserBean;
import com.files.Entites.UserDao;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		UserBean ub = new UserBean();
		UserDao db = new UserDao();
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		ub.setId(id);
		ub.setName(name);
		ub.setUsername(username);
		ub.setEmail(email);
		ub.setPassword(password);
		int status = db.inserUser(ub);
		if(status==1)
		{
			pw.print("<script>alert('inserted')</script>");
			RequestDispatcher rd = request.getRequestDispatcher("Studentlogin.jsp");
			rd.forward(request, response);
		}
		else
		{
			pw.print("<script>alert('unable to insert')</script>");
			RequestDispatcher rd = request.getRequestDispatcher("Studentlogin.jsp");
			rd.forward(request, response);
		}
		
	}

}
