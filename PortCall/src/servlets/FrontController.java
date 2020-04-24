package servlets;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import beans.PrearrivalForm;
import dao.*;


/**
 * Servlet implementation class FrontController
 */
@WebServlet(urlPatterns= {"/submitForm", "/index.jsp"})
public class FrontController extends HttpServlet { //Also, use the previous line to add the new web pages as needed
	
	private static final long serialVersionUID = 1L;
    public PrearrivalForm submittedForm;
	
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
			
			FormSubmit(request, response);
			request.getRequestDispatcher("ships.jsp").forward(request,  response);
		
		} else if(operation.equals("/PortCall/submitForm")) {
			
			//Causes 500 server error nullPointer, and unsure why
			//request.setAttribute("ship", submittedForm.getName());
			
			request.setAttribute("request", operation);
			request.getRequestDispatcher("sentForm.jsp").forward(request,  response);
		}
	}
	
	//This function runs when a Pre-Arrival Form is submitted
	private void FormSubmit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String name = request.getParameter("shipName");
			String callSign = request.getParameter("callSign");
			int imo = new Integer( request.getParameter("imo")).intValue();
			String agentInfo = request.getParameter("agent");
			String arrivingFrom = request.getParameter("arrivingFrom");
			String eta = request.getParameter("eta");
			int berth = new Integer( request.getParameter("berth")).intValue();
			String nextPort = request.getParameter("nextPort");
			String etd = request.getParameter("etd");
			String dischargeCargoDesc = request.getParameter("dischargeDescription");
			int dischargeCargoAmount = new Integer( request.getParameter("dischargeAmount")).intValue();
			String loadCargoDesc = request.getParameter("loadingDescription");
			int loadCargoAmount = new Integer( request.getParameter("loadingAmount")).intValue();
			int arrivalPassengers = new Integer( request.getParameter("PassengerArrivalNumber")).intValue();
			int departurePassengers  = new Integer( request.getParameter("PassengerDepartureNumber")).intValue();
			
			PrearrivalForm form = new PrearrivalForm(name, callSign, imo, agentInfo, arrivingFrom, eta, berth, nextPort, etd, dischargeCargoDesc, dischargeCargoAmount, loadCargoDesc, loadCargoAmount, arrivalPassengers, departurePassengers, 0);
			submittedForm = form;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			System.out.println("Exception during edit operation");
		}
	}
}
