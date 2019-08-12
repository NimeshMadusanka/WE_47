package complexity_measuring_tool.service;

import java.sql.Connection;
import java.sql.PreparedStatement;

import complexity_measuring_tool.model.File;
import complexity_measuring_tool.util.DBConnect;

public class FileService {

	public static File setFile(String name) {

		File file = new File();
		
		file.setName(name);
		
		return file;
		
	}
	public static String saveFile(File file) {

		Connection connection;
		PreparedStatement preparedStatement;
		String status = null;

		try {

			connection = DBConnect.getDBConnection();
			preparedStatement = connection.prepareStatement("INSERT INTO file VALUES (?)");
			preparedStatement.setString(1, file.getName());
			
			int rows = preparedStatement.executeUpdate();

			if (rows > 0)
				status = "File added Successfully";
			else
				status = "Failed to added file";

		} catch (Exception e) {

			status = e.getMessage();
			e.getStackTrace();

		}

		return status;

	}
	
}
