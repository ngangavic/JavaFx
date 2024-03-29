package F4.ClassLists.T1;

import F4.ClassLists.T1.Printpass;
import F4.ClassLists.T1.resultsData;
import F4.ReportForms.T1.*;
import com.itextpdf.awt.DefaultFontMapper;
import com.itextpdf.text.*;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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

public class ClasslistT1E3 implements Initializable{
    String cname = System.getProperty("user.home");
    Calendar now = Calendar.getInstance();
    @FXML
    private TableView<resultsData> tableAllResults;
    @FXML private TableColumn<resultsData,String> positionColumn,admColumn,nameColumn,totalColumn,avgColumn,gradeColumn,kcpeColumn;
    @FXML private TableColumn<resultsData,String>engColumn,kisColumn, matColumn,bioColumn,chemColumn,phyColumn,geoColumn,hisColumn,creColumn,busColumn,agriColumn;
    @FXML private TableColumn<resultsData,String>engGrade,kisGrade,matGrade,bioGrade,chemGrade,phyGrade,geoGrade,hisGrade,creGrade,busGrade,agriGrade;
    private ObservableList<resultsData> tableList;
    public static String printPassword;

    public void showData(){
        String sql="SELECT * FROM tbl_f4_t1_ex3 WHERE class = 'FORM_1' ORDER BY pt DESC ";

        ResultSet resultSet = null;
        try {
            Connection connection = Database.DBConnection.getConnection();
            this.tableList = FXCollections.observableArrayList();

            resultSet = connection.createStatement().executeQuery(sql);
            int count = 0;
            while (resultSet.next()){
                this.tableList.addAll(new resultsData(resultSet.getString(2),resultSet.getString(3)+" "+resultSet.getString(4)+" "+resultSet.getString(5),resultSet.getString(8),resultSet.getString(9),resultSet.getString(11),resultSet.getString(12),resultSet.getString(14),resultSet.getString(15),resultSet.getString(17),resultSet.getString(18),resultSet.getString(20),resultSet.getString(21),resultSet.getString(23),resultSet.getString(24),resultSet.getString(26),resultSet.getString(27),resultSet.getString(29),resultSet.getString(30),resultSet.getString(32),resultSet.getString(33),resultSet.getString(35),resultSet.getString(36),resultSet.getString(38),resultSet.getString(39),resultSet.getString(41),resultSet.getString(43),resultSet.getString(42),resultSet.getString(6)));
            }
            // this.positionColumn.setCellValueFactory(new PropertyValueFactory<resultsData,String>(String.valueOf(count)));
            this.admColumn.setCellValueFactory(new PropertyValueFactory<resultsData,String>("adm"));
            this.nameColumn.setCellValueFactory(new PropertyValueFactory<resultsData,String>("name"));
            this.engColumn.setCellValueFactory(new PropertyValueFactory<resultsData,String>("eng"));
            this.engGrade.setCellValueFactory(new PropertyValueFactory<resultsData,String>("engg"));
            this.kisColumn.setCellValueFactory(new PropertyValueFactory<resultsData,String>("kis"));
            this.kisGrade.setCellValueFactory(new PropertyValueFactory<resultsData,String>("kisg"));
            this.matColumn.setCellValueFactory(new PropertyValueFactory<resultsData,String>("mat"));
            this.matGrade.setCellValueFactory(new PropertyValueFactory<resultsData,String>("matg"));
            this.bioColumn.setCellValueFactory(new PropertyValueFactory<resultsData,String>("bio"));
            this.bioGrade.setCellValueFactory(new PropertyValueFactory<resultsData,String>("biog"));
            this.chemColumn.setCellValueFactory(new PropertyValueFactory<resultsData,String>("chem"));
            this.chemGrade.setCellValueFactory(new PropertyValueFactory<resultsData,String>("chemg"));
            this.phyColumn.setCellValueFactory(new PropertyValueFactory<resultsData,String>("phy"));
            this.phyGrade.setCellValueFactory(new PropertyValueFactory<resultsData,String>("phyg"));
            this.geoColumn.setCellValueFactory(new PropertyValueFactory<resultsData,String>("geo"));
            this.geoGrade.setCellValueFactory(new PropertyValueFactory<resultsData,String>("geog"));
            this.hisColumn.setCellValueFactory(new PropertyValueFactory<resultsData,String>("his"));
            this.hisGrade.setCellValueFactory(new PropertyValueFactory<resultsData,String>("hisg"));
            this.creColumn.setCellValueFactory(new PropertyValueFactory<resultsData,String>("cre"));
            this.creGrade.setCellValueFactory(new PropertyValueFactory<resultsData,String>("creg"));
            this.busColumn.setCellValueFactory(new PropertyValueFactory<resultsData,String>("bus"));
            this.busGrade.setCellValueFactory(new PropertyValueFactory<resultsData,String>("busg"));
            this.agriColumn.setCellValueFactory(new PropertyValueFactory<resultsData,String>("agri"));
            this.agriGrade.setCellValueFactory(new PropertyValueFactory<resultsData,String>("agrig"));
            this.totalColumn.setCellValueFactory(new PropertyValueFactory<resultsData,String>("total"));
            // this.totalColumn.setSortType(TableColumn.SortType.DESCENDING);
            this.avgColumn.setCellValueFactory(new PropertyValueFactory<resultsData,String>("avg"));
            this.gradeColumn.setCellValueFactory(new PropertyValueFactory<resultsData,String>("grade"));
            this.kcpeColumn.setCellValueFactory(new PropertyValueFactory<resultsData,String>("kcpe"));

            this.tableAllResults.setItems(null);
            this.tableAllResults.setItems(this.tableList);
            connection.close();


        }catch (Exception e){
            infoBoxError("An error occurred " + e,"Error",null);
            e.printStackTrace();
        }

    }

    public void onStudentClick(){
        // String bio="",phy="",chem="";
        int bio1=0,phy1=0,chem1=0;
        resultsData selectedItem = tableAllResults.getSelectionModel().getSelectedItem();
        AllSubjects.ADM=selectedItem.getAdm();
        AllSubjects.POS=tableAllResults.getSelectionModel().getSelectedIndex();
        AllSubjects.ALL=tableAllResults.getItems().size();
        BioCreAgri.ADM=selectedItem.getAdm();
        BioCreAgri.POS=tableAllResults.getSelectionModel().getSelectedIndex();
        BioCreAgri.ALL=tableAllResults.getItems().size();
        BioCreBus.ADM=selectedItem.getAdm();
        BioCreBus.POS=tableAllResults.getSelectionModel().getSelectedIndex();
        BioCreBus.ALL=tableAllResults.getItems().size();
        BioGeoAgri.ADM=selectedItem.getAdm();
        BioGeoAgri.POS=tableAllResults.getSelectionModel().getSelectedIndex();
        BioGeoAgri.ALL=tableAllResults.getItems().size();
        BioGeoBus.ADM=selectedItem.getAdm();
        BioGeoBus.POS=tableAllResults.getSelectionModel().getSelectedIndex();
        BioGeoBus.ALL=tableAllResults.getItems().size();
        BioHisAgri.ADM=selectedItem.getAdm();
        BioHisAgri.POS=tableAllResults.getSelectionModel().getSelectedIndex();
        BioHisAgri.ALL=tableAllResults.getItems().size();
        BioHisBus.ADM=selectedItem.getAdm();
        BioHisBus.POS=tableAllResults.getSelectionModel().getSelectedIndex();
        BioHisBus.ALL=tableAllResults.getItems().size();
        PhyCreAgri.ADM=selectedItem.getAdm();
        PhyCreAgri.POS=tableAllResults.getSelectionModel().getSelectedIndex();
        PhyCreAgri.ALL=tableAllResults.getItems().size();
        PhyCreBus.ADM=selectedItem.getAdm();
        PhyCreBus.POS=tableAllResults.getSelectionModel().getSelectedIndex();
        PhyCreBus.ALL=tableAllResults.getItems().size();
        PhyGeoAgri.ADM=selectedItem.getAdm();
        PhyGeoAgri.POS=tableAllResults.getSelectionModel().getSelectedIndex();
        PhyGeoAgri.ALL=tableAllResults.getItems().size();
        PhyCreBus.ADM=selectedItem.getAdm();
        PhyCreBus.POS=tableAllResults.getSelectionModel().getSelectedIndex();
        PhyCreBus.ALL=tableAllResults.getItems().size();
        PhyHisAgri.ADM=selectedItem.getAdm();
        PhyHisAgri.POS=tableAllResults.getSelectionModel().getSelectedIndex();
        PhyHisAgri.ALL=tableAllResults.getItems().size();
        PhyHisBus.ADM=selectedItem.getAdm();
        PhyHisBus.POS=tableAllResults.getSelectionModel().getSelectedIndex();
        PhyHisBus.ALL=tableAllResults.getItems().size();
        String name = selectedItem.getName();

        String sql = "SELECT * FROM tbl_subject_selection WHERE adm=?";
        ResultSet set = null;

        try{
            Connection connection = Database.DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1,selectedItem.getAdm().toString());

            set = statement.executeQuery();
            String bio=set.getString(11);
            String phy=set.getString(13);
            String geo=set.getString(14);
            String his=set.getString(15);
            String cre=set.getString(16);
            String bus=set.getString(17);
            String agri=set.getString(18);

            if (Integer.parseInt(bio)==1&&Integer.parseInt(phy)==1&&Integer.parseInt(geo)==1&&Integer.parseInt(his)==1&&Integer.parseInt(cre)==1&&Integer.parseInt(bus)==1&&Integer.parseInt(agri)==1){
                openAllSubjects(name);
            }else {

                if(Integer.parseInt(bio)==0){
                    //you are doing physics
                    if (Integer.parseInt(geo)==1){
                        if (Integer.parseInt(bus) == 1) {
                            infoBox("You are doing physics,geography,business","Subject",null);
                            openPhyGeoBus(name);
                        }else{
                            infoBox("You are doing physics,geography,agriculture","Subject",null);
                            openPhyGeoAgri(name);
                        }
                    }else if (Integer.parseInt(his)==1){
                        if (Integer.parseInt(bus) == 1) {
                            infoBox("You are doing physics,history,business","Subject",null);
                            openPhyHisBus(name);
                        }else{
                            infoBox("You are doing physics,history,agriculture","Subject",null);
                            openPhyHisAgri(name);
                        }
                    }else {
                        if (Integer.parseInt(bus) == 1) {
                            infoBox("You are physics,cre,doing business","Subject",null);
                            openPhyCreBus(name);
                        }else{
                            infoBox("You are doing physics,cre,agriculture","Subject",null);
                            openPhyCreAgri(name);
                        }
                    }

                }else{
                    //you are doing biology
                    if (Integer.parseInt(geo)==1){
                        if (Integer.parseInt(bus) == 1) {
                            infoBox("You are doing biology,geography,business","Subject",null);
                            openBioGeoBus(name);
                        }else{
                            infoBox("You are doing biology,geography,agriculture","Subject",null);
                            openBioGeoAgri(name);
                        }
                    }else if (Integer.parseInt(his)==1){
                        if (Integer.parseInt(bus) == 1) {
                            infoBox("You are doing biology,history,business","Subject",null);
                            openBioHisBus(name);
                        }else{
                            infoBox("You are doing biology,history,agriculture","Subject",null);
                            openBioHisAgri(name);
                        }
                    }else {
                        if (Integer.parseInt(bus) == 1) {
                            infoBox("You are biology,cre,doing business","Subject",null);
                            openBioCreBus(name);
                        }else{
                            infoBox("You are doing biology,cre,agriculture","Subject",null);
                            openBioCreAgri(name);
                        }
                    }}
            }
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
            infoBoxError("An error occurred " + e,"Error",null);
        }
    }

    private void openAllSubjects(String name) {
        try{
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F4/ReportForms/T1/allSubjects.fxml"));

            AllSubjects allSubjects = (AllSubjects) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Report form for " + name);
            stage.setResizable(false);
            stage.show();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    private void openPhyHisBus(String name) {
        try{
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F4/ReportForms/T1/PhyHisBus.fxml"));

            PhyHisBus phyHisBus = (PhyHisBus) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Report form for " + name);
            stage.setResizable(false);
            stage.show();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    private void openPhyHisAgri(String name) {
        try{
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F4/ReportForms/T1/PhyHisAgri.fxml"));

            PhyHisAgri phyHisAgri = (PhyHisAgri) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Report form for " + name);
            stage.setResizable(false);
            stage.show();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    private void openPhyGeoBus(String name) {
        try{
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F4/ReportForms/T1/PhyGeoBus.fxml"));

            PhyGeoBus phyGeoBus = (PhyGeoBus) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Report form for " + name);
            stage.setResizable(false);
            stage.show();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    private void openPhyGeoAgri(String name) {
        try{
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F4/ReportForms/T1/PhyGeoAgri.fxml"));

            PhyGeoAgri phyGeoAgri = (PhyGeoAgri) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Report form for " + name);
            stage.setResizable(false);
            stage.show();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    private void openPhyCreBus(String name) {
        try{
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F4/ReportForms/T1/PhyCreBus.fxml"));

            PhyCreBus phyCreBus = (PhyCreBus) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Report form for " + name);
            stage.setResizable(false);
            stage.show();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    private void openPhyCreAgri(String name) {
        try{
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F4/ReportForms/T1/PhyCreAgri.fxml"));

            PhyCreAgri phyCreAgri = (PhyCreAgri) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Report form for " + name);
            stage.setResizable(false);
            stage.show();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    private void openBioHisBus(String name) {
        try{
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F4/ReportForms/T1/BioHisBus.fxml"));

            BioHisBus bioHisBus = (BioHisBus) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Report form for " + name);
            stage.setResizable(false);
            stage.show();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    private void openBioHisAgri(String name) {
        try{
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F4/ReportForms/T1/BioHisAgri.fxml"));

            BioHisAgri bioHisAgri = (BioHisAgri) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Report form for " + name);
            stage.setResizable(false);
            stage.show();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    private void openBioGeoBus(String name) {
        try{
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F4/ReportForms/T1/BioGeoBus.fxml"));

            BioGeoBus bioGeoBus = (BioGeoBus) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Report form for " + name);
            stage.setResizable(false);
            stage.show();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    private void openBioGeoAgri(String name) {
        try{
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F4/ReportForms/T1/BioGeoAgri.fxml"));

            BioGeoAgri bioGeoAgri = (BioGeoAgri) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Report form for " + name);
            stage.setResizable(false);
            stage.show();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    private void openBioCreBus(String name) {
        try{
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F4/ReportForms/T1/BioCreBus.fxml"));

            BioCreBus bioCreBus = (BioCreBus) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Report form for " + name);
            stage.setResizable(false);
            stage.show();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    private void openBioCreAgri(String name){
        try{
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F4/ReportForms/T1/BioCreAgri.fxml"));

            BioCreAgri bioCreAgri = (BioCreAgri) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Report form for " + name);
            stage.setResizable(false);
            stage.show();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    private void calcTotal(){
        String sqlDet = "SELECT * FROM tbl_f4_t1_ex3 WHERE class='FORM_1'";
        String sqlUpdate = "UPDATE tbl_f4_t1_ex3 SET total=? WHERE adm=?";
        String sqlUpdate2 = "UPDATE tbl_f4_t1_ex3 SET grade=?,pt=? WHERE adm=?";
        String sqlGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='TOTAL'";
        String sqlSelection = "SELECT * FROM tbl_subject_selection WHERE adm=? ";
        try{
            Connection connection = Database.DBConnection.getConnection();
            ResultSet set = connection.createStatement().executeQuery(sqlDet);
            ResultSet setGrade = connection.createStatement().executeQuery(sqlGrade);
            PreparedStatement statement2 = connection.prepareStatement(sqlUpdate2);
            PreparedStatement statement = connection.prepareStatement(sqlUpdate);

            while (set.next()){

                String adm = set.getString(2);
                ResultSet subSelSet = null;
                PreparedStatement statementSel = connection.prepareStatement(sqlSelection);
                statementSel.setString(1,adm);
                subSelSet = statementSel.executeQuery();
                String bio=subSelSet.getString(11);
                String phy=subSelSet.getString(13);
                String geo=subSelSet.getString(14);
                String his=subSelSet.getString(15);
                String cre=subSelSet.getString(16);
                String bus=subSelSet.getString(17);
                String agri=subSelSet.getString(18);

              /*  float addTotal = Float.parseFloat(set.getString(8))+Float.parseFloat(set.getString(10))+Float.parseFloat(set.getString(12))+Float.parseFloat(set.getString(14))+Float.parseFloat(set.getString(16))+Float.parseFloat(set.getString(18))+Float.parseFloat(set.getString(20))+Float.parseFloat(set.getString(22))+Float.parseFloat(set.getString(24))+Float.parseFloat(set.getString(26))+Float.parseFloat(set.getString(28));
                float avg = addTotal/11;

                PreparedStatement statement = connection.prepareStatement(sqlUpdate);
                statement.setString(1,String.valueOf(addTotal));
                statement.setString(2,set.getString(2));
                String g = "";
                if (avg >= Integer.parseInt(setGrade.getString(4))) {g = "A"; } else if (avg >= Integer.parseInt(setGrade.getString(5))) { g = "A-"; }else if (avg >=Integer.parseInt(setGrade.getString(6))){ g = "B+";}else if (avg >=Integer.parseInt(setGrade.getString(7))){
                    g = "B"; }else if (avg >=Integer.parseInt(setGrade.getString(8))){  g = "B-"; }else if (avg >=Integer.parseInt(setGrade.getString(9))){ g = "C+"; }else if (avg >=Integer.parseInt(setGrade.getString(10))){ g = "C";
                }else if (avg >=Integer.parseInt(setGrade.getString(11))){ g = "C-";}else if (avg >=Integer.parseInt(setGrade.getString(12))){ g = "D+";}else if (avg >=Integer.parseInt(setGrade.getString(13))){ g = "D";}else if (avg >=Integer.parseInt(setGrade.getString(14))){
                    g = "D-";}else {g="E"; }

                statement2.setString(1,g.toUpperCase());
                statement2.setString(2,set.getString(2));
                statement2.execute();

                 statement.execute();*/


                if (Integer.parseInt(bio)==1&&Integer.parseInt(phy)==1&&Integer.parseInt(geo)==1&&Integer.parseInt(his)==1&&Integer.parseInt(cre)==1&&Integer.parseInt(bus)==1&&Integer.parseInt(agri)==1){
                    addAllSubjects(adm,set,setGrade,connection,sqlUpdate,sqlUpdate2,statement,statement2);
                }else {

                    if(Integer.parseInt(bio)==0){
                        //you are doing physics
                        if (Integer.parseInt(geo)==1){
                            if (Integer.parseInt(bus) == 1) {
                                addPhyGeoBus(adm,set,setGrade,connection,sqlUpdate,sqlUpdate2,statement,statement2);
                            }else{
                                addPhyGeoAgri(adm,set,setGrade,connection,sqlUpdate,sqlUpdate2,statement,statement2);
                            }
                        }else if (Integer.parseInt(his)==1){
                            if (Integer.parseInt(bus) == 1) {
                                addPhyHisBus(adm,set,setGrade,connection,sqlUpdate,sqlUpdate2,statement,statement2);
                            }else{
                                addPhyHisAgri(adm,set,setGrade,connection,sqlUpdate,sqlUpdate2,statement,statement2);
                            }
                        }else {
                            if (Integer.parseInt(bus) == 1) {
                                addPhyCreBus(adm,set,setGrade,connection,sqlUpdate,sqlUpdate2,statement,statement2);
                            }else{
                                addPhyCreAgri(adm,set,setGrade,connection,sqlUpdate,sqlUpdate2,statement,statement2);
                            }
                        }

                    }else{
                        //you are doing biology
                        if (Integer.parseInt(geo)==1){
                            if (Integer.parseInt(bus) == 1) {
                                addBioGeoBus(adm,set,setGrade,connection,sqlUpdate,sqlUpdate2,statement,statement2);
                            }else{
                                addBioGeoAgri(adm,set,setGrade,connection,sqlUpdate,sqlUpdate2,statement,statement2);
                            }
                        }else if (Integer.parseInt(his)==1){
                            if (Integer.parseInt(bus) == 1) {
                                addBioHisBus(adm,set,setGrade,connection,sqlUpdate,sqlUpdate2,statement,statement2);
                            }else{
                                addBioHisAgri(adm,set,setGrade,connection,sqlUpdate,sqlUpdate2,statement,statement2);
                            }
                        }else {
                            if (Integer.parseInt(bus) == 1) {
                                addBioCreBus(adm,set,setGrade,connection,sqlUpdate,sqlUpdate2,statement,statement2);
                            }else{
                                addBioCreAgri(adm,set,setGrade,connection,sqlUpdate,sqlUpdate2,statement,statement2);
                            }
                        }}
                }

            }
connection.close();
        }catch (Exception e){
            e.printStackTrace();
            infoBoxError("An error occurred " + e,"Error",null);
        }
    }

    private void addBioCreBus(String adm, ResultSet set, ResultSet setGrade, Connection connection, String sqlUpdate, String sqlUpdate2, PreparedStatement statement, PreparedStatement statement2) {
        try {
            float addTotal = Float.parseFloat(set.getString(8)) + Float.parseFloat(set.getString(11)) + Float.parseFloat(set.getString(14)) + Float.parseFloat(set.getString(20)) + Float.parseFloat(set.getString(17)) + Float.parseFloat(set.getString(32))+ Float.parseFloat(set.getString(35));
            float addPoints = Float.parseFloat(set.getString(10)) + Float.parseFloat(set.getString(13)) + Float.parseFloat(set.getString(16)) + Float.parseFloat(set.getString(22)) + Float.parseFloat(set.getString(19)) + Float.parseFloat(set.getString(34))+ Float.parseFloat(set.getString(37));

            float avg = addTotal / 7;
            String avgP = String.format("%.1f",(addPoints/7));
            statement2 = connection.prepareStatement(sqlUpdate2);
            statement = connection.prepareStatement(sqlUpdate);
            statement.setString(1, String.valueOf(addTotal));
            statement.setString(2, set.getString(2));
            String g,p = "";
            if (Float.parseFloat(avgP)>=11.5) { g = "A";p="12"; } else if (Float.parseFloat(avgP)>=10.5) {
                g = "A-";p="11"; } else if (Float.parseFloat(avgP)>=9.5) { g = "B+";p="10"; } else if (Float.parseFloat(avgP)>=8.5) {
                g = "B";p="9"; } else if (Float.parseFloat(avgP)>=7.5) {
                g = "B-";p="8"; } else if (Float.parseFloat(avgP)>=6.5) {
                g = "C+";p="7"; } else if (Float.parseFloat(avgP)>=5.5) {
                g = "C";p="6"; } else if (Float.parseFloat(avgP)>=4.5) {
                g = "C-";p="5"; } else if (Float.parseFloat(avgP)>=3.5) {
                g = "D+";p="4"; } else if (Float.parseFloat(avgP)>=2.5) {
                g = "D";p="3"; } else if (Float.parseFloat(avgP)>=1.5) {
                g = "D-";p="2"; } else { g = "E";p="1"; }

            statement2.setString(1, g.toUpperCase());
            statement2.setString(2,avgP);
            statement2.setString(3, adm.toString());
            statement2.execute();
             statement.execute();
        }catch (Exception e){
            e.printStackTrace();
            infoBoxError("An error occurred in add phy geo bus " + e,"Error",null);
        }
    }

    private void addBioCreAgri(String adm, ResultSet set, ResultSet setGrade, Connection connection, String sqlUpdate, String sqlUpdate2, PreparedStatement statement, PreparedStatement statement2) {
        try {
            float addTotal = Float.parseFloat(set.getString(8)) + Float.parseFloat(set.getString(11)) + Float.parseFloat(set.getString(14)) + Float.parseFloat(set.getString(20)) + Float.parseFloat(set.getString(17)) + Float.parseFloat(set.getString(32))+ Float.parseFloat(set.getString(38));
            float addPoints = Float.parseFloat(set.getString(10)) + Float.parseFloat(set.getString(13)) + Float.parseFloat(set.getString(16)) + Float.parseFloat(set.getString(22)) + Float.parseFloat(set.getString(19)) + Float.parseFloat(set.getString(34))+ Float.parseFloat(set.getString(40));

            float avg = addTotal / 7;
            String avgP = String.format("%.1f",(addPoints/7));
            statement2 = connection.prepareStatement(sqlUpdate2);
            statement = connection.prepareStatement(sqlUpdate);
            statement.setString(1, String.valueOf(addTotal));
            statement.setString(2, set.getString(2));
            String g,p = "";
            if (Float.parseFloat(avgP)>=11.5) { g = "A";p="12"; } else if (Float.parseFloat(avgP)>=10.5) {
                g = "A-";p="11"; } else if (Float.parseFloat(avgP)>=9.5) { g = "B+";p="10"; } else if (Float.parseFloat(avgP)>=8.5) {
                g = "B";p="9"; } else if (Float.parseFloat(avgP)>=7.5) {
                g = "B-";p="8"; } else if (Float.parseFloat(avgP)>=6.5) {
                g = "C+";p="7"; } else if (Float.parseFloat(avgP)>=5.5) {
                g = "C";p="6"; } else if (Float.parseFloat(avgP)>=4.5) {
                g = "C-";p="5"; } else if (Float.parseFloat(avgP)>=3.5) {
                g = "D+";p="4"; } else if (Float.parseFloat(avgP)>=2.5) {
                g = "D";p="3"; } else if (Float.parseFloat(avgP)>=1.5) {
                g = "D-";p="2"; } else { g = "E";p="1"; }

            statement2.setString(1, g.toUpperCase());
            statement2.setString(2,avgP);
            statement2.setString(3, adm.toString());
            statement2.execute();
             statement.execute();
        }catch (Exception e){
            e.printStackTrace();
            infoBoxError("An error occurred in add bio cre agri " + e,"Error",null);
        }
    }

    private void addBioHisAgri(String adm, ResultSet set, ResultSet setGrade, Connection connection, String sqlUpdate, String sqlUpdate2, PreparedStatement statement, PreparedStatement statement2) {
        try {
            float addTotal = Float.parseFloat(set.getString(8)) + Float.parseFloat(set.getString(11)) + Float.parseFloat(set.getString(14)) + Float.parseFloat(set.getString(20)) + Float.parseFloat(set.getString(17)) + Float.parseFloat(set.getString(29))+ Float.parseFloat(set.getString(38));
            float addPoints = Float.parseFloat(set.getString(10)) + Float.parseFloat(set.getString(13)) + Float.parseFloat(set.getString(16)) + Float.parseFloat(set.getString(22)) + Float.parseFloat(set.getString(19)) + Float.parseFloat(set.getString(31))+ Float.parseFloat(set.getString(40));

            float avg = addTotal / 7;
            String avgP = String.format("%.1f",(addPoints/7));
            statement2 = connection.prepareStatement(sqlUpdate2);
            statement = connection.prepareStatement(sqlUpdate);
            statement.setString(1, String.valueOf(addTotal));
            statement.setString(2, set.getString(2));
            String g,p = "";
            if (Float.parseFloat(avgP)>=11.5) { g = "A";p="12"; } else if (Float.parseFloat(avgP)>=10.5) {
                g = "A-";p="11"; } else if (Float.parseFloat(avgP)>=9.5) { g = "B+";p="10"; } else if (Float.parseFloat(avgP)>=8.5) {
                g = "B";p="9"; } else if (Float.parseFloat(avgP)>=7.5) {
                g = "B-";p="8"; } else if (Float.parseFloat(avgP)>=6.5) {
                g = "C+";p="7"; } else if (Float.parseFloat(avgP)>=5.5) {
                g = "C";p="6"; } else if (Float.parseFloat(avgP)>=4.5) {
                g = "C-";p="5"; } else if (Float.parseFloat(avgP)>=3.5) {
                g = "D+";p="4"; } else if (Float.parseFloat(avgP)>=2.5) {
                g = "D";p="3"; } else if (Float.parseFloat(avgP)>=1.5) {
                g = "D-";p="2"; } else { g = "E";p="1"; }

            statement2.setString(1, g.toUpperCase());
            statement2.setString(2,avgP);
            statement2.setString(3, adm.toString());
            statement2.execute();
             statement.execute();
        }catch (Exception e){
            e.printStackTrace();
            infoBoxError("An error occurred in add phy geo bus " + e,"Error",null);
        }
    }

    private void addBioHisBus(String adm, ResultSet set, ResultSet setGrade, Connection connection, String sqlUpdate, String sqlUpdate2, PreparedStatement statement, PreparedStatement statement2) {
        try {
            float addTotal = Float.parseFloat(set.getString(8)) + Float.parseFloat(set.getString(11)) + Float.parseFloat(set.getString(14)) + Float.parseFloat(set.getString(20)) + Float.parseFloat(set.getString(17)) + Float.parseFloat(set.getString(29))+ Float.parseFloat(set.getString(35));
            float addPoints = Float.parseFloat(set.getString(10)) + Float.parseFloat(set.getString(13)) + Float.parseFloat(set.getString(16)) + Float.parseFloat(set.getString(22)) + Float.parseFloat(set.getString(19)) + Float.parseFloat(set.getString(31))+ Float.parseFloat(set.getString(37));

            float avg = addTotal / 7;
            String avgP = String.format("%.1f",(addPoints/7));
            statement2 = connection.prepareStatement(sqlUpdate2);
            statement = connection.prepareStatement(sqlUpdate);
            statement.setString(1, String.valueOf(addTotal));
            statement.setString(2, set.getString(2));
            String g,p = "";
            if (Float.parseFloat(avgP)>=11.5) { g = "A";p="12"; } else if (Float.parseFloat(avgP)>=10.5) {
                g = "A-";p="11"; } else if (Float.parseFloat(avgP)>=9.5) { g = "B+";p="10"; } else if (Float.parseFloat(avgP)>=8.5) {
                g = "B";p="9"; } else if (Float.parseFloat(avgP)>=7.5) {
                g = "B-";p="8"; } else if (Float.parseFloat(avgP)>=6.5) {
                g = "C+";p="7"; } else if (Float.parseFloat(avgP)>=5.5) {
                g = "C";p="6"; } else if (Float.parseFloat(avgP)>=4.5) {
                g = "C-";p="5"; } else if (Float.parseFloat(avgP)>=3.5) {
                g = "D+";p="4"; } else if (Float.parseFloat(avgP)>=2.5) {
                g = "D";p="3"; } else if (Float.parseFloat(avgP)>=1.5) {
                g = "D-";p="2"; } else { g = "E";p="1"; }

            statement2.setString(1, g.toUpperCase());
            statement2.setString(2,avgP);
            statement2.setString(3, adm.toString());
            statement2.execute();
             statement.execute();
        }catch (Exception e){
            e.printStackTrace();
            infoBoxError("An error occurred in add phy geo bus " + e,"Error",null);
        }
    }

    private void addBioGeoAgri(String adm, ResultSet set, ResultSet setGrade, Connection connection, String sqlUpdate, String sqlUpdate2, PreparedStatement statement, PreparedStatement statement2) {
        try {
            float addTotal = Float.parseFloat(set.getString(8)) + Float.parseFloat(set.getString(11)) + Float.parseFloat(set.getString(14)) + Float.parseFloat(set.getString(20)) + Float.parseFloat(set.getString(17)) + Float.parseFloat(set.getString(26))+ Float.parseFloat(set.getString(38));
            float addPoints = Float.parseFloat(set.getString(10)) + Float.parseFloat(set.getString(13)) + Float.parseFloat(set.getString(16)) + Float.parseFloat(set.getString(22)) + Float.parseFloat(set.getString(19)) + Float.parseFloat(set.getString(28))+ Float.parseFloat(set.getString(40));

            float avg = addTotal / 7;
            String avgP = String.format("%.1f",(addPoints/7));
            statement2 = connection.prepareStatement(sqlUpdate2);
            statement = connection.prepareStatement(sqlUpdate);
            statement.setString(1, String.valueOf(addTotal));
            statement.setString(2, set.getString(2));
            String g,p = "";
            if (Float.parseFloat(avgP)>=11.5) { g = "A";p="12"; } else if (Float.parseFloat(avgP)>=10.5) {
                g = "A-";p="11"; } else if (Float.parseFloat(avgP)>=9.5) { g = "B+";p="10"; } else if (Float.parseFloat(avgP)>=8.5) {
                g = "B";p="9"; } else if (Float.parseFloat(avgP)>=7.5) {
                g = "B-";p="8"; } else if (Float.parseFloat(avgP)>=6.5) {
                g = "C+";p="7"; } else if (Float.parseFloat(avgP)>=5.5) {
                g = "C";p="6"; } else if (Float.parseFloat(avgP)>=4.5) {
                g = "C-";p="5"; } else if (Float.parseFloat(avgP)>=3.5) {
                g = "D+";p="4"; } else if (Float.parseFloat(avgP)>=2.5) {
                g = "D";p="3"; } else if (Float.parseFloat(avgP)>=1.5) {
                g = "D-";p="2"; } else { g = "E";p="1"; }

            statement2.setString(1, g.toUpperCase());
            statement2.setString(2,avgP);
            statement2.setString(3, adm.toString());
            statement2.execute();
             statement.execute();
        }catch (Exception e){
            e.printStackTrace();
            infoBoxError("An error occurred in add phy geo bus " + e,"Error",null);
        }
    }

    private void addBioGeoBus(String adm, ResultSet set, ResultSet setGrade, Connection connection, String sqlUpdate, String sqlUpdate2, PreparedStatement statement, PreparedStatement statement2) {
        try {
            float addTotal = Float.parseFloat(set.getString(8)) + Float.parseFloat(set.getString(11)) + Float.parseFloat(set.getString(14)) + Float.parseFloat(set.getString(20)) + Float.parseFloat(set.getString(17)) + Float.parseFloat(set.getString(26))+ Float.parseFloat(set.getString(35));
            float addPoints = Float.parseFloat(set.getString(10)) + Float.parseFloat(set.getString(13)) + Float.parseFloat(set.getString(16)) + Float.parseFloat(set.getString(22)) + Float.parseFloat(set.getString(19)) + Float.parseFloat(set.getString(28))+ Float.parseFloat(set.getString(37));

            float avg = addTotal / 7;
            String avgP = String.format("%.1f",(addPoints/7));
            statement2 = connection.prepareStatement(sqlUpdate2);
            statement = connection.prepareStatement(sqlUpdate);
            statement.setString(1, String.valueOf(addTotal));
            statement.setString(2, set.getString(2));
            String g,p = "";
            if (Float.parseFloat(avgP)>=11.5) { g = "A";p="12"; } else if (Float.parseFloat(avgP)>=10.5) {
                g = "A-";p="11"; } else if (Float.parseFloat(avgP)>=9.5) { g = "B+";p="10"; } else if (Float.parseFloat(avgP)>=8.5) {
                g = "B";p="9"; } else if (Float.parseFloat(avgP)>=7.5) {
                g = "B-";p="8"; } else if (Float.parseFloat(avgP)>=6.5) {
                g = "C+";p="7"; } else if (Float.parseFloat(avgP)>=5.5) {
                g = "C";p="6"; } else if (Float.parseFloat(avgP)>=4.5) {
                g = "C-";p="5"; } else if (Float.parseFloat(avgP)>=3.5) {
                g = "D+";p="4"; } else if (Float.parseFloat(avgP)>=2.5) {
                g = "D";p="3"; } else if (Float.parseFloat(avgP)>=1.5) {
                g = "D-";p="2"; } else { g = "E";p="1"; }

            statement2.setString(1, g.toUpperCase());
            statement2.setString(2,avgP);
            statement2.setString(3, adm.toString());
            statement2.execute();
             statement.execute();
        }catch (Exception e){
            e.printStackTrace();
            infoBoxError("An error occurred in add phy geo bus " + e,"Error",null);
        }
    }

    private void addPhyCreAgri(String adm, ResultSet set, ResultSet setGrade, Connection connection, String sqlUpdate, String sqlUpdate2, PreparedStatement statement, PreparedStatement statement2) {
        try {
            float addTotal = Float.parseFloat(set.getString(8)) + Float.parseFloat(set.getString(11)) + Float.parseFloat(set.getString(14)) + Float.parseFloat(set.getString(20)) + Float.parseFloat(set.getString(23)) + Float.parseFloat(set.getString(32))+ Float.parseFloat(set.getString(38));
            float addPoints = Float.parseFloat(set.getString(10)) + Float.parseFloat(set.getString(13)) + Float.parseFloat(set.getString(16)) + Float.parseFloat(set.getString(22)) + Float.parseFloat(set.getString(25)) + Float.parseFloat(set.getString(34))+ Float.parseFloat(set.getString(40));

            float avg = addTotal / 7;
            String avgP = String.format("%.1f",(addPoints/7));
            statement2 = connection.prepareStatement(sqlUpdate2);
            statement = connection.prepareStatement(sqlUpdate);
            statement.setString(1, String.valueOf(addTotal));
            statement.setString(2, set.getString(2));
            String g,p = "";
            if (Float.parseFloat(avgP)>=11.5) { g = "A";p="12"; } else if (Float.parseFloat(avgP)>=10.5) {
                g = "A-";p="11"; } else if (Float.parseFloat(avgP)>=9.5) { g = "B+";p="10"; } else if (Float.parseFloat(avgP)>=8.5) {
                g = "B";p="9"; } else if (Float.parseFloat(avgP)>=7.5) {
                g = "B-";p="8"; } else if (Float.parseFloat(avgP)>=6.5) {
                g = "C+";p="7"; } else if (Float.parseFloat(avgP)>=5.5) {
                g = "C";p="6"; } else if (Float.parseFloat(avgP)>=4.5) {
                g = "C-";p="5"; } else if (Float.parseFloat(avgP)>=3.5) {
                g = "D+";p="4"; } else if (Float.parseFloat(avgP)>=2.5) {
                g = "D";p="3"; } else if (Float.parseFloat(avgP)>=1.5) {
                g = "D-";p="2"; } else { g = "E";p="1"; }

            statement2.setString(1, g.toUpperCase());
            statement2.setString(2,avgP);
            statement2.setString(3, adm.toString());
            statement2.execute();
             statement.execute();
        }catch (Exception e){
            e.printStackTrace();
            e.printStackTrace();
            infoBoxError("An error occurred in add phy geo agri " + e,"Error",null);
        }
    }

    private void addPhyCreBus(String adm, ResultSet set, ResultSet setGrade, Connection connection, String sqlUpdate, String sqlUpdate2, PreparedStatement statement, PreparedStatement statement2) {
        try {
            float addTotal = Float.parseFloat(set.getString(8)) + Float.parseFloat(set.getString(11)) + Float.parseFloat(set.getString(14)) + Float.parseFloat(set.getString(20)) + Float.parseFloat(set.getString(23)) + Float.parseFloat(set.getString(32))+ Float.parseFloat(set.getString(35));
            float addPoints = Float.parseFloat(set.getString(10)) + Float.parseFloat(set.getString(13)) + Float.parseFloat(set.getString(16)) + Float.parseFloat(set.getString(22)) + Float.parseFloat(set.getString(25)) + Float.parseFloat(set.getString(34))+ Float.parseFloat(set.getString(37));

            float avg = addTotal / 7;
            String avgP = String.format("%.1f",(addPoints/7));
            statement2 = connection.prepareStatement(sqlUpdate2);
            statement = connection.prepareStatement(sqlUpdate);
            statement.setString(1, String.valueOf(addTotal));
            statement.setString(2, set.getString(2));
            String g,p = "";
            /*if (Float.parseFloat(avgP)>=11.5) { g = "A";p="12"; } else if (Float.parseFloat(avgP)>=10.5) {
                g = "A-";p="11"; } else if (Float.parseFloat(avgP)>=9.5) { g = "B+";p="10"; } else if (Float.parseFloat(avgP)>=8.5) {
                g = "B";p="9"; } else if (Float.parseFloat(avgP)>=7.5) {
                g = "B-";p="8"; } else if (Float.parseFloat(avgP)>=6.5) {
                g = "C+";p="7"; } else if (Float.parseFloat(avgP)>=5.5) {
                g = "C";p="6"; } else if (Float.parseFloat(avgP)>=4.5) {
                g = "C-";p="5"; } else if (Float.parseFloat(avgP)>=3.5) {
                g = "D+";p="4"; } else if (Float.parseFloat(avgP)>=2.5) {
                g = "D";p="3"; } else if (Float.parseFloat(avgP)>=1.5) {
                g = "D-";p="2"; } else { g = "E";p="1"; }*/
            if (Float.parseFloat(avgP)>=11.5) { g = "A";p="12"; } else if (Float.parseFloat(avgP)>=10.5) {
                g = "A-";p="11"; } else if (Float.parseFloat(avgP)>=9.5) { g = "B+";p="10"; } else if (Float.parseFloat(avgP)>=8.5) {
                g = "B";p="9"; } else if (Float.parseFloat(avgP)>=7.5) {
                g = "B-";p="8"; } else if (Float.parseFloat(avgP)>=6.5) {
                g = "C+";p="7"; } else if (Float.parseFloat(avgP)>=5.5) {
                g = "C";p="6"; } else if (Float.parseFloat(avgP)>=4.5) {
                g = "C-";p="5"; } else if (Float.parseFloat(avgP)>=3.5) {
                g = "D+";p="4"; } else if (Float.parseFloat(avgP)>=2.5) {
                g = "D";p="3"; } else if (Float.parseFloat(avgP)>=1.5) {
                g = "D-";p="2"; } else { g = "E";p="1"; }

            statement2.setString(1, g.toUpperCase());
            statement2.setString(2,avgP);
            statement2.setString(3, adm.toString());
            statement2.execute();
             statement.execute();
        }catch (Exception e){
            e.printStackTrace();
            infoBoxError("An error occurred in add phy geo agri " + e,"Error",null);
        }
    }

    private void addPhyHisAgri(String adm, ResultSet set, ResultSet setGrade, Connection connection, String sqlUpdate, String sqlUpdate2, PreparedStatement statement, PreparedStatement statement2) {
        try {
            float addTotal = Float.parseFloat(set.getString(8)) + Float.parseFloat(set.getString(11)) + Float.parseFloat(set.getString(14)) + Float.parseFloat(set.getString(20)) + Float.parseFloat(set.getString(23)) + Float.parseFloat(set.getString(29))+ Float.parseFloat(set.getString(38));
            float addPoints = Float.parseFloat(set.getString(10)) + Float.parseFloat(set.getString(13)) + Float.parseFloat(set.getString(16)) + Float.parseFloat(set.getString(22)) + Float.parseFloat(set.getString(25)) + Float.parseFloat(set.getString(31))+ Float.parseFloat(set.getString(40));

            float avg = addTotal / 7;
            String avgP = String.format("%.1f",(addPoints/7));
            statement2 = connection.prepareStatement(sqlUpdate2);
            statement = connection.prepareStatement(sqlUpdate);
            statement.setString(1, String.valueOf(addTotal));
            statement.setString(2, set.getString(2));
            String g,p = "";
            /*if (Float.parseFloat(avgP)>=11.5) { g = "A";p="12"; } else if (Float.parseFloat(avgP)>=10.5) {
                g = "A-";p="11"; } else if (Float.parseFloat(avgP)>=9.5) { g = "B+";p="10"; } else if (Float.parseFloat(avgP)>=8.5) {
                g = "B";p="9"; } else if (Float.parseFloat(avgP)>=7.5) {
                g = "B-";p="8"; } else if (Float.parseFloat(avgP)>=6.5) {
                g = "C+";p="7"; } else if (Float.parseFloat(avgP)>=5.5) {
                g = "C";p="6"; } else if (Float.parseFloat(avgP)>=4.5) {
                g = "C-";p="5"; } else if (Float.parseFloat(avgP)>=3.5) {
                g = "D+";p="4"; } else if (Float.parseFloat(avgP)>=2.5) {
                g = "D";p="3"; } else if (Float.parseFloat(avgP)>=1.5) {
                g = "D-";p="2"; } else { g = "E";p="1"; }*/

            if (Float.parseFloat(avgP)>=11.5) { g = "A";p="12"; } else if (Float.parseFloat(avgP)>=10.5) {
                g = "A-";p="11"; } else if (Float.parseFloat(avgP)>=9.5) { g = "B+";p="10"; } else if (Float.parseFloat(avgP)>=8.5) {
                g = "B";p="9"; } else if (Float.parseFloat(avgP)>=7.5) {
                g = "B-";p="8"; } else if (Float.parseFloat(avgP)>=6.5) {
                g = "C+";p="7"; } else if (Float.parseFloat(avgP)>=5.5) {
                g = "C";p="6"; } else if (Float.parseFloat(avgP)>=4.5) {
                g = "C-";p="5"; } else if (Float.parseFloat(avgP)>=3.5) {
                g = "D+";p="4"; } else if (Float.parseFloat(avgP)>=2.5) {
                g = "D";p="3"; } else if (Float.parseFloat(avgP)>=1.5) {
                g = "D-";p="2"; } else { g = "E";p="1"; }

            statement2.setString(1, g.toUpperCase());
            statement2.setString(2,avgP);
            statement2.setString(3, adm.toString());
            statement2.execute();
             statement.execute();
        }catch (Exception e){
            e.printStackTrace();
            infoBoxError("An error occurred in add phy geo agri " + e,"Error",null);
        }
    }

    private void addPhyHisBus(String adm, ResultSet set, ResultSet setGrade, Connection connection, String sqlUpdate, String sqlUpdate2, PreparedStatement statement, PreparedStatement statement2) {
        try {
            float addTotal = Float.parseFloat(set.getString(8)) + Float.parseFloat(set.getString(11)) + Float.parseFloat(set.getString(14)) + Float.parseFloat(set.getString(20)) + Float.parseFloat(set.getString(23)) + Float.parseFloat(set.getString(29))+ Float.parseFloat(set.getString(35));
            float addPoints = Float.parseFloat(set.getString(10)) + Float.parseFloat(set.getString(13)) + Float.parseFloat(set.getString(16)) + Float.parseFloat(set.getString(22)) + Float.parseFloat(set.getString(25)) + Float.parseFloat(set.getString(31))+ Float.parseFloat(set.getString(37));

            float avg = addTotal / 7;
            String avgP = String.format("%.1f",(addPoints/7));
            statement2 = connection.prepareStatement(sqlUpdate2);
            statement = connection.prepareStatement(sqlUpdate);
            statement.setString(1, String.valueOf(addTotal));
            statement.setString(2, set.getString(2));
            String g,p = "";
            if (Float.parseFloat(avgP)>=11.5) { g = "A";p="12"; } else if (Float.parseFloat(avgP)>=10.5) {
                g = "A-";p="11"; } else if (Float.parseFloat(avgP)>=9.5) { g = "B+";p="10"; } else if (Float.parseFloat(avgP)>=8.5) {
                g = "B";p="9"; } else if (Float.parseFloat(avgP)>=7.5) {
                g = "B-";p="8"; } else if (Float.parseFloat(avgP)>=6.5) {
                g = "C+";p="7"; } else if (Float.parseFloat(avgP)>=5.5) {
                g = "C";p="6"; } else if (Float.parseFloat(avgP)>=4.5) {
                g = "C-";p="5"; } else if (Float.parseFloat(avgP)>=3.5) {
                g = "D+";p="4"; } else if (Float.parseFloat(avgP)>=2.5) {
                g = "D";p="3"; } else if (Float.parseFloat(avgP)>=1.5) {
                g = "D-";p="2"; } else { g = "E";p="1"; }

            statement2.setString(1, g.toUpperCase());
            statement2.setString(2,avgP);
            statement2.setString(3, adm.toString());
            statement2.execute();
             statement.execute();
        }catch (Exception e){
            e.printStackTrace();
            infoBoxError("An error occurred in add phy geo agri " + e,"Error",null);
        }
    }

    private void addPhyGeoAgri(String adm, ResultSet set, ResultSet setGrade, Connection connection, String sqlUpdate, String sqlUpdate2, PreparedStatement statement, PreparedStatement statement2) {
        try {
            float addTotal = Float.parseFloat(set.getString(8)) + Float.parseFloat(set.getString(11)) + Float.parseFloat(set.getString(14)) + Float.parseFloat(set.getString(20)) + Float.parseFloat(set.getString(23)) + Float.parseFloat(set.getString(26))+ Float.parseFloat(set.getString(38));
            float addPoints = Float.parseFloat(set.getString(10)) + Float.parseFloat(set.getString(13)) + Float.parseFloat(set.getString(16)) + Float.parseFloat(set.getString(22)) + Float.parseFloat(set.getString(25)) + Float.parseFloat(set.getString(28))+ Float.parseFloat(set.getString(40));

            float avg = addTotal / 7;
            String avgP = String.format("%.1f",(addPoints/7));
            statement2 = connection.prepareStatement(sqlUpdate2);
            statement = connection.prepareStatement(sqlUpdate);
            statement.setString(1, String.valueOf(addTotal));
            statement.setString(2, set.getString(2));
            String g,p = "";
            if (Float.parseFloat(avgP)>=11.5) { g = "A";p="12"; } else if (Float.parseFloat(avgP)>=10.5) {
                g = "A-";p="11"; } else if (Float.parseFloat(avgP)>=9.5) { g = "B+";p="10"; } else if (Float.parseFloat(avgP)>=8.5) {
                g = "B";p="9"; } else if (Float.parseFloat(avgP)>=7.5) {
                g = "B-";p="8"; } else if (Float.parseFloat(avgP)>=6.5) {
                g = "C+";p="7"; } else if (Float.parseFloat(avgP)>=5.5) {
                g = "C";p="6"; } else if (Float.parseFloat(avgP)>=4.5) {
                g = "C-";p="5"; } else if (Float.parseFloat(avgP)>=3.5) {
                g = "D+";p="4"; } else if (Float.parseFloat(avgP)>=2.5) {
                g = "D";p="3"; } else if (Float.parseFloat(avgP)>=1.5) {
                g = "D-";p="2"; } else { g = "E";p="1"; }

            statement2.setString(1, g.toUpperCase());
            statement2.setString(2,avgP);
            statement2.setString(3, adm.toString());
            statement2.execute();
             statement.execute();
        }catch (Exception e){
            e.printStackTrace();
            infoBoxError("An error occurred in add phy geo agri " + e,"Error",null);
        }
    }

    private void addPhyGeoBus(String adm, ResultSet set, ResultSet setGrade, Connection connection, String sqlUpdate,String sqlUpdate2,PreparedStatement statement,PreparedStatement statement2) {
        try {
            float addTotal = Float.parseFloat(set.getString(8)) + Float.parseFloat(set.getString(11)) + Float.parseFloat(set.getString(14)) + Float.parseFloat(set.getString(20)) + Float.parseFloat(set.getString(23)) + Float.parseFloat(set.getString(26))+ Float.parseFloat(set.getString(35));
            float addPoints = Float.parseFloat(set.getString(10)) + Float.parseFloat(set.getString(13)) + Float.parseFloat(set.getString(16)) + Float.parseFloat(set.getString(22)) + Float.parseFloat(set.getString(25)) + Float.parseFloat(set.getString(28))+ Float.parseFloat(set.getString(37));

            float avg = addTotal / 7;
            String avgP = String.format("%.1f",(addPoints/7));
            statement2 = connection.prepareStatement(sqlUpdate2);
            statement = connection.prepareStatement(sqlUpdate);
            statement.setString(1, String.valueOf(addTotal));
            statement.setString(2, set.getString(2));
            String g,p = "";
            if (Float.parseFloat(avgP)>=11.5) { g = "A";p="12"; } else if (Float.parseFloat(avgP)>=10.5) {
                g = "A-";p="11"; } else if (Float.parseFloat(avgP)>=9.5) { g = "B+";p="10"; } else if (Float.parseFloat(avgP)>=8.5) {
                g = "B";p="9"; } else if (Float.parseFloat(avgP)>=7.5) {
                g = "B-";p="8"; } else if (Float.parseFloat(avgP)>=6.5) {
                g = "C+";p="7"; } else if (Float.parseFloat(avgP)>=5.5) {
                g = "C";p="6"; } else if (Float.parseFloat(avgP)>=4.5) {
                g = "C-";p="5"; } else if (Float.parseFloat(avgP)>=3.5) {
                g = "D+";p="4"; } else if (Float.parseFloat(avgP)>=2.5) {
                g = "D";p="3"; } else if (Float.parseFloat(avgP)>=1.5) {
                g = "D-";p="2"; } else { g = "E";p="1"; }

            statement2.setString(1, g.toUpperCase());
            statement2.setString(2,avgP);
            statement2.setString(3, adm.toString());
            statement2.execute();
             statement.execute();
        }catch (Exception e){
            e.printStackTrace();
            infoBoxError("An error occurred in add phy geo bus " + e,"Error",null);
        }
    }

    private void addAllSubjects(String adm, ResultSet set, ResultSet setGrade, Connection connection, String sqlUpdate,String sqlUpdate2,PreparedStatement statement,PreparedStatement statement2) {
        try {
            float addTotal = Float.parseFloat(set.getString(8)) + Float.parseFloat(set.getString(11)) + Float.parseFloat(set.getString(14)) + Float.parseFloat(set.getString(17)) + Float.parseFloat(set.getString(20)) + Float.parseFloat(set.getString(23)) + Float.parseFloat(set.getString(26)) + Float.parseFloat(set.getString(29)) + Float.parseFloat(set.getString(32)) + Float.parseFloat(set.getString(35)) + Float.parseFloat(set.getString(38));
            float addPoints = Float.parseFloat(set.getString(10)) + Float.parseFloat(set.getString(13)) + Float.parseFloat(set.getString(16)) + Float.parseFloat(set.getString(19)) + Float.parseFloat(set.getString(22)) + Float.parseFloat(set.getString(25)) + Float.parseFloat(set.getString(28)) + Float.parseFloat(set.getString(31)) + Float.parseFloat(set.getString(34)) + Float.parseFloat(set.getString(37)) + Float.parseFloat(set.getString(40));

            float avg = addTotal / 11;
            String avgP = String.format("%.1f",(addPoints/7));

            statement2 = connection.prepareStatement(sqlUpdate2);
            statement = connection.prepareStatement(sqlUpdate);
            statement.setString(1, String.valueOf(addTotal));
            statement.setString(2, set.getString(2));
            String g,p = "";
            if (Float.parseFloat(avgP)>=11.5) { g = "A";p="12"; } else if (Float.parseFloat(avgP)>=10.5) {
                g = "A-";p="11"; } else if (Float.parseFloat(avgP)>=9.5) { g = "B+";p="10"; } else if (Float.parseFloat(avgP)>=8.5) {
                g = "B";p="9"; } else if (Float.parseFloat(avgP)>=7.5) {
                g = "B-";p="8"; } else if (Float.parseFloat(avgP)>=6.5) {
                g = "C+";p="7"; } else if (Float.parseFloat(avgP)>=5.5) {
                g = "C";p="6"; } else if (Float.parseFloat(avgP)>=4.5) {
                g = "C-";p="5"; } else if (Float.parseFloat(avgP)>=3.5) {
                g = "D+";p="4"; } else if (Float.parseFloat(avgP)>=2.5) {
                g = "D";p="3"; } else if (Float.parseFloat(avgP)>=1.5) {
                g = "D-";p="2"; } else { g = "E";p="1"; }

            statement2.setString(1, g.toUpperCase());
            statement2.setString(2,avgP);
            statement2.setString(3, adm.toString());
            statement2.execute();

             statement.execute();
        }catch (Exception e){
            e.printStackTrace();
            infoBoxError("An error occurred in add all subjects " + e,"Error",null);
        }
    }


    public void printPass(){
        Printpass.ex3=1;
        try{
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("printPass.fxml"));

            Printpass printpass = (Printpass) loader.getController();

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

    public void printPassAll(){
        //PrintPass.printT1Avg=1;
        Printpass.printT1E3=1;
        try{
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("printPass.fxml"));

            Printpass printpass = (Printpass) loader.getController();

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

    public void printClassResults(){

        if(printPassword.toString().equals("vic")) {
            //((Node)(event.getSource())).getScene().getWindow().hide();
            String sql = "SELECT * FROM tbl_f4_t1_ex3 WHERE class = 'FORM_1' ORDER BY pt DESC";
            String engSum = "SELECT AVG(eng) SUM_ENG FROM tbl_f4_t1_ex3 WHERE class='FORM_1'";
            String kisSum = "SELECT AVG(kis) SUM_KIS FROM tbl_f4_t1_ex3 WHERE class='FORM_1'";
            String matSum = "SELECT AVG(mat) SUM_MAT FROM tbl_f4_t1_ex3 WHERE class='FORM_1'";
            String chemSum = "SELECT AVG(chem) SUM_CHEM FROM tbl_f4_t1_ex3 WHERE class='FORM_1'";
            String bioSum = "SELECT AVG(bio) SUM_BIO FROM tbl_f4_t1_ex3 WHERE class='FORM_1'";
            String phySum = "SELECT AVG(phy) SUM_PHY FROM tbl_f4_t1_ex3 WHERE class='FORM_1'";
            String geoSum = "SELECT AVG(geo) SUM_GEO FROM tbl_f4_t1_ex3 WHERE class='FORM_1'";
            String hisSum = "SELECT AVG(his) SUM_HIS FROM tbl_f4_t1_ex3 WHERE class='FORM_1'";
            String creSum = "SELECT AVG(cre) SUM_CRE FROM tbl_f4_t1_ex3 WHERE class='FORM_1'";
            String busSum = "SELECT AVG(bus) SUM_BUS FROM tbl_f4_t1_ex3 WHERE class='FORM_1'";
            String agriSum = "SELECT AVG(agri) SUM_AGRI FROM tbl_f4_t1_ex3 WHERE class='FORM_1'";
            String totalSum = "SELECT AVG(total) SUM_TOTAL FROM tbl_f4_t1_ex3 WHERE class='FORM_1'";
            String avgSum = "SELECT AVG(pt) SUM_PT FROM tbl_f4_t1_ex3 WHERE class='FORM_1'";
            String kcpeSum = "SELECT AVG(kcpe) SUM_KCPE FROM tbl_f4_t1_ex3 WHERE class='FORM_1'";
            try {
                Connection connection = Database.DBConnection.getConnection();
                ResultSet set = connection.createStatement().executeQuery(sql);
                ResultSet setEng = connection.createStatement().executeQuery(engSum);
                ResultSet setKis = connection.createStatement().executeQuery(kisSum);
                ResultSet setMat = connection.createStatement().executeQuery(matSum);
                ResultSet setChem = connection.createStatement().executeQuery(chemSum);
                ResultSet setBio = connection.createStatement().executeQuery(bioSum);
                ResultSet setPhy = connection.createStatement().executeQuery(phySum);
                ResultSet setGeo = connection.createStatement().executeQuery(geoSum);
                ResultSet setHis = connection.createStatement().executeQuery(hisSum);
                ResultSet setCre = connection.createStatement().executeQuery(creSum);
                ResultSet setBus = connection.createStatement().executeQuery(busSum);
                ResultSet setAgri = connection.createStatement().executeQuery(agriSum);
                ResultSet setTotal = connection.createStatement().executeQuery(totalSum);
                ResultSet setAvg = connection.createStatement().executeQuery(avgSum);
                ResultSet setKcpe = connection.createStatement().executeQuery(kcpeSum);

                Document document = new Document(PageSize.A4.rotate());
                PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("F4T1E3ClassResults.pdf"));
                document.open();
                Paragraph schoolName = new Paragraph("SCHOOL NAME", new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.BOLD));
                Paragraph address = new Paragraph("P.O BOX 22332, LOCATION", new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.BOLD));
                Paragraph tell = new Paragraph("PHONE: 073293874", new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.BOLD));
                Paragraph reportType = new Paragraph("FORM 4 TERM 1 EXAM 3", new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.BOLD));
                schoolName.setAlignment(Element.ALIGN_CENTER);
                address.setAlignment(Element.ALIGN_CENTER);
                tell.setAlignment(Element.ALIGN_CENTER);
                reportType.setAlignment(Element.ALIGN_CENTER);
                document.add(schoolName);
                document.add(address);
                document.add(tell);
                document.add(reportType);
                document.add((new Paragraph(" ")));
                /**
                 * logo
                 * */
                Image img = Image.getInstance(cname+"\\HS Results\\Web-Development.png");
                img.scaleAbsolute(100, 50);
                img.setAbsolutePosition(30, 500);
                document.add(img);

                PdfPTable table = new PdfPTable(17);
                table.setWidthPercentage(105);
                table.setSpacingBefore(0f);
                table.setSpacingAfter(0f);

                float[] colWidth = {0.4f, 0.5f, 3f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.6f, 0.5f, 0.5f};
                table.setWidths(colWidth);
                PdfPCell c17 = new PdfPCell(new Paragraph("#", new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD)));
                PdfPCell c1 = new PdfPCell(new Paragraph("ADM", new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD)));
                PdfPCell c2 = new PdfPCell(new Paragraph("NAME", new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD)));
                PdfPCell c3 = new PdfPCell(new Paragraph("ENG", new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD)));
                PdfPCell c4 = new PdfPCell(new Paragraph("KIS", new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD)));
                PdfPCell c5 = new PdfPCell(new Paragraph("MAT", new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD)));
                PdfPCell c6 = new PdfPCell(new Paragraph("CHEM", new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD)));
                PdfPCell c7 = new PdfPCell(new Paragraph("BIO", new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD)));
                PdfPCell c8 = new PdfPCell(new Paragraph("PHY", new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD)));
                PdfPCell c9 = new PdfPCell(new Paragraph("GEO", new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD)));
                PdfPCell c10 = new PdfPCell(new Paragraph("HIS", new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD)));
                PdfPCell c11 = new PdfPCell(new Paragraph("CRE", new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD)));
                PdfPCell c12 = new PdfPCell(new Paragraph("BUS", new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD)));
                PdfPCell c13 = new PdfPCell(new Paragraph("AGRI", new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD)));
                PdfPCell c14 = new PdfPCell(new Paragraph("TOTAL", new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD)));
                PdfPCell c15 = new PdfPCell(new Paragraph("AVG", new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD)));
                PdfPCell c16 = new PdfPCell(new Paragraph("KCPE", new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD)));

                table.addCell(c17);
                table.addCell(c1);
                table.addCell(c2);
                table.addCell(c3);
                table.addCell(c4);
                table.addCell(c5);
                table.addCell(c6);
                table.addCell(c7);
                table.addCell(c8);
                table.addCell(c9);
                table.addCell(c10);
                table.addCell(c11);
                table.addCell(c12);
                table.addCell(c13);
                table.addCell(c14);
                table.addCell(c15);
                table.addCell(c16);

                Font font =  new Font(Font.FontFamily.HELVETICA, 9, Font.NORMAL);

                int Count = 0;

                while (set.next()) {
                    Count++;
                    PdfPCell r17 = new PdfPCell(new Paragraph(String.valueOf(Count),font));
                    PdfPCell r1 = new PdfPCell(new Paragraph(set.getString(2),font));
                    PdfPCell r2 = new PdfPCell(new Paragraph(set.getString(3) + " " + set.getString(4) + " " + set.getString(5),font));
                    PdfPCell r3 = new PdfPCell(new Paragraph(set.getString(8) + " " + set.getString(9),font));
                    PdfPCell r4 = new PdfPCell(new Paragraph(set.getString(11) + " " + set.getString(12),font));
                    PdfPCell r5 = new PdfPCell(new Paragraph(set.getString(14) + " " + set.getString(15),font));
                    PdfPCell r6 = new PdfPCell(new Paragraph(set.getString(17) + " " + set.getString(18),font));
                    PdfPCell r7 = new PdfPCell(new Paragraph(set.getString(20) + " " + set.getString(21),font));
                    PdfPCell r8 = new PdfPCell(new Paragraph(set.getString(23) + " " + set.getString(24),font));
                    PdfPCell r9 = new PdfPCell(new Paragraph(set.getString(26) + " " + set.getString(27),font));
                    PdfPCell r10 = new PdfPCell(new Paragraph(set.getString(29) + " " + set.getString(30),font));
                    PdfPCell r11 = new PdfPCell(new Paragraph(set.getString(32) + " " + set.getString(33),font));
                    PdfPCell r12 = new PdfPCell(new Paragraph(set.getString(35) + " " + set.getString(36),font));
                    PdfPCell r13 = new PdfPCell(new Paragraph(set.getString(38) + " " + set.getString(39),font));
                    PdfPCell r14 = new PdfPCell(new Paragraph(set.getString(41),font));
                    PdfPCell r15 = new PdfPCell(new Paragraph(String.format("%.1f",Float.parseFloat(set.getString(43)))+ " " + set.getString(42),font));
                    PdfPCell r16 = new PdfPCell(new Paragraph(set.getString(6),font));

                    table.addCell(r17);
                    table.addCell(r1);
                    table.addCell(r2);
                    table.addCell(r3);
                    table.addCell(r4);
                    table.addCell(r5);
                    table.addCell(r6);
                    table.addCell(r7);
                    table.addCell(r8);
                    table.addCell(r9);
                    table.addCell(r10);
                    table.addCell(r11);
                    table.addCell(r12);
                    table.addCell(r13);
                    table.addCell(r14);
                    table.addCell(r15);
                    table.addCell(r16);
                }
                PdfPTable table2 = new PdfPTable(17);
                table2.setWidthPercentage(105);
                table2.setSpacingBefore(0f);
                table2.setSpacingAfter(0f);

                float[] colWidth2 = {0.4f, 0.5f, 3f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.6f, 0.5f, 0.5f};
                table2.setWidths(colWidth2);
                PdfPCell s1 = new PdfPCell(new Paragraph(" "));
                PdfPCell s2 = new PdfPCell(new Paragraph(" "));
                PdfPCell s3 = new PdfPCell(new Paragraph(" "));

                table2.addCell(s1);
                table2.addCell(s2);
                table2.addCell(s3);

                while (setEng.next()) {
                    float value = Float.parseFloat(setEng.getString(1));
                    PdfPCell s4 = new PdfPCell(new Paragraph(String.valueOf(Math.round(value)),font));
                    table2.addCell(s4);
                }
                while (setKis.next()) {
                    float value = Float.parseFloat(setKis.getString(1));
                    PdfPCell s5 = new PdfPCell(new Paragraph(String.valueOf(Math.round(value)),font));
                    table2.addCell(s5);
                }
                while (setMat.next()) {
                    float value = Float.parseFloat(setMat.getString(1));
                    PdfPCell s6 = new PdfPCell(new Paragraph(String.valueOf(Math.round(value)),font));
                    table2.addCell(s6);
                }
                while (setChem.next()) {
                    float value = Float.parseFloat(setChem.getString(1));
                    PdfPCell s7 = new PdfPCell(new Paragraph(String.valueOf(Math.round(value)),font));
                    table2.addCell(s7);
                }
                while (setBio.next()) {
                    float value = Float.parseFloat(setBio.getString(1));
                    PdfPCell s8 = new PdfPCell(new Paragraph(String.valueOf(Math.round(value)),font));
                    table2.addCell(s8);
                }
                while (setPhy.next()) {
                    float value = Float.parseFloat(setPhy.getString(1));
                    PdfPCell s9 = new PdfPCell(new Paragraph(String.valueOf(Math.round(value)),font));
                    table2.addCell(s9);
                }
                while (setGeo.next()) {
                    float value = Float.parseFloat(setGeo.getString(1));
                    PdfPCell s10 = new PdfPCell(new Paragraph(String.valueOf(Math.round(value)),font));
                    table2.addCell(s10);
                }
                while (setHis.next()) {
                    float value = Float.parseFloat(setHis.getString(1));
                    PdfPCell s11 = new PdfPCell(new Paragraph(String.valueOf(Math.round(value)),font));
                    table2.addCell(s11);
                }
                while (setCre.next()) {
                    float value = Float.parseFloat(setCre.getString(1));
                    PdfPCell s12 = new PdfPCell(new Paragraph(String.valueOf(Math.round(value)),font));
                    table2.addCell(s12);
                }
                while (setBus.next()) {
                    float value = Float.parseFloat(setBus.getString(1));
                    PdfPCell s13 = new PdfPCell(new Paragraph(String.valueOf(Math.round(value)),font));
                    table2.addCell(s13);
                }
                while (setAgri.next()) {
                    float value = Float.parseFloat(setAgri.getString(1));
                    PdfPCell s14 = new PdfPCell(new Paragraph(String.valueOf(Math.round(value)),font));
                    table2.addCell(s14);
                }
                while (setTotal.next()) {
                    float value = Float.parseFloat(setTotal.getString(1));
                    PdfPCell s15 = new PdfPCell(new Paragraph(String.valueOf(Math.round(value)),font));
                    table2.addCell(s15);
                }
                while (setAvg.next()) {
                    float value = (Float.parseFloat(setAvg.getString(1))) ;
                    PdfPCell s16 = new PdfPCell(new Paragraph(String.valueOf(String.format("%.2f",value)),font));
                    table2.addCell(s16);
                }
                while (setKcpe.next()) {
                    float value = Float.parseFloat(setKcpe.getString(1));
                    PdfPCell s17 = new PdfPCell(new Paragraph(String.valueOf(Math.round(value)),font));
                    table2.addCell(s17);
                }

                document.add(table);
                document.add(table2);
                document.close();
                writer.close();
                infoBox("Document containing exam 3 results for FORM 4 TERM 1 has been created open it for printing.", "Done", null);
                Desktop.getDesktop().open(new File(cname+"\\HS Results\\F4T1E3ClassResults.pdf"));
                connection.close();
            } catch (Exception e) {
                infoBoxError("An error occurred " + e, "error", null);
                e.printStackTrace();
            }
        }else{
            //((Node)(event.getSource())).getScene().getWindow().hide();
            infoBoxError("You are not allowed to print","Error",null);
        }
    }

    public void printAllResults(){
        String sql = "SELECT COUNT(adm) FROM tbl_students WHERE class='FORM_1'";
        String sqlStudents="SELECT * FROM tbl_f4_t1_ex3 WHERE class = 'FORM_1' ORDER BY total DESC ";
        String sqlSubSel = "SELECT * FROM tbl_subject_selection WHERE adm=?";
        try{
            Connection connection = Database.DBConnection.getConnection();
            ResultSet totalSet = connection.createStatement().executeQuery(sql);
            //while (totalSet.next()){
            String totalStudents = totalSet.getString(1);

            // }
            ResultSet studentSet = connection.createStatement().executeQuery(sqlStudents);

            String names = "Form4_term1_exam3";

            Document document = new Document(PageSize.A4);
            PdfWriter writer = PdfWriter.getInstance(document,new FileOutputStream(names+".pdf"));
            document.open();

            int pos = 0;
            while (studentSet.next()){
                pos++;
                String adm = studentSet.getString(2);
                ResultSet subSelSet = null;
                PreparedStatement statement = connection.prepareStatement(sqlSubSel);
                statement.setString(1,adm);
                subSelSet = statement.executeQuery();
                String bio=subSelSet.getString(11);
                String phy=subSelSet.getString(13);
                String geo=subSelSet.getString(14);
                String his=subSelSet.getString(15);
                String cre=subSelSet.getString(16);
                String bus=subSelSet.getString(17);
                String agri=subSelSet.getString(18);
                if (Integer.parseInt(bio)==1&&Integer.parseInt(phy)==1&&Integer.parseInt(geo)==1&&Integer.parseInt(his)==1&&Integer.parseInt(cre)==1&&Integer.parseInt(bus)==1&&Integer.parseInt(agri)==1){
                    printAllSubjects(adm,document,writer,pos,totalStudents);
                }else {

                    if(Integer.parseInt(bio)==0){
                        //you are doing physics
                        if (Integer.parseInt(geo)==1){
                            if (Integer.parseInt(bus) == 1) {
                                //  infoBox("You are doing physics,geography,business","Subject",null);
                                printPhyGeoBus(adm,document,writer,pos,totalStudents);
                            }else{
                                //  infoBox("You are doing physics,geography,agriculture","Subject",null);
                                printPhyGeoAgri(adm,document,writer,pos,totalStudents);
                            }
                        }else if (Integer.parseInt(his)==1){
                            if (Integer.parseInt(bus) == 1) {
                                //  infoBox("You are doing physics,history,business","Subject",null);
                                printPhyHisBus(adm,document,writer,pos,totalStudents);
                            }else{
                                //  infoBox("You are doing physics,history,agriculture","Subject",null);
                                printPhyHisAgri(adm,document,writer,pos,totalStudents);
                            }
                        }else {
                            if (Integer.parseInt(bus) == 1) {
                                //    infoBox("You are physics,cre,doing business","Subject",null);
                                printPhyCreBus(adm,document,writer,pos,totalStudents);
                            }else{
                                //  infoBox("You are doing physics,cre,agriculture","Subject",null);
                                printPhyCreAgri(adm,document,writer,pos,totalStudents);
                            }
                        }

                    }else{
                        //you are doing biology
                        if (Integer.parseInt(geo)==1){
                            if (Integer.parseInt(bus) == 1) {
                                //  infoBox("You are doing biology,geography,business","Subject",null);
                                printBioGeoBus(adm,document,writer,pos,totalStudents);
                            }else{
                                // infoBox("You are doing biology,geography,agriculture","Subject",null);
                                printBioGeoAgri(adm,document,writer,pos,totalStudents);
                            }
                        }else if (Integer.parseInt(his)==1){
                            if (Integer.parseInt(bus) == 1) {
                                //infoBox("You are doing biology,history,business","Subject",null);
                                printBioHisBus(adm,document,writer,pos,totalStudents);
                            }else{
                                //infoBox("You are doing biology,history,agriculture","Subject",null);
                                printBioHisAgri(adm,document,writer,pos,totalStudents);
                            }
                        }else {
                            if (Integer.parseInt(bus) == 1) {
                                // infoBox("You are biology,cre,doing business","Subject",null);
                                printBioCreBus(adm,document,writer,pos,totalStudents);
                            }else{
                                // infoBox("You are doing biology,cre,agriculture","Subject",null);
                                printBioCreAgri(adm,document,writer,pos,totalStudents);
                            }
                        }}
                }

            }
            document.close();
            writer.close();
            infoBox("Document containing exam 3 results for form 4 term 1 has been created open it for printing.","Done",null);
            Desktop.getDesktop().open(new File(cname+"\\HS Results\\"+names+".pdf"));

        }catch (Exception e){
            e.printStackTrace();
            infoBoxError("An error occurred " + e,"Error",null);
        }

    }

    private void printBioCreAgri(String adm, Document document, PdfWriter writer, int pos, String totalStudents) {
        if(printPassword.toString().equals("vic")) {
            String sqlDetails="SELECT * FROM tbl_students WHERE adm=?";
            String sqlComm = "SELECT * FROM tbl_comments";
            String sqlTotal ="SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='TOTAL'";
            String sqlEx3 = "SELECT * FROM tbl_f4_t1_ex3 WHERE adm=? ";
             String sqlF1T1Ex3 = "SELECT * FROM tbl_f1_t1_ex3 WHERE adm=?";
            String sqlF1T2Ex3 = "SELECT * FROM tbl_f1_t2_ex3 WHERE adm=?";
            String sqlF1T3Ex3 = "SELECT * FROM tbl_f1_t3_ex3 WHERE adm=?";
            String sqlF2T1Ex3 = "SELECT * FROM tbl_f2_t1_ex3 WHERE adm=?";
            String sqlF2T2Ex3 = "SELECT * FROM tbl_f2_t2_ex3 WHERE adm=?";
            String sqlF2T3Ex3 = "SELECT * FROM tbl_f2_t3_ex3 WHERE adm=?";
            String sqlF3T1Ex3 = "SELECT * FROM tbl_f3_t1_ex3 WHERE adm=?";
            String sqlF3T2Ex3 = "SELECT * FROM tbl_f3_t2_ex3 WHERE adm=?";
            String sqlF3T3Ex3 = "SELECT * FROM tbl_f3_t3_ex3 WHERE adm=?";

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
                PreparedStatement statementE3 = connection.prepareStatement(sqlEx3);
                PreparedStatement statementF1T1E3 = connection.prepareStatement(sqlF1T1Ex3);
                PreparedStatement statementF1T2E3 = connection.prepareStatement(sqlF1T2Ex3);
                PreparedStatement statementF1T3E3 = connection.prepareStatement(sqlF1T3Ex3);
                PreparedStatement statementF2T1E3 = connection.prepareStatement(sqlF2T1Ex3);
                PreparedStatement statementF2T2E3 = connection.prepareStatement(sqlF2T2Ex3);
                PreparedStatement statementF2T3E3 = connection.prepareStatement(sqlF2T3Ex3);
                PreparedStatement statementF3T1E3 = connection.prepareStatement(sqlF3T1Ex3);
                PreparedStatement statementF3T2E3 = connection.prepareStatement(sqlF3T2Ex3);
                PreparedStatement statementF3T3E3 = connection.prepareStatement(sqlF3T3Ex3);

                statement.setString(1,adm);
                statementE3.setString(1,adm);
                statementF1T1E3.setString(1,adm);
                statementF1T2E3.setString(1,adm);
                statementF1T3E3.setString(1,adm);
                statementF2T1E3.setString(1,adm);
                statementF2T2E3.setString(1,adm);
                statementF2T3E3.setString(1,adm);
                statementF3T1E3.setString(1,adm);
                statementF3T2E3.setString(1,adm);
                statementF3T3E3.setString(1,adm);

                ResultSet set = statement.executeQuery();
                ResultSet setE3 = statementE3.executeQuery();
                 ResultSet setF1T1E3 = statementF1T1E3.executeQuery();
                ResultSet setF1T2E3 = statementF1T2E3.executeQuery();
                ResultSet setF1T3E3 = statementF1T3E3.executeQuery();
                ResultSet setF2T1E3 = statementF2T1E3.executeQuery();
                ResultSet setF2T2E3 = statementF2T2E3.executeQuery();
                ResultSet setF2T3E3 = statementF2T3E3.executeQuery();
                ResultSet setF3T1E3 = statementF3T1E3.executeQuery();
                ResultSet setF3T2E3 = statementF3T2E3.executeQuery();
                ResultSet setF3T3E3 = statementF3T3E3.executeQuery();

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

                document.add((new Paragraph("ADM: "+set.getString(2)+"  "+"NAME: "+set.getString(3)+"   "+set.getString(4)+" "+set.getString(5)+"  "+"KCPE:"+set.getString(6)+"  "+"CLASS:FORM 4"+"  "+"TERM:TERM 1",new Font(Font.FontFamily.TIMES_ROMAN, 9,Font.BOLD))));
                document.add((new Paragraph("YEAR:"+now.get(Calendar.YEAR)+" "+"POS:"+String.valueOf(pos)+" "+"OUT OF "+totalStudents,new Font(Font.FontFamily.TIMES_ROMAN, 9,Font.BOLD))));
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
                PdfPCell engD3 = new PdfPCell(new Paragraph(" "));
                PdfPCell engD4 = new PdfPCell(new Paragraph(setE3.getString(8)+" "+setE3.getString(9)));

                int avgE= Integer.parseInt(setE3.getString(8));
                if (avgE >= Integer.parseInt(setEngGrade.getString(4))) {com = setComments.getString(2); } else if (avgE >= Integer.parseInt(setEngGrade.getString(5))) { com = setComments.getString(3); }else if (avgE >=Integer.parseInt(setEngGrade.getString(6))){ com = setComments.getString(4);}else if (avgE >=Integer.parseInt(setEngGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgE >=Integer.parseInt(setEngGrade.getString(8))){  com = setComments.getString(6); }else if (avgE >=Integer.parseInt(setEngGrade.getString(9))){ com = setComments.getString(7); }else if (avgE >=Integer.parseInt(setEngGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgE >=Integer.parseInt(setEngGrade.getString(11))){ com = setComments.getString(9);}else if (avgE >=Integer.parseInt(setEngGrade.getString(12))){ com = setComments.getString(10);}else if (avgE >=Integer.parseInt(setEngGrade.getString(13))){ com = setComments.getString(11);}else if (avgE >=Integer.parseInt(setEngGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }
                PdfPCell engD5 = new PdfPCell(new Paragraph(setE3.getString(8)+" "+setE3.getString(9)));
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
                PdfPCell kisD3 = new PdfPCell(new Paragraph(" "));
                PdfPCell kisD4 = new PdfPCell(new Paragraph(setE3.getString(11)+" "+setE3.getString(12)));

                int avgKis= Integer.parseInt(setE3.getString(11));
                if (avgKis >= Integer.parseInt(setKisGrade.getString(4))) {com = setComments.getString(2); } else if (avgKis >= Integer.parseInt(setKisGrade.getString(5))) { com = setComments.getString(3); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(6))){ com = setComments.getString(4);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(8))){  com = setComments.getString(6); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(9))){ com = setComments.getString(7); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgKis >=Integer.parseInt(setKisGrade.getString(11))){ com = setComments.getString(9);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(12))){ com = setComments.getString(10);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(13))){ com = setComments.getString(11);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }
                PdfPCell kisD5 = new PdfPCell(new Paragraph(setE3.getString(11)+" "+setE3.getString(12)));
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
                PdfPCell matD3 = new PdfPCell(new Paragraph(" "));
                PdfPCell matD4 = new PdfPCell(new Paragraph(setE3.getString(14)+" "+setE3.getString(15)));

                int avgMat = Integer.parseInt(setE3.getString(14));
                if (avgMat >= Integer.parseInt(setMatGrade.getString(4))) {com = setComments.getString(2); } else if (avgMat >= Integer.parseInt(setMatGrade.getString(5))) { com = setComments.getString(3); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(6))){ com = setComments.getString(4);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(8))){  com = setComments.getString(6); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(9))){ com = setComments.getString(7); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgMat >=Integer.parseInt(setMatGrade.getString(11))){ com = setComments.getString(9);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(12))){ com = setComments.getString(10);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(13))){ com = setComments.getString(11);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell matD5 = new PdfPCell(new Paragraph(setE3.getString(14)+" "+setE3.getString(15)));
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
                PdfPCell chemD3 = new PdfPCell(new Paragraph(" "));
                PdfPCell chemD4 = new PdfPCell(new Paragraph(setE3.getString(20)+" "+setE3.getString(21)));

                int avgChem = Integer.parseInt(setE3.getString(20));
                if (avgChem >= Integer.parseInt(setChemGrade.getString(4))) {com = setComments.getString(2); } else if (avgChem >= Integer.parseInt(setChemGrade.getString(5))) { com = setComments.getString(3); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(6))){ com = setComments.getString(4);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(8))){  com = setComments.getString(6); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(9))){ com = setComments.getString(7); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgChem >=Integer.parseInt(setChemGrade.getString(11))){ com = setComments.getString(9);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(12))){ com = setComments.getString(10);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(13))){ com = setComments.getString(11);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell chemD5 = new PdfPCell(new Paragraph(setE3.getString(20)+" "+setE3.getString(21)));
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
                PdfPCell bioD3 = new PdfPCell(new Paragraph(" "));
                PdfPCell bioD4 = new PdfPCell(new Paragraph(setE3.getString(17)+" "+setE3.getString(18)));

                int avgBio = Integer.parseInt(setE3.getString(17));
                if (avgBio >= Integer.parseInt(setBioGrade.getString(4))) {com = setComments.getString(2); } else if (avgBio >= Integer.parseInt(setBioGrade.getString(5))) { com = setComments.getString(3); }else if (avgBio >=Integer.parseInt(setBioGrade.getString(6))){ com = setComments.getString(4);}else if (avgBio >=Integer.parseInt(setBioGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgBio >=Integer.parseInt(setBioGrade.getString(8))){  com = setComments.getString(6); }else if (avgBio >=Integer.parseInt(setBioGrade.getString(9))){ com = setComments.getString(7); }else if (avgBio >=Integer.parseInt(setBioGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgBio >=Integer.parseInt(setBioGrade.getString(11))){ com = setComments.getString(9);}else if (avgBio >=Integer.parseInt(setBioGrade.getString(12))){ com = setComments.getString(10);}else if (avgBio >=Integer.parseInt(setBioGrade.getString(13))){ com = setComments.getString(11);}else if (avgBio >=Integer.parseInt(setBioGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell bioD5 = new PdfPCell(new Paragraph(setE3.getString(17)+" "+setE3.getString(18)));
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
                PdfPCell creD3 = new PdfPCell(new Paragraph(" "));
                PdfPCell creD4 = new PdfPCell(new Paragraph(setE3.getString(32)+" "+setE3.getString(33)));

                int avgCre = Integer.parseInt(setE3.getString(32));
                if (avgCre >= Integer.parseInt(setCreGrade.getString(4))) {com = setComments.getString(2); } else if (avgCre >= Integer.parseInt(setCreGrade.getString(5))) { com = setComments.getString(3); }else if (avgCre >=Integer.parseInt(setCreGrade.getString(6))){ com = setComments.getString(4);}else if (avgCre >=Integer.parseInt(setCreGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgCre >=Integer.parseInt(setCreGrade.getString(8))){  com = setComments.getString(6); }else if (avgCre >=Integer.parseInt(setCreGrade.getString(9))){ com = setComments.getString(7); }else if (avgCre >=Integer.parseInt(setCreGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgCre >=Integer.parseInt(setCreGrade.getString(11))){ com = setComments.getString(9);}else if (avgCre >=Integer.parseInt(setCreGrade.getString(12))){ com = setComments.getString(10);}else if (avgCre >=Integer.parseInt(setCreGrade.getString(13))){ com = setComments.getString(11);}else if (avgCre >=Integer.parseInt(setCreGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell creD5 = new PdfPCell(new Paragraph(setE3.getString(32)+" "+setE3.getString(33)));
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
                PdfPCell agriD3 = new PdfPCell(new Paragraph(" "));
                PdfPCell agriD4 = new PdfPCell(new Paragraph(setE3.getString(38)+" "+setE3.getString(39)));

                int avgAgri = Integer.parseInt(setE3.getString(38));
                if (avgAgri >= Integer.parseInt(setAgriGrade.getString(4))) {com = setComments.getString(2); } else if (avgAgri >= Integer.parseInt(setAgriGrade.getString(5))) { com = setComments.getString(3); }else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(6))){ com = setComments.getString(4);}else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(8))){  com = setComments.getString(6); }else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(9))){ com = setComments.getString(7); }else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(11))){ com = setComments.getString(9);}else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(12))){ com = setComments.getString(10);}else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(13))){ com = setComments.getString(11);}else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell agriD5 = new PdfPCell(new Paragraph(setE3.getString(38)+" "+setE3.getString(39)));
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
                
                int totalE3 = Integer.parseInt(setE3.getString(41));
                int totalAvg = Integer.parseInt(setE3.getString(41));


                PdfPCell totalD1 = new PdfPCell(new Paragraph("Total"));
                PdfPCell totalD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell totalD3 = new PdfPCell(new Paragraph(" "));
                PdfPCell totalD4 = new PdfPCell(new Paragraph(String.valueOf(totalE3)));
                PdfPCell totalD5 = new PdfPCell(new Paragraph(String.valueOf(totalAvg)));
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

               
                //int add2AvgEx2 = (Math.addExact(totalEx2Mat,addAvgEx2))/3;

                int addAvgEx3 = Math.round(totalE3/7);
                //int add2AvgEx3 = (Math.addExact(totalEx3Mat,addAvgEx3))/3;

                
                PdfPCell avgD1 = new PdfPCell(new Paragraph("Average"));
                PdfPCell avgD2 = new PdfPCell(new Paragraph(" "));
                
                PdfPCell avgD3 = new PdfPCell(new Paragraph(" "));

                if (addAvgEx3 >= Integer.parseInt(setTotal.getString(4))) {g = "A"; } else if (addAvgEx3 >= Integer.parseInt(setTotal.getString(5))) { g = "A-"; }else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(6))){ g = "B+";}else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(7))){
                    g = "B"; }else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(8))){  g = "B-"; }else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(9))){ g = "C+"; }else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(10))){ g = "C";
                }else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(11))){ g = "C-";}else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(12))){ g = "D+";}else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(13))){ g = "D";}else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(14))){
                    g = "D-";}else {g="E"; }
                PdfPCell avgD4 = new PdfPCell(new Paragraph(String.valueOf(addAvgEx3)+" "+setE3.getString(42)));

                //float avgAvgTotal = (addAvgEx1+addAvgEx2+addAvgEx3)/3;
                int avgAvgTotal=Integer.parseInt(setE3.getString(41))/7;

                if (avgAvgTotal >= Integer.parseInt(setTotal.getString(4))) {g = "A"; } else if (avgAvgTotal >= Integer.parseInt(setTotal.getString(5))) { g = "A-"; }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(6))){ g = "B+";}else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(7))){
                    g = "B"; }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(8))){  g = "B-"; }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(9))){ g = "C+"; }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(10))){ g = "C";
                }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(11))){ g = "C-";}else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(12))){ g = "D+";}else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(13))){ g = "D";}else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(14))){
                    g = "D-";}else {g="E"; }

                PdfPCell avgD5 = new PdfPCell(new Paragraph(String.valueOf(Math.round(avgAvgTotal))+" "+setE3.getString(42)));
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
                PdfPCell f1t1m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF1T1E3.getString(30)))/11)+" "+setF1T1E3.getString(31)));
                PdfPCell f2t1 = new PdfPCell(new Paragraph("F2T1"));
                PdfPCell f2t1m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF2T1E3.getString(30)))/11)+" "+setF2T1E3.getString(31)));
                PdfPCell f3t1 = new PdfPCell(new Paragraph("F3T1"));
                PdfPCell f3t1m = new PdfPCell(new Paragraph(String.valueOf(Integer.parseInt(setF3T1E3.getString(41))/11)+" "+setF3T1E3.getString(43)+" "+setF3T1E3.getString(42)));
                PdfPCell f4t1 = new PdfPCell(new Paragraph("F4T1"));
                PdfPCell f4t1m = new PdfPCell(new Paragraph(String.valueOf(avgAvgTotal)+" "+setE3.getString(42)+" "+setE3.getString(43)));
                tableLastSummary.addCell(f1t1);
                tableLastSummary.addCell(f1t1m);
                tableLastSummary.addCell(f2t1);
                tableLastSummary.addCell(f2t1m);
                tableLastSummary.addCell(f3t1);
                tableLastSummary.addCell(f3t1m);
                tableLastSummary.addCell(f4t1);
                tableLastSummary.addCell(f4t1m);

                PdfPCell f1t2 = new PdfPCell(new Paragraph("F1T2"));
                PdfPCell f1t2m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF1T2E3.getString(30)))/11)+" "+setF1T2E3.getString(31)));
                PdfPCell f2t2 = new PdfPCell(new Paragraph("F2T2"));
                PdfPCell f2t2m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF2T2E3.getString(30)))/11)+" "+setF2T2E3.getString(31)));
                PdfPCell f3t2 = new PdfPCell(new Paragraph("F3T2"));
                PdfPCell f3t2m = new PdfPCell(new Paragraph(String.valueOf(Integer.parseInt(setF3T2E3.getString(41))/11)+" "+setF3T2E3.getString(43)+" "+setF3T2E3.getString(42)));
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
                PdfPCell f1t3m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF1T3E3.getString(30)))/11)+" "+setF1T3E3.getString(31)));
                PdfPCell f2t3 = new PdfPCell(new Paragraph("F2T3"));
                PdfPCell f2t3m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF2T3E3.getString(30)))/11)+" "+setF2T3E3.getString(31)));
                PdfPCell f3t3 = new PdfPCell(new Paragraph("F3T3"));
                PdfPCell f3t3m = new PdfPCell(new Paragraph(String.valueOf(Integer.parseInt(setF3T3E3.getString(41))/11)+" "+setF3T3E3.getString(43)+" "+setF3T3E3.getString(42)));
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
               dataSet.setValue((Integer.parseInt(setF1T1E3.getString(30))/11)/7, "Marks", "F1T1");
                dataSet.setValue((Integer.parseInt(setF1T2E3.getString(30))/11)/7, "Marks", "F1T2");
                dataSet.setValue((Integer.parseInt(setF1T3E3.getString(30))/11)/7, "Marks", "F1T3");
                dataSet.setValue((Integer.parseInt(setF2T1E3.getString(30))/11)/7, "Marks", "F2T1");
                dataSet.setValue((Integer.parseInt(setF2T2E3.getString(30))/11)/7, "Marks", "F2T2");
                dataSet.setValue((Integer.parseInt(setF2T3E3.getString(30))/11)/7, "Marks", "F2T3");
                dataSet.setValue(Float.parseFloat(setF3T1E3.getString(43)), "Marks", "F3T1");
                dataSet.setValue(Float.parseFloat(setF3T2E3.getString(43)), "Marks", "F3T2");
                dataSet.setValue(Float.parseFloat(setF3T3E3.getString(43)), "Marks", "F3T3");
              dataSet.setValue(Float.parseFloat(setE3.getString(43)), "Marks", "F4T1");
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
                 document.newPage();
                connection.close();

            }catch (Exception e){
                e.printStackTrace();
                infoBoxError("An error occurred " + e,"Error",null);
            }}else {
            infoBoxError("You are not allowed to print","Error",null);
        }
    }

    private void printBioCreBus(String adm, Document document, PdfWriter writer, int pos, String totalStudents) {
        if(printPassword.toString().equals("vic")) {
            String sqlDetails="SELECT * FROM tbl_students WHERE adm=?";
            String sqlComm = "SELECT * FROM tbl_comments";
            String sqlTotal ="SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='TOTAL'";
            
            String sqlEx3 = "SELECT * FROM tbl_f4_t1_ex3 WHERE adm=? ";
             String sqlF1T1Ex3 = "SELECT * FROM tbl_f1_t1_ex3 WHERE adm=?";
            String sqlF1T2Ex3 = "SELECT * FROM tbl_f1_t2_ex3 WHERE adm=?";
            String sqlF1T3Ex3 = "SELECT * FROM tbl_f1_t3_ex3 WHERE adm=?";
            String sqlF2T1Ex3 = "SELECT * FROM tbl_f2_t1_ex3 WHERE adm=?";
            String sqlF2T2Ex3 = "SELECT * FROM tbl_f2_t2_ex3 WHERE adm=?";
            String sqlF2T3Ex3 = "SELECT * FROM tbl_f2_t3_ex3 WHERE adm=?";
            String sqlF3T1Ex3 = "SELECT * FROM tbl_f3_t1_ex3 WHERE adm=?";
            String sqlF3T2Ex3 = "SELECT * FROM tbl_f3_t2_ex3 WHERE adm=?";
            String sqlF3T3Ex3 = "SELECT * FROM tbl_f3_t3_ex3 WHERE adm=?";
            

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
                
                PreparedStatement statementE3 = connection.prepareStatement(sqlEx3);
                PreparedStatement statementF1T1E3 = connection.prepareStatement(sqlF1T1Ex3);
                PreparedStatement statementF1T2E3 = connection.prepareStatement(sqlF1T2Ex3);
                PreparedStatement statementF1T3E3 = connection.prepareStatement(sqlF1T3Ex3);
                PreparedStatement statementF2T1E3 = connection.prepareStatement(sqlF2T1Ex3);
                PreparedStatement statementF2T2E3 = connection.prepareStatement(sqlF2T2Ex3);
                PreparedStatement statementF2T3E3 = connection.prepareStatement(sqlF2T3Ex3);
                PreparedStatement statementF3T1E3 = connection.prepareStatement(sqlF3T1Ex3);
                PreparedStatement statementF3T2E3 = connection.prepareStatement(sqlF3T2Ex3);
                PreparedStatement statementF3T3E3 = connection.prepareStatement(sqlF3T3Ex3);
                


                statement.setString(1,adm);
                
                statementE3.setString(1,adm);
                statementF1T1E3.setString(1,adm);
                statementF1T2E3.setString(1,adm);
                statementF1T3E3.setString(1,adm);
                statementF2T1E3.setString(1,adm);
                statementF2T2E3.setString(1,adm);
                statementF2T3E3.setString(1,adm);
                statementF3T1E3.setString(1,adm);
                statementF3T2E3.setString(1,adm);
                statementF3T3E3.setString(1,adm);
                

                ResultSet set = statement.executeQuery();
                
                ResultSet setE3 = statementE3.executeQuery();
                 ResultSet setF1T1E3 = statementF1T1E3.executeQuery();
                ResultSet setF1T2E3 = statementF1T2E3.executeQuery();
                ResultSet setF1T3E3 = statementF1T3E3.executeQuery();
                ResultSet setF2T1E3 = statementF2T1E3.executeQuery();
                ResultSet setF2T2E3 = statementF2T2E3.executeQuery();
                ResultSet setF2T3E3 = statementF2T3E3.executeQuery();
                ResultSet setF3T1E3 = statementF3T1E3.executeQuery();
                ResultSet setF3T2E3 = statementF3T2E3.executeQuery();
                ResultSet setF3T3E3 = statementF3T3E3.executeQuery();
                

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

                document.add((new Paragraph("ADM: "+set.getString(2)+"  "+"NAME: "+set.getString(3)+"   "+set.getString(4)+" "+set.getString(5)+"  "+"KCPE:"+set.getString(6)+"  "+"CLASS:FORM 4"+"  "+"TERM:TERM 1",new Font(Font.FontFamily.TIMES_ROMAN, 9,Font.BOLD))));
                document.add((new Paragraph("YEAR:"+now.get(Calendar.YEAR)+" "+"POS:"+String.valueOf(pos)+" "+"OUT OF "+totalStudents,new Font(Font.FontFamily.TIMES_ROMAN, 9,Font.BOLD))));
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
                PdfPCell engD3 = new PdfPCell(new Paragraph(" "));
                PdfPCell engD4 = new PdfPCell(new Paragraph(setE3.getString(8)+" "+setE3.getString(9)));

                int avgE= Integer.parseInt(setE3.getString(8));
                if (avgE >= Integer.parseInt(setEngGrade.getString(4))) {com = setComments.getString(2); } else if (avgE >= Integer.parseInt(setEngGrade.getString(5))) { com = setComments.getString(3); }else if (avgE >=Integer.parseInt(setEngGrade.getString(6))){ com = setComments.getString(4);}else if (avgE >=Integer.parseInt(setEngGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgE >=Integer.parseInt(setEngGrade.getString(8))){  com = setComments.getString(6); }else if (avgE >=Integer.parseInt(setEngGrade.getString(9))){ com = setComments.getString(7); }else if (avgE >=Integer.parseInt(setEngGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgE >=Integer.parseInt(setEngGrade.getString(11))){ com = setComments.getString(9);}else if (avgE >=Integer.parseInt(setEngGrade.getString(12))){ com = setComments.getString(10);}else if (avgE >=Integer.parseInt(setEngGrade.getString(13))){ com = setComments.getString(11);}else if (avgE >=Integer.parseInt(setEngGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }
                PdfPCell engD5 = new PdfPCell(new Paragraph(setE3.getString(8)+" "+setE3.getString(9)));
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
                PdfPCell kisD3 = new PdfPCell(new Paragraph(" "));
                PdfPCell kisD4 = new PdfPCell(new Paragraph(setE3.getString(11)+" "+setE3.getString(12)));

                int avgKis= Integer.parseInt(setE3.getString(11));
                if (avgKis >= Integer.parseInt(setKisGrade.getString(4))) {com = setComments.getString(2); } else if (avgKis >= Integer.parseInt(setKisGrade.getString(5))) { com = setComments.getString(3); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(6))){ com = setComments.getString(4);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(8))){  com = setComments.getString(6); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(9))){ com = setComments.getString(7); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgKis >=Integer.parseInt(setKisGrade.getString(11))){ com = setComments.getString(9);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(12))){ com = setComments.getString(10);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(13))){ com = setComments.getString(11);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }
                PdfPCell kisD5 = new PdfPCell(new Paragraph(setE3.getString(11)+" "+setE3.getString(12)));
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
                PdfPCell matD3 = new PdfPCell(new Paragraph(" "));
                PdfPCell matD4 = new PdfPCell(new Paragraph(setE3.getString(14)+" "+setE3.getString(15)));

                int avgMat = Integer.parseInt(setE3.getString(14));
                if (avgMat >= Integer.parseInt(setMatGrade.getString(4))) {com = setComments.getString(2); } else if (avgMat >= Integer.parseInt(setMatGrade.getString(5))) { com = setComments.getString(3); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(6))){ com = setComments.getString(4);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(8))){  com = setComments.getString(6); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(9))){ com = setComments.getString(7); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgMat >=Integer.parseInt(setMatGrade.getString(11))){ com = setComments.getString(9);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(12))){ com = setComments.getString(10);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(13))){ com = setComments.getString(11);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell matD5 = new PdfPCell(new Paragraph(setE3.getString(14)+" "+setE3.getString(15)));
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
                PdfPCell chemD3 = new PdfPCell(new Paragraph(" "));
                PdfPCell chemD4 = new PdfPCell(new Paragraph(setE3.getString(20)+" "+setE3.getString(21)));

                int avgChem = Integer.parseInt(setE3.getString(20));
                if (avgChem >= Integer.parseInt(setChemGrade.getString(4))) {com = setComments.getString(2); } else if (avgChem >= Integer.parseInt(setChemGrade.getString(5))) { com = setComments.getString(3); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(6))){ com = setComments.getString(4);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(8))){  com = setComments.getString(6); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(9))){ com = setComments.getString(7); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgChem >=Integer.parseInt(setChemGrade.getString(11))){ com = setComments.getString(9);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(12))){ com = setComments.getString(10);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(13))){ com = setComments.getString(11);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell chemD5 = new PdfPCell(new Paragraph(setE3.getString(20)+" "+setE3.getString(21)));
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
                PdfPCell bioD3 = new PdfPCell(new Paragraph(" "));
                PdfPCell bioD4 = new PdfPCell(new Paragraph(setE3.getString(17)+" "+setE3.getString(18)));

                int avgBio = Integer.parseInt(setE3.getString(17));
                if (avgBio >= Integer.parseInt(setBioGrade.getString(4))) {com = setComments.getString(2); } else if (avgBio >= Integer.parseInt(setBioGrade.getString(5))) { com = setComments.getString(3); }else if (avgBio >=Integer.parseInt(setBioGrade.getString(6))){ com = setComments.getString(4);}else if (avgBio >=Integer.parseInt(setBioGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgBio >=Integer.parseInt(setBioGrade.getString(8))){  com = setComments.getString(6); }else if (avgBio >=Integer.parseInt(setBioGrade.getString(9))){ com = setComments.getString(7); }else if (avgBio >=Integer.parseInt(setBioGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgBio >=Integer.parseInt(setBioGrade.getString(11))){ com = setComments.getString(9);}else if (avgBio >=Integer.parseInt(setBioGrade.getString(12))){ com = setComments.getString(10);}else if (avgBio >=Integer.parseInt(setBioGrade.getString(13))){ com = setComments.getString(11);}else if (avgBio >=Integer.parseInt(setBioGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell bioD5 = new PdfPCell(new Paragraph(setE3.getString(17)+" "+setE3.getString(18)));
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
                PdfPCell creD3 = new PdfPCell(new Paragraph(" "));
                PdfPCell creD4 = new PdfPCell(new Paragraph(setE3.getString(32)+" "+setE3.getString(33)));

                int avgCre = Integer.parseInt(setE3.getString(32));
                if (avgCre >= Integer.parseInt(setCreGrade.getString(4))) {com = setComments.getString(2); } else if (avgCre >= Integer.parseInt(setCreGrade.getString(5))) { com = setComments.getString(3); }else if (avgCre >=Integer.parseInt(setCreGrade.getString(6))){ com = setComments.getString(4);}else if (avgCre >=Integer.parseInt(setCreGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgCre >=Integer.parseInt(setCreGrade.getString(8))){  com = setComments.getString(6); }else if (avgCre >=Integer.parseInt(setCreGrade.getString(9))){ com = setComments.getString(7); }else if (avgCre >=Integer.parseInt(setCreGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgCre >=Integer.parseInt(setCreGrade.getString(11))){ com = setComments.getString(9);}else if (avgCre >=Integer.parseInt(setCreGrade.getString(12))){ com = setComments.getString(10);}else if (avgCre >=Integer.parseInt(setCreGrade.getString(13))){ com = setComments.getString(11);}else if (avgCre >=Integer.parseInt(setCreGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell creD5 = new PdfPCell(new Paragraph(setE3.getString(32)+" "+setE3.getString(33)));
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
                PdfPCell busD3 = new PdfPCell(new Paragraph(" "));
                PdfPCell busD4 = new PdfPCell(new Paragraph(setE3.getString(35)+" "+setE3.getString(36)));

                int avgBus = Integer.parseInt(setE3.getString(35));
                if (avgBus >= Integer.parseInt(setBusGrade.getString(4))) {com = setComments.getString(2); } else if (avgBus >= Integer.parseInt(setBusGrade.getString(5))) { com = setComments.getString(3); }else if (avgBus >=Integer.parseInt(setBusGrade.getString(6))){ com = setComments.getString(4);}else if (avgBus >=Integer.parseInt(setBusGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgBus >=Integer.parseInt(setBusGrade.getString(8))){  com = setComments.getString(6); }else if (avgBus >=Integer.parseInt(setBusGrade.getString(9))){ com = setComments.getString(7); }else if (avgBus >=Integer.parseInt(setBusGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgBus >=Integer.parseInt(setBusGrade.getString(11))){ com = setComments.getString(9);}else if (avgBus >=Integer.parseInt(setBusGrade.getString(12))){ com = setComments.getString(10);}else if (avgBus >=Integer.parseInt(setBusGrade.getString(13))){ com = setComments.getString(11);}else if (avgBus >=Integer.parseInt(setBusGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell busD5 = new PdfPCell(new Paragraph(setE3.getString(35)+" "+setE3.getString(36)));
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
                
                int totalE3 = Integer.parseInt(setE3.getString(41));
                int totalAvg = Integer.parseInt(setE3.getString(41));


                PdfPCell totalD1 = new PdfPCell(new Paragraph("Total"));
                PdfPCell totalD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell totalD3 = new PdfPCell(new Paragraph(" "));
                PdfPCell totalD4 = new PdfPCell(new Paragraph(String.valueOf(totalE3)));
                PdfPCell totalD5 = new PdfPCell(new Paragraph(String.valueOf(totalAvg)));
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

               
                //int add2AvgEx2 = (Math.addExact(totalEx2Mat,addAvgEx2))/3;

                int addAvgEx3 = Math.round(totalE3/7);
                //int add2AvgEx3 = (Math.addExact(totalEx3Mat,addAvgEx3))/3;

                
                PdfPCell avgD1 = new PdfPCell(new Paragraph("Average"));
                PdfPCell avgD2 = new PdfPCell(new Paragraph(" "));
                
                PdfPCell avgD3 = new PdfPCell(new Paragraph(" "));

                if (addAvgEx3 >= Integer.parseInt(setTotal.getString(4))) {g = "A"; } else if (addAvgEx3 >= Integer.parseInt(setTotal.getString(5))) { g = "A-"; }else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(6))){ g = "B+";}else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(7))){
                    g = "B"; }else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(8))){  g = "B-"; }else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(9))){ g = "C+"; }else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(10))){ g = "C";
                }else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(11))){ g = "C-";}else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(12))){ g = "D+";}else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(13))){ g = "D";}else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(14))){
                    g = "D-";}else {g="E"; }
                PdfPCell avgD4 = new PdfPCell(new Paragraph(String.valueOf(addAvgEx3)+" "+setE3.getString(42)));

                //float avgAvgTotal = (addAvgEx1+addAvgEx2+addAvgEx3)/3;
                int avgAvgTotal=Integer.parseInt(setE3.getString(41))/7;

                if (avgAvgTotal >= Integer.parseInt(setTotal.getString(4))) {g = "A"; } else if (avgAvgTotal >= Integer.parseInt(setTotal.getString(5))) { g = "A-"; }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(6))){ g = "B+";}else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(7))){
                    g = "B"; }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(8))){  g = "B-"; }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(9))){ g = "C+"; }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(10))){ g = "C";
                }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(11))){ g = "C-";}else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(12))){ g = "D+";}else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(13))){ g = "D";}else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(14))){
                    g = "D-";}else {g="E"; }

                PdfPCell avgD5 = new PdfPCell(new Paragraph(String.valueOf(Math.round(avgAvgTotal))+" "+setE3.getString(42)));
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
                PdfPCell f1t1m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF1T1E3.getString(30)))/11)+" "+setF1T1E3.getString(31)));
                PdfPCell f2t1 = new PdfPCell(new Paragraph("F2T1"));
                PdfPCell f2t1m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF2T1E3.getString(30)))/11)+" "+setF2T1E3.getString(31)));
                PdfPCell f3t1 = new PdfPCell(new Paragraph("F3T1"));
                PdfPCell f3t1m = new PdfPCell(new Paragraph(String.valueOf(Integer.parseInt(setF3T1E3.getString(41))/11)+" "+setF3T1E3.getString(43)+" "+setF3T1E3.getString(42)));
                PdfPCell f4t1 = new PdfPCell(new Paragraph("F4T1"));
                PdfPCell f4t1m = new PdfPCell(new Paragraph(String.valueOf(avgAvgTotal)+" "+setE3.getString(42)+" "+setE3.getString(43)));
                tableLastSummary.addCell(f1t1);
                tableLastSummary.addCell(f1t1m);
                tableLastSummary.addCell(f2t1);
                tableLastSummary.addCell(f2t1m);
                tableLastSummary.addCell(f3t1);
                tableLastSummary.addCell(f3t1m);
                tableLastSummary.addCell(f4t1);
                tableLastSummary.addCell(f4t1m);

                PdfPCell f1t2 = new PdfPCell(new Paragraph("F1T2"));
                PdfPCell f1t2m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF1T2E3.getString(30)))/11)+" "+setF1T2E3.getString(31)));
                PdfPCell f2t2 = new PdfPCell(new Paragraph("F2T2"));
                PdfPCell f2t2m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF2T2E3.getString(30)))/11)+" "+setF2T2E3.getString(31)));
                PdfPCell f3t2 = new PdfPCell(new Paragraph("F3T2"));
                PdfPCell f3t2m = new PdfPCell(new Paragraph(String.valueOf(Integer.parseInt(setF3T2E3.getString(41))/11)+" "+setF3T2E3.getString(43)+" "+setF3T2E3.getString(42)));
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
                PdfPCell f1t3m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF1T3E3.getString(30)))/11)+" "+setF1T3E3.getString(31)));
                PdfPCell f2t3 = new PdfPCell(new Paragraph("F2T3"));
                PdfPCell f2t3m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF2T3E3.getString(30)))/11)+" "+setF2T3E3.getString(31)));
                PdfPCell f3t3 = new PdfPCell(new Paragraph("F3T3"));
                PdfPCell f3t3m = new PdfPCell(new Paragraph(String.valueOf(Integer.parseInt(setF3T3E3.getString(41))/11)+" "+setF3T3E3.getString(43)+" "+setF3T3E3.getString(42)));
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
               dataSet.setValue((Integer.parseInt(setF1T1E3.getString(30))/11)/7, "Marks", "F1T1");
                dataSet.setValue((Integer.parseInt(setF1T2E3.getString(30))/11)/7, "Marks", "F1T2");
                dataSet.setValue((Integer.parseInt(setF1T3E3.getString(30))/11)/7, "Marks", "F1T3");
                dataSet.setValue((Integer.parseInt(setF2T1E3.getString(30))/11)/7, "Marks", "F2T1");
                dataSet.setValue((Integer.parseInt(setF2T2E3.getString(30))/11)/7, "Marks", "F2T2");
                dataSet.setValue((Integer.parseInt(setF2T3E3.getString(30))/11)/7, "Marks", "F2T3");
                dataSet.setValue(Float.parseFloat(setF3T1E3.getString(43)), "Marks", "F3T1");
                dataSet.setValue(Float.parseFloat(setF3T2E3.getString(43)), "Marks", "F3T2");
                dataSet.setValue(Float.parseFloat(setF3T3E3.getString(43)), "Marks", "F3T3");
              dataSet.setValue(Float.parseFloat(setE3.getString(43)), "Marks", "F4T1");
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
                 document.newPage();
                connection.close();

            }catch (Exception e){
                e.printStackTrace();
                infoBoxError("An error occurred " + e,"Error",null);
            }}else {
            infoBoxError("You are not allowed to print","Error",null);
        }
    }

    private void printBioHisAgri(String adm, Document document, PdfWriter writer, int pos, String totalStudents) {
        if(printPassword.toString().equals("vic")) {
            String sqlDetails="SELECT * FROM tbl_students WHERE adm=?";
            String sqlComm = "SELECT * FROM tbl_comments";
            String sqlTotal ="SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='TOTAL'";
            
            String sqlEx3 = "SELECT * FROM tbl_f4_t1_ex3 WHERE adm=? ";
             String sqlF1T1Ex3 = "SELECT * FROM tbl_f1_t1_ex3 WHERE adm=?";
            String sqlF1T2Ex3 = "SELECT * FROM tbl_f1_t2_ex3 WHERE adm=?";
            String sqlF1T3Ex3 = "SELECT * FROM tbl_f1_t3_ex3 WHERE adm=?";
            String sqlF2T1Ex3 = "SELECT * FROM tbl_f2_t1_ex3 WHERE adm=?";
            String sqlF2T2Ex3 = "SELECT * FROM tbl_f2_t2_ex3 WHERE adm=?";
            String sqlF2T3Ex3 = "SELECT * FROM tbl_f2_t3_ex3 WHERE adm=?";
            String sqlF3T1Ex3 = "SELECT * FROM tbl_f3_t1_ex3 WHERE adm=?";
            String sqlF3T2Ex3 = "SELECT * FROM tbl_f3_t2_ex3 WHERE adm=?";
            String sqlF3T3Ex3 = "SELECT * FROM tbl_f3_t3_ex3 WHERE adm=?";
            

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
                
                PreparedStatement statementE3 = connection.prepareStatement(sqlEx3);
                PreparedStatement statementF1T1E3 = connection.prepareStatement(sqlF1T1Ex3);
                PreparedStatement statementF1T2E3 = connection.prepareStatement(sqlF1T2Ex3);
                PreparedStatement statementF1T3E3 = connection.prepareStatement(sqlF1T3Ex3);
                PreparedStatement statementF2T1E3 = connection.prepareStatement(sqlF2T1Ex3);
                PreparedStatement statementF2T2E3 = connection.prepareStatement(sqlF2T2Ex3);
                PreparedStatement statementF2T3E3 = connection.prepareStatement(sqlF2T3Ex3);
                PreparedStatement statementF3T1E3 = connection.prepareStatement(sqlF3T1Ex3);
                PreparedStatement statementF3T2E3 = connection.prepareStatement(sqlF3T2Ex3);
                PreparedStatement statementF3T3E3 = connection.prepareStatement(sqlF3T3Ex3);
                


                statement.setString(1,adm);
                
                statementE3.setString(1,adm);
                statementF1T1E3.setString(1,adm);
                statementF1T2E3.setString(1,adm);
                statementF1T3E3.setString(1,adm);
                statementF2T1E3.setString(1,adm);
                statementF2T2E3.setString(1,adm);
                statementF2T3E3.setString(1,adm);
                statementF3T1E3.setString(1,adm);
                statementF3T2E3.setString(1,adm);
                statementF3T3E3.setString(1,adm);
                

                ResultSet set = statement.executeQuery();
                
                ResultSet setE3 = statementE3.executeQuery();
                 ResultSet setF1T1E3 = statementF1T1E3.executeQuery();
                ResultSet setF1T2E3 = statementF1T2E3.executeQuery();
                ResultSet setF1T3E3 = statementF1T3E3.executeQuery();
                ResultSet setF2T1E3 = statementF2T1E3.executeQuery();
                ResultSet setF2T2E3 = statementF2T2E3.executeQuery();
                ResultSet setF2T3E3 = statementF2T3E3.executeQuery();
                ResultSet setF3T1E3 = statementF3T1E3.executeQuery();
                ResultSet setF3T2E3 = statementF3T2E3.executeQuery();
                ResultSet setF3T3E3 = statementF3T3E3.executeQuery();
                

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

                document.add((new Paragraph("ADM: "+set.getString(2)+"  "+"NAME: "+set.getString(3)+"   "+set.getString(4)+" "+set.getString(5)+"  "+"KCPE:"+set.getString(6)+"  "+"CLASS:FORM 4"+"  "+"TERM:TERM 1",new Font(Font.FontFamily.TIMES_ROMAN, 9,Font.BOLD))));
                document.add((new Paragraph("YEAR:"+now.get(Calendar.YEAR)+" "+"POS:"+String.valueOf(pos)+" "+"OUT OF "+totalStudents,new Font(Font.FontFamily.TIMES_ROMAN, 9,Font.BOLD))));
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
                PdfPCell engD3 = new PdfPCell(new Paragraph(" "));
                PdfPCell engD4 = new PdfPCell(new Paragraph(setE3.getString(8)+" "+setE3.getString(9)));

                int avgE= Integer.parseInt(setE3.getString(8));
                if (avgE >= Integer.parseInt(setEngGrade.getString(4))) {com = setComments.getString(2); } else if (avgE >= Integer.parseInt(setEngGrade.getString(5))) { com = setComments.getString(3); }else if (avgE >=Integer.parseInt(setEngGrade.getString(6))){ com = setComments.getString(4);}else if (avgE >=Integer.parseInt(setEngGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgE >=Integer.parseInt(setEngGrade.getString(8))){  com = setComments.getString(6); }else if (avgE >=Integer.parseInt(setEngGrade.getString(9))){ com = setComments.getString(7); }else if (avgE >=Integer.parseInt(setEngGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgE >=Integer.parseInt(setEngGrade.getString(11))){ com = setComments.getString(9);}else if (avgE >=Integer.parseInt(setEngGrade.getString(12))){ com = setComments.getString(10);}else if (avgE >=Integer.parseInt(setEngGrade.getString(13))){ com = setComments.getString(11);}else if (avgE >=Integer.parseInt(setEngGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }
                PdfPCell engD5 = new PdfPCell(new Paragraph(setE3.getString(8)+" "+setE3.getString(9)));
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
                PdfPCell kisD3 = new PdfPCell(new Paragraph(" "));
                PdfPCell kisD4 = new PdfPCell(new Paragraph(setE3.getString(11)+" "+setE3.getString(12)));

                int avgKis= Integer.parseInt(setE3.getString(11));
                if (avgKis >= Integer.parseInt(setKisGrade.getString(4))) {com = setComments.getString(2); } else if (avgKis >= Integer.parseInt(setKisGrade.getString(5))) { com = setComments.getString(3); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(6))){ com = setComments.getString(4);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(8))){  com = setComments.getString(6); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(9))){ com = setComments.getString(7); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgKis >=Integer.parseInt(setKisGrade.getString(11))){ com = setComments.getString(9);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(12))){ com = setComments.getString(10);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(13))){ com = setComments.getString(11);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }
                PdfPCell kisD5 = new PdfPCell(new Paragraph(setE3.getString(11)+" "+setE3.getString(12)));
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
                PdfPCell matD3 = new PdfPCell(new Paragraph(" "));
                PdfPCell matD4 = new PdfPCell(new Paragraph(setE3.getString(14)+" "+setE3.getString(15)));

                int avgMat = Integer.parseInt(setE3.getString(14));
                if (avgMat >= Integer.parseInt(setMatGrade.getString(4))) {com = setComments.getString(2); } else if (avgMat >= Integer.parseInt(setMatGrade.getString(5))) { com = setComments.getString(3); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(6))){ com = setComments.getString(4);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(8))){  com = setComments.getString(6); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(9))){ com = setComments.getString(7); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgMat >=Integer.parseInt(setMatGrade.getString(11))){ com = setComments.getString(9);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(12))){ com = setComments.getString(10);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(13))){ com = setComments.getString(11);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell matD5 = new PdfPCell(new Paragraph(setE3.getString(14)+" "+setE3.getString(15)));
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
                PdfPCell chemD3 = new PdfPCell(new Paragraph(" "));
                PdfPCell chemD4 = new PdfPCell(new Paragraph(setE3.getString(20)+" "+setE3.getString(21)));

                int avgChem = Integer.parseInt(setE3.getString(20));
                if (avgChem >= Integer.parseInt(setChemGrade.getString(4))) {com = setComments.getString(2); } else if (avgChem >= Integer.parseInt(setChemGrade.getString(5))) { com = setComments.getString(3); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(6))){ com = setComments.getString(4);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(8))){  com = setComments.getString(6); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(9))){ com = setComments.getString(7); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgChem >=Integer.parseInt(setChemGrade.getString(11))){ com = setComments.getString(9);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(12))){ com = setComments.getString(10);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(13))){ com = setComments.getString(11);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell chemD5 = new PdfPCell(new Paragraph(setE3.getString(20)+" "+setE3.getString(21)));
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
                PdfPCell bioD3 = new PdfPCell(new Paragraph(" "));
                PdfPCell bioD4 = new PdfPCell(new Paragraph(setE3.getString(17)+" "+setE3.getString(18)));

                int avgBio = Integer.parseInt(setE3.getString(17));
                if (avgBio >= Integer.parseInt(setBioGrade.getString(4))) {com = setComments.getString(2); } else if (avgBio >= Integer.parseInt(setBioGrade.getString(5))) { com = setComments.getString(3); }else if (avgBio >=Integer.parseInt(setBioGrade.getString(6))){ com = setComments.getString(4);}else if (avgBio >=Integer.parseInt(setBioGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgBio >=Integer.parseInt(setBioGrade.getString(8))){  com = setComments.getString(6); }else if (avgBio >=Integer.parseInt(setBioGrade.getString(9))){ com = setComments.getString(7); }else if (avgBio >=Integer.parseInt(setBioGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgBio >=Integer.parseInt(setBioGrade.getString(11))){ com = setComments.getString(9);}else if (avgBio >=Integer.parseInt(setBioGrade.getString(12))){ com = setComments.getString(10);}else if (avgBio >=Integer.parseInt(setBioGrade.getString(13))){ com = setComments.getString(11);}else if (avgBio >=Integer.parseInt(setBioGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell bioD5 = new PdfPCell(new Paragraph(setE3.getString(17)+" "+setE3.getString(18)));
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
                PdfPCell hisD3 = new PdfPCell(new Paragraph(" "));
                PdfPCell hisD4 = new PdfPCell(new Paragraph(setE3.getString(29)+" "+setE3.getString(30)));

                int avgHis = Integer.parseInt(setE3.getString(29));
                if (avgHis >= Integer.parseInt(setHisGrade.getString(4))) {com = setComments.getString(2); } else if (avgHis >= Integer.parseInt(setHisGrade.getString(5))) { com = setComments.getString(3); }else if (avgHis >=Integer.parseInt(setHisGrade.getString(6))){ com = setComments.getString(4);}else if (avgHis >=Integer.parseInt(setHisGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgHis >=Integer.parseInt(setHisGrade.getString(8))){  com = setComments.getString(6); }else if (avgHis >=Integer.parseInt(setHisGrade.getString(9))){ com = setComments.getString(7); }else if (avgHis >=Integer.parseInt(setHisGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgHis >=Integer.parseInt(setHisGrade.getString(11))){ com = setComments.getString(9);}else if (avgHis >=Integer.parseInt(setHisGrade.getString(12))){ com = setComments.getString(10);}else if (avgHis >=Integer.parseInt(setHisGrade.getString(13))){ com = setComments.getString(11);}else if (avgHis >=Integer.parseInt(setHisGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell hisD5 = new PdfPCell(new Paragraph(setE3.getString(29)+" "+setE3.getString(30)));
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
                PdfPCell agriD3 = new PdfPCell(new Paragraph(" "));
                PdfPCell agriD4 = new PdfPCell(new Paragraph(setE3.getString(38)+" "+setE3.getString(39)));

                int avgAgri = Integer.parseInt(setE3.getString(38));
                if (avgAgri >= Integer.parseInt(setAgriGrade.getString(4))) {com = setComments.getString(2); } else if (avgAgri >= Integer.parseInt(setAgriGrade.getString(5))) { com = setComments.getString(3); }else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(6))){ com = setComments.getString(4);}else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(8))){  com = setComments.getString(6); }else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(9))){ com = setComments.getString(7); }else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(11))){ com = setComments.getString(9);}else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(12))){ com = setComments.getString(10);}else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(13))){ com = setComments.getString(11);}else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell agriD5 = new PdfPCell(new Paragraph(setE3.getString(38)+" "+setE3.getString(39)));
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
                
                int totalE3 = Integer.parseInt(setE3.getString(41));
                int totalAvg = Integer.parseInt(setE3.getString(41));


                PdfPCell totalD1 = new PdfPCell(new Paragraph("Total"));
                PdfPCell totalD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell totalD3 = new PdfPCell(new Paragraph(" "));
                PdfPCell totalD4 = new PdfPCell(new Paragraph(String.valueOf(totalE3)));
                PdfPCell totalD5 = new PdfPCell(new Paragraph(String.valueOf(totalAvg)));
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

               
                //int add2AvgEx2 = (Math.addExact(totalEx2Mat,addAvgEx2))/3;

                int addAvgEx3 = Math.round(totalE3/7);
                //int add2AvgEx3 = (Math.addExact(totalEx3Mat,addAvgEx3))/3;

                
                PdfPCell avgD1 = new PdfPCell(new Paragraph("Average"));
                PdfPCell avgD2 = new PdfPCell(new Paragraph(" "));
                
                PdfPCell avgD3 = new PdfPCell(new Paragraph(" "));

                if (addAvgEx3 >= Integer.parseInt(setTotal.getString(4))) {g = "A"; } else if (addAvgEx3 >= Integer.parseInt(setTotal.getString(5))) { g = "A-"; }else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(6))){ g = "B+";}else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(7))){
                    g = "B"; }else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(8))){  g = "B-"; }else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(9))){ g = "C+"; }else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(10))){ g = "C";
                }else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(11))){ g = "C-";}else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(12))){ g = "D+";}else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(13))){ g = "D";}else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(14))){
                    g = "D-";}else {g="E"; }
                PdfPCell avgD4 = new PdfPCell(new Paragraph(String.valueOf(addAvgEx3)+" "+setE3.getString(42)));

                //float avgAvgTotal = (addAvgEx1+addAvgEx2+addAvgEx3)/3;
                int avgAvgTotal=Integer.parseInt(setE3.getString(41))/7;

                if (avgAvgTotal >= Integer.parseInt(setTotal.getString(4))) {g = "A"; } else if (avgAvgTotal >= Integer.parseInt(setTotal.getString(5))) { g = "A-"; }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(6))){ g = "B+";}else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(7))){
                    g = "B"; }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(8))){  g = "B-"; }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(9))){ g = "C+"; }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(10))){ g = "C";
                }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(11))){ g = "C-";}else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(12))){ g = "D+";}else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(13))){ g = "D";}else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(14))){
                    g = "D-";}else {g="E"; }

                PdfPCell avgD5 = new PdfPCell(new Paragraph(String.valueOf(Math.round(avgAvgTotal))+" "+setE3.getString(42)));
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
                PdfPCell f1t1m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF1T1E3.getString(30)))/11)+" "+setF1T1E3.getString(31)));
                PdfPCell f2t1 = new PdfPCell(new Paragraph("F2T1"));
                PdfPCell f2t1m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF2T1E3.getString(30)))/11)+" "+setF2T1E3.getString(31)));
                PdfPCell f3t1 = new PdfPCell(new Paragraph("F3T1"));
                PdfPCell f3t1m = new PdfPCell(new Paragraph(String.valueOf(Integer.parseInt(setF3T1E3.getString(41))/11)+" "+setF3T1E3.getString(43)+" "+setF3T1E3.getString(42)));
                PdfPCell f4t1 = new PdfPCell(new Paragraph("F4T1"));
                PdfPCell f4t1m = new PdfPCell(new Paragraph(String.valueOf(avgAvgTotal)+" "+setE3.getString(42)+" "+setE3.getString(43)));
                tableLastSummary.addCell(f1t1);
                tableLastSummary.addCell(f1t1m);
                tableLastSummary.addCell(f2t1);
                tableLastSummary.addCell(f2t1m);
                tableLastSummary.addCell(f3t1);
                tableLastSummary.addCell(f3t1m);
                tableLastSummary.addCell(f4t1);
                tableLastSummary.addCell(f4t1m);

                PdfPCell f1t2 = new PdfPCell(new Paragraph("F1T2"));
                PdfPCell f1t2m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF1T2E3.getString(30)))/11)+" "+setF1T2E3.getString(31)));
                PdfPCell f2t2 = new PdfPCell(new Paragraph("F2T2"));
                PdfPCell f2t2m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF2T2E3.getString(30)))/11)+" "+setF2T2E3.getString(31)));
                PdfPCell f3t2 = new PdfPCell(new Paragraph("F3T2"));
                PdfPCell f3t2m = new PdfPCell(new Paragraph(String.valueOf(Integer.parseInt(setF3T2E3.getString(41))/11)+" "+setF3T2E3.getString(43)+" "+setF3T2E3.getString(42)));
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
                PdfPCell f1t3m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF1T3E3.getString(30)))/11)+" "+setF1T3E3.getString(31)));
                PdfPCell f2t3 = new PdfPCell(new Paragraph("F2T3"));
                PdfPCell f2t3m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF2T3E3.getString(30)))/11)+" "+setF2T3E3.getString(31)));
                PdfPCell f3t3 = new PdfPCell(new Paragraph("F3T3"));
                PdfPCell f3t3m = new PdfPCell(new Paragraph(String.valueOf(Integer.parseInt(setF3T3E3.getString(41))/11)+" "+setF3T3E3.getString(43)+" "+setF3T3E3.getString(42)));
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
               dataSet.setValue((Integer.parseInt(setF1T1E3.getString(30))/11)/7, "Marks", "F1T1");
                dataSet.setValue((Integer.parseInt(setF1T2E3.getString(30))/11)/7, "Marks", "F1T2");
                dataSet.setValue((Integer.parseInt(setF1T3E3.getString(30))/11)/7, "Marks", "F1T3");
                dataSet.setValue((Integer.parseInt(setF2T1E3.getString(30))/11)/7, "Marks", "F2T1");
                dataSet.setValue((Integer.parseInt(setF2T2E3.getString(30))/11)/7, "Marks", "F2T2");
                dataSet.setValue((Integer.parseInt(setF2T3E3.getString(30))/11)/7, "Marks", "F2T3");
                dataSet.setValue(Float.parseFloat(setF3T1E3.getString(43)), "Marks", "F3T1");
                dataSet.setValue(Float.parseFloat(setF3T2E3.getString(43)), "Marks", "F3T2");
                dataSet.setValue(Float.parseFloat(setF3T3E3.getString(43)), "Marks", "F3T3");
              dataSet.setValue(Float.parseFloat(setE3.getString(43)), "Marks", "F4T1");
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
                 document.newPage();
                connection.close();

            }catch (Exception e){
                e.printStackTrace();
                infoBoxError("An error occurred " + e,"Error",null);
            }}else {
            infoBoxError("You are not allowed to print","Error",null);
        }
    }

    private void printBioHisBus(String adm, Document document, PdfWriter writer, int pos, String totalStudents) {
        if(printPassword.toString().equals("vic")) {
            String sqlDetails="SELECT * FROM tbl_students WHERE adm=?";
            String sqlComm = "SELECT * FROM tbl_comments";
            String sqlTotal ="SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='TOTAL'";
            
            String sqlEx3 = "SELECT * FROM tbl_f4_t1_ex3 WHERE adm=? ";
             String sqlF1T1Ex3 = "SELECT * FROM tbl_f1_t1_ex3 WHERE adm=?";
            String sqlF1T2Ex3 = "SELECT * FROM tbl_f1_t2_ex3 WHERE adm=?";
            String sqlF1T3Ex3 = "SELECT * FROM tbl_f1_t3_ex3 WHERE adm=?";
            String sqlF2T1Ex3 = "SELECT * FROM tbl_f2_t1_ex3 WHERE adm=?";
            String sqlF2T2Ex3 = "SELECT * FROM tbl_f2_t2_ex3 WHERE adm=?";
            String sqlF2T3Ex3 = "SELECT * FROM tbl_f2_t3_ex3 WHERE adm=?";
            String sqlF3T1Ex3 = "SELECT * FROM tbl_f3_t1_ex3 WHERE adm=?";
            String sqlF3T2Ex3 = "SELECT * FROM tbl_f3_t2_ex3 WHERE adm=?";
            String sqlF3T3Ex3 = "SELECT * FROM tbl_f3_t3_ex3 WHERE adm=?";
            

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
                
                PreparedStatement statementE3 = connection.prepareStatement(sqlEx3);
                PreparedStatement statementF1T1E3 = connection.prepareStatement(sqlF1T1Ex3);
                PreparedStatement statementF1T2E3 = connection.prepareStatement(sqlF1T2Ex3);
                PreparedStatement statementF1T3E3 = connection.prepareStatement(sqlF1T3Ex3);
                PreparedStatement statementF2T1E3 = connection.prepareStatement(sqlF2T1Ex3);
                PreparedStatement statementF2T2E3 = connection.prepareStatement(sqlF2T2Ex3);
                PreparedStatement statementF2T3E3 = connection.prepareStatement(sqlF2T3Ex3);
                PreparedStatement statementF3T1E3 = connection.prepareStatement(sqlF3T1Ex3);
                PreparedStatement statementF3T2E3 = connection.prepareStatement(sqlF3T2Ex3);
                PreparedStatement statementF3T3E3 = connection.prepareStatement(sqlF3T3Ex3);
                


                statement.setString(1,adm);
                
                statementE3.setString(1,adm);
                statementF1T1E3.setString(1,adm);
                statementF1T2E3.setString(1,adm);
                statementF1T3E3.setString(1,adm);
                statementF2T1E3.setString(1,adm);
                statementF2T2E3.setString(1,adm);
                statementF2T3E3.setString(1,adm);
                statementF3T1E3.setString(1,adm);
                statementF3T2E3.setString(1,adm);
                statementF3T3E3.setString(1,adm);
                

                ResultSet set = statement.executeQuery();
                
                ResultSet setE3 = statementE3.executeQuery();
                 ResultSet setF1T1E3 = statementF1T1E3.executeQuery();
                ResultSet setF1T2E3 = statementF1T2E3.executeQuery();
                ResultSet setF1T3E3 = statementF1T3E3.executeQuery();
                ResultSet setF2T1E3 = statementF2T1E3.executeQuery();
                ResultSet setF2T2E3 = statementF2T2E3.executeQuery();
                ResultSet setF2T3E3 = statementF2T3E3.executeQuery();
                ResultSet setF3T1E3 = statementF3T1E3.executeQuery();
                ResultSet setF3T2E3 = statementF3T2E3.executeQuery();
                ResultSet setF3T3E3 = statementF3T3E3.executeQuery();
                

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

                document.add((new Paragraph("ADM: "+set.getString(2)+"  "+"NAME: "+set.getString(3)+"   "+set.getString(4)+" "+set.getString(5)+"  "+"KCPE:"+set.getString(6)+"  "+"CLASS:FORM 4"+"  "+"TERM:TERM 1",new Font(Font.FontFamily.TIMES_ROMAN, 9,Font.BOLD))));
                document.add((new Paragraph("YEAR:"+now.get(Calendar.YEAR)+" "+"POS:"+String.valueOf(pos)+" "+"OUT OF "+totalStudents,new Font(Font.FontFamily.TIMES_ROMAN, 9,Font.BOLD))));
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
                PdfPCell engD3 = new PdfPCell(new Paragraph(" "));
                PdfPCell engD4 = new PdfPCell(new Paragraph(setE3.getString(8)+" "+setE3.getString(9)));

                int avgE= Integer.parseInt(setE3.getString(8));
                if (avgE >= Integer.parseInt(setEngGrade.getString(4))) {com = setComments.getString(2); } else if (avgE >= Integer.parseInt(setEngGrade.getString(5))) { com = setComments.getString(3); }else if (avgE >=Integer.parseInt(setEngGrade.getString(6))){ com = setComments.getString(4);}else if (avgE >=Integer.parseInt(setEngGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgE >=Integer.parseInt(setEngGrade.getString(8))){  com = setComments.getString(6); }else if (avgE >=Integer.parseInt(setEngGrade.getString(9))){ com = setComments.getString(7); }else if (avgE >=Integer.parseInt(setEngGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgE >=Integer.parseInt(setEngGrade.getString(11))){ com = setComments.getString(9);}else if (avgE >=Integer.parseInt(setEngGrade.getString(12))){ com = setComments.getString(10);}else if (avgE >=Integer.parseInt(setEngGrade.getString(13))){ com = setComments.getString(11);}else if (avgE >=Integer.parseInt(setEngGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }
                PdfPCell engD5 = new PdfPCell(new Paragraph(setE3.getString(8)+" "+setE3.getString(9)));
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
                PdfPCell kisD3 = new PdfPCell(new Paragraph(" "));
                PdfPCell kisD4 = new PdfPCell(new Paragraph(setE3.getString(11)+" "+setE3.getString(12)));

                int avgKis= Integer.parseInt(setE3.getString(11));
                if (avgKis >= Integer.parseInt(setKisGrade.getString(4))) {com = setComments.getString(2); } else if (avgKis >= Integer.parseInt(setKisGrade.getString(5))) { com = setComments.getString(3); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(6))){ com = setComments.getString(4);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(8))){  com = setComments.getString(6); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(9))){ com = setComments.getString(7); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgKis >=Integer.parseInt(setKisGrade.getString(11))){ com = setComments.getString(9);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(12))){ com = setComments.getString(10);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(13))){ com = setComments.getString(11);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }
                PdfPCell kisD5 = new PdfPCell(new Paragraph(setE3.getString(11)+" "+setE3.getString(12)));
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
                PdfPCell matD3 = new PdfPCell(new Paragraph(" "));
                PdfPCell matD4 = new PdfPCell(new Paragraph(setE3.getString(14)+" "+setE3.getString(15)));

                int avgMat = Integer.parseInt(setE3.getString(14));
                if (avgMat >= Integer.parseInt(setMatGrade.getString(4))) {com = setComments.getString(2); } else if (avgMat >= Integer.parseInt(setMatGrade.getString(5))) { com = setComments.getString(3); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(6))){ com = setComments.getString(4);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(8))){  com = setComments.getString(6); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(9))){ com = setComments.getString(7); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgMat >=Integer.parseInt(setMatGrade.getString(11))){ com = setComments.getString(9);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(12))){ com = setComments.getString(10);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(13))){ com = setComments.getString(11);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell matD5 = new PdfPCell(new Paragraph(setE3.getString(14)+" "+setE3.getString(15)));
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
                PdfPCell chemD3 = new PdfPCell(new Paragraph(" "));
                PdfPCell chemD4 = new PdfPCell(new Paragraph(setE3.getString(20)+" "+setE3.getString(21)));

                int avgChem = Integer.parseInt(setE3.getString(20));
                if (avgChem >= Integer.parseInt(setChemGrade.getString(4))) {com = setComments.getString(2); } else if (avgChem >= Integer.parseInt(setChemGrade.getString(5))) { com = setComments.getString(3); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(6))){ com = setComments.getString(4);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(8))){  com = setComments.getString(6); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(9))){ com = setComments.getString(7); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgChem >=Integer.parseInt(setChemGrade.getString(11))){ com = setComments.getString(9);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(12))){ com = setComments.getString(10);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(13))){ com = setComments.getString(11);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell chemD5 = new PdfPCell(new Paragraph(setE3.getString(20)+" "+setE3.getString(21)));
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
                PdfPCell bioD3 = new PdfPCell(new Paragraph(" "));
                PdfPCell bioD4 = new PdfPCell(new Paragraph(setE3.getString(17)+" "+setE3.getString(18)));

                int avgBio = Integer.parseInt(setE3.getString(17));
                if (avgBio >= Integer.parseInt(setBioGrade.getString(4))) {com = setComments.getString(2); } else if (avgBio >= Integer.parseInt(setBioGrade.getString(5))) { com = setComments.getString(3); }else if (avgBio >=Integer.parseInt(setBioGrade.getString(6))){ com = setComments.getString(4);}else if (avgBio >=Integer.parseInt(setBioGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgBio >=Integer.parseInt(setBioGrade.getString(8))){  com = setComments.getString(6); }else if (avgBio >=Integer.parseInt(setBioGrade.getString(9))){ com = setComments.getString(7); }else if (avgBio >=Integer.parseInt(setBioGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgBio >=Integer.parseInt(setBioGrade.getString(11))){ com = setComments.getString(9);}else if (avgBio >=Integer.parseInt(setBioGrade.getString(12))){ com = setComments.getString(10);}else if (avgBio >=Integer.parseInt(setBioGrade.getString(13))){ com = setComments.getString(11);}else if (avgBio >=Integer.parseInt(setBioGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell bioD5 = new PdfPCell(new Paragraph(setE3.getString(17)+" "+setE3.getString(18)));
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
                PdfPCell hisD3 = new PdfPCell(new Paragraph(" "));
                PdfPCell hisD4 = new PdfPCell(new Paragraph(setE3.getString(29)+" "+setE3.getString(30)));

                int avgHis = Integer.parseInt(setE3.getString(29));
                if (avgHis >= Integer.parseInt(setHisGrade.getString(4))) {com = setComments.getString(2); } else if (avgHis >= Integer.parseInt(setHisGrade.getString(5))) { com = setComments.getString(3); }else if (avgHis >=Integer.parseInt(setHisGrade.getString(6))){ com = setComments.getString(4);}else if (avgHis >=Integer.parseInt(setHisGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgHis >=Integer.parseInt(setHisGrade.getString(8))){  com = setComments.getString(6); }else if (avgHis >=Integer.parseInt(setHisGrade.getString(9))){ com = setComments.getString(7); }else if (avgHis >=Integer.parseInt(setHisGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgHis >=Integer.parseInt(setHisGrade.getString(11))){ com = setComments.getString(9);}else if (avgHis >=Integer.parseInt(setHisGrade.getString(12))){ com = setComments.getString(10);}else if (avgHis >=Integer.parseInt(setHisGrade.getString(13))){ com = setComments.getString(11);}else if (avgHis >=Integer.parseInt(setHisGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell hisD5 = new PdfPCell(new Paragraph(setE3.getString(29)+" "+setE3.getString(30)));
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
                PdfPCell busD3 = new PdfPCell(new Paragraph(" "));
                PdfPCell busD4 = new PdfPCell(new Paragraph(setE3.getString(35)+" "+setE3.getString(36)));

                int avgBus = Integer.parseInt(setE3.getString(35));
                if (avgBus >= Integer.parseInt(setBusGrade.getString(4))) {com = setComments.getString(2); } else if (avgBus >= Integer.parseInt(setBusGrade.getString(5))) { com = setComments.getString(3); }else if (avgBus >=Integer.parseInt(setBusGrade.getString(6))){ com = setComments.getString(4);}else if (avgBus >=Integer.parseInt(setBusGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgBus >=Integer.parseInt(setBusGrade.getString(8))){  com = setComments.getString(6); }else if (avgBus >=Integer.parseInt(setBusGrade.getString(9))){ com = setComments.getString(7); }else if (avgBus >=Integer.parseInt(setBusGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgBus >=Integer.parseInt(setBusGrade.getString(11))){ com = setComments.getString(9);}else if (avgBus >=Integer.parseInt(setBusGrade.getString(12))){ com = setComments.getString(10);}else if (avgBus >=Integer.parseInt(setBusGrade.getString(13))){ com = setComments.getString(11);}else if (avgBus >=Integer.parseInt(setBusGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell busD5 = new PdfPCell(new Paragraph(setE3.getString(35)+" "+setE3.getString(36)));
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
                
                int totalE3 = Integer.parseInt(setE3.getString(41));
                int totalAvg = Integer.parseInt(setE3.getString(41));


                PdfPCell totalD1 = new PdfPCell(new Paragraph("Total"));
                PdfPCell totalD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell totalD3 = new PdfPCell(new Paragraph(" "));
                PdfPCell totalD4 = new PdfPCell(new Paragraph(String.valueOf(totalE3)));
                PdfPCell totalD5 = new PdfPCell(new Paragraph(String.valueOf(totalAvg)));
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

               
                //int add2AvgEx2 = (Math.addExact(totalEx2Mat,addAvgEx2))/3;

                int addAvgEx3 = Math.round(totalE3/7);
                //int add2AvgEx3 = (Math.addExact(totalEx3Mat,addAvgEx3))/3;

                
                PdfPCell avgD1 = new PdfPCell(new Paragraph("Average"));
                PdfPCell avgD2 = new PdfPCell(new Paragraph(" "));
                
                PdfPCell avgD3 = new PdfPCell(new Paragraph(" "));

                if (addAvgEx3 >= Integer.parseInt(setTotal.getString(4))) {g = "A"; } else if (addAvgEx3 >= Integer.parseInt(setTotal.getString(5))) { g = "A-"; }else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(6))){ g = "B+";}else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(7))){
                    g = "B"; }else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(8))){  g = "B-"; }else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(9))){ g = "C+"; }else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(10))){ g = "C";
                }else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(11))){ g = "C-";}else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(12))){ g = "D+";}else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(13))){ g = "D";}else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(14))){
                    g = "D-";}else {g="E"; }
                PdfPCell avgD4 = new PdfPCell(new Paragraph(String.valueOf(addAvgEx3)+" "+setE3.getString(42)));

                //float avgAvgTotal = (addAvgEx1+addAvgEx2+addAvgEx3)/3;
                int avgAvgTotal=Integer.parseInt(setE3.getString(41))/7;

                if (avgAvgTotal >= Integer.parseInt(setTotal.getString(4))) {g = "A"; } else if (avgAvgTotal >= Integer.parseInt(setTotal.getString(5))) { g = "A-"; }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(6))){ g = "B+";}else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(7))){
                    g = "B"; }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(8))){  g = "B-"; }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(9))){ g = "C+"; }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(10))){ g = "C";
                }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(11))){ g = "C-";}else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(12))){ g = "D+";}else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(13))){ g = "D";}else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(14))){
                    g = "D-";}else {g="E"; }

                PdfPCell avgD5 = new PdfPCell(new Paragraph(String.valueOf(Math.round(avgAvgTotal))+" "+setE3.getString(42)));
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
                PdfPCell f1t1m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF1T1E3.getString(30)))/11)+" "+setF1T1E3.getString(31)));
                PdfPCell f2t1 = new PdfPCell(new Paragraph("F2T1"));
                PdfPCell f2t1m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF2T1E3.getString(30)))/11)+" "+setF2T1E3.getString(31)));
                PdfPCell f3t1 = new PdfPCell(new Paragraph("F3T1"));
                PdfPCell f3t1m = new PdfPCell(new Paragraph(String.valueOf(Integer.parseInt(setF3T1E3.getString(41))/11)+" "+setF3T1E3.getString(43)+" "+setF3T1E3.getString(42)));
                PdfPCell f4t1 = new PdfPCell(new Paragraph("F4T1"));
                PdfPCell f4t1m = new PdfPCell(new Paragraph(String.valueOf(avgAvgTotal)+" "+setE3.getString(42)+" "+setE3.getString(43)));
                tableLastSummary.addCell(f1t1);
                tableLastSummary.addCell(f1t1m);
                tableLastSummary.addCell(f2t1);
                tableLastSummary.addCell(f2t1m);
                tableLastSummary.addCell(f3t1);
                tableLastSummary.addCell(f3t1m);
                tableLastSummary.addCell(f4t1);
                tableLastSummary.addCell(f4t1m);

                PdfPCell f1t2 = new PdfPCell(new Paragraph("F1T2"));
                PdfPCell f1t2m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF1T2E3.getString(30)))/11)+" "+setF1T2E3.getString(31)));
                PdfPCell f2t2 = new PdfPCell(new Paragraph("F2T2"));
                PdfPCell f2t2m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF2T2E3.getString(30)))/11)+" "+setF2T2E3.getString(31)));
                PdfPCell f3t2 = new PdfPCell(new Paragraph("F3T2"));
                PdfPCell f3t2m = new PdfPCell(new Paragraph(String.valueOf(Integer.parseInt(setF3T2E3.getString(41))/11)+" "+setF3T2E3.getString(43)+" "+setF3T2E3.getString(42)));
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
                PdfPCell f1t3m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF1T3E3.getString(30)))/11)+" "+setF1T3E3.getString(31)));
                PdfPCell f2t3 = new PdfPCell(new Paragraph("F2T3"));
                PdfPCell f2t3m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF2T3E3.getString(30)))/11)+" "+setF2T3E3.getString(31)));
                PdfPCell f3t3 = new PdfPCell(new Paragraph("F3T3"));
                PdfPCell f3t3m = new PdfPCell(new Paragraph(String.valueOf(Integer.parseInt(setF3T3E3.getString(41))/11)+" "+setF3T3E3.getString(43)+" "+setF3T3E3.getString(42)));
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
               dataSet.setValue((Integer.parseInt(setF1T1E3.getString(30))/11)/7, "Marks", "F1T1");
                dataSet.setValue((Integer.parseInt(setF1T2E3.getString(30))/11)/7, "Marks", "F1T2");
                dataSet.setValue((Integer.parseInt(setF1T3E3.getString(30))/11)/7, "Marks", "F1T3");
                dataSet.setValue((Integer.parseInt(setF2T1E3.getString(30))/11)/7, "Marks", "F2T1");
                dataSet.setValue((Integer.parseInt(setF2T2E3.getString(30))/11)/7, "Marks", "F2T2");
                dataSet.setValue((Integer.parseInt(setF2T3E3.getString(30))/11)/7, "Marks", "F2T3");
                dataSet.setValue(Float.parseFloat(setF3T1E3.getString(43)), "Marks", "F3T1");
                dataSet.setValue(Float.parseFloat(setF3T2E3.getString(43)), "Marks", "F3T2");
                dataSet.setValue(Float.parseFloat(setF3T3E3.getString(43)), "Marks", "F3T3");
              dataSet.setValue(Float.parseFloat(setE3.getString(43)), "Marks", "F4T1");
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
                 document.newPage();
                connection.close();

            }catch (Exception e){
                e.printStackTrace();
                infoBoxError("An error occurred " + e,"Error",null);
            }}else {
            infoBoxError("You are not allowed to print","Error",null);
        }
    }

    private void printBioGeoAgri(String adm, Document document, PdfWriter writer, int pos, String totalStudents) {
        if(printPassword.toString().equals("vic")) {
            String sqlDetails="SELECT * FROM tbl_students WHERE adm=?";
            String sqlComm = "SELECT * FROM tbl_comments";
            String sqlTotal ="SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='TOTAL'";
            
            String sqlEx3 = "SELECT * FROM tbl_f4_t1_ex3 WHERE adm=? ";
             String sqlF1T1Ex3 = "SELECT * FROM tbl_f1_t1_ex3 WHERE adm=?";
            String sqlF1T2Ex3 = "SELECT * FROM tbl_f1_t2_ex3 WHERE adm=?";
            String sqlF1T3Ex3 = "SELECT * FROM tbl_f1_t3_ex3 WHERE adm=?";
            String sqlF2T1Ex3 = "SELECT * FROM tbl_f2_t1_ex3 WHERE adm=?";
            String sqlF2T2Ex3 = "SELECT * FROM tbl_f2_t2_ex3 WHERE adm=?";
            String sqlF2T3Ex3 = "SELECT * FROM tbl_f2_t3_ex3 WHERE adm=?";
            String sqlF3T1Ex3 = "SELECT * FROM tbl_f3_t1_ex3 WHERE adm=?";
            String sqlF3T2Ex3 = "SELECT * FROM tbl_f3_t2_ex3 WHERE adm=?";
            String sqlF3T3Ex3 = "SELECT * FROM tbl_f3_t3_ex3 WHERE adm=?";
            

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
                
                PreparedStatement statementE3 = connection.prepareStatement(sqlEx3);
                PreparedStatement statementF1T1E3 = connection.prepareStatement(sqlF1T1Ex3);
                PreparedStatement statementF1T2E3 = connection.prepareStatement(sqlF1T2Ex3);
                PreparedStatement statementF1T3E3 = connection.prepareStatement(sqlF1T3Ex3);
                PreparedStatement statementF2T1E3 = connection.prepareStatement(sqlF2T1Ex3);
                PreparedStatement statementF2T2E3 = connection.prepareStatement(sqlF2T2Ex3);
                PreparedStatement statementF2T3E3 = connection.prepareStatement(sqlF2T3Ex3);
                PreparedStatement statementF3T1E3 = connection.prepareStatement(sqlF3T1Ex3);
                PreparedStatement statementF3T2E3 = connection.prepareStatement(sqlF3T2Ex3);
                PreparedStatement statementF3T3E3 = connection.prepareStatement(sqlF3T3Ex3);
                


                statement.setString(1,adm);
                
                statementE3.setString(1,adm);
                statementF1T1E3.setString(1,adm);
                statementF1T2E3.setString(1,adm);
                statementF1T3E3.setString(1,adm);
                statementF2T1E3.setString(1,adm);
                statementF2T2E3.setString(1,adm);
                statementF2T3E3.setString(1,adm);
                statementF3T1E3.setString(1,adm);
                statementF3T2E3.setString(1,adm);
                statementF3T3E3.setString(1,adm);
                

                ResultSet set = statement.executeQuery();
                
                ResultSet setE3 = statementE3.executeQuery();
                 ResultSet setF1T1E3 = statementF1T1E3.executeQuery();
                ResultSet setF1T2E3 = statementF1T2E3.executeQuery();
                ResultSet setF1T3E3 = statementF1T3E3.executeQuery();
                ResultSet setF2T1E3 = statementF2T1E3.executeQuery();
                ResultSet setF2T2E3 = statementF2T2E3.executeQuery();
                ResultSet setF2T3E3 = statementF2T3E3.executeQuery();
                ResultSet setF3T1E3 = statementF3T1E3.executeQuery();
                ResultSet setF3T2E3 = statementF3T2E3.executeQuery();
                ResultSet setF3T3E3 = statementF3T3E3.executeQuery();
                

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

                document.add((new Paragraph("ADM: "+set.getString(2)+"  "+"NAME: "+set.getString(3)+"   "+set.getString(4)+" "+set.getString(5)+"  "+"KCPE:"+set.getString(6)+"  "+"CLASS:FORM 4"+"  "+"TERM:TERM 1",new Font(Font.FontFamily.TIMES_ROMAN, 9,Font.BOLD))));
                document.add((new Paragraph("YEAR:"+now.get(Calendar.YEAR)+" "+"POS:"+String.valueOf(pos)+" "+"OUT OF "+totalStudents,new Font(Font.FontFamily.TIMES_ROMAN, 9,Font.BOLD))));
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
                PdfPCell engD3 = new PdfPCell(new Paragraph(" "));
                PdfPCell engD4 = new PdfPCell(new Paragraph(setE3.getString(8)+" "+setE3.getString(9)));

                int avgE= Integer.parseInt(setE3.getString(8));
                if (avgE >= Integer.parseInt(setEngGrade.getString(4))) {com = setComments.getString(2); } else if (avgE >= Integer.parseInt(setEngGrade.getString(5))) { com = setComments.getString(3); }else if (avgE >=Integer.parseInt(setEngGrade.getString(6))){ com = setComments.getString(4);}else if (avgE >=Integer.parseInt(setEngGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgE >=Integer.parseInt(setEngGrade.getString(8))){  com = setComments.getString(6); }else if (avgE >=Integer.parseInt(setEngGrade.getString(9))){ com = setComments.getString(7); }else if (avgE >=Integer.parseInt(setEngGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgE >=Integer.parseInt(setEngGrade.getString(11))){ com = setComments.getString(9);}else if (avgE >=Integer.parseInt(setEngGrade.getString(12))){ com = setComments.getString(10);}else if (avgE >=Integer.parseInt(setEngGrade.getString(13))){ com = setComments.getString(11);}else if (avgE >=Integer.parseInt(setEngGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }
                PdfPCell engD5 = new PdfPCell(new Paragraph(setE3.getString(8)+" "+setE3.getString(9)));
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
                PdfPCell kisD3 = new PdfPCell(new Paragraph(" "));
                PdfPCell kisD4 = new PdfPCell(new Paragraph(setE3.getString(11)+" "+setE3.getString(12)));

                int avgKis= Integer.parseInt(setE3.getString(11));
                if (avgKis >= Integer.parseInt(setKisGrade.getString(4))) {com = setComments.getString(2); } else if (avgKis >= Integer.parseInt(setKisGrade.getString(5))) { com = setComments.getString(3); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(6))){ com = setComments.getString(4);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(8))){  com = setComments.getString(6); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(9))){ com = setComments.getString(7); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgKis >=Integer.parseInt(setKisGrade.getString(11))){ com = setComments.getString(9);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(12))){ com = setComments.getString(10);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(13))){ com = setComments.getString(11);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }
                PdfPCell kisD5 = new PdfPCell(new Paragraph(setE3.getString(11)+" "+setE3.getString(12)));
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
                PdfPCell matD3 = new PdfPCell(new Paragraph(" "));
                PdfPCell matD4 = new PdfPCell(new Paragraph(setE3.getString(14)+" "+setE3.getString(15)));

                int avgMat = Integer.parseInt(setE3.getString(14));
                if (avgMat >= Integer.parseInt(setMatGrade.getString(4))) {com = setComments.getString(2); } else if (avgMat >= Integer.parseInt(setMatGrade.getString(5))) { com = setComments.getString(3); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(6))){ com = setComments.getString(4);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(8))){  com = setComments.getString(6); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(9))){ com = setComments.getString(7); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgMat >=Integer.parseInt(setMatGrade.getString(11))){ com = setComments.getString(9);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(12))){ com = setComments.getString(10);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(13))){ com = setComments.getString(11);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell matD5 = new PdfPCell(new Paragraph(setE3.getString(14)+" "+setE3.getString(15)));
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
                PdfPCell chemD3 = new PdfPCell(new Paragraph(" "));
                PdfPCell chemD4 = new PdfPCell(new Paragraph(setE3.getString(20)+" "+setE3.getString(21)));

                int avgChem = Integer.parseInt(setE3.getString(20));
                if (avgChem >= Integer.parseInt(setChemGrade.getString(4))) {com = setComments.getString(2); } else if (avgChem >= Integer.parseInt(setChemGrade.getString(5))) { com = setComments.getString(3); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(6))){ com = setComments.getString(4);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(8))){  com = setComments.getString(6); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(9))){ com = setComments.getString(7); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgChem >=Integer.parseInt(setChemGrade.getString(11))){ com = setComments.getString(9);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(12))){ com = setComments.getString(10);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(13))){ com = setComments.getString(11);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell chemD5 = new PdfPCell(new Paragraph(setE3.getString(20)+" "+setE3.getString(21)));
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
                PdfPCell bioD3 = new PdfPCell(new Paragraph(" "));
                PdfPCell bioD4 = new PdfPCell(new Paragraph(setE3.getString(17)+" "+setE3.getString(18)));

                int avgBio = Integer.parseInt(setE3.getString(17));
                if (avgBio >= Integer.parseInt(setBioGrade.getString(4))) {com = setComments.getString(2); } else if (avgBio >= Integer.parseInt(setBioGrade.getString(5))) { com = setComments.getString(3); }else if (avgBio >=Integer.parseInt(setBioGrade.getString(6))){ com = setComments.getString(4);}else if (avgBio >=Integer.parseInt(setBioGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgBio >=Integer.parseInt(setBioGrade.getString(8))){  com = setComments.getString(6); }else if (avgBio >=Integer.parseInt(setBioGrade.getString(9))){ com = setComments.getString(7); }else if (avgBio >=Integer.parseInt(setBioGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgBio >=Integer.parseInt(setBioGrade.getString(11))){ com = setComments.getString(9);}else if (avgBio >=Integer.parseInt(setBioGrade.getString(12))){ com = setComments.getString(10);}else if (avgBio >=Integer.parseInt(setBioGrade.getString(13))){ com = setComments.getString(11);}else if (avgBio >=Integer.parseInt(setBioGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell bioD5 = new PdfPCell(new Paragraph(setE3.getString(17)+" "+setE3.getString(18)));
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
                PdfPCell geoD3 = new PdfPCell(new Paragraph(" "));
                PdfPCell geoD4 = new PdfPCell(new Paragraph(setE3.getString(26)+" "+setE3.getString(27)));

                int avgGeo = Integer.parseInt(setE3.getString(26));
                if (avgGeo >= Integer.parseInt(setGeoGrade.getString(4))) {com = setComments.getString(2); } else if (avgGeo >= Integer.parseInt(setGeoGrade.getString(5))) { com = setComments.getString(3); }else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(6))){ com = setComments.getString(4);}else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(8))){  com = setComments.getString(6); }else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(9))){ com = setComments.getString(7); }else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(11))){ com = setComments.getString(9);}else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(12))){ com = setComments.getString(10);}else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(13))){ com = setComments.getString(11);}else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell geoD5 = new PdfPCell(new Paragraph(setE3.getString(26)+" "+setE3.getString(27)));
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
                PdfPCell agriD3 = new PdfPCell(new Paragraph(" "));
                PdfPCell agriD4 = new PdfPCell(new Paragraph(setE3.getString(38)+" "+setE3.getString(39)));

                int avgAgri = Integer.parseInt(setE3.getString(38));
                if (avgAgri >= Integer.parseInt(setAgriGrade.getString(4))) {com = setComments.getString(2); } else if (avgAgri >= Integer.parseInt(setAgriGrade.getString(5))) { com = setComments.getString(3); }else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(6))){ com = setComments.getString(4);}else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(8))){  com = setComments.getString(6); }else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(9))){ com = setComments.getString(7); }else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(11))){ com = setComments.getString(9);}else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(12))){ com = setComments.getString(10);}else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(13))){ com = setComments.getString(11);}else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell agriD5 = new PdfPCell(new Paragraph(setE3.getString(38)+" "+setE3.getString(39)));
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
                
                int totalE3 = Integer.parseInt(setE3.getString(41));
                int totalAvg = Integer.parseInt(setE3.getString(41));


                PdfPCell totalD1 = new PdfPCell(new Paragraph("Total"));
                PdfPCell totalD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell totalD3 = new PdfPCell(new Paragraph(" "));
                PdfPCell totalD4 = new PdfPCell(new Paragraph(String.valueOf(totalE3)));
                PdfPCell totalD5 = new PdfPCell(new Paragraph(String.valueOf(totalAvg)));
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

               
                //int add2AvgEx2 = (Math.addExact(totalEx2Mat,addAvgEx2))/3;

                int addAvgEx3 = Math.round(totalE3/7);
                //int add2AvgEx3 = (Math.addExact(totalEx3Mat,addAvgEx3))/3;

                
                PdfPCell avgD1 = new PdfPCell(new Paragraph("Average"));
                PdfPCell avgD2 = new PdfPCell(new Paragraph(" "));
                
                PdfPCell avgD3 = new PdfPCell(new Paragraph(" "));

                if (addAvgEx3 >= Integer.parseInt(setTotal.getString(4))) {g = "A"; } else if (addAvgEx3 >= Integer.parseInt(setTotal.getString(5))) { g = "A-"; }else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(6))){ g = "B+";}else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(7))){
                    g = "B"; }else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(8))){  g = "B-"; }else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(9))){ g = "C+"; }else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(10))){ g = "C";
                }else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(11))){ g = "C-";}else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(12))){ g = "D+";}else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(13))){ g = "D";}else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(14))){
                    g = "D-";}else {g="E"; }
                PdfPCell avgD4 = new PdfPCell(new Paragraph(String.valueOf(addAvgEx3)+" "+setE3.getString(42)));

                //float avgAvgTotal = (addAvgEx1+addAvgEx2+addAvgEx3)/3;
                int avgAvgTotal=Integer.parseInt(setE3.getString(41))/7;

                if (avgAvgTotal >= Integer.parseInt(setTotal.getString(4))) {g = "A"; } else if (avgAvgTotal >= Integer.parseInt(setTotal.getString(5))) { g = "A-"; }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(6))){ g = "B+";}else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(7))){
                    g = "B"; }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(8))){  g = "B-"; }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(9))){ g = "C+"; }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(10))){ g = "C";
                }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(11))){ g = "C-";}else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(12))){ g = "D+";}else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(13))){ g = "D";}else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(14))){
                    g = "D-";}else {g="E"; }

                PdfPCell avgD5 = new PdfPCell(new Paragraph(String.valueOf(Math.round(avgAvgTotal))+" "+setE3.getString(42)));
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
                PdfPCell f1t1m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF1T1E3.getString(30)))/11)+" "+setF1T1E3.getString(31)));
                PdfPCell f2t1 = new PdfPCell(new Paragraph("F2T1"));
                PdfPCell f2t1m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF2T1E3.getString(30)))/11)+" "+setF2T1E3.getString(31)));
                PdfPCell f3t1 = new PdfPCell(new Paragraph("F3T1"));
                PdfPCell f3t1m = new PdfPCell(new Paragraph(String.valueOf(Integer.parseInt(setF3T1E3.getString(41))/11)+" "+setF3T1E3.getString(43)+" "+setF3T1E3.getString(42)));
                PdfPCell f4t1 = new PdfPCell(new Paragraph("F4T1"));
                PdfPCell f4t1m = new PdfPCell(new Paragraph(String.valueOf(avgAvgTotal)+" "+setE3.getString(42)+" "+setE3.getString(43)));
                tableLastSummary.addCell(f1t1);
                tableLastSummary.addCell(f1t1m);
                tableLastSummary.addCell(f2t1);
                tableLastSummary.addCell(f2t1m);
                tableLastSummary.addCell(f3t1);
                tableLastSummary.addCell(f3t1m);
                tableLastSummary.addCell(f4t1);
                tableLastSummary.addCell(f4t1m);

                PdfPCell f1t2 = new PdfPCell(new Paragraph("F1T2"));
                PdfPCell f1t2m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF1T2E3.getString(30)))/11)+" "+setF1T2E3.getString(31)));
                PdfPCell f2t2 = new PdfPCell(new Paragraph("F2T2"));
                PdfPCell f2t2m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF2T2E3.getString(30)))/11)+" "+setF2T2E3.getString(31)));
                PdfPCell f3t2 = new PdfPCell(new Paragraph("F3T2"));
                PdfPCell f3t2m = new PdfPCell(new Paragraph(String.valueOf(Integer.parseInt(setF3T2E3.getString(41))/11)+" "+setF3T2E3.getString(43)+" "+setF3T2E3.getString(42)));
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
                PdfPCell f1t3m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF1T3E3.getString(30)))/11)+" "+setF1T3E3.getString(31)));
                PdfPCell f2t3 = new PdfPCell(new Paragraph("F2T3"));
                PdfPCell f2t3m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF2T3E3.getString(30)))/11)+" "+setF2T3E3.getString(31)));
                PdfPCell f3t3 = new PdfPCell(new Paragraph("F3T3"));
                PdfPCell f3t3m = new PdfPCell(new Paragraph(String.valueOf(Integer.parseInt(setF3T3E3.getString(41))/11)+" "+setF3T3E3.getString(43)+" "+setF3T3E3.getString(42)));
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
               dataSet.setValue((Integer.parseInt(setF1T1E3.getString(30))/11)/7, "Marks", "F1T1");
                dataSet.setValue((Integer.parseInt(setF1T2E3.getString(30))/11)/7, "Marks", "F1T2");
                dataSet.setValue((Integer.parseInt(setF1T3E3.getString(30))/11)/7, "Marks", "F1T3");
                dataSet.setValue((Integer.parseInt(setF2T1E3.getString(30))/11)/7, "Marks", "F2T1");
                dataSet.setValue((Integer.parseInt(setF2T2E3.getString(30))/11)/7, "Marks", "F2T2");
                dataSet.setValue((Integer.parseInt(setF2T3E3.getString(30))/11)/7, "Marks", "F2T3");
                dataSet.setValue(Float.parseFloat(setF3T1E3.getString(43)), "Marks", "F3T1");
                dataSet.setValue(Float.parseFloat(setF3T2E3.getString(43)), "Marks", "F3T2");
                dataSet.setValue(Float.parseFloat(setF3T3E3.getString(43)), "Marks", "F3T3");
              dataSet.setValue(Float.parseFloat(setE3.getString(43)), "Marks", "F4T1");
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
                 document.newPage();
                connection.close();

            }catch (Exception e){
                e.printStackTrace();
                infoBoxError("An error occurred " + e,"Error",null);
            }}else {
            infoBoxError("You are not allowed to print","Error",null);
        }
    }

    private void printBioGeoBus(String adm, Document document, PdfWriter writer, int pos, String totalStudents) {
        if(printPassword.toString().equals("vic")) {
            String sqlDetails="SELECT * FROM tbl_students WHERE adm=?";
            String sqlComm = "SELECT * FROM tbl_comments";
            String sqlTotal ="SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='TOTAL'";
            
            String sqlEx3 = "SELECT * FROM tbl_f4_t1_ex3 WHERE adm=? ";
             String sqlF1T1Ex3 = "SELECT * FROM tbl_f1_t1_ex3 WHERE adm=?";
            String sqlF1T2Ex3 = "SELECT * FROM tbl_f1_t2_ex3 WHERE adm=?";
            String sqlF1T3Ex3 = "SELECT * FROM tbl_f1_t3_ex3 WHERE adm=?";
            String sqlF2T1Ex3 = "SELECT * FROM tbl_f2_t1_ex3 WHERE adm=?";
            String sqlF2T2Ex3 = "SELECT * FROM tbl_f2_t2_ex3 WHERE adm=?";
            String sqlF2T3Ex3 = "SELECT * FROM tbl_f2_t3_ex3 WHERE adm=?";
            String sqlF3T1Ex3 = "SELECT * FROM tbl_f3_t1_ex3 WHERE adm=?";
            String sqlF3T2Ex3 = "SELECT * FROM tbl_f3_t2_ex3 WHERE adm=?";
            String sqlF3T3Ex3 = "SELECT * FROM tbl_f3_t3_ex3 WHERE adm=?";
            

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
                
                PreparedStatement statementE3 = connection.prepareStatement(sqlEx3);
                PreparedStatement statementF1T1E3 = connection.prepareStatement(sqlF1T1Ex3);
                PreparedStatement statementF1T2E3 = connection.prepareStatement(sqlF1T2Ex3);
                PreparedStatement statementF1T3E3 = connection.prepareStatement(sqlF1T3Ex3);
                PreparedStatement statementF2T1E3 = connection.prepareStatement(sqlF2T1Ex3);
                PreparedStatement statementF2T2E3 = connection.prepareStatement(sqlF2T2Ex3);
                PreparedStatement statementF2T3E3 = connection.prepareStatement(sqlF2T3Ex3);
                PreparedStatement statementF3T1E3 = connection.prepareStatement(sqlF3T1Ex3);
                PreparedStatement statementF3T2E3 = connection.prepareStatement(sqlF3T2Ex3);
                PreparedStatement statementF3T3E3 = connection.prepareStatement(sqlF3T3Ex3);
                


                statement.setString(1,adm);
                
                statementE3.setString(1,adm);
                statementF1T1E3.setString(1,adm);
                statementF1T2E3.setString(1,adm);
                statementF1T3E3.setString(1,adm);
                statementF2T1E3.setString(1,adm);
                statementF2T2E3.setString(1,adm);
                statementF2T3E3.setString(1,adm);
                statementF3T1E3.setString(1,adm);
                statementF3T2E3.setString(1,adm);
                statementF3T3E3.setString(1,adm);
                

                ResultSet set = statement.executeQuery();
                
                ResultSet setE3 = statementE3.executeQuery();
                 ResultSet setF1T1E3 = statementF1T1E3.executeQuery();
                ResultSet setF1T2E3 = statementF1T2E3.executeQuery();
                ResultSet setF1T3E3 = statementF1T3E3.executeQuery();
                ResultSet setF2T1E3 = statementF2T1E3.executeQuery();
                ResultSet setF2T2E3 = statementF2T2E3.executeQuery();
                ResultSet setF2T3E3 = statementF2T3E3.executeQuery();
                ResultSet setF3T1E3 = statementF3T1E3.executeQuery();
                ResultSet setF3T2E3 = statementF3T2E3.executeQuery();
                ResultSet setF3T3E3 = statementF3T3E3.executeQuery();
                

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

                document.add((new Paragraph("ADM: "+set.getString(2)+"  "+"NAME: "+set.getString(3)+"   "+set.getString(4)+" "+set.getString(5)+"  "+"KCPE:"+set.getString(6)+"  "+"CLASS:FORM 4"+"  "+"TERM:TERM 1",new Font(Font.FontFamily.TIMES_ROMAN, 9,Font.BOLD))));
                document.add((new Paragraph("YEAR:"+now.get(Calendar.YEAR)+" "+"POS:"+String.valueOf(pos)+" "+"OUT OF "+totalStudents,new Font(Font.FontFamily.TIMES_ROMAN, 9,Font.BOLD))));
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
                PdfPCell engD3 = new PdfPCell(new Paragraph(" "));
                PdfPCell engD4 = new PdfPCell(new Paragraph(setE3.getString(8)+" "+setE3.getString(9)));

                int avgE= Integer.parseInt(setE3.getString(8));
                if (avgE >= Integer.parseInt(setEngGrade.getString(4))) {com = setComments.getString(2); } else if (avgE >= Integer.parseInt(setEngGrade.getString(5))) { com = setComments.getString(3); }else if (avgE >=Integer.parseInt(setEngGrade.getString(6))){ com = setComments.getString(4);}else if (avgE >=Integer.parseInt(setEngGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgE >=Integer.parseInt(setEngGrade.getString(8))){  com = setComments.getString(6); }else if (avgE >=Integer.parseInt(setEngGrade.getString(9))){ com = setComments.getString(7); }else if (avgE >=Integer.parseInt(setEngGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgE >=Integer.parseInt(setEngGrade.getString(11))){ com = setComments.getString(9);}else if (avgE >=Integer.parseInt(setEngGrade.getString(12))){ com = setComments.getString(10);}else if (avgE >=Integer.parseInt(setEngGrade.getString(13))){ com = setComments.getString(11);}else if (avgE >=Integer.parseInt(setEngGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }
                PdfPCell engD5 = new PdfPCell(new Paragraph(setE3.getString(8)+" "+setE3.getString(9)));
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
                PdfPCell kisD3 = new PdfPCell(new Paragraph(" "));
                PdfPCell kisD4 = new PdfPCell(new Paragraph(setE3.getString(11)+" "+setE3.getString(12)));

                int avgKis= Integer.parseInt(setE3.getString(11));
                if (avgKis >= Integer.parseInt(setKisGrade.getString(4))) {com = setComments.getString(2); } else if (avgKis >= Integer.parseInt(setKisGrade.getString(5))) { com = setComments.getString(3); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(6))){ com = setComments.getString(4);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(8))){  com = setComments.getString(6); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(9))){ com = setComments.getString(7); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgKis >=Integer.parseInt(setKisGrade.getString(11))){ com = setComments.getString(9);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(12))){ com = setComments.getString(10);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(13))){ com = setComments.getString(11);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }
                PdfPCell kisD5 = new PdfPCell(new Paragraph(setE3.getString(11)+" "+setE3.getString(12)));
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
                PdfPCell matD3 = new PdfPCell(new Paragraph(" "));
                PdfPCell matD4 = new PdfPCell(new Paragraph(setE3.getString(14)+" "+setE3.getString(15)));

                int avgMat = Integer.parseInt(setE3.getString(14));
                if (avgMat >= Integer.parseInt(setMatGrade.getString(4))) {com = setComments.getString(2); } else if (avgMat >= Integer.parseInt(setMatGrade.getString(5))) { com = setComments.getString(3); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(6))){ com = setComments.getString(4);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(8))){  com = setComments.getString(6); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(9))){ com = setComments.getString(7); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgMat >=Integer.parseInt(setMatGrade.getString(11))){ com = setComments.getString(9);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(12))){ com = setComments.getString(10);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(13))){ com = setComments.getString(11);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell matD5 = new PdfPCell(new Paragraph(setE3.getString(14)+" "+setE3.getString(15)));
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
                PdfPCell chemD3 = new PdfPCell(new Paragraph(" "));
                PdfPCell chemD4 = new PdfPCell(new Paragraph(setE3.getString(20)+" "+setE3.getString(21)));

                int avgChem = Integer.parseInt(setE3.getString(20));
                if (avgChem >= Integer.parseInt(setChemGrade.getString(4))) {com = setComments.getString(2); } else if (avgChem >= Integer.parseInt(setChemGrade.getString(5))) { com = setComments.getString(3); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(6))){ com = setComments.getString(4);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(8))){  com = setComments.getString(6); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(9))){ com = setComments.getString(7); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgChem >=Integer.parseInt(setChemGrade.getString(11))){ com = setComments.getString(9);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(12))){ com = setComments.getString(10);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(13))){ com = setComments.getString(11);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell chemD5 = new PdfPCell(new Paragraph(setE3.getString(20)+" "+setE3.getString(21)));
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
                PdfPCell bioD3 = new PdfPCell(new Paragraph(" "));
                PdfPCell bioD4 = new PdfPCell(new Paragraph(setE3.getString(17)+" "+setE3.getString(18)));

                int avgBio = Integer.parseInt(setE3.getString(17));
                if (avgBio >= Integer.parseInt(setBioGrade.getString(4))) {com = setComments.getString(2); } else if (avgBio >= Integer.parseInt(setBioGrade.getString(5))) { com = setComments.getString(3); }else if (avgBio >=Integer.parseInt(setBioGrade.getString(6))){ com = setComments.getString(4);}else if (avgBio >=Integer.parseInt(setBioGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgBio >=Integer.parseInt(setBioGrade.getString(8))){  com = setComments.getString(6); }else if (avgBio >=Integer.parseInt(setBioGrade.getString(9))){ com = setComments.getString(7); }else if (avgBio >=Integer.parseInt(setBioGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgBio >=Integer.parseInt(setBioGrade.getString(11))){ com = setComments.getString(9);}else if (avgBio >=Integer.parseInt(setBioGrade.getString(12))){ com = setComments.getString(10);}else if (avgBio >=Integer.parseInt(setBioGrade.getString(13))){ com = setComments.getString(11);}else if (avgBio >=Integer.parseInt(setBioGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell bioD5 = new PdfPCell(new Paragraph(setE3.getString(17)+" "+setE3.getString(18)));
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
                PdfPCell geoD3 = new PdfPCell(new Paragraph(" "));
                PdfPCell geoD4 = new PdfPCell(new Paragraph(setE3.getString(26)+" "+setE3.getString(27)));

                int avgGeo = Integer.parseInt(setE3.getString(26));
                if (avgGeo >= Integer.parseInt(setGeoGrade.getString(4))) {com = setComments.getString(2); } else if (avgGeo >= Integer.parseInt(setGeoGrade.getString(5))) { com = setComments.getString(3); }else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(6))){ com = setComments.getString(4);}else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(8))){  com = setComments.getString(6); }else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(9))){ com = setComments.getString(7); }else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(11))){ com = setComments.getString(9);}else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(12))){ com = setComments.getString(10);}else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(13))){ com = setComments.getString(11);}else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell geoD5 = new PdfPCell(new Paragraph(setE3.getString(26)+" "+setE3.getString(27)));
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
                PdfPCell busD3 = new PdfPCell(new Paragraph(" "));
                PdfPCell busD4 = new PdfPCell(new Paragraph(setE3.getString(35)+" "+setE3.getString(36)));

                int avgBus = Integer.parseInt(setE3.getString(35));
                if (avgBus >= Integer.parseInt(setBusGrade.getString(4))) {com = setComments.getString(2); } else if (avgBus >= Integer.parseInt(setBusGrade.getString(5))) { com = setComments.getString(3); }else if (avgBus >=Integer.parseInt(setBusGrade.getString(6))){ com = setComments.getString(4);}else if (avgBus >=Integer.parseInt(setBusGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgBus >=Integer.parseInt(setBusGrade.getString(8))){  com = setComments.getString(6); }else if (avgBus >=Integer.parseInt(setBusGrade.getString(9))){ com = setComments.getString(7); }else if (avgBus >=Integer.parseInt(setBusGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgBus >=Integer.parseInt(setBusGrade.getString(11))){ com = setComments.getString(9);}else if (avgBus >=Integer.parseInt(setBusGrade.getString(12))){ com = setComments.getString(10);}else if (avgBus >=Integer.parseInt(setBusGrade.getString(13))){ com = setComments.getString(11);}else if (avgBus >=Integer.parseInt(setBusGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell busD5 = new PdfPCell(new Paragraph(setE3.getString(35)+" "+setE3.getString(36)));
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
                
                int totalE3 = Integer.parseInt(setE3.getString(41));
                int totalAvg = Integer.parseInt(setE3.getString(41));


                PdfPCell totalD1 = new PdfPCell(new Paragraph("Total"));
                PdfPCell totalD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell totalD3 = new PdfPCell(new Paragraph(" "));
                PdfPCell totalD4 = new PdfPCell(new Paragraph(String.valueOf(totalE3)));
                PdfPCell totalD5 = new PdfPCell(new Paragraph(String.valueOf(totalAvg)));
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

               
                //int add2AvgEx2 = (Math.addExact(totalEx2Mat,addAvgEx2))/3;

                int addAvgEx3 = Math.round(totalE3/7);
                //int add2AvgEx3 = (Math.addExact(totalEx3Mat,addAvgEx3))/3;

                
                PdfPCell avgD1 = new PdfPCell(new Paragraph("Average"));
                PdfPCell avgD2 = new PdfPCell(new Paragraph(" "));
                
                PdfPCell avgD3 = new PdfPCell(new Paragraph(" "));

                if (addAvgEx3 >= Integer.parseInt(setTotal.getString(4))) {g = "A"; } else if (addAvgEx3 >= Integer.parseInt(setTotal.getString(5))) { g = "A-"; }else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(6))){ g = "B+";}else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(7))){
                    g = "B"; }else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(8))){  g = "B-"; }else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(9))){ g = "C+"; }else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(10))){ g = "C";
                }else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(11))){ g = "C-";}else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(12))){ g = "D+";}else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(13))){ g = "D";}else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(14))){
                    g = "D-";}else {g="E"; }
                PdfPCell avgD4 = new PdfPCell(new Paragraph(String.valueOf(addAvgEx3)+" "+setE3.getString(42)));

                //float avgAvgTotal = (addAvgEx1+addAvgEx2+addAvgEx3)/3;
                int avgAvgTotal=Integer.parseInt(setE3.getString(41))/7;

                if (avgAvgTotal >= Integer.parseInt(setTotal.getString(4))) {g = "A"; } else if (avgAvgTotal >= Integer.parseInt(setTotal.getString(5))) { g = "A-"; }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(6))){ g = "B+";}else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(7))){
                    g = "B"; }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(8))){  g = "B-"; }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(9))){ g = "C+"; }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(10))){ g = "C";
                }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(11))){ g = "C-";}else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(12))){ g = "D+";}else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(13))){ g = "D";}else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(14))){
                    g = "D-";}else {g="E"; }

                PdfPCell avgD5 = new PdfPCell(new Paragraph(String.valueOf(Math.round(avgAvgTotal))+" "+setE3.getString(42)));
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
                PdfPCell f1t1m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF1T1E3.getString(30)))/11)+" "+setF1T1E3.getString(31)));
                PdfPCell f2t1 = new PdfPCell(new Paragraph("F2T1"));
                PdfPCell f2t1m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF2T1E3.getString(30)))/11)+" "+setF2T1E3.getString(31)));
                PdfPCell f3t1 = new PdfPCell(new Paragraph("F3T1"));
                PdfPCell f3t1m = new PdfPCell(new Paragraph(String.valueOf(Integer.parseInt(setF3T1E3.getString(41))/11)+" "+setF3T1E3.getString(43)+" "+setF3T1E3.getString(42)));
                PdfPCell f4t1 = new PdfPCell(new Paragraph("F4T1"));
                PdfPCell f4t1m = new PdfPCell(new Paragraph(String.valueOf(avgAvgTotal)+" "+setE3.getString(42)+" "+setE3.getString(43)));
                tableLastSummary.addCell(f1t1);
                tableLastSummary.addCell(f1t1m);
                tableLastSummary.addCell(f2t1);
                tableLastSummary.addCell(f2t1m);
                tableLastSummary.addCell(f3t1);
                tableLastSummary.addCell(f3t1m);
                tableLastSummary.addCell(f4t1);
                tableLastSummary.addCell(f4t1m);

                PdfPCell f1t2 = new PdfPCell(new Paragraph("F1T2"));
                PdfPCell f1t2m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF1T2E3.getString(30)))/11)+" "+setF1T2E3.getString(31)));
                PdfPCell f2t2 = new PdfPCell(new Paragraph("F2T2"));
                PdfPCell f2t2m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF2T2E3.getString(30)))/11)+" "+setF2T2E3.getString(31)));
                PdfPCell f3t2 = new PdfPCell(new Paragraph("F3T2"));
                PdfPCell f3t2m = new PdfPCell(new Paragraph(String.valueOf(Integer.parseInt(setF3T2E3.getString(41))/11)+" "+setF3T2E3.getString(43)+" "+setF3T2E3.getString(42)));
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
                PdfPCell f1t3m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF1T3E3.getString(30)))/11)+" "+setF1T3E3.getString(31)));
                PdfPCell f2t3 = new PdfPCell(new Paragraph("F2T3"));
                PdfPCell f2t3m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF2T3E3.getString(30)))/11)+" "+setF2T3E3.getString(31)));
                PdfPCell f3t3 = new PdfPCell(new Paragraph("F3T3"));
                PdfPCell f3t3m = new PdfPCell(new Paragraph(String.valueOf(Integer.parseInt(setF3T3E3.getString(41))/11)+" "+setF3T3E3.getString(43)+" "+setF3T3E3.getString(42)));
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
               dataSet.setValue((Integer.parseInt(setF1T1E3.getString(30))/11)/7, "Marks", "F1T1");
                dataSet.setValue((Integer.parseInt(setF1T2E3.getString(30))/11)/7, "Marks", "F1T2");
                dataSet.setValue((Integer.parseInt(setF1T3E3.getString(30))/11)/7, "Marks", "F1T3");
                dataSet.setValue((Integer.parseInt(setF2T1E3.getString(30))/11)/7, "Marks", "F2T1");
                dataSet.setValue((Integer.parseInt(setF2T2E3.getString(30))/11)/7, "Marks", "F2T2");
                dataSet.setValue((Integer.parseInt(setF2T3E3.getString(30))/11)/7, "Marks", "F2T3");
                dataSet.setValue(Float.parseFloat(setF3T1E3.getString(43)), "Marks", "F3T1");
                dataSet.setValue(Float.parseFloat(setF3T2E3.getString(43)), "Marks", "F3T2");
                dataSet.setValue(Float.parseFloat(setF3T3E3.getString(43)), "Marks", "F3T3");
              dataSet.setValue(Float.parseFloat(setE3.getString(43)), "Marks", "F4T1");
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
                 document.newPage();
                connection.close();

            }catch (Exception e){
                e.printStackTrace();
                infoBoxError("An error occurred " + e,"Error",null);
            }}else {
            infoBoxError("You are not allowed to print","Error",null);
        }
    }

    private void printPhyCreAgri(String adm, Document document, PdfWriter writer, int pos, String totalStudents) {
        if(printPassword.toString().equals("vic")) {
            String sqlDetails="SELECT * FROM tbl_students WHERE adm=?";
            String sqlComm = "SELECT * FROM tbl_comments";
            String sqlTotal ="SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='TOTAL'";
            
            String sqlEx3 = "SELECT * FROM tbl_f4_t1_ex3 WHERE adm=? ";
             String sqlF1T1Ex3 = "SELECT * FROM tbl_f1_t1_ex3 WHERE adm=?";
            String sqlF1T2Ex3 = "SELECT * FROM tbl_f1_t2_ex3 WHERE adm=?";
            String sqlF1T3Ex3 = "SELECT * FROM tbl_f1_t3_ex3 WHERE adm=?";
            String sqlF2T1Ex3 = "SELECT * FROM tbl_f2_t1_ex3 WHERE adm=?";
            String sqlF2T2Ex3 = "SELECT * FROM tbl_f2_t2_ex3 WHERE adm=?";
            String sqlF2T3Ex3 = "SELECT * FROM tbl_f2_t3_ex3 WHERE adm=?";
            String sqlF3T1Ex3 = "SELECT * FROM tbl_f3_t1_ex3 WHERE adm=?";
            String sqlF3T2Ex3 = "SELECT * FROM tbl_f3_t2_ex3 WHERE adm=?";
            String sqlF3T3Ex3 = "SELECT * FROM tbl_f3_t3_ex3 WHERE adm=?";
            

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
                
                PreparedStatement statementE3 = connection.prepareStatement(sqlEx3);
                PreparedStatement statementF1T1E3 = connection.prepareStatement(sqlF1T1Ex3);
                PreparedStatement statementF1T2E3 = connection.prepareStatement(sqlF1T2Ex3);
                PreparedStatement statementF1T3E3 = connection.prepareStatement(sqlF1T3Ex3);
                PreparedStatement statementF2T1E3 = connection.prepareStatement(sqlF2T1Ex3);
                PreparedStatement statementF2T2E3 = connection.prepareStatement(sqlF2T2Ex3);
                PreparedStatement statementF2T3E3 = connection.prepareStatement(sqlF2T3Ex3);
                PreparedStatement statementF3T1E3 = connection.prepareStatement(sqlF3T1Ex3);
                PreparedStatement statementF3T2E3 = connection.prepareStatement(sqlF3T2Ex3);
                PreparedStatement statementF3T3E3 = connection.prepareStatement(sqlF3T3Ex3);
                


                statement.setString(1,adm);
                
                statementE3.setString(1,adm);
                statementF1T1E3.setString(1,adm);
                statementF1T2E3.setString(1,adm);
                statementF1T3E3.setString(1,adm);
                statementF2T1E3.setString(1,adm);
                statementF2T2E3.setString(1,adm);
                statementF2T3E3.setString(1,adm);
                statementF3T1E3.setString(1,adm);
                statementF3T2E3.setString(1,adm);
                statementF3T3E3.setString(1,adm);
                

                ResultSet set = statement.executeQuery();
                
                ResultSet setE3 = statementE3.executeQuery();
                 ResultSet setF1T1E3 = statementF1T1E3.executeQuery();
                ResultSet setF1T2E3 = statementF1T2E3.executeQuery();
                ResultSet setF1T3E3 = statementF1T3E3.executeQuery();
                ResultSet setF2T1E3 = statementF2T1E3.executeQuery();
                ResultSet setF2T2E3 = statementF2T2E3.executeQuery();
                ResultSet setF2T3E3 = statementF2T3E3.executeQuery();
                ResultSet setF3T1E3 = statementF3T1E3.executeQuery();
                ResultSet setF3T2E3 = statementF3T2E3.executeQuery();
                ResultSet setF3T3E3 = statementF3T3E3.executeQuery();
                

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

                document.add((new Paragraph("ADM: "+set.getString(2)+"  "+"NAME: "+set.getString(3)+"   "+set.getString(4)+" "+set.getString(5)+"  "+"KCPE:"+set.getString(6)+"  "+"CLASS:FORM 4"+"  "+"TERM:TERM 1",new Font(Font.FontFamily.TIMES_ROMAN, 9,Font.BOLD))));
                document.add((new Paragraph("YEAR:"+now.get(Calendar.YEAR)+" "+"POS:"+String.valueOf(pos)+" "+"OUT OF "+totalStudents,new Font(Font.FontFamily.TIMES_ROMAN, 9,Font.BOLD))));
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
                PdfPCell engD3 = new PdfPCell(new Paragraph(" "));
                PdfPCell engD4 = new PdfPCell(new Paragraph(setE3.getString(8)+" "+setE3.getString(9)));

                int avgE= Integer.parseInt(setE3.getString(8));
                if (avgE >= Integer.parseInt(setEngGrade.getString(4))) {com = setComments.getString(2); } else if (avgE >= Integer.parseInt(setEngGrade.getString(5))) { com = setComments.getString(3); }else if (avgE >=Integer.parseInt(setEngGrade.getString(6))){ com = setComments.getString(4);}else if (avgE >=Integer.parseInt(setEngGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgE >=Integer.parseInt(setEngGrade.getString(8))){  com = setComments.getString(6); }else if (avgE >=Integer.parseInt(setEngGrade.getString(9))){ com = setComments.getString(7); }else if (avgE >=Integer.parseInt(setEngGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgE >=Integer.parseInt(setEngGrade.getString(11))){ com = setComments.getString(9);}else if (avgE >=Integer.parseInt(setEngGrade.getString(12))){ com = setComments.getString(10);}else if (avgE >=Integer.parseInt(setEngGrade.getString(13))){ com = setComments.getString(11);}else if (avgE >=Integer.parseInt(setEngGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }
                PdfPCell engD5 = new PdfPCell(new Paragraph(setE3.getString(8)+" "+setE3.getString(9)));
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
                PdfPCell kisD3 = new PdfPCell(new Paragraph(" "));
                PdfPCell kisD4 = new PdfPCell(new Paragraph(setE3.getString(11)+" "+setE3.getString(12)));

                int avgKis= Integer.parseInt(setE3.getString(11));
                if (avgKis >= Integer.parseInt(setKisGrade.getString(4))) {com = setComments.getString(2); } else if (avgKis >= Integer.parseInt(setKisGrade.getString(5))) { com = setComments.getString(3); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(6))){ com = setComments.getString(4);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(8))){  com = setComments.getString(6); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(9))){ com = setComments.getString(7); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgKis >=Integer.parseInt(setKisGrade.getString(11))){ com = setComments.getString(9);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(12))){ com = setComments.getString(10);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(13))){ com = setComments.getString(11);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }
                PdfPCell kisD5 = new PdfPCell(new Paragraph(setE3.getString(11)+" "+setE3.getString(12)));
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
                PdfPCell matD3 = new PdfPCell(new Paragraph(" "));
                PdfPCell matD4 = new PdfPCell(new Paragraph(setE3.getString(14)+" "+setE3.getString(15)));

                int avgMat = Integer.parseInt(setE3.getString(14));
                if (avgMat >= Integer.parseInt(setMatGrade.getString(4))) {com = setComments.getString(2); } else if (avgMat >= Integer.parseInt(setMatGrade.getString(5))) { com = setComments.getString(3); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(6))){ com = setComments.getString(4);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(8))){  com = setComments.getString(6); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(9))){ com = setComments.getString(7); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgMat >=Integer.parseInt(setMatGrade.getString(11))){ com = setComments.getString(9);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(12))){ com = setComments.getString(10);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(13))){ com = setComments.getString(11);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell matD5 = new PdfPCell(new Paragraph(setE3.getString(14)+" "+setE3.getString(15)));
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
                PdfPCell chemD3 = new PdfPCell(new Paragraph(" "));
                PdfPCell chemD4 = new PdfPCell(new Paragraph(setE3.getString(20)+" "+setE3.getString(21)));

                int avgChem = Integer.parseInt(setE3.getString(20));
                if (avgChem >= Integer.parseInt(setChemGrade.getString(4))) {com = setComments.getString(2); } else if (avgChem >= Integer.parseInt(setChemGrade.getString(5))) { com = setComments.getString(3); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(6))){ com = setComments.getString(4);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(8))){  com = setComments.getString(6); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(9))){ com = setComments.getString(7); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgChem >=Integer.parseInt(setChemGrade.getString(11))){ com = setComments.getString(9);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(12))){ com = setComments.getString(10);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(13))){ com = setComments.getString(11);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell chemD5 = new PdfPCell(new Paragraph(setE3.getString(20)+" "+setE3.getString(21)));
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
                PdfPCell phyD3 = new PdfPCell(new Paragraph(" "));
                PdfPCell phyD4 = new PdfPCell(new Paragraph(setE3.getString(23)+" "+setE3.getString(24)));

                int avgPhy = Integer.parseInt(setE3.getString(23));
                if (avgPhy >= Integer.parseInt(setPhyGrade.getString(4))) {com = setComments.getString(2); } else if (avgPhy >= Integer.parseInt(setPhyGrade.getString(5))) { com = setComments.getString(3); }else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(6))){ com = setComments.getString(4);}else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(8))){  com = setComments.getString(6); }else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(9))){ com = setComments.getString(7); }else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(11))){ com = setComments.getString(9);}else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(12))){ com = setComments.getString(10);}else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(13))){ com = setComments.getString(11);}else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell phyD5 = new PdfPCell(new Paragraph(setE3.getString(23)+" "+setE3.getString(24)));
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
                PdfPCell creD3 = new PdfPCell(new Paragraph(" "));
                PdfPCell creD4 = new PdfPCell(new Paragraph(setE3.getString(32)+" "+setE3.getString(33)));

                int avgCre = Integer.parseInt(setE3.getString(32));
                if (avgCre >= Integer.parseInt(setCreGrade.getString(4))) {com = setComments.getString(2); } else if (avgCre >= Integer.parseInt(setCreGrade.getString(5))) { com = setComments.getString(3); }else if (avgCre >=Integer.parseInt(setCreGrade.getString(6))){ com = setComments.getString(4);}else if (avgCre >=Integer.parseInt(setCreGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgCre >=Integer.parseInt(setCreGrade.getString(8))){  com = setComments.getString(6); }else if (avgCre >=Integer.parseInt(setCreGrade.getString(9))){ com = setComments.getString(7); }else if (avgCre >=Integer.parseInt(setCreGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgCre >=Integer.parseInt(setCreGrade.getString(11))){ com = setComments.getString(9);}else if (avgCre >=Integer.parseInt(setCreGrade.getString(12))){ com = setComments.getString(10);}else if (avgCre >=Integer.parseInt(setCreGrade.getString(13))){ com = setComments.getString(11);}else if (avgCre >=Integer.parseInt(setCreGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell creD5 = new PdfPCell(new Paragraph(setE3.getString(32)+" "+setE3.getString(33)));
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
                PdfPCell agriD3 = new PdfPCell(new Paragraph(" "));
                PdfPCell agriD4 = new PdfPCell(new Paragraph(setE3.getString(38)+" "+setE3.getString(39)));

                int avgAgri = Integer.parseInt(setE3.getString(38));
                if (avgAgri >= Integer.parseInt(setAgriGrade.getString(4))) {com = setComments.getString(2); } else if (avgAgri >= Integer.parseInt(setAgriGrade.getString(5))) { com = setComments.getString(3); }else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(6))){ com = setComments.getString(4);}else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(8))){  com = setComments.getString(6); }else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(9))){ com = setComments.getString(7); }else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(11))){ com = setComments.getString(9);}else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(12))){ com = setComments.getString(10);}else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(13))){ com = setComments.getString(11);}else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell agriD5 = new PdfPCell(new Paragraph(setE3.getString(38)+" "+setE3.getString(39)));
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
                
                int totalE3 = Integer.parseInt(setE3.getString(41));
                int totalAvg = Integer.parseInt(setE3.getString(41));


                PdfPCell totalD1 = new PdfPCell(new Paragraph("Total"));
                PdfPCell totalD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell totalD3 = new PdfPCell(new Paragraph(" "));
                PdfPCell totalD4 = new PdfPCell(new Paragraph(String.valueOf(totalE3)));
                PdfPCell totalD5 = new PdfPCell(new Paragraph(String.valueOf(totalAvg)));
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

               
                //int add2AvgEx2 = (Math.addExact(totalEx2Mat,addAvgEx2))/3;

                int addAvgEx3 = Math.round(totalE3/7);
                //int add2AvgEx3 = (Math.addExact(totalEx3Mat,addAvgEx3))/3;

                
                PdfPCell avgD1 = new PdfPCell(new Paragraph("Average"));
                PdfPCell avgD2 = new PdfPCell(new Paragraph(" "));
                
                PdfPCell avgD3 = new PdfPCell(new Paragraph(" "));

                if (addAvgEx3 >= Integer.parseInt(setTotal.getString(4))) {g = "A"; } else if (addAvgEx3 >= Integer.parseInt(setTotal.getString(5))) { g = "A-"; }else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(6))){ g = "B+";}else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(7))){
                    g = "B"; }else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(8))){  g = "B-"; }else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(9))){ g = "C+"; }else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(10))){ g = "C";
                }else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(11))){ g = "C-";}else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(12))){ g = "D+";}else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(13))){ g = "D";}else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(14))){
                    g = "D-";}else {g="E"; }
                PdfPCell avgD4 = new PdfPCell(new Paragraph(String.valueOf(addAvgEx3)+" "+setE3.getString(42)));

                //float avgAvgTotal = (addAvgEx1+addAvgEx2+addAvgEx3)/3;
                int avgAvgTotal=Integer.parseInt(setE3.getString(41))/7;

                if (avgAvgTotal >= Integer.parseInt(setTotal.getString(4))) {g = "A"; } else if (avgAvgTotal >= Integer.parseInt(setTotal.getString(5))) { g = "A-"; }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(6))){ g = "B+";}else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(7))){
                    g = "B"; }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(8))){  g = "B-"; }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(9))){ g = "C+"; }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(10))){ g = "C";
                }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(11))){ g = "C-";}else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(12))){ g = "D+";}else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(13))){ g = "D";}else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(14))){
                    g = "D-";}else {g="E"; }

                PdfPCell avgD5 = new PdfPCell(new Paragraph(String.valueOf(Math.round(avgAvgTotal))+" "+setE3.getString(42)));
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
                PdfPCell f1t1m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF1T1E3.getString(30)))/11)+" "+setF1T1E3.getString(31)));
                PdfPCell f2t1 = new PdfPCell(new Paragraph("F2T1"));
                PdfPCell f2t1m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF2T1E3.getString(30)))/11)+" "+setF2T1E3.getString(31)));
                PdfPCell f3t1 = new PdfPCell(new Paragraph("F3T1"));
                PdfPCell f3t1m = new PdfPCell(new Paragraph(String.valueOf(Integer.parseInt(setF3T1E3.getString(41))/11)+" "+setF3T1E3.getString(43)+" "+setF3T1E3.getString(42)));
                PdfPCell f4t1 = new PdfPCell(new Paragraph("F4T1"));
                PdfPCell f4t1m = new PdfPCell(new Paragraph(String.valueOf(avgAvgTotal)+" "+setE3.getString(42)+" "+setE3.getString(43)));
                tableLastSummary.addCell(f1t1);
                tableLastSummary.addCell(f1t1m);
                tableLastSummary.addCell(f2t1);
                tableLastSummary.addCell(f2t1m);
                tableLastSummary.addCell(f3t1);
                tableLastSummary.addCell(f3t1m);
                tableLastSummary.addCell(f4t1);
                tableLastSummary.addCell(f4t1m);

                PdfPCell f1t2 = new PdfPCell(new Paragraph("F1T2"));
                PdfPCell f1t2m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF1T2E3.getString(30)))/11)+" "+setF1T2E3.getString(31)));
                PdfPCell f2t2 = new PdfPCell(new Paragraph("F2T2"));
                PdfPCell f2t2m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF2T2E3.getString(30)))/11)+" "+setF2T2E3.getString(31)));
                PdfPCell f3t2 = new PdfPCell(new Paragraph("F3T2"));
                PdfPCell f3t2m = new PdfPCell(new Paragraph(String.valueOf(Integer.parseInt(setF3T2E3.getString(41))/11)+" "+setF3T2E3.getString(43)+" "+setF3T2E3.getString(42)));
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
                PdfPCell f1t3m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF1T3E3.getString(30)))/11)+" "+setF1T3E3.getString(31)));
                PdfPCell f2t3 = new PdfPCell(new Paragraph("F2T3"));
                PdfPCell f2t3m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF2T3E3.getString(30)))/11)+" "+setF2T3E3.getString(31)));
                PdfPCell f3t3 = new PdfPCell(new Paragraph("F3T3"));
                PdfPCell f3t3m = new PdfPCell(new Paragraph(String.valueOf(Integer.parseInt(setF3T3E3.getString(41))/11)+" "+setF3T3E3.getString(43)+" "+setF3T3E3.getString(42)));
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
               dataSet.setValue((Integer.parseInt(setF1T1E3.getString(30))/11)/7, "Marks", "F1T1");
                dataSet.setValue((Integer.parseInt(setF1T2E3.getString(30))/11)/7, "Marks", "F1T2");
                dataSet.setValue((Integer.parseInt(setF1T3E3.getString(30))/11)/7, "Marks", "F1T3");
                dataSet.setValue((Integer.parseInt(setF2T1E3.getString(30))/11)/7, "Marks", "F2T1");
                dataSet.setValue((Integer.parseInt(setF2T2E3.getString(30))/11)/7, "Marks", "F2T2");
                dataSet.setValue((Integer.parseInt(setF2T3E3.getString(30))/11)/7, "Marks", "F2T3");
                dataSet.setValue(Float.parseFloat(setF3T1E3.getString(43)), "Marks", "F3T1");
                dataSet.setValue(Float.parseFloat(setF3T2E3.getString(43)), "Marks", "F3T2");
                dataSet.setValue(Float.parseFloat(setF3T3E3.getString(43)), "Marks", "F3T3");
              dataSet.setValue(Float.parseFloat(setE3.getString(43)), "Marks", "F4T1");
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
                 document.newPage();
                connection.close();

            }catch (Exception e){
                e.printStackTrace();
                infoBoxError("An error occurred " + e,"Error",null);
            }}else {
            infoBoxError("You are not allowed to print","Error",null);
        }
    }

    private void printPhyCreBus(String adm, Document document, PdfWriter writer, int pos, String totalStudents) {
        if(printPassword.toString().equals("vic")) {
            String sqlDetails="SELECT * FROM tbl_students WHERE adm=?";
            String sqlComm = "SELECT * FROM tbl_comments";
            String sqlTotal ="SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='TOTAL'";
            
            String sqlEx3 = "SELECT * FROM tbl_f4_t1_ex3 WHERE adm=? ";
             String sqlF1T1Ex3 = "SELECT * FROM tbl_f1_t1_ex3 WHERE adm=?";
            String sqlF1T2Ex3 = "SELECT * FROM tbl_f1_t2_ex3 WHERE adm=?";
            String sqlF1T3Ex3 = "SELECT * FROM tbl_f1_t3_ex3 WHERE adm=?";
            String sqlF2T1Ex3 = "SELECT * FROM tbl_f2_t1_ex3 WHERE adm=?";
            String sqlF2T2Ex3 = "SELECT * FROM tbl_f2_t2_ex3 WHERE adm=?";
            String sqlF2T3Ex3 = "SELECT * FROM tbl_f2_t3_ex3 WHERE adm=?";
            String sqlF3T1Ex3 = "SELECT * FROM tbl_f3_t1_ex3 WHERE adm=?";
            String sqlF3T2Ex3 = "SELECT * FROM tbl_f3_t2_ex3 WHERE adm=?";
            String sqlF3T3Ex3 = "SELECT * FROM tbl_f3_t3_ex3 WHERE adm=?";
            

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
                
                PreparedStatement statementE3 = connection.prepareStatement(sqlEx3);
                PreparedStatement statementF1T1E3 = connection.prepareStatement(sqlF1T1Ex3);
                PreparedStatement statementF1T2E3 = connection.prepareStatement(sqlF1T2Ex3);
                PreparedStatement statementF1T3E3 = connection.prepareStatement(sqlF1T3Ex3);
                PreparedStatement statementF2T1E3 = connection.prepareStatement(sqlF2T1Ex3);
                PreparedStatement statementF2T2E3 = connection.prepareStatement(sqlF2T2Ex3);
                PreparedStatement statementF2T3E3 = connection.prepareStatement(sqlF2T3Ex3);
                PreparedStatement statementF3T1E3 = connection.prepareStatement(sqlF3T1Ex3);
                PreparedStatement statementF3T2E3 = connection.prepareStatement(sqlF3T2Ex3);
                PreparedStatement statementF3T3E3 = connection.prepareStatement(sqlF3T3Ex3);
                


                statement.setString(1,adm);
                
                statementE3.setString(1,adm);
                statementF1T1E3.setString(1,adm);
                statementF1T2E3.setString(1,adm);
                statementF1T3E3.setString(1,adm);
                statementF2T1E3.setString(1,adm);
                statementF2T2E3.setString(1,adm);
                statementF2T3E3.setString(1,adm);
                statementF3T1E3.setString(1,adm);
                statementF3T2E3.setString(1,adm);
                statementF3T3E3.setString(1,adm);
                

                ResultSet set = statement.executeQuery();
                
                ResultSet setE3 = statementE3.executeQuery();
                 ResultSet setF1T1E3 = statementF1T1E3.executeQuery();
                ResultSet setF1T2E3 = statementF1T2E3.executeQuery();
                ResultSet setF1T3E3 = statementF1T3E3.executeQuery();
                ResultSet setF2T1E3 = statementF2T1E3.executeQuery();
                ResultSet setF2T2E3 = statementF2T2E3.executeQuery();
                ResultSet setF2T3E3 = statementF2T3E3.executeQuery();
                ResultSet setF3T1E3 = statementF3T1E3.executeQuery();
                ResultSet setF3T2E3 = statementF3T2E3.executeQuery();
                ResultSet setF3T3E3 = statementF3T3E3.executeQuery();
                

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

                document.add((new Paragraph("ADM: "+set.getString(2)+"  "+"NAME: "+set.getString(3)+"   "+set.getString(4)+" "+set.getString(5)+"  "+"KCPE:"+set.getString(6)+"  "+"CLASS:FORM 4"+"  "+"TERM:TERM 1",new Font(Font.FontFamily.TIMES_ROMAN, 9,Font.BOLD))));
                document.add((new Paragraph("YEAR:"+now.get(Calendar.YEAR)+" "+"POS:"+String.valueOf(pos)+" "+"OUT OF "+totalStudents,new Font(Font.FontFamily.TIMES_ROMAN, 9,Font.BOLD))));
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
                PdfPCell engD3 = new PdfPCell(new Paragraph(" "));
                PdfPCell engD4 = new PdfPCell(new Paragraph(setE3.getString(8)+" "+setE3.getString(9)));

                int avgE= Integer.parseInt(setE3.getString(8));
                if (avgE >= Integer.parseInt(setEngGrade.getString(4))) {com = setComments.getString(2); } else if (avgE >= Integer.parseInt(setEngGrade.getString(5))) { com = setComments.getString(3); }else if (avgE >=Integer.parseInt(setEngGrade.getString(6))){ com = setComments.getString(4);}else if (avgE >=Integer.parseInt(setEngGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgE >=Integer.parseInt(setEngGrade.getString(8))){  com = setComments.getString(6); }else if (avgE >=Integer.parseInt(setEngGrade.getString(9))){ com = setComments.getString(7); }else if (avgE >=Integer.parseInt(setEngGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgE >=Integer.parseInt(setEngGrade.getString(11))){ com = setComments.getString(9);}else if (avgE >=Integer.parseInt(setEngGrade.getString(12))){ com = setComments.getString(10);}else if (avgE >=Integer.parseInt(setEngGrade.getString(13))){ com = setComments.getString(11);}else if (avgE >=Integer.parseInt(setEngGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }
                PdfPCell engD5 = new PdfPCell(new Paragraph(setE3.getString(8)+" "+setE3.getString(9)));
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
                PdfPCell kisD3 = new PdfPCell(new Paragraph(" "));
                PdfPCell kisD4 = new PdfPCell(new Paragraph(setE3.getString(11)+" "+setE3.getString(12)));

                int avgKis= Integer.parseInt(setE3.getString(11));
                if (avgKis >= Integer.parseInt(setKisGrade.getString(4))) {com = setComments.getString(2); } else if (avgKis >= Integer.parseInt(setKisGrade.getString(5))) { com = setComments.getString(3); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(6))){ com = setComments.getString(4);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(8))){  com = setComments.getString(6); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(9))){ com = setComments.getString(7); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgKis >=Integer.parseInt(setKisGrade.getString(11))){ com = setComments.getString(9);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(12))){ com = setComments.getString(10);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(13))){ com = setComments.getString(11);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }
                PdfPCell kisD5 = new PdfPCell(new Paragraph(setE3.getString(11)+" "+setE3.getString(12)));
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
                PdfPCell matD3 = new PdfPCell(new Paragraph(" "));
                PdfPCell matD4 = new PdfPCell(new Paragraph(setE3.getString(14)+" "+setE3.getString(15)));

                int avgMat = Integer.parseInt(setE3.getString(14));
                if (avgMat >= Integer.parseInt(setMatGrade.getString(4))) {com = setComments.getString(2); } else if (avgMat >= Integer.parseInt(setMatGrade.getString(5))) { com = setComments.getString(3); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(6))){ com = setComments.getString(4);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(8))){  com = setComments.getString(6); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(9))){ com = setComments.getString(7); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgMat >=Integer.parseInt(setMatGrade.getString(11))){ com = setComments.getString(9);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(12))){ com = setComments.getString(10);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(13))){ com = setComments.getString(11);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell matD5 = new PdfPCell(new Paragraph(setE3.getString(14)+" "+setE3.getString(15)));
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
                PdfPCell chemD3 = new PdfPCell(new Paragraph(" "));
                PdfPCell chemD4 = new PdfPCell(new Paragraph(setE3.getString(20)+" "+setE3.getString(21)));

                int avgChem = Integer.parseInt(setE3.getString(20));
                if (avgChem >= Integer.parseInt(setChemGrade.getString(4))) {com = setComments.getString(2); } else if (avgChem >= Integer.parseInt(setChemGrade.getString(5))) { com = setComments.getString(3); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(6))){ com = setComments.getString(4);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(8))){  com = setComments.getString(6); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(9))){ com = setComments.getString(7); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgChem >=Integer.parseInt(setChemGrade.getString(11))){ com = setComments.getString(9);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(12))){ com = setComments.getString(10);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(13))){ com = setComments.getString(11);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell chemD5 = new PdfPCell(new Paragraph(setE3.getString(20)+" "+setE3.getString(21)));
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
                PdfPCell phyD3 = new PdfPCell(new Paragraph(" "));
                PdfPCell phyD4 = new PdfPCell(new Paragraph(setE3.getString(23)+" "+setE3.getString(24)));

                int avgPhy = Integer.parseInt(setE3.getString(23));
                if (avgPhy >= Integer.parseInt(setPhyGrade.getString(4))) {com = setComments.getString(2); } else if (avgPhy >= Integer.parseInt(setPhyGrade.getString(5))) { com = setComments.getString(3); }else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(6))){ com = setComments.getString(4);}else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(8))){  com = setComments.getString(6); }else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(9))){ com = setComments.getString(7); }else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(11))){ com = setComments.getString(9);}else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(12))){ com = setComments.getString(10);}else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(13))){ com = setComments.getString(11);}else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell phyD5 = new PdfPCell(new Paragraph(setE3.getString(23)+" "+setE3.getString(24)));
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
                PdfPCell creD3 = new PdfPCell(new Paragraph(" "));
                PdfPCell creD4 = new PdfPCell(new Paragraph(setE3.getString(32)+" "+setE3.getString(33)));

                int avgCre = Integer.parseInt(setE3.getString(32));
                if (avgCre >= Integer.parseInt(setCreGrade.getString(4))) {com = setComments.getString(2); } else if (avgCre >= Integer.parseInt(setCreGrade.getString(5))) { com = setComments.getString(3); }else if (avgCre >=Integer.parseInt(setCreGrade.getString(6))){ com = setComments.getString(4);}else if (avgCre >=Integer.parseInt(setCreGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgCre >=Integer.parseInt(setCreGrade.getString(8))){  com = setComments.getString(6); }else if (avgCre >=Integer.parseInt(setCreGrade.getString(9))){ com = setComments.getString(7); }else if (avgCre >=Integer.parseInt(setCreGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgCre >=Integer.parseInt(setCreGrade.getString(11))){ com = setComments.getString(9);}else if (avgCre >=Integer.parseInt(setCreGrade.getString(12))){ com = setComments.getString(10);}else if (avgCre >=Integer.parseInt(setCreGrade.getString(13))){ com = setComments.getString(11);}else if (avgCre >=Integer.parseInt(setCreGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell creD5 = new PdfPCell(new Paragraph(setE3.getString(32)+" "+setE3.getString(33)));
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
                PdfPCell busD3 = new PdfPCell(new Paragraph(" "));
                PdfPCell busD4 = new PdfPCell(new Paragraph(setE3.getString(35)+" "+setE3.getString(36)));

                int avgBus = Integer.parseInt(setE3.getString(35));
                if (avgBus >= Integer.parseInt(setBusGrade.getString(4))) {com = setComments.getString(2); } else if (avgBus >= Integer.parseInt(setBusGrade.getString(5))) { com = setComments.getString(3); }else if (avgBus >=Integer.parseInt(setBusGrade.getString(6))){ com = setComments.getString(4);}else if (avgBus >=Integer.parseInt(setBusGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgBus >=Integer.parseInt(setBusGrade.getString(8))){  com = setComments.getString(6); }else if (avgBus >=Integer.parseInt(setBusGrade.getString(9))){ com = setComments.getString(7); }else if (avgBus >=Integer.parseInt(setBusGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgBus >=Integer.parseInt(setBusGrade.getString(11))){ com = setComments.getString(9);}else if (avgBus >=Integer.parseInt(setBusGrade.getString(12))){ com = setComments.getString(10);}else if (avgBus >=Integer.parseInt(setBusGrade.getString(13))){ com = setComments.getString(11);}else if (avgBus >=Integer.parseInt(setBusGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell busD5 = new PdfPCell(new Paragraph(setE3.getString(35)+" "+setE3.getString(36)));
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
                
                int totalE3 = Integer.parseInt(setE3.getString(41));
                int totalAvg = Integer.parseInt(setE3.getString(41));


                PdfPCell totalD1 = new PdfPCell(new Paragraph("Total"));
                PdfPCell totalD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell totalD3 = new PdfPCell(new Paragraph(" "));
                PdfPCell totalD4 = new PdfPCell(new Paragraph(String.valueOf(totalE3)));
                PdfPCell totalD5 = new PdfPCell(new Paragraph(String.valueOf(totalAvg)));
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

               
                //int add2AvgEx2 = (Math.addExact(totalEx2Mat,addAvgEx2))/3;

                int addAvgEx3 = Math.round(totalE3/7);
                //int add2AvgEx3 = (Math.addExact(totalEx3Mat,addAvgEx3))/3;

                
                PdfPCell avgD1 = new PdfPCell(new Paragraph("Average"));
                PdfPCell avgD2 = new PdfPCell(new Paragraph(" "));
                
                PdfPCell avgD3 = new PdfPCell(new Paragraph(" "));

                if (addAvgEx3 >= Integer.parseInt(setTotal.getString(4))) {g = "A"; } else if (addAvgEx3 >= Integer.parseInt(setTotal.getString(5))) { g = "A-"; }else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(6))){ g = "B+";}else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(7))){
                    g = "B"; }else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(8))){  g = "B-"; }else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(9))){ g = "C+"; }else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(10))){ g = "C";
                }else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(11))){ g = "C-";}else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(12))){ g = "D+";}else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(13))){ g = "D";}else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(14))){
                    g = "D-";}else {g="E"; }
                PdfPCell avgD4 = new PdfPCell(new Paragraph(String.valueOf(addAvgEx3)+" "+setE3.getString(42)));

                //float avgAvgTotal = (addAvgEx1+addAvgEx2+addAvgEx3)/3;
                int avgAvgTotal=Integer.parseInt(setE3.getString(41))/7;

                if (avgAvgTotal >= Integer.parseInt(setTotal.getString(4))) {g = "A"; } else if (avgAvgTotal >= Integer.parseInt(setTotal.getString(5))) { g = "A-"; }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(6))){ g = "B+";}else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(7))){
                    g = "B"; }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(8))){  g = "B-"; }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(9))){ g = "C+"; }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(10))){ g = "C";
                }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(11))){ g = "C-";}else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(12))){ g = "D+";}else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(13))){ g = "D";}else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(14))){
                    g = "D-";}else {g="E"; }

                PdfPCell avgD5 = new PdfPCell(new Paragraph(String.valueOf(Math.round(avgAvgTotal))+" "+setE3.getString(42)));
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
                PdfPCell f1t1m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF1T1E3.getString(30)))/11)+" "+setF1T1E3.getString(31)));
                PdfPCell f2t1 = new PdfPCell(new Paragraph("F2T1"));
                PdfPCell f2t1m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF2T1E3.getString(30)))/11)+" "+setF2T1E3.getString(31)));
                PdfPCell f3t1 = new PdfPCell(new Paragraph("F3T1"));
                PdfPCell f3t1m = new PdfPCell(new Paragraph(String.valueOf(Integer.parseInt(setF3T1E3.getString(41))/11)+" "+setF3T1E3.getString(43)+" "+setF3T1E3.getString(42)));
                PdfPCell f4t1 = new PdfPCell(new Paragraph("F4T1"));
                PdfPCell f4t1m = new PdfPCell(new Paragraph(String.valueOf(avgAvgTotal)+" "+setE3.getString(42)+" "+setE3.getString(43)));
                tableLastSummary.addCell(f1t1);
                tableLastSummary.addCell(f1t1m);
                tableLastSummary.addCell(f2t1);
                tableLastSummary.addCell(f2t1m);
                tableLastSummary.addCell(f3t1);
                tableLastSummary.addCell(f3t1m);
                tableLastSummary.addCell(f4t1);
                tableLastSummary.addCell(f4t1m);

                PdfPCell f1t2 = new PdfPCell(new Paragraph("F1T2"));
                PdfPCell f1t2m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF1T2E3.getString(30)))/11)+" "+setF1T2E3.getString(31)));
                PdfPCell f2t2 = new PdfPCell(new Paragraph("F2T2"));
                PdfPCell f2t2m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF2T2E3.getString(30)))/11)+" "+setF2T2E3.getString(31)));
                PdfPCell f3t2 = new PdfPCell(new Paragraph("F3T2"));
                PdfPCell f3t2m = new PdfPCell(new Paragraph(String.valueOf(Integer.parseInt(setF3T2E3.getString(41))/11)+" "+setF3T2E3.getString(43)+" "+setF3T2E3.getString(42)));
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
                PdfPCell f1t3m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF1T3E3.getString(30)))/11)+" "+setF1T3E3.getString(31)));
                PdfPCell f2t3 = new PdfPCell(new Paragraph("F2T3"));
                PdfPCell f2t3m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF2T3E3.getString(30)))/11)+" "+setF2T3E3.getString(31)));
                PdfPCell f3t3 = new PdfPCell(new Paragraph("F3T3"));
                PdfPCell f3t3m = new PdfPCell(new Paragraph(String.valueOf(Integer.parseInt(setF3T3E3.getString(41))/11)+" "+setF3T3E3.getString(43)+" "+setF3T3E3.getString(42)));
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
               dataSet.setValue((Integer.parseInt(setF1T1E3.getString(30))/11)/7, "Marks", "F1T1");
                dataSet.setValue((Integer.parseInt(setF1T2E3.getString(30))/11)/7, "Marks", "F1T2");
                dataSet.setValue((Integer.parseInt(setF1T3E3.getString(30))/11)/7, "Marks", "F1T3");
                dataSet.setValue((Integer.parseInt(setF2T1E3.getString(30))/11)/7, "Marks", "F2T1");
                dataSet.setValue((Integer.parseInt(setF2T2E3.getString(30))/11)/7, "Marks", "F2T2");
                dataSet.setValue((Integer.parseInt(setF2T3E3.getString(30))/11)/7, "Marks", "F2T3");
                dataSet.setValue(Float.parseFloat(setF3T1E3.getString(43)), "Marks", "F3T1");
                dataSet.setValue(Float.parseFloat(setF3T2E3.getString(43)), "Marks", "F3T2");
                dataSet.setValue(Float.parseFloat(setF3T3E3.getString(43)), "Marks", "F3T3");
              dataSet.setValue(Float.parseFloat(setE3.getString(43)), "Marks", "F4T1");
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
                 document.newPage();
                connection.close();

            }catch (Exception e){
                e.printStackTrace();
                infoBoxError("An error occurred " + e,"Error",null);
            }}else {
            infoBoxError("You are not allowed to print","Error",null);
        }
    }

    private void printPhyHisAgri(String adm, Document document, PdfWriter writer, int pos, String totalStudents) {
        if(printPassword.toString().equals("vic")) {
            String sqlDetails="SELECT * FROM tbl_students WHERE adm=?";
            String sqlComm = "SELECT * FROM tbl_comments";
            String sqlTotal ="SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='TOTAL'";
            
            String sqlEx3 = "SELECT * FROM tbl_f4_t1_ex3 WHERE adm=? ";
             String sqlF1T1Ex3 = "SELECT * FROM tbl_f1_t1_ex3 WHERE adm=?";
            String sqlF1T2Ex3 = "SELECT * FROM tbl_f1_t2_ex3 WHERE adm=?";
            String sqlF1T3Ex3 = "SELECT * FROM tbl_f1_t3_ex3 WHERE adm=?";
            String sqlF2T1Ex3 = "SELECT * FROM tbl_f2_t1_ex3 WHERE adm=?";
            String sqlF2T2Ex3 = "SELECT * FROM tbl_f2_t2_ex3 WHERE adm=?";
            String sqlF2T3Ex3 = "SELECT * FROM tbl_f2_t3_ex3 WHERE adm=?";
            String sqlF3T1Ex3 = "SELECT * FROM tbl_f3_t1_ex3 WHERE adm=?";
            String sqlF3T2Ex3 = "SELECT * FROM tbl_f3_t2_ex3 WHERE adm=?";
            String sqlF3T3Ex3 = "SELECT * FROM tbl_f3_t3_ex3 WHERE adm=?";
            

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
                
                PreparedStatement statementE3 = connection.prepareStatement(sqlEx3);
                PreparedStatement statementF1T1E3 = connection.prepareStatement(sqlF1T1Ex3);
                PreparedStatement statementF1T2E3 = connection.prepareStatement(sqlF1T2Ex3);
                PreparedStatement statementF1T3E3 = connection.prepareStatement(sqlF1T3Ex3);
                PreparedStatement statementF2T1E3 = connection.prepareStatement(sqlF2T1Ex3);
                PreparedStatement statementF2T2E3 = connection.prepareStatement(sqlF2T2Ex3);
                PreparedStatement statementF2T3E3 = connection.prepareStatement(sqlF2T3Ex3);
                PreparedStatement statementF3T1E3 = connection.prepareStatement(sqlF3T1Ex3);
                PreparedStatement statementF3T2E3 = connection.prepareStatement(sqlF3T2Ex3);
                PreparedStatement statementF3T3E3 = connection.prepareStatement(sqlF3T3Ex3);
                


                statement.setString(1,adm);
                
                statementE3.setString(1,adm);
                statementF1T1E3.setString(1,adm);
                statementF1T2E3.setString(1,adm);
                statementF1T3E3.setString(1,adm);
                statementF2T1E3.setString(1,adm);
                statementF2T2E3.setString(1,adm);
                statementF2T3E3.setString(1,adm);
                statementF3T1E3.setString(1,adm);
                statementF3T2E3.setString(1,adm);
                statementF3T3E3.setString(1,adm);
                

                ResultSet set = statement.executeQuery();
                
                ResultSet setE3 = statementE3.executeQuery();
                 ResultSet setF1T1E3 = statementF1T1E3.executeQuery();
                ResultSet setF1T2E3 = statementF1T2E3.executeQuery();
                ResultSet setF1T3E3 = statementF1T3E3.executeQuery();
                ResultSet setF2T1E3 = statementF2T1E3.executeQuery();
                ResultSet setF2T2E3 = statementF2T2E3.executeQuery();
                ResultSet setF2T3E3 = statementF2T3E3.executeQuery();
                ResultSet setF3T1E3 = statementF3T1E3.executeQuery();
                ResultSet setF3T2E3 = statementF3T2E3.executeQuery();
                ResultSet setF3T3E3 = statementF3T3E3.executeQuery();
                

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

                document.add((new Paragraph("ADM: "+set.getString(2)+"  "+"NAME: "+set.getString(3)+"   "+set.getString(4)+" "+set.getString(5)+"  "+"KCPE:"+set.getString(6)+"  "+"CLASS:FORM 4"+"  "+"TERM:TERM 1",new Font(Font.FontFamily.TIMES_ROMAN, 9,Font.BOLD))));
                document.add((new Paragraph("YEAR:"+now.get(Calendar.YEAR)+" "+"POS:"+String.valueOf(pos)+" "+"OUT OF "+totalStudents,new Font(Font.FontFamily.TIMES_ROMAN, 9,Font.BOLD))));
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
                PdfPCell engD3 = new PdfPCell(new Paragraph(" "));
                PdfPCell engD4 = new PdfPCell(new Paragraph(setE3.getString(8)+" "+setE3.getString(9)));

                int avgE= Integer.parseInt(setE3.getString(8));
                if (avgE >= Integer.parseInt(setEngGrade.getString(4))) {com = setComments.getString(2); } else if (avgE >= Integer.parseInt(setEngGrade.getString(5))) { com = setComments.getString(3); }else if (avgE >=Integer.parseInt(setEngGrade.getString(6))){ com = setComments.getString(4);}else if (avgE >=Integer.parseInt(setEngGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgE >=Integer.parseInt(setEngGrade.getString(8))){  com = setComments.getString(6); }else if (avgE >=Integer.parseInt(setEngGrade.getString(9))){ com = setComments.getString(7); }else if (avgE >=Integer.parseInt(setEngGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgE >=Integer.parseInt(setEngGrade.getString(11))){ com = setComments.getString(9);}else if (avgE >=Integer.parseInt(setEngGrade.getString(12))){ com = setComments.getString(10);}else if (avgE >=Integer.parseInt(setEngGrade.getString(13))){ com = setComments.getString(11);}else if (avgE >=Integer.parseInt(setEngGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }
                PdfPCell engD5 = new PdfPCell(new Paragraph(setE3.getString(8)+" "+setE3.getString(9)));
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
                PdfPCell kisD3 = new PdfPCell(new Paragraph(" "));
                PdfPCell kisD4 = new PdfPCell(new Paragraph(setE3.getString(11)+" "+setE3.getString(12)));

                int avgKis= Integer.parseInt(setE3.getString(11));
                if (avgKis >= Integer.parseInt(setKisGrade.getString(4))) {com = setComments.getString(2); } else if (avgKis >= Integer.parseInt(setKisGrade.getString(5))) { com = setComments.getString(3); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(6))){ com = setComments.getString(4);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(8))){  com = setComments.getString(6); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(9))){ com = setComments.getString(7); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgKis >=Integer.parseInt(setKisGrade.getString(11))){ com = setComments.getString(9);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(12))){ com = setComments.getString(10);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(13))){ com = setComments.getString(11);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }
                PdfPCell kisD5 = new PdfPCell(new Paragraph(setE3.getString(11)+" "+setE3.getString(12)));
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
                PdfPCell matD3 = new PdfPCell(new Paragraph(" "));
                PdfPCell matD4 = new PdfPCell(new Paragraph(setE3.getString(14)+" "+setE3.getString(15)));

                int avgMat = Integer.parseInt(setE3.getString(14));
                if (avgMat >= Integer.parseInt(setMatGrade.getString(4))) {com = setComments.getString(2); } else if (avgMat >= Integer.parseInt(setMatGrade.getString(5))) { com = setComments.getString(3); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(6))){ com = setComments.getString(4);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(8))){  com = setComments.getString(6); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(9))){ com = setComments.getString(7); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgMat >=Integer.parseInt(setMatGrade.getString(11))){ com = setComments.getString(9);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(12))){ com = setComments.getString(10);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(13))){ com = setComments.getString(11);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell matD5 = new PdfPCell(new Paragraph(setE3.getString(14)+" "+setE3.getString(15)));
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
                PdfPCell chemD3 = new PdfPCell(new Paragraph(" "));
                PdfPCell chemD4 = new PdfPCell(new Paragraph(setE3.getString(20)+" "+setE3.getString(21)));

                int avgChem = Integer.parseInt(setE3.getString(20));
                if (avgChem >= Integer.parseInt(setChemGrade.getString(4))) {com = setComments.getString(2); } else if (avgChem >= Integer.parseInt(setChemGrade.getString(5))) { com = setComments.getString(3); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(6))){ com = setComments.getString(4);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(8))){  com = setComments.getString(6); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(9))){ com = setComments.getString(7); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgChem >=Integer.parseInt(setChemGrade.getString(11))){ com = setComments.getString(9);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(12))){ com = setComments.getString(10);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(13))){ com = setComments.getString(11);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell chemD5 = new PdfPCell(new Paragraph(setE3.getString(20)+" "+setE3.getString(21)));
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
                PdfPCell phyD3 = new PdfPCell(new Paragraph(" "));
                PdfPCell phyD4 = new PdfPCell(new Paragraph(setE3.getString(23)+" "+setE3.getString(24)));

                int avgPhy = Integer.parseInt(setE3.getString(23));
                if (avgPhy >= Integer.parseInt(setPhyGrade.getString(4))) {com = setComments.getString(2); } else if (avgPhy >= Integer.parseInt(setPhyGrade.getString(5))) { com = setComments.getString(3); }else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(6))){ com = setComments.getString(4);}else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(8))){  com = setComments.getString(6); }else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(9))){ com = setComments.getString(7); }else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(11))){ com = setComments.getString(9);}else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(12))){ com = setComments.getString(10);}else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(13))){ com = setComments.getString(11);}else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell phyD5 = new PdfPCell(new Paragraph(setE3.getString(23)+" "+setE3.getString(24)));
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
                PdfPCell hisD3 = new PdfPCell(new Paragraph(" "));
                PdfPCell hisD4 = new PdfPCell(new Paragraph(setE3.getString(29)+" "+setE3.getString(30)));

                int avgHis = Integer.parseInt(setE3.getString(29));
                if (avgHis >= Integer.parseInt(setHisGrade.getString(4))) {com = setComments.getString(2); } else if (avgHis >= Integer.parseInt(setHisGrade.getString(5))) { com = setComments.getString(3); }else if (avgHis >=Integer.parseInt(setHisGrade.getString(6))){ com = setComments.getString(4);}else if (avgHis >=Integer.parseInt(setHisGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgHis >=Integer.parseInt(setHisGrade.getString(8))){  com = setComments.getString(6); }else if (avgHis >=Integer.parseInt(setHisGrade.getString(9))){ com = setComments.getString(7); }else if (avgHis >=Integer.parseInt(setHisGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgHis >=Integer.parseInt(setHisGrade.getString(11))){ com = setComments.getString(9);}else if (avgHis >=Integer.parseInt(setHisGrade.getString(12))){ com = setComments.getString(10);}else if (avgHis >=Integer.parseInt(setHisGrade.getString(13))){ com = setComments.getString(11);}else if (avgHis >=Integer.parseInt(setHisGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell hisD5 = new PdfPCell(new Paragraph(setE3.getString(29)+" "+setE3.getString(30)));
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
                PdfPCell agriD3 = new PdfPCell(new Paragraph(" "));
                PdfPCell agriD4 = new PdfPCell(new Paragraph(setE3.getString(38)+" "+setE3.getString(39)));

                int avgAgri = Integer.parseInt(setE3.getString(38));
                if (avgAgri >= Integer.parseInt(setAgriGrade.getString(4))) {com = setComments.getString(2); } else if (avgAgri >= Integer.parseInt(setAgriGrade.getString(5))) { com = setComments.getString(3); }else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(6))){ com = setComments.getString(4);}else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(8))){  com = setComments.getString(6); }else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(9))){ com = setComments.getString(7); }else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(11))){ com = setComments.getString(9);}else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(12))){ com = setComments.getString(10);}else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(13))){ com = setComments.getString(11);}else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell agriD5 = new PdfPCell(new Paragraph(setE3.getString(38)+" "+setE3.getString(39)));
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
                
                int totalE3 = Integer.parseInt(setE3.getString(41));
                int totalAvg = Integer.parseInt(setE3.getString(41));


                PdfPCell totalD1 = new PdfPCell(new Paragraph("Total"));
                PdfPCell totalD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell totalD3 = new PdfPCell(new Paragraph(" "));
                PdfPCell totalD4 = new PdfPCell(new Paragraph(String.valueOf(totalE3)));
                PdfPCell totalD5 = new PdfPCell(new Paragraph(String.valueOf(totalAvg)));
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

               
                //int add2AvgEx2 = (Math.addExact(totalEx2Mat,addAvgEx2))/3;

                int addAvgEx3 = Math.round(totalE3/7);
                //int add2AvgEx3 = (Math.addExact(totalEx3Mat,addAvgEx3))/3;

                
                PdfPCell avgD1 = new PdfPCell(new Paragraph("Average"));
                PdfPCell avgD2 = new PdfPCell(new Paragraph(" "));
                
                PdfPCell avgD3 = new PdfPCell(new Paragraph(" "));

                if (addAvgEx3 >= Integer.parseInt(setTotal.getString(4))) {g = "A"; } else if (addAvgEx3 >= Integer.parseInt(setTotal.getString(5))) { g = "A-"; }else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(6))){ g = "B+";}else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(7))){
                    g = "B"; }else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(8))){  g = "B-"; }else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(9))){ g = "C+"; }else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(10))){ g = "C";
                }else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(11))){ g = "C-";}else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(12))){ g = "D+";}else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(13))){ g = "D";}else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(14))){
                    g = "D-";}else {g="E"; }
                PdfPCell avgD4 = new PdfPCell(new Paragraph(String.valueOf(addAvgEx3)+" "+setE3.getString(42)));

                //float avgAvgTotal = (addAvgEx1+addAvgEx2+addAvgEx3)/3;
                int avgAvgTotal=Integer.parseInt(setE3.getString(41))/7;

                if (avgAvgTotal >= Integer.parseInt(setTotal.getString(4))) {g = "A"; } else if (avgAvgTotal >= Integer.parseInt(setTotal.getString(5))) { g = "A-"; }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(6))){ g = "B+";}else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(7))){
                    g = "B"; }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(8))){  g = "B-"; }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(9))){ g = "C+"; }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(10))){ g = "C";
                }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(11))){ g = "C-";}else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(12))){ g = "D+";}else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(13))){ g = "D";}else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(14))){
                    g = "D-";}else {g="E"; }

                PdfPCell avgD5 = new PdfPCell(new Paragraph(String.valueOf(Math.round(avgAvgTotal))+" "+setE3.getString(42)));
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
                PdfPCell f1t1m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF1T1E3.getString(30)))/11)+" "+setF1T1E3.getString(31)));
                PdfPCell f2t1 = new PdfPCell(new Paragraph("F2T1"));
                PdfPCell f2t1m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF2T1E3.getString(30)))/11)+" "+setF2T1E3.getString(31)));
                PdfPCell f3t1 = new PdfPCell(new Paragraph("F3T1"));
                PdfPCell f3t1m = new PdfPCell(new Paragraph(String.valueOf(Integer.parseInt(setF3T1E3.getString(41))/11)+" "+setF3T1E3.getString(43)+" "+setF3T1E3.getString(42)));
                PdfPCell f4t1 = new PdfPCell(new Paragraph("F4T1"));
                PdfPCell f4t1m = new PdfPCell(new Paragraph(String.valueOf(avgAvgTotal)+" "+setE3.getString(42)+" "+setE3.getString(43)));
                tableLastSummary.addCell(f1t1);
                tableLastSummary.addCell(f1t1m);
                tableLastSummary.addCell(f2t1);
                tableLastSummary.addCell(f2t1m);
                tableLastSummary.addCell(f3t1);
                tableLastSummary.addCell(f3t1m);
                tableLastSummary.addCell(f4t1);
                tableLastSummary.addCell(f4t1m);

                PdfPCell f1t2 = new PdfPCell(new Paragraph("F1T2"));
                PdfPCell f1t2m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF1T2E3.getString(30)))/11)+" "+setF1T2E3.getString(31)));
                PdfPCell f2t2 = new PdfPCell(new Paragraph("F2T2"));
                PdfPCell f2t2m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF2T2E3.getString(30)))/11)+" "+setF2T2E3.getString(31)));
                PdfPCell f3t2 = new PdfPCell(new Paragraph("F3T2"));
                PdfPCell f3t2m = new PdfPCell(new Paragraph(String.valueOf(Integer.parseInt(setF3T2E3.getString(41))/11)+" "+setF3T2E3.getString(43)+" "+setF3T2E3.getString(42)));
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
                PdfPCell f1t3m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF1T3E3.getString(30)))/11)+" "+setF1T3E3.getString(31)));
                PdfPCell f2t3 = new PdfPCell(new Paragraph("F2T3"));
                PdfPCell f2t3m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF2T3E3.getString(30)))/11)+" "+setF2T3E3.getString(31)));
                PdfPCell f3t3 = new PdfPCell(new Paragraph("F3T3"));
                PdfPCell f3t3m = new PdfPCell(new Paragraph(String.valueOf(Integer.parseInt(setF3T3E3.getString(41))/11)+" "+setF3T3E3.getString(43)+" "+setF3T3E3.getString(42)));
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
               dataSet.setValue((Integer.parseInt(setF1T1E3.getString(30))/11)/7, "Marks", "F1T1");
                dataSet.setValue((Integer.parseInt(setF1T2E3.getString(30))/11)/7, "Marks", "F1T2");
                dataSet.setValue((Integer.parseInt(setF1T3E3.getString(30))/11)/7, "Marks", "F1T3");
                dataSet.setValue((Integer.parseInt(setF2T1E3.getString(30))/11)/7, "Marks", "F2T1");
                dataSet.setValue((Integer.parseInt(setF2T2E3.getString(30))/11)/7, "Marks", "F2T2");
                dataSet.setValue((Integer.parseInt(setF2T3E3.getString(30))/11)/7, "Marks", "F2T3");
                dataSet.setValue(Float.parseFloat(setF3T1E3.getString(43)), "Marks", "F3T1");
                dataSet.setValue(Float.parseFloat(setF3T2E3.getString(43)), "Marks", "F3T2");
                dataSet.setValue(Float.parseFloat(setF3T3E3.getString(43)), "Marks", "F3T3");
              dataSet.setValue(Float.parseFloat(setE3.getString(43)), "Marks", "F4T1");
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
                 document.newPage();
                connection.close();

            }catch (Exception e){
                e.printStackTrace();
                infoBoxError("An error occurred " + e,"Error",null);
            }}else {
            infoBoxError("You are not allowed to print","Error",null);
        }
    }

    private void printPhyHisBus(String adm, Document document, PdfWriter writer, int pos, String totalStudents) {
        if(printPassword.toString().equals("vic")) {
            String sqlDetails="SELECT * FROM tbl_students WHERE adm=?";
            String sqlComm = "SELECT * FROM tbl_comments";
            String sqlTotal ="SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='TOTAL'";
            
            String sqlEx3 = "SELECT * FROM tbl_f4_t1_ex3 WHERE adm=? ";
             String sqlF1T1Ex3 = "SELECT * FROM tbl_f1_t1_ex3 WHERE adm=?";
            String sqlF1T2Ex3 = "SELECT * FROM tbl_f1_t2_ex3 WHERE adm=?";
            String sqlF1T3Ex3 = "SELECT * FROM tbl_f1_t3_ex3 WHERE adm=?";
            String sqlF2T1Ex3 = "SELECT * FROM tbl_f2_t1_ex3 WHERE adm=?";
            String sqlF2T2Ex3 = "SELECT * FROM tbl_f2_t2_ex3 WHERE adm=?";
            String sqlF2T3Ex3 = "SELECT * FROM tbl_f2_t3_ex3 WHERE adm=?";
            String sqlF3T1Ex3 = "SELECT * FROM tbl_f3_t1_ex3 WHERE adm=?";
            String sqlF3T2Ex3 = "SELECT * FROM tbl_f3_t2_ex3 WHERE adm=?";
            String sqlF3T3Ex3 = "SELECT * FROM tbl_f3_t3_ex3 WHERE adm=?";
            

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
                
                PreparedStatement statementE3 = connection.prepareStatement(sqlEx3);
                PreparedStatement statementF1T1E3 = connection.prepareStatement(sqlF1T1Ex3);
                PreparedStatement statementF1T2E3 = connection.prepareStatement(sqlF1T2Ex3);
                PreparedStatement statementF1T3E3 = connection.prepareStatement(sqlF1T3Ex3);
                PreparedStatement statementF2T1E3 = connection.prepareStatement(sqlF2T1Ex3);
                PreparedStatement statementF2T2E3 = connection.prepareStatement(sqlF2T2Ex3);
                PreparedStatement statementF2T3E3 = connection.prepareStatement(sqlF2T3Ex3);
                PreparedStatement statementF3T1E3 = connection.prepareStatement(sqlF3T1Ex3);
                PreparedStatement statementF3T2E3 = connection.prepareStatement(sqlF3T2Ex3);
                PreparedStatement statementF3T3E3 = connection.prepareStatement(sqlF3T3Ex3);
                


                statement.setString(1,adm);
                
                statementE3.setString(1,adm);
                statementF1T1E3.setString(1,adm);
                statementF1T2E3.setString(1,adm);
                statementF1T3E3.setString(1,adm);
                statementF2T1E3.setString(1,adm);
                statementF2T2E3.setString(1,adm);
                statementF2T3E3.setString(1,adm);
                statementF3T1E3.setString(1,adm);
                statementF3T2E3.setString(1,adm);
                statementF3T3E3.setString(1,adm);
                

                ResultSet set = statement.executeQuery();
                
                ResultSet setE3 = statementE3.executeQuery();
                 ResultSet setF1T1E3 = statementF1T1E3.executeQuery();
                ResultSet setF1T2E3 = statementF1T2E3.executeQuery();
                ResultSet setF1T3E3 = statementF1T3E3.executeQuery();
                ResultSet setF2T1E3 = statementF2T1E3.executeQuery();
                ResultSet setF2T2E3 = statementF2T2E3.executeQuery();
                ResultSet setF2T3E3 = statementF2T3E3.executeQuery();
                ResultSet setF3T1E3 = statementF3T1E3.executeQuery();
                ResultSet setF3T2E3 = statementF3T2E3.executeQuery();
                ResultSet setF3T3E3 = statementF3T3E3.executeQuery();
                

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

                document.add((new Paragraph("ADM: "+set.getString(2)+"  "+"NAME: "+set.getString(3)+"   "+set.getString(4)+" "+set.getString(5)+"  "+"KCPE:"+set.getString(6)+"  "+"CLASS:FORM 4"+"  "+"TERM:TERM 1",new Font(Font.FontFamily.TIMES_ROMAN, 9,Font.BOLD))));
                document.add((new Paragraph("YEAR:"+now.get(Calendar.YEAR)+" "+"POS:"+String.valueOf(pos)+" "+"OUT OF "+totalStudents,new Font(Font.FontFamily.TIMES_ROMAN, 9,Font.BOLD))));
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
                PdfPCell engD3 = new PdfPCell(new Paragraph(" "));
                PdfPCell engD4 = new PdfPCell(new Paragraph(setE3.getString(8)+" "+setE3.getString(9)));

                int avgE= Integer.parseInt(setE3.getString(8));
                if (avgE >= Integer.parseInt(setEngGrade.getString(4))) {com = setComments.getString(2); } else if (avgE >= Integer.parseInt(setEngGrade.getString(5))) { com = setComments.getString(3); }else if (avgE >=Integer.parseInt(setEngGrade.getString(6))){ com = setComments.getString(4);}else if (avgE >=Integer.parseInt(setEngGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgE >=Integer.parseInt(setEngGrade.getString(8))){  com = setComments.getString(6); }else if (avgE >=Integer.parseInt(setEngGrade.getString(9))){ com = setComments.getString(7); }else if (avgE >=Integer.parseInt(setEngGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgE >=Integer.parseInt(setEngGrade.getString(11))){ com = setComments.getString(9);}else if (avgE >=Integer.parseInt(setEngGrade.getString(12))){ com = setComments.getString(10);}else if (avgE >=Integer.parseInt(setEngGrade.getString(13))){ com = setComments.getString(11);}else if (avgE >=Integer.parseInt(setEngGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }
                PdfPCell engD5 = new PdfPCell(new Paragraph(setE3.getString(8)+" "+setE3.getString(9)));
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
                PdfPCell kisD3 = new PdfPCell(new Paragraph(" "));
                PdfPCell kisD4 = new PdfPCell(new Paragraph(setE3.getString(11)+" "+setE3.getString(12)));

                int avgKis= Integer.parseInt(setE3.getString(11));
                if (avgKis >= Integer.parseInt(setKisGrade.getString(4))) {com = setComments.getString(2); } else if (avgKis >= Integer.parseInt(setKisGrade.getString(5))) { com = setComments.getString(3); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(6))){ com = setComments.getString(4);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(8))){  com = setComments.getString(6); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(9))){ com = setComments.getString(7); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgKis >=Integer.parseInt(setKisGrade.getString(11))){ com = setComments.getString(9);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(12))){ com = setComments.getString(10);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(13))){ com = setComments.getString(11);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }
                PdfPCell kisD5 = new PdfPCell(new Paragraph(setE3.getString(11)+" "+setE3.getString(12)));
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
                PdfPCell matD3 = new PdfPCell(new Paragraph(" "));
                PdfPCell matD4 = new PdfPCell(new Paragraph(setE3.getString(14)+" "+setE3.getString(15)));

                int avgMat = Integer.parseInt(setE3.getString(14));
                if (avgMat >= Integer.parseInt(setMatGrade.getString(4))) {com = setComments.getString(2); } else if (avgMat >= Integer.parseInt(setMatGrade.getString(5))) { com = setComments.getString(3); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(6))){ com = setComments.getString(4);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(8))){  com = setComments.getString(6); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(9))){ com = setComments.getString(7); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgMat >=Integer.parseInt(setMatGrade.getString(11))){ com = setComments.getString(9);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(12))){ com = setComments.getString(10);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(13))){ com = setComments.getString(11);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell matD5 = new PdfPCell(new Paragraph(setE3.getString(14)+" "+setE3.getString(15)));
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
                PdfPCell chemD3 = new PdfPCell(new Paragraph(" "));
                PdfPCell chemD4 = new PdfPCell(new Paragraph(setE3.getString(20)+" "+setE3.getString(21)));

                int avgChem = Integer.parseInt(setE3.getString(20));
                if (avgChem >= Integer.parseInt(setChemGrade.getString(4))) {com = setComments.getString(2); } else if (avgChem >= Integer.parseInt(setChemGrade.getString(5))) { com = setComments.getString(3); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(6))){ com = setComments.getString(4);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(8))){  com = setComments.getString(6); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(9))){ com = setComments.getString(7); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgChem >=Integer.parseInt(setChemGrade.getString(11))){ com = setComments.getString(9);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(12))){ com = setComments.getString(10);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(13))){ com = setComments.getString(11);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell chemD5 = new PdfPCell(new Paragraph(setE3.getString(20)+" "+setE3.getString(21)));
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
                PdfPCell phyD3 = new PdfPCell(new Paragraph(" "));
                PdfPCell phyD4 = new PdfPCell(new Paragraph(setE3.getString(23)+" "+setE3.getString(24)));

                int avgPhy = Integer.parseInt(setE3.getString(23));
                if (avgPhy >= Integer.parseInt(setPhyGrade.getString(4))) {com = setComments.getString(2); } else if (avgPhy >= Integer.parseInt(setPhyGrade.getString(5))) { com = setComments.getString(3); }else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(6))){ com = setComments.getString(4);}else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(8))){  com = setComments.getString(6); }else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(9))){ com = setComments.getString(7); }else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(11))){ com = setComments.getString(9);}else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(12))){ com = setComments.getString(10);}else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(13))){ com = setComments.getString(11);}else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell phyD5 = new PdfPCell(new Paragraph(setE3.getString(23)+" "+setE3.getString(24)));
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
                PdfPCell hisD3 = new PdfPCell(new Paragraph(" "));
                PdfPCell hisD4 = new PdfPCell(new Paragraph(setE3.getString(29)+" "+setE3.getString(30)));

                int avgHis = Integer.parseInt(setE3.getString(29));
                if (avgHis >= Integer.parseInt(setHisGrade.getString(4))) {com = setComments.getString(2); } else if (avgHis >= Integer.parseInt(setHisGrade.getString(5))) { com = setComments.getString(3); }else if (avgHis >=Integer.parseInt(setHisGrade.getString(6))){ com = setComments.getString(4);}else if (avgHis >=Integer.parseInt(setHisGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgHis >=Integer.parseInt(setHisGrade.getString(8))){  com = setComments.getString(6); }else if (avgHis >=Integer.parseInt(setHisGrade.getString(9))){ com = setComments.getString(7); }else if (avgHis >=Integer.parseInt(setHisGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgHis >=Integer.parseInt(setHisGrade.getString(11))){ com = setComments.getString(9);}else if (avgHis >=Integer.parseInt(setHisGrade.getString(12))){ com = setComments.getString(10);}else if (avgHis >=Integer.parseInt(setHisGrade.getString(13))){ com = setComments.getString(11);}else if (avgHis >=Integer.parseInt(setHisGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell hisD5 = new PdfPCell(new Paragraph(setE3.getString(29)+" "+setE3.getString(30)));
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
                PdfPCell busD3 = new PdfPCell(new Paragraph(" "));
                PdfPCell busD4 = new PdfPCell(new Paragraph(setE3.getString(35)+" "+setE3.getString(36)));

                int avgBus = Integer.parseInt(setE3.getString(35));
                if (avgBus >= Integer.parseInt(setBusGrade.getString(4))) {com = setComments.getString(2); } else if (avgBus >= Integer.parseInt(setBusGrade.getString(5))) { com = setComments.getString(3); }else if (avgBus >=Integer.parseInt(setBusGrade.getString(6))){ com = setComments.getString(4);}else if (avgBus >=Integer.parseInt(setBusGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgBus >=Integer.parseInt(setBusGrade.getString(8))){  com = setComments.getString(6); }else if (avgBus >=Integer.parseInt(setBusGrade.getString(9))){ com = setComments.getString(7); }else if (avgBus >=Integer.parseInt(setBusGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgBus >=Integer.parseInt(setBusGrade.getString(11))){ com = setComments.getString(9);}else if (avgBus >=Integer.parseInt(setBusGrade.getString(12))){ com = setComments.getString(10);}else if (avgBus >=Integer.parseInt(setBusGrade.getString(13))){ com = setComments.getString(11);}else if (avgBus >=Integer.parseInt(setBusGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell busD5 = new PdfPCell(new Paragraph(setE3.getString(35)+" "+setE3.getString(36)));
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
                
                int totalE3 = Integer.parseInt(setE3.getString(41));
                int totalAvg = Integer.parseInt(setE3.getString(41));


                PdfPCell totalD1 = new PdfPCell(new Paragraph("Total"));
                PdfPCell totalD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell totalD3 = new PdfPCell(new Paragraph(" "));
                PdfPCell totalD4 = new PdfPCell(new Paragraph(String.valueOf(totalE3)));
                PdfPCell totalD5 = new PdfPCell(new Paragraph(String.valueOf(totalAvg)));
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

               
                //int add2AvgEx2 = (Math.addExact(totalEx2Mat,addAvgEx2))/3;

                int addAvgEx3 = Math.round(totalE3/7);
                //int add2AvgEx3 = (Math.addExact(totalEx3Mat,addAvgEx3))/3;

                
                PdfPCell avgD1 = new PdfPCell(new Paragraph("Average"));
                PdfPCell avgD2 = new PdfPCell(new Paragraph(" "));
                
                PdfPCell avgD3 = new PdfPCell(new Paragraph(" "));

                if (addAvgEx3 >= Integer.parseInt(setTotal.getString(4))) {g = "A"; } else if (addAvgEx3 >= Integer.parseInt(setTotal.getString(5))) { g = "A-"; }else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(6))){ g = "B+";}else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(7))){
                    g = "B"; }else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(8))){  g = "B-"; }else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(9))){ g = "C+"; }else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(10))){ g = "C";
                }else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(11))){ g = "C-";}else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(12))){ g = "D+";}else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(13))){ g = "D";}else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(14))){
                    g = "D-";}else {g="E"; }
                PdfPCell avgD4 = new PdfPCell(new Paragraph(String.valueOf(addAvgEx3)+" "+setE3.getString(42)));

                //float avgAvgTotal = (addAvgEx1+addAvgEx2+addAvgEx3)/3;
                int avgAvgTotal=Integer.parseInt(setE3.getString(41))/7;

                if (avgAvgTotal >= Integer.parseInt(setTotal.getString(4))) {g = "A"; } else if (avgAvgTotal >= Integer.parseInt(setTotal.getString(5))) { g = "A-"; }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(6))){ g = "B+";}else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(7))){
                    g = "B"; }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(8))){  g = "B-"; }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(9))){ g = "C+"; }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(10))){ g = "C";
                }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(11))){ g = "C-";}else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(12))){ g = "D+";}else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(13))){ g = "D";}else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(14))){
                    g = "D-";}else {g="E"; }

                PdfPCell avgD5 = new PdfPCell(new Paragraph(String.valueOf(Math.round(avgAvgTotal))+" "+setE3.getString(42)));
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
                PdfPCell f1t1m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF1T1E3.getString(30)))/11)+" "+setF1T1E3.getString(31)));
                PdfPCell f2t1 = new PdfPCell(new Paragraph("F2T1"));
                PdfPCell f2t1m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF2T1E3.getString(30)))/11)+" "+setF2T1E3.getString(31)));
                PdfPCell f3t1 = new PdfPCell(new Paragraph("F3T1"));
                PdfPCell f3t1m = new PdfPCell(new Paragraph(String.valueOf(Integer.parseInt(setF3T1E3.getString(41))/11)+" "+setF3T1E3.getString(43)+" "+setF3T1E3.getString(42)));
                PdfPCell f4t1 = new PdfPCell(new Paragraph("F4T1"));
                PdfPCell f4t1m = new PdfPCell(new Paragraph(String.valueOf(avgAvgTotal)+" "+setE3.getString(42)+" "+setE3.getString(43)));
                tableLastSummary.addCell(f1t1);
                tableLastSummary.addCell(f1t1m);
                tableLastSummary.addCell(f2t1);
                tableLastSummary.addCell(f2t1m);
                tableLastSummary.addCell(f3t1);
                tableLastSummary.addCell(f3t1m);
                tableLastSummary.addCell(f4t1);
                tableLastSummary.addCell(f4t1m);

                PdfPCell f1t2 = new PdfPCell(new Paragraph("F1T2"));
                PdfPCell f1t2m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF1T2E3.getString(30)))/11)+" "+setF1T2E3.getString(31)));
                PdfPCell f2t2 = new PdfPCell(new Paragraph("F2T2"));
                PdfPCell f2t2m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF2T2E3.getString(30)))/11)+" "+setF2T2E3.getString(31)));
                PdfPCell f3t2 = new PdfPCell(new Paragraph("F3T2"));
                PdfPCell f3t2m = new PdfPCell(new Paragraph(String.valueOf(Integer.parseInt(setF3T2E3.getString(41))/11)+" "+setF3T2E3.getString(43)+" "+setF3T2E3.getString(42)));
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
                PdfPCell f1t3m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF1T3E3.getString(30)))/11)+" "+setF1T3E3.getString(31)));
                PdfPCell f2t3 = new PdfPCell(new Paragraph("F2T3"));
                PdfPCell f2t3m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF2T3E3.getString(30)))/11)+" "+setF2T3E3.getString(31)));
                PdfPCell f3t3 = new PdfPCell(new Paragraph("F3T3"));
                PdfPCell f3t3m = new PdfPCell(new Paragraph(String.valueOf(Integer.parseInt(setF3T3E3.getString(41))/11)+" "+setF3T3E3.getString(43)+" "+setF3T3E3.getString(42)));
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
               dataSet.setValue((Integer.parseInt(setF1T1E3.getString(30))/11)/7, "Marks", "F1T1");
                dataSet.setValue((Integer.parseInt(setF1T2E3.getString(30))/11)/7, "Marks", "F1T2");
                dataSet.setValue((Integer.parseInt(setF1T3E3.getString(30))/11)/7, "Marks", "F1T3");
                dataSet.setValue((Integer.parseInt(setF2T1E3.getString(30))/11)/7, "Marks", "F2T1");
                dataSet.setValue((Integer.parseInt(setF2T2E3.getString(30))/11)/7, "Marks", "F2T2");
                dataSet.setValue((Integer.parseInt(setF2T3E3.getString(30))/11)/7, "Marks", "F2T3");
                dataSet.setValue(Float.parseFloat(setF3T1E3.getString(43)), "Marks", "F3T1");
                dataSet.setValue(Float.parseFloat(setF3T2E3.getString(43)), "Marks", "F3T2");
                dataSet.setValue(Float.parseFloat(setF3T3E3.getString(43)), "Marks", "F3T3");
              dataSet.setValue(Float.parseFloat(setE3.getString(43)), "Marks", "F4T1");
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
                 document.newPage();
                connection.close();

            }catch (Exception e){
                e.printStackTrace();
                infoBoxError("An error occurred " + e,"Error",null);
            }}else {
            infoBoxError("You are not allowed to print","Error",null);
        }
    }

    private void printPhyGeoAgri(String adm, Document document, PdfWriter writer, int pos, String totalStudents) {
        if(printPassword.toString().equals("vic")) {
            String sqlDetails="SELECT * FROM tbl_students WHERE adm=?";
            String sqlComm = "SELECT * FROM tbl_comments";
            String sqlTotal ="SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='TOTAL'";
            
            String sqlEx3 = "SELECT * FROM tbl_f4_t1_ex3 WHERE adm=? ";
             String sqlF1T1Ex3 = "SELECT * FROM tbl_f1_t1_ex3 WHERE adm=?";
            String sqlF1T2Ex3 = "SELECT * FROM tbl_f1_t2_ex3 WHERE adm=?";
            String sqlF1T3Ex3 = "SELECT * FROM tbl_f1_t3_ex3 WHERE adm=?";
            String sqlF2T1Ex3 = "SELECT * FROM tbl_f2_t1_ex3 WHERE adm=?";
            String sqlF2T2Ex3 = "SELECT * FROM tbl_f2_t2_ex3 WHERE adm=?";
            String sqlF2T3Ex3 = "SELECT * FROM tbl_f2_t3_ex3 WHERE adm=?";
            String sqlF3T1Ex3 = "SELECT * FROM tbl_f3_t1_ex3 WHERE adm=?";
            String sqlF3T2Ex3 = "SELECT * FROM tbl_f3_t2_ex3 WHERE adm=?";
            String sqlF3T3Ex3 = "SELECT * FROM tbl_f3_t3_ex3 WHERE adm=?";
            

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
                
                PreparedStatement statementE3 = connection.prepareStatement(sqlEx3);
                PreparedStatement statementF1T1E3 = connection.prepareStatement(sqlF1T1Ex3);
                PreparedStatement statementF1T2E3 = connection.prepareStatement(sqlF1T2Ex3);
                PreparedStatement statementF1T3E3 = connection.prepareStatement(sqlF1T3Ex3);
                PreparedStatement statementF2T1E3 = connection.prepareStatement(sqlF2T1Ex3);
                PreparedStatement statementF2T2E3 = connection.prepareStatement(sqlF2T2Ex3);
                PreparedStatement statementF2T3E3 = connection.prepareStatement(sqlF2T3Ex3);
                PreparedStatement statementF3T1E3 = connection.prepareStatement(sqlF3T1Ex3);
                PreparedStatement statementF3T2E3 = connection.prepareStatement(sqlF3T2Ex3);
                PreparedStatement statementF3T3E3 = connection.prepareStatement(sqlF3T3Ex3);
                


                statement.setString(1,adm);
                
                statementE3.setString(1,adm);
                statementF1T1E3.setString(1,adm);
                statementF1T2E3.setString(1,adm);
                statementF1T3E3.setString(1,adm);
                statementF2T1E3.setString(1,adm);
                statementF2T2E3.setString(1,adm);
                statementF2T3E3.setString(1,adm);
                statementF3T1E3.setString(1,adm);
                statementF3T2E3.setString(1,adm);
                statementF3T3E3.setString(1,adm);
                

                ResultSet set = statement.executeQuery();
                
                ResultSet setE3 = statementE3.executeQuery();
                 ResultSet setF1T1E3 = statementF1T1E3.executeQuery();
                ResultSet setF1T2E3 = statementF1T2E3.executeQuery();
                ResultSet setF1T3E3 = statementF1T3E3.executeQuery();
                ResultSet setF2T1E3 = statementF2T1E3.executeQuery();
                ResultSet setF2T2E3 = statementF2T2E3.executeQuery();
                ResultSet setF2T3E3 = statementF2T3E3.executeQuery();
                ResultSet setF3T1E3 = statementF3T1E3.executeQuery();
                ResultSet setF3T2E3 = statementF3T2E3.executeQuery();
                ResultSet setF3T3E3 = statementF3T3E3.executeQuery();
                

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

                document.add((new Paragraph("ADM: "+set.getString(2)+"  "+"NAME: "+set.getString(3)+"   "+set.getString(4)+" "+set.getString(5)+"  "+"KCPE:"+set.getString(6)+"  "+"CLASS:FORM 4"+"  "+"TERM:TERM 1",new Font(Font.FontFamily.TIMES_ROMAN, 9,Font.BOLD))));
                document.add((new Paragraph("YEAR:"+now.get(Calendar.YEAR)+" "+"POS:"+String.valueOf(pos)+" "+"OUT OF "+totalStudents,new Font(Font.FontFamily.TIMES_ROMAN, 9,Font.BOLD))));
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
                PdfPCell engD3 = new PdfPCell(new Paragraph(" "));
                PdfPCell engD4 = new PdfPCell(new Paragraph(setE3.getString(8)+" "+setE3.getString(9)));

                int avgE= Integer.parseInt(setE3.getString(8));
                if (avgE >= Integer.parseInt(setEngGrade.getString(4))) {com = setComments.getString(2); } else if (avgE >= Integer.parseInt(setEngGrade.getString(5))) { com = setComments.getString(3); }else if (avgE >=Integer.parseInt(setEngGrade.getString(6))){ com = setComments.getString(4);}else if (avgE >=Integer.parseInt(setEngGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgE >=Integer.parseInt(setEngGrade.getString(8))){  com = setComments.getString(6); }else if (avgE >=Integer.parseInt(setEngGrade.getString(9))){ com = setComments.getString(7); }else if (avgE >=Integer.parseInt(setEngGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgE >=Integer.parseInt(setEngGrade.getString(11))){ com = setComments.getString(9);}else if (avgE >=Integer.parseInt(setEngGrade.getString(12))){ com = setComments.getString(10);}else if (avgE >=Integer.parseInt(setEngGrade.getString(13))){ com = setComments.getString(11);}else if (avgE >=Integer.parseInt(setEngGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }
                PdfPCell engD5 = new PdfPCell(new Paragraph(setE3.getString(8)+" "+setE3.getString(9)));
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
                PdfPCell kisD3 = new PdfPCell(new Paragraph(" "));
                PdfPCell kisD4 = new PdfPCell(new Paragraph(setE3.getString(11)+" "+setE3.getString(12)));

                int avgKis= Integer.parseInt(setE3.getString(11));
                if (avgKis >= Integer.parseInt(setKisGrade.getString(4))) {com = setComments.getString(2); } else if (avgKis >= Integer.parseInt(setKisGrade.getString(5))) { com = setComments.getString(3); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(6))){ com = setComments.getString(4);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(8))){  com = setComments.getString(6); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(9))){ com = setComments.getString(7); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgKis >=Integer.parseInt(setKisGrade.getString(11))){ com = setComments.getString(9);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(12))){ com = setComments.getString(10);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(13))){ com = setComments.getString(11);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }
                PdfPCell kisD5 = new PdfPCell(new Paragraph(setE3.getString(11)+" "+setE3.getString(12)));
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
                PdfPCell matD3 = new PdfPCell(new Paragraph(" "));
                PdfPCell matD4 = new PdfPCell(new Paragraph(setE3.getString(14)+" "+setE3.getString(15)));

                int avgMat = Integer.parseInt(setE3.getString(14));
                if (avgMat >= Integer.parseInt(setMatGrade.getString(4))) {com = setComments.getString(2); } else if (avgMat >= Integer.parseInt(setMatGrade.getString(5))) { com = setComments.getString(3); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(6))){ com = setComments.getString(4);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(8))){  com = setComments.getString(6); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(9))){ com = setComments.getString(7); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgMat >=Integer.parseInt(setMatGrade.getString(11))){ com = setComments.getString(9);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(12))){ com = setComments.getString(10);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(13))){ com = setComments.getString(11);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell matD5 = new PdfPCell(new Paragraph(setE3.getString(14)+" "+setE3.getString(15)));
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
                PdfPCell chemD3 = new PdfPCell(new Paragraph(" "));
                PdfPCell chemD4 = new PdfPCell(new Paragraph(setE3.getString(20)+" "+setE3.getString(21)));

                int avgChem = Integer.parseInt(setE3.getString(20));
                if (avgChem >= Integer.parseInt(setChemGrade.getString(4))) {com = setComments.getString(2); } else if (avgChem >= Integer.parseInt(setChemGrade.getString(5))) { com = setComments.getString(3); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(6))){ com = setComments.getString(4);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(8))){  com = setComments.getString(6); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(9))){ com = setComments.getString(7); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgChem >=Integer.parseInt(setChemGrade.getString(11))){ com = setComments.getString(9);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(12))){ com = setComments.getString(10);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(13))){ com = setComments.getString(11);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell chemD5 = new PdfPCell(new Paragraph(setE3.getString(20)+" "+setE3.getString(21)));
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
                PdfPCell phyD3 = new PdfPCell(new Paragraph(" "));
                PdfPCell phyD4 = new PdfPCell(new Paragraph(setE3.getString(23)+" "+setE3.getString(24)));

                int avgPhy = Integer.parseInt(setE3.getString(23));
                if (avgPhy >= Integer.parseInt(setPhyGrade.getString(4))) {com = setComments.getString(2); } else if (avgPhy >= Integer.parseInt(setPhyGrade.getString(5))) { com = setComments.getString(3); }else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(6))){ com = setComments.getString(4);}else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(8))){  com = setComments.getString(6); }else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(9))){ com = setComments.getString(7); }else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(11))){ com = setComments.getString(9);}else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(12))){ com = setComments.getString(10);}else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(13))){ com = setComments.getString(11);}else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell phyD5 = new PdfPCell(new Paragraph(setE3.getString(23)+" "+setE3.getString(24)));
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
                PdfPCell geoD3 = new PdfPCell(new Paragraph(" "));
                PdfPCell geoD4 = new PdfPCell(new Paragraph(setE3.getString(26)+" "+setE3.getString(27)));

                int avgGeo = Integer.parseInt(setE3.getString(26));
                if (avgGeo >= Integer.parseInt(setGeoGrade.getString(4))) {com = setComments.getString(2); } else if (avgGeo >= Integer.parseInt(setGeoGrade.getString(5))) { com = setComments.getString(3); }else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(6))){ com = setComments.getString(4);}else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(8))){  com = setComments.getString(6); }else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(9))){ com = setComments.getString(7); }else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(11))){ com = setComments.getString(9);}else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(12))){ com = setComments.getString(10);}else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(13))){ com = setComments.getString(11);}else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell geoD5 = new PdfPCell(new Paragraph(setE3.getString(26)+" "+setE3.getString(27)));
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
                PdfPCell agriD3 = new PdfPCell(new Paragraph(" "));
                PdfPCell agriD4 = new PdfPCell(new Paragraph(setE3.getString(38)+" "+setE3.getString(39)));

                int avgAgri = Integer.parseInt(setE3.getString(38));
                if (avgAgri >= Integer.parseInt(setAgriGrade.getString(4))) {com = setComments.getString(2); } else if (avgAgri >= Integer.parseInt(setAgriGrade.getString(5))) { com = setComments.getString(3); }else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(6))){ com = setComments.getString(4);}else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(8))){  com = setComments.getString(6); }else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(9))){ com = setComments.getString(7); }else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(11))){ com = setComments.getString(9);}else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(12))){ com = setComments.getString(10);}else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(13))){ com = setComments.getString(11);}else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell agriD5 = new PdfPCell(new Paragraph(setE3.getString(38)+" "+setE3.getString(39)));
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
                
                int totalE3 = Integer.parseInt(setE3.getString(41));
                int totalAvg = Integer.parseInt(setE3.getString(41));


                PdfPCell totalD1 = new PdfPCell(new Paragraph("Total"));
                PdfPCell totalD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell totalD3 = new PdfPCell(new Paragraph(" "));
                PdfPCell totalD4 = new PdfPCell(new Paragraph(String.valueOf(totalE3)));
                PdfPCell totalD5 = new PdfPCell(new Paragraph(String.valueOf(totalAvg)));
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

               
                //int add2AvgEx2 = (Math.addExact(totalEx2Mat,addAvgEx2))/3;

                int addAvgEx3 = Math.round(totalE3/7);
                //int add2AvgEx3 = (Math.addExact(totalEx3Mat,addAvgEx3))/3;

                
                PdfPCell avgD1 = new PdfPCell(new Paragraph("Average"));
                PdfPCell avgD2 = new PdfPCell(new Paragraph(" "));
                
                PdfPCell avgD3 = new PdfPCell(new Paragraph(" "));

                if (addAvgEx3 >= Integer.parseInt(setTotal.getString(4))) {g = "A"; } else if (addAvgEx3 >= Integer.parseInt(setTotal.getString(5))) { g = "A-"; }else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(6))){ g = "B+";}else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(7))){
                    g = "B"; }else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(8))){  g = "B-"; }else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(9))){ g = "C+"; }else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(10))){ g = "C";
                }else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(11))){ g = "C-";}else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(12))){ g = "D+";}else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(13))){ g = "D";}else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(14))){
                    g = "D-";}else {g="E"; }
                PdfPCell avgD4 = new PdfPCell(new Paragraph(String.valueOf(addAvgEx3)+" "+setE3.getString(42)));

                //float avgAvgTotal = (addAvgEx1+addAvgEx2+addAvgEx3)/3;
                int avgAvgTotal=Integer.parseInt(setE3.getString(41))/7;

                if (avgAvgTotal >= Integer.parseInt(setTotal.getString(4))) {g = "A"; } else if (avgAvgTotal >= Integer.parseInt(setTotal.getString(5))) { g = "A-"; }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(6))){ g = "B+";}else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(7))){
                    g = "B"; }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(8))){  g = "B-"; }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(9))){ g = "C+"; }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(10))){ g = "C";
                }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(11))){ g = "C-";}else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(12))){ g = "D+";}else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(13))){ g = "D";}else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(14))){
                    g = "D-";}else {g="E"; }

                PdfPCell avgD5 = new PdfPCell(new Paragraph(String.valueOf(Math.round(avgAvgTotal))+" "+setE3.getString(42)));
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
                PdfPCell f1t1m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF1T1E3.getString(30)))/11)+" "+setF1T1E3.getString(31)));
                PdfPCell f2t1 = new PdfPCell(new Paragraph("F2T1"));
                PdfPCell f2t1m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF2T1E3.getString(30)))/11)+" "+setF2T1E3.getString(31)));
                PdfPCell f3t1 = new PdfPCell(new Paragraph("F3T1"));
                PdfPCell f3t1m = new PdfPCell(new Paragraph(String.valueOf(Integer.parseInt(setF3T1E3.getString(41))/11)+" "+setF3T1E3.getString(43)+" "+setF3T1E3.getString(42)));
                PdfPCell f4t1 = new PdfPCell(new Paragraph("F4T1"));
                PdfPCell f4t1m = new PdfPCell(new Paragraph(String.valueOf(avgAvgTotal)+" "+setE3.getString(42)+" "+setE3.getString(43)));
                tableLastSummary.addCell(f1t1);
                tableLastSummary.addCell(f1t1m);
                tableLastSummary.addCell(f2t1);
                tableLastSummary.addCell(f2t1m);
                tableLastSummary.addCell(f3t1);
                tableLastSummary.addCell(f3t1m);
                tableLastSummary.addCell(f4t1);
                tableLastSummary.addCell(f4t1m);

                PdfPCell f1t2 = new PdfPCell(new Paragraph("F1T2"));
                PdfPCell f1t2m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF1T2E3.getString(30)))/11)+" "+setF1T2E3.getString(31)));
                PdfPCell f2t2 = new PdfPCell(new Paragraph("F2T2"));
                PdfPCell f2t2m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF2T2E3.getString(30)))/11)+" "+setF2T2E3.getString(31)));
                PdfPCell f3t2 = new PdfPCell(new Paragraph("F3T2"));
                PdfPCell f3t2m = new PdfPCell(new Paragraph(String.valueOf(Integer.parseInt(setF3T2E3.getString(41))/11)+" "+setF3T2E3.getString(43)+" "+setF3T2E3.getString(42)));
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
                PdfPCell f1t3m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF1T3E3.getString(30)))/11)+" "+setF1T3E3.getString(31)));
                PdfPCell f2t3 = new PdfPCell(new Paragraph("F2T3"));
                PdfPCell f2t3m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF2T3E3.getString(30)))/11)+" "+setF2T3E3.getString(31)));
                PdfPCell f3t3 = new PdfPCell(new Paragraph("F3T3"));
                PdfPCell f3t3m = new PdfPCell(new Paragraph(String.valueOf(Integer.parseInt(setF3T3E3.getString(41))/11)+" "+setF3T3E3.getString(43)+" "+setF3T3E3.getString(42)));
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
               dataSet.setValue((Integer.parseInt(setF1T1E3.getString(30))/11)/7, "Marks", "F1T1");
                dataSet.setValue((Integer.parseInt(setF1T2E3.getString(30))/11)/7, "Marks", "F1T2");
                dataSet.setValue((Integer.parseInt(setF1T3E3.getString(30))/11)/7, "Marks", "F1T3");
                dataSet.setValue((Integer.parseInt(setF2T1E3.getString(30))/11)/7, "Marks", "F2T1");
                dataSet.setValue((Integer.parseInt(setF2T2E3.getString(30))/11)/7, "Marks", "F2T2");
                dataSet.setValue((Integer.parseInt(setF2T3E3.getString(30))/11)/7, "Marks", "F2T3");
                dataSet.setValue(Float.parseFloat(setF3T1E3.getString(43)), "Marks", "F3T1");
                dataSet.setValue(Float.parseFloat(setF3T2E3.getString(43)), "Marks", "F3T2");
                dataSet.setValue(Float.parseFloat(setF3T3E3.getString(43)), "Marks", "F3T3");
              dataSet.setValue(Float.parseFloat(setE3.getString(43)), "Marks", "F4T1");
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
                 document.newPage();
                connection.close();

            }catch (Exception e){
                e.printStackTrace();
                infoBoxError("An error occurred " + e,"Error",null);
            }}else {
            infoBoxError("You are not allowed to print","Error",null);
        }
    }

    private void printPhyGeoBus(String adm, Document document, PdfWriter writer, int pos, String totalStudents) {
        if(printPassword.toString().equals("vic")) {
            String sqlDetails="SELECT * FROM tbl_students WHERE adm=?";
            String sqlComm = "SELECT * FROM tbl_comments";
            String sqlTotal ="SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='TOTAL'";
            
            String sqlEx3 = "SELECT * FROM tbl_f4_t1_ex3 WHERE adm=? ";
             String sqlF1T1Ex3 = "SELECT * FROM tbl_f1_t1_ex3 WHERE adm=?";
            String sqlF1T2Ex3 = "SELECT * FROM tbl_f1_t2_ex3 WHERE adm=?";
            String sqlF1T3Ex3 = "SELECT * FROM tbl_f1_t3_ex3 WHERE adm=?";
            String sqlF2T1Ex3 = "SELECT * FROM tbl_f2_t1_ex3 WHERE adm=?";
            String sqlF2T2Ex3 = "SELECT * FROM tbl_f2_t2_ex3 WHERE adm=?";
            String sqlF2T3Ex3 = "SELECT * FROM tbl_f2_t3_ex3 WHERE adm=?";
            String sqlF3T1Ex3 = "SELECT * FROM tbl_f3_t1_ex3 WHERE adm=?";
            String sqlF3T2Ex3 = "SELECT * FROM tbl_f3_t2_ex3 WHERE adm=?";
            String sqlF3T3Ex3 = "SELECT * FROM tbl_f3_t3_ex3 WHERE adm=?";
            

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
                
                PreparedStatement statementE3 = connection.prepareStatement(sqlEx3);
                PreparedStatement statementF1T1E3 = connection.prepareStatement(sqlF1T1Ex3);
                PreparedStatement statementF1T2E3 = connection.prepareStatement(sqlF1T2Ex3);
                PreparedStatement statementF1T3E3 = connection.prepareStatement(sqlF1T3Ex3);
                PreparedStatement statementF2T1E3 = connection.prepareStatement(sqlF2T1Ex3);
                PreparedStatement statementF2T2E3 = connection.prepareStatement(sqlF2T2Ex3);
                PreparedStatement statementF2T3E3 = connection.prepareStatement(sqlF2T3Ex3);
                PreparedStatement statementF3T1E3 = connection.prepareStatement(sqlF3T1Ex3);
                PreparedStatement statementF3T2E3 = connection.prepareStatement(sqlF3T2Ex3);
                PreparedStatement statementF3T3E3 = connection.prepareStatement(sqlF3T3Ex3);
                


                statement.setString(1,adm);
                
                statementE3.setString(1,adm);
                statementF1T1E3.setString(1,adm);
                statementF1T2E3.setString(1,adm);
                statementF1T3E3.setString(1,adm);
                statementF2T1E3.setString(1,adm);
                statementF2T2E3.setString(1,adm);
                statementF2T3E3.setString(1,adm);
                statementF3T1E3.setString(1,adm);
                statementF3T2E3.setString(1,adm);
                statementF3T3E3.setString(1,adm);
                

                ResultSet set = statement.executeQuery();
                
                ResultSet setE3 = statementE3.executeQuery();
                 ResultSet setF1T1E3 = statementF1T1E3.executeQuery();
                ResultSet setF1T2E3 = statementF1T2E3.executeQuery();
                ResultSet setF1T3E3 = statementF1T3E3.executeQuery();
                ResultSet setF2T1E3 = statementF2T1E3.executeQuery();
                ResultSet setF2T2E3 = statementF2T2E3.executeQuery();
                ResultSet setF2T3E3 = statementF2T3E3.executeQuery();
                ResultSet setF3T1E3 = statementF3T1E3.executeQuery();
                ResultSet setF3T2E3 = statementF3T2E3.executeQuery();
                ResultSet setF3T3E3 = statementF3T3E3.executeQuery();
                

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

                document.add((new Paragraph("ADM: "+set.getString(2)+"  "+"NAME: "+set.getString(3)+"   "+set.getString(4)+" "+set.getString(5)+"  "+"KCPE:"+set.getString(6)+"  "+"CLASS:FORM 4"+"  "+"TERM:TERM 1",new Font(Font.FontFamily.TIMES_ROMAN, 9,Font.BOLD))));
                document.add((new Paragraph("YEAR:"+now.get(Calendar.YEAR)+" "+"POS:"+String.valueOf(pos)+" "+"OUT OF "+totalStudents,new Font(Font.FontFamily.TIMES_ROMAN, 9,Font.BOLD))));
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
                PdfPCell engD3 = new PdfPCell(new Paragraph(" "));
                PdfPCell engD4 = new PdfPCell(new Paragraph(setE3.getString(8)+" "+setE3.getString(9)));

                int avgE= Integer.parseInt(setE3.getString(8));
                if (avgE >= Integer.parseInt(setEngGrade.getString(4))) {com = setComments.getString(2); } else if (avgE >= Integer.parseInt(setEngGrade.getString(5))) { com = setComments.getString(3); }else if (avgE >=Integer.parseInt(setEngGrade.getString(6))){ com = setComments.getString(4);}else if (avgE >=Integer.parseInt(setEngGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgE >=Integer.parseInt(setEngGrade.getString(8))){  com = setComments.getString(6); }else if (avgE >=Integer.parseInt(setEngGrade.getString(9))){ com = setComments.getString(7); }else if (avgE >=Integer.parseInt(setEngGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgE >=Integer.parseInt(setEngGrade.getString(11))){ com = setComments.getString(9);}else if (avgE >=Integer.parseInt(setEngGrade.getString(12))){ com = setComments.getString(10);}else if (avgE >=Integer.parseInt(setEngGrade.getString(13))){ com = setComments.getString(11);}else if (avgE >=Integer.parseInt(setEngGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }
                PdfPCell engD5 = new PdfPCell(new Paragraph(setE3.getString(8)+" "+setE3.getString(9)));
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
                PdfPCell kisD3 = new PdfPCell(new Paragraph(" "));
                PdfPCell kisD4 = new PdfPCell(new Paragraph(setE3.getString(11)+" "+setE3.getString(12)));

                int avgKis= Integer.parseInt(setE3.getString(11));
                if (avgKis >= Integer.parseInt(setKisGrade.getString(4))) {com = setComments.getString(2); } else if (avgKis >= Integer.parseInt(setKisGrade.getString(5))) { com = setComments.getString(3); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(6))){ com = setComments.getString(4);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(8))){  com = setComments.getString(6); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(9))){ com = setComments.getString(7); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgKis >=Integer.parseInt(setKisGrade.getString(11))){ com = setComments.getString(9);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(12))){ com = setComments.getString(10);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(13))){ com = setComments.getString(11);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }
                PdfPCell kisD5 = new PdfPCell(new Paragraph(setE3.getString(11)+" "+setE3.getString(12)));
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
                PdfPCell matD3 = new PdfPCell(new Paragraph(" "));
                PdfPCell matD4 = new PdfPCell(new Paragraph(setE3.getString(14)+" "+setE3.getString(15)));

                int avgMat = Integer.parseInt(setE3.getString(14));
                if (avgMat >= Integer.parseInt(setMatGrade.getString(4))) {com = setComments.getString(2); } else if (avgMat >= Integer.parseInt(setMatGrade.getString(5))) { com = setComments.getString(3); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(6))){ com = setComments.getString(4);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(8))){  com = setComments.getString(6); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(9))){ com = setComments.getString(7); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgMat >=Integer.parseInt(setMatGrade.getString(11))){ com = setComments.getString(9);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(12))){ com = setComments.getString(10);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(13))){ com = setComments.getString(11);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell matD5 = new PdfPCell(new Paragraph(setE3.getString(14)+" "+setE3.getString(15)));
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
                PdfPCell chemD3 = new PdfPCell(new Paragraph(" "));
                PdfPCell chemD4 = new PdfPCell(new Paragraph(setE3.getString(20)+" "+setE3.getString(21)));

                int avgChem = Integer.parseInt(setE3.getString(20));
                if (avgChem >= Integer.parseInt(setChemGrade.getString(4))) {com = setComments.getString(2); } else if (avgChem >= Integer.parseInt(setChemGrade.getString(5))) { com = setComments.getString(3); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(6))){ com = setComments.getString(4);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(8))){  com = setComments.getString(6); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(9))){ com = setComments.getString(7); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgChem >=Integer.parseInt(setChemGrade.getString(11))){ com = setComments.getString(9);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(12))){ com = setComments.getString(10);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(13))){ com = setComments.getString(11);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell chemD5 = new PdfPCell(new Paragraph(setE3.getString(20)+" "+setE3.getString(21)));
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
                PdfPCell phyD3 = new PdfPCell(new Paragraph(" "));
                PdfPCell phyD4 = new PdfPCell(new Paragraph(setE3.getString(23)+" "+setE3.getString(24)));

                int avgPhy = Integer.parseInt(setE3.getString(23));
                if (avgPhy >= Integer.parseInt(setPhyGrade.getString(4))) {com = setComments.getString(2); } else if (avgPhy >= Integer.parseInt(setPhyGrade.getString(5))) { com = setComments.getString(3); }else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(6))){ com = setComments.getString(4);}else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(8))){  com = setComments.getString(6); }else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(9))){ com = setComments.getString(7); }else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(11))){ com = setComments.getString(9);}else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(12))){ com = setComments.getString(10);}else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(13))){ com = setComments.getString(11);}else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell phyD5 = new PdfPCell(new Paragraph(setE3.getString(23)+" "+setE3.getString(24)));
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
                PdfPCell geoD3 = new PdfPCell(new Paragraph(" "));
                PdfPCell geoD4 = new PdfPCell(new Paragraph(setE3.getString(26)+" "+setE3.getString(27)));

                int avgGeo = Integer.parseInt(setE3.getString(26));
                if (avgGeo >= Integer.parseInt(setGeoGrade.getString(4))) {com = setComments.getString(2); } else if (avgGeo >= Integer.parseInt(setGeoGrade.getString(5))) { com = setComments.getString(3); }else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(6))){ com = setComments.getString(4);}else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(8))){  com = setComments.getString(6); }else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(9))){ com = setComments.getString(7); }else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(11))){ com = setComments.getString(9);}else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(12))){ com = setComments.getString(10);}else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(13))){ com = setComments.getString(11);}else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell geoD5 = new PdfPCell(new Paragraph(setE3.getString(26)+" "+setE3.getString(27)));
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
                PdfPCell busD3 = new PdfPCell(new Paragraph(" "));
                PdfPCell busD4 = new PdfPCell(new Paragraph(setE3.getString(35)+" "+setE3.getString(36)));

                int avgBus = Integer.parseInt(setE3.getString(35));
                if (avgBus >= Integer.parseInt(setBusGrade.getString(4))) {com = setComments.getString(2); } else if (avgBus >= Integer.parseInt(setBusGrade.getString(5))) { com = setComments.getString(3); }else if (avgBus >=Integer.parseInt(setBusGrade.getString(6))){ com = setComments.getString(4);}else if (avgBus >=Integer.parseInt(setBusGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgBus >=Integer.parseInt(setBusGrade.getString(8))){  com = setComments.getString(6); }else if (avgBus >=Integer.parseInt(setBusGrade.getString(9))){ com = setComments.getString(7); }else if (avgBus >=Integer.parseInt(setBusGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgBus >=Integer.parseInt(setBusGrade.getString(11))){ com = setComments.getString(9);}else if (avgBus >=Integer.parseInt(setBusGrade.getString(12))){ com = setComments.getString(10);}else if (avgBus >=Integer.parseInt(setBusGrade.getString(13))){ com = setComments.getString(11);}else if (avgBus >=Integer.parseInt(setBusGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell busD5 = new PdfPCell(new Paragraph(setE3.getString(35)+" "+setE3.getString(36)));
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
                
                int totalE3 = Integer.parseInt(setE3.getString(41));
                int totalAvg = Integer.parseInt(setE3.getString(41));


                PdfPCell totalD1 = new PdfPCell(new Paragraph("Total"));
                PdfPCell totalD2 = new PdfPCell(new Paragraph(" "));
                PdfPCell totalD3 = new PdfPCell(new Paragraph(" "));
                PdfPCell totalD4 = new PdfPCell(new Paragraph(String.valueOf(totalE3)));
                PdfPCell totalD5 = new PdfPCell(new Paragraph(String.valueOf(totalAvg)));
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

               
                //int add2AvgEx2 = (Math.addExact(totalEx2Mat,addAvgEx2))/3;

                int addAvgEx3 = Math.round(totalE3/7);
                //int add2AvgEx3 = (Math.addExact(totalEx3Mat,addAvgEx3))/3;

                
                PdfPCell avgD1 = new PdfPCell(new Paragraph("Average"));
                PdfPCell avgD2 = new PdfPCell(new Paragraph(" "));
                
                PdfPCell avgD3 = new PdfPCell(new Paragraph(" "));

                if (addAvgEx3 >= Integer.parseInt(setTotal.getString(4))) {g = "A"; } else if (addAvgEx3 >= Integer.parseInt(setTotal.getString(5))) { g = "A-"; }else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(6))){ g = "B+";}else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(7))){
                    g = "B"; }else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(8))){  g = "B-"; }else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(9))){ g = "C+"; }else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(10))){ g = "C";
                }else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(11))){ g = "C-";}else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(12))){ g = "D+";}else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(13))){ g = "D";}else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(14))){
                    g = "D-";}else {g="E"; }
                PdfPCell avgD4 = new PdfPCell(new Paragraph(String.valueOf(addAvgEx3)+" "+setE3.getString(42)));

                //float avgAvgTotal = (addAvgEx1+addAvgEx2+addAvgEx3)/3;
                int avgAvgTotal=Integer.parseInt(setE3.getString(41))/7;

                if (avgAvgTotal >= Integer.parseInt(setTotal.getString(4))) {g = "A"; } else if (avgAvgTotal >= Integer.parseInt(setTotal.getString(5))) { g = "A-"; }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(6))){ g = "B+";}else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(7))){
                    g = "B"; }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(8))){  g = "B-"; }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(9))){ g = "C+"; }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(10))){ g = "C";
                }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(11))){ g = "C-";}else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(12))){ g = "D+";}else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(13))){ g = "D";}else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(14))){
                    g = "D-";}else {g="E"; }

                PdfPCell avgD5 = new PdfPCell(new Paragraph(String.valueOf(Math.round(avgAvgTotal))+" "+setE3.getString(42)));
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
                PdfPCell f1t1m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF1T1E3.getString(30)))/11)+" "+setF1T1E3.getString(31)));
                PdfPCell f2t1 = new PdfPCell(new Paragraph("F2T1"));
                PdfPCell f2t1m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF2T1E3.getString(30)))/11)+" "+setF2T1E3.getString(31)));
                PdfPCell f3t1 = new PdfPCell(new Paragraph("F3T1"));
                PdfPCell f3t1m = new PdfPCell(new Paragraph(String.valueOf(Integer.parseInt(setF3T1E3.getString(41))/11)+" "+setF3T1E3.getString(43)+" "+setF3T1E3.getString(42)));
                PdfPCell f4t1 = new PdfPCell(new Paragraph("F4T1"));
                PdfPCell f4t1m = new PdfPCell(new Paragraph(String.valueOf(avgAvgTotal)+" "+setE3.getString(42)+" "+setE3.getString(43)));
                tableLastSummary.addCell(f1t1);
                tableLastSummary.addCell(f1t1m);
                tableLastSummary.addCell(f2t1);
                tableLastSummary.addCell(f2t1m);
                tableLastSummary.addCell(f3t1);
                tableLastSummary.addCell(f3t1m);
                tableLastSummary.addCell(f4t1);
                tableLastSummary.addCell(f4t1m);

                PdfPCell f1t2 = new PdfPCell(new Paragraph("F1T2"));
                PdfPCell f1t2m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF1T2E3.getString(30)))/11)+" "+setF1T2E3.getString(31)));
                PdfPCell f2t2 = new PdfPCell(new Paragraph("F2T2"));
                PdfPCell f2t2m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF2T2E3.getString(30)))/11)+" "+setF2T2E3.getString(31)));
                PdfPCell f3t2 = new PdfPCell(new Paragraph("F3T2"));
                PdfPCell f3t2m = new PdfPCell(new Paragraph(String.valueOf(Integer.parseInt(setF3T2E3.getString(41))/11)+" "+setF3T2E3.getString(43)+" "+setF3T2E3.getString(42)));
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
                PdfPCell f1t3m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF1T3E3.getString(30)))/11)+" "+setF1T3E3.getString(31)));
                PdfPCell f2t3 = new PdfPCell(new Paragraph("F2T3"));
                PdfPCell f2t3m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF2T3E3.getString(30)))/11)+" "+setF2T3E3.getString(31)));
                PdfPCell f3t3 = new PdfPCell(new Paragraph("F3T3"));
                PdfPCell f3t3m = new PdfPCell(new Paragraph(String.valueOf(Integer.parseInt(setF3T3E3.getString(41))/11)+" "+setF3T3E3.getString(43)+" "+setF3T3E3.getString(42)));
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
               dataSet.setValue((Integer.parseInt(setF1T1E3.getString(30))/11)/7, "Marks", "F1T1");
                dataSet.setValue((Integer.parseInt(setF1T2E3.getString(30))/11)/7, "Marks", "F1T2");
                dataSet.setValue((Integer.parseInt(setF1T3E3.getString(30))/11)/7, "Marks", "F1T3");
                dataSet.setValue((Integer.parseInt(setF2T1E3.getString(30))/11)/7, "Marks", "F2T1");
                dataSet.setValue((Integer.parseInt(setF2T2E3.getString(30))/11)/7, "Marks", "F2T2");
                dataSet.setValue((Integer.parseInt(setF2T3E3.getString(30))/11)/7, "Marks", "F2T3");
                dataSet.setValue(Float.parseFloat(setF3T1E3.getString(43)), "Marks", "F3T1");
                dataSet.setValue(Float.parseFloat(setF3T2E3.getString(43)), "Marks", "F3T2");
                dataSet.setValue(Float.parseFloat(setF3T3E3.getString(43)), "Marks", "F3T3");
              dataSet.setValue(Float.parseFloat(setE3.getString(43)), "Marks", "F4T1");
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
                 document.newPage();
                connection.close();

            }catch (Exception e){
                e.printStackTrace();
                infoBoxError("An error occurred " + e,"Error",null);
            }}else {
            infoBoxError("You are not allowed to print","Error",null);
        }
    }

    private void printAllSubjects(String adm, Document document, PdfWriter writer, int pos, String totalStudents) {
        if(printPassword.toString().equals("vic")) {
            String sqlDetails="SELECT * FROM tbl_students WHERE adm=?";
            String sqlComm = "SELECT * FROM tbl_comments";
            String sqlTotal ="SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='TOTAL'";
            String sqlEx3 = "SELECT * FROM tbl_f4_t1_ex3 WHERE adm=? ";
             String sqlF1T1Ex3 = "SELECT * FROM tbl_f1_t1_ex3 WHERE adm=?";
            String sqlF1T2Ex3 = "SELECT * FROM tbl_f1_t2_ex3 WHERE adm=?";
            String sqlF1T3Ex3 = "SELECT * FROM tbl_f1_t3_ex3 WHERE adm=?";
            String sqlF2T1Ex3 = "SELECT * FROM tbl_f2_t1_ex3 WHERE adm=?";
            String sqlF2T2Ex3 = "SELECT * FROM tbl_f2_t2_ex3 WHERE adm=?";
            String sqlF2T3Ex3 = "SELECT * FROM tbl_f2_t3_ex3 WHERE adm=?";
            String sqlF3T1Ex3 = "SELECT * FROM tbl_f3_t1_ex3 WHERE adm=?";
            String sqlF3T2Ex3 = "SELECT * FROM tbl_f3_t2_ex3 WHERE adm=?";
            String sqlF3T3Ex3 = "SELECT * FROM tbl_f3_t3_ex3 WHERE adm=?";
            

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
                
                PreparedStatement statementE3 = connection.prepareStatement(sqlEx3);
                PreparedStatement statementF1T1E3 = connection.prepareStatement(sqlF1T1Ex3);
                PreparedStatement statementF1T2E3 = connection.prepareStatement(sqlF1T2Ex3);
                PreparedStatement statementF1T3E3 = connection.prepareStatement(sqlF1T3Ex3);
                PreparedStatement statementF2T1E3 = connection.prepareStatement(sqlF2T1Ex3);
                PreparedStatement statementF2T2E3 = connection.prepareStatement(sqlF2T2Ex3);
                PreparedStatement statementF2T3E3 = connection.prepareStatement(sqlF2T3Ex3);
                PreparedStatement statementF3T1E3 = connection.prepareStatement(sqlF3T1Ex3);
                PreparedStatement statementF3T2E3 = connection.prepareStatement(sqlF3T2Ex3);
                PreparedStatement statementF3T3E3 = connection.prepareStatement(sqlF3T3Ex3);
                

                statement.setString(1,adm);
                
                statementE3.setString(1,adm);
                statementF1T1E3.setString(1,adm);
                statementF1T2E3.setString(1,adm);
                statementF1T3E3.setString(1,adm);
                statementF2T1E3.setString(1,adm);
                statementF2T2E3.setString(1,adm);
                statementF2T3E3.setString(1,adm);
                statementF3T1E3.setString(1,adm);
                statementF3T2E3.setString(1,adm);
                statementF3T3E3.setString(1,adm);
                

                ResultSet set = statement.executeQuery();
                ResultSet setE3 = statementE3.executeQuery();
                 ResultSet setF1T1E3 = statementF1T1E3.executeQuery();
                ResultSet setF1T2E3 = statementF1T2E3.executeQuery();
                ResultSet setF1T3E3 = statementF1T3E3.executeQuery();
                ResultSet setF2T1E3 = statementF2T1E3.executeQuery();
                ResultSet setF2T2E3 = statementF2T2E3.executeQuery();
                ResultSet setF2T3E3 = statementF2T3E3.executeQuery();
                ResultSet setF3T1E3 = statementF3T1E3.executeQuery();
                ResultSet setF3T2E3 = statementF3T2E3.executeQuery();
                ResultSet setF3T3E3 = statementF3T3E3.executeQuery();
                

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

                document.add((new Paragraph("ADM: "+set.getString(2)+"  "+"NAME: "+set.getString(3)+"   "+set.getString(4)+" "+set.getString(5)+"  "+"KCPE:"+set.getString(6)+"  "+"CLASS:FORM 4"+"  "+"TERM:TERM 1",new Font(Font.FontFamily.TIMES_ROMAN, 9,Font.BOLD))));
                document.add((new Paragraph("YEAR:"+now.get(Calendar.YEAR)+" "+"POS:"+String.valueOf(pos)+" "+"OUT OF "+totalStudents,new Font(Font.FontFamily.TIMES_ROMAN, 9,Font.BOLD))));
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
                PdfPCell kisD4 = new PdfPCell(new Paragraph(setE3.getString(11)+" "+setE3.getString(12),font));

                int avgKis= Integer.parseInt(setE3.getString(11));
                if (avgKis >= Integer.parseInt(setKisGrade.getString(4))) {com = setComments.getString(2); } else if (avgKis >= Integer.parseInt(setKisGrade.getString(5))) { com = setComments.getString(3); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(6))){ com = setComments.getString(4);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(8))){  com = setComments.getString(6); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(9))){ com = setComments.getString(7); }else if (avgKis >=Integer.parseInt(setKisGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgKis >=Integer.parseInt(setKisGrade.getString(11))){ com = setComments.getString(9);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(12))){ com = setComments.getString(10);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(13))){ com = setComments.getString(11);}else if (avgKis >=Integer.parseInt(setKisGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }
                PdfPCell kisD5 = new PdfPCell(new Paragraph(setE3.getString(11)+" "+setE3.getString(12),font));
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
                PdfPCell matD4 = new PdfPCell(new Paragraph(setE3.getString(14)+" "+setE3.getString(15),font));

                int avgMat = Integer.parseInt(setE3.getString(14));
                if (avgMat >= Integer.parseInt(setMatGrade.getString(4))) {com = setComments.getString(2); } else if (avgMat >= Integer.parseInt(setMatGrade.getString(5))) { com = setComments.getString(3); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(6))){ com = setComments.getString(4);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(8))){  com = setComments.getString(6); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(9))){ com = setComments.getString(7); }else if (avgMat >=Integer.parseInt(setMatGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgMat >=Integer.parseInt(setMatGrade.getString(11))){ com = setComments.getString(9);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(12))){ com = setComments.getString(10);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(13))){ com = setComments.getString(11);}else if (avgMat >=Integer.parseInt(setMatGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell matD5 = new PdfPCell(new Paragraph(setE3.getString(14)+" "+setE3.getString(15),font));
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
                PdfPCell chemD4 = new PdfPCell(new Paragraph(setE3.getString(20)+" "+setE3.getString(21),font));

                int avgChem = Integer.parseInt(setE3.getString(20));
                if (avgChem >= Integer.parseInt(setChemGrade.getString(4))) {com = setComments.getString(2); } else if (avgChem >= Integer.parseInt(setChemGrade.getString(5))) { com = setComments.getString(3); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(6))){ com = setComments.getString(4);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(8))){  com = setComments.getString(6); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(9))){ com = setComments.getString(7); }else if (avgChem >=Integer.parseInt(setChemGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgChem >=Integer.parseInt(setChemGrade.getString(11))){ com = setComments.getString(9);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(12))){ com = setComments.getString(10);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(13))){ com = setComments.getString(11);}else if (avgChem >=Integer.parseInt(setChemGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell chemD5 = new PdfPCell(new Paragraph(setE3.getString(20)+" "+setE3.getString(21),font));
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
                PdfPCell bioD4 = new PdfPCell(new Paragraph(setE3.getString(17)+" "+setE3.getString(18),font));

                int avgBio = Integer.parseInt(setE3.getString(17));
                if (avgBio >= Integer.parseInt(setBioGrade.getString(4))) {com = setComments.getString(2); } else if (avgBio >= Integer.parseInt(setBioGrade.getString(5))) { com = setComments.getString(3); }else if (avgBio >=Integer.parseInt(setBioGrade.getString(6))){ com = setComments.getString(4);}else if (avgBio >=Integer.parseInt(setBioGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgBio >=Integer.parseInt(setBioGrade.getString(8))){  com = setComments.getString(6); }else if (avgBio >=Integer.parseInt(setBioGrade.getString(9))){ com = setComments.getString(7); }else if (avgBio >=Integer.parseInt(setBioGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgBio >=Integer.parseInt(setBioGrade.getString(11))){ com = setComments.getString(9);}else if (avgBio >=Integer.parseInt(setBioGrade.getString(12))){ com = setComments.getString(10);}else if (avgBio >=Integer.parseInt(setBioGrade.getString(13))){ com = setComments.getString(11);}else if (avgBio >=Integer.parseInt(setBioGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell bioD5 = new PdfPCell(new Paragraph(setE3.getString(17)+" "+setE3.getString(18),font));
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
                PdfPCell phyD3 = new PdfPCell(new Paragraph(" ",font));
                PdfPCell phyD4 = new PdfPCell(new Paragraph(setE3.getString(23)+" "+setE3.getString(24),font));

                int avgPhy = Integer.parseInt(setE3.getString(23));
                if (avgPhy >= Integer.parseInt(setPhyGrade.getString(4))) {com = setComments.getString(2); } else if (avgPhy >= Integer.parseInt(setPhyGrade.getString(5))) { com = setComments.getString(3); }else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(6))){ com = setComments.getString(4);}else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(8))){  com = setComments.getString(6); }else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(9))){ com = setComments.getString(7); }else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(11))){ com = setComments.getString(9);}else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(12))){ com = setComments.getString(10);}else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(13))){ com = setComments.getString(11);}else if (avgPhy >=Integer.parseInt(setPhyGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell phyD5 = new PdfPCell(new Paragraph(setE3.getString(23)+" "+setE3.getString(24),font));
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
                PdfPCell hisD3 = new PdfPCell(new Paragraph(" ",font));
                PdfPCell hisD4 = new PdfPCell(new Paragraph(setE3.getString(29)+" "+setE3.getString(30),font));

                int avgHis = Integer.parseInt(setE3.getString(29));
                if (avgHis >= Integer.parseInt(setHisGrade.getString(4))) {com = setComments.getString(2); } else if (avgHis >= Integer.parseInt(setHisGrade.getString(5))) { com = setComments.getString(3); }else if (avgHis >=Integer.parseInt(setHisGrade.getString(6))){ com = setComments.getString(4);}else if (avgHis >=Integer.parseInt(setHisGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgHis >=Integer.parseInt(setHisGrade.getString(8))){  com = setComments.getString(6); }else if (avgHis >=Integer.parseInt(setHisGrade.getString(9))){ com = setComments.getString(7); }else if (avgHis >=Integer.parseInt(setHisGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgHis >=Integer.parseInt(setHisGrade.getString(11))){ com = setComments.getString(9);}else if (avgHis >=Integer.parseInt(setHisGrade.getString(12))){ com = setComments.getString(10);}else if (avgHis >=Integer.parseInt(setHisGrade.getString(13))){ com = setComments.getString(11);}else if (avgHis >=Integer.parseInt(setHisGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell hisD5 = new PdfPCell(new Paragraph(setE3.getString(29)+" "+setE3.getString(30),font));
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
                PdfPCell geoD3 = new PdfPCell(new Paragraph(" ",font));
                PdfPCell geoD4 = new PdfPCell(new Paragraph(setE3.getString(26)+" "+setE3.getString(27),font));

                int avgGeo = Integer.parseInt(setE3.getString(26));
                if (avgGeo >= Integer.parseInt(setGeoGrade.getString(4))) {com = setComments.getString(2); } else if (avgGeo >= Integer.parseInt(setGeoGrade.getString(5))) { com = setComments.getString(3); }else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(6))){ com = setComments.getString(4);}else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(8))){  com = setComments.getString(6); }else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(9))){ com = setComments.getString(7); }else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(11))){ com = setComments.getString(9);}else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(12))){ com = setComments.getString(10);}else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(13))){ com = setComments.getString(11);}else if (avgGeo >=Integer.parseInt(setGeoGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell geoD5 = new PdfPCell(new Paragraph(setE3.getString(26)+" "+setE3.getString(27),font));
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
                PdfPCell creD3 = new PdfPCell(new Paragraph(" ",font));
                PdfPCell creD4 = new PdfPCell(new Paragraph(setE3.getString(32)+" "+setE3.getString(33),font));

                int avgCre = Integer.parseInt(setE3.getString(32));
                if (avgCre >= Integer.parseInt(setCreGrade.getString(4))) {com = setComments.getString(2); } else if (avgCre >= Integer.parseInt(setCreGrade.getString(5))) { com = setComments.getString(3); }else if (avgCre >=Integer.parseInt(setCreGrade.getString(6))){ com = setComments.getString(4);}else if (avgCre >=Integer.parseInt(setCreGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgCre >=Integer.parseInt(setCreGrade.getString(8))){  com = setComments.getString(6); }else if (avgCre >=Integer.parseInt(setCreGrade.getString(9))){ com = setComments.getString(7); }else if (avgCre >=Integer.parseInt(setCreGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgCre >=Integer.parseInt(setCreGrade.getString(11))){ com = setComments.getString(9);}else if (avgCre >=Integer.parseInt(setCreGrade.getString(12))){ com = setComments.getString(10);}else if (avgCre >=Integer.parseInt(setCreGrade.getString(13))){ com = setComments.getString(11);}else if (avgCre >=Integer.parseInt(setCreGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell creD5 = new PdfPCell(new Paragraph(setE3.getString(32)+" "+setE3.getString(33),font));
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
                PdfPCell busD3 = new PdfPCell(new Paragraph(" ",font));
                PdfPCell busD4 = new PdfPCell(new Paragraph(setE3.getString(35)+" "+setE3.getString(36),font));

                int avgBus = Integer.parseInt(setE3.getString(35));
                if (avgBus >= Integer.parseInt(setBusGrade.getString(4))) {com = setComments.getString(2); } else if (avgBus >= Integer.parseInt(setBusGrade.getString(5))) { com = setComments.getString(3); }else if (avgBus >=Integer.parseInt(setBusGrade.getString(6))){ com = setComments.getString(4);}else if (avgBus >=Integer.parseInt(setBusGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgBus >=Integer.parseInt(setBusGrade.getString(8))){  com = setComments.getString(6); }else if (avgBus >=Integer.parseInt(setBusGrade.getString(9))){ com = setComments.getString(7); }else if (avgBus >=Integer.parseInt(setBusGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgBus >=Integer.parseInt(setBusGrade.getString(11))){ com = setComments.getString(9);}else if (avgBus >=Integer.parseInt(setBusGrade.getString(12))){ com = setComments.getString(10);}else if (avgBus >=Integer.parseInt(setBusGrade.getString(13))){ com = setComments.getString(11);}else if (avgBus >=Integer.parseInt(setBusGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell busD5 = new PdfPCell(new Paragraph(setE3.getString(35)+" "+setE3.getString(36),font));
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
                PdfPCell agriD3 = new PdfPCell(new Paragraph(" ",font));
                PdfPCell agriD4 = new PdfPCell(new Paragraph(setE3.getString(38)+" "+setE3.getString(39),font));

                int avgAgri = Integer.parseInt(setE3.getString(38));
                if (avgAgri >= Integer.parseInt(setAgriGrade.getString(4))) {com = setComments.getString(2); } else if (avgAgri >= Integer.parseInt(setAgriGrade.getString(5))) { com = setComments.getString(3); }else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(6))){ com = setComments.getString(4);}else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(7))){
                    com = setComments.getString(5); }else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(8))){  com = setComments.getString(6); }else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(9))){ com = setComments.getString(7); }else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(10))){ com = setComments.getString(8);
                }else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(11))){ com = setComments.getString(9);}else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(12))){ com = setComments.getString(10);}else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(13))){ com = setComments.getString(11);}else if (avgAgri >=Integer.parseInt(setAgriGrade.getString(14))){
                    com = setComments.getString(12);}else {com = setComments.getString(13); }

                PdfPCell agriD5 = new PdfPCell(new Paragraph(setE3.getString(38)+" "+setE3.getString(39),font));
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
                
                int totalE3 = Integer.parseInt(setE3.getString(41));
                int totalAvg = Integer.parseInt(setE3.getString(41));


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
               int addAvgEx3 = Math.round(totalE3/11);
                //int add2AvgEx3 = (Math.addExact(totalEx3Mat,addAvgEx3))/3;

                
                PdfPCell avgD1 = new PdfPCell(new Paragraph("Average",font));
                PdfPCell avgD2 = new PdfPCell(new Paragraph(" ",font));
                PdfPCell avgD3 = new PdfPCell(new Paragraph(" ",font));
                if (addAvgEx3 >= Integer.parseInt(setTotal.getString(4))) {g = "A"; } else if (addAvgEx3 >= Integer.parseInt(setTotal.getString(5))) { g = "A-"; }else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(6))){ g = "B+";}else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(7))){
                    g = "B"; }else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(8))){  g = "B-"; }else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(9))){ g = "C+"; }else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(10))){ g = "C";
                }else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(11))){ g = "C-";}else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(12))){ g = "D+";}else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(13))){ g = "D";}else if (addAvgEx3 >=Integer.parseInt(setTotal.getString(14))){
                    g = "D-";}else {g="E"; }
                PdfPCell avgD4 = new PdfPCell(new Paragraph(String.valueOf(addAvgEx3)+" "+setE3.getString(42),font));

                //float avgAvgTotal = (addAvgEx1+addAvgEx2+addAvgEx3)/3;
                int avgAvgTotal=Integer.parseInt(setE3.getString(41))/11;

                if (avgAvgTotal >= Integer.parseInt(setTotal.getString(4))) {g = "A"; } else if (avgAvgTotal >= Integer.parseInt(setTotal.getString(5))) { g = "A-"; }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(6))){ g = "B+";}else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(7))){
                    g = "B"; }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(8))){  g = "B-"; }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(9))){ g = "C+"; }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(10))){ g = "C";
                }else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(11))){ g = "C-";}else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(12))){ g = "D+";}else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(13))){ g = "D";}else if (avgAvgTotal >=Integer.parseInt(setTotal.getString(14))){
                    g = "D-";}else {g="E"; }

                PdfPCell avgD5 = new PdfPCell(new Paragraph(String.valueOf(Math.round(avgAvgTotal))+" "+setE3.getString(42),font));
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
                PdfPCell f1t1m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF1T1E3.getString(30)))/11)+" "+setF1T1E3.getString(31),font));
                PdfPCell f2t1 = new PdfPCell(new Paragraph("F2T1",font));
                PdfPCell f2t1m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF2T1E3.getString(30)))/11)+" "+setF2T1E3.getString(31),font));
                PdfPCell f3t1 = new PdfPCell(new Paragraph("F3T1",font));
                PdfPCell f3t1m = new PdfPCell(new Paragraph(String.valueOf(Integer.parseInt(setF3T1E3.getString(41))/11)+" "+setF3T1E3.getString(43)+" "+setF3T1E3.getString(42),font));
                PdfPCell f4t1 = new PdfPCell(new Paragraph("F4T1",font));
                PdfPCell f4t1m = new PdfPCell(new Paragraph(String.valueOf(avgAvgTotal)+" "+setE3.getString(42)+" "+setE3.getString(43),font));
                tableLastSummary.addCell(f1t1);
                tableLastSummary.addCell(f1t1m);
                tableLastSummary.addCell(f2t1);
                tableLastSummary.addCell(f2t1m);
                tableLastSummary.addCell(f3t1);
                tableLastSummary.addCell(f3t1m);
                tableLastSummary.addCell(f4t1);
                tableLastSummary.addCell(f4t1m);

                PdfPCell f1t2 = new PdfPCell(new Paragraph("F1T2",font));
                PdfPCell f1t2m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF1T2E3.getString(30)))/11)+" "+setF1T2E3.getString(31),font));
                PdfPCell f2t2 = new PdfPCell(new Paragraph("F2T2",font));
                PdfPCell f2t2m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF2T2E3.getString(30)))/11)+" "+setF2T2E3.getString(31),font));
                PdfPCell f3t2 = new PdfPCell(new Paragraph("F3T2",font));
                PdfPCell f3t2m = new PdfPCell(new Paragraph(String.valueOf(Integer.parseInt(setF3T2E3.getString(41))/11)+" "+setF3T2E3.getString(43)+" "+setF3T2E3.getString(42),font));
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
                PdfPCell f1t3m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF1T3E3.getString(30)))/11)+" "+setF1T3E3.getString(31),font));
                PdfPCell f2t3 = new PdfPCell(new Paragraph("F2T3",font));
                PdfPCell f2t3m = new PdfPCell(new Paragraph(String.valueOf((Integer.parseInt(setF2T3E3.getString(30)))/11)+" "+setF2T3E3.getString(31),font));
                PdfPCell f3t3 = new PdfPCell(new Paragraph("F3T3",font));
                PdfPCell f3t3m = new PdfPCell(new Paragraph(String.valueOf(Integer.parseInt(setF3T3E3.getString(41))/11)+" "+setF3T3E3.getString(43)+" "+setF3T3E3.getString(42),font));
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
               dataSet.setValue((Integer.parseInt(setF1T1E3.getString(30))/11)/7, "Marks", "F1T1");
                dataSet.setValue((Integer.parseInt(setF1T2E3.getString(30))/11)/7, "Marks", "F1T2");
                dataSet.setValue((Integer.parseInt(setF1T3E3.getString(30))/11)/7, "Marks", "F1T3");
                dataSet.setValue((Integer.parseInt(setF2T1E3.getString(30))/11)/7, "Marks", "F2T1");
                dataSet.setValue((Integer.parseInt(setF2T2E3.getString(30))/11)/7, "Marks", "F2T2");
                dataSet.setValue((Integer.parseInt(setF2T3E3.getString(30))/11)/7, "Marks", "F2T3");
                dataSet.setValue(Float.parseFloat(setF3T1E3.getString(43)), "Marks", "F3T1");
                dataSet.setValue(Float.parseFloat(setF3T2E3.getString(43)), "Marks", "F3T2");
                dataSet.setValue(Float.parseFloat(setF3T3E3.getString(43)), "Marks", "F3T3");
              dataSet.setValue(Float.parseFloat(setE3.getString(43)), "Marks", "F4T1");
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
                 document.newPage();
                connection.close();

            }catch (Exception e){
                e.printStackTrace();
                infoBoxError("An error occurred " + e,"Error",null);
            }}else {
            infoBoxError("You are not allowed to print","Error",null);
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        calcTotal();
        showData();
    }
}
