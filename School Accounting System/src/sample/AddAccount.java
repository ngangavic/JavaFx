package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AddAccount {
    @FXML
    private TextField tfAcc;

    @FXML
    private TextField tfNumber;

    public void insertAccount(){
        if (tfAcc.getText().isEmpty()||tfNumber.getText().isEmpty()){
            System.out.print("All fileds must be filled");
        }else {
            String sql = "INSERT INTO tbl_accounts(name,number,date)VALUES(?,?,?)";
            try {
                Connection connection = DatabaseConn.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                LocalDateTime now = LocalDateTime.now();
                statement.setString(1, tfAcc.getText());
                statement.setString(2, tfNumber.getText());
                statement.setString(3, dtf.format(now));
                statement.execute();
                //connection.close();
                clearTextFields();
            } catch (Exception e) {
                clearTextFields();
                e.printStackTrace();
            }
        }
    }

    private void clearTextFields() {
        tfAcc.clear();
        tfNumber.clear();
    }
}
