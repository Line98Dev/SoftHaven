package servlets;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import beans.Ship;
import dao.*;


/**
 * Servlet implementation class FrontController
 */
@WebServlet(urlPatterns= {"/trafficMonitor", "/index.jsp"}) //localhost:8080/TrafficManagement
public class FrontController extends HttpServlet { //Also, use the previous line to add the new web pages as needed
	
	private static final long serialVersionUID = 1L;
    
	@Inject @JDBC
	ShipDAO dao;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost( request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String operation = request.getRequestURI();
		
		if(operation.equals("/TrafficManagement/")) {
			
			List<Ship> ships = dao.list();
			
			//request.setAttribute("ships", ships);
			request.setAttribute("request", operation);
			request.getRequestDispatcher("ships.jsp").forward(request,  response);
		
		} else if(operation.equals("/TrafficManagement/trafficMonitor")){
			//I know this works now, but now I gotta figureout how to get the jsondata to this to use on a repeated time
			//Also, copy this stuff and use it in the portcall project
			request.setAttribute("request", operation);
			request.getRequestDispatcher("trafficMonitor.jsp").forward(request,  response);
		}
	}
}
