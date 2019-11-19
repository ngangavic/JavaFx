package teacher;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import static alert.AlertBox.infoBox;
import static alert.AlertBox.infoBoxError;

public class AddTeacher implements Initializable {
    @FXML
    private TextField teacherCode,fname,mname,sname,lname;
    @FXML
    private ComboBox<classOption> cbClass;
    @FXML
    private ComboBox<subjectOption> cbSubject;

    public static int idcode;
    public static String tCode;
    public static String fName;
    public static String mName;
    public static String sName;
    public static String lName;
    public static String Classs;
    public static String Subject;

    @FXML
    private void addTeacher(){
        if (teacherCode.getText().isEmpty()||fname.getText().isEmpty()||mname.getText().isEmpty()||sname.getText().isEmpty()||lname.getText().isEmpty()||cbClass.getSelectionModel().isEmpty()||cbSubject.getSelectionModel().isEmpty()){
            infoBoxError("All fields must be filled","Error",null);
        }else{
            //check if teacher exists.
            String sqlCheck = "SELECT * FROM tbl_teacher WHERE class=? AND subject=?";
            String sql = "INSERT INTO tbl_teacher(code,fname,mname,lname,short,class,subject)VALUES(?,?,?,?,?,?,?)";
            try{
                Connection connection = Database.DBConnection.getConnection();
                PreparedStatement statementCheck = connection.prepareStatement(sqlCheck);
                PreparedStatement statementInsert = connection.prepareStatement(sql);
                statementCheck.setString(1,cbClass.getValue().toString().toUpperCase());
                statementCheck.setString(2,cbSubject.getValue().toString());
                ResultSet set =statementCheck.executeQuery();
                int Count = 0;
                while (set.next()){
                    Count++;
                    if (Count > 0 ){
                        infoBoxError("Teacher already exists","Error",null);
                        clearTextFields();
                        connection.close();
                    }
                }
                    statementInsert.setString(1,teacherCode.getText().toUpperCase());
                    statementInsert.setString(2,fname.getText().toUpperCase());
                    statementInsert.setString(3,mname.getText().toUpperCase());
                    statementInsert.setString(4,lname.getText().toUpperCase());
                    statementInsert.setString(5,sname.getText().toUpperCase());
                    statementInsert.setString(6,cbClass.getValue().toString());
                    statementInsert.setString(7,cbSubject.getValue().toString());

                    statementInsert.execute();
                    infoBox("Teacher added successfully","Success",null);
                    clearTextFields();
                //set.close();
                connection.close();
                Teacher teacher = new Teacher();
                teacher.loadData();

            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }

    @FXML
    private void updateTeacher(){
        if (teacherCode.getText().isEmpty()||fname.getText().isEmpty()||mname.getText().isEmpty()||sname.getText().isEmpty()||lname.getText().isEmpty()||cbClass.getSelectionModel().isEmpty()||cbSubject.getSelectionModel().isEmpty()){
            infoBoxError("All fields must be filled","Error",null);
        }else {
            String sql = "UPDATE tbl_teacher SET code=?,fname=?,mname=?,lname=?,short=?,class=?,subject=? WHERE id=?";
            try{
                Connection connection = Database.DBConnection.getConnection();
                PreparedStatement statementInsert = connection.prepareStatement(sql);

                statementInsert.setString(1,teacherCode.getText().toUpperCase());
                statementInsert.setString(2,fname.getText().toUpperCase());
                statementInsert.setString(3,mname.getText().toUpperCase());
                statementInsert.setString(4,lname.getText().toUpperCase());
                statementInsert.setString(5,sname.getText().toUpperCase());
                statementInsert.setString(6,cbClass.getValue().toString());
                statementInsert.setString(7,cbSubject.getValue().toString());
                statementInsert.setString(8, String.valueOf(idcode));

                statementInsert.execute();
                infoBox("Teacher updated successfully","Success",null);
                clearTextFields();
                //set.close();
                connection.close();
                Teacher teacher = new Teacher();
                teacher.loadData();

            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    private void clearTextFields() {
        teacherCode.clear();
        fname.clear();
        mname.clear();
        lname.clear();
        sname.clear();
        cbClass.getSelectionModel().clearSelection();
        cbSubject.getSelectionModel().clearSelection();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.cbSubject.setItems(FXCollections.observableArrayList(subjectOption.values()));
        this.cbClass.setItems(FXCollections.observableArrayList(classOption.values()));
        teacherCode.setText(tCode);
        fname.setText(fName);
        mname.setText(mName);
        sname.setText(sName);
        lname.setText(lName);
    }
}
