package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import dao.Dao_NhanVien;
import entity.NhanVien;
import entity.PhongBan;

public class Form_ThongTinCaNhan extends JPanel implements ActionListener{
	public String user;
	public String mk;
	private JButton btnSua;
	private JTextField txtMa;
	private JTextField txtTen;
	private JTextField txtNgaySinh;
	private JTextField txtGioiTinh;
	private JTextField txtSdt;
	private JTextField txtCCCD;
	private JTextField txtTamTru;
	private JTextField txtThuongTru;
	private JTextField txtChucVu;
	private JTextField txtPhongBan;
	private Dao_NhanVien daoNV = new Dao_NhanVien();
	private JButton btnSave;

	public Form_ThongTinCaNhan() {
		setLayout(null);
		// Avatar
		JPanel avatar = new JPanel();
		avatar.setBackground(Color.GRAY);
		avatar.setBounds(30, 38, 150, 180);
		JLabel anh = new JLabel();
		anh.setIcon(new ImageIcon(getClass().getResource("/image/Profile-Avatar-PNG.png")));
		avatar.add(anh);
		add(avatar);
		
		btnSua = new JButton("Chỉnh sửa hồ sơ");
		btnSua.setFont(new Font(getName(), Font.BOLD, 14));
		btnSua.setForeground(Color.LIGHT_GRAY);
		btnSua.setBackground(Color.DARK_GRAY);
		btnSua.setFocusPainted(false);
		btnSua.setBounds(30, 235, 150, 40);
		add(btnSua);
		
		btnSave = new JButton("Lưu");
		btnSave.setFont(new Font(getName(), Font.BOLD, 14));
		btnSave.setForeground(Color.LIGHT_GRAY);
		btnSave.setBackground(Color.DARK_GRAY);
		btnSave.setFocusPainted(false);
		btnSave.setBounds(30, 288, 150, 40);
		add(btnSave);
		// Thông tin
		int x = 200, y = 30, width = 950, height = 300;
		JPanel thongTin = new JPanel();
		thongTin.setBounds(x, y, width, height);
		thongTin.setBorder(BorderFactory.createTitledBorder("Thông tin cá nhân"));
		TitledBorder title = (TitledBorder) thongTin.getBorder();
		title.setTitleColor(Color.BLUE);
		thongTin.setLayout(null);
		
		Font font = new Font(getName(), Font.PLAIN, 16);
		Font fontTF = new Font(getName(), Font.BOLD, 16);
		
		int xTT = 30, yTT = 50, wTT = 120, hTT = 20, wTF = 220; 
		// Mã nhân viên
		JLabel lblMaNV = new JLabel("Mã nhân viên:");
		thongTin.add(lblMaNV);
		lblMaNV.setBounds(xTT, yTT, wTT, hTT);
		lblMaNV.setFont(font);
		
		txtMa = new JTextField("21070721");
		txtMa.setBorder(null);
		txtMa.setForeground(Color.BLACK);
		txtMa.setEnabled(false);
		txtMa.setEditable(false);
		txtMa.setBounds(xTT + wTT, yTT, wTF, hTT);
		txtMa.setFont(fontTF);
		thongTin.add(txtMa);
		
		// Tên nhân viên
		JLabel lblTenNV = new JLabel("Tên nhân viên:");
		lblTenNV.setBounds(xTT, yTT*2, wTT, hTT);
		thongTin.add(lblTenNV);
		lblTenNV.setFont(font);
		
		txtTen = new JTextField("Lê Văn Tấn Thông");
		txtTen.setBorder(null);
		txtTen.setForeground(Color.BLACK);
		txtTen.setEnabled(false);
		txtTen.setEditable(false);
		txtTen.setBounds(xTT + wTT, yTT*2, wTF, hTT);
		txtTen.setFont(fontTF);
		thongTin.add(txtTen);
		
		// Ngày sinh
		JLabel lblNgaySinh = new JLabel("Ngày sinh:");
		lblNgaySinh.setBounds(xTT, yTT*3, wTT, hTT);
		thongTin.add(lblNgaySinh);
		lblNgaySinh.setFont(font);
		
		txtNgaySinh = new JTextField("2003-02-26");
		txtNgaySinh.setBorder(null);
		txtNgaySinh.setForeground(Color.BLACK);
		txtNgaySinh.setEnabled(false);
		txtNgaySinh.setEditable(false);
		txtNgaySinh.setBounds(xTT + wTT, yTT*3, wTF, hTT);
		txtNgaySinh.setFont(fontTF);
		thongTin.add(txtNgaySinh);
		
		// Giới tính
		JLabel lblGioiTinh = new JLabel("Giới tính:");
		lblGioiTinh.setBounds(xTT, yTT*4, wTT, hTT);
		thongTin.add(lblGioiTinh);
		lblGioiTinh.setFont(font);
		
		txtGioiTinh = new JTextField("Nam");
		txtGioiTinh.setBorder(null);
		txtGioiTinh.setForeground(Color.BLACK);
		txtGioiTinh.setEnabled(false);
		txtGioiTinh.setEditable(false);
		txtGioiTinh.setBounds(xTT + wTT, yTT*4, wTF, hTT);
		txtGioiTinh.setFont(fontTF);
		thongTin.add(txtGioiTinh);
		
		// Số điện thoại
		JLabel lblSdt = new JLabel("Số điện thoại:");
		lblSdt.setBounds(xTT, yTT*5, wTT, hTT);
		thongTin.add(lblSdt);
		lblSdt.setFont(font);
		
		txtSdt = new JTextField("0348807764");
		txtSdt.setBorder(null);
		txtSdt.setForeground(Color.BLACK);
		txtSdt.setEnabled(false);
		txtSdt.setEditable(false);
		txtSdt.setBounds(xTT + wTT, yTT*5, wTF, hTT);
		txtSdt.setFont(fontTF);
		thongTin.add(txtSdt);
		
		// Căn cước công dân
		JLabel lblCCCD = new JLabel("Căn cước công dân:");
		lblCCCD.setBounds(width / 2 + 30, yTT, wTT + 50, hTT);
		thongTin.add(lblCCCD);
		lblCCCD.setFont(font);
		
		txtCCCD = new JTextField("079203012615");
		txtCCCD.setBorder(null);
		txtCCCD.setForeground(Color.BLACK);
		txtCCCD.setEnabled(false);
		txtCCCD.setEditable(false);
		txtCCCD.setBounds(width / 2 + wTT + 70, yTT, wTF, hTT);
		txtCCCD.setFont(fontTF);
		thongTin.add(txtCCCD);
		
		// Địa chỉ tạm trú
		JLabel lblDiaChiTamTru = new JLabel("Địa chỉ tạm trú:");
		lblDiaChiTamTru.setBounds(width / 2 + 30, yTT*2, wTT + 50, hTT);
		thongTin.add(lblDiaChiTamTru);
		lblDiaChiTamTru.setFont(font);
		
		txtTamTru = new JTextField("238,Nguyễn Thị Nê, ấp Phú Hiệp");
		txtTamTru.setBorder(null);
		txtTamTru.setForeground(Color.BLACK);
		txtTamTru.setEnabled(false);
		txtTamTru.setEditable(false);
		txtTamTru.setBounds(width / 2 + wTT + 70, yTT*2, wTF + 30, hTT);
		txtTamTru.setFont(fontTF);
		thongTin.add(txtTamTru);
		
		// Địa chỉ thường trú
		JLabel lblDiaChiThuongTru = new JLabel("Địa chỉ thường trú:");
		lblDiaChiThuongTru.setBounds(width / 2 + 30, yTT*3, wTT + 50, hTT);
		thongTin.add(lblDiaChiThuongTru);
		lblDiaChiThuongTru.setFont(font);
		
		txtThuongTru = new JTextField("238,Nguyễn Thị Nê, ấp Phú Hiệp");
		txtThuongTru.setBorder(null);
		txtThuongTru.setForeground(Color.BLACK);
		txtThuongTru.setEnabled(false);
		txtThuongTru.setEditable(false);
		txtThuongTru.setBounds(width / 2 + wTT + 70, yTT*3, wTF + 30, hTT);
		txtThuongTru.setFont(fontTF);
		thongTin.add(txtThuongTru);
		
		// Chức vụ
		JLabel lblChucVu = new JLabel("Chức vụ:");
		lblChucVu.setBounds(width / 2 + 30, yTT*4, wTT + 50, hTT);
		thongTin.add(lblChucVu);
		lblChucVu.setFont(font);
		
		txtChucVu = new JTextField("Trưởng phòng");
		txtChucVu.setBorder(null);
		txtChucVu.setForeground(Color.BLACK);
		txtChucVu.setEnabled(false);
		txtChucVu.setEditable(false);
		txtChucVu.setBounds(width / 2 + wTT + 70, yTT*4, wTF, hTT);
		txtChucVu.setFont(fontTF);
		thongTin.add(txtChucVu);
		
		// Phòng ban
		JLabel lblPB = new JLabel("Phòng ban:");
		lblPB.setBounds(width / 2 + 30, yTT*5, wTT + 50, hTT);
		thongTin.add(lblPB);
		lblPB.setFont(font);
		
		txtPhongBan = new JTextField("PB001");
		txtPhongBan.setBorder(null);
		txtPhongBan.setForeground(Color.BLACK);
		txtPhongBan.setEnabled(false);
		txtPhongBan.setEditable(false);
		txtPhongBan.setBounds(width / 2 + wTT + 70, yTT*5, wTF, hTT);
		txtPhongBan.setFont(fontTF);
		thongTin.add(txtPhongBan);
		
		add(thongTin);
		
		btnSua.addActionListener(this);
		btnSave.addActionListener(this);
		
		setData();
		setSize(1200, 700);
		setVisible(true);
	}
	
	public void setData() {
		NhanVien nv = daoNV.timKiemTheoMa("NV001");
		txtMa.setText(nv.getMaNV());
		txtTen.setText(nv.getTenNV());
		txtNgaySinh.setText(nv.getNgaySinh().toString());
		txtGioiTinh.setText((nv.isGioiTinh() == true) ? "Nam" : "Nữ");
		txtSdt.setText(nv.getSdt());
		txtCCCD.setText(nv.getCccd());
		txtTamTru.setText(nv.getDiaChiTamTru());
		txtThuongTru.setText(nv.getDiaCHiThuongTru());
		txtChucVu.setText(nv.getChucVu());
		txtPhongBan.setText(nv.getPhongBan().getMaPB());
	}
	
	public void setEnableTrue() {
		txtTen.setEditable(true);
		txtTen.setEnabled(true);
		txtNgaySinh.setEditable(true);
		txtNgaySinh.setEnabled(true);
		txtSdt.setEditable(true);
		txtSdt.setEnabled(true);
		txtGioiTinh.setEditable(true);
		txtGioiTinh.setEnabled(true);
		txtCCCD.setEditable(true);
		txtCCCD.setEnabled(true);
		txtTamTru.setEditable(true);
		txtTamTru.setEnabled(true);
		txtThuongTru.setEditable(true);
		txtThuongTru.setEnabled(true);
		txtChucVu.setEditable(true);
		txtChucVu.setEnabled(true);
		txtPhongBan.setEditable(true);
		txtPhongBan.setEnabled(true);
	}
	
	public void setEnableFalse() {
		txtTen.setEditable(false);
		txtTen.setEnabled(false);
		txtNgaySinh.setEditable(false);
		txtNgaySinh.setEnabled(false);
		txtSdt.setEditable(false);
		txtSdt.setEnabled(false);
		txtGioiTinh.setEditable(false);
		txtGioiTinh.setEnabled(false);
		txtCCCD.setEditable(false);
		txtCCCD.setEnabled(false);
		txtTamTru.setEditable(false);
		txtTamTru.setEnabled(false);
		txtThuongTru.setEditable(false);
		txtThuongTru.setEnabled(false);
		txtChucVu.setEditable(false);
		txtChucVu.setEnabled(false);
		txtPhongBan.setEditable(false);
		txtPhongBan.setEnabled(false);
	}
	
	private void sua() {
		boolean gt;
		if (txtGioiTinh.getText() == "Nam")
			gt = false;
		else
			gt = true;
		String ma = txtMa.getText();
		String ten = txtTen.getText();
		Date ngaySinh = Date.valueOf(txtNgaySinh.getText());
		String sdt = txtSdt.getText();
		boolean gioiTinh = gt;
		String cCCD = txtCCCD.getText();
		String diaChiTamTru = txtTamTru.getText();
		String diaChiThuongTru = txtThuongTru.getText();
		String chucVu = txtChucVu.getText();
		String phongBan = txtPhongBan.getText();
		NhanVien nv = new NhanVien(ma, ten, ngaySinh, gioiTinh, sdt, cCCD, diaChiTamTru, diaChiThuongTru, chucVu, new PhongBan(phongBan));
		if (daoNV.update(nv)) {
			txtTen.setText(txtTen.getText());
			txtNgaySinh.setText(txtNgaySinh.getText());
			txtSdt.setText(txtSdt.getText());
			txtGioiTinh.setText(txtGioiTinh.getText()) ;
			txtCCCD.setText(txtCCCD.getText());
			txtTamTru.setText(txtTamTru.getText());
			txtThuongTru.setText(txtThuongTru.getText());
			txtChucVu.setText(txtChucVu.getText());
			txtPhongBan.setText(txtPhongBan.getText());
			JOptionPane.showMessageDialog(this, "Sửa thành công");
		}
		else
			JOptionPane.showMessageDialog(this, "Sửa không thành công");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o == btnSua) {
			setEnableTrue();
		}
		if(o == btnSave) {
			setEnableFalse();
			sua();
	
		}
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
	
	
}
