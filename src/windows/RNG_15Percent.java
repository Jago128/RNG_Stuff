package windows;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;
import javax.swing.border.*;

public class RNG_15Percent extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextArea txtrRNGResults;
	private JSpinner spinnerRollCount;
	private JButton btnRoll;

	public RNG_15Percent(JFrame parent) {
		super(parent, true);
		setBounds(100, 100, 410, 370);
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
		txtrChoices.setBounds(20, 11, 385, 123);
		contentPanel.add(txtrChoices);
		
		spinnerRollCount = new JSpinner();
		spinnerRollCount.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		spinnerRollCount.setModel(new SpinnerNumberModel(1, 1, 10, 1));
		spinnerRollCount.setBounds(53, 176, 79, 30);
		contentPanel.add(spinnerRollCount);
		
		JLabel lblRollCount = new JLabel("Roll count:");
		lblRollCount.setHorizontalAlignment(SwingConstants.CENTER);
		lblRollCount.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		lblRollCount.setBounds(42, 145, 117, 20);
		contentPanel.add(lblRollCount);
		
		btnRoll = new JButton("Roll");
		btnRoll.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		btnRoll.setBounds(237, 175, 95, 30);
		contentPanel.add(btnRoll);
		btnRoll.addActionListener(this);
		
		txtrRNGResults = new JTextArea();
		txtrRNGResults.setEditable(false);
		txtrRNGResults.setLineWrap(true);
		txtrRNGResults.setWrapStyleWord(true);
		txtrRNGResults.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		txtrRNGResults.setBackground(UIManager.getColor("Button.background"));
		txtrRNGResults.setBounds(20, 217, 334, 100);
		contentPanel.add(txtrRNGResults);
		
		JScrollPane scrollPaneResults = new JScrollPane(txtrRNGResults);
		scrollPaneResults.setBounds(20, 217, 334, 100);
		contentPanel.add(scrollPaneResults);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btnRoll) {
			Random r = new Random();
			int result, count=(int)spinnerRollCount.getValue();
			StringBuilder results = new StringBuilder("");
			for (int i=0; i<count; i++) {
				result = r.nextInt(15-1)+1;
				if (result==15) {
					results.append("Roll ").append(i+1).append("result: Effect triggered! Exact value: "+result).append("\n");
				} else {
					results.append("Roll ").append(i+1).append("result: Nothing happened. Exact value: "+result).append("\n");
				}
			}
			txtrRNGResults.setText(results.toString());
		}
	}
}
