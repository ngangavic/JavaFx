package F1.classlist;

import F1.exams.MarksEntry;
import F1.reports.*;
import about.About;
import backup.ManualBackup;
import grade.Grade;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import start.DatabaseSync;
import students.StudentUpdated;
import students.SubjectSelection;
import teacher.Teacher;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class ShowClasslist implements Initializable{
    @FXML
    private Label schoolName,className,termName,examName;

    @FXML
    private TableView<tableData> tableResults;

    @FXML
    private TableColumn<tableData, String> posCol,admCol,nameCol,engCol,engGr,kisCol,kisGr,matCol,matGr,chemCol,chemGr,bioCol,bioGr,phyCol;

    @FXML
    private TableColumn<tableData, String> phyGr,geoCol,geoGr,hisCol,hisGr,creCol,creGr,busCol,busGr,agriCol,agriGr;

    @FXML
    private TableColumn<tableData, String> totalCol,avgCol,pointsCol,kcpeCol;

    @FXML
    private AnchorPane windowCurrent;

    @FXML
    private TableColumn<tableData, Boolean> actionCol;
    private ObservableList<tableData> tableList;
    public static String currentSetting;
    public static String dbTableName;
    public static String dbClassName;
    public static String schName;
    public static String clsName;
    public static String tmName;
    public static String exName;

    public void printReportForms(){
        ReportFormAverage reportFormAverage = new ReportFormAverage();
        ReportFormExam1 reportFormExam1 = new ReportFormExam1();
        ReportFormExam2 reportFormExam2 = new ReportFormExam2();
        ReportFormExam3 reportFormExam3 = new ReportFormExam3();
        switch (currentSetting){
            case "F1T1E1":
                reportFormExam1.printAllResults("tbl_f1_t1_ex1","FORM_1","ex1","FORM 1","TERM 1");
                break;
            case "F1T1E2":
                reportFormExam2.printAllResults("tbl_f1_t1_ex2","FORM_1","ex2","FORM 1","TERM 1");
                break;
            case "F1T1E3":
                reportFormExam3.printAllResults("tbl_f1_t1_ex3","FORM_1","ex3","FORM 1","TERM 1");
                break;
            case "F1T1AVG":
                reportFormAverage.printAllResults("tbl_f1_t1_avg","FORM_1","avg","tbl_f1_t1","FORM 1","TERM 1");
                break;
            case "F1T2E1":
                reportFormExam1.printAllResults("tbl_f1_t2_ex1","FORM_1","ex1","FORM 1","TERM 2");
                break;
            case "F1T2E2":
                reportFormExam2.printAllResults("tbl_f1_t2_ex2","FORM_1","ex2","FORM 1","TERM 2");
                break;
            case "F1T2E3":
                reportFormExam3.printAllResults("tbl_f1_t2_ex3","FORM_1","ex3","FORM 1","TERM 2");
                break;
            case "F1T2AVG":
                reportFormAverage.printAllResults("tbl_f1_t2_avg","FORM_1","avg","tbl_f1_t2","FORM 1","TERM 2");
                break;
            case "F1T3E1":
                reportFormExam1.printAllResults("tbl_f1_t3_ex1","FORM_1","ex1","FORM 1","TERM 3");
                break;
            case "F1T3E2":
                reportFormExam2.printAllResults("tbl_f1_t3_ex2","FORM_1","ex2","FORM 1","TERM 3");
               
                break;
            case "F1T3E3":
                reportFormExam3.printAllResults("tbl_f1_t3_ex3","FORM_1","ex3","FORM 1","TERM 3");
                break;
            case "F1T3AVG":
                reportFormAverage.printAllResults("tbl_f1_t3_avg","FORM_1","avg","tbl_f1_t3","FORM 1","TERM 3");
                break;
            case "F2T1E1":
                reportFormExam1.printAllResults("tbl_f2_t1_ex1","FORM_2","ex1","FORM 2","TERM 1");
                break;
            case "F2T1E2":
                reportFormExam2.printAllResults("tbl_f2_t1_ex2","FORM_2","ex2","FORM 2","TERM 1");
                break;
            case "F2T1E3":
                reportFormExam3.printAllResults("tbl_f2_t1_ex3","FORM_2","ex3","FORM 2","TERM 1");
                break;
            case "F2T1AVG":
                reportFormAverage.printAllResults("tbl_f2_t1_avg","FORM_2","avg","tbl_f2_t1","FORM 2","TERM 1");
                break;
            case "F2T2E1":
                reportFormExam1.printAllResults("tbl_f2_t2_ex1","FORM_2","ex1","FORM 2","TERM 2");
                break;
            case "F2T2E2":
                reportFormExam2.printAllResults("tbl_f2_t2_ex2","FORM_2","ex2","FORM 2","TERM 2");
                break;
            case "F2T2E3":
                reportFormExam3.printAllResults("tbl_f2_t2_ex3","FORM_2","ex3","FORM 2","TERM 2");
                break;
            case "F2T2AVG":
                reportFormAverage.printAllResults("tbl_f2_t2_avg","FORM_2","avg","tbl_f2_t2","FORM 2","TERM 2");
                break;
            case "F2T3E1":
                reportFormExam1.printAllResults("tbl_f2_t3_ex1","FORM_2","ex1","FORM 2","TERM 3");
                break;
            case "F2T3E2":
                reportFormExam2.printAllResults("tbl_f2_t3_ex2","FORM_2","ex2","FORM 2","TERM 3");
                break;
            case "F2T3E3":
                reportFormExam3.printAllResults("tbl_f2_t3_ex3","FORM_2","ex3","FORM 2","TERM 3");
                break;
            case "F2T3AVG":
                reportFormAverage.printAllResults("tbl_f2_t3_avg","FORM_2","avg","tbl_f2_t3","FORM 2","TERM 3");
                break;
            case "F3T1E1":
                reportFormExam1.printAllResults("tbl_f3_t1_ex1","FORM_3","ex1","FORM 3","TERM 1");
                break;
            case "F3T1E2":
                reportFormExam2.printAllResults("tbl_f3_t1_ex2","FORM_3","ex2","FORM 3","TERM 1");
                break;
            case "F3T1E3":
                reportFormExam3.printAllResults("tbl_f3_t1_ex3","FORM_3","ex3","FORM 3","TERM 1");
                break;
            case "F3T1AVG":
                reportFormAverage.printAllResults("tbl_f3_t1_avg","FORM_3","avg","tbl_f3_t1","FORM 3","TERM 1");
                break;
            case "F3T2E1":
                reportFormExam1.printAllResults("tbl_f3_t2_ex1","FORM_3","ex1","FORM 3","TERM 2");
                break;
            case "F3T2E2":
                reportFormExam2.printAllResults("tbl_f3_t2_ex2","FORM_3","ex2","FORM 3","TERM 2");
                break;
            case "F3T2E3":
                reportFormExam3.printAllResults("tbl_f3_t2_ex3","FORM_3","ex3","FORM 3","TERM 2");
                break;
            case "F3T2AVG":
                reportFormAverage.printAllResults("tbl_f3_t2_avg","FORM_3","avg","tbl_f3_t2","FORM 3","TERM 2");
                break;
            case "F3T3E1":
                reportFormExam1.printAllResults("tbl_f3_t3_ex1","FORM_3","ex1","FORM 3","TERM 3");
                break;
            case "F3T3E2":
                reportFormExam2.printAllResults("tbl_f3_t3_ex2","FORM_3","ex2","FORM 3","TERM 3");
                break;
            case "F3T3E3":
                reportFormExam3.printAllResults("tbl_f3_t3_ex3","FORM_3","ex3","FORM 3","TERM 3");
                break;
            case "F3T3AVG":
                reportFormAverage.printAllResults("tbl_f3_t3_avg","FORM_3","avg","tbl_f3_t3","FORM 3","TERM 3");
                break;
            case "F4T1E1":
                System.out.print("Printing");
                reportFormExam1.printAllResults("tbl_f4_t1_ex1","FORM_4","ex1","FORM 4","TERM 1");
                break;
            case "F4T1E2":
                reportFormExam2.printAllResults("tbl_f4_t1_ex2","FORM_4","ex2","FORM 4","TERM 1");
                break;
            case "F4T1E3":
                reportFormExam3.printAllResults("tbl_f4_t1_ex3","FORM_4","ex3","FORM 4","TERM 1");
                break;
            case "F4T1AVG":
                reportFormAverage.printAllResults("tbl_f4_t1_avg","FORM_4","avg","tbl_f4_t1","FORM 4","TERM 1");
                break;
            case "F4T2E1":
                reportFormExam1.printAllResults("tbl_f4_t2_ex1","FORM_4","ex1","FORM 4","TERM 2");
                break;
            case "F4T2E2":
                reportFormExam2.printAllResults("tbl_f4_t2_ex2","FORM_4","ex2","FORM 4","TERM 2");
                break;
            case "F4T2E3":
                reportFormExam3.printAllResults("tbl_f4_t2_ex3","FORM_4","ex3","FORM 4","TERM 2");
                break;
            case "F4T2AVG":
                reportFormAverage.printAllResults("tbl_f4_t2_avg","FORM_4","avg","tbl_f4_t2","FORM 4","TERM 2");
                break;
            case "F4T3E1":
                reportFormExam1.printAllResults("tbl_f4_t3_ex1","FORM_4","ex1","FORM 4","TERM 3");
                break;
            case "F4T3E2":
                reportFormExam2.printAllResults("tbl_f4_t3_ex2","FORM_4","ex2","FORM 4","TERM 3");
                break;
            case "F4T3E3":
                reportFormExam3.printAllResults("tbl_f4_t3_ex3","FORM_4","ex3","FORM 4","TERM 3");
                break;
            case "F4T3AVG":
                reportFormAverage.printAllResults("tbl_f4_t3_avg","FORM_4","avg","tbl_f4_t3","FORM 4","TERM 3");
                break;
            default:
                System.out.print("An error occurred");
        }
    }

    public void printClassReport(){
        ClassReport classReport = new ClassReport();
        classReport.dbTableName=dbTableName;
        classReport.className=dbClassName;
        classReport.docName="classReport.pdf";
        classReport.schoolNm="SAMPLE SCHOOL NAME ";
        classReport.reportTp="REPORT FORM";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane) loader.load(getClass().getResource("/F1/reports/printPassword.fxml"));

            PrintPassword printPassword = (PrintPassword) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Print Password");
            stage.setResizable(false);
            stage.show();
            stageToClose.close();

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void loadData(){
        schoolName.setText(schName);
        className.setText(clsName);
        termName.setText(tmName);
        examName.setText(exName);
        if(clsName.equals("Form 1")||clsName.equals("Form 2")){
        String sql = "SELECT * FROM " +dbTableName+" WHERE class='"+dbClassName+"' ORDER BY total DESC";
        try{
            Connection connection = Database.DBConnection.getConnection();
            this.tableList = FXCollections.observableArrayList();
            ResultSet resultSet = connection.createStatement().executeQuery(sql);
            while (resultSet.next()){
                this.tableList.addAll(new tableData(resultSet.getString(2),resultSet.getString(3)+" "+resultSet.getString(4)+" "+resultSet.getString(5),resultSet.getString(8),resultSet.getString(9),resultSet.getString(11),resultSet.getString(12),resultSet.getString(14),resultSet.getString(15),resultSet.getString(17),resultSet.getString(18),resultSet.getString(20),resultSet.getString(21),resultSet.getString(23),resultSet.getString(24),resultSet.getString(26),resultSet.getString(27),resultSet.getString(29),resultSet.getString(30),resultSet.getString(32),resultSet.getString(33),resultSet.getString(35),resultSet.getString(36),resultSet.getString(38),resultSet.getString(39),resultSet.getString(41),resultSet.getString(42),resultSet.getString(43),resultSet.getString(6)));
            }

            this.admCol.setCellValueFactory(new PropertyValueFactory<>("adm"));
            this.nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
            this.engCol.setCellValueFactory(new PropertyValueFactory<>("eng"));
            this.engGr.setCellValueFactory(new PropertyValueFactory<>("engg"));
            this.kisCol.setCellValueFactory(new PropertyValueFactory<>("kis"));
            this.kisGr.setCellValueFactory(new PropertyValueFactory<>("kisg"));
            this.matCol.setCellValueFactory(new PropertyValueFactory<>("mat"));
            this.matGr.setCellValueFactory(new PropertyValueFactory<>("matg"));
            this.bioCol.setCellValueFactory(new PropertyValueFactory<>("bio"));
            this.bioGr.setCellValueFactory(new PropertyValueFactory<>("biog"));
            this.chemCol.setCellValueFactory(new PropertyValueFactory<>("chem"));
            this.chemGr.setCellValueFactory(new PropertyValueFactory<>("chemg"));
            this.phyCol.setCellValueFactory(new PropertyValueFactory<>("phy"));
            this.phyGr.setCellValueFactory(new PropertyValueFactory<>("phyg"));
            this.geoCol.setCellValueFactory(new PropertyValueFactory<>("geo"));
            this.geoGr.setCellValueFactory(new PropertyValueFactory<>("geog"));
            this.hisCol.setCellValueFactory(new PropertyValueFactory<>("his"));
            this.hisGr.setCellValueFactory(new PropertyValueFactory<>("hisg"));
            this.creCol.setCellValueFactory(new PropertyValueFactory<>("cre"));
            this.creGr.setCellValueFactory(new PropertyValueFactory<>("creg"));
            this.busCol.setCellValueFactory(new PropertyValueFactory<>("bus"));
            this.busGr.setCellValueFactory(new PropertyValueFactory<>("busg"));
            this.agriCol.setCellValueFactory(new PropertyValueFactory<>("agri"));
            this.agriGr.setCellValueFactory(new PropertyValueFactory<>("agrig"));
            this.totalCol.setCellValueFactory(new PropertyValueFactory<>("total"));
            this.avgCol.setCellValueFactory(new PropertyValueFactory<>("avg"));
            this.pointsCol.setCellValueFactory(new PropertyValueFactory<>("points"));
            this.kcpeCol.setCellValueFactory(new PropertyValueFactory<>("kcpe"));

            this.tableResults.setItems(null);
            this.tableResults.setItems(this.tableList);
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }}else{
        String sql = "SELECT * FROM " +dbTableName+" WHERE class='"+dbClassName+"' ORDER BY pt DESC";
        try{
            Connection connection = Database.DBConnection.getConnection();
            this.tableList = FXCollections.observableArrayList();
            ResultSet resultSet = connection.createStatement().executeQuery(sql);
            while (resultSet.next()){
                this.tableList.addAll(new tableData(resultSet.getString(2),resultSet.getString(3)+" "+resultSet.getString(4)+" "+resultSet.getString(5),resultSet.getString(8),resultSet.getString(9),resultSet.getString(11),resultSet.getString(12),resultSet.getString(14),resultSet.getString(15),resultSet.getString(17),resultSet.getString(18),resultSet.getString(20),resultSet.getString(21),resultSet.getString(23),resultSet.getString(24),resultSet.getString(26),resultSet.getString(27),resultSet.getString(29),resultSet.getString(30),resultSet.getString(32),resultSet.getString(33),resultSet.getString(35),resultSet.getString(36),resultSet.getString(38),resultSet.getString(39),resultSet.getString(41),resultSet.getString(42),resultSet.getString(43),resultSet.getString(6)));
            }

            this.admCol.setCellValueFactory(new PropertyValueFactory<>("adm"));
            this.nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
            this.engCol.setCellValueFactory(new PropertyValueFactory<>("eng"));
            this.engGr.setCellValueFactory(new PropertyValueFactory<>("engg"));
            this.kisCol.setCellValueFactory(new PropertyValueFactory<>("kis"));
            this.kisGr.setCellValueFactory(new PropertyValueFactory<>("kisg"));
            this.matCol.setCellValueFactory(new PropertyValueFactory<>("mat"));
            this.matGr.setCellValueFactory(new PropertyValueFactory<>("matg"));
            this.bioCol.setCellValueFactory(new PropertyValueFactory<>("bio"));
            this.bioGr.setCellValueFactory(new PropertyValueFactory<>("biog"));
            this.chemCol.setCellValueFactory(new PropertyValueFactory<>("chem"));
            this.chemGr.setCellValueFactory(new PropertyValueFactory<>("chemg"));
            this.phyCol.setCellValueFactory(new PropertyValueFactory<>("phy"));
            this.phyGr.setCellValueFactory(new PropertyValueFactory<>("phyg"));
            this.geoCol.setCellValueFactory(new PropertyValueFactory<>("geo"));
            this.geoGr.setCellValueFactory(new PropertyValueFactory<>("geog"));
            this.hisCol.setCellValueFactory(new PropertyValueFactory<>("his"));
            this.hisGr.setCellValueFactory(new PropertyValueFactory<>("hisg"));
            this.creCol.setCellValueFactory(new PropertyValueFactory<>("cre"));
            this.creGr.setCellValueFactory(new PropertyValueFactory<>("creg"));
            this.busCol.setCellValueFactory(new PropertyValueFactory<>("bus"));
            this.busGr.setCellValueFactory(new PropertyValueFactory<>("busg"));
            this.agriCol.setCellValueFactory(new PropertyValueFactory<>("agri"));
            this.agriGr.setCellValueFactory(new PropertyValueFactory<>("agrig"));
            this.totalCol.setCellValueFactory(new PropertyValueFactory<>("total"));
            this.avgCol.setCellValueFactory(new PropertyValueFactory<>("avg"));
            this.pointsCol.setCellValueFactory(new PropertyValueFactory<>("points"));
            this.kcpeCol.setCellValueFactory(new PropertyValueFactory<>("kcpe"));

            this.tableResults.setItems(null);
            this.tableResults.setItems(this.tableList);
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    }

    private void calcTotal(){
        String sqlDet = "SELECT * FROM " +dbTableName+" WHERE class='"+dbClassName+"'";
        String sqlUpdate = "UPDATE " +dbTableName+" SET total=? WHERE adm=?";
        String sqlUpdate2 = "UPDATE " +dbTableName+" SET grade=?,pt=? WHERE adm=?";
        String sqlGrade = "SELECT * FROM tbl_grades WHERE class='"+dbClassName+"' AND subject='TOTAL'";
        String sqlSelection = "SELECT * FROM tbl_subject_selection WHERE adm=? ";
        try{
            System.out.println(dbTableName);
            System.out.println(dbClassName);
            Connection connection = Database.DBConnection.getConnection();
            ResultSet set = connection.createStatement().executeQuery(sqlDet);
            ResultSet setGrade = connection.createStatement().executeQuery(sqlGrade);
            PreparedStatement statement2 = connection.prepareStatement(sqlUpdate2);
            PreparedStatement statement = connection.prepareStatement(sqlUpdate);

            while (set.next()) {
                String adm = set.getString(2);
                PreparedStatement statementSel = connection.prepareStatement(sqlSelection);
                statementSel.setString(1, adm);
                ResultSet subSelSet = statementSel.executeQuery();
                //
                while (subSelSet.next()){
                String bio = subSelSet.getString(11);
                String phy = subSelSet.getString(13);
                String geo = subSelSet.getString(14);
                String his = subSelSet.getString(15);
                String cre = subSelSet.getString(16);
                String bus = subSelSet.getString(17);
                String agri = subSelSet.getString(18);
                System.out.println(bio);
                if (Integer.parseInt(bio) == 1 && Integer.parseInt(phy) == 1 && Integer.parseInt(geo) == 1 && Integer.parseInt(his) == 1 && Integer.parseInt(cre) == 1 && Integer.parseInt(bus) == 1 && Integer.parseInt(agri) == 1) {
                    addAllSubjects(adm, set, setGrade, connection, sqlUpdate, sqlUpdate2, statement, statement2);
                } else {

                    if (Integer.parseInt(bio) == 0) {
                        //you are doing physics
                        if (Integer.parseInt(geo) == 1) {
                            if (Integer.parseInt(bus) == 1) {
                                addPhyGeoBus(adm, set, setGrade, connection, sqlUpdate, sqlUpdate2, statement, statement2);
                            } else {
                                addPhyGeoAgri(adm, set, setGrade, connection, sqlUpdate, sqlUpdate2, statement, statement2);
                            }
                        } else if (Integer.parseInt(his) == 1) {
                            if (Integer.parseInt(bus) == 1) {
                                addPhyHisBus(adm, set, setGrade, connection, sqlUpdate, sqlUpdate2, statement, statement2);
                            } else {
                                addPhyHisAgri(adm, set, setGrade, connection, sqlUpdate, sqlUpdate2, statement, statement2);
                            }
                        } else {
                            if (Integer.parseInt(bus) == 1) {
                                addPhyCreBus(adm, set, setGrade, connection, sqlUpdate, sqlUpdate2, statement, statement2);
                            } else {
                                addPhyCreAgri(adm, set, setGrade, connection, sqlUpdate, sqlUpdate2, statement, statement2);
                            }
                        }

                    } else {
                        //you are doing biology
                        if (Integer.parseInt(geo) == 1) {
                            if (Integer.parseInt(bus) == 1) {
                                addBioGeoBus(adm, set, setGrade, connection, sqlUpdate, sqlUpdate2, statement, statement2);
                            } else {
                                addBioGeoAgri(adm, set, setGrade, connection, sqlUpdate, sqlUpdate2, statement, statement2);
                            }
                        } else if (Integer.parseInt(his) == 1) {
                            if (Integer.parseInt(bus) == 1) {
                                addBioHisBus(adm, set, setGrade, connection, sqlUpdate, sqlUpdate2, statement, statement2);
                            } else {
                                addBioHisAgri(adm, set, setGrade, connection, sqlUpdate, sqlUpdate2, statement, statement2);
                            }
                        } else {
                            if (Integer.parseInt(bus) == 1) {
                                addBioCreBus(adm, set, setGrade, connection, sqlUpdate, sqlUpdate2, statement, statement2);
                            } else {
                                addBioCreAgri(adm, set, setGrade, connection, sqlUpdate, sqlUpdate2, statement, statement2);
                            }
                        }
                    }
                }
            }

            }
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void addBioCreBus(String adm, ResultSet set, ResultSet setGrade, Connection connection, String sqlUpdate, String sqlUpdate2, PreparedStatement statement, PreparedStatement statement2) {
        try {
            float addTotal = Float.parseFloat(set.getString(8)) + Float.parseFloat(set.getString(11)) + Float.parseFloat(set.getString(14)) + Float.parseFloat(set.getString(20)) + Float.parseFloat(set.getString(17)) + Float.parseFloat(set.getString(32))+ Float.parseFloat(set.getString(35));
            float addPoints = Float.parseFloat(set.getString(10)) + Float.parseFloat(set.getString(13)) + Float.parseFloat(set.getString(16)) + Float.parseFloat(set.getString(22)) + Float.parseFloat(set.getString(19)) + Float.parseFloat(set.getString(34))+ Float.parseFloat(set.getString(37));

            String avgP = String.format("%.1f",(addPoints/7));
            statement2 = connection.prepareStatement(sqlUpdate2);
            statement = connection.prepareStatement(sqlUpdate);
            statement.setString(1, String.valueOf((int)addTotal));
            statement.setString(2, set.getString(2));
            String g = "";
            if (Float.parseFloat(avgP)>=11.5) { g = "A"; } else if (Float.parseFloat(avgP)>=10.5) {
                g = "A-"; } else if (Float.parseFloat(avgP)>=9.5) { g = "B+"; } else if (Float.parseFloat(avgP)>=8.5) {
                g = "B"; } else if (Float.parseFloat(avgP)>=7.5) {
                g = "B-"; } else if (Float.parseFloat(avgP)>=6.5) {
                g = "C+"; } else if (Float.parseFloat(avgP)>=5.5) {
                g = "C"; } else if (Float.parseFloat(avgP)>=4.5) {
                g = "C-"; } else if (Float.parseFloat(avgP)>=3.5) {
                g = "D+"; } else if (Float.parseFloat(avgP)>=2.5) {
                g = "D"; } else if (Float.parseFloat(avgP)>=1.5) {
                g = "D-"; } else { g = "E"; }

            statement2.setString(1, g.toUpperCase());
            statement2.setString(2,avgP);
            statement2.setString(3, adm.toString());
            statement2.execute();
            statement.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void addBioCreAgri(String adm, ResultSet set, ResultSet setGrade, Connection connection, String sqlUpdate, String sqlUpdate2, PreparedStatement statement, PreparedStatement statement2) {
        try {
            float addTotal = Float.parseFloat(set.getString(8)) + Float.parseFloat(set.getString(11)) + Float.parseFloat(set.getString(14)) + Float.parseFloat(set.getString(20)) + Float.parseFloat(set.getString(17)) + Float.parseFloat(set.getString(32))+ Float.parseFloat(set.getString(38));
            float addPoints = Float.parseFloat(set.getString(10)) + Float.parseFloat(set.getString(13)) + Float.parseFloat(set.getString(16)) + Float.parseFloat(set.getString(22)) + Float.parseFloat(set.getString(19)) + Float.parseFloat(set.getString(34))+ Float.parseFloat(set.getString(40));

            String avgP = String.format("%.1f",(addPoints/7));
            statement2 = connection.prepareStatement(sqlUpdate2);
            statement = connection.prepareStatement(sqlUpdate);
            statement.setString(1, String.valueOf((int)addTotal));
            statement.setString(2, set.getString(2));
            String g = "";
            if (Float.parseFloat(avgP)>=11.5) { g = "A"; } else if (Float.parseFloat(avgP)>=10.5) {
                g = "A-"; } else if (Float.parseFloat(avgP)>=9.5) { g = "B+"; } else if (Float.parseFloat(avgP)>=8.5) {
                g = "B"; } else if (Float.parseFloat(avgP)>=7.5) {
                g = "B-"; } else if (Float.parseFloat(avgP)>=6.5) {
                g = "C+"; } else if (Float.parseFloat(avgP)>=5.5) {
                g = "C"; } else if (Float.parseFloat(avgP)>=4.5) {
                g = "C-"; } else if (Float.parseFloat(avgP)>=3.5) {
                g = "D+"; } else if (Float.parseFloat(avgP)>=2.5) {
                g = "D"; } else if (Float.parseFloat(avgP)>=1.5) {
                g = "D-"; } else { g = "E"; }

            statement2.setString(1, g.toUpperCase());
            statement2.setString(2,avgP);
            statement2.setString(3, adm.toString());
            statement2.execute();
            statement.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void addBioHisAgri(String adm, ResultSet set, ResultSet setGrade, Connection connection, String sqlUpdate, String sqlUpdate2, PreparedStatement statement, PreparedStatement statement2) {
        try {
            float addTotal = Float.parseFloat(set.getString(8)) + Float.parseFloat(set.getString(11)) + Float.parseFloat(set.getString(14)) + Float.parseFloat(set.getString(20)) + Float.parseFloat(set.getString(17)) + Float.parseFloat(set.getString(29))+ Float.parseFloat(set.getString(38));
            float addPoints = Float.parseFloat(set.getString(10)) + Float.parseFloat(set.getString(13)) + Float.parseFloat(set.getString(16)) + Float.parseFloat(set.getString(22)) + Float.parseFloat(set.getString(19)) + Float.parseFloat(set.getString(31))+ Float.parseFloat(set.getString(40));

            String avgP = String.format("%.1f",(addPoints/7));
            statement2 = connection.prepareStatement(sqlUpdate2);
            statement = connection.prepareStatement(sqlUpdate);
            statement.setString(1, String.valueOf((int)addTotal));
            statement.setString(2, set.getString(2));
            String g = "";
            if (Float.parseFloat(avgP)>=11.5) { g = "A"; } else if (Float.parseFloat(avgP)>=10.5) {
                g = "A-"; } else if (Float.parseFloat(avgP)>=9.5) { g = "B+"; } else if (Float.parseFloat(avgP)>=8.5) {
                g = "B"; } else if (Float.parseFloat(avgP)>=7.5) {
                g = "B-"; } else if (Float.parseFloat(avgP)>=6.5) {
                g = "C+"; } else if (Float.parseFloat(avgP)>=5.5) {
                g = "C"; } else if (Float.parseFloat(avgP)>=4.5) {
                g = "C-"; } else if (Float.parseFloat(avgP)>=3.5) {
                g = "D+"; } else if (Float.parseFloat(avgP)>=2.5) {
                g = "D"; } else if (Float.parseFloat(avgP)>=1.5) {
                g = "D-"; } else { g = "E"; }

            statement2.setString(1, g.toUpperCase());
            statement2.setString(2,avgP);
            statement2.setString(3, adm.toString());
            statement2.execute();
            statement.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void addBioHisBus(String adm, ResultSet set, ResultSet setGrade, Connection connection, String sqlUpdate, String sqlUpdate2, PreparedStatement statement, PreparedStatement statement2) {
        try {
            float addTotal = Float.parseFloat(set.getString(8)) + Float.parseFloat(set.getString(11)) + Float.parseFloat(set.getString(14)) + Float.parseFloat(set.getString(20)) + Float.parseFloat(set.getString(17)) + Float.parseFloat(set.getString(29))+ Float.parseFloat(set.getString(35));
            float addPoints = Float.parseFloat(set.getString(10)) + Float.parseFloat(set.getString(13)) + Float.parseFloat(set.getString(16)) + Float.parseFloat(set.getString(22)) + Float.parseFloat(set.getString(19)) + Float.parseFloat(set.getString(31))+ Float.parseFloat(set.getString(37));

            String avgP = String.format("%.1f",(addPoints/7));
            statement2 = connection.prepareStatement(sqlUpdate2);
            statement = connection.prepareStatement(sqlUpdate);
            statement.setString(1, String.valueOf((int)addTotal));
            statement.setString(2, set.getString(2));
            String g = "";
            if (Float.parseFloat(avgP)>=11.5) { g = "A"; } else if (Float.parseFloat(avgP)>=10.5) {
                g = "A-"; } else if (Float.parseFloat(avgP)>=9.5) { g = "B+"; } else if (Float.parseFloat(avgP)>=8.5) {
                g = "B"; } else if (Float.parseFloat(avgP)>=7.5) {
                g = "B-"; } else if (Float.parseFloat(avgP)>=6.5) {
                g = "C+"; } else if (Float.parseFloat(avgP)>=5.5) {
                g = "C"; } else if (Float.parseFloat(avgP)>=4.5) {
                g = "C-"; } else if (Float.parseFloat(avgP)>=3.5) {
                g = "D+"; } else if (Float.parseFloat(avgP)>=2.5) {
                g = "D"; } else if (Float.parseFloat(avgP)>=1.5) {
                g = "D-"; } else { g = "E"; }

            statement2.setString(1, g.toUpperCase());
            statement2.setString(2,avgP);
            statement2.setString(3, adm.toString());
            statement2.execute();
            statement.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void addBioGeoAgri(String adm, ResultSet set, ResultSet setGrade, Connection connection, String sqlUpdate, String sqlUpdate2, PreparedStatement statement, PreparedStatement statement2) {
        try {
            float addTotal = Float.parseFloat(set.getString(8)) + Float.parseFloat(set.getString(11)) + Float.parseFloat(set.getString(14)) + Float.parseFloat(set.getString(20)) + Float.parseFloat(set.getString(17)) + Float.parseFloat(set.getString(26))+ Float.parseFloat(set.getString(38));
            float addPoints = Float.parseFloat(set.getString(10)) + Float.parseFloat(set.getString(13)) + Float.parseFloat(set.getString(16)) + Float.parseFloat(set.getString(22)) + Float.parseFloat(set.getString(19)) + Float.parseFloat(set.getString(28))+ Float.parseFloat(set.getString(40));

            String avgP = String.format("%.1f",(addPoints/7));
            statement2 = connection.prepareStatement(sqlUpdate2);
            statement = connection.prepareStatement(sqlUpdate);
            statement.setString(1, String.valueOf((int)addTotal));
            statement.setString(2, set.getString(2));
            String g = "";
            if (Float.parseFloat(avgP)>=11.5) { g = "A"; } else if (Float.parseFloat(avgP)>=10.5) {
                g = "A-"; } else if (Float.parseFloat(avgP)>=9.5) { g = "B+"; } else if (Float.parseFloat(avgP)>=8.5) {
                g = "B"; } else if (Float.parseFloat(avgP)>=7.5) {
                g = "B-"; } else if (Float.parseFloat(avgP)>=6.5) {
                g = "C+"; } else if (Float.parseFloat(avgP)>=5.5) {
                g = "C"; } else if (Float.parseFloat(avgP)>=4.5) {
                g = "C-"; } else if (Float.parseFloat(avgP)>=3.5) {
                g = "D+"; } else if (Float.parseFloat(avgP)>=2.5) {
                g = "D"; } else if (Float.parseFloat(avgP)>=1.5) {
                g = "D-"; } else { g = "E"; }

            statement2.setString(1, g.toUpperCase());
            statement2.setString(2,avgP);
            statement2.setString(3, adm.toString());
            statement2.execute();
            statement.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void addBioGeoBus(String adm, ResultSet set, ResultSet setGrade, Connection connection, String sqlUpdate, String sqlUpdate2, PreparedStatement statement, PreparedStatement statement2) {
        try {
            float addTotal = Float.parseFloat(set.getString(8)) + Float.parseFloat(set.getString(11)) + Float.parseFloat(set.getString(14)) + Float.parseFloat(set.getString(20)) + Float.parseFloat(set.getString(17)) + Float.parseFloat(set.getString(26))+ Float.parseFloat(set.getString(35));
            float addPoints = Float.parseFloat(set.getString(10)) + Float.parseFloat(set.getString(13)) + Float.parseFloat(set.getString(16)) + Float.parseFloat(set.getString(22)) + Float.parseFloat(set.getString(19)) + Float.parseFloat(set.getString(28))+ Float.parseFloat(set.getString(37));

            String avgP = String.format("%.1f",(addPoints/7));
            statement2 = connection.prepareStatement(sqlUpdate2);
            statement = connection.prepareStatement(sqlUpdate);
            statement.setString(1, String.valueOf((int)addTotal));
            statement.setString(2, set.getString(2));
            String g = "";
            if (Float.parseFloat(avgP)>=11.5) { g = "A"; } else if (Float.parseFloat(avgP)>=10.5) {
                g = "A-"; } else if (Float.parseFloat(avgP)>=9.5) { g = "B+"; } else if (Float.parseFloat(avgP)>=8.5) {
                g = "B"; } else if (Float.parseFloat(avgP)>=7.5) {
                g = "B-"; } else if (Float.parseFloat(avgP)>=6.5) {
                g = "C+"; } else if (Float.parseFloat(avgP)>=5.5) {
                g = "C"; } else if (Float.parseFloat(avgP)>=4.5) {
                g = "C-"; } else if (Float.parseFloat(avgP)>=3.5) {
                g = "D+"; } else if (Float.parseFloat(avgP)>=2.5) {
                g = "D"; } else if (Float.parseFloat(avgP)>=1.5) {
                g = "D-"; } else { g = "E"; }

            statement2.setString(1, g.toUpperCase());
            statement2.setString(2,avgP);
            statement2.setString(3, adm.toString());
            statement2.execute();
            statement.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void addPhyCreAgri(String adm, ResultSet set, ResultSet setGrade, Connection connection, String sqlUpdate, String sqlUpdate2, PreparedStatement statement, PreparedStatement statement2) {
        try {
            float addTotal = Float.parseFloat(set.getString(8)) + Float.parseFloat(set.getString(11)) + Float.parseFloat(set.getString(14)) + Float.parseFloat(set.getString(20)) + Float.parseFloat(set.getString(23)) + Float.parseFloat(set.getString(32))+ Float.parseFloat(set.getString(38));
            float addPoints = Float.parseFloat(set.getString(10)) + Float.parseFloat(set.getString(13)) + Float.parseFloat(set.getString(16)) + Float.parseFloat(set.getString(22)) + Float.parseFloat(set.getString(25)) + Float.parseFloat(set.getString(34))+ Float.parseFloat(set.getString(40));

            String avgP = String.format("%.1f",(addPoints/7));
            statement2 = connection.prepareStatement(sqlUpdate2);
            statement = connection.prepareStatement(sqlUpdate);
            statement.setString(1, String.valueOf((int)addTotal));
            statement.setString(2, set.getString(2));
            String g,p = "";
            if (Float.parseFloat(avgP)>=11.5) { g = "A"; } else if (Float.parseFloat(avgP)>=10.5) {
                g = "A-"; } else if (Float.parseFloat(avgP)>=9.5) { g = "B+"; } else if (Float.parseFloat(avgP)>=8.5) {
                g = "B"; } else if (Float.parseFloat(avgP)>=7.5) {
                g = "B-"; } else if (Float.parseFloat(avgP)>=6.5) {
                g = "C+"; } else if (Float.parseFloat(avgP)>=5.5) {
                g = "C"; } else if (Float.parseFloat(avgP)>=4.5) {
                g = "C-"; } else if (Float.parseFloat(avgP)>=3.5) {
                g = "D+"; } else if (Float.parseFloat(avgP)>=2.5) {
                g = "D"; } else if (Float.parseFloat(avgP)>=1.5) {
                g = "D-"; } else { g = "E"; }

            statement2.setString(1, g.toUpperCase());
            statement2.setString(2,avgP);
            statement2.setString(3, adm.toString());
            statement2.execute();
            statement.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void addPhyCreBus(String adm, ResultSet set, ResultSet setGrade, Connection connection, String sqlUpdate, String sqlUpdate2, PreparedStatement statement, PreparedStatement statement2) {
        try {
            float addTotal = Float.parseFloat(set.getString(8)) + Float.parseFloat(set.getString(11)) + Float.parseFloat(set.getString(14)) + Float.parseFloat(set.getString(20)) + Float.parseFloat(set.getString(23)) + Float.parseFloat(set.getString(32))+ Float.parseFloat(set.getString(35));
            float addPoints = Float.parseFloat(set.getString(10)) + Float.parseFloat(set.getString(13)) + Float.parseFloat(set.getString(16)) + Float.parseFloat(set.getString(22)) + Float.parseFloat(set.getString(25)) + Float.parseFloat(set.getString(34))+ Float.parseFloat(set.getString(37));

            String avgP = String.format("%.1f",(addPoints/7));
            statement2 = connection.prepareStatement(sqlUpdate2);
            statement = connection.prepareStatement(sqlUpdate);
            statement.setString(1, String.valueOf((int)addTotal));
            statement.setString(2, set.getString(2));
            String g = "";
            if (Float.parseFloat(avgP)>=11.5) { g = "A"; } else if (Float.parseFloat(avgP)>=10.5) {
                g = "A-"; } else if (Float.parseFloat(avgP)>=9.5) { g = "B+"; } else if (Float.parseFloat(avgP)>=8.5) {
                g = "B"; } else if (Float.parseFloat(avgP)>=7.5) {
                g = "B-"; } else if (Float.parseFloat(avgP)>=6.5) {
                g = "C+"; } else if (Float.parseFloat(avgP)>=5.5) {
                g = "C"; } else if (Float.parseFloat(avgP)>=4.5) {
                g = "C-"; } else if (Float.parseFloat(avgP)>=3.5) {
                g = "D+"; } else if (Float.parseFloat(avgP)>=2.5) {
                g = "D"; } else if (Float.parseFloat(avgP)>=1.5) {
                g = "D-"; } else { g = "E"; }

            statement2.setString(1, g.toUpperCase());
            statement2.setString(2,avgP);
            statement2.setString(3, adm.toString());
            statement2.execute();
            statement.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void addPhyHisAgri(String adm, ResultSet set, ResultSet setGrade, Connection connection, String sqlUpdate, String sqlUpdate2, PreparedStatement statement, PreparedStatement statement2) {
        try {
            float addTotal = Float.parseFloat(set.getString(8)) + Float.parseFloat(set.getString(11)) + Float.parseFloat(set.getString(14)) + Float.parseFloat(set.getString(20)) + Float.parseFloat(set.getString(23)) + Float.parseFloat(set.getString(29))+ Float.parseFloat(set.getString(38));
            float addPoints = Float.parseFloat(set.getString(10)) + Float.parseFloat(set.getString(13)) + Float.parseFloat(set.getString(16)) + Float.parseFloat(set.getString(22)) + Float.parseFloat(set.getString(25)) + Float.parseFloat(set.getString(31))+ Float.parseFloat(set.getString(40));

            String avgP = String.format("%.1f",(addPoints/7));
            statement2 = connection.prepareStatement(sqlUpdate2);
            statement = connection.prepareStatement(sqlUpdate);
            statement.setString(1, String.valueOf((int)addTotal));
            statement.setString(2, set.getString(2));
            String g = "";
            if (Float.parseFloat(avgP)>=11.5) { g = "A"; } else if (Float.parseFloat(avgP)>=10.5) {
                g = "A-"; } else if (Float.parseFloat(avgP)>=9.5) { g = "B+"; } else if (Float.parseFloat(avgP)>=8.5) {
                g = "B"; } else if (Float.parseFloat(avgP)>=7.5) {
                g = "B-"; } else if (Float.parseFloat(avgP)>=6.5) {
                g = "C+"; } else if (Float.parseFloat(avgP)>=5.5) {
                g = "C"; } else if (Float.parseFloat(avgP)>=4.5) {
                g = "C-"; } else if (Float.parseFloat(avgP)>=3.5) {
                g = "D+"; } else if (Float.parseFloat(avgP)>=2.5) {
                g = "D"; } else if (Float.parseFloat(avgP)>=1.5) {
                g = "D-"; } else { g = "E"; }

            statement2.setString(1, g.toUpperCase());
            statement2.setString(2,avgP);
            statement2.setString(3, adm.toString());
            statement2.execute();
            statement.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void addPhyHisBus(String adm, ResultSet set, ResultSet setGrade, Connection connection, String sqlUpdate, String sqlUpdate2, PreparedStatement statement, PreparedStatement statement2) {
        try {
            float addTotal = Float.parseFloat(set.getString(8)) + Float.parseFloat(set.getString(11)) + Float.parseFloat(set.getString(14)) + Float.parseFloat(set.getString(20)) + Float.parseFloat(set.getString(23)) + Float.parseFloat(set.getString(29))+ Float.parseFloat(set.getString(35));
            float addPoints = Float.parseFloat(set.getString(10)) + Float.parseFloat(set.getString(13)) + Float.parseFloat(set.getString(16)) + Float.parseFloat(set.getString(22)) + Float.parseFloat(set.getString(25)) + Float.parseFloat(set.getString(31))+ Float.parseFloat(set.getString(37));

            String avgP = String.format("%.1f",(addPoints/7));
            statement2 = connection.prepareStatement(sqlUpdate2);
            statement = connection.prepareStatement(sqlUpdate);
            statement.setString(1, String.valueOf((int)addTotal));
            statement.setString(2, set.getString(2));
            String g = "";
            if (Float.parseFloat(avgP)>=11.5) { g = "A"; } else if (Float.parseFloat(avgP)>=10.5) {
                g = "A-"; } else if (Float.parseFloat(avgP)>=9.5) { g = "B+"; } else if (Float.parseFloat(avgP)>=8.5) {
                g = "B"; } else if (Float.parseFloat(avgP)>=7.5) {
                g = "B-"; } else if (Float.parseFloat(avgP)>=6.5) {
                g = "C+"; } else if (Float.parseFloat(avgP)>=5.5) {
                g = "C"; } else if (Float.parseFloat(avgP)>=4.5) {
                g = "C-"; } else if (Float.parseFloat(avgP)>=3.5) {
                g = "D+"; } else if (Float.parseFloat(avgP)>=2.5) {
                g = "D"; } else if (Float.parseFloat(avgP)>=1.5) {
                g = "D-"; } else { g = "E"; }

            statement2.setString(1, g.toUpperCase());
            statement2.setString(2,avgP);
            statement2.setString(3, adm.toString());
            statement2.execute();
            statement.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void addPhyGeoAgri(String adm, ResultSet set, ResultSet setGrade, Connection connection, String sqlUpdate, String sqlUpdate2, PreparedStatement statement, PreparedStatement statement2) {
        try {
            float addTotal = Float.parseFloat(set.getString(8)) + Float.parseFloat(set.getString(11)) + Float.parseFloat(set.getString(14)) + Float.parseFloat(set.getString(20)) + Float.parseFloat(set.getString(23)) + Float.parseFloat(set.getString(26))+ Float.parseFloat(set.getString(38));
            float addPoints = Float.parseFloat(set.getString(10)) + Float.parseFloat(set.getString(13)) + Float.parseFloat(set.getString(16)) + Float.parseFloat(set.getString(22)) + Float.parseFloat(set.getString(25)) + Float.parseFloat(set.getString(28))+ Float.parseFloat(set.getString(40));

            String avgP = String.format("%.1f",(addPoints/7));
            statement2 = connection.prepareStatement(sqlUpdate2);
            statement = connection.prepareStatement(sqlUpdate);
            statement.setString(1, String.valueOf((int)addTotal));
            statement.setString(2, set.getString(2));
            String g = "";
            if (Float.parseFloat(avgP)>=11.5) { g = "A"; } else if (Float.parseFloat(avgP)>=10.5) {
                g = "A-"; } else if (Float.parseFloat(avgP)>=9.5) { g = "B+"; } else if (Float.parseFloat(avgP)>=8.5) {
                g = "B"; } else if (Float.parseFloat(avgP)>=7.5) {
                g = "B-"; } else if (Float.parseFloat(avgP)>=6.5) {
                g = "C+"; } else if (Float.parseFloat(avgP)>=5.5) {
                g = "C"; } else if (Float.parseFloat(avgP)>=4.5) {
                g = "C-"; } else if (Float.parseFloat(avgP)>=3.5) {
                g = "D+"; } else if (Float.parseFloat(avgP)>=2.5) {
                g = "D"; } else if (Float.parseFloat(avgP)>=1.5) {
                g = "D-"; } else { g = "E"; }

            statement2.setString(1, g.toUpperCase());
            statement2.setString(2,avgP);
            statement2.setString(3, adm.toString());
            statement2.execute();
            statement.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void addPhyGeoBus(String adm, ResultSet set, ResultSet setGrade, Connection connection, String sqlUpdate,String sqlUpdate2,PreparedStatement statement,PreparedStatement statement2) {
        try {
            float addTotal = Float.parseFloat(set.getString(8)) + Float.parseFloat(set.getString(11)) + Float.parseFloat(set.getString(14)) + Float.parseFloat(set.getString(20)) + Float.parseFloat(set.getString(23)) + Float.parseFloat(set.getString(26))+ Float.parseFloat(set.getString(35));
            float addPoints = Float.parseFloat(set.getString(10)) + Float.parseFloat(set.getString(13)) + Float.parseFloat(set.getString(16)) + Float.parseFloat(set.getString(22)) + Float.parseFloat(set.getString(25)) + Float.parseFloat(set.getString(28))+ Float.parseFloat(set.getString(37));

            String avgP = String.format("%.1f",(addPoints/7));
            statement2 = connection.prepareStatement(sqlUpdate2);
            statement = connection.prepareStatement(sqlUpdate);
            statement.setString(1, String.valueOf((int)addTotal));
            statement.setString(2, set.getString(2));
            String g = "";
            if (Float.parseFloat(avgP)>=11.5) { g = "A"; } else if (Float.parseFloat(avgP)>=10.5) {
                g = "A-"; } else if (Float.parseFloat(avgP)>=9.5) { g = "B+"; } else if (Float.parseFloat(avgP)>=8.5) {
                g = "B"; } else if (Float.parseFloat(avgP)>=7.5) {
                g = "B-"; } else if (Float.parseFloat(avgP)>=6.5) {
                g = "C+"; } else if (Float.parseFloat(avgP)>=5.5) {
                g = "C"; } else if (Float.parseFloat(avgP)>=4.5) {
                g = "C-"; } else if (Float.parseFloat(avgP)>=3.5) {
                g = "D+"; } else if (Float.parseFloat(avgP)>=2.5) {
                g = "D"; } else if (Float.parseFloat(avgP)>=1.5) {
                g = "D-"; } else { g = "E"; }

            statement2.setString(1, g.toUpperCase());
            statement2.setString(2,avgP);
            statement2.setString(3, adm.toString());
            statement2.execute();
            statement.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void addAllSubjects(String adm, ResultSet set, ResultSet setGrade, Connection connection, String sqlUpdate,String sqlUpdate2,PreparedStatement statement,PreparedStatement statement2) {
        try {
            float addTotal =  (Float.parseFloat(set.getString(8)) + Float.parseFloat(set.getString(11)) + Float.parseFloat(set.getString(14)) + Float.parseFloat(set.getString(17)) + Float.parseFloat(set.getString(20)) + Float.parseFloat(set.getString(23)) + Float.parseFloat(set.getString(26)) + Float.parseFloat(set.getString(29)) + Float.parseFloat(set.getString(32)) + Float.parseFloat(set.getString(35)) + Float.parseFloat(set.getString(38)));
            float addPoints = Float.parseFloat(set.getString(10)) + Float.parseFloat(set.getString(13)) + Float.parseFloat(set.getString(16)) + Float.parseFloat(set.getString(19)) + Float.parseFloat(set.getString(22)) + Float.parseFloat(set.getString(25)) + Float.parseFloat(set.getString(28)) + Float.parseFloat(set.getString(31)) + Float.parseFloat(set.getString(34)) + Float.parseFloat(set.getString(37)) + Float.parseFloat(set.getString(40));

            String avgP = String.format("%.1f",(addPoints/11));

            statement2 = connection.prepareStatement(sqlUpdate2);
            statement = connection.prepareStatement(sqlUpdate);
            statement.setString(1, String.valueOf((int) addTotal));
            statement.setString(2, set.getString(2));
            String g= "";
            if (Float.parseFloat(avgP)>=11.5) { g = "A"; } else if (Float.parseFloat(avgP)>=10.5) {
                g = "A-"; } else if (Float.parseFloat(avgP)>=9.5) { g = "B+"; } else if (Float.parseFloat(avgP)>=8.5) {
                g = "B"; } else if (Float.parseFloat(avgP)>=7.5) {
                g = "B-"; } else if (Float.parseFloat(avgP)>=6.5) {
                g = "C+"; } else if (Float.parseFloat(avgP)>=5.5) {
                g = "C"; } else if (Float.parseFloat(avgP)>=4.5) {
                g = "C-"; } else if (Float.parseFloat(avgP)>=3.5) {
                g = "D+"; } else if (Float.parseFloat(avgP)>=2.5) {
                g = "D"; } else if (Float.parseFloat(avgP)>=1.5) {
                g = "D-"; } else { g = "E"; }

            statement2.setString(1, g.toUpperCase());
            statement2.setString(2,avgP);
            statement2.setString(3, adm.toString());
            statement2.execute();

            statement.execute();
        }catch (Exception e){
           e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        calcTotal();
        loadData();

    }


    @FXML void openF4T1Avg(){
        ShowClasslist showClasslist = new ShowClasslist();
        showClasslist.dbTableName="tbl_f4_t1_avg";
        showClasslist.dbClassName="FORM_4";
        showClasslist.schName="WAVES ACADEMY LTD";
        showClasslist.clsName="Form 4";
        showClasslist.tmName="Term 1";
        showClasslist.exName="Exam Avg";
        showClasslist.currentSetting="F4T1AVG";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/classlist/showClasslist.fxml"));
            Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
            stage.getIcons().add(applicationIcon);

            ShowClasslist showClasslist1 = (ShowClasslist) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 4 TERM 1 AVERAGE");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML void openF4T1Ex1(){
        ShowClasslist showClasslist = new ShowClasslist();
        showClasslist.dbTableName="tbl_f4_t1_ex1";
        showClasslist.dbClassName="FORM_4";
        showClasslist.schName="WAVES ACADEMY LTD";
        showClasslist.clsName="Form 4";
        showClasslist.tmName="Term 1";
        showClasslist.exName="Exam 1";
        showClasslist.currentSetting="F4T1E1";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/classlist/showClasslist.fxml"));
Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
        stage.getIcons().add(applicationIcon);

            ShowClasslist showClasslist3 = (ShowClasslist) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 4 TERM 1 EXAM 1");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML void openF4T1Ex2(){
        ShowClasslist showClasslist = new ShowClasslist();
        showClasslist.dbTableName="tbl_f4_t1_ex2";
        showClasslist.dbClassName="FORM_4";
        showClasslist.schName="WAVES ACADEMY LTD";
        showClasslist.clsName="Form 4";
        showClasslist.tmName="Term 1";
        showClasslist.exName="Exam 2";
        showClasslist.currentSetting="F4T1E2";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/classlist/showClasslist.fxml"));
Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
        stage.getIcons().add(applicationIcon);

            ShowClasslist showClasslist3 = (ShowClasslist) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 4 TERM 1 EXAM 2");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML void openF4T1Ex3(){
        ShowClasslist showClasslist = new ShowClasslist();
        showClasslist.dbTableName="tbl_f4_t1_ex3";
        showClasslist.dbClassName="FORM_4";
        showClasslist.schName="WAVES ACADEMY LTD";
        showClasslist.clsName="Form 4";
        showClasslist.tmName="Term 1";
        showClasslist.exName="Exam 3";
        showClasslist.currentSetting="F4T1E3";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/classlist/showClasslist.fxml"));
Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
        stage.getIcons().add(applicationIcon);

            ShowClasslist showClasslist3 = (ShowClasslist) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 4 TERM 1 EXAM 3");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML void openF4T2Avg(){
        ShowClasslist showClasslist = new ShowClasslist();
        showClasslist.dbTableName="tbl_f4_t2_avg";
        showClasslist.dbClassName="FORM_4";
        showClasslist.schName="WAVES ACADEMY LTD";
        showClasslist.clsName="Form 4";
        showClasslist.tmName="Term 2";
        showClasslist.exName="Exam Avg";
        showClasslist.currentSetting="F4T2AVG";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/classlist/showClasslist.fxml"));
Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
        stage.getIcons().add(applicationIcon);

            ShowClasslist showClasslist3 = (ShowClasslist) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 4 TERM 2 AVERAGE");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML void openF4T2Ex1(){
        ShowClasslist showClasslist = new ShowClasslist();
        showClasslist.dbTableName="tbl_f4_t2_ex1";
        showClasslist.dbClassName="FORM_4";
        showClasslist.schName="WAVES ACADEMY LTD";
        showClasslist.clsName="Form 4";
        showClasslist.tmName="Term 2";
        showClasslist.exName="Exam 1";
        showClasslist.currentSetting="F4T2E1";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/classlist/showClasslist.fxml"));
Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
        stage.getIcons().add(applicationIcon);

            ShowClasslist showClasslist3 = (ShowClasslist) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 4 TERM 2 EXAM 1");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML void openF4T2Ex2(){
        ShowClasslist showClasslist = new ShowClasslist();
        showClasslist.dbTableName="tbl_f4_t2_ex2";
        showClasslist.dbClassName="FORM_4";
        showClasslist.schName="WAVES ACADEMY LTD";
        showClasslist.clsName="Form 4";
        showClasslist.tmName="Term 2";
        showClasslist.exName="Exam 2";
        showClasslist.currentSetting="F4T2E2";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/classlist/showClasslist.fxml"));
Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
        stage.getIcons().add(applicationIcon);

            ShowClasslist showClasslist3 = (ShowClasslist) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 4 TERM 2 EXAM 2");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML void openF4T2Ex3(){
        ShowClasslist showClasslist = new ShowClasslist();
        showClasslist.dbTableName="tbl_f4_t2_ex3";
        showClasslist.dbClassName="FORM_4";
        showClasslist.schName="WAVES ACADEMY LTD";
        showClasslist.clsName="Form 4";
        showClasslist.tmName="Term 2";
        showClasslist.exName="Exam 3";
        showClasslist.currentSetting="F4T2E3";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/classlist/showClasslist.fxml"));
Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
        stage.getIcons().add(applicationIcon);

            ShowClasslist showClasslist3 = (ShowClasslist) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 4 TERM 2 EXAM 3");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML void openF4T3Avg(){
        ShowClasslist showClasslist = new ShowClasslist();
        showClasslist.dbTableName="tbl_f4_t3_avg";
        showClasslist.dbClassName="FORM_4";
        showClasslist.schName="WAVES ACADEMY LTD";
        showClasslist.clsName="Form 4";
        showClasslist.tmName="Term 3";
        showClasslist.exName="Exam Avg";
        showClasslist.currentSetting="F4T3AVG";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/classlist/showClasslist.fxml"));
Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
        stage.getIcons().add(applicationIcon);

            ShowClasslist showClasslist3 = (ShowClasslist) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 4 TERM 3 AVERAGE");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML void openF4T3Ex1(){
        ShowClasslist showClasslist = new ShowClasslist();
        showClasslist.dbTableName="tbl_f4_t3_ex1";
        showClasslist.dbClassName="FORM_4";
        showClasslist.schName="WAVES ACADEMY LTD";
        showClasslist.clsName="Form 4";
        showClasslist.tmName="Term 3";
        showClasslist.exName="Exam 1";
        showClasslist.currentSetting="F4T3E3";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/classlist/showClasslist.fxml"));
Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
        stage.getIcons().add(applicationIcon);

            ShowClasslist showClasslist3 = (ShowClasslist) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 4 TERM 3 EXAM 1");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML void openF4T3Ex2(){
        ShowClasslist showClasslist = new ShowClasslist();
        showClasslist.dbTableName="tbl_f4_t3_ex2";
        showClasslist.dbClassName="FORM_4";
        showClasslist.schName="WAVES ACADEMY LTD";
        showClasslist.clsName="Form 4";
        showClasslist.tmName="Term 3";
        showClasslist.exName="Exam 2";
        showClasslist.currentSetting="F4T3E2";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/classlist/showClasslist.fxml"));
Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
        stage.getIcons().add(applicationIcon);

            ShowClasslist showClasslist3 = (ShowClasslist) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 4 TERM 3 EXAM 2");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML void openF4T3Ex3(){
        ShowClasslist showClasslist = new ShowClasslist();
        showClasslist.dbTableName="tbl_f4_t3_ex3";
        showClasslist.dbClassName="FORM_4";
        showClasslist.schName="WAVES ACADEMY LTD";
        showClasslist.clsName="Form 4";
        showClasslist.tmName="Term 3";
        showClasslist.exName="Exam 3";
        showClasslist.currentSetting="F4T3E3";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/classlist/showClasslist.fxml"));
Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
        stage.getIcons().add(applicationIcon);

            ShowClasslist showClasslist3 = (ShowClasslist) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 4 TERM 3 EXAM 3");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML void openF3T1Avg(){
        ShowClasslist showClasslist = new ShowClasslist();
        showClasslist.dbTableName="tbl_f3_t1_avg";
        showClasslist.dbClassName="FORM_3";
        showClasslist.schName="WAVES ACADEMY LTD";
        showClasslist.clsName="Form 3";
        showClasslist.tmName="Term 1";
        showClasslist.exName="Exam Avg";
        showClasslist.currentSetting="F3T1AVG";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/classlist/showClasslist.fxml"));
Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
        stage.getIcons().add(applicationIcon);

            ShowClasslist showClasslist3 = (ShowClasslist) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 3 TERM 1 AVERAGE");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML void openF3T1Ex1(){
        ShowClasslist showClasslist = new ShowClasslist();
        showClasslist.dbTableName="tbl_f3_t1_ex1";
        showClasslist.dbClassName="FORM_3";
        showClasslist.schName="WAVES ACADEMY LTD";
        showClasslist.clsName="Form 3";
        showClasslist.tmName="Term 1";
        showClasslist.exName="Exam 1";
        showClasslist.currentSetting="F3T1E1";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/classlist/showClasslist.fxml"));
Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
        stage.getIcons().add(applicationIcon);

            ShowClasslist showClasslist3 = (ShowClasslist) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 3 TERM 1 EXAM 1");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML void openF3T1Ex2(){
        ShowClasslist showClasslist = new ShowClasslist();
        showClasslist.dbTableName="tbl_f3_t1_ex2";
        showClasslist.dbClassName="FORM_3";
        showClasslist.schName="WAVES ACADEMY LTD";
        showClasslist.clsName="Form 3";
        showClasslist.tmName="Term 1";
        showClasslist.exName="Exam 2";
        showClasslist.currentSetting="F3T1E2";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/classlist/showClasslist.fxml"));
Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
        stage.getIcons().add(applicationIcon);

            ShowClasslist showClasslist3 = (ShowClasslist) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 3 TERM 1 EXAM 2");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML void openF3T1Ex3(){
        ShowClasslist showClasslist = new ShowClasslist();
        showClasslist.dbTableName="tbl_f3_t1_ex3";
        showClasslist.dbClassName="FORM_3";
        showClasslist.schName="WAVES ACADEMY LTD";
        showClasslist.clsName="Form 3";
        showClasslist.tmName="Term 1";
        showClasslist.exName="Exam 3";
        showClasslist.currentSetting="F3T1E3";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/classlist/showClasslist.fxml"));
Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
        stage.getIcons().add(applicationIcon);

            ShowClasslist showClasslist3 = (ShowClasslist) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 3 TERM 1 EXAM 3");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML void openF3T2Avg(){
        ShowClasslist showClasslist = new ShowClasslist();
        showClasslist.dbTableName="tbl_f3_t2_avg";
        showClasslist.dbClassName="FORM_3";
        showClasslist.schName="WAVES ACADEMY LTD";
        showClasslist.clsName="Form 3";
        showClasslist.tmName="Term 2";
        showClasslist.exName="Exam Avg";
        showClasslist.currentSetting="F3T2AVG";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/classlist/showClasslist.fxml"));
Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
        stage.getIcons().add(applicationIcon);

            ShowClasslist showClasslist3 = (ShowClasslist) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 3 TERM 2 AVERAGE");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML void openF3T2Ex1(){
        ShowClasslist showClasslist = new ShowClasslist();
        showClasslist.dbTableName="tbl_f3_t2_ex1";
        showClasslist.dbClassName="FORM_3";
        showClasslist.schName="WAVES ACADEMY LTD";
        showClasslist.clsName="Form 3";
        showClasslist.tmName="Term 2";
        showClasslist.exName="Exam 1";
        showClasslist.currentSetting="F3T2E1";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/classlist/showClasslist.fxml"));
Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
        stage.getIcons().add(applicationIcon);

            ShowClasslist showClasslist3 = (ShowClasslist) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 3 TERM 2 EXAM 1");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML void openF3T2Ex2(){
        ShowClasslist showClasslist = new ShowClasslist();
        showClasslist.dbTableName="tbl_f3_t2_ex2";
        showClasslist.dbClassName="FORM_3";
        showClasslist.schName="WAVES ACADEMY LTD";
        showClasslist.clsName="Form 3";
        showClasslist.tmName="Term 2";
        showClasslist.exName="Exam 2";
        showClasslist.currentSetting="F3T2E2";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/classlist/showClasslist.fxml"));
Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
        stage.getIcons().add(applicationIcon);

            ShowClasslist showClasslist3 = (ShowClasslist) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 3 TERM 2 EXAM 2");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML void openF3T2Ex3(){
        ShowClasslist showClasslist = new ShowClasslist();
        showClasslist.dbTableName="tbl_f3_t2_ex3";
        showClasslist.dbClassName="FORM_3";
        showClasslist.schName="WAVES ACADEMY LTD";
        showClasslist.clsName="Form 3";
        showClasslist.tmName="Term 2";
        showClasslist.exName="Exam 3";
        showClasslist.currentSetting="F3T2E3";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/classlist/showClasslist.fxml"));
Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
        stage.getIcons().add(applicationIcon);

            ShowClasslist showClasslist3 = (ShowClasslist) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 3 TERM 2 EXAM 3");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML void openF3T3Avg(){
        ShowClasslist showClasslist = new ShowClasslist();
        showClasslist.dbTableName="tbl_f3_t3_avg";
        showClasslist.dbClassName="FORM_3";
        showClasslist.schName="WAVES ACADEMY LTD";
        showClasslist.clsName="Form 3";
        showClasslist.tmName="Term 3";
        showClasslist.exName="Exam Avg";
        showClasslist.currentSetting="F3T3AVG";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/classlist/showClasslist.fxml"));
Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
        stage.getIcons().add(applicationIcon);

            ShowClasslist showClasslist3 = (ShowClasslist) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 3 TERM 3 AVERAGE");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML void openF3T3Ex1(){
        ShowClasslist showClasslist = new ShowClasslist();
        showClasslist.dbTableName="tbl_f3_t3_ex1";
        showClasslist.dbClassName="FORM_3";
        showClasslist.schName="WAVES ACADEMY LTD";
        showClasslist.clsName="Form 3";
        showClasslist.tmName="Term 3";
        showClasslist.exName="Exam 1";
        showClasslist.currentSetting="F3T3E3";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/classlist/showClasslist.fxml"));
Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
        stage.getIcons().add(applicationIcon);

            ShowClasslist showClasslist3 = (ShowClasslist) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 3 TERM 3 EXAM 1");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML void openF3T3Ex2(){
        ShowClasslist showClasslist = new ShowClasslist();
        showClasslist.dbTableName="tbl_f3_t3_ex2";
        showClasslist.dbClassName="FORM_3";
        showClasslist.schName="WAVES ACADEMY LTD";
        showClasslist.clsName="Form 3";
        showClasslist.tmName="Term 3";
        showClasslist.exName="Exam 2";
        showClasslist.currentSetting="F3T3E2";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/classlist/showClasslist.fxml"));
Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
        stage.getIcons().add(applicationIcon);

            ShowClasslist showClasslist3 = (ShowClasslist) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 3 TERM 3 EXAM 2");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML void openF3T3Ex3(){
        ShowClasslist showClasslist = new ShowClasslist();
        showClasslist.dbTableName="tbl_f3_t3_ex3";
        showClasslist.dbClassName="FORM_3";
        showClasslist.schName="WAVES ACADEMY LTD";
        showClasslist.clsName="Form 3";
        showClasslist.tmName="Term 3";
        showClasslist.exName="Exam 3";
        showClasslist.currentSetting="F3T3E3";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/classlist/showClasslist.fxml"));
Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
        stage.getIcons().add(applicationIcon);

            ShowClasslist showClasslist3 = (ShowClasslist) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 3 TERM 3 EXAM 3");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML void openF2T1Avg(){
        ShowClasslist showClasslist = new ShowClasslist();
        showClasslist.dbTableName="tbl_f2_t1_avg";
        showClasslist.dbClassName="FORM_2";
        showClasslist.schName="WAVES ACADEMY LTD";
        showClasslist.clsName="Form 2";
        showClasslist.tmName="Term 1";
        showClasslist.exName="Exam Avg";
        showClasslist.currentSetting="F2T1AVG";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/classlist/showClasslist.fxml"));
Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
        stage.getIcons().add(applicationIcon);

            ShowClasslist showClasslist3 = (ShowClasslist) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 2 TERM 1 AVERAGE");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML void openF2T1Ex1(){
        ShowClasslist showClasslist = new ShowClasslist();
        showClasslist.dbTableName="tbl_f2_t1_ex1";
        showClasslist.dbClassName="FORM_2";
        showClasslist.schName="WAVES ACADEMY LTD";
        showClasslist.clsName="Form 2";
        showClasslist.tmName="Term 1";
        showClasslist.exName="Exam 1";
        showClasslist.currentSetting="F2T1E1";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/classlist/showClasslist.fxml"));
Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
        stage.getIcons().add(applicationIcon);

            ShowClasslist showClasslist3 = (ShowClasslist) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 2 TERM 1 EXAM 1");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML void openF2T1Ex2(){
        ShowClasslist showClasslist = new ShowClasslist();
        showClasslist.dbTableName="tbl_f2_t1_ex2";
        showClasslist.dbClassName="FORM_2";
        showClasslist.schName="WAVES ACADEMY LTD";
        showClasslist.clsName="Form 2";
        showClasslist.tmName="Term 1";
        showClasslist.exName="Exam 2";
        showClasslist.currentSetting="F2T1E2";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/classlist/showClasslist.fxml"));
Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
        stage.getIcons().add(applicationIcon);

            ShowClasslist showClasslist3 = (ShowClasslist) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 2 TERM 1 EXAM 2");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML void openF2T1Ex3(){
        ShowClasslist showClasslist = new ShowClasslist();
        showClasslist.dbTableName="tbl_f2_t1_ex3";
        showClasslist.dbClassName="FORM_2";
        showClasslist.schName="WAVES ACADEMY LTD";
        showClasslist.clsName="Form 2";
        showClasslist.tmName="Term 1";
        showClasslist.exName="Exam 3";
        showClasslist.currentSetting="F2T1E3";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/classlist/showClasslist.fxml"));
Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
        stage.getIcons().add(applicationIcon);

            ShowClasslist showClasslist3 = (ShowClasslist) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 2 TERM 1 EXAM 3");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML void openF2T2Avg(){
        ShowClasslist showClasslist = new ShowClasslist();
        showClasslist.dbTableName="tbl_f2_t2_avg";
        showClasslist.dbClassName="FORM_2";
        showClasslist.schName="WAVES ACADEMY LTD";
        showClasslist.clsName="Form 2";
        showClasslist.tmName="Term 2";
        showClasslist.exName="Exam Avg";
        showClasslist.currentSetting="F2T2AVG";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/classlist/showClasslist.fxml"));
Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
        stage.getIcons().add(applicationIcon);

            ShowClasslist showClasslist3 = (ShowClasslist) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 2 TERM 2 AVERAGE");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML void openF2T2Ex1(){
        ShowClasslist showClasslist = new ShowClasslist();
        showClasslist.dbTableName="tbl_f2_t2_ex1";
        showClasslist.dbClassName="FORM_2";
        showClasslist.schName="WAVES ACADEMY LTD";
        showClasslist.clsName="Form 2";
        showClasslist.tmName="Term 2";
        showClasslist.exName="Exam 1";
        showClasslist.currentSetting="F2T2E1";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/classlist/showClasslist.fxml"));
Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
        stage.getIcons().add(applicationIcon);

            ShowClasslist showClasslist3 = (ShowClasslist) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 2 TERM 2 EXAM 1");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML void openF2T2Ex2(){
        ShowClasslist showClasslist = new ShowClasslist();
        showClasslist.dbTableName="tbl_f2_t2_ex2";
        showClasslist.dbClassName="FORM_2";
        showClasslist.schName="WAVES ACADEMY LTD";
        showClasslist.clsName="Form 2";
        showClasslist.tmName="Term 2";
        showClasslist.exName="Exam 2";
        showClasslist.currentSetting="F2T2E2";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/classlist/showClasslist.fxml"));
Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
        stage.getIcons().add(applicationIcon);

            ShowClasslist showClasslist3 = (ShowClasslist) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 2 TERM 2 EXAM 2");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML void openF2T2Ex3(){
        ShowClasslist showClasslist = new ShowClasslist();
        showClasslist.dbTableName="tbl_f2_t2_ex3";
        showClasslist.dbClassName="FORM_2";
        showClasslist.schName="WAVES ACADEMY LTD";
        showClasslist.clsName="Form 2";
        showClasslist.tmName="Term 2";
        showClasslist.exName="Exam 3";
        showClasslist.currentSetting="F2T2E3";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/classlist/showClasslist.fxml"));
Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
        stage.getIcons().add(applicationIcon);

            ShowClasslist showClasslist3 = (ShowClasslist) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 2 TERM 2 EXAM 3");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML void openF2T3Avg(){
        ShowClasslist showClasslist = new ShowClasslist();
        showClasslist.dbTableName="tbl_f2_t3_avg";
        showClasslist.dbClassName="FORM_2";
        showClasslist.schName="WAVES ACADEMY LTD";
        showClasslist.clsName="Form 2";
        showClasslist.tmName="Term 3";
        showClasslist.exName="Exam Avg";
        showClasslist.currentSetting="F2T3AVG";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/classlist/showClasslist.fxml"));
Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
        stage.getIcons().add(applicationIcon);

            ShowClasslist showClasslist3 = (ShowClasslist) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 2 TERM 3 AVERAGE");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML void openF2T3Ex1(){
        ShowClasslist showClasslist = new ShowClasslist();
        showClasslist.dbTableName="tbl_f2_t3_ex1";
        showClasslist.dbClassName="FORM_2";
        showClasslist.schName="WAVES ACADEMY LTD";
        showClasslist.clsName="Form 2";
        showClasslist.tmName="Term 3";
        showClasslist.exName="Exam 1";
        showClasslist.currentSetting="F2T3E3";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/classlist/showClasslist.fxml"));
Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
        stage.getIcons().add(applicationIcon);

            ShowClasslist showClasslist3 = (ShowClasslist) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 2 TERM 3 EXAM 1");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML void openF2T3Ex2(){
        ShowClasslist showClasslist = new ShowClasslist();
        showClasslist.dbTableName="tbl_f2_t3_ex2";
        showClasslist.dbClassName="FORM_2";
        showClasslist.schName="WAVES ACADEMY LTD";
        showClasslist.clsName="Form 2";
        showClasslist.tmName="Term 3";
        showClasslist.exName="Exam 2";
        showClasslist.currentSetting="F2T3E2";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/classlist/showClasslist.fxml"));
Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
        stage.getIcons().add(applicationIcon);

            ShowClasslist showClasslist3 = (ShowClasslist) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 2 TERM 3 EXAM 2");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML void openF2T3Ex3(){
        ShowClasslist showClasslist = new ShowClasslist();
        showClasslist.dbTableName="tbl_f2_t3_ex3";
        showClasslist.dbClassName="FORM_2";
        showClasslist.schName="WAVES ACADEMY LTD";
        showClasslist.clsName="Form 2";
        showClasslist.tmName="Term 3";
        showClasslist.exName="Exam 3";
        showClasslist.currentSetting="F2T3E3";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/classlist/showClasslist.fxml"));
Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
        stage.getIcons().add(applicationIcon);

            ShowClasslist showClasslist3 = (ShowClasslist) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 2 TERM 3 EXAM 3");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML void openF1T1Avg(){
        ShowClasslist showClasslist = new ShowClasslist();
        showClasslist.dbTableName="tbl_f1_t1_avg";
        showClasslist.dbClassName="FORM_1";
        showClasslist.schName="WAVES ACADEMY LTD";
        showClasslist.clsName="Form 1";
        showClasslist.tmName="Term 1";
        showClasslist.exName="Exam Avg";
        showClasslist.currentSetting="F1T1AVG";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/classlist/showClasslist.fxml"));
Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
        stage.getIcons().add(applicationIcon);

            ShowClasslist showClasslist3 = (ShowClasslist) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 1 TERM 1 AVERAGE");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML void openF1T1Ex1(){
        ShowClasslist showClasslist = new ShowClasslist();
        showClasslist.dbTableName="tbl_f1_t1_ex1";
        showClasslist.dbClassName="FORM_1";
        showClasslist.schName="WAVES ACADEMY LTD";
        showClasslist.clsName="Form 1";
        showClasslist.tmName="Term 1";
        showClasslist.exName="Exam 1";
        showClasslist.currentSetting="F1T1E1";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/classlist/showClasslist.fxml"));
Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
        stage.getIcons().add(applicationIcon);

            ShowClasslist showClasslist3 = (ShowClasslist) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 1 TERM 1 EXAM 1");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML void openF1T1Ex2(){
        ShowClasslist showClasslist = new ShowClasslist();
        showClasslist.dbTableName="tbl_f1_t1_ex2";
        showClasslist.dbClassName="FORM_1";
        showClasslist.schName="WAVES ACADEMY LTD";
        showClasslist.clsName="Form 1";
        showClasslist.tmName="Term 1";
        showClasslist.exName="Exam 2";
        showClasslist.currentSetting="F1T1E2";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/classlist/showClasslist.fxml"));
Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
        stage.getIcons().add(applicationIcon);

            ShowClasslist showClasslist3 = (ShowClasslist) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 1 TERM 1 EXAM 2");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML void openF1T1Ex3(){
        ShowClasslist showClasslist = new ShowClasslist();
        showClasslist.dbTableName="tbl_f1_t1_ex3";
        showClasslist.dbClassName="FORM_1";
        showClasslist.schName="WAVES ACADEMY LTD";
        showClasslist.clsName="Form 1";
        showClasslist.tmName="Term 1";
        showClasslist.exName="Exam 3";
        showClasslist.currentSetting="F1T1E3";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/classlist/showClasslist.fxml"));
Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
        stage.getIcons().add(applicationIcon);

            ShowClasslist showClasslist3 = (ShowClasslist) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 1 TERM 1 EXAM 3");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML void openF1T2Avg(){
        ShowClasslist showClasslist = new ShowClasslist();
        showClasslist.dbTableName="tbl_f1_t2_avg";
        showClasslist.dbClassName="FORM_1";
        showClasslist.schName="WAVES ACADEMY LTD";
        showClasslist.clsName="Form 1";
        showClasslist.tmName="Term 2";
        showClasslist.exName="Exam Avg";
        showClasslist.currentSetting="F1T2AVG";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/classlist/showClasslist.fxml"));
Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
        stage.getIcons().add(applicationIcon);

            ShowClasslist showClasslist3 = (ShowClasslist) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 1 TERM 2 AVERAGE");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML void openF1T2Ex1(){
        ShowClasslist showClasslist = new ShowClasslist();
        showClasslist.dbTableName="tbl_f1_t2_ex1";
        showClasslist.dbClassName="FORM_1";
        showClasslist.schName="WAVES ACADEMY LTD";
        showClasslist.clsName="Form 1";
        showClasslist.tmName="Term 2";
        showClasslist.exName="Exam 1";
        showClasslist.currentSetting="F1T2E1";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/classlist/showClasslist.fxml"));
Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
        stage.getIcons().add(applicationIcon);

            ShowClasslist showClasslist3 = (ShowClasslist) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 1 TERM 2 EXAM 1");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML void openF1T2Ex2(){
        ShowClasslist showClasslist = new ShowClasslist();
        showClasslist.dbTableName="tbl_f1_t2_ex2";
        showClasslist.dbClassName="FORM_1";
        showClasslist.schName="WAVES ACADEMY LTD";
        showClasslist.clsName="Form 1";
        showClasslist.tmName="Term 2";
        showClasslist.exName="Exam 2";
        showClasslist.currentSetting="F1T2E2";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/classlist/showClasslist.fxml"));
Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
        stage.getIcons().add(applicationIcon);

            ShowClasslist showClasslist3 = (ShowClasslist) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 1 TERM 2 EXAM 2");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML void openF1T2Ex3(){
        ShowClasslist showClasslist = new ShowClasslist();
        showClasslist.dbTableName="tbl_f1_t2_ex3";
        showClasslist.dbClassName="FORM_1";
        showClasslist.schName="WAVES ACADEMY LTD";
        showClasslist.clsName="Form 1";
        showClasslist.tmName="Term 2";
        showClasslist.exName="Exam 3";
        showClasslist.currentSetting="F1T2E3";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/classlist/showClasslist.fxml"));
Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
        stage.getIcons().add(applicationIcon);

            ShowClasslist showClasslist3 = (ShowClasslist) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 1 TERM 2 EXAM 3");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML void openF1T3Avg(){
        ShowClasslist showClasslist = new ShowClasslist();
        showClasslist.dbTableName="tbl_f1_t3_avg";
        showClasslist.dbClassName="FORM_1";
        showClasslist.schName="WAVES ACADEMY LTD";
        showClasslist.clsName="Form 1";
        showClasslist.tmName="Term 3";
        showClasslist.exName="Exam Avg";
        showClasslist.currentSetting="F1T3AVG";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/classlist/showClasslist.fxml"));
Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
        stage.getIcons().add(applicationIcon);

            ShowClasslist showClasslist3 = (ShowClasslist) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 1 TERM 3 AVERAGE");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML void openF1T3Ex1(){
        ShowClasslist showClasslist = new ShowClasslist();
        showClasslist.dbTableName="tbl_f1_t3_ex1";
        showClasslist.dbClassName="FORM_1";
        showClasslist.schName="WAVES ACADEMY LTD";
        showClasslist.clsName="Form 1";
        showClasslist.tmName="Term 3";
        showClasslist.exName="Exam 1";
        showClasslist.currentSetting="F1T3E1";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/classlist/showClasslist.fxml"));
Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
        stage.getIcons().add(applicationIcon);

            ShowClasslist showClasslist3 = (ShowClasslist) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 1 TERM 3 EXAM 1");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML void openF1T3Ex2(){
        ShowClasslist showClasslist = new ShowClasslist();
        showClasslist.dbTableName="tbl_f1_t3_ex2";
        showClasslist.dbClassName="FORM_1";
        showClasslist.schName="WAVES ACADEMY LTD";
        showClasslist.clsName="Form 1";
        showClasslist.tmName="Term 3";
        showClasslist.exName="Exam 2";
        showClasslist.currentSetting="F1T3E2";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/classlist/showClasslist.fxml"));
Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
        stage.getIcons().add(applicationIcon);

            ShowClasslist showClasslist3 = (ShowClasslist) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 1 TERM 3 EXAM 2");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML void openF1T3Ex3(){
        ShowClasslist showClasslist = new ShowClasslist();
        showClasslist.dbTableName="tbl_f1_t3_ex3";
        showClasslist.dbClassName="FORM_1";
        showClasslist.schName="WAVES ACADEMY LTD";
        showClasslist.clsName="Form 1";
        showClasslist.tmName="Term 3";
        showClasslist.exName="Exam 3";
        showClasslist.currentSetting="F1T3E3";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/classlist/showClasslist.fxml"));
Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
        stage.getIcons().add(applicationIcon);

            ShowClasslist showClasslist3 = (ShowClasslist) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 1 TERM 3 EXAM 3");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void openSubjectSelection(){
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/students/subjectSelection.fxml"));
            //Pane root = (Pane)loader.load(getClass().getResource("../../students/subjectSelection.fxml"));
            Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
            stage.getIcons().add(applicationIcon);
            SubjectSelection subjectSelection = (SubjectSelection) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("SUBJECT SELECTION");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void openTeacher(){
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/teacher/teacher.fxml"));
            //Pane root = (Pane)loader.load(getClass().getResource("../../teacher/teacher.fxml"));
            Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
            stage.getIcons().add(applicationIcon);
            Teacher teacher = (Teacher) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("TEACHERS");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void addStudent(){
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/students/StudentsUpdated.fxml"));
            // Pane root = (Pane)loader.load(getClass().getResource("../../students/StudentsUpdated.fxml"));
            Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
            stage.getIcons().add(applicationIcon);
            StudentUpdated studentUpdated = (StudentUpdated) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("ADD/EDIT STUDENT");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void openF4T1EntryAgri(){
        MarksEntry marksEntry = new MarksEntry();
        marksEntry.dbTableNameT1E1="tbl_f4_t1_ex1";
        marksEntry.dbTableNameT1E2="tbl_f4_t1_ex2";
        marksEntry.dbTableNameT1E3="tbl_f4_t1_ex3";
        marksEntry.dbTableNameT2E1="tbl_f4_t2_ex1";
        marksEntry.dbTableNameT2E2="tbl_f4_t2_ex2";
        marksEntry.dbTableNameT2E3="tbl_f4_t2_ex3";
        marksEntry.dbTableNameT3E1="tbl_f4_t3_ex1";
        marksEntry.dbTableNameT3E2="tbl_f4_t3_ex2";
        marksEntry.dbTableNameT3E3="tbl_f4_t3_ex3";
        marksEntry.dbTableNameT1Avg="tbl_f4_t1_avg";
        marksEntry.dbTableNameT2Avg="tbl_f4_t2_avg";
        marksEntry.dbTableNameT3Avg="tbl_f4_t3_avg";
        marksEntry.dbClassName="FORM_4";
        marksEntry.schName="WAVES ACADEMY LTD";
        marksEntry.clsName="Form 4";
        marksEntry.dbSubjectTable="tbl_f4_agri";
        marksEntry.subName="AGRICULTURE";
        marksEntry.sbj="agri";
        marksEntry.sbjg="agrig";
        marksEntry.pn="p11";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            //Pane root = (Pane)loader.load(getClass().getResource("/F1/exams/marksEntry.fxml"));
            Pane root = (Pane)loader.load(getClass().getResource("/F1/exams/marksEntry.fxml"));
Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
        stage.getIcons().add(applicationIcon);

            MarksEntry marksEntry1 = (MarksEntry) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 4 AGRICULTURE[Marks Entry]");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void openF4T1EntryBio(){
        MarksEntry marksEntry = new MarksEntry();
        marksEntry.dbTableNameT1E1="tbl_f4_t1_ex1";
        marksEntry.dbTableNameT1E2="tbl_f4_t1_ex2";
        marksEntry.dbTableNameT1E3="tbl_f4_t1_ex3";
        marksEntry.dbTableNameT2E1="tbl_f4_t2_ex1";
        marksEntry.dbTableNameT2E2="tbl_f4_t2_ex2";
        marksEntry.dbTableNameT2E3="tbl_f4_t2_ex3";
        marksEntry.dbTableNameT3E1="tbl_f4_t3_ex1";
        marksEntry.dbTableNameT3E2="tbl_f4_t3_ex2";
        marksEntry.dbTableNameT3E3="tbl_f4_t3_ex3";
        marksEntry.dbTableNameT1Avg="tbl_f4_t1_avg";
        marksEntry.dbTableNameT2Avg="tbl_f4_t2_avg";
        marksEntry.dbTableNameT3Avg="tbl_f4_t3_avg";
        marksEntry.dbClassName="FORM_4";
        marksEntry.schName="WAVES ACADEMY LTD";
        marksEntry.clsName="Form 4";
        marksEntry.dbSubjectTable="tbl_f4_bio";
        marksEntry.subName="BIOLOGY";
        marksEntry.sbj="bio";
        marksEntry.sbjg="biog";
        marksEntry.pn="p4";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            //Pane root = (Pane)loader.load(getClass().getResource("/F1/exams/marksEntry.fxml"));
Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
        stage.getIcons().add(applicationIcon);
            Pane root = (Pane)loader.load(getClass().getResource("/F1/exams/marksEntry.fxml"));

            MarksEntry marksEntry1 = (MarksEntry) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 4 BIOLOGY[Marks Entry]");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void openF4T1EntryBus(){
        MarksEntry marksEntry = new MarksEntry();
        marksEntry.dbTableNameT1E1="tbl_f4_t1_ex1";
        marksEntry.dbTableNameT1E2="tbl_f4_t1_ex2";
        marksEntry.dbTableNameT1E3="tbl_f4_t1_ex3";
        marksEntry.dbTableNameT2E1="tbl_f4_t2_ex1";
        marksEntry.dbTableNameT2E2="tbl_f4_t2_ex2";
        marksEntry.dbTableNameT2E3="tbl_f4_t2_ex3";
        marksEntry.dbTableNameT3E1="tbl_f4_t3_ex1";
        marksEntry.dbTableNameT3E2="tbl_f4_t3_ex2";
        marksEntry.dbTableNameT3E3="tbl_f4_t3_ex3";
        marksEntry.dbTableNameT1Avg="tbl_f4_t1_avg";
        marksEntry.dbTableNameT2Avg="tbl_f4_t2_avg";
        marksEntry.dbTableNameT3Avg="tbl_f4_t3_avg";
        marksEntry.dbClassName="FORM_4";
        marksEntry.schName="WAVES ACADEMY LTD";
        marksEntry.clsName="Form 4";
        marksEntry.dbSubjectTable="tbl_f4_bus";
        marksEntry.subName="BUSINESS";
        marksEntry.sbj="bus";
        marksEntry.sbjg="busg";
        marksEntry.pn="p10";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            //Pane root = (Pane)loader.load(getClass().getResource("/F1/exams/marksEntry.fxml"));
Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
        stage.getIcons().add(applicationIcon);
            Pane root = (Pane)loader.load(getClass().getResource("/F1/exams/marksEntry.fxml"));

            MarksEntry marksEntry1 = (MarksEntry) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 4 BUSINESS[Marks Entry]");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void openF4T1EntryChem(){
        MarksEntry marksEntry = new MarksEntry();
        marksEntry.dbTableNameT1E1="tbl_f4_t1_ex1";
        marksEntry.dbTableNameT1E2="tbl_f4_t1_ex2";
        marksEntry.dbTableNameT1E3="tbl_f4_t1_ex3";
        marksEntry.dbTableNameT2E1="tbl_f4_t2_ex1";
        marksEntry.dbTableNameT2E2="tbl_f4_t2_ex2";
        marksEntry.dbTableNameT2E3="tbl_f4_t2_ex3";
        marksEntry.dbTableNameT3E1="tbl_f4_t3_ex1";
        marksEntry.dbTableNameT3E2="tbl_f4_t3_ex2";
        marksEntry.dbTableNameT3E3="tbl_f4_t3_ex3";
        marksEntry.dbTableNameT1Avg="tbl_f4_t1_avg";
        marksEntry.dbTableNameT2Avg="tbl_f4_t2_avg";
        marksEntry.dbTableNameT3Avg="tbl_f4_t3_avg";
        marksEntry.dbClassName="FORM_4";
        marksEntry.schName="WAVES ACADEMY LTD";
        marksEntry.clsName="Form 4";
        marksEntry.dbSubjectTable="tbl_f4_chem";
        marksEntry.subName="CHEMISTRY";
        marksEntry.sbj="chem";
        marksEntry.sbjg="chemg";
        marksEntry.pn="p5";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/exams/marksEntry.fxml"));
Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
        stage.getIcons().add(applicationIcon);

            MarksEntry marksEntry1 = (MarksEntry) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 4 CHEMISTRY[Marks Entry]");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void openF4T1EntryCre(){
        MarksEntry marksEntry = new MarksEntry();
        marksEntry.dbTableNameT1E1="tbl_f4_t1_ex1";
        marksEntry.dbTableNameT1E2="tbl_f4_t1_ex2";
        marksEntry.dbTableNameT1E3="tbl_f4_t1_ex3";
        marksEntry.dbTableNameT2E1="tbl_f4_t2_ex1";
        marksEntry.dbTableNameT2E2="tbl_f4_t2_ex2";
        marksEntry.dbTableNameT2E3="tbl_f4_t2_ex3";
        marksEntry.dbTableNameT3E1="tbl_f4_t3_ex1";
        marksEntry.dbTableNameT3E2="tbl_f4_t3_ex2";
        marksEntry.dbTableNameT3E3="tbl_f4_t3_ex3";
        marksEntry.dbTableNameT1Avg="tbl_f4_t1_avg";
        marksEntry.dbTableNameT2Avg="tbl_f4_t2_avg";
        marksEntry.dbTableNameT3Avg="tbl_f4_t3_avg";
        marksEntry.dbClassName="FORM_4";
        marksEntry.schName="WAVES ACADEMY LTD";
        marksEntry.clsName="Form 4";
        marksEntry.dbSubjectTable="tbl_f4_cre";
        marksEntry.subName="CRE";
        marksEntry.sbj="cre";
        marksEntry.sbjg="creg";
        marksEntry.pn="p9";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/exams/marksEntry.fxml"));
Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
        stage.getIcons().add(applicationIcon);

            MarksEntry marksEntry1 = (MarksEntry) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 4 CRE[Marks Entry]");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void openF4T1EntryEng(){
        MarksEntry marksEntry = new MarksEntry();
        marksEntry.dbTableNameT1E1="tbl_f4_t1_ex1";
        marksEntry.dbTableNameT1E2="tbl_f4_t1_ex2";
        marksEntry.dbTableNameT1E3="tbl_f4_t1_ex3";
        marksEntry.dbTableNameT2E1="tbl_f4_t2_ex1";
        marksEntry.dbTableNameT2E2="tbl_f4_t2_ex2";
        marksEntry.dbTableNameT2E3="tbl_f4_t2_ex3";
        marksEntry.dbTableNameT3E1="tbl_f4_t3_ex1";
        marksEntry.dbTableNameT3E2="tbl_f4_t3_ex2";
        marksEntry.dbTableNameT3E3="tbl_f4_t3_ex3";
        marksEntry.dbTableNameT1Avg="tbl_f4_t1_avg";
        marksEntry.dbTableNameT2Avg="tbl_f4_t2_avg";
        marksEntry.dbTableNameT3Avg="tbl_f4_t3_avg";
        marksEntry.dbClassName="FORM_4";
        marksEntry.schName="WAVES ACADEMY LTD";
        marksEntry.clsName="Form 4";
        marksEntry.dbSubjectTable="tbl_f4_eng";
        marksEntry.subName="ENGLISH";
        marksEntry.sbj="eng";
        marksEntry.sbjg="engg";
        marksEntry.pn="p1";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/exams/marksEntry.fxml"));
Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
        stage.getIcons().add(applicationIcon);

            MarksEntry marksEntry1 = (MarksEntry) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 4 ENGLISH[Marks Entry]");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void openF4T1EntryGeo(){
        MarksEntry marksEntry = new MarksEntry();
        marksEntry.dbTableNameT1E1="tbl_f4_t1_ex1";
        marksEntry.dbTableNameT1E2="tbl_f4_t1_ex2";
        marksEntry.dbTableNameT1E3="tbl_f4_t1_ex3";
        marksEntry.dbTableNameT2E1="tbl_f4_t2_ex1";
        marksEntry.dbTableNameT2E2="tbl_f4_t2_ex2";
        marksEntry.dbTableNameT2E3="tbl_f4_t2_ex3";
        marksEntry.dbTableNameT3E1="tbl_f4_t3_ex1";
        marksEntry.dbTableNameT3E2="tbl_f4_t3_ex2";
        marksEntry.dbTableNameT3E3="tbl_f4_t3_ex3";
        marksEntry.dbTableNameT1Avg="tbl_f4_t1_avg";
        marksEntry.dbTableNameT2Avg="tbl_f4_t2_avg";
        marksEntry.dbTableNameT3Avg="tbl_f4_t3_avg";
        marksEntry.dbClassName="FORM_4";
        marksEntry.schName="WAVES ACADEMY LTD";
        marksEntry.clsName="Form 4";
        marksEntry.dbSubjectTable="tbl_f4_geo";
        marksEntry.subName="GEOGRAPHY";
        marksEntry.sbj="geo";
        marksEntry.sbjg="geog";
        marksEntry.pn="p7";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/exams/marksEntry.fxml"));
Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
        stage.getIcons().add(applicationIcon);

            MarksEntry marksEntry1 = (MarksEntry) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 4 GEOGRAPHY[Marks Entry]");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void openF4T1EntryHis(){
        MarksEntry marksEntry = new MarksEntry();
        marksEntry.dbTableNameT1E1="tbl_f4_t1_ex1";
        marksEntry.dbTableNameT1E2="tbl_f4_t1_ex2";
        marksEntry.dbTableNameT1E3="tbl_f4_t1_ex3";
        marksEntry.dbTableNameT2E1="tbl_f4_t2_ex1";
        marksEntry.dbTableNameT2E2="tbl_f4_t2_ex2";
        marksEntry.dbTableNameT2E3="tbl_f4_t2_ex3";
        marksEntry.dbTableNameT3E1="tbl_f4_t3_ex1";
        marksEntry.dbTableNameT3E2="tbl_f4_t3_ex2";
        marksEntry.dbTableNameT3E3="tbl_f4_t3_ex3";
        marksEntry.dbTableNameT1Avg="tbl_f4_t1_avg";
        marksEntry.dbTableNameT2Avg="tbl_f4_t2_avg";
        marksEntry.dbTableNameT3Avg="tbl_f4_t3_avg";
        marksEntry.dbClassName="FORM_4";
        marksEntry.schName="WAVES ACADEMY LTD";
        marksEntry.clsName="Form 4";
        marksEntry.dbSubjectTable="tbl_f4_his";
        marksEntry.subName="HISTORY";
        marksEntry.sbj="his";
        marksEntry.sbjg="hisg";
        marksEntry.pn="p8";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/exams/marksEntry.fxml"));
Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
        stage.getIcons().add(applicationIcon);

            MarksEntry marksEntry1 = (MarksEntry) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 4 HISTORY[Marks Entry]");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void openF4T1EntryKis(){
        MarksEntry marksEntry = new MarksEntry();
        marksEntry.dbTableNameT1E1="tbl_f4_t1_ex1";
        marksEntry.dbTableNameT1E2="tbl_f4_t1_ex2";
        marksEntry.dbTableNameT1E3="tbl_f4_t1_ex3";
        marksEntry.dbTableNameT2E1="tbl_f4_t2_ex1";
        marksEntry.dbTableNameT2E2="tbl_f4_t2_ex2";
        marksEntry.dbTableNameT2E3="tbl_f4_t2_ex3";
        marksEntry.dbTableNameT3E1="tbl_f4_t3_ex1";
        marksEntry.dbTableNameT3E2="tbl_f4_t3_ex2";
        marksEntry.dbTableNameT3E3="tbl_f4_t3_ex3";
        marksEntry.dbTableNameT1Avg="tbl_f4_t1_avg";
        marksEntry.dbTableNameT2Avg="tbl_f4_t2_avg";
        marksEntry.dbTableNameT3Avg="tbl_f4_t3_avg";
        marksEntry.dbClassName="FORM_4";
        marksEntry.schName="WAVES ACADEMY LTD";
        marksEntry.clsName="Form 4";
        marksEntry.dbSubjectTable="tbl_f4_kis";
        marksEntry.subName="KISWAHILI";
        marksEntry.sbj="kis";
        marksEntry.sbjg="kisg";
        marksEntry.pn="p2";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/exams/marksEntry.fxml"));
Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
        stage.getIcons().add(applicationIcon);

            MarksEntry marksEntry1 = (MarksEntry) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 4 KISWAHILI[Marks Entry]");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void openF4T1EntryMat(){
        MarksEntry marksEntry = new MarksEntry();
        marksEntry.dbTableNameT1E1="tbl_f4_t1_ex1";
        marksEntry.dbTableNameT1E2="tbl_f4_t1_ex2";
        marksEntry.dbTableNameT1E3="tbl_f4_t1_ex3";
        marksEntry.dbTableNameT2E1="tbl_f4_t2_ex1";
        marksEntry.dbTableNameT2E2="tbl_f4_t2_ex2";
        marksEntry.dbTableNameT2E3="tbl_f4_t2_ex3";
        marksEntry.dbTableNameT3E1="tbl_f4_t3_ex1";
        marksEntry.dbTableNameT3E2="tbl_f4_t3_ex2";
        marksEntry.dbTableNameT3E3="tbl_f4_t3_ex3";
        marksEntry.dbTableNameT1Avg="tbl_f4_t1_avg";
        marksEntry.dbTableNameT2Avg="tbl_f4_t2_avg";
        marksEntry.dbTableNameT3Avg="tbl_f4_t3_avg";
        marksEntry.dbClassName="FORM_4";
        marksEntry.schName="WAVES ACADEMY LTD";
        marksEntry.clsName="Form 4";
        marksEntry.dbSubjectTable="tbl_f4_mat";
        marksEntry.subName="MATHEMATICS";
        marksEntry.sbj="mat";
        marksEntry.sbjg="matg";
        marksEntry.pn="p3";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/exams/marksEntry.fxml"));
Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
        stage.getIcons().add(applicationIcon);

            MarksEntry marksEntry1 = (MarksEntry) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 4 MATHEMATICS[Marks Entry]");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void openF4T1EntryPhy(){
        MarksEntry marksEntry = new MarksEntry();
        marksEntry.dbTableNameT1E1="tbl_f4_t1_ex1";
        marksEntry.dbTableNameT1E2="tbl_f4_t1_ex2";
        marksEntry.dbTableNameT1E3="tbl_f4_t1_ex3";
        marksEntry.dbTableNameT2E1="tbl_f4_t2_ex1";
        marksEntry.dbTableNameT2E2="tbl_f4_t2_ex2";
        marksEntry.dbTableNameT2E3="tbl_f4_t2_ex3";
        marksEntry.dbTableNameT3E1="tbl_f4_t3_ex1";
        marksEntry.dbTableNameT3E2="tbl_f4_t3_ex2";
        marksEntry.dbTableNameT3E3="tbl_f4_t3_ex3";
        marksEntry.dbTableNameT1Avg="tbl_f4_t1_avg";
        marksEntry.dbTableNameT2Avg="tbl_f4_t2_avg";
        marksEntry.dbTableNameT3Avg="tbl_f4_t3_avg";
        marksEntry.dbClassName="FORM_4";
        marksEntry.schName="WAVES ACADEMY LTD";
        marksEntry.clsName="Form 4";
        marksEntry.dbSubjectTable="tbl_f4_phy";
        marksEntry.subName="PHYSICS";
        marksEntry.sbj="phy";
        marksEntry.sbjg="phyg";
        marksEntry.pn="p6";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/exams/marksEntry.fxml"));
Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
        stage.getIcons().add(applicationIcon);

            MarksEntry marksEntry1 = (MarksEntry) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 4 PHYSICS[Marks Entry]");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void openF3T1EntryAgri(){
        MarksEntry marksEntry = new MarksEntry();
        marksEntry.dbTableNameT1E1="tbl_f3_t1_ex1";
        marksEntry.dbTableNameT1E2="tbl_f3_t1_ex2";
        marksEntry.dbTableNameT1E3="tbl_f3_t1_ex3";
        marksEntry.dbTableNameT2E1="tbl_f3_t2_ex1";
        marksEntry.dbTableNameT2E2="tbl_f3_t2_ex2";
        marksEntry.dbTableNameT2E3="tbl_f3_t2_ex3";
        marksEntry.dbTableNameT3E1="tbl_f3_t3_ex1";
        marksEntry.dbTableNameT3E2="tbl_f3_t3_ex2";
        marksEntry.dbTableNameT3E3="tbl_f3_t3_ex3";
        marksEntry.dbTableNameT1Avg="tbl_f3_t1_avg";
        marksEntry.dbTableNameT2Avg="tbl_f3_t2_avg";
        marksEntry.dbTableNameT3Avg="tbl_f3_t3_avg";
        marksEntry.dbClassName="FORM_3";
        marksEntry.schName="WAVES ACADEMY LTD";
        marksEntry.clsName="Form 3";
        marksEntry.dbSubjectTable="tbl_f3_agri";
        marksEntry.subName="AGRICULTURE";
        marksEntry.sbj="agri";
        marksEntry.sbjg="agrig";
        marksEntry.pn="p11";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/exams/marksEntry.fxml"));
Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
        stage.getIcons().add(applicationIcon);

            MarksEntry marksEntry1 = (MarksEntry) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 3 AGRICULTURE[Marks Entry]");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void openF3T1EntryBio(){
        MarksEntry marksEntry = new MarksEntry();
        marksEntry.dbTableNameT1E1="tbl_f3_t1_ex1";
        marksEntry.dbTableNameT1E2="tbl_f3_t1_ex2";
        marksEntry.dbTableNameT1E3="tbl_f3_t1_ex3";
        marksEntry.dbTableNameT2E1="tbl_f3_t2_ex1";
        marksEntry.dbTableNameT2E2="tbl_f3_t2_ex2";
        marksEntry.dbTableNameT2E3="tbl_f3_t2_ex3";
        marksEntry.dbTableNameT3E1="tbl_f3_t3_ex1";
        marksEntry.dbTableNameT3E2="tbl_f3_t3_ex2";
        marksEntry.dbTableNameT3E3="tbl_f3_t3_ex3";
        marksEntry.dbTableNameT1Avg="tbl_f3_t1_avg";
        marksEntry.dbTableNameT2Avg="tbl_f3_t2_avg";
        marksEntry.dbTableNameT3Avg="tbl_f3_t3_avg";
        marksEntry.dbClassName="FORM_3";
        marksEntry.schName="WAVES ACADEMY LTD";
        marksEntry.clsName="Form 3";
        marksEntry.dbSubjectTable="tbl_f3_bio";
        marksEntry.subName="BIOLOGY";
        marksEntry.sbj="bio";
        marksEntry.sbjg="biog";
        marksEntry.pn="p4";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/exams/marksEntry.fxml"));
Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
        stage.getIcons().add(applicationIcon);

            MarksEntry marksEntry1 = (MarksEntry) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 3 BIOLOGY[Marks Entry]");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void openF3T1EntryBus(){
        MarksEntry marksEntry = new MarksEntry();
        marksEntry.dbTableNameT1E1="tbl_f3_t1_ex1";
        marksEntry.dbTableNameT1E2="tbl_f3_t1_ex2";
        marksEntry.dbTableNameT1E3="tbl_f3_t1_ex3";
        marksEntry.dbTableNameT2E1="tbl_f3_t2_ex1";
        marksEntry.dbTableNameT2E2="tbl_f3_t2_ex2";
        marksEntry.dbTableNameT2E3="tbl_f3_t2_ex3";
        marksEntry.dbTableNameT3E1="tbl_f3_t3_ex1";
        marksEntry.dbTableNameT3E2="tbl_f3_t3_ex2";
        marksEntry.dbTableNameT3E3="tbl_f3_t3_ex3";
        marksEntry.dbTableNameT1Avg="tbl_f3_t1_avg";
        marksEntry.dbTableNameT2Avg="tbl_f3_t2_avg";
        marksEntry.dbTableNameT3Avg="tbl_f3_t3_avg";
        marksEntry.dbClassName="FORM_3";
        marksEntry.schName="WAVES ACADEMY LTD";
        marksEntry.clsName="Form 3";
        marksEntry.dbSubjectTable="tbl_f3_bus";
        marksEntry.subName="BUSINESS";
        marksEntry.sbj="bus";
        marksEntry.sbjg="busg";
        marksEntry.pn="p10";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/exams/marksEntry.fxml"));
Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
        stage.getIcons().add(applicationIcon);

            MarksEntry marksEntry1 = (MarksEntry) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 3 BUSINESS[Marks Entry]");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void openF3T1EntryChem(){
        MarksEntry marksEntry = new MarksEntry();
        marksEntry.dbTableNameT1E1="tbl_f3_t1_ex1";
        marksEntry.dbTableNameT1E2="tbl_f3_t1_ex2";
        marksEntry.dbTableNameT1E3="tbl_f3_t1_ex3";
        marksEntry.dbTableNameT2E1="tbl_f3_t2_ex1";
        marksEntry.dbTableNameT2E2="tbl_f3_t2_ex2";
        marksEntry.dbTableNameT2E3="tbl_f3_t2_ex3";
        marksEntry.dbTableNameT3E1="tbl_f3_t3_ex1";
        marksEntry.dbTableNameT3E2="tbl_f3_t3_ex2";
        marksEntry.dbTableNameT3E3="tbl_f3_t3_ex3";
        marksEntry.dbTableNameT1Avg="tbl_f3_t1_avg";
        marksEntry.dbTableNameT2Avg="tbl_f3_t2_avg";
        marksEntry.dbTableNameT3Avg="tbl_f3_t3_avg";
        marksEntry.dbClassName="FORM_3";
        marksEntry.schName="WAVES ACADEMY LTD";
        marksEntry.clsName="Form 3";
        marksEntry.dbSubjectTable="tbl_f3_chem";
        marksEntry.subName="CHEMISTRY";
        marksEntry.sbj="chem";
        marksEntry.sbjg="chemg";
        marksEntry.pn="p5";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/exams/marksEntry.fxml"));
Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
        stage.getIcons().add(applicationIcon);

            MarksEntry marksEntry1 = (MarksEntry) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 3 CHEMISTRY[Marks Entry]");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void openF3T1EntryCre(){
        MarksEntry marksEntry = new MarksEntry();
        marksEntry.dbTableNameT1E1="tbl_f3_t1_ex1";
        marksEntry.dbTableNameT1E2="tbl_f3_t1_ex2";
        marksEntry.dbTableNameT1E3="tbl_f3_t1_ex3";
        marksEntry.dbTableNameT2E1="tbl_f3_t2_ex1";
        marksEntry.dbTableNameT2E2="tbl_f3_t2_ex2";
        marksEntry.dbTableNameT2E3="tbl_f3_t2_ex3";
        marksEntry.dbTableNameT3E1="tbl_f3_t3_ex1";
        marksEntry.dbTableNameT3E2="tbl_f3_t3_ex2";
        marksEntry.dbTableNameT3E3="tbl_f3_t3_ex3";
        marksEntry.dbTableNameT1Avg="tbl_f3_t1_avg";
        marksEntry.dbTableNameT2Avg="tbl_f3_t2_avg";
        marksEntry.dbTableNameT3Avg="tbl_f3_t3_avg";
        marksEntry.dbClassName="FORM_3";
        marksEntry.schName="WAVES ACADEMY LTD";
        marksEntry.clsName="Form 3";
        marksEntry.dbSubjectTable="tbl_f3_cre";
        marksEntry.subName="CRE";
        marksEntry.sbj="cre";
        marksEntry.sbjg="creg";
        marksEntry.pn="p9";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/exams/marksEntry.fxml"));
Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
        stage.getIcons().add(applicationIcon);

            MarksEntry marksEntry1 = (MarksEntry) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 3 CRE[Marks Entry]");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void openF3T1EntryEng(){
        MarksEntry marksEntry = new MarksEntry();
        marksEntry.dbTableNameT1E1="tbl_f3_t1_ex1";
        marksEntry.dbTableNameT1E2="tbl_f3_t1_ex2";
        marksEntry.dbTableNameT1E3="tbl_f3_t1_ex3";
        marksEntry.dbTableNameT2E1="tbl_f3_t2_ex1";
        marksEntry.dbTableNameT2E2="tbl_f3_t2_ex2";
        marksEntry.dbTableNameT2E3="tbl_f3_t2_ex3";
        marksEntry.dbTableNameT3E1="tbl_f3_t3_ex1";
        marksEntry.dbTableNameT3E2="tbl_f3_t3_ex2";
        marksEntry.dbTableNameT3E3="tbl_f3_t3_ex3";
        marksEntry.dbTableNameT1Avg="tbl_f3_t1_avg";
        marksEntry.dbTableNameT2Avg="tbl_f3_t2_avg";
        marksEntry.dbTableNameT3Avg="tbl_f3_t3_avg";
        marksEntry.dbClassName="FORM_3";
        marksEntry.schName="WAVES ACADEMY LTD";
        marksEntry.clsName="Form 3";
        marksEntry.dbSubjectTable="tbl_f3_eng";
        marksEntry.subName="ENGLISH";
        marksEntry.sbj="eng";
        marksEntry.sbjg="engg";
        marksEntry.pn="p1";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/exams/marksEntry.fxml"));
Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
        stage.getIcons().add(applicationIcon);

            MarksEntry marksEntry1 = (MarksEntry) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 3 ENGLISH[Marks Entry]");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void openF3T1EntryGeo(){
        MarksEntry marksEntry = new MarksEntry();
        marksEntry.dbTableNameT1E1="tbl_f3_t1_ex1";
        marksEntry.dbTableNameT1E2="tbl_f3_t1_ex2";
        marksEntry.dbTableNameT1E3="tbl_f3_t1_ex3";
        marksEntry.dbTableNameT2E1="tbl_f3_t2_ex1";
        marksEntry.dbTableNameT2E2="tbl_f3_t2_ex2";
        marksEntry.dbTableNameT2E3="tbl_f3_t2_ex3";
        marksEntry.dbTableNameT3E1="tbl_f3_t3_ex1";
        marksEntry.dbTableNameT3E2="tbl_f3_t3_ex2";
        marksEntry.dbTableNameT3E3="tbl_f3_t3_ex3";
        marksEntry.dbTableNameT1Avg="tbl_f3_t1_avg";
        marksEntry.dbTableNameT2Avg="tbl_f3_t2_avg";
        marksEntry.dbTableNameT3Avg="tbl_f3_t3_avg";
        marksEntry.dbClassName="FORM_3";
        marksEntry.schName="WAVES ACADEMY LTD";
        marksEntry.clsName="Form 3";
        marksEntry.dbSubjectTable="tbl_f3_geo";
        marksEntry.subName="GEOGRAPHY";
        marksEntry.sbj="geo";
        marksEntry.sbjg="geog";
        marksEntry.pn="p7";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/exams/marksEntry.fxml"));
Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
        stage.getIcons().add(applicationIcon);

            MarksEntry marksEntry1 = (MarksEntry) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 3 GEOGRAPHY[Marks Entry]");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void openF3T1EntryHis(){
        MarksEntry marksEntry = new MarksEntry();
        marksEntry.dbTableNameT1E1="tbl_f3_t1_ex1";
        marksEntry.dbTableNameT1E2="tbl_f3_t1_ex2";
        marksEntry.dbTableNameT1E3="tbl_f3_t1_ex3";
        marksEntry.dbTableNameT2E1="tbl_f3_t2_ex1";
        marksEntry.dbTableNameT2E2="tbl_f3_t2_ex2";
        marksEntry.dbTableNameT2E3="tbl_f3_t2_ex3";
        marksEntry.dbTableNameT3E1="tbl_f3_t3_ex1";
        marksEntry.dbTableNameT3E2="tbl_f3_t3_ex2";
        marksEntry.dbTableNameT3E3="tbl_f3_t3_ex3";
        marksEntry.dbTableNameT1Avg="tbl_f3_t1_avg";
        marksEntry.dbTableNameT2Avg="tbl_f3_t2_avg";
        marksEntry.dbTableNameT3Avg="tbl_f3_t3_avg";
        marksEntry.dbClassName="FORM_3";
        marksEntry.schName="WAVES ACADEMY LTD";
        marksEntry.clsName="Form 3";
        marksEntry.dbSubjectTable="tbl_f3_his";
        marksEntry.subName="HISTORY";
        marksEntry.sbj="his";
        marksEntry.sbjg="hisg";
        marksEntry.pn="p8";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/exams/marksEntry.fxml"));
Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
        stage.getIcons().add(applicationIcon);

            MarksEntry marksEntry1 = (MarksEntry) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 3 HISTORY[Marks Entry]");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void openF3T1EntryKis(){
        MarksEntry marksEntry = new MarksEntry();
        marksEntry.dbTableNameT1E1="tbl_f3_t1_ex1";
        marksEntry.dbTableNameT1E2="tbl_f3_t1_ex2";
        marksEntry.dbTableNameT1E3="tbl_f3_t1_ex3";
        marksEntry.dbTableNameT2E1="tbl_f3_t2_ex1";
        marksEntry.dbTableNameT2E2="tbl_f3_t2_ex2";
        marksEntry.dbTableNameT2E3="tbl_f3_t2_ex3";
        marksEntry.dbTableNameT3E1="tbl_f3_t3_ex1";
        marksEntry.dbTableNameT3E2="tbl_f3_t3_ex2";
        marksEntry.dbTableNameT3E3="tbl_f3_t3_ex3";
        marksEntry.dbTableNameT1Avg="tbl_f3_t1_avg";
        marksEntry.dbTableNameT2Avg="tbl_f3_t2_avg";
        marksEntry.dbTableNameT3Avg="tbl_f3_t3_avg";
        marksEntry.dbClassName="FORM_3";
        marksEntry.schName="WAVES ACADEMY LTD";
        marksEntry.clsName="Form 3";
        marksEntry.dbSubjectTable="tbl_f3_kis";
        marksEntry.subName="KISWAHILI";
        marksEntry.sbj="kis";
        marksEntry.sbjg="kisg";
        marksEntry.pn="p2";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/exams/marksEntry.fxml"));
Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
        stage.getIcons().add(applicationIcon);

            MarksEntry marksEntry1 = (MarksEntry) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 3 KISWAHILI[Marks Entry]");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void openF3T1EntryMat(){
        MarksEntry marksEntry = new MarksEntry();
        marksEntry.dbTableNameT1E1="tbl_f3_t1_ex1";
        marksEntry.dbTableNameT1E2="tbl_f3_t1_ex2";
        marksEntry.dbTableNameT1E3="tbl_f3_t1_ex3";
        marksEntry.dbTableNameT2E1="tbl_f3_t2_ex1";
        marksEntry.dbTableNameT2E2="tbl_f3_t2_ex2";
        marksEntry.dbTableNameT2E3="tbl_f3_t2_ex3";
        marksEntry.dbTableNameT3E1="tbl_f3_t3_ex1";
        marksEntry.dbTableNameT3E2="tbl_f3_t3_ex2";
        marksEntry.dbTableNameT3E3="tbl_f3_t3_ex3";
        marksEntry.dbTableNameT1Avg="tbl_f3_t1_avg";
        marksEntry.dbTableNameT2Avg="tbl_f3_t2_avg";
        marksEntry.dbTableNameT3Avg="tbl_f3_t3_avg";
        marksEntry.dbClassName="FORM_3";
        marksEntry.schName="WAVES ACADEMY LTD";
        marksEntry.clsName="Form 3";
        marksEntry.dbSubjectTable="tbl_f3_mat";
        marksEntry.subName="MATHEMATICS";
        marksEntry.sbj="mat";
        marksEntry.sbjg="matg";
        marksEntry.pn="p3";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/exams/marksEntry.fxml"));
Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
        stage.getIcons().add(applicationIcon);

            MarksEntry marksEntry1 = (MarksEntry) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 3 MATHEMATICS[Marks Entry]");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void openF3T1EntryPhy(){
        MarksEntry marksEntry = new MarksEntry();
        marksEntry.dbTableNameT1E1="tbl_f3_t1_ex1";
        marksEntry.dbTableNameT1E2="tbl_f3_t1_ex2";
        marksEntry.dbTableNameT1E3="tbl_f3_t1_ex3";
        marksEntry.dbTableNameT2E1="tbl_f3_t2_ex1";
        marksEntry.dbTableNameT2E2="tbl_f3_t2_ex2";
        marksEntry.dbTableNameT2E3="tbl_f3_t2_ex3";
        marksEntry.dbTableNameT3E1="tbl_f3_t3_ex1";
        marksEntry.dbTableNameT3E2="tbl_f3_t3_ex2";
        marksEntry.dbTableNameT3E3="tbl_f3_t3_ex3";
        marksEntry.dbTableNameT1Avg="tbl_f3_t1_avg";
        marksEntry.dbTableNameT2Avg="tbl_f3_t2_avg";
        marksEntry.dbTableNameT3Avg="tbl_f3_t3_avg";
        marksEntry.dbClassName="FORM_3";
        marksEntry.schName="WAVES ACADEMY LTD";
        marksEntry.clsName="Form 3";
        marksEntry.dbSubjectTable="tbl_f3_phy";
        marksEntry.subName="PHYSICS";
        marksEntry.sbj="phy";
        marksEntry.sbjg="phyg";
        marksEntry.pn="p6";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/exams/marksEntry.fxml"));
Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
        stage.getIcons().add(applicationIcon);

            MarksEntry marksEntry1 = (MarksEntry) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 3 PHYSICS[Marks Entry]");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void openF2T1EntryAgri(){
        MarksEntry marksEntry = new MarksEntry();
        marksEntry.dbTableNameT1E1="tbl_f2_t1_ex1";
        marksEntry.dbTableNameT1E2="tbl_f2_t1_ex2";
        marksEntry.dbTableNameT1E3="tbl_f2_t1_ex3";
        marksEntry.dbTableNameT2E1="tbl_f2_t2_ex1";
        marksEntry.dbTableNameT2E2="tbl_f2_t2_ex2";
        marksEntry.dbTableNameT2E3="tbl_f2_t2_ex3";
        marksEntry.dbTableNameT3E1="tbl_f2_t3_ex1";
        marksEntry.dbTableNameT3E2="tbl_f2_t3_ex2";
        marksEntry.dbTableNameT3E3="tbl_f2_t3_ex3";
        marksEntry.dbTableNameT1Avg="tbl_f2_t1_avg";
        marksEntry.dbTableNameT2Avg="tbl_f2_t2_avg";
        marksEntry.dbTableNameT3Avg="tbl_f2_t3_avg";
        marksEntry.dbClassName="FORM_2";
        marksEntry.schName="WAVES ACADEMY LTD";
        marksEntry.clsName="Form 2";
        marksEntry.dbSubjectTable="tbl_f2_agri";
        marksEntry.subName="AGRICULTURE";
        marksEntry.sbj="agri";
        marksEntry.sbjg="agrig";
        marksEntry.pn="p11";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/exams/marksEntry.fxml"));
Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
        stage.getIcons().add(applicationIcon);

            MarksEntry marksEntry1 = (MarksEntry) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 2 AGRICULTURE[Marks Entry]");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void openF2T1EntryBio(){
        MarksEntry marksEntry = new MarksEntry();
        marksEntry.dbTableNameT1E1="tbl_f2_t1_ex1";
        marksEntry.dbTableNameT1E2="tbl_f2_t1_ex2";
        marksEntry.dbTableNameT1E3="tbl_f2_t1_ex3";
        marksEntry.dbTableNameT2E1="tbl_f2_t2_ex1";
        marksEntry.dbTableNameT2E2="tbl_f2_t2_ex2";
        marksEntry.dbTableNameT2E3="tbl_f2_t2_ex3";
        marksEntry.dbTableNameT3E1="tbl_f2_t3_ex1";
        marksEntry.dbTableNameT3E2="tbl_f2_t3_ex2";
        marksEntry.dbTableNameT3E3="tbl_f2_t3_ex3";
        marksEntry.dbTableNameT1Avg="tbl_f2_t1_avg";
        marksEntry.dbTableNameT2Avg="tbl_f2_t2_avg";
        marksEntry.dbTableNameT3Avg="tbl_f2_t3_avg";
        marksEntry.dbClassName="FORM_2";
        marksEntry.schName="WAVES ACADEMY LTD";
        marksEntry.clsName="Form 2";
        marksEntry.dbSubjectTable="tbl_f2_bio";
        marksEntry.subName="BIOLOGY";
        marksEntry.sbj="bio";
        marksEntry.sbjg="biog";
        marksEntry.pn="p4";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/exams/marksEntry.fxml"));
Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
        stage.getIcons().add(applicationIcon);

            MarksEntry marksEntry1 = (MarksEntry) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 2 BIOLOGY[Marks Entry]");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void openF2T1EntryBus(){
        MarksEntry marksEntry = new MarksEntry();
        marksEntry.dbTableNameT1E1="tbl_f2_t1_ex1";
        marksEntry.dbTableNameT1E2="tbl_f2_t1_ex2";
        marksEntry.dbTableNameT1E3="tbl_f2_t1_ex3";
        marksEntry.dbTableNameT2E1="tbl_f2_t2_ex1";
        marksEntry.dbTableNameT2E2="tbl_f2_t2_ex2";
        marksEntry.dbTableNameT2E3="tbl_f2_t2_ex3";
        marksEntry.dbTableNameT3E1="tbl_f2_t3_ex1";
        marksEntry.dbTableNameT3E2="tbl_f2_t3_ex2";
        marksEntry.dbTableNameT3E3="tbl_f2_t3_ex3";
        marksEntry.dbTableNameT1Avg="tbl_f2_t1_avg";
        marksEntry.dbTableNameT2Avg="tbl_f2_t2_avg";
        marksEntry.dbTableNameT3Avg="tbl_f2_t3_avg";
        marksEntry.dbClassName="FORM_2";
        marksEntry.schName="WAVES ACADEMY LTD";
        marksEntry.clsName="Form 2";
        marksEntry.dbSubjectTable="tbl_f2_bus";
        marksEntry.subName="BUSINESS";
        marksEntry.sbj="bus";
        marksEntry.sbjg="busg";
        marksEntry.pn="p10";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/exams/marksEntry.fxml"));
Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
        stage.getIcons().add(applicationIcon);

            MarksEntry marksEntry1 = (MarksEntry) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 2 BUSINESS[Marks Entry]");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void openF2T1EntryChem(){
        MarksEntry marksEntry = new MarksEntry();
        marksEntry.dbTableNameT1E1="tbl_f2_t1_ex1";
        marksEntry.dbTableNameT1E2="tbl_f2_t1_ex2";
        marksEntry.dbTableNameT1E3="tbl_f2_t1_ex3";
        marksEntry.dbTableNameT2E1="tbl_f2_t2_ex1";
        marksEntry.dbTableNameT2E2="tbl_f2_t2_ex2";
        marksEntry.dbTableNameT2E3="tbl_f2_t2_ex3";
        marksEntry.dbTableNameT3E1="tbl_f2_t3_ex1";
        marksEntry.dbTableNameT3E2="tbl_f2_t3_ex2";
        marksEntry.dbTableNameT3E3="tbl_f2_t3_ex3";
        marksEntry.dbTableNameT1Avg="tbl_f2_t1_avg";
        marksEntry.dbTableNameT2Avg="tbl_f2_t2_avg";
        marksEntry.dbTableNameT3Avg="tbl_f2_t3_avg";
        marksEntry.dbClassName="FORM_2";
        marksEntry.schName="WAVES ACADEMY LTD";
        marksEntry.clsName="Form 2";
        marksEntry.dbSubjectTable="tbl_f2_chem";
        marksEntry.subName="CHEMISTRY";
        marksEntry.sbj="chem";
        marksEntry.sbjg="chemg";
        marksEntry.pn="p5";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/exams/marksEntry.fxml"));
Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
        stage.getIcons().add(applicationIcon);

            MarksEntry marksEntry1 = (MarksEntry) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 2 CHEMISTRY[Marks Entry]");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void openF2T1EntryCre(){
        MarksEntry marksEntry = new MarksEntry();
        marksEntry.dbTableNameT1E1="tbl_f2_t1_ex1";
        marksEntry.dbTableNameT1E2="tbl_f2_t1_ex2";
        marksEntry.dbTableNameT1E3="tbl_f2_t1_ex3";
        marksEntry.dbTableNameT2E1="tbl_f2_t2_ex1";
        marksEntry.dbTableNameT2E2="tbl_f2_t2_ex2";
        marksEntry.dbTableNameT2E3="tbl_f2_t2_ex3";
        marksEntry.dbTableNameT3E1="tbl_f2_t3_ex1";
        marksEntry.dbTableNameT3E2="tbl_f2_t3_ex2";
        marksEntry.dbTableNameT3E3="tbl_f2_t3_ex3";
        marksEntry.dbTableNameT1Avg="tbl_f2_t1_avg";
        marksEntry.dbTableNameT2Avg="tbl_f2_t2_avg";
        marksEntry.dbTableNameT3Avg="tbl_f2_t3_avg";
        marksEntry.dbClassName="FORM_2";
        marksEntry.schName="WAVES ACADEMY LTD";
        marksEntry.clsName="Form 2";
        marksEntry.dbSubjectTable="tbl_f2_cre";
        marksEntry.subName="CRE";
        marksEntry.sbj="cre";
        marksEntry.sbjg="creg";
        marksEntry.pn="p9";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/exams/marksEntry.fxml"));
Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
        stage.getIcons().add(applicationIcon);

            MarksEntry marksEntry1 = (MarksEntry) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 2 CRE[Marks Entry]");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void openF2T1EntryEng(){
        MarksEntry marksEntry = new MarksEntry();
        marksEntry.dbTableNameT1E1="tbl_f2_t1_ex1";
        marksEntry.dbTableNameT1E2="tbl_f2_t1_ex2";
        marksEntry.dbTableNameT1E3="tbl_f2_t1_ex3";
        marksEntry.dbTableNameT2E1="tbl_f2_t2_ex1";
        marksEntry.dbTableNameT2E2="tbl_f2_t2_ex2";
        marksEntry.dbTableNameT2E3="tbl_f2_t2_ex3";
        marksEntry.dbTableNameT3E1="tbl_f2_t3_ex1";
        marksEntry.dbTableNameT3E2="tbl_f2_t3_ex2";
        marksEntry.dbTableNameT3E3="tbl_f2_t3_ex3";
        marksEntry.dbTableNameT1Avg="tbl_f2_t1_avg";
        marksEntry.dbTableNameT2Avg="tbl_f2_t2_avg";
        marksEntry.dbTableNameT3Avg="tbl_f2_t3_avg";
        marksEntry.dbClassName="FORM_2";
        marksEntry.schName="WAVES ACADEMY LTD";
        marksEntry.clsName="Form 2";
        marksEntry.dbSubjectTable="tbl_f2_eng";
        marksEntry.subName="ENGLISH";
        marksEntry.sbj="eng";
        marksEntry.sbjg="engg";
        marksEntry.pn="p1";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/exams/marksEntry.fxml"));
Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
        stage.getIcons().add(applicationIcon);

            MarksEntry marksEntry1 = (MarksEntry) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 2 ENGLISH[Marks Entry]");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void openF2T1EntryGeo(){
        MarksEntry marksEntry = new MarksEntry();
        marksEntry.dbTableNameT1E1="tbl_f2_t1_ex1";
        marksEntry.dbTableNameT1E2="tbl_f2_t1_ex2";
        marksEntry.dbTableNameT1E3="tbl_f2_t1_ex3";
        marksEntry.dbTableNameT2E1="tbl_f2_t2_ex1";
        marksEntry.dbTableNameT2E2="tbl_f2_t2_ex2";
        marksEntry.dbTableNameT2E3="tbl_f2_t2_ex3";
        marksEntry.dbTableNameT3E1="tbl_f2_t3_ex1";
        marksEntry.dbTableNameT3E2="tbl_f2_t3_ex2";
        marksEntry.dbTableNameT3E3="tbl_f2_t3_ex3";
        marksEntry.dbTableNameT1Avg="tbl_f2_t1_avg";
        marksEntry.dbTableNameT2Avg="tbl_f2_t2_avg";
        marksEntry.dbTableNameT3Avg="tbl_f2_t3_avg";
        marksEntry.dbClassName="FORM_2";
        marksEntry.schName="WAVES ACADEMY LTD";
        marksEntry.clsName="Form 2";
        marksEntry.dbSubjectTable="tbl_f2_geo";
        marksEntry.subName="GEOGRAPHY";
        marksEntry.sbj="geo";
        marksEntry.sbjg="geog";
        marksEntry.pn="p7";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/exams/marksEntry.fxml"));
Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
        stage.getIcons().add(applicationIcon);

            MarksEntry marksEntry1 = (MarksEntry) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 2 GEOGRAPHY[Marks Entry]");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void openF2T1EntryHis(){
        MarksEntry marksEntry = new MarksEntry();
        marksEntry.dbTableNameT1E1="tbl_f2_t1_ex1";
        marksEntry.dbTableNameT1E2="tbl_f2_t1_ex2";
        marksEntry.dbTableNameT1E3="tbl_f2_t1_ex3";
        marksEntry.dbTableNameT2E1="tbl_f2_t2_ex1";
        marksEntry.dbTableNameT2E2="tbl_f2_t2_ex2";
        marksEntry.dbTableNameT2E3="tbl_f2_t2_ex3";
        marksEntry.dbTableNameT3E1="tbl_f2_t3_ex1";
        marksEntry.dbTableNameT3E2="tbl_f2_t3_ex2";
        marksEntry.dbTableNameT3E3="tbl_f2_t3_ex3";
        marksEntry.dbTableNameT1Avg="tbl_f2_t1_avg";
        marksEntry.dbTableNameT2Avg="tbl_f2_t2_avg";
        marksEntry.dbTableNameT3Avg="tbl_f2_t3_avg";
        marksEntry.dbClassName="FORM_2";
        marksEntry.schName="WAVES ACADEMY LTD";
        marksEntry.clsName="Form 2";
        marksEntry.dbSubjectTable="tbl_f2_his";
        marksEntry.subName="HISTORY";
        marksEntry.sbj="his";
        marksEntry.sbjg="hisg";
        marksEntry.pn="p8";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/exams/marksEntry.fxml"));
Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
        stage.getIcons().add(applicationIcon);

            MarksEntry marksEntry1 = (MarksEntry) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 2 HISTORY[Marks Entry]");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void openF2T1EntryKis(){
        MarksEntry marksEntry = new MarksEntry();
        marksEntry.dbTableNameT1E1="tbl_f2_t1_ex1";
        marksEntry.dbTableNameT1E2="tbl_f2_t1_ex2";
        marksEntry.dbTableNameT1E3="tbl_f2_t1_ex3";
        marksEntry.dbTableNameT2E1="tbl_f2_t2_ex1";
        marksEntry.dbTableNameT2E2="tbl_f2_t2_ex2";
        marksEntry.dbTableNameT2E3="tbl_f2_t2_ex3";
        marksEntry.dbTableNameT3E1="tbl_f2_t3_ex1";
        marksEntry.dbTableNameT3E2="tbl_f2_t3_ex2";
        marksEntry.dbTableNameT3E3="tbl_f2_t3_ex3";
        marksEntry.dbTableNameT1Avg="tbl_f2_t1_avg";
        marksEntry.dbTableNameT2Avg="tbl_f2_t2_avg";
        marksEntry.dbTableNameT3Avg="tbl_f2_t3_avg";
        marksEntry.dbClassName="FORM_2";
        marksEntry.schName="WAVES ACADEMY LTD";
        marksEntry.clsName="Form 2";
        marksEntry.dbSubjectTable="tbl_f2_kis";
        marksEntry.subName="KISWAHILI";
        marksEntry.sbj="kis";
        marksEntry.sbjg="kisg";
        marksEntry.pn="p2";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/exams/marksEntry.fxml"));
Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
        stage.getIcons().add(applicationIcon);

            MarksEntry marksEntry1 = (MarksEntry) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 2 KISWAHILI[Marks Entry]");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void openF2T1EntryMat(){
        MarksEntry marksEntry = new MarksEntry();
        marksEntry.dbTableNameT1E1="tbl_f2_t1_ex1";
        marksEntry.dbTableNameT1E2="tbl_f2_t1_ex2";
        marksEntry.dbTableNameT1E3="tbl_f2_t1_ex3";
        marksEntry.dbTableNameT2E1="tbl_f2_t2_ex1";
        marksEntry.dbTableNameT2E2="tbl_f2_t2_ex2";
        marksEntry.dbTableNameT2E3="tbl_f2_t2_ex3";
        marksEntry.dbTableNameT3E1="tbl_f2_t3_ex1";
        marksEntry.dbTableNameT3E2="tbl_f2_t3_ex2";
        marksEntry.dbTableNameT3E3="tbl_f2_t3_ex3";
        marksEntry.dbTableNameT1Avg="tbl_f2_t1_avg";
        marksEntry.dbTableNameT2Avg="tbl_f2_t2_avg";
        marksEntry.dbTableNameT3Avg="tbl_f2_t3_avg";
        marksEntry.dbClassName="FORM_2";
        marksEntry.schName="WAVES ACADEMY LTD";
        marksEntry.clsName="Form 2";
        marksEntry.dbSubjectTable="tbl_f2_mat";
        marksEntry.subName="MATHEMATICS";
        marksEntry.sbj="mat";
        marksEntry.sbjg="matg";
        marksEntry.pn="p3";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/exams/marksEntry.fxml"));
Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
        stage.getIcons().add(applicationIcon);

            MarksEntry marksEntry1 = (MarksEntry) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 2 MATHEMATICS[Marks Entry]");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void openF2T1EntryPhy(){
        MarksEntry marksEntry = new MarksEntry();
        marksEntry.dbTableNameT1E1="tbl_f2_t1_ex1";
        marksEntry.dbTableNameT1E2="tbl_f2_t1_ex2";
        marksEntry.dbTableNameT1E3="tbl_f2_t1_ex3";
        marksEntry.dbTableNameT2E1="tbl_f2_t2_ex1";
        marksEntry.dbTableNameT2E2="tbl_f2_t2_ex2";
        marksEntry.dbTableNameT2E3="tbl_f2_t2_ex3";
        marksEntry.dbTableNameT3E1="tbl_f2_t3_ex1";
        marksEntry.dbTableNameT3E2="tbl_f2_t3_ex2";
        marksEntry.dbTableNameT3E3="tbl_f2_t3_ex3";
        marksEntry.dbTableNameT1Avg="tbl_f2_t1_avg";
        marksEntry.dbTableNameT2Avg="tbl_f2_t2_avg";
        marksEntry.dbTableNameT3Avg="tbl_f2_t3_avg";
        marksEntry.dbClassName="FORM_2";
        marksEntry.schName="WAVES ACADEMY LTD";
        marksEntry.clsName="Form 2";
        marksEntry.dbSubjectTable="tbl_f2_phy";
        marksEntry.subName="PHYSICS";
        marksEntry.sbj="phy";
        marksEntry.sbjg="phyg";
        marksEntry.pn="p6";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/exams/marksEntry.fxml"));
Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
        stage.getIcons().add(applicationIcon);

            MarksEntry marksEntry1 = (MarksEntry) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 2 PHYSICS[Marks Entry]");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void openF1T1EntryAgri(){
        MarksEntry marksEntry = new MarksEntry();
        marksEntry.dbTableNameT1E1="tbl_f1_t1_ex1";
        marksEntry.dbTableNameT1E2="tbl_f1_t1_ex2";
        marksEntry.dbTableNameT1E3="tbl_f1_t1_ex3";
        marksEntry.dbTableNameT2E1="tbl_f1_t2_ex1";
        marksEntry.dbTableNameT2E2="tbl_f1_t2_ex2";
        marksEntry.dbTableNameT2E3="tbl_f1_t2_ex3";
        marksEntry.dbTableNameT3E1="tbl_f1_t3_ex1";
        marksEntry.dbTableNameT3E2="tbl_f1_t3_ex2";
        marksEntry.dbTableNameT3E3="tbl_f1_t3_ex3";
        marksEntry.dbTableNameT1Avg="tbl_f1_t1_avg";
        marksEntry.dbTableNameT2Avg="tbl_f1_t2_avg";
        marksEntry.dbTableNameT3Avg="tbl_f1_t3_avg";
        marksEntry.dbClassName="FORM_1";
        marksEntry.schName="WAVES ACADEMY LTD";
        marksEntry.clsName="Form 1";
        marksEntry.dbSubjectTable="tbl_f1_agri";
        marksEntry.subName="AGRICULTURE";
        marksEntry.sbj="agri";
        marksEntry.sbjg="agrig";
        marksEntry.pn="p11";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/exams/marksEntry.fxml"));
Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
        stage.getIcons().add(applicationIcon);

            MarksEntry marksEntry1 = (MarksEntry) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 1 AGRICULTURE[Marks Entry]");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void openF1T1EntryBio(){
        MarksEntry marksEntry = new MarksEntry();
        marksEntry.dbTableNameT1E1="tbl_f1_t1_ex1";
        marksEntry.dbTableNameT1E2="tbl_f1_t1_ex2";
        marksEntry.dbTableNameT1E3="tbl_f1_t1_ex3";
        marksEntry.dbTableNameT2E1="tbl_f1_t2_ex1";
        marksEntry.dbTableNameT2E2="tbl_f1_t2_ex2";
        marksEntry.dbTableNameT2E3="tbl_f1_t2_ex3";
        marksEntry.dbTableNameT3E1="tbl_f1_t3_ex1";
        marksEntry.dbTableNameT3E2="tbl_f1_t3_ex2";
        marksEntry.dbTableNameT3E3="tbl_f1_t3_ex3";
        marksEntry.dbTableNameT1Avg="tbl_f1_t1_avg";
        marksEntry.dbTableNameT2Avg="tbl_f1_t2_avg";
        marksEntry.dbTableNameT3Avg="tbl_f1_t3_avg";
        marksEntry.dbClassName="FORM_1";
        marksEntry.schName="WAVES ACADEMY LTD";
        marksEntry.clsName="Form 1";
        marksEntry.dbSubjectTable="tbl_f1_bio";
        marksEntry.subName="BIOLOGY";
        marksEntry.sbj="bio";
        marksEntry.sbjg="biog";
        marksEntry.pn="p4";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/exams/marksEntry.fxml"));
Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
        stage.getIcons().add(applicationIcon);

            MarksEntry marksEntry1 = (MarksEntry) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 1 BIOLOGY[Marks Entry]");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void openF1T1EntryBus(){
        MarksEntry marksEntry = new MarksEntry();
        marksEntry.dbTableNameT1E1="tbl_f1_t1_ex1";
        marksEntry.dbTableNameT1E2="tbl_f1_t1_ex2";
        marksEntry.dbTableNameT1E3="tbl_f1_t1_ex3";
        marksEntry.dbTableNameT2E1="tbl_f1_t2_ex1";
        marksEntry.dbTableNameT2E2="tbl_f1_t2_ex2";
        marksEntry.dbTableNameT2E3="tbl_f1_t2_ex3";
        marksEntry.dbTableNameT3E1="tbl_f1_t3_ex1";
        marksEntry.dbTableNameT3E2="tbl_f1_t3_ex2";
        marksEntry.dbTableNameT3E3="tbl_f1_t3_ex3";
        marksEntry.dbTableNameT1Avg="tbl_f1_t1_avg";
        marksEntry.dbTableNameT2Avg="tbl_f1_t2_avg";
        marksEntry.dbTableNameT3Avg="tbl_f1_t3_avg";
        marksEntry.dbClassName="FORM_1";
        marksEntry.schName="WAVES ACADEMY LTD";
        marksEntry.clsName="Form 1";
        marksEntry.dbSubjectTable="tbl_f1_bus";
        marksEntry.subName="BUSINESS";
        marksEntry.sbj="bus";
        marksEntry.sbjg="busg";
        marksEntry.pn="p10";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/exams/marksEntry.fxml"));
Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
        stage.getIcons().add(applicationIcon);

            MarksEntry marksEntry1 = (MarksEntry) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 1 BUSINESS[Marks Entry]");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void openF1T1EntryChem(){
        MarksEntry marksEntry = new MarksEntry();
        marksEntry.dbTableNameT1E1="tbl_f1_t1_ex1";
        marksEntry.dbTableNameT1E2="tbl_f1_t1_ex2";
        marksEntry.dbTableNameT1E3="tbl_f1_t1_ex3";
        marksEntry.dbTableNameT2E1="tbl_f1_t2_ex1";
        marksEntry.dbTableNameT2E2="tbl_f1_t2_ex2";
        marksEntry.dbTableNameT2E3="tbl_f1_t2_ex3";
        marksEntry.dbTableNameT3E1="tbl_f1_t3_ex1";
        marksEntry.dbTableNameT3E2="tbl_f1_t3_ex2";
        marksEntry.dbTableNameT3E3="tbl_f1_t3_ex3";
        marksEntry.dbTableNameT1Avg="tbl_f1_t1_avg";
        marksEntry.dbTableNameT2Avg="tbl_f1_t2_avg";
        marksEntry.dbTableNameT3Avg="tbl_f1_t3_avg";
        marksEntry.dbClassName="FORM_1";
        marksEntry.schName="WAVES ACADEMY LTD";
        marksEntry.clsName="Form 1";
        marksEntry.dbSubjectTable="tbl_f1_chem";
        marksEntry.subName="CHEMISTRY";
        marksEntry.sbj="chem";
        marksEntry.sbjg="chemg";
        marksEntry.pn="p5";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/exams/marksEntry.fxml"));
Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
        stage.getIcons().add(applicationIcon);

            MarksEntry marksEntry1 = (MarksEntry) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 1 CHEMISTRY[Marks Entry]");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void openF1T1EntryCre(){
        MarksEntry marksEntry = new MarksEntry();
        marksEntry.dbTableNameT1E1="tbl_f1_t1_ex1";
        marksEntry.dbTableNameT1E2="tbl_f1_t1_ex2";
        marksEntry.dbTableNameT1E3="tbl_f1_t1_ex3";
        marksEntry.dbTableNameT2E1="tbl_f1_t2_ex1";
        marksEntry.dbTableNameT2E2="tbl_f1_t2_ex2";
        marksEntry.dbTableNameT2E3="tbl_f1_t2_ex3";
        marksEntry.dbTableNameT3E1="tbl_f1_t3_ex1";
        marksEntry.dbTableNameT3E2="tbl_f1_t3_ex2";
        marksEntry.dbTableNameT3E3="tbl_f1_t3_ex3";
        marksEntry.dbTableNameT1Avg="tbl_f1_t1_avg";
        marksEntry.dbTableNameT2Avg="tbl_f1_t2_avg";
        marksEntry.dbTableNameT3Avg="tbl_f1_t3_avg";
        marksEntry.dbClassName="FORM_1";
        marksEntry.schName="WAVES ACADEMY LTD";
        marksEntry.clsName="Form 1";
        marksEntry.dbSubjectTable="tbl_f1_cre";
        marksEntry.subName="CRE";
        marksEntry.sbj="cre";
        marksEntry.sbjg="creg";
        marksEntry.pn="p9";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/exams/marksEntry.fxml"));
Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
        stage.getIcons().add(applicationIcon);

            MarksEntry marksEntry1 = (MarksEntry) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 1 CRE[Marks Entry]");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void openF1T1EntryEng(){
        MarksEntry marksEntry = new MarksEntry();
        marksEntry.dbTableNameT1E1="tbl_f1_t1_ex1";
        marksEntry.dbTableNameT1E2="tbl_f1_t1_ex2";
        marksEntry.dbTableNameT1E3="tbl_f1_t1_ex3";
        marksEntry.dbTableNameT2E1="tbl_f1_t2_ex1";
        marksEntry.dbTableNameT2E2="tbl_f1_t2_ex2";
        marksEntry.dbTableNameT2E3="tbl_f1_t2_ex3";
        marksEntry.dbTableNameT3E1="tbl_f1_t3_ex1";
        marksEntry.dbTableNameT3E2="tbl_f1_t3_ex2";
        marksEntry.dbTableNameT3E3="tbl_f1_t3_ex3";
        marksEntry.dbTableNameT1Avg="tbl_f1_t1_avg";
        marksEntry.dbTableNameT2Avg="tbl_f1_t2_avg";
        marksEntry.dbTableNameT3Avg="tbl_f1_t3_avg";
        marksEntry.dbClassName="FORM_1";
        marksEntry.schName="WAVES ACADEMY LTD";
        marksEntry.clsName="Form 1";
        marksEntry.dbSubjectTable="tbl_f1_eng";
        marksEntry.subName="ENGLISH";
        marksEntry.sbj="eng";
        marksEntry.sbjg="engg";
        marksEntry.pn="p1";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/exams/marksEntry.fxml"));
Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
        stage.getIcons().add(applicationIcon);
            //Pane root = (Pane)loader.load(getClass().getResource("../marksEntry.fxml"));

            MarksEntry marksEntry1 = (MarksEntry) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 1 ENGLISH[Marks Entry]");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();

        }
    }

    public void openF1T1EntryGeo(){
        MarksEntry marksEntry = new MarksEntry();
        marksEntry.dbTableNameT1E1="tbl_f1_t1_ex1";
        marksEntry.dbTableNameT1E2="tbl_f1_t1_ex2";
        marksEntry.dbTableNameT1E3="tbl_f1_t1_ex3";
        marksEntry.dbTableNameT2E1="tbl_f1_t2_ex1";
        marksEntry.dbTableNameT2E2="tbl_f1_t2_ex2";
        marksEntry.dbTableNameT2E3="tbl_f1_t2_ex3";
        marksEntry.dbTableNameT3E1="tbl_f1_t3_ex1";
        marksEntry.dbTableNameT3E2="tbl_f1_t3_ex2";
        marksEntry.dbTableNameT3E3="tbl_f1_t3_ex3";
        marksEntry.dbTableNameT1Avg="tbl_f1_t1_avg";
        marksEntry.dbTableNameT2Avg="tbl_f1_t2_avg";
        marksEntry.dbTableNameT3Avg="tbl_f1_t3_avg";
        marksEntry.dbClassName="FORM_1";
        marksEntry.schName="WAVES ACADEMY LTD";
        marksEntry.clsName="Form 1";
        marksEntry.dbSubjectTable="tbl_f1_geo";
        marksEntry.subName="GEOGRAPHY";
        marksEntry.sbj="geo";
        marksEntry.sbjg="geog";
        marksEntry.pn="p7";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/exams/marksEntry.fxml"));
Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
        stage.getIcons().add(applicationIcon);

            MarksEntry marksEntry1 = (MarksEntry) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 1 GEOGRAPHY[Marks Entry]");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void openF1T1EntryHis(){
        MarksEntry marksEntry = new MarksEntry();
        marksEntry.dbTableNameT1E1="tbl_f1_t1_ex1";
        marksEntry.dbTableNameT1E2="tbl_f1_t1_ex2";
        marksEntry.dbTableNameT1E3="tbl_f1_t1_ex3";
        marksEntry.dbTableNameT2E1="tbl_f1_t2_ex1";
        marksEntry.dbTableNameT2E2="tbl_f1_t2_ex2";
        marksEntry.dbTableNameT2E3="tbl_f1_t2_ex3";
        marksEntry.dbTableNameT3E1="tbl_f1_t3_ex1";
        marksEntry.dbTableNameT3E2="tbl_f1_t3_ex2";
        marksEntry.dbTableNameT3E3="tbl_f1_t3_ex3";
        marksEntry.dbTableNameT1Avg="tbl_f1_t1_avg";
        marksEntry.dbTableNameT2Avg="tbl_f1_t2_avg";
        marksEntry.dbTableNameT3Avg="tbl_f1_t3_avg";
        marksEntry.dbClassName="FORM_1";
        marksEntry.schName="WAVES ACADEMY LTD";
        marksEntry.clsName="Form 1";
        marksEntry.dbSubjectTable="tbl_f1_his";
        marksEntry.subName="HISTORY";
        marksEntry.sbj="his";
        marksEntry.sbjg="hisg";
        marksEntry.pn="p8";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/exams/marksEntry.fxml"));
Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
        stage.getIcons().add(applicationIcon);

            MarksEntry marksEntry1 = (MarksEntry) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 1 HISTORY[Marks Entry]");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void openF1T1EntryKis(){
        MarksEntry marksEntry = new MarksEntry();
        marksEntry.dbTableNameT1E1="tbl_f1_t1_ex1";
        marksEntry.dbTableNameT1E2="tbl_f1_t1_ex2";
        marksEntry.dbTableNameT1E3="tbl_f1_t1_ex3";
        marksEntry.dbTableNameT2E1="tbl_f1_t2_ex1";
        marksEntry.dbTableNameT2E2="tbl_f1_t2_ex2";
        marksEntry.dbTableNameT2E3="tbl_f1_t2_ex3";
        marksEntry.dbTableNameT3E1="tbl_f1_t3_ex1";
        marksEntry.dbTableNameT3E2="tbl_f1_t3_ex2";
        marksEntry.dbTableNameT3E3="tbl_f1_t3_ex3";
        marksEntry.dbTableNameT1Avg="tbl_f1_t1_avg";
        marksEntry.dbTableNameT2Avg="tbl_f1_t2_avg";
        marksEntry.dbTableNameT3Avg="tbl_f1_t3_avg";
        marksEntry.dbClassName="FORM_1";
        marksEntry.schName="WAVES ACADEMY LTD";
        marksEntry.clsName="Form 1";
        marksEntry.dbSubjectTable="tbl_f1_kis";
        marksEntry.subName="KISWAHILI";
        marksEntry.sbj="kis";
        marksEntry.sbjg="kisg";
        marksEntry.pn="p2";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/exams/marksEntry.fxml"));
Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
        stage.getIcons().add(applicationIcon);

            MarksEntry marksEntry1 = (MarksEntry) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 1 KISWAHILI[Marks Entry]");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void openF1T1EntryMat(){
        MarksEntry marksEntry = new MarksEntry();
        marksEntry.dbTableNameT1E1="tbl_f1_t1_ex1";
        marksEntry.dbTableNameT1E2="tbl_f1_t1_ex2";
        marksEntry.dbTableNameT1E3="tbl_f1_t1_ex3";
        marksEntry.dbTableNameT2E1="tbl_f1_t2_ex1";
        marksEntry.dbTableNameT2E2="tbl_f1_t2_ex2";
        marksEntry.dbTableNameT2E3="tbl_f1_t2_ex3";
        marksEntry.dbTableNameT3E1="tbl_f1_t3_ex1";
        marksEntry.dbTableNameT3E2="tbl_f1_t3_ex2";
        marksEntry.dbTableNameT3E3="tbl_f1_t3_ex3";
        marksEntry.dbTableNameT1Avg="tbl_f1_t1_avg";
        marksEntry.dbTableNameT2Avg="tbl_f1_t2_avg";
        marksEntry.dbTableNameT3Avg="tbl_f1_t3_avg";
        marksEntry.dbClassName="FORM_1";
        marksEntry.schName="WAVES ACADEMY LTD";
        marksEntry.clsName="Form 1";
        marksEntry.dbSubjectTable="tbl_f1_mat";
        marksEntry.subName="MATHEMATICS";
        marksEntry.sbj="mat";
        marksEntry.sbjg="matg";
        marksEntry.pn="p3";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/exams/marksEntry.fxml"));
Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
        stage.getIcons().add(applicationIcon);

            MarksEntry marksEntry1 = (MarksEntry) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 1 MATHEMATICS[Marks Entry]");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void openF1T1EntryPhy(){
        MarksEntry marksEntry = new MarksEntry();
        marksEntry.dbTableNameT1E1="tbl_f1_t1_ex1";
        marksEntry.dbTableNameT1E2="tbl_f1_t1_ex2";
        marksEntry.dbTableNameT1E3="tbl_f1_t1_ex3";
        marksEntry.dbTableNameT2E1="tbl_f1_t2_ex1";
        marksEntry.dbTableNameT2E2="tbl_f1_t2_ex2";
        marksEntry.dbTableNameT2E3="tbl_f1_t2_ex3";
        marksEntry.dbTableNameT3E1="tbl_f1_t3_ex1";
        marksEntry.dbTableNameT3E2="tbl_f1_t3_ex2";
        marksEntry.dbTableNameT3E3="tbl_f1_t3_ex3";
        marksEntry.dbTableNameT1Avg="tbl_f1_t1_avg";
        marksEntry.dbTableNameT2Avg="tbl_f1_t2_avg";
        marksEntry.dbTableNameT3Avg="tbl_f1_t3_avg";
        marksEntry.dbClassName="FORM_1";
        marksEntry.schName="WAVES ACADEMY LTD";
        marksEntry.clsName="Form 1";
        marksEntry.dbSubjectTable="tbl_f1_phy";
        marksEntry.subName="PHYSICS";
        marksEntry.sbj="phy";
        marksEntry.sbjg="phyg";
        marksEntry.pn="p6";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/exams/marksEntry.fxml"));
Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
        stage.getIcons().add(applicationIcon);

            MarksEntry marksEntry1 = (MarksEntry) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 1 PHYSICS[Marks Entry]");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void synchronize(){
        DatabaseSync databaseSync = new DatabaseSync();
        databaseSync.updateStudent();
        //databaseSync.addStudent(null,null);
    }

    public void openGrading(){
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            //Pane root = (Pane)loader.load(getClass().getResource("../../grade/grade.fxml"));
            Pane root = (Pane)loader.load(getClass().getResource("/grade/grade.fxml"));
            Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
            stage.getIcons().add(applicationIcon);
            Grade grade = (Grade) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("GRADING and REMARKS");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void Backup(){
        try{
            ManualBackup manualBackup = new ManualBackup();
            manualBackup.Backup();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void closeSystem(){
        System.exit(0);
    }

    public void openAbout(){
        try {
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/about/about.fxml"));

            About about = (About) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("ABOUT");
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setResizable(false);
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void adminMode(){
        try {
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("password.fxml"));
            Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
            stage.getIcons().add(applicationIcon);
            Password password = (Password) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Admin Password");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(false);
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }





}
