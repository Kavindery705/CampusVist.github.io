package com.files;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.files.Entites.UserBean;
import com.files.Entites.UserDao;

/**
 * Servlet implementation class StudentLoginServlet
 */
public class StudentLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentLoginServlet() {
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
		String user = request.getParameter("username");
		String pass = request.getParameter("password");
		UserBean ub = db.getUser(user, pass);
		if(ub!=null)
		{
			System.out.println("hello");
			 System.out.println(ub.getId());
			if(user.equals(ub.getUsername()))
			{
				HttpSession session = request.getSession();
				session.setAttribute("uid", ub.getId());
				session.setAttribute("name", ub.getName());
				pw.print("<script>alert('Admin Logged in')</script>");
				request.getRequestDispatcher("studentProfile.jsp").forward(request, response);
			}
			else
			{
				pw.print("<script>alert('Either id or password incorrect')</script>");
				request.getRequestDispatcher("Studentlogin.jsp").include(request, response);
			}
		}
		else
		{
			pw.print("<script>alert('Either id or password incorrect')</script>");
			request.getRequestDispatcher("Studentlogin.jsp").include(request, response);
		}
	
	}

}
