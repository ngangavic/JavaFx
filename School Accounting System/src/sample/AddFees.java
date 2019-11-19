package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class AddFees implements Initializable{
    @FXML
    private TextField tfYear;

    @FXML
    private TextField tfAmount;

    @FXML
    private ComboBox cbClass;

    private void comboClass(){
        try {
            Connection connection = DatabaseConn.getConnection();
            String sql = "SELECT * FROM tbl_class";
            ResultSet rs = connection.createStatement().executeQuery(sql);
            while (rs.next()){
                cbClass.getItems().addAll(rs.getString("class"));
            }
            //connection.close();
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    public void insertFees(){
        if (tfYear.getText().isEmpty()||tfAmount.getText().isEmpty()||cbClass.getSelectionModel().isEmpty()){
            System.out.print("All field must be filled");
        }else {
            String sql = "INSERT INTO tbl_fees(year,class,fees,date)VALUES(?,?,?,?)";
            try {
                Connection connection = DatabaseConn.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1,tfYear.getText());
                statement.setString(2,cbClass.getValue().toString());
                statement.setString(3,tfAmount.getText());
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                LocalDateTime now = LocalDateTime.now();
                statement.setString(4, dtf.format(now));
                statement.execute();
                clearTextFields();
            }catch (Exception e){
                clearTextFields();
                e.printStackTrace();
            }
        }
    }

    private void clearTextFields() {
        tfAmount.clear();
        tfYear.clear();
        cbClass.getSelectionModel().clearSelection();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        comboClass();
    }
}
