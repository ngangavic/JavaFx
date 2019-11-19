package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AddStudent implements Initializable {
    @FXML
    private TextField tfAdm;

    @FXML
    private TextField tfName;

    @FXML
    private ComboBox cbClass;

    @FXML
    private TextField tfMarks;

    @FXML
    private TextField tfPhone;

    @FXML
    private ComboBox cbYear;

    @FXML
    private Button closeButton;


    public void insertData(){
        if (tfAdm.getText().isEmpty()||tfName.getText().isEmpty()||cbClass.getSelectionModel().isEmpty()||tfMarks.getText().isEmpty()||tfPhone.getText().isEmpty()||cbYear.getSelectionModel().isEmpty()){
            System.out.print("All fields must be filled");
        }else {
            String sql1 = "INSERT INTO tbl_paid(adm)VALUES(?)";
            String sql = "INSERT INTO tbl_students(adm,name,class,kcpe,parentNo,year)VALUES(?,?,?,?,?,?)";
            try {
                Connection connection = DatabaseConn.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
                PreparedStatement statement1 = connection.prepareStatement(sql1);
                statement.setString(1, tfAdm.getText());
                statement.setString(2, tfName.getText());
                statement.setString(3, cbClass.getValue().toString());
                statement.setString(4, tfMarks.getText());
                statement.setString(5, tfPhone.getText());
                statement.setString(6, cbYear.getValue().toString());

                statement1.setString(1, tfAdm.getText());

                statement.execute();
                statement1.execute();
                //connection.close();
                clearTextFields();

            } catch (Exception e) {
                clearTextFields();
                e.printStackTrace();
            }
        }
    }

    public  void clearTextFields(){
        tfAdm.clear();
        tfName.clear();
        cbClass.getSelectionModel().clearSelection();
        tfMarks.clear();
        tfPhone.clear();
        cbYear.getSelectionModel().clearSelection();
    }

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

    private void comboYear(){
        try {
            Connection connection = DatabaseConn.getConnection();
            String sql = "SELECT * FROM tbl_years";
            ResultSet rs = connection.createStatement().executeQuery(sql);
            while (rs.next()){
                cbYear.getItems().addAll(rs.getString("year"));
            }
            //connection.close();
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    @FXML
    private void closeButtonAction(){
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        comboClass();
        comboYear();
    }
}
