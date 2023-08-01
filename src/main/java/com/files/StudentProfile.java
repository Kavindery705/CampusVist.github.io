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
 * Servlet implementation class StudentProfile
 */
public class StudentProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentProfile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String action =request.getParameter("action");
		String id = request.getParameter("id");
		UserDao db = new UserDao();
		UserBean user = db.searchUser(id);
			
		if(action.equals("View"))
		{
			if(user!=null)
			{
				
				request.setAttribute("id", user.getId());
				request.setAttribute("name", user.getName());
				request.setAttribute("username", user.getUsername());
				request.setAttribute("email", user.getEmail());
				request.getRequestDispatcher("ViewSearch.jsp").forward(request, response);
			}
			else
			{
				pw.print("<script>alert('id does not match!')</script>");
				RequestDispatcher rd =request.getRequestDispatcher("studentProfile.jsp");
				rd.include(request, response);
			}
		}
		
		else if(action.equals("Delete"))
		{
			
			 if(user!=null)
			{
				
				int deleteUser = db.deleteUser(id);
				
				 if(deleteUser==1)
				{
					pw.print("<script>alert('User Deleted')</script>");
					RequestDispatcher rd =request.getRequestDispatcher("Studentlogin.jsp");
					rd.include(request, response);
				}
				else
				{
					pw.print("<script>alert('User is not Deleted')</script>");
					RequestDispatcher rd =request.getRequestDispatcher("studentProfile.jsp");
					rd.include(request, response);
				}
			}
			else
			{
				System.out.println("id doesn't match ");
				pw.print("<script>alert('id does not match')</script>");
				RequestDispatcher rd =request.getRequestDispatcher("studentProfile.jsp");
				rd.include(request, response);
			}
			
		}
		
		else if(action.equals("Edit"))
		{
			if(user!=null)
				{
					
					request.setAttribute("id", user.getId());
					request.setAttribute("name", user.getName());
					request.setAttribute("username", user.getUsername());
					request.setAttribute("email", user.getEmail());
					request.setAttribute("password", user.getPassword());
					request.getRequestDispatcher("EditUser.jsp").forward(request, response);
				}
			
			else
			{
				pw.print("<script>alert('User cannot update this user')</script>");
				RequestDispatcher rd =request.getRequestDispatcher("studentProfile.jsp");
				rd.include(request, response);
			}
		}
		else if(action.equals("Update"))
		{
			user.setName(request.getParameter("name"));
			user.setUsername(request.getParameter("username"));
			user.setEmail(request.getParameter("email"));
			user.setPassword(request.getParameter("password"));
			
			int updateUser = db.updateUser(user);
			
			if(updateUser==1)
			{
				pw.print("<script>alert('User Update his profile')</script>");
				RequestDispatcher rd =request.getRequestDispatcher("studentProfile.jsp");
				rd.include(request, response);
			}
			else
			{
				pw.print("<script>alert('User cannot  Update his profile')</script>");
				RequestDispatcher rd =request.getRequestDispatcher("studentProfile.jsp");
				rd.include(request, response);
			}
	}
	}
}
