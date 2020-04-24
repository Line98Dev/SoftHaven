package beans;

public class Ship implements Cloneable {
	
	private int imo;
	private String name;
	private int tonnage; 
	private String flag;


	public Ship( int imo, String name, int tonnage, String flag) {
		this.imo = imo;
		this.name = name;
		this.tonnage = tonnage;
		this.flag=flag;
	}
	
	public Ship() {}

	public void setImo( int i ) {
		imo = i;
	}
	public int getImo() {
		return imo;
	}
	
	public void setName( String n) {
		name = n;
	}
	public String getName() {
		return name;
	}
	
	public void setTonnage( int t) {
		tonnage = t;
	}
	public int getTonnage() {
		return tonnage;
	}

	public void setFlag(String f) {
		flag = f;
	}
	public String getFlag() {
		return flag;
	}
	

	
	public Ship cloneMe() {
		try {
			return (Ship) super.clone();
		} catch (CloneNotSupportedException e) {
			return null ;
		}
	}

}
