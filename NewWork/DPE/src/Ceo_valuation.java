import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.mysql.jdbc.PreparedStatement;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.Color;

public class Ceo_valuation extends JFrame  {

	private static final long serialVersionUID = 1L;
	int i=0;
	int j=0;
		
	String sections=null;
	String selected=null;
	String LastName=null;
	String FirstName=null;
	String lista=null;
	
	
	private JPanel contentPane;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ceo_valuation frame = new Ceo_valuation();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public Ceo_valuation()  {
	 	
	 	setResizable(false);
	 	setTitle("����������");
	 	String[][] hr = new String[200][4];
	 	int[] HRJlist =new int[200];
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 503, 447);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
				
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel.setBounds(395, 203, 95, 37);
		contentPane.add(lblNewLabel);
		
		JLabel label_1 = new JLabel("�������");
		label_1.setForeground(new Color(255, 215, 0));
		label_1.setFont(new Font("Serif", Font.BOLD, 18));
		label_1.setBounds(46, 31, 134, 25);
		contentPane.add(label_1);
		
		JLabel label = new JLabel("�����������");
		label.setForeground(new Color(255, 215, 0));
		label.setFont(new Font("Serif", Font.BOLD, 18));
		label.setBounds(280, 31, 134, 25);
		contentPane.add(label);
		JButton Create = new JButton("����������");
		Create.setForeground(new Color(0, 0, 255));
		
		JComboBox<String> Sections = new JComboBox<String>();
		Sections.setForeground(new Color(0, 0, 255));
		Sections.setBounds(25, 67, 182, 25);
		contentPane.add(Sections);	
				try{
					java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hrm","root","root");
					String query="Select section From Sections";
					PreparedStatement prepareStat=(PreparedStatement) conn.prepareStatement(query);								
				    ResultSet rs = prepareStat.executeQuery();	  	
				    while(rs.next()){
				    	Sections.addItem(rs.getString("Section"));	    		    	
				        }
				    rs.close();			  
				    conn.close();					
				}catch (Exception ex){
					
					JOptionPane.showMessageDialog(null, ex);
				}
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(229, 67, 241, 87);
				contentPane.add(scrollPane);				
				JList<Object> HRL_1 = new JList<Object>();
				scrollPane.setViewportView(HRL_1);
				HRL_1.setBackground(new Color(176, 224, 230));
							
				JButton button = new JButton("\u03A6\u039F\u03A1\u03A4\u03A9\u03A3\u0397");
				button.setForeground(new Color(0, 0, 255));
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try{						
							String item = Sections.getSelectedItem().toString();			
							java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hrm","root","root");
							String query="Select LastName,FirstName,rate,idemployee From Employee as a inner join sections as b "
									+ "on a.IDsection=b.IDsection where b.Section='"+item+"'";
							PreparedStatement prepareStat=(PreparedStatement) conn.prepareStatement(query);
							ResultSet rs=prepareStat.executeQuery();								  	
						    DefaultListModel<Object> DL = new DefaultListModel<Object>();
							while(rs.next()){
								hr[j][0]=rs.getString("idemployee");
								hr[j][1]=rs.getString("LastName");
								hr[j][2]=rs.getString("FirstName");
								hr[j][3]=rs.getString("rate");
							
								lista=hr[j][0]+"  "+hr[j][1]+" "+hr[j][2]+" "+hr[j][3] ;
								DL.addElement(lista);
								HRJlist[j]=j;
								j=j+1;
							}						
							HRL_1.setModel(DL);
							prepareStat.close();
							rs.close();							    
						    conn.close();						
						}catch (Exception ex){							
							JOptionPane.showMessageDialog(null, ex);
						}												
					}
				});
				button.setFont(new Font("Serif", Font.BOLD, 14));
				button.setBounds(42, 102, 134, 27);
				contentPane.add(button);		
		
		JLabel label_2 = new JLabel("����������");
		label_2.setForeground(new Color(255, 215, 0));
		label_2.setFont(new Font("Serif", Font.BOLD, 18));
		label_2.setBounds(173, 203, 134, 25);
		contentPane.add(label_2);
		
		JComboBox<Integer> Rate = new JComboBox<Integer>();
		Rate.setForeground(new Color(0, 0, 255));
	     for(int i=1; i<11; i++){
	    	 Rate.addItem(new Integer(i));
        }
		     
		Rate.setBounds(211, 237, 56, 25);
		contentPane.add(Rate);
		
		
		Create.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				Object item = Rate.getSelectedItem();
				selected = (String) HRL_1.getSelectedValue();		
				String[] value = selected.split("\\s+");			
				try{				
					java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hrm","root","root");
					String quer="UPDATE employee SET rate='"+item+"' WHERE idemployee='"+value[0]+"'";						
					PreparedStatement ps=(PreparedStatement) con.prepareStatement(quer);						
					ps.executeUpdate();
					ps.close();											
					JOptionPane.showMessageDialog(null, "���������� = "+item+" !");				
					 con.close();					
					}catch (Exception ex){						
						JOptionPane.showMessageDialog(null, "�������� ����������� !");			
					}}
			
		});
		
		Create.setFont(new Font("Serif", Font.BOLD, 14));
		Create.setBounds(96, 273, 134, 27);
		contentPane.add(Create);
		
		JButton Del = new JButton("��������");
		Del.setForeground(new Color(0, 0, 255));
		Del.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {														
					selected = (String) HRL_1.getSelectedValue();		
					String[] value = selected.split("\\s+");			
					try{				
						java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hrm","root","root");
						String quer="UPDATE employee SET rate=null WHERE idemployee='"+value[0]+"'";	
					
						PreparedStatement ps=(PreparedStatement) con.prepareStatement(quer);						
						ps.executeUpdate();
						ps.close();											
						JOptionPane.showMessageDialog(null, " ������ �������� ����������� !");				
						 con.close();					
						}catch (Exception ex){						
							JOptionPane.showMessageDialog(null, "�������� ��������� ����������� !");			
						}}
				
			});
			
		
		Del.setFont(new Font("Serif", Font.BOLD, 14));
		Del.setBounds(255, 273, 134, 27);
		contentPane.add(Del);
		
		JButton Exit = new JButton("������");
		Exit.setForeground(new Color(0, 0, 255));
		Exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		Exit.setFont(new Font("Serif", Font.BOLD, 15));
		Exit.setBounds(173, 343, 134, 25);
		contentPane.add(Exit);	
		
		JLabel lblNewLabel_1 = new JLabel("background image");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\User\\Desktop\\abstract_color_background_picture_8016-wide.jpg"));
		lblNewLabel_1.setBounds(0, 0, 497, 418);
		contentPane.add(lblNewLabel_1);			
	}
}