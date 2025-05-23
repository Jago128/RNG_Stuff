package windows;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;
import javax.swing.border.*;

public class OtherRNG extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JSpinner spinnerNum, spinnerRollCount;
	private JButton btnRolling;
	private JTextArea textAreaRNGResults;

	public OtherRNG(JFrame parent) {
		super(parent, true);
		
		setResizable(false);
		setTitle("Other RNG");
		setBounds(100, 100, 680, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblNum = new JLabel("Number:");
		lblNum.setHorizontalAlignment(SwingConstants.CENTER);
		lblNum.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		lblNum.setBounds(25, 46, 101, 26);
		contentPanel.add(lblNum);

		JLabel lblRollCount = new JLabel("Roll count:");
		lblRollCount.setHorizontalAlignment(SwingConstants.CENTER);
		lblRollCount.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		lblRollCount.setBounds(10, 151, 129, 26);
		contentPanel.add(lblRollCount);
		
		JLabel lblForAnyOther = new JLabel("For any other RNG:");
		lblForAnyOther.setHorizontalAlignment(SwingConstants.CENTER);
		lblForAnyOther.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		lblForAnyOther.setBounds(26, 10, 178, 37);
		contentPanel.add(lblForAnyOther);
		
		spinnerRollCount = new JSpinner();
		spinnerRollCount.setModel(new SpinnerNumberModel(1, 1, 100, 1));
		spinnerRollCount.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		spinnerRollCount.setBounds(25, 190, 96, 37);
		contentPanel.add(spinnerRollCount);

		spinnerNum = new JSpinner();
		spinnerNum.setModel(new SpinnerNumberModel(1, 1, 10, 1));
		spinnerNum.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		spinnerNum.setBounds(35, 82, 75, 37);
		contentPanel.add(spinnerNum);

		btnRolling = new JButton("Rolls");
		btnRolling.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		btnRolling.setBounds(120, 117, 101, 37);
		contentPanel.add(btnRolling);
		btnRolling.addActionListener(this);
		
		textAreaRNGResults = new JTextArea();
		textAreaRNGResults.setEditable(false);
		textAreaRNGResults.setLineWrap(true);
		textAreaRNGResults.setWrapStyleWord(true);
		textAreaRNGResults.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		textAreaRNGResults.setBackground(UIManager.getColor("Button.background"));
		textAreaRNGResults.setBounds(235, 10, 419, 243);
		contentPanel.add(textAreaRNGResults);

		JScrollPane scrollPaneResults = new JScrollPane(textAreaRNGResults);
		scrollPaneResults.setBounds(235, 10, 419, 243);
		contentPanel.add(scrollPaneResults);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRolling) {
			Random r = new Random();
			int result, num=(int)spinnerNum.getValue(), count=(int)spinnerRollCount.getValue();
			StringBuilder results = new StringBuilder("");
			for (int i=0; i<count; i++) {
				result = r.nextInt(num)+1;
				results.append("Roll ").append(i+1).append(" result: ").append(result).append("\n");
			}
			textAreaRNGResults.setText(results.toString());
		}
	}
}
