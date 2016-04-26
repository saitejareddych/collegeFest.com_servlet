
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
response.setContentType("text/html;charset=UTF-8");
		int j=colleges.strLength();
		String log="";
		HttpSession session=request.getSession(false);
		if(session!=null){
			
             log="<a class='SignIn' href='logout'>LOGOUT </a>";
		}
		else
		{ 
			log="<a class='SignIn' href='Login.html'>LOGIN/REGISTER </a>";
		}
		
		PrintWriter out = response.getWriter();
		out.println("<html>"
				+ "<title>CollegeFests.com</title>"
				+ "<head>"
				+ "<script type='text/javascript'>"
				+ "var slideimages = new Array() ;"
				+colleges.eventPics() 
						+ "</script>"
				+ "<style>"
				+ ".heading{"
				+ "margin-left:20%;"
				+ "	width:60%;"
				+ "color:#2874A6;"
				+ "text-align:center;"
				+ "font-size:4.5vw;"
				+ "font-family: 'Lato', sans-serif;"
				+ "font-weight:bold;"
				+ "padding-top:2%;"
				+ "margin-top:0px;"
				+ "padding-bottom:1%;"
				+ "margin-bottom:0px;"
				+ "letter-spacing:2px;"
				+ "box-shadow: 10px 10px 10px #EAF2F8;"
				+ "}"
				+ "#total{"
				+ "background-color:#EAF2F8;"
				+ "height:60px;"
				+ "	border:none;"
				+ "}"
				+ ".name{"
				+ "float:left;"
				+ "padding-top:10px;"
				+ "padding-left:2%;"
				+ "}"
				+ ".user{"
				+ "float:right;"
				+ "	padding-top:1.5%;"
				+ "padding-right:2%;"
				+ "}"
				+ "a:link{"
				+ "text-decoration:none;"
				+ "}"
				+ ".SignIn{"
				+ "	color:#138D75;"
				+ "font-size:1.2vw;"
				+ "font-weight:bold;"
				+ "font-family: 'Lato', sans-serif;"
				+ "}"
				+ ".Register{"
				+ "color:#138D75;"
				+ "font-family: 'Lato', sans-serif;"
				+ "font-size:1.2vw;"
				+ "font-weight:bold;"
				+ "margin-top:5px;"
				+ "}"
				+ ".website{"
				+ "font-size:30px"
				+ "}"
				+ "nav{"
				+ "	margin-top:0px;"
				+ "	margin-bottom:2%;"
				+ "padding-top:2%;"
				+ "text-align:center;"
				+ "font-weight:bold;"
				+ "font-family: 'Lato', sans-serif;"
				+ "}"
				+ "nav a{"
				+ "position:static;"
				+ "left:40px;"
				+ "text-decoration:none;"
				+ "font-size:1.1vw;"
				+ "display: inline-block;"
				+ "text-align: center;"
				+ "padding: 1% 1%;"
				+ "text-decoration: none;"
				+ "color:#27AE60;"
				+ "}"
				+ ".name{"
				+ "font-size:1vw;"
				+ "color:#138D75;"
				+ "font-family: 'Lato', sans-serif;"
				+ "}"
				+ "div.list1{"
				+ "float:left;"
				+ "}"
				+ "div.list3{"
				+ "float:right;"
				+ "	position:relative;"
				+ "bottom:4px;"
				+ "}"
				+ "center{"
				+ "color:#566573;"
				+ "}"
				+ ".subtitle{"
				+ "text-align:center;"
				+ "margin-top:3%;"
				+ "color:#808B96;"
				+ "text-transform:uppercase;"
				+ "font-family: Georgia;"
				+ "letter-spacing:1px;"
				+ " font-size:0.9vw;"
				+ "}"
				+ "</style>"
				
				+ "</head>"
				+ "<body>"
				+ "<div id='total'>"
				+ "<div class='name'>"
				+ "&#9742; +91 8333021170</br> &#9993;"
				+ "collegefests@gmail.com"
				+ "</div>"
				+ "<div class='user'>"
				+ log
				+ "</div>"					
				+ "</div>"						
				+ "<div >"
				+ "<p class='heading'>CollegeFests.com</p>"
				+ "<p class='subtitle'>Know  The  Events  Happening  Around  You</p>"
				+ "<nav>"
				+ " <a href='ret'>EVENTS </a> "
				+ "<a href='publishcheck'>PUBLISH AN EVENT </a> "
				+ "<a href='http://localhost:8085/sample/About.html'>ABOUT  </a>"
				+ "</nav>"
				+"<div>"
				+"<div class='list1' style='width:22%'>"
				+"<p style='font-size:20px; color:#616A6B; text-align:center;width:90%'>List Of Organizations</p>"
				+"<marquee bgcolor=''scrollamount='4' direction='up' loop='true' height='300' width='90%'>"
				+"<center>"
				+"<font>Chaitanya Barathi Institute Of Technology</font><p>"
				+"<font>Vasavi College Of engineering</font><p>" 
				+"<font>Indian Institue Of Technology,Mumbai</font><p>"
				+"<font>VIT</font><p>"
				+"<font>GITAM</font><p>"
				+"<font>SRM</font><p>"
				+"<font>Anna University</font><p>"
				+"<font>IIST</font><p>"
				+"<font>Mathrusri Engineering College</font><p>"
				+"</center>"
				+"</marquee>"
				+"</div>"
				+ "<div class='list1' style='width:56%;'>"
				+ "<img src=slideimages[0].src id='slide' width='100%' height='450' class='img' />"
				+ "<script type='text/javascript'>"
				+ "var step=0;"
				+ "function slideit(){"		
				+" if (!document.images)"
					+" return ;"
				+"document.getElementById('slide').src = slideimages[step].src;"
				+ " if (step<="+j+")"
				+ "  step++;"
				+ "	 else"
				+ "  step=0;"
				+ "	 setTimeout('slideit()',5000);"
				+ "}"
				+ "slideit();"
				+ "</script>"
				+ "</div>"
				+"<div class='list3' style='width:22%'>"
				+"<p style='font-size:20px; color:#616A6B; text-align:center;width:90%'>Types Of Events</p>"
				+"<marquee bgcolor=''scrollamount='4' direction='up' loop='true' height='300' width='90%'>"
				+"<center>"
				+"<font>Technical Events</font><p>"
				+"<font>Cultural Events</font><p>" 
				+"<font>Concerts</font><p>"
				+"<font>Competitive Events</font><p>"
				+"<font>Sports Events</font><p>"
				+"<font>College Fests</font><p>"
				+"<font>Public Events</font><p>"
				+"</center>"
				+"</marquee>"
				+"</div>"
				+"</div>"
				+ "</body>"
				+ "</html>");
				
	}

	static class colleges
	{
  

	public static String eventPics() 
	    {
	    String s="";
	     try{
	    	 //loading drivers for mysql
	        Class.forName("com.mysql.jdbc.Driver");

		 //creating connection with the database 
	        Connection con=DriverManager.getConnection
	                       ("jdbc:mysql://localhost:3306/miniproject","root","1324");
		PreparedStatement statement = con.prepareStatement("SELECT * FROM event");
		ResultSet rs=statement.executeQuery();
		int m=0;
		String vx="";
		while(rs.next()){
			  vx="img?id="+rs.getString("rowid");
		s=s+"slideimages["+m+"] = new Image();"+ "slideimages["+m+"].src ='"+vx+"';";
		m++;
		}

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

}
}
