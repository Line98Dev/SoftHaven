package dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.sql.DataSource;

import beans.PrearrivalForm;


@ApplicationScoped @JDBC
public class PortCallDAO {
	@Resource( lookup="jdbc/myShips")
	private DataSource dataSource;
	private List<PrearrivalForm> arrivalForms;
	
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
		arrivalForms.add(form);
	}
}
