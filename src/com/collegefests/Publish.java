package com.collegefests;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;

import java.sql.*;
import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

@MultipartConfig(maxFileSize=16177215)

/**
 * Servlet implementation class Publish
 */
public class Publish extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        String event = request.getParameter("event");
        String info = request.getParameter("info");
        String cname = request.getParameter("cname");
        String phone = request.getParameter("phone");
	String date=request.getParameter("date");
	String time=request.getParameter("time");
	String location=request.getParameter("location");
	String fee=request.getParameter("fee");
	String festName=request.getParameter("festName");
	String url=request.getParameter("url");
InputStream inputStream=null;
Part filePart=request.getPart("photo");
inputStream=filePart.getInputStream();
        PrintWriter out = response.getWriter();
       int i=PublishForm.addUser(event,info,location,phone,fee,date,time,cname,inputStream,festName,url);
		if(i>0)
		{
			out.println("PUBLISHED SUCCESSFULLY");
			response.setContentType("text/html;charset=UTF-8");
			
			  RequestDispatcher rs = request.getRequestDispatcher("eventForm.html");
               rs.include(request, response);
		}
		
    }  
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doGet(request, response);
	}
}

 class PublishForm
 {

	
     public static int addUser(String event,String info,String location,String phone,String fee,String date,String time,String cname,InputStream inputStream,String festName,String url) 
     {  int rs=0;
      try{
		 
         Class.forName("com.mysql.jdbc.Driver");

 	 //creating connection with the database 
         Connection con=DriverManager.getConnection
                        ("jdbc:mysql://localhost:3306/miniproject","root","1324");
	PreparedStatement statement = con.prepareStatement("INSERT INTO event VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
statement.setString(1,event);
statement.setString(2,info);

statement.setString(3,location);
statement.setString(4,phone);
statement.setString(5,fee);
	
statement.setString(6,date);
statement.setString(7,time);
statement.setString(8,cname);
statement.setBlob(9,inputStream);
statement.setString(10,null);
statement.setString(11,festName);
statement.setString(12,url);
    rs=statement.executeUpdate();
 
 
      }catch(Exception e)
      {
          e.printStackTrace();
      }
 return rs;  
            
  }   
	}

