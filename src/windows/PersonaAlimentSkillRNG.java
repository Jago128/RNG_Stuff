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
	private JLabel lblEffectCount;
	private int effectCount;

	public PersonaAlimentSkillRNG(JFrame parent) {
		super(parent, true);
		effectCount=0;
		
		setResizable(false);
		setTitle("Persona Skill RNG");
		setBounds(100, 100, 720, 240);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblEnemyCount = new JLabel("Enemy count:");
		lblEnemyCount.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		lblEnemyCount.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnemyCount.setBounds(10, 6, 129, 28);
		contentPanel.add(lblEnemyCount);

		chckbxTargetting = new JCheckBox("Single or Multiple targets?");
		chckbxTargetting.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxTargetting.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		chckbxTargetting.setBounds(10, 88, 288, 23);
		contentPanel.add(chckbxTargetting);

		spinnerEnemyCount = new JSpinner();
		spinnerEnemyCount.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		spinnerEnemyCount.setModel(new SpinnerNumberModel(1, 1, 30, 1));
		spinnerEnemyCount.setBounds(20, 44, 85, 40);
		contentPanel.add(spinnerEnemyCount);

		btnRoll = new JButton("Roll");
		btnRoll.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		btnRoll.setBounds(20, 165, 89, 28);
		contentPanel.add(btnRoll);
		btnRoll.addActionListener(this);
		
		JTextArea textAreaChoice = new JTextArea();
		textAreaChoice.setText("Not Selected: Single Target\nSelected: All Targets\n");
		textAreaChoice.setWrapStyleWord(true);
		textAreaChoice.setLineWrap(true);
		textAreaChoice.setFont(new Font("Determination Mono Web", Font.PLAIN, 16));
		textAreaChoice.setEditable(false);
		textAreaChoice.setBackground(UIManager.getColor("Button.background"));
		textAreaChoice.setBounds(10, 117, 257, 40);
		contentPanel.add(textAreaChoice);
		
		textAreaRNGResults = new JTextArea();
		textAreaRNGResults.setWrapStyleWord(true);
		textAreaRNGResults.setLineWrap(true);
		textAreaRNGResults.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		textAreaRNGResults.setEditable(false);
		textAreaRNGResults.setBackground(UIManager.getColor("Button.background"));
		textAreaRNGResults.setBounds(304, 9, 386, 187);
		contentPanel.add(textAreaRNGResults);
		
		JScrollPane scrollPaneResults = new JScrollPane(textAreaRNGResults);
		scrollPaneResults.setBounds(304, 9, 386, 187);
		contentPanel.add(scrollPaneResults);
		
		lblEffectCount = new JLabel("Effect count: "+effectCount);
		lblEffectCount.setHorizontalAlignment(SwingConstants.CENTER);
		lblEffectCount.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		lblEffectCount.setBounds(12, 195, 336, 28);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btnRoll) {
			Random r = new Random();
			int result, count=(int)spinnerEnemyCount.getValue();
			effectCount=0;
			StringBuilder results = new StringBuilder("");
			if (!chckbxTargetting.isSelected()) {
				for (int i = 0; i < count; i++) {
					result = r.nextInt(10)+1;
					if (result<=7) {
						results.append("Enemy ").append(i+1).append(" was hit with a status! Exact value: ").append(result).append("\n");
						effectCount++;
					} else {
						results.append("No status effect on enemy ").append(i+1).append(". Exact value: ").append(result).append("\n");
					}
				}
			} else {
				for (int i = 0; i < count; i++) {
					result = r.nextInt(2)+1;
					if (result==2) {
						results.append("Enemy ").append(i+1).append(" was hit with a status! Exact value: ").append(result).append("\n");
						effectCount++;
					} else {
						results.append("No status effect on enemy ").append(i+1).append(". Exact value: ").append(result).append("\n");
					}
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
