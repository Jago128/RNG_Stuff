package windows;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;
import javax.swing.border.*;

public class ElementalBombStuff extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton btnRoll;
	private JLabel lblResult;

	public ElementalBombStuff(JDialog parent) {
		super(parent, true);
		setTitle("Justitia RNG");
		setBounds(100, 100, 450, 180);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JTextArea txtrChances = new JTextArea();
		txtrChances.setLineWrap(true);
		txtrChances.setWrapStyleWord(true);
		txtrChances.setEditable(false);
		txtrChances.setText("Elemental Bomb status triggered!\r\n50% chance to Burn\r\n50% chance to Freeze");
		txtrChances.setBackground(UIManager.getColor("Button.background"));
		txtrChances.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		txtrChances.setBounds(10, 11, 299, 71);
		contentPanel.add(txtrChances);

		btnRoll = new JButton("Roll");
		btnRoll.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		btnRoll.setBounds(313, 35, 111, 27);
		contentPanel.add(btnRoll);
		btnRoll.addActionListener(this);

		lblResult = new JLabel("");
		lblResult.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		lblResult.setHorizontalAlignment(SwingConstants.CENTER);
		lblResult.setBounds(10, 84, 414, 45);
		contentPanel.add(lblResult);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRoll) {
			Random r = new Random();
			int result = r.nextInt(2-1)+1;
			switch (result) {
			case 1:
				lblResult.setText("Burn triggered! Exact value: "+result);
				break;
				
			case 2:
				lblResult.setText("Freeze triggered! Exact value: "+result);
				break;
			}
		}
	}
}
