import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CreditFrame extends WelcomeFrame{
	
	WelcomeFrame frame;
	
	public CreditFrame() {
		
		
		
		JFrame frame1 = new JFrame();
		
		JLabel label = new JLabel("Enter credit");
		label.setFont(new Font("Serif", Font.PLAIN, 28));
		
		JTextField button = new JTextField();
		JButton button2 = new JButton("Enter");
		button2.setPreferredSize(new Dimension(40,40));
		
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(100, 100, 80, 100));
		panel.setLayout(new GridLayout(0, 1));
		panel.add(label);
		panel.add(button);
		panel.add(button2);
		
		frame1.add(panel, BorderLayout.CENTER);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.setTitle("My GUI");
		frame1.pack();
		frame1.setVisible(true);
	}
	
	
}
