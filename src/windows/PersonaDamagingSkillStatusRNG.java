package windows;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;
import javax.swing.border.*;

public class PersonaDamagingSkillStatusRNG extends JDialog implements ActionListener{

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextArea textAreaRNGResults;
	private JSpinner spinnerEnemyCount;
	private JButton btnRoll;
	private JCheckBox chckbxChimera;
	private JLabel lblEffectCount;
	private int effectCount;

	public PersonaDamagingSkillStatusRNG(JFrame parent) {
		super(parent, true);
		effectCount=0;

		setResizable(false);
		setTitle("Persona Skill RNG");
		setBounds(100, 100, 370, 270);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblEnemyCount = new JLabel("Enemy count:");
		lblEnemyCount.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		lblEnemyCount.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnemyCount.setBounds(33, 22, 129, 28);
		contentPanel.add(lblEnemyCount);

		chckbxChimera = new JCheckBox("Chimera or not?");
		chckbxChimera.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxChimera.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		chckbxChimera.setBounds(180, 25, 168, 23);
		contentPanel.add(chckbxChimera);

		spinnerEnemyCount = new JSpinner();
		spinnerEnemyCount.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		spinnerEnemyCount.setModel(new SpinnerNumberModel(1, 1, 30, 1));
		spinnerEnemyCount.setBounds(53, 50, 85, 40);
		contentPanel.add(spinnerEnemyCount);

		btnRoll = new JButton("Roll");
		btnRoll.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		btnRoll.setBounds(227, 62, 89, 28);
		contentPanel.add(btnRoll);
		btnRoll.addActionListener(this);

		textAreaRNGResults = new JTextArea();
		textAreaRNGResults.setEditable(false);
		textAreaRNGResults.setLineWrap(true);
		textAreaRNGResults.setWrapStyleWord(true);
		textAreaRNGResults.setFont(new Font("Determination Mono Web", Font.PLAIN, 11));
		textAreaRNGResults.setBackground(UIManager.getColor("Button.background"));
		textAreaRNGResults.setBounds(10, 101, 330, 84);
		contentPanel.add(textAreaRNGResults);

		JScrollPane scrollPaneResults = new JScrollPane(textAreaRNGResults);
		scrollPaneResults.setBounds(10, 101, 330, 84);
		contentPanel.add(scrollPaneResults);
		
		lblEffectCount = new JLabel("Effect count: "+effectCount);
		lblEffectCount.setEnabled(false);
		lblEffectCount.setHorizontalAlignment(SwingConstants.CENTER);
		lblEffectCount.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		lblEffectCount.setBounds(12, 195, 336, 28);
		contentPanel.add(lblEffectCount);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btnRoll) {
			Random r = new Random();
			int result, count=(int)spinnerEnemyCount.getValue();
			effectCount=0;
			StringBuilder results = new StringBuilder("");
			if (chckbxChimera.isSelected()) {
				for (int i = 0; i < count; i++) {
					result = r.nextInt(25)+1;
					if (result>=23) {
						results.append("Enemy ").append(i+1).append(" was hit with a status! Exact value: ").append(result).append("\n");
						effectCount++;
					} else {
						results.append("No status effect on enemy ").append(i+1).append(". Exact value: ").append(result).append("\n");
					}
				}
			} else {
				for (int i = 0; i < count; i++) {
					result = r.nextInt(25)+1;
					if (result>=24) {
						results.append("Enemy ").append(i+1).append(" was hit with a status! Exact value: ").append(result).append("\n");
						effectCount++;
					} else {
						results.append("No status effect on enemy ").append(i+1).append(". Exact value: ").append(result).append("\n");
					}
				}
			}
			textAreaRNGResults.setText(results.toString());
			if ((int)spinnerEnemyCount.getValue()>5) {
				lblEffectCount.setEnabled(true);
				lblEffectCount.setText("Effect count: "+effectCount);
			}
		}
	}
}
