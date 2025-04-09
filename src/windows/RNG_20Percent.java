package windows;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;
import javax.swing.border.*;

public class RNG_20Percent extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JSpinner spinnerRollCount;
	private JButton btnRoll;
	private JTextArea txtrRNGResults;

	public RNG_20Percent(JFrame parent) {
		super(parent, true);
		setBounds(100, 100, 400, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		JTextArea txtrChoices = new JTextArea();
		txtrChoices.setBackground(UIManager.getColor("Button.background"));
		txtrChoices.setEditable(false);
		txtrChoices.setWrapStyleWord(true);
		txtrChoices.setLineWrap(true);
		txtrChoices.setText("Stara:\r\nConch Destroyer Crit RNG\r\n\r\nChara:\r\nFiery Beam Burn RNG\r\nFrost Snap Spread RNG");
		txtrChoices.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		txtrChoices.setBounds(20, 11, 227, 124);
		contentPanel.add(txtrChoices);
		
		spinnerRollCount = new JSpinner();
		spinnerRollCount.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		spinnerRollCount.setModel(new SpinnerNumberModel(1, 1, 10, 1));
		spinnerRollCount.setBounds(285, 55, 61, 30);
		contentPanel.add(spinnerRollCount);
		
		JLabel lblRollCount = new JLabel("Roll count:");
		lblRollCount.setHorizontalAlignment(SwingConstants.CENTER);
		lblRollCount.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		lblRollCount.setBounds(257, 24, 117, 20);
		contentPanel.add(lblRollCount);
		
		btnRoll = new JButton("Roll");
		btnRoll.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		btnRoll.setBounds(263, 96, 95, 30);
		contentPanel.add(btnRoll);
		btnRoll.addActionListener(this);
		
		txtrRNGResults = new JTextArea();
		txtrRNGResults.setEditable(false);
		txtrRNGResults.setLineWrap(true);
		txtrRNGResults.setWrapStyleWord(true);
		txtrRNGResults.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		txtrRNGResults.setBackground(UIManager.getColor("Button.background"));
		txtrRNGResults.setBounds(20, 146, 334, 100);
		contentPanel.add(txtrRNGResults);
		
		JScrollPane scrollPaneResults = new JScrollPane(txtrRNGResults);
		scrollPaneResults.setBounds(20, 146, 334, 100);
		contentPanel.add(scrollPaneResults);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btnRoll) {
			Random r = new Random();
			int result, count=(int)spinnerRollCount.getValue();
			StringBuilder results = new StringBuilder("");
			for (int i=0; i<count; i++) {
				result = r.nextInt(5-1)+1;
				if (result==5) {
					results.append("Roll ").append(i+1).append("result: Effect triggered/Crit! Exact value: "+result).append("\n");
				} else {
					results.append("Roll ").append(i+1).append("result: Nothing happened. Exact value: "+result).append("\n");
				}
			}
			txtrRNGResults.setText(results.toString());
		}
	}
}
