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
import entity.NhanVien;
import entity.PhongBan;

public class Dao_NhanVien {


	public ArrayList<NhanVien> getAllNhanVien() {
		ArrayList<NhanVien> dsNhanVien = new ArrayList<NhanVien>();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from NhanVien";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				String ma = rs.getString("maNV");
				String ten = rs.getString("tenNV");
				Date ngaySinh = rs.getDate("ngaySinh");
				String sdt = rs.getString("sdt");
				Boolean gioiTinh = rs.getBoolean("gioiTinh");
				String cccd = rs.getString("cccd");
				String dcTamTru = rs.getString("diaChiTamTru");
				String dcThuongTru = rs.getString("diaChiThuongTru");
				String chucVu = rs.getString("chucVu");
				String maPB = rs.getString("maPB");
				dsNhanVien.add(new NhanVien(ma, ten, ngaySinh, gioiTinh, sdt, cccd, dcTamTru, dcThuongTru, chucVu, new PhongBan(maPB)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		ConnectDB.closeConnection(con);
		return dsNhanVien;
		
	}
	
	public NhanVien timKiemTheoMa(String maNV){
		NhanVien nv = null;
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from NhanVien where maNV = '" + maNV + "'";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				String ma = rs.getString("maNV");
				String ten = rs.getString("tenNV");
				Date ngaySinh = rs.getDate("ngaySinh");
				String sdt = rs.getString("sdt");
				Boolean gioiTinh = rs.getBoolean("gioiTinh");
				String cccd = rs.getString("cccd");
				String dcTamTru = rs.getString("diaChiTamTru");
				String dcThuongTru = rs.getString("diaChiThuongTru");
				String chucVu = rs.getString("chucVu");
				String maPB = rs.getString("maPB");
				nv = new NhanVien(ma, ten, ngaySinh, gioiTinh, sdt, cccd, dcTamTru, dcThuongTru, chucVu, new PhongBan(maPB));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		ConnectDB.closeConnection(con);
		return nv;
	}
	public boolean createCT(NhanVien nv) {
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {

			stmt = con.prepareStatement("insert into NhanVien VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			stmt.setString(1, nv.getMaNV());
			stmt.setString(2, nv.getTenNV());
			stmt.setDate(3, nv.getNgaySinh());
			stmt.setString(4, nv.getSdt());
			stmt.setBoolean(5, nv.isGioiTinh());
			stmt.setString(6, nv.getCccd());
			stmt.setString(7, nv.getDiaChiTamTru());
			stmt.setString(8, nv.getDiaCHiThuongTru());
			stmt.setString(9, nv.getChucVu());
			stmt.setString(10, nv.getPhongBan().getMaPB());
			n = stmt.executeUpdate();
			} catch (SQLException e2) {
				// TODO: handle exception
			
				e2.printStackTrace();
			}
		ConnectDB.closeConnection(con);
		return n>0;
	}
	public boolean deleteNV(String manv) throws SQLException {
		Connection con = ConnectDB.getConnection();
		String sql ="DELETE FROM NhanVien WHERE maNV = ?";
		PreparedStatement pst = null;
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1,manv);
			int kt = pst.executeUpdate() ;
			ConnectDB.closeConnection(con);
			if(kt > 0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean update(NhanVien nv) {
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n=0;
		try {
			stmt = con.prepareStatement("update NhanVien set maNV = ?, tenNV= ?, ngaySinh = ?, sdt = ?, gioiTinh = ?, cccd = ?, diaChiTamTru = ?, diaChiThuongTru = ?, chucVu = ?, maPB = ? where maNV = ?");
			
			stmt.setString(1, nv.getMaNV());
			stmt.setString(2, nv.getTenNV());
			stmt.setDate(3, nv.getNgaySinh());
			stmt.setString(4, nv.getSdt());
			stmt.setBoolean(5, nv.isGioiTinh());
			stmt.setString(6, nv.getCccd());
			stmt.setString(7, nv.getDiaChiTamTru());
			stmt.setString(8, nv.getDiaCHiThuongTru());
			stmt.setString(9, nv.getChucVu());
			stmt.setString(10, nv.getPhongBan().getMaPB());
			stmt.setString(11, nv.getMaNV());
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
	
	public String getTenNVTheoMa(String maNV) throws SQLException {
		String tenNV = null;
		Connection con = ConnectDB.getConnection();
		try {
			if(con!=null) {
			String sql = "Select * from NhanVien";
			Statement sta = con.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			
			while (rs.next()) {
				String maNV1 = rs.getString(1);
				if(maNV1.equals(maNV)) {
					tenNV=rs.getString(2);
				}
			}
			}
			else
				System.out.println("lỗi");
		} catch (Exception e) {
			e.printStackTrace();
		}
		ConnectDB.closeConnection(con);
		return tenNV;
	}
	
	public String getCCCDNVTheoMa(String maNV) throws SQLException {
		String cCCD = null;
		Connection con = ConnectDB.getConnection();
		try {
			if(con!=null) {
			String sql = "Select * from NhanVien";
			Statement sta = con.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			
			while (rs.next()) {
				String maNV1 = rs.getString(1);
				if(maNV1.equals(maNV)) {
					cCCD=rs.getString(6);
				}
			}
			}
			else
				System.out.println("lỗi");
		} catch (Exception e) {
			e.printStackTrace();
		}
		ConnectDB.closeConnection(con);
		return cCCD;
	}
	public String getPBNVTheoMa(String maNV) throws SQLException {
		String pB = null;
		Connection con = ConnectDB.getConnection();
		try {
			if(con!=null) {
			String sql = "Select * from NhanVien";
			Statement sta = con.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			
			while (rs.next()) {
				String maNV1 = rs.getString(1);
				if(maNV1.equals(maNV)) {
					pB=rs.getString(10);
				}
			}
			}
			else
				System.out.println("lỗi");
		} catch (Exception e) {
			e.printStackTrace();
		}
		ConnectDB.closeConnection(con);
		return pB;
	}
	
	public String getGTNVTheoMa(String maNV) throws SQLException {
		String gT = null;
		Connection con = ConnectDB.getConnection();
		try {
			if(con!=null) {
			String sql = "Select * from NhanVien";
			Statement sta = con.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			
			while (rs.next()) {
				String maNV1 = rs.getString(1);
				if(maNV1.equals(maNV)) {
					gT=rs.getString(5);
				}
			}
			}
			else
				System.out.println("lỗi");
		} catch (Exception e) {
			e.printStackTrace();
		}
		ConnectDB.closeConnection(con);
		return gT;
	}
}

