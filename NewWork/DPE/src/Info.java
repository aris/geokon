import java.awt.EventQueue;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class Info extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel Panel2;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Info frame = new Info();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Info(){
		
		setTitle("����������� ���������");
		setBounds(780, 250, 400, 330);
		Panel2 = new JPanel();		
		Panel2.setBackground(new Color(0, 51, 102));
		Panel2.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(Panel2);
		Panel2.setLayout(null);
		
	    this.setTitle("�����������");   
	    this.setSize(450, 450);
	    getContentPane().setLayout(new GridLayout(8, 1));

	    JLabel instructions = new JLabel("� HRM Consulting ����� ��� ��������� ��� ���� �� ����� ��� ");
	    instructions.setForeground(new Color(255, 215, 0));
	    JLabel instructions2 = new JLabel("���������� ��� ��o������� ��� ��������� ���.");
	    instructions2.setForeground(new Color(255, 215, 0));
	    JLabel instructions3 = new JLabel("������������ ����������� �������� �� ������ ��� site ��� hrm-con.gr ");
	    instructions3.setForeground(new Color(255, 215, 0));
	    JLabel instructions5 = new JLabel(" ��������������� ���������� :");
	    instructions5.setForeground(new Color(255, 215, 0));
	    JLabel instructions6 = new JLabel(" �������������� ���������� ");
	    instructions6.setForeground(new Color(255, 215, 0));
	    JLabel instructions7 = new JLabel(" ������� ���������� ");
	    instructions7.setForeground(new Color(255, 215, 0));
	    JLabel instructions8 = new JLabel(" ������� �������� ");
	    instructions8.setForeground(new Color(255, 215, 0));
	    
	    getContentPane().add(instructions);
	    getContentPane().add(instructions2);
	    getContentPane().add(instructions3);
	    getContentPane().add(instructions5);
	    getContentPane().add(instructions6);
	    getContentPane().add(instructions7);
	    getContentPane().add(instructions8);
	
	}
	
	


}
