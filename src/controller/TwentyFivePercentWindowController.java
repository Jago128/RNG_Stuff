package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.*;

public class TwentyFivePercentWindowController implements Initializable {

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
		
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
	}
}
