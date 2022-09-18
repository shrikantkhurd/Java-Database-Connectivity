package bank.management.system;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


public class AllAccountDetails extends JFrame {

	private JPanel p1;
	private JTable table;
	Statement stmt;
	ResultSet rs;
	
/*public static void main(String[] args) {
	AllAccountDetails all=new AllAccountDetails();
}*/
	
	public AllAccountDetails() 
	{
		getContentPane().setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1370, 550);
		getContentPane().setLayout(null);
		
		p1 = new JPanel();
		p1.setLayout(null);
		p1.setBackground(Color.BLUE);
		p1.setBounds(0, 0, 1352, 74);
		getContentPane().add(p1);
		
		JLabel lblWelcome = new JLabel("WELCOME TO");
		lblWelcome.setForeground(Color.WHITE);
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblWelcome.setBounds(611, 10, 129, 22);
		p1.add(lblWelcome);
		
		JLabel lblBankOfMaharashtra = new JLabel("BANK OF MAHARASHTRA");
		lblBankOfMaharashtra.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblBankOfMaharashtra.setForeground(Color.WHITE);
		lblBankOfMaharashtra.setBounds(521, 34, 309, 27);
		p1.add(lblBankOfMaharashtra);
		
		JLabel lblAllAccountants = new JLabel("ALL ACCOUNTANTS");
		lblAllAccountants.setHorizontalAlignment(SwingConstants.CENTER);
		lblAllAccountants.setForeground(Color.BLACK);
		lblAllAccountants.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 20));
		lblAllAccountants.setBounds(568, 76, 222, 36);
		getContentPane().add(lblAllAccountants);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 116, 1328, 327);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Account Number", "Name", "Father's Name", "Sur Name", "Gender", "Date", "Month", "Year", "Marital Status", "Address", "City", "Pin Code", "State", "Mobile Number", "Email Address"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(110);
		table.getColumnModel().getColumn(2).setPreferredWidth(93);
		table.getColumnModel().getColumn(8).setPreferredWidth(89);
		table.getColumnModel().getColumn(13).setPreferredWidth(96);
		table.getColumnModel().getColumn(14).setPreferredWidth(200);
		scrollPane.setViewportView(table);
		
		JButton button = new JButton("BACK");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				MainWindow main=new MainWindow();
				main.setVisible(true);
				setVisible(false);
				
			}
		});
		button.setForeground(Color.WHITE);
		button.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 22));
		button.setBackground(Color.BLUE);
		button.setBounds(622, 455, 108, 36);
		getContentPane().add(button);

		
	//	private void formWindowActivated(java.awt.event.WindowEvent evt) {                                     
	         DefaultTableModel model = (DefaultTableModel)table.getModel();
	         
	        try(Connection con=DbConnect.connect())
	        {
	           
	            String data=("select * from account_details");
	            stmt=con.createStatement();
	            rs =stmt.executeQuery(data);
	            while(rs.next())
	            {
	                String account_number = rs.getString(1);
	                String  name = rs.getString(2);
	                String father_name = rs.getString(3);
	                String sur_name = rs.getString(4);
	                String gender = rs.getString(5);
	                String date = rs.getString(6);
	                String month = rs.getString(7);
	                String year = rs.getString(8);
	                String marital_status = rs.getString(9);
	                String address = rs.getString(10);
	                String city = rs.getString(11);
	                String pin_code = rs.getString(12);
	                String state = rs.getString(13);
	                String mobile_number = rs.getString(14);
	                String email_address = rs.getString(15);
	                
	                Object ob[] = {account_number,name, father_name, sur_name, gender, date, month, year, marital_status, address, city, pin_code, state, mobile_number, email_address};
	                model.addRow(ob);
	            }
	        }catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}                             
		
		setTitle("Bank management.");
		setVisible(true);
	}

}
