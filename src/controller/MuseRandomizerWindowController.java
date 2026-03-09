package controller;

import java.net.URL;
import java.util.*;

import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.*;

public class MuseRandomizerWindowController implements Initializable {

	@FXML
	private Spinner<Integer> spinnerCount;

	@FXML
	private Button btnRoll;

	@FXML
	private TextArea textAreaResults;

	@FXML
	private CheckBox cbOptional;

	@FXML
	private CheckBox cbCreatorJago;

	@FXML
	private CheckBox cbStarfira;

	@FXML
	private CheckBox cbJulie;

	private int creatorJago = 0, starfira = 0, julie = 0;

	@FXML
	private void optionalStatus(ActionEvent event) {
		if (cbOptional.isSelected()) {
			cbCreatorJago.setDisable(false);
			cbStarfira.setDisable(false);
			cbJulie.setDisable(false);
		} else {
			cbCreatorJago.setDisable(false);
			cbCreatorJago.setSelected(false);

			cbStarfira.setDisable(false);
			cbStarfira.setSelected(false);

			cbJulie.setDisable(false);
			cbJulie.setSelected(false);
		}
	}

	@FXML
	private void optionals(ActionEvent event) {
		if (cbCreatorJago.isSelected()) {
			creatorJago = 1;
		} else {
			creatorJago = 0;
		}

		if (cbStarfira.isSelected()) {
			starfira = 1;
		} else {
			starfira = 0;
		}

		if (cbJulie.isSelected()) {
			julie = 1;
		} else {
			julie = 0;
		}
	}

	@FXML
	private void roll(ActionEvent event) {
		Random r = new Random();
		int result, count = spinnerCount.getValue();
		StringBuilder results = new StringBuilder("");
		for (int i = 0; i < count; i++) {
			result = r.nextInt(8 + creatorJago + starfira + julie) + 1;
			switch (result) {
			case 1:
				results.append("Roll ").append(i + 1).append(" result: ").append("Starfish. Exact value: ")
						.append(result).append("\n");
				break;

			case 2:
				results.append("Roll ").append(i + 1).append(" result: ").append("Stara. Exact value: ").append(result)
						.append("\n");
				break;

			case 3:
				results.append("Roll ").append(i + 1).append(" result: ").append("Chara. Exact value: ").append(result)
						.append("\n");
				break;

			case 4:
				results.append("Roll ").append(i + 1).append(" result: ").append("Kurage. Exact value: ").append(result)
						.append("\n");
				break;

			case 5:
				results.append("Roll ").append(i + 1).append(" result: ").append("Cyclone. Exact value: ")
						.append(result).append("\n");
				break;

			case 6:
				results.append("Roll ").append(i + 1).append(" result: ").append("Kira. Exact value: ").append(result)
						.append("\n");
				break;

			case 7:
				results.append("Roll ").append(i + 1).append(" result: ").append("Ray. Exact value: ").append(result)
						.append("\n");
				break;

			case 8:
				results.append("Roll ").append(i + 1).append(" result: ").append("Hadel. Exact value: ").append(result)
						.append("\n");
				break;

			case 9:
				if (cbCreatorJago.isSelected() && !cbStarfira.isSelected() && !cbJulie.isSelected()) {
					results.append("Roll ").append(i + 1).append(" result: ").append("Creator!Jago. Exact value: ")
							.append(result).append("\n");
				}

				if (!cbCreatorJago.isSelected() && cbStarfira.isSelected() && !cbJulie.isSelected()) {
					results.append("Roll ").append(i + 1).append(" result: ").append("Starfira. Exact value: ")
							.append(result).append("\n");
				}
				if (!cbCreatorJago.isSelected() && !cbStarfira.isSelected() && cbJulie.isSelected()) {
					results.append("Roll ").append(i + 1).append(" result: ").append("Julie. Exact value: ")
							.append(result).append("\n");
				}
				break;

			case 10:
				if (cbCreatorJago.isSelected() && cbStarfira.isSelected() && !cbJulie.isSelected()) {
					results.append("Roll ").append(i + 1).append(" result: ").append("Starfira. Exact value: ")
							.append(result).append("\n");
				}
				if (cbCreatorJago.isSelected() && !cbStarfira.isSelected() && cbJulie.isSelected()) {
					results.append("Roll ").append(i + 1).append(" result: ").append("Julie. Exact value: ")
							.append(result).append("\n");
				}
				break;

			case 11:
				if (cbCreatorJago.isSelected() && cbStarfira.isSelected() && cbJulie.isSelected()) {
					results.append("Roll ").append(i + 1).append(" result: ").append("Julie. Exact value: ")
							.append(result).append("\n");
				}
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
