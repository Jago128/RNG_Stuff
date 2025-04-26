package windows;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;
import javax.swing.border.*;

public class RNG_50Percent extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextArea textAreaRNGResults;
	private JSpinner spinnerRollCount;
	private JButton btnRoll;
	private JTextArea textAreaChara;

	public RNG_50Percent(JFrame parent) {
		super(parent, true);
		
		setResizable(false);
		setTitle("15% Chance Stuff");
		setBounds(100, 100, 800, 370);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JTextArea textAreaAll = new JTextArea();
		textAreaAll.setBackground(UIManager.getColor("Button.background"));
		textAreaAll.setEditable(false);
		textAreaAll.setWrapStyleWord(true);
		textAreaAll.setLineWrap(true);
		textAreaAll.setText("All:\nTechnical Damage Down RNG");
		textAreaAll.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		textAreaAll.setBounds(10, 11, 254, 144);
		contentPanel.add(textAreaAll);
		
		spinnerRollCount = new JSpinner();
		spinnerRollCount.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		spinnerRollCount.setModel(new SpinnerNumberModel(1, 1, 30, 1));
		spinnerRollCount.setBounds(33, 256, 79, 30);
		contentPanel.add(spinnerRollCount);
		
		JLabel lblRollCount = new JLabel("Roll count:");
		lblRollCount.setHorizontalAlignment(SwingConstants.CENTER);
		lblRollCount.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		lblRollCount.setBounds(21, 226, 117, 20);
		contentPanel.add(lblRollCount);
		
		btnRoll = new JButton("Roll");
		btnRoll.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		btnRoll.setBounds(148, 242, 95, 30);
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
		
		textAreaChara = new JTextArea();
		textAreaChara.setWrapStyleWord(true);
		textAreaChara.setText("Chara:\nDual-Elemental Beam Burn RNG");
		textAreaChara.setLineWrap(true);
		textAreaChara.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		textAreaChara.setEditable(false);
		textAreaChara.setBackground(UIManager.getColor("Button.background"));
		textAreaChara.setBounds(445, 12, 331, 143);
		contentPanel.add(textAreaChara);
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
			}
			textAreaRNGResults.setText(results.toString());
		}
	}
}
