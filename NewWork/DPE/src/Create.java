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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import com.mysql.jdbc.PreparedStatement;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.SwingConstants;

public class Create extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel Panel;	
	private JTextField sectionName;	
	String sections;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Create window = new Create();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	
public Create(){
	
	
	setTitle("ƒ«Ã…œ’—√…¡ /ƒ…¡√—¡÷« ‘Ã«Ã¡‘œ”");
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	setBounds(480, 150, 500, 436);
	Panel = new JPanel();
		
	Panel.setBorder(new EmptyBorder(10, 10, 10, 10));
	setContentPane(Panel);
	Panel.setLayout(null);
		
	JButton CreateButton = new JButton("ƒ«Ã…œ’—√…¡");
	CreateButton.setForeground(new Color(0, 0, 255));
	CreateButton.setFont(new Font("Serif", Font.CENTER_BASELINE, 14));
	CreateButton.setBounds(257, 94, 160, 50);
	Panel.add(CreateButton);
		
	JButton ExitButton = new JButton("∏Œœƒœ”");
	ExitButton.setForeground(new Color(0, 0, 255));
	ExitButton.setFont(new Font("Serif", Font.CENTER_BASELINE, 14));
	ExitButton.setBounds(152, 325, 160, 50);
	Panel.add(ExitButton);
		
	sectionName = new JTextField();
	sectionName.setBackground(new Color(224, 255, 255));
	sectionName.setFont(new Font("Serif", Font.ROMAN_BASELINE, 18));
	sectionName.setBounds(46, 96, 158, 44);
	Panel.add(sectionName);
	sectionName.setColumns(10);
	
	JLabel lblNewLabel = new JLabel("ƒÁÏÈÔ˝Ò„ÁÛÂ ‘ÏﬁÏ·");
	lblNewLabel.setForeground(new Color(255, 215, 0));
	lblNewLabel.setFont(new Font("Serif", Font.BOLD, 18));
	lblNewLabel.setBounds(46, 36, 158, 33);
	Panel.add(lblNewLabel);
	
	JLabel lblNewLabel_1 = new JLabel("‘Ã«Ã¡‘¡");
	lblNewLabel_1.setForeground(new Color(255, 215, 0));
	lblNewLabel_1.setFont(new Font("Serif", Font.BOLD, 18));
	lblNewLabel_1.setBounds(57, 160, 158, 39);
	Panel.add(lblNewLabel_1);
	
	JComboBox<String> comboBox = new JComboBox<String>();
	comboBox.setBounds(49, 207, 160, 33);
	Panel.add(comboBox);
	
	JButton DelButton = new JButton("ƒ…¡√—¡÷«");
	DelButton.setForeground(new Color(0, 0, 255));
	DelButton.setFont(new Font("Serif", Font.BOLD, 14));
	DelButton.setBounds(257, 194, 160, 50);
	Panel.add(DelButton);
	
	JLabel lblNewLabel_2 = new JLabel("Background Image");
	lblNewLabel_2.setVerticalAlignment(SwingConstants.BOTTOM);
	lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\User\\Desktop\\abstract_color_background_picture_8016-wide.jpg"));
	lblNewLabel_2.setBounds(0, 0, 484, 397);
	Panel.add(lblNewLabel_2);
	
	try{
		java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hrm","root","root");
		String query="Select section From Sections";
		PreparedStatement prepareStat=(PreparedStatement) conn.prepareStatement(query);			
	    ResultSet rs = prepareStat.executeQuery();	  	
	    while(rs.next()){
	    	comboBox.addItem(rs.getString("Section"));	    		    	
	        }
	    rs.close();
	    conn.close();
		
	}catch (Exception e){
		
		JOptionPane.showMessageDialog(null, e);
	}
	
	
	CreateButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			sections=sectionName.getText();
					
			try{
				
				java.sql.Connection conn1 = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hrm","root","root");
				String query3="INSERT INTO sections" +"(Section)" + " Values (?) ";
									
					PreparedStatement prepareStat=(PreparedStatement) conn1.prepareStatement(query3);
					prepareStat.setString(1,sectionName.getText());
					prepareStat.executeUpdate();				
					JOptionPane.showMessageDialog(null, "Õ›Ô ‘ÏﬁÏ· : "+sections+" !");
					sectionName.setText("");
					comboBox.removeAllItems();
					String query="Select section From Sections";
					
					PreparedStatement prepareStat3=(PreparedStatement) conn1.prepareStatement(query);										
				    ResultSet rs = prepareStat3.executeQuery();
				    while(rs.next()){
				    	comboBox.addItem(rs.getString("Section"));	    		    	
				        }
				    rs.close();
				   
				    conn1.close();
				}catch (Exception e){
					JOptionPane.showMessageDialog(null, "À‹ËÔÚ ºÌÔÏ· "+sections+" !");			
				}}
	});
	ExitButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {			
			dispose();
			}
	});
	DelButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {		
			Object item = comboBox.getSelectedItem();		
			try{	
				java.sql.Connection conn1 = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hrm","root","root");
				String query3="DELETE FROM Sections WHERE Section=?";								
					PreparedStatement prepareStat=(PreparedStatement) conn1.prepareStatement(query3);					
					prepareStat.setString(1, item.toString());	
					prepareStat.executeUpdate(); 
					JOptionPane.showMessageDialog(null, "≈ÈÙı˜ﬂ· ƒÈ·„Ò·ˆﬁÚ "+sections+"!");
					sectionName.setText("");
					comboBox.removeAllItems();
					String query="Select section From Sections";					
					PreparedStatement prepareStat3=(PreparedStatement) conn1.prepareStatement(query);							
				    ResultSet rs = prepareStat3.executeQuery();
				    while(rs.next()){
				    	comboBox.addItem(rs.getString("Section"));	    		    	
				        }
				    rs.close();
				 
				    conn1.close();
				}catch (Exception e){
					JOptionPane.showMessageDialog(null, "À‹ËÔÚ ºÌÔÏ· "+sections+" !");			
				}		
			}
	});	
}
}


