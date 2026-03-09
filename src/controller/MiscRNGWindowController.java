package controller;

import java.net.URL;
import java.util.*;

import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.*;

public class MiscRNGWindowController implements Initializable {

	@FXML
	private Spinner<Integer> spinnerCount;

	@FXML
	private Button btnRoll;

	@FXML
	private TextArea textAreaResults;

	@FXML
	private RadioButton rbElementalScrollChoice;

	@FXML
	private RadioButton rbFrostbiteSpread;

	private ToggleGroup groupType;

	@FXML
	private void roll(ActionEvent event) {
		Random r = new Random();
		int result, count = spinnerCount.getValue();
		StringBuilder results = new StringBuilder("");

		if (rbElementalScrollChoice.isSelected()) {
			for (int i = 0; i < count; i++) { // 1/3
				result = r.nextInt(3) + 1;
				switch (result) {
				case 1:
					results.append("Enemy ").append(i + 1).append(" was inflicted with Burn! Exact value: ")
							.append(result).append("\n");
					break;

				case 2:
					results.append("Enemy ").append(i + 1).append(" was inflicted with Freeze! Exact value: ")
							.append(result).append("\n");
					break;

				case 3:
					results.append("Enemy ").append(i + 1).append(" was inflicted with Shock! Exact value: ")
							.append(result).append("\n");
					break;
				}
			}
		} else if (rbFrostbiteSpread.isSelected()) {
			for (int i = 0; i < count; i++) { // 1/6
				result = r.nextInt(10) + 1;
				if (result <= 5) {
					results.append("Enemy ").append(i + 1).append(" was inflicted with Frostbite! Exact value: ")
							.append(result).append("\n");
				} else {
					results.append("Frostbite failed to spread on enemy ").append(i + 1).append(". Exact value: ")
							.append(result).append("\n");
				}
			}
		}
		textAreaResults.setText(results.toString());
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		SpinnerValueFactory<Integer> countValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100, 1,
				1);
		spinnerCount.setValueFactory(countValueFactory);
		groupType = new ToggleGroup();
		rbElementalScrollChoice.setToggleGroup(groupType);
		rbFrostbiteSpread.setToggleGroup(groupType);
	}
}
