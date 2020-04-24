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

import beans.Ship;


@ApplicationScoped @JDBC
public class ShipDAO {
	@Resource( lookup="jdbc/myShips") //Change this to match what's needed
	private DataSource dataSource;
	
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
			
	
}
