package main.java.beans;

public class PrearrivalForm implements Cloneable {
	
	private String name;
	private String callSign;
	private int imo;
	private String agentInfo;
	private String arrivingFrom;
	private String eta;
	private int berth;
	private String nextPort;
	private String etd;
	private String dischargeCargoDesc;
	private int dischargeCargoAmount;
	private String loadCargoDesc;
	private int loadCargoAmount;
	private int arrivalPassengers;
	private int departurePassengers;
	//This is where the crew documents would go
	private int formValidation;

	public PrearrivalForm(String name, String callSign, int imo, String agentInfo, String arrivingForm, String eta, int berth, String nextPort, String etd, String dischargeCargoDesc, int dischargeCargoAmount, String loadCargoDesc, int loadCargoAmount, int arrivalPassengers, int departurePassengers, int formValidation) {
		this.name = name;
		this.callSign = callSign;
		this.imo = imo;
		this.agentInfo = agentInfo;
		this.arrivingFrom = arrivingForm;
		this.eta = eta;
		this.berth = berth;
		this.nextPort = nextPort;
		this.etd = etd;
		this.dischargeCargoDesc = dischargeCargoDesc;
		this.dischargeCargoAmount = dischargeCargoAmount;
		this.loadCargoDesc = loadCargoDesc;
		this.loadCargoAmount = loadCargoAmount;
		this.arrivalPassengers = arrivalPassengers;
		this.departurePassengers = departurePassengers;
	}
	
	public PrearrivalForm() {}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	
	
	public void setCallSign(String callSign) {
		this.callSign = callSign;
	}
	
	public String getCallSign() {
		return this.callSign;
	}
	
	

	public void setIMO(int imo) {
		this.imo = imo;
	}
	
	public int getIMO() {
		return this.imo;
	}
	
	
	
	public void setAgentInfo(String agentInfo) {
		this.agentInfo = agentInfo;
	}
	
	public String getAgentInfo() {
		return this.agentInfo;
	}
	
	
	
	public void setArrivingFrom(String arrivingFrom) {
		this.arrivingFrom = arrivingFrom;
	}
	
	public String getArrivingFrom() {
		return this.arrivingFrom;
	}
	
	
	
	public void setETA(String eta) {
		this.eta = eta;
	}
	
	public String getETA() {
		return this.eta;
	}
	
	
	
	public void setBerth(int berth) {
		this.berth = berth;
	}
	
	public int getBerth() {
		return this.berth;
	}
	
	
	
	public void setNextPort(String nextPort) {
		this.nextPort = nextPort;
	}
	
	public String getNextPort() {
		return this.nextPort;
	}
	
	
	
	public void setETD(String etd) {
		this.etd = etd;
	}
	
	public String getETD() {
		return this.etd;
	}
	
	
	
	public void setDischargeCargoDesc(String dischargeCargoDesc) {
		this.dischargeCargoDesc = dischargeCargoDesc;
	}
	
	public String getDischargeCargoDesc() {
		return this.dischargeCargoDesc;
	}
	
	
	
	public void setDischargeCargoAmount(int dischargeCargoAmount) {
		this.dischargeCargoAmount = dischargeCargoAmount;
	}
	
	public int getDischargeCargoAmount() {
		return this.dischargeCargoAmount;
	}
	
	
	
	public void setLoadCargoDesc(String loadCargoDesc) {
		this.loadCargoDesc = loadCargoDesc;
	}
	
	public String getLoadCargoDesc() {
		return this.loadCargoDesc;
	}
	
	
	
	public void setLoadCargoAmount(int loadCargoAmount) {
		this.loadCargoAmount = loadCargoAmount;
	}
	
	public int getLoadCargoAmount() {
		return this.loadCargoAmount;
	}
	
	
	
	public void setArrivalPassengers(int arrivalPassengers) {
		this.arrivalPassengers = arrivalPassengers;
	}
	
	public int getArrivalPassengers() {
		return this.arrivalPassengers;
	}
	
	
	
	public void setDeparturePassengers(int departurePassengers) {
		this.departurePassengers = departurePassengers;
	}
	
	public int getDeparturePassengers() {
		return this.departurePassengers;
	}
	
	
	
	public void setFormValidation(int formValidation) {
		this.formValidation = formValidation;
	}
	
	public int getFormValidation() {
		return this.formValidation;
	}
	
	
	
	public PrearrivalForm cloneMe() {
		try {
			return (PrearrivalForm) super.clone();
		} catch (CloneNotSupportedException e) {
			return null ;
		}
	}

}
