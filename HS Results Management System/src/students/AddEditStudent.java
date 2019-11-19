package students;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import static alert.AlertBox.infoBoxError;

public class AddEditStudent implements Initializable {
    @FXML
    private TextField adm,fname,mname,lname,kcpe;
    @FXML private ComboBox<classOption> classes;
    @FXML private DatePicker dob;

    public static String uAdm;
    public static String uFname;
    public static String uMname;
    public static String uLname;
    public static String uKcpe;
    public static String uClass;
    public static String uDob;
    public static Boolean edit;

    public void insertStudent(){
        if (adm.getText().isEmpty()||fname.getText().isEmpty()||mname.getText().isEmpty()||lname.getText().isEmpty()||kcpe.getText().isEmpty()||dob.getEditor().getText().isEmpty()){
            infoBoxError("All fields must be filled","Error",null);
        }else{
            //check if student exists.
            try {
                String sqlCheck = "SELECT COUNT(adm) FROM tbl_students WHERE adm=?";
                Connection connection = Database.DBConnection.getConnection();
                PreparedStatement statementCheck = connection.prepareStatement(sqlCheck);
                statementCheck.setString(1,adm.getText().toUpperCase());
                ResultSet setCheck = statementCheck.executeQuery();
                while (setCheck.next()){
                    int check = Integer.parseInt(setCheck.getString(1));
                    if (check>0){
                        infoBoxError("Student already exists","Error",null);
                        clearTextFields();
                    }else{
                        InsertStudent insertStudent= new InsertStudent();

                        Thread thread = new Thread(new InsertStudent(),"add");

                        insertStudent.adm=adm.getText().toUpperCase();
                        insertStudent.fname=fname.getText().toUpperCase();
                        insertStudent.mname=mname.getText().toUpperCase();
                        insertStudent.lname=lname.getText().toUpperCase();
                        insertStudent.kcpe=kcpe.getText().toUpperCase();
                        insertStudent.classs=((classOption) this.classes.getValue()).toString().toUpperCase();
                        insertStudent.dob=dob.getEditor().getText().toUpperCase();

                        thread.start();
                    }
                    clearTextFields();
                    resetVariables();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public void updateStudent(){
        if (adm.getText().isEmpty()||fname.getText().isEmpty()||mname.getText().isEmpty()||lname.getText().isEmpty()||kcpe.getText().isEmpty()||dob.getEditor().getText().isEmpty()){
            infoBoxError("All fields must be filled","Error",null);
        }else{
            UpdateStudent updateStudent= new UpdateStudent();

            Thread thread = new Thread(new UpdateStudent(),"update");

            updateStudent.adm=adm.getText().toUpperCase();
            updateStudent.fname=fname.getText().toUpperCase();
            updateStudent.mname=mname.getText().toUpperCase();
            updateStudent.lname=lname.getText().toUpperCase();
            updateStudent.kcpe=kcpe.getText().toUpperCase();
            updateStudent.classs=((classOption) this.classes.getValue()).toString().toUpperCase();
            updateStudent.dob=dob.getEditor().getText().toUpperCase();
            updateStudent.Udm=uAdm;

            thread.start();
        }
        clearTextFields();
        resetVariables();
    }

    private void clearTextFields(){
        adm.clear();
        fname.clear();
        mname.clear();
        lname.clear();
        kcpe.clear();
        classes.getSelectionModel().clearSelection();
        dob.getEditor().clear();
    }

    private void resetVariables(){
        uAdm=null;
        uFname=null;
        uMname=null;
        uLname=null;
        uKcpe=null;
        uClass=null;
        uDob=null;
        edit=false;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.classes.setItems(FXCollections.observableArrayList(classOption.values()));
        if (edit.equals(true)){
        adm.setText(uAdm);
        fname.setText(uFname);
        mname.setText(uMname);
        lname.setText(uLname);
        kcpe.setText(uKcpe);
        dob.getEditor().setText(uDob);
        classes.getSelectionModel().select(classOption.fromvalue(uClass));
        }

    }
}
