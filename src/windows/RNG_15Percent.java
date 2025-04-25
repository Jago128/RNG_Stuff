package windows;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;
import javax.swing.border.*;

public class RNG_15Percent extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextArea textAreaRNGResults;
	private JSpinner spinnerRollCount;
	private JButton btnRoll;
	private JTextArea txtrCharaDualelementalBeam;

	public RNG_15Percent(JFrame parent) {
		super(parent, true);
		
		setResizable(false);
		setTitle("15% Chance Stuff");
		setBounds(100, 100, 800, 370);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JTextArea textAreaChoices = new JTextArea();
		textAreaChoices.setBackground(UIManager.getColor("Button.background"));
		textAreaChoices.setEditable(false);
		textAreaChoices.setWrapStyleWord(true);
		textAreaChoices.setLineWrap(true);
		textAreaChoices.setText("Stara:\r\nFiery Sword Burn RNG\r\n(Underfell Outfit) Conch Slasher Sting RNG");
		textAreaChoices.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		textAreaChoices.setBounds(10, 11, 425, 144);
		contentPanel.add(textAreaChoices);
		
		spinnerRollCount = new JSpinner();
		spinnerRollCount.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		spinnerRollCount.setModel(new SpinnerNumberModel(1, 1, 30, 1));
		spinnerRollCount.setBounds(33, 256, 79, 30);
		contentPanel.add(spinnerRollCount);
		
		JLabel lblRollCount = new JLabel("Roll count:");
		lblRollCount.setHorizontalAlignment(SwingConstants.CENTER);
		lblRollCount.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		lblRollCount.setBounds(21, 226, 117, 20);
		contentPanel.add(lblRollCount);
		
		btnRoll = new JButton("Roll");
		btnRoll.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		btnRoll.setBounds(148, 242, 95, 30);
		contentPanel.add(btnRoll);
		btnRoll.addActionListener(this);
		
		textAreaRNGResults = new JTextArea();
		textAreaRNGResults.setEditable(false);
		textAreaRNGResults.setLineWrap(true);
		textAreaRNGResults.setWrapStyleWord(true);
		textAreaRNGResults.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		textAreaRNGResults.setBackground(UIManager.getColor("Button.background"));
		textAreaRNGResults.setBounds(265, 179, 511, 144);
		contentPanel.add(textAreaRNGResults);
		
		JScrollPane scrollPaneResults = new JScrollPane(textAreaRNGResults);
		scrollPaneResults.setBounds(265, 179, 511, 144);
		contentPanel.add(scrollPaneResults);
		
		txtrCharaDualelementalBeam = new JTextArea();
		txtrCharaDualelementalBeam.setWrapStyleWord(true);
		txtrCharaDualelementalBeam.setText("Chara:\r\nDual-Elemental Beam Burn RNG");
		txtrCharaDualelementalBeam.setLineWrap(true);
		txtrCharaDualelementalBeam.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		txtrCharaDualelementalBeam.setEditable(false);
		txtrCharaDualelementalBeam.setBackground(UIManager.getColor("Button.background"));
		txtrCharaDualelementalBeam.setBounds(445, 12, 331, 143);
		contentPanel.add(txtrCharaDualelementalBeam);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btnRoll) {
			Random r = new Random();
			int result, count=(int)spinnerRollCount.getValue();
			StringBuilder results = new StringBuilder("");
			for (int i=0; i<count; i++) {
				result = r.nextInt(20)+1;
				if (result>=18) {
					results.append("Roll ").append(i+1).append(" result: Effect triggered! Exact value: ").append(result).append("\n");
				} else {
					results.append("Roll ").append(i+1).append(" result: Nothing happened. Exact value: ").append(result).append("\n");
				}
			}
			textAreaRNGResults.setText(results.toString());
		}
	}
}
