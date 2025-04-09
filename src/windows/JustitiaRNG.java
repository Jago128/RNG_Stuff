package windows;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;
import javax.swing.border.*;

public class JustitiaRNG extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton btnRoll;
	private JLabel lblResult;

	public JustitiaRNG(JFrame parent) {
		super(parent, true);
		setTitle("Justitia RNG");
		setBounds(100, 100, 450, 210);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JTextArea txtrChances = new JTextArea();
		txtrChances.setText("Chances:\n40% chance to do a normal attack\n40% chance to do a 5 hit combo\n20% chance to do a 10 hit combo");
		txtrChances.setBackground(UIManager.getColor("Button.background"));
		txtrChances.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		txtrChances.setBounds(10, 11, 293, 100);
		contentPanel.add(txtrChances);

		btnRoll = new JButton("Roll");
		btnRoll.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		btnRoll.setBounds(313, 28, 111, 27);
		contentPanel.add(btnRoll);

		lblResult = new JLabel("");
		lblResult.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		lblResult.setHorizontalAlignment(SwingConstants.CENTER);
		lblResult.setBounds(10, 104, 414, 45);
		contentPanel.add(lblResult);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRoll) {
			Random r = new Random();
			int result = r.nextInt(10-1)+1;
			if (result>=1 && result<=4) {
				lblResult.setText("The result is a normal attack.");
			} else if (result>=5 && result<=8) {
				lblResult.setText("The result is a 5 hit combo.");
			} else {
				lblResult.setText("The result is a 10 hit combo.");
			}
		}
	}
}
