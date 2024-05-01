package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Form_Login extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JTextField txtUser;
	private JPasswordField txtPassword;
	private JButton btnLogin;
	private JButton btnExit;

	public Form_Login() {
		setTitle("Hệ thống quản lý lao động");
		
		setSize(700, 400);
    	setResizable(false);
    	setLocationRelativeTo(null);
    	setLayout(new GridLayout(0, 2));
    	
    	
    	// Background
        JLabel backgound = new JLabel();
        backgound.setIcon(new ImageIcon(getClass().getResource("/image/bg3.jpg")));
        
        JPanel panelRight = new JPanel();
        JPanel tong = new JPanel();
        tong.setBackground(Color.decode("#ada090"));
        tong.setLayout(new BoxLayout(tong, BoxLayout.Y_AXIS));
        JPanel d1 = new JPanel();
        JLabel header = new JLabel("Login");
        d1.setBackground(Color.decode("#ada090"));
        header.setFont(new Font(getName(), Font.BOLD, 36));
        d1.add(header);
        
        
        // Tài khoản
        JPanel d2 = new JPanel();
        JPanel tk = new JPanel();
        d2.setBackground(Color.decode("#ada090"));
        tk.setBackground(Color.decode("#ada090"));
        tk.setLayout(new BoxLayout(tk, BoxLayout.Y_AXIS));
        JLabel user = new JLabel("Username:");
        user.setFont(new Font(getName(), Font.BOLD, 14));
        txtUser = new JTextField(30);
        txtUser.setText("NV001");
        txtUser.setBorder(null);
        txtUser.setBackground(Color.DARK_GRAY);
        txtUser.setForeground(Color.LIGHT_GRAY);
        txtUser.setCaretColor(Color.LIGHT_GRAY);
        txtUser.setPreferredSize(new Dimension(50, 25));
        tk.add(user, Box.LEFT_ALIGNMENT);
        tk.add(Box.createVerticalStrut(5));
        tk.add(txtUser, Box.LEFT_ALIGNMENT);
        d2.add(tk);
        
        // Mật khẩu
        JPanel d3 = new JPanel();
        JPanel mk = new JPanel();
        d3.setBackground(Color.decode("#ada090"));
        mk.setBackground(Color.decode("#ada090"));
        mk.setLayout(new BoxLayout(mk, BoxLayout.Y_AXIS));
        JLabel password = new JLabel("Password:");
        password.setFont(new Font(getName(), Font.BOLD, 14));
        txtPassword = new JPasswordField(30);
        txtPassword.setText("NV001");
        txtPassword.setBorder(null);
        txtPassword.setBackground(Color.DARK_GRAY);
        txtPassword.setForeground(Color.LIGHT_GRAY);
        txtPassword.setCaretColor(Color.LIGHT_GRAY);
        txtPassword.setPreferredSize(new Dimension(50, 25));
        mk.add(password, LEFT_ALIGNMENT);
        mk.add(Box.createVerticalStrut(5));
        mk.add(txtPassword, LEFT_ALIGNMENT);
        d3.add(mk);
        
        // Nút bấm
        JPanel btn = new JPanel();
        btn.setBackground(Color.decode("#ada090"));
        btn.setLayout(new BoxLayout(btn, BoxLayout.X_AXIS));
        
        btnLogin = new JButton("Login");
        btnLogin.addActionListener(this);
        btnLogin.setFont(new Font(getName(), Font.BOLD, 14));
        btnLogin.setForeground(Color.LIGHT_GRAY);
        btnLogin.setBackground(Color.DARK_GRAY);
        btnLogin.setFocusPainted(false);
        
        btnExit = new JButton("  Exit  ");
        btnExit.addActionListener(this);
        btnExit.setFont(new Font(getName(), Font.BOLD, 14));
        btnExit.setForeground(Color.LIGHT_GRAY);
        btnExit.setBackground(Color.DARK_GRAY);
        btnExit.setFocusPainted(false);
        btn.add(btnLogin);
        btn.add(Box.createHorizontalStrut(50));
        btn.add(btnExit);
        
        tong.add(Box.createVerticalStrut(40));
        tong.add(d1);
        tong.add(Box.createVerticalStrut(10));
        tong.add(d2);
        tong.add(Box.createVerticalStrut(10));
        tong.add(d3);
        tong.add(Box.createVerticalStrut(30));
        tong.add(btn);
        panelRight.add(tong);
        panelRight.setBackground(Color.decode("#ada090"));
        
        // Thêm vào JFrame
        add(backgound);
        add(panelRight);
        
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) {
		new Form_Login();
	}
    
    @Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnLogin)) {
			String username = txtUser.getText();
			char[] mk = ((JPasswordField) txtPassword).getPassword();
			String mkstr=new String(mk);
			if(username.equals("NV002") && mkstr.equals("NV002")) {
				TrangChu trangchu= new TrangChu();
				trangchu.setVisible(true);
				trangchu.getBtnLichLV().setEnabled(false);
				trangchu.getBtnQuanLiCT().setEnabled(false);
				trangchu.getBtnThongTinCN().setEnabled(false);
				trangchu.getBtnPhanCong().setEnabled(false);
				trangchu.getBtnThongKe().setEnabled(false);
				dispose();
			}
			else if(username.equals("NV001")&& mkstr.equals("NV001")) {
				TrangChu trangchu= new TrangChu();
				trangchu.setVisible(true);	
				trangchu.getBtnLichLV().setEnabled(true);
				trangchu.getBtnQuanLiCT().setEnabled(true);
				trangchu.getBtnThongTinCN().setEnabled(true);
				trangchu.getBtnPhanCong().setEnabled(true);
				trangchu.getBtnThongKe().setEnabled(true); 
				dispose();
			}
			else {
				JOptionPane.showMessageDialog(this, "Tài khoản hoặc mật khẩu không đúng!");
			}
		}

		else if (o.equals(btnExit)) {
			int chon = JOptionPane.showConfirmDialog(this, "Bạn Có Muốn Thoát Không?", "Thoát",
					JOptionPane.YES_NO_OPTION);
			if (chon == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		}
	}
}