package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import data.Reply;


public class Replys {
	
	public static final String user = "C##MOIM";
	public static final String password = "1q2w3e4r";
	public static final String url = "jdbc:oracle:thin:@192.168.4.22:1521:xe";
	
	public static int create(int id, String moimId, String writer, String ment) {
		try {
			// 1. 연결
			Connection conn = DriverManager.getConnection(url, user, password);

			// 2. 요청객체 준비
			String sql = "INSERT INTO REPLYS(ID, MOIM_ID, WRITER,MENT) VALUES(?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, moimId);
			ps.setString(3, writer);
			ps.setString(4, ment);
			
		

			int r = ps.executeUpdate();
			conn.close();

			return r;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
}