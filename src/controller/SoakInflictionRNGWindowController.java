package controller;

import java.net.URL;
import java.util.ResourceBundle;

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
	private void roll(ActionEvent event) {
		
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		SpinnerValueFactory<Integer> countValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100, 1, 1);
        spinnerCount.setValueFactory(countValueFactory);
	}
}
