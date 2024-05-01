package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.ConnectDB;
import entity.CongViec;

public class Dao_CongViec {
	public ArrayList<CongViec> getAllCongViec() {
		ArrayList<CongViec> dsCongViec = new ArrayList<CongViec>();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from CongViec";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				String ma = rs.getString("maCongViec");
				String ten = rs.getString("tenCongViec");
				
				dsCongViec.add(new CongViec(ma, ten));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		ConnectDB.closeConnection(con);
		return dsCongViec;
	}
	
	
	public String getTenCVTheoMa(String maCV) throws SQLException {
		String tenCV = "";
		Connection con = ConnectDB.getConnection();
		try {
			if(con!=null) {
			String sql = "Select * from CongViec";
			Statement sta = con.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			
				while (rs.next()) {
					String maCV1 = rs.getString(1);
					if(maCV1.equals(maCV)) {
						tenCV=rs.getString(2);
					}
				}
			}
			else
				System.out.println("lỗi");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tenCV;
	}
}
