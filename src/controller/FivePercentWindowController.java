package controller;

import java.net.URL;
import java.util.*;

import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.*;

public class FivePercentWindowController implements Initializable {

	@FXML
	private Spinner<Integer> spinnerCount;

	@FXML
	private Button btnRoll;

	@FXML
	private TextArea textAreaResults;

	@FXML
	private CheckBox cbMultiHitPhys;

	@FXML
	private RadioButton rbTempestSlash;

	@FXML
	private RadioButton rbMyriadSlashes;

	private ToggleGroup groupType;

	@FXML
	private void multiHits(ActionEvent event) {
		if (cbMultiHitPhys.isSelected()) {
			spinnerCount.getValueFactory().setValue(1);
			spinnerCount.setDisable(true);

			rbTempestSlash.setDisable(false);
			rbTempestSlash.setSelected(true);

			rbMyriadSlashes.setDisable(false);
		} else {
			spinnerCount.setDisable(false);

			rbTempestSlash.setDisable(true);
			rbTempestSlash.setSelected(false);

			rbMyriadSlashes.setDisable(true);
			rbMyriadSlashes.setSelected(false);
		}
	}

	@FXML
	private void roll(ActionEvent event) {
		Random r = new Random();
		int result, count = spinnerCount.getValue();
		StringBuilder results = new StringBuilder("");
		for (int i = 0; i < count; i++) {
			result = r.nextInt(20) + 1;
			if (result <= 2) {
				results.append("Roll ").append(i + 1).append(" result: Effect triggered/Crit! Exact value: ").append(result)
						.append("\n");
			} else {
				results.append("Roll ").append(i + 1).append(" result: Nothing happened. Exact value: ").append(result)
						.append("\n");
			}

			if (rbTempestSlash.isSelected()) {
				Random r1 = new Random();
				int tempestSlash = r1.nextInt(3) + 1;
				switch (tempestSlash) {
				case 1:
					results.append("Tempest Slash hit thrice.").append("\n");
					break;

				case 2:
					results.append("Tempest Slash hit four times.").append("\n");
					break;

				case 3:
					results.append("Tempest Slash hit five times.").append("\n");
					break;
				}
			} else if (rbTempestSlash.isSelected()) {
				Random r1 = new Random();
				int myriadSlashes = r1.nextInt(2) + 1;
				switch (myriadSlashes) {
				case 1:
					results.append("Myriad Slashes hit twice.").append("\n");
					break;

				case 2:
					results.append("Myriad Slashes hit thrice.").append("\n");
					break;
				}
			}
		}
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		SpinnerValueFactory<Integer> countValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100, 1,
				1);
		spinnerCount.setValueFactory(countValueFactory);
		groupType = new ToggleGroup();
		rbMyriadSlashes.setToggleGroup(groupType);
		rbTempestSlash.setToggleGroup(groupType);
	}
}
