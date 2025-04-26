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
	private JCheckBox chckbxRampage;

	public RNG_10Percent(JFrame parent) {
		super(parent, true);
		
		setResizable(false);
		setTitle("10% Chance Stuff");
		setBounds(100, 100, 790, 371);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JTextArea textAreaStarfish = new JTextArea();
		textAreaStarfish.setBackground(UIManager.getColor("Button.background"));
		textAreaStarfish.setEditable(false);
		textAreaStarfish.setWrapStyleWord(true);
		textAreaStarfish.setLineWrap(true);
		textAreaStarfish.setText("Starfish:\nTemmie Armor DMG heal\nIce Beam Freeze RNG");
		textAreaStarfish.setFont(new Font("Determination Mono Web", Font.PLAIN, 16));
		textAreaStarfish.setBounds(12, 11, 198, 143);
		contentPanel.add(textAreaStarfish);

		spinnerRollCount = new JSpinner();
		spinnerRollCount.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		spinnerRollCount.setModel(new SpinnerNumberModel(1, 1, 50, 1));
		spinnerRollCount.setBounds(22, 194, 61, 30);
		contentPanel.add(spinnerRollCount);

		JLabel lblRollCount = new JLabel("Roll count:");
		lblRollCount.setHorizontalAlignment(SwingConstants.CENTER);
		lblRollCount.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		lblRollCount.setBounds(12, 164, 121, 20);
		contentPanel.add(lblRollCount);

		btnRoll = new JButton("Roll");
		btnRoll.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		btnRoll.setBounds(120, 183, 90, 30);
		contentPanel.add(btnRoll);
		btnRoll.addActionListener(this);

		textAreaRNGResults = new JTextArea();
		textAreaRNGResults.setEditable(false);
		textAreaRNGResults.setLineWrap(true);
		textAreaRNGResults.setWrapStyleWord(true);
		textAreaRNGResults.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		textAreaRNGResults.setBackground(UIManager.getColor("Button.background"));
		textAreaRNGResults.setBounds(210, 110, 526, 138);
		contentPanel.add(textAreaRNGResults);

		JScrollPane scrollPaneResults = new JScrollPane(textAreaRNGResults);
		scrollPaneResults.setBounds(232, 186, 526, 138);
		contentPanel.add(scrollPaneResults);
		
		chckbxElementalBomb = new JCheckBox("Elemental Bomb");
		chckbxElementalBomb.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		chckbxElementalBomb.setBounds(32, 230, 168, 36);
		contentPanel.add(chckbxElementalBomb);
		
		JTextArea textAreaStara = new JTextArea();
		textAreaStara.setWrapStyleWord(true);
		textAreaStara.setText("Stara:\nConch Slasher/Fusion Crit RNG\nFireball Burn RNG\nFire Breath Burn RNG (End of attack)\nThunderbolt/Chain Lightning/Thundercloud Paralysis RNG\n(Unavailable) Rampage Crit RNG");
		textAreaStara.setLineWrap(true);
		textAreaStara.setFont(new Font("Determination Mono Web", Font.PLAIN, 16));
		textAreaStara.setEditable(false);
		textAreaStara.setBackground(UIManager.getColor("Button.background"));
		textAreaStara.setBounds(210, 11, 297, 165);
		contentPanel.add(textAreaStara);
		
		JTextArea textAreaChara = new JTextArea();
		textAreaChara.setWrapStyleWord(true);
		textAreaChara.setText("Chara:\nElemental Bomb Status RNG\nFire Slash/Fireball Burn RNG\nFrost Snap Infliction RNG");
		textAreaChara.setLineWrap(true);
		textAreaChara.setFont(new Font("Determination Mono Web", Font.PLAIN, 16));
		textAreaChara.setEditable(false);
		textAreaChara.setBackground(UIManager.getColor("Button.background"));
		textAreaChara.setBounds(506, 11, 252, 155);
		contentPanel.add(textAreaChara);
		
		chckbxRampage = new JCheckBox("Rampage");
		chckbxRampage.setEnabled(false);
		chckbxRampage.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		chckbxRampage.setBounds(32, 271, 168, 36);
		contentPanel.add(chckbxRampage);
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
					if (chckbxElementalBomb.isSelected()&&!chckbxRampage.isSelected()) {
						elementalBombTriggers++;
					} else if (chckbxRampage.isSelected()&&!chckbxElementalBomb.isSelected()) {
						Random r1 = new Random();
						int rampage = r1.nextInt(3)+1;
						switch (rampage) {
						case 1:
							results.append("Rampage hit once.").append("\n");
							break;
							
						case 2:
							results.append("Rampage hit twice.").append("\n");
							break;
							
						case 3:
							results.append("Rampage hit thrice.").append("\n");
							break;
						}
					}
				} else {
					results.append("Roll ").append(i+1).append(" result: Nothing happened. Exact value: "+result).append("\n");
				}
			}
			if (elementalBombTriggers>0) {
				ElementalBombStatusedRNG dialog = new ElementalBombStatusedRNG(this, elementalBombTriggers);
				dialog.setVisible(true);
			} else {
				textAreaRNGResults.setText(results.toString());
			}
		}
	}
}
