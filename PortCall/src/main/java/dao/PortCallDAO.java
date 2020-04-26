package main.java.dao;
import java.math.BigDecimal;
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
}
