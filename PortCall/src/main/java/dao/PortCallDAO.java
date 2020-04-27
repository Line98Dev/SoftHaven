package main.java.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.sql.DataSource;
import main.java.beans.PrearrivalForm;
import main.java.beans.Ship;


@ApplicationScoped @JDBC
public class PortCallDAO {
	@Resource( lookup="jdbc/DenmarkTraffic") //We'll have to change this
	private DataSource dataSource;
	private List<PrearrivalForm> arrivalForms = new ArrayList<PrearrivalForm>();
	
	static interface RunJDBC <T>{
		T run(Connection con) throws Exception;
	}
	
	private <T> T withDB(RunJDBC<T> runner) {
		Connection con = null;
		T result = null;
		try {
			con = dataSource.getConnection();
			boolean auto = con.getAutoCommit();
			con.setAutoCommit(false);
			result = runner.run(con);
			con.commit();
			con.setAutoCommit(auto);
		} catch (Exception e) {
			System.out.println(e);
			try { con.rollback(); } catch( SQLException ex) {}
		} finally {
			if (con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
			
	public List<Ship> listShips(){
		return withDB( new RunJDBC<List<Ship>>() {
			public List<Ship> run (Connection con) throws Exception {
				List<Ship> list = new ArrayList<Ship>();
				Statement stt = con.createStatement();
				final String req = "select * from Ship;";
				ResultSet rs = stt.executeQuery(req);
				while (rs.next()) {
					Ship ship = new Ship();
					ship.setIMO(rs.getInt("IMO"));
					ship.setBerth(rs.getInt("Berth"));
					ship.setName(rs.getString("Name"));
					ship.setState(rs.getString("State"));
					list.add( ship );
				}
				
				return list;
			}
		});
	}
	
    public Ship findShip(final int imo) {
        return withDB(con -> {
            PreparedStatement req = con.prepareStatement(
                    "select * from Ship where IMO = ?");
            req.setInt(1, imo);
            ResultSet rs = req.executeQuery();
            if (rs.next()) {
                Ship ship = new Ship();
                ship.setIMO(rs.getInt("IMO"));
                ship.setName(rs.getString("Name"));
                ship.setBerth(rs.getInt("Berth"));
                ship.setState(rs.getString("State"));
                
                return ship;
            } else {
                return null;
            }
        });
    }
    
    public void setState(final int imo, String state) {
        System.out.println("in Modify()");
        withDB((RunJDBC<Ship>) con -> {
            PreparedStatement req = con.prepareStatement(
                    "update Ship set State=? where IMO=?");
            req.setString(1, state);
            req.setInt(2, imo);
            int nbLines = req.executeUpdate();
            System.out.println("in Modify()");
            if (nbLines != 1) {
                System.out.println("Exception during modify");
            }
            return null;
        });
    }
	
	public void addFormToList(PrearrivalForm form) {
		this.arrivalForms.add(form);
	}
	
	public List<Ship> getTestList() {
		List<Ship> shipList = new ArrayList<Ship>();
		
		shipList.add(new Ship("Enterprise", 43126, 101, "at berth"));
		shipList.add(new Ship("Tugger", 5556, 102, "waiting"));
		shipList.add(new Ship("Rictus", 1236, 103, "departed"));
		
		return shipList;
	}

	public List<PrearrivalForm> listPreArrivalForms() {
		return withDB( new RunJDBC<List<PrearrivalForm>>() {
			public List<PrearrivalForm> run (Connection con) throws Exception {
				List<PrearrivalForm> list = new ArrayList<PrearrivalForm>();
				Statement stt = con.createStatement();
				final String req = "select * from `Vessel Pre-arrival Form` WHERE `Form Validation`=0;";
				ResultSet rs = stt.executeQuery(req);
				while (rs.next()) {
					PrearrivalForm form = new PrearrivalForm();
					form.setName(rs.getString("Ship Name"));
					form.setCallSign(rs.getString("Call sign"));
					form.setIMO(rs.getInt("IMO"));
					form.setAgentInfo(rs.getString("Agent Info"));
					form.setArrivingFrom(rs.getString("Arriving From"));
					form.setETA(rs.getString("ETA"));
					form.setBerth(rs.getInt("Berth Number"));
					form.setNextPort(rs.getString("Next PortName"));
					form.setETD(rs.getString("ETD"));
					form.setDischargeCargoDesc(rs.getString("Offboarding Cargo Desc"));
					form.setDischargeCargoAmount(rs.getInt("Offboarding Cargo Amount"));
					form.setLoadCargoDesc(rs.getString("Onboarding Cargo Desc"));
					form.setLoadCargoAmount(rs.getInt("Onboarding Cargo Amount"));
					form.setArrivalPassengers(rs.getInt("Passengers on Arrival"));
					form.setDeparturePassengers(rs.getInt("Passengers on Departure"));
					form.setFormValidation(rs.getInt("Form Validation"));
					
					list.add(form);
				}
				
				return list;
			}
		});
	}
	
	public void addPrearrivalForm(final PrearrivalForm form) {
        withDB((RunJDBC<Ship>) con -> {
            PreparedStatement req = con.prepareStatement(
                    "INSERT INTO `Vessel Pre-arrival Form` VALUES ('?', '?', '?', '?', '?', '?', '?', '?', '?', '?', '?', '?', '?', '?', '?', '?', '?')");
            req.setString(1, form.getName());
            req.setString(2, form.getCallSign());
            req.setInt(3, form.getIMO());
            req.setString(4, form.getAgentInfo());
            req.setString(5, form.getArrivingFrom());
            req.setString(6, form.getETA());
            req.setInt(7, form.getBerth());
            req.setString(8, form.getNextPort());
            req.setString(9, form.getETD());
            req.setString(10, form.getDischargeCargoDesc());
            req.setInt(11, form.getDischargeCargoAmount());
            req.setString(12, form.getLoadCargoDesc());
            req.setInt(13, form.getLoadCargoAmount());
            req.setInt(14, form.getArrivalPassengers());
            req.setInt(15, form.getDeparturePassengers());
            req.setString(16, "");
            req.setInt(17, form.getFormValidation());
            int nbLines = req.executeUpdate();
            System.out.println("in Modify()");
            if (nbLines != 1) {
                System.out.println("Exception during modify");
            }
            return null;
        });
    }
	
	public PrearrivalForm findForm(int IMO) {
		return withDB(con -> {
            PreparedStatement req = con.prepareStatement(
                    "select * from `Vessel Pre-arrival Form` where IMO = ?");
            req.setInt(1, IMO);
            ResultSet rs = req.executeQuery();
            if (rs.next()) {
            	PrearrivalForm form = new PrearrivalForm();
				form.setName(rs.getString("Ship Name"));
				form.setCallSign(rs.getString("Call sign"));
				form.setIMO(rs.getInt("IMO"));
				form.setAgentInfo(rs.getString("Agent Info"));
				form.setArrivingFrom(rs.getString("Arriving From"));
				form.setETA(rs.getString("ETA"));
				form.setBerth(rs.getInt("Berth Number"));
				form.setNextPort(rs.getString("Next PortName"));
				form.setETD(rs.getString("ETD"));
				form.setDischargeCargoDesc(rs.getString("Offboarding Cargo Desc"));
				form.setDischargeCargoAmount(rs.getInt("Offboarding Cargo Amount"));
				form.setLoadCargoDesc(rs.getString("Onboarding Cargo Desc"));
				form.setLoadCargoAmount(rs.getInt("Onboarding Cargo Amount"));
				form.setArrivalPassengers(rs.getInt("Passengers on Arrival"));
				form.setDeparturePassengers(rs.getInt("Passengers on Departure"));
				form.setFormValidation(rs.getInt("Form Validation"));
                
                return form;
            } else {
                return null;
            }
        });
	}

	public void approveForm(int imo, boolean status) {
		System.out.println("in Modify()");
        withDB((RunJDBC<PrearrivalForm>) con -> {
            PreparedStatement req = con.prepareStatement(
                    "update Ship set `Form Validation`=? where IMO=?");
            req.setInt(1, status? 1 : 0);
            req.setInt(2, imo);
            int nbLines = req.executeUpdate();
            System.out.println("in Modify()");
            if (nbLines != 1) {
                System.out.println("Exception during modify");
            }
            return null;
        });
	}
}
