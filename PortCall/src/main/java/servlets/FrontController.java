package main.java.servlets;

import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import main.java.beans.PrearrivalForm;
import main.java.dao.*;


/**
 * Servlet implementation class FrontController
 */
@WebServlet(urlPatterns= {"/submitForm", "/shipMaster", "/shipAgent", "/index.jsp"})
public class FrontController extends HttpServlet { //Also, use the previous line to add the new web pages as needed
	
	private static final long serialVersionUID = 1L;
	
	@Inject @JDBC
	PortCallDAO dao;
	
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
		
		if(operation.equals("/PortCall/")) {
		
			request.getRequestDispatcher("home.jsp").forward(request,  response);
			
		} else if(operation.equals("/PortCall/shipMaster")) {
			
			try {
				String name = request.getParameter("shipName");
				String callSign = request.getParameter("callSign");
				int imo = Integer.parseInt(request.getParameter("imo"));
				String agentInfo = request.getParameter("agent");
				String arrivingFrom = request.getParameter("arrivingFrom");
				String eta = request.getParameter("eta");
				int berth = Integer.parseInt(request.getParameter("berth"));
				String nextPort = request.getParameter("nextPort");
				String etd = request.getParameter("etd");
				String dischargeCargoDesc = request.getParameter("dischargeDescription");
				int dischargeCargoAmount = Integer.parseInt(request.getParameter("dischargeAmount"));
				String loadCargoDesc = request.getParameter("loadingDescription");
				int loadCargoAmount = Integer.parseInt(request.getParameter("loadingAmount"));
				int arrivalPassengers = Integer.parseInt(request.getParameter("PassengerArrivalNumber"));
				int departurePassengers = Integer.parseInt(request.getParameter("PassengerDepartureNumber"));
				
				PrearrivalForm form = new PrearrivalForm(name, callSign, imo, agentInfo, arrivingFrom, eta, berth, nextPort, etd, dischargeCargoDesc, dischargeCargoAmount, loadCargoDesc, loadCargoAmount, arrivalPassengers, departurePassengers, 0);
				
				dao.addFormToList(form);
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
				System.out.println("Exception during edit operation");
			}
			
			request.getRequestDispatcher("ships.jsp").forward(request,  response);
		
		} else if(operation.equals("/PortCall/submitForm")) {
			
			request.setAttribute("ship", dao.getLastShipName());
			
			request.setAttribute("request", operation);
			request.getRequestDispatcher("sentForm.jsp").forward(request,  response);
		
		} else if(operation.equals("/PortCall/shipAgent")) {
			
			request.setAttribute("ships", dao.listShips());
			request.getRequestDispatcher("shipAgent.jsp").forward(request,  response);
		
		}
	}
}
