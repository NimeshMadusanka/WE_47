package complexity_measuring_tool.dbaccess;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import complexity_measuring_tool.model.CheckFile;
import complexity_measuring_tool.util.DBConnection;

public class RecordAcess {
/*
 * @Author Peiris.M.R.P
 * IT16173064
 * 
 */
public static boolean saveRecordData(int fileId,CheckFile checkFile) {
		
		Connection connection = null ;
		int[] result = null ;
		int size = 0;

		try {
			connection = DBConnection.getInstance().getConnection();
			connection.setAutoCommit(false);
			Statement statement=connection.createStatement();
			for(String line : checkFile.getFileLines()) {
				statement.addBatch("INSERT INTO records values("+0+",'"+line+"','"+fileId+"')");
			}
			 result = statement.executeBatch();
			 connection.commit();
			 connection.close();
			 return true;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
}
