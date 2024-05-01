package gui;

import java.awt.BorderLayout;
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
import java.sql.Time;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import dao.Dao_CongViec;
import dao.Dao_LichLamViec;
import dao.Dao_NhanVien;
import entity.CongViec;
import entity.LichLamViec;
import entity.NhanVien;

public class Form_LichLamViec extends JPanel implements ActionListener, MouseListener {

	private DefaultTableModel model;
	private JTable table;
	private Font font;
	private JTextField txtMaLichLV;
	private JComboBox<String> comboBoxMaNV;
	private JComboBox<String> comboBoxMaCV;
	private JTextField txtNgayLam;
	private JTextField txtThoiGianLam;
	private JTextField txtTim;
	private JButton btnTim;
	private JButton btnThem;
	private JButton btnXoa;
	private JButton btnXoaTrang;
	private JButton btnSua;
	private Dao_LichLamViec dsLLV = new Dao_LichLamViec();

	public Form_LichLamViec() {
		setLayout(null);
		JPanel panelNorth = new JPanel();
		add(panelNorth);
		panelNorth.setBounds(100, 10, 970, 50);
		JLabel lblTitle;
		panelNorth.add(lblTitle = new JLabel("Lịch làm việc"));
		lblTitle.setFont(new Font("Arial", Font.BOLD, 25));
		lblTitle.setForeground(new Color(0, 40, 255));

		JPanel panelCenter = new JPanel();
		add(panelCenter, BorderLayout.CENTER);
		panelCenter.setBounds(10, 60, 1162, 290);

		// Bảng
		model = new DefaultTableModel();
		model.addColumn("Mã lịch làm việc");
		model.addColumn("Mã nhân viên");
		model.addColumn("Mã công việc");
		model.addColumn("Ngày làm");
		model.addColumn("Thời gian làm");
		table = new JTable(model);
		table.setRowHeight(20);
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		JScrollPane pane = new JScrollPane(table);
		panelCenter.add(pane);
		pane.setPreferredSize(new Dimension(1160, 270));

		JPanel panelSouth = new JPanel();
		panelSouth.setBounds(10, 352, 570, 220);
		panelSouth.setBorder(BorderFactory.createTitledBorder("Thông tin lịch làm việc"));
		TitledBorder titledthongtin = (TitledBorder) panelSouth.getBorder();
		titledthongtin.setTitleColor(Color.blue);
		panelSouth.setLayout(null);
		add(panelSouth);

		int x = 30, y = 35, wl = 150, h = 20, wt = 360, xt = 180;
		JLabel lblMaLichLV = new JLabel("Mã lịch làm việc:");
		panelSouth.add(lblMaLichLV);
		lblMaLichLV.setBounds(x, y, wl, h);
		font = new Font("Arial", Font.PLAIN, 16);
		lblMaLichLV.setFont(font);
		panelSouth.add(txtMaLichLV = new JTextField());
		txtMaLichLV.setBounds(xt, y + 1, wt, h);
		txtMaLichLV.setFont(font);

		JLabel lblMaNV = new JLabel("Mã nhân viên:");
		panelSouth.add(lblMaNV);
		lblMaNV.setBounds(x, y * 2, wl, h);
		lblMaNV.setFont(font);
		panelSouth.add(comboBoxMaNV = new JComboBox<String>());
		comboBoxMaNV.setBounds(xt, y * 2 + 1, wt, h);
		updateComBoBoxNV();

		JLabel lblMaCV = new JLabel("Mã Công việc:");
		panelSouth.add(lblMaCV);
		lblMaCV.setBounds(x, y * 3, wl, h);
		lblMaCV.setFont(font);
		panelSouth.add(comboBoxMaCV = new JComboBox<String>());
		comboBoxMaCV.setBounds(xt, y * 3 + 2, wt, h);
		updateComBoBoxCV();

		JLabel lblNgayLam = new JLabel("Ngày làm:");
		panelSouth.add(lblNgayLam);
		lblNgayLam.setBounds(x, y * 4, wl, h);
		lblNgayLam.setFont(font);
		panelSouth.add(txtNgayLam = new JTextField());
		txtNgayLam.setBounds(xt, y * 4, wt, h);
		txtNgayLam.setFont(font);

		JLabel lblThoiGianLam = new JLabel("Thời gian làm:");
		panelSouth.add(lblThoiGianLam);
		lblThoiGianLam.setBounds(x, y * 5, wl, h);
		lblThoiGianLam.setFont(font);
		panelSouth.add(txtThoiGianLam = new JTextField());
		txtThoiGianLam.setBounds(xt, y * 5, wt, h);
		txtThoiGianLam.setFont(font);

		// chức năng
		JPanel panelChucNang = new JPanel();
		panelChucNang.setLayout(null);
		panelChucNang.setBounds(600, 352, 570, 220);
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
		txtTim.setBounds(160, 76, 245, 20);

		panelChucNang.add(btnTim = new JButton("Tìm"));
		btnTim.setFont(new Font(getName(), Font.BOLD, 14));
		btnTim.setForeground(Color.LIGHT_GRAY);
		btnTim.setBackground(Color.DARK_GRAY);
		btnTim.setFocusPainted(false);
		btnTim.setBounds(160 + 260, 71, 120, 25);

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

		updateTable();
		table.addMouseListener(this);
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnSua.addActionListener(this);
		btnTim.addActionListener(this);
		btnXoaTrang.addActionListener(this);
		setSize(1200, 700);
		setVisible(true);
	}

	private void updateTable() {
		Dao_LichLamViec ds = new Dao_LichLamViec();
		List<LichLamViec> list = ds.getAllLichLamViec();
		for (LichLamViec p : list) {
			String[] row = { p.getMalich(), p.getNhanVien().getMaNV(), p.getCongViec().getMaCongViec(),
					String.valueOf(p.getNgayLam()), p.getThoiGianLam() + "" };
			model.addRow(row);
		}
		table.setModel(model);
	}

	public void updateComBoBoxNV() {
		Dao_NhanVien dsNV = new Dao_NhanVien();
		List<NhanVien> list = dsNV.getAllNhanVien();
		for (NhanVien ds : list) {
			comboBoxMaNV.addItem(ds.getMaNV());
		}
	}

	public void updateComBoBoxCV() {
		Dao_CongViec dsCV = new Dao_CongViec();
		List<CongViec> list = dsCV.getAllCongViec();
		for (CongViec ds : list) {
			comboBoxMaCV.addItem(ds.getMaCongViec());
		}
	}

//	public void them() throws SQLException {
//
//		try {
//			Time tGLam = Time.valueOf(txtThoiGianLam.getText());
//		} catch (Exception e) {
//			JOptionPane.showMessageDialog(this,
//					"Lỗi nhập dữ liệu: không rỗng && thời gian làm có có định dạng 08:00:00");
//		}
//		try {
//			Date ngayLam = Date.valueOf(txtNgayLam.getText());
//
//		} catch (Exception e) {
//			JOptionPane.showMessageDialog(this,
//					"Lỗi nhập dữ liệu: không rỗng && ngày phải có định dạng Năm-Tháng-Ngày");
//			// TODO: handle exception
//		}
//		try {
//			String maLLV = txtMaLichLV.getText();
//			String maNV = comboBoxMaNV.getSelectedItem().toString();
//			String maCV = comboBoxMaCV.getSelectedItem().toString();
//			Date ngayLam = Date.valueOf(txtNgayLam.getText());
//			Time tGLam = Time.valueOf(txtThoiGianLam.getText());
//
//			LichLamViec lLV = new LichLamViec(maLLV, new NhanVien(maNV), new CongViec(maCV), ngayLam, tGLam);
//			try {
//
//				if (dsLLV.createCT(lLV)) {
//					String[] row = { maLLV, maNV, maCV, String.valueOf(ngayLam), tGLam + "" };
//					model.addRow(row);
//				}
//			} catch (Exception e) {
//				JOptionPane.showMessageDialog(this,
//						"NgayKhoiCong<=NgayBatDau<=NgayKetThuc && NgayBatDau<=NgayKetThuc<=NgayHoanThanh");
//				// TODO: handle exception
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//
//	}
	
	public void them() throws SQLException {
	    try {
	        Time tGLam = Time.valueOf(txtThoiGianLam.getText());
	        
	        // Kiểm tra thời gian làm phải từ 07:00:00 đến 17:00:00
	        Time gioBatDau = Time.valueOf("07:00:00");
	        Time gioKetThuc = Time.valueOf("17:00:00");
	        if (tGLam.before(gioBatDau) || tGLam.after(gioKetThuc)) {
	            JOptionPane.showMessageDialog(this, "Thời gian làm việc phải từ 07:00:00 đến 17:00:00");
	            return; 
	        }
	    } catch (Exception e) {
	        JOptionPane.showMessageDialog(this, "Lỗi nhập dữ liệu: không rỗng && thời gian làm có định dạng 08:00:00");
	        return; 
	    }

	    try {
	        Date ngayLam = Date.valueOf(txtNgayLam.getText());

	        // Kiểm tra ngày làm phải lớn hơn ngày hiện tại
	        Date ngayHienTai = new Date(System.currentTimeMillis());
	        if (ngayLam.before(ngayHienTai)) {
	            JOptionPane.showMessageDialog(this, "Ngày làm phải sau ngày hiện tại");
	            return; 
	        }
	    } catch (Exception e) {
	        JOptionPane.showMessageDialog(this, "Lỗi nhập dữ liệu: không rỗng && ngày phải có định dạng Năm-Tháng-Ngày");
	        return; 
	    }

	    try {
	        String maLLV = txtMaLichLV.getText();
	        String maNV = comboBoxMaNV.getSelectedItem().toString();
	        String maCV = comboBoxMaCV.getSelectedItem().toString();
	        Date ngayLam = Date.valueOf(txtNgayLam.getText());
	        Time tGLam = Time.valueOf(txtThoiGianLam.getText());

	        LichLamViec lLV = new LichLamViec(maLLV, new NhanVien(maNV), new CongViec(maCV), ngayLam, tGLam);

	        try {
	            if (dsLLV.createCT(lLV)) {
	                String[] row = {maLLV, maNV, maCV, String.valueOf(ngayLam), tGLam + ""};
	                model.addRow(row);
	                JOptionPane.showMessageDialog(this, "Thêm thành công");
	            }
	        } catch (Exception e) {
	            JOptionPane.showMessageDialog(this,
	                    "NgayKhoiCong<=NgayBatDau<=NgayKetThuc && NgayBatDau<=NgayKetThuc<=NgayHoanThanh");
	        }
	    } catch (Exception e) {
	        JOptionPane.showMessageDialog(this, "Trùng mã");
	    }
	}


	private void sua() {
		int a = 0;
		String maLLV = txtMaLichLV.getText();
		String maNV = comboBoxMaNV.getSelectedItem().toString();
		String maCV = comboBoxMaCV.getSelectedItem().toString();
		Date ngayLam = Date.valueOf(txtNgayLam.getText());
		Time tGLam = Time.valueOf(txtThoiGianLam.getText());

		LichLamViec lLV = new LichLamViec(maLLV, new NhanVien(maNV), new CongViec(maCV), ngayLam, tGLam);
		for (int row = 0; row <= table.getRowCount() - 1; row++) {
			if (maLLV.equals(table.getValueAt(row, 0).toString())) {
				if (dsLLV.update(lLV)) {
					// Nếu tìm thấy mã nhân viên, cập nhật tên nhân viên
					table.setValueAt(maNV, row, 1);
					table.setValueAt(maCV, row, 2);
					table.setValueAt(ngayLam, row, 3);
					table.setValueAt(tGLam, row, 4);

					a = 1;
					break;
				}
			}
		}
		if (a == 0)
			JOptionPane.showMessageDialog(this, "Không có mã lịch muốn sữa");
		else
			JOptionPane.showMessageDialog(this, "Sữa thành công");
	}

	private void xoa() {
		int row = table.getSelectedRow();
		if (row == -1) {
			JOptionPane.showMessageDialog(this, "Chọn lịch làm việc cần xóa");
		} else {
			int hoiNhac;
			hoiNhac = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa phân công này không ?", "Chú ý",
					JOptionPane.YES_NO_OPTION);
			if (hoiNhac == JOptionPane.YES_OPTION) {
				String ma = table.getModel().getValueAt(row, 0).toString();
				try {
					if (dsLLV.xoa(ma)) {
						model.removeRow(row);

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

	public void tim() {
		String searchValue = txtTim.getText();
		for (int row = 0; row <= table.getRowCount() - 1; row++) {
			if (searchValue.equals(table.getValueAt(row, 0).toString())) {
				// Nếu tìm thấy mã nhân viên, in thông tin lich lam viec ra JTextField
				txtMaLichLV.setText(model.getValueAt(row, 0).toString());
				comboBoxMaNV.setSelectedItem(model.getValueAt(row, 1));
				comboBoxMaCV.setSelectedItem(model.getValueAt(row, 2));
				txtNgayLam.setText(model.getValueAt(row, 3).toString());
				txtThoiGianLam.setText(model.getValueAt(row, 4).toString());
				break;
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = table.getSelectedRow();
		txtMaLichLV.setText(model.getValueAt(row, 0).toString());
		comboBoxMaNV.setSelectedItem(model.getValueAt(row, 1));
		comboBoxMaCV.setSelectedItem(model.getValueAt(row, 2));
		txtNgayLam.setText(model.getValueAt(row, 3).toString());
		txtThoiGianLam.setText(model.getValueAt(row, 4).toString());
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
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (o == btnSua) {
			sua();
		}
		if (o == btnXoa) {
			xoa();
		}
		if (o == btnTim) {
			tim();
		}
	}
}
