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
	private JTextArea rngResults;

	public OtherRNG(JFrame parent) {
		super(parent, true);
		setTitle("Other RNG");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblNum = new JLabel("Number:");
		lblNum.setHorizontalAlignment(SwingConstants.CENTER);
		lblNum.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		lblNum.setBounds(34, 11, 170, 37);
		contentPanel.add(lblNum);

		JLabel lblRollCount = new JLabel("Roll count:");
		lblRollCount.setHorizontalAlignment(SwingConstants.CENTER);
		lblRollCount.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		lblRollCount.setBounds(240, 11, 170, 37);
		contentPanel.add(lblRollCount);

		spinnerRollCount = new JSpinner();
		spinnerRollCount.setModel(new SpinnerNumberModel(1, 1, 50, 1));
		spinnerRollCount.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		spinnerRollCount.setBounds(283, 47, 90, 37);
		contentPanel.add(spinnerRollCount);

		spinnerNum = new JSpinner();
		spinnerNum.setModel(new SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
		spinnerNum.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		spinnerNum.setBounds(67, 47, 90, 37);
		contentPanel.add(spinnerNum);

		btnRolling = new JButton("Do the rolls");
		btnRolling.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		btnRolling.setBounds(144, 100, 144, 55);
		contentPanel.add(btnRolling);
		btnRolling.addActionListener(this);
		
		rngResults = new JTextArea();
		rngResults.setEditable(false);
		rngResults.setLineWrap(true);
		rngResults.setWrapStyleWord(true);
		rngResults.setFont(new Font("Determination Mono Web", Font.PLAIN, 11));
		rngResults.setBackground(UIManager.getColor("Button.background"));
		rngResults.setBounds(10, 166, 414, 84);
		contentPanel.add(rngResults);
		
		JScrollPane scrollPane = new JScrollPane(rngResults);
		scrollPane.setBounds(10, 166, 414, 84);
		contentPanel.add(scrollPane);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRolling) {
			Random r = new Random();
			int result, num=(int)spinnerNum.getValue(), count=(int)spinnerRollCount.getValue();
			StringBuilder results = new StringBuilder("");
			for (int i=0; i<count; i++) {
				result = r.nextInt(num-1)+1;
				results.append("Roll ").append(i+1).append(": ").append(result).append("\n");
			}
			rngResults.setText(results.toString());
		}
	}
}
