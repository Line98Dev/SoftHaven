package main.java.dao;
import java.sql.Connection;
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
	@Resource( lookup="jdbc/myShips") //We'll have to change this
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
			
	public List<PrearrivalForm> list(){
		return withDB( new RunJDBC<List<PrearrivalForm>>() {
			public List<PrearrivalForm> run (Connection con) throws Exception {
				List<PrearrivalForm> list = new ArrayList<PrearrivalForm>();
				Statement stt = con.createStatement();
				final String req = "select * from VESSEL ORDER BY RAND() LIMIT 3;";
				ResultSet rs = stt.executeQuery(req);
				while (rs.next()) {
					PrearrivalForm ship = new PrearrivalForm();
					//ship.setImo(rs.getInt("IMO"));
					//ship.setTonnage(rs.getInt("Tonnage"));
					//ship.setName(rs.getString("Name"));
					//ship.setFlag(rs.getString("Flag"));
					list.add( ship );
				}
				
				return list;
			}
		});
	}
	
	public void addFormToList(PrearrivalForm form) {
		this.arrivalForms.add(form);
	}
	
	public String getLastShipName() {
		
		PrearrivalForm form = this.arrivalForms.get(this.arrivalForms.size() - 1);
		String name = form.getName();
		
		return name;
	}
	
	public List<Ship> getTestList() {
		List<Ship> shipList = new ArrayList<Ship>();
		
		shipList.add(new Ship("Enterprise", 43126, 101, "at berth"));
		shipList.add(new Ship("Tugger", 5556, 102, "waiting"));
		shipList.add(new Ship("Rictus", 1236, 103, "departed"));
		
		return shipList;
	}
}
