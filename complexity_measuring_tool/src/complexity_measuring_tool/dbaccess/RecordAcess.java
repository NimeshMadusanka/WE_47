package complexity_measuring_tool.dbaccess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import complexity_measuring_tool.model.CheckFile;
import complexity_measuring_tool.model.ViewRecord;
import complexity_measuring_tool.util.DBConnection;

/*
 * @Author Peiris.M.R.P IT16173064
 * 
 */
public class RecordAcess {
	
	public static boolean saveRecordData(int fileId, CheckFile checkFile) {

		Connection connection = null;
		int[] result = null;
		int size = 0;

		try {
			connection = DBConnection.getInstance().getConnection();
			connection.setAutoCommit(false);
			Statement statement = connection.createStatement();
			for (String line : checkFile.getFileLines()) {
				statement.addBatch("INSERT INTO records values(" + 0 + ",'" + line + "','" + fileId + "')");
			}
			result = statement.executeBatch();
			connection.commit();
//			connection.close();
			return true;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return false;
	}
	
	public static ArrayList<ViewRecord> retriveRecords(String fileName) {
		String sql= "select r.value,f.date,f.cs,f.cns,f.cts,f.ci,f.cr "
				+ "from records r, file f "
				+ "where f.fileId=r.fileId and r.fileId = ("
				+ "select fl.fileId "
				+ "from file fl "
				+ "where fileName='"+fileName+"' "
				+ "group by fl.fileId desc "
				+ "limit 1)"; 
				
		Connection connection = null;
		ArrayList<ViewRecord> latesRecords = new ArrayList<ViewRecord>();
		
		try {
			connection = DBConnection.getInstance().getConnection();
			Statement statement = connection.createStatement();
			ResultSet rs= statement.executeQuery(sql);
			ViewRecord line=null;
			while (rs.next()) {
				line = new ViewRecord(rs.getString("date"), rs.getString("value"),rs.getInt("cs"),rs.getInt("cns"),rs.getInt("cts"),rs.getInt("ci"),rs.getInt("cr"));
				latesRecords.add(line);
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return latesRecords;
	}
}
