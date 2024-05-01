package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.ConnectDB;
import entity.BangPhanCong;
import entity.CongTrinh;
import entity.NhanVien;
import entity.TKNVCoTrongCT;
import entity.TKSoDuAnNVThamGia;

public class Dao_ThongKe {
	public ArrayList<TKSoDuAnNVThamGia> getAllDuAn() {
		ArrayList<TKSoDuAnNVThamGia> tk = new ArrayList<TKSoDuAnNVThamGia>();
		TKSoDuAnNVThamGia da = null;
		Connection con = ConnectDB.getConnection();
        try{
            CallableStatement stmt = con.prepareCall("{call GetAssignedTasksByEmployee()}");
            ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    String maNV = rs.getString("maNV");
                    String tenNV = rs.getString("tenNV");
                    int assignedTasks = rs.getInt("AssignedTasks");
                    da=new TKSoDuAnNVThamGia(maNV, tenNV, assignedTasks);
                    tk.add(da);
                }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return tk;
    }
	public ArrayList<TKNVCoTrongCT> getNVCoTrongCT(String ma) {
		ArrayList<TKNVCoTrongCT> tk = new ArrayList<TKNVCoTrongCT>();
		TKNVCoTrongCT da = null;
		Connection con = ConnectDB.getConnection();
        try{
        	CallableStatement stmt = con.prepareCall("{call GetEmployeesInProject(?)}");

            stmt.setString(1, ma); // Đặt giá trị cho tham số đầu tiên

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
           
                String maNV = rs.getString("maNV");
                String tenNV = rs.getString("tenNV");
                    da=new TKNVCoTrongCT(maNV, tenNV);
                    tk.add(da);
                }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return tk;
	}
}
