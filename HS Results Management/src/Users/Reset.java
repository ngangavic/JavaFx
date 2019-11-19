package Users;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

import static Alerts.informationBox.infoBoxError;

public class Reset {
    @FXML private TextField username,resetCode;
    @FXML private PasswordField newPassword,confirmPassword;

    public void clickResetPassword(){

    }

    public void clickLogin(ActionEvent event){
        try {
            Stage loginStage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("login.fxml").openStream());

            Login login = (Login) loader.getController();

            Scene scene = new Scene(root);
            loginStage.setScene(scene);
            loginStage.setTitle("HS System Login");
            loginStage.setResizable(false);
            loginStage.show();

            ((Node)(event.getSource())).getScene().getWindow().hide();
        }catch (IOException e){
            infoBoxError("Please click LOGIN again","Error",null);
        }

    }

    public void clickRegister(ActionEvent event){
        try {
            Stage loginStage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("register.fxml").openStream());

            Register reg = (Register) loader.getController();

            Scene scene = new Scene(root);
            loginStage.setScene(scene);
            loginStage.setTitle("HS System Register");
            loginStage.setResizable(false);
            loginStage.show();

            ((Node)(event.getSource())).getScene().getWindow().hide();
        }catch (IOException e){
            infoBoxError("Please click REGISTER again","Error",null);
        }
    }
}
