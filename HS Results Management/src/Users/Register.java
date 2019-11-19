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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import static Alerts.informationBox.infoBox;
import static Alerts.informationBox.infoBoxError;

public class Register {
    @FXML private TextField firstname,lastname,code,username;
    @FXML private PasswordField password,confirmPassword;

    public void clickRegister() {
        try {
            if (this.firstname.getText().equals("") || this.lastname.getText().equals("") || this.code.getText().equals("") || this.username.getText().equals("") || this.password.getText().equals("") || this.confirmPassword.getText().equals("")) {
                infoBoxError("All fields must be filled","Error",null);
                clearTextFields();
            }else{
                if (this.password.getText().equals(this.confirmPassword.getText())){
                    try{
                        String sql="INSERT INTO tbl_users (firstname,lastname,code,username,password,role,date)VALUES(?,?,?,?,?,?,?)";
                        String sqlCheck="SELECT * FROM tbl_users WHERE code=? AND username=? ";
                        ResultSet set = null;
                        Connection connection = Database.DBConnection.getConnection();
                        PreparedStatement statement = connection.prepareStatement(sql);
                        PreparedStatement checkStatement = connection.prepareStatement(sqlCheck);
                        checkStatement.setString(1,this.code.getText().toString().toUpperCase());
                        checkStatement.setString(2,this.username.getText().toString().toUpperCase());

                        set = checkStatement.executeQuery();
                        int Count=0;
                        while (set.next()){
                            Count++;
                            if (Count > 0 ){
                                infoBoxError("User already exist","Error",null);
                                connection.close();
                                clearTextFields();
                                System.exit(1);
                            }
                        }

                        statement.setString(1,this.firstname.getText().toString().toUpperCase());
                        statement.setString(2,this.lastname.getText().toString().toUpperCase());
                        statement.setString(3,this.code.getText().toString().toUpperCase());
                        statement.setString(4,this.username.getText().toString().toUpperCase());
                        statement.setString(5,this.password.getText().toString().toUpperCase());
                        statement.setString(6,"System_User");
                        statement.setString(7, String.valueOf(Timestamp.valueOf(LocalDateTime.now())));
                        statement.execute();
                        connection.close();

                        infoBox("Data inserted successfully","Success",null);
                        clearTextFields();

                    }catch (Exception e){
                        e.printStackTrace();
                        infoBoxError("An error occurred" + e,"Error",null);
                    }

                }else {
                    infoBoxError("Passwords do not match","Error",null);
                    clearTextFields();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void clearTextFields(){
        this.firstname.clear();
        this.lastname.clear();
        this.code.clear();
        this.username.clear();
        this.password.clear();
        this.confirmPassword.clear();
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
}
