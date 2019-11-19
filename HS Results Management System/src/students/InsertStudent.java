package students;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static alert.AlertBox.infoBox;
import static alert.AlertBox.infoBoxError;

public class InsertStudent implements Runnable {
    
    public static String adm;
    public static String fname;
    public static String mname;
    public static String lname;
    public static String kcpe;
    public static String classs;
    public static String dob;

    @Override
    public void run() {
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
            
                try {
                    Connection connection = Database.DBConnection.getConnection();

                    PreparedStatement statementStudent = connection.prepareStatement(students);
                    statementStudent.setString(1, adm);
                    statementStudent.setString(2, fname);
                    statementStudent.setString(3, mname);
                    statementStudent.setString(4, lname);
                    statementStudent.setString(5, kcpe);
                    statementStudent.setString(6, classs);
                    statementStudent.setString(7, dob);

                    PreparedStatement statementSubjects = connection.prepareStatement(subject);
                    statementSubjects.setString(1, adm);
                    statementSubjects.setString(2, fname);
                    statementSubjects.setString(3, mname);
                    statementSubjects.setString(4, lname);
                    statementSubjects.setString(5, kcpe);
                    statementSubjects.setString(6, classs);

                    PreparedStatement statementF1T1Avg = connection.prepareStatement(F1T1Avg);
                    statementF1T1Avg.setString(1, adm);
                    statementF1T1Avg.setString(2, fname);
                    statementF1T1Avg.setString(3, mname);
                    statementF1T1Avg.setString(4, lname);
                    statementF1T1Avg.setString(5, kcpe);
                    statementF1T1Avg.setString(6, classs);

                    PreparedStatement statementF1T2Avg = connection.prepareStatement(F1T2Avg);
                    statementF1T2Avg.setString(1, adm);
                    statementF1T2Avg.setString(2, fname);
                    statementF1T2Avg.setString(3, mname);
                    statementF1T2Avg.setString(4, lname);
                    statementF1T2Avg.setString(5, kcpe);
                    statementF1T2Avg.setString(6, classs);

                    PreparedStatement statementF1T3Avg = connection.prepareStatement(F1T3Avg);
                    statementF1T3Avg.setString(1, adm);
                    statementF1T3Avg.setString(2, fname);
                    statementF1T3Avg.setString(3, mname);
                    statementF1T3Avg.setString(4, lname);
                    statementF1T3Avg.setString(5, kcpe);
                    statementF1T3Avg.setString(6, classs);

                    PreparedStatement statementF2T1Avg = connection.prepareStatement(F2T1Avg);
                    statementF2T1Avg.setString(1, adm);
                    statementF2T1Avg.setString(2, fname);
                    statementF2T1Avg.setString(3, mname);
                    statementF2T1Avg.setString(4, lname);
                    statementF2T1Avg.setString(5, kcpe);
                    statementF2T1Avg.setString(6, classs);

                    PreparedStatement statementF2T2Avg = connection.prepareStatement(F2T2Avg);
                    statementF2T2Avg.setString(1, adm);
                    statementF2T2Avg.setString(2, fname);
                    statementF2T2Avg.setString(3, mname);
                    statementF2T2Avg.setString(4, lname);
                    statementF2T2Avg.setString(5, kcpe);
                    statementF2T2Avg.setString(6, classs);

                    PreparedStatement statementF2T3Avg = connection.prepareStatement(F2T3Avg);
                    statementF2T3Avg.setString(1, adm);
                    statementF2T3Avg.setString(2, fname);
                    statementF2T3Avg.setString(3, mname);
                    statementF2T3Avg.setString(4, lname);
                    statementF2T3Avg.setString(5, kcpe);
                    statementF2T3Avg.setString(6, classs);

                    PreparedStatement statementF3T1Avg = connection.prepareStatement(F3T1Avg);
                    statementF3T1Avg.setString(1, adm);
                    statementF3T1Avg.setString(2, fname);
                    statementF3T1Avg.setString(3, mname);
                    statementF3T1Avg.setString(4, lname);
                    statementF3T1Avg.setString(5, kcpe);
                    statementF3T1Avg.setString(6, classs);

                    PreparedStatement statementF3T2Avg = connection.prepareStatement(F3T2Avg);
                    statementF3T2Avg.setString(1, adm);
                    statementF3T2Avg.setString(2, fname);
                    statementF3T2Avg.setString(3, mname);
                    statementF3T2Avg.setString(4, lname);
                    statementF3T2Avg.setString(5, kcpe);
                    statementF3T2Avg.setString(6, classs);

                    PreparedStatement statementF3T3Avg = connection.prepareStatement(F3T3Avg);
                    statementF3T3Avg.setString(1, adm);
                    statementF3T3Avg.setString(2, fname);
                    statementF3T3Avg.setString(3, mname);
                    statementF3T3Avg.setString(4, lname);
                    statementF3T3Avg.setString(5, kcpe);
                    statementF3T3Avg.setString(6, classs);

                    PreparedStatement statementF4T1Avg = connection.prepareStatement(F4T1Avg);
                    statementF4T1Avg.setString(1, adm);
                    statementF4T1Avg.setString(2, fname);
                    statementF4T1Avg.setString(3, mname);
                    statementF4T1Avg.setString(4, lname);
                    statementF4T1Avg.setString(5, kcpe);
                    statementF4T1Avg.setString(6, classs);

                    PreparedStatement statementF4T2Avg = connection.prepareStatement(F4T2Avg);
                    statementF4T2Avg.setString(1, adm);
                    statementF4T2Avg.setString(2, fname);
                    statementF4T2Avg.setString(3, mname);
                    statementF4T2Avg.setString(4, lname);
                    statementF4T2Avg.setString(5, kcpe);
                    statementF4T2Avg.setString(6, classs);

                    PreparedStatement statementF4T3Avg = connection.prepareStatement(F4T3Avg);
                    statementF4T3Avg.setString(1, adm);
                    statementF4T3Avg.setString(2, fname);
                    statementF4T3Avg.setString(3, mname);
                    statementF4T3Avg.setString(4, lname);
                    statementF4T3Avg.setString(5, kcpe);
                    statementF4T3Avg.setString(6, classs);


                    PreparedStatement statementF1T1Ex1 = connection.prepareStatement(F1T1Ex1);
                    statementF1T1Ex1.setString(1, adm);
                    statementF1T1Ex1.setString(2, fname);
                    statementF1T1Ex1.setString(3, mname);
                    statementF1T1Ex1.setString(4, lname);
                    statementF1T1Ex1.setString(5, kcpe);
                    statementF1T1Ex1.setString(6, classs);

                    PreparedStatement statementF1T1Ex2 = connection.prepareStatement(F1T1Ex2);
                    statementF1T1Ex2.setString(1, adm);
                    statementF1T1Ex2.setString(2, fname);
                    statementF1T1Ex2.setString(3, mname);
                    statementF1T1Ex2.setString(4, lname);
                    statementF1T1Ex2.setString(5, kcpe);
                    statementF1T1Ex2.setString(6, classs);

                    PreparedStatement statementF1T1Ex3 = connection.prepareStatement(F1T1Ex3);
                    statementF1T1Ex3.setString(1, adm);
                    statementF1T1Ex3.setString(2, fname);
                    statementF1T1Ex3.setString(3, mname);
                    statementF1T1Ex3.setString(4, lname);
                    statementF1T1Ex3.setString(5, kcpe);
                    statementF1T1Ex3.setString(6, classs);

                    PreparedStatement statementF1T2Ex1 = connection.prepareStatement(F1T2Ex1);
                    statementF1T2Ex1.setString(1, adm);
                    statementF1T2Ex1.setString(2, fname);
                    statementF1T2Ex1.setString(3, mname);
                    statementF1T2Ex1.setString(4, lname);
                    statementF1T2Ex1.setString(5, kcpe);
                    statementF1T2Ex1.setString(6, classs);

                    PreparedStatement statementF1T2Ex2 = connection.prepareStatement(F1T2Ex2);
                    statementF1T2Ex2.setString(1, adm);
                    statementF1T2Ex2.setString(2, fname);
                    statementF1T2Ex2.setString(3, mname);
                    statementF1T2Ex2.setString(4, lname);
                    statementF1T2Ex2.setString(5, kcpe);
                    statementF1T2Ex2.setString(6, classs);

                    PreparedStatement statementF1T2Ex3 = connection.prepareStatement(F1T2Ex3);
                    statementF1T2Ex3.setString(1, adm);
                    statementF1T2Ex3.setString(2, fname);
                    statementF1T2Ex3.setString(3, mname);
                    statementF1T2Ex3.setString(4, lname);
                    statementF1T2Ex3.setString(5, kcpe);
                    statementF1T2Ex3.setString(6, classs);

                    PreparedStatement statementF1T3Ex1 = connection.prepareStatement(F1T3Ex1);
                    statementF1T3Ex1.setString(1, adm);
                    statementF1T3Ex1.setString(2, fname);
                    statementF1T3Ex1.setString(3, mname);
                    statementF1T3Ex1.setString(4, lname);
                    statementF1T3Ex1.setString(5, kcpe);
                    statementF1T3Ex1.setString(6, classs);

                    PreparedStatement statementF1T3Ex2 = connection.prepareStatement(F1T3Ex2);
                    statementF1T3Ex2.setString(1, adm);
                    statementF1T3Ex2.setString(2, fname);
                    statementF1T3Ex2.setString(3, mname);
                    statementF1T3Ex2.setString(4, lname);
                    statementF1T3Ex2.setString(5, kcpe);
                    statementF1T3Ex2.setString(6, classs);

                    PreparedStatement statementF1T3Ex3 = connection.prepareStatement(F1T3Ex3);
                    statementF1T3Ex3.setString(1, adm);
                    statementF1T3Ex3.setString(2, fname);
                    statementF1T3Ex3.setString(3, mname);
                    statementF1T3Ex3.setString(4, lname);
                    statementF1T3Ex3.setString(5, kcpe);
                    statementF1T3Ex3.setString(6, classs);

                    PreparedStatement statementF2T1Ex1 = connection.prepareStatement(F2T1Ex1);
                    statementF2T1Ex1.setString(1, adm);
                    statementF2T1Ex1.setString(2, fname);
                    statementF2T1Ex1.setString(3, mname);
                    statementF2T1Ex1.setString(4, lname);
                    statementF2T1Ex1.setString(5, kcpe);
                    statementF2T1Ex1.setString(6, classs);

                    PreparedStatement statementF2T1Ex2 = connection.prepareStatement(F2T1Ex2);
                    statementF2T1Ex2.setString(1, adm);
                    statementF2T1Ex2.setString(2, fname);
                    statementF2T1Ex2.setString(3, mname);
                    statementF2T1Ex2.setString(4, lname);
                    statementF2T1Ex2.setString(5, kcpe);
                    statementF2T1Ex2.setString(6, classs);

                    PreparedStatement statementF2T1Ex3 = connection.prepareStatement(F2T1Ex3);
                    statementF2T1Ex3.setString(1, adm);
                    statementF2T1Ex3.setString(2, fname);
                    statementF2T1Ex3.setString(3, mname);
                    statementF2T1Ex3.setString(4, lname);
                    statementF2T1Ex3.setString(5, kcpe);
                    statementF2T1Ex3.setString(6, classs);

                    PreparedStatement statementF2T2Ex1 = connection.prepareStatement(F2T2Ex1);
                    statementF2T2Ex1.setString(1, adm);
                    statementF2T2Ex1.setString(2, fname);
                    statementF2T2Ex1.setString(3, mname);
                    statementF2T2Ex1.setString(4, lname);
                    statementF2T2Ex1.setString(5, kcpe);
                    statementF2T2Ex1.setString(6, classs);

                    PreparedStatement statementF2T2Ex2 = connection.prepareStatement(F2T2Ex2);
                    statementF2T2Ex2.setString(1, adm);
                    statementF2T2Ex2.setString(2, fname);
                    statementF2T2Ex2.setString(3, mname);
                    statementF2T2Ex2.setString(4, lname);
                    statementF2T2Ex2.setString(5, kcpe);
                    statementF2T2Ex2.setString(6, classs);

                    PreparedStatement statementF2T2Ex3 = connection.prepareStatement(F2T2Ex3);
                    statementF2T2Ex3.setString(1, adm);
                    statementF2T2Ex3.setString(2, fname);
                    statementF2T2Ex3.setString(3, mname);
                    statementF2T2Ex3.setString(4, lname);
                    statementF2T2Ex3.setString(5, kcpe);
                    statementF2T2Ex3.setString(6, classs);

                    PreparedStatement statementF2T3Ex1 = connection.prepareStatement(F2T3Ex1);
                    statementF2T3Ex1.setString(1, adm);
                    statementF2T3Ex1.setString(2, fname);
                    statementF2T3Ex1.setString(3, mname);
                    statementF2T3Ex1.setString(4, lname);
                    statementF2T3Ex1.setString(5, kcpe);
                    statementF2T3Ex1.setString(6, classs);

                    PreparedStatement statementF2T3Ex2 = connection.prepareStatement(F2T3Ex2);
                    statementF2T3Ex2.setString(1, adm);
                    statementF2T3Ex2.setString(2, fname);
                    statementF2T3Ex2.setString(3, mname);
                    statementF2T3Ex2.setString(4, lname);
                    statementF2T3Ex2.setString(5, kcpe);
                    statementF2T3Ex2.setString(6, classs);

                    PreparedStatement statementF2T3Ex3 = connection.prepareStatement(F2T3Ex3);
                    statementF2T3Ex3.setString(1, adm);
                    statementF2T3Ex3.setString(2, fname);
                    statementF2T3Ex3.setString(3, mname);
                    statementF2T3Ex3.setString(4, lname);
                    statementF2T3Ex3.setString(5, kcpe);
                    statementF2T3Ex3.setString(6, classs);

                    PreparedStatement statementF3T1Ex1 = connection.prepareStatement(F3T1Ex1);
                    statementF3T1Ex1.setString(1, adm);
                    statementF3T1Ex1.setString(2, fname);
                    statementF3T1Ex1.setString(3, mname);
                    statementF3T1Ex1.setString(4, lname);
                    statementF3T1Ex1.setString(5, kcpe);
                    statementF3T1Ex1.setString(6, classs);

                    PreparedStatement statementF3T1Ex2 = connection.prepareStatement(F3T1Ex2);
                    statementF3T1Ex2.setString(1, adm);
                    statementF3T1Ex2.setString(2, fname);
                    statementF3T1Ex2.setString(3, mname);
                    statementF3T1Ex2.setString(4, lname);
                    statementF3T1Ex2.setString(5, kcpe);
                    statementF3T1Ex2.setString(6, classs);

                    PreparedStatement statementF3T1Ex3 = connection.prepareStatement(F3T1Ex3);
                    statementF3T1Ex3.setString(1, adm);
                    statementF3T1Ex3.setString(2, fname);
                    statementF3T1Ex3.setString(3, mname);
                    statementF3T1Ex3.setString(4, lname);
                    statementF3T1Ex3.setString(5, kcpe);
                    statementF3T1Ex3.setString(6, classs);

                    PreparedStatement statementF3T2Ex1 = connection.prepareStatement(F3T2Ex1);
                    statementF3T2Ex1.setString(1, adm);
                    statementF3T2Ex1.setString(2, fname);
                    statementF3T2Ex1.setString(3, mname);
                    statementF3T2Ex1.setString(4, lname);
                    statementF3T2Ex1.setString(5, kcpe);
                    statementF3T2Ex1.setString(6, classs);

                    PreparedStatement statementF3T2Ex2 = connection.prepareStatement(F3T2Ex2);
                    statementF3T2Ex2.setString(1, adm);
                    statementF3T2Ex2.setString(2, fname);
                    statementF3T2Ex2.setString(3, mname);
                    statementF3T2Ex2.setString(4, lname);
                    statementF3T2Ex2.setString(5, kcpe);
                    statementF3T2Ex2.setString(6, classs);

                    PreparedStatement statementF3T2Ex3 = connection.prepareStatement(F3T2Ex3);
                    statementF3T2Ex3.setString(1, adm);
                    statementF3T2Ex3.setString(2, fname);
                    statementF3T2Ex3.setString(3, mname);
                    statementF3T2Ex3.setString(4, lname);
                    statementF3T2Ex3.setString(5, kcpe);
                    statementF3T2Ex3.setString(6, classs);

                    PreparedStatement statementF3T3Ex1 = connection.prepareStatement(F3T3Ex1);
                    statementF3T3Ex1.setString(1, adm);
                    statementF3T3Ex1.setString(2, fname);
                    statementF3T3Ex1.setString(3, mname);
                    statementF3T3Ex1.setString(4, lname);
                    statementF3T3Ex1.setString(5, kcpe);
                    statementF3T3Ex1.setString(6, classs);

                    PreparedStatement statementF3T3Ex2 = connection.prepareStatement(F3T3Ex2);
                    statementF3T3Ex2.setString(1, adm);
                    statementF3T3Ex2.setString(2, fname);
                    statementF3T3Ex2.setString(3, mname);
                    statementF3T3Ex2.setString(4, lname);
                    statementF3T3Ex2.setString(5, kcpe);
                    statementF3T3Ex2.setString(6, classs);

                    PreparedStatement statementF3T3Ex3 = connection.prepareStatement(F3T3Ex3);
                    statementF3T3Ex3.setString(1, adm);
                    statementF3T3Ex3.setString(2, fname);
                    statementF3T3Ex3.setString(3, mname);
                    statementF3T3Ex3.setString(4, lname);
                    statementF3T3Ex3.setString(5, kcpe);
                    statementF3T3Ex3.setString(6, classs);

                    PreparedStatement statementF4T1Ex1 = connection.prepareStatement(F4T1Ex1);
                    statementF4T1Ex1.setString(1, adm);
                    statementF4T1Ex1.setString(2, fname);
                    statementF4T1Ex1.setString(3, mname);
                    statementF4T1Ex1.setString(4, lname);
                    statementF4T1Ex1.setString(5, kcpe);
                    statementF4T1Ex1.setString(6, classs);

                    PreparedStatement statementF4T1Ex2 = connection.prepareStatement(F4T1Ex2);
                    statementF4T1Ex2.setString(1, adm);
                    statementF4T1Ex2.setString(2, fname);
                    statementF4T1Ex2.setString(3, mname);
                    statementF4T1Ex2.setString(4, lname);
                    statementF4T1Ex2.setString(5, kcpe);
                    statementF4T1Ex2.setString(6, classs);

                    PreparedStatement statementF4T1Ex3 = connection.prepareStatement(F4T1Ex3);
                    statementF4T1Ex3.setString(1, adm);
                    statementF4T1Ex3.setString(2, fname);
                    statementF4T1Ex3.setString(3, mname);
                    statementF4T1Ex3.setString(4, lname);
                    statementF4T1Ex3.setString(5, kcpe);
                    statementF4T1Ex3.setString(6, classs);

                    PreparedStatement statementF4T2Ex1 = connection.prepareStatement(F4T2Ex1);
                    statementF4T2Ex1.setString(1, adm);
                    statementF4T2Ex1.setString(2, fname);
                    statementF4T2Ex1.setString(3, mname);
                    statementF4T2Ex1.setString(4, lname);
                    statementF4T2Ex1.setString(5, kcpe);
                    statementF4T2Ex1.setString(6, classs);

                    PreparedStatement statementF4T2Ex2 = connection.prepareStatement(F4T2Ex2);
                    statementF4T2Ex2.setString(1, adm);
                    statementF4T2Ex2.setString(2, fname);
                    statementF4T2Ex2.setString(3, mname);
                    statementF4T2Ex2.setString(4, lname);
                    statementF4T2Ex2.setString(5, kcpe);
                    statementF4T2Ex2.setString(6, classs);

                    PreparedStatement statementF4T2Ex3 = connection.prepareStatement(F4T2Ex3);
                    statementF4T2Ex3.setString(1, adm);
                    statementF4T2Ex3.setString(2, fname);
                    statementF4T2Ex3.setString(3, mname);
                    statementF4T2Ex3.setString(4, lname);
                    statementF4T2Ex3.setString(5, kcpe);
                    statementF4T2Ex3.setString(6, classs);

                    PreparedStatement statementF4T3Ex1 = connection.prepareStatement(F4T3Ex1);
                    statementF4T3Ex1.setString(1, adm);
                    statementF4T3Ex1.setString(2, fname);
                    statementF4T3Ex1.setString(3, mname);
                    statementF4T3Ex1.setString(4, lname);
                    statementF4T3Ex1.setString(5, kcpe);
                    statementF4T3Ex1.setString(6, classs);

                    PreparedStatement statementF4T3Ex2 = connection.prepareStatement(F4T3Ex2);
                    statementF4T3Ex2.setString(1, adm);
                    statementF4T3Ex2.setString(2, fname);
                    statementF4T3Ex2.setString(3, mname);
                    statementF4T3Ex2.setString(4, lname);
                    statementF4T3Ex2.setString(5, kcpe);
                    statementF4T3Ex2.setString(6, classs);

                    PreparedStatement statementF4T3Ex3 = connection.prepareStatement(F4T3Ex3);
                    statementF4T3Ex3.setString(1, adm);
                    statementF4T3Ex3.setString(2, fname);
                    statementF4T3Ex3.setString(3, mname);
                    statementF4T3Ex3.setString(4, lname);
                    statementF4T3Ex3.setString(5, kcpe);
                    statementF4T3Ex3.setString(6, classs);


                    PreparedStatement statementEngF1 = connection.prepareStatement(EngF1);
                    statementEngF1.setString(1, adm);
                    statementEngF1.setString(2, fname);
                    statementEngF1.setString(3, mname);
                    statementEngF1.setString(4, lname);
                    statementEngF1.setString(5, kcpe);
                    statementEngF1.setString(6, classs);

                    PreparedStatement statementKisF1 = connection.prepareStatement(KisF1);
                    statementKisF1.setString(1, adm);
                    statementKisF1.setString(2, fname);
                    statementKisF1.setString(3, mname);
                    statementKisF1.setString(4, lname);
                    statementKisF1.setString(5, kcpe);
                    statementKisF1.setString(6, classs);

                    PreparedStatement statementMatF1 = connection.prepareStatement(MatF1);
                    statementMatF1.setString(1, adm);
                    statementMatF1.setString(2, fname);
                    statementMatF1.setString(3, mname);
                    statementMatF1.setString(4, lname);
                    statementMatF1.setString(5, kcpe);
                    statementMatF1.setString(6, classs);

                    PreparedStatement statementBioF1 = connection.prepareStatement(BioF1);
                    statementBioF1.setString(1, adm);
                    statementBioF1.setString(2, fname);
                    statementBioF1.setString(3, mname);
                    statementBioF1.setString(4, lname);
                    statementBioF1.setString(5, kcpe);
                    statementBioF1.setString(6, classs);

                    PreparedStatement statementPhyF1 = connection.prepareStatement(PhyF1);
                    statementPhyF1.setString(1, adm);
                    statementPhyF1.setString(2, fname);
                    statementPhyF1.setString(3, mname);
                    statementPhyF1.setString(4, lname);
                    statementPhyF1.setString(5, kcpe);
                    statementPhyF1.setString(6, classs);

                    PreparedStatement statementChemF1 = connection.prepareStatement(ChemF1);
                    statementChemF1.setString(1, adm);
                    statementChemF1.setString(2, fname);
                    statementChemF1.setString(3, mname);
                    statementChemF1.setString(4, lname);
                    statementChemF1.setString(5, kcpe);
                    statementChemF1.setString(6, classs);

                    PreparedStatement statementGeoF1 = connection.prepareStatement(GeoF1);
                    statementGeoF1.setString(1, adm);
                    statementGeoF1.setString(2, fname);
                    statementGeoF1.setString(3, mname);
                    statementGeoF1.setString(4, lname);
                    statementGeoF1.setString(5, kcpe);
                    statementGeoF1.setString(6, classs);

                    PreparedStatement statementHisF1 = connection.prepareStatement(HisF1);
                    statementHisF1.setString(1, adm);
                    statementHisF1.setString(2, fname);
                    statementHisF1.setString(3, mname);
                    statementHisF1.setString(4, lname);
                    statementHisF1.setString(5, kcpe);
                    statementHisF1.setString(6, classs);

                    PreparedStatement statementCreF1 = connection.prepareStatement(CreF1);
                    statementCreF1.setString(1, adm);
                    statementCreF1.setString(2, fname);
                    statementCreF1.setString(3, mname);
                    statementCreF1.setString(4, lname);
                    statementCreF1.setString(5, kcpe);
                    statementCreF1.setString(6, classs);

                    PreparedStatement statementAgriF1 = connection.prepareStatement(AgriF1);
                    statementAgriF1.setString(1, adm);
                    statementAgriF1.setString(2, fname);
                    statementAgriF1.setString(3, mname);
                    statementAgriF1.setString(4, lname);
                    statementAgriF1.setString(5, kcpe);
                    statementAgriF1.setString(6, classs);

                    PreparedStatement statementBusF1 = connection.prepareStatement(BusF1);
                    statementBusF1.setString(1, adm);
                    statementBusF1.setString(2, fname);
                    statementBusF1.setString(3, mname);
                    statementBusF1.setString(4, lname);
                    statementBusF1.setString(5, kcpe);
                    statementBusF1.setString(6, classs);


                    PreparedStatement statementEngF2 = connection.prepareStatement(EngF2);
                    statementEngF2.setString(1, adm);
                    statementEngF2.setString(2, fname);
                    statementEngF2.setString(3, mname);
                    statementEngF2.setString(4, lname);
                    statementEngF2.setString(5, kcpe);
                    statementEngF2.setString(6, classs);

                    PreparedStatement statementKisF2 = connection.prepareStatement(KisF2);
                    statementKisF2.setString(1, adm);
                    statementKisF2.setString(2, fname);
                    statementKisF2.setString(3, mname);
                    statementKisF2.setString(4, lname);
                    statementKisF2.setString(5, kcpe);
                    statementKisF2.setString(6, classs);

                    PreparedStatement statementMatF2 = connection.prepareStatement(MatF2);
                    statementMatF2.setString(1, adm);
                    statementMatF2.setString(2, fname);
                    statementMatF2.setString(3, mname);
                    statementMatF2.setString(4, lname);
                    statementMatF2.setString(5, kcpe);
                    statementMatF2.setString(6, classs);

                    PreparedStatement statementBioF2 = connection.prepareStatement(BioF2);
                    statementBioF2.setString(1, adm);
                    statementBioF2.setString(2, fname);
                    statementBioF2.setString(3, mname);
                    statementBioF2.setString(4, lname);
                    statementBioF2.setString(5, kcpe);
                    statementBioF2.setString(6, classs);

                    PreparedStatement statementPhyF2 = connection.prepareStatement(PhyF2);
                    statementPhyF2.setString(1, adm);
                    statementPhyF2.setString(2, fname);
                    statementPhyF2.setString(3, mname);
                    statementPhyF2.setString(4, lname);
                    statementPhyF2.setString(5, kcpe);
                    statementPhyF2.setString(6, classs);

                    PreparedStatement statementChemF2 = connection.prepareStatement(ChemF2);
                    statementChemF2.setString(1, adm);
                    statementChemF2.setString(2, fname);
                    statementChemF2.setString(3, mname);
                    statementChemF2.setString(4, lname);
                    statementChemF2.setString(5, kcpe);
                    statementChemF2.setString(6, classs);

                    PreparedStatement statementGeoF2 = connection.prepareStatement(GeoF2);
                    statementGeoF2.setString(1, adm);
                    statementGeoF2.setString(2, fname);
                    statementGeoF2.setString(3, mname);
                    statementGeoF2.setString(4, lname);
                    statementGeoF2.setString(5, kcpe);
                    statementGeoF2.setString(6, classs);

                    PreparedStatement statementHisF2 = connection.prepareStatement(HisF2);
                    statementHisF2.setString(1, adm);
                    statementHisF2.setString(2, fname);
                    statementHisF2.setString(3, mname);
                    statementHisF2.setString(4, lname);
                    statementHisF2.setString(5, kcpe);
                    statementHisF2.setString(6, classs);

                    PreparedStatement statementCreF2 = connection.prepareStatement(CreF2);
                    statementCreF2.setString(1, adm);
                    statementCreF2.setString(2, fname);
                    statementCreF2.setString(3, mname);
                    statementCreF2.setString(4, lname);
                    statementCreF2.setString(5, kcpe);
                    statementCreF2.setString(6, classs);

                    PreparedStatement statementAgriF2 = connection.prepareStatement(AgriF2);
                    statementAgriF2.setString(1, adm);
                    statementAgriF2.setString(2, fname);
                    statementAgriF2.setString(3, mname);
                    statementAgriF2.setString(4, lname);
                    statementAgriF2.setString(5, kcpe);
                    statementAgriF2.setString(6, classs);

                    PreparedStatement statementBusF2 = connection.prepareStatement(BusF2);
                    statementBusF2.setString(1, adm);
                    statementBusF2.setString(2, fname);
                    statementBusF2.setString(3, mname);
                    statementBusF2.setString(4, lname);
                    statementBusF2.setString(5, kcpe);
                    statementBusF2.setString(6, classs);


                    PreparedStatement statementEngF3 = connection.prepareStatement(EngF3);
                    statementEngF3.setString(1, adm);
                    statementEngF3.setString(2, fname);
                    statementEngF3.setString(3, mname);
                    statementEngF3.setString(4, lname);
                    statementEngF3.setString(5, kcpe);
                    statementEngF3.setString(6, classs);

                    PreparedStatement statementKisF3 = connection.prepareStatement(KisF3);
                    statementKisF3.setString(1, adm);
                    statementKisF3.setString(2, fname);
                    statementKisF3.setString(3, mname);
                    statementKisF3.setString(4, lname);
                    statementKisF3.setString(5, kcpe);
                    statementKisF3.setString(6, classs);

                    PreparedStatement statementMatF3 = connection.prepareStatement(MatF3);
                    statementMatF3.setString(1, adm);
                    statementMatF3.setString(2, fname);
                    statementMatF3.setString(3, mname);
                    statementMatF3.setString(4, lname);
                    statementMatF3.setString(5, kcpe);
                    statementMatF3.setString(6, classs);

                    PreparedStatement statementBioF3 = connection.prepareStatement(BioF3);
                    statementBioF3.setString(1, adm);
                    statementBioF3.setString(2, fname);
                    statementBioF3.setString(3, mname);
                    statementBioF3.setString(4, lname);
                    statementBioF3.setString(5, kcpe);
                    statementBioF3.setString(6, classs);

                    PreparedStatement statementPhyF3 = connection.prepareStatement(PhyF3);
                    statementPhyF3.setString(1, adm);
                    statementPhyF3.setString(2, fname);
                    statementPhyF3.setString(3, mname);
                    statementPhyF3.setString(4, lname);
                    statementPhyF3.setString(5, kcpe);
                    statementPhyF3.setString(6, classs);

                    PreparedStatement statementChemF3 = connection.prepareStatement(ChemF3);
                    statementChemF3.setString(1, adm);
                    statementChemF3.setString(2, fname);
                    statementChemF3.setString(3, mname);
                    statementChemF3.setString(4, lname);
                    statementChemF3.setString(5, kcpe);
                    statementChemF3.setString(6, classs);

                    PreparedStatement statementGeoF3 = connection.prepareStatement(GeoF3);
                    statementGeoF3.setString(1, adm);
                    statementGeoF3.setString(2, fname);
                    statementGeoF3.setString(3, mname);
                    statementGeoF3.setString(4, lname);
                    statementGeoF3.setString(5, kcpe);
                    statementGeoF3.setString(6, classs);

                    PreparedStatement statementHisF3 = connection.prepareStatement(HisF3);
                    statementHisF3.setString(1, adm);
                    statementHisF3.setString(2, fname);
                    statementHisF3.setString(3, mname);
                    statementHisF3.setString(4, lname);
                    statementHisF3.setString(5, kcpe);
                    statementHisF3.setString(6, classs);

                    PreparedStatement statementCreF3 = connection.prepareStatement(CreF3);
                    statementCreF3.setString(1, adm);
                    statementCreF3.setString(2, fname);
                    statementCreF3.setString(3, mname);
                    statementCreF3.setString(4, lname);
                    statementCreF3.setString(5, kcpe);
                    statementCreF3.setString(6, classs);

                    PreparedStatement statementAgriF3 = connection.prepareStatement(AgriF3);
                    statementAgriF3.setString(1, adm);
                    statementAgriF3.setString(2, fname);
                    statementAgriF3.setString(3, mname);
                    statementAgriF3.setString(4, lname);
                    statementAgriF3.setString(5, kcpe);
                    statementAgriF3.setString(6, classs);

                    PreparedStatement statementBusF3 = connection.prepareStatement(BusF3);
                    statementBusF3.setString(1, adm);
                    statementBusF3.setString(2, fname);
                    statementBusF3.setString(3, mname);
                    statementBusF3.setString(4, lname);
                    statementBusF3.setString(5, kcpe);
                    statementBusF3.setString(6, classs);


                    PreparedStatement statementEngF4 = connection.prepareStatement(EngF4);
                    statementEngF4.setString(1, adm);
                    statementEngF4.setString(2, fname);
                    statementEngF4.setString(3, mname);
                    statementEngF4.setString(4, lname);
                    statementEngF4.setString(5, kcpe);
                    statementEngF4.setString(6, classs);

                    PreparedStatement statementKisF4 = connection.prepareStatement(KisF4);
                    statementKisF4.setString(1, adm);
                    statementKisF4.setString(2, fname);
                    statementKisF4.setString(3, mname);
                    statementKisF4.setString(4, lname);
                    statementKisF4.setString(5, kcpe);
                    statementKisF4.setString(6, classs);

                    PreparedStatement statementMatF4 = connection.prepareStatement(MatF4);
                    statementMatF4.setString(1, adm);
                    statementMatF4.setString(2, fname);
                    statementMatF4.setString(3, mname);
                    statementMatF4.setString(4, lname);
                    statementMatF4.setString(5, kcpe);
                    statementMatF4.setString(6, classs);

                    PreparedStatement statementBioF4 = connection.prepareStatement(BioF4);
                    statementBioF4.setString(1, adm);
                    statementBioF4.setString(2, fname);
                    statementBioF4.setString(3, mname);
                    statementBioF4.setString(4, lname);
                    statementBioF4.setString(5, kcpe);
                    statementBioF4.setString(6, classs);

                    PreparedStatement statementPhyF4 = connection.prepareStatement(PhyF4);
                    statementPhyF4.setString(1, adm);
                    statementPhyF4.setString(2, fname);
                    statementPhyF4.setString(3, mname);
                    statementPhyF4.setString(4, lname);
                    statementPhyF4.setString(5, kcpe);
                    statementPhyF4.setString(6, classs);

                    PreparedStatement statementChemF4 = connection.prepareStatement(ChemF4);
                    statementChemF4.setString(1, adm);
                    statementChemF4.setString(2, fname);
                    statementChemF4.setString(3, mname);
                    statementChemF4.setString(4, lname);
                    statementChemF4.setString(5, kcpe);
                    statementChemF4.setString(6, classs);

                    PreparedStatement statementGeoF4 = connection.prepareStatement(GeoF4);
                    statementGeoF4.setString(1, adm);
                    statementGeoF4.setString(2, fname);
                    statementGeoF4.setString(3, mname);
                    statementGeoF4.setString(4, lname);
                    statementGeoF4.setString(5, kcpe);
                    statementGeoF4.setString(6, classs);

                    PreparedStatement statementHisF4 = connection.prepareStatement(HisF4);
                    statementHisF4.setString(1, adm);
                    statementHisF4.setString(2, fname);
                    statementHisF4.setString(3, mname);
                    statementHisF4.setString(4, lname);
                    statementHisF4.setString(5, kcpe);
                    statementHisF4.setString(6, classs);

                    PreparedStatement statementCreF4 = connection.prepareStatement(CreF4);
                    statementCreF4.setString(1, adm);
                    statementCreF4.setString(2, fname);
                    statementCreF4.setString(3, mname);
                    statementCreF4.setString(4, lname);
                    statementCreF4.setString(5, kcpe);
                    statementCreF4.setString(6, classs);

                    PreparedStatement statementAgriF4 = connection.prepareStatement(AgriF4);
                    statementAgriF4.setString(1, adm);
                    statementAgriF4.setString(2, fname);
                    statementAgriF4.setString(3, mname);
                    statementAgriF4.setString(4, lname);
                    statementAgriF4.setString(5, kcpe);
                    statementAgriF4.setString(6, classs);

                    PreparedStatement statementBusF4 = connection.prepareStatement(BusF4);
                    statementBusF4.setString(1, adm);
                    statementBusF4.setString(2, fname);
                    statementBusF4.setString(3, mname);
                    statementBusF4.setString(4, lname);
                    statementBusF4.setString(5, kcpe);
                    statementBusF4.setString(6, classs);


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
                    
                    connection.close();
                    
                    //System.out.print("Student added successfully");
                    //infoBox("Student added successfully","Success",null);
                    System.out.println("Student added successfully");


                } catch (Exception e) {
                    e.printStackTrace();
                }
            
        
    }
}
