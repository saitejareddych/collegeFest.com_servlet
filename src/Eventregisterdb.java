

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Eventregisterdb
 */
@WebServlet("/Eventregisterdb")
public class Eventregisterdb extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		 String festname = request.getParameter("festname");
		
       String studentname = request.getParameter("name1");
       String clgname = request.getParameter("clgname");
       String year = request.getParameter("year");
       String branch = request.getParameter("branch");
	String phone=request.getParameter("phone");
	String mailid=request.getParameter("mailid");
	    PrintWriter out = response.getWriter();
      int i=usersRegistartion.eventRegForm(festname,studentname,clgname,year,branch,phone,mailid);
		if(i>0)
		{
			out.println("Registered Successfully");
			  RequestDispatcher rs = request.getRequestDispatcher("ret");
              rs.include(request, response);
		}
		else
			out.println("exception  ");
		
   }  
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doGet(request, response);
	}
}

class usersRegistartion
{

	
    public static int eventRegForm(String festname,String studentname,String clgname,String year,String branch,String phone,String mailid) 
    {  int rs=0;
     try{
		 
        Class.forName("com.mysql.jdbc.Driver");

	 //creating connection with the database 
        Connection con=DriverManager.getConnection
                       ("jdbc:mysql://localhost:3306/miniproject","root","1324");
	PreparedStatement statement = con.prepareStatement("INSERT INTO eventregistration VALUES(?,?,?,?,?,?,?,?)");
statement.setString(1,festname);


statement.setString(2,studentname);

statement.setString(3,clgname);
statement.setString(4,year);
statement.setString(5,branch);
statement.setString(6,phone);
statement.setString(7,mailid);
statement.setString(8,null);


   rs=statement.executeUpdate();


     }catch(Exception e)
     {
         e.printStackTrace();
     }
return rs;  
           
 }   
	}

