package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Controller {
    @FXML private TextField txtUsername;
    @FXML private TextField txtPassword;


@FXML
    private void exitSystem(){
        System.exit(0);
    }

    @FXML
    private void cancelBtn(){
        txtUsername.clear();
        txtPassword.clear();
        txtUsername.requestFocus();
    }

    @FXML
    private void loginBtn(){
    String sql = "SELECT COUNT(*) FROM users WHERE uname=? AND passkey=?";
    try{
        Connection connection = DbConnection.getConnection();

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,txtUsername.getText());
        statement.setString(2,txtPassword.getText());
        ResultSet set = statement.executeQuery();
        while (set.next()){
            int count = Integer.parseInt(set.getString(1));
            if (count==1){
                System.out.println("Login successfull");
            }else{
                System.out.println("Login not successfull");
            }
        }

    }catch (Exception e){
        e.printStackTrace();
    }
    }




}




