package controller;

import java.net.URL;
import java.util.*;

import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.*;

public class FifteenPercentWindowController implements Initializable {

	@FXML
	private Spinner<Integer> spinnerCount;

	@FXML
	private Button btnRoll;

	@FXML
	private TextArea textAreaResults;

	@FXML
	private void roll(ActionEvent event) {
		Random r = new Random();
		int result, count = spinnerCount.getValue();
		StringBuilder results = new StringBuilder("");
		for (int i = 0; i < count; i++) {
			result = r.nextInt(20) + 1;
			if (result <= 3) {
				results.append("Roll ").append(i + 1).append(" result: Effect triggered/Crit! Exact value: ").append(result)
						.append("\n");
			} else {
				results.append("Roll ").append(i + 1).append(" result: Nothing happened. Exact value: ").append(result)
						.append("\n");
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
