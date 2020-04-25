package main.java.beans;

public class Ship implements Cloneable {

	private String name;
	private int imo;
	private int berth;
	private String state;
	
	public Ship(String name, int imo, int berth, String state) {
		this.name = name;
		this.imo = imo;
		this.berth = berth;
		this.state = state;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	
	public void setImo(int imo) {
		this.imo = imo;
	}
	
	public int getIMO() {
		return this.imo;
	}
	
	
	public void setBerth(int berth) {
		this.berth = berth;
	}
	
	public int getBerth() {
		return this.berth;
	}
	
	
	public void setState(String state) {
		this.state = state;
	}
	
	public String getState() {
		return this.state;
	}
	
	
	public Ship cloneMe() {
		try {
			return (Ship) super.clone();
		} catch (CloneNotSupportedException e) {
			return null ;
		}
	}
}
