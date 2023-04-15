package luhnvalidator.luhnvalidator;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import luhnvalidator.luhnvalidator.algorithm.LuhnValidator;

public class Controller {

    @FXML
    private Label introTextLabel;
    @FXML
    private Label resultLabel;
    @FXML
    private Button validationButton;
    @FXML
    private TextField numberValidationTextField;

    public void initialize(){

        /*
        The label displayed the results is emptied whenever the user modifies the input in the text field.
         */
        numberValidationTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            resultLabel.setText("");
        });

        numberValidationTextField.setMaxSize(200, 20);
    }

    /**
     * This method calls the static validatedNumber method from the LuhnValidator class
     * whenever the button is pressed, if the user input is not empty.
     * The text in the result label is then set accordingly based on the validation result
     */
    @FXML
    private void runValidation(){
        String stringToValidate = numberValidationTextField.getText();

        if(stringToValidate.trim().isEmpty()){
            Alert emptyStringAlert = new Alert(Alert.AlertType.WARNING);
            emptyStringAlert.setHeaderText(null);
            emptyStringAlert.setTitle("Missing input");
            emptyStringAlert.setContentText("Please add a valid code");
            emptyStringAlert.show();
        } else {

            boolean luhnValidated = LuhnValidator.validateNumber(stringToValidate);

            if(luhnValidated){
                resultLabel.setText("The inputted code is valid");
                resultLabel.setTextFill(Color.DARKGREEN);
            } else {
                resultLabel.setText("The inputted code is not valid");
                resultLabel.setTextFill(Color.RED);
            }
        }
    }
}