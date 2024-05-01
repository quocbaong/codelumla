package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import dao.Dao_BangPhanCong;
import dao.Dao_CongTrinh;
import dao.Dao_CongViec;
import dao.Dao_NhanVien;
import entity.BangPhanCong;
import entity.CongTrinh;
import entity.CongViec;
import entity.NhanVien;

public class Form_BangPhanCong extends JPanel implements ActionListener,MouseListener {

	private static final long serialVersionUID = 1L;
	private JTextField txtMaNV;
	private JTextField txtTenNV;
	private JTextField txtCCCD;
	private JTextField txtPB;
	private JRadioButton radNam;
	private JRadioButton radNu;
	private ButtonGroup grbSex;
	private JButton btnLayTTNV;
	private JButton btnXoaTrangNV;
	private JLabel lblMaCT;
	private JLabel lblTenCT;
	private JLabel lblNgayKhoiCong;
	private JLabel lblNgayHT;
	private JTextField txtMaCT;
	private JTextField txtTenCT;
	private JTextField txtNgayKhoiCong;
	private JTextField txtNgayHT;
	private JButton btnThemCT;
	private JLabel lblMaCV;
	private JLabel lblTenCV;
	private JTextField txtMaCV;
	private JTextField txtTenCV;
	private JButton btnThemCV;
	private JLabel lblMaBPC;
	private JTextField txtMaBPC;
	private JLabel lblTTMaCT;
	private JTextField txtTTMaCT;
	private JLabel lblSoNgay;
	private JTextField txtSoNgay;
	private JLabel lblNgayKC;
	private JTextField txtNgayKC;
	private JLabel lblGhiChu;
	private JTextField txtGhiChu;
	private JLabel lblMaCVTT;
	private JTextField txtMaCVTT;
	private DefaultTableModel dtm;
	private JTable table;
	private JScrollPane scrollTable;
	private Dao_NhanVien dao_NV = new Dao_NhanVien();
	private Dao_CongTrinh dao_CT = new Dao_CongTrinh();
	private JTextField txtNgayHT1;
	private Dao_CongViec dao_CV = new Dao_CongViec();
	private JLabel lblMaNV1;
	private JTextField txtMaNV1;
	private JButton btnThemDA;
	private JButton btnXoaDA;
	private JButton btnSuaDA;
	private JButton btnTimDA;
	private JButton btnXoaTrangCT;
	private JButton btnXoaTrangCV;
	private JComboBox<String> comboBoxTim;
	private Dao_BangPhanCong dao_BPC = new Dao_BangPhanCong();
	public Form_BangPhanCong() {
		setLayout(null);
		
		// ========== Nhân viên ========== //
		int x = 10, y = 10, width = 400, height = 220;
		JPanel pnNhanVien = new JPanel();
		pnNhanVien.setBounds(x,y,width, height);
		pnNhanVien.setBorder(BorderFactory.createTitledBorder("Nhập thông tin nhân viên"));
		TitledBorder titleNhanVien = (TitledBorder) pnNhanVien.getBorder();
		titleNhanVien.setTitleColor(Color.blue);
		pnNhanVien.setLayout(null);
		
		int xNV = 30, yNV = 30, wNV = 120, hNV = 20; 
		// Ma
		JLabel lblMaNv = new JLabel("Mã nhân viên:");
		pnNhanVien.add(lblMaNv);
		lblMaNv.setBounds(xNV, yNV, wNV, hNV);
		// Ten
		JLabel lblTenNV = new JLabel("Tên nhân viên:");
		lblTenNV.setBounds(xNV, yNV*2, wNV, hNV);
		pnNhanVien.add(lblTenNV);
		// CCCD
		JLabel lblCCCD = new JLabel("CCCD:");
		lblCCCD.setBounds(xNV, yNV*3, wNV, hNV);
		pnNhanVien.add(lblCCCD);
		// PB
		JLabel lblPB = new JLabel("Phòng ban:");
		lblPB.setBounds(xNV, yNV*4, wNV, hNV);
		pnNhanVien.add(lblPB);
		// GT
		JLabel lblGioiTinh = new JLabel("Giới tính:");
		lblGioiTinh.setBounds(xNV, yNV*5, wNV, hNV);
		pnNhanVien.add(lblGioiTinh);
		// Txt
		int xTxtNV = 160, wTxtNV = 210; 
		pnNhanVien.add(txtMaNV = new JTextField());
		txtMaNV.setBounds(xTxtNV, yNV, wTxtNV, hNV);
		
		pnNhanVien.add(txtTenNV = new JTextField());
		txtTenNV.setBounds(xTxtNV, yNV*2, wTxtNV, hNV);
		txtTenNV.setEditable(false);
		
		pnNhanVien.add(txtCCCD = new JTextField());
		txtCCCD.setBounds(xTxtNV, yNV*3+1, wTxtNV, hNV);
		txtCCCD.setEditable(false);
		
		pnNhanVien.add(txtPB = new JTextField());
		txtPB.setBounds(xTxtNV, yNV*4+1, wTxtNV, hNV);
		txtPB.setEditable(false);
		
		pnNhanVien.add(radNam = new JRadioButton("Nam"));
		radNam.setBounds(xTxtNV-5, yNV*5, 60, hNV);
		
		pnNhanVien.add(radNu = new JRadioButton("Nữ"));
		radNu.setBounds(xTxtNV+75, yNV*5, 60, hNV);
		
		grbSex = new ButtonGroup();
		grbSex.add(radNam);
		grbSex.add(radNu);
		radNam.setEnabled(false);
		radNu.setEnabled(false);

		btnLayTTNV = new JButton("Thêm nhân viên");
		btnLayTTNV.setBounds(30, 180, 150, 30);
		btnLayTTNV.setFont(new Font(getName(), Font.BOLD, 14));
		btnLayTTNV.setForeground(Color.LIGHT_GRAY);
		btnLayTTNV.setBackground(Color.DARK_GRAY);
		btnLayTTNV.setFocusPainted(false);
		pnNhanVien.add(btnLayTTNV);
		
		btnXoaTrangNV = new JButton("Xóa trắng");
		btnXoaTrangNV.setBounds(220, 180, 150, 30);
		btnXoaTrangNV.setFont(new Font(getName(), Font.BOLD, 14));
		btnXoaTrangNV.setForeground(Color.LIGHT_GRAY);
		btnXoaTrangNV.setBackground(Color.DARK_GRAY);
		btnXoaTrangNV.setFocusPainted(false);
		pnNhanVien.add(btnXoaTrangNV);
		
		add(pnNhanVien);
		
		// ========== Công trình ========== //
		
		JPanel pnCT = new JPanel();
		pnCT.setBorder(BorderFactory.createTitledBorder("Nhập thông tin công trình:"));
		TitledBorder titleCT = (TitledBorder) pnCT.getBorder();
		titleCT.setTitleColor(Color.blue);
		pnCT.setLayout(null);
		x = 420; y=10; width=400; height=220;
		pnCT.setBounds(x, y, width, height);
		
		pnCT.add(lblMaCT = new JLabel("Mã công trình:"));
		lblMaCT.setBounds(30, 30, 120, 20);
		pnCT.add(lblTenCT = new JLabel("Tên công trình:"));
		lblTenCT.setBounds(30, 60, 120, 20);
		pnCT.add(lblNgayKhoiCong = new JLabel("Ngày khởi công:"));
		lblNgayKhoiCong.setBounds(30, 90, 120, 20);
		pnCT.add(lblNgayHT = new JLabel("Ngày hoàn thành:"));
		lblNgayHT.setBounds(30, 120, 120, 20);
		
		pnCT.add(txtMaCT = new JTextField());
		txtMaCT.setBounds(160, 30, 210, 20);

		pnCT.add(txtTenCT = new JTextField());
		txtTenCT.setBounds(160, 60, 210, 20);
		txtTenCT.setEditable(false);
		
		pnCT.add(txtNgayKhoiCong = new JTextField());
		txtNgayKhoiCong.setBounds(160, 91, 210, 20);
		txtNgayKhoiCong.setEditable(false);
		
		pnCT.add(txtNgayHT = new JTextField());
		txtNgayHT.setBounds(160, 121, 210, 20);
		txtNgayHT.setEditable(false);
		
		btnThemCT = new JButton("Thêm công trình");
		btnThemCT.setBounds(30, 180, 150, 30);
		btnThemCT.setFont(new Font(getName(), Font.BOLD, 14));
		btnThemCT.setForeground(Color.LIGHT_GRAY);
		btnThemCT.setBackground(Color.DARK_GRAY);
		btnThemCT.setFocusPainted(false);
		pnCT.add(btnThemCT);
		
		btnXoaTrangCT = new JButton("Xóa trắng");
		btnXoaTrangCT.setBounds(220, 180, 150, 30);
		btnXoaTrangCT.setFont(new Font(getName(), Font.BOLD, 14));
		btnXoaTrangCT.setForeground(Color.LIGHT_GRAY);
		btnXoaTrangCT.setBackground(Color.DARK_GRAY);
		btnXoaTrangCT.setFocusPainted(false);
		pnCT.add(btnXoaTrangCT);
		
		add(pnCT);
		
		// ========== Công việc ========== //
		
		JPanel pnCV = new JPanel();
		pnCV.setBorder(BorderFactory.createTitledBorder("Loại công việc"));
		TitledBorder titleCV = (TitledBorder) pnCV.getBorder();
		titleCV.setTitleColor(Color.blue);
		pnCV.setLayout(null);
		pnCV.setBounds(830, 10, 340, 220);
		
		pnCV.add(lblMaCV = new JLabel("Mã công việc:"));
		lblMaCV.setBounds(30, 30, 90, 20);
		pnCV.add(lblTenCV = new JLabel("Tên công việc:"));
		lblTenCV.setBounds(30, 60, 90, 20);
		
		pnCV.add(txtMaCV = new JTextField());
		txtMaCV.setBounds(141, 30, 170, 20);
//		ArrayList<NhanVien> lsTenNV = nv.getAllNhanVien();
		pnCV.add(txtTenCV = new JTextField());
		txtTenCV.setBounds(141, 60, 170, 20);
		txtTenCV.setEditable(false);
		
		btnThemCV = new JButton("Thêm công việc");
		btnThemCV.setBounds(30, 180, 140, 30);
		btnThemCV.setFont(new Font(getName(), Font.BOLD, 14));
		btnThemCV.setForeground(Color.LIGHT_GRAY);
		btnThemCV.setBackground(Color.DARK_GRAY);
		btnThemCV.setFocusPainted(false);
		pnCV.add(btnThemCV);
		
		btnXoaTrangCV = new JButton("Xóa trắng");
		btnXoaTrangCV.setBounds(190, 180, 120, 30);
		btnXoaTrangCV.setFont(new Font(getName(), Font.BOLD, 14));
		btnXoaTrangCV.setForeground(Color.LIGHT_GRAY);
		btnXoaTrangCV.setBackground(Color.DARK_GRAY);
		btnXoaTrangCV.setFocusPainted(false);
		pnCV.add(btnXoaTrangCV);
		
		add(pnCV);
		
		
		// ============================================================================ //
		JPanel pnThongTin = new JPanel();
		pnThongTin.setLayout(null);
		pnThongTin.setBounds(5, 250, 1200, 60); 
		pnThongTin.add(lblMaBPC = new JLabel("Mã BPC:"));
		lblMaBPC.setBounds(10, 1, 50, 20);
		pnThongTin.add(txtMaBPC = new JTextField());
		txtMaBPC.setBounds(80, 1, 180, 20);
		
		pnThongTin.add(lblMaNV1 = new JLabel("Mã NV:"));
		lblMaNV1.setBounds(290, 1, 60, 20);
		pnThongTin.add(txtMaNV1 = new JTextField());
		txtMaNV1.setBounds(401, 1, 180, 20);
		txtMaNV1.setEditable(false);
		
		pnThongTin.add(lblTTMaCT = new JLabel("Mã CT:"));
		lblTTMaCT.setBounds(610, 1, 100, 20);
		pnThongTin.add(txtTTMaCT = new JTextField());
		txtTTMaCT.setBounds(710, 1, 180, 20);
		txtTTMaCT.setEditable(false);
		
		pnThongTin.add(lblMaCVTT = new JLabel("Mã CV:"));
		lblMaCVTT.setBounds(920, 1, 50, 20);
		pnThongTin.add(txtMaCVTT = new JTextField());
		txtMaCVTT.setBounds(984, 1, 180, 20);
		txtMaCVTT.setEditable(false);
		
		pnThongTin.add(lblSoNgay = new JLabel("Số ngày:"));
		lblSoNgay.setBounds(10, 29, 90, 20);
		pnThongTin.add(txtSoNgay = new JTextField());
		txtSoNgay.setBounds(80, 29, 180, 20);
		
		
		pnThongTin.add(lblNgayKC = new JLabel("Ngày bắt đầu:"));
		lblNgayKC.setBounds(290, 29, 100, 20);
		pnThongTin.add(txtNgayKC = new JTextField());
		txtNgayKC.setBounds(401, 29, 180, 20);

		pnThongTin.add(lblNgayHT = new JLabel("Ngày kết thúc:"));
		lblNgayHT.setBounds(610, 29, 90, 20);
		pnThongTin.add(txtNgayHT1 = new JTextField());
		txtNgayHT1.setBounds(710, 29, 180, 20);
		
		
		pnThongTin.add(lblGhiChu = new JLabel("Ghi chú:"));
		lblGhiChu.setBounds(920, 29, 70, 20);
		pnThongTin.add(txtGhiChu = new JTextField());
		txtGhiChu.setBounds(984, 29, 180, 20);

		add(pnThongTin);
		
		JPanel pnTable = new JPanel();
		pnTable.setBorder(BorderFactory.createTitledBorder("Chi tiết dự án"));
		TitledBorder titleChiTietDA = (TitledBorder) pnTable.getBorder();
		titleChiTietDA.setTitleColor(Color.blue);
		pnTable.setBounds(10, 320, 1160, 201);
		pnTable.setLayout(null);
		
		dtm = new DefaultTableModel();
		dtm.addColumn("MaBPC");
		dtm.addColumn("MaNV");
		dtm.addColumn("MaCT");
		dtm.addColumn("MaCV");
		dtm.addColumn("SoNgay");
		dtm.addColumn("NgayBatDau");
		dtm.addColumn("NgayKetThuc");
		dtm.addColumn("GhiChu");
		table = new JTable(dtm);
		table.setRowHeight(20);
		scrollTable = new JScrollPane(table);
		scrollTable.setBounds(9, 25, 1142, 165);
		pnTable.add(scrollTable);
		add(pnTable);
		
		JPanel pnControl = new JPanel();
		pnControl.setBounds(10, 530, 1200, 40);
		pnControl.setLayout(null);
		
		JLabel lblTim = new JLabel("Chọn mã BPC cần tìm:");
		pnControl.add(lblTim);
		lblTim.setBounds(0, 10, 170, 30);
		pnControl.add(comboBoxTim=new JComboBox<String>());
		updateComboBox();
		comboBoxTim.setBounds(150, 10, 170, 30);
		
		pnControl.add(btnTimDA = new JButton("Tìm dự án"));
		btnTimDA.setBounds(360, 10, 170, 30);
		btnTimDA.setFont(new Font(getName(), Font.BOLD, 14));
		btnTimDA.setForeground(Color.LIGHT_GRAY);
		btnTimDA.setBackground(Color.DARK_GRAY);
		btnTimDA.setFocusPainted(false);

		pnControl.add(btnThemDA = new JButton("Thêm dự án"));
		btnThemDA.setBounds(570, 10, 170, 30);
		btnThemDA.setFont(new Font(getName(), Font.BOLD, 14));
		btnThemDA.setForeground(Color.LIGHT_GRAY);
		btnThemDA.setBackground(Color.DARK_GRAY);
		btnThemDA.setFocusPainted(false);
		
		pnControl.add(btnSuaDA = new JButton("Sửa dự án"));
		btnSuaDA.setBounds(780, 10, 170, 30);
		btnSuaDA.setFont(new Font(getName(), Font.BOLD, 14));
		btnSuaDA.setForeground(Color.LIGHT_GRAY);
		btnSuaDA.setBackground(Color.DARK_GRAY);
		btnSuaDA.setFocusPainted(false);
		
		pnControl.add(btnXoaDA = new JButton("Xóa dự án"));
		btnXoaDA.setBounds(990, 10, 170, 30);
		btnXoaDA.setFont(new Font(getName(), Font.BOLD, 14));
		btnXoaDA.setForeground(Color.LIGHT_GRAY);
		btnXoaDA.setBackground(Color.DARK_GRAY);
		btnXoaDA.setFocusPainted(false);
		
		add(pnControl);     
		
		txtMaNV.addActionListener(this);
		txtMaCT.addActionListener(this);
		txtMaCV.addActionListener(this);
		btnLayTTNV.addActionListener(this);
		btnThemCT.addActionListener(this);
		btnThemCV.addActionListener(this);
		btnThemDA.addActionListener(this);
		btnTimDA.addActionListener(this);
		btnXoaDA.addActionListener(this);
		btnSuaDA.addActionListener(this);
		table.addMouseListener(this);
		
		
		updateTable();
		
		setSize(1200,700);
		setVisible(true);
		
	}
	
	public void layThongTinNV() throws SQLException {
		String maNV = txtMaNV.getText();
		try {
			String ten = dao_NV.getTenNVTheoMa(maNV);
			String cCCD = dao_NV.getCCCDNVTheoMa(maNV);
			String pB = dao_NV.getPBNVTheoMa(maNV);
			String gT = dao_NV.getGTNVTheoMa(maNV);
				
			if( ten != ""&&cCCD!=""&&pB!=""&&gT!="" )
			{
				txtTenNV.setText(ten);
				txtCCCD.setText(cCCD);
				txtPB.setText(pB);
				if(gT.equals("0"))
					radNu.setSelected(true);
				else
					radNam.setSelected(true);
			}		
			} catch (Exception e) {
		}
	}
	
	public void xoaTrangTTNV() {
		txtMaNV.setText("");
		txtTenNV.setText("");
		txtCCCD.setText("");
		txtPB.setText("");
	}
	public void layThongTinCT() throws SQLException {
		
					String maCT = txtMaCT.getText();
					
					
						
						String ten = dao_CT.getTenCTTheoMa(maCT);
						String ngayKC =dao_CT.getNgayKCCTTheoMa(maCT);
						String ngayHT =dao_CT.getNgayHTCTTheoMa(maCT);
						
						if( ten != "" )
						{
							txtTenCT.setText(ten);
							txtNgayKhoiCong.setText(ngayKC);
							txtNgayHT.setText(ngayHT);
							
						}
						
				
	}
	public void xoaTrangTTCT() {
		txtMaCT.setText("");
		txtTenCT.setText("");
		txtNgayKhoiCong.setText("");
		txtNgayHT.setText("");
	}
	public void layThongTinCV() throws SQLException {
		
		String maCV = txtMaCV.getText();
		
		
			
			String ten = dao_CV.getTenCVTheoMa(maCV);
			
			if( ten != "" )
			{
				txtTenCV.setText(ten);
				
			}
			
	
}
	public void xoaTrangTTCV() {
		txtMaCV.setText("");
		txtTenCV.setText("");
	}
	public void themNV() {
		if(txtMaNV.getText().length()>0) {
			txtMaNV1.setText(txtMaNV.getText());
		}
		else {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập mã nhân viên để định dạng nhân viên. VD: NV001");
			txtMaNV.requestFocus();
		}
	}
	public void themCT() {
		if(txtMaCT.getText().length()>0) {
			txtTTMaCT.setText(txtMaCT.getText());
			txtNgayKC.setText(txtNgayKhoiCong.getText());
			txtNgayHT1.setText(txtNgayHT.getText());
		}
		else {
JOptionPane.showMessageDialog(this, "Vui lòng nhập mã công việc để định dạng công trình. VD: CT001");
			txtMaCT.requestFocus();
		}
	}
	public void themCV() {
		if(txtMaCV.getText().length()>0) {
			txtMaCVTT.setText(txtMaCV.getText());
			
		}
		else {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập mã công việc để định dạng công việc. VD: CV001");
			txtMaCV.requestFocus();
		}
	}
	public boolean vaidliDate(){
		int i = -1;
		String maBPC = txtMaBPC.getText();
		String maNV =txtMaNV1.getText();
		String maCT = txtTTMaCT.getText();
		String maCV = txtMaCVTT.getText();
		int soNgay = Integer.parseInt(txtSoNgay.getText());
		Date ngayBatDau = Date.valueOf(txtNgayKC.getText());
		Date ngayHT = Date.valueOf(txtNgayHT1.getText());
		String ghichu = txtGhiChu.getText();
			Dao_BangPhanCong ds = new Dao_BangPhanCong();
			List<BangPhanCong> list = ds.getAllDuAn();
			for (BangPhanCong p : list) {
				if(p.getMaBPC().equals(maBPC)) {
					i=1;
				}}
			
		if(!(i!=1)) {
				JOptionPane.showMessageDialog(this,"Mã bảng phân công bị trùng");
				return false;
			}
		if(!((maBPC.length() > 0) && maBPC.matches("BPC\\d{3,10}"))) {
			JOptionPane.showMessageDialog(this, "Không được rỗng và Mã bảng phân công bắt đầu BPC và theo sau phải có 3-10 chữ số[BPC111]");
			return false;
		}
		if(!((maNV.length() > 0) )) {
			JOptionPane.showMessageDialog(this, "Mã nhân viên không được rỗng");
			return false;
		}
		if(!((maCT.length() > 0) )) {
			JOptionPane.showMessageDialog(this, "Mã công trình không được rỗng");
			return false;
		}
		if(!((maCV.length() > 0) )) {
			JOptionPane.showMessageDialog(this, "Mã công việc không được rỗng");
			return false;
		}
		if(!((txtNgayKC.getText().length() > 0) )) {
			JOptionPane.showMessageDialog(this, "Nhập ngày bắt đầu");
			return false;
		}
		if(!((txtNgayHT1.getText().length() > 0) )) {
			JOptionPane.showMessageDialog(this, "Nhập ngày kết thúc");
			return false;
		}
		if(!((txtSoNgay.getText().length() > 0)&& soNgay>=1 )) {
			JOptionPane.showMessageDialog(this, "Nhập số ngày và số ngày phải lớn hơn 0");
			return false;
		}
		if(!((txtGhiChu.getText().length() > 0) )) {
			JOptionPane.showMessageDialog(this, "Nhập ghi chú");
			return false;
		}
		return true;
			
	}
	private void them()throws SQLException {

		try {	
			int soNgay=Integer.parseInt(txtSoNgay.getText());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Lỗi nhập dữ liệu: không rỗng && số ngày có kiểu dữ liệu là int");
		}
		try {
			Date ngayBatDau=Date.valueOf(txtNgayKC.getText());
			Date ngayHT=Date.valueOf(txtNgayHT1.getText());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Lỗi nhập dữ liệu: không rỗng && ngày phải có định dạng Năm-Tháng-Ngày");
			// TODO: handle exception
		}
		try {
			String maBPC=txtMaBPC.getText();
			String maNV=txtMaNV1.getText();
			String maCT=txtTTMaCT.getText();
			String maCV=txtMaCVTT.getText();
			int soNgay=Integer.parseInt(txtSoNgay.getText());
			Date ngayBatDau=Date.valueOf(txtNgayKC.getText());
			Date ngayHT=Date.valueOf(txtNgayHT1.getText());
			String ghichu=txtGhiChu.getText();
			BangPhanCong bpc=new BangPhanCong(maBPC, new NhanVien(maNV), new CongTrinh(maCT), new CongViec(maCV), soNgay, ngayBatDau, ngayHT, ghichu);
			try {
				if(vaidliDate()){
					if(dao_BPC.createCT(bpc)) {
						String[] row= {maBPC,maNV,maCT,maCV,String.valueOf(soNgay),String.valueOf(ngayBatDau),String.valueOf(ngayHT),ghichu+""};
						dtm.addRow(row);
						comboBoxTim.removeAllItems();
						updateComboBox();
					}}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "NgayKhoiCong<=NgayBatDau<=NgayKetThuc && NgayBatDau<=NgayKetThuc<=NgayHoanThanh");
				// TODO: handle exception
			}	
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
	}
	public void xoaTrang() {
		txtMaBPC.setText("");
		txtMaNV1.setText("");
		txtTTMaCT.setText("");
		txtMaCVTT.setText("");
		txtSoNgay.setText("");
		txtNgayKC.setText("");
		txtNgayHT1.setText("");
		txtGhiChu.setText("");
	}
	private void sua() {
		int a=0;
		String maBPC = txtMaBPC.getText();
		String maNV = txtMaNV1.getText();
		String maCT = txtTTMaCT.getText();
		String maCV = txtMaCVTT.getText();
		int soNgay = Integer.parseInt(txtSoNgay.getText());
		Date ngayBatDau = Date.valueOf(txtNgayKC.getText());
		Date ngayHT = Date.valueOf(txtNgayHT1.getText());
		String ghichu = txtGhiChu.getText();

		BangPhanCong bpc = new BangPhanCong(maBPC, new NhanVien(maNV), new CongTrinh(maCT), new CongViec(maCV), soNgay, ngayBatDau, ngayHT, ghichu);
        for (int row = 0; row <= table.getRowCount() - 1; row++) {
            if (maBPC.equals(table.getValueAt(row, 0).toString())) {
          	  if(dao_BPC.update(bpc)) {
                // Nếu tìm thấy mã nhân viên, cập nhật tên nhân viên
          	  table.setValueAt(maNV, row, 1);
          	  table.setValueAt(maCT, row, 2);
          	  table.setValueAt(maCV, row, 3);
          	  table.setValueAt(soNgay, row, 4);
          	  table.setValueAt(ngayBatDau, row, 5);
          	  table.setValueAt(ngayHT, row, 6);
          	  table.setValueAt(ghichu, row, 7);
          	comboBoxTim.removeAllItems();
			updateComboBox();
          	  a=1;
                break;}
            }
        }
        if(a==0)
             JOptionPane.showMessageDialog(this, "Không có mã công trình muốn sữa");
        else
             JOptionPane.showMessageDialog(this, "Sữa thành công");
	}
	private void xoa() {
		int row=table.getSelectedRow();
		if (row == -1) {
			JOptionPane.showMessageDialog(this, "Chọn phân công cần xóa");
		} else {
			int hoiNhac;
			hoiNhac = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa phân công này không ?", "Chú ý",
					JOptionPane.YES_NO_OPTION);
			if (hoiNhac == JOptionPane.YES_OPTION) {
				String ma=table.getModel().getValueAt(row, 0).toString();
				try {
					if (dao_BPC.xoa(ma)) {
						dtm.removeRow(row);
						comboBoxTim.removeAllItems();
						updateComboBox();
						JOptionPane.showMessageDialog(this, "Xóa thành công");
					} else {
						JOptionPane.showMessageDialog(this, "Xóa không thành công. Lỗi không xác định");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void updateComboBox() {
		List<BangPhanCong> list=dao_BPC.getAllDuAn();
		for (BangPhanCong bangPhanCong : list) {
			comboBoxTim.addItem(bangPhanCong.getMaBPC());
		}
		
	}
	
	public void tim() {
		String searchValue = comboBoxTim.getSelectedItem().toString();
		 for (int row = 0; row <= table.getRowCount() - 1; row++) {
           if (searchValue.equals(table.getValueAt(row, 0).toString())) {
               // Nếu tìm thấy mã nhân viên, in thông tin nhân viên ra JTextField
        		txtMaBPC.setText(dtm.getValueAt(row, 0).toString());
        		txtMaNV1.setText(dtm.getValueAt(row, 1).toString());
        		txtMaNV.setText(dtm.getValueAt(row, 1).toString());
        		try {
        			layThongTinNV();
        		} catch (SQLException e1) {
        			// TODO Auto-generated catch block
        			e1.printStackTrace();
        		}
        		txtTTMaCT.setText(dtm.getValueAt(row, 2).toString());
        		txtMaCT.setText(dtm.getValueAt(row, 2).toString());
        		try {
        			layThongTinCT();
        		} catch (SQLException e1) {
        			// TODO Auto-generated catch block
        			e1.printStackTrace();
        		}
        		txtMaCVTT.setText(dtm.getValueAt(row, 3).toString());
        		txtMaCV.setText(dtm.getValueAt(row, 3).toString());
        		String ten;
        		try {
        			ten = dao_CV.getTenCVTheoMa(txtMaCV.getText());
        			if( ten != "" )
        			{
        				txtTenCV.setText(ten);
        				
        			}
        		} catch (SQLException e1) {
        			// TODO Auto-generated catch block
        			e1.printStackTrace();
        		}
        		txtSoNgay.setText(dtm.getValueAt(row, 4).toString());
        		txtNgayKC.setText(dtm.getValueAt(row, 5).toString());
        		txtNgayHT1.setText(dtm.getValueAt(row, 6).toString());
        		txtGhiChu.setText(dtm.getValueAt(row, 7).toString());
          	 break;
           }
       }
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
		txtMaBPC.setText(dtm.getValueAt(row, 0).toString());
		txtMaNV1.setText(dtm.getValueAt(row, 1).toString());
		txtMaNV.setText(dtm.getValueAt(row, 1).toString());
		try {
			layThongTinNV();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		txtTTMaCT.setText(dtm.getValueAt(row, 2).toString());
		txtMaCT.setText(dtm.getValueAt(row, 2).toString());
		try {
			layThongTinCT();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		txtMaCVTT.setText(dtm.getValueAt(row, 3).toString());
		txtMaCV.setText(dtm.getValueAt(row, 3).toString());
		String ten;
		try {
			ten = dao_CV.getTenCVTheoMa(txtMaCV.getText());
			if( ten != "" )
			{
				txtTenCV.setText(ten);
				
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		txtSoNgay.setText(dtm.getValueAt(row, 4).toString());
		txtNgayKC.setText(dtm.getValueAt(row, 5).toString());
		txtNgayHT1.setText(dtm.getValueAt(row, 6).toString());
		txtGhiChu.setText(dtm.getValueAt(row, 7).toString());
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	private void updateTable() {
		Dao_BangPhanCong ds = new Dao_BangPhanCong();
		List<BangPhanCong> list=ds.getAllDuAn();
		for (BangPhanCong p : list) {
			String[] row = { p.getMaBPC(), p.getNhanVien().getMaNV(),p.getCongTrinh().getMaCT(),p.getCongViec().getMaCongViec(),String.valueOf(p.getSoNgayCongThamGia()),String.valueOf(p.getNgayBatDau()),String.valueOf(p.getNgayKetThuc()),p.getGhiChu()};
			dtm.addRow(row);
		}
		table.setModel(dtm);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o=e.getSource();
		if(o==txtMaNV) {
			try {
				layThongTinNV();
				if(txtTenNV.getText().length()>0)
					JOptionPane.showMessageDialog(null, "Tìm thấy dữ liệu Nhân viên!!");
				else {
					txtMaNV.setText("");
					txtMaNV.requestFocus();
					JOptionPane.showMessageDialog(null, "Không tìm thấy thông tin. Mã nhân viên không hợp lệ. MaNV có định dạng:(NV[0-9]{3,10})!!");
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		if(o==txtMaCT) {
			try {
				layThongTinCT();
				if(txtTenCT.getText().length()>0)
					JOptionPane.showMessageDialog(null, "Tìm thấy dữ liệu công trình!!");
				else {
					JOptionPane.showMessageDialog(null, "Không tìm thấy thông tin. Mã công trình không hợp lệ. MaCT có định dạng:(CT[0-9]{3,10})!!");
					txtMaCT.setText("");
					txtMaCT.requestFocus();
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		if(o==txtMaCV) {
			try {
				layThongTinCV();
				if(txtTenCV.getText().length()>0)
					JOptionPane.showMessageDialog(null, "Tìm thấy dữ liệu công việc");
				else {
					JOptionPane.showMessageDialog(null, "Không tìm thấy thông tin. Mã công việc không hợp lệ. MaCV có định dạng:(CV[0-9]{3,10})!!");
					txtMaCV.setText("");
					txtMaCV.requestFocus();
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		if(o==btnLayTTNV) {
			themNV();
		}
		if(o==btnThemCT) {
			themCT();
		}
		if(o==btnThemCV) {
			themCV();
		}
		if(o==btnThemDA) {
			try {
				them();
				xoaTrangTTNV();
				xoaTrangTTCT();
				xoaTrangTTCV();
				xoaTrang();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		if(o==btnSuaDA) {
			sua();
			xoaTrangTTNV();
			xoaTrangTTCT();
			xoaTrangTTCV();
			xoaTrang();
		}
		if(o==btnXoaDA) {
			xoa();
			xoaTrangTTNV();
			xoaTrangTTCT();
			xoaTrangTTCV();
			xoaTrang();
		}
		if(o==btnTimDA) {
			tim();
		}
	}
}