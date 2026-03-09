package controller;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.*;

public class OtherRNGWindowController implements Initializable {

	@FXML
	private Spinner<Integer> spinnerNumber;

	@FXML
	private Spinner<Integer> spinnerCount;

	@FXML
	private Button btnRoll;

	@FXML
	private TextArea textAreaResults;

	@FXML
	private void roll(ActionEvent event) {
		Random r = new Random();
		int result, num = spinnerNumber.getValue(), count = spinnerCount.getValue();
		StringBuilder results = new StringBuilder("");

		for (int i = 0; i < count; i++) {
			result = r.nextInt(num) + 1;
			results.append("Roll ").append(i + 1).append(" result: ").append(result).append("\n");
		}
		textAreaResults.setText(results.toString());
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		SpinnerValueFactory<Integer> numberValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 1000, 1,
				1);
		spinnerNumber.setValueFactory(numberValueFactory);

		SpinnerValueFactory<Integer> countValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100, 1,
				1);
		spinnerCount.setValueFactory(countValueFactory);
	}
}
