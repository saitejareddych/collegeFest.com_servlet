

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uname = request.getParameter("username");
        String pass = request.getParameter("password");

       



        PrintWriter out = response.getWriter();
        
        
        if(Validate.checkUser(uname,pass))
        {
		out.println("login successful..Now You can Publish Your Event");
        	HttpSession session=request.getSession(); 
        	
        	response.setContentType("text/html;charset=UTF-8");
            session.setAttribute("name",uname);  
            RequestDispatcher rs = request.getRequestDispatcher("home");
            rs.include(request, response);
      
}
        else
        {
           out.println("Username or Password incorrect");
           RequestDispatcher rs = request.getRequestDispatcher("login.html");
           rs.include(request, response);
        }
    }  
}

class Validate
 {
     public static boolean checkUser(String uname,String pass) 
     {
      boolean st =false;
      try{

	 //loading drivers for mysql
         Class.forName("com.mysql.jdbc.Driver");

 	 //creating connection with the database 
         Connection con=DriverManager.getConnection
                        ("jdbc:mysql://localhost:3306/miniproject","root","1324");
	PreparedStatement statement = con.prepareStatement("SELECT * FROM register WHERE username=? and password=?");
statement.setString(1,uname);
statement.setString(2,pass);
	
    ResultSet rs=statement.executeQuery();
	st=rs.next();
 
      }catch(Exception e)
      {
          e.printStackTrace();
      }
return st;
                        
  }   
	}

