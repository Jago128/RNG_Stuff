package windows;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;
import javax.swing.border.*;

public class SoakStatusRNG extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton btnRoll;
	private JLabel lblResult;

	public SoakStatusRNG(JFrame parent) {
		super(parent, true);
		setTitle("Soak Status RNG");
		setBounds(100, 100, 350, 160);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JTextArea textAreaChances = new JTextArea();
		textAreaChances.setLineWrap(true);
		textAreaChances.setWrapStyleWord(true);
		textAreaChances.setEditable(false);
		textAreaChances.setText("(Mal)Aquadyne\r\n40% chance to Soak");
		textAreaChances.setBackground(UIManager.getColor("Button.background"));
		textAreaChances.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		textAreaChances.setBounds(10, 11, 184, 50);
		contentPanel.add(textAreaChances);

		btnRoll = new JButton("Roll");
		btnRoll.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		btnRoll.setBounds(204, 21, 111, 27);
		contentPanel.add(btnRoll);
		btnRoll.addActionListener(this);

		lblResult = new JLabel("");
		lblResult.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		lblResult.setHorizontalAlignment(SwingConstants.CENTER);
		lblResult.setBounds(10, 59, 305, 45);
		contentPanel.add(lblResult);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRoll) {
			Random r = new Random();
			int result = r.nextInt(40)+1;
			if (result==4) {
				lblResult.setText("The enemy got soaked! Exact value: "+result);
			} else {
				lblResult.setText("The effect didn't trigger. Exact value: "+result);
			}
		}
	}
}
