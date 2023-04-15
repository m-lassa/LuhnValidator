module luhnvalidator.luhnvalidator {
    requires javafx.controls;
    requires javafx.fxml;


    opens luhnvalidator.luhnvalidator to javafx.fxml;
    exports luhnvalidator.luhnvalidator;
}