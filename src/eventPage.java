

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class eventPage
 */
@WebServlet("/eventPage")
public class eventPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  response.setContentType("text/html");
		  String m=request.getParameter("m");
		  String festname=request.getParameter("festname");
		  String aboutevent=request.getParameter("aboutevent");
		  String location=request.getParameter("location");
		  String contact=request.getParameter("contact");
		  String fee=request.getParameter("fee");
		  	String date=request.getParameter("date");
		  	String time=request.getParameter("time");
		  	String organiser=request.getParameter("organiser");
		  String x=m;
		  String v="img?id="+x;
	      // Actual logic goes here.
	      PrintWriter out = response.getWriter();
	      out.println("<html>");
	    		  out.println("<html>");
	    	         out.println("<head>");
	    	         out.println("<link href=eventStyle.css rel=stylesheet type=text/css");
	    	         out.println("</head>"  
	      + "<body>"
+"<div class='back' background-image:url("+v+")></div>"
	  		+ "<p class='heading'>"
	  		+festname
	  		+"</p>"
	  	 +"<div><nav class='navi' ><a href=\"http://localhost:8080/sample/Home.html\">HOME  </a> <a href=\"http://localhost:8080/sample/About.html\">EVENTS  </a></nav></div><br>"
	  		+ "<div class='description'>"
	  		+aboutevent
	  		+"</p>"
	  		+ "</div>"
	  		+ "<div class='info' >"
	  		+ "<img class='img' src="+v+" alt='POSTER UNAVAILABLE' width=730 height=400>"
	 + "</div>"  
	  		
	  		+ "<div class='info'>"
	  		+ "<div class='sub'>"
	  		+ "	Event Location : "+location
	  		+"<br>"
	  		+ "	Organiser Name : "+organiser
	  		+"<br>"
	  		+ "Phone : "+contact
	  		+"<br>"
	  		+ "Date : "+date
	  		+"<br>"
	  		+ "Time : "+time
	  		+"<br>"
	  		+ "Registration Fee : "+fee
	  		+"<br>"
	  		+ "</div>"
	  		
	  		+"<br>"
	  		+"<form action='ret4' method='get'>"
	  		+"<input type='hidden' name='festname' value='"+festname+"'>"
	  		+ "<input type='submit' class='register' id='button' value='Register Now'>"
	  		+"</form>"
	  		+"</div>"
	  		+"</div>"
	  		+ "</body>"
	  		+ "</html>");
	}



}

