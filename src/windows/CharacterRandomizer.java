package windows;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;
import javax.swing.border.*;

public class CharacterRandomizer extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JSpinner spinnerRollCount;
	private JButton btnRolling;
	private JTextArea rngResults;

	public CharacterRandomizer(JFrame parent) {
		super(parent, true);
		setTitle("Character Randomizer");
		setBounds(100, 100, 390, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblRollCount = new JLabel("Roll count:");
		lblRollCount.setHorizontalAlignment(SwingConstants.CENTER);
		lblRollCount.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		lblRollCount.setBounds(225, 11, 170, 37);
		contentPanel.add(lblRollCount);

		spinnerRollCount = new JSpinner();
		spinnerRollCount.setModel(new SpinnerNumberModel(1, 1, 15, 1));
		spinnerRollCount.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		spinnerRollCount.setBounds(269, 47, 90, 37);
		contentPanel.add(spinnerRollCount);

		btnRolling = new JButton("Rolls");
		btnRolling.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		btnRolling.setBounds(269, 95, 90, 55);
		contentPanel.add(btnRolling);
		btnRolling.addActionListener(this);

		JTextArea txtrChoices = new JTextArea();
		txtrChoices.setBackground(UIManager.getColor("Button.background"));
		txtrChoices.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		txtrChoices.setText("Available choices:\nStarfish\nStara\nChara\nStarfira");
		txtrChoices.setEditable(false);
		txtrChoices.setWrapStyleWord(true);
		txtrChoices.setLineWrap(true);
		txtrChoices.setBounds(59, 11, 170, 104);
		contentPanel.add(txtrChoices);

		rngResults = new JTextArea();
		rngResults.setEditable(false);
		rngResults.setLineWrap(true);
		rngResults.setWrapStyleWord(true);
		rngResults.setFont(new Font("Determination Mono Web", Font.PLAIN, 11));
		rngResults.setBackground(UIManager.getColor("Button.background"));
		rngResults.setBounds(10, 166, 349, 84);
		contentPanel.add(rngResults);

		JScrollPane scrollPaneResults = new JScrollPane(rngResults);
		scrollPaneResults.setBounds(10, 166, 349, 84);
		contentPanel.add(scrollPaneResults);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btnRolling) {
			Random r = new Random();
			int result, count=(int)spinnerRollCount.getValue();
			StringBuilder results = new StringBuilder("");
			for (int i=0; i<count; i++) {
				result = r.nextInt(4-1)+1;
				switch (result) {
				case 1:
					results.append("Roll ").append(i+1).append("result: ").append("Starfish. Exact value: "+result).append("\n");
					break;
					
				case 2:
					results.append("Roll ").append(i+1).append("result: ").append("Stara. Exact value: "+result).append("\n");
					break;
					
				case 3:
					results.append("Roll ").append(i+1).append("result: ").append("Chara. Exact value:"+result).append("\n");
					break;
					
				case 4:
					results.append("Roll ").append(i+1).append("result: ").append("Starfira. Exact value:"+result).append("\n");
					break;
				}
			}
			rngResults.setText(results.toString());
		}
	}
}
