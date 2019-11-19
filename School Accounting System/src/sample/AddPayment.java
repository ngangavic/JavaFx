package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddPayment {
    @FXML
    private TextField tfName;

    @FXML
    private TextField tfAmount;

    public void insertVotehead(){
        if (tfName.getText().isEmpty()||tfAmount.getText().isEmpty()){
            System.out.print("Text field cannot be empty");
        }else {
            String sql = "INSERT INTO tbl_payments(name,amount)VALUES(?,?)";
            try {
                Connection connection = DatabaseConn.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, tfName.getText());
                statement.setString(2, tfAmount.getText());
                statement.execute();
                clearTf();
            } catch (Exception e) {
                clearTf();
                e.printStackTrace();
            }
        }
    }

    public void clearTf(){
        tfName.clear();
        tfAmount.clear();
    }
}
