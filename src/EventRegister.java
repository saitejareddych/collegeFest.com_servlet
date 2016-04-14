

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EventRegister
 */
@WebServlet("/EventRegister")
public class EventRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String festname=request.getParameter("festname");
		PrintWriter out=response.getWriter();
		out.println("<html>"
				+ "<head>"
				+ "<meta charset='ISO-8859-1'>"
						+ "<title>Event Registration</title>"
						+ "<style>"
						+ "body{"
						+ "}"
						+ ".button {"
						+ " height:35px;width:12vw;"
						+ " border-radius: 5px 5px 5px 5px;"
						+ " text-indent: 5%;"
						+ " margin-top:10px;"
						+ "}"
						+ "#submit:hover {"
						+ "  background: #7DCEA0;"
						+ "}"
						+ "#submit {"
						+"border:none;"
						+"width:40px;"
						+"}"
						+"input:focus {"
						+ " outline: none;"
						+ " outline: 2px solid #27AE60;"
						+ "  box-shadow: 0 0 2px #27AE60;"
						+ "}"
						+ ".header {"
						+ " font-size: 35px;"
						+ "text-transform: uppercase;"
						+ " letter-spacing: 5px;"
						+ " text-align:center;"
						+ " color:#2874A6;"
						+"margin-top:5%"
						+ "	}"
						+ ".description {"
						+ "  font-size: 17px;"
						+ "  letter-spacing: 1px;"
						+ "  line-height: 1.3em;"
						+ " margin: -2px 0 45px;"
						+ " text-align:center;"
						+ "  color:#2874A6;"
						+ "	}"
						+ "	#submit {"
						+ " width:105px;"
						+ " background:#27AE60;"
						+ "	  margin-top:30px;"
						+ " font-family:georgia;"
						+ " font-weight: bold;"
						+ " letter-spacing: 1px;"
						+ " border-radius: 5px 5px 5px 5px;"
						+ "	  cursor: pointer;"
						+ "  color: #FDFCFB;"
						+ "}"
						+ "nav{"
						+ "margin-top:0px;"
						+ "	margin-bottom:20px;"
						+ "	padding-top:40px;"
						+ "text-align:center;"
						+ "font-weight:bold;"
						+ "font-family: georgia;"
						+ "}"
						+ "nav a{"
						+ "position:static;"
						+ "	left:40px;"
						+ "text-decoration:none;"
						+ "font-size:15px;"
						+ "display: inline-block;"
						+ "text-align: center;"
						+ "padding: 14px 16px;"
						+ "text-decoration: none;"
						+ "color:#27AE60;"
						+ "}"
						+ "</style>"
						+ "</head>"
						+ "<body>"
						+ "<div class='header'>"
						+ "	<p>Register For "
						+festname
						+"</p>"
						+ "</div>"
						+ "<div>"
						+ "<nav>"
						+ " <a href='home'>HOME  </a> "
						+ "<a href='ret'>EVENTS  </a> "
						+ "</nav>"
						+ "</div>"
						+ "<div>"
						+ "<form method='get' action='eventregisterdb' enctype='multipart/form-data'>"
						+ "	<div class='description'>"
						+ "<p>Please Fill Your Information Below</p>"
						+ "<div>"
						+ "<div class='input'>"
						+ "<input type='text' class= 'button'  name='name1' placeholder='NAME' required > <input type='text' class= 'button' id='location' name='clgname' placeholder='COLLEGE NAME' required><br>"
								+ "	<input type='text' class= 'button' id='cname' name='year' placeholder='GRADUATING YEAR' required> "
										+ "<input type='text' class= 'button'  name='branch' placeholder='BRANCH' required><br>"
												+ "<input type='text' class= 'button' id='phone' name='phone' placeholder='PHONE'  style='width:25vw;' required><br>"
														+ "<input type='text' class= 'button' id='fee' name='mailid' placeholder='EMAIL'  style='width:25vw;' required><br>"
														+"<input type='hidden' name='festname' value='"+festname+"'>");
	      	out.println("<input type='submit'  class=\"button\"  id=\"submit\" value='SUBMIT'>");

	}

	
	

}
