package main.java.beans;

public class Vessel implements Cloneable {
	private int imo;
	private String flag;
	private String name;
	private int built;
	private String callSign;
	private int length;
	private int breadth;
	private int tonnage;
	private int mmsi;
	private String type;
	private int ownerCode;
	
	public Vessel(int imo, String flag, String name, int built, String callSign, int length, int breadth, int tonnage, int mmsi, String type, int ownerCode) {
		this.imo = imo;
		this.flag = flag;
		this.name = name;
		this.built = built;
		this.callSign = callSign;
		this.length = length;
		this.breadth = breadth;
		this.tonnage = tonnage;
		this.mmsi = mmsi;
		this.type = type;
		this.ownerCode = ownerCode;
	}
	
	/**
	 * @return the imo
	 */
	public int getIMO() {
		return imo;
	}
	/**
	 * @return the flag
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return the built
	 */
	public int getBuilt() {
		return built;
	}
	/**
	 * @return the callSign
	 */
	public String getCallSign() {
		return callSign;
	}
	/**
	 * @return the length
	 */
	public int getLength() {
		return length;
	}
	/**
	 * @return the breadth
	 */
	public int getBreadth() {
		return breadth;
	}
	/**
	 * @return the tonnage
	 */
	public int getTonnage() {
		return tonnage;
	}
	/**
	 * @return the mmsi
	 */
	public int getMmsi() {
		return mmsi;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @return the ownerCode
	 */
	public int getOwnerCode() {
		return ownerCode;
	}
}
