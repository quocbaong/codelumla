package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import database.ConnectDB;
import entity.CongTrinh;

public class Dao_CongTrinh {
	
	public ArrayList<CongTrinh> getAllCongTrinh() {
		ArrayList<CongTrinh> dsCongTrinh = new ArrayList<CongTrinh>();
		CongTrinh ct= null;
		
		Connection con = ConnectDB.getConnection();
		try {
			if(con!=null) {
			String sql = "Select * from CongTrinh";
			Statement sta = con.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			
			while (rs.next()) {
				String maCT1 = rs.getString(1);
				String hoCT =  rs.getString(2);
				String diaChi = rs.getString(3);
				Date ngayCapPhep=rs.getDate(4);
				Date ngayKhoiCong=rs.getDate(5);
				Date ngayHT=rs.getDate(6);
				ct = new CongTrinh(maCT1, hoCT, diaChi, ngayCapPhep, ngayKhoiCong, ngayHT);;
				dsCongTrinh.add(ct);
			}
			}
			else
				System.out.println("lỗi");
		} catch (Exception e) {
			e.printStackTrace();
		}
		ConnectDB.closeConnection(con);
		return dsCongTrinh;
	}
	
	public CongTrinh getCongTrinhTheoMa(String maCT) {
		CongTrinh ct= null;

		
		Connection con = ConnectDB.getConnection();
		

		try {
			String sql = "select * from CongTrinh where maCT='"+maCT+"'";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next()) {
				String maCT1 = rs.getString(1);
				String hoCT =  rs.getString(2);
				String diaChi = rs.getString(3);
				Date ngayCapPhep=rs.getDate(4);
				Date ngayKhoiCong=rs.getDate(5);
				Date ngayHT=rs.getDate(6);
				ct = new CongTrinh(maCT1, hoCT, diaChi, ngayCapPhep, ngayKhoiCong, ngayHT);

			}}
			
		 catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return ct;
	}
	
	public String getTenCTTheoMa(String maCT) throws SQLException {
		String tenCT = "";
		ConnectDB.getConnection();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select tenCT from CongTrinh where maCT like '%" + maCT + "%'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				tenCT = rs.getString("tenCT");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		ConnectDB.closeConnection(con);
		return tenCT;
	}
	public String getNgayKCCTTheoMa(String maCT) throws SQLException {
		String ngayKC = null;
		ConnectDB.getConnection();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from CongTrinh where maCT='"+maCT+"'";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next()) {
				String maCT1 = rs.getString(1);
				if(maCT1.equals(maCT)) {
					Date ngayKhoiCong=rs.getDate(5);
					ngayKC=	ngayKhoiCong.toString();
				}
				else
					ngayKC="";
			}}
			
		 catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		ConnectDB.closeConnection(con);
		return ngayKC;
	}
	public String getNgayHTCTTheoMa(String maCT) throws SQLException {
		String ngayHT = null;
		ConnectDB.getConnection();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from CongTrinh where maCT='"+maCT+"'";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next()) {
				String maCT1 = rs.getString(1);
				if(maCT1.equals(maCT)) {
					Date ngayHoanThanh=rs.getDate(6);
					ngayHT=	ngayHoanThanh.toString();
				}
				else
					ngayHT="";
			}
		}	
		 catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		ConnectDB.closeConnection(con);
		return ngayHT;
	}
	
	public boolean createCT(CongTrinh ct) {
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {

			stmt = con.prepareStatement("insert into CongTrinh values (?, ?, ?, ?, ?, ?)");
			stmt.setString(1, ct.getMaCT());
			stmt.setString(2, ct.getTenCT());
			stmt.setString(3, ct.getDiaDiem());
			stmt.setDate(4, ct.getNgayCapPhep());
			stmt.setDate(5, ct.getNgayKhoiCong());
			stmt.setDate(6, ct.getNgayHT());

			n = stmt.executeUpdate();
			} catch (SQLException e2) {
				// TODO: handle exception
			
				
			}
		ConnectDB.closeConnection(con);
		return n>0;
	}

	public boolean update(CongTrinh ct) {
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n=0;
		try {
			stmt = con.prepareStatement("update CongTrinh set maCT = ?, tenCT= ?, diaDiem = ?, ngayCapPhep = ?, ngayKhoiCong = ?, ngayHT = ? where maCT = ?");
			
			stmt.setString(1, ct.getMaCT());
			stmt.setString(2, ct.getTenCT());
			stmt.setString(3, ct.getDiaDiem());
			stmt.setDate(4, ct.getNgayCapPhep());
			stmt.setDate(5, ct.getNgayKhoiCong());
			stmt.setDate(6, ct.getNgayHT());
			stmt.setString(7, ct.getMaCT());
			n = stmt.executeUpdate();
			} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		ConnectDB.closeConnection(con);
		return n > 0;
	}

	public boolean xoa(String ma) throws SQLException {
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("delete CongTrinh where maCT = ?");
			stmt.setString(1, ma);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		ConnectDB.closeConnection(con);
		return n > 0;
	}
}
