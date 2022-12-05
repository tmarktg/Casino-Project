import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BetFrame implements ActionListener{
	
	private JFrame frame2;
	private JTextField textfield2;
	
	
	public BetFrame() {
		frame2 = new JFrame();
		
		JLabel label = new JLabel("Enter bet");
		
		label.setFont(new Font("Serif", Font.PLAIN, 28));
		
		textfield2 = new JTextField();
		
		JButton button2 = new JButton("Enter");
		button2.setPreferredSize(new Dimension(40,40));
		
		button2.addActionListener(this);
		
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(100, 100, 80, 100));
		panel.setLayout(new GridLayout(0,1));
		panel.add(label);
		panel.add(textfield2);
		panel.add(button2);
		
		frame2.add(panel, BorderLayout.CENTER);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.setTitle("My GUI");
		frame2.pack();
		frame2.setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String strTextField = textfield2.getText();
		int betValue = Integer.parseInt(strTextField);
		frame2.dispose();
		
		
	}
	

}
