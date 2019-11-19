package start;

import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DatabaseSync {
    /*
    *This file will add the new students to the database
    * or synchronize any changes made
    */

    //public void addStudent(Stage ps,Stage spalsh){
    public void addStudent(){
        String sqlDelete = "DELETE FROM tbl_temporary";
        String students = "INSERT INTO tbl_students(adm,fname,mname,lname,kcpe,class,dob)SELECT adm,fname,mname,lname,kcpe,class,dob FROM tbl_temporary";
        String subject = "INSERT INTO tbl_subject_selection(adm,fname,mname,lname,kcpe,class)SELECT adm,fname,mname,lname,kcpe,class FROM tbl_temporary";
        String F1T1Avg = "INSERT INTO tbl_f1_t1_avg(adm,fname,mname,lname,kcpe,class)SELECT adm,fname,mname,lname,kcpe,class FROM tbl_temporary";
        String F1T2Avg = "INSERT INTO tbl_f1_t2_avg(adm,fname,mname,lname,kcpe,class)SELECT adm,fname,mname,lname,kcpe,class FROM tbl_temporary";
        String F1T3Avg = "INSERT INTO tbl_f1_t3_avg(adm,fname,mname,lname,kcpe,class)SELECT adm,fname,mname,lname,kcpe,class FROM tbl_temporary";
        String F2T1Avg = "INSERT INTO tbl_f2_t1_avg(adm,fname,mname,lname,kcpe,class)SELECT adm,fname,mname,lname,kcpe,class FROM tbl_temporary";
        String F2T2Avg = "INSERT INTO tbl_f2_t2_avg(adm,fname,mname,lname,kcpe,class)SELECT adm,fname,mname,lname,kcpe,class FROM tbl_temporary";
        String F2T3Avg = "INSERT INTO tbl_f2_t3_avg(adm,fname,mname,lname,kcpe,class)SELECT adm,fname,mname,lname,kcpe,class FROM tbl_temporary";
        String F3T1Avg = "INSERT INTO tbl_f3_t1_avg(adm,fname,mname,lname,kcpe,class)SELECT adm,fname,mname,lname,kcpe,class FROM tbl_temporary";
        String F3T2Avg = "INSERT INTO tbl_f3_t2_avg(adm,fname,mname,lname,kcpe,class)SELECT adm,fname,mname,lname,kcpe,class FROM tbl_temporary";
        String F3T3Avg = "INSERT INTO tbl_f3_t3_avg(adm,fname,mname,lname,kcpe,class)SELECT adm,fname,mname,lname,kcpe,class FROM tbl_temporary";
        String F4T1Avg = "INSERT INTO tbl_f4_t1_avg(adm,fname,mname,lname,kcpe,class)SELECT adm,fname,mname,lname,kcpe,class FROM tbl_temporary";
        String F4T2Avg = "INSERT INTO tbl_f4_t2_avg(adm,fname,mname,lname,kcpe,class)SELECT adm,fname,mname,lname,kcpe,class FROM tbl_temporary";
        String F4T3Avg = "INSERT INTO tbl_f4_t3_avg(adm,fname,mname,lname,kcpe,class)SELECT adm,fname,mname,lname,kcpe,class FROM tbl_temporary";

        String F1T1Ex1 = "INSERT INTO tbl_f1_t1_ex1(adm,fname,mname,lname,kcpe,class)SELECT adm,fname,mname,lname,kcpe,class FROM tbl_temporary";
        String F1T1Ex2 = "INSERT INTO tbl_f1_t1_ex2(adm,fname,mname,lname,kcpe,class)SELECT adm,fname,mname,lname,kcpe,class FROM tbl_temporary";
        String F1T1Ex3 = "INSERT INTO tbl_f1_t1_ex3(adm,fname,mname,lname,kcpe,class)SELECT adm,fname,mname,lname,kcpe,class FROM tbl_temporary";
        String F1T2Ex1 = "INSERT INTO tbl_f1_t2_ex1(adm,fname,mname,lname,kcpe,class)SELECT adm,fname,mname,lname,kcpe,class FROM tbl_temporary";
        String F1T2Ex2 = "INSERT INTO tbl_f1_t2_ex2(adm,fname,mname,lname,kcpe,class)SELECT adm,fname,mname,lname,kcpe,class FROM tbl_temporary";
        String F1T2Ex3 = "INSERT INTO tbl_f1_t2_ex3(adm,fname,mname,lname,kcpe,class)SELECT adm,fname,mname,lname,kcpe,class FROM tbl_temporary";
        String F1T3Ex1 = "INSERT INTO tbl_f1_t3_ex1(adm,fname,mname,lname,kcpe,class)SELECT adm,fname,mname,lname,kcpe,class FROM tbl_temporary";
        String F1T3Ex2 = "INSERT INTO tbl_f1_t3_ex2(adm,fname,mname,lname,kcpe,class)SELECT adm,fname,mname,lname,kcpe,class FROM tbl_temporary";
        String F1T3Ex3 = "INSERT INTO tbl_f1_t3_ex3(adm,fname,mname,lname,kcpe,class)SELECT adm,fname,mname,lname,kcpe,class FROM tbl_temporary";

        String F2T1Ex1 = "INSERT INTO tbl_f2_t1_ex1(adm,fname,mname,lname,kcpe,class)SELECT adm,fname,mname,lname,kcpe,class FROM tbl_temporary";
        String F2T1Ex2 = "INSERT INTO tbl_f2_t1_ex2(adm,fname,mname,lname,kcpe,class)SELECT adm,fname,mname,lname,kcpe,class FROM tbl_temporary";
        String F2T1Ex3 = "INSERT INTO tbl_f2_t1_ex3(adm,fname,mname,lname,kcpe,class)SELECT adm,fname,mname,lname,kcpe,class FROM tbl_temporary";
        String F2T2Ex1 = "INSERT INTO tbl_f2_t2_ex1(adm,fname,mname,lname,kcpe,class)SELECT adm,fname,mname,lname,kcpe,class FROM tbl_temporary";
        String F2T2Ex2 = "INSERT INTO tbl_f2_t2_ex2(adm,fname,mname,lname,kcpe,class)SELECT adm,fname,mname,lname,kcpe,class FROM tbl_temporary";
        String F2T2Ex3 = "INSERT INTO tbl_f2_t2_ex3(adm,fname,mname,lname,kcpe,class)SELECT adm,fname,mname,lname,kcpe,class FROM tbl_temporary";
        String F2T3Ex1 = "INSERT INTO tbl_f2_t3_ex1(adm,fname,mname,lname,kcpe,class)SELECT adm,fname,mname,lname,kcpe,class FROM tbl_temporary";
        String F2T3Ex2 = "INSERT INTO tbl_f2_t3_ex2(adm,fname,mname,lname,kcpe,class)SELECT adm,fname,mname,lname,kcpe,class FROM tbl_temporary";
        String F2T3Ex3 = "INSERT INTO tbl_f2_t3_ex3(adm,fname,mname,lname,kcpe,class)SELECT adm,fname,mname,lname,kcpe,class FROM tbl_temporary";

        String F3T1Ex1 = "INSERT INTO tbl_f3_t1_ex1(adm,fname,mname,lname,kcpe,class)SELECT adm,fname,mname,lname,kcpe,class FROM tbl_temporary";
        String F3T1Ex2 = "INSERT INTO tbl_f3_t1_ex2(adm,fname,mname,lname,kcpe,class)SELECT adm,fname,mname,lname,kcpe,class FROM tbl_temporary";
        String F3T1Ex3 = "INSERT INTO tbl_f3_t1_ex3(adm,fname,mname,lname,kcpe,class)SELECT adm,fname,mname,lname,kcpe,class FROM tbl_temporary";
        String F3T2Ex1 = "INSERT INTO tbl_f3_t2_ex1(adm,fname,mname,lname,kcpe,class)SELECT adm,fname,mname,lname,kcpe,class FROM tbl_temporary";
        String F3T2Ex2 = "INSERT INTO tbl_f3_t2_ex2(adm,fname,mname,lname,kcpe,class)SELECT adm,fname,mname,lname,kcpe,class FROM tbl_temporary";
        String F3T2Ex3 = "INSERT INTO tbl_f3_t2_ex3(adm,fname,mname,lname,kcpe,class)SELECT adm,fname,mname,lname,kcpe,class FROM tbl_temporary";
        String F3T3Ex1 = "INSERT INTO tbl_f3_t3_ex1(adm,fname,mname,lname,kcpe,class)SELECT adm,fname,mname,lname,kcpe,class FROM tbl_temporary";
        String F3T3Ex2 = "INSERT INTO tbl_f3_t3_ex2(adm,fname,mname,lname,kcpe,class)SELECT adm,fname,mname,lname,kcpe,class FROM tbl_temporary";
        String F3T3Ex3 = "INSERT INTO tbl_f3_t3_ex3(adm,fname,mname,lname,kcpe,class)SELECT adm,fname,mname,lname,kcpe,class FROM tbl_temporary";

        String F4T1Ex1 = "INSERT INTO tbl_f4_t1_ex1(adm,fname,mname,lname,kcpe,class)SELECT adm,fname,mname,lname,kcpe,class FROM tbl_temporary";
        String F4T1Ex2 = "INSERT INTO tbl_f4_t1_ex2(adm,fname,mname,lname,kcpe,class)SELECT adm,fname,mname,lname,kcpe,class FROM tbl_temporary";
        String F4T1Ex3 = "INSERT INTO tbl_f4_t1_ex3(adm,fname,mname,lname,kcpe,class)SELECT adm,fname,mname,lname,kcpe,class FROM tbl_temporary";
        String F4T2Ex1 = "INSERT INTO tbl_f4_t2_ex1(adm,fname,mname,lname,kcpe,class)SELECT adm,fname,mname,lname,kcpe,class FROM tbl_temporary";
        String F4T2Ex2 = "INSERT INTO tbl_f4_t2_ex2(adm,fname,mname,lname,kcpe,class)SELECT adm,fname,mname,lname,kcpe,class FROM tbl_temporary";
        String F4T2Ex3 = "INSERT INTO tbl_f4_t2_ex3(adm,fname,mname,lname,kcpe,class)SELECT adm,fname,mname,lname,kcpe,class FROM tbl_temporary";
        String F4T3Ex1 = "INSERT INTO tbl_f4_t3_ex1(adm,fname,mname,lname,kcpe,class)SELECT adm,fname,mname,lname,kcpe,class FROM tbl_temporary";
        String F4T3Ex2 = "INSERT INTO tbl_f4_t3_ex2(adm,fname,mname,lname,kcpe,class)SELECT adm,fname,mname,lname,kcpe,class FROM tbl_temporary";
        String F4T3Ex3 = "INSERT INTO tbl_f4_t3_ex3(adm,fname,mname,lname,kcpe,class)SELECT adm,fname,mname,lname,kcpe,class FROM tbl_temporary";

        String EngF1 = "INSERT INTO tbl_f1_eng(adm,fname,mname,lname,kcpe,class)SELECT adm,fname,mname,lname,kcpe,class FROM tbl_temporary";
        String KisF1 = "INSERT INTO tbl_f1_kis(adm,fname,mname,lname,kcpe,class)SELECT adm,fname,mname,lname,kcpe,class FROM tbl_temporary";
        String MatF1 = "INSERT INTO tbl_f1_mat(adm,fname,mname,lname,kcpe,class)SELECT adm,fname,mname,lname,kcpe,class FROM tbl_temporary";
        String BioF1 = "INSERT INTO tbl_f1_bio(adm,fname,mname,lname,kcpe,class)SELECT adm,fname,mname,lname,kcpe,class FROM tbl_temporary";
        String PhyF1 = "INSERT INTO tbl_f1_phy(adm,fname,mname,lname,kcpe,class)SELECT adm,fname,mname,lname,kcpe,class FROM tbl_temporary";
        String ChemF1 = "INSERT INTO tbl_f1_chem(adm,fname,mname,lname,kcpe,class)SELECT adm,fname,mname,lname,kcpe,class FROM tbl_temporary";
        String GeoF1 = "INSERT INTO tbl_f1_geo(adm,fname,mname,lname,kcpe,class)SELECT adm,fname,mname,lname,kcpe,class FROM tbl_temporary";
        String HisF1 = "INSERT INTO tbl_f1_his(adm,fname,mname,lname,kcpe,class)SELECT adm,fname,mname,lname,kcpe,class FROM tbl_temporary";
        String CreF1 = "INSERT INTO tbl_f1_cre(adm,fname,mname,lname,kcpe,class)SELECT adm,fname,mname,lname,kcpe,class FROM tbl_temporary";
        String AgriF1 = "INSERT INTO tbl_f1_agri(adm,fname,mname,lname,kcpe,class)SELECT adm,fname,mname,lname,kcpe,class FROM tbl_temporary";
        String BusF1 = "INSERT INTO tbl_f1_bus(adm,fname,mname,lname,kcpe,class)SELECT adm,fname,mname,lname,kcpe,class FROM tbl_temporary";
        String EngF2 = "INSERT INTO tbl_f2_eng(adm,fname,mname,lname,kcpe,class)SELECT adm,fname,mname,lname,kcpe,class FROM tbl_temporary";
        String KisF2 = "INSERT INTO tbl_f2_kis(adm,fname,mname,lname,kcpe,class)SELECT adm,fname,mname,lname,kcpe,class FROM tbl_temporary";
        String MatF2 = "INSERT INTO tbl_f2_mat(adm,fname,mname,lname,kcpe,class)SELECT adm,fname,mname,lname,kcpe,class FROM tbl_temporary";
        String BioF2 = "INSERT INTO tbl_f2_bio(adm,fname,mname,lname,kcpe,class)SELECT adm,fname,mname,lname,kcpe,class FROM tbl_temporary";
        String PhyF2 = "INSERT INTO tbl_f2_phy(adm,fname,mname,lname,kcpe,class)SELECT adm,fname,mname,lname,kcpe,class FROM tbl_temporary";
        String ChemF2 = "INSERT INTO tbl_f2_chem(adm,fname,mname,lname,kcpe,class)SELECT adm,fname,mname,lname,kcpe,class FROM tbl_temporary";
        String GeoF2 = "INSERT INTO tbl_f2_geo(adm,fname,mname,lname,kcpe,class)SELECT adm,fname,mname,lname,kcpe,class FROM tbl_temporary";
        String HisF2 = "INSERT INTO tbl_f2_his(adm,fname,mname,lname,kcpe,class)SELECT adm,fname,mname,lname,kcpe,class FROM tbl_temporary";
        String CreF2 = "INSERT INTO tbl_f2_cre(adm,fname,mname,lname,kcpe,class)SELECT adm,fname,mname,lname,kcpe,class FROM tbl_temporary";
        String AgriF2 = "INSERT INTO tbl_f2_agri(adm,fname,mname,lname,kcpe,class)SELECT adm,fname,mname,lname,kcpe,class FROM tbl_temporary";
        String BusF2 = "INSERT INTO tbl_f2_bus(adm,fname,mname,lname,kcpe,class)SELECT adm,fname,mname,lname,kcpe,class FROM tbl_temporary";
        String EngF3 = "INSERT INTO tbl_f3_eng(adm,fname,mname,lname,kcpe,class)SELECT adm,fname,mname,lname,kcpe,class FROM tbl_temporary";
        String KisF3 = "INSERT INTO tbl_f3_kis(adm,fname,mname,lname,kcpe,class)SELECT adm,fname,mname,lname,kcpe,class FROM tbl_temporary";
        String MatF3 = "INSERT INTO tbl_f3_mat(adm,fname,mname,lname,kcpe,class)SELECT adm,fname,mname,lname,kcpe,class FROM tbl_temporary";
        String BioF3 = "INSERT INTO tbl_f3_bio(adm,fname,mname,lname,kcpe,class)SELECT adm,fname,mname,lname,kcpe,class FROM tbl_temporary";
        String PhyF3 = "INSERT INTO tbl_f3_phy(adm,fname,mname,lname,kcpe,class)SELECT adm,fname,mname,lname,kcpe,class FROM tbl_temporary";
        String ChemF3 = "INSERT INTO tbl_f3_chem(adm,fname,mname,lname,kcpe,class)SELECT adm,fname,mname,lname,kcpe,class FROM tbl_temporary";
        String GeoF3 = "INSERT INTO tbl_f3_geo(adm,fname,mname,lname,kcpe,class)SELECT adm,fname,mname,lname,kcpe,class FROM tbl_temporary";
        String HisF3 = "INSERT INTO tbl_f3_his(adm,fname,mname,lname,kcpe,class)SELECT adm,fname,mname,lname,kcpe,class FROM tbl_temporary";
        String CreF3 = "INSERT INTO tbl_f3_cre(adm,fname,mname,lname,kcpe,class)SELECT adm,fname,mname,lname,kcpe,class FROM tbl_temporary";
        String AgriF3 = "INSERT INTO tbl_f3_agri(adm,fname,mname,lname,kcpe,class)SELECT adm,fname,mname,lname,kcpe,class FROM tbl_temporary";
        String BusF3 = "INSERT INTO tbl_f3_bus(adm,fname,mname,lname,kcpe,class)SELECT adm,fname,mname,lname,kcpe,class FROM tbl_temporary";
        String EngF4 = "INSERT INTO tbl_f4_eng(adm,fname,mname,lname,kcpe,class)SELECT adm,fname,mname,lname,kcpe,class FROM tbl_temporary";
        String KisF4 = "INSERT INTO tbl_f4_kis(adm,fname,mname,lname,kcpe,class)SELECT adm,fname,mname,lname,kcpe,class FROM tbl_temporary";
        String MatF4 = "INSERT INTO tbl_f4_mat(adm,fname,mname,lname,kcpe,class)SELECT adm,fname,mname,lname,kcpe,class FROM tbl_temporary";
        String BioF4 = "INSERT INTO tbl_f4_bio(adm,fname,mname,lname,kcpe,class)SELECT adm,fname,mname,lname,kcpe,class FROM tbl_temporary";
        String PhyF4 = "INSERT INTO tbl_f4_phy(adm,fname,mname,lname,kcpe,class)SELECT adm,fname,mname,lname,kcpe,class FROM tbl_temporary";
        String ChemF4 = "INSERT INTO tbl_f4_chem(adm,fname,mname,lname,kcpe,class)SELECT adm,fname,mname,lname,kcpe,class FROM tbl_temporary";
        String GeoF4 = "INSERT INTO tbl_f4_geo(adm,fname,mname,lname,kcpe,class)SELECT adm,fname,mname,lname,kcpe,class FROM tbl_temporary";
        String HisF4 = "INSERT INTO tbl_f4_his(adm,fname,mname,lname,kcpe,class)SELECT adm,fname,mname,lname,kcpe,class FROM tbl_temporary";
        String CreF4 = "INSERT INTO tbl_f4_cre(adm,fname,mname,lname,kcpe,class)SELECT adm,fname,mname,lname,kcpe,class FROM tbl_temporary";
        String AgriF4 = "INSERT INTO tbl_f4_agri(adm,fname,mname,lname,kcpe,class)SELECT adm,fname,mname,lname,kcpe,class FROM tbl_temporary";
        String BusF4 = "INSERT INTO tbl_f4_bus(adm,fname,mname,lname,kcpe,class)SELECT adm,fname,mname,lname,kcpe,class FROM tbl_temporary";
        try{
            Connection connection = Database.DBConnection.getConnection();
            assert connection != null;
            //insert into students table
           // PreparedStatement statementStudents = connection.prepareStatement(students);
//            statementStudents.execute();
            //inserting into the average tables
            PreparedStatement statementSubject = connection.prepareStatement(subject);
            statementSubject.execute();
            PreparedStatement statementF1T1Avg = connection.prepareStatement(F1T1Avg);
            statementF1T1Avg.execute();
            PreparedStatement statementF1T2Avg = connection.prepareStatement(F1T2Avg);
            statementF1T2Avg.execute();
            PreparedStatement statementF1T3Avg = connection.prepareStatement(F1T3Avg);
            statementF1T3Avg.execute();
            PreparedStatement statementF2T1Avg = connection.prepareStatement(F2T1Avg);
            statementF2T1Avg.execute();
            PreparedStatement statementF2T2Avg = connection.prepareStatement(F2T2Avg);
            statementF2T2Avg.execute();
            PreparedStatement statementF2T3Avg = connection.prepareStatement(F2T3Avg);
            statementF2T3Avg.execute();
            PreparedStatement statementF3T1Avg = connection.prepareStatement(F3T1Avg);
            statementF3T1Avg.execute();
            PreparedStatement statementF3T2Avg = connection.prepareStatement(F3T2Avg);
            statementF3T2Avg.execute();
            PreparedStatement statementF3T3Avg = connection.prepareStatement(F3T3Avg);
            statementF3T3Avg.execute();
            PreparedStatement statementF4T1Avg = connection.prepareStatement(F4T1Avg);
            statementF4T1Avg.execute();
            PreparedStatement statementF4T2Avg = connection.prepareStatement(F4T2Avg);
            statementF4T2Avg.execute();
            PreparedStatement statementF4T3Avg = connection.prepareStatement(F4T3Avg);
            statementF4T3Avg.execute();

            //inserting into form 1 tables
            PreparedStatement statementF1T1Ex1 = connection.prepareStatement(F1T1Ex1);
            statementF1T1Ex1.execute();
            PreparedStatement statementF1T1Ex2 = connection.prepareStatement(F1T1Ex2);
            statementF1T1Ex2.execute();
            PreparedStatement statementF1T1Ex3 = connection.prepareStatement(F1T1Ex3);
            statementF1T1Ex3.execute();
            PreparedStatement statementF1T2Ex1 = connection.prepareStatement(F1T2Ex1);
            statementF1T2Ex1.execute();
            PreparedStatement statementF1T2Ex2 = connection.prepareStatement(F1T2Ex2);
            statementF1T2Ex2.execute();
            PreparedStatement statementF1T2Ex3 = connection.prepareStatement(F1T2Ex3);
            statementF1T2Ex3.execute();
            PreparedStatement statementF1T3Ex1 = connection.prepareStatement(F1T3Ex1);
            statementF1T3Ex1.execute();
            PreparedStatement statementF1T3Ex2 = connection.prepareStatement(F1T3Ex2);
            statementF1T3Ex2.execute();
            PreparedStatement statementF1T3Ex3 = connection.prepareStatement(F1T3Ex3);
            statementF1T3Ex3.execute();

            //inserting into form 2 tables
            PreparedStatement statementF2T1Ex1 = connection.prepareStatement(F2T1Ex1);
            statementF2T1Ex1.execute();
            PreparedStatement statementF2T1Ex2 = connection.prepareStatement(F2T1Ex2);
            statementF2T1Ex2.execute();
            PreparedStatement statementF2T1Ex3 = connection.prepareStatement(F2T1Ex3);
            statementF2T1Ex3.execute();
            PreparedStatement statementF2T2Ex1 = connection.prepareStatement(F2T2Ex1);
            statementF2T2Ex1.execute();
            PreparedStatement statementF2T2Ex2 = connection.prepareStatement(F2T2Ex2);
            statementF2T2Ex2.execute();
            PreparedStatement statementF2T2Ex3 = connection.prepareStatement(F2T2Ex3);
            statementF2T2Ex3.execute();
            PreparedStatement statementF2T3Ex1 = connection.prepareStatement(F2T3Ex1);
            statementF2T3Ex1.execute();
            PreparedStatement statementF2T3Ex2 = connection.prepareStatement(F2T3Ex2);
            statementF2T3Ex2.execute();
            PreparedStatement statementF2T3Ex3 = connection.prepareStatement(F2T3Ex3);
            statementF2T3Ex3.execute();

            //inserting into form 3 tables
            PreparedStatement statementF3T1Ex1 = connection.prepareStatement(F3T1Ex1);
            statementF3T1Ex1.execute();
            PreparedStatement statementF3T1Ex2 = connection.prepareStatement(F3T1Ex2);
            statementF3T1Ex2.execute();
            PreparedStatement statementF3T1Ex3 = connection.prepareStatement(F3T1Ex3);
            statementF3T1Ex3.execute();
            PreparedStatement statementF3T2Ex1 = connection.prepareStatement(F3T2Ex1);
            statementF3T2Ex1.execute();
            PreparedStatement statementF3T2Ex2 = connection.prepareStatement(F3T2Ex2);
            statementF3T2Ex2.execute();
            PreparedStatement statementF3T2Ex3 = connection.prepareStatement(F3T2Ex3);
            statementF3T2Ex3.execute();
            PreparedStatement statementF3T3Ex1 = connection.prepareStatement(F3T3Ex1);
            statementF3T3Ex1.execute();
            PreparedStatement statementF3T3Ex2 = connection.prepareStatement(F3T3Ex2);
            statementF3T3Ex2.execute();
            PreparedStatement statementF3T3Ex3 = connection.prepareStatement(F3T3Ex3);
            statementF3T3Ex3.execute();

            //inserting into form 4 tables
            PreparedStatement statementF4T1Ex1 = connection.prepareStatement(F4T1Ex1);
            statementF4T1Ex1.execute();
            PreparedStatement statementF4T1Ex2 = connection.prepareStatement(F4T1Ex2);
            statementF4T1Ex2.execute();
            PreparedStatement statementF4T1Ex3 = connection.prepareStatement(F4T1Ex3);
            statementF4T1Ex3.execute();
            PreparedStatement statementF4T2Ex1 = connection.prepareStatement(F4T2Ex1);
            statementF4T2Ex1.execute();
            PreparedStatement statementF4T2Ex2 = connection.prepareStatement(F4T2Ex2);
            statementF4T2Ex2.execute();
            PreparedStatement statementF4T2Ex3 = connection.prepareStatement(F4T2Ex3);
            statementF4T2Ex3.execute();
            PreparedStatement statementF4T3Ex1 = connection.prepareStatement(F4T3Ex1);
            statementF4T3Ex1.execute();
            PreparedStatement statementF4T3Ex2 = connection.prepareStatement(F4T3Ex2);
            statementF4T3Ex2.execute();
            PreparedStatement statementF4T3Ex3 = connection.prepareStatement(F4T3Ex3);
            statementF4T3Ex3.execute();

            //inserting into form 1 subject tables
            PreparedStatement statementF1Eng = connection.prepareStatement(EngF1);
            statementF1Eng.execute();
            PreparedStatement statementF1Kis = connection.prepareStatement(KisF1);
            statementF1Kis.execute();
            PreparedStatement statementF1Mat = connection.prepareStatement(MatF1);
            statementF1Mat.execute();
            PreparedStatement statementF1Chem = connection.prepareStatement(ChemF1);
            statementF1Chem.execute();
            PreparedStatement statementF1Bio = connection.prepareStatement(BioF1);
            statementF1Bio.execute();
            PreparedStatement statementF1Phy = connection.prepareStatement(PhyF1);
            statementF1Phy.execute();
            PreparedStatement statementF1Geo = connection.prepareStatement(GeoF1);
            statementF1Geo.execute();
            PreparedStatement statementF1Cre = connection.prepareStatement(CreF1);
            statementF1Cre.execute();
            PreparedStatement statementF1His= connection.prepareStatement(HisF1);
            statementF1His.execute();
            PreparedStatement statementF1Bus = connection.prepareStatement(BusF1);
            statementF1Bus.execute();
            PreparedStatement statementF1Agri= connection.prepareStatement(AgriF1);
            statementF1Agri.execute();

            //inserting into form 2 subject tables
            PreparedStatement statementF2Eng = connection.prepareStatement(EngF2);
            statementF2Eng.execute();
            PreparedStatement statementF2Kis = connection.prepareStatement(KisF2);
            statementF2Kis.execute();
            PreparedStatement statementF2Mat = connection.prepareStatement(MatF2);
            statementF2Mat.execute();
            PreparedStatement statementF2Chem = connection.prepareStatement(ChemF2);
            statementF2Chem.execute();
            PreparedStatement statementF2Bio = connection.prepareStatement(BioF2);
            statementF2Bio.execute();
            PreparedStatement statementF2Phy = connection.prepareStatement(PhyF2);
            statementF2Phy.execute();
            PreparedStatement statementF2Geo = connection.prepareStatement(GeoF2);
            statementF2Geo.execute();
            PreparedStatement statementF2Cre = connection.prepareStatement(CreF2);
            statementF2Cre.execute();
            PreparedStatement statementF2His= connection.prepareStatement(HisF2);
            statementF2His.execute();
            PreparedStatement statementF2Bus = connection.prepareStatement(BusF2);
            statementF2Bus.execute();
            PreparedStatement statementF2Agri= connection.prepareStatement(AgriF2);
            statementF2Agri.execute();

            //inserting into form 3 subject tables
            PreparedStatement statementF3Eng = connection.prepareStatement(EngF3);
            statementF3Eng.execute();
            PreparedStatement statementF3Kis = connection.prepareStatement(KisF3);
            statementF3Kis.execute();
            PreparedStatement statementF3Mat = connection.prepareStatement(MatF3);
            statementF3Mat.execute();
            PreparedStatement statementF3Chem = connection.prepareStatement(ChemF3);
            statementF3Chem.execute();
            PreparedStatement statementF3Bio = connection.prepareStatement(BioF3);
            statementF3Bio.execute();
            PreparedStatement statementF3Phy = connection.prepareStatement(PhyF3);
            statementF3Phy.execute();
            PreparedStatement statementF3Geo = connection.prepareStatement(GeoF3);
            statementF3Geo.execute();
            PreparedStatement statementF3Cre = connection.prepareStatement(CreF3);
            statementF3Cre.execute();
            PreparedStatement statementF3His= connection.prepareStatement(HisF3);
            statementF3His.execute();
            PreparedStatement statementF3Bus = connection.prepareStatement(BusF3);
            statementF3Bus.execute();
            PreparedStatement statementF3Agri= connection.prepareStatement(AgriF3);
            statementF3Agri.execute();

            //inserting into form 4 subject tables
            PreparedStatement statementF4Eng = connection.prepareStatement(EngF4);
            statementF4Eng.execute();
            PreparedStatement statementF4Kis = connection.prepareStatement(KisF4);
            statementF4Kis.execute();
            PreparedStatement statementF4Mat = connection.prepareStatement(MatF4);
            statementF4Mat.execute();
            PreparedStatement statementF4Chem = connection.prepareStatement(ChemF4);
            statementF4Chem.execute();
            PreparedStatement statementF4Bio = connection.prepareStatement(BioF4);
            statementF4Bio.execute();
            PreparedStatement statementF4Phy = connection.prepareStatement(PhyF4);
            statementF4Phy.execute();
            PreparedStatement statementF4Geo = connection.prepareStatement(GeoF4);
            statementF4Geo.execute();
            PreparedStatement statementF4Cre = connection.prepareStatement(CreF4);
            statementF4Cre.execute();
            PreparedStatement statementF4His= connection.prepareStatement(HisF4);
            statementF4His.execute();
            PreparedStatement statementF4Bus = connection.prepareStatement(BusF4);
            statementF4Bus.execute();
            PreparedStatement statementF4Agri= connection.prepareStatement(AgriF4);
            statementF4Agri.execute();

            //empty tbl_temporary
            PreparedStatement statementDelete = connection.prepareStatement(sqlDelete);
            statementDelete.execute();
            connection.close();

           // spalsh.close();
           // ps.show();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void updateStudent(){
         String getData = "SELECT * FROM tbl_update";
         String delete = "DELETE FROM tbl_update WHERE adm=?";
        String student = "UPDATE tbl_students SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=?,dob=? WHERE adm=?";
        String subject = "UPDATE tbl_subject_selection SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE adm=?";
        String F1T1Avg = "UPDATE tbl_f1_t1_avg SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE adm=?";
        String F1T2Avg = "UPDATE tbl_f1_t2_avg SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE adm=?";
        String F1T3Avg = "UPDATE tbl_f1_t3_avg SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE adm=?";
        String F2T1Avg = "UPDATE tbl_f2_t1_avg SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE adm=?";
        String F2T2Avg = "UPDATE tbl_f2_t2_avg SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE adm=?";
        String F2T3Avg = "UPDATE tbl_f2_t3_avg SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE adm=?";
        String F3T1Avg = "UPDATE tbl_f3_t1_avg SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE adm=?";
        String F3T2Avg = "UPDATE tbl_f3_t2_avg SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE adm=?";
        String F3T3Avg = "UPDATE tbl_f3_t3_avg SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE adm=?";
        String F4T1Avg = "UPDATE tbl_f4_t1_avg SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE adm=?";
        String F4T2Avg = "UPDATE tbl_f4_t2_avg SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE adm=?";
        String F4T3Avg = "UPDATE tbl_f4_t3_avg SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE adm=?";


        String F1T1Ex1 = "UPDATE tbl_f1_t1_ex1 SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE adm=?";
        String F1T1Ex2 = "UPDATE tbl_f1_t1_ex2 SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE adm=?";
        String F1T1Ex3 = "UPDATE tbl_f1_t1_ex3 SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE adm=?";
        String F1T2Ex1 = "UPDATE tbl_f1_t2_ex1 SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE adm=?";
        String F1T2Ex2 = "UPDATE tbl_f1_t2_ex2 SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE adm=?";
        String F1T2Ex3 = "UPDATE tbl_f1_t2_ex3 SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE adm=?";
        String F1T3Ex1 = "UPDATE tbl_f1_t3_ex1 SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE adm=?";
        String F1T3Ex2 = "UPDATE tbl_f1_t3_ex2 SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE adm=?";
        String F1T3Ex3 = "UPDATE tbl_f1_t3_ex3 SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE adm=?";

        String F2T1Ex1 = "UPDATE tbl_f2_t1_ex1 SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE adm=?";
        String F2T1Ex2 = "UPDATE tbl_f2_t1_ex2 SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE adm=?";
        String F2T1Ex3 = "UPDATE tbl_f2_t1_ex3 SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE adm=?";
        String F2T2Ex1 = "UPDATE tbl_f2_t2_ex1 SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE adm=?";
        String F2T2Ex2 = "UPDATE tbl_f2_t2_ex2 SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE adm=?";
        String F2T2Ex3 = "UPDATE tbl_f2_t2_ex3 SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE adm=?";
        String F2T3Ex1 = "UPDATE tbl_f2_t3_ex1 SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE adm=?";
        String F2T3Ex2 = "UPDATE tbl_f2_t3_ex2 SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE adm=?";
        String F2T3Ex3 = "UPDATE tbl_f2_t3_ex3 SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE adm=?";

        String F3T1Ex1 = "UPDATE tbl_f3_t1_ex1 SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE adm=?";
        String F3T1Ex2 = "UPDATE tbl_f3_t1_ex2 SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE adm=?";
        String F3T1Ex3 = "UPDATE tbl_f3_t1_ex3 SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE adm=?";
        String F3T2Ex1 = "UPDATE tbl_f3_t2_ex1 SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE adm=?";
        String F3T2Ex2 = "UPDATE tbl_f3_t2_ex2 SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE adm=?";
        String F3T2Ex3 = "UPDATE tbl_f3_t2_ex3 SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE adm=?";
        String F3T3Ex1 = "UPDATE tbl_f3_t3_ex1 SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE adm=?";
        String F3T3Ex2 = "UPDATE tbl_f3_t3_ex2 SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE adm=?";
        String F3T3Ex3 = "UPDATE tbl_f3_t3_ex3 SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE adm=?";

        String F4T1Ex1 = "UPDATE tbl_f4_t1_ex1 SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE adm=?";
        String F4T1Ex2 = "UPDATE tbl_f4_t1_ex2 SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE adm=?";
        String F4T1Ex3 = "UPDATE tbl_f4_t1_ex3 SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE adm=?";
        String F4T2Ex1 = "UPDATE tbl_f4_t2_ex1 SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE adm=?";
        String F4T2Ex2 = "UPDATE tbl_f4_t2_ex2 SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE adm=?";
        String F4T2Ex3 = "UPDATE tbl_f4_t2_ex3 SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE adm=?";
        String F4T3Ex1 = "UPDATE tbl_f4_t3_ex1 SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE adm=?";
        String F4T3Ex2 = "UPDATE tbl_f4_t3_ex2 SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE adm=?";
        String F4T3Ex3 = "UPDATE tbl_f4_t3_ex3 SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE adm=?";



        String EngF1 = "UPDATE tbl_f1_eng SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE adm=?";
        String KisF1 = "UPDATE tbl_f1_kis SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE adm=?";
        String MatF1 = "UPDATE tbl_f1_mat SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE adm=?";
        String BioF1 = "UPDATE tbl_f1_bio SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE adm=?";
        String PhyF1 = "UPDATE tbl_f1_phy SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE adm=?";
        String ChemF1 = "UPDATE tbl_f1_chem SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE adm=?";
        String GeoF1 = "UPDATE tbl_f1_geo SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE adm=?";
        String HisF1 = "UPDATE tbl_f1_his SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE adm=?";
        String CreF1 = "UPDATE tbl_f1_cre SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE adm=?";
        String AgriF1 = "UPDATE tbl_f1_agri SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE adm=?";
        String BusF1 = "UPDATE tbl_f1_bus SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE adm=?";
        String EngF2 = "UPDATE tbl_f2_eng SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE adm=?";
        String KisF2 = "UPDATE tbl_f2_kis SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE adm=?";
        String MatF2 = "UPDATE tbl_f2_mat SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE adm=?";
        String BioF2 = "UPDATE tbl_f2_bio SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE adm=?";
        String PhyF2 = "UPDATE tbl_f2_phy SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE adm=?";
        String ChemF2 = "UPDATE tbl_f2_chem SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE adm=?";
        String GeoF2 = "UPDATE tbl_f2_geo SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE adm=?";
        String HisF2 = "UPDATE tbl_f2_his SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE adm=?";
        String CreF2 = "UPDATE tbl_f2_cre SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE adm=?";
        String AgriF2 = "UPDATE tbl_f2_agri SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE adm=?";
        String BusF2 = "UPDATE tbl_f2_bus SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE adm=?";
        String EngF3 = "UPDATE tbl_f3_eng SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE adm=?";
        String KisF3 = "UPDATE tbl_f3_kis SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE adm=?";
        String MatF3 = "UPDATE tbl_f3_mat SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE adm=?";
        String BioF3 = "UPDATE tbl_f3_bio SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE adm=?";
        String PhyF3 = "UPDATE tbl_f3_phy SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE adm=?";
        String ChemF3 = "UPDATE tbl_f3_chem SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE adm=?";
        String GeoF3 = "UPDATE tbl_f3_geo SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE adm=?";
        String HisF3 = "UPDATE tbl_f3_his SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE adm=?";
        String CreF3 = "UPDATE tbl_f3_cre SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE adm=?";
        String AgriF3 = "UPDATE tbl_f3_agri SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE adm=?";
        String BusF3 = "UPDATE tbl_f3_bus SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE adm=?";
        String EngF4 = "UPDATE tbl_f4_eng SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE adm=?";
        String KisF4 = "UPDATE tbl_f4_kis SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE adm=?";
        String MatF4 = "UPDATE tbl_f4_mat SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE adm=?";
        String BioF4 = "UPDATE tbl_f4_bio SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE adm=?";
        String PhyF4 = "UPDATE tbl_f4_phy SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE adm=?";
        String ChemF4 = "UPDATE tbl_f4_chem SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE adm=?";
        String GeoF4 = "UPDATE tbl_f4_geo SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE adm=?";
        String HisF4 = "UPDATE tbl_f4_his SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE adm=?";
        String CreF4 = "UPDATE tbl_f4_cre SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE adm=?";
        String AgriF4 = "UPDATE tbl_f4_agri SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE adm=?";
        String BusF4 = "UPDATE tbl_f4_bus SET adm=?,fname=?,mname=?,lname=?,kcpe=?,class=? WHERE adm=?";

         try{
             Connection connection = Database.DBConnection.getConnection();
             ResultSet resultSet = connection.createStatement().executeQuery(getData);
             PreparedStatement statement  = connection.prepareStatement(delete);
             while (resultSet.next()) {
                 //Connection connection = Database.DBConnection.getConnection();
                 String admPrev = resultSet.getString(2);
                 String adm = resultSet.getString(3);
                 String fname = resultSet.getString(4);
                 String mname = resultSet.getString(5);
                 String lname = resultSet.getString(6);
                 String kcpe = resultSet.getString(7);
                 String classs = resultSet.getString(8);
                 String dob = resultSet.getString(9);

                 PreparedStatement statementStudent = connection.prepareStatement(student);
                 statementStudent.setString(1,adm);
                 statementStudent.setString(2,fname);
                 statementStudent.setString(3,mname);
                 statementStudent.setString(4,lname);
                 statementStudent.setString(5,kcpe);
                 statementStudent.setString(6,classs);
                 statementStudent.setString(7, dob);
                 statementStudent.setString(8,admPrev);

                 PreparedStatement statementSubjects = connection.prepareStatement(subject);
                 statementSubjects.setString(1,adm);
                 statementSubjects.setString(2,fname);
                 statementSubjects.setString(3,mname);
                 statementSubjects.setString(4,lname);
                 statementSubjects.setString(5,kcpe);
                 statementSubjects.setString(6,classs);
                 statementSubjects.setString(7,admPrev);

                 PreparedStatement statementF1T1Avg = connection.prepareStatement(F1T1Avg);
                 statementF1T1Avg.setString(1,adm);
                 statementF1T1Avg.setString(2,fname);
                 statementF1T1Avg.setString(3,mname);
                 statementF1T1Avg.setString(4,lname);
                 statementF1T1Avg.setString(5,kcpe);
                 statementF1T1Avg.setString(6,classs);
                 statementF1T1Avg.setString(7,admPrev);

                 PreparedStatement statementF1T2Avg = connection.prepareStatement(F1T2Avg);
                 statementF1T2Avg.setString(1,adm);
                 statementF1T2Avg.setString(2,fname);
                 statementF1T2Avg.setString(3,mname);
                 statementF1T2Avg.setString(4,lname);
                 statementF1T2Avg.setString(5,kcpe);
                 statementF1T2Avg.setString(6,classs);
                 statementF1T2Avg.setString(7,admPrev);

                 PreparedStatement statementF1T3Avg = connection.prepareStatement(F1T3Avg);
                 statementF1T3Avg.setString(1,adm);
                 statementF1T3Avg.setString(2,fname);
                 statementF1T3Avg.setString(3,mname);
                 statementF1T3Avg.setString(4,lname);
                 statementF1T3Avg.setString(5,kcpe);
                 statementF1T3Avg.setString(6,classs);
                 statementF1T3Avg.setString(7,admPrev);

                 PreparedStatement statementF2T1Avg = connection.prepareStatement(F2T1Avg);
                 statementF2T1Avg.setString(1,adm);
                 statementF2T1Avg.setString(2,fname);
                 statementF2T1Avg.setString(3,mname);
                 statementF2T1Avg.setString(4,lname);
                 statementF2T1Avg.setString(5,kcpe);
                 statementF2T1Avg.setString(6,classs);
                 statementF2T1Avg.setString(7,admPrev);

                 PreparedStatement statementF2T2Avg = connection.prepareStatement(F2T2Avg);
                 statementF2T2Avg.setString(1,adm);
                 statementF2T2Avg.setString(2,fname);
                 statementF2T2Avg.setString(3,mname);
                 statementF2T2Avg.setString(4,lname);
                 statementF2T2Avg.setString(5,kcpe);
                 statementF2T2Avg.setString(6,classs);
                 statementF2T2Avg.setString(7,admPrev);

                 PreparedStatement statementF2T3Avg = connection.prepareStatement(F2T3Avg);
                 statementF2T3Avg.setString(1,adm);
                 statementF2T3Avg.setString(2,fname);
                 statementF2T3Avg.setString(3,mname);
                 statementF2T3Avg.setString(4,lname);
                 statementF2T3Avg.setString(5,kcpe);
                 statementF2T3Avg.setString(6,classs);
                 statementF2T3Avg.setString(7,admPrev);

                 PreparedStatement statementF3T1Avg = connection.prepareStatement(F3T1Avg);
                 statementF3T1Avg.setString(1,adm);
                 statementF3T1Avg.setString(2,fname);
                 statementF3T1Avg.setString(3,mname);
                 statementF3T1Avg.setString(4,lname);
                 statementF3T1Avg.setString(5,kcpe);
                 statementF3T1Avg.setString(6,classs);
                 statementF3T1Avg.setString(7,admPrev);

                 PreparedStatement statementF3T2Avg = connection.prepareStatement(F3T2Avg);
                 statementF3T2Avg.setString(1,adm);
                 statementF3T2Avg.setString(2,fname);
                 statementF3T2Avg.setString(3,mname);
                 statementF3T2Avg.setString(4,lname);
                 statementF3T2Avg.setString(5,kcpe);
                 statementF3T2Avg.setString(6,classs);
                 statementF3T2Avg.setString(7,admPrev);

                 PreparedStatement statementF3T3Avg = connection.prepareStatement(F3T3Avg);
                 statementF3T3Avg.setString(1,adm);
                 statementF3T3Avg.setString(2,fname);
                 statementF3T3Avg.setString(3,mname);
                 statementF3T3Avg.setString(4,lname);
                 statementF3T3Avg.setString(5,kcpe);
                 statementF3T3Avg.setString(6,classs);
                 statementF3T3Avg.setString(7,admPrev);

                 PreparedStatement statementF4T1Avg = connection.prepareStatement(F4T1Avg);
                 statementF4T1Avg.setString(1,adm);
                 statementF4T1Avg.setString(2,fname);
                 statementF4T1Avg.setString(3,mname);
                 statementF4T1Avg.setString(4,lname);
                 statementF4T1Avg.setString(5,kcpe);
                 statementF4T1Avg.setString(6,classs);
                 statementF4T1Avg.setString(7,admPrev);

                 PreparedStatement statementF4T2Avg = connection.prepareStatement(F4T2Avg);
                 statementF4T2Avg.setString(1,adm);
                 statementF4T2Avg.setString(2,fname);
                 statementF4T2Avg.setString(3,mname);
                 statementF4T2Avg.setString(4,lname);
                 statementF4T2Avg.setString(5,kcpe);
                 statementF4T2Avg.setString(6,classs);
                 statementF4T2Avg.setString(7,admPrev);

                 PreparedStatement statementF4T3Avg = connection.prepareStatement(F4T3Avg);
                 statementF4T3Avg.setString(1,adm);
                 statementF4T3Avg.setString(2,fname);
                 statementF4T3Avg.setString(3,mname);
                 statementF4T3Avg.setString(4,lname);
                 statementF4T3Avg.setString(5,kcpe);
                 statementF4T3Avg.setString(6,classs);
                 statementF4T3Avg.setString(7,admPrev);


                 PreparedStatement statementF1T1Ex1 = connection.prepareStatement(F1T1Ex1);
                 statementF1T1Ex1.setString(1,adm);
                 statementF1T1Ex1.setString(2,fname);
                 statementF1T1Ex1.setString(3,mname);
                 statementF1T1Ex1.setString(4,lname);
                 statementF1T1Ex1.setString(5,kcpe);
                 statementF1T1Ex1.setString(6,classs);
                 statementF1T1Ex1.setString(7,admPrev);

                 PreparedStatement statementF1T1Ex2 = connection.prepareStatement(F1T1Ex2);
                 statementF1T1Ex2.setString(1,adm);
                 statementF1T1Ex2.setString(2,fname);
                 statementF1T1Ex2.setString(3,mname);
                 statementF1T1Ex2.setString(4,lname);
                 statementF1T1Ex2.setString(5,kcpe);
                 statementF1T1Ex2.setString(6,classs);
                 statementF1T1Ex2.setString(7,admPrev);

                 PreparedStatement statementF1T1Ex3 = connection.prepareStatement(F1T1Ex3);
                 statementF1T1Ex3.setString(1,adm);
                 statementF1T1Ex3.setString(2,fname);
                 statementF1T1Ex3.setString(3,mname);
                 statementF1T1Ex3.setString(4,lname);
                 statementF1T1Ex3.setString(5,kcpe);
                 statementF1T1Ex3.setString(6,classs);
                 statementF1T1Ex3.setString(7,admPrev);

                 PreparedStatement statementF1T2Ex1 = connection.prepareStatement(F1T2Ex1);
                 statementF1T2Ex1.setString(1,adm);
                 statementF1T2Ex1.setString(2,fname);
                 statementF1T2Ex1.setString(3,mname);
                 statementF1T2Ex1.setString(4,lname);
                 statementF1T2Ex1.setString(5,kcpe);
                 statementF1T2Ex1.setString(6,classs);
                 statementF1T2Ex1.setString(7,admPrev);

                 PreparedStatement statementF1T2Ex2 = connection.prepareStatement(F1T2Ex2);
                 statementF1T2Ex2.setString(1,adm);
                 statementF1T2Ex2.setString(2,fname);
                 statementF1T2Ex2.setString(3,mname);
                 statementF1T2Ex2.setString(4,lname);
                 statementF1T2Ex2.setString(5,kcpe);
                 statementF1T2Ex2.setString(6,classs);
                 statementF1T2Ex2.setString(7,admPrev);

                 PreparedStatement statementF1T2Ex3 = connection.prepareStatement(F1T2Ex3);
                 statementF1T2Ex3.setString(1,adm);
                 statementF1T2Ex3.setString(2,fname);
                 statementF1T2Ex3.setString(3,mname);
                 statementF1T2Ex3.setString(4,lname);
                 statementF1T2Ex3.setString(5,kcpe);
                 statementF1T2Ex3.setString(6,classs);
                 statementF1T2Ex3.setString(7,admPrev);

                 PreparedStatement statementF1T3Ex1 = connection.prepareStatement(F1T3Ex1);
                 statementF1T3Ex1.setString(1,adm);
                 statementF1T3Ex1.setString(2,fname);
                 statementF1T3Ex1.setString(3,mname);
                 statementF1T3Ex1.setString(4,lname);
                 statementF1T3Ex1.setString(5,kcpe);
                 statementF1T3Ex1.setString(6,classs);
                 statementF1T3Ex1.setString(7,admPrev);

                 PreparedStatement statementF1T3Ex2 = connection.prepareStatement(F1T3Ex2);
                 statementF1T3Ex2.setString(1,adm);
                 statementF1T3Ex2.setString(2,fname);
                 statementF1T3Ex2.setString(3,mname);
                 statementF1T3Ex2.setString(4,lname);
                 statementF1T3Ex2.setString(5,kcpe);
                 statementF1T3Ex2.setString(6,classs);
                 statementF1T3Ex2.setString(7,admPrev);

                 PreparedStatement statementF1T3Ex3 = connection.prepareStatement(F1T3Ex3);
                 statementF1T3Ex3.setString(1,adm);
                 statementF1T3Ex3.setString(2,fname);
                 statementF1T3Ex3.setString(3,mname);
                 statementF1T3Ex3.setString(4,lname);
                 statementF1T3Ex3.setString(5,kcpe);
                 statementF1T3Ex3.setString(6,classs);
                 statementF1T3Ex3.setString(7,admPrev);

                 PreparedStatement statementF2T1Ex1 = connection.prepareStatement(F2T1Ex1);
                 statementF2T1Ex1.setString(1,adm);
                 statementF2T1Ex1.setString(2,fname);
                 statementF2T1Ex1.setString(3,mname);
                 statementF2T1Ex1.setString(4,lname);
                 statementF2T1Ex1.setString(5,kcpe);
                 statementF2T1Ex1.setString(6,classs);
                 statementF2T1Ex1.setString(7,admPrev);

                 PreparedStatement statementF2T1Ex2 = connection.prepareStatement(F2T1Ex2);
                 statementF2T1Ex2.setString(1,adm);
                 statementF2T1Ex2.setString(2,fname);
                 statementF2T1Ex2.setString(3,mname);
                 statementF2T1Ex2.setString(4,lname);
                 statementF2T1Ex2.setString(5,kcpe);
                 statementF2T1Ex2.setString(6,classs);
                 statementF2T1Ex2.setString(7,admPrev);

                 PreparedStatement statementF2T1Ex3 = connection.prepareStatement(F2T1Ex3);
                 statementF2T1Ex3.setString(1,adm);
                 statementF2T1Ex3.setString(2,fname);
                 statementF2T1Ex3.setString(3,mname);
                 statementF2T1Ex3.setString(4,lname);
                 statementF2T1Ex3.setString(5,kcpe);
                 statementF2T1Ex3.setString(6,classs);
                 statementF2T1Ex3.setString(7,admPrev);

                 PreparedStatement statementF2T2Ex1 = connection.prepareStatement(F2T2Ex1);
                 statementF2T2Ex1.setString(1,adm);
                 statementF2T2Ex1.setString(2,fname);
                 statementF2T2Ex1.setString(3,mname);
                 statementF2T2Ex1.setString(4,lname);
                 statementF2T2Ex1.setString(5,kcpe);
                 statementF2T2Ex1.setString(6,classs);
                 statementF2T2Ex1.setString(7,admPrev);

                 PreparedStatement statementF2T2Ex2 = connection.prepareStatement(F2T2Ex2);
                 statementF2T2Ex2.setString(1,adm);
                 statementF2T2Ex2.setString(2,fname);
                 statementF2T2Ex2.setString(3,mname);
                 statementF2T2Ex2.setString(4,lname);
                 statementF2T2Ex2.setString(5,kcpe);
                 statementF2T2Ex2.setString(6,classs);
                 statementF2T2Ex2.setString(7,admPrev);

                 PreparedStatement statementF2T2Ex3 = connection.prepareStatement(F2T2Ex3);
                 statementF2T2Ex3.setString(1,adm);
                 statementF2T2Ex3.setString(2,fname);
                 statementF2T2Ex3.setString(3,mname);
                 statementF2T2Ex3.setString(4,lname);
                 statementF2T2Ex3.setString(5,kcpe);
                 statementF2T2Ex3.setString(6,classs);
                 statementF2T2Ex3.setString(7,admPrev);

                 PreparedStatement statementF2T3Ex1 = connection.prepareStatement(F2T3Ex1);
                 statementF2T3Ex1.setString(1,adm);
                 statementF2T3Ex1.setString(2,fname);
                 statementF2T3Ex1.setString(3,mname);
                 statementF2T3Ex1.setString(4,lname);
                 statementF2T3Ex1.setString(5,kcpe);
                 statementF2T3Ex1.setString(6,classs);
                 statementF2T3Ex1.setString(7,admPrev);

                 PreparedStatement statementF2T3Ex2 = connection.prepareStatement(F2T3Ex2);
                 statementF2T3Ex2.setString(1,adm);
                 statementF2T3Ex2.setString(2,fname);
                 statementF2T3Ex2.setString(3,mname);
                 statementF2T3Ex2.setString(4,lname);
                 statementF2T3Ex2.setString(5,kcpe);
                 statementF2T3Ex2.setString(6,classs);
                 statementF2T3Ex2.setString(7,admPrev);

                 PreparedStatement statementF2T3Ex3 = connection.prepareStatement(F2T3Ex3);
                 statementF2T3Ex3.setString(1,adm);
                 statementF2T3Ex3.setString(2,fname);
                 statementF2T3Ex3.setString(3,mname);
                 statementF2T3Ex3.setString(4,lname);
                 statementF2T3Ex3.setString(5,kcpe);
                 statementF2T3Ex3.setString(6,classs);
                 statementF2T3Ex3.setString(7,admPrev);

                 PreparedStatement statementF3T1Ex1 = connection.prepareStatement(F3T1Ex1);
                 statementF3T1Ex1.setString(1,adm);
                 statementF3T1Ex1.setString(2,fname);
                 statementF3T1Ex1.setString(3,mname);
                 statementF3T1Ex1.setString(4,lname);
                 statementF3T1Ex1.setString(5,kcpe);
                 statementF3T1Ex1.setString(6,classs);
                 statementF3T1Ex1.setString(7,admPrev);

                 PreparedStatement statementF3T1Ex2 = connection.prepareStatement(F3T1Ex2);
                 statementF3T1Ex2.setString(1,adm);
                 statementF3T1Ex2.setString(2,fname);
                 statementF3T1Ex2.setString(3,mname);
                 statementF3T1Ex2.setString(4,lname);
                 statementF3T1Ex2.setString(5,kcpe);
                 statementF3T1Ex2.setString(6,classs);
                 statementF3T1Ex2.setString(7,admPrev);

                 PreparedStatement statementF3T1Ex3 = connection.prepareStatement(F3T1Ex3);
                 statementF3T1Ex3.setString(1,adm);
                 statementF3T1Ex3.setString(2,fname);
                 statementF3T1Ex3.setString(3,mname);
                 statementF3T1Ex3.setString(4,lname);
                 statementF3T1Ex3.setString(5,kcpe);
                 statementF3T1Ex3.setString(6,classs);
                 statementF3T1Ex3.setString(7,admPrev);

                 PreparedStatement statementF3T2Ex1 = connection.prepareStatement(F3T2Ex1);
                 statementF3T2Ex1.setString(1,adm);
                 statementF3T2Ex1.setString(2,fname);
                 statementF3T2Ex1.setString(3,mname);
                 statementF3T2Ex1.setString(4,lname);
                 statementF3T2Ex1.setString(5,kcpe);
                 statementF3T2Ex1.setString(6,classs);
                 statementF3T2Ex1.setString(7,admPrev);

                 PreparedStatement statementF3T2Ex2 = connection.prepareStatement(F3T2Ex2);
                 statementF3T2Ex2.setString(1,adm);
                 statementF3T2Ex2.setString(2,fname);
                 statementF3T2Ex2.setString(3,mname);
                 statementF3T2Ex2.setString(4,lname);
                 statementF3T2Ex2.setString(5,kcpe);
                 statementF3T2Ex2.setString(6,classs);
                 statementF3T2Ex2.setString(7,admPrev);

                 PreparedStatement statementF3T2Ex3 = connection.prepareStatement(F3T2Ex3);
                 statementF3T2Ex3.setString(1,adm);
                 statementF3T2Ex3.setString(2,fname);
                 statementF3T2Ex3.setString(3,mname);
                 statementF3T2Ex3.setString(4,lname);
                 statementF3T2Ex3.setString(5,kcpe);
                 statementF3T2Ex3.setString(6,classs);
                 statementF3T2Ex3.setString(7,admPrev);

                 PreparedStatement statementF3T3Ex1 = connection.prepareStatement(F3T3Ex1);
                 statementF3T3Ex1.setString(1,adm);
                 statementF3T3Ex1.setString(2,fname);
                 statementF3T3Ex1.setString(3,mname);
                 statementF3T3Ex1.setString(4,lname);
                 statementF3T3Ex1.setString(5,kcpe);
                 statementF3T3Ex1.setString(6,classs);
                 statementF3T3Ex1.setString(7,admPrev);

                 PreparedStatement statementF3T3Ex2 = connection.prepareStatement(F3T3Ex2);
                 statementF3T3Ex2.setString(1,adm);
                 statementF3T3Ex2.setString(2,fname);
                 statementF3T3Ex2.setString(3,mname);
                 statementF3T3Ex2.setString(4,lname);
                 statementF3T3Ex2.setString(5,kcpe);
                 statementF3T3Ex2.setString(6,classs);
                 statementF3T3Ex2.setString(7,admPrev);

                 PreparedStatement statementF3T3Ex3 = connection.prepareStatement(F3T3Ex3);
                 statementF3T3Ex3.setString(1,adm);
                 statementF3T3Ex3.setString(2,fname);
                 statementF3T3Ex3.setString(3,mname);
                 statementF3T3Ex3.setString(4,lname);
                 statementF3T3Ex3.setString(5,kcpe);
                 statementF3T3Ex3.setString(6,classs);
                 statementF3T3Ex3.setString(7,admPrev);

                 PreparedStatement statementF4T1Ex1 = connection.prepareStatement(F4T1Ex1);
                 statementF4T1Ex1.setString(1,adm);
                 statementF4T1Ex1.setString(2,fname);
                 statementF4T1Ex1.setString(3,mname);
                 statementF4T1Ex1.setString(4,lname);
                 statementF4T1Ex1.setString(5,kcpe);
                 statementF4T1Ex1.setString(6,classs);
                 statementF4T1Ex1.setString(7,admPrev);

                 PreparedStatement statementF4T1Ex2 = connection.prepareStatement(F4T1Ex2);
                 statementF4T1Ex2.setString(1,adm);
                 statementF4T1Ex2.setString(2,fname);
                 statementF4T1Ex2.setString(3,mname);
                 statementF4T1Ex2.setString(4,lname);
                 statementF4T1Ex2.setString(5,kcpe);
                 statementF4T1Ex2.setString(6,classs);
                 statementF4T1Ex2.setString(7,admPrev);

                 PreparedStatement statementF4T1Ex3 = connection.prepareStatement(F4T1Ex3);
                 statementF4T1Ex3.setString(1,adm);
                 statementF4T1Ex3.setString(2,fname);
                 statementF4T1Ex3.setString(3,mname);
                 statementF4T1Ex3.setString(4,lname);
                 statementF4T1Ex3.setString(5,kcpe);
                 statementF4T1Ex3.setString(6,classs);
                 statementF4T1Ex3.setString(7,admPrev);

                 PreparedStatement statementF4T2Ex1 = connection.prepareStatement(F4T2Ex1);
                 statementF4T2Ex1.setString(1,adm);
                 statementF4T2Ex1.setString(2,fname);
                 statementF4T2Ex1.setString(3,mname);
                 statementF4T2Ex1.setString(4,lname);
                 statementF4T2Ex1.setString(5,kcpe);
                 statementF4T2Ex1.setString(6,classs);
                 statementF4T2Ex1.setString(7,admPrev);

                 PreparedStatement statementF4T2Ex2 = connection.prepareStatement(F4T2Ex2);
                 statementF4T2Ex2.setString(1,adm);
                 statementF4T2Ex2.setString(2,fname);
                 statementF4T2Ex2.setString(3,mname);
                 statementF4T2Ex2.setString(4,lname);
                 statementF4T2Ex2.setString(5,kcpe);
                 statementF4T2Ex2.setString(6,classs);
                 statementF4T2Ex2.setString(7,admPrev);

                 PreparedStatement statementF4T2Ex3 = connection.prepareStatement(F4T2Ex3);
                 statementF4T2Ex3.setString(1,adm);
                 statementF4T2Ex3.setString(2,fname);
                 statementF4T2Ex3.setString(3,mname);
                 statementF4T2Ex3.setString(4,lname);
                 statementF4T2Ex3.setString(5,kcpe);
                 statementF4T2Ex3.setString(6,classs);
                 statementF4T2Ex3.setString(7,admPrev);

                 PreparedStatement statementF4T3Ex1 = connection.prepareStatement(F4T3Ex1);
                 statementF4T3Ex1.setString(1,adm);
                 statementF4T3Ex1.setString(2,fname);
                 statementF4T3Ex1.setString(3,mname);
                 statementF4T3Ex1.setString(4,lname);
                 statementF4T3Ex1.setString(5,kcpe);
                 statementF4T3Ex1.setString(6,classs);
                 statementF4T3Ex1.setString(7,admPrev);

                 PreparedStatement statementF4T3Ex2 = connection.prepareStatement(F4T3Ex2);
                 statementF4T3Ex2.setString(1,adm);
                 statementF4T3Ex2.setString(2,fname);
                 statementF4T3Ex2.setString(3,mname);
                 statementF4T3Ex2.setString(4,lname);
                 statementF4T3Ex2.setString(5,kcpe);
                 statementF4T3Ex2.setString(6,classs);
                 statementF4T3Ex2.setString(7,admPrev);

                 PreparedStatement statementF4T3Ex3 = connection.prepareStatement(F4T3Ex3);
                 statementF4T3Ex3.setString(1,adm);
                 statementF4T3Ex3.setString(2,fname);
                 statementF4T3Ex3.setString(3,mname);
                 statementF4T3Ex3.setString(4,lname);
                 statementF4T3Ex3.setString(5,kcpe);
                 statementF4T3Ex3.setString(6,classs);
                 statementF4T3Ex3.setString(7,admPrev);


                 PreparedStatement statementEngF1 = connection.prepareStatement(EngF1);
                 statementEngF1.setString(1,adm);
                 statementEngF1.setString(2,fname);
                 statementEngF1.setString(3,mname);
                 statementEngF1.setString(4,lname);
                 statementEngF1.setString(5,kcpe);
                 statementEngF1.setString(6,classs);
                 statementEngF1.setString(7,admPrev);

                 PreparedStatement statementKisF1 = connection.prepareStatement(KisF1);
                 statementKisF1.setString(1,adm);
                 statementKisF1.setString(2,fname);
                 statementKisF1.setString(3,mname);
                 statementKisF1.setString(4,lname);
                 statementKisF1.setString(5,kcpe);
                 statementKisF1.setString(6,classs);
                 statementKisF1.setString(7,admPrev);

                 PreparedStatement statementMatF1 = connection.prepareStatement(MatF1);
                 statementMatF1.setString(1,adm);
                 statementMatF1.setString(2,fname);
                 statementMatF1.setString(3,mname);
                 statementMatF1.setString(4,lname);
                 statementMatF1.setString(5,kcpe);
                 statementMatF1.setString(6,classs);
                 statementMatF1.setString(7,admPrev);

                 PreparedStatement statementBioF1 = connection.prepareStatement(BioF1);
                 statementBioF1.setString(1,adm);
                 statementBioF1.setString(2,fname);
                 statementBioF1.setString(3,mname);
                 statementBioF1.setString(4,lname);
                 statementBioF1.setString(5,kcpe);
                 statementBioF1.setString(6,classs);
                 statementBioF1.setString(7,admPrev);

                 PreparedStatement statementPhyF1 = connection.prepareStatement(PhyF1);
                 statementPhyF1.setString(1,adm);
                 statementPhyF1.setString(2,fname);
                 statementPhyF1.setString(3,mname);
                 statementPhyF1.setString(4,lname);
                 statementPhyF1.setString(5,kcpe);
                 statementPhyF1.setString(6,classs);
                 statementPhyF1.setString(7,admPrev);

                 PreparedStatement statementChemF1 = connection.prepareStatement(ChemF1);
                 statementChemF1.setString(1,adm);
                 statementChemF1.setString(2,fname);
                 statementChemF1.setString(3,mname);
                 statementChemF1.setString(4,lname);
                 statementChemF1.setString(5,kcpe);
                 statementChemF1.setString(6,classs);
                 statementChemF1.setString(7,admPrev);

                 PreparedStatement statementGeoF1 = connection.prepareStatement(GeoF1);
                 statementGeoF1.setString(1,adm);
                 statementGeoF1.setString(2,fname);
                 statementGeoF1.setString(3,mname);
                 statementGeoF1.setString(4,lname);
                 statementGeoF1.setString(5,kcpe);
                 statementGeoF1.setString(6,classs);
                 statementGeoF1.setString(7,admPrev);

                 PreparedStatement statementHisF1 = connection.prepareStatement(HisF1);
                 statementHisF1.setString(1,adm);
                 statementHisF1.setString(2,fname);
                 statementHisF1.setString(3,mname);
                 statementHisF1.setString(4,lname);
                 statementHisF1.setString(5,kcpe);
                 statementHisF1.setString(6,classs);
                 statementHisF1.setString(7,admPrev);

                 PreparedStatement statementCreF1 = connection.prepareStatement(CreF1);
                 statementCreF1.setString(1,adm);
                 statementCreF1.setString(2,fname);
                 statementCreF1.setString(3,mname);
                 statementCreF1.setString(4,lname);
                 statementCreF1.setString(5,kcpe);
                 statementCreF1.setString(6,classs);
                 statementCreF1.setString(7,admPrev);

                 PreparedStatement statementAgriF1 = connection.prepareStatement(AgriF1);
                 statementAgriF1.setString(1,adm);
                 statementAgriF1.setString(2,fname);
                 statementAgriF1.setString(3,mname);
                 statementAgriF1.setString(4,lname);
                 statementAgriF1.setString(5,kcpe);
                 statementAgriF1.setString(6,classs);
                 statementAgriF1.setString(7,admPrev);

                 PreparedStatement statementBusF1 = connection.prepareStatement(BusF1);
                 statementBusF1.setString(1,adm);
                 statementBusF1.setString(2,fname);
                 statementBusF1.setString(3,mname);
                 statementBusF1.setString(4,lname);
                 statementBusF1.setString(5,kcpe);
                 statementBusF1.setString(6,classs);
                 statementBusF1.setString(7,admPrev);


                 PreparedStatement statementEngF2 = connection.prepareStatement(EngF2);
                 statementEngF2.setString(1,adm);
                 statementEngF2.setString(2,fname);
                 statementEngF2.setString(3,mname);
                 statementEngF2.setString(4,lname);
                 statementEngF2.setString(5,kcpe);
                 statementEngF2.setString(6,classs);
                 statementEngF2.setString(7,admPrev);

                 PreparedStatement statementKisF2 = connection.prepareStatement(KisF2);
                 statementKisF2.setString(1,adm);
                 statementKisF2.setString(2,fname);
                 statementKisF2.setString(3,mname);
                 statementKisF2.setString(4,lname);
                 statementKisF2.setString(5,kcpe);
                 statementKisF2.setString(6,classs);
                 statementKisF2.setString(7,admPrev);

                 PreparedStatement statementMatF2 = connection.prepareStatement(MatF2);
                 statementMatF2.setString(1,adm);
                 statementMatF2.setString(2,fname);
                 statementMatF2.setString(3,mname);
                 statementMatF2.setString(4,lname);
                 statementMatF2.setString(5,kcpe);
                 statementMatF2.setString(6,classs);
                 statementMatF2.setString(7,admPrev);

                 PreparedStatement statementBioF2 = connection.prepareStatement(BioF2);
                 statementBioF2.setString(1,adm);
                 statementBioF2.setString(2,fname);
                 statementBioF2.setString(3,mname);
                 statementBioF2.setString(4,lname);
                 statementBioF2.setString(5,kcpe);
                 statementBioF2.setString(6,classs);
                 statementBioF2.setString(7,admPrev);

                 PreparedStatement statementPhyF2 = connection.prepareStatement(PhyF2);
                 statementPhyF2.setString(1,adm);
                 statementPhyF2.setString(2,fname);
                 statementPhyF2.setString(3,mname);
                 statementPhyF2.setString(4,lname);
                 statementPhyF2.setString(5,kcpe);
                 statementPhyF2.setString(6,classs);
                 statementPhyF2.setString(7,admPrev);

                 PreparedStatement statementChemF2 = connection.prepareStatement(ChemF2);
                 statementChemF2.setString(1,adm);
                 statementChemF2.setString(2,fname);
                 statementChemF2.setString(3,mname);
                 statementChemF2.setString(4,lname);
                 statementChemF2.setString(5,kcpe);
                 statementChemF2.setString(6,classs);
                 statementChemF2.setString(7,admPrev);

                 PreparedStatement statementGeoF2 = connection.prepareStatement(GeoF2);
                 statementGeoF2.setString(1,adm);
                 statementGeoF2.setString(2,fname);
                 statementGeoF2.setString(3,mname);
                 statementGeoF2.setString(4,lname);
                 statementGeoF2.setString(5,kcpe);
                 statementGeoF2.setString(6,classs);
                 statementGeoF2.setString(7,admPrev);

                 PreparedStatement statementHisF2 = connection.prepareStatement(HisF2);
                 statementHisF2.setString(1,adm);
                 statementHisF2.setString(2,fname);
                 statementHisF2.setString(3,mname);
                 statementHisF2.setString(4,lname);
                 statementHisF2.setString(5,kcpe);
                 statementHisF2.setString(6,classs);
                 statementHisF2.setString(7,admPrev);

                 PreparedStatement statementCreF2 = connection.prepareStatement(CreF2);
                 statementCreF2.setString(1,adm);
                 statementCreF2.setString(2,fname);
                 statementCreF2.setString(3,mname);
                 statementCreF2.setString(4,lname);
                 statementCreF2.setString(5,kcpe);
                 statementCreF2.setString(6,classs);
                 statementCreF2.setString(7,admPrev);

                 PreparedStatement statementAgriF2 = connection.prepareStatement(AgriF2);
                 statementAgriF2.setString(1,adm);
                 statementAgriF2.setString(2,fname);
                 statementAgriF2.setString(3,mname);
                 statementAgriF2.setString(4,lname);
                 statementAgriF2.setString(5,kcpe);
                 statementAgriF2.setString(6,classs);
                 statementAgriF2.setString(7,admPrev);

                 PreparedStatement statementBusF2 = connection.prepareStatement(BusF2);
                 statementBusF2.setString(1,adm);
                 statementBusF2.setString(2,fname);
                 statementBusF2.setString(3,mname);
                 statementBusF2.setString(4,lname);
                 statementBusF2.setString(5,kcpe);
                 statementBusF2.setString(6,classs);
                 statementBusF2.setString(7,admPrev);


                 PreparedStatement statementEngF3 = connection.prepareStatement(EngF3);
                 statementEngF3.setString(1,adm);
                 statementEngF3.setString(2,fname);
                 statementEngF3.setString(3,mname);
                 statementEngF3.setString(4,lname);
                 statementEngF3.setString(5,kcpe);
                 statementEngF3.setString(6,classs);
                 statementEngF3.setString(7,admPrev);

                 PreparedStatement statementKisF3 = connection.prepareStatement(KisF3);
                 statementKisF3.setString(1,adm);
                 statementKisF3.setString(2,fname);
                 statementKisF3.setString(3,mname);
                 statementKisF3.setString(4,lname);
                 statementKisF3.setString(5,kcpe);
                 statementKisF3.setString(6,classs);
                 statementKisF3.setString(7,admPrev);

                 PreparedStatement statementMatF3 = connection.prepareStatement(MatF3);
                 statementMatF3.setString(1,adm);
                 statementMatF3.setString(2,fname);
                 statementMatF3.setString(3,mname);
                 statementMatF3.setString(4,lname);
                 statementMatF3.setString(5,kcpe);
                 statementMatF3.setString(6,classs);
                 statementMatF3.setString(7,admPrev);

                 PreparedStatement statementBioF3 = connection.prepareStatement(BioF3);
                 statementBioF3.setString(1,adm);
                 statementBioF3.setString(2,fname);
                 statementBioF3.setString(3,mname);
                 statementBioF3.setString(4,lname);
                 statementBioF3.setString(5,kcpe);
                 statementBioF3.setString(6,classs);
                 statementBioF3.setString(7,admPrev);

                 PreparedStatement statementPhyF3 = connection.prepareStatement(PhyF3);
                 statementPhyF3.setString(1,adm);
                 statementPhyF3.setString(2,fname);
                 statementPhyF3.setString(3,mname);
                 statementPhyF3.setString(4,lname);
                 statementPhyF3.setString(5,kcpe);
                 statementPhyF3.setString(6,classs);
                 statementPhyF3.setString(7,admPrev);

                 PreparedStatement statementChemF3 = connection.prepareStatement(ChemF3);
                 statementChemF3.setString(1,adm);
                 statementChemF3.setString(2,fname);
                 statementChemF3.setString(3,mname);
                 statementChemF3.setString(4,lname);
                 statementChemF3.setString(5,kcpe);
                 statementChemF3.setString(6,classs);
                 statementChemF3.setString(7,admPrev);

                 PreparedStatement statementGeoF3 = connection.prepareStatement(GeoF3);
                 statementGeoF3.setString(1,adm);
                 statementGeoF3.setString(2,fname);
                 statementGeoF3.setString(3,mname);
                 statementGeoF3.setString(4,lname);
                 statementGeoF3.setString(5,kcpe);
                 statementGeoF3.setString(6,classs);
                 statementGeoF3.setString(7,admPrev);

                 PreparedStatement statementHisF3 = connection.prepareStatement(HisF3);
                 statementHisF3.setString(1,adm);
                 statementHisF3.setString(2,fname);
                 statementHisF3.setString(3,mname);
                 statementHisF3.setString(4,lname);
                 statementHisF3.setString(5,kcpe);
                 statementHisF3.setString(6,classs);
                 statementHisF3.setString(7,admPrev);

                 PreparedStatement statementCreF3 = connection.prepareStatement(CreF3);
                 statementCreF3.setString(1,adm);
                 statementCreF3.setString(2,fname);
                 statementCreF3.setString(3,mname);
                 statementCreF3.setString(4,lname);
                 statementCreF3.setString(5,kcpe);
                 statementCreF3.setString(6,classs);
                 statementCreF3.setString(7,admPrev);

                 PreparedStatement statementAgriF3 = connection.prepareStatement(AgriF3);
                 statementAgriF3.setString(1,adm);
                 statementAgriF3.setString(2,fname);
                 statementAgriF3.setString(3,mname);
                 statementAgriF3.setString(4,lname);
                 statementAgriF3.setString(5,kcpe);
                 statementAgriF3.setString(6,classs);
                 statementAgriF3.setString(7,admPrev);

                 PreparedStatement statementBusF3 = connection.prepareStatement(BusF3);
                 statementBusF3.setString(1,adm);
                 statementBusF3.setString(2,fname);
                 statementBusF3.setString(3,mname);
                 statementBusF3.setString(4,lname);
                 statementBusF3.setString(5,kcpe);
                 statementBusF3.setString(6,classs);
                 statementBusF3.setString(7,admPrev);


                 PreparedStatement statementEngF4 = connection.prepareStatement(EngF4);
                 statementEngF4.setString(1,adm);
                 statementEngF4.setString(2,fname);
                 statementEngF4.setString(3,mname);
                 statementEngF4.setString(4,lname);
                 statementEngF4.setString(5,kcpe);
                 statementEngF4.setString(6,classs);
                 statementEngF4.setString(7,admPrev);

                 PreparedStatement statementKisF4 = connection.prepareStatement(KisF4);
                 statementKisF4.setString(1,adm);
                 statementKisF4.setString(2,fname);
                 statementKisF4.setString(3,mname);
                 statementKisF4.setString(4,lname);
                 statementKisF4.setString(5,kcpe);
                 statementKisF4.setString(6,classs);
                 statementKisF4.setString(7,admPrev);

                 PreparedStatement statementMatF4 = connection.prepareStatement(MatF4);
                 statementMatF4.setString(1,adm);
                 statementMatF4.setString(2,fname);
                 statementMatF4.setString(3,mname);
                 statementMatF4.setString(4,lname);
                 statementMatF4.setString(5,kcpe);
                 statementMatF4.setString(6,classs);
                 statementMatF4.setString(7,admPrev);

                 PreparedStatement statementBioF4 = connection.prepareStatement(BioF4);
                 statementBioF4.setString(1,adm);
                 statementBioF4.setString(2,fname);
                 statementBioF4.setString(3,mname);
                 statementBioF4.setString(4,lname);
                 statementBioF4.setString(5,kcpe);
                 statementBioF4.setString(6,classs);
                 statementBioF4.setString(7,admPrev);

                 PreparedStatement statementPhyF4 = connection.prepareStatement(PhyF4);
                 statementPhyF4.setString(1,adm);
                 statementPhyF4.setString(2,fname);
                 statementPhyF4.setString(3,mname);
                 statementPhyF4.setString(4,lname);
                 statementPhyF4.setString(5,kcpe);
                 statementPhyF4.setString(6,classs);
                 statementPhyF4.setString(7,admPrev);

                 PreparedStatement statementChemF4 = connection.prepareStatement(ChemF4);
                 statementChemF4.setString(1,adm);
                 statementChemF4.setString(2,fname);
                 statementChemF4.setString(3,mname);
                 statementChemF4.setString(4,lname);
                 statementChemF4.setString(5,kcpe);
                 statementChemF4.setString(6,classs);
                 statementChemF4.setString(7,admPrev);

                 PreparedStatement statementGeoF4 = connection.prepareStatement(GeoF4);
                 statementGeoF4.setString(1,adm);
                 statementGeoF4.setString(2,fname);
                 statementGeoF4.setString(3,mname);
                 statementGeoF4.setString(4,lname);
                 statementGeoF4.setString(5,kcpe);
                 statementGeoF4.setString(6,classs);
                 statementGeoF4.setString(7,admPrev);

                 PreparedStatement statementHisF4 = connection.prepareStatement(HisF4);
                 statementHisF4.setString(1,adm);
                 statementHisF4.setString(2,fname);
                 statementHisF4.setString(3,mname);
                 statementHisF4.setString(4,lname);
                 statementHisF4.setString(5,kcpe);
                 statementHisF4.setString(6,classs);
                 statementHisF4.setString(7,admPrev);

                 PreparedStatement statementCreF4 = connection.prepareStatement(CreF4);
                 statementCreF4.setString(1,adm);
                 statementCreF4.setString(2,fname);
                 statementCreF4.setString(3,mname);
                 statementCreF4.setString(4,lname);
                 statementCreF4.setString(5,kcpe);
                 statementCreF4.setString(6,classs);
                 statementCreF4.setString(7,admPrev);

                 PreparedStatement statementAgriF4 = connection.prepareStatement(AgriF4);
                 statementAgriF4.setString(1,adm);
                 statementAgriF4.setString(2,fname);
                 statementAgriF4.setString(3,mname);
                 statementAgriF4.setString(4,lname);
                 statementAgriF4.setString(5,kcpe);
                 statementAgriF4.setString(6,classs);
                 statementAgriF4.setString(7,admPrev);

                 PreparedStatement statementBusF4 = connection.prepareStatement(BusF4);
                 statementBusF4.setString(1,adm);
                 statementBusF4.setString(2,fname);
                 statementBusF4.setString(3,mname);
                 statementBusF4.setString(4,lname);
                 statementBusF4.setString(5,kcpe);
                 statementBusF4.setString(6,classs);
                 statementBusF4.setString(7,admPrev);

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
                 
                 System.out.print("Student updated");
                 System.out.println(resultSet.getString(4));
                 statement.setString(1,adm);
                 statement.execute();
                 System.out.println("deleted... ");
//                 connection.wait(5000);
                 //connection.close();
             }
             connection.close();
         }catch (Exception e){
             e.printStackTrace();
         }
    }

}
