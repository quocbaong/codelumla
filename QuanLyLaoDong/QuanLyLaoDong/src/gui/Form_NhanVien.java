package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import dao.Dao_CongTrinh;
import dao.Dao_NhanVien;
import entity.CongTrinh;
import entity.NhanVien;
import entity.PhongBan;

public class Form_NhanVien extends JPanel implements ActionListener, MouseListener {

	private static final long serialVersionUID = 1L;
	private DefaultTableModel dtm;
	private JTable table;
	private Dao_NhanVien nhanVien_DAO = new Dao_NhanVien();
	private JTextField txtTen;
	private JTextField txtMa;
	private JTextField txtNgaySinh;
	private JComboBox<String> txtGioiTinh;
	private JTextField txtSdt;
	private JTextField txtCccd;
	private JTextField txtDcTamTru;
	private JTextField txtDcThuongTru;
	private JTextField txtChucVu;
	private JComboBox<String> txtMaPB;
	private JButton btnThem;
	private JButton btnXoa;
	private JButton btnSua;
	private JButton btnTim;
	private JTextField txtTim;
	private JScrollPane scrollTable;

	public Form_NhanVien() {
		setLayout(null);
		// Thông tin
		int x = 10, y = 10, width = 1160, height = 230;
		JPanel thongTin = new JPanel();
		thongTin.setBounds(x, y, width, height);
		thongTin.setBorder(BorderFactory.createTitledBorder("Thông tin cá nhân"));
		TitledBorder title = (TitledBorder) thongTin.getBorder();
		title.setTitleColor(Color.BLUE);
		thongTin.setLayout(null);

		int xTT = 30, yTT = 36, wTT = 120, hTT = 20, wTF = 360;
		// Mã nhân viên
		JLabel lblMaNV = new JLabel("Mã nhân viên:");
		thongTin.add(lblMaNV);
		lblMaNV.setBounds(xTT, yTT, wTT, hTT);

		txtMa = new JTextField();
		txtMa.setBounds(xTT + wTT, yTT, wTF, hTT);
		thongTin.add(txtMa);

		// Tên nhân viên
		JLabel lblTenNV = new JLabel("Tên nhân viên:");
		lblTenNV.setBounds(xTT, yTT * 2, wTT, hTT);
		thongTin.add(lblTenNV);

		txtTen = new JTextField();
		txtTen.setBounds(xTT + wTT, yTT * 2, wTF, hTT);
		thongTin.add(txtTen);

		// Ngày sinh
		JLabel lblNgaySinh = new JLabel("Ngày sinh:");
		lblNgaySinh.setBounds(xTT, yTT * 3, wTT, hTT);
		thongTin.add(lblNgaySinh);

		txtNgaySinh = new JTextField();
		txtNgaySinh.setBounds(xTT + wTT, yTT * 3, wTF, hTT);
		thongTin.add(txtNgaySinh);

		// Giới tính
		JLabel lblGioiTinh = new JLabel("Giới tính:");
		lblGioiTinh.setBounds(xTT, yTT * 4 + 1, wTT, hTT);
		thongTin.add(lblGioiTinh);

		String[] gt = { "Nam", "Nữ" };
		txtGioiTinh = new JComboBox<String>(gt);
		txtGioiTinh.setBounds(xTT + wTT, yTT * 4 + 1, wTF, hTT);
		thongTin.add(txtGioiTinh);

		// Số điện thoại
		JLabel lblSdt = new JLabel("Số điện thoại:");
		lblSdt.setBounds(xTT, yTT * 5 + 1, wTT, hTT);
		thongTin.add(lblSdt);

		txtSdt = new JTextField();
		txtSdt.setBounds(xTT + wTT, yTT * 5 + 1, wTF, hTT);
		thongTin.add(txtSdt);

		// Căn cước công dân
		JLabel lblCCCD = new JLabel("Căn cước công dân:");
		lblCCCD.setBounds(width / 2 + 30, yTT, wTT + 50, hTT);
		thongTin.add(lblCCCD);

		txtCccd = new JTextField();
		txtCccd.setBounds(width / 2 + wTT + 70, yTT, wTF, hTT);
		thongTin.add(txtCccd);

		// Địa chỉ tạm trú
		JLabel lblDiaChiTamTru = new JLabel("Địa chỉ tạm trú:");
		lblDiaChiTamTru.setBounds(width / 2 + 30, yTT * 2, wTT + 50, hTT);
		thongTin.add(lblDiaChiTamTru);

		txtDcTamTru = new JTextField();
		txtDcTamTru.setBounds(width / 2 + wTT + 70, yTT * 2, wTF, hTT);
		thongTin.add(txtDcTamTru);

		// Địa chỉ thường trú
		JLabel lblDiaChiThuongTru = new JLabel("Địa chỉ thường trú:");
		lblDiaChiThuongTru.setBounds(width / 2 + 30, yTT * 3, wTT + 50, hTT);
		thongTin.add(lblDiaChiThuongTru);

		txtDcThuongTru = new JTextField();
		txtDcThuongTru.setBounds(width / 2 + wTT + 70, yTT * 3, wTF, hTT);
		thongTin.add(txtDcThuongTru);

		// Chức vụ
		JLabel lblChucVu = new JLabel("Chức vụ:");
		lblChucVu.setBounds(width / 2 + 30, yTT * 4 + 1, wTT + 50, hTT);
		thongTin.add(lblChucVu);

		txtChucVu = new JTextField();
		txtChucVu.setBounds(width / 2 + wTT + 70, yTT * 4 + 1, wTF, hTT);
		thongTin.add(txtChucVu);

		// Phòng ban
		JLabel lblPB = new JLabel("Phòng ban:");
		lblPB.setBounds(width / 2 + 30, yTT * 5 + 1, wTT + 50, hTT);
		thongTin.add(lblPB);
		String[] pb = { "PB001", "PB002", "PB003", "PB004", "PB005", "PB006", "PB007" };
		txtMaPB = new JComboBox<String>(pb);
		txtMaPB.setBounds(width / 2 + wTT + 70, yTT * 5 + 1, wTF, hTT);
		thongTin.add(txtMaPB);

		add(thongTin);

		JPanel pnControl = new JPanel();
		pnControl.setBounds(10, yTT * 7, 1200, 40);
		pnControl.setLayout(null);

		JLabel lblTim = new JLabel("Nhập mã nhân viên:");
		pnControl.add(lblTim);
		lblTim.setBounds(0, 10, 170, 30);
		pnControl.add(txtTim = new JTextField());
		txtTim.setBounds(150, 10, 170, 30);

		pnControl.add(btnTim = new JButton("Tìm"));
		btnTim.setBounds(360, 10, 170, 30);
		btnTim.setFont(new Font(getName(), Font.BOLD, 14));
		btnTim.setForeground(Color.LIGHT_GRAY);
		btnTim.setBackground(Color.DARK_GRAY);
		btnTim.setFocusPainted(false);

		pnControl.add(btnThem = new JButton("Thêm"));
		btnThem.setBounds(570, 10, 170, 30);
		btnThem.setFont(new Font(getName(), Font.BOLD, 14));
		btnThem.setForeground(Color.LIGHT_GRAY);
		btnThem.setBackground(Color.DARK_GRAY);
		btnThem.setFocusPainted(false);

		pnControl.add(btnSua = new JButton("Sửa"));
		btnSua.setBounds(780, 10, 170, 30);
		btnSua.setFont(new Font(getName(), Font.BOLD, 14));
		btnSua.setForeground(Color.LIGHT_GRAY);
		btnSua.setBackground(Color.DARK_GRAY);
		btnSua.setFocusPainted(false);

		pnControl.add(btnXoa = new JButton("Xóa"));
		btnXoa.setBounds(990, 10, 170, 30);
		btnXoa.setFont(new Font(getName(), Font.BOLD, 14));
		btnXoa.setForeground(Color.LIGHT_GRAY);
		btnXoa.setBackground(Color.DARK_GRAY);
		btnXoa.setFocusPainted(false);

		add(pnControl);

		JLabel ds = new JLabel("Danh sách công trình");
		ds.setFont(new Font(getName(), Font.BOLD, 24));
		add(ds);
		ds.setBounds(465, 260, 250, 30);

		dtm = new DefaultTableModel();
		dtm.addColumn("Mã nhân viên");
		dtm.addColumn("Tên nhân viên");
		dtm.addColumn("Ngày sinh");
		dtm.addColumn("Giới tính");
		dtm.addColumn("Số điện thoại");
		dtm.addColumn("CCCD");
		dtm.addColumn("Địa chỉ tạm trú");
		dtm.addColumn("Địa chỉ thường trú");
		dtm.addColumn("Chức vụ");
		dtm.addColumn("Mã phòng ban");

		table = new JTable(dtm);
		table.setRowHeight(20);
		scrollTable = new JScrollPane(table);
		scrollTable.setBounds(11, 320, 1159, 250);
		add(scrollTable);

		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnSua.addActionListener(this);
		btnTim.addActionListener(this);
		table.addMouseListener(this);

		loadData();

		setSize(1200, 700);
		setVisible(true);
	}

	public void loadData() {
		for (NhanVien nv : nhanVien_DAO.getAllNhanVien()) {
			String gt = "";
			if (nv.isGioiTinh())
				gt = "Nam";
			else
				gt = "Nữ";
			Object[] row = { nv.getMaNV(), nv.getTenNV(), nv.getNgaySinh(), gt, nv.getSdt(), nv.getCccd(),
					nv.getDiaChiTamTru(), nv.getDiaCHiThuongTru(), nv.getChucVu(), nv.getPhongBan().getMaPB() };
			dtm.addRow(row);
		}
	}

	private void them() throws SQLException {
		try {
			boolean gt;
			if (txtGioiTinh.getSelectedItem().toString() == "Nam")
				gt = true;
			else
				gt = false;
			String ma = txtMa.getText();
			String ten = txtTen.getText();
			Date ngaySinh = Date.valueOf(txtNgaySinh.getText());
			String sdt = txtSdt.getText();
			boolean gioiTinh = gt;
			String cCCD = txtCccd.getText();
			String diaChiTamTru = txtDcTamTru.getText();
			String diaChiThuongTru = txtDcThuongTru.getText();
			String chucVu = txtChucVu.getText();
			String phongBan = txtMaPB.getSelectedItem().toString();

			NhanVien nv = new NhanVien(ma, ten, ngaySinh, gioiTinh, sdt, cCCD, diaChiTamTru, diaChiThuongTru, chucVu,new PhongBan(phongBan));
			if(vaidliDate()) {
			if (nhanVien_DAO.createCT(nv)) {
				String[] row = { ma, ten, String.valueOf(ngaySinh),
				String.valueOf(txtGioiTinh.getSelectedItem().toString()), sdt, cCCD, diaChiTamTru, diaChiThuongTru, chucVu, phongBan };
				dtm.addRow(row);
				JOptionPane.showMessageDialog(this, "Thêm thành công");
			}}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Lỗi nhập dữ liệu");
		}

	}

	private void xoa() {
		int row = table.getSelectedRow();
		if (row == -1) {
			JOptionPane.showMessageDialog(this, "Chọn Nhân viên cần xóa");
		} else {
			int hoiNhac;
			hoiNhac = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa nhân viên này không ?", "Chú ý",
					JOptionPane.YES_NO_OPTION);
			if (hoiNhac == JOptionPane.YES_OPTION) {
				String ma = table.getModel().getValueAt(row, 0).toString();
				try {
					if (nhanVien_DAO.deleteNV(ma)) {
						dtm.removeRow(row);
						JOptionPane.showMessageDialog(this, "Xóa thành công");
					} else {
						JOptionPane.showMessageDialog(this, "Xóa không thành công. Lỗi không xác định");
					}
				} catch (HeadlessException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	private void sua() {
		int a = 0;
		boolean gt;
		if (txtGioiTinh.getSelectedItem().toString() == "Nam")
			gt = true;
		else
			gt = false;
		String ma = txtMa.getText();
		String ten = txtTen.getText();
		Date ngaySinh = Date.valueOf(txtNgaySinh.getText());
		String sdt = txtSdt.getText();
		boolean gioiTinh = gt;
		String cCCD = txtCccd.getText();
		String diaChiTamTru = txtDcTamTru.getText();
		String diaChiThuongTru = txtDcThuongTru.getText();
		String chucVu = txtChucVu.getText();
		String phongBan = txtMaPB.getSelectedItem().toString();
		NhanVien nv = new NhanVien(ma, ten, ngaySinh, gioiTinh, sdt, cCCD, diaChiTamTru, diaChiThuongTru, chucVu,
				new PhongBan(phongBan));
		for (int row = 0; row <= table.getRowCount() - 1; row++) {
			if (ma.equals(table.getValueAt(row, 0).toString())) {
				if (nhanVien_DAO.update(nv)) {
					// Nếu tìm thấy mã nhân viên, cập nhật tên nhân viên
					table.setValueAt(ten, row, 1);
					table.setValueAt(ngaySinh, row, 2);
					table.setValueAt(txtGioiTinh.getSelectedItem().toString(), row, 3);
					table.setValueAt(sdt, row, 4);
					table.setValueAt(cCCD, row, 5);
					table.setValueAt(diaChiTamTru, row, 6);
					table.setValueAt(diaChiThuongTru, row, 7);
					table.setValueAt(chucVu, row, 8);
					table.setValueAt(phongBan, row, 9);

					a = 1;
					break;
				}
			}
		}
		if (a == 0)
			JOptionPane.showMessageDialog(this, "Không có mã công trình muốn sữa");
		else
			JOptionPane.showMessageDialog(this, "Sữa thành công");
	}

	public void tim() {
		int i = 0;
		String searchValue = txtTim.getText();
		for (int row = 0; row <= table.getRowCount() - 1; row++) {
			if (searchValue.equals(table.getValueAt(row, 0).toString())) {
				// Nếu tìm thấy mã nhân viên, in thông tin nhân viên ra JTextField
				txtMa.setText(dtm.getValueAt(row, 0).toString());
				txtTen.setText(dtm.getValueAt(row, 1).toString());
				txtNgaySinh.setText(dtm.getValueAt(row, 2).toString());
				txtGioiTinh.setSelectedItem(dtm.getValueAt(row, 3));
				txtSdt.setText(dtm.getValueAt(row, 4).toString());
				txtCccd.setText(dtm.getValueAt(row, 5).toString());
				txtDcTamTru.setText(dtm.getValueAt(row, 6).toString());
				txtDcThuongTru.setText(dtm.getValueAt(row, 7).toString());
				txtChucVu.setText(dtm.getValueAt(row, 8).toString());
				txtMaPB.setSelectedItem(dtm.getValueAt(row, 9));
				i = 1;
				break;
			}
		}
		if (i != 0) {
			JOptionPane.showMessageDialog(this, "Có nhân viên cần tìm");
			return;
		} else {
			JOptionPane.showMessageDialog(this, "Không có nhân viên cần tìm");
			return;
		}
	}

	public void xoaTrang() {
		txtMa.setText("");
		txtTen.setText("");
		txtNgaySinh.setText("");
		txtGioiTinh.setSelectedItem("");
		txtSdt.setText("");
		txtCccd.setText("");
		txtDcTamTru.setText("");
		txtDcThuongTru.setText("");
		txtChucVu.setText("");
		txtMaPB.setSelectedItem("");
	}

	public boolean vaidliDate() {
		int i = -1;
		boolean gt;
		if (txtGioiTinh.getSelectedItem().toString() == "Nam")
			gt = true;
		else
			gt = false;
		String id = txtMa.getText();
		String ten = txtTen.getText();
		Date ngaySinh = Date.valueOf(txtNgaySinh.getText());
		boolean gioiTinh = gt;
		String sdt = txtSdt.getText();
		String cccd = txtCccd.getText();
		String dcTamTru = txtDcTamTru.getText();
		String dcThuongTru = txtDcThuongTru.getText();
		String chucVu = txtChucVu.getText();
		String maPB = txtMaPB.getSelectedItem().toString();
		NhanVien nv = new NhanVien(maPB, ten, ngaySinh, gioiTinh, sdt, cccd, dcTamTru, dcThuongTru, chucVu, new PhongBan(maPB));
		Dao_NhanVien ds = new Dao_NhanVien();
		
		List<NhanVien> list = ds.getAllNhanVien();
		for (NhanVien p : list) {
			if (p.getMaNV().equals(id)) {
				i = 1;
			}
		}
		if (i == 1) {
			JOptionPane.showMessageDialog(this, "Mã nhân viên bị trùng");
		}
		if (!((id.length() > 0) && id.matches("^(NV)\\d{3,10}"))) {
			JOptionPane.showMessageDialog(this,
					"Không được rỗng và mã nhân viên bắt dầu NV và theo sau phải có 3-10 chữ số [NV1111...]");
			return false;
		}
		if (!((ten.length() > 0) && ten.matches("([A-Z][a-z]+\\s?)+"))) {
			JOptionPane.showMessageDialog(this,
					"Không được rỗng và Tên phải in hoa chữ cái đầu");
			return false;
		}
		if (!((dcTamTru.length() > 0) && dcTamTru.matches("([A-Z][a-z]+\\s?)+"))) {
			JOptionPane.showMessageDialog(this,
					"Không được rỗng và địa chỉ tạm trú phải in hoa chữ cái đầu");
			return false;
		}
		if (!((dcThuongTru.length() > 0) && dcThuongTru.matches("([A-Z][a-z]+\\s?)+"))) {
			JOptionPane.showMessageDialog(this,
					"Không được rỗng và địa chỉ thường trú phải in hoa chữ cái đầu");
			return false;
		}
//		if (!((chucVu.length() > 0) && chucVu.matches(""))) {
//			JOptionPane.showMessageDialog(this,
//					"Không được rỗng và địa chỉ thường trú phải in hoa chữ cái đầu");
//			return false;
//		}
		if (!((sdt.length() > 0) && sdt.matches("\\d{10}"))) {
			JOptionPane.showMessageDialog(this,
				"Không được rỗng và số điện thoại phải có đủ 10 số");
			return false;
		}
		if (!((cccd.length() > 0) && cccd.matches("\\d{10}"))) {
			JOptionPane.showMessageDialog(this,
				"Không được rỗng và căn cước công dân phải có đủ 10 số");
			return false;
		}
		return true;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = table.getSelectedRow();
		txtMa.setText(dtm.getValueAt(row, 0).toString());
		txtTen.setText(dtm.getValueAt(row, 1).toString());
		txtNgaySinh.setText(dtm.getValueAt(row, 2).toString());
		txtGioiTinh.setSelectedItem(dtm.getValueAt(row, 3));
		txtSdt.setText(dtm.getValueAt(row, 4).toString());
		txtCccd.setText(dtm.getValueAt(row, 5).toString());
		txtDcTamTru.setText(dtm.getValueAt(row, 6).toString());
		txtDcThuongTru.setText(dtm.getValueAt(row, 7).toString());
		txtChucVu.setText(dtm.getValueAt(row, 8).toString());
		txtMaPB.setSelectedItem(dtm.getValueAt(row, 9));
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o == btnThem) {
			try {
				them();
				xoaTrang();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(this, "Mã trùng");
			}
		}
		if (o == btnXoa) {
			xoa();
			xoaTrang();
		}
		if (o == btnSua) {
			sua();
			xoaTrang();
		}
		if (o == btnTim)
			tim();
	}
}
