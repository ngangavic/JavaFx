package students;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class deleteStudents implements Runnable {
    
    public static  String toRemove;

    @Override
    public void run() {
            //public void deleteStudents(){
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
                //tableStudentsData toRemove = (tableStudentsData) tableStudents.getItems().get(getTableRow().getIndex());
                statementStudents.setString(1,toRemove);
                statementSubject.setString(1,toRemove);
                statementF1T1AVG.setString(1,toRemove);
                statementF1T2AVG.setString(1,toRemove);
                statementF1T3AVG.setString(1,toRemove);
                statementF2T1AVG.setString(1,toRemove);
                statementF2T2AVG.setString(1,toRemove);
                statementF2T3AVG.setString(1,toRemove);
                statementF3T1AVG.setString(1,toRemove);
                statementF3T2AVG.setString(1,toRemove);
                statementF3T3AVG.setString(1,toRemove);
                statementF4T1AVG.setString(1,toRemove);
                statementF4T2AVG.setString(1,toRemove);
                statementF4T3AVG.setString(1,toRemove);

                statementF1T1Ex1.setString(1,toRemove);
                statementF1T1Ex2.setString(1,toRemove);
                statementF1T1Ex3.setString(1,toRemove);
                statementF1T2Ex1.setString(1,toRemove);
                statementF1T2Ex2.setString(1,toRemove);
                statementF1T2Ex3.setString(1,toRemove);
                statementF1T3Ex1.setString(1,toRemove);
                statementF1T3Ex2.setString(1,toRemove);
                statementF1T3Ex3.setString(1,toRemove);///syart
                statementF2T1Ex1.setString(1,toRemove);
                statementF2T1Ex2.setString(1,toRemove);
                statementF2T1Ex3.setString(1,toRemove);
                statementF2T2Ex1.setString(1,toRemove);
                statementF2T2Ex2.setString(1,toRemove);
                statementF2T2Ex3.setString(1,toRemove);
                statementF2T3Ex1.setString(1,toRemove);
                statementF2T3Ex2.setString(1,toRemove);
                statementF2T3Ex3.setString(1,toRemove);//start
                statementF3T1Ex1.setString(1,toRemove);
                statementF3T1Ex2.setString(1,toRemove);
                statementF3T1Ex3.setString(1,toRemove);
                statementF3T2Ex1.setString(1,toRemove);
                statementF3T2Ex2.setString(1,toRemove);
                statementF3T2Ex3.setString(1,toRemove);
                statementF3T3Ex1.setString(1,toRemove);
                statementF3T3Ex2.setString(1,toRemove);
                statementF3T3Ex3.setString(1,toRemove);//start
                statementF4T1Ex1.setString(1,toRemove);
                statementF4T1Ex2.setString(1,toRemove);
                statementF4T1Ex3.setString(1,toRemove);
                statementF4T2Ex1.setString(1,toRemove);
                statementF4T2Ex2.setString(1,toRemove);
                statementF4T2Ex3.setString(1,toRemove);
                statementF4T3Ex1.setString(1,toRemove);
                statementF4T3Ex2.setString(1,toRemove);
                statementF4T3Ex3.setString(1,toRemove);

                statementEngF1.setString(1,toRemove);
                statementKisF1.setString(1,toRemove);
                statementMatF1.setString(1,toRemove);
                statementBioF1.setString(1,toRemove);
                statementChemF1.setString(1,toRemove);
                statementPhyF1.setString(1,toRemove);
                statementGeoF1.setString(1,toRemove);
                statementHisF1.setString(1,toRemove);
                statementCreF1.setString(1,toRemove);
                statementBusF1.setString(1,toRemove);
                statementAgriF1.setString(1,toRemove);

                statementEngF2.setString(1,toRemove);
                statementKisF2.setString(1,toRemove);
                statementMatF2.setString(1,toRemove);
                statementBioF2.setString(1,toRemove);
                statementChemF2.setString(1,toRemove);
                statementPhyF2.setString(1,toRemove);
                statementGeoF2.setString(1,toRemove);
                statementHisF2.setString(1,toRemove);
                statementCreF2.setString(1,toRemove);
                statementBusF2.setString(1,toRemove);
                statementAgriF2.setString(1,toRemove);

                statementEngF3.setString(1,toRemove);
                statementKisF3.setString(1,toRemove);
                statementMatF3.setString(1,toRemove);
                statementBioF3.setString(1,toRemove);
                statementChemF3.setString(1,toRemove);
                statementPhyF3.setString(1,toRemove);
                statementGeoF3.setString(1,toRemove);
                statementHisF3.setString(1,toRemove);
                statementCreF3.setString(1,toRemove);
                statementBusF3.setString(1,toRemove);
                statementAgriF3.setString(1,toRemove);

                statementEngF4.setString(1,toRemove);
                statementKisF4.setString(1,toRemove);
                statementMatF4.setString(1,toRemove);
                statementBioF4.setString(1,toRemove);
                statementChemF4.setString(1,toRemove);
                statementPhyF4.setString(1,toRemove);
                statementGeoF4.setString(1,toRemove);
                statementHisF4.setString(1,toRemove);
                statementCreF4.setString(1,toRemove);
                statementBusF4.setString(1,toRemove);
                statementAgriF4.setString(1,toRemove);


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
                System.out.print("Student deleted successfully");
                //loadData();
            }catch (Exception e){
                e.printStackTrace();
            }
            // }
        }


}
