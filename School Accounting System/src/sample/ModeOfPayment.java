package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ModeOfPayment {
    @FXML
    private TextField tfMode;

    public void insertMode(){
        if (tfMode.getText().isEmpty()){
            System.out.print("Field cannot be empty");
        }else {
            String sql = "INSERT INTO tbl_mode(name)VALUES(?)";
            try {
                Connection connection = DatabaseConn.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, tfMode.getText());
                statement.execute();
                tfMode.clear();
            } catch (Exception e) {
                tfMode.clear();
                e.printStackTrace();
            }
        }
    }
}
