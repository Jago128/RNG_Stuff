package windows;

import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

public class RNG_Stuff extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JButton btnNewButton;
	JButton btnNewButton_1;
	JButton btnNewButton_2;
	JButton btnNewButton_2_1;

	public RNG_Stuff() {
		setTitle("RNG Stuff");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 197);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnNewButton = new JButton("New button");
		btnNewButton.setBounds(26, 10, 200, 64);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(251, 10, 200, 64);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBounds(26, 84, 200, 64);
		contentPane.add(btnNewButton_2);
		
		btnNewButton_2_1 = new JButton("New button");
		btnNewButton_2_1.setBounds(251, 84, 200, 64);
		contentPane.add(btnNewButton_2_1);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}
