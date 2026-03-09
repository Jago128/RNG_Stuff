package controller;

import java.net.URL;
import java.util.*;

import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.*;

public class AttackSkillStatusInflictionRNGWindowController implements Initializable {

	@FXML
	private Spinner<Integer> spinnerCount;

	@FXML
	private Button btnRoll;

	@FXML
	private TextArea textAreaResults;

	@FXML
	private RadioButton rbNormal;

	@FXML
	private RadioButton rbStara;

	@FXML
	private RadioButton rbDeathScythe;

	@FXML
	private RadioButton rbJellyfishSting;

	@FXML
	private CheckBox cbStagnantAir;

	private ToggleGroup groupType;
	private int effectCount, stagnantAir = 0;
	private boolean stAirForAttack = false;

	@FXML
	private void stagnantAir(ActionEvent event) {
		if (cbStagnantAir.isSelected()) {
			stagnantAir = 1; // +10% chance
			stAirForAttack = true;
		} else {
			stagnantAir = 0; // Unchanged
			stAirForAttack = false;
		}
	}

	@FXML
	private void numberCheck(ActionEvent event) {
		if (rbDeathScythe.isSelected() || rbJellyfishSting.isSelected()) {
			spinnerCount.getValueFactory().setValue(1);
			spinnerCount.setDisable(true);
		} else {
			spinnerCount.setDisable(false);
		}
	}

	@FXML
	private void roll(ActionEvent event) {
		Random r = new Random();
		int result, count = spinnerCount.getValue();
		effectCount = 0;
		StringBuilder results = new StringBuilder("");

		if (rbNormal.isSelected()) {
			if (!stAirForAttack) {
				for (int i = 0; i < count; i++) { // 8% chance (2/25)
					result = r.nextInt(25) + 1;
					if (result <= 2) {
						results.append("Enemy ").append(i + 1).append(" was hit with a status! Exact value: ")
								.append(result).append("\n");
						if (count > 5) {
							effectCount++;
						}
					} else {
						results.append("No status effect on enemy ").append(i + 1).append(". Exact value: ")
								.append(result).append("\n");
					}
				}
			} else {
				for (int i = 0; i < count; i++) { // 18% chance (9/50)
					result = r.nextInt(50) + 1;
					if (result <= 9) {
						results.append("Enemy ").append(i + 1).append(" was hit with a status! Exact value: ")
								.append(result).append("\n");
						if (count > 5) {
							effectCount++;
						}
					} else {
						results.append("No status effect on enemy ").append(i + 1).append(". Exact value: ")
								.append(result).append("\n");
					}
				}
			}
		} else if (rbStara.isSelected()) {
			if (!stAirForAttack) {
				for (int i = 0; i < count; i++) { // 12% chance (3/25)
					result = r.nextInt(25) + 1;
					if (result <= 3) {
						results.append("Enemy ").append(i + 1).append(" was hit with a status! Exact value: ")
								.append(result).append("\n");
						if (count > 5) {
							effectCount++;
						}
					} else {
						results.append("No status effect on enemy ").append(i + 1).append(". Exact value: ")
								.append(result).append("\n");
					}
				}
			} else {
				for (int i = 0; i < count; i++) { // 22% chance (11/50)
					result = r.nextInt(50) + 1;
					if (result <= 11) {
						results.append("Enemy ").append(i + 1).append(" was hit with a status! Exact value: ")
								.append(result).append("\n");
						if (count > 5) {
							effectCount++;
						}
					} else {
						results.append("No status effect on enemy ").append(i + 1).append(". Exact value: ")
								.append(result).append("\n");
					}
				}
			}
		} else if (rbDeathScythe.isSelected()) {
			result = r.nextInt(10) + 1;
			if (result <= 5 + stagnantAir) {
				results.append("The enemy was inflicted with fear! Exact value: ").append(result).append("\n");
			} else {
				results.append("No status effect on the enemy. Exact value: ").append(result).append("\n");
			}
		} else if (rbJellyfishSting.isSelected()) {
			result = r.nextInt(10) + 1;
			if (result <= 6) {
				results.append("The enemy was paralyzed! Exact value: ").append(result).append("\n");
			} else {
				results.append("No status effect on the enemy. Exact value: ").append(result).append("\n");
			}
		}

		if (count > 5) {
			results.append("Effect count: " + effectCount);
		}
		textAreaResults.setText(results.toString());
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		SpinnerValueFactory<Integer> countValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100, 1,
				1);
		spinnerCount.setValueFactory(countValueFactory);
		groupType = new ToggleGroup();
		rbNormal.setToggleGroup(groupType);
		rbStara.setToggleGroup(groupType);
		rbDeathScythe.setToggleGroup(groupType);
		rbJellyfishSting.setToggleGroup(groupType);
	}
}
