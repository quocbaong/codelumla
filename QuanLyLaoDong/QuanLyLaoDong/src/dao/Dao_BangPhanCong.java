package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.ConnectDB;
import entity.BangPhanCong;
import entity.CongTrinh;
import entity.CongViec;
import entity.NhanVien;


public class Dao_BangPhanCong {
	

	public ArrayList<BangPhanCong> getAllDuAn() {
		ArrayList<BangPhanCong> dsDuAn = new ArrayList<BangPhanCong>();
		BangPhanCong da = null;
		
		Connection con = ConnectDB.getConnection();
		try {
			if(con!=null) {
			String sql = "Select * from BangPhanCong";
			Statement sta = con.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			
			while (rs.next()) {
				String maBPC = rs.getString(1);
				String maNV =  rs.getString(2);
				String maCT = rs.getString(3);
				String maCV = rs.getString(4);
				int soNCTG  =  rs.getInt(5);
				Date ngayBatDau=rs.getDate(6);
				Date ngayKT=rs.getDate(7);
				String ghiChu =rs.getString(8);
				da = new BangPhanCong(maBPC, new NhanVien(maNV), new CongTrinh(maCT), new CongViec(maCV), soNCTG, ngayBatDau, ngayKT, ghiChu);
				dsDuAn.add(da);
			}
			}
			else
				System.out.println("lỗi");
		} catch (Exception e) {
			e.printStackTrace();
		}
		ConnectDB.closeConnection(con);
		return dsDuAn;
	}
	public boolean createCT(BangPhanCong dA) {
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {

			stmt = con.prepareStatement("insert into BangPhanCong values (?, ?, ?, ?, ?, ?, ?, ?)");
			stmt.setString(1, dA.getMaBPC());
			stmt.setString(2, dA.getNhanVien().getMaNV());
			stmt.setString(3, dA.getCongTrinh().getMaCT());
			stmt.setString(4, dA.getCongViec().getMaCongViec());
			stmt.setInt(5, dA.getSoNgayCongThamGia());
			stmt.setDate(6, dA.getNgayBatDau());
			stmt.setDate(7, dA.getNgayKetThuc());
			stmt.setString(8, dA.getGhiChu());

			n = stmt.executeUpdate();
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
				
			}
		ConnectDB.closeConnection(con);
		return n>0;
	}
	public boolean update(BangPhanCong dA) {
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n=0;
		try {
			stmt = con.prepareStatement("update BangPhanCong set maBangPhanCong = ?, maNV = ?, maCT= ?, maCongViec= ?, soNgayCongThamGia= ?, ngayBatDau= ?, ngayKetThuc=?, ghiChu = ? where maBangPhanCong = ?");
			
			stmt.setString(1, dA.getMaBPC());
			stmt.setString(2, dA.getNhanVien().getMaNV());
			stmt.setString(3, dA.getCongTrinh().getMaCT());
			stmt.setString(4, dA.getCongViec().getMaCongViec());
			stmt.setInt(5, dA.getSoNgayCongThamGia());
			stmt.setDate(6, dA.getNgayBatDau());
			stmt.setDate(7, dA.getNgayKetThuc());
			stmt.setString(8, dA.getGhiChu());
			stmt.setString(9, dA.getMaBPC());
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
			stmt = con.prepareStatement("delete BangPhanCong where maBangPhanCong = ?");
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
