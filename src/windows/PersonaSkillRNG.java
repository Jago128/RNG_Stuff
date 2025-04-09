package windows;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class PersonaSkillRNG extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	public PersonaSkillRNG(JFrame parent) {
		super(parent, true);
		setTitle("Persona Skill RNG");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("Determination Mono Web", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(33, 22, 129, 28);
		contentPanel.add(lblNewLabel);
	}
}
