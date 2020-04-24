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
			
			try {
				String name = "NaN";
				if(request.getParameter("shipName") != null && !request.getParameter("shipName").isEmpty()) name = request.getParameter("shipName");
				
				String callSign = "NaN"; 
				if(request.getParameter("callSign") != null && !request.getParameter("callSign").isEmpty()) callSign = request.getParameter("callSign");
				
				int imo = 0; 
				if(request.getParameter("imo") != null && !request.getParameter("imo").isEmpty()) imo = Integer.parseInt(request.getParameter("imo"));
				
				String agentInfo = "NaN"; 
				if(request.getParameter("agent") != null && !request.getParameter("agent").isEmpty()) agentInfo = request.getParameter("agent");
				
				String arrivingFrom = "Nan";
				if(request.getParameter("arrivingFrom") != null && !request.getParameter("arrivingFrom").isEmpty()) arrivingFrom = request.getParameter("arrivingFrom");
				
				String eta = "Nan";
				if(request.getParameter("eta") != null && !request.getParameter("eta").isEmpty()) eta = request.getParameter("eta");
				
				int berth = 0;
				if(request.getParameter("berth") != null && !request.getParameter("berth").isEmpty()) berth = Integer.parseInt(request.getParameter("berth"));
				
				String nextPort = "Nan";
				if(request.getParameter("nextPort") != null && !request.getParameter("nextPort").isEmpty()) nextPort = request.getParameter("nextPort");
				
				String etd = "Nan";
				if(request.getParameter("etd") != null && !request.getParameter("etd").isEmpty()) etd = request.getParameter("etd");
				
				String dischargeCargoDesc = "Nan";
				if(request.getParameter("dischargeDescription") != null && !request.getParameter("dischargeDescription").isEmpty()) dischargeCargoDesc = request.getParameter("dischargeDescription");
				
				int dischargeCargoAmount = 0;
				if(request.getParameter("dischargeAmount") != null && !request.getParameter("dischargeAmount").isEmpty()) dischargeCargoAmount = Integer.parseInt(request.getParameter("dischargeAmount"));
				
				String loadCargoDesc = "Nan";
				if(request.getParameter("loadingDescription") != null && !request.getParameter("loadingDescription").isEmpty()) loadCargoDesc = request.getParameter("loadingDescription");
				
				int loadCargoAmount = 0;
				if(request.getParameter("loadingAmount") != null && !request.getParameter("loadingAmount").isEmpty()) loadCargoAmount = Integer.parseInt(request.getParameter("loadingAmount"));
				
				int arrivalPassengers = 0;
				if(request.getParameter("PassengerArrivalNumber") != null && !request.getParameter("PassengerArrivalNumber").isEmpty()) arrivalPassengers = Integer.parseInt(request.getParameter("PassengerArrivalNumber"));
				
				int departurePassengers = 0;
				if(request.getParameter("PassengerDepartureNumber") != null && !request.getParameter("PassengerDepartureNumber").isEmpty()) departurePassengers = Integer.parseInt(request.getParameter("PassengerDepartureNumber"));
				
				//For some reason this object is null when it's added to the dao
				PrearrivalForm form = new PrearrivalForm(name, callSign, imo, agentInfo, arrivingFrom, eta, berth, nextPort, etd, dischargeCargoDesc, dischargeCargoAmount, loadCargoDesc, loadCargoAmount, arrivalPassengers, departurePassengers, 0);
				
				dao.addFormToList(form);
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
				System.out.println("Exception during edit operation");
			}
			
			request.getRequestDispatcher("ships.jsp").forward(request,  response);
		
		} else if(operation.equals("/PortCall/submitForm")) {
			
			//Causes 500 server error nullPointer, because of line 90-92
			request.setAttribute("ship", dao.getLastShipName());
			
			request.setAttribute("request", operation);
			request.getRequestDispatcher("sentForm.jsp").forward(request,  response);
		}
	}
}
