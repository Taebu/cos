package file;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FileDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public FileDAO() {
		try {
			String dbURL = "jdbc:mysql://localhost:3306/file";
			String dbID = "root";
			String dbPassword = "";
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public int upload(String fileName,String fileRealName) {
		String SQL = "INSERT INTO file VALUES (?,?)";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, fileName);
			pstmt.setString(2, fileRealName);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return -1;
	}	
}
