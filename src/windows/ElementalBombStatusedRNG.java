package windows;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;
import javax.swing.border.*;

public class ElementalBombStatusedRNG extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton btnRoll;
	private int elementalBombTriggers;
	private JTextArea textAreaRNGResults;

	public ElementalBombStatusedRNG(JDialog parent, int elementalBombTriggers) {
		super(parent, true);
		this.elementalBombTriggers=elementalBombTriggers;
		
		setResizable(false);
		setTitle("Elemental Bomb Stuff");
		setBounds(100, 100, 700, 200);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JTextArea textAreaChances = new JTextArea();
		textAreaChances.setLineWrap(true);
		textAreaChances.setWrapStyleWord(true);
		textAreaChances.setEditable(false);
		textAreaChances.setText("Elemental Bomb status triggered!\nTrigger count: "+elementalBombTriggers+"\n50% chance to Burn\n50% chance to Freeze");
		textAreaChances.setBackground(UIManager.getColor("Button.background"));
		textAreaChances.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		textAreaChances.setBounds(10, 11, 313, 88);
		contentPanel.add(textAreaChances);

		btnRoll = new JButton("Roll");
		btnRoll.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		btnRoll.setBounds(106, 121, 93, 27);
		contentPanel.add(btnRoll);
		btnRoll.addActionListener(this);

		textAreaRNGResults = new JTextArea();
		textAreaRNGResults.setBackground(UIManager.getColor("Button.background"));
		textAreaRNGResults.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		textAreaRNGResults.setWrapStyleWord(true);
		textAreaRNGResults.setLineWrap(true);
		textAreaRNGResults.setEditable(false);
		textAreaRNGResults.setBounds(315, 11, 361, 142);
		contentPanel.add(textAreaRNGResults);

		JScrollPane scrollPaneResults = new JScrollPane(textAreaRNGResults);
		scrollPaneResults.setBounds(315, 11, 361, 142);
		contentPanel.add(scrollPaneResults);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRoll) {
			Random r = new Random();
			int result;
			StringBuilder results = new StringBuilder("");
			for (int i = 0; i < elementalBombTriggers; i++) {
				result = r.nextInt(2)+1;
				switch (result) {
				case 1:
					results.append("Roll ").append(i+1).append(" result: Burn triggered! Exact value: "+result).append("\n");
					break;

				case 2:
					results.append("Roll ").append(i+1).append(" result: Freeze triggered! Exact value: "+result).append("\n");
					break;
				}
			}
			textAreaRNGResults.setText(results.toString());
		}
	}
}