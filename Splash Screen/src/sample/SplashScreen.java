package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class SplashScreen implements Initializable {
    @FXML
    private Label progress;

    public static Label label;

    @FXML
    private void handleButtonAction(ActionEvent event) {


    }



    @Override
    public void initialize(URL url, ResourceBundle rb) {
        label = progress ;
    }
}
