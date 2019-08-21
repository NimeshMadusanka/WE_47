package complexity_measuring_tool.dbaccess;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import complexity_measuring_tool.model.CheckFile;
import complexity_measuring_tool.util.DBConnect;

public class RecordAcess {

public static boolean saveFileData(int fileId,CheckFile checkFile) {
		
		Connection connection = null ;
		int[] result = null ;
		int size = 0;

		try {
			connection = DBConnect.getDBConnection();
			connection.setAutoCommit(false);
			Statement statement=connection.createStatement();
			for(String line : checkFile.getFileLines()) {
				statement.addBatch("INSERT INTO records values("+0+",'"+line+"','"+fileId+"')");
			}
			 result = statement.executeBatch();
			 connection.commit();
			 connection.close();
			 return true;
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
}
