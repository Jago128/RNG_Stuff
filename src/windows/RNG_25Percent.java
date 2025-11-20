package windows;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;
import javax.swing.border.*;

public class RNG_25Percent extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JSpinner spinnerRollCount;
	private JButton btnRoll;
	private JTextArea textAreaRNGResults;

	public RNG_25Percent(JFrame parent) {
		super(parent, true);

		setResizable(false);
		setTitle("25% Stuff");
		setBounds(100, 100, 800, 340);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JTextArea textAreaStara = new JTextArea();
		textAreaStara.setBackground(UIManager.getColor("Button.background"));
		textAreaStara.setEditable(false);
		textAreaStara.setWrapStyleWord(true);
		textAreaStara.setLineWrap(true);
		textAreaStara.setText(
				"Stara:\n(Underfell Outfit) Conch Destroyer Sting RNG\n(Outertale Outfit) Pull on hit RNG\nConch Fusion (Geno Variation) Sting RNG");
		textAreaStara.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		textAreaStara.setBounds(10, 11, 427, 91);
		contentPanel.add(textAreaStara);

		JTextArea textAreaVoidTea = new JTextArea();
		textAreaVoidTea.setWrapStyleWord(true);
		textAreaVoidTea.setText(
				"Other:\r\nVoid Tea increased healing");
		textAreaVoidTea.setLineWrap(true);
		textAreaVoidTea.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		textAreaVoidTea.setEditable(false);
		textAreaVoidTea.setBackground(UIManager.getColor("Button.background"));
		textAreaVoidTea.setBounds(451, 11, 281, 42);
		contentPanel.add(textAreaVoidTea);

		spinnerRollCount = new JSpinner();
		spinnerRollCount.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		spinnerRollCount.setModel(new SpinnerNumberModel(1, 1, 30, 1));
		spinnerRollCount.setBounds(21, 191, 79, 30);
		contentPanel.add(spinnerRollCount);

		JLabel lblRollCount = new JLabel("Roll count:");
		lblRollCount.setHorizontalAlignment(SwingConstants.CENTER);
		lblRollCount.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		lblRollCount.setBounds(10, 161, 117, 20);
		contentPanel.add(lblRollCount);

		btnRoll = new JButton("Roll");
		btnRoll.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		btnRoll.setBounds(123, 179, 95, 30);
		contentPanel.add(btnRoll);
		btnRoll.addActionListener(this);

		textAreaRNGResults = new JTextArea();
		textAreaRNGResults.setEditable(false);
		textAreaRNGResults.setLineWrap(true);
		textAreaRNGResults.setWrapStyleWord(true);
		textAreaRNGResults.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		textAreaRNGResults.setBackground(UIManager.getColor("Button.background"));
		textAreaRNGResults.setBounds(236, 111, 540, 182);
		contentPanel.add(textAreaRNGResults);

		JScrollPane scrollPaneResults = new JScrollPane(textAreaRNGResults);
		scrollPaneResults.setBounds(236, 111, 540, 182);
		contentPanel.add(scrollPaneResults);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRoll) {
			Random r = new Random();
			int result, count = (int) spinnerRollCount.getValue();
			StringBuilder results = new StringBuilder("");
			for (int i = 0; i < count; i++) {
				result = r.nextInt(4) + 1;
				if (result == 4) {
					results.append("Roll ").append(i + 1).append(" result: Effect triggered! Exact value: " + result)
							.append("\n");
				} else {
					results.append("Roll ").append(i + 1).append(" result: Nothing happened. Exact value: " + result)
							.append("\n");
				}
			}
			textAreaRNGResults.setText(results.toString());
		}
	}
}
