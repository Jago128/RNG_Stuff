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
	private JTextArea textAreaRNGResults;

	public RNG_20Percent(JFrame parent) {
		super(parent, true);
		
		setResizable(false);
		setTitle("20% Chance Stuff");
		setBounds(100, 100, 390, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JTextArea textAreaChoices = new JTextArea();
		textAreaChoices.setBackground(UIManager.getColor("Button.background"));
		textAreaChoices.setEditable(false);
		textAreaChoices.setWrapStyleWord(true);
		textAreaChoices.setLineWrap(true);
		textAreaChoices.setText("Stara:\nConch Destroyer Crit RNG\n\nChara:\nFiery Beam Burn RNG\nFrost Snap Spread RNG");
		textAreaChoices.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		textAreaChoices.setBounds(20, 11, 239, 125);
		contentPanel.add(textAreaChoices);
		
		spinnerRollCount = new JSpinner();
		spinnerRollCount.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		spinnerRollCount.setModel(new SpinnerNumberModel(1, 1, 30, 1));
		spinnerRollCount.setBounds(287, 55, 61, 30);
		contentPanel.add(spinnerRollCount);
		
		JLabel lblRollCount = new JLabel("Roll count:");
		lblRollCount.setHorizontalAlignment(SwingConstants.CENTER);
		lblRollCount.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		lblRollCount.setBounds(259, 24, 117, 20);
		contentPanel.add(lblRollCount);
		
		btnRoll = new JButton("Roll");
		btnRoll.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		btnRoll.setBounds(265, 96, 95, 30);
		contentPanel.add(btnRoll);
		btnRoll.addActionListener(this);
		
		textAreaRNGResults = new JTextArea();
		textAreaRNGResults.setEditable(false);
		textAreaRNGResults.setLineWrap(true);
		textAreaRNGResults.setWrapStyleWord(true);
		textAreaRNGResults.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		textAreaRNGResults.setBackground(UIManager.getColor("Button.background"));
		textAreaRNGResults.setBounds(20, 146, 334, 100);
		contentPanel.add(textAreaRNGResults);
		
		JScrollPane scrollPaneResults = new JScrollPane(textAreaRNGResults);
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
				result = r.nextInt(5)+1;
				if (result==5) {
					results.append("Roll ").append(i+1).append(" result: Effect triggered/Crit! Exact value: "+result).append("\n");
				} else {
					results.append("Roll ").append(i+1).append(" result: Nothing happened. Exact value: "+result).append("\n");
				}
			}
			textAreaRNGResults.setText(results.toString());
		}
	}
}
