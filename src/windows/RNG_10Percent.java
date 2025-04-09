package windows;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

public class RNG_10Percent extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextArea rngResults;

	public RNG_10Percent(JFrame parent) {
		super(parent, true);
		setBounds(100, 100, 380, 380);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JTextArea txtrAvailableChoicesStarfish = new JTextArea();
		txtrAvailableChoicesStarfish.setBackground(UIManager.getColor("Button.background"));
		txtrAvailableChoicesStarfish.setEditable(false);
		txtrAvailableChoicesStarfish.setWrapStyleWord(true);
		txtrAvailableChoicesStarfish.setLineWrap(true);
		txtrAvailableChoicesStarfish.setText("Starfish:\r\nTemmie Armor DMG heal\r\n\r\nStara:\r\nConch Slasher Crit\r\n\r\nChara:\r\nElemental Bomb Status RNG\r\nFire Slash Burn RNG\r\nFrost Snap RNG");
		txtrAvailableChoicesStarfish.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		txtrAvailableChoicesStarfish.setBounds(20, 11, 238, 202);
		contentPanel.add(txtrAvailableChoicesStarfish);
		
		JSpinner spinner = new JSpinner();
		spinner.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		spinner.setModel(new SpinnerNumberModel(1, 1, 10, 1));
		spinner.setBounds(282, 43, 61, 30);
		contentPanel.add(spinner);
		
		JLabel lblNewLabel = new JLabel("Count:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		lblNewLabel.setBounds(268, 12, 88, 20);
		contentPanel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Roll");
		btnNewButton.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		btnNewButton.setBounds(268, 84, 89, 23);
		contentPanel.add(btnNewButton);
		
		rngResults = new JTextArea();
		rngResults.setEditable(false);
		rngResults.setLineWrap(true);
		rngResults.setWrapStyleWord(true);
		rngResults.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		rngResults.setBackground(UIManager.getColor("Button.background"));
		rngResults.setBounds(20, 230, 334, 100);
		contentPanel.add(rngResults);
		
		JScrollPane scrollPane = new JScrollPane(rngResults);
		scrollPane.setBounds(20, 230, 334, 100);
		contentPanel.add(scrollPane);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}
