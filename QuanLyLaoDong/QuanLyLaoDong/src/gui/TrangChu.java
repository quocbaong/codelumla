package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TrangChu extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JButton btnLichLV;
	private JButton btnThongTinCN;
	private JButton btnQuanLiCT;
	private JButton btnPhanCong;
	private JButton btnThongKe;
	private JButton btndx;
	private JLabel backgound;
	private JPanel QLNV;
	private JPanel CT;
	private JPanel LLV;
	private JPanel PC;
	private JPanel TTCN;
	private JPanel TK;
	private JButton btnTTCN;
	private Form_NhanVien viewNhanVien = new Form_NhanVien();
	private Form_BangPhanCong viewPhanCong = new Form_BangPhanCong();
	private Form_CongTrinh viewCongTrinh = new Form_CongTrinh();
	private Form_LichLamViec viewLichLamViec = new Form_LichLamViec();
	private Form_ThongTinCaNhan viewTTCaNhan = new Form_ThongTinCaNhan();
	private Form_ThongKe viewThongKe = new Form_ThongKe();
	
	public static void main(String[] args) {
		new TrangChu().setVisible(true);
	}

	public TrangChu() {
		super("QuanLyLaoDong.java");
		initialize();
	}

	private void initialize() {
		setSize(1200, 750);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		// Tiêu đề
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.Y_AXIS));
		JLabel title = new JLabel("HỆ THỐNG QUẢN LÝ LAO ĐỘNG");
		title.setFont(new Font(getName(), Font.BOLD, 36));
		title.setForeground(Color.LIGHT_GRAY);
		JPanel tl = new JPanel();
		tl.setBackground(Color.decode("#56585d"));
		tl.add(title);
		header.add(tl, CENTER_ALIGNMENT);
		
		// Thanh menu
		JPanel menu = new JPanel();
		menu.setLayout(new BoxLayout(menu, BoxLayout.X_AXIS));
		
		// Lịch làm việc
		btnLichLV = new JButton("Lịch làm việc");
		btnLichLV.setFont(new Font(getName(), Font.BOLD, 14));
		btnLichLV.setForeground(Color.LIGHT_GRAY);
		btnLichLV.setBackground(Color.DARK_GRAY);
		btnLichLV.setFocusPainted(false);
		btnLichLV.setPreferredSize(new Dimension(130,40));
		
		// Thông tin cá nhân
		btnThongTinCN = new JButton("Nhân viên");
		btnThongTinCN.setFont(new Font(getName(), Font.BOLD, 14));
		btnThongTinCN.setForeground(Color.LIGHT_GRAY);
		btnThongTinCN.setBackground(Color.DARK_GRAY);
		btnThongTinCN.setFocusPainted(false);
		btnThongTinCN.setPreferredSize(new Dimension(130,40));
		
		// QL công trình
		btnQuanLiCT = new JButton("Công trình");
		btnQuanLiCT.setFont(new Font(getName(), Font.BOLD, 14));
		btnQuanLiCT.setForeground(Color.LIGHT_GRAY);
		btnQuanLiCT.setBackground(Color.DARK_GRAY);
		btnQuanLiCT.setFocusPainted(false);
		btnQuanLiCT.setPreferredSize(new Dimension(130,40));
		
		// Phân công
		btnPhanCong = new JButton("Phân công");
		btnPhanCong.setFont(new Font(getName(), Font.BOLD, 14));
		btnPhanCong.setForeground(Color.LIGHT_GRAY);
		btnPhanCong.setBackground(Color.DARK_GRAY);
		btnPhanCong.setFocusPainted(false);
		btnPhanCong.setPreferredSize(new Dimension(130,40));
		
		// Chấm công
		btnTTCN = new JButton("TT cá nhân");
		btnTTCN.setFont(new Font(getName(), Font.BOLD, 14));
		btnTTCN.setForeground(Color.LIGHT_GRAY);
		btnTTCN.setBackground(Color.DARK_GRAY);
		btnTTCN.setFocusPainted(false);
		btnTTCN.setPreferredSize(new Dimension(130,40));
		
		// Thống kê 
		btnThongKe = new JButton("Thống kê");
		btnThongKe.setFont(new Font(getName(), Font.BOLD, 14));
		btnThongKe.setForeground(Color.LIGHT_GRAY);
		btnThongKe.setBackground(Color.DARK_GRAY);
		btnThongKe.setFocusPainted(false);
		btnThongKe.setPreferredSize(new Dimension(130,40));
		
		// Đăng xuất
		btndx = new JButton("Đăng xuất");
		btndx.setFont(new Font(getName(), Font.BOLD, 14));
		btndx.setForeground(Color.LIGHT_GRAY);
		btndx.setBackground(Color.DARK_GRAY);
		btndx.setFocusPainted(false);
		btndx.setPreferredSize(new Dimension(130,40));
		
		
		JPanel n1 = new JPanel();
		n1.setBackground(Color.decode("#ada090"));
		n1.add(btnLichLV);
		
		JPanel n2 = new JPanel();
		n2.setBackground(Color.decode("#ada090"));
		n2.add(btnThongTinCN);
		
		JPanel n3 = new JPanel();
		n3.setBackground(Color.decode("#ada090"));
		n3.add(btnQuanLiCT);
		
		JPanel n4 = new JPanel();
		n4.setBackground(Color.decode("#ada090"));
		n4.add(btnPhanCong);
		
		JPanel n5 = new JPanel();
		n5.setBackground(Color.decode("#ada090"));
		n5.add(btnTTCN);
		
		JPanel n6 = new JPanel();
		n6.setBackground(Color.decode("#ada090"));
		n6.add(btnThongKe);
		
		JPanel n7 = new JPanel();
		n7.setBackground(Color.decode("#ada090"));
		n7.add(btndx);
		
		menu.add(n1);
		menu.add(n2);
		menu.add(n3);
		menu.add(n4);
		menu.add(n5);
		menu.add(n6);
		menu.add(n7);
		menu.setBorder(BorderFactory.createMatteBorder(5, 0, 5, 0, Color.DARK_GRAY));
		menu.setBackground(Color.decode("#ada090"));
		
		header.add(menu,BorderLayout.CENTER);
		
		// Thêm vào JFrame
		this.add(header, BorderLayout.NORTH);
		
		// Backgroud
		backgound = new JLabel();
		backgound.setIcon(new ImageIcon(getClass().getResource("/image/bg1.jpg")));
		add(backgound, BorderLayout.CENTER);
		
		// Lịch làm việc
		LLV = new JPanel();
		LLV.setLayout(new BorderLayout());
		LLV.add(viewLichLamViec, BorderLayout.CENTER);
		LLV.setVisible(false);
		
		// Quản lý nhân viên
		QLNV = new JPanel();
		QLNV.setLayout(new BorderLayout());
		QLNV.add(viewNhanVien, BorderLayout.CENTER);
		QLNV.setVisible(false);
		
		// Quản lý nhân viên
		PC = new JPanel();
		PC.setLayout(new BorderLayout());
		PC.add(viewPhanCong, BorderLayout.CENTER);
		PC.setVisible(false);
		
		// Công trình
		CT = new JPanel();
		CT.setLayout(new BorderLayout());
		CT.add(viewCongTrinh, BorderLayout.CENTER);
		CT.setVisible(false);
		
		// Thông tin cá nhân
		TTCN = new JPanel();
		TTCN.setLayout(new BorderLayout());
		TTCN.add(viewTTCaNhan, BorderLayout.CENTER);
		TTCN.setVisible(false);
		
		// Thống kê
		TK = new JPanel();
		TK.setLayout(new BorderLayout());
		TK.add(viewThongKe, BorderLayout.CENTER);
		TK.setVisible(false);
		
		
		btnTTCN.addActionListener(this);
		btnQuanLiCT.addActionListener(this);
		btnLichLV.addActionListener(this);
		btnThongTinCN.addActionListener(this);
		btnPhanCong.addActionListener(this);
		btnThongKe.addActionListener(this);
		btndx.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o == btnThongTinCN) {
			setVisibleFalse();
			resetBtnBackground();
			add(QLNV, BorderLayout.CENTER);
			QLNV.setVisible(true);
			btnThongTinCN.setBackground(Color.GRAY);
		}
		else if(o == btnLichLV) {
			setVisibleFalse();
			resetBtnBackground();
				
			add(LLV, BorderLayout.CENTER);
			LLV.setVisible(true);
			btnLichLV.setBackground(Color.GRAY);
		}
		else if(o == btnQuanLiCT) {
			setVisibleFalse();
			resetBtnBackground();
				
			add(CT, BorderLayout.CENTER);
			CT.setVisible(true);
			btnQuanLiCT.setBackground(Color.GRAY);
		}
		else if(o == btnPhanCong) {
			setVisibleFalse();
			resetBtnBackground();
				
			add(PC, BorderLayout.CENTER);
			PC.setVisible(true);
			btnPhanCong.setBackground(Color.GRAY);
		}
		else if(o == btnTTCN) {
			setVisibleFalse();
			resetBtnBackground();
				
			add(TTCN, BorderLayout.CENTER);
			TTCN.setVisible(true);
			btnTTCN.setBackground(Color.GRAY);
		}
		else if(o == btnThongKe) {
			setVisibleFalse();
			resetBtnBackground();
				
			add(TK, BorderLayout.CENTER);
			TK.setVisible(true);
			btnThongKe.setBackground(Color.GRAY);
		}
		else if(o == btndx) {
			int chon = JOptionPane.showConfirmDialog(this, "Bạn có muốn đăng xuất không?", "Đăng xuất",
					JOptionPane.YES_NO_OPTION);
			if (chon == JOptionPane.YES_OPTION) {
				Form_Login lg = new Form_Login();
				lg.setVisible(true);
				dispose();
			}
		}
	}
	
	public void resetBtnBackground() {
		btnLichLV.setBackground(Color.DARK_GRAY);
		btnTTCN.setBackground(Color.DARK_GRAY);
		btnThongTinCN.setBackground(Color.DARK_GRAY);
		btnPhanCong.setBackground(Color.DARK_GRAY);
		btnQuanLiCT.setBackground(Color.DARK_GRAY);
		btnThongKe.setBackground(Color.DARK_GRAY);
	}
	
	public void setVisibleFalse() {
		TK.setVisible(false);
		PC.setVisible(false);
		CT.setVisible(false);
		LLV.setVisible(false);
		QLNV.setVisible(false);
		TTCN.setVisible(false);
		backgound.setVisible(false);
	}

	public JButton getBtnLichLV() {
		return btnLichLV;
	}

	public void setBtnQuanLiLD(JButton btnQuanLiLD) {
		this.btnLichLV = btnQuanLiLD;
	}

	public JButton getBtnThongTinCN() {
		return btnThongTinCN;
	}

	public void setBtnThongTinCN(JButton btnThongTinCN) {
		this.btnThongTinCN = btnThongTinCN;
	}

	public JButton getBtnQuanLiCT() {
		return btnQuanLiCT;
	}

	public void setBtnQuanLiCT(JButton btnQuanLiCT) {
		this.btnQuanLiCT = btnQuanLiCT;
	}

	public JButton getBtnPhanCong() {
		return btnPhanCong;
	}

	public void setBtnPhanCong(JButton btnPhanCong) {
		this.btnPhanCong = btnPhanCong;
	}

	@Override
	public String toString() {
		return "TrangChu [btnLichLV=" + btnLichLV + ", btnThongTinCN=" + btnThongTinCN + "]";
	}

	public JButton getBtnThongKe() {
		return btnThongKe;
	}

	public void setBtnThongKe(JButton btnThongKe) {
		this.btnThongKe = btnThongKe;
	}

	public JButton getBtndx() {
		return btndx;
	}

	public void setBtndx(JButton btndx) {
		this.btndx = btndx;
	}

	public JButton getBtnTTCN() {
		return btnTTCN;
	}

	public void setBtnTTCN(JButton btnTTCN) {
		this.btnTTCN = btnTTCN;
	}

	public void setBtnLichLV(JButton btnLichLV) {
		this.btnLichLV = btnLichLV;
	}
}

