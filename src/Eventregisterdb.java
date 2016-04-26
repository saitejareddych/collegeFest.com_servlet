

import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.*;
import com.itextpdf.*;

import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

	response.setContentType("application/pdf");
	response.setHeader("Content-Disposition", "attachment;filename=Acknowlegement.pdf");
	HttpSession session=request.getSession();
	try{
		Document document=new Document();
		PdfWriter.getInstance(document,response.getOutputStream());
		document.open();
		
		Paragraph paragraph0 = new Paragraph("                      REGISTRATION ACKNOWLEDGEMENT FOR:"+festname+"                     \t");
		Paragraph paragraph00 = new Paragraph("----------------------------------------------------------------------------------------------------------------------------------");
		Paragraph paragraph1 = new Paragraph("                      NAME                                  :     "+studentname);
		Paragraph paragraph2 = new Paragraph("                      COLLEGE NAME                :      "+clgname);
		Paragraph paragraph3 = new Paragraph("                      YEAR                                   :     "+year);
		Paragraph paragraph4 = new Paragraph("                      BRANCH                              :     "+branch);
		Paragraph paragraph5 = new Paragraph("                      PHONE NUMBER                :     "+phone);
		Paragraph paragraph6 = new Paragraph("                      EMAIL ID                              :     "+mailid);
		Paragraph paragraph7 = new Paragraph("                      REGISTRATION FEE          :     not paid");
		Paragraph paragraph8 = new Paragraph("----------------------------------------------------------------------------------------------------------------------------------");
		Paragraph paragraph9 = new Paragraph("                      -Please carry this acknowledgement to the event location without fail");
		Paragraph paragraph10 = new Paragraph("                      -Upadtes regarding the event will be sent to the above mail and phone");
		Paragraph paragraph11 = new Paragraph("                      -This is computer generated copy not an authorized one");
		
		document.add(paragraph0);
		document.add(paragraph00);
		document.add(paragraph1);
		document.add(paragraph2);
		document.add(paragraph3);
		document.add(paragraph4);
		document.add(paragraph5);
		document.add(paragraph6);
		document.add(paragraph7);
		document.add(paragraph8);
		document.add(paragraph9);
		document.add(paragraph10);
		document.add(paragraph11);
		  int i=usersRegistartion.eventRegForm(festname,studentname,clgname,year,branch,phone,mailid);
		document.close();
		}
	catch(Exception de){
	throw new IOException(de.getMessage());
	}

	    PrintWriter out = response.getWriter();
    int i = 0;
		if(i>0)
		{

			
			out.println("Registered Successfully");
			  RequestDispatcher rs = request.getRequestDispatcher("ret");
              rs.include(request, response);
		}
		else
			{out.println("exception  ");}
		
		
		
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

