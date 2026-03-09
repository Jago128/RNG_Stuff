package controller;

import java.net.URL;
import java.util.*;

import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.*;

public class TeamChoiceRandomizerWindowController implements Initializable {

	@FXML
	private Spinner<Integer> spinnerCount;

	@FXML
	private Button btnRoll;

	@FXML
	private TextArea textAreaResults;

	@FXML
	private CheckBox cbJagoSillies;
	
	private int jagoSillies = 0;

	@FXML
	private void jagoSillies(ActionEvent event) {
		if (cbJagoSillies.isSelected()) {
			jagoSillies = 1;
		} else {
			jagoSillies = 0;
		}
	}


	@FXML
	private void roll(ActionEvent event) {
		Random r = new Random();
		int result, count = spinnerCount.getValue();
		StringBuilder results = new StringBuilder("");
		for (int i = 0; i < count; i++) {
			result = r.nextInt(3 + jagoSillies) + 1;
			switch (result) {
			case 1:
				results.append("Roll ").append(i + 1).append(" result: ").append("Oceanic Trio. Exact value: ")
						.append(result).append("\n");
				break;

			case 2:
				results.append("Roll ").append(i + 1).append(" result: ").append("Calming Storms Trio. Exact value: ")
						.append(result).append("\n");
				break;

			case 3:
				results.append("Roll ").append(i + 1).append(" result: ").append("Sunny Duo. Exact value: ")
						.append(result).append("\n");
				break;

			case 4:
				results.append("Roll ").append(i + 1).append(" result: ").append("Jago Sillies. Exact value: ")
						.append(result).append("\n");
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
