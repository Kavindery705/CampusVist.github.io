package com.files;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.files.Entites.UserBean;
import com.files.Entites.UserDao;


@MultipartConfig(maxFileSize = 16177215) // upload file's size up to 16MB
/**
 * Servlet implementation class Admission
 */
public class Admission extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admission() {
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
		UserBean ub = new UserBean();
		ub.setSname(request.getParameter("sname"));
		ub.setFathername(request.getParameter("fathername"));
		ub.setDob(request.getParameter("dob"));
		ub.setGender(request.getParameter("gender"));
		ub.setAddress(request.getParameter("address"));
		ub.setCity(request.getParameter("city"));
		ub.setState(request.getParameter("state"));
		ub.setPin(request.getParameter("pin"));
		ub.setEmail(request.getParameter("email"));
		ub.setPhone(Long.parseLong(request.getParameter("phone")));
		Part part = request.getPart("tenth");
		String filename = part.getSubmittedFileName();
		InputStream fis = part.getInputStream();
		String path = "E:\\Myfirst java\\CampusVisit\\uploadedfiles\\"+filename;
		System.out.println(path);
		int i;
		
		FileOutputStream fos = new FileOutputStream(path);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		while((i=fis.read())!=-1)
		{
			bos.write(i);
		}
		System.out.println(filename);
		ub.setTenth(filename);
		
		Part part1 = request.getPart("twelth");
		String filename2 = part1.getSubmittedFileName();
		InputStream fis2 = part1.getInputStream();
		String path1 ="E:\\Myfirst java\\CampusVisit\\uploadedfiles\\"+filename2;
		int j;
		
		FileOutputStream fos1 = new FileOutputStream(path1);
		BufferedOutputStream bos1 = new BufferedOutputStream(fos1);
		while((j=fis2.read())!=-1)
		{
			bos1.write(j);
		}
		System.out.println(filename2);
		ub.setTwelth(filename2);
		ub.setCourses(request.getParameter("course"));
		int status = db.insertAdmission(ub);
//		 InputStream fis = null; // input stream of the upload file
//         
//	        // obtains the upload file part in this multipart request
//	        Part filePart = request.getPart("tenth");
//	        if (filePart != null) {
//	            // prints out some information for debugging
//	            System.out.println(filePart.getName());
//	            System.out.println(filePart.getSize());
//	            System.out.println(filePart.getContentType());
//	             
//	            // obtains input stream of the upload file
//	            fis = filePart.getInputStream();
//	        }
//	        InputStream fis2 = null; // input stream of the upload file
//	         
//	        // obtains the upload file part in this multipart request
//	        Part filePart2 = request.getPart("twelth");
//	        if (filePart != null) {
//	            // prints out some information for debugging
//	            System.out.println(filePart2.getName());
//	            System.out.println(filePart2.getSize());
//	            System.out.println(filePart2.getContentType());
//	             
//	            // obtains input stream of the upload file
//	            fis2 = filePart2.getInputStream();
//	        } 
//	        
//	        ub.setCourse(request.getParameter("course"));
//	        int status = db.insertAdmission(ub, fis, fis2);
		
	        if(status==1)
	        {
	        	pw.print("<script>alert('form submit')</script>");
	        	request.getRequestDispatcher("Admission.jsp").include(request, response);
	        }
	        else
	        {
	        	pw.print("<script>alert('form not submit')</script>");
	        	request.getRequestDispatcher("Admission.jsp").include(request, response);
	        }
	}

}
