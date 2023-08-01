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
 * Servlet implementation class AdminProfile
 */
public class AdminProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminProfile() {
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
	UserBean user = new UserBean(); 
	user = db.searchUser(id);
		
	if(action.equals("Search"))
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
			RequestDispatcher rd =request.getRequestDispatcher("adminProfile.jsp");
			rd.include(request, response);
		}
	}
	
	else if(action.equals("Delete"))
	{
		if(id.equals("a101"))
		{
			pw.print("<script>alert('Admin Id No one can delete this ')</script>");
			RequestDispatcher rd =request.getRequestDispatcher("adminProfile.jsp");
			rd.include(request, response);
		}
		else if(user!=null)
		{
			
			int deleteUser = db.deleteUser(id);
			
			 if(deleteUser==1)
			{
				pw.print("<script>alert('User Deleted')</script>");
				RequestDispatcher rd =request.getRequestDispatcher("adminProfile.jsp");
				rd.include(request, response);
			}
			else
			{
				pw.print("<script>alert('User is not Deleted')</script>");
				RequestDispatcher rd =request.getRequestDispatcher("adminProfile.jsp");
				rd.include(request, response);
			}
		}
		else
		{
			System.out.println("id doesn't match ");
			pw.print("<script>alert('id does not match')</script>");
			RequestDispatcher rd =request.getRequestDispatcher("adminProfile.jsp");
			rd.include(request, response);
		}
		
	}
	
	else if(action.equals("Edit"))
	{
		if(id.equals("a101"))
		{
			if(user!=null)
			{
				
				request.setAttribute("id", user.getId());
				request.setAttribute("name", user.getName());
				request.setAttribute("username", user.getUsername());
				request.setAttribute("email", user.getEmail());
				request.setAttribute("password", user.getPassword());
				request.getRequestDispatcher("EditAdmin.jsp").forward(request, response);
			}
		}
		else
		{
			pw.print("<script>alert('Admin cannot update this user')</script>");
			RequestDispatcher rd =request.getRequestDispatcher("adminProfile.jsp");
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
			pw.print("<script>alert('Admin Update his profile')</script>");
			RequestDispatcher rd =request.getRequestDispatcher("adminProfile.jsp");
			rd.include(request, response);
		}
		else
		{
			pw.print("<script>alert('Admin cannot  Update his profile')</script>");
			RequestDispatcher rd =request.getRequestDispatcher("adminProfile.jsp");
			rd.include(request, response);
		}
	}
	else if(action.equals("InsertResult"))
	{
		RequestDispatcher rd =request.getRequestDispatcher("InsertResult.jsp");
		rd.include(request, response);
	}
	else if(action.equals("AdmissionFormShow"))
	{
		RequestDispatcher rd =request.getRequestDispatcher("AdmissionShow1.jsp");
		rd.forward(request, response);
	}
	/*
	 * else if(action.equals("InsertR")) {
	 * user.setReg_no(Integer.parseInt(request.getParameter("reg_no")));
	 * user.setSname(request.getParameter("sname"));
	 * user.setMothername(request.getParameter("mothername"));
	 * user.setCourses(request.getParameter("courses"));
	 * user.setSubject1marks(Integer.parseInt(request.getParameter("subject1marks"))
	 * );
	 * user.setSubject2marks(Integer.parseInt(request.getParameter("subject2marks"))
	 * );
	 * user.setSubject3marks(Integer.parseInt(request.getParameter("subject3marks"))
	 * ); user.setRemarks(request.getParameter("remarks"));
	 * 
	 * int insertResults = db.insertResult(user); if(insertResults==1) {
	 * pw.print("<script>alert('Result Inserted')</script>"); RequestDispatcher rd
	 * =request.getRequestDispatcher("InsertResult.jsp"); rd.include(request,
	 * response); } else {
	 * pw.print("<script>alert('Result not Inserted')</script>"); RequestDispatcher
	 * rd =request.getRequestDispatcher("InsertResult.jsp"); rd.include(request,
	 * response); } }
	 */
	
	}
	

}
