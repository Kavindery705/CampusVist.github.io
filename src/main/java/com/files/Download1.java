package com.files;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.files.Entites.UserBean;
import com.files.Entites.UserDao;

/**
 * Servlet implementation class Download1
 */
public class Download1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Download1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("type");
		int id =Integer.parseInt(request.getParameter("id"));
		response.setContentType("text/html");
		UserDao db = new UserDao();
		UserBean ub = db.showAdmissionOne(id);
		PrintWriter pw = response.getWriter();
		String path = "E:\\Myfirst java\\CampusVisit\\src\\main\\webapp\\Tenthtwelfth\\";
//		+ub.getSname()+"Tenth"+ub.getS_id()+".pdf";
		String filename ="";
		response.setContentType("APPLICATION/OCTET-STREAM");
		if(type.equals("file1"))
		{
			filename =ub.getSname()+"Tenth"+ub.getS_id()+".pdf";
		}
		else if(type.equals("file2"))
		{
			filename =ub.getSname()+"Twelfth"+ub.getS_id()+".pdf";
		}
		response.setHeader("Content-Disposition","attachment;filename=\""+filename+"\"");
		FileInputStream fis = new FileInputStream(path+filename);
		BufferedInputStream bis = new BufferedInputStream(fis);
		int i ;
		while((i=bis.read())!=-1)
		{
			pw.write(i);
		}
		bis.close();
		pw.close();
	}

}
