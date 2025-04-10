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
	private JTextArea textAreaRNGResults;

	public CharacterRandomizer(JFrame parent) {
		super(parent, true);
		
		setResizable(false);
		setTitle("Character Randomizer");
		setBounds(100, 100, 390, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblRollCount = new JLabel("Roll count:");
		lblRollCount.setHorizontalAlignment(SwingConstants.CENTER);
		lblRollCount.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		lblRollCount.setBounds(235, 11, 141, 37);
		contentPanel.add(lblRollCount);

		spinnerRollCount = new JSpinner();
		spinnerRollCount.setModel(new SpinnerNumberModel(1, 1, 15, 1));
		spinnerRollCount.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		spinnerRollCount.setBounds(257, 54, 90, 37);
		contentPanel.add(spinnerRollCount);

		btnRolling = new JButton("Rolls");
		btnRolling.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		btnRolling.setBounds(257, 101, 90, 55);
		contentPanel.add(btnRolling);
		btnRolling.addActionListener(this);

		JTextArea textAreaChoices = new JTextArea();
		textAreaChoices.setBackground(UIManager.getColor("Button.background"));
		textAreaChoices.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		textAreaChoices.setText("Available choices:\nStarfish\nStara\nChara\nStarfira");
		textAreaChoices.setEditable(false);
		textAreaChoices.setWrapStyleWord(true);
		textAreaChoices.setLineWrap(true);
		textAreaChoices.setBounds(20, 11, 182, 106);
		contentPanel.add(textAreaChoices);

		textAreaRNGResults = new JTextArea();
		textAreaRNGResults.setEditable(false);
		textAreaRNGResults.setLineWrap(true);
		textAreaRNGResults.setWrapStyleWord(true);
		textAreaRNGResults.setFont(new Font("Determination Mono Web", Font.PLAIN, 11));
		textAreaRNGResults.setBackground(UIManager.getColor("Button.background"));
		textAreaRNGResults.setBounds(10, 166, 349, 84);
		contentPanel.add(textAreaRNGResults);

		JScrollPane scrollPaneResults = new JScrollPane(textAreaRNGResults);
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
				result = r.nextInt(4)+1;
				switch (result) {
				case 1:
					results.append("Roll ").append(i+1).append(" result: ").append("Starfish. Exact value: "+result).append("\n");
					break;
					
				case 2:
					results.append("Roll ").append(i+1).append(" result: ").append("Stara. Exact value: "+result).append("\n");
					break;
					
				case 3:
					results.append("Roll ").append(i+1).append(" result: ").append("Chara. Exact value:"+result).append("\n");
					break;
					
				case 4:
					results.append("Roll ").append(i+1).append(" result: ").append("Starfira. Exact value:"+result).append("\n");
					break;
				}
			}
			textAreaRNGResults.setText(results.toString());
		}
	}
}
