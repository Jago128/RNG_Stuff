package windows;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;
import javax.swing.border.*;

public class PersonaDamagingSkillStatusRNG extends JDialog implements ActionListener{

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextArea rngResults;
	private JSpinner spinnerEnemyCount;
	private JButton btnRoll;
	private JCheckBox chimeraCheckBox;

	public PersonaDamagingSkillStatusRNG(JFrame parent) {
		super(parent, true);
		setTitle("Persona Skill RNG");
		setBounds(100, 100, 370, 240);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblEnemyCount = new JLabel("Enemy count:");
		lblEnemyCount.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		lblEnemyCount.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnemyCount.setBounds(33, 22, 129, 28);
		contentPanel.add(lblEnemyCount);

		chimeraCheckBox = new JCheckBox("Chimera or not?");
		chimeraCheckBox.setHorizontalAlignment(SwingConstants.CENTER);
		chimeraCheckBox.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		chimeraCheckBox.setBounds(180, 25, 168, 23);
		contentPanel.add(chimeraCheckBox);

		spinnerEnemyCount = new JSpinner();
		spinnerEnemyCount.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		spinnerEnemyCount.setModel(new SpinnerNumberModel(1, 1, 5, 1));
		spinnerEnemyCount.setBounds(53, 50, 85, 40);
		contentPanel.add(spinnerEnemyCount);

		btnRoll = new JButton("Roll");
		btnRoll.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		btnRoll.setBounds(227, 62, 89, 28);
		contentPanel.add(btnRoll);

		rngResults = new JTextArea();
		rngResults.setEditable(false);
		rngResults.setLineWrap(true);
		rngResults.setWrapStyleWord(true);
		rngResults.setFont(new Font("Determination Mono Web", Font.PLAIN, 11));
		rngResults.setBackground(UIManager.getColor("Button.background"));
		rngResults.setBounds(10, 101, 330, 84);
		contentPanel.add(rngResults);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btnRoll) {
			Random r = new Random();
			int result, count=(int)spinnerEnemyCount.getValue();
			StringBuilder results = new StringBuilder("");
			if (chimeraCheckBox.isSelected()) {
				for (int i=0; i<count; i++) {
					result = r.nextInt(12-1)+1;
					if (result==12) {
						results.append("Enemy ").append(i+1).append(" was hit with a status!").append("\n");
					} else {
						results.append("No status effect on enemy ").append(i+1).append(".").append("\n");
					}
				}
			} else {
				for (int i=0; i<count; i++) {
					result = r.nextInt(8-1)+1;
					if (result==8) {
						results.append("Enemy ").append(i+1).append(" was hit with a status!").append("\n");
					} else {
						results.append("No status effect on enemy ").append(i+1).append(".").append("\n");
					}
				}
			}
			rngResults.setText(results.toString());
		}
	}
}
