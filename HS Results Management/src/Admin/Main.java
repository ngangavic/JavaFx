package Admin;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Main implements Initializable {
    @FXML
    private Label about;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Stage stageToClose = (Stage)about.getScene().getWindow();
       // try {
        //    stageToClose.isShowing();
        //    stageToClose.wait(500);
        //    stageToClose.close();
       // } catch (InterruptedException e) {
        //    e.printStackTrace();
       // }
    }
}
