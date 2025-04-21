package windows;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;
import javax.swing.border.*;

public class SoakStatusRNG extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton btnRoll;
	private JSpinner spinnerEnemyCount;
	private JTextArea textAreaRNGResults;
	private int effectCount;
	private JLabel lblEffectCount;

	public SoakStatusRNG(JFrame parent) {
		super(parent, true);
		effectCount=0;

		setResizable(false);
		setTitle("Soak Status RNG");
		setBounds(100, 100, 449, 290);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JTextArea textAreaChances = new JTextArea();
		textAreaChances.setLineWrap(true);
		textAreaChances.setWrapStyleWord(true);
		textAreaChances.setEditable(false);
		textAreaChances.setText("Aqua line skills\r\n40% chance to Soak");
		textAreaChances.setBackground(UIManager.getColor("Button.background"));
		textAreaChances.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		textAreaChances.setBounds(10, 16, 184, 50);
		contentPanel.add(textAreaChances);

		btnRoll = new JButton("Roll");
		btnRoll.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		btnRoll.setBounds(314, 30, 111, 27);
		contentPanel.add(btnRoll);
		btnRoll.addActionListener(this);

		JLabel lblEnemyCount = new JLabel("Enemy count:");
		lblEnemyCount.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		lblEnemyCount.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnemyCount.setBounds(186, 13, 129, 28);
		contentPanel.add(lblEnemyCount);

		spinnerEnemyCount = new JSpinner();
		spinnerEnemyCount.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		spinnerEnemyCount.setModel(new SpinnerNumberModel(1, 1, 90, 1));
		spinnerEnemyCount.setBounds(204, 45, 85, 40);
		contentPanel.add(spinnerEnemyCount);

		textAreaRNGResults = new JTextArea();
		textAreaRNGResults.setWrapStyleWord(true);
		textAreaRNGResults.setLineWrap(true);
		textAreaRNGResults.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		textAreaRNGResults.setEditable(false);
		textAreaRNGResults.setBackground(UIManager.getColor("Button.background"));
		textAreaRNGResults.setBounds(10, 95, 415, 106);
		contentPanel.add(textAreaRNGResults);

		JScrollPane scrollPaneResults = new JScrollPane(textAreaRNGResults);
		scrollPaneResults.setBounds(10, 95, 415, 106);
		contentPanel.add(scrollPaneResults);
		
		lblEffectCount = new JLabel("Effect count: "+effectCount);
		lblEffectCount.setHorizontalAlignment(SwingConstants.CENTER);
		lblEffectCount.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		lblEffectCount.setBounds(10, 211, 415, 28);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRoll) {
			Random r = new Random();
			int result, count=(int)spinnerEnemyCount.getValue();
			effectCount=0;
			result = r.nextInt(5)+1;
			StringBuilder results = new StringBuilder("");
			for (int i = 0; i < count; i++) {
				result = r.nextInt(10)+1;
				if (result<=2) {
					results.append("Enemy ").append(i+1).append(" was soaked! Exact value: ").append(result).append("\n");
					effectCount++;
				} else {
					results.append("The effect didn't trigger on enemy ").append(i+1).append(". Exact value: ").append(result).append("\n");
				}
			}
			textAreaRNGResults.setText(results.toString());
			if ((int)spinnerEnemyCount.getValue()>5) {
				contentPanel.add(lblEffectCount);
				lblEffectCount.setText("Effect count: "+effectCount);
			}
		}
	}
}
