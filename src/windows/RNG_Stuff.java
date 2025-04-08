package windows;

import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class RNG_Stuff extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btn10PercentRNG;
	private JButton btn15PercentRNG;
	private JButton btn20PercentRNG;
	private JButton btn25PercentRNG;
	private JButton btn40PercentRNG;
	private JButton btn12PercentRNG;
	private JButton btnJustitiaRNG;
	private JButton btn33PercentRNG;

	public RNG_Stuff() {
		setTitle("RNG Stuff");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 531, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btn10PercentRNG = new JButton("10% Stuff");
		btn10PercentRNG.setFont(new Font("Determination Mono Web", Font.PLAIN, 20));
		btn10PercentRNG.setBounds(24, 61, 200, 64);
		contentPane.add(btn10PercentRNG);
		
		btn15PercentRNG = new JButton("15% Stuff");
		btn15PercentRNG.setFont(new Font("Determination Mono Web", Font.PLAIN, 20));
		btn15PercentRNG.setBounds(255, 61, 200, 64);
		contentPane.add(btn15PercentRNG);
		
		btn20PercentRNG = new JButton("20% Stuff");
		btn20PercentRNG.setFont(new Font("Determination Mono Web", Font.PLAIN, 20));
		btn20PercentRNG.setBounds(24, 135, 200, 64);
		contentPane.add(btn20PercentRNG);
		
		btn25PercentRNG = new JButton("25% Stuff");
		btn25PercentRNG.setFont(new Font("Determination Mono Web", Font.PLAIN, 20));
		btn25PercentRNG.setBounds(255, 135, 200, 64);
		contentPane.add(btn25PercentRNG);
		
		btn40PercentRNG = new JButton("Soak Status RNG");
		btn40PercentRNG.setFont(new Font("Determination Mono Web", Font.PLAIN, 20));
		btn40PercentRNG.setBounds(24, 209, 200, 64);
		contentPane.add(btn40PercentRNG);
		
		btn12PercentRNG = new JButton("Status RNG with Chimera");
		btn12PercentRNG.setFont(new Font("Determination Mono Web", Font.PLAIN, 16));
		btn12PercentRNG.setBounds(234, 209, 223, 64);
		contentPane.add(btn12PercentRNG);
		
		JLabel lblNewLabel = new JLabel("Jago's RNG Shenanigans");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Determination Mono Web", Font.PLAIN, 24));
		lblNewLabel.setBounds(56, 10, 372, 41);
		contentPane.add(lblNewLabel);
		
		btnJustitiaRNG = new JButton("Justitia RNG");
		btnJustitiaRNG.setFont(new Font("Determination Mono Web", Font.PLAIN, 20));
		btnJustitiaRNG.setBounds(24, 283, 200, 64);
		contentPane.add(btnJustitiaRNG);
		
		btn33PercentRNG = new JButton("Void Tea Overheal RNG");
		btn33PercentRNG.setFont(new Font("Determination Mono Web", Font.PLAIN, 16));
		btn33PercentRNG.setBounds(255, 283, 200, 64);
		contentPane.add(btn33PercentRNG);
		
		JButton btn50PercentRNG = new JButton("Abysmal Surge RNG");
		btn50PercentRNG.setFont(new Font("Determination Mono Web", Font.PLAIN, 20));
		btn50PercentRNG.setBounds(24, 359, 200, 64);
		contentPane.add(btn50PercentRNG);
		
		JButton btnOtherRNG = new JButton("Other RNG");
		btnOtherRNG.setFont(new Font("Determination Mono Web", Font.PLAIN, 20));
		btnOtherRNG.setBounds(255, 357, 200, 64);
		contentPane.add(btnOtherRNG);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}
