package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;

import database.ConnectDB;
import entity.BangPhanCong;
import entity.CongTrinh;
import entity.CongViec;
import entity.LichLamViec;
import entity.NhanVien;

public class Dao_LichLamViec {
	public ArrayList<LichLamViec> getAllLichLamViec() {
		ArrayList<LichLamViec> dsLichLamViec = new ArrayList<LichLamViec>();
		LichLamViec	lLV = null;
		
		Connection con = ConnectDB.getConnection();
		try {
			if(con!=null) {
			String sql = "Select * from LichLamViec";
			Statement sta = con.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			
			while (rs.next()) {
				String maLLV = rs.getString(1);
				String maNV =  rs.getString(2);
				String maCV = rs.getString(3);
				Date ngayLam=rs.getDate(4);
				Time thoiGianLam=rs.getTime(5);

				lLV=new LichLamViec(maLLV, new NhanVien(maNV), new CongViec(maCV), ngayLam, thoiGianLam);
				dsLichLamViec.add(lLV);
			}
			}
			else
				System.out.println("lỗi");
		} catch (Exception e) {
			e.printStackTrace();
		}
		ConnectDB.closeConnection(con);
		return dsLichLamViec;
	}
	
	public boolean createCT(LichLamViec lLV) {
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {

			stmt = con.prepareStatement("insert into LichLamViec values (?, ?, ?, ?, ?)");
			stmt.setString(1, lLV.getMalich());
			stmt.setString(2, lLV.getNhanVien().getMaNV());
			stmt.setString(3, lLV.getCongViec().getMaCongViec());
			stmt.setDate(4, lLV.getNgayLam());
			stmt.setTime(5, lLV.getThoiGianLam());

			n = stmt.executeUpdate();
			} catch (SQLException e2) {
				// TODO: handle exception
			
				
			}
		ConnectDB.closeConnection(con);
		return n>0;
	}
	public boolean update(LichLamViec lLV) {
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n=0;
		try {
			stmt = con.prepareStatement("update LichLamViec set maLich = ?, maNV = ?, maCongViec= ?, ngayLam= ?, thoiGianLam= ? where maLich = ?");
			
			stmt.setString(1, lLV.getMalich());
			stmt.setString(2, lLV.getNhanVien().getMaNV());
			stmt.setString(3, lLV.getCongViec().getMaCongViec());
			stmt.setDate(4, lLV.getNgayLam());
			stmt.setTime(5, lLV.getThoiGianLam());
			stmt.setString(6, lLV.getMalich());
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
			stmt = con.prepareStatement("delete LichLamViec where maLich = ?");
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
