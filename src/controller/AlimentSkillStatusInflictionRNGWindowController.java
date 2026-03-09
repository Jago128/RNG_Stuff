package controller;

import java.net.URL;
import java.util.*;

import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.*;

public class AlimentSkillStatusInflictionRNGWindowController implements Initializable {

	@FXML
	private Spinner<Integer> spinnerCount;

	@FXML
	private Button btnRoll;

	@FXML
	private TextArea textAreaResults;

	@FXML
	private RadioButton rbSingleTarget;

	@FXML
	private RadioButton rbAoE;

	@FXML
	private CheckBox cbStagnantAir;

	private ToggleGroup groupType;
	private int effectCount, stagnantAir = 0;

	@FXML
	private void stagnantAir(ActionEvent event) {
		if (cbStagnantAir.isSelected()) {
			stagnantAir = 1; // +10% chance
		} else {
			stagnantAir = 0; // Unchanged
		}
	}

	@FXML
	private void roll(ActionEvent event) {
		Random r = new Random();
		int result, count = spinnerCount.getValue();
		effectCount = 0;
		StringBuilder results = new StringBuilder("");

		if (rbSingleTarget.isSelected()) {
			for (int i = 0; i < count; i++) { // 70% chance
				result = r.nextInt(10) + 1;
				if (result <= 7 + stagnantAir) {
					results.append("Enemy ").append(i + 1).append(" was hit with a status! Exact value: ")
							.append(result).append("\n");
					if (count > 5) {
						effectCount++;
					}
				} else {
					results.append("No status effect on enemy ").append(i + 1).append(". Exact value: ").append(result)
							.append("\n");
				}
			}
		} else if (rbAoE.isSelected()) {
			for (int i = 0; i < count; i++) { // 50% chance
				result = r.nextInt(10) + 1;
				if (result <= 5 + stagnantAir) {
					results.append("Enemy ").append(i + 1).append(" was hit with a status! Exact value: ")
							.append(result).append("\n");
					if (count > 5) {
						effectCount++;
					}
				} else {
					results.append("No status effect on enemy ").append(i + 1).append(". Exact value: ").append(result)
							.append("\n");
				}
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
		rbSingleTarget.setToggleGroup(groupType);
		rbAoE.setToggleGroup(groupType);
	}
}
