package complexity_measuring_tool.dbaccess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import complexity_measuring_tool.model.CheckFile;
import complexity_measuring_tool.util.DBConnection;

public class FileAccess {

	public static boolean saveFileData(CheckFile checkFile)
			throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {

		Connection connection = DBConnection.getInstance().getConnection();
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		String dateTime = df.format(checkFile.getDate());

		String sql = "Insert into file values(" + 0 + ",'" + checkFile.getFileName() + "','" + dateTime + "','"
				+ checkFile.getCs() + "','" + checkFile.getCns() + "','" + checkFile.getCts() + "','"
				+ checkFile.getCi() + "','" + checkFile.getCr() + "','" + checkFile.getTw() + "')";

		Statement statement = connection.createStatement();
		int resp = statement.executeUpdate(sql);

		if (resp > 0) {
			ResultSet rs = statement.getGeneratedKeys();
			int lastInsertedRecoedId = 0;
			if (rs.next()) {
				lastInsertedRecoedId = rs.getInt(1);
			}
			boolean res = RecordAcess.saveFileData(lastInsertedRecoedId, checkFile);
			if (res == true) {
				return true;
			}
		}
		connection.rollback();
		return false;

	}

}
