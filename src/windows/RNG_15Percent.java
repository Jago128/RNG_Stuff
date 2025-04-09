package windows;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

public class RNG_15Percent extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextArea txtrRNGResults;

	public RNG_15Percent(JFrame parent) {
		super(parent, true);
		setBounds(100, 100, 380, 350);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		JTextArea txtrChoices = new JTextArea();
		txtrChoices.setBackground(UIManager.getColor("Button.background"));
		txtrChoices.setEditable(false);
		txtrChoices.setWrapStyleWord(true);
		txtrChoices.setLineWrap(true);
		txtrChoices.setText("Stara:\r\nFiery Sword Burn RNG\r\nUnderfell Outfit Conch Slasher Sting RNG\r\n\r\nChara:\r\nDual-Elemental Beam Burn RNG");
		txtrChoices.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		txtrChoices.setBounds(20, 11, 238, 161);
		contentPanel.add(txtrChoices);
		
		JSpinner spinnerCount = new JSpinner();
		spinnerCount.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		spinnerCount.setModel(new SpinnerNumberModel(1, 1, 10, 1));
		spinnerCount.setBounds(282, 43, 61, 30);
		contentPanel.add(spinnerCount);
		
		JLabel lblCount = new JLabel("Count:");
		lblCount.setHorizontalAlignment(SwingConstants.CENTER);
		lblCount.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		lblCount.setBounds(268, 12, 88, 20);
		contentPanel.add(lblCount);
		
		JButton btnRoll = new JButton("Roll");
		btnRoll.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		btnRoll.setBounds(267, 84, 89, 30);
		contentPanel.add(btnRoll);
		btnRoll.addActionListener(this);
		
		txtrRNGResults = new JTextArea();
		txtrRNGResults.setEditable(false);
		txtrRNGResults.setLineWrap(true);
		txtrRNGResults.setWrapStyleWord(true);
		txtrRNGResults.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		txtrRNGResults.setBackground(UIManager.getColor("Button.background"));
		txtrRNGResults.setBounds(20, 185, 334, 100);
		contentPanel.add(txtrRNGResults);
		
		JScrollPane scrollPaneResults = new JScrollPane(txtrRNGResults);
		scrollPaneResults.setBounds(20, 185, 334, 100);
		contentPanel.add(scrollPaneResults);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}
