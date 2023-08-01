package com.files;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Download
 */
public class Download extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Download() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("type");
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String path = "E:\\Myfirst java\\CampusVisit\\downloadfiles\\";
		String filename ="";
		response.setContentType("APPLICATION/OCTET-STREAM");
		if(type.equals("file1"))
		{
			filename ="prospectus.pdf";
		}
		else if(type.equals("MCA"))
		{
			filename ="MCA.pdf";
		}
		else if(type.equals("MBA"))
		{
			filename ="MBA.pdf";
		}
		else if(type.equals("BTech"))
		{
			filename ="Btech.pdf";
		}
		else if(type.equals("Msc Phy"))
		{
			filename ="Msc phy.pdf";
		}
		else if(type.equals("Msc Chem"))
		{
			filename ="Msc Chem.pdf";
		}
		else if(type.equals("Msc Math"))
		{
			filename ="Msc math.pdf";
		}
		else if(type.equals("MSW"))
		{
			filename ="MSW.pdf";
		}
		else if(type.equals("MA"))
		{
			filename ="MA.pdf";
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
