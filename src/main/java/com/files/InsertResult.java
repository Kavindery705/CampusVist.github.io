package com.files;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.files.Entites.UserBean;
import com.files.Entites.UserDao;

/**
 * Servlet implementation class InsertResult
 */

@MultipartConfig(maxFileSize = 16177215) 
public class InsertResult extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertResult() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		UserBean user = new UserBean();
		UserDao db = new UserDao();
		user.setReg_no(Long.parseLong(request.getParameter("reg_no")));
		user.setSname(request.getParameter("sname"));
		user.setMothername(request.getParameter("mothername"));
		user.setCourses(request.getParameter("courses"));
		user.setSubject1marks(Integer.parseInt(request.getParameter("subject1marks")));
		user.setSubject2marks(Integer.parseInt(request.getParameter("subject2marks")));
		user.setSubject3marks(Integer.parseInt(request.getParameter("subject3marks")));
		user.setRemarks(request.getParameter("remarks"));
		
		int ir = db.insertResult(user);
		if(ir==1)
		{
			pw.print("<script>alert('Result Inserted')</script>");
			RequestDispatcher rd =request.getRequestDispatcher("InsertResult.jsp");
			rd.include(request, response);
		}
		else
		{
			pw.print("<script>alert('Result not Inserted')</script>");
			RequestDispatcher rd =request.getRequestDispatcher("InsertResult.jsp");
			rd.include(request, response);
		}
	
	}

}
