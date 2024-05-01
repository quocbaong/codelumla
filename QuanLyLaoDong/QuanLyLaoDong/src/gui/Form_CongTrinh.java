package gui;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.sql.SQLException;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

import dao.Dao_CongTrinh;
import entity.CongTrinh;

public class Form_CongTrinh extends JPanel implements ActionListener, MouseListener {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTextField txtMaCT;
	private JTextField txtTenCT;
	private JTextField txtDiaDiem;
	private JTextField txtNgayCapPhep;
	private JTextField txtNgayKhoiCong;
	private JTextField txtNgayHoanThanh;
	private DefaultTableModel dtm;
	private JButton btnTim;
	private JButton btnXoa;
	private JButton btnSua;
	private JButton btnThem;
	private Dao_CongTrinh congTrinh_DAO = new Dao_CongTrinh();
	private JScrollPane scrollTable;
	private JTextField txtTim;
	private JButton btnXoaTrang;
	

	public Form_CongTrinh() {
		setLayout(null);

		// ========== Công trình ========== //
		int x = 10, y = 10, width = 570, height = 220;
		JPanel pnCongTrinh = new JPanel();
		pnCongTrinh.setBounds(x, y, width, height);
		pnCongTrinh.setBorder(BorderFactory.createTitledBorder("Nhập thông tin công trình"));
		TitledBorder titleNhanVien = (TitledBorder) pnCongTrinh.getBorder();
		titleNhanVien.setTitleColor(Color.BLUE);
		pnCongTrinh.setLayout(null);

		int xCT = 30, yCT = 30, wCT = 120, hCT = 20;
		// Mã công trình
		JLabel lblMaCT = new JLabel("Mã công trình:");
		pnCongTrinh.add(lblMaCT);
		lblMaCT.setBounds(xCT, yCT, wCT, hCT);
		// Tên công trình
		JLabel lblTenCT = new JLabel("Tên công trình:");
		lblTenCT.setBounds(xCT, yCT * 2, wCT, hCT);
		pnCongTrinh.add(lblTenCT);
		// Địa điểm
		JLabel lblDiaDiem = new JLabel("Địa điểm:");
		lblDiaDiem.setBounds(xCT, yCT * 3, wCT, hCT);
		pnCongTrinh.add(lblDiaDiem);
		// Ngày cấp phép
		JLabel lblNCP = new JLabel("Ngày cấp phép:");
		lblNCP.setBounds(xCT, yCT * 4, wCT, hCT);
		pnCongTrinh.add(lblNCP);
		// Ngày khởi công
		JLabel lblNKC = new JLabel("Ngày khởi công:");
		lblNKC.setBounds(xCT, yCT * 5, wCT, hCT);
		pnCongTrinh.add(lblNKC);
		// Ngày hoàn thành
		JLabel lblNHT = new JLabel("Ngày hoàn thành:");
		lblNHT.setBounds(xCT, yCT * 6, wCT, hCT);
		pnCongTrinh.add(lblNHT);

		// Txt
		int xTxtCT = 160, wTxtCT = 380;
		pnCongTrinh.add(txtMaCT = new JTextField());
		txtMaCT.setBounds(xTxtCT, yCT, wTxtCT, hCT);

		pnCongTrinh.add(txtTenCT = new JTextField());
		txtTenCT.setBounds(xTxtCT, yCT * 2, wTxtCT, hCT);

		pnCongTrinh.add(txtDiaDiem = new JTextField());
		txtDiaDiem.setBounds(xTxtCT, yCT * 3 + 1, wTxtCT, hCT);

		pnCongTrinh.add(txtNgayCapPhep = new JTextField());
		txtNgayCapPhep.setBounds(xTxtCT, yCT * 4 + 1, wTxtCT, hCT);

		pnCongTrinh.add(txtNgayKhoiCong = new JTextField());
		txtNgayKhoiCong.setBounds(xTxtCT, yCT * 5, wTxtCT, hCT);

		pnCongTrinh.add(txtNgayHoanThanh = new JTextField());
		txtNgayHoanThanh.setBounds(xTxtCT, yCT * 6 + 1, wTxtCT, hCT);

		// ========== Chuc nang ========== //
		JPanel panelChucNang = new JPanel();
		panelChucNang.setLayout(null);
		panelChucNang.setBounds(x + width + 20, y, width, height);
		panelChucNang.setBorder(BorderFactory.createTitledBorder("Các chức năng"));
		TitledBorder titledchucnang = (TitledBorder) panelChucNang.getBorder();
		titledchucnang.setTitleColor(Color.blue);
		add(panelChucNang);

		JLabel lblTim = new JLabel("Tìm kiếm");
		lblTim.setFont(new Font(getName(), Font.BOLD, 24));
		panelChucNang.add(lblTim);
		lblTim.setBounds(235, 30, 150, 30);

		JLabel lblNhapTT = new JLabel("Nhập mã công trình:");
		panelChucNang.add(lblNhapTT);
		lblNhapTT.setBounds(30, 75, 150, 20);
		panelChucNang.add(txtTim = new JTextField());
		txtTim.setBounds(160, 75, wTxtCT - 135, 20);

		panelChucNang.add(btnTim = new JButton("Tìm"));
		btnTim.setFont(new Font(getName(), Font.BOLD, 14));
		btnTim.setForeground(Color.LIGHT_GRAY);
		btnTim.setBackground(Color.DARK_GRAY);
		btnTim.setFocusPainted(false);
		btnTim.setBounds(160 + wTxtCT - 170 + 50, 71, 120, 25);

		JLabel lblCN = new JLabel("Chức năng");
		lblCN.setFont(new Font(getName(), Font.BOLD, 24));
		panelChucNang.add(lblCN);
		lblCN.setBounds(225, 120, 150, 30);

		panelChucNang.add(btnThem = new JButton("Thêm"));
		btnThem.setFont(new Font(getName(), Font.BOLD, 14));
		btnThem.setForeground(Color.LIGHT_GRAY);
		btnThem.setBackground(Color.DARK_GRAY);
		btnThem.setFocusPainted(false);
		btnThem.setBounds(30, 170, 100, 30);

		panelChucNang.add(btnXoa = new JButton("Xóa"));
		btnXoa.setFont(new Font(getName(), Font.BOLD, 14));
		btnXoa.setForeground(Color.LIGHT_GRAY);
		btnXoa.setBackground(Color.DARK_GRAY);
		btnXoa.setFocusPainted(false);
		btnXoa.setBounds(168, 170, 100, 30);

		panelChucNang.add(btnXoaTrang = new JButton("Xóa trắng"));
		btnXoaTrang.setFont(new Font(getName(), Font.BOLD, 14));
		btnXoaTrang.setForeground(Color.LIGHT_GRAY);
		btnXoaTrang.setBackground(Color.DARK_GRAY);
		btnXoaTrang.setFocusPainted(false);
		btnXoaTrang.setBounds(303, 170, 100, 30);

		panelChucNang.add(btnSua = new JButton("Sửa"));
		btnSua.setFont(new Font(getName(), Font.BOLD, 14));
		btnSua.setForeground(Color.LIGHT_GRAY);
		btnSua.setBackground(Color.DARK_GRAY);
		btnSua.setFocusPainted(false);
		btnSua.setBounds(440, 170, 100, 30);
		add(pnCongTrinh);

		JLabel ds = new JLabel("Danh sách công trình");
		ds.setFont(new Font(getName(), Font.BOLD, 24));
		add(ds);
		ds.setBounds(465, 260, 250, 30);

		dtm = new DefaultTableModel();
		dtm.addColumn("Mã công trình");
		dtm.addColumn("Tên công trình");
		dtm.addColumn("Địa điểm");
		dtm.addColumn("Ngày cấp phép");
		dtm.addColumn("Ngày khởi công");
		dtm.addColumn("Ngày hoàn thành");
		table = new JTable(dtm);
		table.setRowHeight(20);
		scrollTable = new JScrollPane(table);
		scrollTable.setBounds(11, 320, 1159, 250);
//		pnTable.add(scrollTable);
		add(scrollTable);

		btnThem.addActionListener(this);
		btnSua.addActionListener(this);
		btnTim.addActionListener(this);
		btnXoa.addActionListener(this);

		btnXoaTrang.addActionListener(this);
		table.addMouseListener(this);

		updateTable();

		setSize(1200, 700);
		setVisible(true);
	}

	public void loadData() {
		congTrinh_DAO = new Dao_CongTrinh();
		for (CongTrinh p : congTrinh_DAO.getAllCongTrinh()) {
			Object[] row = { p.getMaCT(), p.getTenCT(), p.getDiaDiem(), p.getNgayCapPhep(), p.getNgayKhoiCong(),
					p.getNgayHT() };
			dtm.addRow(row);
		}
		table.setModel(dtm);
	}
	private void updateTable() {
		Dao_CongTrinh ds = new Dao_CongTrinh();
		List<CongTrinh> list = ds.getAllCongTrinh();
		for (CongTrinh p : list) {
			String[] row = { p.getMaCT(), p.getTenCT(), p.getDiaDiem(), String.valueOf(p.getNgayCapPhep()),
					String.valueOf(p.getNgayKhoiCong()), p.getNgayHT() + "" };
			dtm.addRow(row);
		}
		table.setModel(dtm);
	}

	private void them() throws SQLException {
		try {
			String ma = txtMaCT.getText();
			String ten = txtTenCT.getText();
			String diaChi = txtDiaDiem.getText();
			Date ngayCapPhep = Date.valueOf(txtNgayCapPhep.getText());
			Date ngayKhoiCong = Date.valueOf(txtNgayKhoiCong.getText());
			Date ngayHoaThanh = Date.valueOf(txtNgayHoanThanh.getText());

			CongTrinh ct = new CongTrinh(ma, ten, diaChi, ngayCapPhep, ngayKhoiCong, ngayHoaThanh);
			if (vaidliDate()) {
				if (congTrinh_DAO.createCT(ct)) {
					String[] row = { ma, ten, diaChi, String.valueOf(ngayCapPhep), String.valueOf(ngayKhoiCong),
							ngayHoaThanh + "" };
					dtm.addRow(row);
				}
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Lỗi nhập dữ liệu cho ngày phải có định dạng Năm-Tháng-Ngày");
		}

	}

	private void xoaTrang() {
		txtMaCT.setText("");
		txtTenCT.setText("");
		txtDiaDiem.setText("");
		txtNgayCapPhep.setText("");
		txtNgayKhoiCong.setText("");
		txtNgayHoanThanh.setText("");
	}

	private void xoa() {
		int row = table.getSelectedRow();
		if (row == -1) {
			JOptionPane.showMessageDialog(this, "Chọn công trình cần xóa");
		} else {
			int hoiNhac;
			hoiNhac = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa công trình này không ?", "Chú ý",
					JOptionPane.YES_NO_OPTION);
			if (hoiNhac == JOptionPane.YES_OPTION) {
				String ma = table.getModel().getValueAt(row, 0).toString();
				try {
					if (congTrinh_DAO.xoa(ma)) {
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
		String id = txtMaCT.getText();
		String ten = txtTenCT.getText();
		String diaDiem = txtDiaDiem.getText();
		Date ngayCapPhep = Date.valueOf(txtNgayCapPhep.getText());
		Date ngayKhoiCong = Date.valueOf(txtNgayKhoiCong.getText());
		Date ngayHoaThanh = Date.valueOf(txtNgayHoanThanh.getText());
		CongTrinh ct = null;
		ct = new CongTrinh(id, ten, diaDiem, ngayCapPhep, ngayKhoiCong, ngayHoaThanh);
		for (int row = 0; row <= table.getRowCount() - 1; row++) {
			if (id.equals(table.getValueAt(row, 0).toString())) {
				if (congTrinh_DAO.update(ct)) {
					// Nếu tìm thấy mã nhân viên, cập nhật tên nhân viên
					table.setValueAt(ten, row, 1);
					table.setValueAt(diaDiem, row, 2);
					table.setValueAt(ngayCapPhep, row, 3);
					table.setValueAt(ngayKhoiCong, row, 4);
					table.setValueAt(ngayHoaThanh, row, 5);
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

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
		txtMaCT.setText(dtm.getValueAt(row, 0).toString());
		txtTenCT.setText(dtm.getValueAt(row, 1).toString());
		txtDiaDiem.setText(dtm.getValueAt(row, 2).toString());
		txtNgayCapPhep.setText(dtm.getValueAt(row, 3).toString());
		txtNgayKhoiCong.setText(dtm.getValueAt(row, 4).toString());
		txtNgayHoanThanh.setText(dtm.getValueAt(row, 5).toString());
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

	public void tim() {
		int i = 0;
		String searchValue = txtTim.getText();
		for (int row = 0; row <= table.getRowCount() - 1; row++) {
			if (searchValue.equals(table.getValueAt(row, 0).toString())) {
				// Nếu tìm thấy mã nhân viên, in thông tin nhân viên ra JTextField
				txtMaCT.setText(table.getValueAt(row, 0).toString());
				txtTenCT.setText(table.getValueAt(row, 1).toString());
				txtDiaDiem.setText(table.getValueAt(row, 2).toString());
				txtNgayCapPhep.setText(table.getValueAt(row, 3).toString());
				txtNgayKhoiCong.setText(table.getValueAt(row, 4).toString());
				txtNgayHoanThanh.setText(table.getValueAt(row, 5).toString());
				i = 1;
				break;
			}
		}
		if (i != 0) {
			JOptionPane.showMessageDialog(this, "Có Công trình cần tìm");
			return;
		} else {
			JOptionPane.showMessageDialog(this, "Không có công trình cần tìm");
			return;
		}
	}

	public boolean vaidliDate() {
		int i = -1;
		String id = txtMaCT.getText();
		String ten = txtTenCT.getText();
		String diaDiem = txtDiaDiem.getText();
		Date ngayCapPhep = Date.valueOf(txtNgayCapPhep.getText());
		Date ngayKhoiCong = Date.valueOf(txtNgayKhoiCong.getText());
		Date ngayHoaThanh = Date.valueOf(txtNgayHoanThanh.getText());
		Dao_CongTrinh ds = new Dao_CongTrinh();
		List<CongTrinh> list = ds.getAllCongTrinh();
		for (CongTrinh p : list) {
			if (p.getMaCT().equals(id)) {
				i = 1;
			}
		}
		if (!(i != 1)) {
			JOptionPane.showMessageDialog(this, "Mã Công trình bị trùng");
		}
		if (!((id.length() > 0) && id.matches("CT\\d{3,10}"))) {
			JOptionPane.showMessageDialog(this,
					"Không được rỗng và Mã Công trình bắt dầu CT và theo sau phải có 3-10 chữ số[CT111]");
			return false;
		}
		if (!((ten.length() > 0) && ten.matches("Công trình(\\s{1}[a-zA-Z]+)+"))) {
			JOptionPane.showMessageDialog(this,
					"Không được rỗng và Tên công trình bắt đầu Công trình và theo sau là chữ cái [Công trình A]");
			return false;
		}
		if (!((diaDiem.length() > 0) && diaDiem.matches("Địa điểm(\\s{1}[a-zA-Z]+)+"))) {
			JOptionPane.showMessageDialog(this,
					"Không được rỗng và Tên công trình bắt đầu Địa điểm và theo sau là chữ cái [Địa điểm A]");
			return false;
		}
		int ktncp = 0;
		if (ngayCapPhep.after(ngayKhoiCong))
			ktncp = 1;
		if (!((txtNgayCapPhep.getText().length() > 0) && ktncp != 1)) {
			JOptionPane.showMessageDialog(this, "Không được rỗng và ngày cấp phép phải sau ngày khởi công");
			return false;
		}
		int ktnkc = 0;
		if (ngayKhoiCong.after(ngayHoaThanh))
			ktnkc = 1;

		if (!((txtNgayKhoiCong.getText().length() > 0) && ktnkc != 1)) {
			JOptionPane.showMessageDialog(this, "Không được rỗng và ngày khởi công phải sau ngày hoàn thành");
			return false;
		}
		return true;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o == btnThem) {
			try {
				them();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		if (o == btnXoa) {
			xoa();
		}
		if (o == btnXoaTrang) {
			xoaTrang();
		}
		if (o == btnSua) {
			sua();
		}
		if (o == btnTim) {
			tim();
		}
	}
}
