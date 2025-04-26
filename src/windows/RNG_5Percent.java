package windows;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;
import javax.swing.border.*;

public class RNG_5Percent extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextArea textAreaRNGResults;
	private JSpinner spinnerRollCount;
	private JButton btnRoll;
	private JCheckBox chckbxTempestSlash;
	private JCheckBox chckbxMyriadSlashes;

	public RNG_5Percent(JFrame parent) {
		super(parent, true);

		setResizable(false);
		setTitle("5% Chance Stuff");
		setBounds(100, 100, 800, 370);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JTextArea textAreaStara = new JTextArea();
		textAreaStara.setBackground(UIManager.getColor("Button.background"));
		textAreaStara.setEditable(false);
		textAreaStara.setWrapStyleWord(true);
		textAreaStara.setLineWrap(true);
		textAreaStara.setText("Stara:\nVajira Blast Crit RNG");
		textAreaStara.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		textAreaStara.setBounds(10, 11, 425, 144);
		contentPanel.add(textAreaStara);

		spinnerRollCount = new JSpinner();
		spinnerRollCount.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		spinnerRollCount.setModel(new SpinnerNumberModel(1, 1, 30, 1));
		spinnerRollCount.setBounds(30, 195, 79, 30);
		contentPanel.add(spinnerRollCount);

		JLabel lblRollCount = new JLabel("Roll count:");
		lblRollCount.setHorizontalAlignment(SwingConstants.CENTER);
		lblRollCount.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		lblRollCount.setBounds(20, 165, 117, 20);
		contentPanel.add(lblRollCount);

		btnRoll = new JButton("Roll");
		btnRoll.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		btnRoll.setBounds(147, 176, 95, 30);
		contentPanel.add(btnRoll);
		btnRoll.addActionListener(this);

		textAreaRNGResults = new JTextArea();
		textAreaRNGResults.setEditable(false);
		textAreaRNGResults.setLineWrap(true);
		textAreaRNGResults.setWrapStyleWord(true);
		textAreaRNGResults.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		textAreaRNGResults.setBackground(UIManager.getColor("Button.background"));
		textAreaRNGResults.setBounds(265, 179, 511, 144);
		contentPanel.add(textAreaRNGResults);

		JScrollPane scrollPaneResults = new JScrollPane(textAreaRNGResults);
		scrollPaneResults.setBounds(265, 179, 511, 144);
		contentPanel.add(scrollPaneResults);

		JTextArea textAreaChara = new JTextArea();
		textAreaChara.setWrapStyleWord(true);
		textAreaChara.setText("Chara:\n(Unavailable) Tempest Slash/Rising Slash/Myriad Slashes/Death Scythe Crit RNG");
		textAreaChara.setLineWrap(true);
		textAreaChara.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		textAreaChara.setEditable(false);
		textAreaChara.setBackground(UIManager.getColor("Button.background"));
		textAreaChara.setBounds(445, 12, 331, 143);
		contentPanel.add(textAreaChara);

		chckbxTempestSlash = new JCheckBox("Tempest Slash");
		chckbxTempestSlash.setEnabled(false);
		chckbxTempestSlash.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		chckbxTempestSlash.setBounds(30, 231, 168, 36);
		contentPanel.add(chckbxTempestSlash);
		
		chckbxMyriadSlashes = new JCheckBox("Myriad Slashes");
		chckbxMyriadSlashes.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		chckbxMyriadSlashes.setEnabled(false);
		chckbxMyriadSlashes.setBounds(30, 269, 168, 36);
		contentPanel.add(chckbxMyriadSlashes);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btnRoll) {
			Random r = new Random();
			int result, count=(int)spinnerRollCount.getValue();
			StringBuilder results = new StringBuilder("");
			for (int i=0; i<count; i++) {
				result = r.nextInt(20)+1;
				if (result>=18) {
					results.append("Roll ").append(i+1).append(" result: Effect triggered! Exact value: ").append(result).append("\n");
				} else {
					results.append("Roll ").append(i+1).append(" result: Nothing happened. Exact value: ").append(result).append("\n");
				}

				if (chckbxTempestSlash.isSelected()&&!chckbxMyriadSlashes.isSelected()) {
					Random r1 = new Random();
					int rampage = r1.nextInt(3)+1;
					switch (rampage) {
					case 1:
						results.append("Tempest Slash hit thrice.").append("\n");
						break;

					case 2:
						results.append("Tempest Slash hit four times.").append("\n");
						break;

					case 3:
						results.append("Tempest Slash hit five times.").append("\n");
						break;
					}
				} else if (chckbxMyriadSlashes.isSelected()&&!chckbxTempestSlash.isSelected()) {
					Random r1 = new Random();
					int mSlashes = r1.nextInt(2)+1;
					switch (mSlashes) {
					case 1:
						results.append("Myriad Slashes hit twice.").append("\n");
						break;

					case 2:
						results.append("Myriad Slashes hit thrice.").append("\n");
						break;
					}
				}
				textAreaRNGResults.setText(results.toString());
			}
		}
	}
}