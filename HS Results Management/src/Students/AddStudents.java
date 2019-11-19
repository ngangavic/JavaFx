package Students;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import static Alerts.informationBox.infoBox;
import static Alerts.informationBox.infoBoxError;

public class AddStudents implements Initializable{

    @FXML private TextField adm,fname,mname,lname,kcpe;
    @FXML private ComboBox<classOption> classes;
    @FXML private DatePicker dob;
    @FXML private TableView<tableStudentsData> tableStudents;
    @FXML private TableColumn<tableStudentsData,String> idColumn;
    @FXML private TableColumn<tableStudentsData,String> admColumn;
    @FXML private TableColumn<tableStudentsData,String> fnameColumn;
    @FXML private TableColumn<tableStudentsData,String> mnameColumn;
    @FXML private TableColumn<tableStudentsData,String> lnameColumn;
    @FXML private TableColumn<tableStudentsData,String> kcpeColumn;
    @FXML private TableColumn<tableStudentsData,String> classColumn;
    @FXML private TableColumn<tableStudentsData,String> dobColumn;
    @FXML private TableColumn<tableStudentsData, Boolean> deleteColumn;
    private ObservableList<tableStudentsData> tableList;
    @FXML private TextField classFilter,admSearch;

    public void insertData(){
        String sqlCheck = "SELECT * FROM tbl_students WHERE adm=?";
        String students = "INSERT INTO tbl_students(adm,fname,mname,lname,kcpe,class,dob)VALUES(?,?,?,?,?,?,?)";
        String subject = "INSERT INTO tbl_subject_selection(adm,fname,mname,lname,kcpe,class)VALUES(?,?,?,?,?,?)";
        String F1T1Avg = "INSERT INTO tbl_f1_t1_avg(adm,fname,mname,lname,kcpe,class)VALUES(?,?,?,?,?,?)";
        String F1T2Avg = "INSERT INTO tbl_f1_t2_avg(adm,fname,mname,lname,kcpe,class)VALUES(?,?,?,?,?,?)";
        String F1T3Avg = "INSERT INTO tbl_f1_t3_avg(adm,fname,mname,lname,kcpe,class)VALUES(?,?,?,?,?,?)";
        String F2T1Avg = "INSERT INTO tbl_f2_t1_avg(adm,fname,mname,lname,kcpe,class)VALUES(?,?,?,?,?,?)";
        String F2T2Avg = "INSERT INTO tbl_f2_t2_avg(adm,fname,mname,lname,kcpe,class)VALUES(?,?,?,?,?,?)";
        String F2T3Avg = "INSERT INTO tbl_f2_t3_avg(adm,fname,mname,lname,kcpe,class)VALUES(?,?,?,?,?,?)";
        String F3T1Avg = "INSERT INTO tbl_f3_t1_avg(adm,fname,mname,lname,kcpe,class)VALUES(?,?,?,?,?,?)";
        String F3T2Avg = "INSERT INTO tbl_f3_t2_avg(adm,fname,mname,lname,kcpe,class)VALUES(?,?,?,?,?,?)";
        String F3T3Avg = "INSERT INTO tbl_f3_t3_avg(adm,fname,mname,lname,kcpe,class)VALUES(?,?,?,?,?,?)";
        String F4T1Avg = "INSERT INTO tbl_f4_t1_avg(adm,fname,mname,lname,kcpe,class)VALUES(?,?,?,?,?,?)";
        String F4T2Avg = "INSERT INTO tbl_f4_t2_avg(adm,fname,mname,lname,kcpe,class)VALUES(?,?,?,?,?,?)";
        String F4T3Avg = "INSERT INTO tbl_f4_t3_avg(adm,fname,mname,lname,kcpe,class)VALUES(?,?,?,?,?,?)";

        String F1T1Ex1 = "INSERT INTO tbl_f1_t1_ex1(adm,fname,mname,lname,kcpe,class)VALUES(?,?,?,?,?,?)";
        String F1T1Ex2 = "INSERT INTO tbl_f1_t1_ex2(adm,fname,mname,lname,kcpe,class)VALUES(?,?,?,?,?,?)";
        String F1T1Ex3 = "INSERT INTO tbl_f1_t1_ex3(adm,fname,mname,lname,kcpe,class)VALUES(?,?,?,?,?,?)";
        String F1T2Ex1 = "INSERT INTO tbl_f1_t2_ex1(adm,fname,mname,lname,kcpe,class)VALUES(?,?,?,?,?,?)";
        String F1T2Ex2 = "INSERT INTO tbl_f1_t2_ex2(adm,fname,mname,lname,kcpe,class)VALUES(?,?,?,?,?,?)";
        String F1T2Ex3 = "INSERT INTO tbl_f1_t2_ex3(adm,fname,mname,lname,kcpe,class)VALUES(?,?,?,?,?,?)";
        String F1T3Ex1 = "INSERT INTO tbl_f1_t3_ex1(adm,fname,mname,lname,kcpe,class)VALUES(?,?,?,?,?,?)";
        String F1T3Ex2 = "INSERT INTO tbl_f1_t3_ex2(adm,fname,mname,lname,kcpe,class)VALUES(?,?,?,?,?,?)";
        String F1T3Ex3 = "INSERT INTO tbl_f1_t3_ex3(adm,fname,mname,lname,kcpe,class)VALUES(?,?,?,?,?,?)";

        String F2T1Ex1 = "INSERT INTO tbl_f2_t1_ex1(adm,fname,mname,lname,kcpe,class)VALUES(?,?,?,?,?,?)";
        String F2T1Ex2 = "INSERT INTO tbl_f2_t1_ex2(adm,fname,mname,lname,kcpe,class)VALUES(?,?,?,?,?,?)";
        String F2T1Ex3 = "INSERT INTO tbl_f2_t1_ex3(adm,fname,mname,lname,kcpe,class)VALUES(?,?,?,?,?,?)";
        String F2T2Ex1 = "INSERT INTO tbl_f2_t2_ex1(adm,fname,mname,lname,kcpe,class)VALUES(?,?,?,?,?,?)";
        String F2T2Ex2 = "INSERT INTO tbl_f2_t2_ex2(adm,fname,mname,lname,kcpe,class)VALUES(?,?,?,?,?,?)";
        String F2T2Ex3 = "INSERT INTO tbl_f2_t2_ex3(adm,fname,mname,lname,kcpe,class)VALUES(?,?,?,?,?,?)";
        String F2T3Ex1 = "INSERT INTO tbl_f2_t3_ex1(adm,fname,mname,lname,kcpe,class)VALUES(?,?,?,?,?,?)";
        String F2T3Ex2 = "INSERT INTO tbl_f2_t3_ex2(adm,fname,mname,lname,kcpe,class)VALUES(?,?,?,?,?,?)";
        String F2T3Ex3 = "INSERT INTO tbl_f2_t3_ex3(adm,fname,mname,lname,kcpe,class)VALUES(?,?,?,?,?,?)";

        String F3T1Ex1 = "INSERT INTO tbl_f3_t1_ex1(adm,fname,mname,lname,kcpe,class)VALUES(?,?,?,?,?,?)";
        String F3T1Ex2 = "INSERT INTO tbl_f3_t1_ex2(adm,fname,mname,lname,kcpe,class)VALUES(?,?,?,?,?,?)";
        String F3T1Ex3 = "INSERT INTO tbl_f3_t1_ex3(adm,fname,mname,lname,kcpe,class)VALUES(?,?,?,?,?,?)";
        String F3T2Ex1 = "INSERT INTO tbl_f3_t2_ex1(adm,fname,mname,lname,kcpe,class)VALUES(?,?,?,?,?,?)";
        String F3T2Ex2 = "INSERT INTO tbl_f3_t2_ex2(adm,fname,mname,lname,kcpe,class)VALUES(?,?,?,?,?,?)";
        String F3T2Ex3 = "INSERT INTO tbl_f3_t2_ex3(adm,fname,mname,lname,kcpe,class)VALUES(?,?,?,?,?,?)";
        String F3T3Ex1 = "INSERT INTO tbl_f3_t3_ex1(adm,fname,mname,lname,kcpe,class)VALUES(?,?,?,?,?,?)";
        String F3T3Ex2 = "INSERT INTO tbl_f3_t3_ex2(adm,fname,mname,lname,kcpe,class)VALUES(?,?,?,?,?,?)";
        String F3T3Ex3 = "INSERT INTO tbl_f3_t3_ex3(adm,fname,mname,lname,kcpe,class)VALUES(?,?,?,?,?,?)";

        String F4T1Ex1 = "INSERT INTO tbl_f4_t1_ex1(adm,fname,mname,lname,kcpe,class)VALUES(?,?,?,?,?,?)";
        String F4T1Ex2 = "INSERT INTO tbl_f4_t1_ex2(adm,fname,mname,lname,kcpe,class)VALUES(?,?,?,?,?,?)";
        String F4T1Ex3 = "INSERT INTO tbl_f4_t1_ex3(adm,fname,mname,lname,kcpe,class)VALUES(?,?,?,?,?,?)";
        String F4T2Ex1 = "INSERT INTO tbl_f4_t2_ex1(adm,fname,mname,lname,kcpe,class)VALUES(?,?,?,?,?,?)";
        String F4T2Ex2 = "INSERT INTO tbl_f4_t2_ex2(adm,fname,mname,lname,kcpe,class)VALUES(?,?,?,?,?,?)";
        String F4T2Ex3 = "INSERT INTO tbl_f4_t2_ex3(adm,fname,mname,lname,kcpe,class)VALUES(?,?,?,?,?,?)";
        String F4T3Ex1 = "INSERT INTO tbl_f4_t3_ex1(adm,fname,mname,lname,kcpe,class)VALUES(?,?,?,?,?,?)";
        String F4T3Ex2 = "INSERT INTO tbl_f4_t3_ex2(adm,fname,mname,lname,kcpe,class)VALUES(?,?,?,?,?,?)";
        String F4T3Ex3 = "INSERT INTO tbl_f4_t3_ex3(adm,fname,mname,lname,kcpe,class)VALUES(?,?,?,?,?,?)";

        String EngF1 = "INSERT INTO tbl_f1_eng(adm,fname,mname,lname,kcpe,class)VALUES(?,?,?,?,?,?)";
        String KisF1 = "INSERT INTO tbl_f1_kis(adm,fname,mname,lname,kcpe,class)VALUES(?,?,?,?,?,?)";
        String MatF1 = "INSERT INTO tbl_f1_mat(adm,fname,mname,lname,kcpe,class)VALUES(?,?,?,?,?,?)";
        String BioF1 = "INSERT INTO tbl_f1_bio(adm,fname,mname,lname,kcpe,class)VALUES(?,?,?,?,?,?)";
        String PhyF1 = "INSERT INTO tbl_f1_phy(adm,fname,mname,lname,kcpe,class)VALUES(?,?,?,?,?,?)";
        String ChemF1 = "INSERT INTO tbl_f1_chem(adm,fname,mname,lname,kcpe,class)VALUES(?,?,?,?,?,?)";
        String GeoF1 = "INSERT INTO tbl_f1_geo(adm,fname,mname,lname,kcpe,class)VALUES(?,?,?,?,?,?)";
        String HisF1 = "INSERT INTO tbl_f1_his(adm,fname,mname,lname,kcpe,class)VALUES(?,?,?,?,?,?)";
        String CreF1 = "INSERT INTO tbl_f1_cre(adm,fname,mname,lname,kcpe,class)VALUES(?,?,?,?,?,?)";
        String AgriF1 = "INSERT INTO tbl_f1_agri(adm,fname,mname,lname,kcpe,class)VALUES(?,?,?,?,?,?)";
        String BusF1 = "INSERT INTO tbl_f1_bus(adm,fname,mname,lname,kcpe,class)VALUES(?,?,?,?,?,?)";
        String EngF2 = "INSERT INTO tbl_f2_eng(adm,fname,mname,lname,kcpe,class)VALUES(?,?,?,?,?,?)";
        String KisF2 = "INSERT INTO tbl_f2_kis(adm,fname,mname,lname,kcpe,class)VALUES(?,?,?,?,?,?)";
        String MatF2 = "INSERT INTO tbl_f2_mat(adm,fname,mname,lname,kcpe,class)VALUES(?,?,?,?,?,?)";
        String BioF2 = "INSERT INTO tbl_f2_bio(adm,fname,mname,lname,kcpe,class)VALUES(?,?,?,?,?,?)";
        String PhyF2 = "INSERT INTO tbl_f2_phy(adm,fname,mname,lname,kcpe,class)VALUES(?,?,?,?,?,?)";
        String ChemF2 = "INSERT INTO tbl_f2_chem(adm,fname,mname,lname,kcpe,class)VALUES(?,?,?,?,?,?)";
        String GeoF2 = "INSERT INTO tbl_f2_geo(adm,fname,mname,lname,kcpe,class)VALUES(?,?,?,?,?,?)";
        String HisF2 = "INSERT INTO tbl_f2_his(adm,fname,mname,lname,kcpe,class)VALUES(?,?,?,?,?,?)";
        String CreF2 = "INSERT INTO tbl_f2_cre(adm,fname,mname,lname,kcpe,class)VALUES(?,?,?,?,?,?)";
        String AgriF2 = "INSERT INTO tbl_f2_agri(adm,fname,mname,lname,kcpe,class)VALUES(?,?,?,?,?,?)";
        String BusF2 = "INSERT INTO tbl_f2_bus(adm,fname,mname,lname,kcpe,class)VALUES(?,?,?,?,?,?)";
        String EngF3 = "INSERT INTO tbl_f3_eng(adm,fname,mname,lname,kcpe,class)VALUES(?,?,?,?,?,?)";
        String KisF3 = "INSERT INTO tbl_f3_kis(adm,fname,mname,lname,kcpe,class)VALUES(?,?,?,?,?,?)";
        String MatF3 = "INSERT INTO tbl_f3_mat(adm,fname,mname,lname,kcpe,class)VALUES(?,?,?,?,?,?)";
        String BioF3 = "INSERT INTO tbl_f3_bio(adm,fname,mname,lname,kcpe,class)VALUES(?,?,?,?,?,?)";
        String PhyF3 = "INSERT INTO tbl_f3_phy(adm,fname,mname,lname,kcpe,class)VALUES(?,?,?,?,?,?)";
        String ChemF3 = "INSERT INTO tbl_f3_chem(adm,fname,mname,lname,kcpe,class)VALUES(?,?,?,?,?,?)";
        String GeoF3 = "INSERT INTO tbl_f3_geo(adm,fname,mname,lname,kcpe,class)VALUES(?,?,?,?,?,?)";
        String HisF3 = "INSERT INTO tbl_f3_his(adm,fname,mname,lname,kcpe,class)VALUES(?,?,?,?,?,?)";
        String CreF3 = "INSERT INTO tbl_f3_cre(adm,fname,mname,lname,kcpe,class)VALUES(?,?,?,?,?,?)";
        String AgriF3 = "INSERT INTO tbl_f3_agri(adm,fname,mname,lname,kcpe,class)VALUES(?,?,?,?,?,?)";
        String BusF3 = "INSERT INTO tbl_f3_bus(adm,fname,mname,lname,kcpe,class)VALUES(?,?,?,?,?,?)";
        String EngF4 = "INSERT INTO tbl_f4_eng(adm,fname,mname,lname,kcpe,class)VALUES(?,?,?,?,?,?)";
        String KisF4 = "INSERT INTO tbl_f4_kis(adm,fname,mname,lname,kcpe,class)VALUES(?,?,?,?,?,?)";
        String MatF4 = "INSERT INTO tbl_f4_mat(adm,fname,mname,lname,kcpe,class)VALUES(?,?,?,?,?,?)";
        String BioF4 = "INSERT INTO tbl_f4_bio(adm,fname,mname,lname,kcpe,class)VALUES(?,?,?,?,?,?)";
        String PhyF4 = "INSERT INTO tbl_f4_phy(adm,fname,mname,lname,kcpe,class)VALUES(?,?,?,?,?,?)";
        String ChemF4 = "INSERT INTO tbl_f4_chem(adm,fname,mname,lname,kcpe,class)VALUES(?,?,?,?,?,?)";
        String GeoF4 = "INSERT INTO tbl_f4_geo(adm,fname,mname,lname,kcpe,class)VALUES(?,?,?,?,?,?)";
        String HisF4 = "INSERT INTO tbl_f4_his(adm,fname,mname,lname,kcpe,class)VALUES(?,?,?,?,?,?)";
        String CreF4 = "INSERT INTO tbl_f4_cre(adm,fname,mname,lname,kcpe,class)VALUES(?,?,?,?,?,?)";
        String AgriF4 = "INSERT INTO tbl_f4_agri(adm,fname,mname,lname,kcpe,class)VALUES(?,?,?,?,?,?)";
        String BusF4 = "INSERT INTO tbl_f4_bus(adm,fname,mname,lname,kcpe,class)VALUES(?,?,?,?,?,?)";

        if (this.adm.getText().equals("")||this.fname.getText().equals("")||this.mname.getText().equals("")||this.lname.getText().equals("")||this.kcpe.getText().equals("")||((classOption)this.classes.getValue()).equals("")||this.dob.getEditor().getText().equals("")){
            infoBoxError("You must fill all fields ","Empty fields",null);
        }else {
            try {
                Connection connection = Database.DBConnection.getConnection();
                PreparedStatement statementCheck = connection.prepareStatement(sqlCheck);
                statementCheck.setString(1,this.adm.getText().toUpperCase());
                ResultSet resultSet = statementCheck.executeQuery();
                int Count=0;
                while (resultSet.next()){
                   Count++;
                    if (Count > 0 ){
                        infoBoxError("Student already exist","Error",null);
                        emptyTextFields();
                        connection.close();
                    }
                }
                PreparedStatement statementStudent = connection.prepareStatement(students);
                statementStudent.setString(1, this.adm.getText().toUpperCase());
                statementStudent.setString(2, this.fname.getText().toUpperCase());
                statementStudent.setString(3, this.mname.getText().toUpperCase());
                statementStudent.setString(4, this.lname.getText().toUpperCase());
                statementStudent.setString(5, this.kcpe.getText().toUpperCase());
                statementStudent.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());
                statementStudent.setString(7, this.dob.getEditor().getText().toUpperCase());

                PreparedStatement statementSubjects = connection.prepareStatement(subject);
                statementSubjects.setString(1, this.adm.getText().toUpperCase());
                statementSubjects.setString(2, this.fname.getText().toUpperCase());
                statementSubjects.setString(3, this.mname.getText().toUpperCase());
                statementSubjects.setString(4, this.lname.getText().toUpperCase());
                statementSubjects.setString(5, this.kcpe.getText().toUpperCase());
                statementSubjects.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());

                PreparedStatement statementF1T1Avg = connection.prepareStatement(F1T1Avg);
                statementF1T1Avg.setString(1, this.adm.getText().toUpperCase());
                statementF1T1Avg.setString(2, this.fname.getText().toUpperCase());
                statementF1T1Avg.setString(3, this.mname.getText().toUpperCase());
                statementF1T1Avg.setString(4, this.lname.getText().toUpperCase());
                statementF1T1Avg.setString(5, this.kcpe.getText().toUpperCase());
                statementF1T1Avg.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());

                PreparedStatement statementF1T2Avg = connection.prepareStatement(F1T2Avg);
                statementF1T2Avg.setString(1, this.adm.getText().toUpperCase());
                statementF1T2Avg.setString(2, this.fname.getText().toUpperCase());
                statementF1T2Avg.setString(3, this.mname.getText().toUpperCase());
                statementF1T2Avg.setString(4, this.lname.getText().toUpperCase());
                statementF1T2Avg.setString(5, this.kcpe.getText().toUpperCase());
                statementF1T2Avg.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());

                PreparedStatement statementF1T3Avg = connection.prepareStatement(F1T3Avg);
                statementF1T3Avg.setString(1, this.adm.getText().toUpperCase());
                statementF1T3Avg.setString(2, this.fname.getText().toUpperCase());
                statementF1T3Avg.setString(3, this.mname.getText().toUpperCase());
                statementF1T3Avg.setString(4, this.lname.getText().toUpperCase());
                statementF1T3Avg.setString(5, this.kcpe.getText().toUpperCase());
                statementF1T3Avg.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());

                PreparedStatement statementF2T1Avg = connection.prepareStatement(F2T1Avg);
                statementF2T1Avg.setString(1, this.adm.getText().toUpperCase());
                statementF2T1Avg.setString(2, this.fname.getText().toUpperCase());
                statementF2T1Avg.setString(3, this.mname.getText().toUpperCase());
                statementF2T1Avg.setString(4, this.lname.getText().toUpperCase());
                statementF2T1Avg.setString(5, this.kcpe.getText().toUpperCase());
                statementF2T1Avg.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());

                PreparedStatement statementF2T2Avg = connection.prepareStatement(F2T2Avg);
                statementF2T2Avg.setString(1, this.adm.getText().toUpperCase());
                statementF2T2Avg.setString(2, this.fname.getText().toUpperCase());
                statementF2T2Avg.setString(3, this.mname.getText().toUpperCase());
                statementF2T2Avg.setString(4, this.lname.getText().toUpperCase());
                statementF2T2Avg.setString(5, this.kcpe.getText().toUpperCase());
                statementF2T2Avg.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());

                PreparedStatement statementF2T3Avg = connection.prepareStatement(F2T3Avg);
                statementF2T3Avg.setString(1, this.adm.getText().toUpperCase());
                statementF2T3Avg.setString(2, this.fname.getText().toUpperCase());
                statementF2T3Avg.setString(3, this.mname.getText().toUpperCase());
                statementF2T3Avg.setString(4, this.lname.getText().toUpperCase());
                statementF2T3Avg.setString(5, this.kcpe.getText().toUpperCase());
                statementF2T3Avg.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());

                PreparedStatement statementF3T1Avg = connection.prepareStatement(F3T1Avg);
                statementF3T1Avg.setString(1, this.adm.getText().toUpperCase());
                statementF3T1Avg.setString(2, this.fname.getText().toUpperCase());
                statementF3T1Avg.setString(3, this.mname.getText().toUpperCase());
                statementF3T1Avg.setString(4, this.lname.getText().toUpperCase());
                statementF3T1Avg.setString(5, this.kcpe.getText().toUpperCase());
                statementF3T1Avg.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());

                PreparedStatement statementF3T2Avg = connection.prepareStatement(F3T2Avg);
                statementF3T2Avg.setString(1, this.adm.getText().toUpperCase());
                statementF3T2Avg.setString(2, this.fname.getText().toUpperCase());
                statementF3T2Avg.setString(3, this.mname.getText().toUpperCase());
                statementF3T2Avg.setString(4, this.lname.getText().toUpperCase());
                statementF3T2Avg.setString(5, this.kcpe.getText().toUpperCase());
                statementF3T2Avg.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());

                PreparedStatement statementF3T3Avg = connection.prepareStatement(F3T3Avg);
                statementF3T3Avg.setString(1, this.adm.getText().toUpperCase());
                statementF3T3Avg.setString(2, this.fname.getText().toUpperCase());
                statementF3T3Avg.setString(3, this.mname.getText().toUpperCase());
                statementF3T3Avg.setString(4, this.lname.getText().toUpperCase());
                statementF3T3Avg.setString(5, this.kcpe.getText().toUpperCase());
                statementF3T3Avg.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());

                PreparedStatement statementF4T1Avg = connection.prepareStatement(F4T1Avg);
                statementF4T1Avg.setString(1, this.adm.getText().toUpperCase());
                statementF4T1Avg.setString(2, this.fname.getText().toUpperCase());
                statementF4T1Avg.setString(3, this.mname.getText().toUpperCase());
                statementF4T1Avg.setString(4, this.lname.getText().toUpperCase());
                statementF4T1Avg.setString(5, this.kcpe.getText().toUpperCase());
                statementF4T1Avg.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());

                PreparedStatement statementF4T2Avg = connection.prepareStatement(F4T2Avg);
                statementF4T2Avg.setString(1, this.adm.getText().toUpperCase());
                statementF4T2Avg.setString(2, this.fname.getText().toUpperCase());
                statementF4T2Avg.setString(3, this.mname.getText().toUpperCase());
                statementF4T2Avg.setString(4, this.lname.getText().toUpperCase());
                statementF4T2Avg.setString(5, this.kcpe.getText().toUpperCase());
                statementF4T2Avg.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());

                PreparedStatement statementF4T3Avg = connection.prepareStatement(F4T3Avg);
                statementF4T3Avg.setString(1, this.adm.getText().toUpperCase());
                statementF4T3Avg.setString(2, this.fname.getText().toUpperCase());
                statementF4T3Avg.setString(3, this.mname.getText().toUpperCase());
                statementF4T3Avg.setString(4, this.lname.getText().toUpperCase());
                statementF4T3Avg.setString(5, this.kcpe.getText().toUpperCase());
                statementF4T3Avg.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());


                PreparedStatement statementF1T1Ex1 = connection.prepareStatement(F1T1Ex1);
                statementF1T1Ex1.setString(1, this.adm.getText().toUpperCase());
                statementF1T1Ex1.setString(2, this.fname.getText().toUpperCase());
                statementF1T1Ex1.setString(3, this.mname.getText().toUpperCase());
                statementF1T1Ex1.setString(4, this.lname.getText().toUpperCase());
                statementF1T1Ex1.setString(5, this.kcpe.getText().toUpperCase());
                statementF1T1Ex1.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());

                PreparedStatement statementF1T1Ex2 = connection.prepareStatement(F1T1Ex2);
                statementF1T1Ex2.setString(1, this.adm.getText().toUpperCase());
                statementF1T1Ex2.setString(2, this.fname.getText().toUpperCase());
                statementF1T1Ex2.setString(3, this.mname.getText().toUpperCase());
                statementF1T1Ex2.setString(4, this.lname.getText().toUpperCase());
                statementF1T1Ex2.setString(5, this.kcpe.getText().toUpperCase());
                statementF1T1Ex2.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());

                PreparedStatement statementF1T1Ex3 = connection.prepareStatement(F1T1Ex3);
                statementF1T1Ex3.setString(1, this.adm.getText().toUpperCase());
                statementF1T1Ex3.setString(2, this.fname.getText().toUpperCase());
                statementF1T1Ex3.setString(3, this.mname.getText().toUpperCase());
                statementF1T1Ex3.setString(4, this.lname.getText().toUpperCase());
                statementF1T1Ex3.setString(5, this.kcpe.getText().toUpperCase());
                statementF1T1Ex3.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());

                PreparedStatement statementF1T2Ex1 = connection.prepareStatement(F1T2Ex1);
                statementF1T2Ex1.setString(1, this.adm.getText().toUpperCase());
                statementF1T2Ex1.setString(2, this.fname.getText().toUpperCase());
                statementF1T2Ex1.setString(3, this.mname.getText().toUpperCase());
                statementF1T2Ex1.setString(4, this.lname.getText().toUpperCase());
                statementF1T2Ex1.setString(5, this.kcpe.getText().toUpperCase());
                statementF1T2Ex1.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());

                PreparedStatement statementF1T2Ex2 = connection.prepareStatement(F1T2Ex2);
                statementF1T2Ex2.setString(1, this.adm.getText().toUpperCase());
                statementF1T2Ex2.setString(2, this.fname.getText().toUpperCase());
                statementF1T2Ex2.setString(3, this.mname.getText().toUpperCase());
                statementF1T2Ex2.setString(4, this.lname.getText().toUpperCase());
                statementF1T2Ex2.setString(5, this.kcpe.getText().toUpperCase());
                statementF1T2Ex2.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());

                PreparedStatement statementF1T2Ex3 = connection.prepareStatement(F1T2Ex3);
                statementF1T2Ex3.setString(1, this.adm.getText().toUpperCase());
                statementF1T2Ex3.setString(2, this.fname.getText().toUpperCase());
                statementF1T2Ex3.setString(3, this.mname.getText().toUpperCase());
                statementF1T2Ex3.setString(4, this.lname.getText().toUpperCase());
                statementF1T2Ex3.setString(5, this.kcpe.getText().toUpperCase());
                statementF1T2Ex3.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());

                PreparedStatement statementF1T3Ex1 = connection.prepareStatement(F1T3Ex1);
                statementF1T3Ex1.setString(1, this.adm.getText().toUpperCase());
                statementF1T3Ex1.setString(2, this.fname.getText().toUpperCase());
                statementF1T3Ex1.setString(3, this.mname.getText().toUpperCase());
                statementF1T3Ex1.setString(4, this.lname.getText().toUpperCase());
                statementF1T3Ex1.setString(5, this.kcpe.getText().toUpperCase());
                statementF1T3Ex1.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());

                PreparedStatement statementF1T3Ex2 = connection.prepareStatement(F1T3Ex2);
                statementF1T3Ex2.setString(1, this.adm.getText().toUpperCase());
                statementF1T3Ex2.setString(2, this.fname.getText().toUpperCase());
                statementF1T3Ex2.setString(3, this.mname.getText().toUpperCase());
                statementF1T3Ex2.setString(4, this.lname.getText().toUpperCase());
                statementF1T3Ex2.setString(5, this.kcpe.getText().toUpperCase());
                statementF1T3Ex2.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());

                PreparedStatement statementF1T3Ex3 = connection.prepareStatement(F1T3Ex3);
                statementF1T3Ex3.setString(1, this.adm.getText().toUpperCase());
                statementF1T3Ex3.setString(2, this.fname.getText().toUpperCase());
                statementF1T3Ex3.setString(3, this.mname.getText().toUpperCase());
                statementF1T3Ex3.setString(4, this.lname.getText().toUpperCase());
                statementF1T3Ex3.setString(5, this.kcpe.getText().toUpperCase());
                statementF1T3Ex3.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());

                PreparedStatement statementF2T1Ex1 = connection.prepareStatement(F2T1Ex1);
                statementF2T1Ex1.setString(1, this.adm.getText().toUpperCase());
                statementF2T1Ex1.setString(2, this.fname.getText().toUpperCase());
                statementF2T1Ex1.setString(3, this.mname.getText().toUpperCase());
                statementF2T1Ex1.setString(4, this.lname.getText().toUpperCase());
                statementF2T1Ex1.setString(5, this.kcpe.getText().toUpperCase());
                statementF2T1Ex1.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());

                PreparedStatement statementF2T1Ex2 = connection.prepareStatement(F2T1Ex2);
                statementF2T1Ex2.setString(1, this.adm.getText().toUpperCase());
                statementF2T1Ex2.setString(2, this.fname.getText().toUpperCase());
                statementF2T1Ex2.setString(3, this.mname.getText().toUpperCase());
                statementF2T1Ex2.setString(4, this.lname.getText().toUpperCase());
                statementF2T1Ex2.setString(5, this.kcpe.getText().toUpperCase());
                statementF2T1Ex2.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());

                PreparedStatement statementF2T1Ex3 = connection.prepareStatement(F2T1Ex3);
                statementF2T1Ex3.setString(1, this.adm.getText().toUpperCase());
                statementF2T1Ex3.setString(2, this.fname.getText().toUpperCase());
                statementF2T1Ex3.setString(3, this.mname.getText().toUpperCase());
                statementF2T1Ex3.setString(4, this.lname.getText().toUpperCase());
                statementF2T1Ex3.setString(5, this.kcpe.getText().toUpperCase());
                statementF2T1Ex3.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());

                PreparedStatement statementF2T2Ex1 = connection.prepareStatement(F2T2Ex1);
                statementF2T2Ex1.setString(1, this.adm.getText().toUpperCase());
                statementF2T2Ex1.setString(2, this.fname.getText().toUpperCase());
                statementF2T2Ex1.setString(3, this.mname.getText().toUpperCase());
                statementF2T2Ex1.setString(4, this.lname.getText().toUpperCase());
                statementF2T2Ex1.setString(5, this.kcpe.getText().toUpperCase());
                statementF2T2Ex1.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());

                PreparedStatement statementF2T2Ex2 = connection.prepareStatement(F2T2Ex2);
                statementF2T2Ex2.setString(1, this.adm.getText().toUpperCase());
                statementF2T2Ex2.setString(2, this.fname.getText().toUpperCase());
                statementF2T2Ex2.setString(3, this.mname.getText().toUpperCase());
                statementF2T2Ex2.setString(4, this.lname.getText().toUpperCase());
                statementF2T2Ex2.setString(5, this.kcpe.getText().toUpperCase());
                statementF2T2Ex2.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());

                PreparedStatement statementF2T2Ex3 = connection.prepareStatement(F2T2Ex3);
                statementF2T2Ex3.setString(1, this.adm.getText().toUpperCase());
                statementF2T2Ex3.setString(2, this.fname.getText().toUpperCase());
                statementF2T2Ex3.setString(3, this.mname.getText().toUpperCase());
                statementF2T2Ex3.setString(4, this.lname.getText().toUpperCase());
                statementF2T2Ex3.setString(5, this.kcpe.getText().toUpperCase());
                statementF2T2Ex3.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());

                PreparedStatement statementF2T3Ex1 = connection.prepareStatement(F2T3Ex1);
                statementF2T3Ex1.setString(1, this.adm.getText().toUpperCase());
                statementF2T3Ex1.setString(2, this.fname.getText().toUpperCase());
                statementF2T3Ex1.setString(3, this.mname.getText().toUpperCase());
                statementF2T3Ex1.setString(4, this.lname.getText().toUpperCase());
                statementF2T3Ex1.setString(5, this.kcpe.getText().toUpperCase());
                statementF2T3Ex1.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());

                PreparedStatement statementF2T3Ex2 = connection.prepareStatement(F2T3Ex2);
                statementF2T3Ex2.setString(1, this.adm.getText().toUpperCase());
                statementF2T3Ex2.setString(2, this.fname.getText().toUpperCase());
                statementF2T3Ex2.setString(3, this.mname.getText().toUpperCase());
                statementF2T3Ex2.setString(4, this.lname.getText().toUpperCase());
                statementF2T3Ex2.setString(5, this.kcpe.getText().toUpperCase());
                statementF2T3Ex2.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());

                PreparedStatement statementF2T3Ex3 = connection.prepareStatement(F2T3Ex3);
                statementF2T3Ex3.setString(1, this.adm.getText().toUpperCase());
                statementF2T3Ex3.setString(2, this.fname.getText().toUpperCase());
                statementF2T3Ex3.setString(3, this.mname.getText().toUpperCase());
                statementF2T3Ex3.setString(4, this.lname.getText().toUpperCase());
                statementF2T3Ex3.setString(5, this.kcpe.getText().toUpperCase());
                statementF2T3Ex3.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());

                PreparedStatement statementF3T1Ex1 = connection.prepareStatement(F3T1Ex1);
                statementF3T1Ex1.setString(1, this.adm.getText().toUpperCase());
                statementF3T1Ex1.setString(2, this.fname.getText().toUpperCase());
                statementF3T1Ex1.setString(3, this.mname.getText().toUpperCase());
                statementF3T1Ex1.setString(4, this.lname.getText().toUpperCase());
                statementF3T1Ex1.setString(5, this.kcpe.getText().toUpperCase());
                statementF3T1Ex1.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());

                PreparedStatement statementF3T1Ex2 = connection.prepareStatement(F3T1Ex2);
                statementF3T1Ex2.setString(1, this.adm.getText().toUpperCase());
                statementF3T1Ex2.setString(2, this.fname.getText().toUpperCase());
                statementF3T1Ex2.setString(3, this.mname.getText().toUpperCase());
                statementF3T1Ex2.setString(4, this.lname.getText().toUpperCase());
                statementF3T1Ex2.setString(5, this.kcpe.getText().toUpperCase());
                statementF3T1Ex2.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());

                PreparedStatement statementF3T1Ex3 = connection.prepareStatement(F3T1Ex3);
                statementF3T1Ex3.setString(1, this.adm.getText().toUpperCase());
                statementF3T1Ex3.setString(2, this.fname.getText().toUpperCase());
                statementF3T1Ex3.setString(3, this.mname.getText().toUpperCase());
                statementF3T1Ex3.setString(4, this.lname.getText().toUpperCase());
                statementF3T1Ex3.setString(5, this.kcpe.getText().toUpperCase());
                statementF3T1Ex3.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());

                PreparedStatement statementF3T2Ex1 = connection.prepareStatement(F3T2Ex1);
                statementF3T2Ex1.setString(1, this.adm.getText().toUpperCase());
                statementF3T2Ex1.setString(2, this.fname.getText().toUpperCase());
                statementF3T2Ex1.setString(3, this.mname.getText().toUpperCase());
                statementF3T2Ex1.setString(4, this.lname.getText().toUpperCase());
                statementF3T2Ex1.setString(5, this.kcpe.getText().toUpperCase());
                statementF3T2Ex1.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());

                PreparedStatement statementF3T2Ex2 = connection.prepareStatement(F3T2Ex2);
                statementF3T2Ex2.setString(1, this.adm.getText().toUpperCase());
                statementF3T2Ex2.setString(2, this.fname.getText().toUpperCase());
                statementF3T2Ex2.setString(3, this.mname.getText().toUpperCase());
                statementF3T2Ex2.setString(4, this.lname.getText().toUpperCase());
                statementF3T2Ex2.setString(5, this.kcpe.getText().toUpperCase());
                statementF3T2Ex2.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());

                PreparedStatement statementF3T2Ex3 = connection.prepareStatement(F3T2Ex3);
                statementF3T2Ex3.setString(1, this.adm.getText().toUpperCase());
                statementF3T2Ex3.setString(2, this.fname.getText().toUpperCase());
                statementF3T2Ex3.setString(3, this.mname.getText().toUpperCase());
                statementF3T2Ex3.setString(4, this.lname.getText().toUpperCase());
                statementF3T2Ex3.setString(5, this.kcpe.getText().toUpperCase());
                statementF3T2Ex3.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());

                PreparedStatement statementF3T3Ex1 = connection.prepareStatement(F3T3Ex1);
                statementF3T3Ex1.setString(1, this.adm.getText().toUpperCase());
                statementF3T3Ex1.setString(2, this.fname.getText().toUpperCase());
                statementF3T3Ex1.setString(3, this.mname.getText().toUpperCase());
                statementF3T3Ex1.setString(4, this.lname.getText().toUpperCase());
                statementF3T3Ex1.setString(5, this.kcpe.getText().toUpperCase());
                statementF3T3Ex1.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());

                PreparedStatement statementF3T3Ex2 = connection.prepareStatement(F3T3Ex2);
                statementF3T3Ex2.setString(1, this.adm.getText().toUpperCase());
                statementF3T3Ex2.setString(2, this.fname.getText().toUpperCase());
                statementF3T3Ex2.setString(3, this.mname.getText().toUpperCase());
                statementF3T3Ex2.setString(4, this.lname.getText().toUpperCase());
                statementF3T3Ex2.setString(5, this.kcpe.getText().toUpperCase());
                statementF3T3Ex2.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());

                PreparedStatement statementF3T3Ex3 = connection.prepareStatement(F3T3Ex3);
                statementF3T3Ex3.setString(1, this.adm.getText().toUpperCase());
                statementF3T3Ex3.setString(2, this.fname.getText().toUpperCase());
                statementF3T3Ex3.setString(3, this.mname.getText().toUpperCase());
                statementF3T3Ex3.setString(4, this.lname.getText().toUpperCase());
                statementF3T3Ex3.setString(5, this.kcpe.getText().toUpperCase());
                statementF3T3Ex3.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());

                PreparedStatement statementF4T1Ex1 = connection.prepareStatement(F4T1Ex1);
                statementF4T1Ex1.setString(1, this.adm.getText().toUpperCase());
                statementF4T1Ex1.setString(2, this.fname.getText().toUpperCase());
                statementF4T1Ex1.setString(3, this.mname.getText().toUpperCase());
                statementF4T1Ex1.setString(4, this.lname.getText().toUpperCase());
                statementF4T1Ex1.setString(5, this.kcpe.getText().toUpperCase());
                statementF4T1Ex1.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());

                PreparedStatement statementF4T1Ex2 = connection.prepareStatement(F4T1Ex2);
                statementF4T1Ex2.setString(1, this.adm.getText().toUpperCase());
                statementF4T1Ex2.setString(2, this.fname.getText().toUpperCase());
                statementF4T1Ex2.setString(3, this.mname.getText().toUpperCase());
                statementF4T1Ex2.setString(4, this.lname.getText().toUpperCase());
                statementF4T1Ex2.setString(5, this.kcpe.getText().toUpperCase());
                statementF4T1Ex2.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());

                PreparedStatement statementF4T1Ex3 = connection.prepareStatement(F4T1Ex3);
                statementF4T1Ex3.setString(1, this.adm.getText().toUpperCase());
                statementF4T1Ex3.setString(2, this.fname.getText().toUpperCase());
                statementF4T1Ex3.setString(3, this.mname.getText().toUpperCase());
                statementF4T1Ex3.setString(4, this.lname.getText().toUpperCase());
                statementF4T1Ex3.setString(5, this.kcpe.getText().toUpperCase());
                statementF4T1Ex3.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());

                PreparedStatement statementF4T2Ex1 = connection.prepareStatement(F4T2Ex1);
                statementF4T2Ex1.setString(1, this.adm.getText().toUpperCase());
                statementF4T2Ex1.setString(2, this.fname.getText().toUpperCase());
                statementF4T2Ex1.setString(3, this.mname.getText().toUpperCase());
                statementF4T2Ex1.setString(4, this.lname.getText().toUpperCase());
                statementF4T2Ex1.setString(5, this.kcpe.getText().toUpperCase());
                statementF4T2Ex1.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());

                PreparedStatement statementF4T2Ex2 = connection.prepareStatement(F4T2Ex2);
                statementF4T2Ex2.setString(1, this.adm.getText().toUpperCase());
                statementF4T2Ex2.setString(2, this.fname.getText().toUpperCase());
                statementF4T2Ex2.setString(3, this.mname.getText().toUpperCase());
                statementF4T2Ex2.setString(4, this.lname.getText().toUpperCase());
                statementF4T2Ex2.setString(5, this.kcpe.getText().toUpperCase());
                statementF4T2Ex2.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());

                PreparedStatement statementF4T2Ex3 = connection.prepareStatement(F4T2Ex3);
                statementF4T2Ex3.setString(1, this.adm.getText().toUpperCase());
                statementF4T2Ex3.setString(2, this.fname.getText().toUpperCase());
                statementF4T2Ex3.setString(3, this.mname.getText().toUpperCase());
                statementF4T2Ex3.setString(4, this.lname.getText().toUpperCase());
                statementF4T2Ex3.setString(5, this.kcpe.getText().toUpperCase());
                statementF4T2Ex3.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());

                PreparedStatement statementF4T3Ex1 = connection.prepareStatement(F4T3Ex1);
                statementF4T3Ex1.setString(1, this.adm.getText().toUpperCase());
                statementF4T3Ex1.setString(2, this.fname.getText().toUpperCase());
                statementF4T3Ex1.setString(3, this.mname.getText().toUpperCase());
                statementF4T3Ex1.setString(4, this.lname.getText().toUpperCase());
                statementF4T3Ex1.setString(5, this.kcpe.getText().toUpperCase());
                statementF4T3Ex1.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());

                PreparedStatement statementF4T3Ex2 = connection.prepareStatement(F4T3Ex2);
                statementF4T3Ex2.setString(1, this.adm.getText().toUpperCase());
                statementF4T3Ex2.setString(2, this.fname.getText().toUpperCase());
                statementF4T3Ex2.setString(3, this.mname.getText().toUpperCase());
                statementF4T3Ex2.setString(4, this.lname.getText().toUpperCase());
                statementF4T3Ex2.setString(5, this.kcpe.getText().toUpperCase());
                statementF4T3Ex2.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());

                PreparedStatement statementF4T3Ex3 = connection.prepareStatement(F4T3Ex3);
                statementF4T3Ex3.setString(1, this.adm.getText().toUpperCase());
                statementF4T3Ex3.setString(2, this.fname.getText().toUpperCase());
                statementF4T3Ex3.setString(3, this.mname.getText().toUpperCase());
                statementF4T3Ex3.setString(4, this.lname.getText().toUpperCase());
                statementF4T3Ex3.setString(5, this.kcpe.getText().toUpperCase());
                statementF4T3Ex3.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());


                PreparedStatement statementEngF1 = connection.prepareStatement(EngF1);
                statementEngF1.setString(1, this.adm.getText().toUpperCase());
                statementEngF1.setString(2, this.fname.getText().toUpperCase());
                statementEngF1.setString(3, this.mname.getText().toUpperCase());
                statementEngF1.setString(4, this.lname.getText().toUpperCase());
                statementEngF1.setString(5, this.kcpe.getText().toUpperCase());
                statementEngF1.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());

                PreparedStatement statementKisF1 = connection.prepareStatement(KisF1);
                statementKisF1.setString(1, this.adm.getText().toUpperCase());
                statementKisF1.setString(2, this.fname.getText().toUpperCase());
                statementKisF1.setString(3, this.mname.getText().toUpperCase());
                statementKisF1.setString(4, this.lname.getText().toUpperCase());
                statementKisF1.setString(5, this.kcpe.getText().toUpperCase());
                statementKisF1.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());

                PreparedStatement statementMatF1 = connection.prepareStatement(MatF1);
                statementMatF1.setString(1, this.adm.getText().toUpperCase());
                statementMatF1.setString(2, this.fname.getText().toUpperCase());
                statementMatF1.setString(3, this.mname.getText().toUpperCase());
                statementMatF1.setString(4, this.lname.getText().toUpperCase());
                statementMatF1.setString(5, this.kcpe.getText().toUpperCase());
                statementMatF1.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());

                PreparedStatement statementBioF1 = connection.prepareStatement(BioF1);
                statementBioF1.setString(1, this.adm.getText().toUpperCase());
                statementBioF1.setString(2, this.fname.getText().toUpperCase());
                statementBioF1.setString(3, this.mname.getText().toUpperCase());
                statementBioF1.setString(4, this.lname.getText().toUpperCase());
                statementBioF1.setString(5, this.kcpe.getText().toUpperCase());
                statementBioF1.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());

                PreparedStatement statementPhyF1 = connection.prepareStatement(PhyF1);
                statementPhyF1.setString(1, this.adm.getText().toUpperCase());
                statementPhyF1.setString(2, this.fname.getText().toUpperCase());
                statementPhyF1.setString(3, this.mname.getText().toUpperCase());
                statementPhyF1.setString(4, this.lname.getText().toUpperCase());
                statementPhyF1.setString(5, this.kcpe.getText().toUpperCase());
                statementPhyF1.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());

                PreparedStatement statementChemF1 = connection.prepareStatement(ChemF1);
                statementChemF1.setString(1, this.adm.getText().toUpperCase());
                statementChemF1.setString(2, this.fname.getText().toUpperCase());
                statementChemF1.setString(3, this.mname.getText().toUpperCase());
                statementChemF1.setString(4, this.lname.getText().toUpperCase());
                statementChemF1.setString(5, this.kcpe.getText().toUpperCase());
                statementChemF1.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());

                PreparedStatement statementGeoF1 = connection.prepareStatement(GeoF1);
                statementGeoF1.setString(1, this.adm.getText().toUpperCase());
                statementGeoF1.setString(2, this.fname.getText().toUpperCase());
                statementGeoF1.setString(3, this.mname.getText().toUpperCase());
                statementGeoF1.setString(4, this.lname.getText().toUpperCase());
                statementGeoF1.setString(5, this.kcpe.getText().toUpperCase());
                statementGeoF1.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());

                PreparedStatement statementHisF1 = connection.prepareStatement(HisF1);
                statementHisF1.setString(1, this.adm.getText().toUpperCase());
                statementHisF1.setString(2, this.fname.getText().toUpperCase());
                statementHisF1.setString(3, this.mname.getText().toUpperCase());
                statementHisF1.setString(4, this.lname.getText().toUpperCase());
                statementHisF1.setString(5, this.kcpe.getText().toUpperCase());
                statementHisF1.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());

                PreparedStatement statementCreF1 = connection.prepareStatement(CreF1);
                statementCreF1.setString(1, this.adm.getText().toUpperCase());
                statementCreF1.setString(2, this.fname.getText().toUpperCase());
                statementCreF1.setString(3, this.mname.getText().toUpperCase());
                statementCreF1.setString(4, this.lname.getText().toUpperCase());
                statementCreF1.setString(5, this.kcpe.getText().toUpperCase());
                statementCreF1.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());

                PreparedStatement statementAgriF1 = connection.prepareStatement(AgriF1);
                statementAgriF1.setString(1, this.adm.getText().toUpperCase());
                statementAgriF1.setString(2, this.fname.getText().toUpperCase());
                statementAgriF1.setString(3, this.mname.getText().toUpperCase());
                statementAgriF1.setString(4, this.lname.getText().toUpperCase());
                statementAgriF1.setString(5, this.kcpe.getText().toUpperCase());
                statementAgriF1.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());

                PreparedStatement statementBusF1 = connection.prepareStatement(BusF1);
                statementBusF1.setString(1, this.adm.getText().toUpperCase());
                statementBusF1.setString(2, this.fname.getText().toUpperCase());
                statementBusF1.setString(3, this.mname.getText().toUpperCase());
                statementBusF1.setString(4, this.lname.getText().toUpperCase());
                statementBusF1.setString(5, this.kcpe.getText().toUpperCase());
                statementBusF1.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());


                PreparedStatement statementEngF2 = connection.prepareStatement(EngF2);
                statementEngF2.setString(1, this.adm.getText().toUpperCase());
                statementEngF2.setString(2, this.fname.getText().toUpperCase());
                statementEngF2.setString(3, this.mname.getText().toUpperCase());
                statementEngF2.setString(4, this.lname.getText().toUpperCase());
                statementEngF2.setString(5, this.kcpe.getText().toUpperCase());
                statementEngF2.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());

                PreparedStatement statementKisF2 = connection.prepareStatement(KisF2);
                statementKisF2.setString(1, this.adm.getText().toUpperCase());
                statementKisF2.setString(2, this.fname.getText().toUpperCase());
                statementKisF2.setString(3, this.mname.getText().toUpperCase());
                statementKisF2.setString(4, this.lname.getText().toUpperCase());
                statementKisF2.setString(5, this.kcpe.getText().toUpperCase());
                statementKisF2.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());

                PreparedStatement statementMatF2 = connection.prepareStatement(MatF2);
                statementMatF2.setString(1, this.adm.getText().toUpperCase());
                statementMatF2.setString(2, this.fname.getText().toUpperCase());
                statementMatF2.setString(3, this.mname.getText().toUpperCase());
                statementMatF2.setString(4, this.lname.getText().toUpperCase());
                statementMatF2.setString(5, this.kcpe.getText().toUpperCase());
                statementMatF2.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());

                PreparedStatement statementBioF2 = connection.prepareStatement(BioF2);
                statementBioF2.setString(1, this.adm.getText().toUpperCase());
                statementBioF2.setString(2, this.fname.getText().toUpperCase());
                statementBioF2.setString(3, this.mname.getText().toUpperCase());
                statementBioF2.setString(4, this.lname.getText().toUpperCase());
                statementBioF2.setString(5, this.kcpe.getText().toUpperCase());
                statementBioF2.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());

                PreparedStatement statementPhyF2 = connection.prepareStatement(PhyF2);
                statementPhyF2.setString(1, this.adm.getText().toUpperCase());
                statementPhyF2.setString(2, this.fname.getText().toUpperCase());
                statementPhyF2.setString(3, this.mname.getText().toUpperCase());
                statementPhyF2.setString(4, this.lname.getText().toUpperCase());
                statementPhyF2.setString(5, this.kcpe.getText().toUpperCase());
                statementPhyF2.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());

                PreparedStatement statementChemF2 = connection.prepareStatement(ChemF2);
                statementChemF2.setString(1, this.adm.getText().toUpperCase());
                statementChemF2.setString(2, this.fname.getText().toUpperCase());
                statementChemF2.setString(3, this.mname.getText().toUpperCase());
                statementChemF2.setString(4, this.lname.getText().toUpperCase());
                statementChemF2.setString(5, this.kcpe.getText().toUpperCase());
                statementChemF2.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());

                PreparedStatement statementGeoF2 = connection.prepareStatement(GeoF2);
                statementGeoF2.setString(1, this.adm.getText().toUpperCase());
                statementGeoF2.setString(2, this.fname.getText().toUpperCase());
                statementGeoF2.setString(3, this.mname.getText().toUpperCase());
                statementGeoF2.setString(4, this.lname.getText().toUpperCase());
                statementGeoF2.setString(5, this.kcpe.getText().toUpperCase());
                statementGeoF2.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());

                PreparedStatement statementHisF2 = connection.prepareStatement(HisF2);
                statementHisF2.setString(1, this.adm.getText().toUpperCase());
                statementHisF2.setString(2, this.fname.getText().toUpperCase());
                statementHisF2.setString(3, this.mname.getText().toUpperCase());
                statementHisF2.setString(4, this.lname.getText().toUpperCase());
                statementHisF2.setString(5, this.kcpe.getText().toUpperCase());
                statementHisF2.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());

                PreparedStatement statementCreF2 = connection.prepareStatement(CreF2);
                statementCreF2.setString(1, this.adm.getText().toUpperCase());
                statementCreF2.setString(2, this.fname.getText().toUpperCase());
                statementCreF2.setString(3, this.mname.getText().toUpperCase());
                statementCreF2.setString(4, this.lname.getText().toUpperCase());
                statementCreF2.setString(5, this.kcpe.getText().toUpperCase());
                statementCreF2.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());

                PreparedStatement statementAgriF2 = connection.prepareStatement(AgriF2);
                statementAgriF2.setString(1, this.adm.getText().toUpperCase());
                statementAgriF2.setString(2, this.fname.getText().toUpperCase());
                statementAgriF2.setString(3, this.mname.getText().toUpperCase());
                statementAgriF2.setString(4, this.lname.getText().toUpperCase());
                statementAgriF2.setString(5, this.kcpe.getText().toUpperCase());
                statementAgriF2.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());

                PreparedStatement statementBusF2 = connection.prepareStatement(BusF2);
                statementBusF2.setString(1, this.adm.getText().toUpperCase());
                statementBusF2.setString(2, this.fname.getText().toUpperCase());
                statementBusF2.setString(3, this.mname.getText().toUpperCase());
                statementBusF2.setString(4, this.lname.getText().toUpperCase());
                statementBusF2.setString(5, this.kcpe.getText().toUpperCase());
                statementBusF2.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());


                PreparedStatement statementEngF3 = connection.prepareStatement(EngF3);
                statementEngF3.setString(1, this.adm.getText().toUpperCase());
                statementEngF3.setString(2, this.fname.getText().toUpperCase());
                statementEngF3.setString(3, this.mname.getText().toUpperCase());
                statementEngF3.setString(4, this.lname.getText().toUpperCase());
                statementEngF3.setString(5, this.kcpe.getText().toUpperCase());
                statementEngF3.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());

                PreparedStatement statementKisF3 = connection.prepareStatement(KisF3);
                statementKisF3.setString(1, this.adm.getText().toUpperCase());
                statementKisF3.setString(2, this.fname.getText().toUpperCase());
                statementKisF3.setString(3, this.mname.getText().toUpperCase());
                statementKisF3.setString(4, this.lname.getText().toUpperCase());
                statementKisF3.setString(5, this.kcpe.getText().toUpperCase());
                statementKisF3.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());

                PreparedStatement statementMatF3 = connection.prepareStatement(MatF3);
                statementMatF3.setString(1, this.adm.getText().toUpperCase());
                statementMatF3.setString(2, this.fname.getText().toUpperCase());
                statementMatF3.setString(3, this.mname.getText().toUpperCase());
                statementMatF3.setString(4, this.lname.getText().toUpperCase());
                statementMatF3.setString(5, this.kcpe.getText().toUpperCase());
                statementMatF3.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());

                PreparedStatement statementBioF3 = connection.prepareStatement(BioF3);
                statementBioF3.setString(1, this.adm.getText().toUpperCase());
                statementBioF3.setString(2, this.fname.getText().toUpperCase());
                statementBioF3.setString(3, this.mname.getText().toUpperCase());
                statementBioF3.setString(4, this.lname.getText().toUpperCase());
                statementBioF3.setString(5, this.kcpe.getText().toUpperCase());
                statementBioF3.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());

                PreparedStatement statementPhyF3 = connection.prepareStatement(PhyF3);
                statementPhyF3.setString(1, this.adm.getText().toUpperCase());
                statementPhyF3.setString(2, this.fname.getText().toUpperCase());
                statementPhyF3.setString(3, this.mname.getText().toUpperCase());
                statementPhyF3.setString(4, this.lname.getText().toUpperCase());
                statementPhyF3.setString(5, this.kcpe.getText().toUpperCase());
                statementPhyF3.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());

                PreparedStatement statementChemF3 = connection.prepareStatement(ChemF3);
                statementChemF3.setString(1, this.adm.getText().toUpperCase());
                statementChemF3.setString(2, this.fname.getText().toUpperCase());
                statementChemF3.setString(3, this.mname.getText().toUpperCase());
                statementChemF3.setString(4, this.lname.getText().toUpperCase());
                statementChemF3.setString(5, this.kcpe.getText().toUpperCase());
                statementChemF3.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());

                PreparedStatement statementGeoF3 = connection.prepareStatement(GeoF3);
                statementGeoF3.setString(1, this.adm.getText().toUpperCase());
                statementGeoF3.setString(2, this.fname.getText().toUpperCase());
                statementGeoF3.setString(3, this.mname.getText().toUpperCase());
                statementGeoF3.setString(4, this.lname.getText().toUpperCase());
                statementGeoF3.setString(5, this.kcpe.getText().toUpperCase());
                statementGeoF3.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());

                PreparedStatement statementHisF3 = connection.prepareStatement(HisF3);
                statementHisF3.setString(1, this.adm.getText().toUpperCase());
                statementHisF3.setString(2, this.fname.getText().toUpperCase());
                statementHisF3.setString(3, this.mname.getText().toUpperCase());
                statementHisF3.setString(4, this.lname.getText().toUpperCase());
                statementHisF3.setString(5, this.kcpe.getText().toUpperCase());
                statementHisF3.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());

                PreparedStatement statementCreF3 = connection.prepareStatement(CreF3);
                statementCreF3.setString(1, this.adm.getText().toUpperCase());
                statementCreF3.setString(2, this.fname.getText().toUpperCase());
                statementCreF3.setString(3, this.mname.getText().toUpperCase());
                statementCreF3.setString(4, this.lname.getText().toUpperCase());
                statementCreF3.setString(5, this.kcpe.getText().toUpperCase());
                statementCreF3.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());

                PreparedStatement statementAgriF3 = connection.prepareStatement(AgriF3);
                statementAgriF3.setString(1, this.adm.getText().toUpperCase());
                statementAgriF3.setString(2, this.fname.getText().toUpperCase());
                statementAgriF3.setString(3, this.mname.getText().toUpperCase());
                statementAgriF3.setString(4, this.lname.getText().toUpperCase());
                statementAgriF3.setString(5, this.kcpe.getText().toUpperCase());
                statementAgriF3.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());

                PreparedStatement statementBusF3 = connection.prepareStatement(BusF3);
                statementBusF3.setString(1, this.adm.getText().toUpperCase());
                statementBusF3.setString(2, this.fname.getText().toUpperCase());
                statementBusF3.setString(3, this.mname.getText().toUpperCase());
                statementBusF3.setString(4, this.lname.getText().toUpperCase());
                statementBusF3.setString(5, this.kcpe.getText().toUpperCase());
                statementBusF3.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());


                PreparedStatement statementEngF4 = connection.prepareStatement(EngF4);
                statementEngF4.setString(1, this.adm.getText().toUpperCase());
                statementEngF4.setString(2, this.fname.getText().toUpperCase());
                statementEngF4.setString(3, this.mname.getText().toUpperCase());
                statementEngF4.setString(4, this.lname.getText().toUpperCase());
                statementEngF4.setString(5, this.kcpe.getText().toUpperCase());
                statementEngF4.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());

                PreparedStatement statementKisF4 = connection.prepareStatement(KisF4);
                statementKisF4.setString(1, this.adm.getText().toUpperCase());
                statementKisF4.setString(2, this.fname.getText().toUpperCase());
                statementKisF4.setString(3, this.mname.getText().toUpperCase());
                statementKisF4.setString(4, this.lname.getText().toUpperCase());
                statementKisF4.setString(5, this.kcpe.getText().toUpperCase());
                statementKisF4.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());

                PreparedStatement statementMatF4 = connection.prepareStatement(MatF4);
                statementMatF4.setString(1, this.adm.getText().toUpperCase());
                statementMatF4.setString(2, this.fname.getText().toUpperCase());
                statementMatF4.setString(3, this.mname.getText().toUpperCase());
                statementMatF4.setString(4, this.lname.getText().toUpperCase());
                statementMatF4.setString(5, this.kcpe.getText().toUpperCase());
                statementMatF4.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());

                PreparedStatement statementBioF4 = connection.prepareStatement(BioF4);
                statementBioF4.setString(1, this.adm.getText().toUpperCase());
                statementBioF4.setString(2, this.fname.getText().toUpperCase());
                statementBioF4.setString(3, this.mname.getText().toUpperCase());
                statementBioF4.setString(4, this.lname.getText().toUpperCase());
                statementBioF4.setString(5, this.kcpe.getText().toUpperCase());
                statementBioF4.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());

                PreparedStatement statementPhyF4 = connection.prepareStatement(PhyF4);
                statementPhyF4.setString(1, this.adm.getText().toUpperCase());
                statementPhyF4.setString(2, this.fname.getText().toUpperCase());
                statementPhyF4.setString(3, this.mname.getText().toUpperCase());
                statementPhyF4.setString(4, this.lname.getText().toUpperCase());
                statementPhyF4.setString(5, this.kcpe.getText().toUpperCase());
                statementPhyF4.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());

                PreparedStatement statementChemF4 = connection.prepareStatement(ChemF4);
                statementChemF4.setString(1, this.adm.getText().toUpperCase());
                statementChemF4.setString(2, this.fname.getText().toUpperCase());
                statementChemF4.setString(3, this.mname.getText().toUpperCase());
                statementChemF4.setString(4, this.lname.getText().toUpperCase());
                statementChemF4.setString(5, this.kcpe.getText().toUpperCase());
                statementChemF4.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());

                PreparedStatement statementGeoF4 = connection.prepareStatement(GeoF4);
                statementGeoF4.setString(1, this.adm.getText().toUpperCase());
                statementGeoF4.setString(2, this.fname.getText().toUpperCase());
                statementGeoF4.setString(3, this.mname.getText().toUpperCase());
                statementGeoF4.setString(4, this.lname.getText().toUpperCase());
                statementGeoF4.setString(5, this.kcpe.getText().toUpperCase());
                statementGeoF4.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());

                PreparedStatement statementHisF4 = connection.prepareStatement(HisF4);
                statementHisF4.setString(1, this.adm.getText().toUpperCase());
                statementHisF4.setString(2, this.fname.getText().toUpperCase());
                statementHisF4.setString(3, this.mname.getText().toUpperCase());
                statementHisF4.setString(4, this.lname.getText().toUpperCase());
                statementHisF4.setString(5, this.kcpe.getText().toUpperCase());
                statementHisF4.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());

                PreparedStatement statementCreF4 = connection.prepareStatement(CreF4);
                statementCreF4.setString(1, this.adm.getText().toUpperCase());
                statementCreF4.setString(2, this.fname.getText().toUpperCase());
                statementCreF4.setString(3, this.mname.getText().toUpperCase());
                statementCreF4.setString(4, this.lname.getText().toUpperCase());
                statementCreF4.setString(5, this.kcpe.getText().toUpperCase());
                statementCreF4.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());

                PreparedStatement statementAgriF4 = connection.prepareStatement(AgriF4);
                statementAgriF4.setString(1, this.adm.getText().toUpperCase());
                statementAgriF4.setString(2, this.fname.getText().toUpperCase());
                statementAgriF4.setString(3, this.mname.getText().toUpperCase());
                statementAgriF4.setString(4, this.lname.getText().toUpperCase());
                statementAgriF4.setString(5, this.kcpe.getText().toUpperCase());
                statementAgriF4.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());

                PreparedStatement statementBusF4 = connection.prepareStatement(BusF4);
                statementBusF4.setString(1, this.adm.getText().toUpperCase());
                statementBusF4.setString(2, this.fname.getText().toUpperCase());
                statementBusF4.setString(3, this.mname.getText().toUpperCase());
                statementBusF4.setString(4, this.lname.getText().toUpperCase());
                statementBusF4.setString(5, this.kcpe.getText().toUpperCase());
                statementBusF4.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());


                statementStudent.execute();
                statementSubjects.execute();
                statementF1T1Avg.execute();
                statementF1T2Avg.execute();
                statementF1T3Avg.execute();
                statementF2T1Avg.execute();
                statementF2T2Avg.execute();
                statementF2T3Avg.execute();
                statementF3T1Avg.execute();
                statementF3T2Avg.execute();
                statementF3T3Avg.execute();
                statementF4T1Avg.execute();
                statementF4T2Avg.execute();
                statementF4T3Avg.execute();//start
                statementF1T1Ex1.execute();
                statementF1T1Ex2.execute();
                statementF1T1Ex3.execute();
                statementF1T2Ex1.execute();
                statementF1T2Ex2.execute();
                statementF1T2Ex3.execute();
                statementF1T3Ex1.execute();
                statementF1T3Ex2.execute();
                statementF1T3Ex3.execute();///syart
                statementF2T1Ex1.execute();
                statementF2T1Ex2.execute();
                statementF2T1Ex3.execute();
                statementF2T2Ex1.execute();
                statementF2T2Ex2.execute();
                statementF2T2Ex3.execute();
                statementF2T3Ex1.execute();
                statementF2T3Ex2.execute();
                statementF2T3Ex3.execute();//start
                statementF3T1Ex1.execute();
                statementF3T1Ex2.execute();
                statementF3T1Ex3.execute();
                statementF3T2Ex1.execute();
                statementF3T2Ex2.execute();
                statementF3T2Ex3.execute();
                statementF3T3Ex1.execute();
                statementF3T3Ex2.execute();
                statementF3T3Ex3.execute();//start
                statementF4T1Ex1.execute();
                statementF4T1Ex2.execute();
                statementF4T1Ex3.execute();
                statementF4T2Ex1.execute();
                statementF4T2Ex2.execute();
                statementF4T2Ex3.execute();
                statementF4T3Ex1.execute();
                statementF4T3Ex2.execute();
                statementF4T3Ex3.execute();
                statementEngF1.execute();//start
                statementKisF1.execute();
                statementMatF1.execute();
                statementBioF1.execute();
                statementChemF1.execute();
                statementPhyF1.execute();
                statementGeoF1.execute();
                statementHisF1.execute();
                statementCreF1.execute();
                statementAgriF1.execute();
                statementBusF1.execute();
                statementEngF2.execute();
                statementKisF2.execute();
                statementMatF2.execute();
                statementBioF2.execute();
                statementChemF2.execute();
                statementPhyF2.execute();
                statementGeoF2.execute();
                statementHisF2.execute();
                statementCreF2.execute();
                statementAgriF2.execute();
                statementBusF2.execute();
                statementEngF3.execute();
                statementKisF3.execute();
                statementMatF3.execute();
                statementBioF3.execute();
                statementChemF3.execute();
                statementPhyF3.execute();
                statementGeoF3.execute();
                statementHisF3.execute();
                statementCreF3.execute();
                statementAgriF3.execute();
                statementBusF3.execute();
                statementEngF4.execute();
                statementKisF4.execute();
                statementMatF4.execute();
                statementBioF4.execute();
                statementChemF4.execute();
                statementPhyF4.execute();
                statementGeoF4.execute();
                statementHisF4.execute();
                statementCreF4.execute();
                statementAgriF4.execute();
                statementBusF4.execute();
                emptyTextFields();
                connection.close();
                loadData();
                infoBox("Student added successfully","Success",null);

            } catch (Exception e) {
                infoBoxError("An error occurred " + e, "Error", null);
                e.printStackTrace();
            }
        }
    }

    public void emptyTextFields(){
        this.adm.clear();
        this.fname.clear();
        this.mname.clear();
        this.lname.clear();
        this.kcpe.clear();
        this.classes.getEditor().clear();
        this.dob.getEditor().clear();
     }

    public void loadData(){

         String sql = "SELECT * FROM tbl_students";
         try{
             Connection connection = Database.DBConnection.getConnection();
             this.tableList = FXCollections.observableArrayList();
             ResultSet set = connection.createStatement().executeQuery(sql);
             while (set.next()){
                 this.tableList.addAll(new tableStudentsData(set.getString(1),set.getString(2),set.getString(3),set.getString(4),set.getString(5),set.getString(6),set.getString(7),set.getString(8)));
             }

             this.idColumn.setCellValueFactory(new PropertyValueFactory<tableStudentsData,String>("id"));
             this.admColumn.setCellValueFactory(new PropertyValueFactory<tableStudentsData,String>("adm"));
             this.fnameColumn.setCellValueFactory(new PropertyValueFactory<tableStudentsData,String>("fname"));
             this.mnameColumn.setCellValueFactory(new PropertyValueFactory<tableStudentsData,String>("mname"));
             this.lnameColumn.setCellValueFactory(new PropertyValueFactory<tableStudentsData,String>("lname"));
             this.kcpeColumn.setCellValueFactory(new PropertyValueFactory<tableStudentsData,String>("kcpe"));
             this.classColumn.setCellValueFactory(new PropertyValueFactory<tableStudentsData,String>("classes"));
             this.dobColumn.setCellValueFactory(new PropertyValueFactory<tableStudentsData,String>("dob"));
             this.deleteColumn.setCellFactory((Callback<TableColumn<tableStudentsData, Boolean>, TableCell<tableStudentsData, Boolean>>) p ->  new ButtonCell());

             this.tableStudents.setItems(null);
             this.tableStudents.setItems(this.tableList);

         }catch (Exception e){
             infoBoxError("An error occurred " + e,"Error",null);
         }
     }

    private class ButtonCell extends TableCell<tableStudentsData, Boolean> {
        final Button cellButton = new Button("Delete");
        ButtonCell(){
            cellButton.setOnAction(new EventHandler<ActionEvent>(){
                @Override
                public void handle(ActionEvent t) {
                    String students = "DELETE FROM tbl_students WHERE adm=?";
                    String subject = "DELETE FROM tbl_subject_selection WHERE adm=?";
                    String F1T1Avg = "DELETE FROM tbl_f1_t1_avg WHERE adm=?";
                    String F1T2Avg = "DELETE FROM tbl_f1_t2_avg WHERE adm=?";
                    String F1T3Avg = "DELETE FROM tbl_f1_t3_avg WHERE adm=?";
                    String F2T1Avg = "DELETE FROM tbl_f2_t1_avg WHERE adm=?";
                    String F2T2Avg = "DELETE FROM tbl_f2_t2_avg WHERE adm=?";
                    String F2T3Avg = "DELETE FROM tbl_f2_t3_avg WHERE adm=?";
                    String F3T1Avg = "DELETE FROM tbl_f3_t1_avg WHERE adm=?";
                    String F3T2Avg = "DELETE FROM tbl_f3_t2_avg WHERE adm=?";
                    String F3T3Avg = "DELETE FROM tbl_f3_t3_avg WHERE adm=?";
                    String F4T1Avg = "DELETE FROM tbl_f4_t1_avg WHERE adm=?";
                    String F4T2Avg = "DELETE FROM tbl_f4_t2_avg WHERE adm=?";
                    String F4T3Avg = "DELETE FROM tbl_f4_t3_avg WHERE adm=?";


                    String F1T1Ex1 = "DELETE FROM tbl_f1_t1_ex1 WHERE adm=?";
                    String F1T1Ex2 = "DELETE FROM tbl_f1_t1_ex2 WHERE adm=?";
                    String F1T1Ex3 = "DELETE FROM tbl_f1_t1_ex3 WHERE adm=?";
                    String F1T2Ex1 = "DELETE FROM tbl_f1_t2_ex1 WHERE adm=?";
                    String F1T2Ex2 = "DELETE FROM tbl_f1_t2_ex2 WHERE adm=?";
                    String F1T2Ex3 = "DELETE FROM tbl_f1_t2_ex3 WHERE adm=?";
                    String F1T3Ex1 = "DELETE FROM tbl_f1_t3_ex1 WHERE adm=?";
                    String F1T3Ex2 = "DELETE FROM tbl_f1_t3_ex2 WHERE adm=?";
                    String F1T3Ex3 = "DELETE FROM tbl_f1_t3_ex3 WHERE adm=?";

                    String F2T1Ex1 = "DELETE FROM tbl_f2_t1_ex1 WHERE adm=?";
                    String F2T1Ex2 = "DELETE FROM tbl_f2_t1_ex2 WHERE adm=?";
                    String F2T1Ex3 = "DELETE FROM tbl_f2_t1_ex3 WHERE adm=?";
                    String F2T2Ex1 = "DELETE FROM tbl_f2_t2_ex1 WHERE adm=?";
                    String F2T2Ex2 = "DELETE FROM tbl_f2_t2_ex2 WHERE adm=?";
                    String F2T2Ex3 = "DELETE FROM tbl_f2_t2_ex3 WHERE adm=?";
                    String F2T3Ex1 = "DELETE FROM tbl_f2_t3_ex1 WHERE adm=?";
                    String F2T3Ex2 = "DELETE FROM tbl_f2_t3_ex2 WHERE adm=?";
                    String F2T3Ex3 = "DELETE FROM tbl_f2_t3_ex3 WHERE adm=?";

                    String F3T1Ex1 = "DELETE FROM tbl_f3_t1_ex1 WHERE adm=?";
                    String F3T1Ex2 = "DELETE FROM tbl_f3_t1_ex2 WHERE adm=?";
                    String F3T1Ex3 = "DELETE FROM tbl_f3_t1_ex3 WHERE adm=?";
                    String F3T2Ex1 = "DELETE FROM tbl_f3_t2_ex1 WHERE adm=?";
                    String F3T2Ex2 = "DELETE FROM tbl_f3_t2_ex2 WHERE adm=?";
                    String F3T2Ex3 = "DELETE FROM tbl_f3_t2_ex3 WHERE adm=?";
                    String F3T3Ex1 = "DELETE FROM tbl_f3_t3_ex1 WHERE adm=?";
                    String F3T3Ex2 = "DELETE FROM tbl_f3_t3_ex2 WHERE adm=?";
                    String F3T3Ex3 = "DELETE FROM tbl_f3_t3_ex3 WHERE adm=?";

                    String F4T1Ex1 = "DELETE FROM tbl_f4_t1_ex1 WHERE adm=?";
                    String F4T1Ex2 = "DELETE FROM tbl_f4_t1_ex2 WHERE adm=?";
                    String F4T1Ex3 = "DELETE FROM tbl_f4_t1_ex3 WHERE adm=?";
                    String F4T2Ex1 = "DELETE FROM tbl_f4_t2_ex1 WHERE adm=?";
                    String F4T2Ex2 = "DELETE FROM tbl_f4_t2_ex2 WHERE adm=?";
                    String F4T2Ex3 = "DELETE FROM tbl_f4_t2_ex3 WHERE adm=?";
                    String F4T3Ex1 = "DELETE FROM tbl_f4_t3_ex1 WHERE adm=?";
                    String F4T3Ex2 = "DELETE FROM tbl_f4_t3_ex2 WHERE adm=?";
                    String F4T3Ex3 = "DELETE FROM tbl_f4_t3_ex3 WHERE adm=?";


                    String EngF1 = "DELETE FROM tbl_f1_eng WHERE adm=?";
                    String KisF1 = "DELETE FROM tbl_f1_kis WHERE adm=?";
                    String MatF1 = "DELETE FROM tbl_f1_mat WHERE adm=?";
                    String BioF1 = "DELETE FROM tbl_f1_bio WHERE adm=?";
                    String PhyF1 = "DELETE FROM tbl_f1_phy WHERE adm=?";
                    String ChemF1 = "DELETE FROM tbl_f1_chem WHERE adm=?";
                    String GeoF1 = "DELETE FROM tbl_f1_geo WHERE adm=?";
                    String HisF1 = "DELETE FROM tbl_f1_his WHERE adm=?";
                    String CreF1 = "DELETE FROM tbl_f1_cre WHERE adm=?";
                    String AgriF1 = "DELETE FROM tbl_f1_agri WHERE adm=?";
                    String BusF1 = "DELETE FROM tbl_f1_bus WHERE adm=?";
                    String EngF2 = "DELETE FROM tbl_f2_eng WHERE adm=?";
                    String KisF2 = "DELETE FROM tbl_f2_kis WHERE adm=?";
                    String MatF2 = "DELETE FROM tbl_f2_mat WHERE adm=?";
                    String BioF2 = "DELETE FROM tbl_f2_bio WHERE adm=?";
                    String PhyF2 = "DELETE FROM tbl_f2_phy WHERE adm=?";
                    String ChemF2 = "DELETE FROM tbl_f2_chem WHERE adm=?";
                    String GeoF2 = "DELETE FROM tbl_f2_geo WHERE adm=?";
                    String HisF2 = "DELETE FROM tbl_f2_his WHERE adm=?";
                    String CreF2 = "DELETE FROM tbl_f2_cre WHERE adm=?";
                    String AgriF2 = "DELETE FROM tbl_f2_agri WHERE adm=?";
                    String BusF2 = "DELETE FROM tbl_f2_bus WHERE adm=?";
                    String EngF3 = "DELETE FROM tbl_f3_eng WHERE adm=?";
                    String KisF3 = "DELETE FROM tbl_f3_kis WHERE adm=?";
                    String MatF3 = "DELETE FROM tbl_f3_mat WHERE adm=?";
                    String BioF3 = "DELETE FROM tbl_f3_bio WHERE adm=?";
                    String PhyF3 = "DELETE FROM tbl_f3_phy WHERE adm=?";
                    String ChemF3 = "DELETE FROM tbl_f3_chem WHERE adm=?";
                    String GeoF3 = "DELETE FROM tbl_f3_geo WHERE adm=?";
                    String HisF3 = "DELETE FROM tbl_f3_his WHERE adm=?";
                    String CreF3 = "DELETE FROM tbl_f3_cre WHERE adm=?";
                    String AgriF3 = "DELETE FROM tbl_f3_agri WHERE adm=?";
                    String BusF3 = "DELETE FROM tbl_f3_bus WHERE adm=?";
                    String EngF4 = "DELETE FROM tbl_f4_eng WHERE adm=?";
                    String KisF4 = "DELETE FROM tbl_f4_kis WHERE adm=?";
                    String MatF4 = "DELETE FROM tbl_f4_mat WHERE adm=?";
                    String BioF4 = "DELETE FROM tbl_f4_bio WHERE adm=?";
                    String PhyF4 = "DELETE FROM tbl_f4_phy WHERE adm=?";
                    String ChemF4 = "DELETE FROM tbl_f4_chem WHERE adm=?";
                    String GeoF4 = "DELETE FROM tbl_f4_geo WHERE adm=?";
                    String HisF4 = "DELETE FROM tbl_f4_his WHERE adm=?";
                    String CreF4 = "DELETE FROM tbl_f4_cre WHERE adm=?";
                    String AgriF4 = "DELETE FROM tbl_f4_agri WHERE adm=?";
                    String BusF4 = "DELETE FROM tbl_f4_bus WHERE adm=?";

                    try {
                        Connection connection = Database.DBConnection.getConnection();
                        PreparedStatement statementStudents = connection.prepareStatement(students);
                        PreparedStatement statementSubject = connection.prepareStatement(subject);

                        PreparedStatement statementF1T1AVG = connection.prepareStatement(F1T1Avg);
                        PreparedStatement statementF1T2AVG = connection.prepareStatement(F1T2Avg);
                        PreparedStatement statementF1T3AVG = connection.prepareStatement(F1T3Avg);
                        PreparedStatement statementF2T1AVG = connection.prepareStatement(F2T1Avg);
                        PreparedStatement statementF2T2AVG = connection.prepareStatement(F2T2Avg);
                        PreparedStatement statementF2T3AVG = connection.prepareStatement(F2T3Avg);
                        PreparedStatement statementF3T1AVG = connection.prepareStatement(F3T1Avg);
                        PreparedStatement statementF3T2AVG = connection.prepareStatement(F3T2Avg);
                        PreparedStatement statementF3T3AVG = connection.prepareStatement(F3T3Avg);
                        PreparedStatement statementF4T1AVG = connection.prepareStatement(F4T1Avg);
                        PreparedStatement statementF4T2AVG = connection.prepareStatement(F4T2Avg);
                        PreparedStatement statementF4T3AVG = connection.prepareStatement(F4T3Avg);

                        PreparedStatement statementF1T1Ex1 = connection.prepareStatement(F1T1Ex1);
                        PreparedStatement statementF1T1Ex2 = connection.prepareStatement(F1T1Ex2);
                        PreparedStatement statementF1T1Ex3 = connection.prepareStatement(F1T1Ex3);
                        PreparedStatement statementF1T2Ex1 = connection.prepareStatement(F1T2Ex1);
                        PreparedStatement statementF1T2Ex2= connection.prepareStatement(F1T2Ex2);
                        PreparedStatement statementF1T2Ex3= connection.prepareStatement(F1T2Ex3);
                        PreparedStatement statementF1T3Ex1= connection.prepareStatement(F1T3Ex1);
                        PreparedStatement statementF1T3Ex2= connection.prepareStatement(F1T3Ex2);
                        PreparedStatement statementF1T3Ex3= connection.prepareStatement(F1T3Ex3);///syart
                        PreparedStatement statementF2T1Ex1= connection.prepareStatement(F2T1Ex1);
                        PreparedStatement statementF2T1Ex2= connection.prepareStatement(F2T1Ex2);
                        PreparedStatement statementF2T1Ex3= connection.prepareStatement(F2T1Ex3);
                        PreparedStatement statementF2T2Ex1= connection.prepareStatement(F2T2Ex1);
                        PreparedStatement statementF2T2Ex2= connection.prepareStatement(F2T2Ex2);
                        PreparedStatement statementF2T2Ex3= connection.prepareStatement(F2T2Ex3);
                        PreparedStatement statementF2T3Ex1= connection.prepareStatement(F2T3Ex1);
                        PreparedStatement statementF2T3Ex2= connection.prepareStatement(F2T3Ex2);
                        PreparedStatement statementF2T3Ex3= connection.prepareStatement(F2T3Ex3);//start
                        PreparedStatement statementF3T1Ex1= connection.prepareStatement(F3T1Ex1);
                        PreparedStatement statementF3T1Ex2= connection.prepareStatement(F3T1Ex2);
                        PreparedStatement statementF3T1Ex3= connection.prepareStatement(F3T1Ex3);
                        PreparedStatement statementF3T2Ex1= connection.prepareStatement(F3T2Ex1);
                        PreparedStatement statementF3T2Ex2= connection.prepareStatement(F3T2Ex2);
                        PreparedStatement statementF3T2Ex3= connection.prepareStatement(F3T2Ex3);
                        PreparedStatement statementF3T3Ex1= connection.prepareStatement(F3T3Ex1);
                        PreparedStatement statementF3T3Ex2= connection.prepareStatement(F3T3Ex2);
                        PreparedStatement statementF3T3Ex3= connection.prepareStatement(F3T3Ex3);//start
                        PreparedStatement statementF4T1Ex1= connection.prepareStatement(F4T1Ex1);
                        PreparedStatement statementF4T1Ex2= connection.prepareStatement(F4T1Ex2);
                        PreparedStatement statementF4T1Ex3= connection.prepareStatement(F4T1Ex3);
                        PreparedStatement statementF4T2Ex1= connection.prepareStatement(F4T2Ex1);
                        PreparedStatement statementF4T2Ex2= connection.prepareStatement(F4T2Ex2);
                        PreparedStatement statementF4T2Ex3= connection.prepareStatement(F4T2Ex3);
                        PreparedStatement statementF4T3Ex1= connection.prepareStatement(F4T3Ex1);
                        PreparedStatement statementF4T3Ex2= connection.prepareStatement(F4T3Ex2);
                        PreparedStatement statementF4T3Ex3= connection.prepareStatement(F4T3Ex3);

                        PreparedStatement statementEngF1 = connection.prepareStatement(EngF1);
                        PreparedStatement statementKisF1 = connection.prepareStatement(KisF1);
                        PreparedStatement statementMatF1 = connection.prepareStatement(MatF1);
                        PreparedStatement statementBioF1 = connection.prepareStatement(BioF1);
                        PreparedStatement statementChemF1 = connection.prepareStatement(ChemF1);
                        PreparedStatement statementPhyF1 = connection.prepareStatement(PhyF1);
                        PreparedStatement statementGeoF1 = connection.prepareStatement(GeoF1);
                        PreparedStatement statementHisF1 = connection.prepareStatement(HisF1);
                        PreparedStatement statementCreF1 = connection.prepareStatement(CreF1);
                        PreparedStatement statementBusF1 = connection.prepareStatement(BusF1);
                        PreparedStatement statementAgriF1 = connection.prepareStatement(AgriF1);

                        PreparedStatement statementEngF2 = connection.prepareStatement(EngF2);
                        PreparedStatement statementKisF2 = connection.prepareStatement(KisF2);
                        PreparedStatement statementMatF2 = connection.prepareStatement(MatF2);
                        PreparedStatement statementBioF2 = connection.prepareStatement(BioF2);
                        PreparedStatement statementChemF2 = connection.prepareStatement(ChemF2);
                        PreparedStatement statementPhyF2 = connection.prepareStatement(PhyF2);
                        PreparedStatement statementGeoF2 = connection.prepareStatement(GeoF2);
                        PreparedStatement statementHisF2 = connection.prepareStatement(HisF2);
                        PreparedStatement statementCreF2 = connection.prepareStatement(CreF2);
                        PreparedStatement statementBusF2 = connection.prepareStatement(BusF2);
                        PreparedStatement statementAgriF2 = connection.prepareStatement(AgriF2);

                        PreparedStatement statementEngF3 = connection.prepareStatement(EngF3);
                        PreparedStatement statementKisF3 = connection.prepareStatement(KisF3);
                        PreparedStatement statementMatF3 = connection.prepareStatement(MatF3);
                        PreparedStatement statementBioF3 = connection.prepareStatement(BioF3);
                        PreparedStatement statementChemF3 = connection.prepareStatement(ChemF3);
                        PreparedStatement statementPhyF3 = connection.prepareStatement(PhyF3);
                        PreparedStatement statementGeoF3 = connection.prepareStatement(GeoF3);
                        PreparedStatement statementHisF3 = connection.prepareStatement(HisF3);
                        PreparedStatement statementCreF3 = connection.prepareStatement(CreF3);
                        PreparedStatement statementBusF3 = connection.prepareStatement(BusF3);
                        PreparedStatement statementAgriF3 = connection.prepareStatement(AgriF3);

                        PreparedStatement statementEngF4 = connection.prepareStatement(EngF4);
                        PreparedStatement statementKisF4 = connection.prepareStatement(KisF4);
                        PreparedStatement statementMatF4 = connection.prepareStatement(MatF4);
                        PreparedStatement statementBioF4 = connection.prepareStatement(BioF4);
                        PreparedStatement statementChemF4 = connection.prepareStatement(ChemF4);
                        PreparedStatement statementPhyF4 = connection.prepareStatement(PhyF4);
                        PreparedStatement statementGeoF4 = connection.prepareStatement(GeoF4);
                        PreparedStatement statementHisF4 = connection.prepareStatement(HisF4);
                        PreparedStatement statementCreF4 = connection.prepareStatement(CreF4);
                        PreparedStatement statementBusF4 = connection.prepareStatement(BusF4);
                        PreparedStatement statementAgriF4 = connection.prepareStatement(AgriF4);
                        tableStudentsData toRemove = (tableStudentsData) tableStudents.getItems().get(getTableRow().getIndex());
                        statementStudents.setString(1,toRemove.getAdm());
                        statementSubject.setString(1,toRemove.getAdm());
                        statementF1T1AVG.setString(1,toRemove.getAdm());
                        statementF1T2AVG.setString(1,toRemove.getAdm());
                        statementF1T3AVG.setString(1,toRemove.getAdm());
                        statementF2T1AVG.setString(1,toRemove.getAdm());
                        statementF2T2AVG.setString(1,toRemove.getAdm());
                        statementF2T3AVG.setString(1,toRemove.getAdm());
                        statementF3T1AVG.setString(1,toRemove.getAdm());
                        statementF3T2AVG.setString(1,toRemove.getAdm());
                        statementF3T3AVG.setString(1,toRemove.getAdm());
                        statementF4T1AVG.setString(1,toRemove.getAdm());
                        statementF4T2AVG.setString(1,toRemove.getAdm());
                        statementF4T3AVG.setString(1,toRemove.getAdm());

                        statementF1T1Ex1.setString(1,toRemove.getAdm());
                        statementF1T1Ex2.setString(1,toRemove.getAdm());
                        statementF1T1Ex3.setString(1,toRemove.getAdm());
                        statementF1T2Ex1.setString(1,toRemove.getAdm());
                        statementF1T2Ex2.setString(1,toRemove.getAdm());
                        statementF1T2Ex3.setString(1,toRemove.getAdm());
                        statementF1T3Ex1.setString(1,toRemove.getAdm());
                        statementF1T3Ex2.setString(1,toRemove.getAdm());
                        statementF1T3Ex3.setString(1,toRemove.getAdm());///syart
                        statementF2T1Ex1.setString(1,toRemove.getAdm());
                        statementF2T1Ex2.setString(1,toRemove.getAdm());
                        statementF2T1Ex3.setString(1,toRemove.getAdm());
                        statementF2T2Ex1.setString(1,toRemove.getAdm());
                        statementF2T2Ex2.setString(1,toRemove.getAdm());
                        statementF2T2Ex3.setString(1,toRemove.getAdm());
                        statementF2T3Ex1.setString(1,toRemove.getAdm());
                        statementF2T3Ex2.setString(1,toRemove.getAdm());
                        statementF2T3Ex3.setString(1,toRemove.getAdm());//start
                        statementF3T1Ex1.setString(1,toRemove.getAdm());
                        statementF3T1Ex2.setString(1,toRemove.getAdm());
                        statementF3T1Ex3.setString(1,toRemove.getAdm());
                        statementF3T2Ex1.setString(1,toRemove.getAdm());
                        statementF3T2Ex2.setString(1,toRemove.getAdm());
                        statementF3T2Ex3.setString(1,toRemove.getAdm());
                        statementF3T3Ex1.setString(1,toRemove.getAdm());
                        statementF3T3Ex2.setString(1,toRemove.getAdm());
                        statementF3T3Ex3.setString(1,toRemove.getAdm());//start
                        statementF4T1Ex1.setString(1,toRemove.getAdm());
                        statementF4T1Ex2.setString(1,toRemove.getAdm());
                        statementF4T1Ex3.setString(1,toRemove.getAdm());
                        statementF4T2Ex1.setString(1,toRemove.getAdm());
                        statementF4T2Ex2.setString(1,toRemove.getAdm());
                        statementF4T2Ex3.setString(1,toRemove.getAdm());
                        statementF4T3Ex1.setString(1,toRemove.getAdm());
                        statementF4T3Ex2.setString(1,toRemove.getAdm());
                        statementF4T3Ex3.setString(1,toRemove.getAdm());

                        statementEngF1.setString(1,toRemove.getAdm());
                        statementKisF1.setString(1,toRemove.getAdm());
                        statementMatF1.setString(1,toRemove.getAdm());
                        statementBioF1.setString(1,toRemove.getAdm());
                        statementChemF1.setString(1,toRemove.getAdm());
                        statementPhyF1.setString(1,toRemove.getAdm());
                        statementGeoF1.setString(1,toRemove.getAdm());
                        statementHisF1.setString(1,toRemove.getAdm());
                        statementCreF1.setString(1,toRemove.getAdm());
                        statementBusF1.setString(1,toRemove.getAdm());
                        statementAgriF1.setString(1,toRemove.getAdm());

                        statementEngF2.setString(1,toRemove.getAdm());
                        statementKisF2.setString(1,toRemove.getAdm());
                        statementMatF2.setString(1,toRemove.getAdm());
                        statementBioF2.setString(1,toRemove.getAdm());
                        statementChemF2.setString(1,toRemove.getAdm());
                        statementPhyF2.setString(1,toRemove.getAdm());
                        statementGeoF2.setString(1,toRemove.getAdm());
                        statementHisF2.setString(1,toRemove.getAdm());
                        statementCreF2.setString(1,toRemove.getAdm());
                        statementBusF2.setString(1,toRemove.getAdm());
                        statementAgriF2.setString(1,toRemove.getAdm());

                        statementEngF3.setString(1,toRemove.getAdm());
                        statementKisF3.setString(1,toRemove.getAdm());
                        statementMatF3.setString(1,toRemove.getAdm());
                        statementBioF3.setString(1,toRemove.getAdm());
                        statementChemF3.setString(1,toRemove.getAdm());
                        statementPhyF3.setString(1,toRemove.getAdm());
                        statementGeoF3.setString(1,toRemove.getAdm());
                        statementHisF3.setString(1,toRemove.getAdm());
                        statementCreF3.setString(1,toRemove.getAdm());
                        statementBusF3.setString(1,toRemove.getAdm());
                        statementAgriF3.setString(1,toRemove.getAdm());

                        statementEngF4.setString(1,toRemove.getAdm());
                        statementKisF4.setString(1,toRemove.getAdm());
                        statementMatF4.setString(1,toRemove.getAdm());
                        statementBioF4.setString(1,toRemove.getAdm());
                        statementChemF4.setString(1,toRemove.getAdm());
                        statementPhyF4.setString(1,toRemove.getAdm());
                        statementGeoF4.setString(1,toRemove.getAdm());
                        statementHisF4.setString(1,toRemove.getAdm());
                        statementCreF4.setString(1,toRemove.getAdm());
                        statementBusF4.setString(1,toRemove.getAdm());
                        statementAgriF4.setString(1,toRemove.getAdm());


                       /*
                       *
                       *
                        execution part
                       *
                       *
                       */
                        statementStudents.execute();
                        statementSubject.execute();

                        statementF1T1AVG.execute();
                        statementF1T2AVG.execute();
                        statementF1T3AVG.execute();
                        statementF2T1AVG.execute();
                        statementF2T2AVG.execute();
                        statementF2T3AVG.execute();
                        statementF3T1AVG.execute();
                        statementF3T2AVG.execute();
                        statementF3T3AVG.execute();
                        statementF4T1AVG.execute();
                        statementF4T2AVG.execute();
                        statementF4T3AVG.execute();

                        statementF1T1Ex1.execute();
                        statementF1T1Ex2.execute();
                        statementF1T1Ex3.execute();
                        statementF1T2Ex1.execute();
                        statementF1T2Ex2.execute();
                        statementF1T2Ex3.execute();
                        statementF1T3Ex1.execute();
                        statementF1T3Ex2.execute();
                        statementF1T3Ex3.execute();///syart
                        statementF2T1Ex1.execute();
                        statementF2T1Ex2.execute();
                        statementF2T1Ex3.execute();
                        statementF2T2Ex1.execute();
                        statementF2T2Ex2.execute();
                        statementF2T2Ex3.execute();
                        statementF2T3Ex1.execute();
                        statementF2T3Ex2.execute();
                        statementF2T3Ex3.execute();//start
                        statementF3T1Ex1.execute();
                        statementF3T1Ex2.execute();
                        statementF3T1Ex3.execute();
                        statementF3T2Ex1.execute();
                        statementF3T2Ex2.execute();
                        statementF3T2Ex3.execute();
                        statementF3T3Ex1.execute();
                        statementF3T3Ex2.execute();
                        statementF3T3Ex3.execute();//start
                        statementF4T1Ex1.execute();
                        statementF4T1Ex2.execute();
                        statementF4T1Ex3.execute();
                        statementF4T2Ex1.execute();
                        statementF4T2Ex2.execute();
                        statementF4T2Ex3.execute();
                        statementF4T3Ex1.execute();
                        statementF4T3Ex2.execute();
                        statementF4T3Ex3.execute();

                        statementEngF1.execute();
                        statementKisF1.execute();
                        statementMatF1.execute();
                        statementBioF1.execute();
                        statementChemF1.execute();
                        statementPhyF1.execute();
                        statementGeoF1.execute();
                        statementHisF1.execute();
                        statementCreF1.execute();
                        statementBusF1.execute();
                        statementAgriF1.execute();

                        statementEngF2.execute();
                        statementKisF2.execute();
                        statementMatF2.execute();
                        statementBioF2.execute();
                        statementChemF2.execute();
                        statementPhyF2.execute();
                        statementGeoF2.execute();
                        statementHisF2.execute();
                        statementCreF2.execute();
                        statementBusF2.execute();
                        statementAgriF2.execute();

                        statementEngF3.execute();
                        statementKisF3.execute();
                        statementMatF3.execute();
                        statementBioF3.execute();
                        statementChemF3.execute();
                        statementPhyF3.execute();
                        statementGeoF3.execute();
                        statementHisF3.execute();
                        statementCreF3.execute();
                        statementBusF3.execute();
                        statementAgriF3.execute();

                        statementEngF4.execute();
                        statementKisF4.execute();
                        statementMatF4.execute();
                        statementBioF4.execute();
                        statementChemF4.execute();
                        statementPhyF4.execute();
                        statementGeoF4.execute();
                        statementHisF4.execute();
                        statementCreF4.execute();
                        statementBusF4.execute();
                        statementAgriF4.execute();
                        connection.close();
                        infoBox("Student deleted successfully","Success",null);
                        loadData();
                    }catch (Exception e){
                        infoBoxError("An error occurred " + e,"Error",null);
                    }
                }
            });
        }
        //Display button if the row is not empty
        @Override
        protected void updateItem(Boolean t, boolean empty) {
            super.updateItem(t, empty);
            if(!empty){
                setGraphic(cellButton);
            }
        }
    }

    public void classFilter(){
         String sql="SELECT * FROM tbl_students WHERE class=?";
         try{
             Connection connection = Database.DBConnection.getConnection();
             this.tableList= FXCollections.observableArrayList();
             PreparedStatement statement = connection.prepareStatement(sql);
             statement.setString(1,this.classFilter.getText().toUpperCase());
             ResultSet resultSet = statement.executeQuery();

             while (resultSet.next()){
                 this.tableList.addAll(new tableStudentsData(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6),resultSet.getString(7),resultSet.getString(8)));
             }

             this.idColumn.setCellValueFactory(new PropertyValueFactory<tableStudentsData,String>("id"));
             this.admColumn.setCellValueFactory(new PropertyValueFactory<tableStudentsData,String>("adm"));
             this.fnameColumn.setCellValueFactory(new PropertyValueFactory<tableStudentsData,String>("fname"));
             this.mnameColumn.setCellValueFactory(new PropertyValueFactory<tableStudentsData,String>("mname"));
             this.lnameColumn.setCellValueFactory(new PropertyValueFactory<tableStudentsData,String>("lname"));
             this.kcpeColumn.setCellValueFactory(new PropertyValueFactory<tableStudentsData,String>("kcpe"));
             this.classColumn.setCellValueFactory(new PropertyValueFactory<tableStudentsData,String>("classes"));
             this.dobColumn.setCellValueFactory(new PropertyValueFactory<tableStudentsData,String>("dob"));
             this.deleteColumn.setCellFactory((Callback<TableColumn<tableStudentsData, Boolean>, TableCell<tableStudentsData, Boolean>>) p ->  new ButtonCell());

             this.tableStudents.setItems(null);
             this.tableStudents.setItems(this.tableList);
         }catch (Exception e){
             infoBoxError("An error occurred","Error",null);
         }
    }

    public void searchAdm(){
        String sql = "SELECT * FROM tbl_students WHERE adm=? ";
        try {
            Connection connection = Database.DBConnection.getConnection();
            this.tableList= FXCollections.observableArrayList();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,this.admSearch.getText().toUpperCase());
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                this.tableList.addAll(new tableStudentsData(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6),resultSet.getString(7),resultSet.getString(8)));
            }
            this.idColumn.setCellValueFactory(new PropertyValueFactory<tableStudentsData,String>("id"));
            this.admColumn.setCellValueFactory(new PropertyValueFactory<tableStudentsData,String>("adm"));
            this.fnameColumn.setCellValueFactory(new PropertyValueFactory<tableStudentsData,String>("fname"));
            this.mnameColumn.setCellValueFactory(new PropertyValueFactory<tableStudentsData,String>("mname"));
            this.lnameColumn.setCellValueFactory(new PropertyValueFactory<tableStudentsData,String>("lname"));
            this.kcpeColumn.setCellValueFactory(new PropertyValueFactory<tableStudentsData,String>("kcpe"));
            this.classColumn.setCellValueFactory(new PropertyValueFactory<tableStudentsData,String>("classes"));
            this.dobColumn.setCellValueFactory(new PropertyValueFactory<tableStudentsData,String>("dob"));
            this.deleteColumn.setCellFactory((Callback<TableColumn<tableStudentsData, Boolean>, TableCell<tableStudentsData, Boolean>>) p ->  new ButtonCell());

            this.tableStudents.setItems(null);
            this.tableStudents.setItems(this.tableList);
        }catch (Exception e){
            infoBoxError("An error occurred","Error",null);
        }
    }

    public void setEdit(){
        tableStudentsData tableStudentsUpdate = tableStudents.getSelectionModel().getSelectedItem();
        adm.setText(tableStudentsUpdate.getAdm());
        fname.setText(tableStudentsUpdate.getFname());
        mname.setText(tableStudentsUpdate.getMname());
        lname.setText(tableStudentsUpdate.getLname());
        kcpe.setText(tableStudentsUpdate.getKcpe());
        classes.setValue(classOption.fromvalue(tableStudentsUpdate.getClasses()));
        dob.getEditor().setText(tableStudentsUpdate.getDob());
    }

    public void updateStudent(){
        tableStudentsData tableStudentsUpdate = tableStudents.getSelectionModel().getSelectedItem();
        String idCode = tableStudentsUpdate.getId();
        String students = "UPDATE tbl_students SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=?,dob=? WHERE id=?";
        String subject = "UPDATE tbl_subject_selection SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE id=?";
        String F1T1Avg = "UPDATE tbl_f1_t1_avg SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE id=?";
        String F1T2Avg = "UPDATE tbl_f1_t2_avg SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE id=?";
        String F1T3Avg = "UPDATE tbl_f1_t3_avg SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE id=?";
        String F2T1Avg = "UPDATE tbl_f2_t1_avg SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE id=?";
        String F2T2Avg = "UPDATE tbl_f2_t2_avg SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE id=?";
        String F2T3Avg = "UPDATE tbl_f2_t3_avg SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE id=?";
        String F3T1Avg = "UPDATE tbl_f3_t1_avg SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE id=?";
        String F3T2Avg = "UPDATE tbl_f3_t2_avg SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE id=?";
        String F3T3Avg = "UPDATE tbl_f3_t3_avg SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE id=?";
        String F4T1Avg = "UPDATE tbl_f4_t1_avg SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE id=?";
        String F4T2Avg = "UPDATE tbl_f4_t2_avg SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE id=?";
        String F4T3Avg = "UPDATE tbl_f4_t3_avg SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE id=?";


        String F1T1Ex1 = "UPDATE tbl_f1_t1_ex1 SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE id=?";
        String F1T1Ex2 = "UPDATE tbl_f1_t1_ex2 SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE id=?";
        String F1T1Ex3 = "UPDATE tbl_f1_t1_ex3 SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE id=?";
        String F1T2Ex1 = "UPDATE tbl_f1_t2_ex1 SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE id=?";
        String F1T2Ex2 = "UPDATE tbl_f1_t2_ex2 SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE id=?";
        String F1T2Ex3 = "UPDATE tbl_f1_t2_ex3 SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE id=?";
        String F1T3Ex1 = "UPDATE tbl_f1_t3_ex1 SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE id=?";
        String F1T3Ex2 = "UPDATE tbl_f1_t3_ex2 SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE id=?";
        String F1T3Ex3 = "UPDATE tbl_f1_t3_ex3 SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE id=?";

        String F2T1Ex1 = "UPDATE tbl_f2_t1_ex1 SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE id=?";
        String F2T1Ex2 = "UPDATE tbl_f2_t1_ex2 SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE id=?";
        String F2T1Ex3 = "UPDATE tbl_f2_t1_ex3 SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE id=?";
        String F2T2Ex1 = "UPDATE tbl_f2_t2_ex1 SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE id=?";
        String F2T2Ex2 = "UPDATE tbl_f2_t2_ex2 SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE id=?";
        String F2T2Ex3 = "UPDATE tbl_f2_t2_ex3 SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE id=?";
        String F2T3Ex1 = "UPDATE tbl_f2_t3_ex1 SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE id=?";
        String F2T3Ex2 = "UPDATE tbl_f2_t3_ex2 SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE id=?";
        String F2T3Ex3 = "UPDATE tbl_f2_t3_ex3 SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE id=?";

        String F3T1Ex1 = "UPDATE tbl_f3_t1_ex1 SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE id=?";
        String F3T1Ex2 = "UPDATE tbl_f3_t1_ex2 SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE id=?";
        String F3T1Ex3 = "UPDATE tbl_f3_t1_ex3 SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE id=?";
        String F3T2Ex1 = "UPDATE tbl_f3_t2_ex1 SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE id=?";
        String F3T2Ex2 = "UPDATE tbl_f3_t2_ex2 SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE id=?";
        String F3T2Ex3 = "UPDATE tbl_f3_t2_ex3 SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE id=?";
        String F3T3Ex1 = "UPDATE tbl_f3_t3_ex1 SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE id=?";
        String F3T3Ex2 = "UPDATE tbl_f3_t3_ex2 SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE id=?";
        String F3T3Ex3 = "UPDATE tbl_f3_t3_ex3 SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE id=?";

        String F4T1Ex1 = "UPDATE tbl_f4_t1_ex1 SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE id=?";
        String F4T1Ex2 = "UPDATE tbl_f4_t1_ex2 SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE id=?";
        String F4T1Ex3 = "UPDATE tbl_f4_t1_ex3 SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE id=?";
        String F4T2Ex1 = "UPDATE tbl_f4_t2_ex1 SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE id=?";
        String F4T2Ex2 = "UPDATE tbl_f4_t2_ex2 SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE id=?";
        String F4T2Ex3 = "UPDATE tbl_f4_t2_ex3 SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE id=?";
        String F4T3Ex1 = "UPDATE tbl_f4_t3_ex1 SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE id=?";
        String F4T3Ex2 = "UPDATE tbl_f4_t3_ex2 SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE id=?";
        String F4T3Ex3 = "UPDATE tbl_f4_t3_ex3 SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE id=?";



        String EngF1 = "UPDATE tbl_f1_eng SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE id=?";
        String KisF1 = "UPDATE tbl_f1_kis SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE id=?";
        String MatF1 = "UPDATE tbl_f1_mat SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE id=?";
        String BioF1 = "UPDATE tbl_f1_bio SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE id=?";
        String PhyF1 = "UPDATE tbl_f1_phy SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE id=?";
        String ChemF1 = "UPDATE tbl_f1_chem SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE id=?";
        String GeoF1 = "UPDATE tbl_f1_geo SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE id=?";
        String HisF1 = "UPDATE tbl_f1_his SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE id=?";
        String CreF1 = "UPDATE tbl_f1_cre SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE id=?";
        String AgriF1 = "UPDATE tbl_f1_agri SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE id=?";
        String BusF1 = "UPDATE tbl_f1_bus SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE id=?";
        String EngF2 = "UPDATE tbl_f2_eng SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE id=?";
        String KisF2 = "UPDATE tbl_f2_kis SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE id=?";
        String MatF2 = "UPDATE tbl_f2_mat SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE id=?";
        String BioF2 = "UPDATE tbl_f2_bio SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE id=?";
        String PhyF2 = "UPDATE tbl_f2_phy SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE id=?";
        String ChemF2 = "UPDATE tbl_f2_chem SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE id=?";
        String GeoF2 = "UPDATE tbl_f2_geo SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE id=?";
        String HisF2 = "UPDATE tbl_f2_his SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE id=?";
        String CreF2 = "UPDATE tbl_f2_cre SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE id=?";
        String AgriF2 = "UPDATE tbl_f2_agri SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE id=?";
        String BusF2 = "UPDATE tbl_f2_bus SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE id=?";
        String EngF3 = "UPDATE tbl_f3_eng SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE id=?";
        String KisF3 = "UPDATE tbl_f3_kis SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE id=?";
        String MatF3 = "UPDATE tbl_f3_mat SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE id=?";
        String BioF3 = "UPDATE tbl_f3_bio SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE id=?";
        String PhyF3 = "UPDATE tbl_f3_phy SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE id=?";
        String ChemF3 = "UPDATE tbl_f3_chem SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE id=?";
        String GeoF3 = "UPDATE tbl_f3_geo SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE id=?";
        String HisF3 = "UPDATE tbl_f3_his SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE id=?";
        String CreF3 = "UPDATE tbl_f3_cre SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE id=?";
        String AgriF3 = "UPDATE tbl_f3_agri SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE id=?";
        String BusF3 = "UPDATE tbl_f3_bus SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE id=?";
        String EngF4 = "UPDATE tbl_f4_eng SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE id=?";
        String KisF4 = "UPDATE tbl_f4_kis SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE id=?";
        String MatF4 = "UPDATE tbl_f4_mat SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE id=?";
        String BioF4 = "UPDATE tbl_f4_bio SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE id=?";
        String PhyF4 = "UPDATE tbl_f4_phy SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE id=?";
        String ChemF4 = "UPDATE tbl_f4_chem SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE id=?";
        String GeoF4 = "UPDATE tbl_f4_geo SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE id=?";
        String HisF4 = "UPDATE tbl_f4_his SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE id=?";
        String CreF4 = "UPDATE tbl_f4_cre SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE id=?";
        String AgriF4 = "UPDATE tbl_f4_agri SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE id=?";
        String BusF4 = "UPDATE tbl_f4_bus SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE id=?";
        try{
            Connection connection = Database.DBConnection.getConnection();
            PreparedStatement statementStudent = connection.prepareStatement(students);
            statementStudent.setString(1, this.adm.getText().toUpperCase());
            statementStudent.setString(2, this.fname.getText().toUpperCase());
            statementStudent.setString(3, this.mname.getText().toUpperCase());
            statementStudent.setString(4, this.lname.getText().toUpperCase());
            statementStudent.setString(5, this.kcpe.getText().toUpperCase());
            statementStudent.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());
            statementStudent.setString(7, this.dob.getEditor().getText().toUpperCase());
            statementStudent.setString(8,idCode.toUpperCase());

            PreparedStatement statementSubjects = connection.prepareStatement(subject);
            statementSubjects.setString(1, this.adm.getText().toUpperCase());
            statementSubjects.setString(2, this.fname.getText().toUpperCase());
            statementSubjects.setString(3, this.mname.getText().toUpperCase());
            statementSubjects.setString(4, this.lname.getText().toUpperCase());
            statementSubjects.setString(5, this.kcpe.getText().toUpperCase());
            statementSubjects.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());
            statementSubjects.setString(7,idCode.toUpperCase());

            PreparedStatement statementF1T1Avg = connection.prepareStatement(F1T1Avg);
            statementF1T1Avg.setString(1, this.adm.getText().toUpperCase());
            statementF1T1Avg.setString(2, this.fname.getText().toUpperCase());
            statementF1T1Avg.setString(3, this.mname.getText().toUpperCase());
            statementF1T1Avg.setString(4, this.lname.getText().toUpperCase());
            statementF1T1Avg.setString(5, this.kcpe.getText().toUpperCase());
            statementF1T1Avg.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());
            statementF1T1Avg.setString(7,idCode.toUpperCase());

            PreparedStatement statementF1T2Avg = connection.prepareStatement(F1T2Avg);
            statementF1T2Avg.setString(1, this.adm.getText().toUpperCase());
            statementF1T2Avg.setString(2, this.fname.getText().toUpperCase());
            statementF1T2Avg.setString(3, this.mname.getText().toUpperCase());
            statementF1T2Avg.setString(4, this.lname.getText().toUpperCase());
            statementF1T2Avg.setString(5, this.kcpe.getText().toUpperCase());
            statementF1T2Avg.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());
            statementF1T2Avg.setString(7,idCode.toUpperCase());

            PreparedStatement statementF1T3Avg = connection.prepareStatement(F1T3Avg);
            statementF1T3Avg.setString(1, this.adm.getText().toUpperCase());
            statementF1T3Avg.setString(2, this.fname.getText().toUpperCase());
            statementF1T3Avg.setString(3, this.mname.getText().toUpperCase());
            statementF1T3Avg.setString(4, this.lname.getText().toUpperCase());
            statementF1T3Avg.setString(5, this.kcpe.getText().toUpperCase());
            statementF1T3Avg.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());
            statementF1T3Avg.setString(7,idCode.toUpperCase());

            PreparedStatement statementF2T1Avg = connection.prepareStatement(F2T1Avg);
            statementF2T1Avg.setString(1, this.adm.getText().toUpperCase());
            statementF2T1Avg.setString(2, this.fname.getText().toUpperCase());
            statementF2T1Avg.setString(3, this.mname.getText().toUpperCase());
            statementF2T1Avg.setString(4, this.lname.getText().toUpperCase());
            statementF2T1Avg.setString(5, this.kcpe.getText().toUpperCase());
            statementF2T1Avg.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());
            statementF2T1Avg.setString(7,idCode.toUpperCase());

            PreparedStatement statementF2T2Avg = connection.prepareStatement(F2T2Avg);
            statementF2T2Avg.setString(1, this.adm.getText().toUpperCase());
            statementF2T2Avg.setString(2, this.fname.getText().toUpperCase());
            statementF2T2Avg.setString(3, this.mname.getText().toUpperCase());
            statementF2T2Avg.setString(4, this.lname.getText().toUpperCase());
            statementF2T2Avg.setString(5, this.kcpe.getText().toUpperCase());
            statementF2T2Avg.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());
            statementF2T2Avg.setString(7,idCode.toUpperCase());

            PreparedStatement statementF2T3Avg = connection.prepareStatement(F2T3Avg);
            statementF2T3Avg.setString(1, this.adm.getText().toUpperCase());
            statementF2T3Avg.setString(2, this.fname.getText().toUpperCase());
            statementF2T3Avg.setString(3, this.mname.getText().toUpperCase());
            statementF2T3Avg.setString(4, this.lname.getText().toUpperCase());
            statementF2T3Avg.setString(5, this.kcpe.getText().toUpperCase());
            statementF2T3Avg.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());
            statementF2T3Avg.setString(7,idCode.toUpperCase());

            PreparedStatement statementF3T1Avg = connection.prepareStatement(F3T1Avg);
            statementF3T1Avg.setString(1, this.adm.getText().toUpperCase());
            statementF3T1Avg.setString(2, this.fname.getText().toUpperCase());
            statementF3T1Avg.setString(3, this.mname.getText().toUpperCase());
            statementF3T1Avg.setString(4, this.lname.getText().toUpperCase());
            statementF3T1Avg.setString(5, this.kcpe.getText().toUpperCase());
            statementF3T1Avg.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());
            statementF3T1Avg.setString(7,idCode.toUpperCase());

            PreparedStatement statementF3T2Avg = connection.prepareStatement(F3T2Avg);
            statementF3T2Avg.setString(1, this.adm.getText().toUpperCase());
            statementF3T2Avg.setString(2, this.fname.getText().toUpperCase());
            statementF3T2Avg.setString(3, this.mname.getText().toUpperCase());
            statementF3T2Avg.setString(4, this.lname.getText().toUpperCase());
            statementF3T2Avg.setString(5, this.kcpe.getText().toUpperCase());
            statementF3T2Avg.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());
            statementF3T2Avg.setString(7,idCode.toUpperCase());

            PreparedStatement statementF3T3Avg = connection.prepareStatement(F3T3Avg);
            statementF3T3Avg.setString(1, this.adm.getText().toUpperCase());
            statementF3T3Avg.setString(2, this.fname.getText().toUpperCase());
            statementF3T3Avg.setString(3, this.mname.getText().toUpperCase());
            statementF3T3Avg.setString(4, this.lname.getText().toUpperCase());
            statementF3T3Avg.setString(5, this.kcpe.getText().toUpperCase());
            statementF3T3Avg.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());
            statementF3T3Avg.setString(7,idCode.toUpperCase());

            PreparedStatement statementF4T1Avg = connection.prepareStatement(F4T1Avg);
            statementF4T1Avg.setString(1, this.adm.getText().toUpperCase());
            statementF4T1Avg.setString(2, this.fname.getText().toUpperCase());
            statementF4T1Avg.setString(3, this.mname.getText().toUpperCase());
            statementF4T1Avg.setString(4, this.lname.getText().toUpperCase());
            statementF4T1Avg.setString(5, this.kcpe.getText().toUpperCase());
            statementF4T1Avg.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());
            statementF4T1Avg.setString(7,idCode.toUpperCase());

            PreparedStatement statementF4T2Avg = connection.prepareStatement(F4T2Avg);
            statementF4T2Avg.setString(1, this.adm.getText().toUpperCase());
            statementF4T2Avg.setString(2, this.fname.getText().toUpperCase());
            statementF4T2Avg.setString(3, this.mname.getText().toUpperCase());
            statementF4T2Avg.setString(4, this.lname.getText().toUpperCase());
            statementF4T2Avg.setString(5, this.kcpe.getText().toUpperCase());
            statementF4T2Avg.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());
            statementF4T2Avg.setString(7,idCode.toUpperCase());

            PreparedStatement statementF4T3Avg = connection.prepareStatement(F4T3Avg);
            statementF4T3Avg.setString(1, this.adm.getText().toUpperCase());
            statementF4T3Avg.setString(2, this.fname.getText().toUpperCase());
            statementF4T3Avg.setString(3, this.mname.getText().toUpperCase());
            statementF4T3Avg.setString(4, this.lname.getText().toUpperCase());
            statementF4T3Avg.setString(5, this.kcpe.getText().toUpperCase());
            statementF4T3Avg.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());
            statementF4T3Avg.setString(7,idCode.toUpperCase());


            PreparedStatement statementF1T1Ex1 = connection.prepareStatement(F1T1Ex1);
            statementF1T1Ex1.setString(1, this.adm.getText().toUpperCase());
            statementF1T1Ex1.setString(2, this.fname.getText().toUpperCase());
            statementF1T1Ex1.setString(3, this.mname.getText().toUpperCase());
            statementF1T1Ex1.setString(4, this.lname.getText().toUpperCase());
            statementF1T1Ex1.setString(5, this.kcpe.getText().toUpperCase());
            statementF1T1Ex1.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());
            statementF1T1Ex1.setString(7,idCode.toUpperCase());

            PreparedStatement statementF1T1Ex2 = connection.prepareStatement(F1T1Ex2);
            statementF1T1Ex2.setString(1, this.adm.getText().toUpperCase());
            statementF1T1Ex2.setString(2, this.fname.getText().toUpperCase());
            statementF1T1Ex2.setString(3, this.mname.getText().toUpperCase());
            statementF1T1Ex2.setString(4, this.lname.getText().toUpperCase());
            statementF1T1Ex2.setString(5, this.kcpe.getText().toUpperCase());
            statementF1T1Ex2.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());
            statementF1T1Ex2.setString(7,idCode.toUpperCase());

            PreparedStatement statementF1T1Ex3 = connection.prepareStatement(F1T1Ex3);
            statementF1T1Ex3.setString(1, this.adm.getText().toUpperCase());
            statementF1T1Ex3.setString(2, this.fname.getText().toUpperCase());
            statementF1T1Ex3.setString(3, this.mname.getText().toUpperCase());
            statementF1T1Ex3.setString(4, this.lname.getText().toUpperCase());
            statementF1T1Ex3.setString(5, this.kcpe.getText().toUpperCase());
            statementF1T1Ex3.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());
            statementF1T1Ex3.setString(7,idCode.toUpperCase());

            PreparedStatement statementF1T2Ex1 = connection.prepareStatement(F1T2Ex1);
            statementF1T2Ex1.setString(1, this.adm.getText().toUpperCase());
            statementF1T2Ex1.setString(2, this.fname.getText().toUpperCase());
            statementF1T2Ex1.setString(3, this.mname.getText().toUpperCase());
            statementF1T2Ex1.setString(4, this.lname.getText().toUpperCase());
            statementF1T2Ex1.setString(5, this.kcpe.getText().toUpperCase());
            statementF1T2Ex1.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());
            statementF1T2Ex1.setString(7,idCode.toUpperCase());

            PreparedStatement statementF1T2Ex2 = connection.prepareStatement(F1T2Ex2);
            statementF1T2Ex2.setString(1, this.adm.getText().toUpperCase());
            statementF1T2Ex2.setString(2, this.fname.getText().toUpperCase());
            statementF1T2Ex2.setString(3, this.mname.getText().toUpperCase());
            statementF1T2Ex2.setString(4, this.lname.getText().toUpperCase());
            statementF1T2Ex2.setString(5, this.kcpe.getText().toUpperCase());
            statementF1T2Ex2.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());
            statementF1T2Ex2.setString(7,idCode.toUpperCase());

            PreparedStatement statementF1T2Ex3 = connection.prepareStatement(F1T2Ex3);
            statementF1T2Ex3.setString(1, this.adm.getText().toUpperCase());
            statementF1T2Ex3.setString(2, this.fname.getText().toUpperCase());
            statementF1T2Ex3.setString(3, this.mname.getText().toUpperCase());
            statementF1T2Ex3.setString(4, this.lname.getText().toUpperCase());
            statementF1T2Ex3.setString(5, this.kcpe.getText().toUpperCase());
            statementF1T2Ex3.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());
            statementF1T2Ex3.setString(7,idCode.toUpperCase());

            PreparedStatement statementF1T3Ex1 = connection.prepareStatement(F1T3Ex1);
            statementF1T3Ex1.setString(1, this.adm.getText().toUpperCase());
            statementF1T3Ex1.setString(2, this.fname.getText().toUpperCase());
            statementF1T3Ex1.setString(3, this.mname.getText().toUpperCase());
            statementF1T3Ex1.setString(4, this.lname.getText().toUpperCase());
            statementF1T3Ex1.setString(5, this.kcpe.getText().toUpperCase());
            statementF1T3Ex1.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());
            statementF1T3Ex1.setString(7,idCode.toUpperCase());

            PreparedStatement statementF1T3Ex2 = connection.prepareStatement(F1T3Ex2);
            statementF1T3Ex2.setString(1, this.adm.getText().toUpperCase());
            statementF1T3Ex2.setString(2, this.fname.getText().toUpperCase());
            statementF1T3Ex2.setString(3, this.mname.getText().toUpperCase());
            statementF1T3Ex2.setString(4, this.lname.getText().toUpperCase());
            statementF1T3Ex2.setString(5, this.kcpe.getText().toUpperCase());
            statementF1T3Ex2.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());
            statementF1T3Ex2.setString(7,idCode.toUpperCase());

            PreparedStatement statementF1T3Ex3 = connection.prepareStatement(F1T3Ex3);
            statementF1T3Ex3.setString(1, this.adm.getText().toUpperCase());
            statementF1T3Ex3.setString(2, this.fname.getText().toUpperCase());
            statementF1T3Ex3.setString(3, this.mname.getText().toUpperCase());
            statementF1T3Ex3.setString(4, this.lname.getText().toUpperCase());
            statementF1T3Ex3.setString(5, this.kcpe.getText().toUpperCase());
            statementF1T3Ex3.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());
            statementF1T3Ex3.setString(7,idCode.toUpperCase());

            PreparedStatement statementF2T1Ex1 = connection.prepareStatement(F2T1Ex1);
            statementF2T1Ex1.setString(1, this.adm.getText().toUpperCase());
            statementF2T1Ex1.setString(2, this.fname.getText().toUpperCase());
            statementF2T1Ex1.setString(3, this.mname.getText().toUpperCase());
            statementF2T1Ex1.setString(4, this.lname.getText().toUpperCase());
            statementF2T1Ex1.setString(5, this.kcpe.getText().toUpperCase());
            statementF2T1Ex1.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());
            statementF2T1Ex1.setString(7,idCode.toUpperCase());

            PreparedStatement statementF2T1Ex2 = connection.prepareStatement(F2T1Ex2);
            statementF2T1Ex2.setString(1, this.adm.getText().toUpperCase());
            statementF2T1Ex2.setString(2, this.fname.getText().toUpperCase());
            statementF2T1Ex2.setString(3, this.mname.getText().toUpperCase());
            statementF2T1Ex2.setString(4, this.lname.getText().toUpperCase());
            statementF2T1Ex2.setString(5, this.kcpe.getText().toUpperCase());
            statementF2T1Ex2.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());
            statementF2T1Ex2.setString(7,idCode.toUpperCase());

            PreparedStatement statementF2T1Ex3 = connection.prepareStatement(F2T1Ex3);
            statementF2T1Ex3.setString(1, this.adm.getText().toUpperCase());
            statementF2T1Ex3.setString(2, this.fname.getText().toUpperCase());
            statementF2T1Ex3.setString(3, this.mname.getText().toUpperCase());
            statementF2T1Ex3.setString(4, this.lname.getText().toUpperCase());
            statementF2T1Ex3.setString(5, this.kcpe.getText().toUpperCase());
            statementF2T1Ex3.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());
            statementF2T1Ex3.setString(7,idCode.toUpperCase());

            PreparedStatement statementF2T2Ex1 = connection.prepareStatement(F2T2Ex1);
            statementF2T2Ex1.setString(1, this.adm.getText().toUpperCase());
            statementF2T2Ex1.setString(2, this.fname.getText().toUpperCase());
            statementF2T2Ex1.setString(3, this.mname.getText().toUpperCase());
            statementF2T2Ex1.setString(4, this.lname.getText().toUpperCase());
            statementF2T2Ex1.setString(5, this.kcpe.getText().toUpperCase());
            statementF2T2Ex1.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());
            statementF2T2Ex1.setString(7,idCode.toUpperCase());

            PreparedStatement statementF2T2Ex2 = connection.prepareStatement(F2T2Ex2);
            statementF2T2Ex2.setString(1, this.adm.getText().toUpperCase());
            statementF2T2Ex2.setString(2, this.fname.getText().toUpperCase());
            statementF2T2Ex2.setString(3, this.mname.getText().toUpperCase());
            statementF2T2Ex2.setString(4, this.lname.getText().toUpperCase());
            statementF2T2Ex2.setString(5, this.kcpe.getText().toUpperCase());
            statementF2T2Ex2.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());
            statementF2T2Ex2.setString(7,idCode.toUpperCase());

            PreparedStatement statementF2T2Ex3 = connection.prepareStatement(F2T2Ex3);
            statementF2T2Ex3.setString(1, this.adm.getText().toUpperCase());
            statementF2T2Ex3.setString(2, this.fname.getText().toUpperCase());
            statementF2T2Ex3.setString(3, this.mname.getText().toUpperCase());
            statementF2T2Ex3.setString(4, this.lname.getText().toUpperCase());
            statementF2T2Ex3.setString(5, this.kcpe.getText().toUpperCase());
            statementF2T2Ex3.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());
            statementF2T2Ex3.setString(7,idCode.toUpperCase());

            PreparedStatement statementF2T3Ex1 = connection.prepareStatement(F2T3Ex1);
            statementF2T3Ex1.setString(1, this.adm.getText().toUpperCase());
            statementF2T3Ex1.setString(2, this.fname.getText().toUpperCase());
            statementF2T3Ex1.setString(3, this.mname.getText().toUpperCase());
            statementF2T3Ex1.setString(4, this.lname.getText().toUpperCase());
            statementF2T3Ex1.setString(5, this.kcpe.getText().toUpperCase());
            statementF2T3Ex1.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());
            statementF2T3Ex1.setString(7,idCode.toUpperCase());

            PreparedStatement statementF2T3Ex2 = connection.prepareStatement(F2T3Ex2);
            statementF2T3Ex2.setString(1, this.adm.getText().toUpperCase());
            statementF2T3Ex2.setString(2, this.fname.getText().toUpperCase());
            statementF2T3Ex2.setString(3, this.mname.getText().toUpperCase());
            statementF2T3Ex2.setString(4, this.lname.getText().toUpperCase());
            statementF2T3Ex2.setString(5, this.kcpe.getText().toUpperCase());
            statementF2T3Ex2.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());
            statementF2T3Ex2.setString(7,idCode.toUpperCase());

            PreparedStatement statementF2T3Ex3 = connection.prepareStatement(F2T3Ex3);
            statementF2T3Ex3.setString(1, this.adm.getText().toUpperCase());
            statementF2T3Ex3.setString(2, this.fname.getText().toUpperCase());
            statementF2T3Ex3.setString(3, this.mname.getText().toUpperCase());
            statementF2T3Ex3.setString(4, this.lname.getText().toUpperCase());
            statementF2T3Ex3.setString(5, this.kcpe.getText().toUpperCase());
            statementF2T3Ex3.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());
            statementF2T3Ex3.setString(7,idCode.toUpperCase());

            PreparedStatement statementF3T1Ex1 = connection.prepareStatement(F3T1Ex1);
            statementF3T1Ex1.setString(1, this.adm.getText().toUpperCase());
            statementF3T1Ex1.setString(2, this.fname.getText().toUpperCase());
            statementF3T1Ex1.setString(3, this.mname.getText().toUpperCase());
            statementF3T1Ex1.setString(4, this.lname.getText().toUpperCase());
            statementF3T1Ex1.setString(5, this.kcpe.getText().toUpperCase());
            statementF3T1Ex1.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());
            statementF3T1Ex1.setString(7,idCode.toUpperCase());

            PreparedStatement statementF3T1Ex2 = connection.prepareStatement(F3T1Ex2);
            statementF3T1Ex2.setString(1, this.adm.getText().toUpperCase());
            statementF3T1Ex2.setString(2, this.fname.getText().toUpperCase());
            statementF3T1Ex2.setString(3, this.mname.getText().toUpperCase());
            statementF3T1Ex2.setString(4, this.lname.getText().toUpperCase());
            statementF3T1Ex2.setString(5, this.kcpe.getText().toUpperCase());
            statementF3T1Ex2.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());
            statementF3T1Ex2.setString(7,idCode.toUpperCase());

            PreparedStatement statementF3T1Ex3 = connection.prepareStatement(F3T1Ex3);
            statementF3T1Ex3.setString(1, this.adm.getText().toUpperCase());
            statementF3T1Ex3.setString(2, this.fname.getText().toUpperCase());
            statementF3T1Ex3.setString(3, this.mname.getText().toUpperCase());
            statementF3T1Ex3.setString(4, this.lname.getText().toUpperCase());
            statementF3T1Ex3.setString(5, this.kcpe.getText().toUpperCase());
            statementF3T1Ex3.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());
            statementF3T1Ex3.setString(7,idCode.toUpperCase());

            PreparedStatement statementF3T2Ex1 = connection.prepareStatement(F3T2Ex1);
            statementF3T2Ex1.setString(1, this.adm.getText().toUpperCase());
            statementF3T2Ex1.setString(2, this.fname.getText().toUpperCase());
            statementF3T2Ex1.setString(3, this.mname.getText().toUpperCase());
            statementF3T2Ex1.setString(4, this.lname.getText().toUpperCase());
            statementF3T2Ex1.setString(5, this.kcpe.getText().toUpperCase());
            statementF3T2Ex1.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());
            statementF3T2Ex1.setString(7,idCode.toUpperCase());

            PreparedStatement statementF3T2Ex2 = connection.prepareStatement(F3T2Ex2);
            statementF3T2Ex2.setString(1, this.adm.getText().toUpperCase());
            statementF3T2Ex2.setString(2, this.fname.getText().toUpperCase());
            statementF3T2Ex2.setString(3, this.mname.getText().toUpperCase());
            statementF3T2Ex2.setString(4, this.lname.getText().toUpperCase());
            statementF3T2Ex2.setString(5, this.kcpe.getText().toUpperCase());
            statementF3T2Ex2.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());
            statementF3T2Ex2.setString(7,idCode.toUpperCase());

            PreparedStatement statementF3T2Ex3 = connection.prepareStatement(F3T2Ex3);
            statementF3T2Ex3.setString(1, this.adm.getText().toUpperCase());
            statementF3T2Ex3.setString(2, this.fname.getText().toUpperCase());
            statementF3T2Ex3.setString(3, this.mname.getText().toUpperCase());
            statementF3T2Ex3.setString(4, this.lname.getText().toUpperCase());
            statementF3T2Ex3.setString(5, this.kcpe.getText().toUpperCase());
            statementF3T2Ex3.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());
            statementF3T2Ex3.setString(7,idCode.toUpperCase());

            PreparedStatement statementF3T3Ex1 = connection.prepareStatement(F3T3Ex1);
            statementF3T3Ex1.setString(1, this.adm.getText().toUpperCase());
            statementF3T3Ex1.setString(2, this.fname.getText().toUpperCase());
            statementF3T3Ex1.setString(3, this.mname.getText().toUpperCase());
            statementF3T3Ex1.setString(4, this.lname.getText().toUpperCase());
            statementF3T3Ex1.setString(5, this.kcpe.getText().toUpperCase());
            statementF3T3Ex1.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());
            statementF3T3Ex1.setString(7,idCode.toUpperCase());

            PreparedStatement statementF3T3Ex2 = connection.prepareStatement(F3T3Ex2);
            statementF3T3Ex2.setString(1, this.adm.getText().toUpperCase());
            statementF3T3Ex2.setString(2, this.fname.getText().toUpperCase());
            statementF3T3Ex2.setString(3, this.mname.getText().toUpperCase());
            statementF3T3Ex2.setString(4, this.lname.getText().toUpperCase());
            statementF3T3Ex2.setString(5, this.kcpe.getText().toUpperCase());
            statementF3T3Ex2.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());
            statementF3T3Ex2.setString(7,idCode.toUpperCase());

            PreparedStatement statementF3T3Ex3 = connection.prepareStatement(F3T3Ex3);
            statementF3T3Ex3.setString(1, this.adm.getText().toUpperCase());
            statementF3T3Ex3.setString(2, this.fname.getText().toUpperCase());
            statementF3T3Ex3.setString(3, this.mname.getText().toUpperCase());
            statementF3T3Ex3.setString(4, this.lname.getText().toUpperCase());
            statementF3T3Ex3.setString(5, this.kcpe.getText().toUpperCase());
            statementF3T3Ex3.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());
            statementF3T3Ex3.setString(7,idCode.toUpperCase());

            PreparedStatement statementF4T1Ex1 = connection.prepareStatement(F4T1Ex1);
            statementF4T1Ex1.setString(1, this.adm.getText().toUpperCase());
            statementF4T1Ex1.setString(2, this.fname.getText().toUpperCase());
            statementF4T1Ex1.setString(3, this.mname.getText().toUpperCase());
            statementF4T1Ex1.setString(4, this.lname.getText().toUpperCase());
            statementF4T1Ex1.setString(5, this.kcpe.getText().toUpperCase());
            statementF4T1Ex1.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());
            statementF4T1Ex1.setString(7,idCode.toUpperCase());

            PreparedStatement statementF4T1Ex2 = connection.prepareStatement(F4T1Ex2);
            statementF4T1Ex2.setString(1, this.adm.getText().toUpperCase());
            statementF4T1Ex2.setString(2, this.fname.getText().toUpperCase());
            statementF4T1Ex2.setString(3, this.mname.getText().toUpperCase());
            statementF4T1Ex2.setString(4, this.lname.getText().toUpperCase());
            statementF4T1Ex2.setString(5, this.kcpe.getText().toUpperCase());
            statementF4T1Ex2.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());
            statementF4T1Ex2.setString(7,idCode.toUpperCase());

            PreparedStatement statementF4T1Ex3 = connection.prepareStatement(F4T1Ex3);
            statementF4T1Ex3.setString(1, this.adm.getText().toUpperCase());
            statementF4T1Ex3.setString(2, this.fname.getText().toUpperCase());
            statementF4T1Ex3.setString(3, this.mname.getText().toUpperCase());
            statementF4T1Ex3.setString(4, this.lname.getText().toUpperCase());
            statementF4T1Ex3.setString(5, this.kcpe.getText().toUpperCase());
            statementF4T1Ex3.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());
            statementF4T1Ex3.setString(7,idCode.toUpperCase());

            PreparedStatement statementF4T2Ex1 = connection.prepareStatement(F4T2Ex1);
            statementF4T2Ex1.setString(1, this.adm.getText().toUpperCase());
            statementF4T2Ex1.setString(2, this.fname.getText().toUpperCase());
            statementF4T2Ex1.setString(3, this.mname.getText().toUpperCase());
            statementF4T2Ex1.setString(4, this.lname.getText().toUpperCase());
            statementF4T2Ex1.setString(5, this.kcpe.getText().toUpperCase());
            statementF4T2Ex1.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());
            statementF4T2Ex1.setString(7,idCode.toUpperCase());

            PreparedStatement statementF4T2Ex2 = connection.prepareStatement(F4T2Ex2);
            statementF2T2Ex2.setString(1, this.adm.getText().toUpperCase());
            statementF2T2Ex2.setString(2, this.fname.getText().toUpperCase());
            statementF2T2Ex2.setString(3, this.mname.getText().toUpperCase());
            statementF2T2Ex2.setString(4, this.lname.getText().toUpperCase());
            statementF2T2Ex2.setString(5, this.kcpe.getText().toUpperCase());
            statementF2T2Ex2.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());
            statementF4T2Ex2.setString(7,idCode.toUpperCase());

            PreparedStatement statementF4T2Ex3 = connection.prepareStatement(F4T2Ex3);
            statementF4T2Ex3.setString(1, this.adm.getText().toUpperCase());
            statementF4T2Ex3.setString(2, this.fname.getText().toUpperCase());
            statementF4T2Ex3.setString(3, this.mname.getText().toUpperCase());
            statementF4T2Ex3.setString(4, this.lname.getText().toUpperCase());
            statementF4T2Ex3.setString(5, this.kcpe.getText().toUpperCase());
            statementF4T2Ex3.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());
            statementF4T2Ex3.setString(7,idCode.toUpperCase());

            PreparedStatement statementF4T3Ex1 = connection.prepareStatement(F4T3Ex1);
            statementF4T3Ex1.setString(1, this.adm.getText().toUpperCase());
            statementF4T3Ex1.setString(2, this.fname.getText().toUpperCase());
            statementF4T3Ex1.setString(3, this.mname.getText().toUpperCase());
            statementF4T3Ex1.setString(4, this.lname.getText().toUpperCase());
            statementF4T3Ex1.setString(5, this.kcpe.getText().toUpperCase());
            statementF4T3Ex1.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());
            statementF4T3Ex1.setString(7,idCode.toUpperCase());

            PreparedStatement statementF4T3Ex2 = connection.prepareStatement(F4T3Ex2);
            statementF4T3Ex2.setString(1, this.adm.getText().toUpperCase());
            statementF4T3Ex2.setString(2, this.fname.getText().toUpperCase());
            statementF4T3Ex2.setString(3, this.mname.getText().toUpperCase());
            statementF4T3Ex2.setString(4, this.lname.getText().toUpperCase());
            statementF4T3Ex2.setString(5, this.kcpe.getText().toUpperCase());
            statementF4T3Ex2.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());
            statementF4T3Ex2.setString(7,idCode.toUpperCase());

            PreparedStatement statementF4T3Ex3 = connection.prepareStatement(F4T3Ex3);
            statementF4T3Ex3.setString(1, this.adm.getText().toUpperCase());
            statementF4T3Ex3.setString(2, this.fname.getText().toUpperCase());
            statementF4T3Ex3.setString(3, this.mname.getText().toUpperCase());
            statementF4T3Ex3.setString(4, this.lname.getText().toUpperCase());
            statementF4T3Ex3.setString(5, this.kcpe.getText().toUpperCase());
            statementF4T3Ex3.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());
            statementF4T3Ex3.setString(7,idCode.toUpperCase());


            PreparedStatement statementEngF1 = connection.prepareStatement(EngF1);
            statementEngF1.setString(1, this.adm.getText().toUpperCase());
            statementEngF1.setString(2, this.fname.getText().toUpperCase());
            statementEngF1.setString(3, this.mname.getText().toUpperCase());
            statementEngF1.setString(4, this.lname.getText().toUpperCase());
            statementEngF1.setString(5, this.kcpe.getText().toUpperCase());
            statementEngF1.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());
            statementEngF1.setString(7,idCode.toUpperCase());

            PreparedStatement statementKisF1 = connection.prepareStatement(KisF1);
            statementKisF1.setString(1, this.adm.getText().toUpperCase());
            statementKisF1.setString(2, this.fname.getText().toUpperCase());
            statementKisF1.setString(3, this.mname.getText().toUpperCase());
            statementKisF1.setString(4, this.lname.getText().toUpperCase());
            statementKisF1.setString(5, this.kcpe.getText().toUpperCase());
            statementKisF1.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());
            statementKisF1.setString(7,idCode.toUpperCase());

            PreparedStatement statementMatF1 = connection.prepareStatement(MatF1);
            statementMatF1.setString(1, this.adm.getText().toUpperCase());
            statementMatF1.setString(2, this.fname.getText().toUpperCase());
            statementMatF1.setString(3, this.mname.getText().toUpperCase());
            statementMatF1.setString(4, this.lname.getText().toUpperCase());
            statementMatF1.setString(5, this.kcpe.getText().toUpperCase());
            statementMatF1.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());
            statementMatF1.setString(7,idCode.toUpperCase());

            PreparedStatement statementBioF1 = connection.prepareStatement(BioF1);
            statementBioF1.setString(1, this.adm.getText().toUpperCase());
            statementBioF1.setString(2, this.fname.getText().toUpperCase());
            statementBioF1.setString(3, this.mname.getText().toUpperCase());
            statementBioF1.setString(4, this.lname.getText().toUpperCase());
            statementBioF1.setString(5, this.kcpe.getText().toUpperCase());
            statementBioF1.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());
            statementBioF1.setString(7,idCode.toUpperCase());

            PreparedStatement statementPhyF1 = connection.prepareStatement(PhyF1);
            statementPhyF1.setString(1, this.adm.getText().toUpperCase());
            statementPhyF1.setString(2, this.fname.getText().toUpperCase());
            statementPhyF1.setString(3, this.mname.getText().toUpperCase());
            statementPhyF1.setString(4, this.lname.getText().toUpperCase());
            statementPhyF1.setString(5, this.kcpe.getText().toUpperCase());
            statementPhyF1.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());
            statementPhyF1.setString(7,idCode.toUpperCase());

            PreparedStatement statementChemF1 = connection.prepareStatement(ChemF1);
            statementChemF1.setString(1, this.adm.getText().toUpperCase());
            statementChemF1.setString(2, this.fname.getText().toUpperCase());
            statementChemF1.setString(3, this.mname.getText().toUpperCase());
            statementChemF1.setString(4, this.lname.getText().toUpperCase());
            statementChemF1.setString(5, this.kcpe.getText().toUpperCase());
            statementChemF1.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());
            statementChemF1.setString(7,idCode.toUpperCase());

            PreparedStatement statementGeoF1 = connection.prepareStatement(GeoF1);
            statementGeoF1.setString(1, this.adm.getText().toUpperCase());
            statementGeoF1.setString(2, this.fname.getText().toUpperCase());
            statementGeoF1.setString(3, this.mname.getText().toUpperCase());
            statementGeoF1.setString(4, this.lname.getText().toUpperCase());
            statementGeoF1.setString(5, this.kcpe.getText().toUpperCase());
            statementGeoF1.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());
            statementGeoF1.setString(7,idCode.toUpperCase());

            PreparedStatement statementHisF1 = connection.prepareStatement(HisF1);
            statementHisF1.setString(1, this.adm.getText().toUpperCase());
            statementHisF1.setString(2, this.fname.getText().toUpperCase());
            statementHisF1.setString(3, this.mname.getText().toUpperCase());
            statementHisF1.setString(4, this.lname.getText().toUpperCase());
            statementHisF1.setString(5, this.kcpe.getText().toUpperCase());
            statementHisF1.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());
            statementHisF1.setString(7,idCode.toUpperCase());

            PreparedStatement statementCreF1 = connection.prepareStatement(CreF1);
            statementCreF1.setString(1, this.adm.getText().toUpperCase());
            statementCreF1.setString(2, this.fname.getText().toUpperCase());
            statementCreF1.setString(3, this.mname.getText().toUpperCase());
            statementCreF1.setString(4, this.lname.getText().toUpperCase());
            statementCreF1.setString(5, this.kcpe.getText().toUpperCase());
            statementCreF1.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());
            statementCreF1.setString(7,idCode.toUpperCase());

            PreparedStatement statementAgriF1 = connection.prepareStatement(AgriF1);
            statementAgriF1.setString(1, this.adm.getText().toUpperCase());
            statementAgriF1.setString(2, this.fname.getText().toUpperCase());
            statementAgriF1.setString(3, this.mname.getText().toUpperCase());
            statementAgriF1.setString(4, this.lname.getText().toUpperCase());
            statementAgriF1.setString(5, this.kcpe.getText().toUpperCase());
            statementAgriF1.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());
            statementAgriF1.setString(7,idCode.toUpperCase());

            PreparedStatement statementBusF1 = connection.prepareStatement(BusF1);
            statementBusF1.setString(1, this.adm.getText().toUpperCase());
            statementBusF1.setString(2, this.fname.getText().toUpperCase());
            statementBusF1.setString(3, this.mname.getText().toUpperCase());
            statementBusF1.setString(4, this.lname.getText().toUpperCase());
            statementBusF1.setString(5, this.kcpe.getText().toUpperCase());
            statementBusF1.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());
            statementBusF1.setString(7,idCode.toUpperCase());


            PreparedStatement statementEngF2 = connection.prepareStatement(EngF2);
            statementEngF2.setString(1, this.adm.getText().toUpperCase());
            statementEngF2.setString(2, this.fname.getText().toUpperCase());
            statementEngF2.setString(3, this.mname.getText().toUpperCase());
            statementEngF2.setString(4, this.lname.getText().toUpperCase());
            statementEngF2.setString(5, this.kcpe.getText().toUpperCase());
            statementEngF2.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());
            statementEngF2.setString(7,idCode.toUpperCase());

            PreparedStatement statementKisF2 = connection.prepareStatement(KisF2);
            statementKisF2.setString(1, this.adm.getText().toUpperCase());
            statementKisF2.setString(2, this.fname.getText().toUpperCase());
            statementKisF2.setString(3, this.mname.getText().toUpperCase());
            statementKisF2.setString(4, this.lname.getText().toUpperCase());
            statementKisF2.setString(5, this.kcpe.getText().toUpperCase());
            statementKisF2.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());
            statementKisF2.setString(7,idCode.toUpperCase());

            PreparedStatement statementMatF2 = connection.prepareStatement(MatF2);
            statementMatF2.setString(1, this.adm.getText().toUpperCase());
            statementMatF2.setString(2, this.fname.getText().toUpperCase());
            statementMatF2.setString(3, this.mname.getText().toUpperCase());
            statementMatF2.setString(4, this.lname.getText().toUpperCase());
            statementMatF2.setString(5, this.kcpe.getText().toUpperCase());
            statementMatF2.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());
            statementMatF2.setString(7,idCode.toUpperCase());

            PreparedStatement statementBioF2 = connection.prepareStatement(BioF2);
            statementBioF2.setString(1, this.adm.getText().toUpperCase());
            statementBioF2.setString(2, this.fname.getText().toUpperCase());
            statementBioF2.setString(3, this.mname.getText().toUpperCase());
            statementBioF2.setString(4, this.lname.getText().toUpperCase());
            statementBioF2.setString(5, this.kcpe.getText().toUpperCase());
            statementBioF2.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());
            statementBioF2.setString(7,idCode.toUpperCase());

            PreparedStatement statementPhyF2 = connection.prepareStatement(PhyF2);
            statementPhyF2.setString(1, this.adm.getText().toUpperCase());
            statementPhyF2.setString(2, this.fname.getText().toUpperCase());
            statementPhyF2.setString(3, this.mname.getText().toUpperCase());
            statementPhyF2.setString(4, this.lname.getText().toUpperCase());
            statementPhyF2.setString(5, this.kcpe.getText().toUpperCase());
            statementPhyF2.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());
            statementPhyF2.setString(7,idCode.toUpperCase());

            PreparedStatement statementChemF2 = connection.prepareStatement(ChemF2);
            statementChemF2.setString(1, this.adm.getText().toUpperCase());
            statementChemF2.setString(2, this.fname.getText().toUpperCase());
            statementChemF2.setString(3, this.mname.getText().toUpperCase());
            statementChemF2.setString(4, this.lname.getText().toUpperCase());
            statementChemF2.setString(5, this.kcpe.getText().toUpperCase());
            statementChemF2.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());
            statementChemF2.setString(7,idCode.toUpperCase());

            PreparedStatement statementGeoF2 = connection.prepareStatement(GeoF2);
            statementGeoF2.setString(1, this.adm.getText().toUpperCase());
            statementGeoF2.setString(2, this.fname.getText().toUpperCase());
            statementGeoF2.setString(3, this.mname.getText().toUpperCase());
            statementGeoF2.setString(4, this.lname.getText().toUpperCase());
            statementGeoF2.setString(5, this.kcpe.getText().toUpperCase());
            statementGeoF2.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());
            statementGeoF2.setString(7,idCode.toUpperCase());

            PreparedStatement statementHisF2 = connection.prepareStatement(HisF2);
            statementHisF2.setString(1, this.adm.getText().toUpperCase());
            statementHisF2.setString(2, this.fname.getText().toUpperCase());
            statementHisF2.setString(3, this.mname.getText().toUpperCase());
            statementHisF2.setString(4, this.lname.getText().toUpperCase());
            statementHisF2.setString(5, this.kcpe.getText().toUpperCase());
            statementHisF2.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());
            statementHisF2.setString(7,idCode.toUpperCase());

            PreparedStatement statementCreF2 = connection.prepareStatement(CreF2);
            statementCreF2.setString(1, this.adm.getText().toUpperCase());
            statementCreF2.setString(2, this.fname.getText().toUpperCase());
            statementCreF2.setString(3, this.mname.getText().toUpperCase());
            statementCreF2.setString(4, this.lname.getText().toUpperCase());
            statementCreF2.setString(5, this.kcpe.getText().toUpperCase());
            statementCreF2.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());
            statementCreF2.setString(7,idCode.toUpperCase());

            PreparedStatement statementAgriF2 = connection.prepareStatement(AgriF2);
            statementAgriF2.setString(1, this.adm.getText().toUpperCase());
            statementAgriF2.setString(2, this.fname.getText().toUpperCase());
            statementAgriF2.setString(3, this.mname.getText().toUpperCase());
            statementAgriF2.setString(4, this.lname.getText().toUpperCase());
            statementAgriF2.setString(5, this.kcpe.getText().toUpperCase());
            statementAgriF2.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());
            statementAgriF2.setString(7,idCode.toUpperCase());

            PreparedStatement statementBusF2 = connection.prepareStatement(BusF2);
            statementBusF2.setString(1, this.adm.getText().toUpperCase());
            statementBusF2.setString(2, this.fname.getText().toUpperCase());
            statementBusF2.setString(3, this.mname.getText().toUpperCase());
            statementBusF2.setString(4, this.lname.getText().toUpperCase());
            statementBusF2.setString(5, this.kcpe.getText().toUpperCase());
            statementBusF2.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());
            statementBusF2.setString(7,idCode.toUpperCase());


            PreparedStatement statementEngF3 = connection.prepareStatement(EngF3);
            statementEngF3.setString(1, this.adm.getText().toUpperCase());
            statementEngF3.setString(2, this.fname.getText().toUpperCase());
            statementEngF3.setString(3, this.mname.getText().toUpperCase());
            statementEngF3.setString(4, this.lname.getText().toUpperCase());
            statementEngF3.setString(5, this.kcpe.getText().toUpperCase());
            statementEngF3.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());
            statementEngF3.setString(7,idCode.toUpperCase());

            PreparedStatement statementKisF3 = connection.prepareStatement(KisF3);
            statementKisF3.setString(1, this.adm.getText().toUpperCase());
            statementKisF3.setString(2, this.fname.getText().toUpperCase());
            statementKisF3.setString(3, this.mname.getText().toUpperCase());
            statementKisF3.setString(4, this.lname.getText().toUpperCase());
            statementKisF3.setString(5, this.kcpe.getText().toUpperCase());
            statementKisF3.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());
            statementKisF3.setString(7,idCode.toUpperCase());

            PreparedStatement statementMatF3 = connection.prepareStatement(MatF3);
            statementMatF3.setString(1, this.adm.getText().toUpperCase());
            statementMatF3.setString(2, this.fname.getText().toUpperCase());
            statementMatF3.setString(3, this.mname.getText().toUpperCase());
            statementMatF3.setString(4, this.lname.getText().toUpperCase());
            statementMatF3.setString(5, this.kcpe.getText().toUpperCase());
            statementMatF3.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());
            statementMatF3.setString(7,idCode.toUpperCase());

            PreparedStatement statementBioF3 = connection.prepareStatement(BioF3);
            statementBioF3.setString(1, this.adm.getText().toUpperCase());
            statementBioF3.setString(2, this.fname.getText().toUpperCase());
            statementBioF3.setString(3, this.mname.getText().toUpperCase());
            statementBioF3.setString(4, this.lname.getText().toUpperCase());
            statementBioF3.setString(5, this.kcpe.getText().toUpperCase());
            statementBioF3.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());
            statementBioF3.setString(7,idCode.toUpperCase());

            PreparedStatement statementPhyF3 = connection.prepareStatement(PhyF3);
            statementPhyF3.setString(1, this.adm.getText().toUpperCase());
            statementPhyF3.setString(2, this.fname.getText().toUpperCase());
            statementPhyF3.setString(3, this.mname.getText().toUpperCase());
            statementPhyF3.setString(4, this.lname.getText().toUpperCase());
            statementPhyF3.setString(5, this.kcpe.getText().toUpperCase());
            statementPhyF3.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());
            statementPhyF3.setString(7,idCode.toUpperCase());

            PreparedStatement statementChemF3 = connection.prepareStatement(ChemF3);
            statementChemF3.setString(1, this.adm.getText().toUpperCase());
            statementChemF3.setString(2, this.fname.getText().toUpperCase());
            statementChemF3.setString(3, this.mname.getText().toUpperCase());
            statementChemF3.setString(4, this.lname.getText().toUpperCase());
            statementChemF3.setString(5, this.kcpe.getText().toUpperCase());
            statementChemF3.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());
            statementChemF3.setString(7,idCode.toUpperCase());

            PreparedStatement statementGeoF3 = connection.prepareStatement(GeoF3);
            statementGeoF3.setString(1, this.adm.getText().toUpperCase());
            statementGeoF3.setString(2, this.fname.getText().toUpperCase());
            statementGeoF3.setString(3, this.mname.getText().toUpperCase());
            statementGeoF3.setString(4, this.lname.getText().toUpperCase());
            statementGeoF3.setString(5, this.kcpe.getText().toUpperCase());
            statementGeoF3.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());
            statementGeoF3.setString(7,idCode.toUpperCase());

            PreparedStatement statementHisF3 = connection.prepareStatement(HisF3);
            statementHisF3.setString(1, this.adm.getText().toUpperCase());
            statementHisF3.setString(2, this.fname.getText().toUpperCase());
            statementHisF3.setString(3, this.mname.getText().toUpperCase());
            statementHisF3.setString(4, this.lname.getText().toUpperCase());
            statementHisF3.setString(5, this.kcpe.getText().toUpperCase());
            statementHisF3.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());
            statementHisF3.setString(7,idCode.toUpperCase());

            PreparedStatement statementCreF3 = connection.prepareStatement(CreF3);
            statementCreF3.setString(1, this.adm.getText().toUpperCase());
            statementCreF3.setString(2, this.fname.getText().toUpperCase());
            statementCreF3.setString(3, this.mname.getText().toUpperCase());
            statementCreF3.setString(4, this.lname.getText().toUpperCase());
            statementCreF3.setString(5, this.kcpe.getText().toUpperCase());
            statementCreF3.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());
            statementCreF3.setString(7,idCode.toUpperCase());

            PreparedStatement statementAgriF3 = connection.prepareStatement(AgriF3);
            statementAgriF3.setString(1, this.adm.getText().toUpperCase());
            statementAgriF3.setString(2, this.fname.getText().toUpperCase());
            statementAgriF3.setString(3, this.mname.getText().toUpperCase());
            statementAgriF3.setString(4, this.lname.getText().toUpperCase());
            statementAgriF3.setString(5, this.kcpe.getText().toUpperCase());
            statementAgriF3.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());
            statementAgriF3.setString(7,idCode.toUpperCase());

            PreparedStatement statementBusF3 = connection.prepareStatement(BusF3);
            statementBusF3.setString(1, this.adm.getText().toUpperCase());
            statementBusF3.setString(2, this.fname.getText().toUpperCase());
            statementBusF3.setString(3, this.mname.getText().toUpperCase());
            statementBusF3.setString(4, this.lname.getText().toUpperCase());
            statementBusF3.setString(5, this.kcpe.getText().toUpperCase());
            statementBusF3.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());
            statementBusF3.setString(7,idCode.toUpperCase());


            PreparedStatement statementEngF4 = connection.prepareStatement(EngF4);
            statementEngF4.setString(1, this.adm.getText().toUpperCase());
            statementEngF4.setString(2, this.fname.getText().toUpperCase());
            statementEngF4.setString(3, this.mname.getText().toUpperCase());
            statementEngF4.setString(4, this.lname.getText().toUpperCase());
            statementEngF4.setString(5, this.kcpe.getText().toUpperCase());
            statementEngF4.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());
            statementEngF4.setString(7,idCode.toUpperCase());

            PreparedStatement statementKisF4 = connection.prepareStatement(KisF4);
            statementKisF4.setString(1, this.adm.getText().toUpperCase());
            statementKisF4.setString(2, this.fname.getText().toUpperCase());
            statementKisF4.setString(3, this.mname.getText().toUpperCase());
            statementKisF4.setString(4, this.lname.getText().toUpperCase());
            statementKisF4.setString(5, this.kcpe.getText().toUpperCase());
            statementKisF4.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());
            statementKisF4.setString(7,idCode.toUpperCase());

            PreparedStatement statementMatF4 = connection.prepareStatement(MatF4);
            statementMatF4.setString(1, this.adm.getText().toUpperCase());
            statementMatF4.setString(2, this.fname.getText().toUpperCase());
            statementMatF4.setString(3, this.mname.getText().toUpperCase());
            statementMatF4.setString(4, this.lname.getText().toUpperCase());
            statementMatF4.setString(5, this.kcpe.getText().toUpperCase());
            statementMatF4.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());
            statementMatF4.setString(7,idCode.toUpperCase());

            PreparedStatement statementBioF4 = connection.prepareStatement(BioF4);
            statementBioF4.setString(1, this.adm.getText().toUpperCase());
            statementBioF4.setString(2, this.fname.getText().toUpperCase());
            statementBioF4.setString(3, this.mname.getText().toUpperCase());
            statementBioF4.setString(4, this.lname.getText().toUpperCase());
            statementBioF4.setString(5, this.kcpe.getText().toUpperCase());
            statementBioF4.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());
            statementBioF4.setString(7,idCode.toUpperCase());

            PreparedStatement statementPhyF4 = connection.prepareStatement(PhyF4);
            statementPhyF4.setString(1, this.adm.getText().toUpperCase());
            statementPhyF4.setString(2, this.fname.getText().toUpperCase());
            statementPhyF4.setString(3, this.mname.getText().toUpperCase());
            statementPhyF4.setString(4, this.lname.getText().toUpperCase());
            statementPhyF4.setString(5, this.kcpe.getText().toUpperCase());
            statementPhyF4.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());
            statementPhyF4.setString(7,idCode.toUpperCase());

            PreparedStatement statementChemF4 = connection.prepareStatement(ChemF4);
            statementChemF4.setString(1, this.adm.getText().toUpperCase());
            statementChemF4.setString(2, this.fname.getText().toUpperCase());
            statementChemF4.setString(3, this.mname.getText().toUpperCase());
            statementChemF4.setString(4, this.lname.getText().toUpperCase());
            statementChemF4.setString(5, this.kcpe.getText().toUpperCase());
            statementChemF4.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());
            statementChemF4.setString(7,idCode.toUpperCase());

            PreparedStatement statementGeoF4 = connection.prepareStatement(GeoF4);
            statementGeoF4.setString(1, this.adm.getText().toUpperCase());
            statementGeoF4.setString(2, this.fname.getText().toUpperCase());
            statementGeoF4.setString(3, this.mname.getText().toUpperCase());
            statementGeoF4.setString(4, this.lname.getText().toUpperCase());
            statementGeoF4.setString(5, this.kcpe.getText().toUpperCase());
            statementGeoF4.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());
            statementGeoF4.setString(7,idCode.toUpperCase());

            PreparedStatement statementHisF4 = connection.prepareStatement(HisF4);
            statementHisF4.setString(1, this.adm.getText().toUpperCase());
            statementHisF4.setString(2, this.fname.getText().toUpperCase());
            statementHisF4.setString(3, this.mname.getText().toUpperCase());
            statementHisF4.setString(4, this.lname.getText().toUpperCase());
            statementHisF4.setString(5, this.kcpe.getText().toUpperCase());
            statementHisF4.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());
            statementHisF4.setString(7,idCode.toUpperCase());

            PreparedStatement statementCreF4 = connection.prepareStatement(CreF4);
            statementCreF4.setString(1, this.adm.getText().toUpperCase());
            statementCreF4.setString(2, this.fname.getText().toUpperCase());
            statementCreF4.setString(3, this.mname.getText().toUpperCase());
            statementCreF4.setString(4, this.lname.getText().toUpperCase());
            statementCreF4.setString(5, this.kcpe.getText().toUpperCase());
            statementCreF4.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());
            statementCreF4.setString(7,idCode.toUpperCase());

            PreparedStatement statementAgriF4 = connection.prepareStatement(AgriF4);
            statementAgriF4.setString(1, this.adm.getText().toUpperCase());
            statementAgriF4.setString(2, this.fname.getText().toUpperCase());
            statementAgriF4.setString(3, this.mname.getText().toUpperCase());
            statementAgriF4.setString(4, this.lname.getText().toUpperCase());
            statementAgriF4.setString(5, this.kcpe.getText().toUpperCase());
            statementAgriF4.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());
            statementAgriF4.setString(7,idCode.toUpperCase());

            PreparedStatement statementBusF4 = connection.prepareStatement(BusF4);
            statementBusF4.setString(1, this.adm.getText().toUpperCase());
            statementBusF4.setString(2, this.fname.getText().toUpperCase());
            statementBusF4.setString(3, this.mname.getText().toUpperCase());
            statementBusF4.setString(4, this.lname.getText().toUpperCase());
            statementBusF4.setString(5, this.kcpe.getText().toUpperCase());
            statementBusF4.setString(6, ((classOption) this.classes.getValue()).toString().toUpperCase());
            statementBusF4.setString(7,idCode.toUpperCase());


            statementStudent.execute();
            statementSubjects.execute();
            statementF1T1Avg.execute();
            statementF1T2Avg.execute();
            statementF1T3Avg.execute();
            statementF2T1Avg.execute();
            statementF2T2Avg.execute();
            statementF2T3Avg.execute();
            statementF3T1Avg.execute();
            statementF3T2Avg.execute();
            statementF3T3Avg.execute();
            statementF4T1Avg.execute();
            statementF4T2Avg.execute();
            statementF4T3Avg.execute();//start
            statementF1T1Ex1.execute();
            statementF1T1Ex2.execute();
            statementF1T1Ex3.execute();
            statementF1T2Ex1.execute();
            statementF1T2Ex2.execute();
            statementF1T2Ex3.execute();
            statementF1T3Ex1.execute();
            statementF1T3Ex2.execute();
            statementF1T3Ex3.execute();///syart
            statementF2T1Ex1.execute();
            statementF2T1Ex2.execute();
            statementF2T1Ex3.execute();
            statementF2T2Ex1.execute();
            statementF2T2Ex2.execute();
            statementF2T2Ex3.execute();
            statementF2T3Ex1.execute();
            statementF2T3Ex2.execute();
            statementF2T3Ex3.execute();//start
            statementF3T1Ex1.execute();
            statementF3T1Ex2.execute();
            statementF3T1Ex3.execute();
            statementF3T2Ex1.execute();
            statementF3T2Ex2.execute();
            statementF3T2Ex3.execute();
            statementF3T3Ex1.execute();
            statementF3T3Ex2.execute();
            statementF3T3Ex3.execute();//start
            statementF4T1Ex1.execute();
            statementF4T1Ex2.execute();
            statementF4T1Ex3.execute();
            statementF4T2Ex1.execute();
            statementF4T2Ex2.execute();
            statementF4T2Ex3.execute();
            statementF4T3Ex1.execute();
            statementF4T3Ex2.execute();
            statementF4T3Ex3.execute();
            statementEngF1.execute();//start
            statementKisF1.execute();
            statementMatF1.execute();
            statementBioF1.execute();
            statementChemF1.execute();
            statementPhyF1.execute();
            statementGeoF1.execute();
            statementHisF1.execute();
            statementCreF1.execute();
            statementAgriF1.execute();
            statementBusF1.execute();
            statementEngF2.execute();
            statementKisF2.execute();
            statementMatF2.execute();
            statementBioF2.execute();
            statementChemF2.execute();
            statementPhyF2.execute();
            statementGeoF2.execute();
            statementHisF2.execute();
            statementCreF2.execute();
            statementAgriF2.execute();
            statementBusF2.execute();
            statementEngF3.execute();
            statementKisF3.execute();
            statementMatF3.execute();
            statementBioF3.execute();
            statementChemF3.execute();
            statementPhyF3.execute();
            statementGeoF3.execute();
            statementHisF3.execute();
            statementCreF3.execute();
            statementAgriF3.execute();
            statementBusF3.execute();
            statementEngF4.execute();
            statementKisF4.execute();
            statementMatF4.execute();
            statementBioF4.execute();
            statementChemF4.execute();
            statementPhyF4.execute();
            statementGeoF4.execute();
            statementHisF4.execute();
            statementCreF4.execute();
            statementAgriF4.execute();
            statementBusF4.execute();
            emptyTextFields();
            connection.close();
            loadData();
            infoBox("Student updated successfully","Success",null);

        }catch (Exception e){
            infoBoxError("An error occurred " + e,"Error",null);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.classes.setItems(FXCollections.observableArrayList(classOption.values()));
        loadData();
    }
}
