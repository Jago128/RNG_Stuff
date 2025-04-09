package windows;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

public class CharacterRandomizer extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JSpinner spinnerRollCount;
	private JButton btnRolling;
	private JTextArea rngResults;

	public CharacterRandomizer() {
		setTitle("Character Randomizer");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblRollCount = new JLabel("Roll count:");
		lblRollCount.setHorizontalAlignment(SwingConstants.CENTER);
		lblRollCount.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		lblRollCount.setBounds(240, 11, 170, 37);
		contentPanel.add(lblRollCount);

		spinnerRollCount = new JSpinner();
		spinnerRollCount.setModel(new SpinnerNumberModel(1, 1, 50, 1));
		spinnerRollCount.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		spinnerRollCount.setBounds(283, 47, 90, 37);
		contentPanel.add(spinnerRollCount);

		btnRolling = new JButton("Do the rolls");
		btnRolling.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		btnRolling.setBounds(266, 95, 144, 55);
		contentPanel.add(btnRolling);
		
		JTextArea choices = new JTextArea();
		choices.setBackground(UIManager.getColor("Button.background"));
		choices.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		choices.setText("Available choices:\r\nStarfish\r\nStara\r\nChara\r\nStarfira");
		choices.setEditable(false);
		choices.setWrapStyleWord(true);
		choices.setLineWrap(true);
		choices.setBounds(45, 11, 170, 144);
		contentPanel.add(choices);
		
		rngResults = new JTextArea();
		rngResults.setEditable(false);
		rngResults.setLineWrap(true);
		rngResults.setWrapStyleWord(true);
		rngResults.setFont(new Font("Determination Mono Web", Font.PLAIN, 11));
		rngResults.setBackground(UIManager.getColor("Button.background"));
		rngResults.setBounds(10, 166, 414, 84);
		contentPanel.add(rngResults);
		
		JScrollPane scrollPane = new JScrollPane(rngResults);
		scrollPane.setBounds(10, 166, 414, 84);
		contentPanel.add(scrollPane);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btnRolling) {
			
		}
	}
}
