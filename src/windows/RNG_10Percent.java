package windows;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;
import javax.swing.border.*;

public class RNG_10Percent extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextArea txtrRNGResults;
	private JButton btnRoll;
	private JSpinner spinnerRollCount;

	public RNG_10Percent(JFrame parent) {
		super(parent, true);
		setBounds(100, 100, 400, 400);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JTextArea txtrChoices = new JTextArea();
		txtrChoices.setBackground(UIManager.getColor("Button.background"));
		txtrChoices.setEditable(false);
		txtrChoices.setWrapStyleWord(true);
		txtrChoices.setLineWrap(true);
		txtrChoices.setText("Starfish:\r\nTemmie Armor DMG heal\r\n\r\nStara:\r\nConch Slasher Crit\r\n\r\nChara:\r\nElemental Bomb Status RNG\r\nFire Slash Burn RNG\r\nFrost Snap Infliction RNG");
		txtrChoices.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		txtrChoices.setBounds(20, 11, 237, 213);
		contentPanel.add(txtrChoices);

		spinnerRollCount = new JSpinner();
		spinnerRollCount.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		spinnerRollCount.setModel(new SpinnerNumberModel(1, 1, 10, 1));
		spinnerRollCount.setBounds(301, 59, 61, 30);
		contentPanel.add(spinnerRollCount);

		JLabel lblRollCount = new JLabel("Roll count:");
		lblRollCount.setHorizontalAlignment(SwingConstants.CENTER);
		lblRollCount.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		lblRollCount.setBounds(263, 28, 130, 20);
		contentPanel.add(lblRollCount);

		btnRoll = new JButton("Roll");
		btnRoll.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		btnRoll.setBounds(283, 100, 90, 30);
		contentPanel.add(btnRoll);
		btnRoll.addActionListener(this);

		txtrRNGResults = new JTextArea();
		txtrRNGResults.setEditable(false);
		txtrRNGResults.setLineWrap(true);
		txtrRNGResults.setWrapStyleWord(true);
		txtrRNGResults.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		txtrRNGResults.setBackground(UIManager.getColor("Button.background"));
		txtrRNGResults.setBounds(20, 250, 353, 100);
		contentPanel.add(txtrRNGResults);

		JScrollPane scrollPaneResults = new JScrollPane(txtrRNGResults);
		scrollPaneResults.setBounds(20, 250, 353, 100);
		contentPanel.add(scrollPaneResults);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btnRoll) {
			Random r = new Random();
			int result, count=(int)spinnerRollCount.getValue();
			StringBuilder results = new StringBuilder("");
			for (int i=0; i<count; i++) {
				result = r.nextInt(10-1)+1;
				if (result==10) {
					results.append("Roll ").append(i+1).append("result: Effect triggered/Crit! Exact value: "+result).append("\n");
				} else {
					results.append("Roll ").append(i+1).append("result: Nothing happened. Exact value: "+result).append("\n");
				}
			}
			txtrRNGResults.setText(results.toString());
		}
	}
}
