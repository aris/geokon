import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.PreparedStatement;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Hr_login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField HrText;
	private JPasswordField HrPass;
	private JPanel Panel;	
	private JButton Lbutton = new JButton("�������");
	private JLabel lblNewLabel;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hr_login frame = new Hr_login();
					frame.Panel.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Hr_login() {
		Hr_login1();
		
	}
	
	public void Hr_login1(){
				
		setTitle("�������  �����������");
		setBounds(780, 250, 400, 330);
		Panel = new JPanel();
		
		Panel.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(Panel);
		Panel.setLayout(null);
		Panel.getRootPane().setDefaultButton(Lbutton);
		
		
		HrText = new JTextField();
		HrText.setFont(new Font("SansSerif", Font.CENTER_BASELINE, 15));
		HrText.setBounds(140, 40, 125, 30);
		Panel.add(HrText);
		HrText.setColumns(10);
		
		
		JLabel HrLabel = new JLabel("�����:");
		HrLabel.setForeground(new Color(255, 215, 0));
		HrLabel.setFont(new Font("Serif", Font.CENTER_BASELINE, 18));
		HrLabel.setBounds(40, 39, 89, 25);
		Panel.add(HrLabel);
		
		
		HrPass = new JPasswordField();
		HrPass.setFont(new Font("SansSerif", Font.CENTER_BASELINE, 15));
		HrPass.setBounds(140, 125, 125, 30);
		Panel.add(HrPass);
		HrPass.setColumns(10);
		
		
		JLabel HrLabel1 = new JLabel("�������:");
		HrLabel1.setForeground(new Color(255, 215, 0));
		HrLabel1.setFont(new Font("Serif", Font.CENTER_BASELINE, 18));
		HrLabel1.setBounds(40, 123, 89, 25);
		Panel.add(HrLabel1);
		
		JButton �button = new JButton("������");
		
		�button.setFont(new Font("Serif", Font.CENTER_BASELINE, 13));
		�button.setBounds(190, 223, 95, 25);
		Panel.add(�button);
					
		�button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				dispose();
			}
		});
	
		Lbutton.setFont(new Font("Serif", Font.CENTER_BASELINE, 13));
		Lbutton.setBounds(80, 223, 95, 25);
		Panel.add(Lbutton);
		
		lblNewLabel = new JLabel("Background image");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\User\\Desktop\\1797990.jpg"));
		lblNewLabel.setBounds(0, 0, 384, 291);
		Panel.add(lblNewLabel);
				
		setVisible(true);
		actionlogin();
		}
		
	public void actionlogin(){
		Lbutton.addActionListener(new ActionListener() {
		@SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent arg0) {
			try {
				String query="SELECT * FROM users WHERE username=? AND pass_word=? AND ID=2 ";
				java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hrm","root","root");
				PreparedStatement prepareStat=(PreparedStatement) conn.prepareStatement(query);
				prepareStat.setString(1,HrText.getText());
				prepareStat.setString(2,HrPass.getText());				
				ResultSet rs=prepareStat.executeQuery();
				int count =0 ;
				while(rs.next()){
					count++;						
				}
				if(count==1)
				{		
					JOptionPane.showMessageDialog(null, "�������� ������� !");
					dispose();					
					Hr_Properties hr = new Hr_Properties();
					hr.setVisible(true);
				}			
				else{				
					JOptionPane.showMessageDialog(null, "����� ������� � ������� !");
					HrText.setText("");
					HrPass.setText("");
				}
				rs.close();
				prepareStat.close();
				conn.close();
			}catch(Exception ex){
				
				JOptionPane.showMessageDialog(null, "��� ������� ������� ��� ���� !");
			}
		}
		
	});
}
}
	
	

