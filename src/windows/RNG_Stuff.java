package windows;

import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class RNG_Stuff extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btn8_12PercentRNG, btn10PercentRNG, btn15PercentRNG, btn20PercentRNG, btn25PercentRNG, btn33PercentRNG, btn40PercentRNG, btn50PercentRNG, btnJustitiaRNG, btnOtherRNG;

	public RNG_Stuff() {
		setTitle("RNG Stuff");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 490);
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
		
		btn8_12PercentRNG = new JButton("Skill Status RNG");
		btn8_12PercentRNG.setFont(new Font("Determination Mono Web", Font.PLAIN, 16));
		btn8_12PercentRNG.setBounds(255, 229, 202, 64);
		contentPane.add(btn8_12PercentRNG);
		
		JLabel lblTitle = new JLabel("Jago's RNG Shenanigans");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Determination Mono Web", Font.PLAIN, 24));
		lblTitle.setBounds(56, 10, 372, 41);
		contentPane.add(lblTitle);
		
		btnJustitiaRNG = new JButton("Justitia RNG");
		btnJustitiaRNG.setFont(new Font("Determination Mono Web", Font.PLAIN, 20));
		btnJustitiaRNG.setBounds(24, 283, 200, 64);
		contentPane.add(btnJustitiaRNG);
		
		btn33PercentRNG = new JButton("Void Tea Overheal RNG");
		btn33PercentRNG.setFont(new Font("Determination Mono Web", Font.PLAIN, 16));
		btn33PercentRNG.setBounds(244, 295, 211, 64);
		contentPane.add(btn33PercentRNG);
		
		btn50PercentRNG = new JButton("Abysmal Surge RNG");
		btn50PercentRNG.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		btn50PercentRNG.setBounds(24, 359, 200, 64);
		contentPane.add(btn50PercentRNG);
		
		btnOtherRNG = new JButton("Other RNG");
		btnOtherRNG.setFont(new Font("Determination Mono Web", Font.PLAIN, 20));
		btnOtherRNG.setBounds(244, 369, 200, 64);
		contentPane.add(btnOtherRNG);
		
		JLabel lblDamagingSkillsOnly = new JLabel("Damaging Skills only");
		lblDamagingSkillsOnly.setHorizontalAlignment(SwingConstants.CENTER);
		lblDamagingSkillsOnly.setFont(new Font("Determination Mono Web", Font.PLAIN, 16));
		lblDamagingSkillsOnly.setBounds(247, 196, 219, 41);
		contentPane.add(lblDamagingSkillsOnly);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btn10PercentRNG) {
			
		} else if (e.getSource()==btn15PercentRNG) {
			
		} else if (e.getSource()==btn20PercentRNG) {
			
		} else if (e.getSource()==btn25PercentRNG) {
			
		} else if (e.getSource()==btn33PercentRNG) {
			
		} else if (e.getSource()==btn40PercentRNG) {
			
		} else if (e.getSource()==btn50PercentRNG) {
			
		} else if (e.getSource()==btn8_12PercentRNG) {
			
		} else if (e.getSource()==btnJustitiaRNG) {
			
		} else if (e.getSource()==btnOtherRNG) {
			
		}
	}
}
