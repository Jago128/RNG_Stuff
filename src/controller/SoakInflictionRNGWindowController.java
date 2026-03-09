package controller;

import java.net.URL;
import java.util.*;

import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.*;

public class SoakInflictionRNGWindowController implements Initializable {

	@FXML
	private Spinner<Integer> spinnerCount;

	@FXML
	private Button btnRoll;

	@FXML
	private TextArea textAreaResults;

	@FXML
	private CheckBox cbStagnantAir;

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

		for (int i = 0; i < count; i++) {
			result = r.nextInt(10) + 1;
			if (result <= 4 + stagnantAir) {
				results.append("Enemy ").append(i + 1).append(" was soaked! Exact value: ").append(result).append("\n");
				if (count > 5) {
					effectCount++;
				}
			} else {
				results.append("Enemy ").append(i + 1).append(" wasn't soaked. Exact value: ").append(result)
						.append("\n");
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
	}
}
