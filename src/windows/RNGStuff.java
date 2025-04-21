package windows;

import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class RNGStuff extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnPersonaDMGSkillStatusRNG, btn10PercentRNG, btn15PercentRNG, btn20PercentRNG, btn25PercentRNG, btnVoidTeaOverhealRNG, btnSoakStatusRNG, btnJustitiaRNG, btnOtherRNG;
	private JButton btnCharacterRandomizer;
	private JButton btnPersonaAlimentSkillRNG;

	public RNGStuff() {
		setResizable(false);
		setTitle("RNG Stuff");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 710, 400);
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
		btn25PercentRNG.setBounds(474, 61, 200, 64);
		contentPane.add(btn25PercentRNG);

		btnSoakStatusRNG = new JButton("Soak Status RNG");
		btnSoakStatusRNG.setFont(new Font("Determination Mono Web", Font.PLAIN, 20));
		btnSoakStatusRNG.setBounds(255, 135, 200, 64);
		contentPane.add(btnSoakStatusRNG);

		btnPersonaDMGSkillStatusRNG = new JButton("Damaging Skill Status RNG");
		btnPersonaDMGSkillStatusRNG.setFont(new Font("Determination Mono Web", Font.PLAIN, 16));
		btnPersonaDMGSkillStatusRNG.setBounds(234, 209, 244, 64);
		contentPane.add(btnPersonaDMGSkillStatusRNG);

		JLabel lblTitle = new JLabel("Jago's RP/Parody RNG Shenanigans");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Determination Mono Web", Font.PLAIN, 24));
		lblTitle.setBounds(36, 10, 401, 41);
		contentPane.add(lblTitle);

		btnJustitiaRNG = new JButton("Justitia RNG");
		btnJustitiaRNG.setFont(new Font("Determination Mono Web", Font.PLAIN, 20));
		btnJustitiaRNG.setBounds(24, 205, 200, 64);
		contentPane.add(btnJustitiaRNG);

		btnVoidTeaOverhealRNG = new JButton("Void Tea Overheal RNG");
		btnVoidTeaOverhealRNG.setFont(new Font("Determination Mono Web", Font.PLAIN, 16));
		btnVoidTeaOverhealRNG.setBounds(474, 136, 214, 64);
		contentPane.add(btnVoidTeaOverhealRNG);

		btnOtherRNG = new JButton("Other RNG");
		btnOtherRNG.setFont(new Font("Determination Mono Web", Font.PLAIN, 20));
		btnOtherRNG.setBounds(378, 283, 200, 64);
		contentPane.add(btnOtherRNG);

		btnCharacterRandomizer = new JButton("Character Randomizer");
		btnCharacterRandomizer.setFont(new Font("Determination Mono Web", Font.PLAIN, 16));
		btnCharacterRandomizer.setBounds(133, 284, 200, 64);
		contentPane.add(btnCharacterRandomizer);

		btnPersonaAlimentSkillRNG = new JButton("Aliment Skill RNG");
		btnPersonaAlimentSkillRNG.setFont(new Font("Determination Mono Web", Font.PLAIN, 16));
		btnPersonaAlimentSkillRNG.setBounds(488, 209, 200, 64);
		contentPane.add(btnPersonaAlimentSkillRNG);

		btn10PercentRNG.addActionListener(this);
		btn15PercentRNG.addActionListener(this);
		btn20PercentRNG.addActionListener(this);
		btn25PercentRNG.addActionListener(this);
		btnVoidTeaOverhealRNG.addActionListener(this);
		btnSoakStatusRNG.addActionListener(this);
		btnCharacterRandomizer.addActionListener(this);
		btnJustitiaRNG.addActionListener(this);
		btnOtherRNG.addActionListener(this);
		btnPersonaDMGSkillStatusRNG.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btn10PercentRNG) {
			RNG_10Percent dialog = new RNG_10Percent(this);
			dialog.setVisible(true);
		} else if (e.getSource()==btn15PercentRNG) {
			RNG_15Percent dialog = new RNG_15Percent(this);
			dialog.setVisible(true);
		} else if (e.getSource()==btn20PercentRNG) {
			RNG_20Percent dialog = new RNG_20Percent(this);
			dialog.setVisible(true);
		} else if (e.getSource()==btn25PercentRNG) {
			RNG_25Percent dialog = new RNG_25Percent(this);
			dialog.setVisible(true);
		} else if (e.getSource()==btnVoidTeaOverhealRNG) {
			VoidTeaOverhealRNG dialog = new VoidTeaOverhealRNG(this);
			dialog.setVisible(true);
		} else if (e.getSource()==btnSoakStatusRNG) {
			SoakStatusRNG dialog = new SoakStatusRNG(this);
			dialog.setVisible(true);
		} else if (e.getSource()==btnPersonaDMGSkillStatusRNG) {
			PersonaDamagingSkillStatusRNG dialog = new PersonaDamagingSkillStatusRNG(this);
			dialog.setVisible(true);
		} else if (e.getSource()==btnPersonaAlimentSkillRNG) {
			PersonaAlimentSkillRNG dialog = new PersonaAlimentSkillRNG(this);
			dialog.setVisible(true);
		} else if (e.getSource()==btnJustitiaRNG) {
			JustitiaRNG dialog = new JustitiaRNG(this);
			dialog.setVisible(true);
		} else if (e.getSource()==btnOtherRNG) {
			OtherRNG dialog = new OtherRNG(this);
			dialog.setVisible(true);
		} else if (e.getSource()==btnCharacterRandomizer) {
			CharacterRandomizer dialog = new CharacterRandomizer(this);
			dialog.setVisible(true);
		}
	}
}
