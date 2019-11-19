package F3.ReportForms.T2;

import F3.ReportForms.T2.PrintPass;
import com.itextpdf.awt.DefaultFontMapper;
import com.itextpdf.text.*;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;

import static Alerts.informationBox.infoBox;
import static Alerts.informationBox.infoBoxError;

public class ReportsEx2 {
    String cname = System.getProperty("user.home");
    Calendar now = Calendar.getInstance();
    public static String ADM;
    public static String NAME;
    public static String ALL;
    public static int POS;
    public static String printPassword;
    public static int SUB;

    public void printReports() {
        if (printPassword.toString().equals("vic")) {
            if (SUB == 1) {
                //ALL SUBJECTS
                printAllSubjects(ADM, POS, ALL);
                clear();
            } else if (SUB == 2) {
                //bio cre agri
                printBioCreAgri(ADM, POS, ALL);
                clear();
            } else if (SUB == 3) {
                //bio cre bus
                printBioCreBus(ADM, POS, ALL);
                clear();
            } else if (SUB == 4) {
                //bio geo agri
                printBioGeoAgri(ADM, POS, ALL);
                clear();
            } else if (SUB == 5) {
                //bio geo bus
                printBioGeoBus(ADM, POS, ALL);
                clear();
            } else if (SUB == 6) {
                //bio his agri
                printBioHisAgri(ADM, POS, ALL);
                clear();
            } else if (SUB == 7) {
                //bio his bus
                printBioHisBus(ADM, POS, ALL);
                clear();
            } else if (SUB == 8) {
                //phy cre agri
                printPhyCreAgri(ADM, POS, ALL);
                clear();
            } else if (SUB == 9) {
                //phy cre bus
                printPhyCreBus(ADM, POS, ALL);
                clear();
            } else if (SUB == 10) {
                //phy geo agri
                printPhyGeoAgri(ADM, POS, ALL);
                clear();
            } else if (SUB == 11) {
                //phy geo bus
                printPhyGeoBus(ADM, POS, ALL);
                clear();
            } else if (SUB == 12) {
                //phy his agri
                printPhyHisAgri(ADM, POS, ALL);
                clear();
            } else if (SUB == 13) {
                //phy his bus
                printPhyHisBus(ADM, POS, ALL);
                clear();
            } else {
                //error
                infoBoxError("An error occurred while genrating the report", "error", null);
            }

        } else {
            //not allowed to print
            infoBoxError("you are not allowed to print", "error", null);
        }
    }

    public void clear(){
        SUB=0;
    }

    public void printPass(){
        PrintPass.reportsEx2=1;
        try{
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("printPass.fxml"));

            PrintPass printpass = (PrintPass) loader.getController();


            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("PRINT PASSWORD");
            stage.setResizable(true);
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    private void printBioCreAgri(String ADM,int POS, String ALL) {
        if(printPassword.toString().equals("vic")) {
            String sqlDetails="SELECT * FROM tbl_students WHERE adm=?";
            String sqlComm = "SELECT * FROM tbl_comments";
            String sqlTotal ="SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='TOTAL'";
            String sqlEx2 = "SELECT * FROM tbl_f3_t2_ex2 WHERE adm=? ";
            String sqlF1T1Ex2 = "SELECT * FROM tbl_f1_t1_ex2 WHERE adm=?";
            String sqlF1T2Ex2 = "SELECT * FROM tbl_f1_t2_ex2 WHERE adm=?";
            String sqlF1T3Ex2 = "SELECT * FROM tbl_f1_t3_ex2 WHERE adm=?";
            String sqlF2T1Ex2 = "SELECT * FROM tbl_f2_t1_ex2 WHERE adm=?";
            String sqlF2T2Ex2 = "SELECT * FROM tbl_f2_t2_ex2 WHERE adm=?";
            String sqlF2T3Ex2 = "SELECT * FROM tbl_f2_t3_ex2 WHERE adm=?";
            String sqlF3T1Ex2 = "SELECT * FROM tbl_f3_t1_ex2 WHERE adm=?";

            String sqlEngTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='English'";
            String sqlKisTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='Kiswahili'";
            String sqlMatTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='Mathematics'";
            String sqlChemTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='Chemistry'";
            String sqlBioTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='Biology'";
            String sqlPhyTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='Physics'";
            String sqlHisTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='History'";
            String sqlGeoTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='Geography'";
            String sqlCreTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='CRE'";
            String sqlBusTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='Business'";
            String sqlAgriTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='Agriculture'";

            String sqlEngGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='ENGLISH'";
            String sqlKisGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='KISWAHILI'";
            String sqlMatGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='MATHEMATICS'";
            String sqlChemGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='CHEMISTRY'";
            String sqlBioGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='BIOLOGY'";
            String sqlPhyGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='PHYSICS'";
            String sqlHisGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='HISTORY'";
            String sqlGeoGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='GEOGRAPHY'";
            String sqlCreGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='CRE'";
            String sqlBusGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='BUSINESS'";
            String sqlAgriGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='AGRICULTURE'";

            try{
                Connection connection = Database.DBConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sqlDetails);
                PreparedStatement statementE2 = connection.prepareStatement(sqlEx2);
                PreparedStatement statementF1T1E2 = connection.prepareStatement(sqlF1T1Ex2);
                PreparedStatement statementF1T2E2 = connection.prepareStatement(sqlF1T2Ex2);
                PreparedStatement statementF1T3E2 = connection.prepareStatement(sqlF1T3Ex2);
                PreparedStatement statementF2T1E2 = connection.prepareStatement(sqlF2T1Ex2);
                PreparedStatement statementF2T2E2 = connection.prepareStatement(sqlF2T2Ex2);
                PreparedStatement statementF2T3E2 = connection.prepareStatement(sqlF2T3Ex2);
                PreparedStatement statementF3T1E2 = connection.prepareStatement(sqlF3T1Ex2);



                statement.setString(1,ADM);
                statementE2.setString(1,ADM);
                statementF1T1E2.setString(1,ADM);
                statementF1T2E2.setString(1,ADM);
                statementF1T3E2.setString(1,ADM);
                statementF2T1E2.setString(1,ADM);
                statementF2T2E2.setString(1,ADM);
                statementF2T3E2.setString(1,ADM);
                statementF3T1E2.setString(1,ADM);


                ResultSet set = statement.executeQuery();

                ResultSet setE2 = statementE2.executeQuery();
                ResultSet setF1T1E2 = statementF1T1E2.executeQuery();
                ResultSet setF1T2E2 = statementF1T2E2.executeQuery();
                ResultSet setF1T3E2 = statementF1T3E2.executeQuery();
                ResultSet setF2T1E2 = statementF2T1E2.executeQuery();
                ResultSet setF2T2E2 = statementF2T2E2.executeQuery();
                ResultSet setF2T3E2 = statementF2T3E2.executeQuery();
                ResultSet setF3T1E2 = statementF3T1E2.executeQuery();


                ResultSet setEngTeacher = connection.createStatement().executeQuery(sqlEngTeacher);
                ResultSet setKisTeacher = connection.createStatement().executeQuery(sqlKisTeacher);
                ResultSet setMatTeacher = connection.createStatement().executeQuery(sqlMatTeacher);
                ResultSet setChemTeacher = connection.createStatement().executeQuery(sqlChemTeacher);
                ResultSet setBioTeacher = connection.createStatement().executeQuery(sqlBioTeacher);
                ResultSet setPhyTeacher = connection.createStatement().executeQuery(sqlPhyTeacher);
                ResultSet setHisTeacher = connection.createStatement().executeQuery(sqlHisTeacher);
                ResultSet setGeoTeacher = connection.createStatement().executeQuery(sqlGeoTeacher);
                ResultSet setCreTeacher = connection.createStatement().executeQuery(sqlCreTeacher);
                ResultSet setBusTeacher = connection.createStatement().executeQuery(sqlBusTeacher);
                ResultSet setAgriTeacher = connection.createStatement().executeQuery(sqlAgriTeacher);

                ResultSet setEngGrade = connection.createStatement().executeQuery(sqlEngGrade);
                ResultSet setKisGrade = connection.createStatement().executeQuery(sqlKisGrade);
                ResultSet setMatGrade = connection.createStatement().executeQuery(sqlMatGrade);
                ResultSet setChemGrade = connection.createStatement().executeQuery(sqlChemGrade);
                ResultSet setBioGrade = connection.createStatement().executeQuery(sqlBioGrade);
                ResultSet setPhyGrade = connection.createStatement().executeQuery(sqlPhyGrade);
                ResultSet setHisGrade = connection.createStatement().executeQuery(sqlHisGrade);
                ResultSet setGeoGrade = connection.createStatement().executeQuery(sqlGeoGrade);
                ResultSet setCreGrade = connection.createStatement().executeQuery(sqlCreGrade);
                ResultSet setBusGrade = connection.createStatement().executeQuery(sqlBusGrade);
                ResultSet setAgriGrade = connection.createStatement().executeQuery(sqlAgriGrade);

                ResultSet setComments = connection.createStatement().executeQuery(sqlComm);
                ResultSet setTotal = connection.createStatement().executeQuery(sqlTotal);

                String names = set.getString(3)+"_"+set.getString(4)+"_"+set.getString(5);

                Document document = new Document(PageSize.A4);
            PdfWriter writer = PdfWriter.getInstance(document,new FileOutputStream(NAME+".pdf"));
            document.open();

                Paragraph schoolName = new Paragraph("SCHOOL NAME", new Font(Font.FontFamily.TIMES_ROMAN, 15,Font.BOLD));
                Paragraph address = new Paragraph("P.O BOX 22332, LOCATION", new Font(Font.FontFamily.TIMES_ROMAN, 15,Font.BOLD));
                Paragraph tell = new Paragraph("PHONE: 073293874", new Font(Font.FontFamily.TIMES_ROMAN, 15,Font.BOLD));
                Paragraph reportType = new Paragraph("Report Form", new Font(Font.FontFamily.TIMES_ROMAN, 10,Font.BOLD));
                schoolName.setAlignment(Element.ALIGN_CENTER);
                address.setAlignment(Element.ALIGN_CENTER);
                tell.setAlignment(Element.ALIGN_CENTER);
                reportType.setAlignment(Element.ALIGN_CENTER);
                document.add(schoolName);
                document.add(address);
                document.add(tell);
                document.add(reportType);

                document.add((new Paragraph("ADM: "+set.getString(2)+"  "+"NAME: "+set.getString(3)+"   "+set.getString(4)+" "+set.getString(5)+"  "+"KCPE:"+set.getString(6)+"  "+"CLASS:FORM 3"+"  "+"TERM:TERM 2",new Font(Font.FontFamily.TIMES_ROMAN, 9,Font.BOLD))));
                document.add((new Paragraph("YEAR:"+now.get(Calendar.YEAR)+" "+"POS:"+String.valueOf(POS+1)+" "+"OUT OF "+ALL,new Font(Font.FontFamily.TIMES_ROMAN, 9,Font.BOLD))));
                document.add((new Paragraph(" ")));

                PdfPTable table = new PdfPTable(7);
                table.setWidthPercentage(105);
                table.setSpacingBefore(0f);
                table.setSpacingAfter(0f);

                float[] colWidth = {1.1f,0.5f,0.5f,0.5f,0.7f,2f,1f};
                table.setWidths(colWidth);
                PdfPCell c1 = new PdfPCell(new Paragraph("SUBJECTS",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell c2 = new PdfPCell(new Paragraph("EX1",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell c3 = new PdfPCell(new Paragraph("EX2",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell c4 = new PdfPCell(new Paragraph("EX3",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell c5 = new PdfPCell(new Paragraph("AVG",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell c6 = new PdfPCell(new Paragraph("COMMENTS",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell c7 = new PdfPCell(new Paragraph("TEACHER",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                table.addCell(c1);
                table.addCell(c2);
                table.addCell(c3);
                table.addCell(c4);
                table.addCell(c5);
                table.addCell(c6);
                table.addCell(c7);

                //set eng results
                String g,com=null;
                PdfPCell engD1 = new PdfPCell(new Paragraph("English"));
                PdfPCell engD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell engD3 = new PdfPCell(new Paragraph(setE2.getString(8)+" "+setE2.getString(9)));
                PdfPCell engD4 = new PdfPCell(new Paragraph(" "));

                int avgE= Integer.parseInt(setE2.getString(8));
                if (avgE >= Integer.parseInt(setEngGrade.getString(4))) {com = setComments.getString(2); } else if (avgE >= Integer.parseInt(setEngGrade.getString(5))) { com = setComments.getString(3); }else if (avgE >=Integer.parseInt(setEngGrade.getString(6))){ com = setComments.getString(4);}else if (avgE >=Integer.parseInt(setEngGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgE >=Integer.parseInt(setEngGrade.getString(8))){  com = setComments.getString(6); }else if (avgE >=Integer.parseInt(setEngGrade.getString(9))){ com = setComments.getString(7); }else if (avgE >=Integer.parseInt(setEngGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgE >=Integer.parseInt(setEngGrade.getString(11))){ com = setComments.getString(9);}else if (avgE >=Integer.parseInt(setEngGrade.getString(12))){ com = setComments.getString(10);}else if (avgE >=Integer.parseInt(setEngGrade.getString(13))){ com = setComments.getString(11);}else if (avgE >=Integer.parseInt(setEngGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }
                PdfPCell engD5 = new PdfPCell(new Paragraph(setE2.getString(8)+" "+setE2.getString(9)));
                PdfPCell engD6 = new PdfPCell(new Paragraph(com));
                PdfPCell engD7 = new PdfPCell(new Paragraph(setEngTeacher.getString(6)));
                table.addCell(engD1);
                table.addCell(engD2);
                table.addCell(engD3);
                table.addCell(engD4);
                table.addCell(engD5);
                table.addCell(engD6);
                table.addCell(engD7);

                //set kis results
                PdfPCell kisD1 = new PdfPCell(new Paragraph("Kiswahili"));
                PdfPCell kisD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell kisD3 = new PdfPCell(new Paragraph(setE2.getString(11)+" "+setE2.getString(12)));
                PdfPCell kisD4 = new PdfPCell(new Paragraph(" "));

                int avgKis= Integer.parseInt(setE2.getString(11));
                if (avgKis >= Integer.parseInt(setKisGrade.getString(4))) {com = setComments.getString(2); } else if (avgKis >= Integer.parseInt(setKisGrade.getString(5))) { com = setComments.getString(3); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(6))){ com = setComments.getString(4);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(8))){  com = setComments.getString(6); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(9))){ com = setComments.getString(7); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgKis >=Integer.parseInt(setKisGrade.getString(11))){ com = setComments.getString(9);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(12))){ com = setComments.getString(10);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(13))){ com = setComments.getString(11);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }
                PdfPCell kisD5 = new PdfPCell(new Paragraph(setE2.getString(11)+" "+setE2.getString(12)));
                PdfPCell kisD6 = new PdfPCell(new Paragraph(com));
                PdfPCell kisD7 = new PdfPCell(new Paragraph(setKisTeacher.getString(6)));
                table.addCell(kisD1);
                table.addCell(kisD2);
                table.addCell(kisD3);
                table.addCell(kisD4);
                table.addCell(kisD5);
                table.addCell(kisD6);
                table.addCell(kisD7);

                //set mat results

                PdfPCell matD1 = new PdfPCell(new Paragraph("Mathematics"));
                PdfPCell matD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell matD3 = new PdfPCell(new Paragraph(setE2.getString(14)+" "+setE2.getString(15)));
                PdfPCell matD4 = new PdfPCell(new Paragraph(" "));

                int avgMat = Integer.parseInt(setE2.getString(14));
                if (avgMat >= Integer.parseInt(setMatGrade.getString(4))) {com = setComments.getString(2); } else if (avgMat >= Integer.parseInt(setMatGrade.getString(5))) { com = setComments.getString(3); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(6))){ com = setComments.getString(4);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(8))){  com = setComments.getString(6); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(9))){ com = setComments.getString(7); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgMat >=Integer.parseInt(setMatGrade.getString(11))){ com = setComments.getString(9);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(12))){ com = setComments.getString(10);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(13))){ com = setComments.getString(11);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell matD5 = new PdfPCell(new Paragraph(setE2.getString(14)+" "+setE2.getString(15)));
                PdfPCell matD6 = new PdfPCell(new Paragraph(com));
                PdfPCell matD7 = new PdfPCell(new Paragraph(setMatTeacher.getString(6)));
                table.addCell(matD1);
                table.addCell(matD2);
                table.addCell(matD3);
                table.addCell(matD4);
                table.addCell(matD5);
                table.addCell(matD6);
                table.addCell(matD7);

                //set Chemistry results
                PdfPCell chemD1 = new PdfPCell(new Paragraph("Chemistry"));
                PdfPCell chemD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell chemD3 = new PdfPCell(new Paragraph(setE2.getString(20)+" "+setE2.getString(21)));
                PdfPCell chemD4 = new PdfPCell(new Paragraph(" "));

                int avgChem = Integer.parseInt(setE2.getString(20));
                if (avgChem >= Integer.parseInt(setChemGrade.getString(4))) {com = setComments.getString(2); } else if (avgChem >= Integer.parseInt(setChemGrade.getString(5))) { com = setComments.getString(3); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(6))){ com = setComments.getString(4);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(8))){  com = setComments.getString(6); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(9))){ com = setComments.getString(7); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgChem >=Integer.parseInt(setChemGrade.getString(11))){ com = setComments.getString(9);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(12))){ com = setComments.getString(10);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(13))){ com = setComments.getString(11);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell chemD5 = new PdfPCell(new Paragraph(setE2.getString(20)+" "+setE2.getString(21)));
                PdfPCell chemD6 = new PdfPCell(new Paragraph(com));
                PdfPCell chemD7 = new PdfPCell(new Paragraph(setChemTeacher.getString(6)));
                table.addCell(chemD1);
                table.addCell(chemD2);
                table.addCell(chemD3);
                table.addCell(chemD4);
                table.addCell(chemD5);
                table.addCell(chemD6);
                table.addCell(chemD7);

                //set Biology Results
                PdfPCell bioD1 = new PdfPCell(new Paragraph("Biology"));
                PdfPCell bioD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell bioD3 = new PdfPCell(new Paragraph(setE2.getString(17)+" "+setE2.getString(18)));
                PdfPCell bioD4 = new PdfPCell(new Paragraph(" "));

                int avgBio = Integer.parseInt(setE2.getString(17));
                if (avgBio >= Integer.parseInt(setBioGrade.getString(4))) {com = setComments.getString(2); } else if (avgBio >= Integer.parseInt(setBioGrade.getString(5))) { com = setComments.getString(3); }else if (avgBio >=Integer.parseInt(setBioGrade.getString(6))){ com = setComments.getString(4);}else if (avgBio >=Integer.parseInt(setBioGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgBio >=Integer.parseInt(setBioGrade.getString(8))){  com = setComments.getString(6); }else if (avgBio >=Integer.parseInt(setBioGrade.getString(9))){ com = setComments.getString(7); }else if (avgBio >=Integer.parseInt(setBioGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgBio >=Integer.parseInt(setBioGrade.getString(11))){ com = setComments.getString(9);}else if (avgBio >=Integer.parseInt(setBioGrade.getString(12))){ com = setComments.getString(10);}else if (avgBio >=Integer.parseInt(setBioGrade.getString(13))){ com = setComments.getString(11);}else if (avgBio >=Integer.parseInt(setBioGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell bioD5 = new PdfPCell(new Paragraph(setE2.getString(17)+" "+setE2.getString(18)));
                PdfPCell bioD6 = new PdfPCell(new Paragraph(com));
                PdfPCell bioD7 = new PdfPCell(new Paragraph(setBioTeacher.getString(6)));
                table.addCell(bioD1);
                table.addCell(bioD2);
                table.addCell(bioD3);
                table.addCell(bioD4);
                table.addCell(bioD5);
                table.addCell(bioD6);
                table.addCell(bioD7);

                //set Cre results
                PdfPCell creD1 = new PdfPCell(new Paragraph("Cre"));
                PdfPCell creD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell creD3 = new PdfPCell(new Paragraph(setE2.getString(32)+" "+setE2.getString(33)));
                PdfPCell creD4 = new PdfPCell(new Paragraph(" "));

                int avgCre = Integer.parseInt(setE2.getString(32));
                if (avgCre >= Integer.parseInt(setCreGrade.getString(4))) {com = setComments.getString(2); } else if (avgCre >= Integer.parseInt(setCreGrade.getString(5))) { com = setComments.getString(3); }else if (avgCre >=Integer.parseInt(setCreGrade.getString(6))){ com = setComments.getString(4);}else if (avgCre >=Integer.parseInt(setCreGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgCre >=Integer.parseInt(setCreGrade.getString(8))){  com = setComments.getString(6); }else if (avgCre >=Integer.parseInt(setCreGrade.getString(9))){ com = setComments.getString(7); }else if (avgCre >=Integer.parseInt(setCreGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgCre >=Integer.parseInt(setCreGrade.getString(11))){ com = setComments.getString(9);}else if (avgCre >=Integer.parseInt(setCreGrade.getString(12))){ com = setComments.getString(10);}else if (avgCre >=Integer.parseInt(setCreGrade.getString(13))){ com = setComments.getString(11);}else if (avgCre >=Integer.parseInt(setCreGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell creD5 = new PdfPCell(new Paragraph(setE2.getString(32)+" "+setE2.getString(33)));
                PdfPCell creD6 = new PdfPCell(new Paragraph(com));
                PdfPCell creD7 = new PdfPCell(new Paragraph(setCreTeacher.getString(6)));
                table.addCell(creD1);
                table.addCell(creD2);
                table.addCell(creD3);
                table.addCell(creD4);
                table.addCell(creD5);
                table.addCell(creD6);
                table.addCell(creD7);

                //set Agriculture results
                PdfPCell agriD1 = new PdfPCell(new Paragraph("Agriculture"));
                PdfPCell agriD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell agriD3 = new PdfPCell(new Paragraph(setE2.getString(38)+" "+setE2.getString(39)));
                PdfPCell agriD4 = new PdfPCell(new Paragraph(" "));

                int avgAgri = Integer.parseInt(setE2.getString(38));
                if (avgAgri >= Integer.parseInt(setAgriGrade.getString(4))) {com = setComments.getString(2); } else if (avgAgri >= Integer.parseInt(setAgriGrade.getString(5))) { com = setComments.getString(3); }else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(6))){ com = setComments.getString(4);}else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(8))){  com = setComments.getString(6); }else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(9))){ com = setComments.getString(7); }else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(11))){ com = setComments.getString(9);}else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(12))){ com = setComments.getString(10);}else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(13))){ com = setComments.getString(11);}else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell agriD5 = new PdfPCell(new Paragraph(setE2.getString(38)+" "+setE2.getString(39)));
                PdfPCell agriD6 = new PdfPCell(new Paragraph(com));
                PdfPCell agriD7 = new PdfPCell(new Paragraph(setAgriTeacher.getString(6)));
                table.addCell(agriD1);
                table.addCell(agriD2);
                table.addCell(agriD3);
                table.addCell(agriD4);
                table.addCell(agriD5);
                table.addCell(agriD6);
                table.addCell(agriD7);

                //set total results

                int totalE2 = Integer.parseInt(setE2.getString(41));



                PdfPCell totalD1 = new PdfPCell(new Paragraph("Total"));
                PdfPCell totalD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell totalD3 = new PdfPCell(new Paragraph(String.valueOf(totalE2)));
                PdfPCell totalD4 = new PdfPCell(new Paragraph(" "));
                PdfPCell totalD5 = new PdfPCell(new Paragraph(" "));
                PdfPCell totalD6 = new PdfPCell(new Paragraph(""));
                PdfPCell totalD7 = new PdfPCell(new Paragraph(""));
                table.addCell(totalD1);
                table.addCell(totalD2);
                table.addCell(totalD3);
                table.addCell(totalD4);
                table.addCell(totalD5);
                table.addCell(totalD6);
                table.addCell(totalD7);

                //set average results

                //int add2AvgEx1 = (Math.addExact(totalEx1Mat,addAvgEx1))/3;

                int addAvgEx2 = Math.round(totalE2/7);
                //int add2AvgEx2 = (Math.addExact(totalEx2Mat,addAvgEx2))/3;


                //int add2AvgEx3 = (Math.addExact(totalEx3Mat,addAvgEx3))/3;


                PdfPCell avgD1 = new PdfPCell(new Paragraph("Average"));
                PdfPCell avgD2 = new PdfPCell(new Paragraph(" "));
                if (addAvgEx2 >= Integer.parseInt(setTotal.getString(4))) {g = "A"; } else if (addAvgEx2 >= Integer.parseInt(setTotal.getString(5))) { g = "A-"; }else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(6))){ g = "B+";}else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(7))){
                    g = "B"; }else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(8))){  g = "B-"; }else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(9))){ g = "C+"; }else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(10))){ g = "C";
                }else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(11))){ g = "C-";}else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(12))){ g = "D+";}else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(13))){ g = "D";}else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(14))){
                    g = "D-";}else {g="E"; }
                PdfPCell avgD3 = new PdfPCell(new Paragraph(String.valueOf(addAvgEx2)+" "+g));


                PdfPCell avgD4 = new PdfPCell(new Paragraph(" "));

                //float avgAvgTotal = (addAvgEx1+addAvgEx2+addAvgEx3)/3;
                int avgAvgTotal=Integer.parseInt(setE2.getString(41))/7;

                if (avgAvgTotal >= Integer.parseInt(setTotal.getString(4))) {g = "A"; } else if (avgAvgTotal >= Integer.parseInt(setTotal.getString(5))) { g = "A-"; }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(6))){ g = "B+";}else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(7))){
                    g = "B"; }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(8))){  g = "B-"; }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(9))){ g = "C+"; }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(10))){ g = "C";
                }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(11))){ g = "C-";}else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(12))){ g = "D+";}else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(13))){ g = "D";}else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(14))){
                    g = "D-";}else {g="E"; }

                PdfPCell avgD5 = new PdfPCell(new Paragraph(String.valueOf(Math.round(avgAvgTotal))+" "+g));
                PdfPCell avgD6 = new PdfPCell(new Paragraph(""));
                PdfPCell avgD7 = new PdfPCell(new Paragraph(""));
                table.addCell(avgD1);
                table.addCell(avgD2);
                table.addCell(avgD3);
                table.addCell(avgD4);
                table.addCell(avgD5);
                table.addCell(avgD6);
                table.addCell(avgD7);

                document.add(table);

                Paragraph labelSummary = new Paragraph("PERFORMANCE TREND",new Font(Font.FontFamily.TIMES_ROMAN, 8,Font.BOLD));
                labelSummary.setSpacingBefore(0);
                labelSummary.setSpacingAfter(5);
                labelSummary.setAlignment(Element.ALIGN_CENTER);
                document.add(labelSummary);

                PdfPTable tableLastSummary = new PdfPTable(8);
                tableLastSummary.setWidthPercentage(105);
                tableLastSummary.setSpacingBefore(0f);
                tableLastSummary.setSpacingAfter(0f);

                float[] colWidthSummary = {0.5f,0.5f,0.5f,0.5f,0.5f,0.5f,0.5f,0.5f};
                tableLastSummary.setWidths(colWidthSummary);
                PdfPCell cS1 = new PdfPCell(new Paragraph("FORM 1",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell cS2 = new PdfPCell(new Paragraph(" ",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell cS3 = new PdfPCell(new Paragraph("FORM 2",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell cS4 = new PdfPCell(new Paragraph(" ",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell cS5 = new PdfPCell(new Paragraph("FORM 3",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell cS6 = new PdfPCell(new Paragraph(" ",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell cS7 = new PdfPCell(new Paragraph("FORM 4",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell cS8 = new PdfPCell(new Paragraph(" ",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                tableLastSummary.addCell(cS1);
                tableLastSummary.addCell(cS2);
                tableLastSummary.addCell(cS3);
                tableLastSummary.addCell(cS4);
                tableLastSummary.addCell(cS5);
                tableLastSummary.addCell(cS6);
                tableLastSummary.addCell(cS7);
                tableLastSummary.addCell(cS8);

                PdfPCell f1t1 = new PdfPCell(new Paragraph("F1T1"));
                PdfPCell f1t1m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF1T1E2.getString(30)))/11)+" "+setF1T1E2.getString(31)));
                PdfPCell f2t1 = new PdfPCell(new Paragraph("F2T1"));
                PdfPCell f2t1m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF2T1E2.getString(30)))/11)+" "+setF2T1E2.getString(31)));
                PdfPCell f3t1 = new PdfPCell(new Paragraph("F3T1"));
                PdfPCell f3t1m = new PdfPCell(new Paragraph(String.valueOf(Integer.parseInt(setF3T1E2.getString(41))/11)+" "+setF3T1E2.getString(43)+" "+setF3T1E2.getString(42)));
                PdfPCell f4t1 = new PdfPCell(new Paragraph("F4T1"));
                PdfPCell f4t1m = new PdfPCell(new Paragraph(" "));
                tableLastSummary.addCell(f1t1);
                tableLastSummary.addCell(f1t1m);
                tableLastSummary.addCell(f2t1);
                tableLastSummary.addCell(f2t1m);
                tableLastSummary.addCell(f3t1);
                tableLastSummary.addCell(f3t1m);
                tableLastSummary.addCell(f4t1);
                tableLastSummary.addCell(f4t1m);

                PdfPCell f1t2 = new PdfPCell(new Paragraph("F1T2"));
                PdfPCell f1t2m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF1T2E2.getString(30)))/11)+" "+setF1T2E2.getString(31)));
                PdfPCell f2t2 = new PdfPCell(new Paragraph("F2T2"));
                PdfPCell f2t2m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF2T2E2.getString(30)))/11)+" "+setF2T2E2.getString(31)));
                PdfPCell f3t2 = new PdfPCell(new Paragraph("F3T2"));
                PdfPCell f3t2m = new PdfPCell(new Paragraph(String.valueOf(avgAvgTotal)+" "+setE2.getString(42)+" "+setE2.getString(43)));
                PdfPCell f4t2 = new PdfPCell(new Paragraph("F4T2"));
                PdfPCell f4t2m = new PdfPCell(new Paragraph(" "));
                tableLastSummary.addCell(f1t2);
                tableLastSummary.addCell(f1t2m);
                tableLastSummary.addCell(f2t2);
                tableLastSummary.addCell(f2t2m);
                tableLastSummary.addCell(f3t2);
                tableLastSummary.addCell(f3t2m);
                tableLastSummary.addCell(f4t2);
                tableLastSummary.addCell(f4t2m);

                PdfPCell f1t3 = new PdfPCell(new Paragraph("F1T3"));
                PdfPCell f1t3m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF1T3E2.getString(30)))/11)+" "+setF1T3E2.getString(31)));
                PdfPCell f2t3 = new PdfPCell(new Paragraph("F2T3"));
                PdfPCell f2t3m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF2T3E2.getString(30)))/11)+" "+setF2T3E2.getString(31)));
                PdfPCell f3t3 = new PdfPCell(new Paragraph("F3T3"));
                PdfPCell f3t3m = new PdfPCell(new Paragraph(" "));
                PdfPCell f4t3 = new PdfPCell(new Paragraph("F4T3"));
                PdfPCell f4t3m = new PdfPCell(new Paragraph(" "));
                tableLastSummary.addCell(f1t3);
                tableLastSummary.addCell(f1t3m);
                tableLastSummary.addCell(f2t3);
                tableLastSummary.addCell(f2t3m);
                tableLastSummary.addCell(f3t3);
                tableLastSummary.addCell(f3t3m);
                tableLastSummary.addCell(f4t3);
                tableLastSummary.addCell(f4t3m);

                document.add(tableLastSummary);
            /*
            * logo
            * */
                Image img = Image.getInstance(cname+"\\HS Results\\Web-Development.png");
                img.scaleAbsolute(100,50);
                img.setAbsolutePosition(30,750);
                document.add(img);

            /*
            * chart
            * */
                DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
                JFreeChart chart = ChartFactory.createBarChart(
                        "", "", "Marks",
                        dataSet, PlotOrientation.VERTICAL, false, false, false);
                int width=500; /* Width of our chart */
                int height=150; /* Height of our chart */
/* Get instance of CategoryPlot */
                CategoryPlot plot = chart.getCategoryPlot();
                BarRenderer renderer = (BarRenderer) plot.getRenderer();
                renderer.setSeriesPaint(0, Color.black);
                dataSet.setValue((Integer.parseInt(setF1T1E2.getString(30))/11)/7, "Marks", "F1T1");
                dataSet.setValue((Integer.parseInt(setF1T2E2.getString(30))/11)/7, "Marks", "F1T2");
                dataSet.setValue((Integer.parseInt(setF1T3E2.getString(30))/11)/7, "Marks", "F1T3");
                dataSet.setValue((Integer.parseInt(setF2T1E2.getString(30))/11)/7, "Marks", "F2T1");
                dataSet.setValue((Integer.parseInt(setF2T2E2.getString(30))/11)/7, "Marks", "F2T2");
                dataSet.setValue((Integer.parseInt(setF2T3E2.getString(30))/11)/7, "Marks", "F2T3");
                dataSet.setValue(Float.parseFloat(setF3T1E2.getString(43)), "Marks", "F3T1");
                dataSet.setValue(Float.parseFloat(setE2.getString(43)), "Marks", "F3T2");
                dataSet.setValue(0, "Marks", "F3T3");
                dataSet.setValue(0, "Marks", "F4T1");
                dataSet.setValue(0, "Marks", "F4T2");
                dataSet.setValue(0, "Marks", "F4T3");
                PdfContentByte contentByte = writer.getDirectContent();
                PdfTemplate template = contentByte.createTemplate(width, height);
                Graphics2D graphics2d = template.createGraphics(width, height,new DefaultFontMapper());
                Rectangle2D rectangle2d = new Rectangle2D.Double(0, 0, width, height);
                chart.draw(graphics2d, rectangle2d);
                graphics2d.dispose();
                contentByte.addTemplate(template, 30, 275);

                Paragraph classTeacherComments = new Paragraph("Class teacher comments: _________________________________________________________");
                Paragraph classTeacherComments1 = new Paragraph("______________________________________________________________________________");
                Paragraph principalComments =new Paragraph("Principal comments: _____________________________________________________________");
                Paragraph principalComments1 =new Paragraph("______________________________________________________________________________");

                classTeacherComments.setSpacingBefore(170);
                document.add(classTeacherComments);
                document.add(classTeacherComments1);
                document.add(principalComments);
                document.add(principalComments1);
                document.close();
            writer.close();
            infoBox("Document containing exam2 results for " + NAME + " has been created open it for printing.","Done",null);
            Desktop.getDesktop().open(new File(cname+"\\HS Results\\"+NAME+".pdf"));


            }catch (Exception e){
                e.printStackTrace();
                infoBoxError("An error occurred " + e,"Error",null);
            }}else {
            infoBoxError("You are not allowed to print","Error",null);
        }
    }

    private void printBioCreBus(String ADM,int POS, String ALL) {
        if(printPassword.toString().equals("vic")) {
            String sqlDetails="SELECT * FROM tbl_students WHERE adm=?";
            String sqlComm = "SELECT * FROM tbl_comments";
            String sqlTotal ="SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='TOTAL'";

            String sqlEx2 = "SELECT * FROM tbl_f3_t2_ex2 WHERE adm=? ";
            String sqlF1T1Ex2 = "SELECT * FROM tbl_f1_t1_ex2 WHERE adm=?";
            String sqlF1T2Ex2 = "SELECT * FROM tbl_f1_t2_ex2 WHERE adm=?";
            String sqlF1T3Ex2 = "SELECT * FROM tbl_f1_t3_ex2 WHERE adm=?";
            String sqlF2T1Ex2 = "SELECT * FROM tbl_f2_t1_ex2 WHERE adm=?";
            String sqlF2T2Ex2 = "SELECT * FROM tbl_f2_t2_ex2 WHERE adm=?";
            String sqlF2T3Ex2 = "SELECT * FROM tbl_f2_t3_ex2 WHERE adm=?";
            String sqlF3T1Ex2 = "SELECT * FROM tbl_f3_t1_ex2 WHERE adm=?";


            String sqlEngTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='English'";
            String sqlKisTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='Kiswahili'";
            String sqlMatTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='Mathematics'";
            String sqlChemTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='Chemistry'";
            String sqlBioTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='Biology'";
            String sqlPhyTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='Physics'";
            String sqlHisTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='History'";
            String sqlGeoTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='Geography'";
            String sqlCreTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='CRE'";
            String sqlBusTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='Business'";
            String sqlAgriTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='Agriculture'";

            String sqlEngGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='ENGLISH'";
            String sqlKisGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='KISWAHILI'";
            String sqlMatGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='MATHEMATICS'";
            String sqlChemGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='CHEMISTRY'";
            String sqlBioGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='BIOLOGY'";
            String sqlPhyGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='PHYSICS'";
            String sqlHisGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='HISTORY'";
            String sqlGeoGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='GEOGRAPHY'";
            String sqlCreGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='CRE'";
            String sqlBusGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='BUSINESS'";
            String sqlAgriGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='AGRICULTURE'";

            try{
                Connection connection = Database.DBConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sqlDetails);

                PreparedStatement statementE2 = connection.prepareStatement(sqlEx2);
                PreparedStatement statementF1T1E2 = connection.prepareStatement(sqlF1T1Ex2);
                PreparedStatement statementF1T2E2 = connection.prepareStatement(sqlF1T2Ex2);
                PreparedStatement statementF1T3E2 = connection.prepareStatement(sqlF1T3Ex2);
                PreparedStatement statementF2T1E2 = connection.prepareStatement(sqlF2T1Ex2);
                PreparedStatement statementF2T2E2 = connection.prepareStatement(sqlF2T2Ex2);
                PreparedStatement statementF2T3E2 = connection.prepareStatement(sqlF2T3Ex2);
                PreparedStatement statementF3T1E2 = connection.prepareStatement(sqlF3T1Ex2);



                statement.setString(1,ADM);

                statementE2.setString(1,ADM);
                statementF1T1E2.setString(1,ADM);
                statementF1T2E2.setString(1,ADM);
                statementF1T3E2.setString(1,ADM);
                statementF2T1E2.setString(1,ADM);
                statementF2T2E2.setString(1,ADM);
                statementF2T3E2.setString(1,ADM);
                statementF3T1E2.setString(1,ADM);


                ResultSet set = statement.executeQuery();

                ResultSet setE2 = statementE2.executeQuery();
                ResultSet setF1T1E2 = statementF1T1E2.executeQuery();
                ResultSet setF1T2E2 = statementF1T2E2.executeQuery();
                ResultSet setF1T3E2 = statementF1T3E2.executeQuery();
                ResultSet setF2T1E2 = statementF2T1E2.executeQuery();
                ResultSet setF2T2E2 = statementF2T2E2.executeQuery();
                ResultSet setF2T3E2 = statementF2T3E2.executeQuery();
                ResultSet setF3T1E2 = statementF3T1E2.executeQuery();


                ResultSet setEngTeacher = connection.createStatement().executeQuery(sqlEngTeacher);
                ResultSet setKisTeacher = connection.createStatement().executeQuery(sqlKisTeacher);
                ResultSet setMatTeacher = connection.createStatement().executeQuery(sqlMatTeacher);
                ResultSet setChemTeacher = connection.createStatement().executeQuery(sqlChemTeacher);
                ResultSet setBioTeacher = connection.createStatement().executeQuery(sqlBioTeacher);
                ResultSet setPhyTeacher = connection.createStatement().executeQuery(sqlPhyTeacher);
                ResultSet setHisTeacher = connection.createStatement().executeQuery(sqlHisTeacher);
                ResultSet setGeoTeacher = connection.createStatement().executeQuery(sqlGeoTeacher);
                ResultSet setCreTeacher = connection.createStatement().executeQuery(sqlCreTeacher);
                ResultSet setBusTeacher = connection.createStatement().executeQuery(sqlBusTeacher);
                ResultSet setAgriTeacher = connection.createStatement().executeQuery(sqlAgriTeacher);

                ResultSet setEngGrade = connection.createStatement().executeQuery(sqlEngGrade);
                ResultSet setKisGrade = connection.createStatement().executeQuery(sqlKisGrade);
                ResultSet setMatGrade = connection.createStatement().executeQuery(sqlMatGrade);
                ResultSet setChemGrade = connection.createStatement().executeQuery(sqlChemGrade);
                ResultSet setBioGrade = connection.createStatement().executeQuery(sqlBioGrade);
                ResultSet setPhyGrade = connection.createStatement().executeQuery(sqlPhyGrade);
                ResultSet setHisGrade = connection.createStatement().executeQuery(sqlHisGrade);
                ResultSet setGeoGrade = connection.createStatement().executeQuery(sqlGeoGrade);
                ResultSet setCreGrade = connection.createStatement().executeQuery(sqlCreGrade);
                ResultSet setBusGrade = connection.createStatement().executeQuery(sqlBusGrade);
                ResultSet setAgriGrade = connection.createStatement().executeQuery(sqlAgriGrade);

                ResultSet setComments = connection.createStatement().executeQuery(sqlComm);
                ResultSet setTotal = connection.createStatement().executeQuery(sqlTotal);

                String names = set.getString(3)+"_"+set.getString(4)+"_"+set.getString(5);

                Document document = new Document(PageSize.A4);
            PdfWriter writer = PdfWriter.getInstance(document,new FileOutputStream(NAME+".pdf"));
            document.open();

                Paragraph schoolName = new Paragraph("SCHOOL NAME", new Font(Font.FontFamily.TIMES_ROMAN, 15,Font.BOLD));
                Paragraph address = new Paragraph("P.O BOX 22332, LOCATION", new Font(Font.FontFamily.TIMES_ROMAN, 15,Font.BOLD));
                Paragraph tell = new Paragraph("PHONE: 073293874", new Font(Font.FontFamily.TIMES_ROMAN, 15,Font.BOLD));
                Paragraph reportType = new Paragraph("Report Form", new Font(Font.FontFamily.TIMES_ROMAN, 10,Font.BOLD));
                schoolName.setAlignment(Element.ALIGN_CENTER);
                address.setAlignment(Element.ALIGN_CENTER);
                tell.setAlignment(Element.ALIGN_CENTER);
                reportType.setAlignment(Element.ALIGN_CENTER);
                document.add(schoolName);
                document.add(address);
                document.add(tell);
                document.add(reportType);

                document.add((new Paragraph("ADM: "+set.getString(2)+"  "+"NAME: "+set.getString(3)+"   "+set.getString(4)+" "+set.getString(5)+"  "+"KCPE:"+set.getString(6)+"  "+"CLASS:FORM 3"+"  "+"TERM:TERM 2",new Font(Font.FontFamily.TIMES_ROMAN, 9,Font.BOLD))));
                document.add((new Paragraph("YEAR:"+now.get(Calendar.YEAR)+" "+"POS:"+String.valueOf(POS+1)+" "+"OUT OF "+ALL,new Font(Font.FontFamily.TIMES_ROMAN, 9,Font.BOLD))));
                document.add((new Paragraph(" ")));

                PdfPTable table = new PdfPTable(7);
                table.setWidthPercentage(105);
                table.setSpacingBefore(0f);
                table.setSpacingAfter(0f);

                float[] colWidth = {1.1f,0.5f,0.5f,0.5f,0.7f,2f,1f};
                table.setWidths(colWidth);
                PdfPCell c1 = new PdfPCell(new Paragraph("SUBJECTS",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell c2 = new PdfPCell(new Paragraph("EX1",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell c3 = new PdfPCell(new Paragraph("EX2",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell c4 = new PdfPCell(new Paragraph("EX3",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell c5 = new PdfPCell(new Paragraph("AVG",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell c6 = new PdfPCell(new Paragraph("COMMENTS",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell c7 = new PdfPCell(new Paragraph("TEACHER",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                table.addCell(c1);
                table.addCell(c2);
                table.addCell(c3);
                table.addCell(c4);
                table.addCell(c5);
                table.addCell(c6);
                table.addCell(c7);

                //set eng results
                String g,com=null;
                PdfPCell engD1 = new PdfPCell(new Paragraph("English"));
                PdfPCell engD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell engD3 = new PdfPCell(new Paragraph(setE2.getString(8)+" "+setE2.getString(9)));
                PdfPCell engD4 = new PdfPCell(new Paragraph(" "));

                int avgE= Integer.parseInt(setE2.getString(8));
                if (avgE >= Integer.parseInt(setEngGrade.getString(4))) {com = setComments.getString(2); } else if (avgE >= Integer.parseInt(setEngGrade.getString(5))) { com = setComments.getString(3); }else if (avgE >=Integer.parseInt(setEngGrade.getString(6))){ com = setComments.getString(4);}else if (avgE >=Integer.parseInt(setEngGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgE >=Integer.parseInt(setEngGrade.getString(8))){  com = setComments.getString(6); }else if (avgE >=Integer.parseInt(setEngGrade.getString(9))){ com = setComments.getString(7); }else if (avgE >=Integer.parseInt(setEngGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgE >=Integer.parseInt(setEngGrade.getString(11))){ com = setComments.getString(9);}else if (avgE >=Integer.parseInt(setEngGrade.getString(12))){ com = setComments.getString(10);}else if (avgE >=Integer.parseInt(setEngGrade.getString(13))){ com = setComments.getString(11);}else if (avgE >=Integer.parseInt(setEngGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }
                PdfPCell engD5 = new PdfPCell(new Paragraph(setE2.getString(8)+" "+setE2.getString(9)));
                PdfPCell engD6 = new PdfPCell(new Paragraph(com));
                PdfPCell engD7 = new PdfPCell(new Paragraph(setEngTeacher.getString(6)));
                table.addCell(engD1);
                table.addCell(engD2);
                table.addCell(engD3);
                table.addCell(engD4);
                table.addCell(engD5);
                table.addCell(engD6);
                table.addCell(engD7);

                //set kis results
                PdfPCell kisD1 = new PdfPCell(new Paragraph("Kiswahili"));
                PdfPCell kisD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell kisD3 = new PdfPCell(new Paragraph(setE2.getString(11)+" "+setE2.getString(12)));
                PdfPCell kisD4 = new PdfPCell(new Paragraph(" "));

                int avgKis= Integer.parseInt(setE2.getString(11));
                if (avgKis >= Integer.parseInt(setKisGrade.getString(4))) {com = setComments.getString(2); } else if (avgKis >= Integer.parseInt(setKisGrade.getString(5))) { com = setComments.getString(3); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(6))){ com = setComments.getString(4);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(8))){  com = setComments.getString(6); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(9))){ com = setComments.getString(7); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgKis >=Integer.parseInt(setKisGrade.getString(11))){ com = setComments.getString(9);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(12))){ com = setComments.getString(10);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(13))){ com = setComments.getString(11);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }
                PdfPCell kisD5 = new PdfPCell(new Paragraph(setE2.getString(11)+" "+setE2.getString(12)));
                PdfPCell kisD6 = new PdfPCell(new Paragraph(com));
                PdfPCell kisD7 = new PdfPCell(new Paragraph(setKisTeacher.getString(6)));
                table.addCell(kisD1);
                table.addCell(kisD2);
                table.addCell(kisD3);
                table.addCell(kisD4);
                table.addCell(kisD5);
                table.addCell(kisD6);
                table.addCell(kisD7);

                //set mat results

                PdfPCell matD1 = new PdfPCell(new Paragraph("Mathematics"));
                PdfPCell matD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell matD3 = new PdfPCell(new Paragraph(setE2.getString(14)+" "+setE2.getString(15)));
                PdfPCell matD4 = new PdfPCell(new Paragraph(" "));

                int avgMat = Integer.parseInt(setE2.getString(14));
                if (avgMat >= Integer.parseInt(setMatGrade.getString(4))) {com = setComments.getString(2); } else if (avgMat >= Integer.parseInt(setMatGrade.getString(5))) { com = setComments.getString(3); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(6))){ com = setComments.getString(4);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(8))){  com = setComments.getString(6); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(9))){ com = setComments.getString(7); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgMat >=Integer.parseInt(setMatGrade.getString(11))){ com = setComments.getString(9);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(12))){ com = setComments.getString(10);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(13))){ com = setComments.getString(11);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell matD5 = new PdfPCell(new Paragraph(setE2.getString(14)+" "+setE2.getString(15)));
                PdfPCell matD6 = new PdfPCell(new Paragraph(com));
                PdfPCell matD7 = new PdfPCell(new Paragraph(setMatTeacher.getString(6)));
                table.addCell(matD1);
                table.addCell(matD2);
                table.addCell(matD3);
                table.addCell(matD4);
                table.addCell(matD5);
                table.addCell(matD6);
                table.addCell(matD7);

                //set Chemistry results
                PdfPCell chemD1 = new PdfPCell(new Paragraph("Chemistry"));
                PdfPCell chemD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell chemD3 = new PdfPCell(new Paragraph(setE2.getString(20)+" "+setE2.getString(21)));
                PdfPCell chemD4 = new PdfPCell(new Paragraph(" "));

                int avgChem = Integer.parseInt(setE2.getString(20));
                if (avgChem >= Integer.parseInt(setChemGrade.getString(4))) {com = setComments.getString(2); } else if (avgChem >= Integer.parseInt(setChemGrade.getString(5))) { com = setComments.getString(3); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(6))){ com = setComments.getString(4);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(8))){  com = setComments.getString(6); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(9))){ com = setComments.getString(7); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgChem >=Integer.parseInt(setChemGrade.getString(11))){ com = setComments.getString(9);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(12))){ com = setComments.getString(10);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(13))){ com = setComments.getString(11);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell chemD5 = new PdfPCell(new Paragraph(setE2.getString(20)+" "+setE2.getString(21)));
                PdfPCell chemD6 = new PdfPCell(new Paragraph(com));
                PdfPCell chemD7 = new PdfPCell(new Paragraph(setChemTeacher.getString(6)));
                table.addCell(chemD1);
                table.addCell(chemD2);
                table.addCell(chemD3);
                table.addCell(chemD4);
                table.addCell(chemD5);
                table.addCell(chemD6);
                table.addCell(chemD7);

                //set Biology Results
                PdfPCell bioD1 = new PdfPCell(new Paragraph("Biology"));
                PdfPCell bioD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell bioD3 = new PdfPCell(new Paragraph(setE2.getString(17)+" "+setE2.getString(18)));
                PdfPCell bioD4 = new PdfPCell(new Paragraph(" "));

                int avgBio = Integer.parseInt(setE2.getString(17));
                if (avgBio >= Integer.parseInt(setBioGrade.getString(4))) {com = setComments.getString(2); } else if (avgBio >= Integer.parseInt(setBioGrade.getString(5))) { com = setComments.getString(3); }else if (avgBio >=Integer.parseInt(setBioGrade.getString(6))){ com = setComments.getString(4);}else if (avgBio >=Integer.parseInt(setBioGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgBio >=Integer.parseInt(setBioGrade.getString(8))){  com = setComments.getString(6); }else if (avgBio >=Integer.parseInt(setBioGrade.getString(9))){ com = setComments.getString(7); }else if (avgBio >=Integer.parseInt(setBioGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgBio >=Integer.parseInt(setBioGrade.getString(11))){ com = setComments.getString(9);}else if (avgBio >=Integer.parseInt(setBioGrade.getString(12))){ com = setComments.getString(10);}else if (avgBio >=Integer.parseInt(setBioGrade.getString(13))){ com = setComments.getString(11);}else if (avgBio >=Integer.parseInt(setBioGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell bioD5 = new PdfPCell(new Paragraph(setE2.getString(17)+" "+setE2.getString(18)));
                PdfPCell bioD6 = new PdfPCell(new Paragraph(com));
                PdfPCell bioD7 = new PdfPCell(new Paragraph(setBioTeacher.getString(6)));
                table.addCell(bioD1);
                table.addCell(bioD2);
                table.addCell(bioD3);
                table.addCell(bioD4);
                table.addCell(bioD5);
                table.addCell(bioD6);
                table.addCell(bioD7);

                //set Cre results
                PdfPCell creD1 = new PdfPCell(new Paragraph("Cre"));
                PdfPCell creD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell creD3 = new PdfPCell(new Paragraph(setE2.getString(32)+" "+setE2.getString(33)));
                PdfPCell creD4 = new PdfPCell(new Paragraph(" "));

                int avgCre = Integer.parseInt(setE2.getString(32));
                if (avgCre >= Integer.parseInt(setCreGrade.getString(4))) {com = setComments.getString(2); } else if (avgCre >= Integer.parseInt(setCreGrade.getString(5))) { com = setComments.getString(3); }else if (avgCre >=Integer.parseInt(setCreGrade.getString(6))){ com = setComments.getString(4);}else if (avgCre >=Integer.parseInt(setCreGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgCre >=Integer.parseInt(setCreGrade.getString(8))){  com = setComments.getString(6); }else if (avgCre >=Integer.parseInt(setCreGrade.getString(9))){ com = setComments.getString(7); }else if (avgCre >=Integer.parseInt(setCreGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgCre >=Integer.parseInt(setCreGrade.getString(11))){ com = setComments.getString(9);}else if (avgCre >=Integer.parseInt(setCreGrade.getString(12))){ com = setComments.getString(10);}else if (avgCre >=Integer.parseInt(setCreGrade.getString(13))){ com = setComments.getString(11);}else if (avgCre >=Integer.parseInt(setCreGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell creD5 = new PdfPCell(new Paragraph(setE2.getString(32)+" "+setE2.getString(33)));
                PdfPCell creD6 = new PdfPCell(new Paragraph(com));
                PdfPCell creD7 = new PdfPCell(new Paragraph(setCreTeacher.getString(6)));
                table.addCell(creD1);
                table.addCell(creD2);
                table.addCell(creD3);
                table.addCell(creD4);
                table.addCell(creD5);
                table.addCell(creD6);
                table.addCell(creD7);

                //set Business results
                PdfPCell busD1 = new PdfPCell(new Paragraph("Business"));
                PdfPCell busD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell busD3 = new PdfPCell(new Paragraph(setE2.getString(35)+" "+setE2.getString(36)));
                PdfPCell busD4 = new PdfPCell(new Paragraph(" "));

                int avgBus = Integer.parseInt(setE2.getString(35));
                if (avgBus >= Integer.parseInt(setBusGrade.getString(4))) {com = setComments.getString(2); } else if (avgBus >= Integer.parseInt(setBusGrade.getString(5))) { com = setComments.getString(3); }else if (avgBus >=Integer.parseInt(setBusGrade.getString(6))){ com = setComments.getString(4);}else if (avgBus >=Integer.parseInt(setBusGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgBus >=Integer.parseInt(setBusGrade.getString(8))){  com = setComments.getString(6); }else if (avgBus >=Integer.parseInt(setBusGrade.getString(9))){ com = setComments.getString(7); }else if (avgBus >=Integer.parseInt(setBusGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgBus >=Integer.parseInt(setBusGrade.getString(11))){ com = setComments.getString(9);}else if (avgBus >=Integer.parseInt(setBusGrade.getString(12))){ com = setComments.getString(10);}else if (avgBus >=Integer.parseInt(setBusGrade.getString(13))){ com = setComments.getString(11);}else if (avgBus >=Integer.parseInt(setBusGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell busD5 = new PdfPCell(new Paragraph(setE2.getString(35)+" "+setE2.getString(36)));
                PdfPCell busD6 = new PdfPCell(new Paragraph(com));
                PdfPCell busD7 = new PdfPCell(new Paragraph(setBusTeacher.getString(6)));
                table.addCell(busD1);
                table.addCell(busD2);
                table.addCell(busD3);
                table.addCell(busD4);
                table.addCell(busD5);
                table.addCell(busD6);
                table.addCell(busD7);

                //set total results

                int totalE2 = Integer.parseInt(setE2.getString(41));



                PdfPCell totalD1 = new PdfPCell(new Paragraph("Total"));
                PdfPCell totalD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell totalD3 = new PdfPCell(new Paragraph(String.valueOf(totalE2)));
                PdfPCell totalD4 = new PdfPCell(new Paragraph(" "));
                PdfPCell totalD5 = new PdfPCell(new Paragraph(" "));
                PdfPCell totalD6 = new PdfPCell(new Paragraph(""));
                PdfPCell totalD7 = new PdfPCell(new Paragraph(""));
                table.addCell(totalD1);
                table.addCell(totalD2);
                table.addCell(totalD3);
                table.addCell(totalD4);
                table.addCell(totalD5);
                table.addCell(totalD6);
                table.addCell(totalD7);

                //set average results

                //int add2AvgEx1 = (Math.addExact(totalEx1Mat,addAvgEx1))/3;

                int addAvgEx2 = Math.round(totalE2/7);
                //int add2AvgEx2 = (Math.addExact(totalEx2Mat,addAvgEx2))/3;


                //int add2AvgEx3 = (Math.addExact(totalEx3Mat,addAvgEx3))/3;


                PdfPCell avgD1 = new PdfPCell(new Paragraph("Average"));
                PdfPCell avgD2 = new PdfPCell(new Paragraph(" "));
                if (addAvgEx2 >= Integer.parseInt(setTotal.getString(4))) {g = "A"; } else if (addAvgEx2 >= Integer.parseInt(setTotal.getString(5))) { g = "A-"; }else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(6))){ g = "B+";}else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(7))){
                    g = "B"; }else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(8))){  g = "B-"; }else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(9))){ g = "C+"; }else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(10))){ g = "C";
                }else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(11))){ g = "C-";}else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(12))){ g = "D+";}else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(13))){ g = "D";}else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(14))){
                    g = "D-";}else {g="E"; }
                PdfPCell avgD3 = new PdfPCell(new Paragraph(String.valueOf(addAvgEx2)+" "+g));


                PdfPCell avgD4 = new PdfPCell(new Paragraph(" "));

                //float avgAvgTotal = (addAvgEx1+addAvgEx2+addAvgEx3)/3;
                int avgAvgTotal=Integer.parseInt(setE2.getString(41))/7;

                if (avgAvgTotal >= Integer.parseInt(setTotal.getString(4))) {g = "A"; } else if (avgAvgTotal >= Integer.parseInt(setTotal.getString(5))) { g = "A-"; }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(6))){ g = "B+";}else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(7))){
                    g = "B"; }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(8))){  g = "B-"; }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(9))){ g = "C+"; }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(10))){ g = "C";
                }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(11))){ g = "C-";}else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(12))){ g = "D+";}else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(13))){ g = "D";}else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(14))){
                    g = "D-";}else {g="E"; }

                PdfPCell avgD5 = new PdfPCell(new Paragraph(String.valueOf(Math.round(avgAvgTotal))+" "+g));
                PdfPCell avgD6 = new PdfPCell(new Paragraph(""));
                PdfPCell avgD7 = new PdfPCell(new Paragraph(""));
                table.addCell(avgD1);
                table.addCell(avgD2);
                table.addCell(avgD3);
                table.addCell(avgD4);
                table.addCell(avgD5);
                table.addCell(avgD6);
                table.addCell(avgD7);

                document.add(table);

                Paragraph labelSummary = new Paragraph("PERFORMANCE TREND",new Font(Font.FontFamily.TIMES_ROMAN, 8,Font.BOLD));
                labelSummary.setSpacingBefore(0);
                labelSummary.setSpacingAfter(5);
                labelSummary.setAlignment(Element.ALIGN_CENTER);
                document.add(labelSummary);

                PdfPTable tableLastSummary = new PdfPTable(8);
                tableLastSummary.setWidthPercentage(105);
                tableLastSummary.setSpacingBefore(0f);
                tableLastSummary.setSpacingAfter(0f);

                float[] colWidthSummary = {0.5f,0.5f,0.5f,0.5f,0.5f,0.5f,0.5f,0.5f};
                tableLastSummary.setWidths(colWidthSummary);
                PdfPCell cS1 = new PdfPCell(new Paragraph("FORM 1",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell cS2 = new PdfPCell(new Paragraph(" ",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell cS3 = new PdfPCell(new Paragraph("FORM 2",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell cS4 = new PdfPCell(new Paragraph(" ",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell cS5 = new PdfPCell(new Paragraph("FORM 3",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell cS6 = new PdfPCell(new Paragraph(" ",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell cS7 = new PdfPCell(new Paragraph("FORM 4",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell cS8 = new PdfPCell(new Paragraph(" ",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                tableLastSummary.addCell(cS1);
                tableLastSummary.addCell(cS2);
                tableLastSummary.addCell(cS3);
                tableLastSummary.addCell(cS4);
                tableLastSummary.addCell(cS5);
                tableLastSummary.addCell(cS6);
                tableLastSummary.addCell(cS7);
                tableLastSummary.addCell(cS8);

                PdfPCell f1t1 = new PdfPCell(new Paragraph("F1T1"));
                PdfPCell f1t1m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF1T1E2.getString(30)))/11)+" "+setF1T1E2.getString(31)));
                PdfPCell f2t1 = new PdfPCell(new Paragraph("F2T1"));
                PdfPCell f2t1m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF2T1E2.getString(30)))/11)+" "+setF2T1E2.getString(31)));
                PdfPCell f3t1 = new PdfPCell(new Paragraph("F3T1"));
                PdfPCell f3t1m = new PdfPCell(new Paragraph(String.valueOf(Integer.parseInt(setF3T1E2.getString(41))/11)+" "+setF3T1E2.getString(43)+" "+setF3T1E2.getString(42)));
                PdfPCell f4t1 = new PdfPCell(new Paragraph("F4T1"));
                PdfPCell f4t1m = new PdfPCell(new Paragraph(" "));
                tableLastSummary.addCell(f1t1);
                tableLastSummary.addCell(f1t1m);
                tableLastSummary.addCell(f2t1);
                tableLastSummary.addCell(f2t1m);
                tableLastSummary.addCell(f3t1);
                tableLastSummary.addCell(f3t1m);
                tableLastSummary.addCell(f4t1);
                tableLastSummary.addCell(f4t1m);

                PdfPCell f1t2 = new PdfPCell(new Paragraph("F1T2"));
                PdfPCell f1t2m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF1T2E2.getString(30)))/11)+" "+setF1T2E2.getString(31)));
                PdfPCell f2t2 = new PdfPCell(new Paragraph("F2T2"));
                PdfPCell f2t2m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF2T2E2.getString(30)))/11)+" "+setF2T2E2.getString(31)));
                PdfPCell f3t2 = new PdfPCell(new Paragraph("F3T2"));
                PdfPCell f3t2m = new PdfPCell(new Paragraph(String.valueOf(avgAvgTotal)+" "+setE2.getString(42)+" "+setE2.getString(43)));
                PdfPCell f4t2 = new PdfPCell(new Paragraph("F4T2"));
                PdfPCell f4t2m = new PdfPCell(new Paragraph(" "));
                tableLastSummary.addCell(f1t2);
                tableLastSummary.addCell(f1t2m);
                tableLastSummary.addCell(f2t2);
                tableLastSummary.addCell(f2t2m);
                tableLastSummary.addCell(f3t2);
                tableLastSummary.addCell(f3t2m);
                tableLastSummary.addCell(f4t2);
                tableLastSummary.addCell(f4t2m);

                PdfPCell f1t3 = new PdfPCell(new Paragraph("F1T3"));
                PdfPCell f1t3m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF1T3E2.getString(30)))/11)+" "+setF1T3E2.getString(31)));
                PdfPCell f2t3 = new PdfPCell(new Paragraph("F2T3"));
                PdfPCell f2t3m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF2T3E2.getString(30)))/11)+" "+setF2T3E2.getString(31)));
                PdfPCell f3t3 = new PdfPCell(new Paragraph("F3T3"));
                PdfPCell f3t3m = new PdfPCell(new Paragraph(" "));
                PdfPCell f4t3 = new PdfPCell(new Paragraph("F4T3"));
                PdfPCell f4t3m = new PdfPCell(new Paragraph(" "));
                tableLastSummary.addCell(f1t3);
                tableLastSummary.addCell(f1t3m);
                tableLastSummary.addCell(f2t3);
                tableLastSummary.addCell(f2t3m);
                tableLastSummary.addCell(f3t3);
                tableLastSummary.addCell(f3t3m);
                tableLastSummary.addCell(f4t3);
                tableLastSummary.addCell(f4t3m);

                document.add(tableLastSummary);
            /*
            * logo
            * */
                Image img = Image.getInstance(cname+"\\HS Results\\Web-Development.png");
                img.scaleAbsolute(100,50);
                img.setAbsolutePosition(30,750);
                document.add(img);

            /*
            * chart
            * */
                DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
                JFreeChart chart = ChartFactory.createBarChart(
                        "", "", "Marks",
                        dataSet, PlotOrientation.VERTICAL, false, false, false);
                int width=500; /* Width of our chart */
                int height=150; /* Height of our chart */
/* Get instance of CategoryPlot */
                CategoryPlot plot = chart.getCategoryPlot();
                BarRenderer renderer = (BarRenderer) plot.getRenderer();
                renderer.setSeriesPaint(0, Color.black);
                dataSet.setValue((Integer.parseInt(setF1T1E2.getString(30))/11)/7, "Marks", "F1T1");
                dataSet.setValue((Integer.parseInt(setF1T2E2.getString(30))/11)/7, "Marks", "F1T2");
                dataSet.setValue((Integer.parseInt(setF1T3E2.getString(30))/11)/7, "Marks", "F1T3");
                dataSet.setValue((Integer.parseInt(setF2T1E2.getString(30))/11)/7, "Marks", "F2T1");
                dataSet.setValue((Integer.parseInt(setF2T2E2.getString(30))/11)/7, "Marks", "F2T2");
                dataSet.setValue((Integer.parseInt(setF2T3E2.getString(30))/11)/7, "Marks", "F2T3");
                dataSet.setValue(Float.parseFloat(setF3T1E2.getString(43)), "Marks", "F3T1");
                dataSet.setValue(Float.parseFloat(setE2.getString(43)), "Marks", "F3T2");
                dataSet.setValue(0, "Marks", "F3T3");
                dataSet.setValue(0, "Marks", "F4T1");
                dataSet.setValue(0, "Marks", "F4T2");
                dataSet.setValue(0, "Marks", "F4T3");
                PdfContentByte contentByte = writer.getDirectContent();
                PdfTemplate template = contentByte.createTemplate(width, height);
                Graphics2D graphics2d = template.createGraphics(width, height,new DefaultFontMapper());
                Rectangle2D rectangle2d = new Rectangle2D.Double(0, 0, width, height);
                chart.draw(graphics2d, rectangle2d);
                graphics2d.dispose();
                contentByte.addTemplate(template, 30, 275);

                Paragraph classTeacherComments = new Paragraph("Class teacher comments: _________________________________________________________");
                Paragraph classTeacherComments1 = new Paragraph("______________________________________________________________________________");
                Paragraph principalComments =new Paragraph("Principal comments: _____________________________________________________________");
                Paragraph principalComments1 =new Paragraph("______________________________________________________________________________");

                classTeacherComments.setSpacingBefore(170);
                document.add(classTeacherComments);
                document.add(classTeacherComments1);
                document.add(principalComments);
                document.add(principalComments1);
                document.close();
            writer.close();
            infoBox("Document containing exam2 results for " + NAME + " has been created open it for printing.","Done",null);
            Desktop.getDesktop().open(new File(cname+"\\HS Results\\"+NAME+".pdf"));


            }catch (Exception e){
                e.printStackTrace();
                infoBoxError("An error occurred " + e,"Error",null);
            }}else {
            infoBoxError("You are not allowed to print","Error",null);
        }
    }

    private void printBioHisAgri(String ADM,int POS, String ALL) {
        if(printPassword.toString().equals("vic")) {
            String sqlDetails="SELECT * FROM tbl_students WHERE adm=?";
            String sqlComm = "SELECT * FROM tbl_comments";
            String sqlTotal ="SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='TOTAL'";

            String sqlEx2 = "SELECT * FROM tbl_f3_t2_ex2 WHERE adm=? ";
            String sqlF1T1Ex2 = "SELECT * FROM tbl_f1_t1_ex2 WHERE adm=?";
            String sqlF1T2Ex2 = "SELECT * FROM tbl_f1_t2_ex2 WHERE adm=?";
            String sqlF1T3Ex2 = "SELECT * FROM tbl_f1_t3_ex2 WHERE adm=?";
            String sqlF2T1Ex2 = "SELECT * FROM tbl_f2_t1_ex2 WHERE adm=?";
            String sqlF2T2Ex2 = "SELECT * FROM tbl_f2_t2_ex2 WHERE adm=?";
            String sqlF2T3Ex2 = "SELECT * FROM tbl_f2_t3_ex2 WHERE adm=?";
            String sqlF3T1Ex2 = "SELECT * FROM tbl_f3_t1_ex2 WHERE adm=?";


            String sqlEngTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='English'";
            String sqlKisTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='Kiswahili'";
            String sqlMatTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='Mathematics'";
            String sqlChemTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='Chemistry'";
            String sqlBioTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='Biology'";
            String sqlPhyTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='Physics'";
            String sqlHisTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='History'";
            String sqlGeoTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='Geography'";
            String sqlCreTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='CRE'";
            String sqlBusTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='Business'";
            String sqlAgriTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='Agriculture'";

            String sqlEngGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='ENGLISH'";
            String sqlKisGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='KISWAHILI'";
            String sqlMatGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='MATHEMATICS'";
            String sqlChemGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='CHEMISTRY'";
            String sqlBioGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='BIOLOGY'";
            String sqlPhyGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='PHYSICS'";
            String sqlHisGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='HISTORY'";
            String sqlGeoGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='GEOGRAPHY'";
            String sqlCreGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='CRE'";
            String sqlBusGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='BUSINESS'";
            String sqlAgriGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='AGRICULTURE'";

            try{
                Connection connection = Database.DBConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sqlDetails);

                PreparedStatement statementE2 = connection.prepareStatement(sqlEx2);
                PreparedStatement statementF1T1E2 = connection.prepareStatement(sqlF1T1Ex2);
                PreparedStatement statementF1T2E2 = connection.prepareStatement(sqlF1T2Ex2);
                PreparedStatement statementF1T3E2 = connection.prepareStatement(sqlF1T3Ex2);
                PreparedStatement statementF2T1E2 = connection.prepareStatement(sqlF2T1Ex2);
                PreparedStatement statementF2T2E2 = connection.prepareStatement(sqlF2T2Ex2);
                PreparedStatement statementF2T3E2 = connection.prepareStatement(sqlF2T3Ex2);
                PreparedStatement statementF3T1E2 = connection.prepareStatement(sqlF3T1Ex2);



                statement.setString(1,ADM);

                statementE2.setString(1,ADM);
                statementF1T1E2.setString(1,ADM);
                statementF1T2E2.setString(1,ADM);
                statementF1T3E2.setString(1,ADM);
                statementF2T1E2.setString(1,ADM);
                statementF2T2E2.setString(1,ADM);
                statementF2T3E2.setString(1,ADM);
                statementF3T1E2.setString(1,ADM);


                ResultSet set = statement.executeQuery();

                ResultSet setE2 = statementE2.executeQuery();
                ResultSet setF1T1E2 = statementF1T1E2.executeQuery();
                ResultSet setF1T2E2 = statementF1T2E2.executeQuery();
                ResultSet setF1T3E2 = statementF1T3E2.executeQuery();
                ResultSet setF2T1E2 = statementF2T1E2.executeQuery();
                ResultSet setF2T2E2 = statementF2T2E2.executeQuery();
                ResultSet setF2T3E2 = statementF2T3E2.executeQuery();
                ResultSet setF3T1E2 = statementF3T1E2.executeQuery();


                ResultSet setEngTeacher = connection.createStatement().executeQuery(sqlEngTeacher);
                ResultSet setKisTeacher = connection.createStatement().executeQuery(sqlKisTeacher);
                ResultSet setMatTeacher = connection.createStatement().executeQuery(sqlMatTeacher);
                ResultSet setChemTeacher = connection.createStatement().executeQuery(sqlChemTeacher);
                ResultSet setBioTeacher = connection.createStatement().executeQuery(sqlBioTeacher);
                ResultSet setPhyTeacher = connection.createStatement().executeQuery(sqlPhyTeacher);
                ResultSet setHisTeacher = connection.createStatement().executeQuery(sqlHisTeacher);
                ResultSet setGeoTeacher = connection.createStatement().executeQuery(sqlGeoTeacher);
                ResultSet setCreTeacher = connection.createStatement().executeQuery(sqlCreTeacher);
                ResultSet setBusTeacher = connection.createStatement().executeQuery(sqlBusTeacher);
                ResultSet setAgriTeacher = connection.createStatement().executeQuery(sqlAgriTeacher);

                ResultSet setEngGrade = connection.createStatement().executeQuery(sqlEngGrade);
                ResultSet setKisGrade = connection.createStatement().executeQuery(sqlKisGrade);
                ResultSet setMatGrade = connection.createStatement().executeQuery(sqlMatGrade);
                ResultSet setChemGrade = connection.createStatement().executeQuery(sqlChemGrade);
                ResultSet setBioGrade = connection.createStatement().executeQuery(sqlBioGrade);
                ResultSet setPhyGrade = connection.createStatement().executeQuery(sqlPhyGrade);
                ResultSet setHisGrade = connection.createStatement().executeQuery(sqlHisGrade);
                ResultSet setGeoGrade = connection.createStatement().executeQuery(sqlGeoGrade);
                ResultSet setCreGrade = connection.createStatement().executeQuery(sqlCreGrade);
                ResultSet setBusGrade = connection.createStatement().executeQuery(sqlBusGrade);
                ResultSet setAgriGrade = connection.createStatement().executeQuery(sqlAgriGrade);

                ResultSet setComments = connection.createStatement().executeQuery(sqlComm);
                ResultSet setTotal = connection.createStatement().executeQuery(sqlTotal);

                String names = set.getString(3)+"_"+set.getString(4)+"_"+set.getString(5);

                Document document = new Document(PageSize.A4);
            PdfWriter writer = PdfWriter.getInstance(document,new FileOutputStream(NAME+".pdf"));
            document.open();

                Paragraph schoolName = new Paragraph("SCHOOL NAME", new Font(Font.FontFamily.TIMES_ROMAN, 15,Font.BOLD));
                Paragraph address = new Paragraph("P.O BOX 22332, LOCATION", new Font(Font.FontFamily.TIMES_ROMAN, 15,Font.BOLD));
                Paragraph tell = new Paragraph("PHONE: 073293874", new Font(Font.FontFamily.TIMES_ROMAN, 15,Font.BOLD));
                Paragraph reportType = new Paragraph("Report Form", new Font(Font.FontFamily.TIMES_ROMAN, 10,Font.BOLD));
                schoolName.setAlignment(Element.ALIGN_CENTER);
                address.setAlignment(Element.ALIGN_CENTER);
                tell.setAlignment(Element.ALIGN_CENTER);
                reportType.setAlignment(Element.ALIGN_CENTER);
                document.add(schoolName);
                document.add(address);
                document.add(tell);
                document.add(reportType);

                document.add((new Paragraph("ADM: "+set.getString(2)+"  "+"NAME: "+set.getString(3)+"   "+set.getString(4)+" "+set.getString(5)+"  "+"KCPE:"+set.getString(6)+"  "+"CLASS:FORM 3"+"  "+"TERM:TERM 2",new Font(Font.FontFamily.TIMES_ROMAN, 9,Font.BOLD))));
                document.add((new Paragraph("YEAR:"+now.get(Calendar.YEAR)+" "+"POS:"+String.valueOf(POS+1)+" "+"OUT OF "+ALL,new Font(Font.FontFamily.TIMES_ROMAN, 9,Font.BOLD))));
                document.add((new Paragraph(" ")));

                PdfPTable table = new PdfPTable(7);
                table.setWidthPercentage(105);
                table.setSpacingBefore(0f);
                table.setSpacingAfter(0f);

                float[] colWidth = {1.1f,0.5f,0.5f,0.5f,0.7f,2f,1f};
                table.setWidths(colWidth);
                PdfPCell c1 = new PdfPCell(new Paragraph("SUBJECTS",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell c2 = new PdfPCell(new Paragraph("EX1",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell c3 = new PdfPCell(new Paragraph("EX2",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell c4 = new PdfPCell(new Paragraph("EX3",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell c5 = new PdfPCell(new Paragraph("AVG",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell c6 = new PdfPCell(new Paragraph("COMMENTS",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell c7 = new PdfPCell(new Paragraph("TEACHER",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                table.addCell(c1);
                table.addCell(c2);
                table.addCell(c3);
                table.addCell(c4);
                table.addCell(c5);
                table.addCell(c6);
                table.addCell(c7);

                //set eng results
                String g,com=null;
                PdfPCell engD1 = new PdfPCell(new Paragraph("English"));
                PdfPCell engD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell engD3 = new PdfPCell(new Paragraph(setE2.getString(8)+" "+setE2.getString(9)));
                PdfPCell engD4 = new PdfPCell(new Paragraph(" "));

                int avgE= Integer.parseInt(setE2.getString(8));
                if (avgE >= Integer.parseInt(setEngGrade.getString(4))) {com = setComments.getString(2); } else if (avgE >= Integer.parseInt(setEngGrade.getString(5))) { com = setComments.getString(3); }else if (avgE >=Integer.parseInt(setEngGrade.getString(6))){ com = setComments.getString(4);}else if (avgE >=Integer.parseInt(setEngGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgE >=Integer.parseInt(setEngGrade.getString(8))){  com = setComments.getString(6); }else if (avgE >=Integer.parseInt(setEngGrade.getString(9))){ com = setComments.getString(7); }else if (avgE >=Integer.parseInt(setEngGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgE >=Integer.parseInt(setEngGrade.getString(11))){ com = setComments.getString(9);}else if (avgE >=Integer.parseInt(setEngGrade.getString(12))){ com = setComments.getString(10);}else if (avgE >=Integer.parseInt(setEngGrade.getString(13))){ com = setComments.getString(11);}else if (avgE >=Integer.parseInt(setEngGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }
                PdfPCell engD5 = new PdfPCell(new Paragraph(setE2.getString(8)+" "+setE2.getString(9)));
                PdfPCell engD6 = new PdfPCell(new Paragraph(com));
                PdfPCell engD7 = new PdfPCell(new Paragraph(setEngTeacher.getString(6)));
                table.addCell(engD1);
                table.addCell(engD2);
                table.addCell(engD3);
                table.addCell(engD4);
                table.addCell(engD5);
                table.addCell(engD6);
                table.addCell(engD7);

                //set kis results
                PdfPCell kisD1 = new PdfPCell(new Paragraph("Kiswahili"));
                PdfPCell kisD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell kisD3 = new PdfPCell(new Paragraph(setE2.getString(11)+" "+setE2.getString(12)));
                PdfPCell kisD4 = new PdfPCell(new Paragraph(" "));

                int avgKis= Integer.parseInt(setE2.getString(11));
                if (avgKis >= Integer.parseInt(setKisGrade.getString(4))) {com = setComments.getString(2); } else if (avgKis >= Integer.parseInt(setKisGrade.getString(5))) { com = setComments.getString(3); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(6))){ com = setComments.getString(4);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(8))){  com = setComments.getString(6); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(9))){ com = setComments.getString(7); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgKis >=Integer.parseInt(setKisGrade.getString(11))){ com = setComments.getString(9);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(12))){ com = setComments.getString(10);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(13))){ com = setComments.getString(11);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }
                PdfPCell kisD5 = new PdfPCell(new Paragraph(setE2.getString(11)+" "+setE2.getString(12)));
                PdfPCell kisD6 = new PdfPCell(new Paragraph(com));
                PdfPCell kisD7 = new PdfPCell(new Paragraph(setKisTeacher.getString(6)));
                table.addCell(kisD1);
                table.addCell(kisD2);
                table.addCell(kisD3);
                table.addCell(kisD4);
                table.addCell(kisD5);
                table.addCell(kisD6);
                table.addCell(kisD7);

                //set mat results

                PdfPCell matD1 = new PdfPCell(new Paragraph("Mathematics"));
                PdfPCell matD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell matD3 = new PdfPCell(new Paragraph(setE2.getString(14)+" "+setE2.getString(15)));
                PdfPCell matD4 = new PdfPCell(new Paragraph(" "));

                int avgMat = Integer.parseInt(setE2.getString(14));
                if (avgMat >= Integer.parseInt(setMatGrade.getString(4))) {com = setComments.getString(2); } else if (avgMat >= Integer.parseInt(setMatGrade.getString(5))) { com = setComments.getString(3); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(6))){ com = setComments.getString(4);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(8))){  com = setComments.getString(6); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(9))){ com = setComments.getString(7); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgMat >=Integer.parseInt(setMatGrade.getString(11))){ com = setComments.getString(9);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(12))){ com = setComments.getString(10);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(13))){ com = setComments.getString(11);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell matD5 = new PdfPCell(new Paragraph(setE2.getString(14)+" "+setE2.getString(15)));
                PdfPCell matD6 = new PdfPCell(new Paragraph(com));
                PdfPCell matD7 = new PdfPCell(new Paragraph(setMatTeacher.getString(6)));
                table.addCell(matD1);
                table.addCell(matD2);
                table.addCell(matD3);
                table.addCell(matD4);
                table.addCell(matD5);
                table.addCell(matD6);
                table.addCell(matD7);

                //set Chemistry results
                PdfPCell chemD1 = new PdfPCell(new Paragraph("Chemistry"));
                PdfPCell chemD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell chemD3 = new PdfPCell(new Paragraph(setE2.getString(20)+" "+setE2.getString(21)));
                PdfPCell chemD4 = new PdfPCell(new Paragraph(" "));

                int avgChem = Integer.parseInt(setE2.getString(20));
                if (avgChem >= Integer.parseInt(setChemGrade.getString(4))) {com = setComments.getString(2); } else if (avgChem >= Integer.parseInt(setChemGrade.getString(5))) { com = setComments.getString(3); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(6))){ com = setComments.getString(4);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(8))){  com = setComments.getString(6); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(9))){ com = setComments.getString(7); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgChem >=Integer.parseInt(setChemGrade.getString(11))){ com = setComments.getString(9);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(12))){ com = setComments.getString(10);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(13))){ com = setComments.getString(11);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell chemD5 = new PdfPCell(new Paragraph(setE2.getString(20)+" "+setE2.getString(21)));
                PdfPCell chemD6 = new PdfPCell(new Paragraph(com));
                PdfPCell chemD7 = new PdfPCell(new Paragraph(setChemTeacher.getString(6)));
                table.addCell(chemD1);
                table.addCell(chemD2);
                table.addCell(chemD3);
                table.addCell(chemD4);
                table.addCell(chemD5);
                table.addCell(chemD6);
                table.addCell(chemD7);

                //set Biology Results
                PdfPCell bioD1 = new PdfPCell(new Paragraph("Biology"));
                PdfPCell bioD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell bioD3 = new PdfPCell(new Paragraph(setE2.getString(17)+" "+setE2.getString(18)));
                PdfPCell bioD4 = new PdfPCell(new Paragraph(" "));

                int avgBio = Integer.parseInt(setE2.getString(17));
                if (avgBio >= Integer.parseInt(setBioGrade.getString(4))) {com = setComments.getString(2); } else if (avgBio >= Integer.parseInt(setBioGrade.getString(5))) { com = setComments.getString(3); }else if (avgBio >=Integer.parseInt(setBioGrade.getString(6))){ com = setComments.getString(4);}else if (avgBio >=Integer.parseInt(setBioGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgBio >=Integer.parseInt(setBioGrade.getString(8))){  com = setComments.getString(6); }else if (avgBio >=Integer.parseInt(setBioGrade.getString(9))){ com = setComments.getString(7); }else if (avgBio >=Integer.parseInt(setBioGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgBio >=Integer.parseInt(setBioGrade.getString(11))){ com = setComments.getString(9);}else if (avgBio >=Integer.parseInt(setBioGrade.getString(12))){ com = setComments.getString(10);}else if (avgBio >=Integer.parseInt(setBioGrade.getString(13))){ com = setComments.getString(11);}else if (avgBio >=Integer.parseInt(setBioGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell bioD5 = new PdfPCell(new Paragraph(setE2.getString(17)+" "+setE2.getString(18)));
                PdfPCell bioD6 = new PdfPCell(new Paragraph(com));
                PdfPCell bioD7 = new PdfPCell(new Paragraph(setBioTeacher.getString(6)));
                table.addCell(bioD1);
                table.addCell(bioD2);
                table.addCell(bioD3);
                table.addCell(bioD4);
                table.addCell(bioD5);
                table.addCell(bioD6);
                table.addCell(bioD7);

                //set History results
                PdfPCell hisD1 = new PdfPCell(new Paragraph("History"));
                PdfPCell hisD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell hisD3 = new PdfPCell(new Paragraph(setE2.getString(29)+" "+setE2.getString(30)));
                PdfPCell hisD4 = new PdfPCell(new Paragraph(" "));

                int avgHis = Integer.parseInt(setE2.getString(29));
                if (avgHis >= Integer.parseInt(setHisGrade.getString(4))) {com = setComments.getString(2); } else if (avgHis >= Integer.parseInt(setHisGrade.getString(5))) { com = setComments.getString(3); }else if (avgHis >=Integer.parseInt(setHisGrade.getString(6))){ com = setComments.getString(4);}else if (avgHis >=Integer.parseInt(setHisGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgHis >=Integer.parseInt(setHisGrade.getString(8))){  com = setComments.getString(6); }else if (avgHis >=Integer.parseInt(setHisGrade.getString(9))){ com = setComments.getString(7); }else if (avgHis >=Integer.parseInt(setHisGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgHis >=Integer.parseInt(setHisGrade.getString(11))){ com = setComments.getString(9);}else if (avgHis >=Integer.parseInt(setHisGrade.getString(12))){ com = setComments.getString(10);}else if (avgHis >=Integer.parseInt(setHisGrade.getString(13))){ com = setComments.getString(11);}else if (avgHis >=Integer.parseInt(setHisGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell hisD5 = new PdfPCell(new Paragraph(setE2.getString(29)+" "+setE2.getString(30)));
                PdfPCell hisD6 = new PdfPCell(new Paragraph(com));
                PdfPCell hisD7 = new PdfPCell(new Paragraph(setHisTeacher.getString(6)));
                table.addCell(hisD1);
                table.addCell(hisD2);
                table.addCell(hisD3);
                table.addCell(hisD4);
                table.addCell(hisD5);
                table.addCell(hisD6);
                table.addCell(hisD7);



                //set Agriculture results
                PdfPCell agriD1 = new PdfPCell(new Paragraph("Agriculture"));
                PdfPCell agriD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell agriD3 = new PdfPCell(new Paragraph(setE2.getString(38)+" "+setE2.getString(39)));
                PdfPCell agriD4 = new PdfPCell(new Paragraph(" "));

                int avgAgri = Integer.parseInt(setE2.getString(38));
                if (avgAgri >= Integer.parseInt(setAgriGrade.getString(4))) {com = setComments.getString(2); } else if (avgAgri >= Integer.parseInt(setAgriGrade.getString(5))) { com = setComments.getString(3); }else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(6))){ com = setComments.getString(4);}else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(8))){  com = setComments.getString(6); }else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(9))){ com = setComments.getString(7); }else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(11))){ com = setComments.getString(9);}else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(12))){ com = setComments.getString(10);}else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(13))){ com = setComments.getString(11);}else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell agriD5 = new PdfPCell(new Paragraph(setE2.getString(38)+" "+setE2.getString(39)));
                PdfPCell agriD6 = new PdfPCell(new Paragraph(com));
                PdfPCell agriD7 = new PdfPCell(new Paragraph(setAgriTeacher.getString(6)));
                table.addCell(agriD1);
                table.addCell(agriD2);
                table.addCell(agriD3);
                table.addCell(agriD4);
                table.addCell(agriD5);
                table.addCell(agriD6);
                table.addCell(agriD7);

                //set total results

                int totalE2 = Integer.parseInt(setE2.getString(41));



                PdfPCell totalD1 = new PdfPCell(new Paragraph("Total"));
                PdfPCell totalD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell totalD3 = new PdfPCell(new Paragraph(String.valueOf(totalE2)));
                PdfPCell totalD4 = new PdfPCell(new Paragraph(" "));
                PdfPCell totalD5 = new PdfPCell(new Paragraph(" "));
                PdfPCell totalD6 = new PdfPCell(new Paragraph(""));
                PdfPCell totalD7 = new PdfPCell(new Paragraph(""));
                table.addCell(totalD1);
                table.addCell(totalD2);
                table.addCell(totalD3);
                table.addCell(totalD4);
                table.addCell(totalD5);
                table.addCell(totalD6);
                table.addCell(totalD7);

                //set average results

                //int add2AvgEx1 = (Math.addExact(totalEx1Mat,addAvgEx1))/3;

                int addAvgEx2 = Math.round(totalE2/7);
                //int add2AvgEx2 = (Math.addExact(totalEx2Mat,addAvgEx2))/3;


                //int add2AvgEx3 = (Math.addExact(totalEx3Mat,addAvgEx3))/3;


                PdfPCell avgD1 = new PdfPCell(new Paragraph("Average"));
                PdfPCell avgD2 = new PdfPCell(new Paragraph(" "));
                if (addAvgEx2 >= Integer.parseInt(setTotal.getString(4))) {g = "A"; } else if (addAvgEx2 >= Integer.parseInt(setTotal.getString(5))) { g = "A-"; }else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(6))){ g = "B+";}else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(7))){
                    g = "B"; }else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(8))){  g = "B-"; }else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(9))){ g = "C+"; }else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(10))){ g = "C";
                }else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(11))){ g = "C-";}else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(12))){ g = "D+";}else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(13))){ g = "D";}else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(14))){
                    g = "D-";}else {g="E"; }
                PdfPCell avgD3 = new PdfPCell(new Paragraph(String.valueOf(addAvgEx2)+" "+g));


                PdfPCell avgD4 = new PdfPCell(new Paragraph(" "));

                //float avgAvgTotal = (addAvgEx1+addAvgEx2+addAvgEx3)/3;
                int avgAvgTotal=Integer.parseInt(setE2.getString(41))/7;

                if (avgAvgTotal >= Integer.parseInt(setTotal.getString(4))) {g = "A"; } else if (avgAvgTotal >= Integer.parseInt(setTotal.getString(5))) { g = "A-"; }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(6))){ g = "B+";}else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(7))){
                    g = "B"; }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(8))){  g = "B-"; }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(9))){ g = "C+"; }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(10))){ g = "C";
                }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(11))){ g = "C-";}else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(12))){ g = "D+";}else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(13))){ g = "D";}else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(14))){
                    g = "D-";}else {g="E"; }

                PdfPCell avgD5 = new PdfPCell(new Paragraph(String.valueOf(Math.round(avgAvgTotal))+" "+g));
                PdfPCell avgD6 = new PdfPCell(new Paragraph(""));
                PdfPCell avgD7 = new PdfPCell(new Paragraph(""));
                table.addCell(avgD1);
                table.addCell(avgD2);
                table.addCell(avgD3);
                table.addCell(avgD4);
                table.addCell(avgD5);
                table.addCell(avgD6);
                table.addCell(avgD7);

                document.add(table);

                Paragraph labelSummary = new Paragraph("PERFORMANCE TREND",new Font(Font.FontFamily.TIMES_ROMAN, 8,Font.BOLD));
                labelSummary.setSpacingBefore(0);
                labelSummary.setSpacingAfter(5);
                labelSummary.setAlignment(Element.ALIGN_CENTER);
                document.add(labelSummary);

                PdfPTable tableLastSummary = new PdfPTable(8);
                tableLastSummary.setWidthPercentage(105);
                tableLastSummary.setSpacingBefore(0f);
                tableLastSummary.setSpacingAfter(0f);

                float[] colWidthSummary = {0.5f,0.5f,0.5f,0.5f,0.5f,0.5f,0.5f,0.5f};
                tableLastSummary.setWidths(colWidthSummary);
                PdfPCell cS1 = new PdfPCell(new Paragraph("FORM 1",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell cS2 = new PdfPCell(new Paragraph(" ",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell cS3 = new PdfPCell(new Paragraph("FORM 2",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell cS4 = new PdfPCell(new Paragraph(" ",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell cS5 = new PdfPCell(new Paragraph("FORM 3",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell cS6 = new PdfPCell(new Paragraph(" ",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell cS7 = new PdfPCell(new Paragraph("FORM 4",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell cS8 = new PdfPCell(new Paragraph(" ",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                tableLastSummary.addCell(cS1);
                tableLastSummary.addCell(cS2);
                tableLastSummary.addCell(cS3);
                tableLastSummary.addCell(cS4);
                tableLastSummary.addCell(cS5);
                tableLastSummary.addCell(cS6);
                tableLastSummary.addCell(cS7);
                tableLastSummary.addCell(cS8);

                PdfPCell f1t1 = new PdfPCell(new Paragraph("F1T1"));
                PdfPCell f1t1m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF1T1E2.getString(30)))/11)+" "+setF1T1E2.getString(31)));
                PdfPCell f2t1 = new PdfPCell(new Paragraph("F2T1"));
                PdfPCell f2t1m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF2T1E2.getString(30)))/11)+" "+setF2T1E2.getString(31)));
                PdfPCell f3t1 = new PdfPCell(new Paragraph("F3T1"));
                PdfPCell f3t1m = new PdfPCell(new Paragraph(String.valueOf(Integer.parseInt(setF3T1E2.getString(41))/11)+" "+setF3T1E2.getString(43)+" "+setF3T1E2.getString(42)));
                PdfPCell f4t1 = new PdfPCell(new Paragraph("F4T1"));
                PdfPCell f4t1m = new PdfPCell(new Paragraph(" "));
                tableLastSummary.addCell(f1t1);
                tableLastSummary.addCell(f1t1m);
                tableLastSummary.addCell(f2t1);
                tableLastSummary.addCell(f2t1m);
                tableLastSummary.addCell(f3t1);
                tableLastSummary.addCell(f3t1m);
                tableLastSummary.addCell(f4t1);
                tableLastSummary.addCell(f4t1m);

                PdfPCell f1t2 = new PdfPCell(new Paragraph("F1T2"));
                PdfPCell f1t2m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF1T2E2.getString(30)))/11)+" "+setF1T2E2.getString(31)));
                PdfPCell f2t2 = new PdfPCell(new Paragraph("F2T2"));
                PdfPCell f2t2m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF2T2E2.getString(30)))/11)+" "+setF2T2E2.getString(31)));
                PdfPCell f3t2 = new PdfPCell(new Paragraph("F3T2"));
                PdfPCell f3t2m = new PdfPCell(new Paragraph(String.valueOf(avgAvgTotal)+" "+setE2.getString(42)+" "+setE2.getString(43)));
                PdfPCell f4t2 = new PdfPCell(new Paragraph("F4T2"));
                PdfPCell f4t2m = new PdfPCell(new Paragraph(" "));
                tableLastSummary.addCell(f1t2);
                tableLastSummary.addCell(f1t2m);
                tableLastSummary.addCell(f2t2);
                tableLastSummary.addCell(f2t2m);
                tableLastSummary.addCell(f3t2);
                tableLastSummary.addCell(f3t2m);
                tableLastSummary.addCell(f4t2);
                tableLastSummary.addCell(f4t2m);

                PdfPCell f1t3 = new PdfPCell(new Paragraph("F1T3"));
                PdfPCell f1t3m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF1T3E2.getString(30)))/11)+" "+setF1T3E2.getString(31)));
                PdfPCell f2t3 = new PdfPCell(new Paragraph("F2T3"));
                PdfPCell f2t3m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF2T3E2.getString(30)))/11)+" "+setF2T3E2.getString(31)));
                PdfPCell f3t3 = new PdfPCell(new Paragraph("F3T3"));
                PdfPCell f3t3m = new PdfPCell(new Paragraph(" "));
                PdfPCell f4t3 = new PdfPCell(new Paragraph("F4T3"));
                PdfPCell f4t3m = new PdfPCell(new Paragraph(" "));
                tableLastSummary.addCell(f1t3);
                tableLastSummary.addCell(f1t3m);
                tableLastSummary.addCell(f2t3);
                tableLastSummary.addCell(f2t3m);
                tableLastSummary.addCell(f3t3);
                tableLastSummary.addCell(f3t3m);
                tableLastSummary.addCell(f4t3);
                tableLastSummary.addCell(f4t3m);

                document.add(tableLastSummary);
            /*
            * logo
            * */
                Image img = Image.getInstance(cname+"\\HS Results\\Web-Development.png");
                img.scaleAbsolute(100,50);
                img.setAbsolutePosition(30,750);
                document.add(img);

            /*
            * chart
            * */
                DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
                JFreeChart chart = ChartFactory.createBarChart(
                        "", "", "Marks",
                        dataSet, PlotOrientation.VERTICAL, false, false, false);
                int width=500; /* Width of our chart */
                int height=150; /* Height of our chart */
/* Get instance of CategoryPlot */
                CategoryPlot plot = chart.getCategoryPlot();
                BarRenderer renderer = (BarRenderer) plot.getRenderer();
                renderer.setSeriesPaint(0, Color.black);
                dataSet.setValue((Integer.parseInt(setF1T1E2.getString(30))/11)/7, "Marks", "F1T1");
                dataSet.setValue((Integer.parseInt(setF1T2E2.getString(30))/11)/7, "Marks", "F1T2");
                dataSet.setValue((Integer.parseInt(setF1T3E2.getString(30))/11)/7, "Marks", "F1T3");
                dataSet.setValue((Integer.parseInt(setF2T1E2.getString(30))/11)/7, "Marks", "F2T1");
                dataSet.setValue((Integer.parseInt(setF2T2E2.getString(30))/11)/7, "Marks", "F2T2");
                dataSet.setValue((Integer.parseInt(setF2T3E2.getString(30))/11)/7, "Marks", "F2T3");
                dataSet.setValue(Float.parseFloat(setF3T1E2.getString(43)), "Marks", "F3T1");
                dataSet.setValue(Float.parseFloat(setE2.getString(43)), "Marks", "F3T2");
                dataSet.setValue(0, "Marks", "F3T3");
                dataSet.setValue(0, "Marks", "F4T1");
                dataSet.setValue(0, "Marks", "F4T2");
                dataSet.setValue(0, "Marks", "F4T3");
                PdfContentByte contentByte = writer.getDirectContent();
                PdfTemplate template = contentByte.createTemplate(width, height);
                Graphics2D graphics2d = template.createGraphics(width, height,new DefaultFontMapper());
                Rectangle2D rectangle2d = new Rectangle2D.Double(0, 0, width, height);
                chart.draw(graphics2d, rectangle2d);
                graphics2d.dispose();
                contentByte.addTemplate(template, 30, 275);

                Paragraph classTeacherComments = new Paragraph("Class teacher comments: _________________________________________________________");
                Paragraph classTeacherComments1 = new Paragraph("______________________________________________________________________________");
                Paragraph principalComments =new Paragraph("Principal comments: _____________________________________________________________");
                Paragraph principalComments1 =new Paragraph("______________________________________________________________________________");

                classTeacherComments.setSpacingBefore(170);
                document.add(classTeacherComments);
                document.add(classTeacherComments1);
                document.add(principalComments);
                document.add(principalComments1);
                document.close();
            writer.close();
            infoBox("Document containing exam2 results for " + NAME + " has been created open it for printing.","Done",null);
            Desktop.getDesktop().open(new File(cname+"\\HS Results\\"+NAME+".pdf"));


            }catch (Exception e){
                e.printStackTrace();
                infoBoxError("An error occurred " + e,"Error",null);
            }}else {
            infoBoxError("You are not allowed to print","Error",null);
        }
    }

    private void printBioHisBus(String ADM,int POS, String ALL) {
        if(printPassword.toString().equals("vic")) {
            String sqlDetails="SELECT * FROM tbl_students WHERE adm=?";
            String sqlComm = "SELECT * FROM tbl_comments";
            String sqlTotal ="SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='TOTAL'";

            String sqlEx2 = "SELECT * FROM tbl_f3_t2_ex2 WHERE adm=? ";
            String sqlF1T1Ex2 = "SELECT * FROM tbl_f1_t1_ex2 WHERE adm=?";
            String sqlF1T2Ex2 = "SELECT * FROM tbl_f1_t2_ex2 WHERE adm=?";
            String sqlF1T3Ex2 = "SELECT * FROM tbl_f1_t3_ex2 WHERE adm=?";
            String sqlF2T1Ex2 = "SELECT * FROM tbl_f2_t1_ex2 WHERE adm=?";
            String sqlF2T2Ex2 = "SELECT * FROM tbl_f2_t2_ex2 WHERE adm=?";
            String sqlF2T3Ex2 = "SELECT * FROM tbl_f2_t3_ex2 WHERE adm=?";
            String sqlF3T1Ex2 = "SELECT * FROM tbl_f3_t1_ex2 WHERE adm=?";


            String sqlEngTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='English'";
            String sqlKisTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='Kiswahili'";
            String sqlMatTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='Mathematics'";
            String sqlChemTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='Chemistry'";
            String sqlBioTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='Biology'";
            String sqlPhyTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='Physics'";
            String sqlHisTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='History'";
            String sqlGeoTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='Geography'";
            String sqlCreTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='CRE'";
            String sqlBusTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='Business'";
            String sqlAgriTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='Agriculture'";

            String sqlEngGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='ENGLISH'";
            String sqlKisGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='KISWAHILI'";
            String sqlMatGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='MATHEMATICS'";
            String sqlChemGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='CHEMISTRY'";
            String sqlBioGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='BIOLOGY'";
            String sqlPhyGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='PHYSICS'";
            String sqlHisGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='HISTORY'";
            String sqlGeoGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='GEOGRAPHY'";
            String sqlCreGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='CRE'";
            String sqlBusGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='BUSINESS'";
            String sqlAgriGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='AGRICULTURE'";

            try{
                Connection connection = Database.DBConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sqlDetails);

                PreparedStatement statementE2 = connection.prepareStatement(sqlEx2);
                PreparedStatement statementF1T1E2 = connection.prepareStatement(sqlF1T1Ex2);
                PreparedStatement statementF1T2E2 = connection.prepareStatement(sqlF1T2Ex2);
                PreparedStatement statementF1T3E2 = connection.prepareStatement(sqlF1T3Ex2);
                PreparedStatement statementF2T1E2 = connection.prepareStatement(sqlF2T1Ex2);
                PreparedStatement statementF2T2E2 = connection.prepareStatement(sqlF2T2Ex2);
                PreparedStatement statementF2T3E2 = connection.prepareStatement(sqlF2T3Ex2);
                PreparedStatement statementF3T1E2 = connection.prepareStatement(sqlF3T1Ex2);



                statement.setString(1,ADM);

                statementE2.setString(1,ADM);
                statementF1T1E2.setString(1,ADM);
                statementF1T2E2.setString(1,ADM);
                statementF1T3E2.setString(1,ADM);
                statementF2T1E2.setString(1,ADM);
                statementF2T2E2.setString(1,ADM);
                statementF2T3E2.setString(1,ADM);
                statementF3T1E2.setString(1,ADM);


                ResultSet set = statement.executeQuery();

                ResultSet setE2 = statementE2.executeQuery();
                ResultSet setF1T1E2 = statementF1T1E2.executeQuery();
                ResultSet setF1T2E2 = statementF1T2E2.executeQuery();
                ResultSet setF1T3E2 = statementF1T3E2.executeQuery();
                ResultSet setF2T1E2 = statementF2T1E2.executeQuery();
                ResultSet setF2T2E2 = statementF2T2E2.executeQuery();
                ResultSet setF2T3E2 = statementF2T3E2.executeQuery();
                ResultSet setF3T1E2 = statementF3T1E2.executeQuery();


                ResultSet setEngTeacher = connection.createStatement().executeQuery(sqlEngTeacher);
                ResultSet setKisTeacher = connection.createStatement().executeQuery(sqlKisTeacher);
                ResultSet setMatTeacher = connection.createStatement().executeQuery(sqlMatTeacher);
                ResultSet setChemTeacher = connection.createStatement().executeQuery(sqlChemTeacher);
                ResultSet setBioTeacher = connection.createStatement().executeQuery(sqlBioTeacher);
                ResultSet setPhyTeacher = connection.createStatement().executeQuery(sqlPhyTeacher);
                ResultSet setHisTeacher = connection.createStatement().executeQuery(sqlHisTeacher);
                ResultSet setGeoTeacher = connection.createStatement().executeQuery(sqlGeoTeacher);
                ResultSet setCreTeacher = connection.createStatement().executeQuery(sqlCreTeacher);
                ResultSet setBusTeacher = connection.createStatement().executeQuery(sqlBusTeacher);
                ResultSet setAgriTeacher = connection.createStatement().executeQuery(sqlAgriTeacher);

                ResultSet setEngGrade = connection.createStatement().executeQuery(sqlEngGrade);
                ResultSet setKisGrade = connection.createStatement().executeQuery(sqlKisGrade);
                ResultSet setMatGrade = connection.createStatement().executeQuery(sqlMatGrade);
                ResultSet setChemGrade = connection.createStatement().executeQuery(sqlChemGrade);
                ResultSet setBioGrade = connection.createStatement().executeQuery(sqlBioGrade);
                ResultSet setPhyGrade = connection.createStatement().executeQuery(sqlPhyGrade);
                ResultSet setHisGrade = connection.createStatement().executeQuery(sqlHisGrade);
                ResultSet setGeoGrade = connection.createStatement().executeQuery(sqlGeoGrade);
                ResultSet setCreGrade = connection.createStatement().executeQuery(sqlCreGrade);
                ResultSet setBusGrade = connection.createStatement().executeQuery(sqlBusGrade);
                ResultSet setAgriGrade = connection.createStatement().executeQuery(sqlAgriGrade);

                ResultSet setComments = connection.createStatement().executeQuery(sqlComm);
                ResultSet setTotal = connection.createStatement().executeQuery(sqlTotal);

                String names = set.getString(3)+"_"+set.getString(4)+"_"+set.getString(5);

                Document document = new Document(PageSize.A4);
            PdfWriter writer = PdfWriter.getInstance(document,new FileOutputStream(NAME+".pdf"));
            document.open();

                Paragraph schoolName = new Paragraph("SCHOOL NAME", new Font(Font.FontFamily.TIMES_ROMAN, 15,Font.BOLD));
                Paragraph address = new Paragraph("P.O BOX 22332, LOCATION", new Font(Font.FontFamily.TIMES_ROMAN, 15,Font.BOLD));
                Paragraph tell = new Paragraph("PHONE: 073293874", new Font(Font.FontFamily.TIMES_ROMAN, 15,Font.BOLD));
                Paragraph reportType = new Paragraph("Report Form", new Font(Font.FontFamily.TIMES_ROMAN, 10,Font.BOLD));
                schoolName.setAlignment(Element.ALIGN_CENTER);
                address.setAlignment(Element.ALIGN_CENTER);
                tell.setAlignment(Element.ALIGN_CENTER);
                reportType.setAlignment(Element.ALIGN_CENTER);
                document.add(schoolName);
                document.add(address);
                document.add(tell);
                document.add(reportType);

                document.add((new Paragraph("ADM: "+set.getString(2)+"  "+"NAME: "+set.getString(3)+"   "+set.getString(4)+" "+set.getString(5)+"  "+"KCPE:"+set.getString(6)+"  "+"CLASS:FORM 3"+"  "+"TERM:TERM 2",new Font(Font.FontFamily.TIMES_ROMAN, 9,Font.BOLD))));
                document.add((new Paragraph("YEAR:"+now.get(Calendar.YEAR)+" "+"POS:"+String.valueOf(POS+1)+" "+"OUT OF "+ALL,new Font(Font.FontFamily.TIMES_ROMAN, 9,Font.BOLD))));
                document.add((new Paragraph(" ")));

                PdfPTable table = new PdfPTable(7);
                table.setWidthPercentage(105);
                table.setSpacingBefore(0f);
                table.setSpacingAfter(0f);

                float[] colWidth = {1.1f,0.5f,0.5f,0.5f,0.7f,2f,1f};
                table.setWidths(colWidth);
                PdfPCell c1 = new PdfPCell(new Paragraph("SUBJECTS",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell c2 = new PdfPCell(new Paragraph("EX1",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell c3 = new PdfPCell(new Paragraph("EX2",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell c4 = new PdfPCell(new Paragraph("EX3",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell c5 = new PdfPCell(new Paragraph("AVG",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell c6 = new PdfPCell(new Paragraph("COMMENTS",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell c7 = new PdfPCell(new Paragraph("TEACHER",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                table.addCell(c1);
                table.addCell(c2);
                table.addCell(c3);
                table.addCell(c4);
                table.addCell(c5);
                table.addCell(c6);
                table.addCell(c7);

                //set eng results
                String g,com=null;
                PdfPCell engD1 = new PdfPCell(new Paragraph("English"));
                PdfPCell engD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell engD3 = new PdfPCell(new Paragraph(setE2.getString(8)+" "+setE2.getString(9)));
                PdfPCell engD4 = new PdfPCell(new Paragraph(" "));

                int avgE= Integer.parseInt(setE2.getString(8));
                if (avgE >= Integer.parseInt(setEngGrade.getString(4))) {com = setComments.getString(2); } else if (avgE >= Integer.parseInt(setEngGrade.getString(5))) { com = setComments.getString(3); }else if (avgE >=Integer.parseInt(setEngGrade.getString(6))){ com = setComments.getString(4);}else if (avgE >=Integer.parseInt(setEngGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgE >=Integer.parseInt(setEngGrade.getString(8))){  com = setComments.getString(6); }else if (avgE >=Integer.parseInt(setEngGrade.getString(9))){ com = setComments.getString(7); }else if (avgE >=Integer.parseInt(setEngGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgE >=Integer.parseInt(setEngGrade.getString(11))){ com = setComments.getString(9);}else if (avgE >=Integer.parseInt(setEngGrade.getString(12))){ com = setComments.getString(10);}else if (avgE >=Integer.parseInt(setEngGrade.getString(13))){ com = setComments.getString(11);}else if (avgE >=Integer.parseInt(setEngGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }
                PdfPCell engD5 = new PdfPCell(new Paragraph(setE2.getString(8)+" "+setE2.getString(9)));
                PdfPCell engD6 = new PdfPCell(new Paragraph(com));
                PdfPCell engD7 = new PdfPCell(new Paragraph(setEngTeacher.getString(6)));
                table.addCell(engD1);
                table.addCell(engD2);
                table.addCell(engD3);
                table.addCell(engD4);
                table.addCell(engD5);
                table.addCell(engD6);
                table.addCell(engD7);

                //set kis results
                PdfPCell kisD1 = new PdfPCell(new Paragraph("Kiswahili"));
                PdfPCell kisD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell kisD3 = new PdfPCell(new Paragraph(setE2.getString(11)+" "+setE2.getString(12)));
                PdfPCell kisD4 = new PdfPCell(new Paragraph(" "));

                int avgKis= Integer.parseInt(setE2.getString(11));
                if (avgKis >= Integer.parseInt(setKisGrade.getString(4))) {com = setComments.getString(2); } else if (avgKis >= Integer.parseInt(setKisGrade.getString(5))) { com = setComments.getString(3); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(6))){ com = setComments.getString(4);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(8))){  com = setComments.getString(6); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(9))){ com = setComments.getString(7); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgKis >=Integer.parseInt(setKisGrade.getString(11))){ com = setComments.getString(9);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(12))){ com = setComments.getString(10);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(13))){ com = setComments.getString(11);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }
                PdfPCell kisD5 = new PdfPCell(new Paragraph(setE2.getString(11)+" "+setE2.getString(12)));
                PdfPCell kisD6 = new PdfPCell(new Paragraph(com));
                PdfPCell kisD7 = new PdfPCell(new Paragraph(setKisTeacher.getString(6)));
                table.addCell(kisD1);
                table.addCell(kisD2);
                table.addCell(kisD3);
                table.addCell(kisD4);
                table.addCell(kisD5);
                table.addCell(kisD6);
                table.addCell(kisD7);

                //set mat results

                PdfPCell matD1 = new PdfPCell(new Paragraph("Mathematics"));
                PdfPCell matD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell matD3 = new PdfPCell(new Paragraph(setE2.getString(14)+" "+setE2.getString(15)));
                PdfPCell matD4 = new PdfPCell(new Paragraph(" "));

                int avgMat = Integer.parseInt(setE2.getString(14));
                if (avgMat >= Integer.parseInt(setMatGrade.getString(4))) {com = setComments.getString(2); } else if (avgMat >= Integer.parseInt(setMatGrade.getString(5))) { com = setComments.getString(3); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(6))){ com = setComments.getString(4);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(8))){  com = setComments.getString(6); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(9))){ com = setComments.getString(7); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgMat >=Integer.parseInt(setMatGrade.getString(11))){ com = setComments.getString(9);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(12))){ com = setComments.getString(10);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(13))){ com = setComments.getString(11);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell matD5 = new PdfPCell(new Paragraph(setE2.getString(14)+" "+setE2.getString(15)));
                PdfPCell matD6 = new PdfPCell(new Paragraph(com));
                PdfPCell matD7 = new PdfPCell(new Paragraph(setMatTeacher.getString(6)));
                table.addCell(matD1);
                table.addCell(matD2);
                table.addCell(matD3);
                table.addCell(matD4);
                table.addCell(matD5);
                table.addCell(matD6);
                table.addCell(matD7);

                //set Chemistry results
                PdfPCell chemD1 = new PdfPCell(new Paragraph("Chemistry"));
                PdfPCell chemD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell chemD3 = new PdfPCell(new Paragraph(setE2.getString(20)+" "+setE2.getString(21)));
                PdfPCell chemD4 = new PdfPCell(new Paragraph(" "));

                int avgChem = Integer.parseInt(setE2.getString(20));
                if (avgChem >= Integer.parseInt(setChemGrade.getString(4))) {com = setComments.getString(2); } else if (avgChem >= Integer.parseInt(setChemGrade.getString(5))) { com = setComments.getString(3); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(6))){ com = setComments.getString(4);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(8))){  com = setComments.getString(6); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(9))){ com = setComments.getString(7); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgChem >=Integer.parseInt(setChemGrade.getString(11))){ com = setComments.getString(9);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(12))){ com = setComments.getString(10);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(13))){ com = setComments.getString(11);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell chemD5 = new PdfPCell(new Paragraph(setE2.getString(20)+" "+setE2.getString(21)));
                PdfPCell chemD6 = new PdfPCell(new Paragraph(com));
                PdfPCell chemD7 = new PdfPCell(new Paragraph(setChemTeacher.getString(6)));
                table.addCell(chemD1);
                table.addCell(chemD2);
                table.addCell(chemD3);
                table.addCell(chemD4);
                table.addCell(chemD5);
                table.addCell(chemD6);
                table.addCell(chemD7);

                //set Biology Results
                PdfPCell bioD1 = new PdfPCell(new Paragraph("Biology"));
                PdfPCell bioD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell bioD3 = new PdfPCell(new Paragraph(setE2.getString(17)+" "+setE2.getString(18)));
                PdfPCell bioD4 = new PdfPCell(new Paragraph(" "));

                int avgBio = Integer.parseInt(setE2.getString(17));
                if (avgBio >= Integer.parseInt(setBioGrade.getString(4))) {com = setComments.getString(2); } else if (avgBio >= Integer.parseInt(setBioGrade.getString(5))) { com = setComments.getString(3); }else if (avgBio >=Integer.parseInt(setBioGrade.getString(6))){ com = setComments.getString(4);}else if (avgBio >=Integer.parseInt(setBioGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgBio >=Integer.parseInt(setBioGrade.getString(8))){  com = setComments.getString(6); }else if (avgBio >=Integer.parseInt(setBioGrade.getString(9))){ com = setComments.getString(7); }else if (avgBio >=Integer.parseInt(setBioGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgBio >=Integer.parseInt(setBioGrade.getString(11))){ com = setComments.getString(9);}else if (avgBio >=Integer.parseInt(setBioGrade.getString(12))){ com = setComments.getString(10);}else if (avgBio >=Integer.parseInt(setBioGrade.getString(13))){ com = setComments.getString(11);}else if (avgBio >=Integer.parseInt(setBioGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell bioD5 = new PdfPCell(new Paragraph(setE2.getString(17)+" "+setE2.getString(18)));
                PdfPCell bioD6 = new PdfPCell(new Paragraph(com));
                PdfPCell bioD7 = new PdfPCell(new Paragraph(setBioTeacher.getString(6)));
                table.addCell(bioD1);
                table.addCell(bioD2);
                table.addCell(bioD3);
                table.addCell(bioD4);
                table.addCell(bioD5);
                table.addCell(bioD6);
                table.addCell(bioD7);

                //set History results
                PdfPCell hisD1 = new PdfPCell(new Paragraph("History"));
                PdfPCell hisD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell hisD3 = new PdfPCell(new Paragraph(setE2.getString(29)+" "+setE2.getString(30)));
                PdfPCell hisD4 = new PdfPCell(new Paragraph(" "));

                int avgHis = Integer.parseInt(setE2.getString(29));
                if (avgHis >= Integer.parseInt(setHisGrade.getString(4))) {com = setComments.getString(2); } else if (avgHis >= Integer.parseInt(setHisGrade.getString(5))) { com = setComments.getString(3); }else if (avgHis >=Integer.parseInt(setHisGrade.getString(6))){ com = setComments.getString(4);}else if (avgHis >=Integer.parseInt(setHisGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgHis >=Integer.parseInt(setHisGrade.getString(8))){  com = setComments.getString(6); }else if (avgHis >=Integer.parseInt(setHisGrade.getString(9))){ com = setComments.getString(7); }else if (avgHis >=Integer.parseInt(setHisGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgHis >=Integer.parseInt(setHisGrade.getString(11))){ com = setComments.getString(9);}else if (avgHis >=Integer.parseInt(setHisGrade.getString(12))){ com = setComments.getString(10);}else if (avgHis >=Integer.parseInt(setHisGrade.getString(13))){ com = setComments.getString(11);}else if (avgHis >=Integer.parseInt(setHisGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell hisD5 = new PdfPCell(new Paragraph(setE2.getString(29)+" "+setE2.getString(30)));
                PdfPCell hisD6 = new PdfPCell(new Paragraph(com));
                PdfPCell hisD7 = new PdfPCell(new Paragraph(setHisTeacher.getString(6)));
                table.addCell(hisD1);
                table.addCell(hisD2);
                table.addCell(hisD3);
                table.addCell(hisD4);
                table.addCell(hisD5);
                table.addCell(hisD6);
                table.addCell(hisD7);

                //set Business results
                PdfPCell busD1 = new PdfPCell(new Paragraph("Business"));
                PdfPCell busD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell busD3 = new PdfPCell(new Paragraph(setE2.getString(35)+" "+setE2.getString(36)));
                PdfPCell busD4 = new PdfPCell(new Paragraph(" "));

                int avgBus = Integer.parseInt(setE2.getString(35));
                if (avgBus >= Integer.parseInt(setBusGrade.getString(4))) {com = setComments.getString(2); } else if (avgBus >= Integer.parseInt(setBusGrade.getString(5))) { com = setComments.getString(3); }else if (avgBus >=Integer.parseInt(setBusGrade.getString(6))){ com = setComments.getString(4);}else if (avgBus >=Integer.parseInt(setBusGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgBus >=Integer.parseInt(setBusGrade.getString(8))){  com = setComments.getString(6); }else if (avgBus >=Integer.parseInt(setBusGrade.getString(9))){ com = setComments.getString(7); }else if (avgBus >=Integer.parseInt(setBusGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgBus >=Integer.parseInt(setBusGrade.getString(11))){ com = setComments.getString(9);}else if (avgBus >=Integer.parseInt(setBusGrade.getString(12))){ com = setComments.getString(10);}else if (avgBus >=Integer.parseInt(setBusGrade.getString(13))){ com = setComments.getString(11);}else if (avgBus >=Integer.parseInt(setBusGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell busD5 = new PdfPCell(new Paragraph(setE2.getString(35)+" "+setE2.getString(36)));
                PdfPCell busD6 = new PdfPCell(new Paragraph(com));
                PdfPCell busD7 = new PdfPCell(new Paragraph(setBusTeacher.getString(6)));
                table.addCell(busD1);
                table.addCell(busD2);
                table.addCell(busD3);
                table.addCell(busD4);
                table.addCell(busD5);
                table.addCell(busD6);
                table.addCell(busD7);

                //set total results

                int totalE2 = Integer.parseInt(setE2.getString(41));



                PdfPCell totalD1 = new PdfPCell(new Paragraph("Total"));
                PdfPCell totalD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell totalD3 = new PdfPCell(new Paragraph(String.valueOf(totalE2)));
                PdfPCell totalD4 = new PdfPCell(new Paragraph(" "));
                PdfPCell totalD5 = new PdfPCell(new Paragraph(" "));
                PdfPCell totalD6 = new PdfPCell(new Paragraph(""));
                PdfPCell totalD7 = new PdfPCell(new Paragraph(""));
                table.addCell(totalD1);
                table.addCell(totalD2);
                table.addCell(totalD3);
                table.addCell(totalD4);
                table.addCell(totalD5);
                table.addCell(totalD6);
                table.addCell(totalD7);

                //set average results

                //int add2AvgEx1 = (Math.addExact(totalEx1Mat,addAvgEx1))/3;

                int addAvgEx2 = Math.round(totalE2/7);
                //int add2AvgEx2 = (Math.addExact(totalEx2Mat,addAvgEx2))/3;


                //int add2AvgEx3 = (Math.addExact(totalEx3Mat,addAvgEx3))/3;


                PdfPCell avgD1 = new PdfPCell(new Paragraph("Average"));
                PdfPCell avgD2 = new PdfPCell(new Paragraph(" "));
                if (addAvgEx2 >= Integer.parseInt(setTotal.getString(4))) {g = "A"; } else if (addAvgEx2 >= Integer.parseInt(setTotal.getString(5))) { g = "A-"; }else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(6))){ g = "B+";}else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(7))){
                    g = "B"; }else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(8))){  g = "B-"; }else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(9))){ g = "C+"; }else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(10))){ g = "C";
                }else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(11))){ g = "C-";}else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(12))){ g = "D+";}else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(13))){ g = "D";}else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(14))){
                    g = "D-";}else {g="E"; }
                PdfPCell avgD3 = new PdfPCell(new Paragraph(String.valueOf(addAvgEx2)+" "+g));


                PdfPCell avgD4 = new PdfPCell(new Paragraph(" "));

                //float avgAvgTotal = (addAvgEx1+addAvgEx2+addAvgEx3)/3;
                int avgAvgTotal=Integer.parseInt(setE2.getString(41))/7;

                if (avgAvgTotal >= Integer.parseInt(setTotal.getString(4))) {g = "A"; } else if (avgAvgTotal >= Integer.parseInt(setTotal.getString(5))) { g = "A-"; }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(6))){ g = "B+";}else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(7))){
                    g = "B"; }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(8))){  g = "B-"; }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(9))){ g = "C+"; }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(10))){ g = "C";
                }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(11))){ g = "C-";}else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(12))){ g = "D+";}else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(13))){ g = "D";}else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(14))){
                    g = "D-";}else {g="E"; }

                PdfPCell avgD5 = new PdfPCell(new Paragraph(String.valueOf(Math.round(avgAvgTotal))+" "+g));
                PdfPCell avgD6 = new PdfPCell(new Paragraph(""));
                PdfPCell avgD7 = new PdfPCell(new Paragraph(""));
                table.addCell(avgD1);
                table.addCell(avgD2);
                table.addCell(avgD3);
                table.addCell(avgD4);
                table.addCell(avgD5);
                table.addCell(avgD6);
                table.addCell(avgD7);

                document.add(table);

                Paragraph labelSummary = new Paragraph("PERFORMANCE TREND",new Font(Font.FontFamily.TIMES_ROMAN, 8,Font.BOLD));
                labelSummary.setSpacingBefore(0);
                labelSummary.setSpacingAfter(5);
                labelSummary.setAlignment(Element.ALIGN_CENTER);
                document.add(labelSummary);

                PdfPTable tableLastSummary = new PdfPTable(8);
                tableLastSummary.setWidthPercentage(105);
                tableLastSummary.setSpacingBefore(0f);
                tableLastSummary.setSpacingAfter(0f);

                float[] colWidthSummary = {0.5f,0.5f,0.5f,0.5f,0.5f,0.5f,0.5f,0.5f};
                tableLastSummary.setWidths(colWidthSummary);
                PdfPCell cS1 = new PdfPCell(new Paragraph("FORM 1",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell cS2 = new PdfPCell(new Paragraph(" ",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell cS3 = new PdfPCell(new Paragraph("FORM 2",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell cS4 = new PdfPCell(new Paragraph(" ",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell cS5 = new PdfPCell(new Paragraph("FORM 3",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell cS6 = new PdfPCell(new Paragraph(" ",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell cS7 = new PdfPCell(new Paragraph("FORM 4",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell cS8 = new PdfPCell(new Paragraph(" ",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                tableLastSummary.addCell(cS1);
                tableLastSummary.addCell(cS2);
                tableLastSummary.addCell(cS3);
                tableLastSummary.addCell(cS4);
                tableLastSummary.addCell(cS5);
                tableLastSummary.addCell(cS6);
                tableLastSummary.addCell(cS7);
                tableLastSummary.addCell(cS8);

                PdfPCell f1t1 = new PdfPCell(new Paragraph("F1T1"));
                PdfPCell f1t1m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF1T1E2.getString(30)))/11)+" "+setF1T1E2.getString(31)));
                PdfPCell f2t1 = new PdfPCell(new Paragraph("F2T1"));
                PdfPCell f2t1m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF2T1E2.getString(30)))/11)+" "+setF2T1E2.getString(31)));
                PdfPCell f3t1 = new PdfPCell(new Paragraph("F3T1"));
                PdfPCell f3t1m = new PdfPCell(new Paragraph(String.valueOf(Integer.parseInt(setF3T1E2.getString(41))/11)+" "+setF3T1E2.getString(43)+" "+setF3T1E2.getString(42)));
                PdfPCell f4t1 = new PdfPCell(new Paragraph("F4T1"));
                PdfPCell f4t1m = new PdfPCell(new Paragraph(" "));
                tableLastSummary.addCell(f1t1);
                tableLastSummary.addCell(f1t1m);
                tableLastSummary.addCell(f2t1);
                tableLastSummary.addCell(f2t1m);
                tableLastSummary.addCell(f3t1);
                tableLastSummary.addCell(f3t1m);
                tableLastSummary.addCell(f4t1);
                tableLastSummary.addCell(f4t1m);

                PdfPCell f1t2 = new PdfPCell(new Paragraph("F1T2"));
                PdfPCell f1t2m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF1T2E2.getString(30)))/11)+" "+setF1T2E2.getString(31)));
                PdfPCell f2t2 = new PdfPCell(new Paragraph("F2T2"));
                PdfPCell f2t2m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF2T2E2.getString(30)))/11)+" "+setF2T2E2.getString(31)));
                PdfPCell f3t2 = new PdfPCell(new Paragraph("F3T2"));
                PdfPCell f3t2m = new PdfPCell(new Paragraph(String.valueOf(avgAvgTotal)+" "+setE2.getString(42)+" "+setE2.getString(43)));
                PdfPCell f4t2 = new PdfPCell(new Paragraph("F4T2"));
                PdfPCell f4t2m = new PdfPCell(new Paragraph(" "));
                tableLastSummary.addCell(f1t2);
                tableLastSummary.addCell(f1t2m);
                tableLastSummary.addCell(f2t2);
                tableLastSummary.addCell(f2t2m);
                tableLastSummary.addCell(f3t2);
                tableLastSummary.addCell(f3t2m);
                tableLastSummary.addCell(f4t2);
                tableLastSummary.addCell(f4t2m);

                PdfPCell f1t3 = new PdfPCell(new Paragraph("F1T3"));
                PdfPCell f1t3m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF1T3E2.getString(30)))/11)+" "+setF1T3E2.getString(31)));
                PdfPCell f2t3 = new PdfPCell(new Paragraph("F2T3"));
                PdfPCell f2t3m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF2T3E2.getString(30)))/11)+" "+setF2T3E2.getString(31)));
                PdfPCell f3t3 = new PdfPCell(new Paragraph("F3T3"));
                PdfPCell f3t3m = new PdfPCell(new Paragraph(" "));
                PdfPCell f4t3 = new PdfPCell(new Paragraph("F4T3"));
                PdfPCell f4t3m = new PdfPCell(new Paragraph(" "));
                tableLastSummary.addCell(f1t3);
                tableLastSummary.addCell(f1t3m);
                tableLastSummary.addCell(f2t3);
                tableLastSummary.addCell(f2t3m);
                tableLastSummary.addCell(f3t3);
                tableLastSummary.addCell(f3t3m);
                tableLastSummary.addCell(f4t3);
                tableLastSummary.addCell(f4t3m);

                document.add(tableLastSummary);
            /*
            * logo
            * */
                Image img = Image.getInstance(cname+"\\HS Results\\Web-Development.png");
                img.scaleAbsolute(100,50);
                img.setAbsolutePosition(30,750);
                document.add(img);

            /*
            * chart
            * */
                DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
                JFreeChart chart = ChartFactory.createBarChart(
                        "", "", "Marks",
                        dataSet, PlotOrientation.VERTICAL, false, false, false);
                int width=500; /* Width of our chart */
                int height=150; /* Height of our chart */
/* Get instance of CategoryPlot */
                CategoryPlot plot = chart.getCategoryPlot();
                BarRenderer renderer = (BarRenderer) plot.getRenderer();
                renderer.setSeriesPaint(0, Color.black);
                dataSet.setValue((Integer.parseInt(setF1T1E2.getString(30))/11)/7, "Marks", "F1T1");
                dataSet.setValue((Integer.parseInt(setF1T2E2.getString(30))/11)/7, "Marks", "F1T2");
                dataSet.setValue((Integer.parseInt(setF1T3E2.getString(30))/11)/7, "Marks", "F1T3");
                dataSet.setValue((Integer.parseInt(setF2T1E2.getString(30))/11)/7, "Marks", "F2T1");
                dataSet.setValue((Integer.parseInt(setF2T2E2.getString(30))/11)/7, "Marks", "F2T2");
                dataSet.setValue((Integer.parseInt(setF2T3E2.getString(30))/11)/7, "Marks", "F2T3");
                dataSet.setValue(Float.parseFloat(setF3T1E2.getString(43)), "Marks", "F3T1");
                dataSet.setValue(Float.parseFloat(setE2.getString(43)), "Marks", "F3T2");
                dataSet.setValue(0, "Marks", "F3T3");
                dataSet.setValue(0, "Marks", "F4T1");
                dataSet.setValue(0, "Marks", "F4T2");
                dataSet.setValue(0, "Marks", "F4T3");
                PdfContentByte contentByte = writer.getDirectContent();
                PdfTemplate template = contentByte.createTemplate(width, height);
                Graphics2D graphics2d = template.createGraphics(width, height,new DefaultFontMapper());
                Rectangle2D rectangle2d = new Rectangle2D.Double(0, 0, width, height);
                chart.draw(graphics2d, rectangle2d);
                graphics2d.dispose();
                contentByte.addTemplate(template, 30, 275);

                Paragraph classTeacherComments = new Paragraph("Class teacher comments: _________________________________________________________");
                Paragraph classTeacherComments1 = new Paragraph("______________________________________________________________________________");
                Paragraph principalComments =new Paragraph("Principal comments: _____________________________________________________________");
                Paragraph principalComments1 =new Paragraph("______________________________________________________________________________");

                classTeacherComments.setSpacingBefore(170);
                document.add(classTeacherComments);
                document.add(classTeacherComments1);
                document.add(principalComments);
                document.add(principalComments1);
                document.close();
            writer.close();
            infoBox("Document containing exam2 results for " + NAME + " has been created open it for printing.","Done",null);
            Desktop.getDesktop().open(new File(cname+"\\HS Results\\"+NAME+".pdf"));


            }catch (Exception e){
                e.printStackTrace();
                infoBoxError("An error occurred " + e,"Error",null);
            }}else {
            infoBoxError("You are not allowed to print","Error",null);
        }
    }

    private void printBioGeoAgri(String ADM,int POS, String ALL) {
        if(printPassword.toString().equals("vic")) {
            String sqlDetails="SELECT * FROM tbl_students WHERE adm=?";
            String sqlComm = "SELECT * FROM tbl_comments";
            String sqlTotal ="SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='TOTAL'";

            String sqlEx2 = "SELECT * FROM tbl_f3_t2_ex2 WHERE adm=? ";
            String sqlF1T1Ex2 = "SELECT * FROM tbl_f1_t1_ex2 WHERE adm=?";
            String sqlF1T2Ex2 = "SELECT * FROM tbl_f1_t2_ex2 WHERE adm=?";
            String sqlF1T3Ex2 = "SELECT * FROM tbl_f1_t3_ex2 WHERE adm=?";
            String sqlF2T1Ex2 = "SELECT * FROM tbl_f2_t1_ex2 WHERE adm=?";
            String sqlF2T2Ex2 = "SELECT * FROM tbl_f2_t2_ex2 WHERE adm=?";
            String sqlF2T3Ex2 = "SELECT * FROM tbl_f2_t3_ex2 WHERE adm=?";
            String sqlF3T1Ex2 = "SELECT * FROM tbl_f3_t1_ex2 WHERE adm=?";


            String sqlEngTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='English'";
            String sqlKisTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='Kiswahili'";
            String sqlMatTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='Mathematics'";
            String sqlChemTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='Chemistry'";
            String sqlBioTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='Biology'";
            String sqlPhyTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='Physics'";
            String sqlHisTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='History'";
            String sqlGeoTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='Geography'";
            String sqlCreTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='CRE'";
            String sqlBusTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='Business'";
            String sqlAgriTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='Agriculture'";

            String sqlEngGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='ENGLISH'";
            String sqlKisGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='KISWAHILI'";
            String sqlMatGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='MATHEMATICS'";
            String sqlChemGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='CHEMISTRY'";
            String sqlBioGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='BIOLOGY'";
            String sqlPhyGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='PHYSICS'";
            String sqlHisGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='HISTORY'";
            String sqlGeoGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='GEOGRAPHY'";
            String sqlCreGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='CRE'";
            String sqlBusGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='BUSINESS'";
            String sqlAgriGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='AGRICULTURE'";

            try{
                Connection connection = Database.DBConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sqlDetails);

                PreparedStatement statementE2 = connection.prepareStatement(sqlEx2);
                PreparedStatement statementF1T1E2 = connection.prepareStatement(sqlF1T1Ex2);
                PreparedStatement statementF1T2E2 = connection.prepareStatement(sqlF1T2Ex2);
                PreparedStatement statementF1T3E2 = connection.prepareStatement(sqlF1T3Ex2);
                PreparedStatement statementF2T1E2 = connection.prepareStatement(sqlF2T1Ex2);
                PreparedStatement statementF2T2E2 = connection.prepareStatement(sqlF2T2Ex2);
                PreparedStatement statementF2T3E2 = connection.prepareStatement(sqlF2T3Ex2);
                PreparedStatement statementF3T1E2 = connection.prepareStatement(sqlF3T1Ex2);



                statement.setString(1,ADM);

                statementE2.setString(1,ADM);
                statementF1T1E2.setString(1,ADM);
                statementF1T2E2.setString(1,ADM);
                statementF1T3E2.setString(1,ADM);
                statementF2T1E2.setString(1,ADM);
                statementF2T2E2.setString(1,ADM);
                statementF2T3E2.setString(1,ADM);
                statementF3T1E2.setString(1,ADM);


                ResultSet set = statement.executeQuery();

                ResultSet setE2 = statementE2.executeQuery();
                ResultSet setF1T1E2 = statementF1T1E2.executeQuery();
                ResultSet setF1T2E2 = statementF1T2E2.executeQuery();
                ResultSet setF1T3E2 = statementF1T3E2.executeQuery();
                ResultSet setF2T1E2 = statementF2T1E2.executeQuery();
                ResultSet setF2T2E2 = statementF2T2E2.executeQuery();
                ResultSet setF2T3E2 = statementF2T3E2.executeQuery();
                ResultSet setF3T1E2 = statementF3T1E2.executeQuery();


                ResultSet setEngTeacher = connection.createStatement().executeQuery(sqlEngTeacher);
                ResultSet setKisTeacher = connection.createStatement().executeQuery(sqlKisTeacher);
                ResultSet setMatTeacher = connection.createStatement().executeQuery(sqlMatTeacher);
                ResultSet setChemTeacher = connection.createStatement().executeQuery(sqlChemTeacher);
                ResultSet setBioTeacher = connection.createStatement().executeQuery(sqlBioTeacher);
                ResultSet setPhyTeacher = connection.createStatement().executeQuery(sqlPhyTeacher);
                ResultSet setHisTeacher = connection.createStatement().executeQuery(sqlHisTeacher);
                ResultSet setGeoTeacher = connection.createStatement().executeQuery(sqlGeoTeacher);
                ResultSet setCreTeacher = connection.createStatement().executeQuery(sqlCreTeacher);
                ResultSet setBusTeacher = connection.createStatement().executeQuery(sqlBusTeacher);
                ResultSet setAgriTeacher = connection.createStatement().executeQuery(sqlAgriTeacher);

                ResultSet setEngGrade = connection.createStatement().executeQuery(sqlEngGrade);
                ResultSet setKisGrade = connection.createStatement().executeQuery(sqlKisGrade);
                ResultSet setMatGrade = connection.createStatement().executeQuery(sqlMatGrade);
                ResultSet setChemGrade = connection.createStatement().executeQuery(sqlChemGrade);
                ResultSet setBioGrade = connection.createStatement().executeQuery(sqlBioGrade);
                ResultSet setPhyGrade = connection.createStatement().executeQuery(sqlPhyGrade);
                ResultSet setHisGrade = connection.createStatement().executeQuery(sqlHisGrade);
                ResultSet setGeoGrade = connection.createStatement().executeQuery(sqlGeoGrade);
                ResultSet setCreGrade = connection.createStatement().executeQuery(sqlCreGrade);
                ResultSet setBusGrade = connection.createStatement().executeQuery(sqlBusGrade);
                ResultSet setAgriGrade = connection.createStatement().executeQuery(sqlAgriGrade);

                ResultSet setComments = connection.createStatement().executeQuery(sqlComm);
                ResultSet setTotal = connection.createStatement().executeQuery(sqlTotal);

                String names = set.getString(3)+"_"+set.getString(4)+"_"+set.getString(5);

                Document document = new Document(PageSize.A4);
            PdfWriter writer = PdfWriter.getInstance(document,new FileOutputStream(NAME+".pdf"));
            document.open();

                Paragraph schoolName = new Paragraph("SCHOOL NAME", new Font(Font.FontFamily.TIMES_ROMAN, 15,Font.BOLD));
                Paragraph address = new Paragraph("P.O BOX 22332, LOCATION", new Font(Font.FontFamily.TIMES_ROMAN, 15,Font.BOLD));
                Paragraph tell = new Paragraph("PHONE: 073293874", new Font(Font.FontFamily.TIMES_ROMAN, 15,Font.BOLD));
                Paragraph reportType = new Paragraph("Report Form", new Font(Font.FontFamily.TIMES_ROMAN, 10,Font.BOLD));
                schoolName.setAlignment(Element.ALIGN_CENTER);
                address.setAlignment(Element.ALIGN_CENTER);
                tell.setAlignment(Element.ALIGN_CENTER);
                reportType.setAlignment(Element.ALIGN_CENTER);
                document.add(schoolName);
                document.add(address);
                document.add(tell);
                document.add(reportType);

                document.add((new Paragraph("ADM: "+set.getString(2)+"  "+"NAME: "+set.getString(3)+"   "+set.getString(4)+" "+set.getString(5)+"  "+"KCPE:"+set.getString(6)+"  "+"CLASS:FORM 3"+"  "+"TERM:TERM 2",new Font(Font.FontFamily.TIMES_ROMAN, 9,Font.BOLD))));
                document.add((new Paragraph("YEAR:"+now.get(Calendar.YEAR)+" "+"POS:"+String.valueOf(POS+1)+" "+"OUT OF "+ALL,new Font(Font.FontFamily.TIMES_ROMAN, 9,Font.BOLD))));
                document.add((new Paragraph(" ")));

                PdfPTable table = new PdfPTable(7);
                table.setWidthPercentage(105);
                table.setSpacingBefore(0f);
                table.setSpacingAfter(0f);

                float[] colWidth = {1.1f,0.5f,0.5f,0.5f,0.7f,2f,1f};
                table.setWidths(colWidth);
                PdfPCell c1 = new PdfPCell(new Paragraph("SUBJECTS",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell c2 = new PdfPCell(new Paragraph("EX1",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell c3 = new PdfPCell(new Paragraph("EX2",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell c4 = new PdfPCell(new Paragraph("EX3",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell c5 = new PdfPCell(new Paragraph("AVG",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell c6 = new PdfPCell(new Paragraph("COMMENTS",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell c7 = new PdfPCell(new Paragraph("TEACHER",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                table.addCell(c1);
                table.addCell(c2);
                table.addCell(c3);
                table.addCell(c4);
                table.addCell(c5);
                table.addCell(c6);
                table.addCell(c7);

                //set eng results
                String g,com=null;
                PdfPCell engD1 = new PdfPCell(new Paragraph("English"));
                PdfPCell engD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell engD3 = new PdfPCell(new Paragraph(setE2.getString(8)+" "+setE2.getString(9)));
                PdfPCell engD4 = new PdfPCell(new Paragraph(" "));

                int avgE= Integer.parseInt(setE2.getString(8));
                if (avgE >= Integer.parseInt(setEngGrade.getString(4))) {com = setComments.getString(2); } else if (avgE >= Integer.parseInt(setEngGrade.getString(5))) { com = setComments.getString(3); }else if (avgE >=Integer.parseInt(setEngGrade.getString(6))){ com = setComments.getString(4);}else if (avgE >=Integer.parseInt(setEngGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgE >=Integer.parseInt(setEngGrade.getString(8))){  com = setComments.getString(6); }else if (avgE >=Integer.parseInt(setEngGrade.getString(9))){ com = setComments.getString(7); }else if (avgE >=Integer.parseInt(setEngGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgE >=Integer.parseInt(setEngGrade.getString(11))){ com = setComments.getString(9);}else if (avgE >=Integer.parseInt(setEngGrade.getString(12))){ com = setComments.getString(10);}else if (avgE >=Integer.parseInt(setEngGrade.getString(13))){ com = setComments.getString(11);}else if (avgE >=Integer.parseInt(setEngGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }
                PdfPCell engD5 = new PdfPCell(new Paragraph(setE2.getString(8)+" "+setE2.getString(9)));
                PdfPCell engD6 = new PdfPCell(new Paragraph(com));
                PdfPCell engD7 = new PdfPCell(new Paragraph(setEngTeacher.getString(6)));
                table.addCell(engD1);
                table.addCell(engD2);
                table.addCell(engD3);
                table.addCell(engD4);
                table.addCell(engD5);
                table.addCell(engD6);
                table.addCell(engD7);

                //set kis results
                PdfPCell kisD1 = new PdfPCell(new Paragraph("Kiswahili"));
                PdfPCell kisD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell kisD3 = new PdfPCell(new Paragraph(setE2.getString(11)+" "+setE2.getString(12)));
                PdfPCell kisD4 = new PdfPCell(new Paragraph(" "));

                int avgKis= Integer.parseInt(setE2.getString(11));
                if (avgKis >= Integer.parseInt(setKisGrade.getString(4))) {com = setComments.getString(2); } else if (avgKis >= Integer.parseInt(setKisGrade.getString(5))) { com = setComments.getString(3); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(6))){ com = setComments.getString(4);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(8))){  com = setComments.getString(6); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(9))){ com = setComments.getString(7); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgKis >=Integer.parseInt(setKisGrade.getString(11))){ com = setComments.getString(9);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(12))){ com = setComments.getString(10);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(13))){ com = setComments.getString(11);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }
                PdfPCell kisD5 = new PdfPCell(new Paragraph(setE2.getString(11)+" "+setE2.getString(12)));
                PdfPCell kisD6 = new PdfPCell(new Paragraph(com));
                PdfPCell kisD7 = new PdfPCell(new Paragraph(setKisTeacher.getString(6)));
                table.addCell(kisD1);
                table.addCell(kisD2);
                table.addCell(kisD3);
                table.addCell(kisD4);
                table.addCell(kisD5);
                table.addCell(kisD6);
                table.addCell(kisD7);

                //set mat results

                PdfPCell matD1 = new PdfPCell(new Paragraph("Mathematics"));
                PdfPCell matD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell matD3 = new PdfPCell(new Paragraph(setE2.getString(14)+" "+setE2.getString(15)));
                PdfPCell matD4 = new PdfPCell(new Paragraph(" "));

                int avgMat = Integer.parseInt(setE2.getString(14));
                if (avgMat >= Integer.parseInt(setMatGrade.getString(4))) {com = setComments.getString(2); } else if (avgMat >= Integer.parseInt(setMatGrade.getString(5))) { com = setComments.getString(3); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(6))){ com = setComments.getString(4);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(8))){  com = setComments.getString(6); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(9))){ com = setComments.getString(7); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgMat >=Integer.parseInt(setMatGrade.getString(11))){ com = setComments.getString(9);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(12))){ com = setComments.getString(10);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(13))){ com = setComments.getString(11);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell matD5 = new PdfPCell(new Paragraph(setE2.getString(14)+" "+setE2.getString(15)));
                PdfPCell matD6 = new PdfPCell(new Paragraph(com));
                PdfPCell matD7 = new PdfPCell(new Paragraph(setMatTeacher.getString(6)));
                table.addCell(matD1);
                table.addCell(matD2);
                table.addCell(matD3);
                table.addCell(matD4);
                table.addCell(matD5);
                table.addCell(matD6);
                table.addCell(matD7);

                //set Chemistry results
                PdfPCell chemD1 = new PdfPCell(new Paragraph("Chemistry"));
                PdfPCell chemD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell chemD3 = new PdfPCell(new Paragraph(setE2.getString(20)+" "+setE2.getString(21)));
                PdfPCell chemD4 = new PdfPCell(new Paragraph(" "));

                int avgChem = Integer.parseInt(setE2.getString(20));
                if (avgChem >= Integer.parseInt(setChemGrade.getString(4))) {com = setComments.getString(2); } else if (avgChem >= Integer.parseInt(setChemGrade.getString(5))) { com = setComments.getString(3); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(6))){ com = setComments.getString(4);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(8))){  com = setComments.getString(6); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(9))){ com = setComments.getString(7); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgChem >=Integer.parseInt(setChemGrade.getString(11))){ com = setComments.getString(9);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(12))){ com = setComments.getString(10);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(13))){ com = setComments.getString(11);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell chemD5 = new PdfPCell(new Paragraph(setE2.getString(20)+" "+setE2.getString(21)));
                PdfPCell chemD6 = new PdfPCell(new Paragraph(com));
                PdfPCell chemD7 = new PdfPCell(new Paragraph(setChemTeacher.getString(6)));
                table.addCell(chemD1);
                table.addCell(chemD2);
                table.addCell(chemD3);
                table.addCell(chemD4);
                table.addCell(chemD5);
                table.addCell(chemD6);
                table.addCell(chemD7);

                //set Biology Results
                PdfPCell bioD1 = new PdfPCell(new Paragraph("Biology"));
                PdfPCell bioD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell bioD3 = new PdfPCell(new Paragraph(setE2.getString(17)+" "+setE2.getString(18)));
                PdfPCell bioD4 = new PdfPCell(new Paragraph(" "));

                int avgBio = Integer.parseInt(setE2.getString(17));
                if (avgBio >= Integer.parseInt(setBioGrade.getString(4))) {com = setComments.getString(2); } else if (avgBio >= Integer.parseInt(setBioGrade.getString(5))) { com = setComments.getString(3); }else if (avgBio >=Integer.parseInt(setBioGrade.getString(6))){ com = setComments.getString(4);}else if (avgBio >=Integer.parseInt(setBioGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgBio >=Integer.parseInt(setBioGrade.getString(8))){  com = setComments.getString(6); }else if (avgBio >=Integer.parseInt(setBioGrade.getString(9))){ com = setComments.getString(7); }else if (avgBio >=Integer.parseInt(setBioGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgBio >=Integer.parseInt(setBioGrade.getString(11))){ com = setComments.getString(9);}else if (avgBio >=Integer.parseInt(setBioGrade.getString(12))){ com = setComments.getString(10);}else if (avgBio >=Integer.parseInt(setBioGrade.getString(13))){ com = setComments.getString(11);}else if (avgBio >=Integer.parseInt(setBioGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell bioD5 = new PdfPCell(new Paragraph(setE2.getString(17)+" "+setE2.getString(18)));
                PdfPCell bioD6 = new PdfPCell(new Paragraph(com));
                PdfPCell bioD7 = new PdfPCell(new Paragraph(setBioTeacher.getString(6)));
                table.addCell(bioD1);
                table.addCell(bioD2);
                table.addCell(bioD3);
                table.addCell(bioD4);
                table.addCell(bioD5);
                table.addCell(bioD6);
                table.addCell(bioD7);

                //set Geography results
                PdfPCell geoD1 = new PdfPCell(new Paragraph("Geography"));
                PdfPCell geoD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell geoD3 = new PdfPCell(new Paragraph(setE2.getString(26)+" "+setE2.getString(27)));
                PdfPCell geoD4 = new PdfPCell(new Paragraph(" "));

                int avgGeo = Integer.parseInt(setE2.getString(26));
                if (avgGeo >= Integer.parseInt(setGeoGrade.getString(4))) {com = setComments.getString(2); } else if (avgGeo >= Integer.parseInt(setGeoGrade.getString(5))) { com = setComments.getString(3); }else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(6))){ com = setComments.getString(4);}else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(8))){  com = setComments.getString(6); }else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(9))){ com = setComments.getString(7); }else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(11))){ com = setComments.getString(9);}else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(12))){ com = setComments.getString(10);}else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(13))){ com = setComments.getString(11);}else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell geoD5 = new PdfPCell(new Paragraph(setE2.getString(26)+" "+setE2.getString(27)));
                PdfPCell geoD6 = new PdfPCell(new Paragraph(com));
                PdfPCell geoD7 = new PdfPCell(new Paragraph(setGeoTeacher.getString(6)));
                table.addCell(geoD1);
                table.addCell(geoD2);
                table.addCell(geoD3);
                table.addCell(geoD4);
                table.addCell(geoD5);
                table.addCell(geoD6);
                table.addCell(geoD7);

                //set Agriculture results
                PdfPCell agriD1 = new PdfPCell(new Paragraph("Agriculture"));
                PdfPCell agriD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell agriD3 = new PdfPCell(new Paragraph(setE2.getString(38)+" "+setE2.getString(39)));
                PdfPCell agriD4 = new PdfPCell(new Paragraph(" "));

                int avgAgri = Integer.parseInt(setE2.getString(38));
                if (avgAgri >= Integer.parseInt(setAgriGrade.getString(4))) {com = setComments.getString(2); } else if (avgAgri >= Integer.parseInt(setAgriGrade.getString(5))) { com = setComments.getString(3); }else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(6))){ com = setComments.getString(4);}else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(8))){  com = setComments.getString(6); }else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(9))){ com = setComments.getString(7); }else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(11))){ com = setComments.getString(9);}else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(12))){ com = setComments.getString(10);}else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(13))){ com = setComments.getString(11);}else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell agriD5 = new PdfPCell(new Paragraph(setE2.getString(38)+" "+setE2.getString(39)));
                PdfPCell agriD6 = new PdfPCell(new Paragraph(com));
                PdfPCell agriD7 = new PdfPCell(new Paragraph(setAgriTeacher.getString(6)));
                table.addCell(agriD1);
                table.addCell(agriD2);
                table.addCell(agriD3);
                table.addCell(agriD4);
                table.addCell(agriD5);
                table.addCell(agriD6);
                table.addCell(agriD7);

                //set total results

                int totalE2 = Integer.parseInt(setE2.getString(41));



                PdfPCell totalD1 = new PdfPCell(new Paragraph("Total"));
                PdfPCell totalD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell totalD3 = new PdfPCell(new Paragraph(String.valueOf(totalE2)));
                PdfPCell totalD4 = new PdfPCell(new Paragraph(" "));
                PdfPCell totalD5 = new PdfPCell(new Paragraph(" "));
                PdfPCell totalD6 = new PdfPCell(new Paragraph(""));
                PdfPCell totalD7 = new PdfPCell(new Paragraph(""));
                table.addCell(totalD1);
                table.addCell(totalD2);
                table.addCell(totalD3);
                table.addCell(totalD4);
                table.addCell(totalD5);
                table.addCell(totalD6);
                table.addCell(totalD7);

                //set average results

                //int add2AvgEx1 = (Math.addExact(totalEx1Mat,addAvgEx1))/3;

                int addAvgEx2 = Math.round(totalE2/7);
                //int add2AvgEx2 = (Math.addExact(totalEx2Mat,addAvgEx2))/3;


                //int add2AvgEx3 = (Math.addExact(totalEx3Mat,addAvgEx3))/3;


                PdfPCell avgD1 = new PdfPCell(new Paragraph("Average"));
                PdfPCell avgD2 = new PdfPCell(new Paragraph(" "));
                if (addAvgEx2 >= Integer.parseInt(setTotal.getString(4))) {g = "A"; } else if (addAvgEx2 >= Integer.parseInt(setTotal.getString(5))) { g = "A-"; }else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(6))){ g = "B+";}else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(7))){
                    g = "B"; }else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(8))){  g = "B-"; }else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(9))){ g = "C+"; }else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(10))){ g = "C";
                }else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(11))){ g = "C-";}else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(12))){ g = "D+";}else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(13))){ g = "D";}else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(14))){
                    g = "D-";}else {g="E"; }
                PdfPCell avgD3 = new PdfPCell(new Paragraph(String.valueOf(addAvgEx2)+" "+g));


                PdfPCell avgD4 = new PdfPCell(new Paragraph(" "));

                //float avgAvgTotal = (addAvgEx1+addAvgEx2+addAvgEx3)/3;
                int avgAvgTotal=Integer.parseInt(setE2.getString(41))/7;

                if (avgAvgTotal >= Integer.parseInt(setTotal.getString(4))) {g = "A"; } else if (avgAvgTotal >= Integer.parseInt(setTotal.getString(5))) { g = "A-"; }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(6))){ g = "B+";}else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(7))){
                    g = "B"; }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(8))){  g = "B-"; }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(9))){ g = "C+"; }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(10))){ g = "C";
                }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(11))){ g = "C-";}else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(12))){ g = "D+";}else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(13))){ g = "D";}else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(14))){
                    g = "D-";}else {g="E"; }

                PdfPCell avgD5 = new PdfPCell(new Paragraph(String.valueOf(Math.round(avgAvgTotal))+" "+g));
                PdfPCell avgD6 = new PdfPCell(new Paragraph(""));
                PdfPCell avgD7 = new PdfPCell(new Paragraph(""));
                table.addCell(avgD1);
                table.addCell(avgD2);
                table.addCell(avgD3);
                table.addCell(avgD4);
                table.addCell(avgD5);
                table.addCell(avgD6);
                table.addCell(avgD7);

                document.add(table);

                Paragraph labelSummary = new Paragraph("PERFORMANCE TREND",new Font(Font.FontFamily.TIMES_ROMAN, 8,Font.BOLD));
                labelSummary.setSpacingBefore(0);
                labelSummary.setSpacingAfter(5);
                labelSummary.setAlignment(Element.ALIGN_CENTER);
                document.add(labelSummary);

                PdfPTable tableLastSummary = new PdfPTable(8);
                tableLastSummary.setWidthPercentage(105);
                tableLastSummary.setSpacingBefore(0f);
                tableLastSummary.setSpacingAfter(0f);

                float[] colWidthSummary = {0.5f,0.5f,0.5f,0.5f,0.5f,0.5f,0.5f,0.5f};
                tableLastSummary.setWidths(colWidthSummary);
                PdfPCell cS1 = new PdfPCell(new Paragraph("FORM 1",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell cS2 = new PdfPCell(new Paragraph(" ",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell cS3 = new PdfPCell(new Paragraph("FORM 2",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell cS4 = new PdfPCell(new Paragraph(" ",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell cS5 = new PdfPCell(new Paragraph("FORM 3",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell cS6 = new PdfPCell(new Paragraph(" ",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell cS7 = new PdfPCell(new Paragraph("FORM 4",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell cS8 = new PdfPCell(new Paragraph(" ",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                tableLastSummary.addCell(cS1);
                tableLastSummary.addCell(cS2);
                tableLastSummary.addCell(cS3);
                tableLastSummary.addCell(cS4);
                tableLastSummary.addCell(cS5);
                tableLastSummary.addCell(cS6);
                tableLastSummary.addCell(cS7);
                tableLastSummary.addCell(cS8);

                PdfPCell f1t1 = new PdfPCell(new Paragraph("F1T1"));
                PdfPCell f1t1m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF1T1E2.getString(30)))/11)+" "+setF1T1E2.getString(31)));
                PdfPCell f2t1 = new PdfPCell(new Paragraph("F2T1"));
                PdfPCell f2t1m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF2T1E2.getString(30)))/11)+" "+setF2T1E2.getString(31)));
                PdfPCell f3t1 = new PdfPCell(new Paragraph("F3T1"));
                PdfPCell f3t1m = new PdfPCell(new Paragraph(String.valueOf(Integer.parseInt(setF3T1E2.getString(41))/11)+" "+setF3T1E2.getString(43)+" "+setF3T1E2.getString(42)));
                PdfPCell f4t1 = new PdfPCell(new Paragraph("F4T1"));
                PdfPCell f4t1m = new PdfPCell(new Paragraph(" "));
                tableLastSummary.addCell(f1t1);
                tableLastSummary.addCell(f1t1m);
                tableLastSummary.addCell(f2t1);
                tableLastSummary.addCell(f2t1m);
                tableLastSummary.addCell(f3t1);
                tableLastSummary.addCell(f3t1m);
                tableLastSummary.addCell(f4t1);
                tableLastSummary.addCell(f4t1m);

                PdfPCell f1t2 = new PdfPCell(new Paragraph("F1T2"));
                PdfPCell f1t2m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF1T2E2.getString(30)))/11)+" "+setF1T2E2.getString(31)));
                PdfPCell f2t2 = new PdfPCell(new Paragraph("F2T2"));
                PdfPCell f2t2m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF2T2E2.getString(30)))/11)+" "+setF2T2E2.getString(31)));
                PdfPCell f3t2 = new PdfPCell(new Paragraph("F3T2"));
                PdfPCell f3t2m = new PdfPCell(new Paragraph(String.valueOf(avgAvgTotal)+" "+setE2.getString(42)+" "+setE2.getString(43)));
                PdfPCell f4t2 = new PdfPCell(new Paragraph("F4T2"));
                PdfPCell f4t2m = new PdfPCell(new Paragraph(" "));
                tableLastSummary.addCell(f1t2);
                tableLastSummary.addCell(f1t2m);
                tableLastSummary.addCell(f2t2);
                tableLastSummary.addCell(f2t2m);
                tableLastSummary.addCell(f3t2);
                tableLastSummary.addCell(f3t2m);
                tableLastSummary.addCell(f4t2);
                tableLastSummary.addCell(f4t2m);

                PdfPCell f1t3 = new PdfPCell(new Paragraph("F1T3"));
                PdfPCell f1t3m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF1T3E2.getString(30)))/11)+" "+setF1T3E2.getString(31)));
                PdfPCell f2t3 = new PdfPCell(new Paragraph("F2T3"));
                PdfPCell f2t3m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF2T3E2.getString(30)))/11)+" "+setF2T3E2.getString(31)));
                PdfPCell f3t3 = new PdfPCell(new Paragraph("F3T3"));
                PdfPCell f3t3m = new PdfPCell(new Paragraph(" "));
                PdfPCell f4t3 = new PdfPCell(new Paragraph("F4T3"));
                PdfPCell f4t3m = new PdfPCell(new Paragraph(" "));
                tableLastSummary.addCell(f1t3);
                tableLastSummary.addCell(f1t3m);
                tableLastSummary.addCell(f2t3);
                tableLastSummary.addCell(f2t3m);
                tableLastSummary.addCell(f3t3);
                tableLastSummary.addCell(f3t3m);
                tableLastSummary.addCell(f4t3);
                tableLastSummary.addCell(f4t3m);

                document.add(tableLastSummary);
            /*
            * logo
            * */
                Image img = Image.getInstance(cname+"\\HS Results\\Web-Development.png");
                img.scaleAbsolute(100,50);
                img.setAbsolutePosition(30,750);
                document.add(img);

            /*
            * chart
            * */
                DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
                JFreeChart chart = ChartFactory.createBarChart(
                        "", "", "Marks",
                        dataSet, PlotOrientation.VERTICAL, false, false, false);
                int width=500; /* Width of our chart */
                int height=150; /* Height of our chart */
/* Get instance of CategoryPlot */
                CategoryPlot plot = chart.getCategoryPlot();
                BarRenderer renderer = (BarRenderer) plot.getRenderer();
                renderer.setSeriesPaint(0, Color.black);
                dataSet.setValue((Integer.parseInt(setF1T1E2.getString(30))/11)/7, "Marks", "F1T1");
                dataSet.setValue((Integer.parseInt(setF1T2E2.getString(30))/11)/7, "Marks", "F1T2");
                dataSet.setValue((Integer.parseInt(setF1T3E2.getString(30))/11)/7, "Marks", "F1T3");
                dataSet.setValue((Integer.parseInt(setF2T1E2.getString(30))/11)/7, "Marks", "F2T1");
                dataSet.setValue((Integer.parseInt(setF2T2E2.getString(30))/11)/7, "Marks", "F2T2");
                dataSet.setValue((Integer.parseInt(setF2T3E2.getString(30))/11)/7, "Marks", "F2T3");
                dataSet.setValue(Float.parseFloat(setF3T1E2.getString(43)), "Marks", "F3T1");
                dataSet.setValue(Float.parseFloat(setE2.getString(43)), "Marks", "F3T2");
                dataSet.setValue(0, "Marks", "F3T3");
                dataSet.setValue(0, "Marks", "F4T1");
                dataSet.setValue(0, "Marks", "F4T2");
                dataSet.setValue(0, "Marks", "F4T3");
                PdfContentByte contentByte = writer.getDirectContent();
                PdfTemplate template = contentByte.createTemplate(width, height);
                Graphics2D graphics2d = template.createGraphics(width, height,new DefaultFontMapper());
                Rectangle2D rectangle2d = new Rectangle2D.Double(0, 0, width, height);
                chart.draw(graphics2d, rectangle2d);
                graphics2d.dispose();
                contentByte.addTemplate(template, 30, 275);

                Paragraph classTeacherComments = new Paragraph("Class teacher comments: _________________________________________________________");
                Paragraph classTeacherComments1 = new Paragraph("______________________________________________________________________________");
                Paragraph principalComments =new Paragraph("Principal comments: _____________________________________________________________");
                Paragraph principalComments1 =new Paragraph("______________________________________________________________________________");

                classTeacherComments.setSpacingBefore(170);
                document.add(classTeacherComments);
                document.add(classTeacherComments1);
                document.add(principalComments);
                document.add(principalComments1);
                document.close();
            writer.close();
            infoBox("Document containing exam2 results for " + NAME + " has been created open it for printing.","Done",null);
            Desktop.getDesktop().open(new File(cname+"\\HS Results\\"+NAME+".pdf"));


            }catch (Exception e){
                e.printStackTrace();
                infoBoxError("An error occurred " + e,"Error",null);
            }}else {
            infoBoxError("You are not allowed to print","Error",null);
        }
    }

    private void printBioGeoBus(String ADM,int POS, String ALL) {
        if(printPassword.toString().equals("vic")) {
            String sqlDetails="SELECT * FROM tbl_students WHERE adm=?";
            String sqlComm = "SELECT * FROM tbl_comments";
            String sqlTotal ="SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='TOTAL'";

            String sqlEx2 = "SELECT * FROM tbl_f3_t2_ex2 WHERE adm=? ";
            String sqlF1T1Ex2 = "SELECT * FROM tbl_f1_t1_ex2 WHERE adm=?";
            String sqlF1T2Ex2 = "SELECT * FROM tbl_f1_t2_ex2 WHERE adm=?";
            String sqlF1T3Ex2 = "SELECT * FROM tbl_f1_t3_ex2 WHERE adm=?";
            String sqlF2T1Ex2 = "SELECT * FROM tbl_f2_t1_ex2 WHERE adm=?";
            String sqlF2T2Ex2 = "SELECT * FROM tbl_f2_t2_ex2 WHERE adm=?";
            String sqlF2T3Ex2 = "SELECT * FROM tbl_f2_t3_ex2 WHERE adm=?";
            String sqlF3T1Ex2 = "SELECT * FROM tbl_f3_t1_ex2 WHERE adm=?";


            String sqlEngTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='English'";
            String sqlKisTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='Kiswahili'";
            String sqlMatTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='Mathematics'";
            String sqlChemTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='Chemistry'";
            String sqlBioTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='Biology'";
            String sqlPhyTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='Physics'";
            String sqlHisTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='History'";
            String sqlGeoTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='Geography'";
            String sqlCreTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='CRE'";
            String sqlBusTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='Business'";
            String sqlAgriTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='Agriculture'";

            String sqlEngGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='ENGLISH'";
            String sqlKisGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='KISWAHILI'";
            String sqlMatGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='MATHEMATICS'";
            String sqlChemGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='CHEMISTRY'";
            String sqlBioGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='BIOLOGY'";
            String sqlPhyGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='PHYSICS'";
            String sqlHisGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='HISTORY'";
            String sqlGeoGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='GEOGRAPHY'";
            String sqlCreGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='CRE'";
            String sqlBusGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='BUSINESS'";
            String sqlAgriGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='AGRICULTURE'";

            try{
                Connection connection = Database.DBConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sqlDetails);

                PreparedStatement statementE2 = connection.prepareStatement(sqlEx2);
                PreparedStatement statementF1T1E2 = connection.prepareStatement(sqlF1T1Ex2);
                PreparedStatement statementF1T2E2 = connection.prepareStatement(sqlF1T2Ex2);
                PreparedStatement statementF1T3E2 = connection.prepareStatement(sqlF1T3Ex2);
                PreparedStatement statementF2T1E2 = connection.prepareStatement(sqlF2T1Ex2);
                PreparedStatement statementF2T2E2 = connection.prepareStatement(sqlF2T2Ex2);
                PreparedStatement statementF2T3E2 = connection.prepareStatement(sqlF2T3Ex2);
                PreparedStatement statementF3T1E2 = connection.prepareStatement(sqlF3T1Ex2);



                statement.setString(1,ADM);

                statementE2.setString(1,ADM);
                statementF1T1E2.setString(1,ADM);
                statementF1T2E2.setString(1,ADM);
                statementF1T3E2.setString(1,ADM);
                statementF2T1E2.setString(1,ADM);
                statementF2T2E2.setString(1,ADM);
                statementF2T3E2.setString(1,ADM);
                statementF3T1E2.setString(1,ADM);


                ResultSet set = statement.executeQuery();

                ResultSet setE2 = statementE2.executeQuery();
                ResultSet setF1T1E2 = statementF1T1E2.executeQuery();
                ResultSet setF1T2E2 = statementF1T2E2.executeQuery();
                ResultSet setF1T3E2 = statementF1T3E2.executeQuery();
                ResultSet setF2T1E2 = statementF2T1E2.executeQuery();
                ResultSet setF2T2E2 = statementF2T2E2.executeQuery();
                ResultSet setF2T3E2 = statementF2T3E2.executeQuery();
                ResultSet setF3T1E2 = statementF3T1E2.executeQuery();


                ResultSet setEngTeacher = connection.createStatement().executeQuery(sqlEngTeacher);
                ResultSet setKisTeacher = connection.createStatement().executeQuery(sqlKisTeacher);
                ResultSet setMatTeacher = connection.createStatement().executeQuery(sqlMatTeacher);
                ResultSet setChemTeacher = connection.createStatement().executeQuery(sqlChemTeacher);
                ResultSet setBioTeacher = connection.createStatement().executeQuery(sqlBioTeacher);
                ResultSet setPhyTeacher = connection.createStatement().executeQuery(sqlPhyTeacher);
                ResultSet setHisTeacher = connection.createStatement().executeQuery(sqlHisTeacher);
                ResultSet setGeoTeacher = connection.createStatement().executeQuery(sqlGeoTeacher);
                ResultSet setCreTeacher = connection.createStatement().executeQuery(sqlCreTeacher);
                ResultSet setBusTeacher = connection.createStatement().executeQuery(sqlBusTeacher);
                ResultSet setAgriTeacher = connection.createStatement().executeQuery(sqlAgriTeacher);

                ResultSet setEngGrade = connection.createStatement().executeQuery(sqlEngGrade);
                ResultSet setKisGrade = connection.createStatement().executeQuery(sqlKisGrade);
                ResultSet setMatGrade = connection.createStatement().executeQuery(sqlMatGrade);
                ResultSet setChemGrade = connection.createStatement().executeQuery(sqlChemGrade);
                ResultSet setBioGrade = connection.createStatement().executeQuery(sqlBioGrade);
                ResultSet setPhyGrade = connection.createStatement().executeQuery(sqlPhyGrade);
                ResultSet setHisGrade = connection.createStatement().executeQuery(sqlHisGrade);
                ResultSet setGeoGrade = connection.createStatement().executeQuery(sqlGeoGrade);
                ResultSet setCreGrade = connection.createStatement().executeQuery(sqlCreGrade);
                ResultSet setBusGrade = connection.createStatement().executeQuery(sqlBusGrade);
                ResultSet setAgriGrade = connection.createStatement().executeQuery(sqlAgriGrade);

                ResultSet setComments = connection.createStatement().executeQuery(sqlComm);
                ResultSet setTotal = connection.createStatement().executeQuery(sqlTotal);

                String names = set.getString(3)+"_"+set.getString(4)+"_"+set.getString(5);

                Document document = new Document(PageSize.A4);
            PdfWriter writer = PdfWriter.getInstance(document,new FileOutputStream(NAME+".pdf"));
            document.open();

                Paragraph schoolName = new Paragraph("SCHOOL NAME", new Font(Font.FontFamily.TIMES_ROMAN, 15,Font.BOLD));
                Paragraph address = new Paragraph("P.O BOX 22332, LOCATION", new Font(Font.FontFamily.TIMES_ROMAN, 15,Font.BOLD));
                Paragraph tell = new Paragraph("PHONE: 073293874", new Font(Font.FontFamily.TIMES_ROMAN, 15,Font.BOLD));
                Paragraph reportType = new Paragraph("Report Form", new Font(Font.FontFamily.TIMES_ROMAN, 10,Font.BOLD));
                schoolName.setAlignment(Element.ALIGN_CENTER);
                address.setAlignment(Element.ALIGN_CENTER);
                tell.setAlignment(Element.ALIGN_CENTER);
                reportType.setAlignment(Element.ALIGN_CENTER);
                document.add(schoolName);
                document.add(address);
                document.add(tell);
                document.add(reportType);

                document.add((new Paragraph("ADM: "+set.getString(2)+"  "+"NAME: "+set.getString(3)+"   "+set.getString(4)+" "+set.getString(5)+"  "+"KCPE:"+set.getString(6)+"  "+"CLASS:FORM 3"+"  "+"TERM:TERM 2",new Font(Font.FontFamily.TIMES_ROMAN, 9,Font.BOLD))));
                document.add((new Paragraph("YEAR:"+now.get(Calendar.YEAR)+" "+"POS:"+String.valueOf(POS+1)+" "+"OUT OF "+ALL,new Font(Font.FontFamily.TIMES_ROMAN, 9,Font.BOLD))));
                document.add((new Paragraph(" ")));

                PdfPTable table = new PdfPTable(7);
                table.setWidthPercentage(105);
                table.setSpacingBefore(0f);
                table.setSpacingAfter(0f);

                float[] colWidth = {1.1f,0.5f,0.5f,0.5f,0.7f,2f,1f};
                table.setWidths(colWidth);
                PdfPCell c1 = new PdfPCell(new Paragraph("SUBJECTS",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell c2 = new PdfPCell(new Paragraph("EX1",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell c3 = new PdfPCell(new Paragraph("EX2",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell c4 = new PdfPCell(new Paragraph("EX3",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell c5 = new PdfPCell(new Paragraph("AVG",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell c6 = new PdfPCell(new Paragraph("COMMENTS",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell c7 = new PdfPCell(new Paragraph("TEACHER",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                table.addCell(c1);
                table.addCell(c2);
                table.addCell(c3);
                table.addCell(c4);
                table.addCell(c5);
                table.addCell(c6);
                table.addCell(c7);

                //set eng results
                String g,com=null;
                PdfPCell engD1 = new PdfPCell(new Paragraph("English"));
                PdfPCell engD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell engD3 = new PdfPCell(new Paragraph(setE2.getString(8)+" "+setE2.getString(9)));
                PdfPCell engD4 = new PdfPCell(new Paragraph(" "));

                int avgE= Integer.parseInt(setE2.getString(8));
                if (avgE >= Integer.parseInt(setEngGrade.getString(4))) {com = setComments.getString(2); } else if (avgE >= Integer.parseInt(setEngGrade.getString(5))) { com = setComments.getString(3); }else if (avgE >=Integer.parseInt(setEngGrade.getString(6))){ com = setComments.getString(4);}else if (avgE >=Integer.parseInt(setEngGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgE >=Integer.parseInt(setEngGrade.getString(8))){  com = setComments.getString(6); }else if (avgE >=Integer.parseInt(setEngGrade.getString(9))){ com = setComments.getString(7); }else if (avgE >=Integer.parseInt(setEngGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgE >=Integer.parseInt(setEngGrade.getString(11))){ com = setComments.getString(9);}else if (avgE >=Integer.parseInt(setEngGrade.getString(12))){ com = setComments.getString(10);}else if (avgE >=Integer.parseInt(setEngGrade.getString(13))){ com = setComments.getString(11);}else if (avgE >=Integer.parseInt(setEngGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }
                PdfPCell engD5 = new PdfPCell(new Paragraph(setE2.getString(8)+" "+setE2.getString(9)));
                PdfPCell engD6 = new PdfPCell(new Paragraph(com));
                PdfPCell engD7 = new PdfPCell(new Paragraph(setEngTeacher.getString(6)));
                table.addCell(engD1);
                table.addCell(engD2);
                table.addCell(engD3);
                table.addCell(engD4);
                table.addCell(engD5);
                table.addCell(engD6);
                table.addCell(engD7);

                //set kis results
                PdfPCell kisD1 = new PdfPCell(new Paragraph("Kiswahili"));
                PdfPCell kisD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell kisD3 = new PdfPCell(new Paragraph(setE2.getString(11)+" "+setE2.getString(12)));
                PdfPCell kisD4 = new PdfPCell(new Paragraph(" "));

                int avgKis= Integer.parseInt(setE2.getString(11));
                if (avgKis >= Integer.parseInt(setKisGrade.getString(4))) {com = setComments.getString(2); } else if (avgKis >= Integer.parseInt(setKisGrade.getString(5))) { com = setComments.getString(3); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(6))){ com = setComments.getString(4);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(8))){  com = setComments.getString(6); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(9))){ com = setComments.getString(7); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgKis >=Integer.parseInt(setKisGrade.getString(11))){ com = setComments.getString(9);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(12))){ com = setComments.getString(10);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(13))){ com = setComments.getString(11);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }
                PdfPCell kisD5 = new PdfPCell(new Paragraph(setE2.getString(11)+" "+setE2.getString(12)));
                PdfPCell kisD6 = new PdfPCell(new Paragraph(com));
                PdfPCell kisD7 = new PdfPCell(new Paragraph(setKisTeacher.getString(6)));
                table.addCell(kisD1);
                table.addCell(kisD2);
                table.addCell(kisD3);
                table.addCell(kisD4);
                table.addCell(kisD5);
                table.addCell(kisD6);
                table.addCell(kisD7);

                //set mat results

                PdfPCell matD1 = new PdfPCell(new Paragraph("Mathematics"));
                PdfPCell matD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell matD3 = new PdfPCell(new Paragraph(setE2.getString(14)+" "+setE2.getString(15)));
                PdfPCell matD4 = new PdfPCell(new Paragraph(" "));

                int avgMat = Integer.parseInt(setE2.getString(14));
                if (avgMat >= Integer.parseInt(setMatGrade.getString(4))) {com = setComments.getString(2); } else if (avgMat >= Integer.parseInt(setMatGrade.getString(5))) { com = setComments.getString(3); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(6))){ com = setComments.getString(4);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(8))){  com = setComments.getString(6); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(9))){ com = setComments.getString(7); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgMat >=Integer.parseInt(setMatGrade.getString(11))){ com = setComments.getString(9);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(12))){ com = setComments.getString(10);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(13))){ com = setComments.getString(11);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell matD5 = new PdfPCell(new Paragraph(setE2.getString(14)+" "+setE2.getString(15)));
                PdfPCell matD6 = new PdfPCell(new Paragraph(com));
                PdfPCell matD7 = new PdfPCell(new Paragraph(setMatTeacher.getString(6)));
                table.addCell(matD1);
                table.addCell(matD2);
                table.addCell(matD3);
                table.addCell(matD4);
                table.addCell(matD5);
                table.addCell(matD6);
                table.addCell(matD7);

                //set Chemistry results
                PdfPCell chemD1 = new PdfPCell(new Paragraph("Chemistry"));
                PdfPCell chemD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell chemD3 = new PdfPCell(new Paragraph(setE2.getString(20)+" "+setE2.getString(21)));
                PdfPCell chemD4 = new PdfPCell(new Paragraph(" "));

                int avgChem = Integer.parseInt(setE2.getString(20));
                if (avgChem >= Integer.parseInt(setChemGrade.getString(4))) {com = setComments.getString(2); } else if (avgChem >= Integer.parseInt(setChemGrade.getString(5))) { com = setComments.getString(3); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(6))){ com = setComments.getString(4);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(8))){  com = setComments.getString(6); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(9))){ com = setComments.getString(7); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgChem >=Integer.parseInt(setChemGrade.getString(11))){ com = setComments.getString(9);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(12))){ com = setComments.getString(10);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(13))){ com = setComments.getString(11);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell chemD5 = new PdfPCell(new Paragraph(setE2.getString(20)+" "+setE2.getString(21)));
                PdfPCell chemD6 = new PdfPCell(new Paragraph(com));
                PdfPCell chemD7 = new PdfPCell(new Paragraph(setChemTeacher.getString(6)));
                table.addCell(chemD1);
                table.addCell(chemD2);
                table.addCell(chemD3);
                table.addCell(chemD4);
                table.addCell(chemD5);
                table.addCell(chemD6);
                table.addCell(chemD7);

                //set Biology Results
                PdfPCell bioD1 = new PdfPCell(new Paragraph("Biology"));
                PdfPCell bioD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell bioD3 = new PdfPCell(new Paragraph(setE2.getString(17)+" "+setE2.getString(18)));
                PdfPCell bioD4 = new PdfPCell(new Paragraph(" "));

                int avgBio = Integer.parseInt(setE2.getString(17));
                if (avgBio >= Integer.parseInt(setBioGrade.getString(4))) {com = setComments.getString(2); } else if (avgBio >= Integer.parseInt(setBioGrade.getString(5))) { com = setComments.getString(3); }else if (avgBio >=Integer.parseInt(setBioGrade.getString(6))){ com = setComments.getString(4);}else if (avgBio >=Integer.parseInt(setBioGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgBio >=Integer.parseInt(setBioGrade.getString(8))){  com = setComments.getString(6); }else if (avgBio >=Integer.parseInt(setBioGrade.getString(9))){ com = setComments.getString(7); }else if (avgBio >=Integer.parseInt(setBioGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgBio >=Integer.parseInt(setBioGrade.getString(11))){ com = setComments.getString(9);}else if (avgBio >=Integer.parseInt(setBioGrade.getString(12))){ com = setComments.getString(10);}else if (avgBio >=Integer.parseInt(setBioGrade.getString(13))){ com = setComments.getString(11);}else if (avgBio >=Integer.parseInt(setBioGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell bioD5 = new PdfPCell(new Paragraph(setE2.getString(17)+" "+setE2.getString(18)));
                PdfPCell bioD6 = new PdfPCell(new Paragraph(com));
                PdfPCell bioD7 = new PdfPCell(new Paragraph(setBioTeacher.getString(6)));
                table.addCell(bioD1);
                table.addCell(bioD2);
                table.addCell(bioD3);
                table.addCell(bioD4);
                table.addCell(bioD5);
                table.addCell(bioD6);
                table.addCell(bioD7);

                //set Geography results
                PdfPCell geoD1 = new PdfPCell(new Paragraph("Geography"));
                PdfPCell geoD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell geoD3 = new PdfPCell(new Paragraph(setE2.getString(26)+" "+setE2.getString(27)));
                PdfPCell geoD4 = new PdfPCell(new Paragraph(" "));

                int avgGeo = Integer.parseInt(setE2.getString(26));
                if (avgGeo >= Integer.parseInt(setGeoGrade.getString(4))) {com = setComments.getString(2); } else if (avgGeo >= Integer.parseInt(setGeoGrade.getString(5))) { com = setComments.getString(3); }else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(6))){ com = setComments.getString(4);}else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(8))){  com = setComments.getString(6); }else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(9))){ com = setComments.getString(7); }else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(11))){ com = setComments.getString(9);}else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(12))){ com = setComments.getString(10);}else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(13))){ com = setComments.getString(11);}else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell geoD5 = new PdfPCell(new Paragraph(setE2.getString(26)+" "+setE2.getString(27)));
                PdfPCell geoD6 = new PdfPCell(new Paragraph(com));
                PdfPCell geoD7 = new PdfPCell(new Paragraph(setGeoTeacher.getString(6)));
                table.addCell(geoD1);
                table.addCell(geoD2);
                table.addCell(geoD3);
                table.addCell(geoD4);
                table.addCell(geoD5);
                table.addCell(geoD6);
                table.addCell(geoD7);

                //set Business results
                PdfPCell busD1 = new PdfPCell(new Paragraph("Business"));
                PdfPCell busD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell busD3 = new PdfPCell(new Paragraph(setE2.getString(35)+" "+setE2.getString(36)));
                PdfPCell busD4 = new PdfPCell(new Paragraph(" "));

                int avgBus = Integer.parseInt(setE2.getString(35));
                if (avgBus >= Integer.parseInt(setBusGrade.getString(4))) {com = setComments.getString(2); } else if (avgBus >= Integer.parseInt(setBusGrade.getString(5))) { com = setComments.getString(3); }else if (avgBus >=Integer.parseInt(setBusGrade.getString(6))){ com = setComments.getString(4);}else if (avgBus >=Integer.parseInt(setBusGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgBus >=Integer.parseInt(setBusGrade.getString(8))){  com = setComments.getString(6); }else if (avgBus >=Integer.parseInt(setBusGrade.getString(9))){ com = setComments.getString(7); }else if (avgBus >=Integer.parseInt(setBusGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgBus >=Integer.parseInt(setBusGrade.getString(11))){ com = setComments.getString(9);}else if (avgBus >=Integer.parseInt(setBusGrade.getString(12))){ com = setComments.getString(10);}else if (avgBus >=Integer.parseInt(setBusGrade.getString(13))){ com = setComments.getString(11);}else if (avgBus >=Integer.parseInt(setBusGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell busD5 = new PdfPCell(new Paragraph(setE2.getString(35)+" "+setE2.getString(36)));
                PdfPCell busD6 = new PdfPCell(new Paragraph(com));
                PdfPCell busD7 = new PdfPCell(new Paragraph(setBusTeacher.getString(6)));
                table.addCell(busD1);
                table.addCell(busD2);
                table.addCell(busD3);
                table.addCell(busD4);
                table.addCell(busD5);
                table.addCell(busD6);
                table.addCell(busD7);

                //set total results

                int totalE2 = Integer.parseInt(setE2.getString(41));



                PdfPCell totalD1 = new PdfPCell(new Paragraph("Total"));
                PdfPCell totalD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell totalD3 = new PdfPCell(new Paragraph(String.valueOf(totalE2)));
                PdfPCell totalD4 = new PdfPCell(new Paragraph(" "));
                PdfPCell totalD5 = new PdfPCell(new Paragraph(" "));
                PdfPCell totalD6 = new PdfPCell(new Paragraph(""));
                PdfPCell totalD7 = new PdfPCell(new Paragraph(""));
                table.addCell(totalD1);
                table.addCell(totalD2);
                table.addCell(totalD3);
                table.addCell(totalD4);
                table.addCell(totalD5);
                table.addCell(totalD6);
                table.addCell(totalD7);

                //set average results

                //int add2AvgEx1 = (Math.addExact(totalEx1Mat,addAvgEx1))/3;

                int addAvgEx2 = Math.round(totalE2/7);
                //int add2AvgEx2 = (Math.addExact(totalEx2Mat,addAvgEx2))/3;


                //int add2AvgEx3 = (Math.addExact(totalEx3Mat,addAvgEx3))/3;


                PdfPCell avgD1 = new PdfPCell(new Paragraph("Average"));
                PdfPCell avgD2 = new PdfPCell(new Paragraph(" "));
                if (addAvgEx2 >= Integer.parseInt(setTotal.getString(4))) {g = "A"; } else if (addAvgEx2 >= Integer.parseInt(setTotal.getString(5))) { g = "A-"; }else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(6))){ g = "B+";}else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(7))){
                    g = "B"; }else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(8))){  g = "B-"; }else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(9))){ g = "C+"; }else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(10))){ g = "C";
                }else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(11))){ g = "C-";}else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(12))){ g = "D+";}else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(13))){ g = "D";}else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(14))){
                    g = "D-";}else {g="E"; }
                PdfPCell avgD3 = new PdfPCell(new Paragraph(String.valueOf(addAvgEx2)+" "+g));


                PdfPCell avgD4 = new PdfPCell(new Paragraph(" "));

                //float avgAvgTotal = (addAvgEx1+addAvgEx2+addAvgEx3)/3;
                int avgAvgTotal=Integer.parseInt(setE2.getString(41))/7;

                if (avgAvgTotal >= Integer.parseInt(setTotal.getString(4))) {g = "A"; } else if (avgAvgTotal >= Integer.parseInt(setTotal.getString(5))) { g = "A-"; }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(6))){ g = "B+";}else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(7))){
                    g = "B"; }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(8))){  g = "B-"; }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(9))){ g = "C+"; }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(10))){ g = "C";
                }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(11))){ g = "C-";}else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(12))){ g = "D+";}else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(13))){ g = "D";}else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(14))){
                    g = "D-";}else {g="E"; }

                PdfPCell avgD5 = new PdfPCell(new Paragraph(String.valueOf(Math.round(avgAvgTotal))+" "+g));
                PdfPCell avgD6 = new PdfPCell(new Paragraph(""));
                PdfPCell avgD7 = new PdfPCell(new Paragraph(""));
                table.addCell(avgD1);
                table.addCell(avgD2);
                table.addCell(avgD3);
                table.addCell(avgD4);
                table.addCell(avgD5);
                table.addCell(avgD6);
                table.addCell(avgD7);

                document.add(table);

                Paragraph labelSummary = new Paragraph("PERFORMANCE TREND",new Font(Font.FontFamily.TIMES_ROMAN, 8,Font.BOLD));
                labelSummary.setSpacingBefore(0);
                labelSummary.setSpacingAfter(5);
                labelSummary.setAlignment(Element.ALIGN_CENTER);
                document.add(labelSummary);

                PdfPTable tableLastSummary = new PdfPTable(8);
                tableLastSummary.setWidthPercentage(105);
                tableLastSummary.setSpacingBefore(0f);
                tableLastSummary.setSpacingAfter(0f);

                float[] colWidthSummary = {0.5f,0.5f,0.5f,0.5f,0.5f,0.5f,0.5f,0.5f};
                tableLastSummary.setWidths(colWidthSummary);
                PdfPCell cS1 = new PdfPCell(new Paragraph("FORM 1",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell cS2 = new PdfPCell(new Paragraph(" ",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell cS3 = new PdfPCell(new Paragraph("FORM 2",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell cS4 = new PdfPCell(new Paragraph(" ",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell cS5 = new PdfPCell(new Paragraph("FORM 3",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell cS6 = new PdfPCell(new Paragraph(" ",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell cS7 = new PdfPCell(new Paragraph("FORM 4",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell cS8 = new PdfPCell(new Paragraph(" ",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                tableLastSummary.addCell(cS1);
                tableLastSummary.addCell(cS2);
                tableLastSummary.addCell(cS3);
                tableLastSummary.addCell(cS4);
                tableLastSummary.addCell(cS5);
                tableLastSummary.addCell(cS6);
                tableLastSummary.addCell(cS7);
                tableLastSummary.addCell(cS8);

                PdfPCell f1t1 = new PdfPCell(new Paragraph("F1T1"));
                PdfPCell f1t1m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF1T1E2.getString(30)))/11)+" "+setF1T1E2.getString(31)));
                PdfPCell f2t1 = new PdfPCell(new Paragraph("F2T1"));
                PdfPCell f2t1m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF2T1E2.getString(30)))/11)+" "+setF2T1E2.getString(31)));
                PdfPCell f3t1 = new PdfPCell(new Paragraph("F3T1"));
                PdfPCell f3t1m = new PdfPCell(new Paragraph(String.valueOf(Integer.parseInt(setF3T1E2.getString(41))/11)+" "+setF3T1E2.getString(43)+" "+setF3T1E2.getString(42)));
                PdfPCell f4t1 = new PdfPCell(new Paragraph("F4T1"));
                PdfPCell f4t1m = new PdfPCell(new Paragraph(" "));
                tableLastSummary.addCell(f1t1);
                tableLastSummary.addCell(f1t1m);
                tableLastSummary.addCell(f2t1);
                tableLastSummary.addCell(f2t1m);
                tableLastSummary.addCell(f3t1);
                tableLastSummary.addCell(f3t1m);
                tableLastSummary.addCell(f4t1);
                tableLastSummary.addCell(f4t1m);

                PdfPCell f1t2 = new PdfPCell(new Paragraph("F1T2"));
                PdfPCell f1t2m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF1T2E2.getString(30)))/11)+" "+setF1T2E2.getString(31)));
                PdfPCell f2t2 = new PdfPCell(new Paragraph("F2T2"));
                PdfPCell f2t2m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF2T2E2.getString(30)))/11)+" "+setF2T2E2.getString(31)));
                PdfPCell f3t2 = new PdfPCell(new Paragraph("F3T2"));
                PdfPCell f3t2m = new PdfPCell(new Paragraph(String.valueOf(avgAvgTotal)+" "+setE2.getString(42)+" "+setE2.getString(43)));
                PdfPCell f4t2 = new PdfPCell(new Paragraph("F4T2"));
                PdfPCell f4t2m = new PdfPCell(new Paragraph(" "));
                tableLastSummary.addCell(f1t2);
                tableLastSummary.addCell(f1t2m);
                tableLastSummary.addCell(f2t2);
                tableLastSummary.addCell(f2t2m);
                tableLastSummary.addCell(f3t2);
                tableLastSummary.addCell(f3t2m);
                tableLastSummary.addCell(f4t2);
                tableLastSummary.addCell(f4t2m);

                PdfPCell f1t3 = new PdfPCell(new Paragraph("F1T3"));
                PdfPCell f1t3m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF1T3E2.getString(30)))/11)+" "+setF1T3E2.getString(31)));
                PdfPCell f2t3 = new PdfPCell(new Paragraph("F2T3"));
                PdfPCell f2t3m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF2T3E2.getString(30)))/11)+" "+setF2T3E2.getString(31)));
                PdfPCell f3t3 = new PdfPCell(new Paragraph("F3T3"));
                PdfPCell f3t3m = new PdfPCell(new Paragraph(" "));
                PdfPCell f4t3 = new PdfPCell(new Paragraph("F4T3"));
                PdfPCell f4t3m = new PdfPCell(new Paragraph(" "));
                tableLastSummary.addCell(f1t3);
                tableLastSummary.addCell(f1t3m);
                tableLastSummary.addCell(f2t3);
                tableLastSummary.addCell(f2t3m);
                tableLastSummary.addCell(f3t3);
                tableLastSummary.addCell(f3t3m);
                tableLastSummary.addCell(f4t3);
                tableLastSummary.addCell(f4t3m);

                document.add(tableLastSummary);
            /*
            * logo
            * */
                Image img = Image.getInstance(cname+"\\HS Results\\Web-Development.png");
                img.scaleAbsolute(100,50);
                img.setAbsolutePosition(30,750);
                document.add(img);

            /*
            * chart
            * */
                DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
                JFreeChart chart = ChartFactory.createBarChart(
                        "", "", "Marks",
                        dataSet, PlotOrientation.VERTICAL, false, false, false);
                int width=500; /* Width of our chart */
                int height=150; /* Height of our chart */
/* Get instance of CategoryPlot */
                CategoryPlot plot = chart.getCategoryPlot();
                BarRenderer renderer = (BarRenderer) plot.getRenderer();
                renderer.setSeriesPaint(0, Color.black);
                dataSet.setValue((Integer.parseInt(setF1T1E2.getString(30))/11)/7, "Marks", "F1T1");
                dataSet.setValue((Integer.parseInt(setF1T2E2.getString(30))/11)/7, "Marks", "F1T2");
                dataSet.setValue((Integer.parseInt(setF1T3E2.getString(30))/11)/7, "Marks", "F1T3");
                dataSet.setValue((Integer.parseInt(setF2T1E2.getString(30))/11)/7, "Marks", "F2T1");
                dataSet.setValue((Integer.parseInt(setF2T2E2.getString(30))/11)/7, "Marks", "F2T2");
                dataSet.setValue((Integer.parseInt(setF2T3E2.getString(30))/11)/7, "Marks", "F2T3");
                dataSet.setValue(Float.parseFloat(setF3T1E2.getString(43)), "Marks", "F3T1");
                dataSet.setValue(Float.parseFloat(setE2.getString(43)), "Marks", "F3T2");
                dataSet.setValue(0, "Marks", "F3T3");
                dataSet.setValue(0, "Marks", "F4T1");
                dataSet.setValue(0, "Marks", "F4T2");
                dataSet.setValue(0, "Marks", "F4T3");
                PdfContentByte contentByte = writer.getDirectContent();
                PdfTemplate template = contentByte.createTemplate(width, height);
                Graphics2D graphics2d = template.createGraphics(width, height,new DefaultFontMapper());
                Rectangle2D rectangle2d = new Rectangle2D.Double(0, 0, width, height);
                chart.draw(graphics2d, rectangle2d);
                graphics2d.dispose();
                contentByte.addTemplate(template, 30, 275);

                Paragraph classTeacherComments = new Paragraph("Class teacher comments: _________________________________________________________");
                Paragraph classTeacherComments1 = new Paragraph("______________________________________________________________________________");
                Paragraph principalComments =new Paragraph("Principal comments: _____________________________________________________________");
                Paragraph principalComments1 =new Paragraph("______________________________________________________________________________");

                classTeacherComments.setSpacingBefore(170);
                document.add(classTeacherComments);
                document.add(classTeacherComments1);
                document.add(principalComments);
                document.add(principalComments1);
                document.close();
            writer.close();
            infoBox("Document containing exam2 results for " + NAME + " has been created open it for printing.","Done",null);
            Desktop.getDesktop().open(new File(cname+"\\HS Results\\"+NAME+".pdf"));


            }catch (Exception e){
                e.printStackTrace();
                infoBoxError("An error occurred " + e,"Error",null);
            }}else {
            infoBoxError("You are not allowed to print","Error",null);
        }
    }

    private void printPhyCreAgri(String ADM,int POS, String ALL) {
        if(printPassword.toString().equals("vic")) {
            String sqlDetails="SELECT * FROM tbl_students WHERE adm=?";
            String sqlComm = "SELECT * FROM tbl_comments";
            String sqlTotal ="SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='TOTAL'";

            String sqlEx2 = "SELECT * FROM tbl_f3_t2_ex2 WHERE adm=? ";
            String sqlF1T1Ex2 = "SELECT * FROM tbl_f1_t1_ex2 WHERE adm=?";
            String sqlF1T2Ex2 = "SELECT * FROM tbl_f1_t2_ex2 WHERE adm=?";
            String sqlF1T3Ex2 = "SELECT * FROM tbl_f1_t3_ex2 WHERE adm=?";
            String sqlF2T1Ex2 = "SELECT * FROM tbl_f2_t1_ex2 WHERE adm=?";
            String sqlF2T2Ex2 = "SELECT * FROM tbl_f2_t2_ex2 WHERE adm=?";
            String sqlF2T3Ex2 = "SELECT * FROM tbl_f2_t3_ex2 WHERE adm=?";
            String sqlF3T1Ex2 = "SELECT * FROM tbl_f3_t1_ex2 WHERE adm=?";


            String sqlEngTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='English'";
            String sqlKisTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='Kiswahili'";
            String sqlMatTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='Mathematics'";
            String sqlChemTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='Chemistry'";
            String sqlBioTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='Biology'";
            String sqlPhyTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='Physics'";
            String sqlHisTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='History'";
            String sqlGeoTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='Geography'";
            String sqlCreTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='CRE'";
            String sqlBusTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='Business'";
            String sqlAgriTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='Agriculture'";

            String sqlEngGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='ENGLISH'";
            String sqlKisGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='KISWAHILI'";
            String sqlMatGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='MATHEMATICS'";
            String sqlChemGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='CHEMISTRY'";
            String sqlBioGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='BIOLOGY'";
            String sqlPhyGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='PHYSICS'";
            String sqlHisGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='HISTORY'";
            String sqlGeoGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='GEOGRAPHY'";
            String sqlCreGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='CRE'";
            String sqlBusGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='BUSINESS'";
            String sqlAgriGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='AGRICULTURE'";

            try{
                Connection connection = Database.DBConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sqlDetails);

                PreparedStatement statementE2 = connection.prepareStatement(sqlEx2);
                PreparedStatement statementF1T1E2 = connection.prepareStatement(sqlF1T1Ex2);
                PreparedStatement statementF1T2E2 = connection.prepareStatement(sqlF1T2Ex2);
                PreparedStatement statementF1T3E2 = connection.prepareStatement(sqlF1T3Ex2);
                PreparedStatement statementF2T1E2 = connection.prepareStatement(sqlF2T1Ex2);
                PreparedStatement statementF2T2E2 = connection.prepareStatement(sqlF2T2Ex2);
                PreparedStatement statementF2T3E2 = connection.prepareStatement(sqlF2T3Ex2);
                PreparedStatement statementF3T1E2 = connection.prepareStatement(sqlF3T1Ex2);



                statement.setString(1,ADM);

                statementE2.setString(1,ADM);
                statementF1T1E2.setString(1,ADM);
                statementF1T2E2.setString(1,ADM);
                statementF1T3E2.setString(1,ADM);
                statementF2T1E2.setString(1,ADM);
                statementF2T2E2.setString(1,ADM);
                statementF2T3E2.setString(1,ADM);
                statementF3T1E2.setString(1,ADM);


                ResultSet set = statement.executeQuery();

                ResultSet setE2 = statementE2.executeQuery();
                ResultSet setF1T1E2 = statementF1T1E2.executeQuery();
                ResultSet setF1T2E2 = statementF1T2E2.executeQuery();
                ResultSet setF1T3E2 = statementF1T3E2.executeQuery();
                ResultSet setF2T1E2 = statementF2T1E2.executeQuery();
                ResultSet setF2T2E2 = statementF2T2E2.executeQuery();
                ResultSet setF2T3E2 = statementF2T3E2.executeQuery();
                ResultSet setF3T1E2 = statementF3T1E2.executeQuery();


                ResultSet setEngTeacher = connection.createStatement().executeQuery(sqlEngTeacher);
                ResultSet setKisTeacher = connection.createStatement().executeQuery(sqlKisTeacher);
                ResultSet setMatTeacher = connection.createStatement().executeQuery(sqlMatTeacher);
                ResultSet setChemTeacher = connection.createStatement().executeQuery(sqlChemTeacher);
                ResultSet setBioTeacher = connection.createStatement().executeQuery(sqlBioTeacher);
                ResultSet setPhyTeacher = connection.createStatement().executeQuery(sqlPhyTeacher);
                ResultSet setHisTeacher = connection.createStatement().executeQuery(sqlHisTeacher);
                ResultSet setGeoTeacher = connection.createStatement().executeQuery(sqlGeoTeacher);
                ResultSet setCreTeacher = connection.createStatement().executeQuery(sqlCreTeacher);
                ResultSet setBusTeacher = connection.createStatement().executeQuery(sqlBusTeacher);
                ResultSet setAgriTeacher = connection.createStatement().executeQuery(sqlAgriTeacher);

                ResultSet setEngGrade = connection.createStatement().executeQuery(sqlEngGrade);
                ResultSet setKisGrade = connection.createStatement().executeQuery(sqlKisGrade);
                ResultSet setMatGrade = connection.createStatement().executeQuery(sqlMatGrade);
                ResultSet setChemGrade = connection.createStatement().executeQuery(sqlChemGrade);
                ResultSet setBioGrade = connection.createStatement().executeQuery(sqlBioGrade);
                ResultSet setPhyGrade = connection.createStatement().executeQuery(sqlPhyGrade);
                ResultSet setHisGrade = connection.createStatement().executeQuery(sqlHisGrade);
                ResultSet setGeoGrade = connection.createStatement().executeQuery(sqlGeoGrade);
                ResultSet setCreGrade = connection.createStatement().executeQuery(sqlCreGrade);
                ResultSet setBusGrade = connection.createStatement().executeQuery(sqlBusGrade);
                ResultSet setAgriGrade = connection.createStatement().executeQuery(sqlAgriGrade);

                ResultSet setComments = connection.createStatement().executeQuery(sqlComm);
                ResultSet setTotal = connection.createStatement().executeQuery(sqlTotal);

                String names = set.getString(3)+"_"+set.getString(4)+"_"+set.getString(5);

                Document document = new Document(PageSize.A4);
            PdfWriter writer = PdfWriter.getInstance(document,new FileOutputStream(NAME+".pdf"));
            document.open();

                Paragraph schoolName = new Paragraph("SCHOOL NAME", new Font(Font.FontFamily.TIMES_ROMAN, 15,Font.BOLD));
                Paragraph address = new Paragraph("P.O BOX 22332, LOCATION", new Font(Font.FontFamily.TIMES_ROMAN, 15,Font.BOLD));
                Paragraph tell = new Paragraph("PHONE: 073293874", new Font(Font.FontFamily.TIMES_ROMAN, 15,Font.BOLD));
                Paragraph reportType = new Paragraph("Report Form", new Font(Font.FontFamily.TIMES_ROMAN, 10,Font.BOLD));
                schoolName.setAlignment(Element.ALIGN_CENTER);
                address.setAlignment(Element.ALIGN_CENTER);
                tell.setAlignment(Element.ALIGN_CENTER);
                reportType.setAlignment(Element.ALIGN_CENTER);
                document.add(schoolName);
                document.add(address);
                document.add(tell);
                document.add(reportType);

                document.add((new Paragraph("ADM: "+set.getString(2)+"  "+"NAME: "+set.getString(3)+"   "+set.getString(4)+" "+set.getString(5)+"  "+"KCPE:"+set.getString(6)+"  "+"CLASS:FORM 3"+"  "+"TERM:TERM 2",new Font(Font.FontFamily.TIMES_ROMAN, 9,Font.BOLD))));
                document.add((new Paragraph("YEAR:"+now.get(Calendar.YEAR)+" "+"POS:"+String.valueOf(POS+1)+" "+"OUT OF "+ALL,new Font(Font.FontFamily.TIMES_ROMAN, 9,Font.BOLD))));
                document.add((new Paragraph(" ")));

                PdfPTable table = new PdfPTable(7);
                table.setWidthPercentage(105);
                table.setSpacingBefore(0f);
                table.setSpacingAfter(0f);

                float[] colWidth = {1.1f,0.5f,0.5f,0.5f,0.7f,2f,1f};
                table.setWidths(colWidth);
                PdfPCell c1 = new PdfPCell(new Paragraph("SUBJECTS",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell c2 = new PdfPCell(new Paragraph("EX1",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell c3 = new PdfPCell(new Paragraph("EX2",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell c4 = new PdfPCell(new Paragraph("EX3",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell c5 = new PdfPCell(new Paragraph("AVG",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell c6 = new PdfPCell(new Paragraph("COMMENTS",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell c7 = new PdfPCell(new Paragraph("TEACHER",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                table.addCell(c1);
                table.addCell(c2);
                table.addCell(c3);
                table.addCell(c4);
                table.addCell(c5);
                table.addCell(c6);
                table.addCell(c7);

                //set eng results
                String g,com=null;
                PdfPCell engD1 = new PdfPCell(new Paragraph("English"));
                PdfPCell engD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell engD3 = new PdfPCell(new Paragraph(setE2.getString(8)+" "+setE2.getString(9)));
                PdfPCell engD4 = new PdfPCell(new Paragraph(" "));

                int avgE= Integer.parseInt(setE2.getString(8));
                if (avgE >= Integer.parseInt(setEngGrade.getString(4))) {com = setComments.getString(2); } else if (avgE >= Integer.parseInt(setEngGrade.getString(5))) { com = setComments.getString(3); }else if (avgE >=Integer.parseInt(setEngGrade.getString(6))){ com = setComments.getString(4);}else if (avgE >=Integer.parseInt(setEngGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgE >=Integer.parseInt(setEngGrade.getString(8))){  com = setComments.getString(6); }else if (avgE >=Integer.parseInt(setEngGrade.getString(9))){ com = setComments.getString(7); }else if (avgE >=Integer.parseInt(setEngGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgE >=Integer.parseInt(setEngGrade.getString(11))){ com = setComments.getString(9);}else if (avgE >=Integer.parseInt(setEngGrade.getString(12))){ com = setComments.getString(10);}else if (avgE >=Integer.parseInt(setEngGrade.getString(13))){ com = setComments.getString(11);}else if (avgE >=Integer.parseInt(setEngGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }
                PdfPCell engD5 = new PdfPCell(new Paragraph(setE2.getString(8)+" "+setE2.getString(9)));
                PdfPCell engD6 = new PdfPCell(new Paragraph(com));
                PdfPCell engD7 = new PdfPCell(new Paragraph(setEngTeacher.getString(6)));
                table.addCell(engD1);
                table.addCell(engD2);
                table.addCell(engD3);
                table.addCell(engD4);
                table.addCell(engD5);
                table.addCell(engD6);
                table.addCell(engD7);

                //set kis results
                PdfPCell kisD1 = new PdfPCell(new Paragraph("Kiswahili"));
                PdfPCell kisD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell kisD3 = new PdfPCell(new Paragraph(setE2.getString(11)+" "+setE2.getString(12)));
                PdfPCell kisD4 = new PdfPCell(new Paragraph(" "));

                int avgKis= Integer.parseInt(setE2.getString(11));
                if (avgKis >= Integer.parseInt(setKisGrade.getString(4))) {com = setComments.getString(2); } else if (avgKis >= Integer.parseInt(setKisGrade.getString(5))) { com = setComments.getString(3); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(6))){ com = setComments.getString(4);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(8))){  com = setComments.getString(6); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(9))){ com = setComments.getString(7); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgKis >=Integer.parseInt(setKisGrade.getString(11))){ com = setComments.getString(9);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(12))){ com = setComments.getString(10);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(13))){ com = setComments.getString(11);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }
                PdfPCell kisD5 = new PdfPCell(new Paragraph(setE2.getString(11)+" "+setE2.getString(12)));
                PdfPCell kisD6 = new PdfPCell(new Paragraph(com));
                PdfPCell kisD7 = new PdfPCell(new Paragraph(setKisTeacher.getString(6)));
                table.addCell(kisD1);
                table.addCell(kisD2);
                table.addCell(kisD3);
                table.addCell(kisD4);
                table.addCell(kisD5);
                table.addCell(kisD6);
                table.addCell(kisD7);

                //set mat results

                PdfPCell matD1 = new PdfPCell(new Paragraph("Mathematics"));
                PdfPCell matD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell matD3 = new PdfPCell(new Paragraph(setE2.getString(14)+" "+setE2.getString(15)));
                PdfPCell matD4 = new PdfPCell(new Paragraph(" "));

                int avgMat = Integer.parseInt(setE2.getString(14));
                if (avgMat >= Integer.parseInt(setMatGrade.getString(4))) {com = setComments.getString(2); } else if (avgMat >= Integer.parseInt(setMatGrade.getString(5))) { com = setComments.getString(3); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(6))){ com = setComments.getString(4);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(8))){  com = setComments.getString(6); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(9))){ com = setComments.getString(7); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgMat >=Integer.parseInt(setMatGrade.getString(11))){ com = setComments.getString(9);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(12))){ com = setComments.getString(10);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(13))){ com = setComments.getString(11);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell matD5 = new PdfPCell(new Paragraph(setE2.getString(14)+" "+setE2.getString(15)));
                PdfPCell matD6 = new PdfPCell(new Paragraph(com));
                PdfPCell matD7 = new PdfPCell(new Paragraph(setMatTeacher.getString(6)));
                table.addCell(matD1);
                table.addCell(matD2);
                table.addCell(matD3);
                table.addCell(matD4);
                table.addCell(matD5);
                table.addCell(matD6);
                table.addCell(matD7);

                //set Chemistry results
                PdfPCell chemD1 = new PdfPCell(new Paragraph("Chemistry"));
                PdfPCell chemD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell chemD3 = new PdfPCell(new Paragraph(setE2.getString(20)+" "+setE2.getString(21)));
                PdfPCell chemD4 = new PdfPCell(new Paragraph(" "));

                int avgChem = Integer.parseInt(setE2.getString(20));
                if (avgChem >= Integer.parseInt(setChemGrade.getString(4))) {com = setComments.getString(2); } else if (avgChem >= Integer.parseInt(setChemGrade.getString(5))) { com = setComments.getString(3); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(6))){ com = setComments.getString(4);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(8))){  com = setComments.getString(6); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(9))){ com = setComments.getString(7); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgChem >=Integer.parseInt(setChemGrade.getString(11))){ com = setComments.getString(9);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(12))){ com = setComments.getString(10);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(13))){ com = setComments.getString(11);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell chemD5 = new PdfPCell(new Paragraph(setE2.getString(20)+" "+setE2.getString(21)));
                PdfPCell chemD6 = new PdfPCell(new Paragraph(com));
                PdfPCell chemD7 = new PdfPCell(new Paragraph(setChemTeacher.getString(6)));
                table.addCell(chemD1);
                table.addCell(chemD2);
                table.addCell(chemD3);
                table.addCell(chemD4);
                table.addCell(chemD5);
                table.addCell(chemD6);
                table.addCell(chemD7);

                //set Physics Results
                PdfPCell phyD1 = new PdfPCell(new Paragraph("Physics"));
                PdfPCell phyD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell phyD3 = new PdfPCell(new Paragraph(setE2.getString(23)+" "+setE2.getString(24)));
                PdfPCell phyD4 = new PdfPCell(new Paragraph(" "));

                int avgPhy = Integer.parseInt(setE2.getString(23));
                if (avgPhy >= Integer.parseInt(setPhyGrade.getString(4))) {com = setComments.getString(2); } else if (avgPhy >= Integer.parseInt(setPhyGrade.getString(5))) { com = setComments.getString(3); }else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(6))){ com = setComments.getString(4);}else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(8))){  com = setComments.getString(6); }else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(9))){ com = setComments.getString(7); }else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(11))){ com = setComments.getString(9);}else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(12))){ com = setComments.getString(10);}else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(13))){ com = setComments.getString(11);}else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell phyD5 = new PdfPCell(new Paragraph(setE2.getString(23)+" "+setE2.getString(24)));
                PdfPCell phyD6 = new PdfPCell(new Paragraph(com));
                PdfPCell phyD7 = new PdfPCell(new Paragraph(setPhyTeacher.getString(6)));
                table.addCell(phyD1);
                table.addCell(phyD2);
                table.addCell(phyD3);
                table.addCell(phyD4);
                table.addCell(phyD5);
                table.addCell(phyD6);
                table.addCell(phyD7);

                //set Cre results
                PdfPCell creD1 = new PdfPCell(new Paragraph("Cre"));
                PdfPCell creD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell creD3 = new PdfPCell(new Paragraph(setE2.getString(32)+" "+setE2.getString(33)));
                PdfPCell creD4 = new PdfPCell(new Paragraph(" "));

                int avgCre = Integer.parseInt(setE2.getString(32));
                if (avgCre >= Integer.parseInt(setCreGrade.getString(4))) {com = setComments.getString(2); } else if (avgCre >= Integer.parseInt(setCreGrade.getString(5))) { com = setComments.getString(3); }else if (avgCre >=Integer.parseInt(setCreGrade.getString(6))){ com = setComments.getString(4);}else if (avgCre >=Integer.parseInt(setCreGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgCre >=Integer.parseInt(setCreGrade.getString(8))){  com = setComments.getString(6); }else if (avgCre >=Integer.parseInt(setCreGrade.getString(9))){ com = setComments.getString(7); }else if (avgCre >=Integer.parseInt(setCreGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgCre >=Integer.parseInt(setCreGrade.getString(11))){ com = setComments.getString(9);}else if (avgCre >=Integer.parseInt(setCreGrade.getString(12))){ com = setComments.getString(10);}else if (avgCre >=Integer.parseInt(setCreGrade.getString(13))){ com = setComments.getString(11);}else if (avgCre >=Integer.parseInt(setCreGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell creD5 = new PdfPCell(new Paragraph(setE2.getString(32)+" "+setE2.getString(33)));
                PdfPCell creD6 = new PdfPCell(new Paragraph(com));
                PdfPCell creD7 = new PdfPCell(new Paragraph(setCreTeacher.getString(6)));
                table.addCell(creD1);
                table.addCell(creD2);
                table.addCell(creD3);
                table.addCell(creD4);
                table.addCell(creD5);
                table.addCell(creD6);
                table.addCell(creD7);

                //set Agriculture results
                PdfPCell agriD1 = new PdfPCell(new Paragraph("Agriculture"));
                PdfPCell agriD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell agriD3 = new PdfPCell(new Paragraph(setE2.getString(38)+" "+setE2.getString(39)));
                PdfPCell agriD4 = new PdfPCell(new Paragraph(" "));

                int avgAgri = Integer.parseInt(setE2.getString(38));
                if (avgAgri >= Integer.parseInt(setAgriGrade.getString(4))) {com = setComments.getString(2); } else if (avgAgri >= Integer.parseInt(setAgriGrade.getString(5))) { com = setComments.getString(3); }else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(6))){ com = setComments.getString(4);}else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(8))){  com = setComments.getString(6); }else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(9))){ com = setComments.getString(7); }else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(11))){ com = setComments.getString(9);}else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(12))){ com = setComments.getString(10);}else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(13))){ com = setComments.getString(11);}else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell agriD5 = new PdfPCell(new Paragraph(setE2.getString(38)+" "+setE2.getString(39)));
                PdfPCell agriD6 = new PdfPCell(new Paragraph(com));
                PdfPCell agriD7 = new PdfPCell(new Paragraph(setAgriTeacher.getString(6)));
                table.addCell(agriD1);
                table.addCell(agriD2);
                table.addCell(agriD3);
                table.addCell(agriD4);
                table.addCell(agriD5);
                table.addCell(agriD6);
                table.addCell(agriD7);

                //set total results

                int totalE2 = Integer.parseInt(setE2.getString(41));



                PdfPCell totalD1 = new PdfPCell(new Paragraph("Total"));
                PdfPCell totalD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell totalD3 = new PdfPCell(new Paragraph(String.valueOf(totalE2)));
                PdfPCell totalD4 = new PdfPCell(new Paragraph(" "));
                PdfPCell totalD5 = new PdfPCell(new Paragraph(" "));
                PdfPCell totalD6 = new PdfPCell(new Paragraph(""));
                PdfPCell totalD7 = new PdfPCell(new Paragraph(""));
                table.addCell(totalD1);
                table.addCell(totalD2);
                table.addCell(totalD3);
                table.addCell(totalD4);
                table.addCell(totalD5);
                table.addCell(totalD6);
                table.addCell(totalD7);

                //set average results

                //int add2AvgEx1 = (Math.addExact(totalEx1Mat,addAvgEx1))/3;

                int addAvgEx2 = Math.round(totalE2/7);
                //int add2AvgEx2 = (Math.addExact(totalEx2Mat,addAvgEx2))/3;


                //int add2AvgEx3 = (Math.addExact(totalEx3Mat,addAvgEx3))/3;


                PdfPCell avgD1 = new PdfPCell(new Paragraph("Average"));
                PdfPCell avgD2 = new PdfPCell(new Paragraph(" "));
                if (addAvgEx2 >= Integer.parseInt(setTotal.getString(4))) {g = "A"; } else if (addAvgEx2 >= Integer.parseInt(setTotal.getString(5))) { g = "A-"; }else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(6))){ g = "B+";}else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(7))){
                    g = "B"; }else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(8))){  g = "B-"; }else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(9))){ g = "C+"; }else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(10))){ g = "C";
                }else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(11))){ g = "C-";}else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(12))){ g = "D+";}else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(13))){ g = "D";}else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(14))){
                    g = "D-";}else {g="E"; }
                PdfPCell avgD3 = new PdfPCell(new Paragraph(String.valueOf(addAvgEx2)+" "+g));


                PdfPCell avgD4 = new PdfPCell(new Paragraph(" "));

                //float avgAvgTotal = (addAvgEx1+addAvgEx2+addAvgEx3)/3;
                int avgAvgTotal=Integer.parseInt(setE2.getString(41))/7;

                if (avgAvgTotal >= Integer.parseInt(setTotal.getString(4))) {g = "A"; } else if (avgAvgTotal >= Integer.parseInt(setTotal.getString(5))) { g = "A-"; }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(6))){ g = "B+";}else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(7))){
                    g = "B"; }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(8))){  g = "B-"; }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(9))){ g = "C+"; }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(10))){ g = "C";
                }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(11))){ g = "C-";}else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(12))){ g = "D+";}else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(13))){ g = "D";}else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(14))){
                    g = "D-";}else {g="E"; }

                PdfPCell avgD5 = new PdfPCell(new Paragraph(String.valueOf(Math.round(avgAvgTotal))+" "+g));
                PdfPCell avgD6 = new PdfPCell(new Paragraph(""));
                PdfPCell avgD7 = new PdfPCell(new Paragraph(""));
                table.addCell(avgD1);
                table.addCell(avgD2);
                table.addCell(avgD3);
                table.addCell(avgD4);
                table.addCell(avgD5);
                table.addCell(avgD6);
                table.addCell(avgD7);

                document.add(table);

                Paragraph labelSummary = new Paragraph("PERFORMANCE TREND",new Font(Font.FontFamily.TIMES_ROMAN, 8,Font.BOLD));
                labelSummary.setSpacingBefore(0);
                labelSummary.setSpacingAfter(5);
                labelSummary.setAlignment(Element.ALIGN_CENTER);
                document.add(labelSummary);

                PdfPTable tableLastSummary = new PdfPTable(8);
                tableLastSummary.setWidthPercentage(105);
                tableLastSummary.setSpacingBefore(0f);
                tableLastSummary.setSpacingAfter(0f);

                float[] colWidthSummary = {0.5f,0.5f,0.5f,0.5f,0.5f,0.5f,0.5f,0.5f};
                tableLastSummary.setWidths(colWidthSummary);
                PdfPCell cS1 = new PdfPCell(new Paragraph("FORM 1",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell cS2 = new PdfPCell(new Paragraph(" ",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell cS3 = new PdfPCell(new Paragraph("FORM 2",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell cS4 = new PdfPCell(new Paragraph(" ",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell cS5 = new PdfPCell(new Paragraph("FORM 3",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell cS6 = new PdfPCell(new Paragraph(" ",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell cS7 = new PdfPCell(new Paragraph("FORM 4",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell cS8 = new PdfPCell(new Paragraph(" ",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                tableLastSummary.addCell(cS1);
                tableLastSummary.addCell(cS2);
                tableLastSummary.addCell(cS3);
                tableLastSummary.addCell(cS4);
                tableLastSummary.addCell(cS5);
                tableLastSummary.addCell(cS6);
                tableLastSummary.addCell(cS7);
                tableLastSummary.addCell(cS8);

                PdfPCell f1t1 = new PdfPCell(new Paragraph("F1T1"));
                PdfPCell f1t1m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF1T1E2.getString(30)))/11)+" "+setF1T1E2.getString(31)));
                PdfPCell f2t1 = new PdfPCell(new Paragraph("F2T1"));
                PdfPCell f2t1m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF2T1E2.getString(30)))/11)+" "+setF2T1E2.getString(31)));
                PdfPCell f3t1 = new PdfPCell(new Paragraph("F3T1"));
                PdfPCell f3t1m = new PdfPCell(new Paragraph(String.valueOf(Integer.parseInt(setF3T1E2.getString(41))/11)+" "+setF3T1E2.getString(43)+" "+setF3T1E2.getString(42)));
                PdfPCell f4t1 = new PdfPCell(new Paragraph("F4T1"));
                PdfPCell f4t1m = new PdfPCell(new Paragraph(" "));
                tableLastSummary.addCell(f1t1);
                tableLastSummary.addCell(f1t1m);
                tableLastSummary.addCell(f2t1);
                tableLastSummary.addCell(f2t1m);
                tableLastSummary.addCell(f3t1);
                tableLastSummary.addCell(f3t1m);
                tableLastSummary.addCell(f4t1);
                tableLastSummary.addCell(f4t1m);

                PdfPCell f1t2 = new PdfPCell(new Paragraph("F1T2"));
                PdfPCell f1t2m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF1T2E2.getString(30)))/11)+" "+setF1T2E2.getString(31)));
                PdfPCell f2t2 = new PdfPCell(new Paragraph("F2T2"));
                PdfPCell f2t2m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF2T2E2.getString(30)))/11)+" "+setF2T2E2.getString(31)));
                PdfPCell f3t2 = new PdfPCell(new Paragraph("F3T2"));
                PdfPCell f3t2m = new PdfPCell(new Paragraph(String.valueOf(avgAvgTotal)+" "+setE2.getString(42)+" "+setE2.getString(43)));
                PdfPCell f4t2 = new PdfPCell(new Paragraph("F4T2"));
                PdfPCell f4t2m = new PdfPCell(new Paragraph(" "));
                tableLastSummary.addCell(f1t2);
                tableLastSummary.addCell(f1t2m);
                tableLastSummary.addCell(f2t2);
                tableLastSummary.addCell(f2t2m);
                tableLastSummary.addCell(f3t2);
                tableLastSummary.addCell(f3t2m);
                tableLastSummary.addCell(f4t2);
                tableLastSummary.addCell(f4t2m);

                PdfPCell f1t3 = new PdfPCell(new Paragraph("F1T3"));
                PdfPCell f1t3m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF1T3E2.getString(30)))/11)+" "+setF1T3E2.getString(31)));
                PdfPCell f2t3 = new PdfPCell(new Paragraph("F2T3"));
                PdfPCell f2t3m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF2T3E2.getString(30)))/11)+" "+setF2T3E2.getString(31)));
                PdfPCell f3t3 = new PdfPCell(new Paragraph("F3T3"));
                PdfPCell f3t3m = new PdfPCell(new Paragraph(" "));
                PdfPCell f4t3 = new PdfPCell(new Paragraph("F4T3"));
                PdfPCell f4t3m = new PdfPCell(new Paragraph(" "));
                tableLastSummary.addCell(f1t3);
                tableLastSummary.addCell(f1t3m);
                tableLastSummary.addCell(f2t3);
                tableLastSummary.addCell(f2t3m);
                tableLastSummary.addCell(f3t3);
                tableLastSummary.addCell(f3t3m);
                tableLastSummary.addCell(f4t3);
                tableLastSummary.addCell(f4t3m);

                document.add(tableLastSummary);
            /*
            * logo
            * */
                Image img = Image.getInstance(cname+"\\HS Results\\Web-Development.png");
                img.scaleAbsolute(100,50);
                img.setAbsolutePosition(30,750);
                document.add(img);

            /*
            * chart
            * */
                DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
                JFreeChart chart = ChartFactory.createBarChart(
                        "", "", "Marks",
                        dataSet, PlotOrientation.VERTICAL, false, false, false);
                int width=500; /* Width of our chart */
                int height=150; /* Height of our chart */
/* Get instance of CategoryPlot */
                CategoryPlot plot = chart.getCategoryPlot();
                BarRenderer renderer = (BarRenderer) plot.getRenderer();
                renderer.setSeriesPaint(0, Color.black);
                dataSet.setValue((Integer.parseInt(setF1T1E2.getString(30))/11)/7, "Marks", "F1T1");
                dataSet.setValue((Integer.parseInt(setF1T2E2.getString(30))/11)/7, "Marks", "F1T2");
                dataSet.setValue((Integer.parseInt(setF1T3E2.getString(30))/11)/7, "Marks", "F1T3");
                dataSet.setValue((Integer.parseInt(setF2T1E2.getString(30))/11)/7, "Marks", "F2T1");
                dataSet.setValue((Integer.parseInt(setF2T2E2.getString(30))/11)/7, "Marks", "F2T2");
                dataSet.setValue((Integer.parseInt(setF2T3E2.getString(30))/11)/7, "Marks", "F2T3");
                dataSet.setValue(Float.parseFloat(setF3T1E2.getString(43)), "Marks", "F3T1");
                dataSet.setValue(Float.parseFloat(setE2.getString(43)), "Marks", "F3T2");
                dataSet.setValue(0, "Marks", "F3T3");
                dataSet.setValue(0, "Marks", "F4T1");
                dataSet.setValue(0, "Marks", "F4T2");
                dataSet.setValue(0, "Marks", "F4T3");
                PdfContentByte contentByte = writer.getDirectContent();
                PdfTemplate template = contentByte.createTemplate(width, height);
                Graphics2D graphics2d = template.createGraphics(width, height,new DefaultFontMapper());
                Rectangle2D rectangle2d = new Rectangle2D.Double(0, 0, width, height);
                chart.draw(graphics2d, rectangle2d);
                graphics2d.dispose();
                contentByte.addTemplate(template, 30, 275);

                Paragraph classTeacherComments = new Paragraph("Class teacher comments: _________________________________________________________");
                Paragraph classTeacherComments1 = new Paragraph("______________________________________________________________________________");
                Paragraph principalComments =new Paragraph("Principal comments: _____________________________________________________________");
                Paragraph principalComments1 =new Paragraph("______________________________________________________________________________");

                classTeacherComments.setSpacingBefore(170);
                document.add(classTeacherComments);
                document.add(classTeacherComments1);
                document.add(principalComments);
                document.add(principalComments1);
                document.close();
            writer.close();
            infoBox("Document containing exam2 results for " + NAME + " has been created open it for printing.","Done",null);
            Desktop.getDesktop().open(new File(cname+"\\HS Results\\"+NAME+".pdf"));


            }catch (Exception e){
                e.printStackTrace();
                infoBoxError("An error occurred " + e,"Error",null);
            }}else {
            infoBoxError("You are not allowed to print","Error",null);
        }
    }

    private void printPhyCreBus(String ADM,int POS, String ALL) {
        if(printPassword.toString().equals("vic")) {
            String sqlDetails="SELECT * FROM tbl_students WHERE adm=?";
            String sqlComm = "SELECT * FROM tbl_comments";
            String sqlTotal ="SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='TOTAL'";

            String sqlEx2 = "SELECT * FROM tbl_f3_t2_ex2 WHERE adm=? ";
            String sqlF1T1Ex2 = "SELECT * FROM tbl_f1_t1_ex2 WHERE adm=?";
            String sqlF1T2Ex2 = "SELECT * FROM tbl_f1_t2_ex2 WHERE adm=?";
            String sqlF1T3Ex2 = "SELECT * FROM tbl_f1_t3_ex2 WHERE adm=?";
            String sqlF2T1Ex2 = "SELECT * FROM tbl_f2_t1_ex2 WHERE adm=?";
            String sqlF2T2Ex2 = "SELECT * FROM tbl_f2_t2_ex2 WHERE adm=?";
            String sqlF2T3Ex2 = "SELECT * FROM tbl_f2_t3_ex2 WHERE adm=?";
            String sqlF3T1Ex2 = "SELECT * FROM tbl_f3_t1_ex2 WHERE adm=?";


            String sqlEngTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='English'";
            String sqlKisTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='Kiswahili'";
            String sqlMatTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='Mathematics'";
            String sqlChemTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='Chemistry'";
            String sqlBioTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='Biology'";
            String sqlPhyTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='Physics'";
            String sqlHisTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='History'";
            String sqlGeoTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='Geography'";
            String sqlCreTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='CRE'";
            String sqlBusTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='Business'";
            String sqlAgriTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='Agriculture'";

            String sqlEngGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='ENGLISH'";
            String sqlKisGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='KISWAHILI'";
            String sqlMatGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='MATHEMATICS'";
            String sqlChemGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='CHEMISTRY'";
            String sqlBioGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='BIOLOGY'";
            String sqlPhyGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='PHYSICS'";
            String sqlHisGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='HISTORY'";
            String sqlGeoGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='GEOGRAPHY'";
            String sqlCreGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='CRE'";
            String sqlBusGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='BUSINESS'";
            String sqlAgriGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='AGRICULTURE'";

            try{
                Connection connection = Database.DBConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sqlDetails);

                PreparedStatement statementE2 = connection.prepareStatement(sqlEx2);
                PreparedStatement statementF1T1E2 = connection.prepareStatement(sqlF1T1Ex2);
                PreparedStatement statementF1T2E2 = connection.prepareStatement(sqlF1T2Ex2);
                PreparedStatement statementF1T3E2 = connection.prepareStatement(sqlF1T3Ex2);
                PreparedStatement statementF2T1E2 = connection.prepareStatement(sqlF2T1Ex2);
                PreparedStatement statementF2T2E2 = connection.prepareStatement(sqlF2T2Ex2);
                PreparedStatement statementF2T3E2 = connection.prepareStatement(sqlF2T3Ex2);
                PreparedStatement statementF3T1E2 = connection.prepareStatement(sqlF3T1Ex2);



                statement.setString(1,ADM);

                statementE2.setString(1,ADM);
                statementF1T1E2.setString(1,ADM);
                statementF1T2E2.setString(1,ADM);
                statementF1T3E2.setString(1,ADM);
                statementF2T1E2.setString(1,ADM);
                statementF2T2E2.setString(1,ADM);
                statementF2T3E2.setString(1,ADM);
                statementF3T1E2.setString(1,ADM);


                ResultSet set = statement.executeQuery();

                ResultSet setE2 = statementE2.executeQuery();
                ResultSet setF1T1E2 = statementF1T1E2.executeQuery();
                ResultSet setF1T2E2 = statementF1T2E2.executeQuery();
                ResultSet setF1T3E2 = statementF1T3E2.executeQuery();
                ResultSet setF2T1E2 = statementF2T1E2.executeQuery();
                ResultSet setF2T2E2 = statementF2T2E2.executeQuery();
                ResultSet setF2T3E2 = statementF2T3E2.executeQuery();
                ResultSet setF3T1E2 = statementF3T1E2.executeQuery();


                ResultSet setEngTeacher = connection.createStatement().executeQuery(sqlEngTeacher);
                ResultSet setKisTeacher = connection.createStatement().executeQuery(sqlKisTeacher);
                ResultSet setMatTeacher = connection.createStatement().executeQuery(sqlMatTeacher);
                ResultSet setChemTeacher = connection.createStatement().executeQuery(sqlChemTeacher);
                ResultSet setBioTeacher = connection.createStatement().executeQuery(sqlBioTeacher);
                ResultSet setPhyTeacher = connection.createStatement().executeQuery(sqlPhyTeacher);
                ResultSet setHisTeacher = connection.createStatement().executeQuery(sqlHisTeacher);
                ResultSet setGeoTeacher = connection.createStatement().executeQuery(sqlGeoTeacher);
                ResultSet setCreTeacher = connection.createStatement().executeQuery(sqlCreTeacher);
                ResultSet setBusTeacher = connection.createStatement().executeQuery(sqlBusTeacher);
                ResultSet setAgriTeacher = connection.createStatement().executeQuery(sqlAgriTeacher);

                ResultSet setEngGrade = connection.createStatement().executeQuery(sqlEngGrade);
                ResultSet setKisGrade = connection.createStatement().executeQuery(sqlKisGrade);
                ResultSet setMatGrade = connection.createStatement().executeQuery(sqlMatGrade);
                ResultSet setChemGrade = connection.createStatement().executeQuery(sqlChemGrade);
                ResultSet setBioGrade = connection.createStatement().executeQuery(sqlBioGrade);
                ResultSet setPhyGrade = connection.createStatement().executeQuery(sqlPhyGrade);
                ResultSet setHisGrade = connection.createStatement().executeQuery(sqlHisGrade);
                ResultSet setGeoGrade = connection.createStatement().executeQuery(sqlGeoGrade);
                ResultSet setCreGrade = connection.createStatement().executeQuery(sqlCreGrade);
                ResultSet setBusGrade = connection.createStatement().executeQuery(sqlBusGrade);
                ResultSet setAgriGrade = connection.createStatement().executeQuery(sqlAgriGrade);

                ResultSet setComments = connection.createStatement().executeQuery(sqlComm);
                ResultSet setTotal = connection.createStatement().executeQuery(sqlTotal);

                String names = set.getString(3)+"_"+set.getString(4)+"_"+set.getString(5);

                Document document = new Document(PageSize.A4);
            PdfWriter writer = PdfWriter.getInstance(document,new FileOutputStream(NAME+".pdf"));
            document.open();

                Paragraph schoolName = new Paragraph("SCHOOL NAME", new Font(Font.FontFamily.TIMES_ROMAN, 15,Font.BOLD));
                Paragraph address = new Paragraph("P.O BOX 22332, LOCATION", new Font(Font.FontFamily.TIMES_ROMAN, 15,Font.BOLD));
                Paragraph tell = new Paragraph("PHONE: 073293874", new Font(Font.FontFamily.TIMES_ROMAN, 15,Font.BOLD));
                Paragraph reportType = new Paragraph("Report Form", new Font(Font.FontFamily.TIMES_ROMAN, 10,Font.BOLD));
                schoolName.setAlignment(Element.ALIGN_CENTER);
                address.setAlignment(Element.ALIGN_CENTER);
                tell.setAlignment(Element.ALIGN_CENTER);
                reportType.setAlignment(Element.ALIGN_CENTER);
                document.add(schoolName);
                document.add(address);
                document.add(tell);
                document.add(reportType);

                document.add((new Paragraph("ADM: "+set.getString(2)+"  "+"NAME: "+set.getString(3)+"   "+set.getString(4)+" "+set.getString(5)+"  "+"KCPE:"+set.getString(6)+"  "+"CLASS:FORM 3"+"  "+"TERM:TERM 2",new Font(Font.FontFamily.TIMES_ROMAN, 9,Font.BOLD))));
                document.add((new Paragraph("YEAR:"+now.get(Calendar.YEAR)+" "+"POS:"+String.valueOf(POS+1)+" "+"OUT OF "+ALL,new Font(Font.FontFamily.TIMES_ROMAN, 9,Font.BOLD))));
                document.add((new Paragraph(" ")));

                PdfPTable table = new PdfPTable(7);
                table.setWidthPercentage(105);
                table.setSpacingBefore(0f);
                table.setSpacingAfter(0f);

                float[] colWidth = {1.1f,0.5f,0.5f,0.5f,0.7f,2f,1f};
                table.setWidths(colWidth);
                PdfPCell c1 = new PdfPCell(new Paragraph("SUBJECTS",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell c2 = new PdfPCell(new Paragraph("EX1",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell c3 = new PdfPCell(new Paragraph("EX2",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell c4 = new PdfPCell(new Paragraph("EX3",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell c5 = new PdfPCell(new Paragraph("AVG",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell c6 = new PdfPCell(new Paragraph("COMMENTS",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell c7 = new PdfPCell(new Paragraph("TEACHER",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                table.addCell(c1);
                table.addCell(c2);
                table.addCell(c3);
                table.addCell(c4);
                table.addCell(c5);
                table.addCell(c6);
                table.addCell(c7);

                //set eng results
                String g,com=null;
                PdfPCell engD1 = new PdfPCell(new Paragraph("English"));
                PdfPCell engD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell engD3 = new PdfPCell(new Paragraph(setE2.getString(8)+" "+setE2.getString(9)));
                PdfPCell engD4 = new PdfPCell(new Paragraph(" "));

                int avgE= Integer.parseInt(setE2.getString(8));
                if (avgE >= Integer.parseInt(setEngGrade.getString(4))) {com = setComments.getString(2); } else if (avgE >= Integer.parseInt(setEngGrade.getString(5))) { com = setComments.getString(3); }else if (avgE >=Integer.parseInt(setEngGrade.getString(6))){ com = setComments.getString(4);}else if (avgE >=Integer.parseInt(setEngGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgE >=Integer.parseInt(setEngGrade.getString(8))){  com = setComments.getString(6); }else if (avgE >=Integer.parseInt(setEngGrade.getString(9))){ com = setComments.getString(7); }else if (avgE >=Integer.parseInt(setEngGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgE >=Integer.parseInt(setEngGrade.getString(11))){ com = setComments.getString(9);}else if (avgE >=Integer.parseInt(setEngGrade.getString(12))){ com = setComments.getString(10);}else if (avgE >=Integer.parseInt(setEngGrade.getString(13))){ com = setComments.getString(11);}else if (avgE >=Integer.parseInt(setEngGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }
                PdfPCell engD5 = new PdfPCell(new Paragraph(setE2.getString(8)+" "+setE2.getString(9)));
                PdfPCell engD6 = new PdfPCell(new Paragraph(com));
                PdfPCell engD7 = new PdfPCell(new Paragraph(setEngTeacher.getString(6)));
                table.addCell(engD1);
                table.addCell(engD2);
                table.addCell(engD3);
                table.addCell(engD4);
                table.addCell(engD5);
                table.addCell(engD6);
                table.addCell(engD7);

                //set kis results
                PdfPCell kisD1 = new PdfPCell(new Paragraph("Kiswahili"));
                PdfPCell kisD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell kisD3 = new PdfPCell(new Paragraph(setE2.getString(11)+" "+setE2.getString(12)));
                PdfPCell kisD4 = new PdfPCell(new Paragraph(" "));

                int avgKis= Integer.parseInt(setE2.getString(11));
                if (avgKis >= Integer.parseInt(setKisGrade.getString(4))) {com = setComments.getString(2); } else if (avgKis >= Integer.parseInt(setKisGrade.getString(5))) { com = setComments.getString(3); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(6))){ com = setComments.getString(4);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(8))){  com = setComments.getString(6); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(9))){ com = setComments.getString(7); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgKis >=Integer.parseInt(setKisGrade.getString(11))){ com = setComments.getString(9);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(12))){ com = setComments.getString(10);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(13))){ com = setComments.getString(11);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }
                PdfPCell kisD5 = new PdfPCell(new Paragraph(setE2.getString(11)+" "+setE2.getString(12)));
                PdfPCell kisD6 = new PdfPCell(new Paragraph(com));
                PdfPCell kisD7 = new PdfPCell(new Paragraph(setKisTeacher.getString(6)));
                table.addCell(kisD1);
                table.addCell(kisD2);
                table.addCell(kisD3);
                table.addCell(kisD4);
                table.addCell(kisD5);
                table.addCell(kisD6);
                table.addCell(kisD7);

                //set mat results

                PdfPCell matD1 = new PdfPCell(new Paragraph("Mathematics"));
                PdfPCell matD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell matD3 = new PdfPCell(new Paragraph(setE2.getString(14)+" "+setE2.getString(15)));
                PdfPCell matD4 = new PdfPCell(new Paragraph(" "));

                int avgMat = Integer.parseInt(setE2.getString(14));
                if (avgMat >= Integer.parseInt(setMatGrade.getString(4))) {com = setComments.getString(2); } else if (avgMat >= Integer.parseInt(setMatGrade.getString(5))) { com = setComments.getString(3); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(6))){ com = setComments.getString(4);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(8))){  com = setComments.getString(6); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(9))){ com = setComments.getString(7); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgMat >=Integer.parseInt(setMatGrade.getString(11))){ com = setComments.getString(9);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(12))){ com = setComments.getString(10);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(13))){ com = setComments.getString(11);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell matD5 = new PdfPCell(new Paragraph(setE2.getString(14)+" "+setE2.getString(15)));
                PdfPCell matD6 = new PdfPCell(new Paragraph(com));
                PdfPCell matD7 = new PdfPCell(new Paragraph(setMatTeacher.getString(6)));
                table.addCell(matD1);
                table.addCell(matD2);
                table.addCell(matD3);
                table.addCell(matD4);
                table.addCell(matD5);
                table.addCell(matD6);
                table.addCell(matD7);

                //set Chemistry results
                PdfPCell chemD1 = new PdfPCell(new Paragraph("Chemistry"));
                PdfPCell chemD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell chemD3 = new PdfPCell(new Paragraph(setE2.getString(20)+" "+setE2.getString(21)));
                PdfPCell chemD4 = new PdfPCell(new Paragraph(" "));

                int avgChem = Integer.parseInt(setE2.getString(20));
                if (avgChem >= Integer.parseInt(setChemGrade.getString(4))) {com = setComments.getString(2); } else if (avgChem >= Integer.parseInt(setChemGrade.getString(5))) { com = setComments.getString(3); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(6))){ com = setComments.getString(4);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(8))){  com = setComments.getString(6); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(9))){ com = setComments.getString(7); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgChem >=Integer.parseInt(setChemGrade.getString(11))){ com = setComments.getString(9);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(12))){ com = setComments.getString(10);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(13))){ com = setComments.getString(11);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell chemD5 = new PdfPCell(new Paragraph(setE2.getString(20)+" "+setE2.getString(21)));
                PdfPCell chemD6 = new PdfPCell(new Paragraph(com));
                PdfPCell chemD7 = new PdfPCell(new Paragraph(setChemTeacher.getString(6)));
                table.addCell(chemD1);
                table.addCell(chemD2);
                table.addCell(chemD3);
                table.addCell(chemD4);
                table.addCell(chemD5);
                table.addCell(chemD6);
                table.addCell(chemD7);

                //set Physics Results
                PdfPCell phyD1 = new PdfPCell(new Paragraph("Physics"));
                PdfPCell phyD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell phyD3 = new PdfPCell(new Paragraph(setE2.getString(23)+" "+setE2.getString(24)));
                PdfPCell phyD4 = new PdfPCell(new Paragraph(" "));

                int avgPhy = Integer.parseInt(setE2.getString(23));
                if (avgPhy >= Integer.parseInt(setPhyGrade.getString(4))) {com = setComments.getString(2); } else if (avgPhy >= Integer.parseInt(setPhyGrade.getString(5))) { com = setComments.getString(3); }else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(6))){ com = setComments.getString(4);}else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(8))){  com = setComments.getString(6); }else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(9))){ com = setComments.getString(7); }else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(11))){ com = setComments.getString(9);}else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(12))){ com = setComments.getString(10);}else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(13))){ com = setComments.getString(11);}else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell phyD5 = new PdfPCell(new Paragraph(setE2.getString(23)+" "+setE2.getString(24)));
                PdfPCell phyD6 = new PdfPCell(new Paragraph(com));
                PdfPCell phyD7 = new PdfPCell(new Paragraph(setPhyTeacher.getString(6)));
                table.addCell(phyD1);
                table.addCell(phyD2);
                table.addCell(phyD3);
                table.addCell(phyD4);
                table.addCell(phyD5);
                table.addCell(phyD6);
                table.addCell(phyD7);


                //set Cre results
                PdfPCell creD1 = new PdfPCell(new Paragraph("Cre"));
                PdfPCell creD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell creD3 = new PdfPCell(new Paragraph(setE2.getString(32)+" "+setE2.getString(33)));
                PdfPCell creD4 = new PdfPCell(new Paragraph(" "));

                int avgCre = Integer.parseInt(setE2.getString(32));
                if (avgCre >= Integer.parseInt(setCreGrade.getString(4))) {com = setComments.getString(2); } else if (avgCre >= Integer.parseInt(setCreGrade.getString(5))) { com = setComments.getString(3); }else if (avgCre >=Integer.parseInt(setCreGrade.getString(6))){ com = setComments.getString(4);}else if (avgCre >=Integer.parseInt(setCreGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgCre >=Integer.parseInt(setCreGrade.getString(8))){  com = setComments.getString(6); }else if (avgCre >=Integer.parseInt(setCreGrade.getString(9))){ com = setComments.getString(7); }else if (avgCre >=Integer.parseInt(setCreGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgCre >=Integer.parseInt(setCreGrade.getString(11))){ com = setComments.getString(9);}else if (avgCre >=Integer.parseInt(setCreGrade.getString(12))){ com = setComments.getString(10);}else if (avgCre >=Integer.parseInt(setCreGrade.getString(13))){ com = setComments.getString(11);}else if (avgCre >=Integer.parseInt(setCreGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell creD5 = new PdfPCell(new Paragraph(setE2.getString(32)+" "+setE2.getString(33)));
                PdfPCell creD6 = new PdfPCell(new Paragraph(com));
                PdfPCell creD7 = new PdfPCell(new Paragraph(setCreTeacher.getString(6)));
                table.addCell(creD1);
                table.addCell(creD2);
                table.addCell(creD3);
                table.addCell(creD4);
                table.addCell(creD5);
                table.addCell(creD6);
                table.addCell(creD7);

                //set Business results
                PdfPCell busD1 = new PdfPCell(new Paragraph("Business"));
                PdfPCell busD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell busD3 = new PdfPCell(new Paragraph(setE2.getString(35)+" "+setE2.getString(36)));
                PdfPCell busD4 = new PdfPCell(new Paragraph(" "));

                int avgBus = Integer.parseInt(setE2.getString(35));
                if (avgBus >= Integer.parseInt(setBusGrade.getString(4))) {com = setComments.getString(2); } else if (avgBus >= Integer.parseInt(setBusGrade.getString(5))) { com = setComments.getString(3); }else if (avgBus >=Integer.parseInt(setBusGrade.getString(6))){ com = setComments.getString(4);}else if (avgBus >=Integer.parseInt(setBusGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgBus >=Integer.parseInt(setBusGrade.getString(8))){  com = setComments.getString(6); }else if (avgBus >=Integer.parseInt(setBusGrade.getString(9))){ com = setComments.getString(7); }else if (avgBus >=Integer.parseInt(setBusGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgBus >=Integer.parseInt(setBusGrade.getString(11))){ com = setComments.getString(9);}else if (avgBus >=Integer.parseInt(setBusGrade.getString(12))){ com = setComments.getString(10);}else if (avgBus >=Integer.parseInt(setBusGrade.getString(13))){ com = setComments.getString(11);}else if (avgBus >=Integer.parseInt(setBusGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell busD5 = new PdfPCell(new Paragraph(setE2.getString(35)+" "+setE2.getString(36)));
                PdfPCell busD6 = new PdfPCell(new Paragraph(com));
                PdfPCell busD7 = new PdfPCell(new Paragraph(setBusTeacher.getString(6)));
                table.addCell(busD1);
                table.addCell(busD2);
                table.addCell(busD3);
                table.addCell(busD4);
                table.addCell(busD5);
                table.addCell(busD6);
                table.addCell(busD7);

                //set total results

                int totalE2 = Integer.parseInt(setE2.getString(41));



                PdfPCell totalD1 = new PdfPCell(new Paragraph("Total"));
                PdfPCell totalD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell totalD3 = new PdfPCell(new Paragraph(String.valueOf(totalE2)));
                PdfPCell totalD4 = new PdfPCell(new Paragraph(" "));
                PdfPCell totalD5 = new PdfPCell(new Paragraph(" "));
                PdfPCell totalD6 = new PdfPCell(new Paragraph(""));
                PdfPCell totalD7 = new PdfPCell(new Paragraph(""));
                table.addCell(totalD1);
                table.addCell(totalD2);
                table.addCell(totalD3);
                table.addCell(totalD4);
                table.addCell(totalD5);
                table.addCell(totalD6);
                table.addCell(totalD7);

                //set average results

                //int add2AvgEx1 = (Math.addExact(totalEx1Mat,addAvgEx1))/3;

                int addAvgEx2 = Math.round(totalE2/7);
                //int add2AvgEx2 = (Math.addExact(totalEx2Mat,addAvgEx2))/3;


                //int add2AvgEx3 = (Math.addExact(totalEx3Mat,addAvgEx3))/3;


                PdfPCell avgD1 = new PdfPCell(new Paragraph("Average"));
                PdfPCell avgD2 = new PdfPCell(new Paragraph(" "));
                if (addAvgEx2 >= Integer.parseInt(setTotal.getString(4))) {g = "A"; } else if (addAvgEx2 >= Integer.parseInt(setTotal.getString(5))) { g = "A-"; }else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(6))){ g = "B+";}else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(7))){
                    g = "B"; }else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(8))){  g = "B-"; }else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(9))){ g = "C+"; }else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(10))){ g = "C";
                }else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(11))){ g = "C-";}else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(12))){ g = "D+";}else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(13))){ g = "D";}else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(14))){
                    g = "D-";}else {g="E"; }
                PdfPCell avgD3 = new PdfPCell(new Paragraph(String.valueOf(addAvgEx2)+" "+g));


                PdfPCell avgD4 = new PdfPCell(new Paragraph(" "));

                //float avgAvgTotal = (addAvgEx1+addAvgEx2+addAvgEx3)/3;
                int avgAvgTotal=Integer.parseInt(setE2.getString(41))/7;

                if (avgAvgTotal >= Integer.parseInt(setTotal.getString(4))) {g = "A"; } else if (avgAvgTotal >= Integer.parseInt(setTotal.getString(5))) { g = "A-"; }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(6))){ g = "B+";}else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(7))){
                    g = "B"; }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(8))){  g = "B-"; }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(9))){ g = "C+"; }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(10))){ g = "C";
                }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(11))){ g = "C-";}else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(12))){ g = "D+";}else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(13))){ g = "D";}else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(14))){
                    g = "D-";}else {g="E"; }

                PdfPCell avgD5 = new PdfPCell(new Paragraph(String.valueOf(Math.round(avgAvgTotal))+" "+g));
                PdfPCell avgD6 = new PdfPCell(new Paragraph(""));
                PdfPCell avgD7 = new PdfPCell(new Paragraph(""));
                table.addCell(avgD1);
                table.addCell(avgD2);
                table.addCell(avgD3);
                table.addCell(avgD4);
                table.addCell(avgD5);
                table.addCell(avgD6);
                table.addCell(avgD7);

                document.add(table);

                Paragraph labelSummary = new Paragraph("PERFORMANCE TREND",new Font(Font.FontFamily.TIMES_ROMAN, 8,Font.BOLD));
                labelSummary.setSpacingBefore(0);
                labelSummary.setSpacingAfter(5);
                labelSummary.setAlignment(Element.ALIGN_CENTER);
                document.add(labelSummary);

                PdfPTable tableLastSummary = new PdfPTable(8);
                tableLastSummary.setWidthPercentage(105);
                tableLastSummary.setSpacingBefore(0f);
                tableLastSummary.setSpacingAfter(0f);

                float[] colWidthSummary = {0.5f,0.5f,0.5f,0.5f,0.5f,0.5f,0.5f,0.5f};
                tableLastSummary.setWidths(colWidthSummary);
                PdfPCell cS1 = new PdfPCell(new Paragraph("FORM 1",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell cS2 = new PdfPCell(new Paragraph(" ",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell cS3 = new PdfPCell(new Paragraph("FORM 2",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell cS4 = new PdfPCell(new Paragraph(" ",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell cS5 = new PdfPCell(new Paragraph("FORM 3",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell cS6 = new PdfPCell(new Paragraph(" ",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell cS7 = new PdfPCell(new Paragraph("FORM 4",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell cS8 = new PdfPCell(new Paragraph(" ",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                tableLastSummary.addCell(cS1);
                tableLastSummary.addCell(cS2);
                tableLastSummary.addCell(cS3);
                tableLastSummary.addCell(cS4);
                tableLastSummary.addCell(cS5);
                tableLastSummary.addCell(cS6);
                tableLastSummary.addCell(cS7);
                tableLastSummary.addCell(cS8);

                PdfPCell f1t1 = new PdfPCell(new Paragraph("F1T1"));
                PdfPCell f1t1m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF1T1E2.getString(30)))/11)+" "+setF1T1E2.getString(31)));
                PdfPCell f2t1 = new PdfPCell(new Paragraph("F2T1"));
                PdfPCell f2t1m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF2T1E2.getString(30)))/11)+" "+setF2T1E2.getString(31)));
                PdfPCell f3t1 = new PdfPCell(new Paragraph("F3T1"));
                PdfPCell f3t1m = new PdfPCell(new Paragraph(String.valueOf(Integer.parseInt(setF3T1E2.getString(41))/11)+" "+setF3T1E2.getString(43)+" "+setF3T1E2.getString(42)));
                PdfPCell f4t1 = new PdfPCell(new Paragraph("F4T1"));
                PdfPCell f4t1m = new PdfPCell(new Paragraph(" "));
                tableLastSummary.addCell(f1t1);
                tableLastSummary.addCell(f1t1m);
                tableLastSummary.addCell(f2t1);
                tableLastSummary.addCell(f2t1m);
                tableLastSummary.addCell(f3t1);
                tableLastSummary.addCell(f3t1m);
                tableLastSummary.addCell(f4t1);
                tableLastSummary.addCell(f4t1m);

                PdfPCell f1t2 = new PdfPCell(new Paragraph("F1T2"));
                PdfPCell f1t2m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF1T2E2.getString(30)))/11)+" "+setF1T2E2.getString(31)));
                PdfPCell f2t2 = new PdfPCell(new Paragraph("F2T2"));
                PdfPCell f2t2m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF2T2E2.getString(30)))/11)+" "+setF2T2E2.getString(31)));
                PdfPCell f3t2 = new PdfPCell(new Paragraph("F3T2"));
                PdfPCell f3t2m = new PdfPCell(new Paragraph(String.valueOf(avgAvgTotal)+" "+setE2.getString(42)+" "+setE2.getString(43)));
                PdfPCell f4t2 = new PdfPCell(new Paragraph("F4T2"));
                PdfPCell f4t2m = new PdfPCell(new Paragraph(" "));
                tableLastSummary.addCell(f1t2);
                tableLastSummary.addCell(f1t2m);
                tableLastSummary.addCell(f2t2);
                tableLastSummary.addCell(f2t2m);
                tableLastSummary.addCell(f3t2);
                tableLastSummary.addCell(f3t2m);
                tableLastSummary.addCell(f4t2);
                tableLastSummary.addCell(f4t2m);

                PdfPCell f1t3 = new PdfPCell(new Paragraph("F1T3"));
                PdfPCell f1t3m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF1T3E2.getString(30)))/11)+" "+setF1T3E2.getString(31)));
                PdfPCell f2t3 = new PdfPCell(new Paragraph("F2T3"));
                PdfPCell f2t3m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF2T3E2.getString(30)))/11)+" "+setF2T3E2.getString(31)));
                PdfPCell f3t3 = new PdfPCell(new Paragraph("F3T3"));
                PdfPCell f3t3m = new PdfPCell(new Paragraph(" "));
                PdfPCell f4t3 = new PdfPCell(new Paragraph("F4T3"));
                PdfPCell f4t3m = new PdfPCell(new Paragraph(" "));
                tableLastSummary.addCell(f1t3);
                tableLastSummary.addCell(f1t3m);
                tableLastSummary.addCell(f2t3);
                tableLastSummary.addCell(f2t3m);
                tableLastSummary.addCell(f3t3);
                tableLastSummary.addCell(f3t3m);
                tableLastSummary.addCell(f4t3);
                tableLastSummary.addCell(f4t3m);

                document.add(tableLastSummary);
            /*
            * logo
            * */
                Image img = Image.getInstance(cname+"\\HS Results\\Web-Development.png");
                img.scaleAbsolute(100,50);
                img.setAbsolutePosition(30,750);
                document.add(img);

            /*
            * chart
            * */
                DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
                JFreeChart chart = ChartFactory.createBarChart(
                        "", "", "Marks",
                        dataSet, PlotOrientation.VERTICAL, false, false, false);
                int width=500; /* Width of our chart */
                int height=150; /* Height of our chart */
/* Get instance of CategoryPlot */
                CategoryPlot plot = chart.getCategoryPlot();
                BarRenderer renderer = (BarRenderer) plot.getRenderer();
                renderer.setSeriesPaint(0, Color.black);
                dataSet.setValue((Integer.parseInt(setF1T1E2.getString(30))/11)/7, "Marks", "F1T1");
                dataSet.setValue((Integer.parseInt(setF1T2E2.getString(30))/11)/7, "Marks", "F1T2");
                dataSet.setValue((Integer.parseInt(setF1T3E2.getString(30))/11)/7, "Marks", "F1T3");
                dataSet.setValue((Integer.parseInt(setF2T1E2.getString(30))/11)/7, "Marks", "F2T1");
                dataSet.setValue((Integer.parseInt(setF2T2E2.getString(30))/11)/7, "Marks", "F2T2");
                dataSet.setValue((Integer.parseInt(setF2T3E2.getString(30))/11)/7, "Marks", "F2T3");
                dataSet.setValue(Float.parseFloat(setF3T1E2.getString(43)), "Marks", "F3T1");
                dataSet.setValue(Float.parseFloat(setE2.getString(43)), "Marks", "F3T2");
                dataSet.setValue(0, "Marks", "F3T3");
                dataSet.setValue(0, "Marks", "F4T1");
                dataSet.setValue(0, "Marks", "F4T2");
                dataSet.setValue(0, "Marks", "F4T3");
                PdfContentByte contentByte = writer.getDirectContent();
                PdfTemplate template = contentByte.createTemplate(width, height);
                Graphics2D graphics2d = template.createGraphics(width, height,new DefaultFontMapper());
                Rectangle2D rectangle2d = new Rectangle2D.Double(0, 0, width, height);
                chart.draw(graphics2d, rectangle2d);
                graphics2d.dispose();
                contentByte.addTemplate(template, 30, 275);

                Paragraph classTeacherComments = new Paragraph("Class teacher comments: _________________________________________________________");
                Paragraph classTeacherComments1 = new Paragraph("______________________________________________________________________________");
                Paragraph principalComments =new Paragraph("Principal comments: _____________________________________________________________");
                Paragraph principalComments1 =new Paragraph("______________________________________________________________________________");

                classTeacherComments.setSpacingBefore(170);
                document.add(classTeacherComments);
                document.add(classTeacherComments1);
                document.add(principalComments);
                document.add(principalComments1);
                document.close();
            writer.close();
            infoBox("Document containing exam2 results for " + NAME + " has been created open it for printing.","Done",null);
            Desktop.getDesktop().open(new File(cname+"\\HS Results\\"+NAME+".pdf"));


            }catch (Exception e){
                e.printStackTrace();
                infoBoxError("An error occurred " + e,"Error",null);
            }}else {
            infoBoxError("You are not allowed to print","Error",null);
        }
    }

    private void printPhyHisAgri(String ADM,int POS, String ALL) {
        if(printPassword.toString().equals("vic")) {
            String sqlDetails="SELECT * FROM tbl_students WHERE adm=?";
            String sqlComm = "SELECT * FROM tbl_comments";
            String sqlTotal ="SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='TOTAL'";

            String sqlEx2 = "SELECT * FROM tbl_f3_t2_ex2 WHERE adm=? ";
            String sqlF1T1Ex2 = "SELECT * FROM tbl_f1_t1_ex2 WHERE adm=?";
            String sqlF1T2Ex2 = "SELECT * FROM tbl_f1_t2_ex2 WHERE adm=?";
            String sqlF1T3Ex2 = "SELECT * FROM tbl_f1_t3_ex2 WHERE adm=?";
            String sqlF2T1Ex2 = "SELECT * FROM tbl_f2_t1_ex2 WHERE adm=?";
            String sqlF2T2Ex2 = "SELECT * FROM tbl_f2_t2_ex2 WHERE adm=?";
            String sqlF2T3Ex2 = "SELECT * FROM tbl_f2_t3_ex2 WHERE adm=?";
            String sqlF3T1Ex2 = "SELECT * FROM tbl_f3_t1_ex2 WHERE adm=?";


            String sqlEngTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='English'";
            String sqlKisTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='Kiswahili'";
            String sqlMatTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='Mathematics'";
            String sqlChemTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='Chemistry'";
            String sqlBioTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='Biology'";
            String sqlPhyTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='Physics'";
            String sqlHisTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='History'";
            String sqlGeoTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='Geography'";
            String sqlCreTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='CRE'";
            String sqlBusTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='Business'";
            String sqlAgriTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='Agriculture'";

            String sqlEngGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='ENGLISH'";
            String sqlKisGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='KISWAHILI'";
            String sqlMatGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='MATHEMATICS'";
            String sqlChemGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='CHEMISTRY'";
            String sqlBioGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='BIOLOGY'";
            String sqlPhyGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='PHYSICS'";
            String sqlHisGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='HISTORY'";
            String sqlGeoGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='GEOGRAPHY'";
            String sqlCreGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='CRE'";
            String sqlBusGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='BUSINESS'";
            String sqlAgriGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='AGRICULTURE'";

            try{
                Connection connection = Database.DBConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sqlDetails);

                PreparedStatement statementE2 = connection.prepareStatement(sqlEx2);
                PreparedStatement statementF1T1E2 = connection.prepareStatement(sqlF1T1Ex2);
                PreparedStatement statementF1T2E2 = connection.prepareStatement(sqlF1T2Ex2);
                PreparedStatement statementF1T3E2 = connection.prepareStatement(sqlF1T3Ex2);
                PreparedStatement statementF2T1E2 = connection.prepareStatement(sqlF2T1Ex2);
                PreparedStatement statementF2T2E2 = connection.prepareStatement(sqlF2T2Ex2);
                PreparedStatement statementF2T3E2 = connection.prepareStatement(sqlF2T3Ex2);
                PreparedStatement statementF3T1E2 = connection.prepareStatement(sqlF3T1Ex2);



                statement.setString(1,ADM);

                statementE2.setString(1,ADM);
                statementF1T1E2.setString(1,ADM);
                statementF1T2E2.setString(1,ADM);
                statementF1T3E2.setString(1,ADM);
                statementF2T1E2.setString(1,ADM);
                statementF2T2E2.setString(1,ADM);
                statementF2T3E2.setString(1,ADM);
                statementF3T1E2.setString(1,ADM);


                ResultSet set = statement.executeQuery();

                ResultSet setE2 = statementE2.executeQuery();
                ResultSet setF1T1E2 = statementF1T1E2.executeQuery();
                ResultSet setF1T2E2 = statementF1T2E2.executeQuery();
                ResultSet setF1T3E2 = statementF1T3E2.executeQuery();
                ResultSet setF2T1E2 = statementF2T1E2.executeQuery();
                ResultSet setF2T2E2 = statementF2T2E2.executeQuery();
                ResultSet setF2T3E2 = statementF2T3E2.executeQuery();
                ResultSet setF3T1E2 = statementF3T1E2.executeQuery();


                ResultSet setEngTeacher = connection.createStatement().executeQuery(sqlEngTeacher);
                ResultSet setKisTeacher = connection.createStatement().executeQuery(sqlKisTeacher);
                ResultSet setMatTeacher = connection.createStatement().executeQuery(sqlMatTeacher);
                ResultSet setChemTeacher = connection.createStatement().executeQuery(sqlChemTeacher);
                ResultSet setBioTeacher = connection.createStatement().executeQuery(sqlBioTeacher);
                ResultSet setPhyTeacher = connection.createStatement().executeQuery(sqlPhyTeacher);
                ResultSet setHisTeacher = connection.createStatement().executeQuery(sqlHisTeacher);
                ResultSet setGeoTeacher = connection.createStatement().executeQuery(sqlGeoTeacher);
                ResultSet setCreTeacher = connection.createStatement().executeQuery(sqlCreTeacher);
                ResultSet setBusTeacher = connection.createStatement().executeQuery(sqlBusTeacher);
                ResultSet setAgriTeacher = connection.createStatement().executeQuery(sqlAgriTeacher);

                ResultSet setEngGrade = connection.createStatement().executeQuery(sqlEngGrade);
                ResultSet setKisGrade = connection.createStatement().executeQuery(sqlKisGrade);
                ResultSet setMatGrade = connection.createStatement().executeQuery(sqlMatGrade);
                ResultSet setChemGrade = connection.createStatement().executeQuery(sqlChemGrade);
                ResultSet setBioGrade = connection.createStatement().executeQuery(sqlBioGrade);
                ResultSet setPhyGrade = connection.createStatement().executeQuery(sqlPhyGrade);
                ResultSet setHisGrade = connection.createStatement().executeQuery(sqlHisGrade);
                ResultSet setGeoGrade = connection.createStatement().executeQuery(sqlGeoGrade);
                ResultSet setCreGrade = connection.createStatement().executeQuery(sqlCreGrade);
                ResultSet setBusGrade = connection.createStatement().executeQuery(sqlBusGrade);
                ResultSet setAgriGrade = connection.createStatement().executeQuery(sqlAgriGrade);

                ResultSet setComments = connection.createStatement().executeQuery(sqlComm);
                ResultSet setTotal = connection.createStatement().executeQuery(sqlTotal);

                String names = set.getString(3)+"_"+set.getString(4)+"_"+set.getString(5);

                Document document = new Document(PageSize.A4);
            PdfWriter writer = PdfWriter.getInstance(document,new FileOutputStream(NAME+".pdf"));
            document.open();

                Paragraph schoolName = new Paragraph("SCHOOL NAME", new Font(Font.FontFamily.TIMES_ROMAN, 15,Font.BOLD));
                Paragraph address = new Paragraph("P.O BOX 22332, LOCATION", new Font(Font.FontFamily.TIMES_ROMAN, 15,Font.BOLD));
                Paragraph tell = new Paragraph("PHONE: 073293874", new Font(Font.FontFamily.TIMES_ROMAN, 15,Font.BOLD));
                Paragraph reportType = new Paragraph("Report Form", new Font(Font.FontFamily.TIMES_ROMAN, 10,Font.BOLD));
                schoolName.setAlignment(Element.ALIGN_CENTER);
                address.setAlignment(Element.ALIGN_CENTER);
                tell.setAlignment(Element.ALIGN_CENTER);
                reportType.setAlignment(Element.ALIGN_CENTER);
                document.add(schoolName);
                document.add(address);
                document.add(tell);
                document.add(reportType);

                document.add((new Paragraph("ADM: "+set.getString(2)+"  "+"NAME: "+set.getString(3)+"   "+set.getString(4)+" "+set.getString(5)+"  "+"KCPE:"+set.getString(6)+"  "+"CLASS:FORM 3"+"  "+"TERM:TERM 2",new Font(Font.FontFamily.TIMES_ROMAN, 9,Font.BOLD))));
                document.add((new Paragraph("YEAR:"+now.get(Calendar.YEAR)+" "+"POS:"+String.valueOf(POS+1)+" "+"OUT OF "+ALL,new Font(Font.FontFamily.TIMES_ROMAN, 9,Font.BOLD))));
                document.add((new Paragraph(" ")));

                PdfPTable table = new PdfPTable(7);
                table.setWidthPercentage(105);
                table.setSpacingBefore(0f);
                table.setSpacingAfter(0f);

                float[] colWidth = {1.1f,0.5f,0.5f,0.5f,0.7f,2f,1f};
                table.setWidths(colWidth);
                PdfPCell c1 = new PdfPCell(new Paragraph("SUBJECTS",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell c2 = new PdfPCell(new Paragraph("EX1",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell c3 = new PdfPCell(new Paragraph("EX2",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell c4 = new PdfPCell(new Paragraph("EX3",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell c5 = new PdfPCell(new Paragraph("AVG",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell c6 = new PdfPCell(new Paragraph("COMMENTS",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell c7 = new PdfPCell(new Paragraph("TEACHER",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                table.addCell(c1);
                table.addCell(c2);
                table.addCell(c3);
                table.addCell(c4);
                table.addCell(c5);
                table.addCell(c6);
                table.addCell(c7);

                //set eng results
                String g,com=null;
                PdfPCell engD1 = new PdfPCell(new Paragraph("English"));
                PdfPCell engD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell engD3 = new PdfPCell(new Paragraph(setE2.getString(8)+" "+setE2.getString(9)));
                PdfPCell engD4 = new PdfPCell(new Paragraph(" "));

                int avgE= Integer.parseInt(setE2.getString(8));
                if (avgE >= Integer.parseInt(setEngGrade.getString(4))) {com = setComments.getString(2); } else if (avgE >= Integer.parseInt(setEngGrade.getString(5))) { com = setComments.getString(3); }else if (avgE >=Integer.parseInt(setEngGrade.getString(6))){ com = setComments.getString(4);}else if (avgE >=Integer.parseInt(setEngGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgE >=Integer.parseInt(setEngGrade.getString(8))){  com = setComments.getString(6); }else if (avgE >=Integer.parseInt(setEngGrade.getString(9))){ com = setComments.getString(7); }else if (avgE >=Integer.parseInt(setEngGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgE >=Integer.parseInt(setEngGrade.getString(11))){ com = setComments.getString(9);}else if (avgE >=Integer.parseInt(setEngGrade.getString(12))){ com = setComments.getString(10);}else if (avgE >=Integer.parseInt(setEngGrade.getString(13))){ com = setComments.getString(11);}else if (avgE >=Integer.parseInt(setEngGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }
                PdfPCell engD5 = new PdfPCell(new Paragraph(setE2.getString(8)+" "+setE2.getString(9)));
                PdfPCell engD6 = new PdfPCell(new Paragraph(com));
                PdfPCell engD7 = new PdfPCell(new Paragraph(setEngTeacher.getString(6)));
                table.addCell(engD1);
                table.addCell(engD2);
                table.addCell(engD3);
                table.addCell(engD4);
                table.addCell(engD5);
                table.addCell(engD6);
                table.addCell(engD7);

                //set kis results
                PdfPCell kisD1 = new PdfPCell(new Paragraph("Kiswahili"));
                PdfPCell kisD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell kisD3 = new PdfPCell(new Paragraph(setE2.getString(11)+" "+setE2.getString(12)));
                PdfPCell kisD4 = new PdfPCell(new Paragraph(" "));

                int avgKis= Integer.parseInt(setE2.getString(11));
                if (avgKis >= Integer.parseInt(setKisGrade.getString(4))) {com = setComments.getString(2); } else if (avgKis >= Integer.parseInt(setKisGrade.getString(5))) { com = setComments.getString(3); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(6))){ com = setComments.getString(4);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(8))){  com = setComments.getString(6); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(9))){ com = setComments.getString(7); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgKis >=Integer.parseInt(setKisGrade.getString(11))){ com = setComments.getString(9);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(12))){ com = setComments.getString(10);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(13))){ com = setComments.getString(11);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }
                PdfPCell kisD5 = new PdfPCell(new Paragraph(setE2.getString(11)+" "+setE2.getString(12)));
                PdfPCell kisD6 = new PdfPCell(new Paragraph(com));
                PdfPCell kisD7 = new PdfPCell(new Paragraph(setKisTeacher.getString(6)));
                table.addCell(kisD1);
                table.addCell(kisD2);
                table.addCell(kisD3);
                table.addCell(kisD4);
                table.addCell(kisD5);
                table.addCell(kisD6);
                table.addCell(kisD7);

                //set mat results

                PdfPCell matD1 = new PdfPCell(new Paragraph("Mathematics"));
                PdfPCell matD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell matD3 = new PdfPCell(new Paragraph(setE2.getString(14)+" "+setE2.getString(15)));
                PdfPCell matD4 = new PdfPCell(new Paragraph(" "));

                int avgMat = Integer.parseInt(setE2.getString(14));
                if (avgMat >= Integer.parseInt(setMatGrade.getString(4))) {com = setComments.getString(2); } else if (avgMat >= Integer.parseInt(setMatGrade.getString(5))) { com = setComments.getString(3); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(6))){ com = setComments.getString(4);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(8))){  com = setComments.getString(6); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(9))){ com = setComments.getString(7); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgMat >=Integer.parseInt(setMatGrade.getString(11))){ com = setComments.getString(9);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(12))){ com = setComments.getString(10);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(13))){ com = setComments.getString(11);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell matD5 = new PdfPCell(new Paragraph(setE2.getString(14)+" "+setE2.getString(15)));
                PdfPCell matD6 = new PdfPCell(new Paragraph(com));
                PdfPCell matD7 = new PdfPCell(new Paragraph(setMatTeacher.getString(6)));
                table.addCell(matD1);
                table.addCell(matD2);
                table.addCell(matD3);
                table.addCell(matD4);
                table.addCell(matD5);
                table.addCell(matD6);
                table.addCell(matD7);

                //set Chemistry results
                PdfPCell chemD1 = new PdfPCell(new Paragraph("Chemistry"));
                PdfPCell chemD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell chemD3 = new PdfPCell(new Paragraph(setE2.getString(20)+" "+setE2.getString(21)));
                PdfPCell chemD4 = new PdfPCell(new Paragraph(" "));

                int avgChem = Integer.parseInt(setE2.getString(20));
                if (avgChem >= Integer.parseInt(setChemGrade.getString(4))) {com = setComments.getString(2); } else if (avgChem >= Integer.parseInt(setChemGrade.getString(5))) { com = setComments.getString(3); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(6))){ com = setComments.getString(4);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(8))){  com = setComments.getString(6); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(9))){ com = setComments.getString(7); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgChem >=Integer.parseInt(setChemGrade.getString(11))){ com = setComments.getString(9);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(12))){ com = setComments.getString(10);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(13))){ com = setComments.getString(11);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell chemD5 = new PdfPCell(new Paragraph(setE2.getString(20)+" "+setE2.getString(21)));
                PdfPCell chemD6 = new PdfPCell(new Paragraph(com));
                PdfPCell chemD7 = new PdfPCell(new Paragraph(setChemTeacher.getString(6)));
                table.addCell(chemD1);
                table.addCell(chemD2);
                table.addCell(chemD3);
                table.addCell(chemD4);
                table.addCell(chemD5);
                table.addCell(chemD6);
                table.addCell(chemD7);

                //set Physics Results
                PdfPCell phyD1 = new PdfPCell(new Paragraph("Physics"));
                PdfPCell phyD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell phyD3 = new PdfPCell(new Paragraph(setE2.getString(23)+" "+setE2.getString(24)));
                PdfPCell phyD4 = new PdfPCell(new Paragraph(" "));

                int avgPhy = Integer.parseInt(setE2.getString(23));
                if (avgPhy >= Integer.parseInt(setPhyGrade.getString(4))) {com = setComments.getString(2); } else if (avgPhy >= Integer.parseInt(setPhyGrade.getString(5))) { com = setComments.getString(3); }else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(6))){ com = setComments.getString(4);}else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(8))){  com = setComments.getString(6); }else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(9))){ com = setComments.getString(7); }else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(11))){ com = setComments.getString(9);}else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(12))){ com = setComments.getString(10);}else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(13))){ com = setComments.getString(11);}else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell phyD5 = new PdfPCell(new Paragraph(setE2.getString(23)+" "+setE2.getString(24)));
                PdfPCell phyD6 = new PdfPCell(new Paragraph(com));
                PdfPCell phyD7 = new PdfPCell(new Paragraph(setPhyTeacher.getString(6)));
                table.addCell(phyD1);
                table.addCell(phyD2);
                table.addCell(phyD3);
                table.addCell(phyD4);
                table.addCell(phyD5);
                table.addCell(phyD6);
                table.addCell(phyD7);

                //set History results
                PdfPCell hisD1 = new PdfPCell(new Paragraph("History"));
                PdfPCell hisD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell hisD3 = new PdfPCell(new Paragraph(setE2.getString(29)+" "+setE2.getString(30)));
                PdfPCell hisD4 = new PdfPCell(new Paragraph(" "));

                int avgHis = Integer.parseInt(setE2.getString(29));
                if (avgHis >= Integer.parseInt(setHisGrade.getString(4))) {com = setComments.getString(2); } else if (avgHis >= Integer.parseInt(setHisGrade.getString(5))) { com = setComments.getString(3); }else if (avgHis >=Integer.parseInt(setHisGrade.getString(6))){ com = setComments.getString(4);}else if (avgHis >=Integer.parseInt(setHisGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgHis >=Integer.parseInt(setHisGrade.getString(8))){  com = setComments.getString(6); }else if (avgHis >=Integer.parseInt(setHisGrade.getString(9))){ com = setComments.getString(7); }else if (avgHis >=Integer.parseInt(setHisGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgHis >=Integer.parseInt(setHisGrade.getString(11))){ com = setComments.getString(9);}else if (avgHis >=Integer.parseInt(setHisGrade.getString(12))){ com = setComments.getString(10);}else if (avgHis >=Integer.parseInt(setHisGrade.getString(13))){ com = setComments.getString(11);}else if (avgHis >=Integer.parseInt(setHisGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell hisD5 = new PdfPCell(new Paragraph(setE2.getString(29)+" "+setE2.getString(30)));
                PdfPCell hisD6 = new PdfPCell(new Paragraph(com));
                PdfPCell hisD7 = new PdfPCell(new Paragraph(setHisTeacher.getString(6)));
                table.addCell(hisD1);
                table.addCell(hisD2);
                table.addCell(hisD3);
                table.addCell(hisD4);
                table.addCell(hisD5);
                table.addCell(hisD6);
                table.addCell(hisD7);

                //set Agriculture results
                PdfPCell agriD1 = new PdfPCell(new Paragraph("Agriculture"));
                PdfPCell agriD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell agriD3 = new PdfPCell(new Paragraph(setE2.getString(38)+" "+setE2.getString(39)));
                PdfPCell agriD4 = new PdfPCell(new Paragraph(" "));

                int avgAgri = Integer.parseInt(setE2.getString(38));
                if (avgAgri >= Integer.parseInt(setAgriGrade.getString(4))) {com = setComments.getString(2); } else if (avgAgri >= Integer.parseInt(setAgriGrade.getString(5))) { com = setComments.getString(3); }else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(6))){ com = setComments.getString(4);}else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(8))){  com = setComments.getString(6); }else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(9))){ com = setComments.getString(7); }else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(11))){ com = setComments.getString(9);}else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(12))){ com = setComments.getString(10);}else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(13))){ com = setComments.getString(11);}else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell agriD5 = new PdfPCell(new Paragraph(setE2.getString(38)+" "+setE2.getString(39)));
                PdfPCell agriD6 = new PdfPCell(new Paragraph(com));
                PdfPCell agriD7 = new PdfPCell(new Paragraph(setAgriTeacher.getString(6)));
                table.addCell(agriD1);
                table.addCell(agriD2);
                table.addCell(agriD3);
                table.addCell(agriD4);
                table.addCell(agriD5);
                table.addCell(agriD6);
                table.addCell(agriD7);

                //set total results

                int totalE2 = Integer.parseInt(setE2.getString(41));



                PdfPCell totalD1 = new PdfPCell(new Paragraph("Total"));
                PdfPCell totalD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell totalD3 = new PdfPCell(new Paragraph(String.valueOf(totalE2)));
                PdfPCell totalD4 = new PdfPCell(new Paragraph(" "));
                PdfPCell totalD5 = new PdfPCell(new Paragraph(" "));
                PdfPCell totalD6 = new PdfPCell(new Paragraph(""));
                PdfPCell totalD7 = new PdfPCell(new Paragraph(""));
                table.addCell(totalD1);
                table.addCell(totalD2);
                table.addCell(totalD3);
                table.addCell(totalD4);
                table.addCell(totalD5);
                table.addCell(totalD6);
                table.addCell(totalD7);

                //set average results

                //int add2AvgEx1 = (Math.addExact(totalEx1Mat,addAvgEx1))/3;

                int addAvgEx2 = Math.round(totalE2/7);
                //int add2AvgEx2 = (Math.addExact(totalEx2Mat,addAvgEx2))/3;


                //int add2AvgEx3 = (Math.addExact(totalEx3Mat,addAvgEx3))/3;


                PdfPCell avgD1 = new PdfPCell(new Paragraph("Average"));
                PdfPCell avgD2 = new PdfPCell(new Paragraph(" "));
                if (addAvgEx2 >= Integer.parseInt(setTotal.getString(4))) {g = "A"; } else if (addAvgEx2 >= Integer.parseInt(setTotal.getString(5))) { g = "A-"; }else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(6))){ g = "B+";}else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(7))){
                    g = "B"; }else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(8))){  g = "B-"; }else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(9))){ g = "C+"; }else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(10))){ g = "C";
                }else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(11))){ g = "C-";}else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(12))){ g = "D+";}else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(13))){ g = "D";}else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(14))){
                    g = "D-";}else {g="E"; }
                PdfPCell avgD3 = new PdfPCell(new Paragraph(String.valueOf(addAvgEx2)+" "+g));


                PdfPCell avgD4 = new PdfPCell(new Paragraph(" "));

                //float avgAvgTotal = (addAvgEx1+addAvgEx2+addAvgEx3)/3;
                int avgAvgTotal=Integer.parseInt(setE2.getString(41))/7;

                if (avgAvgTotal >= Integer.parseInt(setTotal.getString(4))) {g = "A"; } else if (avgAvgTotal >= Integer.parseInt(setTotal.getString(5))) { g = "A-"; }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(6))){ g = "B+";}else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(7))){
                    g = "B"; }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(8))){  g = "B-"; }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(9))){ g = "C+"; }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(10))){ g = "C";
                }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(11))){ g = "C-";}else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(12))){ g = "D+";}else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(13))){ g = "D";}else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(14))){
                    g = "D-";}else {g="E"; }

                PdfPCell avgD5 = new PdfPCell(new Paragraph(String.valueOf(Math.round(avgAvgTotal))+" "+g));
                PdfPCell avgD6 = new PdfPCell(new Paragraph(""));
                PdfPCell avgD7 = new PdfPCell(new Paragraph(""));
                table.addCell(avgD1);
                table.addCell(avgD2);
                table.addCell(avgD3);
                table.addCell(avgD4);
                table.addCell(avgD5);
                table.addCell(avgD6);
                table.addCell(avgD7);

                document.add(table);

                Paragraph labelSummary = new Paragraph("PERFORMANCE TREND",new Font(Font.FontFamily.TIMES_ROMAN, 8,Font.BOLD));
                labelSummary.setSpacingBefore(0);
                labelSummary.setSpacingAfter(5);
                labelSummary.setAlignment(Element.ALIGN_CENTER);
                document.add(labelSummary);

                PdfPTable tableLastSummary = new PdfPTable(8);
                tableLastSummary.setWidthPercentage(105);
                tableLastSummary.setSpacingBefore(0f);
                tableLastSummary.setSpacingAfter(0f);

                float[] colWidthSummary = {0.5f,0.5f,0.5f,0.5f,0.5f,0.5f,0.5f,0.5f};
                tableLastSummary.setWidths(colWidthSummary);
                PdfPCell cS1 = new PdfPCell(new Paragraph("FORM 1",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell cS2 = new PdfPCell(new Paragraph(" ",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell cS3 = new PdfPCell(new Paragraph("FORM 2",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell cS4 = new PdfPCell(new Paragraph(" ",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell cS5 = new PdfPCell(new Paragraph("FORM 3",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell cS6 = new PdfPCell(new Paragraph(" ",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell cS7 = new PdfPCell(new Paragraph("FORM 4",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell cS8 = new PdfPCell(new Paragraph(" ",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                tableLastSummary.addCell(cS1);
                tableLastSummary.addCell(cS2);
                tableLastSummary.addCell(cS3);
                tableLastSummary.addCell(cS4);
                tableLastSummary.addCell(cS5);
                tableLastSummary.addCell(cS6);
                tableLastSummary.addCell(cS7);
                tableLastSummary.addCell(cS8);

                PdfPCell f1t1 = new PdfPCell(new Paragraph("F1T1"));
                PdfPCell f1t1m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF1T1E2.getString(30)))/11)+" "+setF1T1E2.getString(31)));
                PdfPCell f2t1 = new PdfPCell(new Paragraph("F2T1"));
                PdfPCell f2t1m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF2T1E2.getString(30)))/11)+" "+setF2T1E2.getString(31)));
                PdfPCell f3t1 = new PdfPCell(new Paragraph("F3T1"));
                PdfPCell f3t1m = new PdfPCell(new Paragraph(String.valueOf(Integer.parseInt(setF3T1E2.getString(41))/11)+" "+setF3T1E2.getString(43)+" "+setF3T1E2.getString(42)));
                PdfPCell f4t1 = new PdfPCell(new Paragraph("F4T1"));
                PdfPCell f4t1m = new PdfPCell(new Paragraph(" "));
                tableLastSummary.addCell(f1t1);
                tableLastSummary.addCell(f1t1m);
                tableLastSummary.addCell(f2t1);
                tableLastSummary.addCell(f2t1m);
                tableLastSummary.addCell(f3t1);
                tableLastSummary.addCell(f3t1m);
                tableLastSummary.addCell(f4t1);
                tableLastSummary.addCell(f4t1m);

                PdfPCell f1t2 = new PdfPCell(new Paragraph("F1T2"));
                PdfPCell f1t2m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF1T2E2.getString(30)))/11)+" "+setF1T2E2.getString(31)));
                PdfPCell f2t2 = new PdfPCell(new Paragraph("F2T2"));
                PdfPCell f2t2m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF2T2E2.getString(30)))/11)+" "+setF2T2E2.getString(31)));
                PdfPCell f3t2 = new PdfPCell(new Paragraph("F3T2"));
                PdfPCell f3t2m = new PdfPCell(new Paragraph(String.valueOf(avgAvgTotal)+" "+setE2.getString(42)+" "+setE2.getString(43)));
                PdfPCell f4t2 = new PdfPCell(new Paragraph("F4T2"));
                PdfPCell f4t2m = new PdfPCell(new Paragraph(" "));
                tableLastSummary.addCell(f1t2);
                tableLastSummary.addCell(f1t2m);
                tableLastSummary.addCell(f2t2);
                tableLastSummary.addCell(f2t2m);
                tableLastSummary.addCell(f3t2);
                tableLastSummary.addCell(f3t2m);
                tableLastSummary.addCell(f4t2);
                tableLastSummary.addCell(f4t2m);

                PdfPCell f1t3 = new PdfPCell(new Paragraph("F1T3"));
                PdfPCell f1t3m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF1T3E2.getString(30)))/11)+" "+setF1T3E2.getString(31)));
                PdfPCell f2t3 = new PdfPCell(new Paragraph("F2T3"));
                PdfPCell f2t3m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF2T3E2.getString(30)))/11)+" "+setF2T3E2.getString(31)));
                PdfPCell f3t3 = new PdfPCell(new Paragraph("F3T3"));
                PdfPCell f3t3m = new PdfPCell(new Paragraph(" "));
                PdfPCell f4t3 = new PdfPCell(new Paragraph("F4T3"));
                PdfPCell f4t3m = new PdfPCell(new Paragraph(" "));
                tableLastSummary.addCell(f1t3);
                tableLastSummary.addCell(f1t3m);
                tableLastSummary.addCell(f2t3);
                tableLastSummary.addCell(f2t3m);
                tableLastSummary.addCell(f3t3);
                tableLastSummary.addCell(f3t3m);
                tableLastSummary.addCell(f4t3);
                tableLastSummary.addCell(f4t3m);

                document.add(tableLastSummary);
            /*
            * logo
            * */
                Image img = Image.getInstance(cname+"\\HS Results\\Web-Development.png");
                img.scaleAbsolute(100,50);
                img.setAbsolutePosition(30,750);
                document.add(img);

            /*
            * chart
            * */
                DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
                JFreeChart chart = ChartFactory.createBarChart(
                        "", "", "Marks",
                        dataSet, PlotOrientation.VERTICAL, false, false, false);
                int width=500; /* Width of our chart */
                int height=150; /* Height of our chart */
/* Get instance of CategoryPlot */
                CategoryPlot plot = chart.getCategoryPlot();
                BarRenderer renderer = (BarRenderer) plot.getRenderer();
                renderer.setSeriesPaint(0, Color.black);
                dataSet.setValue((Integer.parseInt(setF1T1E2.getString(30))/11)/7, "Marks", "F1T1");
                dataSet.setValue((Integer.parseInt(setF1T2E2.getString(30))/11)/7, "Marks", "F1T2");
                dataSet.setValue((Integer.parseInt(setF1T3E2.getString(30))/11)/7, "Marks", "F1T3");
                dataSet.setValue((Integer.parseInt(setF2T1E2.getString(30))/11)/7, "Marks", "F2T1");
                dataSet.setValue((Integer.parseInt(setF2T2E2.getString(30))/11)/7, "Marks", "F2T2");
                dataSet.setValue((Integer.parseInt(setF2T3E2.getString(30))/11)/7, "Marks", "F2T3");
                dataSet.setValue(Float.parseFloat(setF3T1E2.getString(43)), "Marks", "F3T1");
                dataSet.setValue(Float.parseFloat(setE2.getString(43)), "Marks", "F3T2");
                dataSet.setValue(0, "Marks", "F3T3");
                dataSet.setValue(0, "Marks", "F4T1");
                dataSet.setValue(0, "Marks", "F4T2");
                dataSet.setValue(0, "Marks", "F4T3");
                PdfContentByte contentByte = writer.getDirectContent();
                PdfTemplate template = contentByte.createTemplate(width, height);
                Graphics2D graphics2d = template.createGraphics(width, height,new DefaultFontMapper());
                Rectangle2D rectangle2d = new Rectangle2D.Double(0, 0, width, height);
                chart.draw(graphics2d, rectangle2d);
                graphics2d.dispose();
                contentByte.addTemplate(template, 30, 275);

                Paragraph classTeacherComments = new Paragraph("Class teacher comments: _________________________________________________________");
                Paragraph classTeacherComments1 = new Paragraph("______________________________________________________________________________");
                Paragraph principalComments =new Paragraph("Principal comments: _____________________________________________________________");
                Paragraph principalComments1 =new Paragraph("______________________________________________________________________________");

                classTeacherComments.setSpacingBefore(170);
                document.add(classTeacherComments);
                document.add(classTeacherComments1);
                document.add(principalComments);
                document.add(principalComments1);
                document.close();
            writer.close();
            infoBox("Document containing exam2 results for " + NAME + " has been created open it for printing.","Done",null);
            Desktop.getDesktop().open(new File(cname+"\\HS Results\\"+NAME+".pdf"));


            }catch (Exception e){
                e.printStackTrace();
                infoBoxError("An error occurred " + e,"Error",null);
            }}else {
            infoBoxError("You are not allowed to print","Error",null);
        }
    }

    private void printPhyHisBus(String ADM,int POS, String ALL) {
        if(printPassword.toString().equals("vic")) {
            String sqlDetails="SELECT * FROM tbl_students WHERE adm=?";
            String sqlComm = "SELECT * FROM tbl_comments";
            String sqlTotal ="SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='TOTAL'";

            String sqlEx2 = "SELECT * FROM tbl_f3_t2_ex2 WHERE adm=? ";
            String sqlF1T1Ex2 = "SELECT * FROM tbl_f1_t1_ex2 WHERE adm=?";
            String sqlF1T2Ex2 = "SELECT * FROM tbl_f1_t2_ex2 WHERE adm=?";
            String sqlF1T3Ex2 = "SELECT * FROM tbl_f1_t3_ex2 WHERE adm=?";
            String sqlF2T1Ex2 = "SELECT * FROM tbl_f2_t1_ex2 WHERE adm=?";
            String sqlF2T2Ex2 = "SELECT * FROM tbl_f2_t2_ex2 WHERE adm=?";
            String sqlF2T3Ex2 = "SELECT * FROM tbl_f2_t3_ex2 WHERE adm=?";
            String sqlF3T1Ex2 = "SELECT * FROM tbl_f3_t1_ex2 WHERE adm=?";


            String sqlEngTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='English'";
            String sqlKisTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='Kiswahili'";
            String sqlMatTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='Mathematics'";
            String sqlChemTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='Chemistry'";
            String sqlBioTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='Biology'";
            String sqlPhyTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='Physics'";
            String sqlHisTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='History'";
            String sqlGeoTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='Geography'";
            String sqlCreTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='CRE'";
            String sqlBusTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='Business'";
            String sqlAgriTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='Agriculture'";

            String sqlEngGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='ENGLISH'";
            String sqlKisGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='KISWAHILI'";
            String sqlMatGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='MATHEMATICS'";
            String sqlChemGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='CHEMISTRY'";
            String sqlBioGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='BIOLOGY'";
            String sqlPhyGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='PHYSICS'";
            String sqlHisGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='HISTORY'";
            String sqlGeoGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='GEOGRAPHY'";
            String sqlCreGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='CRE'";
            String sqlBusGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='BUSINESS'";
            String sqlAgriGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='AGRICULTURE'";

            try{
                Connection connection = Database.DBConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sqlDetails);

                PreparedStatement statementE2 = connection.prepareStatement(sqlEx2);
                PreparedStatement statementF1T1E2 = connection.prepareStatement(sqlF1T1Ex2);
                PreparedStatement statementF1T2E2 = connection.prepareStatement(sqlF1T2Ex2);
                PreparedStatement statementF1T3E2 = connection.prepareStatement(sqlF1T3Ex2);
                PreparedStatement statementF2T1E2 = connection.prepareStatement(sqlF2T1Ex2);
                PreparedStatement statementF2T2E2 = connection.prepareStatement(sqlF2T2Ex2);
                PreparedStatement statementF2T3E2 = connection.prepareStatement(sqlF2T3Ex2);
                PreparedStatement statementF3T1E2 = connection.prepareStatement(sqlF3T1Ex2);



                statement.setString(1,ADM);

                statementE2.setString(1,ADM);
                statementF1T1E2.setString(1,ADM);
                statementF1T2E2.setString(1,ADM);
                statementF1T3E2.setString(1,ADM);
                statementF2T1E2.setString(1,ADM);
                statementF2T2E2.setString(1,ADM);
                statementF2T3E2.setString(1,ADM);
                statementF3T1E2.setString(1,ADM);


                ResultSet set = statement.executeQuery();

                ResultSet setE2 = statementE2.executeQuery();
                ResultSet setF1T1E2 = statementF1T1E2.executeQuery();
                ResultSet setF1T2E2 = statementF1T2E2.executeQuery();
                ResultSet setF1T3E2 = statementF1T3E2.executeQuery();
                ResultSet setF2T1E2 = statementF2T1E2.executeQuery();
                ResultSet setF2T2E2 = statementF2T2E2.executeQuery();
                ResultSet setF2T3E2 = statementF2T3E2.executeQuery();
                ResultSet setF3T1E2 = statementF3T1E2.executeQuery();


                ResultSet setEngTeacher = connection.createStatement().executeQuery(sqlEngTeacher);
                ResultSet setKisTeacher = connection.createStatement().executeQuery(sqlKisTeacher);
                ResultSet setMatTeacher = connection.createStatement().executeQuery(sqlMatTeacher);
                ResultSet setChemTeacher = connection.createStatement().executeQuery(sqlChemTeacher);
                ResultSet setBioTeacher = connection.createStatement().executeQuery(sqlBioTeacher);
                ResultSet setPhyTeacher = connection.createStatement().executeQuery(sqlPhyTeacher);
                ResultSet setHisTeacher = connection.createStatement().executeQuery(sqlHisTeacher);
                ResultSet setGeoTeacher = connection.createStatement().executeQuery(sqlGeoTeacher);
                ResultSet setCreTeacher = connection.createStatement().executeQuery(sqlCreTeacher);
                ResultSet setBusTeacher = connection.createStatement().executeQuery(sqlBusTeacher);
                ResultSet setAgriTeacher = connection.createStatement().executeQuery(sqlAgriTeacher);

                ResultSet setEngGrade = connection.createStatement().executeQuery(sqlEngGrade);
                ResultSet setKisGrade = connection.createStatement().executeQuery(sqlKisGrade);
                ResultSet setMatGrade = connection.createStatement().executeQuery(sqlMatGrade);
                ResultSet setChemGrade = connection.createStatement().executeQuery(sqlChemGrade);
                ResultSet setBioGrade = connection.createStatement().executeQuery(sqlBioGrade);
                ResultSet setPhyGrade = connection.createStatement().executeQuery(sqlPhyGrade);
                ResultSet setHisGrade = connection.createStatement().executeQuery(sqlHisGrade);
                ResultSet setGeoGrade = connection.createStatement().executeQuery(sqlGeoGrade);
                ResultSet setCreGrade = connection.createStatement().executeQuery(sqlCreGrade);
                ResultSet setBusGrade = connection.createStatement().executeQuery(sqlBusGrade);
                ResultSet setAgriGrade = connection.createStatement().executeQuery(sqlAgriGrade);

                ResultSet setComments = connection.createStatement().executeQuery(sqlComm);
                ResultSet setTotal = connection.createStatement().executeQuery(sqlTotal);

                String names = set.getString(3)+"_"+set.getString(4)+"_"+set.getString(5);

                Document document = new Document(PageSize.A4);
            PdfWriter writer = PdfWriter.getInstance(document,new FileOutputStream(NAME+".pdf"));
            document.open();

                Paragraph schoolName = new Paragraph("SCHOOL NAME", new Font(Font.FontFamily.TIMES_ROMAN, 15,Font.BOLD));
                Paragraph address = new Paragraph("P.O BOX 22332, LOCATION", new Font(Font.FontFamily.TIMES_ROMAN, 15,Font.BOLD));
                Paragraph tell = new Paragraph("PHONE: 073293874", new Font(Font.FontFamily.TIMES_ROMAN, 15,Font.BOLD));
                Paragraph reportType = new Paragraph("Report Form", new Font(Font.FontFamily.TIMES_ROMAN, 10,Font.BOLD));
                schoolName.setAlignment(Element.ALIGN_CENTER);
                address.setAlignment(Element.ALIGN_CENTER);
                tell.setAlignment(Element.ALIGN_CENTER);
                reportType.setAlignment(Element.ALIGN_CENTER);
                document.add(schoolName);
                document.add(address);
                document.add(tell);
                document.add(reportType);

                document.add((new Paragraph("ADM: "+set.getString(2)+"  "+"NAME: "+set.getString(3)+"   "+set.getString(4)+" "+set.getString(5)+"  "+"KCPE:"+set.getString(6)+"  "+"CLASS:FORM 3"+"  "+"TERM:TERM 2",new Font(Font.FontFamily.TIMES_ROMAN, 9,Font.BOLD))));
                document.add((new Paragraph("YEAR:"+now.get(Calendar.YEAR)+" "+"POS:"+String.valueOf(POS+1)+" "+"OUT OF "+ALL,new Font(Font.FontFamily.TIMES_ROMAN, 9,Font.BOLD))));
                document.add((new Paragraph(" ")));

                PdfPTable table = new PdfPTable(7);
                table.setWidthPercentage(105);
                table.setSpacingBefore(0f);
                table.setSpacingAfter(0f);

                float[] colWidth = {1.1f,0.5f,0.5f,0.5f,0.7f,2f,1f};
                table.setWidths(colWidth);
                PdfPCell c1 = new PdfPCell(new Paragraph("SUBJECTS",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell c2 = new PdfPCell(new Paragraph("EX1",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell c3 = new PdfPCell(new Paragraph("EX2",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell c4 = new PdfPCell(new Paragraph("EX3",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell c5 = new PdfPCell(new Paragraph("AVG",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell c6 = new PdfPCell(new Paragraph("COMMENTS",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell c7 = new PdfPCell(new Paragraph("TEACHER",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                table.addCell(c1);
                table.addCell(c2);
                table.addCell(c3);
                table.addCell(c4);
                table.addCell(c5);
                table.addCell(c6);
                table.addCell(c7);

                //set eng results
                String g,com=null;
                PdfPCell engD1 = new PdfPCell(new Paragraph("English"));
                PdfPCell engD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell engD3 = new PdfPCell(new Paragraph(setE2.getString(8)+" "+setE2.getString(9)));
                PdfPCell engD4 = new PdfPCell(new Paragraph(" "));

                int avgE= Integer.parseInt(setE2.getString(8));
                if (avgE >= Integer.parseInt(setEngGrade.getString(4))) {com = setComments.getString(2); } else if (avgE >= Integer.parseInt(setEngGrade.getString(5))) { com = setComments.getString(3); }else if (avgE >=Integer.parseInt(setEngGrade.getString(6))){ com = setComments.getString(4);}else if (avgE >=Integer.parseInt(setEngGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgE >=Integer.parseInt(setEngGrade.getString(8))){  com = setComments.getString(6); }else if (avgE >=Integer.parseInt(setEngGrade.getString(9))){ com = setComments.getString(7); }else if (avgE >=Integer.parseInt(setEngGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgE >=Integer.parseInt(setEngGrade.getString(11))){ com = setComments.getString(9);}else if (avgE >=Integer.parseInt(setEngGrade.getString(12))){ com = setComments.getString(10);}else if (avgE >=Integer.parseInt(setEngGrade.getString(13))){ com = setComments.getString(11);}else if (avgE >=Integer.parseInt(setEngGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }
                PdfPCell engD5 = new PdfPCell(new Paragraph(setE2.getString(8)+" "+setE2.getString(9)));
                PdfPCell engD6 = new PdfPCell(new Paragraph(com));
                PdfPCell engD7 = new PdfPCell(new Paragraph(setEngTeacher.getString(6)));
                table.addCell(engD1);
                table.addCell(engD2);
                table.addCell(engD3);
                table.addCell(engD4);
                table.addCell(engD5);
                table.addCell(engD6);
                table.addCell(engD7);

                //set kis results
                PdfPCell kisD1 = new PdfPCell(new Paragraph("Kiswahili"));
                PdfPCell kisD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell kisD3 = new PdfPCell(new Paragraph(setE2.getString(11)+" "+setE2.getString(12)));
                PdfPCell kisD4 = new PdfPCell(new Paragraph(" "));

                int avgKis= Integer.parseInt(setE2.getString(11));
                if (avgKis >= Integer.parseInt(setKisGrade.getString(4))) {com = setComments.getString(2); } else if (avgKis >= Integer.parseInt(setKisGrade.getString(5))) { com = setComments.getString(3); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(6))){ com = setComments.getString(4);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(8))){  com = setComments.getString(6); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(9))){ com = setComments.getString(7); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgKis >=Integer.parseInt(setKisGrade.getString(11))){ com = setComments.getString(9);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(12))){ com = setComments.getString(10);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(13))){ com = setComments.getString(11);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }
                PdfPCell kisD5 = new PdfPCell(new Paragraph(setE2.getString(11)+" "+setE2.getString(12)));
                PdfPCell kisD6 = new PdfPCell(new Paragraph(com));
                PdfPCell kisD7 = new PdfPCell(new Paragraph(setKisTeacher.getString(6)));
                table.addCell(kisD1);
                table.addCell(kisD2);
                table.addCell(kisD3);
                table.addCell(kisD4);
                table.addCell(kisD5);
                table.addCell(kisD6);
                table.addCell(kisD7);

                //set mat results

                PdfPCell matD1 = new PdfPCell(new Paragraph("Mathematics"));
                PdfPCell matD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell matD3 = new PdfPCell(new Paragraph(setE2.getString(14)+" "+setE2.getString(15)));
                PdfPCell matD4 = new PdfPCell(new Paragraph(" "));

                int avgMat = Integer.parseInt(setE2.getString(14));
                if (avgMat >= Integer.parseInt(setMatGrade.getString(4))) {com = setComments.getString(2); } else if (avgMat >= Integer.parseInt(setMatGrade.getString(5))) { com = setComments.getString(3); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(6))){ com = setComments.getString(4);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(8))){  com = setComments.getString(6); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(9))){ com = setComments.getString(7); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgMat >=Integer.parseInt(setMatGrade.getString(11))){ com = setComments.getString(9);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(12))){ com = setComments.getString(10);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(13))){ com = setComments.getString(11);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell matD5 = new PdfPCell(new Paragraph(setE2.getString(14)+" "+setE2.getString(15)));
                PdfPCell matD6 = new PdfPCell(new Paragraph(com));
                PdfPCell matD7 = new PdfPCell(new Paragraph(setMatTeacher.getString(6)));
                table.addCell(matD1);
                table.addCell(matD2);
                table.addCell(matD3);
                table.addCell(matD4);
                table.addCell(matD5);
                table.addCell(matD6);
                table.addCell(matD7);

                //set Chemistry results
                PdfPCell chemD1 = new PdfPCell(new Paragraph("Chemistry"));
                PdfPCell chemD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell chemD3 = new PdfPCell(new Paragraph(setE2.getString(20)+" "+setE2.getString(21)));
                PdfPCell chemD4 = new PdfPCell(new Paragraph(" "));

                int avgChem = Integer.parseInt(setE2.getString(20));
                if (avgChem >= Integer.parseInt(setChemGrade.getString(4))) {com = setComments.getString(2); } else if (avgChem >= Integer.parseInt(setChemGrade.getString(5))) { com = setComments.getString(3); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(6))){ com = setComments.getString(4);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(8))){  com = setComments.getString(6); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(9))){ com = setComments.getString(7); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgChem >=Integer.parseInt(setChemGrade.getString(11))){ com = setComments.getString(9);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(12))){ com = setComments.getString(10);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(13))){ com = setComments.getString(11);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell chemD5 = new PdfPCell(new Paragraph(setE2.getString(20)+" "+setE2.getString(21)));
                PdfPCell chemD6 = new PdfPCell(new Paragraph(com));
                PdfPCell chemD7 = new PdfPCell(new Paragraph(setChemTeacher.getString(6)));
                table.addCell(chemD1);
                table.addCell(chemD2);
                table.addCell(chemD3);
                table.addCell(chemD4);
                table.addCell(chemD5);
                table.addCell(chemD6);
                table.addCell(chemD7);

                //set Physics Results
                PdfPCell phyD1 = new PdfPCell(new Paragraph("Physics"));
                PdfPCell phyD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell phyD3 = new PdfPCell(new Paragraph(setE2.getString(23)+" "+setE2.getString(24)));
                PdfPCell phyD4 = new PdfPCell(new Paragraph(" "));

                int avgPhy = Integer.parseInt(setE2.getString(23));
                if (avgPhy >= Integer.parseInt(setPhyGrade.getString(4))) {com = setComments.getString(2); } else if (avgPhy >= Integer.parseInt(setPhyGrade.getString(5))) { com = setComments.getString(3); }else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(6))){ com = setComments.getString(4);}else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(8))){  com = setComments.getString(6); }else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(9))){ com = setComments.getString(7); }else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(11))){ com = setComments.getString(9);}else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(12))){ com = setComments.getString(10);}else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(13))){ com = setComments.getString(11);}else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell phyD5 = new PdfPCell(new Paragraph(setE2.getString(23)+" "+setE2.getString(24)));
                PdfPCell phyD6 = new PdfPCell(new Paragraph(com));
                PdfPCell phyD7 = new PdfPCell(new Paragraph(setPhyTeacher.getString(6)));
                table.addCell(phyD1);
                table.addCell(phyD2);
                table.addCell(phyD3);
                table.addCell(phyD4);
                table.addCell(phyD5);
                table.addCell(phyD6);
                table.addCell(phyD7);

                //set History results
                PdfPCell hisD1 = new PdfPCell(new Paragraph("History"));
                PdfPCell hisD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell hisD3 = new PdfPCell(new Paragraph(setE2.getString(29)+" "+setE2.getString(30)));
                PdfPCell hisD4 = new PdfPCell(new Paragraph(" "));

                int avgHis = Integer.parseInt(setE2.getString(29));
                if (avgHis >= Integer.parseInt(setHisGrade.getString(4))) {com = setComments.getString(2); } else if (avgHis >= Integer.parseInt(setHisGrade.getString(5))) { com = setComments.getString(3); }else if (avgHis >=Integer.parseInt(setHisGrade.getString(6))){ com = setComments.getString(4);}else if (avgHis >=Integer.parseInt(setHisGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgHis >=Integer.parseInt(setHisGrade.getString(8))){  com = setComments.getString(6); }else if (avgHis >=Integer.parseInt(setHisGrade.getString(9))){ com = setComments.getString(7); }else if (avgHis >=Integer.parseInt(setHisGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgHis >=Integer.parseInt(setHisGrade.getString(11))){ com = setComments.getString(9);}else if (avgHis >=Integer.parseInt(setHisGrade.getString(12))){ com = setComments.getString(10);}else if (avgHis >=Integer.parseInt(setHisGrade.getString(13))){ com = setComments.getString(11);}else if (avgHis >=Integer.parseInt(setHisGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell hisD5 = new PdfPCell(new Paragraph(setE2.getString(29)+" "+setE2.getString(30)));
                PdfPCell hisD6 = new PdfPCell(new Paragraph(com));
                PdfPCell hisD7 = new PdfPCell(new Paragraph(setHisTeacher.getString(6)));
                table.addCell(hisD1);
                table.addCell(hisD2);
                table.addCell(hisD3);
                table.addCell(hisD4);
                table.addCell(hisD5);
                table.addCell(hisD6);
                table.addCell(hisD7);

                //set Business results
                PdfPCell busD1 = new PdfPCell(new Paragraph("Business"));
                PdfPCell busD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell busD3 = new PdfPCell(new Paragraph(setE2.getString(35)+" "+setE2.getString(36)));
                PdfPCell busD4 = new PdfPCell(new Paragraph(" "));

                int avgBus = Integer.parseInt(setE2.getString(35));
                if (avgBus >= Integer.parseInt(setBusGrade.getString(4))) {com = setComments.getString(2); } else if (avgBus >= Integer.parseInt(setBusGrade.getString(5))) { com = setComments.getString(3); }else if (avgBus >=Integer.parseInt(setBusGrade.getString(6))){ com = setComments.getString(4);}else if (avgBus >=Integer.parseInt(setBusGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgBus >=Integer.parseInt(setBusGrade.getString(8))){  com = setComments.getString(6); }else if (avgBus >=Integer.parseInt(setBusGrade.getString(9))){ com = setComments.getString(7); }else if (avgBus >=Integer.parseInt(setBusGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgBus >=Integer.parseInt(setBusGrade.getString(11))){ com = setComments.getString(9);}else if (avgBus >=Integer.parseInt(setBusGrade.getString(12))){ com = setComments.getString(10);}else if (avgBus >=Integer.parseInt(setBusGrade.getString(13))){ com = setComments.getString(11);}else if (avgBus >=Integer.parseInt(setBusGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell busD5 = new PdfPCell(new Paragraph(setE2.getString(35)+" "+setE2.getString(36)));
                PdfPCell busD6 = new PdfPCell(new Paragraph(com));
                PdfPCell busD7 = new PdfPCell(new Paragraph(setBusTeacher.getString(6)));
                table.addCell(busD1);
                table.addCell(busD2);
                table.addCell(busD3);
                table.addCell(busD4);
                table.addCell(busD5);
                table.addCell(busD6);
                table.addCell(busD7);

                //set total results

                int totalE2 = Integer.parseInt(setE2.getString(41));



                PdfPCell totalD1 = new PdfPCell(new Paragraph("Total"));
                PdfPCell totalD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell totalD3 = new PdfPCell(new Paragraph(String.valueOf(totalE2)));
                PdfPCell totalD4 = new PdfPCell(new Paragraph(" "));
                PdfPCell totalD5 = new PdfPCell(new Paragraph(" "));
                PdfPCell totalD6 = new PdfPCell(new Paragraph(""));
                PdfPCell totalD7 = new PdfPCell(new Paragraph(""));
                table.addCell(totalD1);
                table.addCell(totalD2);
                table.addCell(totalD3);
                table.addCell(totalD4);
                table.addCell(totalD5);
                table.addCell(totalD6);
                table.addCell(totalD7);

                //set average results

                //int add2AvgEx1 = (Math.addExact(totalEx1Mat,addAvgEx1))/3;

                int addAvgEx2 = Math.round(totalE2/7);
                //int add2AvgEx2 = (Math.addExact(totalEx2Mat,addAvgEx2))/3;


                //int add2AvgEx3 = (Math.addExact(totalEx3Mat,addAvgEx3))/3;


                PdfPCell avgD1 = new PdfPCell(new Paragraph("Average"));
                PdfPCell avgD2 = new PdfPCell(new Paragraph(" "));
                if (addAvgEx2 >= Integer.parseInt(setTotal.getString(4))) {g = "A"; } else if (addAvgEx2 >= Integer.parseInt(setTotal.getString(5))) { g = "A-"; }else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(6))){ g = "B+";}else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(7))){
                    g = "B"; }else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(8))){  g = "B-"; }else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(9))){ g = "C+"; }else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(10))){ g = "C";
                }else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(11))){ g = "C-";}else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(12))){ g = "D+";}else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(13))){ g = "D";}else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(14))){
                    g = "D-";}else {g="E"; }
                PdfPCell avgD3 = new PdfPCell(new Paragraph(String.valueOf(addAvgEx2)+" "+g));


                PdfPCell avgD4 = new PdfPCell(new Paragraph(" "));

                //float avgAvgTotal = (addAvgEx1+addAvgEx2+addAvgEx3)/3;
                int avgAvgTotal=Integer.parseInt(setE2.getString(41))/7;

                if (avgAvgTotal >= Integer.parseInt(setTotal.getString(4))) {g = "A"; } else if (avgAvgTotal >= Integer.parseInt(setTotal.getString(5))) { g = "A-"; }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(6))){ g = "B+";}else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(7))){
                    g = "B"; }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(8))){  g = "B-"; }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(9))){ g = "C+"; }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(10))){ g = "C";
                }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(11))){ g = "C-";}else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(12))){ g = "D+";}else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(13))){ g = "D";}else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(14))){
                    g = "D-";}else {g="E"; }

                PdfPCell avgD5 = new PdfPCell(new Paragraph(String.valueOf(Math.round(avgAvgTotal))+" "+g));
                PdfPCell avgD6 = new PdfPCell(new Paragraph(""));
                PdfPCell avgD7 = new PdfPCell(new Paragraph(""));
                table.addCell(avgD1);
                table.addCell(avgD2);
                table.addCell(avgD3);
                table.addCell(avgD4);
                table.addCell(avgD5);
                table.addCell(avgD6);
                table.addCell(avgD7);

                document.add(table);

                Paragraph labelSummary = new Paragraph("PERFORMANCE TREND",new Font(Font.FontFamily.TIMES_ROMAN, 8,Font.BOLD));
                labelSummary.setSpacingBefore(0);
                labelSummary.setSpacingAfter(5);
                labelSummary.setAlignment(Element.ALIGN_CENTER);
                document.add(labelSummary);

                PdfPTable tableLastSummary = new PdfPTable(8);
                tableLastSummary.setWidthPercentage(105);
                tableLastSummary.setSpacingBefore(0f);
                tableLastSummary.setSpacingAfter(0f);

                float[] colWidthSummary = {0.5f,0.5f,0.5f,0.5f,0.5f,0.5f,0.5f,0.5f};
                tableLastSummary.setWidths(colWidthSummary);
                PdfPCell cS1 = new PdfPCell(new Paragraph("FORM 1",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell cS2 = new PdfPCell(new Paragraph(" ",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell cS3 = new PdfPCell(new Paragraph("FORM 2",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell cS4 = new PdfPCell(new Paragraph(" ",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell cS5 = new PdfPCell(new Paragraph("FORM 3",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell cS6 = new PdfPCell(new Paragraph(" ",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell cS7 = new PdfPCell(new Paragraph("FORM 4",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell cS8 = new PdfPCell(new Paragraph(" ",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                tableLastSummary.addCell(cS1);
                tableLastSummary.addCell(cS2);
                tableLastSummary.addCell(cS3);
                tableLastSummary.addCell(cS4);
                tableLastSummary.addCell(cS5);
                tableLastSummary.addCell(cS6);
                tableLastSummary.addCell(cS7);
                tableLastSummary.addCell(cS8);

                PdfPCell f1t1 = new PdfPCell(new Paragraph("F1T1"));
                PdfPCell f1t1m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF1T1E2.getString(30)))/11)+" "+setF1T1E2.getString(31)));
                PdfPCell f2t1 = new PdfPCell(new Paragraph("F2T1"));
                PdfPCell f2t1m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF2T1E2.getString(30)))/11)+" "+setF2T1E2.getString(31)));
                PdfPCell f3t1 = new PdfPCell(new Paragraph("F3T1"));
                PdfPCell f3t1m = new PdfPCell(new Paragraph(String.valueOf(Integer.parseInt(setF3T1E2.getString(41))/11)+" "+setF3T1E2.getString(43)+" "+setF3T1E2.getString(42)));
                PdfPCell f4t1 = new PdfPCell(new Paragraph("F4T1"));
                PdfPCell f4t1m = new PdfPCell(new Paragraph(" "));
                tableLastSummary.addCell(f1t1);
                tableLastSummary.addCell(f1t1m);
                tableLastSummary.addCell(f2t1);
                tableLastSummary.addCell(f2t1m);
                tableLastSummary.addCell(f3t1);
                tableLastSummary.addCell(f3t1m);
                tableLastSummary.addCell(f4t1);
                tableLastSummary.addCell(f4t1m);

                PdfPCell f1t2 = new PdfPCell(new Paragraph("F1T2"));
                PdfPCell f1t2m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF1T2E2.getString(30)))/11)+" "+setF1T2E2.getString(31)));
                PdfPCell f2t2 = new PdfPCell(new Paragraph("F2T2"));
                PdfPCell f2t2m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF2T2E2.getString(30)))/11)+" "+setF2T2E2.getString(31)));
                PdfPCell f3t2 = new PdfPCell(new Paragraph("F3T2"));
                PdfPCell f3t2m = new PdfPCell(new Paragraph(String.valueOf(avgAvgTotal)+" "+setE2.getString(42)+" "+setE2.getString(43)));
                PdfPCell f4t2 = new PdfPCell(new Paragraph("F4T2"));
                PdfPCell f4t2m = new PdfPCell(new Paragraph(" "));
                tableLastSummary.addCell(f1t2);
                tableLastSummary.addCell(f1t2m);
                tableLastSummary.addCell(f2t2);
                tableLastSummary.addCell(f2t2m);
                tableLastSummary.addCell(f3t2);
                tableLastSummary.addCell(f3t2m);
                tableLastSummary.addCell(f4t2);
                tableLastSummary.addCell(f4t2m);

                PdfPCell f1t3 = new PdfPCell(new Paragraph("F1T3"));
                PdfPCell f1t3m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF1T3E2.getString(30)))/11)+" "+setF1T3E2.getString(31)));
                PdfPCell f2t3 = new PdfPCell(new Paragraph("F2T3"));
                PdfPCell f2t3m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF2T3E2.getString(30)))/11)+" "+setF2T3E2.getString(31)));
                PdfPCell f3t3 = new PdfPCell(new Paragraph("F3T3"));
                PdfPCell f3t3m = new PdfPCell(new Paragraph(" "));
                PdfPCell f4t3 = new PdfPCell(new Paragraph("F4T3"));
                PdfPCell f4t3m = new PdfPCell(new Paragraph(" "));
                tableLastSummary.addCell(f1t3);
                tableLastSummary.addCell(f1t3m);
                tableLastSummary.addCell(f2t3);
                tableLastSummary.addCell(f2t3m);
                tableLastSummary.addCell(f3t3);
                tableLastSummary.addCell(f3t3m);
                tableLastSummary.addCell(f4t3);
                tableLastSummary.addCell(f4t3m);

                document.add(tableLastSummary);
            /*
            * logo
            * */
                Image img = Image.getInstance(cname+"\\HS Results\\Web-Development.png");
                img.scaleAbsolute(100,50);
                img.setAbsolutePosition(30,750);
                document.add(img);

            /*
            * chart
            * */
                DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
                JFreeChart chart = ChartFactory.createBarChart(
                        "", "", "Marks",
                        dataSet, PlotOrientation.VERTICAL, false, false, false);
                int width=500; /* Width of our chart */
                int height=150; /* Height of our chart */
/* Get instance of CategoryPlot */
                CategoryPlot plot = chart.getCategoryPlot();
                BarRenderer renderer = (BarRenderer) plot.getRenderer();
                renderer.setSeriesPaint(0, Color.black);
                dataSet.setValue((Integer.parseInt(setF1T1E2.getString(30))/11)/7, "Marks", "F1T1");
                dataSet.setValue((Integer.parseInt(setF1T2E2.getString(30))/11)/7, "Marks", "F1T2");
                dataSet.setValue((Integer.parseInt(setF1T3E2.getString(30))/11)/7, "Marks", "F1T3");
                dataSet.setValue((Integer.parseInt(setF2T1E2.getString(30))/11)/7, "Marks", "F2T1");
                dataSet.setValue((Integer.parseInt(setF2T2E2.getString(30))/11)/7, "Marks", "F2T2");
                dataSet.setValue((Integer.parseInt(setF2T3E2.getString(30))/11)/7, "Marks", "F2T3");
                dataSet.setValue(Float.parseFloat(setF3T1E2.getString(43)), "Marks", "F3T1");
                dataSet.setValue(Float.parseFloat(setE2.getString(43)), "Marks", "F3T2");
                dataSet.setValue(0, "Marks", "F3T3");
                dataSet.setValue(0, "Marks", "F4T1");
                dataSet.setValue(0, "Marks", "F4T2");
                dataSet.setValue(0, "Marks", "F4T3");
                PdfContentByte contentByte = writer.getDirectContent();
                PdfTemplate template = contentByte.createTemplate(width, height);
                Graphics2D graphics2d = template.createGraphics(width, height,new DefaultFontMapper());
                Rectangle2D rectangle2d = new Rectangle2D.Double(0, 0, width, height);
                chart.draw(graphics2d, rectangle2d);
                graphics2d.dispose();
                contentByte.addTemplate(template, 30, 275);

                Paragraph classTeacherComments = new Paragraph("Class teacher comments: _________________________________________________________");
                Paragraph classTeacherComments1 = new Paragraph("______________________________________________________________________________");
                Paragraph principalComments =new Paragraph("Principal comments: _____________________________________________________________");
                Paragraph principalComments1 =new Paragraph("______________________________________________________________________________");

                classTeacherComments.setSpacingBefore(170);
                document.add(classTeacherComments);
                document.add(classTeacherComments1);
                document.add(principalComments);
                document.add(principalComments1);
                document.close();
            writer.close();
            infoBox("Document containing exam2 results for " + NAME + " has been created open it for printing.","Done",null);
            Desktop.getDesktop().open(new File(cname+"\\HS Results\\"+NAME+".pdf"));


            }catch (Exception e){
                e.printStackTrace();
                infoBoxError("An error occurred " + e,"Error",null);
            }}else {
            infoBoxError("You are not allowed to print","Error",null);
        }
    }

    private void printPhyGeoAgri(String ADM,int POS, String ALL) {
        if(printPassword.toString().equals("vic")) {
            String sqlDetails="SELECT * FROM tbl_students WHERE adm=?";
            String sqlComm = "SELECT * FROM tbl_comments";
            String sqlTotal ="SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='TOTAL'";

            String sqlEx2 = "SELECT * FROM tbl_f3_t2_ex2 WHERE adm=? ";
            String sqlF1T1Ex2 = "SELECT * FROM tbl_f1_t1_ex2 WHERE adm=?";
            String sqlF1T2Ex2 = "SELECT * FROM tbl_f1_t2_ex2 WHERE adm=?";
            String sqlF1T3Ex2 = "SELECT * FROM tbl_f1_t3_ex2 WHERE adm=?";
            String sqlF2T1Ex2 = "SELECT * FROM tbl_f2_t1_ex2 WHERE adm=?";
            String sqlF2T2Ex2 = "SELECT * FROM tbl_f2_t2_ex2 WHERE adm=?";
            String sqlF2T3Ex2 = "SELECT * FROM tbl_f2_t3_ex2 WHERE adm=?";
            String sqlF3T1Ex2 = "SELECT * FROM tbl_f3_t1_ex2 WHERE adm=?";


            String sqlEngTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='English'";
            String sqlKisTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='Kiswahili'";
            String sqlMatTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='Mathematics'";
            String sqlChemTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='Chemistry'";
            String sqlBioTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='Biology'";
            String sqlPhyTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='Physics'";
            String sqlHisTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='History'";
            String sqlGeoTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='Geography'";
            String sqlCreTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='CRE'";
            String sqlBusTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='Business'";
            String sqlAgriTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='Agriculture'";

            String sqlEngGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='ENGLISH'";
            String sqlKisGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='KISWAHILI'";
            String sqlMatGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='MATHEMATICS'";
            String sqlChemGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='CHEMISTRY'";
            String sqlBioGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='BIOLOGY'";
            String sqlPhyGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='PHYSICS'";
            String sqlHisGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='HISTORY'";
            String sqlGeoGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='GEOGRAPHY'";
            String sqlCreGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='CRE'";
            String sqlBusGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='BUSINESS'";
            String sqlAgriGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='AGRICULTURE'";

            try{
                Connection connection = Database.DBConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sqlDetails);

                PreparedStatement statementE2 = connection.prepareStatement(sqlEx2);
                PreparedStatement statementF1T1E2 = connection.prepareStatement(sqlF1T1Ex2);
                PreparedStatement statementF1T2E2 = connection.prepareStatement(sqlF1T2Ex2);
                PreparedStatement statementF1T3E2 = connection.prepareStatement(sqlF1T3Ex2);
                PreparedStatement statementF2T1E2 = connection.prepareStatement(sqlF2T1Ex2);
                PreparedStatement statementF2T2E2 = connection.prepareStatement(sqlF2T2Ex2);
                PreparedStatement statementF2T3E2 = connection.prepareStatement(sqlF2T3Ex2);
                PreparedStatement statementF3T1E2 = connection.prepareStatement(sqlF3T1Ex2);



                statement.setString(1,ADM);

                statementE2.setString(1,ADM);
                statementF1T1E2.setString(1,ADM);
                statementF1T2E2.setString(1,ADM);
                statementF1T3E2.setString(1,ADM);
                statementF2T1E2.setString(1,ADM);
                statementF2T2E2.setString(1,ADM);
                statementF2T3E2.setString(1,ADM);
                statementF3T1E2.setString(1,ADM);


                ResultSet set = statement.executeQuery();

                ResultSet setE2 = statementE2.executeQuery();
                ResultSet setF1T1E2 = statementF1T1E2.executeQuery();
                ResultSet setF1T2E2 = statementF1T2E2.executeQuery();
                ResultSet setF1T3E2 = statementF1T3E2.executeQuery();
                ResultSet setF2T1E2 = statementF2T1E2.executeQuery();
                ResultSet setF2T2E2 = statementF2T2E2.executeQuery();
                ResultSet setF2T3E2 = statementF2T3E2.executeQuery();
                ResultSet setF3T1E2 = statementF3T1E2.executeQuery();


                ResultSet setEngTeacher = connection.createStatement().executeQuery(sqlEngTeacher);
                ResultSet setKisTeacher = connection.createStatement().executeQuery(sqlKisTeacher);
                ResultSet setMatTeacher = connection.createStatement().executeQuery(sqlMatTeacher);
                ResultSet setChemTeacher = connection.createStatement().executeQuery(sqlChemTeacher);
                ResultSet setBioTeacher = connection.createStatement().executeQuery(sqlBioTeacher);
                ResultSet setPhyTeacher = connection.createStatement().executeQuery(sqlPhyTeacher);
                ResultSet setHisTeacher = connection.createStatement().executeQuery(sqlHisTeacher);
                ResultSet setGeoTeacher = connection.createStatement().executeQuery(sqlGeoTeacher);
                ResultSet setCreTeacher = connection.createStatement().executeQuery(sqlCreTeacher);
                ResultSet setBusTeacher = connection.createStatement().executeQuery(sqlBusTeacher);
                ResultSet setAgriTeacher = connection.createStatement().executeQuery(sqlAgriTeacher);

                ResultSet setEngGrade = connection.createStatement().executeQuery(sqlEngGrade);
                ResultSet setKisGrade = connection.createStatement().executeQuery(sqlKisGrade);
                ResultSet setMatGrade = connection.createStatement().executeQuery(sqlMatGrade);
                ResultSet setChemGrade = connection.createStatement().executeQuery(sqlChemGrade);
                ResultSet setBioGrade = connection.createStatement().executeQuery(sqlBioGrade);
                ResultSet setPhyGrade = connection.createStatement().executeQuery(sqlPhyGrade);
                ResultSet setHisGrade = connection.createStatement().executeQuery(sqlHisGrade);
                ResultSet setGeoGrade = connection.createStatement().executeQuery(sqlGeoGrade);
                ResultSet setCreGrade = connection.createStatement().executeQuery(sqlCreGrade);
                ResultSet setBusGrade = connection.createStatement().executeQuery(sqlBusGrade);
                ResultSet setAgriGrade = connection.createStatement().executeQuery(sqlAgriGrade);

                ResultSet setComments = connection.createStatement().executeQuery(sqlComm);
                ResultSet setTotal = connection.createStatement().executeQuery(sqlTotal);

                String names = set.getString(3)+"_"+set.getString(4)+"_"+set.getString(5);

                Document document = new Document(PageSize.A4);
            PdfWriter writer = PdfWriter.getInstance(document,new FileOutputStream(NAME+".pdf"));
            document.open();

                Paragraph schoolName = new Paragraph("SCHOOL NAME", new Font(Font.FontFamily.TIMES_ROMAN, 15,Font.BOLD));
                Paragraph address = new Paragraph("P.O BOX 22332, LOCATION", new Font(Font.FontFamily.TIMES_ROMAN, 15,Font.BOLD));
                Paragraph tell = new Paragraph("PHONE: 073293874", new Font(Font.FontFamily.TIMES_ROMAN, 15,Font.BOLD));
                Paragraph reportType = new Paragraph("Report Form", new Font(Font.FontFamily.TIMES_ROMAN, 10,Font.BOLD));
                schoolName.setAlignment(Element.ALIGN_CENTER);
                address.setAlignment(Element.ALIGN_CENTER);
                tell.setAlignment(Element.ALIGN_CENTER);
                reportType.setAlignment(Element.ALIGN_CENTER);
                document.add(schoolName);
                document.add(address);
                document.add(tell);
                document.add(reportType);

                document.add((new Paragraph("ADM: "+set.getString(2)+"  "+"NAME: "+set.getString(3)+"   "+set.getString(4)+" "+set.getString(5)+"  "+"KCPE:"+set.getString(6)+"  "+"CLASS:FORM 3"+"  "+"TERM:TERM 2",new Font(Font.FontFamily.TIMES_ROMAN, 9,Font.BOLD))));
                document.add((new Paragraph("YEAR:"+now.get(Calendar.YEAR)+" "+"POS:"+String.valueOf(POS+1)+" "+"OUT OF "+ALL,new Font(Font.FontFamily.TIMES_ROMAN, 9,Font.BOLD))));
                document.add((new Paragraph(" ")));

                PdfPTable table = new PdfPTable(7);
                table.setWidthPercentage(105);
                table.setSpacingBefore(0f);
                table.setSpacingAfter(0f);

                float[] colWidth = {1.1f,0.5f,0.5f,0.5f,0.7f,2f,1f};
                table.setWidths(colWidth);
                PdfPCell c1 = new PdfPCell(new Paragraph("SUBJECTS",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell c2 = new PdfPCell(new Paragraph("EX1",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell c3 = new PdfPCell(new Paragraph("EX2",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell c4 = new PdfPCell(new Paragraph("EX3",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell c5 = new PdfPCell(new Paragraph("AVG",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell c6 = new PdfPCell(new Paragraph("COMMENTS",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell c7 = new PdfPCell(new Paragraph("TEACHER",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                table.addCell(c1);
                table.addCell(c2);
                table.addCell(c3);
                table.addCell(c4);
                table.addCell(c5);
                table.addCell(c6);
                table.addCell(c7);

                //set eng results
                String g,com=null;
                PdfPCell engD1 = new PdfPCell(new Paragraph("English"));
                PdfPCell engD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell engD3 = new PdfPCell(new Paragraph(setE2.getString(8)+" "+setE2.getString(9)));
                PdfPCell engD4 = new PdfPCell(new Paragraph(" "));

                int avgE= Integer.parseInt(setE2.getString(8));
                if (avgE >= Integer.parseInt(setEngGrade.getString(4))) {com = setComments.getString(2); } else if (avgE >= Integer.parseInt(setEngGrade.getString(5))) { com = setComments.getString(3); }else if (avgE >=Integer.parseInt(setEngGrade.getString(6))){ com = setComments.getString(4);}else if (avgE >=Integer.parseInt(setEngGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgE >=Integer.parseInt(setEngGrade.getString(8))){  com = setComments.getString(6); }else if (avgE >=Integer.parseInt(setEngGrade.getString(9))){ com = setComments.getString(7); }else if (avgE >=Integer.parseInt(setEngGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgE >=Integer.parseInt(setEngGrade.getString(11))){ com = setComments.getString(9);}else if (avgE >=Integer.parseInt(setEngGrade.getString(12))){ com = setComments.getString(10);}else if (avgE >=Integer.parseInt(setEngGrade.getString(13))){ com = setComments.getString(11);}else if (avgE >=Integer.parseInt(setEngGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }
                PdfPCell engD5 = new PdfPCell(new Paragraph(setE2.getString(8)+" "+setE2.getString(9)));
                PdfPCell engD6 = new PdfPCell(new Paragraph(com));
                PdfPCell engD7 = new PdfPCell(new Paragraph(setEngTeacher.getString(6)));
                table.addCell(engD1);
                table.addCell(engD2);
                table.addCell(engD3);
                table.addCell(engD4);
                table.addCell(engD5);
                table.addCell(engD6);
                table.addCell(engD7);

                //set kis results
                PdfPCell kisD1 = new PdfPCell(new Paragraph("Kiswahili"));
                PdfPCell kisD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell kisD3 = new PdfPCell(new Paragraph(setE2.getString(11)+" "+setE2.getString(12)));
                PdfPCell kisD4 = new PdfPCell(new Paragraph(" "));

                int avgKis= Integer.parseInt(setE2.getString(11));
                if (avgKis >= Integer.parseInt(setKisGrade.getString(4))) {com = setComments.getString(2); } else if (avgKis >= Integer.parseInt(setKisGrade.getString(5))) { com = setComments.getString(3); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(6))){ com = setComments.getString(4);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(8))){  com = setComments.getString(6); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(9))){ com = setComments.getString(7); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgKis >=Integer.parseInt(setKisGrade.getString(11))){ com = setComments.getString(9);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(12))){ com = setComments.getString(10);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(13))){ com = setComments.getString(11);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }
                PdfPCell kisD5 = new PdfPCell(new Paragraph(setE2.getString(11)+" "+setE2.getString(12)));
                PdfPCell kisD6 = new PdfPCell(new Paragraph(com));
                PdfPCell kisD7 = new PdfPCell(new Paragraph(setKisTeacher.getString(6)));
                table.addCell(kisD1);
                table.addCell(kisD2);
                table.addCell(kisD3);
                table.addCell(kisD4);
                table.addCell(kisD5);
                table.addCell(kisD6);
                table.addCell(kisD7);

                //set mat results

                PdfPCell matD1 = new PdfPCell(new Paragraph("Mathematics"));
                PdfPCell matD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell matD3 = new PdfPCell(new Paragraph(setE2.getString(14)+" "+setE2.getString(15)));
                PdfPCell matD4 = new PdfPCell(new Paragraph(" "));

                int avgMat = Integer.parseInt(setE2.getString(14));
                if (avgMat >= Integer.parseInt(setMatGrade.getString(4))) {com = setComments.getString(2); } else if (avgMat >= Integer.parseInt(setMatGrade.getString(5))) { com = setComments.getString(3); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(6))){ com = setComments.getString(4);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(8))){  com = setComments.getString(6); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(9))){ com = setComments.getString(7); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgMat >=Integer.parseInt(setMatGrade.getString(11))){ com = setComments.getString(9);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(12))){ com = setComments.getString(10);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(13))){ com = setComments.getString(11);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell matD5 = new PdfPCell(new Paragraph(setE2.getString(14)+" "+setE2.getString(15)));
                PdfPCell matD6 = new PdfPCell(new Paragraph(com));
                PdfPCell matD7 = new PdfPCell(new Paragraph(setMatTeacher.getString(6)));
                table.addCell(matD1);
                table.addCell(matD2);
                table.addCell(matD3);
                table.addCell(matD4);
                table.addCell(matD5);
                table.addCell(matD6);
                table.addCell(matD7);

                //set Chemistry results
                PdfPCell chemD1 = new PdfPCell(new Paragraph("Chemistry"));
                PdfPCell chemD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell chemD3 = new PdfPCell(new Paragraph(setE2.getString(20)+" "+setE2.getString(21)));
                PdfPCell chemD4 = new PdfPCell(new Paragraph(" "));

                int avgChem = Integer.parseInt(setE2.getString(20));
                if (avgChem >= Integer.parseInt(setChemGrade.getString(4))) {com = setComments.getString(2); } else if (avgChem >= Integer.parseInt(setChemGrade.getString(5))) { com = setComments.getString(3); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(6))){ com = setComments.getString(4);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(8))){  com = setComments.getString(6); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(9))){ com = setComments.getString(7); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgChem >=Integer.parseInt(setChemGrade.getString(11))){ com = setComments.getString(9);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(12))){ com = setComments.getString(10);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(13))){ com = setComments.getString(11);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell chemD5 = new PdfPCell(new Paragraph(setE2.getString(20)+" "+setE2.getString(21)));
                PdfPCell chemD6 = new PdfPCell(new Paragraph(com));
                PdfPCell chemD7 = new PdfPCell(new Paragraph(setChemTeacher.getString(6)));
                table.addCell(chemD1);
                table.addCell(chemD2);
                table.addCell(chemD3);
                table.addCell(chemD4);
                table.addCell(chemD5);
                table.addCell(chemD6);
                table.addCell(chemD7);

                //set Physics Results
                PdfPCell phyD1 = new PdfPCell(new Paragraph("Physics"));
                PdfPCell phyD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell phyD3 = new PdfPCell(new Paragraph(setE2.getString(23)+" "+setE2.getString(24)));
                PdfPCell phyD4 = new PdfPCell(new Paragraph(" "));

                int avgPhy = Integer.parseInt(setE2.getString(23));
                if (avgPhy >= Integer.parseInt(setPhyGrade.getString(4))) {com = setComments.getString(2); } else if (avgPhy >= Integer.parseInt(setPhyGrade.getString(5))) { com = setComments.getString(3); }else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(6))){ com = setComments.getString(4);}else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(8))){  com = setComments.getString(6); }else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(9))){ com = setComments.getString(7); }else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(11))){ com = setComments.getString(9);}else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(12))){ com = setComments.getString(10);}else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(13))){ com = setComments.getString(11);}else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell phyD5 = new PdfPCell(new Paragraph(setE2.getString(23)+" "+setE2.getString(24)));
                PdfPCell phyD6 = new PdfPCell(new Paragraph(com));
                PdfPCell phyD7 = new PdfPCell(new Paragraph(setPhyTeacher.getString(6)));
                table.addCell(phyD1);
                table.addCell(phyD2);
                table.addCell(phyD3);
                table.addCell(phyD4);
                table.addCell(phyD5);
                table.addCell(phyD6);
                table.addCell(phyD7);

                //set Geography results
                PdfPCell geoD1 = new PdfPCell(new Paragraph("Geography"));
                PdfPCell geoD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell geoD3 = new PdfPCell(new Paragraph(setE2.getString(26)+" "+setE2.getString(27)));
                PdfPCell geoD4 = new PdfPCell(new Paragraph(" "));

                int avgGeo = Integer.parseInt(setE2.getString(26));
                if (avgGeo >= Integer.parseInt(setGeoGrade.getString(4))) {com = setComments.getString(2); } else if (avgGeo >= Integer.parseInt(setGeoGrade.getString(5))) { com = setComments.getString(3); }else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(6))){ com = setComments.getString(4);}else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(8))){  com = setComments.getString(6); }else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(9))){ com = setComments.getString(7); }else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(11))){ com = setComments.getString(9);}else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(12))){ com = setComments.getString(10);}else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(13))){ com = setComments.getString(11);}else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell geoD5 = new PdfPCell(new Paragraph(setE2.getString(26)+" "+setE2.getString(27)));
                PdfPCell geoD6 = new PdfPCell(new Paragraph(com));
                PdfPCell geoD7 = new PdfPCell(new Paragraph(setGeoTeacher.getString(6)));
                table.addCell(geoD1);
                table.addCell(geoD2);
                table.addCell(geoD3);
                table.addCell(geoD4);
                table.addCell(geoD5);
                table.addCell(geoD6);
                table.addCell(geoD7);

                //set Agriculture results
                PdfPCell agriD1 = new PdfPCell(new Paragraph("Agriculture"));
                PdfPCell agriD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell agriD3 = new PdfPCell(new Paragraph(setE2.getString(38)+" "+setE2.getString(39)));
                PdfPCell agriD4 = new PdfPCell(new Paragraph(" "));

                int avgAgri = Integer.parseInt(setE2.getString(38));
                if (avgAgri >= Integer.parseInt(setAgriGrade.getString(4))) {com = setComments.getString(2); } else if (avgAgri >= Integer.parseInt(setAgriGrade.getString(5))) { com = setComments.getString(3); }else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(6))){ com = setComments.getString(4);}else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(8))){  com = setComments.getString(6); }else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(9))){ com = setComments.getString(7); }else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(11))){ com = setComments.getString(9);}else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(12))){ com = setComments.getString(10);}else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(13))){ com = setComments.getString(11);}else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell agriD5 = new PdfPCell(new Paragraph(setE2.getString(38)+" "+setE2.getString(39)));
                PdfPCell agriD6 = new PdfPCell(new Paragraph(com));
                PdfPCell agriD7 = new PdfPCell(new Paragraph(setAgriTeacher.getString(6)));
                table.addCell(agriD1);
                table.addCell(agriD2);
                table.addCell(agriD3);
                table.addCell(agriD4);
                table.addCell(agriD5);
                table.addCell(agriD6);
                table.addCell(agriD7);

                //set total results

                int totalE2 = Integer.parseInt(setE2.getString(41));



                PdfPCell totalD1 = new PdfPCell(new Paragraph("Total"));
                PdfPCell totalD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell totalD3 = new PdfPCell(new Paragraph(String.valueOf(totalE2)));
                PdfPCell totalD4 = new PdfPCell(new Paragraph(" "));
                PdfPCell totalD5 = new PdfPCell(new Paragraph(" "));
                PdfPCell totalD6 = new PdfPCell(new Paragraph(""));
                PdfPCell totalD7 = new PdfPCell(new Paragraph(""));
                table.addCell(totalD1);
                table.addCell(totalD2);
                table.addCell(totalD3);
                table.addCell(totalD4);
                table.addCell(totalD5);
                table.addCell(totalD6);
                table.addCell(totalD7);

                //set average results

                //int add2AvgEx1 = (Math.addExact(totalEx1Mat,addAvgEx1))/3;

                int addAvgEx2 = Math.round(totalE2/7);
                //int add2AvgEx2 = (Math.addExact(totalEx2Mat,addAvgEx2))/3;


                //int add2AvgEx3 = (Math.addExact(totalEx3Mat,addAvgEx3))/3;


                PdfPCell avgD1 = new PdfPCell(new Paragraph("Average"));
                PdfPCell avgD2 = new PdfPCell(new Paragraph(" "));
                if (addAvgEx2 >= Integer.parseInt(setTotal.getString(4))) {g = "A"; } else if (addAvgEx2 >= Integer.parseInt(setTotal.getString(5))) { g = "A-"; }else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(6))){ g = "B+";}else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(7))){
                    g = "B"; }else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(8))){  g = "B-"; }else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(9))){ g = "C+"; }else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(10))){ g = "C";
                }else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(11))){ g = "C-";}else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(12))){ g = "D+";}else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(13))){ g = "D";}else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(14))){
                    g = "D-";}else {g="E"; }
                PdfPCell avgD3 = new PdfPCell(new Paragraph(String.valueOf(addAvgEx2)+" "+g));


                PdfPCell avgD4 = new PdfPCell(new Paragraph(" "));

                //float avgAvgTotal = (addAvgEx1+addAvgEx2+addAvgEx3)/3;
                int avgAvgTotal=Integer.parseInt(setE2.getString(41))/7;

                if (avgAvgTotal >= Integer.parseInt(setTotal.getString(4))) {g = "A"; } else if (avgAvgTotal >= Integer.parseInt(setTotal.getString(5))) { g = "A-"; }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(6))){ g = "B+";}else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(7))){
                    g = "B"; }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(8))){  g = "B-"; }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(9))){ g = "C+"; }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(10))){ g = "C";
                }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(11))){ g = "C-";}else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(12))){ g = "D+";}else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(13))){ g = "D";}else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(14))){
                    g = "D-";}else {g="E"; }

                PdfPCell avgD5 = new PdfPCell(new Paragraph(String.valueOf(Math.round(avgAvgTotal))+" "+g));
                PdfPCell avgD6 = new PdfPCell(new Paragraph(""));
                PdfPCell avgD7 = new PdfPCell(new Paragraph(""));
                table.addCell(avgD1);
                table.addCell(avgD2);
                table.addCell(avgD3);
                table.addCell(avgD4);
                table.addCell(avgD5);
                table.addCell(avgD6);
                table.addCell(avgD7);

                document.add(table);

                Paragraph labelSummary = new Paragraph("PERFORMANCE TREND",new Font(Font.FontFamily.TIMES_ROMAN, 8,Font.BOLD));
                labelSummary.setSpacingBefore(0);
                labelSummary.setSpacingAfter(5);
                labelSummary.setAlignment(Element.ALIGN_CENTER);
                document.add(labelSummary);

                PdfPTable tableLastSummary = new PdfPTable(8);
                tableLastSummary.setWidthPercentage(105);
                tableLastSummary.setSpacingBefore(0f);
                tableLastSummary.setSpacingAfter(0f);

                float[] colWidthSummary = {0.5f,0.5f,0.5f,0.5f,0.5f,0.5f,0.5f,0.5f};
                tableLastSummary.setWidths(colWidthSummary);
                PdfPCell cS1 = new PdfPCell(new Paragraph("FORM 1",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell cS2 = new PdfPCell(new Paragraph(" ",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell cS3 = new PdfPCell(new Paragraph("FORM 2",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell cS4 = new PdfPCell(new Paragraph(" ",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell cS5 = new PdfPCell(new Paragraph("FORM 3",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell cS6 = new PdfPCell(new Paragraph(" ",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell cS7 = new PdfPCell(new Paragraph("FORM 4",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell cS8 = new PdfPCell(new Paragraph(" ",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                tableLastSummary.addCell(cS1);
                tableLastSummary.addCell(cS2);
                tableLastSummary.addCell(cS3);
                tableLastSummary.addCell(cS4);
                tableLastSummary.addCell(cS5);
                tableLastSummary.addCell(cS6);
                tableLastSummary.addCell(cS7);
                tableLastSummary.addCell(cS8);

                PdfPCell f1t1 = new PdfPCell(new Paragraph("F1T1"));
                PdfPCell f1t1m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF1T1E2.getString(30)))/11)+" "+setF1T1E2.getString(31)));
                PdfPCell f2t1 = new PdfPCell(new Paragraph("F2T1"));
                PdfPCell f2t1m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF2T1E2.getString(30)))/11)+" "+setF2T1E2.getString(31)));
                PdfPCell f3t1 = new PdfPCell(new Paragraph("F3T1"));
                PdfPCell f3t1m = new PdfPCell(new Paragraph(String.valueOf(Integer.parseInt(setF3T1E2.getString(41))/11)+" "+setF3T1E2.getString(43)+" "+setF3T1E2.getString(42)));
                PdfPCell f4t1 = new PdfPCell(new Paragraph("F4T1"));
                PdfPCell f4t1m = new PdfPCell(new Paragraph(" "));
                tableLastSummary.addCell(f1t1);
                tableLastSummary.addCell(f1t1m);
                tableLastSummary.addCell(f2t1);
                tableLastSummary.addCell(f2t1m);
                tableLastSummary.addCell(f3t1);
                tableLastSummary.addCell(f3t1m);
                tableLastSummary.addCell(f4t1);
                tableLastSummary.addCell(f4t1m);

                PdfPCell f1t2 = new PdfPCell(new Paragraph("F1T2"));
                PdfPCell f1t2m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF1T2E2.getString(30)))/11)+" "+setF1T2E2.getString(31)));
                PdfPCell f2t2 = new PdfPCell(new Paragraph("F2T2"));
                PdfPCell f2t2m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF2T2E2.getString(30)))/11)+" "+setF2T2E2.getString(31)));
                PdfPCell f3t2 = new PdfPCell(new Paragraph("F3T2"));
                PdfPCell f3t2m = new PdfPCell(new Paragraph(String.valueOf(avgAvgTotal)+" "+setE2.getString(42)+" "+setE2.getString(43)));
                PdfPCell f4t2 = new PdfPCell(new Paragraph("F4T2"));
                PdfPCell f4t2m = new PdfPCell(new Paragraph(" "));
                tableLastSummary.addCell(f1t2);
                tableLastSummary.addCell(f1t2m);
                tableLastSummary.addCell(f2t2);
                tableLastSummary.addCell(f2t2m);
                tableLastSummary.addCell(f3t2);
                tableLastSummary.addCell(f3t2m);
                tableLastSummary.addCell(f4t2);
                tableLastSummary.addCell(f4t2m);

                PdfPCell f1t3 = new PdfPCell(new Paragraph("F1T3"));
                PdfPCell f1t3m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF1T3E2.getString(30)))/11)+" "+setF1T3E2.getString(31)));
                PdfPCell f2t3 = new PdfPCell(new Paragraph("F2T3"));
                PdfPCell f2t3m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF2T3E2.getString(30)))/11)+" "+setF2T3E2.getString(31)));
                PdfPCell f3t3 = new PdfPCell(new Paragraph("F3T3"));
                PdfPCell f3t3m = new PdfPCell(new Paragraph(" "));
                PdfPCell f4t3 = new PdfPCell(new Paragraph("F4T3"));
                PdfPCell f4t3m = new PdfPCell(new Paragraph(" "));
                tableLastSummary.addCell(f1t3);
                tableLastSummary.addCell(f1t3m);
                tableLastSummary.addCell(f2t3);
                tableLastSummary.addCell(f2t3m);
                tableLastSummary.addCell(f3t3);
                tableLastSummary.addCell(f3t3m);
                tableLastSummary.addCell(f4t3);
                tableLastSummary.addCell(f4t3m);

                document.add(tableLastSummary);
            /*
            * logo
            * */
                Image img = Image.getInstance(cname+"\\HS Results\\Web-Development.png");
                img.scaleAbsolute(100,50);
                img.setAbsolutePosition(30,750);
                document.add(img);

            /*
            * chart
            * */
                DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
                JFreeChart chart = ChartFactory.createBarChart(
                        "", "", "Marks",
                        dataSet, PlotOrientation.VERTICAL, false, false, false);
                int width=500; /* Width of our chart */
                int height=150; /* Height of our chart */
/* Get instance of CategoryPlot */
                CategoryPlot plot = chart.getCategoryPlot();
                BarRenderer renderer = (BarRenderer) plot.getRenderer();
                renderer.setSeriesPaint(0, Color.black);
                dataSet.setValue((Integer.parseInt(setF1T1E2.getString(30))/11)/7, "Marks", "F1T1");
                dataSet.setValue((Integer.parseInt(setF1T2E2.getString(30))/11)/7, "Marks", "F1T2");
                dataSet.setValue((Integer.parseInt(setF1T3E2.getString(30))/11)/7, "Marks", "F1T3");
                dataSet.setValue((Integer.parseInt(setF2T1E2.getString(30))/11)/7, "Marks", "F2T1");
                dataSet.setValue((Integer.parseInt(setF2T2E2.getString(30))/11)/7, "Marks", "F2T2");
                dataSet.setValue((Integer.parseInt(setF2T3E2.getString(30))/11)/7, "Marks", "F2T3");
                dataSet.setValue(Float.parseFloat(setF3T1E2.getString(43)), "Marks", "F3T1");
                dataSet.setValue(Float.parseFloat(setE2.getString(43)), "Marks", "F3T2");
                dataSet.setValue(0, "Marks", "F3T3");
                dataSet.setValue(0, "Marks", "F4T1");
                dataSet.setValue(0, "Marks", "F4T2");
                dataSet.setValue(0, "Marks", "F4T3");
                PdfContentByte contentByte = writer.getDirectContent();
                PdfTemplate template = contentByte.createTemplate(width, height);
                Graphics2D graphics2d = template.createGraphics(width, height,new DefaultFontMapper());
                Rectangle2D rectangle2d = new Rectangle2D.Double(0, 0, width, height);
                chart.draw(graphics2d, rectangle2d);
                graphics2d.dispose();
                contentByte.addTemplate(template, 30, 275);

                Paragraph classTeacherComments = new Paragraph("Class teacher comments: _________________________________________________________");
                Paragraph classTeacherComments1 = new Paragraph("______________________________________________________________________________");
                Paragraph principalComments =new Paragraph("Principal comments: _____________________________________________________________");
                Paragraph principalComments1 =new Paragraph("______________________________________________________________________________");

                classTeacherComments.setSpacingBefore(170);
                document.add(classTeacherComments);
                document.add(classTeacherComments1);
                document.add(principalComments);
                document.add(principalComments1);
                document.close();
            writer.close();
            infoBox("Document containing exam2 results for " + NAME + " has been created open it for printing.","Done",null);
            Desktop.getDesktop().open(new File(cname+"\\HS Results\\"+NAME+".pdf"));


            }catch (Exception e){
                e.printStackTrace();
                infoBoxError("An error occurred " + e,"Error",null);
            }}else {
            infoBoxError("You are not allowed to print","Error",null);
        }
    }

    private void printPhyGeoBus(String ADM,int POS, String ALL) {
        if(printPassword.toString().equals("vic")) {
            String sqlDetails="SELECT * FROM tbl_students WHERE adm=?";
            String sqlComm = "SELECT * FROM tbl_comments";
            String sqlTotal ="SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='TOTAL'";

            String sqlEx2 = "SELECT * FROM tbl_f3_t2_ex2 WHERE adm=? ";
            String sqlF1T1Ex2 = "SELECT * FROM tbl_f1_t1_ex2 WHERE adm=?";
            String sqlF1T2Ex2 = "SELECT * FROM tbl_f1_t2_ex2 WHERE adm=?";
            String sqlF1T3Ex2 = "SELECT * FROM tbl_f1_t3_ex2 WHERE adm=?";
            String sqlF2T1Ex2 = "SELECT * FROM tbl_f2_t1_ex2 WHERE adm=?";
            String sqlF2T2Ex2 = "SELECT * FROM tbl_f2_t2_ex2 WHERE adm=?";
            String sqlF2T3Ex2 = "SELECT * FROM tbl_f2_t3_ex2 WHERE adm=?";
            String sqlF3T1Ex2 = "SELECT * FROM tbl_f3_t1_ex2 WHERE adm=?";


            String sqlEngTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='English'";
            String sqlKisTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='Kiswahili'";
            String sqlMatTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='Mathematics'";
            String sqlChemTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='Chemistry'";
            String sqlBioTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='Biology'";
            String sqlPhyTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='Physics'";
            String sqlHisTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='History'";
            String sqlGeoTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='Geography'";
            String sqlCreTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='CRE'";
            String sqlBusTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='Business'";
            String sqlAgriTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='Agriculture'";

            String sqlEngGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='ENGLISH'";
            String sqlKisGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='KISWAHILI'";
            String sqlMatGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='MATHEMATICS'";
            String sqlChemGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='CHEMISTRY'";
            String sqlBioGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='BIOLOGY'";
            String sqlPhyGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='PHYSICS'";
            String sqlHisGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='HISTORY'";
            String sqlGeoGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='GEOGRAPHY'";
            String sqlCreGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='CRE'";
            String sqlBusGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='BUSINESS'";
            String sqlAgriGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='AGRICULTURE'";

            try{
                Connection connection = Database.DBConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sqlDetails);

                PreparedStatement statementE2 = connection.prepareStatement(sqlEx2);
                PreparedStatement statementF1T1E2 = connection.prepareStatement(sqlF1T1Ex2);
                PreparedStatement statementF1T2E2 = connection.prepareStatement(sqlF1T2Ex2);
                PreparedStatement statementF1T3E2 = connection.prepareStatement(sqlF1T3Ex2);
                PreparedStatement statementF2T1E2 = connection.prepareStatement(sqlF2T1Ex2);
                PreparedStatement statementF2T2E2 = connection.prepareStatement(sqlF2T2Ex2);
                PreparedStatement statementF2T3E2 = connection.prepareStatement(sqlF2T3Ex2);
                PreparedStatement statementF3T1E2 = connection.prepareStatement(sqlF3T1Ex2);



                statement.setString(1,ADM);

                statementE2.setString(1,ADM);
                statementF1T1E2.setString(1,ADM);
                statementF1T2E2.setString(1,ADM);
                statementF1T3E2.setString(1,ADM);
                statementF2T1E2.setString(1,ADM);
                statementF2T2E2.setString(1,ADM);
                statementF2T3E2.setString(1,ADM);
                statementF3T1E2.setString(1,ADM);


                ResultSet set = statement.executeQuery();

                ResultSet setE2 = statementE2.executeQuery();
                ResultSet setF1T1E2 = statementF1T1E2.executeQuery();
                ResultSet setF1T2E2 = statementF1T2E2.executeQuery();
                ResultSet setF1T3E2 = statementF1T3E2.executeQuery();
                ResultSet setF2T1E2 = statementF2T1E2.executeQuery();
                ResultSet setF2T2E2 = statementF2T2E2.executeQuery();
                ResultSet setF2T3E2 = statementF2T3E2.executeQuery();
                ResultSet setF3T1E2 = statementF3T1E2.executeQuery();


                ResultSet setEngTeacher = connection.createStatement().executeQuery(sqlEngTeacher);
                ResultSet setKisTeacher = connection.createStatement().executeQuery(sqlKisTeacher);
                ResultSet setMatTeacher = connection.createStatement().executeQuery(sqlMatTeacher);
                ResultSet setChemTeacher = connection.createStatement().executeQuery(sqlChemTeacher);
                ResultSet setBioTeacher = connection.createStatement().executeQuery(sqlBioTeacher);
                ResultSet setPhyTeacher = connection.createStatement().executeQuery(sqlPhyTeacher);
                ResultSet setHisTeacher = connection.createStatement().executeQuery(sqlHisTeacher);
                ResultSet setGeoTeacher = connection.createStatement().executeQuery(sqlGeoTeacher);
                ResultSet setCreTeacher = connection.createStatement().executeQuery(sqlCreTeacher);
                ResultSet setBusTeacher = connection.createStatement().executeQuery(sqlBusTeacher);
                ResultSet setAgriTeacher = connection.createStatement().executeQuery(sqlAgriTeacher);

                ResultSet setEngGrade = connection.createStatement().executeQuery(sqlEngGrade);
                ResultSet setKisGrade = connection.createStatement().executeQuery(sqlKisGrade);
                ResultSet setMatGrade = connection.createStatement().executeQuery(sqlMatGrade);
                ResultSet setChemGrade = connection.createStatement().executeQuery(sqlChemGrade);
                ResultSet setBioGrade = connection.createStatement().executeQuery(sqlBioGrade);
                ResultSet setPhyGrade = connection.createStatement().executeQuery(sqlPhyGrade);
                ResultSet setHisGrade = connection.createStatement().executeQuery(sqlHisGrade);
                ResultSet setGeoGrade = connection.createStatement().executeQuery(sqlGeoGrade);
                ResultSet setCreGrade = connection.createStatement().executeQuery(sqlCreGrade);
                ResultSet setBusGrade = connection.createStatement().executeQuery(sqlBusGrade);
                ResultSet setAgriGrade = connection.createStatement().executeQuery(sqlAgriGrade);

                ResultSet setComments = connection.createStatement().executeQuery(sqlComm);
                ResultSet setTotal = connection.createStatement().executeQuery(sqlTotal);

                String names = set.getString(3)+"_"+set.getString(4)+"_"+set.getString(5);

                Document document = new Document(PageSize.A4);
            PdfWriter writer = PdfWriter.getInstance(document,new FileOutputStream(NAME+".pdf"));
            document.open();

                Paragraph schoolName = new Paragraph("SCHOOL NAME", new Font(Font.FontFamily.TIMES_ROMAN, 15,Font.BOLD));
                Paragraph address = new Paragraph("P.O BOX 22332, LOCATION", new Font(Font.FontFamily.TIMES_ROMAN, 15,Font.BOLD));
                Paragraph tell = new Paragraph("PHONE: 073293874", new Font(Font.FontFamily.TIMES_ROMAN, 15,Font.BOLD));
                Paragraph reportType = new Paragraph("Report Form", new Font(Font.FontFamily.TIMES_ROMAN, 10,Font.BOLD));
                schoolName.setAlignment(Element.ALIGN_CENTER);
                address.setAlignment(Element.ALIGN_CENTER);
                tell.setAlignment(Element.ALIGN_CENTER);
                reportType.setAlignment(Element.ALIGN_CENTER);
                document.add(schoolName);
                document.add(address);
                document.add(tell);
                document.add(reportType);

                document.add((new Paragraph("ADM: "+set.getString(2)+"  "+"NAME: "+set.getString(3)+"   "+set.getString(4)+" "+set.getString(5)+"  "+"KCPE:"+set.getString(6)+"  "+"CLASS:FORM 3"+"  "+"TERM:TERM 2",new Font(Font.FontFamily.TIMES_ROMAN, 9,Font.BOLD))));
                document.add((new Paragraph("YEAR:"+now.get(Calendar.YEAR)+" "+"POS:"+String.valueOf(POS+1)+" "+"OUT OF "+ALL,new Font(Font.FontFamily.TIMES_ROMAN, 9,Font.BOLD))));
                document.add((new Paragraph(" ")));

                PdfPTable table = new PdfPTable(7);
                table.setWidthPercentage(105);
                table.setSpacingBefore(0f);
                table.setSpacingAfter(0f);

                float[] colWidth = {1.1f,0.5f,0.5f,0.5f,0.7f,2f,1f};
                table.setWidths(colWidth);
                PdfPCell c1 = new PdfPCell(new Paragraph("SUBJECTS",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell c2 = new PdfPCell(new Paragraph("EX1",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell c3 = new PdfPCell(new Paragraph("EX2",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell c4 = new PdfPCell(new Paragraph("EX3",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell c5 = new PdfPCell(new Paragraph("AVG",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell c6 = new PdfPCell(new Paragraph("COMMENTS",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell c7 = new PdfPCell(new Paragraph("TEACHER",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                table.addCell(c1);
                table.addCell(c2);
                table.addCell(c3);
                table.addCell(c4);
                table.addCell(c5);
                table.addCell(c6);
                table.addCell(c7);

                //set eng results
                String g,com=null;
                PdfPCell engD1 = new PdfPCell(new Paragraph("English"));
                PdfPCell engD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell engD3 = new PdfPCell(new Paragraph(setE2.getString(8)+" "+setE2.getString(9)));
                PdfPCell engD4 = new PdfPCell(new Paragraph(" "));

                int avgE= Integer.parseInt(setE2.getString(8));
                if (avgE >= Integer.parseInt(setEngGrade.getString(4))) {com = setComments.getString(2); } else if (avgE >= Integer.parseInt(setEngGrade.getString(5))) { com = setComments.getString(3); }else if (avgE >=Integer.parseInt(setEngGrade.getString(6))){ com = setComments.getString(4);}else if (avgE >=Integer.parseInt(setEngGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgE >=Integer.parseInt(setEngGrade.getString(8))){  com = setComments.getString(6); }else if (avgE >=Integer.parseInt(setEngGrade.getString(9))){ com = setComments.getString(7); }else if (avgE >=Integer.parseInt(setEngGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgE >=Integer.parseInt(setEngGrade.getString(11))){ com = setComments.getString(9);}else if (avgE >=Integer.parseInt(setEngGrade.getString(12))){ com = setComments.getString(10);}else if (avgE >=Integer.parseInt(setEngGrade.getString(13))){ com = setComments.getString(11);}else if (avgE >=Integer.parseInt(setEngGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }
                PdfPCell engD5 = new PdfPCell(new Paragraph(setE2.getString(8)+" "+setE2.getString(9)));
                PdfPCell engD6 = new PdfPCell(new Paragraph(com));
                PdfPCell engD7 = new PdfPCell(new Paragraph(setEngTeacher.getString(6)));
                table.addCell(engD1);
                table.addCell(engD2);
                table.addCell(engD3);
                table.addCell(engD4);
                table.addCell(engD5);
                table.addCell(engD6);
                table.addCell(engD7);

                //set kis results
                PdfPCell kisD1 = new PdfPCell(new Paragraph("Kiswahili"));
                PdfPCell kisD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell kisD3 = new PdfPCell(new Paragraph(setE2.getString(11)+" "+setE2.getString(12)));
                PdfPCell kisD4 = new PdfPCell(new Paragraph(" "));

                int avgKis= Integer.parseInt(setE2.getString(11));
                if (avgKis >= Integer.parseInt(setKisGrade.getString(4))) {com = setComments.getString(2); } else if (avgKis >= Integer.parseInt(setKisGrade.getString(5))) { com = setComments.getString(3); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(6))){ com = setComments.getString(4);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(8))){  com = setComments.getString(6); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(9))){ com = setComments.getString(7); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgKis >=Integer.parseInt(setKisGrade.getString(11))){ com = setComments.getString(9);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(12))){ com = setComments.getString(10);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(13))){ com = setComments.getString(11);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }
                PdfPCell kisD5 = new PdfPCell(new Paragraph(setE2.getString(11)+" "+setE2.getString(12)));
                PdfPCell kisD6 = new PdfPCell(new Paragraph(com));
                PdfPCell kisD7 = new PdfPCell(new Paragraph(setKisTeacher.getString(6)));
                table.addCell(kisD1);
                table.addCell(kisD2);
                table.addCell(kisD3);
                table.addCell(kisD4);
                table.addCell(kisD5);
                table.addCell(kisD6);
                table.addCell(kisD7);

                //set mat results

                PdfPCell matD1 = new PdfPCell(new Paragraph("Mathematics"));
                PdfPCell matD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell matD3 = new PdfPCell(new Paragraph(setE2.getString(14)+" "+setE2.getString(15)));
                PdfPCell matD4 = new PdfPCell(new Paragraph(" "));

                int avgMat = Integer.parseInt(setE2.getString(14));
                if (avgMat >= Integer.parseInt(setMatGrade.getString(4))) {com = setComments.getString(2); } else if (avgMat >= Integer.parseInt(setMatGrade.getString(5))) { com = setComments.getString(3); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(6))){ com = setComments.getString(4);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(8))){  com = setComments.getString(6); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(9))){ com = setComments.getString(7); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgMat >=Integer.parseInt(setMatGrade.getString(11))){ com = setComments.getString(9);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(12))){ com = setComments.getString(10);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(13))){ com = setComments.getString(11);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell matD5 = new PdfPCell(new Paragraph(setE2.getString(14)+" "+setE2.getString(15)));
                PdfPCell matD6 = new PdfPCell(new Paragraph(com));
                PdfPCell matD7 = new PdfPCell(new Paragraph(setMatTeacher.getString(6)));
                table.addCell(matD1);
                table.addCell(matD2);
                table.addCell(matD3);
                table.addCell(matD4);
                table.addCell(matD5);
                table.addCell(matD6);
                table.addCell(matD7);

                //set Chemistry results
                PdfPCell chemD1 = new PdfPCell(new Paragraph("Chemistry"));
                PdfPCell chemD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell chemD3 = new PdfPCell(new Paragraph(setE2.getString(20)+" "+setE2.getString(21)));
                PdfPCell chemD4 = new PdfPCell(new Paragraph(" "));

                int avgChem = Integer.parseInt(setE2.getString(20));
                if (avgChem >= Integer.parseInt(setChemGrade.getString(4))) {com = setComments.getString(2); } else if (avgChem >= Integer.parseInt(setChemGrade.getString(5))) { com = setComments.getString(3); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(6))){ com = setComments.getString(4);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(8))){  com = setComments.getString(6); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(9))){ com = setComments.getString(7); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgChem >=Integer.parseInt(setChemGrade.getString(11))){ com = setComments.getString(9);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(12))){ com = setComments.getString(10);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(13))){ com = setComments.getString(11);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell chemD5 = new PdfPCell(new Paragraph(setE2.getString(20)+" "+setE2.getString(21)));
                PdfPCell chemD6 = new PdfPCell(new Paragraph(com));
                PdfPCell chemD7 = new PdfPCell(new Paragraph(setChemTeacher.getString(6)));
                table.addCell(chemD1);
                table.addCell(chemD2);
                table.addCell(chemD3);
                table.addCell(chemD4);
                table.addCell(chemD5);
                table.addCell(chemD6);
                table.addCell(chemD7);

                //set Physics Results
                PdfPCell phyD1 = new PdfPCell(new Paragraph("Physics"));
                PdfPCell phyD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell phyD3 = new PdfPCell(new Paragraph(setE2.getString(23)+" "+setE2.getString(24)));
                PdfPCell phyD4 = new PdfPCell(new Paragraph(" "));

                int avgPhy = Integer.parseInt(setE2.getString(23));
                if (avgPhy >= Integer.parseInt(setPhyGrade.getString(4))) {com = setComments.getString(2); } else if (avgPhy >= Integer.parseInt(setPhyGrade.getString(5))) { com = setComments.getString(3); }else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(6))){ com = setComments.getString(4);}else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(8))){  com = setComments.getString(6); }else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(9))){ com = setComments.getString(7); }else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(11))){ com = setComments.getString(9);}else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(12))){ com = setComments.getString(10);}else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(13))){ com = setComments.getString(11);}else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell phyD5 = new PdfPCell(new Paragraph(setE2.getString(23)+" "+setE2.getString(24)));
                PdfPCell phyD6 = new PdfPCell(new Paragraph(com));
                PdfPCell phyD7 = new PdfPCell(new Paragraph(setPhyTeacher.getString(6)));
                table.addCell(phyD1);
                table.addCell(phyD2);
                table.addCell(phyD3);
                table.addCell(phyD4);
                table.addCell(phyD5);
                table.addCell(phyD6);
                table.addCell(phyD7);

                //set Geography results
                PdfPCell geoD1 = new PdfPCell(new Paragraph("Geography"));
                PdfPCell geoD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell geoD3 = new PdfPCell(new Paragraph(setE2.getString(26)+" "+setE2.getString(27)));
                PdfPCell geoD4 = new PdfPCell(new Paragraph(" "));

                int avgGeo = Integer.parseInt(setE2.getString(26));
                if (avgGeo >= Integer.parseInt(setGeoGrade.getString(4))) {com = setComments.getString(2); } else if (avgGeo >= Integer.parseInt(setGeoGrade.getString(5))) { com = setComments.getString(3); }else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(6))){ com = setComments.getString(4);}else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(8))){  com = setComments.getString(6); }else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(9))){ com = setComments.getString(7); }else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(11))){ com = setComments.getString(9);}else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(12))){ com = setComments.getString(10);}else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(13))){ com = setComments.getString(11);}else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell geoD5 = new PdfPCell(new Paragraph(setE2.getString(26)+" "+setE2.getString(27)));
                PdfPCell geoD6 = new PdfPCell(new Paragraph(com));
                PdfPCell geoD7 = new PdfPCell(new Paragraph(setGeoTeacher.getString(6)));
                table.addCell(geoD1);
                table.addCell(geoD2);
                table.addCell(geoD3);
                table.addCell(geoD4);
                table.addCell(geoD5);
                table.addCell(geoD6);
                table.addCell(geoD7);

                //set Business results
                PdfPCell busD1 = new PdfPCell(new Paragraph("Business"));
                PdfPCell busD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell busD3 = new PdfPCell(new Paragraph(setE2.getString(35)+" "+setE2.getString(36)));
                PdfPCell busD4 = new PdfPCell(new Paragraph(" "));

                int avgBus = Integer.parseInt(setE2.getString(35));
                if (avgBus >= Integer.parseInt(setBusGrade.getString(4))) {com = setComments.getString(2); } else if (avgBus >= Integer.parseInt(setBusGrade.getString(5))) { com = setComments.getString(3); }else if (avgBus >=Integer.parseInt(setBusGrade.getString(6))){ com = setComments.getString(4);}else if (avgBus >=Integer.parseInt(setBusGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgBus >=Integer.parseInt(setBusGrade.getString(8))){  com = setComments.getString(6); }else if (avgBus >=Integer.parseInt(setBusGrade.getString(9))){ com = setComments.getString(7); }else if (avgBus >=Integer.parseInt(setBusGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgBus >=Integer.parseInt(setBusGrade.getString(11))){ com = setComments.getString(9);}else if (avgBus >=Integer.parseInt(setBusGrade.getString(12))){ com = setComments.getString(10);}else if (avgBus >=Integer.parseInt(setBusGrade.getString(13))){ com = setComments.getString(11);}else if (avgBus >=Integer.parseInt(setBusGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell busD5 = new PdfPCell(new Paragraph(setE2.getString(35)+" "+setE2.getString(36)));
                PdfPCell busD6 = new PdfPCell(new Paragraph(com));
                PdfPCell busD7 = new PdfPCell(new Paragraph(setBusTeacher.getString(6)));
                table.addCell(busD1);
                table.addCell(busD2);
                table.addCell(busD3);
                table.addCell(busD4);
                table.addCell(busD5);
                table.addCell(busD6);
                table.addCell(busD7);

                //set total results

                int totalE2 = Integer.parseInt(setE2.getString(41));



                PdfPCell totalD1 = new PdfPCell(new Paragraph("Total"));
                PdfPCell totalD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell totalD3 = new PdfPCell(new Paragraph(String.valueOf(totalE2)));
                PdfPCell totalD4 = new PdfPCell(new Paragraph(" "));
                PdfPCell totalD5 = new PdfPCell(new Paragraph(" "));
                PdfPCell totalD6 = new PdfPCell(new Paragraph(""));
                PdfPCell totalD7 = new PdfPCell(new Paragraph(""));
                table.addCell(totalD1);
                table.addCell(totalD2);
                table.addCell(totalD3);
                table.addCell(totalD4);
                table.addCell(totalD5);
                table.addCell(totalD6);
                table.addCell(totalD7);

                //set average results

                //int add2AvgEx1 = (Math.addExact(totalEx1Mat,addAvgEx1))/3;

                int addAvgEx2 = Math.round(totalE2/7);
                //int add2AvgEx2 = (Math.addExact(totalEx2Mat,addAvgEx2))/3;


                //int add2AvgEx3 = (Math.addExact(totalEx3Mat,addAvgEx3))/3;


                PdfPCell avgD1 = new PdfPCell(new Paragraph("Average"));
                PdfPCell avgD2 = new PdfPCell(new Paragraph(" "));
                if (addAvgEx2 >= Integer.parseInt(setTotal.getString(4))) {g = "A"; } else if (addAvgEx2 >= Integer.parseInt(setTotal.getString(5))) { g = "A-"; }else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(6))){ g = "B+";}else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(7))){
                    g = "B"; }else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(8))){  g = "B-"; }else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(9))){ g = "C+"; }else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(10))){ g = "C";
                }else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(11))){ g = "C-";}else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(12))){ g = "D+";}else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(13))){ g = "D";}else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(14))){
                    g = "D-";}else {g="E"; }
                PdfPCell avgD3 = new PdfPCell(new Paragraph(String.valueOf(addAvgEx2)+" "+g));


                PdfPCell avgD4 = new PdfPCell(new Paragraph(" "));

                //float avgAvgTotal = (addAvgEx1+addAvgEx2+addAvgEx3)/3;
                int avgAvgTotal=Integer.parseInt(setE2.getString(41))/7;

                if (avgAvgTotal >= Integer.parseInt(setTotal.getString(4))) {g = "A"; } else if (avgAvgTotal >= Integer.parseInt(setTotal.getString(5))) { g = "A-"; }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(6))){ g = "B+";}else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(7))){
                    g = "B"; }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(8))){  g = "B-"; }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(9))){ g = "C+"; }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(10))){ g = "C";
                }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(11))){ g = "C-";}else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(12))){ g = "D+";}else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(13))){ g = "D";}else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(14))){
                    g = "D-";}else {g="E"; }

                PdfPCell avgD5 = new PdfPCell(new Paragraph(String.valueOf(Math.round(avgAvgTotal))+" "+g));
                PdfPCell avgD6 = new PdfPCell(new Paragraph(""));
                PdfPCell avgD7 = new PdfPCell(new Paragraph(""));
                table.addCell(avgD1);
                table.addCell(avgD2);
                table.addCell(avgD3);
                table.addCell(avgD4);
                table.addCell(avgD5);
                table.addCell(avgD6);
                table.addCell(avgD7);

                document.add(table);

                Paragraph labelSummary = new Paragraph("PERFORMANCE TREND",new Font(Font.FontFamily.TIMES_ROMAN, 8,Font.BOLD));
                labelSummary.setSpacingBefore(0);
                labelSummary.setSpacingAfter(5);
                labelSummary.setAlignment(Element.ALIGN_CENTER);
                document.add(labelSummary);

                PdfPTable tableLastSummary = new PdfPTable(8);
                tableLastSummary.setWidthPercentage(105);
                tableLastSummary.setSpacingBefore(0f);
                tableLastSummary.setSpacingAfter(0f);

                float[] colWidthSummary = {0.5f,0.5f,0.5f,0.5f,0.5f,0.5f,0.5f,0.5f};
                tableLastSummary.setWidths(colWidthSummary);
                PdfPCell cS1 = new PdfPCell(new Paragraph("FORM 1",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell cS2 = new PdfPCell(new Paragraph(" ",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell cS3 = new PdfPCell(new Paragraph("FORM 2",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell cS4 = new PdfPCell(new Paragraph(" ",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell cS5 = new PdfPCell(new Paragraph("FORM 3",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell cS6 = new PdfPCell(new Paragraph(" ",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell cS7 = new PdfPCell(new Paragraph("FORM 4",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell cS8 = new PdfPCell(new Paragraph(" ",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                tableLastSummary.addCell(cS1);
                tableLastSummary.addCell(cS2);
                tableLastSummary.addCell(cS3);
                tableLastSummary.addCell(cS4);
                tableLastSummary.addCell(cS5);
                tableLastSummary.addCell(cS6);
                tableLastSummary.addCell(cS7);
                tableLastSummary.addCell(cS8);

                PdfPCell f1t1 = new PdfPCell(new Paragraph("F1T1"));
                PdfPCell f1t1m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF1T1E2.getString(30)))/11)+" "+setF1T1E2.getString(31)));
                PdfPCell f2t1 = new PdfPCell(new Paragraph("F2T1"));
                PdfPCell f2t1m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF2T1E2.getString(30)))/11)+" "+setF2T1E2.getString(31)));
                PdfPCell f3t1 = new PdfPCell(new Paragraph("F3T1"));
                PdfPCell f3t1m = new PdfPCell(new Paragraph(String.valueOf(Integer.parseInt(setF3T1E2.getString(41))/11)+" "+setF3T1E2.getString(43)+" "+setF3T1E2.getString(42)));
                PdfPCell f4t1 = new PdfPCell(new Paragraph("F4T1"));
                PdfPCell f4t1m = new PdfPCell(new Paragraph(" "));
                tableLastSummary.addCell(f1t1);
                tableLastSummary.addCell(f1t1m);
                tableLastSummary.addCell(f2t1);
                tableLastSummary.addCell(f2t1m);
                tableLastSummary.addCell(f3t1);
                tableLastSummary.addCell(f3t1m);
                tableLastSummary.addCell(f4t1);
                tableLastSummary.addCell(f4t1m);

                PdfPCell f1t2 = new PdfPCell(new Paragraph("F1T2"));
                PdfPCell f1t2m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF1T2E2.getString(30)))/11)+" "+setF1T2E2.getString(31)));
                PdfPCell f2t2 = new PdfPCell(new Paragraph("F2T2"));
                PdfPCell f2t2m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF2T2E2.getString(30)))/11)+" "+setF2T2E2.getString(31)));
                PdfPCell f3t2 = new PdfPCell(new Paragraph("F3T2"));
                PdfPCell f3t2m = new PdfPCell(new Paragraph(String.valueOf(avgAvgTotal)+" "+setE2.getString(42)+" "+setE2.getString(43)));
                PdfPCell f4t2 = new PdfPCell(new Paragraph("F4T2"));
                PdfPCell f4t2m = new PdfPCell(new Paragraph(" "));
                tableLastSummary.addCell(f1t2);
                tableLastSummary.addCell(f1t2m);
                tableLastSummary.addCell(f2t2);
                tableLastSummary.addCell(f2t2m);
                tableLastSummary.addCell(f3t2);
                tableLastSummary.addCell(f3t2m);
                tableLastSummary.addCell(f4t2);
                tableLastSummary.addCell(f4t2m);

                PdfPCell f1t3 = new PdfPCell(new Paragraph("F1T3"));
                PdfPCell f1t3m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF1T3E2.getString(30)))/11)+" "+setF1T3E2.getString(31)));
                PdfPCell f2t3 = new PdfPCell(new Paragraph("F2T3"));
                PdfPCell f2t3m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF2T3E2.getString(30)))/11)+" "+setF2T3E2.getString(31)));
                PdfPCell f3t3 = new PdfPCell(new Paragraph("F3T3"));
                PdfPCell f3t3m = new PdfPCell(new Paragraph(" "));
                PdfPCell f4t3 = new PdfPCell(new Paragraph("F4T3"));
                PdfPCell f4t3m = new PdfPCell(new Paragraph(" "));
                tableLastSummary.addCell(f1t3);
                tableLastSummary.addCell(f1t3m);
                tableLastSummary.addCell(f2t3);
                tableLastSummary.addCell(f2t3m);
                tableLastSummary.addCell(f3t3);
                tableLastSummary.addCell(f3t3m);
                tableLastSummary.addCell(f4t3);
                tableLastSummary.addCell(f4t3m);

                document.add(tableLastSummary);
            /*
            * logo
            * */
                Image img = Image.getInstance(cname+"\\HS Results\\Web-Development.png");
                img.scaleAbsolute(100,50);
                img.setAbsolutePosition(30,750);
                document.add(img);

            /*
            * chart
            * */
                DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
                JFreeChart chart = ChartFactory.createBarChart(
                        "", "", "Marks",
                        dataSet, PlotOrientation.VERTICAL, false, false, false);
                int width=500; /* Width of our chart */
                int height=150; /* Height of our chart */
/* Get instance of CategoryPlot */
                CategoryPlot plot = chart.getCategoryPlot();
                BarRenderer renderer = (BarRenderer) plot.getRenderer();
                renderer.setSeriesPaint(0, Color.black);
                dataSet.setValue((Integer.parseInt(setF1T1E2.getString(30))/11)/7, "Marks", "F1T1");
                dataSet.setValue((Integer.parseInt(setF1T2E2.getString(30))/11)/7, "Marks", "F1T2");
                dataSet.setValue((Integer.parseInt(setF1T3E2.getString(30))/11)/7, "Marks", "F1T3");
                dataSet.setValue((Integer.parseInt(setF2T1E2.getString(30))/11)/7, "Marks", "F2T1");
                dataSet.setValue((Integer.parseInt(setF2T2E2.getString(30))/11)/7, "Marks", "F2T2");
                dataSet.setValue((Integer.parseInt(setF2T3E2.getString(30))/11)/7, "Marks", "F2T3");
                dataSet.setValue(Float.parseFloat(setF3T1E2.getString(43)), "Marks", "F3T1");
                dataSet.setValue(Float.parseFloat(setE2.getString(43)), "Marks", "F3T2");
                dataSet.setValue(0, "Marks", "F3T3");
                dataSet.setValue(0, "Marks", "F4T1");
                dataSet.setValue(0, "Marks", "F4T2");
                dataSet.setValue(0, "Marks", "F4T3");
                PdfContentByte contentByte = writer.getDirectContent();
                PdfTemplate template = contentByte.createTemplate(width, height);
                Graphics2D graphics2d = template.createGraphics(width, height,new DefaultFontMapper());
                Rectangle2D rectangle2d = new Rectangle2D.Double(0, 0, width, height);
                chart.draw(graphics2d, rectangle2d);
                graphics2d.dispose();
                contentByte.addTemplate(template, 30, 275);

                Paragraph classTeacherComments = new Paragraph("Class teacher comments: _________________________________________________________");
                Paragraph classTeacherComments1 = new Paragraph("______________________________________________________________________________");
                Paragraph principalComments =new Paragraph("Principal comments: _____________________________________________________________");
                Paragraph principalComments1 =new Paragraph("______________________________________________________________________________");

                classTeacherComments.setSpacingBefore(170);
                document.add(classTeacherComments);
                document.add(classTeacherComments1);
                document.add(principalComments);
                document.add(principalComments1);
                document.close();
            writer.close();
            infoBox("Document containing exam2 results for " + NAME + " has been created open it for printing.","Done",null);
            Desktop.getDesktop().open(new File(cname+"\\HS Results\\"+NAME+".pdf"));


            }catch (Exception e){
                e.printStackTrace();
                infoBoxError("An error occurred " + e,"Error",null);
            }}else {
            infoBoxError("You are not allowed to print","Error",null);
        }
    }

    private void printAllSubjects(String ADM,int POS, String ALL) {
        if(printPassword.toString().equals("vic")) {
            String sqlDetails="SELECT * FROM tbl_students WHERE adm=?";
            String sqlComm = "SELECT * FROM tbl_comments";
            String sqlTotal ="SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='TOTAL'";

            String sqlEx2 = "SELECT * FROM tbl_f3_t2_ex2 WHERE adm=? ";
            String sqlF1T1Ex2 = "SELECT * FROM tbl_f1_t1_ex2 WHERE adm=?";
            String sqlF1T2Ex2 = "SELECT * FROM tbl_f1_t2_ex2 WHERE adm=?";
            String sqlF1T3Ex2 = "SELECT * FROM tbl_f1_t3_ex2 WHERE adm=?";
            String sqlF2T1Ex2 = "SELECT * FROM tbl_f2_t1_ex2 WHERE adm=?";
            String sqlF2T2Ex2 = "SELECT * FROM tbl_f2_t2_ex2 WHERE adm=?";
            String sqlF2T3Ex2 = "SELECT * FROM tbl_f2_t3_ex2 WHERE adm=?";
            String sqlF3T1Ex2 = "SELECT * FROM tbl_f3_t1_ex2 WHERE adm=?";



            String sqlEngTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='English'";
            String sqlKisTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='Kiswahili'";
            String sqlMatTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='Mathematics'";
            String sqlChemTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='Chemistry'";
            String sqlBioTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='Biology'";
            String sqlPhyTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='Physics'";
            String sqlHisTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='History'";
            String sqlGeoTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='Geography'";
            String sqlCreTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='CRE'";
            String sqlBusTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='Business'";
            String sqlAgriTeacher = "SELECT * FROM tbl_teacher WHERE class='FORM_1' AND subject='Agriculture'";

            String sqlEngGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='ENGLISH'";
            String sqlKisGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='KISWAHILI'";
            String sqlMatGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='MATHEMATICS'";
            String sqlChemGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='CHEMISTRY'";
            String sqlBioGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='BIOLOGY'";
            String sqlPhyGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='PHYSICS'";
            String sqlHisGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='HISTORY'";
            String sqlGeoGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='GEOGRAPHY'";
            String sqlCreGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='CRE'";
            String sqlBusGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='BUSINESS'";
            String sqlAgriGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='AGRICULTURE'";

            try{
                Connection connection = Database.DBConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sqlDetails);

                PreparedStatement statementE2 = connection.prepareStatement(sqlEx2);
                PreparedStatement statementF1T1E2 = connection.prepareStatement(sqlF1T1Ex2);
                PreparedStatement statementF1T2E2 = connection.prepareStatement(sqlF1T2Ex2);
                PreparedStatement statementF1T3E2 = connection.prepareStatement(sqlF1T3Ex2);
                PreparedStatement statementF2T1E2 = connection.prepareStatement(sqlF2T1Ex2);
                PreparedStatement statementF2T2E2 = connection.prepareStatement(sqlF2T2Ex2);
                PreparedStatement statementF2T3E2 = connection.prepareStatement(sqlF2T3Ex2);
                PreparedStatement statementF3T1E2 = connection.prepareStatement(sqlF3T1Ex2);




                statement.setString(1,ADM);

                statementE2.setString(1,ADM);
                statementF1T1E2.setString(1,ADM);
                statementF1T2E2.setString(1,ADM);
                statementF1T3E2.setString(1,ADM);
                statementF2T1E2.setString(1,ADM);
                statementF2T2E2.setString(1,ADM);
                statementF2T3E2.setString(1,ADM);
                statementF3T1E2.setString(1,ADM);



                ResultSet set = statement.executeQuery();

                ResultSet setE2 = statementE2.executeQuery();
                ResultSet setF1T1E2 = statementF1T1E2.executeQuery();
                ResultSet setF1T2E2 = statementF1T2E2.executeQuery();
                ResultSet setF1T3E2 = statementF1T3E2.executeQuery();
                ResultSet setF2T1E2 = statementF2T1E2.executeQuery();
                ResultSet setF2T2E2 = statementF2T2E2.executeQuery();
                ResultSet setF2T3E2 = statementF2T3E2.executeQuery();
                ResultSet setF3T1E2 = statementF3T1E2.executeQuery();



                ResultSet setEngTeacher = connection.createStatement().executeQuery(sqlEngTeacher);
                ResultSet setKisTeacher = connection.createStatement().executeQuery(sqlKisTeacher);
                ResultSet setMatTeacher = connection.createStatement().executeQuery(sqlMatTeacher);
                ResultSet setChemTeacher = connection.createStatement().executeQuery(sqlChemTeacher);
                ResultSet setBioTeacher = connection.createStatement().executeQuery(sqlBioTeacher);
                ResultSet setPhyTeacher = connection.createStatement().executeQuery(sqlPhyTeacher);
                ResultSet setHisTeacher = connection.createStatement().executeQuery(sqlHisTeacher);
                ResultSet setGeoTeacher = connection.createStatement().executeQuery(sqlGeoTeacher);
                ResultSet setCreTeacher = connection.createStatement().executeQuery(sqlCreTeacher);
                ResultSet setBusTeacher = connection.createStatement().executeQuery(sqlBusTeacher);
                ResultSet setAgriTeacher = connection.createStatement().executeQuery(sqlAgriTeacher);

                ResultSet setEngGrade = connection.createStatement().executeQuery(sqlEngGrade);
                ResultSet setKisGrade = connection.createStatement().executeQuery(sqlKisGrade);
                ResultSet setMatGrade = connection.createStatement().executeQuery(sqlMatGrade);
                ResultSet setChemGrade = connection.createStatement().executeQuery(sqlChemGrade);
                ResultSet setBioGrade = connection.createStatement().executeQuery(sqlBioGrade);
                ResultSet setPhyGrade = connection.createStatement().executeQuery(sqlPhyGrade);
                ResultSet setHisGrade = connection.createStatement().executeQuery(sqlHisGrade);
                ResultSet setGeoGrade = connection.createStatement().executeQuery(sqlGeoGrade);
                ResultSet setCreGrade = connection.createStatement().executeQuery(sqlCreGrade);
                ResultSet setBusGrade = connection.createStatement().executeQuery(sqlBusGrade);
                ResultSet setAgriGrade = connection.createStatement().executeQuery(sqlAgriGrade);

                ResultSet setComments = connection.createStatement().executeQuery(sqlComm);
                ResultSet setTotal = connection.createStatement().executeQuery(sqlTotal);

                String names = set.getString(3)+"_"+set.getString(4)+"_"+set.getString(5);

                Document document = new Document(PageSize.A4);
            PdfWriter writer = PdfWriter.getInstance(document,new FileOutputStream(NAME+".pdf"));
            document.open();

                Paragraph schoolName = new Paragraph("SCHOOL NAME", new Font(Font.FontFamily.TIMES_ROMAN, 10,Font.BOLD));
                Paragraph address = new Paragraph("P.O BOX 22332, LOCATION", new Font(Font.FontFamily.TIMES_ROMAN, 10,Font.BOLD));
                Paragraph tell = new Paragraph("PHONE: 073293874", new Font(Font.FontFamily.TIMES_ROMAN, 10,Font.BOLD));
                Paragraph reportType = new Paragraph("Report Form", new Font(Font.FontFamily.TIMES_ROMAN, 10,Font.BOLD));
                schoolName.setAlignment(Element.ALIGN_CENTER);
                address.setAlignment(Element.ALIGN_CENTER);
                tell.setAlignment(Element.ALIGN_CENTER);
                reportType.setAlignment(Element.ALIGN_CENTER);
                document.add(schoolName);
                document.add(address);
                document.add(tell);
                document.add(reportType);

                document.add((new Paragraph("ADM: "+set.getString(2)+"  "+"NAME: "+set.getString(3)+"   "+set.getString(4)+" "+set.getString(5)+"  "+"KCPE:"+set.getString(6)+"  "+"CLASS:FORM 3"+"  "+"TERM:TERM 2",new Font(Font.FontFamily.TIMES_ROMAN, 9,Font.BOLD))));
                document.add((new Paragraph("YEAR:"+now.get(Calendar.YEAR)+" "+"POS:"+String.valueOf(POS+1)+" "+"OUT OF "+ALL,new Font(Font.FontFamily.TIMES_ROMAN, 9,Font.BOLD))));
                document.add((new Paragraph(" ")));

                PdfPTable table = new PdfPTable(7);
                table.setWidthPercentage(105);
                table.setSpacingBefore(0f);
                table.setSpacingAfter(0f);

                float[] colWidth = {1.1f,0.5f,0.5f,0.5f,0.7f,2f,1f};
                table.setWidths(colWidth);
                PdfPCell c1 = new PdfPCell(new Paragraph("SUBJECTS",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell c2 = new PdfPCell(new Paragraph("EX1",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell c3 = new PdfPCell(new Paragraph("EX2",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell c4 = new PdfPCell(new Paragraph("EX3",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell c5 = new PdfPCell(new Paragraph("AVG",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell c6 = new PdfPCell(new Paragraph("COMMENTS",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell c7 = new PdfPCell(new Paragraph("TEACHER",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                table.addCell(c1);
                table.addCell(c2);
                table.addCell(c3);
                table.addCell(c4);
                table.addCell(c5);
                table.addCell(c6);
                table.addCell(c7);

                Font font =  new Font(Font.FontFamily.HELVETICA, 9, Font.NORMAL);
                //set eng results
                String g,com=null;
                PdfPCell engD1 = new PdfPCell(new Paragraph("English",font));
                PdfPCell engD2 = new PdfPCell(new Paragraph(" ",font));
                PdfPCell engD3 = new PdfPCell(new Paragraph(setE2.getString(8)+" "+setE2.getString(9),font));
                PdfPCell engD4 = new PdfPCell(new Paragraph(" ",font));

                int avgE= Integer.parseInt(setE2.getString(8));
                if (avgE >= Integer.parseInt(setEngGrade.getString(4))) {com = setComments.getString(2); } else if (avgE >= Integer.parseInt(setEngGrade.getString(5))) { com = setComments.getString(3); }else if (avgE >=Integer.parseInt(setEngGrade.getString(6))){ com = setComments.getString(4);}else if (avgE >=Integer.parseInt(setEngGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgE >=Integer.parseInt(setEngGrade.getString(8))){  com = setComments.getString(6); }else if (avgE >=Integer.parseInt(setEngGrade.getString(9))){ com = setComments.getString(7); }else if (avgE >=Integer.parseInt(setEngGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgE >=Integer.parseInt(setEngGrade.getString(11))){ com = setComments.getString(9);}else if (avgE >=Integer.parseInt(setEngGrade.getString(12))){ com = setComments.getString(10);}else if (avgE >=Integer.parseInt(setEngGrade.getString(13))){ com = setComments.getString(11);}else if (avgE >=Integer.parseInt(setEngGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }
                PdfPCell engD5 = new PdfPCell(new Paragraph(setE2.getString(8)+" "+setE2.getString(9),font));
                PdfPCell engD6 = new PdfPCell(new Paragraph(com,font));
                PdfPCell engD7 = new PdfPCell(new Paragraph(setEngTeacher.getString(6),font));
                table.addCell(engD1);
                table.addCell(engD2);
                table.addCell(engD3);
                table.addCell(engD4);
                table.addCell(engD5);
                table.addCell(engD6);
                table.addCell(engD7);

                //set kis results
                PdfPCell kisD1 = new PdfPCell(new Paragraph("Kiswahili",font));
                PdfPCell kisD2 = new PdfPCell(new Paragraph(" ",font));
                PdfPCell kisD3 = new PdfPCell(new Paragraph(setE2.getString(11)+" "+setE2.getString(12),font));
                PdfPCell kisD4 = new PdfPCell(new Paragraph(" ",font));

                int avgKis= Integer.parseInt(setE2.getString(11));
                if (avgKis >= Integer.parseInt(setKisGrade.getString(4))) {com = setComments.getString(2); } else if (avgKis >= Integer.parseInt(setKisGrade.getString(5))) { com = setComments.getString(3); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(6))){ com = setComments.getString(4);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(8))){  com = setComments.getString(6); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(9))){ com = setComments.getString(7); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgKis >=Integer.parseInt(setKisGrade.getString(11))){ com = setComments.getString(9);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(12))){ com = setComments.getString(10);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(13))){ com = setComments.getString(11);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }
                PdfPCell kisD5 = new PdfPCell(new Paragraph(setE2.getString(11)+" "+setE2.getString(12),font));
                PdfPCell kisD6 = new PdfPCell(new Paragraph(com,font));
                PdfPCell kisD7 = new PdfPCell(new Paragraph(setKisTeacher.getString(6),font));
                table.addCell(kisD1);
                table.addCell(kisD2);
                table.addCell(kisD3);
                table.addCell(kisD4);
                table.addCell(kisD5);
                table.addCell(kisD6);
                table.addCell(kisD7);

                //set mat results

                PdfPCell matD1 = new PdfPCell(new Paragraph("Mathematics",font));
                PdfPCell matD2 = new PdfPCell(new Paragraph(" ",font));
                PdfPCell matD3 = new PdfPCell(new Paragraph(setE2.getString(14)+" "+setE2.getString(15),font));
                PdfPCell matD4 = new PdfPCell(new Paragraph(" ",font));

                int avgMat = Integer.parseInt(setE2.getString(14));
                if (avgMat >= Integer.parseInt(setMatGrade.getString(4))) {com = setComments.getString(2); } else if (avgMat >= Integer.parseInt(setMatGrade.getString(5))) { com = setComments.getString(3); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(6))){ com = setComments.getString(4);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(8))){  com = setComments.getString(6); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(9))){ com = setComments.getString(7); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgMat >=Integer.parseInt(setMatGrade.getString(11))){ com = setComments.getString(9);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(12))){ com = setComments.getString(10);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(13))){ com = setComments.getString(11);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell matD5 = new PdfPCell(new Paragraph(setE2.getString(14)+" "+setE2.getString(15),font));
                PdfPCell matD6 = new PdfPCell(new Paragraph(com,font));
                PdfPCell matD7 = new PdfPCell(new Paragraph(setMatTeacher.getString(6),font));
                table.addCell(matD1);
                table.addCell(matD2);
                table.addCell(matD3);
                table.addCell(matD4);
                table.addCell(matD5);
                table.addCell(matD6);
                table.addCell(matD7);

                //set Chemistry results
                PdfPCell chemD1 = new PdfPCell(new Paragraph("Chemistry",font));
                PdfPCell chemD2 = new PdfPCell(new Paragraph(" ",font));
                PdfPCell chemD3 = new PdfPCell(new Paragraph(setE2.getString(20)+" "+setE2.getString(21),font));
                PdfPCell chemD4 = new PdfPCell(new Paragraph(" ",font));

                int avgChem = Integer.parseInt(setE2.getString(20));
                if (avgChem >= Integer.parseInt(setChemGrade.getString(4))) {com = setComments.getString(2); } else if (avgChem >= Integer.parseInt(setChemGrade.getString(5))) { com = setComments.getString(3); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(6))){ com = setComments.getString(4);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(8))){  com = setComments.getString(6); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(9))){ com = setComments.getString(7); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgChem >=Integer.parseInt(setChemGrade.getString(11))){ com = setComments.getString(9);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(12))){ com = setComments.getString(10);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(13))){ com = setComments.getString(11);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell chemD5 = new PdfPCell(new Paragraph(setE2.getString(20)+" "+setE2.getString(21),font));
                PdfPCell chemD6 = new PdfPCell(new Paragraph(com,font));
                PdfPCell chemD7 = new PdfPCell(new Paragraph(setChemTeacher.getString(6),font));
                table.addCell(chemD1);
                table.addCell(chemD2);
                table.addCell(chemD3);
                table.addCell(chemD4);
                table.addCell(chemD5);
                table.addCell(chemD6);
                table.addCell(chemD7);

                //set Biology Results
                PdfPCell bioD1 = new PdfPCell(new Paragraph("Biology",font));
                PdfPCell bioD2 = new PdfPCell(new Paragraph(" ",font));
                PdfPCell bioD3 = new PdfPCell(new Paragraph(setE2.getString(17)+" "+setE2.getString(18),font));
                PdfPCell bioD4 = new PdfPCell(new Paragraph(" ",font));

                int avgBio = Integer.parseInt(setE2.getString(17));
                if (avgBio >= Integer.parseInt(setBioGrade.getString(4))) {com = setComments.getString(2); } else if (avgBio >= Integer.parseInt(setBioGrade.getString(5))) { com = setComments.getString(3); }else if (avgBio >=Integer.parseInt(setBioGrade.getString(6))){ com = setComments.getString(4);}else if (avgBio >=Integer.parseInt(setBioGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgBio >=Integer.parseInt(setBioGrade.getString(8))){  com = setComments.getString(6); }else if (avgBio >=Integer.parseInt(setBioGrade.getString(9))){ com = setComments.getString(7); }else if (avgBio >=Integer.parseInt(setBioGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgBio >=Integer.parseInt(setBioGrade.getString(11))){ com = setComments.getString(9);}else if (avgBio >=Integer.parseInt(setBioGrade.getString(12))){ com = setComments.getString(10);}else if (avgBio >=Integer.parseInt(setBioGrade.getString(13))){ com = setComments.getString(11);}else if (avgBio >=Integer.parseInt(setBioGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell bioD5 = new PdfPCell(new Paragraph(setE2.getString(17)+" "+setE2.getString(18),font));
                PdfPCell bioD6 = new PdfPCell(new Paragraph(com,font));
                PdfPCell bioD7 = new PdfPCell(new Paragraph(setBioTeacher.getString(6),font));
                table.addCell(bioD1);
                table.addCell(bioD2);
                table.addCell(bioD3);
                table.addCell(bioD4);
                table.addCell(bioD5);
                table.addCell(bioD6);
                table.addCell(bioD7);

                //set Physics Results
                PdfPCell phyD1 = new PdfPCell(new Paragraph("Physics",font));
                PdfPCell phyD2 = new PdfPCell(new Paragraph(" ",font));
                PdfPCell phyD3 = new PdfPCell(new Paragraph(setE2.getString(23)+" "+setE2.getString(24),font));
                PdfPCell phyD4 = new PdfPCell(new Paragraph(" ",font));

                int avgPhy = Integer.parseInt(setE2.getString(23));
                if (avgPhy >= Integer.parseInt(setPhyGrade.getString(4))) {com = setComments.getString(2); } else if (avgPhy >= Integer.parseInt(setPhyGrade.getString(5))) { com = setComments.getString(3); }else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(6))){ com = setComments.getString(4);}else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(8))){  com = setComments.getString(6); }else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(9))){ com = setComments.getString(7); }else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(11))){ com = setComments.getString(9);}else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(12))){ com = setComments.getString(10);}else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(13))){ com = setComments.getString(11);}else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell phyD5 = new PdfPCell(new Paragraph(setE2.getString(23)+" "+setE2.getString(24),font));
                PdfPCell phyD6 = new PdfPCell(new Paragraph(com,font));
                PdfPCell phyD7 = new PdfPCell(new Paragraph(setPhyTeacher.getString(6),font));
                table.addCell(phyD1);
                table.addCell(phyD2);
                table.addCell(phyD3);
                table.addCell(phyD4);
                table.addCell(phyD5);
                table.addCell(phyD6);
                table.addCell(phyD7);

                //set History results
                PdfPCell hisD1 = new PdfPCell(new Paragraph("History",font));
                PdfPCell hisD2 = new PdfPCell(new Paragraph(" ",font));
                PdfPCell hisD3 = new PdfPCell(new Paragraph(setE2.getString(29)+" "+setE2.getString(30),font));
                PdfPCell hisD4 = new PdfPCell(new Paragraph(" ",font));

                int avgHis = Integer.parseInt(setE2.getString(29));
                if (avgHis >= Integer.parseInt(setHisGrade.getString(4))) {com = setComments.getString(2); } else if (avgHis >= Integer.parseInt(setHisGrade.getString(5))) { com = setComments.getString(3); }else if (avgHis >=Integer.parseInt(setHisGrade.getString(6))){ com = setComments.getString(4);}else if (avgHis >=Integer.parseInt(setHisGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgHis >=Integer.parseInt(setHisGrade.getString(8))){  com = setComments.getString(6); }else if (avgHis >=Integer.parseInt(setHisGrade.getString(9))){ com = setComments.getString(7); }else if (avgHis >=Integer.parseInt(setHisGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgHis >=Integer.parseInt(setHisGrade.getString(11))){ com = setComments.getString(9);}else if (avgHis >=Integer.parseInt(setHisGrade.getString(12))){ com = setComments.getString(10);}else if (avgHis >=Integer.parseInt(setHisGrade.getString(13))){ com = setComments.getString(11);}else if (avgHis >=Integer.parseInt(setHisGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell hisD5 = new PdfPCell(new Paragraph(setE2.getString(29)+" "+setE2.getString(30),font));
                PdfPCell hisD6 = new PdfPCell(new Paragraph(com,font));
                PdfPCell hisD7 = new PdfPCell(new Paragraph(setHisTeacher.getString(6),font));
                table.addCell(hisD1);
                table.addCell(hisD2);
                table.addCell(hisD3);
                table.addCell(hisD4);
                table.addCell(hisD5);
                table.addCell(hisD6);
                table.addCell(hisD7);

                //set Geography results
                PdfPCell geoD1 = new PdfPCell(new Paragraph("Geography",font));
                PdfPCell geoD2 = new PdfPCell(new Paragraph(" ",font));
                PdfPCell geoD3 = new PdfPCell(new Paragraph(setE2.getString(26)+" "+setE2.getString(27),font));
                PdfPCell geoD4 = new PdfPCell(new Paragraph(" ",font));

                int avgGeo = Integer.parseInt(setE2.getString(26));
                if (avgGeo >= Integer.parseInt(setGeoGrade.getString(4))) {com = setComments.getString(2); } else if (avgGeo >= Integer.parseInt(setGeoGrade.getString(5))) { com = setComments.getString(3); }else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(6))){ com = setComments.getString(4);}else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(8))){  com = setComments.getString(6); }else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(9))){ com = setComments.getString(7); }else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(11))){ com = setComments.getString(9);}else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(12))){ com = setComments.getString(10);}else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(13))){ com = setComments.getString(11);}else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell geoD5 = new PdfPCell(new Paragraph(setE2.getString(26)+" "+setE2.getString(27),font));
                PdfPCell geoD6 = new PdfPCell(new Paragraph(com,font));
                PdfPCell geoD7 = new PdfPCell(new Paragraph(setGeoTeacher.getString(6),font));
                table.addCell(geoD1);
                table.addCell(geoD2);
                table.addCell(geoD3);
                table.addCell(geoD4);
                table.addCell(geoD5);
                table.addCell(geoD6);
                table.addCell(geoD7);

                //set Cre results
                PdfPCell creD1 = new PdfPCell(new Paragraph("Cre",font));
                PdfPCell creD2 = new PdfPCell(new Paragraph(" ",font));
                PdfPCell creD3 = new PdfPCell(new Paragraph(setE2.getString(32)+" "+setE2.getString(33),font));
                PdfPCell creD4 = new PdfPCell(new Paragraph(" ",font));

                int avgCre = Integer.parseInt(setE2.getString(32));
                if (avgCre >= Integer.parseInt(setCreGrade.getString(4))) {com = setComments.getString(2); } else if (avgCre >= Integer.parseInt(setCreGrade.getString(5))) { com = setComments.getString(3); }else if (avgCre >=Integer.parseInt(setCreGrade.getString(6))){ com = setComments.getString(4);}else if (avgCre >=Integer.parseInt(setCreGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgCre >=Integer.parseInt(setCreGrade.getString(8))){  com = setComments.getString(6); }else if (avgCre >=Integer.parseInt(setCreGrade.getString(9))){ com = setComments.getString(7); }else if (avgCre >=Integer.parseInt(setCreGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgCre >=Integer.parseInt(setCreGrade.getString(11))){ com = setComments.getString(9);}else if (avgCre >=Integer.parseInt(setCreGrade.getString(12))){ com = setComments.getString(10);}else if (avgCre >=Integer.parseInt(setCreGrade.getString(13))){ com = setComments.getString(11);}else if (avgCre >=Integer.parseInt(setCreGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell creD5 = new PdfPCell(new Paragraph(setE2.getString(32)+" "+setE2.getString(33),font));
                PdfPCell creD6 = new PdfPCell(new Paragraph(com,font));
                PdfPCell creD7 = new PdfPCell(new Paragraph(setCreTeacher.getString(6),font));
                table.addCell(creD1);
                table.addCell(creD2);
                table.addCell(creD3);
                table.addCell(creD4);
                table.addCell(creD5);
                table.addCell(creD6);
                table.addCell(creD7);

                //set Business results
                PdfPCell busD1 = new PdfPCell(new Paragraph("Business",font));
                PdfPCell busD2 = new PdfPCell(new Paragraph(" ",font));
                PdfPCell busD3 = new PdfPCell(new Paragraph(setE2.getString(35)+" "+setE2.getString(36),font));
                PdfPCell busD4 = new PdfPCell(new Paragraph(" ",font));

                int avgBus = Integer.parseInt(setE2.getString(35));
                if (avgBus >= Integer.parseInt(setBusGrade.getString(4))) {com = setComments.getString(2); } else if (avgBus >= Integer.parseInt(setBusGrade.getString(5))) { com = setComments.getString(3); }else if (avgBus >=Integer.parseInt(setBusGrade.getString(6))){ com = setComments.getString(4);}else if (avgBus >=Integer.parseInt(setBusGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgBus >=Integer.parseInt(setBusGrade.getString(8))){  com = setComments.getString(6); }else if (avgBus >=Integer.parseInt(setBusGrade.getString(9))){ com = setComments.getString(7); }else if (avgBus >=Integer.parseInt(setBusGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgBus >=Integer.parseInt(setBusGrade.getString(11))){ com = setComments.getString(9);}else if (avgBus >=Integer.parseInt(setBusGrade.getString(12))){ com = setComments.getString(10);}else if (avgBus >=Integer.parseInt(setBusGrade.getString(13))){ com = setComments.getString(11);}else if (avgBus >=Integer.parseInt(setBusGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell busD5 = new PdfPCell(new Paragraph(setE2.getString(35)+" "+setE2.getString(36),font));
                PdfPCell busD6 = new PdfPCell(new Paragraph(com,font));
                PdfPCell busD7 = new PdfPCell(new Paragraph(setBusTeacher.getString(6),font));
                table.addCell(busD1);
                table.addCell(busD2);
                table.addCell(busD3);
                table.addCell(busD4);
                table.addCell(busD5);
                table.addCell(busD6);
                table.addCell(busD7);

                //set Agriculture results
                PdfPCell agriD1 = new PdfPCell(new Paragraph("Agriculture",font));
                PdfPCell agriD2 = new PdfPCell(new Paragraph(" ",font));
                PdfPCell agriD3 = new PdfPCell(new Paragraph(setE2.getString(38)+" "+setE2.getString(39),font));
                PdfPCell agriD4 = new PdfPCell(new Paragraph(" ",font));

                int avgAgri = Integer.parseInt(setE2.getString(38));
                if (avgAgri >= Integer.parseInt(setAgriGrade.getString(4))) {com = setComments.getString(2); } else if (avgAgri >= Integer.parseInt(setAgriGrade.getString(5))) { com = setComments.getString(3); }else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(6))){ com = setComments.getString(4);}else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(8))){  com = setComments.getString(6); }else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(9))){ com = setComments.getString(7); }else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(11))){ com = setComments.getString(9);}else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(12))){ com = setComments.getString(10);}else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(13))){ com = setComments.getString(11);}else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell agriD5 = new PdfPCell(new Paragraph(setE2.getString(38)+" "+setE2.getString(39),font));
                PdfPCell agriD6 = new PdfPCell(new Paragraph(com,font));
                PdfPCell agriD7 = new PdfPCell(new Paragraph(setAgriTeacher.getString(6),font));
                table.addCell(agriD1);
                table.addCell(agriD2);
                table.addCell(agriD3);
                table.addCell(agriD4);
                table.addCell(agriD5);
                table.addCell(agriD6);
                table.addCell(agriD7);

                //set total results
               
                int totalE2 = Integer.parseInt(setE2.getString(41));
                


                PdfPCell totalD1 = new PdfPCell(new Paragraph("Total",font));
                PdfPCell totalD2 = new PdfPCell(new Paragraph(" ",font));
                PdfPCell totalD3 = new PdfPCell(new Paragraph(String.valueOf(totalE2),font));
                PdfPCell totalD4 = new PdfPCell(new Paragraph(" ",font));
                PdfPCell totalD5 = new PdfPCell(new Paragraph(" ",font));
                PdfPCell totalD6 = new PdfPCell(new Paragraph("",font));
                PdfPCell totalD7 = new PdfPCell(new Paragraph("",font));
                table.addCell(totalD1);
                table.addCell(totalD2);
                table.addCell(totalD3);
                table.addCell(totalD4);
                table.addCell(totalD5);
                table.addCell(totalD6);
                table.addCell(totalD7);

                //set average results
                int addAvgEx2 = Math.round(totalE2/11);



                PdfPCell avgD1 = new PdfPCell(new Paragraph("Average",font));
                PdfPCell avgD2 = new PdfPCell(new Paragraph(" "));
                if (addAvgEx2 >= Integer.parseInt(setTotal.getString(4))) {g = "A"; } else if (addAvgEx2 >= Integer.parseInt(setTotal.getString(5))) { g = "A-"; }else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(6))){ g = "B+";}else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(7))){
                    g = "B"; }else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(8))){  g = "B-"; }else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(9))){ g = "C+"; }else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(10))){ g = "C";
                }else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(11))){ g = "C-";}else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(12))){ g = "D+";}else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(13))){ g = "D";}else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(14))){
                    g = "D-";}else {g="E"; }
                PdfPCell avgD3 = new PdfPCell(new Paragraph(String.valueOf(addAvgEx2)+" "+g,font));


                PdfPCell avgD4 = new PdfPCell(new Paragraph(" ",font));

                //float avgAvgTotal = (addAvgEx1+addAvgEx2+addAvgEx3)/3;
                int avgAvgTotal=Integer.parseInt(setE2.getString(41))/11;

                if (avgAvgTotal >= Integer.parseInt(setTotal.getString(4))) {g = "A"; } else if (avgAvgTotal >= Integer.parseInt(setTotal.getString(5))) { g = "A-"; }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(6))){ g = "B+";}else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(7))){
                    g = "B"; }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(8))){  g = "B-"; }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(9))){ g = "C+"; }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(10))){ g = "C";
                }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(11))){ g = "C-";}else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(12))){ g = "D+";}else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(13))){ g = "D";}else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(14))){
                    g = "D-";}else {g="E"; }

                PdfPCell avgD5 = new PdfPCell(new Paragraph(String.valueOf(Math.round(avgAvgTotal))+" "+g,font));
                PdfPCell avgD6 = new PdfPCell(new Paragraph("",font));
                PdfPCell avgD7 = new PdfPCell(new Paragraph("",font));
                table.addCell(avgD1);
                table.addCell(avgD2);
                table.addCell(avgD3);
                table.addCell(avgD4);
                table.addCell(avgD5);
                table.addCell(avgD6);
                table.addCell(avgD7);

                document.add(table);

                Paragraph labelSummary = new Paragraph("PERFORMANCE TREND",new Font(Font.FontFamily.TIMES_ROMAN, 8,Font.BOLD));
                labelSummary.setSpacingBefore(0);
                labelSummary.setSpacingAfter(5);
                labelSummary.setAlignment(Element.ALIGN_CENTER);
                document.add(labelSummary);

                PdfPTable tableLastSummary = new PdfPTable(8);
                tableLastSummary.setWidthPercentage(105);
                tableLastSummary.setSpacingBefore(0f);
                tableLastSummary.setSpacingAfter(0f);

                float[] colWidthSummary = {0.5f,0.5f,0.5f,0.5f,0.5f,0.5f,0.5f,0.5f};
                tableLastSummary.setWidths(colWidthSummary);
                PdfPCell cS1 = new PdfPCell(new Paragraph("FORM 1",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell cS2 = new PdfPCell(new Paragraph(" ",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell cS3 = new PdfPCell(new Paragraph("FORM 2",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell cS4 = new PdfPCell(new Paragraph(" ",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell cS5 = new PdfPCell(new Paragraph("FORM 3",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell cS6 = new PdfPCell(new Paragraph(" ",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell cS7 = new PdfPCell(new Paragraph("FORM 4",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                PdfPCell cS8 = new PdfPCell(new Paragraph(" ",new Font(Font.FontFamily.HELVETICA, 12,Font.BOLD)));
                tableLastSummary.addCell(cS1);
                tableLastSummary.addCell(cS2);
                tableLastSummary.addCell(cS3);
                tableLastSummary.addCell(cS4);
                tableLastSummary.addCell(cS5);
                tableLastSummary.addCell(cS6);
                tableLastSummary.addCell(cS7);
                tableLastSummary.addCell(cS8);

                PdfPCell f1t1 = new PdfPCell(new Paragraph("F1T1",font));
                PdfPCell f1t1m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF1T1E2.getString(30)))/11)+" "+setF1T1E2.getString(31),font));
                PdfPCell f2t1 = new PdfPCell(new Paragraph("F2T1",font));
                PdfPCell f2t1m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF2T1E2.getString(30)))/11)+" "+setF2T1E2.getString(31),font));
                PdfPCell f3t1 = new PdfPCell(new Paragraph("F3T1",font));
                PdfPCell f3t1m = new PdfPCell(new Paragraph(String.valueOf(Integer.parseInt(setF3T1E2.getString(41))/11)+" "+setF3T1E2.getString(43)+" "+setF3T1E2.getString(42),font));
                PdfPCell f4t1 = new PdfPCell(new Paragraph("F4T1",font));
                PdfPCell f4t1m = new PdfPCell(new Paragraph(" ",font));
                tableLastSummary.addCell(f1t1);
                tableLastSummary.addCell(f1t1m);
                tableLastSummary.addCell(f2t1);
                tableLastSummary.addCell(f2t1m);
                tableLastSummary.addCell(f3t1);
                tableLastSummary.addCell(f3t1m);
                tableLastSummary.addCell(f4t1);
                tableLastSummary.addCell(f4t1m);

                PdfPCell f1t2 = new PdfPCell(new Paragraph("F1T2",font));
                PdfPCell f1t2m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF1T2E2.getString(30)))/11)+" "+setF1T2E2.getString(31),font));
                PdfPCell f2t2 = new PdfPCell(new Paragraph("F2T2",font));
                PdfPCell f2t2m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF2T2E2.getString(30)))/11)+" "+setF2T2E2.getString(31),font));
                PdfPCell f3t2 = new PdfPCell(new Paragraph("F3T2",font));
                PdfPCell f3t2m = new PdfPCell(new Paragraph(String.valueOf(avgAvgTotal)+" "+setE2.getString(42)+" "+setE2.getString(43),font));
                PdfPCell f4t2 = new PdfPCell(new Paragraph("F4T2",font));
                PdfPCell f4t2m = new PdfPCell(new Paragraph(" ",font));
                tableLastSummary.addCell(f1t2);
                tableLastSummary.addCell(f1t2m);
                tableLastSummary.addCell(f2t2);
                tableLastSummary.addCell(f2t2m);
                tableLastSummary.addCell(f3t2);
                tableLastSummary.addCell(f3t2m);
                tableLastSummary.addCell(f4t2);
                tableLastSummary.addCell(f4t2m);

                PdfPCell f1t3 = new PdfPCell(new Paragraph("F1T3",font));
                PdfPCell f1t3m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF1T3E2.getString(30)))/11)+" "+setF1T3E2.getString(31),font));
                PdfPCell f2t3 = new PdfPCell(new Paragraph("F2T3",font));
                PdfPCell f2t3m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF2T3E2.getString(30)))/11)+" "+setF2T3E2.getString(31),font));
                PdfPCell f3t3 = new PdfPCell(new Paragraph("F3T3",font));
                PdfPCell f3t3m = new PdfPCell(new Paragraph(" ",font));
                PdfPCell f4t3 = new PdfPCell(new Paragraph("F4T3",font));
                PdfPCell f4t3m = new PdfPCell(new Paragraph(" ",font));
                tableLastSummary.addCell(f1t3);
                tableLastSummary.addCell(f1t3m);
                tableLastSummary.addCell(f2t3);
                tableLastSummary.addCell(f2t3m);
                tableLastSummary.addCell(f3t3);
                tableLastSummary.addCell(f3t3m);
                tableLastSummary.addCell(f4t3);
                tableLastSummary.addCell(f4t3m);

                document.add(tableLastSummary);
            /*
            * logo
            * */
                Image img = Image.getInstance(cname+"\\HS Results\\Web-Development.png");
                img.scaleAbsolute(100,50);
                img.setAbsolutePosition(30,750);
                document.add(img);

            /*
            * chart
            * */
                DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
                JFreeChart chart = ChartFactory.createBarChart(
                        "", "", "Marks",
                        dataSet, PlotOrientation.VERTICAL, false, false, false);
                int width=500; /* Width of our chart */
                int height=150; /* Height of our chart */
/* Get instance of CategoryPlot */
                CategoryPlot plot = chart.getCategoryPlot();
                BarRenderer renderer = (BarRenderer) plot.getRenderer();
                renderer.setSeriesPaint(0, Color.black);
                dataSet.setValue((Integer.parseInt(setF1T1E2.getString(30))/11)/7, "Marks", "F1T1");
                dataSet.setValue((Integer.parseInt(setF1T2E2.getString(30))/11)/7, "Marks", "F1T2");
                dataSet.setValue((Integer.parseInt(setF1T3E2.getString(30))/11)/7, "Marks", "F1T3");
                dataSet.setValue((Integer.parseInt(setF2T1E2.getString(30))/11)/7, "Marks", "F2T1");
                dataSet.setValue((Integer.parseInt(setF2T2E2.getString(30))/11)/7, "Marks", "F2T2");
                dataSet.setValue((Integer.parseInt(setF2T3E2.getString(30))/11)/7, "Marks", "F2T3");
                dataSet.setValue(Float.parseFloat(setF3T1E2.getString(43)), "Marks", "F3T1");
                dataSet.setValue(Float.parseFloat(setE2.getString(43)), "Marks", "F3T2");
                dataSet.setValue(0, "Marks", "F3T3");
                dataSet.setValue(0, "Marks", "F4T1");
                dataSet.setValue(0, "Marks", "F4T2");
                dataSet.setValue(0, "Marks", "F4T3");
                PdfContentByte contentByte = writer.getDirectContent();
                PdfTemplate template = contentByte.createTemplate(width, height);
                Graphics2D graphics2d = template.createGraphics(width, height,new DefaultFontMapper());
                Rectangle2D rectangle2d = new Rectangle2D.Double(0, 0, width, height);
                chart.draw(graphics2d, rectangle2d);
                graphics2d.dispose();
                contentByte.addTemplate(template, 30, 270);

                Paragraph classTeacherComments = new Paragraph("Class teacher comments: _________________________________________________________");
                Paragraph classTeacherComments1 = new Paragraph("______________________________________________________________________________");
                Paragraph principalComments =new Paragraph("Principal comments: _____________________________________________________________");
                Paragraph principalComments1 =new Paragraph("______________________________________________________________________________");

                classTeacherComments.setSpacingBefore(170);
                document.add(classTeacherComments);
                document.add(classTeacherComments1);
                document.add(principalComments);
                document.add(principalComments1);
                document.close();
            writer.close();
            infoBox("Document containing exam2 results for " + NAME + " has been created open it for printing.","Done",null);
            Desktop.getDesktop().open(new File(cname+"\\HS Results\\"+NAME+".pdf"));


            }catch (Exception e){
                e.printStackTrace();
                infoBoxError("An error occurred " + e,"Error",null);
            }}else {
            infoBoxError("You are not allowed to print","Error",null);
        }
    }
}
