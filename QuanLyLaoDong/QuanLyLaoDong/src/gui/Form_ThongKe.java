package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import dao.Dao_CongTrinh;
import dao.Dao_ThongKe;
import entity.CongTrinh;
import entity.TKNVCoTrongCT;
import entity.TKSoDuAnNVThamGia;



public class Form_ThongKe extends JPanel implements ActionListener{
	
	
	private DefaultTableModel dtm;
	private JTable table;
	private JScrollPane scrollTable;
	private DefaultTableModel dtm1;
	private JTable table1;
	private JScrollPane scrollTable1;
	private JButton btnXacNhan;
	private JComboBox<String> comboBoxMaCT;

	public Form_ThongKe() {
		// TODO Auto-generated constructor stub
		setLayout(null);
		add(comboBoxMaCT=new JComboBox<String>());
		comboBoxMaCT.setBounds(10, 10, 100, 30);
		add(btnXacNhan=new JButton("Xác nhận"));
		btnXacNhan.setBounds(150, 10, 100, 30);
		btnXacNhan.addActionListener(this);
		JPanel pnTable1 = new JPanel();
		pnTable1.setBorder(BorderFactory.createTitledBorder("Thống kê số công việc mà nhân viên đã được phân công"));
		TitledBorder titleChiTietDA1 = (TitledBorder) pnTable1.getBorder();
		titleChiTietDA1.setTitleColor(Color.blue);
		pnTable1.setBounds(10, 50, 1160, 201);
		pnTable1.setLayout(null);

		dtm1 = new DefaultTableModel();
		dtm1.addColumn("Mã Nhân Viên");
		dtm1.addColumn("Tên Nhân Viên");

		
		table1 = new JTable(dtm1);
		table1.setRowHeight(20);
		scrollTable1 = new JScrollPane(table1);
		scrollTable1.setBounds(9, 25, 1142, 165);
		pnTable1.add(scrollTable1);
		add(pnTable1);


		JPanel pnTable = new JPanel();
		pnTable.setBorder(BorderFactory.createTitledBorder("Thống kê số công việc mà nhân viên đã được phân công"));
		TitledBorder titleChiTietDA = (TitledBorder) pnTable.getBorder();
		titleChiTietDA.setTitleColor(Color.blue);
		pnTable.setBounds(10, 320, 1160, 201);
		pnTable.setLayout(null);

		dtm = new DefaultTableModel();
		dtm.addColumn("Mã Nhân Viên");
		dtm.addColumn("Tên Nhân Viên");
		dtm.addColumn("Số Dự án tham gia");
		
		table = new JTable(dtm);
		table.setRowHeight(20);
		scrollTable = new JScrollPane(table);
		scrollTable.setBounds(9, 25, 1142, 165);
		pnTable.add(scrollTable);
		add(pnTable);
		updateTable();
		updateComboBox();
		setSize(1200,700);
		setVisible(true);
	}
	private void updateTable() {
		Dao_ThongKe ds = new Dao_ThongKe();
		List<TKSoDuAnNVThamGia> list=ds.getAllDuAn();
		for (TKSoDuAnNVThamGia p : list) {
			String[] row = {p.getMaNV(), p.getTenNV(),p.getSoDuAn()+""};
			dtm.addRow(row);
		}
		table.setModel(dtm);
	}
	private void updateTable1() {
		Dao_ThongKe ds = new Dao_ThongKe();
		List<TKNVCoTrongCT> list=ds.getNVCoTrongCT(comboBoxMaCT.getSelectedItem().toString());
		for (TKNVCoTrongCT p : list) {
			String[] row = {p.getMaNV(), p.getTenNV()};
			dtm1.addRow(row);
		}
		table1.setModel(dtm1);
	}

	public void updateComboBox() {
		Dao_CongTrinh ds=new Dao_CongTrinh();
		List<CongTrinh> list=ds.getAllCongTrinh();
		for (CongTrinh ct : list) {
			comboBoxMaCT.addItem(ct.getMaCT());
		}
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o=e.getSource();
		if(o==btnXacNhan) {
			dtm1.setRowCount(0);
			updateTable1();
			if(dtm1.getRowCount()==0) {
				JOptionPane.showMessageDialog(this, "Công trình này hiện tại không có nhân viên tham gia");
			}
		}
	}
	
}
