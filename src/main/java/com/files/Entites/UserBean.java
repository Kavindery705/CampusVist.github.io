package com.files.Entites;

import java.sql.Blob;

public class UserBean {

	

	private String id,name,session , email , subject , message , username , password ,mothername,remarks, city,address,sname,fathername,dob,gender,state,pin,courses,tenth,twelth ;
	private int age,marks,c_id,subject1marks,subject2marks,subject3marks,s_id;
	private long phone,	reg_no  ;
	private Blob tenth1,twelfth1;
	public String getName() {
		return name;
	} 

	public int getC_id() {
		return c_id;
	}

	public int getS_id() {
		return s_id;
	}

	public void setS_id(int s_id) {
		this.s_id = s_id;
	}

	public void setC_id(int c_id) {
		this.c_id = c_id;
	}

	public String getId() {
		return id;
	}

	public String getCourses() {
		return courses;
	}

	public void setCourses(String courses) {
		this.courses = courses;
	}

	public String getTenth() {
		return tenth;
	}

	public void setTenth(String tenth) {
		this.tenth = tenth;
	}

	public String getTwelth() {
		return twelth;
	}

	public void setTwelth(String twelth) {
		this.twelth = twelth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getFathername() {
		return fathername;
	}

	public void setFathername(String fathername) {
		this.fathername = fathername;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}


	public void setId(String id) {
		this.id = id;
	}

	public String getSession() {
		return session;
	}

	public void setSession(String session) {
		this.session = session;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	public String getMothername() {
		return mothername;
	}

	public void setMothername(String mothername) {
		this.mothername = mothername;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public int getSubject1marks() {
		return subject1marks;
	}

	public void setSubject1marks(int subject1marks) {
		this.subject1marks = subject1marks;
	}

	public int getSubject2marks() {
		return subject2marks;
	}

	public void setSubject2marks(int subject2marks) {
		this.subject2marks = subject2marks;
	}

	public int getSubject3marks() {
		return subject3marks;
	}

	public void setSubject3marks(int subject3marks) {
		this.subject3marks = subject3marks;
	}

	public long getReg_no() {
		return reg_no;
	}

	public void setReg_no(long reg_no) {
		this.reg_no = reg_no;
	}

	public Blob getTenth1() {
		return tenth1;
	}

	public void setTenth1(Blob tenth1) {
		this.tenth1 = tenth1;
	}

	public Blob getTwelfth1() {
		return twelfth1;
	}

	public void setTwelfth1(Blob twelfth1) {
		this.twelfth1 = twelfth1;
	}
	
}
