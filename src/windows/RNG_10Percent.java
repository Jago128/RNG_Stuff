package windows;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;
import javax.swing.border.*;

public class RNG_10Percent extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextArea textAreaRNGResults;
	private JButton btnRoll;
	private JSpinner spinnerRollCount;
	private JCheckBox chckbxElementalBomb;

	public RNG_10Percent(JFrame parent) {
		super(parent, true);
		
		setResizable(false);
		setTitle("10% Chance Stuff");
		setBounds(100, 100, 420, 370);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JTextArea textAreaChoices = new JTextArea();
		textAreaChoices.setBackground(UIManager.getColor("Button.background"));
		textAreaChoices.setEditable(false);
		textAreaChoices.setWrapStyleWord(true);
		textAreaChoices.setLineWrap(true);
		textAreaChoices.setText("Starfish:\nTemmie Armor DMG heal\n\nStara:\nConch Slasher/Fusion Crit RNG\n\nChara:\nElemental Bomb Status RNG\nFire Slash Burn RNG\nFrost Snap Infliction RNG");
		textAreaChoices.setFont(new Font("Determination Mono Web", Font.PLAIN, 16));
		textAreaChoices.setBounds(10, 11, 244, 183);
		contentPanel.add(textAreaChoices);

		spinnerRollCount = new JSpinner();
		spinnerRollCount.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		spinnerRollCount.setModel(new SpinnerNumberModel(1, 1, 10, 1));
		spinnerRollCount.setBounds(312, 56, 61, 30);
		contentPanel.add(spinnerRollCount);

		JLabel lblRollCount = new JLabel("Roll count:");
		lblRollCount.setHorizontalAlignment(SwingConstants.CENTER);
		lblRollCount.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		lblRollCount.setBounds(274, 25, 130, 20);
		contentPanel.add(lblRollCount);

		btnRoll = new JButton("Roll");
		btnRoll.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		btnRoll.setBounds(294, 97, 90, 30);
		contentPanel.add(btnRoll);
		btnRoll.addActionListener(this);

		textAreaRNGResults = new JTextArea();
		textAreaRNGResults.setEditable(false);
		textAreaRNGResults.setLineWrap(true);
		textAreaRNGResults.setWrapStyleWord(true);
		textAreaRNGResults.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		textAreaRNGResults.setBackground(UIManager.getColor("Button.background"));
		textAreaRNGResults.setBounds(20, 215, 364, 100);
		contentPanel.add(textAreaRNGResults);

		JScrollPane scrollPaneResults = new JScrollPane(textAreaRNGResults);
		scrollPaneResults.setBounds(20, 215, 364, 100);
		contentPanel.add(scrollPaneResults);
		
		chckbxElementalBomb = new JCheckBox("Elemental Bomb");
		chckbxElementalBomb.setFont(new Font("Determination Mono Web", Font.PLAIN, 14));
		chckbxElementalBomb.setBounds(254, 147, 130, 23);
		contentPanel.add(chckbxElementalBomb);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btnRoll) {
			Random r = new Random();
			int result, count=(int)spinnerRollCount.getValue(), elementalBombTriggers = 0;
			StringBuilder results = new StringBuilder("");
			for (int i=0; i<count; i++) {
				result = r.nextInt(10)+1;
				if (result==10) {
					results.append("Roll ").append(i+1).append(" result: Effect triggered/Crit! Exact value: "+result).append("\n");
					if (chckbxElementalBomb.isSelected()) {
						elementalBombTriggers++;
					}
				} else {
					results.append("Roll ").append(i+1).append(" result: Nothing happened. Exact value: "+result).append("\n");
				}
			}
			if (elementalBombTriggers>0) {
				ElementalBombStuff dialog = new ElementalBombStuff(this, elementalBombTriggers);
				dialog.setVisible(true);
			} else {
				textAreaRNGResults.setText(results.toString());
			}
		}
	}
}
