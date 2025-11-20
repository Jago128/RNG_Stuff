package windows;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;
import javax.swing.border.*;

public class Rank1_2TechnicalDownRNG extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextArea textAreaRNGResults;
	private JSpinner spinnerRollCount;
	private JButton btnRoll;

	public Rank1_2TechnicalDownRNG(JFrame parent) {
		super(parent, true);

		setResizable(false);
		setTitle("Rank 1-2 Technical DMG Down RNG");
		setBounds(100, 100, 800, 310);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JTextArea textAreaTechnical = new JTextArea();
		textAreaTechnical.setBackground(UIManager.getColor("Button.background"));
		textAreaTechnical.setEditable(false);
		textAreaTechnical.setWrapStyleWord(true);
		textAreaTechnical.setLineWrap(true);
		textAreaTechnical.setText("(Rank 1-2)\r\nTechnical Damage Down RNG");
		textAreaTechnical.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		textAreaTechnical.setBounds(10, 56, 254, 49);
		contentPanel.add(textAreaTechnical);

		spinnerRollCount = new JSpinner();
		spinnerRollCount.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		spinnerRollCount.setModel(new SpinnerNumberModel(1, 1, 30, 1));
		spinnerRollCount.setBounds(31, 162, 79, 30);
		contentPanel.add(spinnerRollCount);

		JLabel lblRollCount = new JLabel("Roll count:");
		lblRollCount.setHorizontalAlignment(SwingConstants.CENTER);
		lblRollCount.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		lblRollCount.setBounds(10, 132, 117, 20);
		contentPanel.add(lblRollCount);

		btnRoll = new JButton("Roll");
		btnRoll.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		btnRoll.setBounds(134, 130, 95, 30);
		contentPanel.add(btnRoll);
		btnRoll.addActionListener(this);

		textAreaRNGResults = new JTextArea();
		textAreaRNGResults.setEditable(false);
		textAreaRNGResults.setLineWrap(true);
		textAreaRNGResults.setWrapStyleWord(true);
		textAreaRNGResults.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		textAreaRNGResults.setBackground(UIManager.getColor("Button.background"));
		textAreaRNGResults.setBounds(265, 11, 511, 254);
		contentPanel.add(textAreaRNGResults);

		JScrollPane scrollPaneResults = new JScrollPane(textAreaRNGResults);
		scrollPaneResults.setBounds(265, 11, 511, 254);
		contentPanel.add(scrollPaneResults);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRoll) {
			Random r = new Random();
			int result, count = (int) spinnerRollCount.getValue();
			StringBuilder results = new StringBuilder("");
			for (int i = 0; i < count; i++) {
				result = r.nextInt(2) + 1;
				if (result == 2) {
					results.append("Roll ").append(i + 1).append(" result: Enemy was downed! Exact value: ")
							.append(result).append("\n");
				} else {
					results.append("Roll ").append(i + 1).append(" result: Nothing happened. Exact value: ")
							.append(result).append("\n");
				}
			}
			textAreaRNGResults.setText(results.toString());
		}
	}
}
