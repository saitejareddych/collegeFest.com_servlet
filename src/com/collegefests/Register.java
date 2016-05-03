package com.collegefests;


import javax.servlet.annotation.WebServlet;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        response.setContentType("text/html;charset=UTF-8");

		
	        String fname = request.getParameter("FirstName");
	        String lname = request.getParameter("LastName");
	        String uname = request.getParameter("Remail");
	        String pass = request.getParameter("Rpassword");
		String phone=request.getParameter("uphone");
		String college=request.getParameter("college");
		String designation=request.getParameter("designation");
		String cphone=request.getParameter("cphone");
		String est=request.getParameter("est");
		String city=request.getParameter("city");
		String state=request.getParameter("state");
	        PrintWriter out = response.getWriter();
	       int i=ValidateForm.addUser( uname,pass,fname,lname,phone,college,designation,cphone,est,city,state);
			if(i>0)
			{
				  RequestDispatcher rs = request.getRequestDispatcher("Registered.html");
	               rs.include(request, response);
			}
			
	    }  
	}

	 class ValidateForm
	 {

		
	     public static int addUser(String uname,String pass,String fname,String lname,String phone,String college,String designation,String cphone,String est,String city,String state) 
	     {  int rs=0;
	      try{
			 
	         Class.forName("com.mysql.jdbc.Driver");

	 	 //creating connection with the database 
	         Connection con=DriverManager.getConnection
	                        ("jdbc:mysql://localhost:3306/miniproject","root","1324");
		PreparedStatement statement = con.prepareStatement("INSERT INTO register VALUES(?,?,?,?,?,?,?,?,?,?,?)");
		System.out.println(designation);
	statement.setString(1,uname);
	statement.setString(2,pass);

	statement.setString(3,fname);
	statement.setString(4,lname);
	statement.setString(5,phone);
		
	statement.setString(6,college);
	statement.setString(7,designation);
	statement.setString(8,cphone);
	statement.setString(9,est);
	statement.setString(10,city);
	statement.setString(11,state);
	    rs=statement.executeUpdate();
	 
	 
	      }catch(Exception e)
	      {
	          e.printStackTrace();
	      }
	 return rs;  
	            
	  }   
}
