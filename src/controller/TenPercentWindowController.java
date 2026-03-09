package controller;

import java.net.URL;
import java.util.*;

import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.*;

public class TenPercentWindowController implements Initializable {

	@FXML
	private Spinner<Integer> spinnerCount;

	@FXML
	private Button btnRoll;

	@FXML
	private TextArea textAreaResults;

	@FXML
	private CheckBox cbRampage;

	@FXML
	private void roll(ActionEvent event) {
		Random r = new Random();
		int result, count = spinnerCount.getValue();
		StringBuilder results = new StringBuilder("");

		if (!cbRampage.isSelected()) {
			for (int i = 0; i < count; i++) {
				result = r.nextInt(10) + 1;
				if (result == 1) {
					results.append("Roll ").append(i + 1).append(" result: Effect triggered/Crit! Exact value: " + result)
							.append("\n");
				} else {
					results.append("Roll ").append(i + 1).append(" result: Nothing happened. Exact value: " + result)
							.append("\n");
				}
			}
		} else {
			result = r.nextInt(10) + 1;
			if (result == 1) {
				results.append("Roll result: Rampage crit! Exact value: " + result)
						.append("\n");
			} else {
				results.append("Roll result: Nothing happened. Exact value: " + result)
						.append("\n");
			}
			
			result = r.nextInt(3) + 1;
			switch (result) {
			case 1:
				results.append("Rampage hit once.");
				break;

			case 2:
				results.append("Rampage hit twice.");
				break;

			case 3:
				results.append("Rampage hit thrice.");
				break;
			}
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
