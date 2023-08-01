package com.files.Entites;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

public class UserDao {

	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	public UserDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Found!");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/campusvisit","root","1234");
			 System.out.println("Connected !!!");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	public UserBean getUser(String uname , String pass)
	{
		UserBean ub = null;
		try {
			ps=con.prepareStatement("select * from login where username = ? and password = ?");
			ps.setString(1, uname);
			ps.setString(2, pass);
			
			rs =ps.executeQuery();
			if(rs.next())
			{
				ub = new UserBean();
				ub.setId(rs.getString(1));
				ub.setName(rs.getString(2));
				ub.setUsername(rs.getString(3));
				ub.setEmail(rs.getString(4));
				ub.setPassword(rs.getString(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ub;
		
	}
	public int inserUser(UserBean ub)
	{
		int status = 0;
		try {
			ps=con.prepareStatement("insert into login values(?,?,?,?,?)");
			ps.setString(1, ub.getId());
			ps.setString(2, ub.getName());
			ps.setString(3, ub.getUsername());
			ps.setString(4, ub.getEmail());
			ps.setString(5, ub.getPassword());
			
			status = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
		
	}
	
	public int insertAdmission(UserBean ub)
	{
		int status = 0;
		try {
			ps=con.prepareStatement("insert into admission(sname,fathername,dob,gender,address,city,state,pin,email,phone,tenth,twelth,courses) values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, ub.getSname());
			ps.setString(2, ub.getFathername());
			ps.setString(3, ub.getDob());
			ps.setString(4, ub.getGender());
			ps.setString(5, ub.getAddress());
			ps.setString(6, ub.getCity());
			ps.setString(7, ub.getState());
			ps.setString(8, ub.getPin());
			ps.setString(9, ub.getEmail());
			ps.setLong(10, ub.getPhone());
			ps.setString(11, ub.getTenth());
			ps.setString(12, ub.getTwelth());
			ps.setString(13, ub.getCourses());
			
			
			
			
			status = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
		
	}
	public int insertAdmission1(UserBean ub , InputStream fis , InputStream fis1)
	{
		int status = 0;
		try {
			ps=con.prepareStatement("insert into admission1(sname,fathername,dob,gender,address,city,state,pin,email,phone,tenth1,twelfth1,courses) values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, ub.getSname());
			ps.setString(2, ub.getFathername());
			ps.setString(3, ub.getDob());
			ps.setString(4, ub.getGender());
			ps.setString(5, ub.getAddress());
			ps.setString(6, ub.getCity());
			ps.setString(7, ub.getState());
			ps.setString(8, ub.getPin());
			ps.setString(9, ub.getEmail());
			ps.setLong(10, ub.getPhone());
			ps.setBlob(11, fis);
			ps.setBlob(12, fis1);
			ps.setString(13, ub.getCourses());
			
			
			
			
			status = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
		
	}
	public List<UserBean> getAllCourse()
	{
		
		UserBean ub = null;
		List<UserBean> list = new ArrayList<>();
		
		try {
			ps=con.prepareStatement("select * from course");
		
			
			rs =ps.executeQuery();
			while(rs.next())
			{
				ub = new UserBean();
				ub.setC_id(rs.getInt(1));
				ub.setCourses(rs.getString(2));
				list.add(ub);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
		
	}
	public List<UserBean> showAdmission()
	{
		
		UserBean ub = null;
		List<UserBean> list = new ArrayList<>();
		
		try {
			ps=con.prepareStatement("select * from admission");
			
			
			rs =ps.executeQuery();
			while(rs.next())
			{
				ub = new UserBean();
				ub.setSname(rs.getString(1));
				ub.setFathername(rs.getString(2));
				ub.setDob(rs.getString(3));
				ub.setGender(rs.getString(4));
				ub.setAddress(rs.getString(5));
				ub.setCity(rs.getString(6));
				ub.setState(rs.getString(7));
				ub.setPin(rs.getString(8));
				ub.setEmail(rs.getString(9));
				ub.setPhone(rs.getLong(10));
				ub.setTenth(rs.getString(11));
				ub.setTwelth(rs.getString(12));
				ub.setCourses(rs.getString(13));
				ub.setS_id(rs.getInt(14));
				list.add(ub);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
		
	}
	public List<UserBean> showAdmission1()
	{
		
		UserBean ub = null;
		List<UserBean> list = new ArrayList<>();
		
		try {
			ps=con.prepareStatement("select * from admission1");
			
			
			rs =ps.executeQuery();
			while(rs.next())
			{
				ub = new UserBean();
				ub.setSname(rs.getString(1));
				ub.setFathername(rs.getString(2));
				ub.setDob(rs.getString(3));
				ub.setGender(rs.getString(4));
				ub.setAddress(rs.getString(5));
				ub.setCity(rs.getString(6));
				ub.setState(rs.getString(7));
				ub.setPin(rs.getString(8));
				ub.setEmail(rs.getString(9));
				ub.setPhone(rs.getLong(10));
				ub.setTenth1(rs.getBlob(11));
				ub.setTwelfth1(rs.getBlob(12));
				ub.setCourses(rs.getString(13));
				ub.setS_id(rs.getInt(14));
				list.add(ub);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(ub!=null)
		{
			
	
		try {
			InputStream fis = ub.getTenth1().getBinaryStream();
			
			FileOutputStream fos = new FileOutputStream("E:\\Myfirst java\\CampusVisit\\src\\main\\webapp\\Tenthtwelfth\\"+ub.getSname()+"Tenth"+ub.getS_id()+".pdf");
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			int i;
			while((i=fis.read())!=-1)
			{
				bos.write(i);
			}
			bos.close();
			
			
			InputStream fis1 = ub.getTwelfth1().getBinaryStream();
			FileOutputStream fos1 = new FileOutputStream("E:\\Myfirst java\\CampusVisit\\src\\main\\webapp\\Tenthtwelfth\\"+ub.getSname()+"Twelfth"+ub.getS_id()+".pdf");
			BufferedOutputStream bos1 = new BufferedOutputStream(fos1);
			int j;
			while((j=fis1.read())!=-1)
			{
				bos1.write(j);
			}
			bos1.close();
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		return list;
		
	}
	public UserBean showAdmissionOne(int s_id)
	{
		
		UserBean ub = null;
		
		try {
			ps=con.prepareStatement("select * from admission1 where s_id =?");
			ps.setInt(1, s_id);
			
			
			rs =ps.executeQuery();
			while(rs.next())
			{
				ub = new UserBean();
				ub.setSname(rs.getString(1));
				ub.setFathername(rs.getString(2));
				ub.setDob(rs.getString(3));
				ub.setGender(rs.getString(4));
				ub.setAddress(rs.getString(5));
				ub.setCity(rs.getString(6));
				ub.setState(rs.getString(7));
				ub.setPin(rs.getString(8));
				ub.setEmail(rs.getString(9));
				ub.setPhone(rs.getLong(10));
				ub.setTenth1(rs.getBlob(11));
				ub.setTwelfth1(rs.getBlob(12));
				ub.setCourses(rs.getString(13));
				ub.setS_id(rs.getInt(14));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ub;
	}
	public UserBean searchUser(String id)
	{
		UserBean ub = null;
		try {
			ps=con.prepareStatement("select * from login where id =?");
			ps.setString(1, id);
			
			rs =ps.executeQuery();
			if(rs.next())
			{
				ub = new UserBean();
				ub.setId(rs.getString(1));
				ub.setName(rs.getString(2));
				ub.setUsername(rs.getString(3));
				ub.setEmail(rs.getString(4));
				ub.setPassword(rs.getString(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ub;
		
	}
	public int deleteUser(String id)
	{
		int status =0;
		try {
			ps=con.prepareStatement("delete from login where id =?");
			ps.setString(1, id);
			
			status=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return status;
		
	}
	public int updateUser(UserBean ub)
	{
		int status = 0;
		try {
			ps=con.prepareStatement("update login set name =? , username =? , email =?,password =? where id =?");
			
			ps.setString(1, ub.getName());
			ps.setString(2, ub.getUsername());
			ps.setString(3, ub.getEmail());
			ps.setString(4, ub.getPassword());
			ps.setString(5, ub.getId());
			status = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
		
	}
	public List<UserBean> getAllRecordPage(int start ,int total)
	{
		
		UserBean ub = null;
		List<UserBean> list = new ArrayList<>();
		
		try {
			ps=con.prepareStatement("select * from login limit ? , ?");
			ps.setInt(1, start);
			ps.setInt(2, total);
			
			rs =ps.executeQuery();
			while(rs.next())
			{
				ub = new UserBean();
				ub.setId(rs.getString(1));
				ub.setName(rs.getString(2));
				ub.setUsername(rs.getString(3));
				ub.setEmail(rs.getString(4));
				ub.setPassword(rs.getString(5));
				list.add(ub);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
		
	}
	public int countUser() {
		int count = 0;
		try {
			ps = con.prepareStatement("select count(id) from login");
			rs= ps.executeQuery();
			
			if(rs.next())
			{
				count =rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
		
	}
	public int insertResult(UserBean ub)
	{
		int status = 0;
		try {
			ps=con.prepareStatement("insert into result values(?,?,?,?,?,?,?,?)");
			ps.setLong(1, ub.getReg_no());
			ps.setString(2, ub.getSname());
			ps.setString(3, ub.getMothername());
			ps.setString(4, ub.getCourses());
			ps.setInt(5, ub.getSubject1marks());
			ps.setInt(6, ub.getSubject2marks());
			ps.setInt(7, ub.getSubject3marks());
			ps.setString(8, ub.getRemarks());
			
			
			
			status = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
		
	}
	public UserBean showResult(long reg_no)
	{
		UserBean ub = null;
		try {
			ps=con.prepareStatement("select * from result where reg_no =?");
			ps.setLong(1, reg_no);
			
			rs =ps.executeQuery();
			if(rs.next())
			{
				ub = new UserBean();
				ub.setReg_no(rs.getLong(1));
				ub.setSname(rs.getString(2));
				ub.setMothername(rs.getString(3));
				ub.setCourses(rs.getString(4));
				ub.setSubject1marks(rs.getInt(5));
				ub.setSubject2marks(rs.getInt(6));
				ub.setSubject3marks(rs.getInt(7));
				ub.setRemarks(rs.getString(8));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ub;
		
	}
	public int totalMarks(long reg_no)
	{
		int total = 0;
		try {
			ps=con.prepareStatement("select (subject1marks+subject2marks+subject3marks) as total from result where reg_no=?");
			ps.setLong(1, reg_no);
			rs=ps.executeQuery();
			if(rs.next())
			{
				total = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return total;
		
	}
	public int deleteAdmission(int s_id)
	{
		int status =0;
		try {
			ps=con.prepareStatement("delete from admission where s_id =?");
			ps.setInt(1, s_id);
			
			status=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return status;
		
	}
	public int deleteAdmission1(int s_id)
	{
		int status =0;
		try {
			ps=con.prepareStatement("delete from admission1 where s_id =?");
			ps.setInt(1, s_id);
			
			status=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return status;
		
	}
}
