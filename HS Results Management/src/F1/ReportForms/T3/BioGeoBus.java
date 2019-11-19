package F1.ReportForms.T3;

import F1.ReportForms.T3.PrintPass;
import com.itextpdf.awt.DefaultFontMapper;
import com.itextpdf.text.*;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
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
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.ResourceBundle;

import static Alerts.informationBox.infoBox;
import static Alerts.informationBox.infoBoxError;

public class BioGeoBus implements Initializable{
    Calendar now = Calendar.getInstance();
    String cname = System.getProperty("user.home");
    @FXML
    private Label adm,name,pos,all;
    @FXML
    private Label engEx1,kisEx1,matEx1,bioEx1,phyEx1,chemEx1,geoEx1,hisEx1,creEx1,busEx1,agriEx1,totalEx1,avgEx1;
    @FXML
    private Label engEx2,kisEx2,matEx2,bioEx2,phyEx2,chemEx2,geoEx2,hisEx2,creEx2,busEx2,agriEx2,totalEx2,avgEx2;
    @FXML
    private Label engEx3,kisEx3,matEx3,bioEx3,phyEx3,chemEx3,geoEx3,hisEx3,creEx3,busEx3,agriEx3,totalEx3,avgEx3;
    @FXML
    private Label engAvg,kisAvg,matAvg,bioAvg,phyAvg,chemAvg,geoAvg,hisAvg,creAvg,busAvg,agriAvg,totalAvg,avgAvg;
    @FXML
    private Label engAvgGrade,kisAvgGrade,matAvgGrade,bioAvgGrade,phyAvgGrade,chemAvgGrade,geoAvgGrade,hisAvgGrade,creAvgGrade,busAvgGrade,agriAvgGrade,avgAvgGrade;
    @FXML
    private Label engEx1Grade,kisEx1Grade,matEx1Grade,bioEx1Grade,phyEx1Grade,chemEx1Grade,geoEx1Grade,hisEx1Grade,creEx1Grade,busEx1Grade,agriEx1Grade,avgEx1Grade;
    @FXML
    private Label engEx2Grade,kisEx2Grade,matEx2Grade,bioEx2Grade,phyEx2Grade,chemEx2Grade,geoEx2Grade,hisEx2Grade,creEx2Grade,busEx2Grade,agriEx2Grade,avgEx2Grade;
    @FXML
    private Label engEx3Grade,kisEx3Grade,matEx3Grade,bioEx3Grade,phyEx3Grade,chemEx3Grade,geoEx3Grade,hisEx3Grade,creEx3Grade,busEx3Grade,agriEx3Grade,avgEx3Grade;
    @FXML
    private Label engComment,kisComment,matComment,bioComment,phyComment,chemComment,geoComment,hisComment,creComment,busComment,agriComment;
    @FXML
    private Label engTeacher,kisTeacher,matTeacher,bioTeacher,phyTeacher,chemTeacher,creTeacher,geoTeacher,hisTeacher,busTeacher,agriTeacher;

    public static String ADM;
    public static int POS;
    public static int ALL;
    public static String printPassword;

    private void setDetails(){
        pos.setText(String.valueOf(POS+1));
        all.setText(String.valueOf(ALL));
        String sql="SELECT * FROM tbl_students WHERE adm=?";
        ResultSet set = null;
        try{
            Connection connection = Database.DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,ADM);
            set = statement.executeQuery();

            String names = set.getString(3)+" "+set.getString(4)+" "+set.getString(5);

            adm.setText(ADM);
            name.setText(names);

        }catch (Exception e){
            infoBoxError("An error occurred in details" + e,"Error",null);
        }
    }

    private void setMarks(){
        String sqlEx1 = "SELECT * FROM tbl_f1_t3_ex1 WHERE class='FORM_1' AND adm=?";
        String sqlEx2 ="SELECT * FROM tbl_f1_t3_ex2 WHERE class='FORM_1' AND adm=?";
        String sqlEx3 ="SELECT * FROM tbl_f1_t3_ex3 WHERE class='FORM_1' AND adm=?";
        String sqlAvg ="SELECT * FROM tbl_f1_t3_avg WHERE class='FORM_1' AND adm=?";

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

        try{
            Connection connection = Database.DBConnection.getConnection();
            ResultSet setEx1,setEx2,setEx3,setAvg = null;
            PreparedStatement statementEx1 = connection.prepareStatement(sqlEx1);
            PreparedStatement statementEx2 = connection.prepareStatement(sqlEx2);
            PreparedStatement statementEx3 = connection.prepareStatement(sqlEx3);
            PreparedStatement statementAvg = connection.prepareStatement(sqlAvg);

            statementEx1.setString(1,ADM);
            statementEx2.setString(1,ADM);
            statementEx3.setString(1,ADM);
            statementAvg.setString(1,ADM);

            setEx1 = statementEx1.executeQuery();
            setEx2 = statementEx2.executeQuery();
            setEx3 = statementEx3.executeQuery();
            setAvg = statementAvg.executeQuery();
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

            /***English***/
            engEx1.setText(setEx1.getString(8));
            engEx2.setText(setEx2.getString(8));
            engEx3.setText(setEx3.getString(8));
            engAvg.setText(setAvg.getString(8));
            engEx1Grade.setText(setEx1.getString(9));
            engEx2Grade.setText(setEx2.getString(9));
            engEx3Grade.setText(setEx3.getString(9));
            engAvgGrade.setText(setAvg.getString(9));
            engTeacher.setText(setEngTeacher.getString(6));
            /***Kiswahili***/
            kisEx1.setText(setEx1.getString(10));
            kisEx2.setText(setEx2.getString(10));
            kisEx3.setText(setEx3.getString(10));
            kisAvg.setText(setAvg.getString(10));
            kisEx1Grade.setText(setEx1.getString(11));
            kisEx2Grade.setText(setEx2.getString(11));
            kisEx3Grade.setText(setEx3.getString(11));
            kisAvgGrade.setText(setAvg.getString(11));
            kisTeacher.setText(setKisTeacher.getString(6));
            /***Mathematics***/
            matEx1.setText(setEx1.getString(12));
            matEx2.setText(setEx2.getString(12));
            matEx3.setText(setEx3.getString(12));
            matAvg.setText(setAvg.getString(12));
            matEx1Grade.setText(setEx1.getString(13));
            matEx2Grade.setText(setEx2.getString(13));
            matEx3Grade.setText(setEx3.getString(13));
            matAvgGrade.setText(setAvg.getString(12));
            matTeacher.setText(setMatTeacher.getString(6));
            /***Chemistry***/
            chemEx1.setText(setEx1.getString(16));
            chemEx2.setText(setEx2.getString(16));
            chemEx3.setText(setEx3.getString(16));
            chemAvg.setText(setAvg.getString(16));
            chemEx1Grade.setText(setEx1.getString(17));
            chemEx2Grade.setText(setEx2.getString(17));
            chemEx3Grade.setText(setEx3.getString(17));
            chemAvgGrade.setText(setAvg.getString(17));
            chemTeacher.setText(setChemTeacher.getString(6));
            /***Biology***/
            bioEx1.setText(setEx1.getString(14));
            bioEx2.setText(setEx2.getString(14));
            bioEx3.setText(setEx3.getString(14));
            bioAvg.setText(setAvg.getString(14));
            bioEx1Grade.setText(setEx1.getString(15));
            bioEx2Grade.setText(setEx2.getString(15));
            bioEx3Grade.setText(setEx3.getString(15));
            bioAvgGrade.setText(setAvg.getString(15));
            bioTeacher.setText(setBioTeacher.getString(6));
            /***Geography***/
            geoEx1.setText(setEx1.getString(20));
            geoEx2.setText(setEx2.getString(20));
            geoEx3.setText(setEx3.getString(20));
            geoAvg.setText(setAvg.getString(20));
            geoEx1Grade.setText(setEx1.getString(21));
            geoEx2Grade.setText(setEx2.getString(21));
            geoEx3Grade.setText(setEx3.getString(21));
            geoAvgGrade.setText(setAvg.getString(21));
            geoTeacher.setText(setGeoTeacher.getString(6));
            /***Business***/
            busEx1.setText(setEx1.getString(26));
            busEx2.setText(setEx2.getString(26));
            busEx3.setText(setEx3.getString(26));
            busAvg.setText(setAvg.getString(26));
            busEx1Grade.setText(setEx1.getString(27));
            busEx2Grade.setText(setEx2.getString(27));
            busEx3Grade.setText(setEx3.getString(27));
            busAvgGrade.setText(setAvg.getString(27));
            busTeacher.setText(setBusTeacher.getString(6));
            /***totals***/
            totalEx1.setText(setEx1.getString(30));
            totalEx2.setText(setEx2.getString(30));
            totalEx3.setText(setEx3.getString(30));
            totalAvg.setText(setAvg.getString(30));
            avgEx1.setText(String.valueOf(Integer.parseInt(setEx1.getString(30))/7));
            avgEx2.setText(String.valueOf(Integer.parseInt(setEx2.getString(30))/7));
            avgEx3.setText(String.valueOf(Integer.parseInt(setEx3.getString(30))/7));
            avgAvg.setText(String.valueOf(Integer.parseInt(setAvg.getString(30))/7));
            avgEx1Grade.setText(setEx1.getString(31));
            avgEx2Grade.setText(setEx2.getString(31));
            avgEx3Grade.setText(setEx3.getString(31));
            avgAvgGrade.setText(setAvg.getString(31));

        }catch (Exception e){
            e.printStackTrace();
            infoBoxError("An error occurred","Error",null);
        }
    }

    public void printPassAvg(){
        PrintPass.bioGeoBus=1;
        PrintPass.avg=1;
        PrintPass.ex1=0;
        PrintPass.ex2=0;
        PrintPass.ex3=0;
        try{
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("printPass.fxml"));

            PrintPass printPass = (PrintPass) loader.getController();

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

    public void printPassEx1(){
        PrintPass.bioGeoBus=1;
        PrintPass.avg=0;
        PrintPass.ex1=1;
        PrintPass.ex2=0;
        PrintPass.ex3=0;
        try{
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("printPass.fxml"));

            PrintPass printPass = (PrintPass) loader.getController();

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

    public void printPassEx2(){
        PrintPass.bioGeoBus=1;
        PrintPass.avg=0;
        PrintPass.ex1=0;
        PrintPass.ex2=1;
        PrintPass.ex3=0;
        try{
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("printPass.fxml"));

            PrintPass printPass = (PrintPass) loader.getController();

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

    public void printPassEx3(){
        PrintPass.bioGeoBus=1;
        PrintPass.avg=0;
        PrintPass.ex1=0;
        PrintPass.ex2=0;
        PrintPass.ex3=1;
        try{
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("printPass.fxml"));

            PrintPass printPass = (PrintPass) loader.getController();

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

    @FXML
    void printExamAvg() {
        if(printPassword.toString().equals("vic")) {
            String sqlDetails="SELECT * FROM tbl_students WHERE adm=?";
            String sqlComm = "SELECT * FROM tbl_comments";
            String sqlTotal ="SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='TOTAL'";
            String sqlEx1 = "SELECT * FROM tbl_f1_t3_ex1 WHERE adm=? ";
            String sqlEx2 = "SELECT * FROM tbl_f1_t3_ex2 WHERE adm=? ";
            String sqlEx3 = "SELECT * FROM tbl_f1_t3_ex3 WHERE adm=? ";
            String sqlAvg = "SELECT * FROM tbl_f1_t3_avg WHERE adm=? ";

            String sqlAvgT1 = "SELECT * FROM tbl_f1_t1_avg WHERE adm=? ";
            String sqlAvgT2 = "SELECT * FROM tbl_f1_t2_avg WHERE adm=? ";
			
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
            String sql = "SELECT COUNT(adm) FROM tbl_students WHERE class='FORM_1'";

            try{
                Connection connection = Database.DBConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sqlDetails);
                PreparedStatement statementE1 = connection.prepareStatement(sqlEx1);
                PreparedStatement statementE2 = connection.prepareStatement(sqlEx2);
                PreparedStatement statementE3 = connection.prepareStatement(sqlEx3);
                PreparedStatement statementAvg = connection.prepareStatement(sqlAvg);
				PreparedStatement statementAvgF1T1 = connection.prepareStatement(sqlAvgT1);
				PreparedStatement statementAvgF1T2 = connection.prepareStatement(sqlAvgT2);

                ResultSet totalSet = connection.createStatement().executeQuery(sql);
                String totalStudents = totalSet.getString(1);

                statement.setString(1,ADM);
                statementE1.setString(1,ADM);
                statementE2.setString(1,ADM);
                statementE3.setString(1,ADM);
                statementAvg.setString(1,ADM);
				statementAvgF1T1.setString(1,ADM);
				statementAvgF1T2.setString(1,ADM);

                ResultSet set = statement.executeQuery();
                ResultSet setE1 = statementE1.executeQuery();
                ResultSet setE2 = statementE2.executeQuery();
                ResultSet setE3 = statementE3.executeQuery();
                ResultSet setAvg = statementAvg.executeQuery();
				ResultSet setAvgF1T1 = statementAvgF1T1.executeQuery();
				ResultSet setAvgF1T2 = statementAvgF1T2.executeQuery();

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

                String names2 = set.getString(3)+" "+set.getString(4)+" "+set.getString(5);

                Document document = new Document(PageSize.A4);
                PdfWriter writer = PdfWriter.getInstance(document,new FileOutputStream(names+"_T2_AVG.pdf"));
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
                document.add((new Paragraph("ADM: "+set.getString(2)+"  "+"NAME: "+set.getString(3)+"   "+set.getString(4)+" "+set.getString(5)+"  "+"KCPE:"+set.getString(6)+"  "+"CLASS:FORM 1"+"  "+"TERM:TERM 1",new Font(Font.FontFamily.TIMES_ROMAN, 9,Font.BOLD))));
                document.add((new Paragraph("YEAR:"+now.get(Calendar.YEAR)+" "+"POS:"+String.valueOf(POS+1)+" "+"OUT OF "+totalStudents,new Font(Font.FontFamily.TIMES_ROMAN, 9,Font.BOLD))));
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
                PdfPCell engD2 = new PdfPCell(new Paragraph(setE1.getString(8)+" "+setE1.getString(9),font));
                PdfPCell engD3 = new PdfPCell(new Paragraph(setE2.getString(8)+" "+setE2.getString(9),font));
                PdfPCell engD4 = new PdfPCell(new Paragraph(setE3.getString(8)+" "+setE3.getString(9),font));

                int avgE= Integer.parseInt(setAvg.getString(8));
                if (avgE >= Integer.parseInt(setEngGrade.getString(4))) {com = setComments.getString(2); } else if (avgE >= Integer.parseInt(setEngGrade.getString(5))) { com = setComments.getString(3); }else if (avgE >=Integer.parseInt(setEngGrade.getString(6))){ com = setComments.getString(4);}else if (avgE >=Integer.parseInt(setEngGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgE >=Integer.parseInt(setEngGrade.getString(8))){  com = setComments.getString(6); }else if (avgE >=Integer.parseInt(setEngGrade.getString(9))){ com = setComments.getString(7); }else if (avgE >=Integer.parseInt(setEngGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgE >=Integer.parseInt(setEngGrade.getString(11))){ com = setComments.getString(9);}else if (avgE >=Integer.parseInt(setEngGrade.getString(12))){ com = setComments.getString(10);}else if (avgE >=Integer.parseInt(setEngGrade.getString(13))){ com = setComments.getString(11);}else if (avgE >=Integer.parseInt(setEngGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }
                PdfPCell engD5 = new PdfPCell(new Paragraph(setAvg.getString(8)+" "+setAvg.getString(9),font));
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
                PdfPCell kisD2 = new PdfPCell(new Paragraph(setE1.getString(10)+" "+setE1.getString(11),font));
                PdfPCell kisD3 = new PdfPCell(new Paragraph(setE2.getString(10)+" "+setE2.getString(11),font));
                PdfPCell kisD4 = new PdfPCell(new Paragraph(setE3.getString(10)+" "+setE3.getString(11),font));

                int avgKis= Integer.parseInt(setAvg.getString(10));
                if (avgKis >= Integer.parseInt(setKisGrade.getString(4))) {com = setComments.getString(2); } else if (avgKis >= Integer.parseInt(setKisGrade.getString(5))) { com = setComments.getString(3); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(6))){ com = setComments.getString(4);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(8))){  com = setComments.getString(6); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(9))){ com = setComments.getString(7); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgKis >=Integer.parseInt(setKisGrade.getString(11))){ com = setComments.getString(9);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(12))){ com = setComments.getString(10);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(13))){ com = setComments.getString(11);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }
                PdfPCell kisD5 = new PdfPCell(new Paragraph(setAvg.getString(10)+" "+setAvg.getString(11),font));
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
                PdfPCell matD2 = new PdfPCell(new Paragraph(setE1.getString(12)+" "+setE1.getString(13),font));
                PdfPCell matD3 = new PdfPCell(new Paragraph(setE2.getString(12)+" "+setE2.getString(13),font));
                PdfPCell matD4 = new PdfPCell(new Paragraph(setE3.getString(12)+" "+setE3.getString(13),font));

                int avgMat = Integer.parseInt(setAvg.getString(12));
                if (avgMat >= Integer.parseInt(setMatGrade.getString(4))) {com = setComments.getString(2); } else if (avgMat >= Integer.parseInt(setMatGrade.getString(5))) { com = setComments.getString(3); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(6))){ com = setComments.getString(4);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(8))){  com = setComments.getString(6); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(9))){ com = setComments.getString(7); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgMat >=Integer.parseInt(setMatGrade.getString(11))){ com = setComments.getString(9);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(12))){ com = setComments.getString(10);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(13))){ com = setComments.getString(11);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell matD5 = new PdfPCell(new Paragraph(setAvg.getString(12)+" "+setAvg.getString(13),font));
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
                PdfPCell chemD2 = new PdfPCell(new Paragraph(setE1.getString(14)+" "+setE1.getString(15),font));
                PdfPCell chemD3 = new PdfPCell(new Paragraph(setE2.getString(14)+" "+setE2.getString(15),font));
                PdfPCell chemD4 = new PdfPCell(new Paragraph(setE3.getString(14)+" "+setE3.getString(15),font));

                int avgChem = Integer.parseInt(setAvg.getString(14));
                if (avgChem >= Integer.parseInt(setChemGrade.getString(4))) {com = setComments.getString(2); } else if (avgChem >= Integer.parseInt(setChemGrade.getString(5))) { com = setComments.getString(3); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(6))){ com = setComments.getString(4);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(8))){  com = setComments.getString(6); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(9))){ com = setComments.getString(7); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgChem >=Integer.parseInt(setChemGrade.getString(11))){ com = setComments.getString(9);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(12))){ com = setComments.getString(10);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(13))){ com = setComments.getString(11);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell chemD5 = new PdfPCell(new Paragraph(setAvg.getString(14)+" "+setAvg.getString(15),font));
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
                PdfPCell bioD2 = new PdfPCell(new Paragraph(setE1.getString(16)+" "+setE1.getString(17),font));
                PdfPCell bioD3 = new PdfPCell(new Paragraph(setE2.getString(16)+" "+setE2.getString(17),font));
                PdfPCell bioD4 = new PdfPCell(new Paragraph(setE3.getString(16)+" "+setE3.getString(17),font));

                int avgBio = Integer.parseInt(setAvg.getString(16));
                if (avgBio >= Integer.parseInt(setBioGrade.getString(4))) {com = setComments.getString(2); } else if (avgBio >= Integer.parseInt(setBioGrade.getString(5))) { com = setComments.getString(3); }else if (avgBio >=Integer.parseInt(setBioGrade.getString(6))){ com = setComments.getString(4);}else if (avgBio >=Integer.parseInt(setBioGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgBio >=Integer.parseInt(setBioGrade.getString(8))){  com = setComments.getString(6); }else if (avgBio >=Integer.parseInt(setBioGrade.getString(9))){ com = setComments.getString(7); }else if (avgBio >=Integer.parseInt(setBioGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgBio >=Integer.parseInt(setBioGrade.getString(11))){ com = setComments.getString(9);}else if (avgBio >=Integer.parseInt(setBioGrade.getString(12))){ com = setComments.getString(10);}else if (avgBio >=Integer.parseInt(setBioGrade.getString(13))){ com = setComments.getString(11);}else if (avgBio >=Integer.parseInt(setBioGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell bioD5 = new PdfPCell(new Paragraph(setAvg.getString(16)+" "+setAvg.getString(17),font));
                PdfPCell bioD6 = new PdfPCell(new Paragraph(com,font));
                PdfPCell bioD7 = new PdfPCell(new Paragraph(setBioTeacher.getString(6),font));
                table.addCell(bioD1);
                table.addCell(bioD2);
                table.addCell(bioD3);
                table.addCell(bioD4);
                table.addCell(bioD5);
                table.addCell(bioD6);
                table.addCell(bioD7);

                //set Geography results
                PdfPCell geoD1 = new PdfPCell(new Paragraph("Geography",font));
                PdfPCell geoD2 = new PdfPCell(new Paragraph(setE1.getString(20)+" "+setE1.getString(21),font));
                PdfPCell geoD3 = new PdfPCell(new Paragraph(setE2.getString(20)+" "+setE2.getString(21),font));
                PdfPCell geoD4 = new PdfPCell(new Paragraph(setE3.getString(20)+" "+setE3.getString(21),font));

                int avgGeo = Integer.parseInt(setAvg.getString(20));
                if (avgGeo >= Integer.parseInt(setGeoGrade.getString(4))) {com = setComments.getString(2); } else if (avgGeo >= Integer.parseInt(setGeoGrade.getString(5))) { com = setComments.getString(3); }else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(6))){ com = setComments.getString(4);}else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(8))){  com = setComments.getString(6); }else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(9))){ com = setComments.getString(7); }else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(11))){ com = setComments.getString(9);}else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(12))){ com = setComments.getString(10);}else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(13))){ com = setComments.getString(11);}else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell geoD5 = new PdfPCell(new Paragraph(setAvg.getString(20)+" "+setAvg.getString(21),font));
                PdfPCell geoD6 = new PdfPCell(new Paragraph(com,font));
                PdfPCell geoD7 = new PdfPCell(new Paragraph(setGeoTeacher.getString(6),font));
                table.addCell(geoD1);
                table.addCell(geoD2);
                table.addCell(geoD3);
                table.addCell(geoD4);
                table.addCell(geoD5);
                table.addCell(geoD6);
                table.addCell(geoD7);

                //set Business results
                PdfPCell busD1 = new PdfPCell(new Paragraph("Business",font));
                PdfPCell busD2 = new PdfPCell(new Paragraph(setE1.getString(26)+" "+setE1.getString(27),font));
                PdfPCell busD3 = new PdfPCell(new Paragraph(setE2.getString(26)+" "+setE2.getString(27),font));
                PdfPCell busD4 = new PdfPCell(new Paragraph(setE3.getString(26)+" "+setE3.getString(27),font));

                int avgBus = Integer.parseInt(setAvg.getString(26));
                if (avgBus >= Integer.parseInt(setBusGrade.getString(4))) {com = setComments.getString(2); } else if (avgBus >= Integer.parseInt(setBusGrade.getString(5))) { com = setComments.getString(3); }else if (avgBus >=Integer.parseInt(setBusGrade.getString(6))){ com = setComments.getString(4);}else if (avgBus >=Integer.parseInt(setBusGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgBus >=Integer.parseInt(setBusGrade.getString(8))){  com = setComments.getString(6); }else if (avgBus >=Integer.parseInt(setBusGrade.getString(9))){ com = setComments.getString(7); }else if (avgBus >=Integer.parseInt(setBusGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgBus >=Integer.parseInt(setBusGrade.getString(11))){ com = setComments.getString(9);}else if (avgBus >=Integer.parseInt(setBusGrade.getString(12))){ com = setComments.getString(10);}else if (avgBus >=Integer.parseInt(setBusGrade.getString(13))){ com = setComments.getString(11);}else if (avgBus >=Integer.parseInt(setBusGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell busD5 = new PdfPCell(new Paragraph(setAvg.getString(26)+" "+setAvg.getString(27),font));
                PdfPCell busD6 = new PdfPCell(new Paragraph(com,font));
                PdfPCell busD7 = new PdfPCell(new Paragraph(setBusTeacher.getString(6),font));
                table.addCell(busD1);
                table.addCell(busD2);
                table.addCell(busD3);
                table.addCell(busD4);
                table.addCell(busD5);
                table.addCell(busD6);
                table.addCell(busD7);

                //set total results
                int totalE1 = Integer.parseInt(setE1.getString(30));
                int totalE2 = Integer.parseInt(setE2.getString(30));
                int totalE3 = Integer.parseInt(setE3.getString(30));
                int totalAvg = Integer.parseInt(setAvg.getString(30));


                PdfPCell totalD1 = new PdfPCell(new Paragraph("Total",font));
                PdfPCell totalD2 = new PdfPCell(new Paragraph(String.valueOf(totalE1),font));
                PdfPCell totalD3 = new PdfPCell(new Paragraph(String.valueOf(totalE2),font));
                PdfPCell totalD4 = new PdfPCell(new Paragraph(String.valueOf(totalE3),font));
                PdfPCell totalD5 = new PdfPCell(new Paragraph(String.valueOf(totalAvg),font));
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
                int addAvgEx1 = Math.round(totalE1/7);
                //int add2AvgEx1 = (Math.addExact(totalEx1Mat,addAvgEx1))/3;

                int addAvgEx2 = Math.round(totalE2/7);
                //int add2AvgEx2 = (Math.addExact(totalEx2Mat,addAvgEx2))/3;

                int addAvgEx3 = Math.round(totalE3/7);
                //int add2AvgEx3 = (Math.addExact(totalEx3Mat,addAvgEx3))/3;

                if (addAvgEx1 >= Integer.parseInt(setTotal.getString(4))) {g = "A"; } else if (addAvgEx1 >= Integer.parseInt(setTotal.getString(5))) { g = "A-"; }else if (addAvgEx1 >=Integer.parseInt(setTotal.getString(6))){ g = "B+";}else if (addAvgEx1 >=Integer.parseInt(setTotal.getString(7))){
                    g = "B"; }else if (addAvgEx1 >=Integer.parseInt(setTotal.getString(8))){  g = "B-"; }else if (addAvgEx1 >=Integer.parseInt(setTotal.getString(9))){ g = "C+"; }else if (addAvgEx1 >=Integer.parseInt(setTotal.getString(10))){ g = "C";
                }else if (addAvgEx1 >=Integer.parseInt(setTotal.getString(11))){ g = "C-";}else if (addAvgEx1 >=Integer.parseInt(setTotal.getString(12))){ g = "D+";}else if (addAvgEx1 >=Integer.parseInt(setTotal.getString(13))){ g = "D";}else if (addAvgEx1 >=Integer.parseInt(setTotal.getString(14))){
                    g = "D-";}else {g="E"; }
                PdfPCell avgD1 = new PdfPCell(new Paragraph("Average",font));
                PdfPCell avgD2 = new PdfPCell(new Paragraph(String.valueOf(addAvgEx1)+" "+g,font));
                if (addAvgEx2 >= Integer.parseInt(setTotal.getString(4))) {g = "A"; } else if (addAvgEx2 >= Integer.parseInt(setTotal.getString(5))) { g = "A-"; }else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(6))){ g = "B+";}else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(7))){
                    g = "B"; }else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(8))){  g = "B-"; }else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(9))){ g = "C+"; }else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(10))){ g = "C";
                }else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(11))){ g = "C-";}else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(12))){ g = "D+";}else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(13))){ g = "D";}else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(14))){
                    g = "D-";}else {g="E"; }
                PdfPCell avgD3 = new PdfPCell(new Paragraph(String.valueOf(addAvgEx2)+" "+g,font));

                if (addAvgEx3 >= Integer.parseInt(setTotal.getString(4))) {g = "A"; } else if (addAvgEx3 >= Integer.parseInt(setTotal.getString(5))) { g = "A-"; }else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(6))){ g = "B+";}else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(7))){
                    g = "B"; }else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(8))){  g = "B-"; }else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(9))){ g = "C+"; }else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(10))){ g = "C";
                }else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(11))){ g = "C-";}else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(12))){ g = "D+";}else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(13))){ g = "D";}else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(14))){
                    g = "D-";}else {g="E"; }
                PdfPCell avgD4 = new PdfPCell(new Paragraph(String.valueOf(addAvgEx3)+" "+g,font));

                //float avgAvgTotal = (addAvgEx1+addAvgEx2+addAvgEx3)/3;
                int avgAvgTotal=Integer.parseInt(setAvg.getString(30))/7;

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
                PdfPCell f1t1m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setAvgF1T1.getString(30)))/11)+" "+setAvgF1T1.getString(31),font));
                PdfPCell f2t1 = new PdfPCell(new Paragraph("F2T1",font));
                PdfPCell f2t1m = new PdfPCell(new Paragraph(" ",font));
                PdfPCell f3t1 = new PdfPCell(new Paragraph("F3T1",font));
                PdfPCell f3t1m = new PdfPCell(new Paragraph(" ",font));
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
                PdfPCell f1t2m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setAvgF1T2.getString(30)))/11)+" "+setAvgF1T2.getString(31),font));
                PdfPCell f2t2 = new PdfPCell(new Paragraph("F2T2",font));
                PdfPCell f2t2m = new PdfPCell(new Paragraph(" ",font));
                PdfPCell f3t2 = new PdfPCell(new Paragraph("F3T2",font));
                PdfPCell f3t2m = new PdfPCell(new Paragraph(" ",font));
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
                PdfPCell f1t3m = new PdfPCell(new Paragraph(String.valueOf(avgAvgTotal)+" "+g,font));
                PdfPCell f2t3 = new PdfPCell(new Paragraph("F2T3",font));
                PdfPCell f2t3m = new PdfPCell(new Paragraph(" ",font));
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
                dataSet.setValue((Integer.parseInt(setAvgF1T1.getString(30))/11), "Marks", "F1T1");
                dataSet.setValue((Integer.parseInt(setAvgF1T2.getString(30))/11), "Marks", "F1T2");
                dataSet.setValue(avgAvgTotal, "Marks", "F1T3");
                dataSet.setValue(0, "Marks", "F2T1");
                dataSet.setValue(0, "Marks", "F2T2");
                dataSet.setValue(0, "Marks", "F2T3");
                dataSet.setValue(0, "Marks", "F3T1");
                dataSet.setValue(0, "Marks", "F3T2");
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
                infoBox("Document containing average results for " + names2 + " has been created open it for printing.","Done",null);
                Desktop.getDesktop().open(new File(cname+"\\HS Results\\"+names+"_T2_AVG.pdf"));
            }catch (Exception e){
                e.printStackTrace();
                infoBoxError("An error occurred " + e,"Error",null);
            }}else {
            infoBoxError("You are not allowed to print","Error",null);
        }

    }

    @FXML
    void printExam1(){
        if(printPassword.toString().equals("vic")) {
            String sqlDetails="SELECT * FROM tbl_students WHERE adm=?";
            String sqlComm = "SELECT * FROM tbl_comments";
            String sqlTotal ="SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='TOTAL'";
            String sqlEx1 = "SELECT * FROM tbl_f1_t3_ex1 WHERE adm=? ";
			
			String sqlEx1T1F1 = "SELECT * FROM tbl_f1_t1_ex1 WHERE adm=? ";
			String sqlEx1T2F1 = "SELECT * FROM tbl_f1_t2_ex1 WHERE adm=?";


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

            String sql = "SELECT COUNT(adm) FROM tbl_students WHERE class='FORM_1'";
            try{
                Connection connection = Database.DBConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sqlDetails);
                PreparedStatement statementE1 = connection.prepareStatement(sqlEx1);
				PreparedStatement statementE1F1T1 = connection.prepareStatement(sqlEx1T1F1);
				PreparedStatement statementE1F1T2 = connection.prepareStatement(sqlEx1T2F1);

                ResultSet totalSet = connection.createStatement().executeQuery(sql);
                String totalStudents = totalSet.getString(1);

                statement.setString(1,ADM);
                statementE1.setString(1,ADM);
				statementE1F1T1.setString(1,ADM);
				statementE1F1T2.setString(1,ADM);

                ResultSet set = statement.executeQuery();
                ResultSet setE1 = statementE1.executeQuery();
				ResultSet setAvgF1T1 = statementE1F1T1.executeQuery();
				ResultSet setAvgF1T2 = statementE1F1T2.executeQuery();

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

                String names2 = set.getString(3)+" "+set.getString(4)+" "+set.getString(5);

                Document document = new Document(PageSize.A4);
                PdfWriter writer = PdfWriter.getInstance(document,new FileOutputStream(names+"_EXAM1.pdf"));
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
                document.add((new Paragraph("ADM: "+set.getString(2)+"  "+"NAME: "+set.getString(3)+"   "+set.getString(4)+" "+set.getString(5)+"  "+"KCPE:"+set.getString(6)+"  "+"CLASS:FORM 1"+"  "+"TERM:TERM 1",new Font(Font.FontFamily.TIMES_ROMAN, 9,Font.BOLD))));
                document.add((new Paragraph("YEAR:"+now.get(Calendar.YEAR)+" "+"POS:"+String.valueOf(POS+1)+" "+"OUT OF "+totalStudents,new Font(Font.FontFamily.TIMES_ROMAN, 9,Font.BOLD))));
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
                PdfPCell engD2 = new PdfPCell(new Paragraph(setE1.getString(8)+" "+setE1.getString(9),font));
                PdfPCell engD3 = new PdfPCell(new Paragraph(" ",font));
                PdfPCell engD4 = new PdfPCell(new Paragraph(" ",font));

                int avgE= Integer.parseInt(setE1.getString(8));
                if (avgE >= Integer.parseInt(setEngGrade.getString(4))) {com = setComments.getString(2); } else if (avgE >= Integer.parseInt(setEngGrade.getString(5))) { com = setComments.getString(3); }else if (avgE >=Integer.parseInt(setEngGrade.getString(6))){ com = setComments.getString(4);}else if (avgE >=Integer.parseInt(setEngGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgE >=Integer.parseInt(setEngGrade.getString(8))){  com = setComments.getString(6); }else if (avgE >=Integer.parseInt(setEngGrade.getString(9))){ com = setComments.getString(7); }else if (avgE >=Integer.parseInt(setEngGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgE >=Integer.parseInt(setEngGrade.getString(11))){ com = setComments.getString(9);}else if (avgE >=Integer.parseInt(setEngGrade.getString(12))){ com = setComments.getString(10);}else if (avgE >=Integer.parseInt(setEngGrade.getString(13))){ com = setComments.getString(11);}else if (avgE >=Integer.parseInt(setEngGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }
                PdfPCell engD5 = new PdfPCell(new Paragraph(setE1.getString(8)+" "+setE1.getString(9),font));
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
                PdfPCell kisD2 = new PdfPCell(new Paragraph(setE1.getString(10)+" "+setE1.getString(11),font));
                PdfPCell kisD3 = new PdfPCell(new Paragraph(" ",font));
                PdfPCell kisD4 = new PdfPCell(new Paragraph(" ",font));

                int avgKis= Integer.parseInt(setE1.getString(10));
                if (avgKis >= Integer.parseInt(setKisGrade.getString(4))) {com = setComments.getString(2); } else if (avgKis >= Integer.parseInt(setKisGrade.getString(5))) { com = setComments.getString(3); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(6))){ com = setComments.getString(4);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(8))){  com = setComments.getString(6); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(9))){ com = setComments.getString(7); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgKis >=Integer.parseInt(setKisGrade.getString(11))){ com = setComments.getString(9);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(12))){ com = setComments.getString(10);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(13))){ com = setComments.getString(11);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }
                PdfPCell kisD5 = new PdfPCell(new Paragraph(setE1.getString(10)+" "+setE1.getString(11),font));
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
                PdfPCell matD2 = new PdfPCell(new Paragraph(setE1.getString(12)+" "+setE1.getString(13),font));
                PdfPCell matD3 = new PdfPCell(new Paragraph(" ",font));
                PdfPCell matD4 = new PdfPCell(new Paragraph(" ",font));

                int avgMat = Integer.parseInt(setE1.getString(12));
                if (avgMat >= Integer.parseInt(setMatGrade.getString(4))) {com = setComments.getString(2); } else if (avgMat >= Integer.parseInt(setMatGrade.getString(5))) { com = setComments.getString(3); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(6))){ com = setComments.getString(4);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(8))){  com = setComments.getString(6); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(9))){ com = setComments.getString(7); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgMat >=Integer.parseInt(setMatGrade.getString(11))){ com = setComments.getString(9);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(12))){ com = setComments.getString(10);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(13))){ com = setComments.getString(11);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell matD5 = new PdfPCell(new Paragraph(setE1.getString(12)+" "+setE1.getString(13),font));
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
                PdfPCell chemD2 = new PdfPCell(new Paragraph(setE1.getString(14)+" "+setE1.getString(15),font));
                PdfPCell chemD3 = new PdfPCell(new Paragraph(" ",font));
                PdfPCell chemD4 = new PdfPCell(new Paragraph(" ",font));

                int avgChem = Integer.parseInt(setE1.getString(14));
                if (avgChem >= Integer.parseInt(setChemGrade.getString(4))) {com = setComments.getString(2); } else if (avgChem >= Integer.parseInt(setChemGrade.getString(5))) { com = setComments.getString(3); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(6))){ com = setComments.getString(4);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(8))){  com = setComments.getString(6); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(9))){ com = setComments.getString(7); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgChem >=Integer.parseInt(setChemGrade.getString(11))){ com = setComments.getString(9);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(12))){ com = setComments.getString(10);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(13))){ com = setComments.getString(11);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell chemD5 = new PdfPCell(new Paragraph(setE1.getString(14)+" "+setE1.getString(15),font));
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
                PdfPCell bioD2 = new PdfPCell(new Paragraph(setE1.getString(16)+" "+setE1.getString(17),font));
                PdfPCell bioD3 = new PdfPCell(new Paragraph(" ",font));
                PdfPCell bioD4 = new PdfPCell(new Paragraph(" ",font));

                int avgBio = Integer.parseInt(setE1.getString(16));
                if (avgBio >= Integer.parseInt(setBioGrade.getString(4))) {com = setComments.getString(2); } else if (avgBio >= Integer.parseInt(setBioGrade.getString(5))) { com = setComments.getString(3); }else if (avgBio >=Integer.parseInt(setBioGrade.getString(6))){ com = setComments.getString(4);}else if (avgBio >=Integer.parseInt(setBioGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgBio >=Integer.parseInt(setBioGrade.getString(8))){  com = setComments.getString(6); }else if (avgBio >=Integer.parseInt(setBioGrade.getString(9))){ com = setComments.getString(7); }else if (avgBio >=Integer.parseInt(setBioGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgBio >=Integer.parseInt(setBioGrade.getString(11))){ com = setComments.getString(9);}else if (avgBio >=Integer.parseInt(setBioGrade.getString(12))){ com = setComments.getString(10);}else if (avgBio >=Integer.parseInt(setBioGrade.getString(13))){ com = setComments.getString(11);}else if (avgBio >=Integer.parseInt(setBioGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell bioD5 = new PdfPCell(new Paragraph(setE1.getString(16)+" "+setE1.getString(17),font));
                PdfPCell bioD6 = new PdfPCell(new Paragraph(com,font));
                PdfPCell bioD7 = new PdfPCell(new Paragraph(setBioTeacher.getString(6),font));
                table.addCell(bioD1);
                table.addCell(bioD2);
                table.addCell(bioD3);
                table.addCell(bioD4);
                table.addCell(bioD5);
                table.addCell(bioD6);
                table.addCell(bioD7);

                //set Geography results
                PdfPCell geoD1 = new PdfPCell(new Paragraph("Geography",font));
                PdfPCell geoD2 = new PdfPCell(new Paragraph(setE1.getString(20)+" "+setE1.getString(21),font));
                PdfPCell geoD3 = new PdfPCell(new Paragraph(" ",font));
                PdfPCell geoD4 = new PdfPCell(new Paragraph(" ",font));

                int avgGeo = Integer.parseInt(setE1.getString(20));
                if (avgGeo >= Integer.parseInt(setGeoGrade.getString(4))) {com = setComments.getString(2); } else if (avgGeo >= Integer.parseInt(setGeoGrade.getString(5))) { com = setComments.getString(3); }else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(6))){ com = setComments.getString(4);}else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(8))){  com = setComments.getString(6); }else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(9))){ com = setComments.getString(7); }else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(11))){ com = setComments.getString(9);}else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(12))){ com = setComments.getString(10);}else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(13))){ com = setComments.getString(11);}else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell geoD5 = new PdfPCell(new Paragraph(setE1.getString(20)+" "+setE1.getString(21),font));
                PdfPCell geoD6 = new PdfPCell(new Paragraph(com,font));
                PdfPCell geoD7 = new PdfPCell(new Paragraph(setGeoTeacher.getString(6),font));
                table.addCell(geoD1);
                table.addCell(geoD2);
                table.addCell(geoD3);
                table.addCell(geoD4);
                table.addCell(geoD5);
                table.addCell(geoD6);
                table.addCell(geoD7);

                //set Business results
                PdfPCell busD1 = new PdfPCell(new Paragraph("Business",font));
                PdfPCell busD2 = new PdfPCell(new Paragraph(setE1.getString(26)+" "+setE1.getString(27),font));
                PdfPCell busD3 = new PdfPCell(new Paragraph(" ",font));
                PdfPCell busD4 = new PdfPCell(new Paragraph(" ",font));

                int avgBus = Integer.parseInt(setE1.getString(26));
                if (avgBus >= Integer.parseInt(setBusGrade.getString(4))) {com = setComments.getString(2); } else if (avgBus >= Integer.parseInt(setBusGrade.getString(5))) { com = setComments.getString(3); }else if (avgBus >=Integer.parseInt(setBusGrade.getString(6))){ com = setComments.getString(4);}else if (avgBus >=Integer.parseInt(setBusGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgBus >=Integer.parseInt(setBusGrade.getString(8))){  com = setComments.getString(6); }else if (avgBus >=Integer.parseInt(setBusGrade.getString(9))){ com = setComments.getString(7); }else if (avgBus >=Integer.parseInt(setBusGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgBus >=Integer.parseInt(setBusGrade.getString(11))){ com = setComments.getString(9);}else if (avgBus >=Integer.parseInt(setBusGrade.getString(12))){ com = setComments.getString(10);}else if (avgBus >=Integer.parseInt(setBusGrade.getString(13))){ com = setComments.getString(11);}else if (avgBus >=Integer.parseInt(setBusGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell busD5 = new PdfPCell(new Paragraph(setE1.getString(26)+" "+setE1.getString(27),font));
                PdfPCell busD6 = new PdfPCell(new Paragraph(com,font));
                PdfPCell busD7 = new PdfPCell(new Paragraph(setBusTeacher.getString(6),font));
                table.addCell(busD1);
                table.addCell(busD2);
                table.addCell(busD3);
                table.addCell(busD4);
                table.addCell(busD5);
                table.addCell(busD6);
                table.addCell(busD7);

                //set total results
                int totalE1 = Integer.parseInt(setE1.getString(30));


                int totalAvg = Integer.parseInt(setE1.getString(30));


                PdfPCell totalD1 = new PdfPCell(new Paragraph("Total",font));
                PdfPCell totalD2 = new PdfPCell(new Paragraph(String.valueOf(totalE1),font));
                PdfPCell totalD3 = new PdfPCell(new Paragraph(" ",font));
                PdfPCell totalD4 = new PdfPCell(new Paragraph(" ",font));
                PdfPCell totalD5 = new PdfPCell(new Paragraph(String.valueOf(totalE1),font));
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
                int addAvgEx1 = Math.round(totalE1/7);
                //int add2AvgEx1 = (Math.addExact(totalEx1Mat,addAvgEx1))/3;


                if (addAvgEx1 >= Integer.parseInt(setTotal.getString(4))) {g = "A"; } else if (addAvgEx1 >= Integer.parseInt(setTotal.getString(5))) { g = "A-"; }else if (addAvgEx1 >=Integer.parseInt(setTotal.getString(6))){ g = "B+";}else if (addAvgEx1 >=Integer.parseInt(setTotal.getString(7))){
                    g = "B"; }else if (addAvgEx1 >=Integer.parseInt(setTotal.getString(8))){  g = "B-"; }else if (addAvgEx1 >=Integer.parseInt(setTotal.getString(9))){ g = "C+"; }else if (addAvgEx1 >=Integer.parseInt(setTotal.getString(10))){ g = "C";
                }else if (addAvgEx1 >=Integer.parseInt(setTotal.getString(11))){ g = "C-";}else if (addAvgEx1 >=Integer.parseInt(setTotal.getString(12))){ g = "D+";}else if (addAvgEx1 >=Integer.parseInt(setTotal.getString(13))){ g = "D";}else if (addAvgEx1 >=Integer.parseInt(setTotal.getString(14))){
                    g = "D-";}else {g="E"; }
                PdfPCell avgD1 = new PdfPCell(new Paragraph("Average",font));
                PdfPCell avgD2 = new PdfPCell(new Paragraph(String.valueOf(addAvgEx1)+" "+g,font));

                PdfPCell avgD3 = new PdfPCell(new Paragraph(" ",font));


                PdfPCell avgD4 = new PdfPCell(new Paragraph(" ",font));

                //float avgAvgTotal = (addAvgEx1+addAvgEx2+addAvgEx3)/3;
                int avgAvgTotal=Integer.parseInt(setE1.getString(30))/7;

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
                PdfPCell f1t1m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setAvgF1T1.getString(30)))/11)+" "+setAvgF1T1.getString(31),font));
                PdfPCell f2t1 = new PdfPCell(new Paragraph("F2T1",font));
                PdfPCell f2t1m = new PdfPCell(new Paragraph(" ",font));
                PdfPCell f3t1 = new PdfPCell(new Paragraph("F3T1",font));
                PdfPCell f3t1m = new PdfPCell(new Paragraph(" ",font));
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
                PdfPCell f1t2m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setAvgF1T2.getString(30)))/11)+" "+setAvgF1T2.getString(31),font));
                PdfPCell f2t2 = new PdfPCell(new Paragraph("F2T2",font));
                PdfPCell f2t2m = new PdfPCell(new Paragraph(" ",font));
                PdfPCell f3t2 = new PdfPCell(new Paragraph("F3T2",font));
                PdfPCell f3t2m = new PdfPCell(new Paragraph(" ",font));
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
                PdfPCell f1t3m = new PdfPCell(new Paragraph(String.valueOf(avgAvgTotal)+" "+g,font));
                PdfPCell f2t3 = new PdfPCell(new Paragraph("F2T3",font));
                PdfPCell f2t3m = new PdfPCell(new Paragraph(" ",font));
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
                dataSet.setValue((Integer.parseInt(setAvgF1T1.getString(30))/11), "Marks", "F1T1");
                dataSet.setValue((Integer.parseInt(setAvgF1T2.getString(30))/11), "Marks", "F1T2");
                dataSet.setValue(avgAvgTotal, "Marks", "F1T3");
                dataSet.setValue(0, "Marks", "F2T1");
                dataSet.setValue(0, "Marks", "F2T2");
                dataSet.setValue(0, "Marks", "F2T3");
                dataSet.setValue(0, "Marks", "F3T1");
                dataSet.setValue(0, "Marks", "F3T2");
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
                infoBox("Document containing exam 1 results for " + names2 + " has been created open it for printing.","Done",null);
                Desktop.getDesktop().open(new File(cname+"\\HS Results\\"+names+"_EXAM1.pdf"));
            }catch (Exception e){
                e.printStackTrace();
                infoBoxError("An error occurred " + e,"Error",null);
            }}else {
            infoBoxError("You are not allowed to print","Error",null);
        }

    }

    @FXML
    void printExam2(){
        if(printPassword.toString().equals("vic")) {
            String sqlDetails="SELECT * FROM tbl_students WHERE adm=?";
            String sqlComm = "SELECT * FROM tbl_comments";
            String sqlTotal ="SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='TOTAL'";

            String sqlEx2 = "SELECT * FROM tbl_f1_t3_ex2 WHERE adm=? ";
String sqlEx2T1F1 = "SELECT * FROM tbl_f1_t1_ex2 WHERE adm=? ";
String sqlEx2T2F1 = "SELECT * FROM tbl_f1_t2_ex2 WHERE adm=? ";

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

            String sql = "SELECT COUNT(adm) FROM tbl_students WHERE class='FORM_1'";
            try{
                Connection connection = Database.DBConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sqlDetails);
                PreparedStatement statementE2 = connection.prepareStatement(sqlEx2);
				PreparedStatement statementE2T1F1 = connection.prepareStatement(sqlEx2T1F1);
				PreparedStatement statementE2T2F1 = connection.prepareStatement(sqlEx2T2F1);

                ResultSet totalSet = connection.createStatement().executeQuery(sql);
                String totalStudents = totalSet.getString(1);



                statement.setString(1,ADM);

                statementE2.setString(1,ADM);
				statementE2T1F1.setString(1,ADM);
				statementE2T2F1.setString(1,ADM);


                ResultSet set = statement.executeQuery();

                ResultSet setE2 = statementE2.executeQuery();
				ResultSet setAvgF1T1 = statementE2T1F1.executeQuery();
				ResultSet setAvgF1T2 = statementE2T2F1.executeQuery();


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

                String names2 = set.getString(3)+" "+set.getString(4)+" "+set.getString(5);

                Document document = new Document(PageSize.A4);
                PdfWriter writer = PdfWriter.getInstance(document,new FileOutputStream(names+"_EXAM2.pdf"));
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
                document.add((new Paragraph("ADM: "+set.getString(2)+"  "+"NAME: "+set.getString(3)+"   "+set.getString(4)+" "+set.getString(5)+"  "+"KCPE:"+set.getString(6)+"  "+"CLASS:FORM 1"+"  "+"TERM:TERM 1",new Font(Font.FontFamily.TIMES_ROMAN, 9,Font.BOLD))));
                document.add((new Paragraph("YEAR:"+now.get(Calendar.YEAR)+" "+"POS:"+String.valueOf(POS+1)+" "+"OUT OF "+totalStudents,new Font(Font.FontFamily.TIMES_ROMAN, 9,Font.BOLD))));
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
                PdfPCell kisD3 = new PdfPCell(new Paragraph(setE2.getString(10)+" "+setE2.getString(11),font));
                PdfPCell kisD4 = new PdfPCell(new Paragraph(" ",font));

                int avgKis= Integer.parseInt(setE2.getString(10));
                if (avgKis >= Integer.parseInt(setKisGrade.getString(4))) {com = setComments.getString(2); } else if (avgKis >= Integer.parseInt(setKisGrade.getString(5))) { com = setComments.getString(3); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(6))){ com = setComments.getString(4);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(8))){  com = setComments.getString(6); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(9))){ com = setComments.getString(7); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgKis >=Integer.parseInt(setKisGrade.getString(11))){ com = setComments.getString(9);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(12))){ com = setComments.getString(10);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(13))){ com = setComments.getString(11);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }
                PdfPCell kisD5 = new PdfPCell(new Paragraph(setE2.getString(10)+" "+setE2.getString(11),font));
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
                PdfPCell matD3 = new PdfPCell(new Paragraph(setE2.getString(12)+" "+setE2.getString(13),font));
                PdfPCell matD4 = new PdfPCell(new Paragraph(" ",font));

                int avgMat = Integer.parseInt(setE2.getString(12));
                if (avgMat >= Integer.parseInt(setMatGrade.getString(4))) {com = setComments.getString(2); } else if (avgMat >= Integer.parseInt(setMatGrade.getString(5))) { com = setComments.getString(3); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(6))){ com = setComments.getString(4);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(8))){  com = setComments.getString(6); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(9))){ com = setComments.getString(7); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgMat >=Integer.parseInt(setMatGrade.getString(11))){ com = setComments.getString(9);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(12))){ com = setComments.getString(10);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(13))){ com = setComments.getString(11);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell matD5 = new PdfPCell(new Paragraph(setE2.getString(12)+" "+setE2.getString(13),font));
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
                PdfPCell chemD3 = new PdfPCell(new Paragraph(setE2.getString(14)+" "+setE2.getString(15),font));
                PdfPCell chemD4 = new PdfPCell(new Paragraph(" ",font));

                int avgChem = Integer.parseInt(setE2.getString(14));
                if (avgChem >= Integer.parseInt(setChemGrade.getString(4))) {com = setComments.getString(2); } else if (avgChem >= Integer.parseInt(setChemGrade.getString(5))) { com = setComments.getString(3); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(6))){ com = setComments.getString(4);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(8))){  com = setComments.getString(6); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(9))){ com = setComments.getString(7); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgChem >=Integer.parseInt(setChemGrade.getString(11))){ com = setComments.getString(9);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(12))){ com = setComments.getString(10);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(13))){ com = setComments.getString(11);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell chemD5 = new PdfPCell(new Paragraph(setE2.getString(14)+" "+setE2.getString(15),font));
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
                PdfPCell bioD3 = new PdfPCell(new Paragraph(setE2.getString(16)+" "+setE2.getString(17),font));
                PdfPCell bioD4 = new PdfPCell(new Paragraph(" ",font));

                int avgBio = Integer.parseInt(setE2.getString(16));
                if (avgBio >= Integer.parseInt(setBioGrade.getString(4))) {com = setComments.getString(2); } else if (avgBio >= Integer.parseInt(setBioGrade.getString(5))) { com = setComments.getString(3); }else if (avgBio >=Integer.parseInt(setBioGrade.getString(6))){ com = setComments.getString(4);}else if (avgBio >=Integer.parseInt(setBioGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgBio >=Integer.parseInt(setBioGrade.getString(8))){  com = setComments.getString(6); }else if (avgBio >=Integer.parseInt(setBioGrade.getString(9))){ com = setComments.getString(7); }else if (avgBio >=Integer.parseInt(setBioGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgBio >=Integer.parseInt(setBioGrade.getString(11))){ com = setComments.getString(9);}else if (avgBio >=Integer.parseInt(setBioGrade.getString(12))){ com = setComments.getString(10);}else if (avgBio >=Integer.parseInt(setBioGrade.getString(13))){ com = setComments.getString(11);}else if (avgBio >=Integer.parseInt(setBioGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell bioD5 = new PdfPCell(new Paragraph(setE2.getString(16)+" "+setE2.getString(17),font));
                PdfPCell bioD6 = new PdfPCell(new Paragraph(com,font));
                PdfPCell bioD7 = new PdfPCell(new Paragraph(setBioTeacher.getString(6),font));
                table.addCell(bioD1);
                table.addCell(bioD2);
                table.addCell(bioD3);
                table.addCell(bioD4);
                table.addCell(bioD5);
                table.addCell(bioD6);
                table.addCell(bioD7);

                //set Geography results
                PdfPCell geoD1 = new PdfPCell(new Paragraph("Geography",font));
                PdfPCell geoD2 = new PdfPCell(new Paragraph(" ",font));
                PdfPCell geoD3 = new PdfPCell(new Paragraph(setE2.getString(20)+" "+setE2.getString(21),font));
                PdfPCell geoD4 = new PdfPCell(new Paragraph(" ",font));

                int avgGeo = Integer.parseInt(setE2.getString(20));
                if (avgGeo >= Integer.parseInt(setGeoGrade.getString(4))) {com = setComments.getString(2); } else if (avgGeo >= Integer.parseInt(setGeoGrade.getString(5))) { com = setComments.getString(3); }else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(6))){ com = setComments.getString(4);}else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(8))){  com = setComments.getString(6); }else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(9))){ com = setComments.getString(7); }else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(11))){ com = setComments.getString(9);}else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(12))){ com = setComments.getString(10);}else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(13))){ com = setComments.getString(11);}else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell geoD5 = new PdfPCell(new Paragraph(setE2.getString(20)+" "+setE2.getString(21),font));
                PdfPCell geoD6 = new PdfPCell(new Paragraph(com,font));
                PdfPCell geoD7 = new PdfPCell(new Paragraph(setGeoTeacher.getString(6),font));
                table.addCell(geoD1);
                table.addCell(geoD2);
                table.addCell(geoD3);
                table.addCell(geoD4);
                table.addCell(geoD5);
                table.addCell(geoD6);
                table.addCell(geoD7);

                //set Business results
                PdfPCell busD1 = new PdfPCell(new Paragraph("Business",font));
                PdfPCell busD2 = new PdfPCell(new Paragraph(" ",font));
                PdfPCell busD3 = new PdfPCell(new Paragraph(setE2.getString(26)+" "+setE2.getString(27),font));
                PdfPCell busD4 = new PdfPCell(new Paragraph(" ",font));

                int avgBus = Integer.parseInt(setE2.getString(26));
                if (avgBus >= Integer.parseInt(setBusGrade.getString(4))) {com = setComments.getString(2); } else if (avgBus >= Integer.parseInt(setBusGrade.getString(5))) { com = setComments.getString(3); }else if (avgBus >=Integer.parseInt(setBusGrade.getString(6))){ com = setComments.getString(4);}else if (avgBus >=Integer.parseInt(setBusGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgBus >=Integer.parseInt(setBusGrade.getString(8))){  com = setComments.getString(6); }else if (avgBus >=Integer.parseInt(setBusGrade.getString(9))){ com = setComments.getString(7); }else if (avgBus >=Integer.parseInt(setBusGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgBus >=Integer.parseInt(setBusGrade.getString(11))){ com = setComments.getString(9);}else if (avgBus >=Integer.parseInt(setBusGrade.getString(12))){ com = setComments.getString(10);}else if (avgBus >=Integer.parseInt(setBusGrade.getString(13))){ com = setComments.getString(11);}else if (avgBus >=Integer.parseInt(setBusGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell busD5 = new PdfPCell(new Paragraph(setE2.getString(26)+" "+setE2.getString(27),font));
                PdfPCell busD6 = new PdfPCell(new Paragraph(com,font));
                PdfPCell busD7 = new PdfPCell(new Paragraph(setBusTeacher.getString(6),font));
                table.addCell(busD1);
                table.addCell(busD2);
                table.addCell(busD3);
                table.addCell(busD4);
                table.addCell(busD5);
                table.addCell(busD6);
                table.addCell(busD7);

                //set total results

                int totalE2 = Integer.parseInt(setE2.getString(30));



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
                int addAvgEx2 = Math.round(totalE2/7);



                PdfPCell avgD1 = new PdfPCell(new Paragraph("Average",font));
                PdfPCell avgD2 = new PdfPCell(new Paragraph(" "));
                if (addAvgEx2 >= Integer.parseInt(setTotal.getString(4))) {g = "A"; } else if (addAvgEx2 >= Integer.parseInt(setTotal.getString(5))) { g = "A-"; }else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(6))){ g = "B+";}else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(7))){
                    g = "B"; }else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(8))){  g = "B-"; }else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(9))){ g = "C+"; }else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(10))){ g = "C";
                }else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(11))){ g = "C-";}else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(12))){ g = "D+";}else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(13))){ g = "D";}else if (addAvgEx2 >=Integer.parseInt(setTotal.getString(14))){
                    g = "D-";}else {g="E"; }
                PdfPCell avgD3 = new PdfPCell(new Paragraph(String.valueOf(addAvgEx2)+" "+g,font));


                PdfPCell avgD4 = new PdfPCell(new Paragraph(" ",font));

                //float avgAvgTotal = (addAvgEx1+addAvgEx2+addAvgEx3)/3;
                int avgAvgTotal=Integer.parseInt(setE2.getString(30))/7;

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
                PdfPCell f1t1m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setAvgF1T1.getString(30)))/11)+" "+setAvgF1T1.getString(31),font));
                PdfPCell f2t1 = new PdfPCell(new Paragraph("F2T1",font));
                PdfPCell f2t1m = new PdfPCell(new Paragraph(" ",font));
                PdfPCell f3t1 = new PdfPCell(new Paragraph("F3T1",font));
                PdfPCell f3t1m = new PdfPCell(new Paragraph(" ",font));
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
                PdfPCell f1t2m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setAvgF1T2.getString(30)))/11)+" "+setAvgF1T2.getString(31),font));
                PdfPCell f2t2 = new PdfPCell(new Paragraph("F2T2",font));
                PdfPCell f2t2m = new PdfPCell(new Paragraph(" ",font));
                PdfPCell f3t2 = new PdfPCell(new Paragraph("F3T2",font));
                PdfPCell f3t2m = new PdfPCell(new Paragraph(" ",font));
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
                PdfPCell f1t3m = new PdfPCell(new Paragraph(String.valueOf(avgAvgTotal)+" "+g,font));
                PdfPCell f2t3 = new PdfPCell(new Paragraph("F2T3",font));
                PdfPCell f2t3m = new PdfPCell(new Paragraph(" ",font));
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
                dataSet.setValue((Integer.parseInt(setAvgF1T1.getString(30))/11), "Marks", "F1T1");
                dataSet.setValue((Integer.parseInt(setAvgF1T2.getString(30))/11), "Marks", "F1T2");
                dataSet.setValue(avgAvgTotal, "Marks", "F1T3");
                dataSet.setValue(0, "Marks", "F2T1");
                dataSet.setValue(0, "Marks", "F2T2");
                dataSet.setValue(0, "Marks", "F2T3");
                dataSet.setValue(0, "Marks", "F3T1");
                dataSet.setValue(0, "Marks", "F3T2");
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
                infoBox("Document containing exam 2 results for " + names2 + " has been created open it for printing.","Done",null);
                Desktop.getDesktop().open(new File(cname+"\\HS Results\\"+names+"_EXAM2.pdf"));
            }catch (Exception e){
                e.printStackTrace();
                infoBoxError("An error occurred " + e,"Error",null);
            }}else {
            infoBoxError("You are not allowed to print","Error",null);
        }
    }

    @FXML
    void printExam3(){
        if(printPassword.toString().equals("vic")) {
            String sqlDetails="SELECT * FROM tbl_students WHERE adm=?";
            String sqlComm = "SELECT * FROM tbl_comments";
            String sqlTotal ="SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='TOTAL'";
            String sqlEx3 = "SELECT * FROM tbl_f1_t3_ex3 WHERE adm=? ";
			String sqlEx3T1F1 = "SELECT * FROM tbl_f1_t1_ex3 WHERE adm=? ";
			String sqlEx3T2F1 = "SELECT * FROM tbl_f1_t2_ex3 WHERE adm=? ";

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

            String sql = "SELECT COUNT(adm) FROM tbl_students WHERE class='FORM_1'";


            try{
                Connection connection = Database.DBConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sqlDetails);
                PreparedStatement statementE3 = connection.prepareStatement(sqlEx3);
				PreparedStatement statementE3T1F1 = connection.prepareStatement(sqlEx3T1F1);
				PreparedStatement statementE3T2F1 = connection.prepareStatement(sqlEx3T2F1);
                ResultSet totalSet = connection.createStatement().executeQuery(sql);
                String totalStudents = totalSet.getString(1);

                statement.setString(1,ADM);
                statementE3.setString(1,ADM);
				statementE3T1F1.setString(1,ADM);
				statementE3T2F1.setString(1,ADM);

                ResultSet set = statement.executeQuery();
                ResultSet setE3 = statementE3.executeQuery();
				ResultSet setAvgF1T1 = statementE3T1F1.executeQuery();
				ResultSet setAvgF1T2 = statementE3T2F1.executeQuery();

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

                String names2 = set.getString(3)+" "+set.getString(4)+" "+set.getString(5);

                Document document = new Document(PageSize.A4);
                PdfWriter writer = PdfWriter.getInstance(document,new FileOutputStream(names+"_EXAM3.pdf"));
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
                document.add((new Paragraph("ADM: "+set.getString(2)+"  "+"NAME: "+set.getString(3)+"   "+set.getString(4)+" "+set.getString(5)+"  "+"KCPE:"+set.getString(6)+"  "+"CLASS:FORM 1"+"  "+"TERM:TERM 1",new Font(Font.FontFamily.TIMES_ROMAN, 9,Font.BOLD))));
                document.add((new Paragraph("YEAR:"+now.get(Calendar.YEAR)+" "+"POS:"+String.valueOf(POS+1)+" "+"OUT OF "+totalStudents,new Font(Font.FontFamily.TIMES_ROMAN, 9,Font.BOLD))));
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
                PdfPCell engD3 = new PdfPCell(new Paragraph(" ",font));
                PdfPCell engD4 = new PdfPCell(new Paragraph(setE3.getString(8)+" "+setE3.getString(9),font));

                int avgE= Integer.parseInt(setE3.getString(8));
                if (avgE >= Integer.parseInt(setEngGrade.getString(4))) {com = setComments.getString(2); } else if (avgE >= Integer.parseInt(setEngGrade.getString(5))) { com = setComments.getString(3); }else if (avgE >=Integer.parseInt(setEngGrade.getString(6))){ com = setComments.getString(4);}else if (avgE >=Integer.parseInt(setEngGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgE >=Integer.parseInt(setEngGrade.getString(8))){  com = setComments.getString(6); }else if (avgE >=Integer.parseInt(setEngGrade.getString(9))){ com = setComments.getString(7); }else if (avgE >=Integer.parseInt(setEngGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgE >=Integer.parseInt(setEngGrade.getString(11))){ com = setComments.getString(9);}else if (avgE >=Integer.parseInt(setEngGrade.getString(12))){ com = setComments.getString(10);}else if (avgE >=Integer.parseInt(setEngGrade.getString(13))){ com = setComments.getString(11);}else if (avgE >=Integer.parseInt(setEngGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }
                PdfPCell engD5 = new PdfPCell(new Paragraph(setE3.getString(8)+" "+setE3.getString(9),font));
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
                PdfPCell kisD3 = new PdfPCell(new Paragraph(" ",font));
                PdfPCell kisD4 = new PdfPCell(new Paragraph(setE3.getString(10)+" "+setE3.getString(11),font));

                int avgKis= Integer.parseInt(setE3.getString(10));
                if (avgKis >= Integer.parseInt(setKisGrade.getString(4))) {com = setComments.getString(2); } else if (avgKis >= Integer.parseInt(setKisGrade.getString(5))) { com = setComments.getString(3); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(6))){ com = setComments.getString(4);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(8))){  com = setComments.getString(6); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(9))){ com = setComments.getString(7); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgKis >=Integer.parseInt(setKisGrade.getString(11))){ com = setComments.getString(9);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(12))){ com = setComments.getString(10);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(13))){ com = setComments.getString(11);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }
                PdfPCell kisD5 = new PdfPCell(new Paragraph(setE3.getString(10)+" "+setE3.getString(11),font));
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
                PdfPCell matD3 = new PdfPCell(new Paragraph(" ",font));
                PdfPCell matD4 = new PdfPCell(new Paragraph(setE3.getString(12)+" "+setE3.getString(13),font));

                int avgMat = Integer.parseInt(setE3.getString(12));
                if (avgMat >= Integer.parseInt(setMatGrade.getString(4))) {com = setComments.getString(2); } else if (avgMat >= Integer.parseInt(setMatGrade.getString(5))) { com = setComments.getString(3); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(6))){ com = setComments.getString(4);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(8))){  com = setComments.getString(6); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(9))){ com = setComments.getString(7); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgMat >=Integer.parseInt(setMatGrade.getString(11))){ com = setComments.getString(9);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(12))){ com = setComments.getString(10);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(13))){ com = setComments.getString(11);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell matD5 = new PdfPCell(new Paragraph(setE3.getString(12)+" "+setE3.getString(13),font));
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
                PdfPCell chemD3 = new PdfPCell(new Paragraph(" ",font));
                PdfPCell chemD4 = new PdfPCell(new Paragraph(setE3.getString(14)+" "+setE3.getString(15),font));

                int avgChem = Integer.parseInt(setE3.getString(14));
                if (avgChem >= Integer.parseInt(setChemGrade.getString(4))) {com = setComments.getString(2); } else if (avgChem >= Integer.parseInt(setChemGrade.getString(5))) { com = setComments.getString(3); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(6))){ com = setComments.getString(4);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(8))){  com = setComments.getString(6); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(9))){ com = setComments.getString(7); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgChem >=Integer.parseInt(setChemGrade.getString(11))){ com = setComments.getString(9);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(12))){ com = setComments.getString(10);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(13))){ com = setComments.getString(11);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell chemD5 = new PdfPCell(new Paragraph(setE3.getString(14)+" "+setE3.getString(15),font));
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
                PdfPCell bioD3 = new PdfPCell(new Paragraph(" ",font));
                PdfPCell bioD4 = new PdfPCell(new Paragraph(setE3.getString(16)+" "+setE3.getString(17),font));

                int avgBio = Integer.parseInt(setE3.getString(16));
                if (avgBio >= Integer.parseInt(setBioGrade.getString(4))) {com = setComments.getString(2); } else if (avgBio >= Integer.parseInt(setBioGrade.getString(5))) { com = setComments.getString(3); }else if (avgBio >=Integer.parseInt(setBioGrade.getString(6))){ com = setComments.getString(4);}else if (avgBio >=Integer.parseInt(setBioGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgBio >=Integer.parseInt(setBioGrade.getString(8))){  com = setComments.getString(6); }else if (avgBio >=Integer.parseInt(setBioGrade.getString(9))){ com = setComments.getString(7); }else if (avgBio >=Integer.parseInt(setBioGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgBio >=Integer.parseInt(setBioGrade.getString(11))){ com = setComments.getString(9);}else if (avgBio >=Integer.parseInt(setBioGrade.getString(12))){ com = setComments.getString(10);}else if (avgBio >=Integer.parseInt(setBioGrade.getString(13))){ com = setComments.getString(11);}else if (avgBio >=Integer.parseInt(setBioGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell bioD5 = new PdfPCell(new Paragraph(setE3.getString(16)+" "+setE3.getString(17),font));
                PdfPCell bioD6 = new PdfPCell(new Paragraph(com,font));
                PdfPCell bioD7 = new PdfPCell(new Paragraph(setBioTeacher.getString(6),font));
                table.addCell(bioD1);
                table.addCell(bioD2);
                table.addCell(bioD3);
                table.addCell(bioD4);
                table.addCell(bioD5);
                table.addCell(bioD6);
                table.addCell(bioD7);

                //set Geography results
                PdfPCell geoD1 = new PdfPCell(new Paragraph("Geography",font));
                PdfPCell geoD2 = new PdfPCell(new Paragraph(" ",font));
                PdfPCell geoD3 = new PdfPCell(new Paragraph(" ",font));
                PdfPCell geoD4 = new PdfPCell(new Paragraph(setE3.getString(20)+" "+setE3.getString(21),font));

                int avgGeo = Integer.parseInt(setE3.getString(20));
                if (avgGeo >= Integer.parseInt(setGeoGrade.getString(4))) {com = setComments.getString(2); } else if (avgGeo >= Integer.parseInt(setGeoGrade.getString(5))) { com = setComments.getString(3); }else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(6))){ com = setComments.getString(4);}else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(8))){  com = setComments.getString(6); }else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(9))){ com = setComments.getString(7); }else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(11))){ com = setComments.getString(9);}else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(12))){ com = setComments.getString(10);}else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(13))){ com = setComments.getString(11);}else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell geoD5 = new PdfPCell(new Paragraph(setE3.getString(20)+" "+setE3.getString(21),font));
                PdfPCell geoD6 = new PdfPCell(new Paragraph(com,font));
                PdfPCell geoD7 = new PdfPCell(new Paragraph(setGeoTeacher.getString(6),font));
                table.addCell(geoD1);
                table.addCell(geoD2);
                table.addCell(geoD3);
                table.addCell(geoD4);
                table.addCell(geoD5);
                table.addCell(geoD6);
                table.addCell(geoD7);

                //set Business results
                PdfPCell busD1 = new PdfPCell(new Paragraph("Business",font));
                PdfPCell busD2 = new PdfPCell(new Paragraph(" ",font));
                PdfPCell busD3 = new PdfPCell(new Paragraph(" ",font));
                PdfPCell busD4 = new PdfPCell(new Paragraph(setE3.getString(26)+" "+setE3.getString(27),font));

                int avgBus = Integer.parseInt(setE3.getString(26));
                if (avgBus >= Integer.parseInt(setBusGrade.getString(4))) {com = setComments.getString(2); } else if (avgBus >= Integer.parseInt(setBusGrade.getString(5))) { com = setComments.getString(3); }else if (avgBus >=Integer.parseInt(setBusGrade.getString(6))){ com = setComments.getString(4);}else if (avgBus >=Integer.parseInt(setBusGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgBus >=Integer.parseInt(setBusGrade.getString(8))){  com = setComments.getString(6); }else if (avgBus >=Integer.parseInt(setBusGrade.getString(9))){ com = setComments.getString(7); }else if (avgBus >=Integer.parseInt(setBusGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgBus >=Integer.parseInt(setBusGrade.getString(11))){ com = setComments.getString(9);}else if (avgBus >=Integer.parseInt(setBusGrade.getString(12))){ com = setComments.getString(10);}else if (avgBus >=Integer.parseInt(setBusGrade.getString(13))){ com = setComments.getString(11);}else if (avgBus >=Integer.parseInt(setBusGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell busD5 = new PdfPCell(new Paragraph(setE3.getString(26)+" "+setE3.getString(27),font));
                PdfPCell busD6 = new PdfPCell(new Paragraph(com,font));
                PdfPCell busD7 = new PdfPCell(new Paragraph(setBusTeacher.getString(6),font));
                table.addCell(busD1);
                table.addCell(busD2);
                table.addCell(busD3);
                table.addCell(busD4);
                table.addCell(busD5);
                table.addCell(busD6);
                table.addCell(busD7);

                //set total results

                int totalE3 = Integer.parseInt(setE3.getString(30));
                int totalAvg = Integer.parseInt(setE3.getString(30));


                PdfPCell totalD1 = new PdfPCell(new Paragraph("Total",font));
                PdfPCell totalD2 = new PdfPCell(new Paragraph(" ",font));
                PdfPCell totalD3 = new PdfPCell(new Paragraph(" ",font));
                PdfPCell totalD4 = new PdfPCell(new Paragraph(String.valueOf(totalE3),font));
                PdfPCell totalD5 = new PdfPCell(new Paragraph(String.valueOf(totalAvg),font));
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
                int addAvgEx3 = Math.round(totalE3/7);
                //int add2AvgEx3 = (Math.addExact(totalEx3Mat,addAvgEx3))/3;


                PdfPCell avgD1 = new PdfPCell(new Paragraph("Average",font));
                PdfPCell avgD2 = new PdfPCell(new Paragraph(" ",font));
                PdfPCell avgD3 = new PdfPCell(new Paragraph(" ",font));
                if (addAvgEx3 >= Integer.parseInt(setTotal.getString(4))) {g = "A"; } else if (addAvgEx3 >= Integer.parseInt(setTotal.getString(5))) { g = "A-"; }else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(6))){ g = "B+";}else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(7))){
                    g = "B"; }else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(8))){  g = "B-"; }else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(9))){ g = "C+"; }else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(10))){ g = "C";
                }else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(11))){ g = "C-";}else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(12))){ g = "D+";}else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(13))){ g = "D";}else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(14))){
                    g = "D-";}else {g="E"; }
                PdfPCell avgD4 = new PdfPCell(new Paragraph(String.valueOf(addAvgEx3)+" "+g,font));

                //float avgAvgTotal = (addAvgEx1+addAvgEx2+addAvgEx3)/3;
                int avgAvgTotal=Integer.parseInt(setE3.getString(30))/7;

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
                PdfPCell f1t1m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setAvgF1T1.getString(30)))/11)+" "+setAvgF1T1.getString(31),font));
                PdfPCell f2t1 = new PdfPCell(new Paragraph("F2T1",font));
                PdfPCell f2t1m = new PdfPCell(new Paragraph(" ",font));
                PdfPCell f3t1 = new PdfPCell(new Paragraph("F3T1",font));
                PdfPCell f3t1m = new PdfPCell(new Paragraph(" ",font));
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
                PdfPCell f1t2m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setAvgF1T2.getString(30)))/11)+" "+setAvgF1T2.getString(31),font));
                PdfPCell f2t2 = new PdfPCell(new Paragraph("F2T2",font));
                PdfPCell f2t2m = new PdfPCell(new Paragraph(" ",font));
                PdfPCell f3t2 = new PdfPCell(new Paragraph("F3T2",font));
                PdfPCell f3t2m = new PdfPCell(new Paragraph(" ",font));
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
                PdfPCell f1t3m = new PdfPCell(new Paragraph(String.valueOf(avgAvgTotal)+" "+g,font));
                PdfPCell f2t3 = new PdfPCell(new Paragraph("F2T3",font));
                PdfPCell f2t3m = new PdfPCell(new Paragraph(" ",font));
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
                dataSet.setValue((Integer.parseInt(setAvgF1T1.getString(30))/11), "Marks", "F1T1");
                dataSet.setValue((Integer.parseInt(setAvgF1T2.getString(30))/11), "Marks", "F1T2");
                dataSet.setValue(avgAvgTotal, "Marks", "F1T3");
                dataSet.setValue(0, "Marks", "F2T1");
                dataSet.setValue(0, "Marks", "F2T2");
                dataSet.setValue(0, "Marks", "F2T3");
                dataSet.setValue(0, "Marks", "F3T1");
                dataSet.setValue(0, "Marks", "F3T2");
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
                infoBox("Document containing exam 3 results for " + names2 + " has been created open it for printing.","Done",null);
                Desktop.getDesktop().open(new File(cname+"\\HS Results\\"+names+"_EXAM3.pdf"));
            }catch (Exception e){
                e.printStackTrace();
                infoBoxError("An error occurred " + e,"Error",null);
            }}else {
            infoBoxError("You are not allowed to print","Error",null);
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setDetails();
        setMarks();
    }
}
