package Users;

import Admin.Main;
import Start.Graphs;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import static Alerts.informationBox.infoBox;
import static Alerts.informationBox.infoBoxError;

public class Login implements Initializable{
    @FXML private TextField username;
    @FXML private PasswordField password;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
      //  this.comboBox.setItems(FXCollections.observableArrayList(loginOption.values()));
    }

    public void loginClick(ActionEvent event){
        try {
            if (this.username.getText().equals("")||this.password.getText().equals("")){
                infoBoxError("All fields must be filled","Error",null);
                clearTextFields();
            }else{
                try {
                    String sql = "SELECT * FROM tbl_users WHERE username=? AND password=?";
                    ResultSet set= null;
                    Connection connection = Database.DBConnection.getConnection();
                    PreparedStatement statement = connection.prepareStatement(sql);
                    statement.setString(1,this.username.getText().toUpperCase());
                    statement.setString(2,this.password.getText().toUpperCase());

                    set = statement.executeQuery();
                    int Count=0;
                    while (set.next()){

                        Count++;
                        if (Count == 1 ){

                               // adminLogin();

                                userLogin();
                            System.out.println("WELECOME USER");

                        }else{
                            clearTextFields();
                            infoBoxError("Wrong credentials.Try again","Error",null);
                        }
                    }

                    clearTextFields();
                }catch (Exception e){
                    e.printStackTrace();
                    infoBoxError("An error occuurred" + e,"Error",null);
                }
            }
           // Connection connection = Connection.DBConnection.getConnection();
            ((Node)(event.getSource())).getScene().getWindow().hide();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void clearTextFields(){
        this.username.clear();
        this.password.clear();
//        this.comboBox.getEditor().clear();
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

    public void clickResetPassword(ActionEvent event){
        try {
            Stage loginStage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("reset.fxml").openStream());

            Reset reset = (Reset) loader.getController();

            Scene scene = new Scene(root);
            loginStage.setScene(scene);
            loginStage.setTitle("HS System Reset");
            loginStage.setResizable(false);
            loginStage.show();

            ((Node)(event.getSource())).getScene().getWindow().hide();
        }catch (IOException e){
            infoBoxError("Please click RESET again","Error",null);
        }
    }

    public void userLogin(){
        try{
            Stage userStage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("../Start/graphs.fxml"));

            Graphs graphs = (Graphs) loader.getController();

            Scene scene = new Scene(root);
            userStage.setScene(scene);
            userStage.setTitle("Users Dashboard");
            userStage.setResizable(true);
            userStage.setFullScreen(true);
            userStage.show();
        }catch (IOException e){
            e.printStackTrace();
            infoBoxError("LOGIN FAILED \n " + e ,"ERROR",null);
        }
    }

    public void adminLogin(){
        try{
            Stage adminStage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("../Admin/main.fxml").openStream());

            Main main = (Main) loader.getController();

            Scene scene = new Scene(root);
           // Scene scene = new Scene(root,1360,710);
            //adminStage.setScene(scene);
            //Image applicationIcon = new Image(getClass().getResourceAsStream("icon.png"));
            //adminStage.getIcons().add(applicationIcon);
            adminStage.setTitle("Admin Dashboard");
            adminStage.setResizable(true);
            adminStage.setFullScreen(true);
            adminStage.show();
            //loader.setRoot(this);
           // loader.setController(this);
           // loader.load();
        }catch (IOException e){
            e.printStackTrace();
            infoBoxError("LOGIN FAILED \n " + e,"ERROR",null);
        }
    }


}
