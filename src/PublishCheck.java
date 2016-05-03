

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class PublishCheck
 */
@WebServlet("/PublishCheck")
public class PublishCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		HttpSession session=request.getSession(false);
		if(session!=null){
			 RequestDispatcher rs = request.getRequestDispatcher("/eventForm.html");
                         rs.forward(request, response);
		}
		else
		{ 
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			
			  RequestDispatcher rs = request.getRequestDispatcher("/Login.html");
                          rs.include(request,response);
		}
	}
	}
