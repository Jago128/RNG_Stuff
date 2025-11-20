package windows;

import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class RNGStuff extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnPersonaDMGSkillStatusRNG, btn10PercentRNG, btn15PercentRNG, btn20PercentRNG, btn25PercentRNG,
			btnVoidTeaOverhealRNG, btnSoakStatusRNG, btnOtherRNG;
	private JButton btnCharacterRandomizer;
	private JButton btnPersonaAlimentSkillRNG;
	private JButton btn5PercentRNG;
	private JButton btnTechnicalDownRNG;

	public RNGStuff() {
		setResizable(false);
		setTitle("RNG Stuff");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		btn10PercentRNG = new JButton("10% Stuff");
		btn10PercentRNG.setFont(new Font("Determination Mono Web", Font.PLAIN, 20));
		btn10PercentRNG.setBounds(231, 61, 200, 64);
		contentPane.add(btn10PercentRNG);

		btn15PercentRNG = new JButton("15% Stuff");
		btn15PercentRNG.setFont(new Font("Determination Mono Web", Font.PLAIN, 20));
		btn15PercentRNG.setBounds(441, 61, 200, 64);
		contentPane.add(btn15PercentRNG);

		btn20PercentRNG = new JButton("20% Stuff");
		btn20PercentRNG.setFont(new Font("Determination Mono Web", Font.PLAIN, 20));
		btn20PercentRNG.setBounds(24, 135, 200, 64);
		contentPane.add(btn20PercentRNG);

		btn25PercentRNG = new JButton("25% Stuff");
		btn25PercentRNG.setFont(new Font("Determination Mono Web", Font.PLAIN, 20));
		btn25PercentRNG.setBounds(231, 135, 200, 64);
		contentPane.add(btn25PercentRNG);

		btnSoakStatusRNG = new JButton("Soak Status RNG");
		btnSoakStatusRNG.setFont(new Font("Determination Mono Web", Font.PLAIN, 20));
		btnSoakStatusRNG.setBounds(24, 208, 200, 64);
		contentPane.add(btnSoakStatusRNG);

		btnPersonaDMGSkillStatusRNG = new JButton("Damaging Skill Status RNG");
		btnPersonaDMGSkillStatusRNG.setFont(new Font("Determination Mono Web", Font.PLAIN, 16));
		btnPersonaDMGSkillStatusRNG.setBounds(212, 359, 244, 64);
		contentPane.add(btnPersonaDMGSkillStatusRNG);

		JLabel lblTitle = new JLabel("Jago's RP/Parody RNG Shenanigans");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Determination Mono Web", Font.PLAIN, 24));
		lblTitle.setBounds(151, 10, 401, 41);
		contentPane.add(lblTitle);

		btnVoidTeaOverhealRNG = new JButton("Void Tea Overheal RNG");
		btnVoidTeaOverhealRNG.setFont(new Font("Determination Mono Web", Font.PLAIN, 16));
		btnVoidTeaOverhealRNG.setBounds(441, 136, 214, 64);
		contentPane.add(btnVoidTeaOverhealRNG);

		btnOtherRNG = new JButton("Other RNG");
		btnOtherRNG.setFont(new Font("Determination Mono Web", Font.PLAIN, 20));
		btnOtherRNG.setBounds(455, 281, 200, 64);
		contentPane.add(btnOtherRNG);

		btnCharacterRandomizer = new JButton("Character Randomizer");
		btnCharacterRandomizer.setFont(new Font("Determination Mono Web", Font.PLAIN, 16));
		btnCharacterRandomizer.setBounds(231, 209, 200, 64);
		contentPane.add(btnCharacterRandomizer);

		btnPersonaAlimentSkillRNG = new JButton("Aliment Skill RNG");
		btnPersonaAlimentSkillRNG.setFont(new Font("Determination Mono Web", Font.PLAIN, 16));
		btnPersonaAlimentSkillRNG.setBounds(24, 282, 200, 64);
		contentPane.add(btnPersonaAlimentSkillRNG);

		btn5PercentRNG = new JButton("5% Stuff");
		btn5PercentRNG.setFont(new Font("Determination Mono Web", Font.PLAIN, 20));
		btn5PercentRNG.setBounds(24, 61, 200, 64);
		contentPane.add(btn5PercentRNG);

		btnTechnicalDownRNG = new JButton("Technical Down RNG");
		btnTechnicalDownRNG.setFont(new Font("Determination Mono Web", Font.PLAIN, 16));
		btnTechnicalDownRNG.setBounds(441, 209, 200, 64);
		contentPane.add(btnTechnicalDownRNG);

		btn5PercentRNG.addActionListener(this);
		btn10PercentRNG.addActionListener(this);
		btn15PercentRNG.addActionListener(this);
		btn20PercentRNG.addActionListener(this);
		btn25PercentRNG.addActionListener(this);
		btnTechnicalDownRNG.addActionListener(this);
		btnVoidTeaOverhealRNG.addActionListener(this);
		btnSoakStatusRNG.addActionListener(this);
		btnCharacterRandomizer.addActionListener(this);
		btnOtherRNG.addActionListener(this);
		btnPersonaDMGSkillStatusRNG.addActionListener(this);
		btnPersonaAlimentSkillRNG.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn5PercentRNG) {
			RNG_5Percent dialog = new RNG_5Percent(this);
			dialog.setVisible(true);
		} else if (e.getSource() == btn10PercentRNG) {
			RNG_10Percent dialog = new RNG_10Percent(this);
			dialog.setVisible(true);
		} else if (e.getSource() == btn15PercentRNG) {
			RNG_15Percent dialog = new RNG_15Percent(this);
			dialog.setVisible(true);
		} else if (e.getSource() == btn20PercentRNG) {
			RNG_20Percent dialog = new RNG_20Percent(this);
			dialog.setVisible(true);
		} else if (e.getSource() == btn25PercentRNG) {
			RNG_25Percent dialog = new RNG_25Percent(this);
			dialog.setVisible(true);
		} else if (e.getSource() == btnTechnicalDownRNG) {
			Rank1_2TechnicalDownRNG dialog = new Rank1_2TechnicalDownRNG(this);
			dialog.setVisible(true);
		} else if (e.getSource() == btnVoidTeaOverhealRNG) {
			VoidTeaOverhealRNG dialog = new VoidTeaOverhealRNG(this);
			dialog.setVisible(true);
		} else if (e.getSource() == btnSoakStatusRNG) {
			SoakStatusRNG dialog = new SoakStatusRNG(this);
			dialog.setVisible(true);
		} else if (e.getSource() == btnPersonaDMGSkillStatusRNG) {
			PersonaDamagingSkillStatusRNG dialog = new PersonaDamagingSkillStatusRNG(this);
			dialog.setVisible(true);
		} else if (e.getSource() == btnPersonaAlimentSkillRNG) {
			PersonaAlimentSkillRNG dialog = new PersonaAlimentSkillRNG(this);
			dialog.setVisible(true);
		} else if (e.getSource() == btnOtherRNG) {
			OtherRNG dialog = new OtherRNG(this);
			dialog.setVisible(true);
		} else if (e.getSource() == btnCharacterRandomizer) {
			CharacterRandomizer dialog = new CharacterRandomizer(this);
			dialog.setVisible(true);
		}
	}
}
