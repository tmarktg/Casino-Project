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

public class CreditFrame implements ActionListener{
	
	
	private JFrame frame1;
	private JTextField textfield;
	
	public CreditFrame(String buttonPress) {
		
		frame1 = new JFrame();
		
		JLabel label = new JLabel("Enter credit");
		JLabel label2 = new JLabel(buttonPress);
		
		
//		JLabel label2 = new JLabel(wf.getButtonPress());
		label.setFont(new Font("Serif", Font.PLAIN, 28));
		
		textfield = new JTextField();
		
				
		
		JButton button2 = new JButton("Enter");
		button2.setPreferredSize(new Dimension(40,40));
		
		button2.addActionListener(this);
		
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(100, 100, 80, 100));
		panel.setLayout(new GridLayout(0, 1));
		panel.add(label);
		panel.add(label2);
		panel.add(textfield);
		panel.add(button2);
		
		

		
		
		frame1.add(panel, BorderLayout.CENTER);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.setTitle("My GUI");
		frame1.pack();
		frame1.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String strTextField = textfield.getText();
		int creditValue = Integer.parseInt(strTextField);
		frame1.dispose();
		
		System.out.println(creditValue);
		new BetFrame();
		
		
		
	}
	
	
}
