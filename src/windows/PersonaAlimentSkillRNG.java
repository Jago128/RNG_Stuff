package windows;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;
import javax.swing.border.*;

public class PersonaAlimentSkillRNG extends JDialog implements ActionListener{

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JSpinner spinnerEnemyCount;
	private JButton btnRoll;
	private JCheckBox chckbxTargetting;
	private JTextArea textAreaRNGResults;

	public PersonaAlimentSkillRNG(JFrame parent) {
		super(parent, true);
		
		setResizable(false);
		setTitle("Persona Skill RNG");
		setBounds(100, 100, 462, 240);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblEnemyCount = new JLabel("Enemy count:");
		lblEnemyCount.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		lblEnemyCount.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnemyCount.setBounds(33, 22, 129, 28);
		contentPanel.add(lblEnemyCount);

		chckbxTargetting = new JCheckBox("Single or Multiple targets?");
		chckbxTargetting.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxTargetting.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		chckbxTargetting.setBounds(157, 6, 285, 23);
		contentPanel.add(chckbxTargetting);

		spinnerEnemyCount = new JSpinner();
		spinnerEnemyCount.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		spinnerEnemyCount.setModel(new SpinnerNumberModel(1, 1, 30, 1));
		spinnerEnemyCount.setBounds(53, 50, 85, 40);
		contentPanel.add(spinnerEnemyCount);

		btnRoll = new JButton("Roll");
		btnRoll.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		btnRoll.setBounds(157, 66, 89, 28);
		contentPanel.add(btnRoll);
		btnRoll.addActionListener(this);
		
		JTextArea textAreaChoice = new JTextArea();
		textAreaChoice.setText("Not Selected: Single Target\r\nSelected: All Targets\r\n");
		textAreaChoice.setWrapStyleWord(true);
		textAreaChoice.setLineWrap(true);
		textAreaChoice.setFont(new Font("Determination Mono Web", Font.PLAIN, 16));
		textAreaChoice.setEditable(false);
		textAreaChoice.setBackground(UIManager.getColor("Button.background"));
		textAreaChoice.setBounds(167, 27, 257, 40);
		contentPanel.add(textAreaChoice);
		
		textAreaRNGResults = new JTextArea();
		textAreaRNGResults.setWrapStyleWord(true);
		textAreaRNGResults.setLineWrap(true);
		textAreaRNGResults.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		textAreaRNGResults.setEditable(false);
		textAreaRNGResults.setBackground(UIManager.getColor("Button.background"));
		textAreaRNGResults.setBounds(10, 100, 432, 93);
		contentPanel.add(textAreaRNGResults);
		
		JScrollPane scrollPaneResults = new JScrollPane(textAreaRNGResults);
		scrollPaneResults.setBounds(10, 100, 432, 93);
		contentPanel.add(scrollPaneResults); 
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btnRoll) {
			Random r = new Random();
			int result, count=(int)spinnerEnemyCount.getValue();
			StringBuilder results = new StringBuilder("");
			if (!chckbxTargetting.isSelected()) {
				for (int i = 0; i < count; i++) {
					result = r.nextInt(10)+1;
					if (result<=7) {
						results.append("Enemy ").append(i+1).append(" was hit with a status! Exact value: ").append(result).append("\n");
					} else {
						results.append("No status effect on enemy ").append(i+1).append(". Exact value: ").append(result).append("\n");
					}
				}
			} else {
				for (int i = 0; i < count; i++) {
					result = r.nextInt(2)+1;
					if (result==2) {
						results.append("Enemy ").append(i+1).append(" was hit with a status! Exact value: ").append(result).append("\n");
					} else {
						results.append("No status effect on enemy ").append(i+1).append(". Exact value: ").append(result).append("\n");
					}
				}
			}
			textAreaRNGResults.setText(results.toString());
		}
	}
}
