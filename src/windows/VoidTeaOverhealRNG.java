package windows;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;
import javax.swing.border.*;

public class VoidTeaOverhealRNG extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton btnRoll;
	private JLabel lblResult;

	public VoidTeaOverhealRNG(JFrame parent) {
		super(parent, true);

		setResizable(false);
		setTitle("Void Tea Overheal RNG");
		setBounds(100, 100, 700, 160);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		btnRoll = new JButton("Roll");
		btnRoll.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		btnRoll.setBounds(97, 66, 95, 30);
		contentPanel.add(btnRoll);
		btnRoll.addActionListener(this);

		lblResult = new JLabel("");
		lblResult.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		lblResult.setHorizontalAlignment(SwingConstants.CENTER);
		lblResult.setBounds(303, 11, 373, 102);
		contentPanel.add(lblResult);

		JLabel lblChances = new JLabel("33% chance to overheal (+20 HP)");
		lblChances.setHorizontalAlignment(SwingConstants.CENTER);
		lblChances.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		lblChances.setBounds(6, 26, 298, 30);
		contentPanel.add(lblChances);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRoll) {
			Random r = new Random();
			int result;
			result = r.nextInt(3) + 1;
			if (result == 3) {
				lblResult.setText("Overheal triggered! Exact value: " + result);
			} else {
				lblResult.setText("No extra effects. Exact value: " + result);
			}
		}
	}
}
