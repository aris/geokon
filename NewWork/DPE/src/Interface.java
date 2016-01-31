import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Interface {
	
	private JFrame Frame;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface window = new Interface();
					window.Frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Interface() {
		Interface1();		
	}

	private void Interface1() {

		Frame = new JFrame();
		
		Frame.setResizable(false);
		Frame.setTitle("��������");
		Frame.getContentPane().setBackground(Color.white);
		
		Frame.setBounds(150, 150, 631, 398);
		Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Frame.getContentPane().setLayout(null);
		Frame.setLocationRelativeTo ( null );
		
		JLabel Label1 = new JLabel("");
		Image img1 = new ImageIcon(this.getClass().getResource("/HRM Final logo.jpg-for-web-normal.jpg")).getImage();
		Label1.setIcon(new ImageIcon(img1));
		Label1.setBounds(257, 94, 326, 165);
		Frame.getContentPane().add(Label1);
		
		
		JButton  Ceobutton= new JButton("������������");
		Ceobutton.setForeground(new Color(0, 0, 255));
		
		Ceobutton.setFont(new Font("Serif", Font.CENTER_BASELINE, 15));
		Ceobutton.setBounds(28, 46, 180, 50);
		Ceobutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ceo_login cf = new Ceo_login();
				cf.setVisible(true);
			}
		});
		Frame.getContentPane().add(Ceobutton);
		
		
		JButton  HRbutton= new JButton("�����������");
		HRbutton.setForeground(new Color(0, 0, 255));
		Frame.getContentPane().add(HRbutton);
		HRbutton.setFont(new Font("Serif", Font.CENTER_BASELINE, 15));
		HRbutton.setBounds(28, 118, 180, 50);
		HRbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Hr_login hr = new Hr_login();
				hr.setVisible(true);
			}
		});
				
		JButton  INFObutton= new JButton("�����������");
		INFObutton.setForeground(new Color(0, 0, 255));
		Frame.getContentPane().add(INFObutton);
		INFObutton.setFont(new Font("Serif", Font.CENTER_BASELINE, 15));
		INFObutton.setBounds(28, 191, 180, 50);
		INFObutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Info inf = new Info();
				inf.setVisible(true);
			}
		});
		
		JButton ExitButton = new JButton("������");
		ExitButton.setForeground(new Color(0, 0, 255));
		Frame.getContentPane().add(ExitButton);
		ExitButton.setFont(new Font("Serif", Font.CENTER_BASELINE, 15));
		ExitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Frame.dispatchEvent(new WindowEvent(Frame, WindowEvent.WINDOW_CLOSING));
			}
		});
		ExitButton.setBounds(28, 268, 180, 50);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\User\\Desktop\\1797990.jpg"));
		lblNewLabel.setBounds(0, 0, 696, 369);
		Frame.getContentPane().add(lblNewLabel);
		
		
	
	}	
}