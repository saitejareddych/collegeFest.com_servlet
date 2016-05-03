

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

/**
 * Servlet implementation class ImgRetriver
 */
@WebServlet("/ImgRetriver")
public class ImgRetriver extends HttpServlet{
	 int m=1;
	static int id=1;
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
     PrintWriter out=res.getWriter();
     String data="man";

   //  event obj=new event();
     
;      						
     try{
         res.setContentType("text/html");
         int j=Event.strLength(); 
         out.println("<html>");
         out.println("<head>");
         out.println("<link href=style.css rel=stylesheet type=text/css");
         out.println("</head>");
         out.println("<body>");
         out.println("<p class=\"p\">What's New</p>");
         out.println("<div><nav ><a href=\"home\">HOME  </a><a href=\"publishcheck\">PUBLISH AN EVENT </a> <a href=\"http://localhost:8085/sample/About.html\">ABOUT  </a></nav</div><br>");
         out.println("</body>");
      while(j!=0){if(Event.exist(m)){
    	  String x=Integer.toString(m);
    	  String v="img?id="+x;
   	      		out.println(" <html>");
   	      		out.println(" <head>");
   	      	out.println(" <head>");
   	     out.println(" <body>");	
   	  out.println("<div  class=\"total\">");
   	  out.println("<div class=\"title\">");
   	out.println("<p class=\"event\">");
   	out.println(Event.festName(x));
   	out.println("</p>");
   	out.println("</div>");
   	out.println("<div class=\"title\">");
   	out.println("<p class=\"college\">");
   	out.println(Event.collegeName(x));
   	out.println("</p>");
   	out.println("</div>");
   	out.println("<div class=\"title\">");
   	out.println("<img  width=730 height=400 margin=20 src="+v+" alt='no poster available' height='42' width='42'>");
   	out.println("</div>");
    out.println("<div class=\"title\">");
   	out.println("<form action='ret3' method='get'>");
   	out.println("<input type='hidden' name='m'"+" value="+m+">"
   		  +"<input type='hidden' name='festname' value='"+Event.eventData(m,1)+"'>"
     		  +"<input type='hidden' name='aboutevent' value='"+Event.eventData(m,2)+"'>"
     		  +"<input type='hidden' name='location' value='"+Event.eventData(m,3)+"'>"
     		  +"<input type='hidden' name='contact' value="+Event.eventData(m,4)+">"
     		  +"<input type='hidden' name='fee' value="+Event.eventData(m,5)+">"
     		  +"<input type='hidden' name='date' value="+Event.eventData(m,6)+">"
     		  +"<input type='hidden' name='time' value="+Event.eventData(m,7)+">"
     		  +"<input type='hidden' name='organiser' value="+Event.eventData(m,8)+">");
   	out.println("<input type='hidden' name="+Integer.toString(m)+" value="+Event.festName(x)+">");
   	      	out.println("<input type='submit'  class=\"moreinfo\"  id=\"button\" value='More Info & Register'>");
   	      		out.println("</form>"
   	      		+"</div>"
   	      				+"</div>"
   	      			+"<hr noshade>"
   	      		+"</body>"
   	      		+"</html>");
   	      		;
         
         j--;
         m++;
                }
      else{
    	  m++;
      }
      }
      if(m>Event.strLength())
      {
   	   m=1;
      }
     }
     catch(Exception e){
       out.println(e);
     }
 }
}

class Event
{
	public static String eventData(int uname,int col) 
    {
     boolean st =false;
    String s="";
     try{
    	 //loading drivers for mysql
        Class.forName("com.mysql.jdbc.Driver");

	 //creating connection with the database 
        Connection con=DriverManager.getConnection
                       ("jdbc:mysql://localhost:3306/miniproject","root","1324");
	PreparedStatement statement = con.prepareStatement("SELECT * FROM event WHERE rowid=? ");
statement.setInt(1,uname);
	
   ResultSet rs=statement.executeQuery();
	st=rs.next();
	s=rs.getString(col);
	

     }catch(Exception e)
     {
         e.printStackTrace();
     }

    return s;  	
 }   
   public static String festName(String uname) 
   {
    boolean st =false;
   String s="";
    try{

	 //loading drivers for mysql
       Class.forName("com.mysql.jdbc.Driver");

	 //creating connection with the database 
       Connection con=DriverManager.getConnection
                      ("jdbc:mysql://localhost:3306/miniproject","root","1324");
	PreparedStatement statement = con.prepareStatement("SELECT * FROM event WHERE rowid=? ");
statement.setString(1,uname);
	
  ResultSet rs=statement.executeQuery();
	st=rs.next();
	s=rs.getString(1);
	

    }catch(Exception e)
    {
        e.printStackTrace();
    }

   return s;  	
}   
   public static String collegeName(String uname) 
   {
    boolean st =false;
   String s="";
    try{

	 //loading drivers for mysql
       Class.forName("com.mysql.jdbc.Driver");

	 //creating connection with the database 
       Connection con=DriverManager.getConnection
                      ("jdbc:mysql://localhost:3306/miniproject","root","1324");
	PreparedStatement statement = con.prepareStatement("SELECT * FROM event WHERE rowid=? ");
statement.setString(1,uname);
	
  ResultSet rs=statement.executeQuery();
	st=rs.next();
	s=rs.getString(3);
	

    }catch(Exception e)
    {
        e.printStackTrace();
    }

   return s;  	
}   
   
   public static int strLength() 
   {int len=0;
    try{
   	 
	 //loading drivers for mysql
       Class.forName("com.mysql.jdbc.Driver");

	 //creating connection with the database 	
       Connection con=DriverManager.getConnection
                      ("jdbc:mysql://localhost:3306/miniproject","root","1324");
	PreparedStatement statement = con.prepareStatement("SELECT * FROM event");

	
  ResultSet rs=statement.executeQuery();
	while(rs.next()){
		len++;
	}
	

    }catch(Exception e)
    {
        e.printStackTrace();
    }

   return len;  	
} 
   
   public static boolean exist(int id) 
   {boolean k=false;
    try{
   	 
	 //loading drivers for mysql
       Class.forName("com.mysql.jdbc.Driver");

	 //creating connection with the database 	
       Connection con=DriverManager.getConnection
                      ("jdbc:mysql://localhost:3306/miniproject","root","1324");
	PreparedStatement statement = con.prepareStatement("SELECT * FROM event  where rowid=?");

	statement.setInt(1, id);
  ResultSet rs=statement.executeQuery();
	k=rs.next();

    }catch(Exception e)
    
    {
        e.printStackTrace();
    }

   return k;  	
} 
}

