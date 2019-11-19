package students;

import F1.classlist.Password;
import F1.classlist.ShowClasslist;
import F1.exams.MarksEntry;
import about.About;
import backup.ManualBackup;
import grade.Grade;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import start.DatabaseSync;
import teacher.Teacher;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class SubjectSelection implements Initializable{
    @FXML
    private TableView<subjectSelectionData> tableSubjectSel;
    @FXML
    private TableColumn<subjectSelectionData,String> idColumn,admColumn,nameColumn,classColumn,engColumn,kisColumn,matColumn,bioColumn,chemColumn,phyColumn,hisColumn,creColumn,geoColumn,busColumn,agriColumn;
    @FXML
    private TextField classFilter,admSearch;
    private ObservableList<subjectSelectionData> tableList;
    @FXML
    private AnchorPane windowCurrent;

    @FXML
    private void loadData(){
        String sqlSel = "SELECT * FROM tbl_subject_selection";
        try{
            Connection connection = Database.DBConnection.getConnection();
            this.tableList = FXCollections.observableArrayList();
            ResultSet set = connection.createStatement().executeQuery(sqlSel);
            while (set.next()){
                this.tableList.addAll(new subjectSelectionData(set.getString(1),set.getString(2),set.getString(3)+" "+set.getString(4)+" "+set.getString(5),set.getString(7),set.getString(8),set.getString(9),set.getString(10),set.getString(11),set.getString(12),set.getString(13),set.getString(14),set.getString(15),set.getString(16),set.getString(17),set.getString(18)));
            }

            this.idColumn.setCellValueFactory(new PropertyValueFactory<subjectSelectionData,String>("id"));
            this.admColumn.setCellValueFactory(new PropertyValueFactory<subjectSelectionData,String>("adm"));
            this.nameColumn.setCellValueFactory(new PropertyValueFactory<subjectSelectionData,String>("name"));
            this.classColumn.setCellValueFactory(new PropertyValueFactory<subjectSelectionData,String>("classs"));
            this.engColumn.setCellValueFactory(new PropertyValueFactory<subjectSelectionData,String>("eng"));
            this.kisColumn.setCellValueFactory(new PropertyValueFactory<subjectSelectionData,String>("kis"));
            this.matColumn.setCellValueFactory(new PropertyValueFactory<subjectSelectionData,String>("mat"));
            this.bioColumn.setCellValueFactory(new PropertyValueFactory<subjectSelectionData,String>("bio"));
            this.chemColumn.setCellValueFactory(new PropertyValueFactory<subjectSelectionData,String>("chem"));
            this.phyColumn.setCellValueFactory(new PropertyValueFactory<subjectSelectionData,String>("phy"));
            this.geoColumn.setCellValueFactory(new PropertyValueFactory<subjectSelectionData,String>("geo"));
            this.hisColumn.setCellValueFactory(new PropertyValueFactory<subjectSelectionData,String>("his"));
            this.creColumn.setCellValueFactory(new PropertyValueFactory<subjectSelectionData,String>("cre"));
            this.busColumn.setCellValueFactory(new PropertyValueFactory<subjectSelectionData,String>("bus"));
            this.agriColumn.setCellValueFactory(new PropertyValueFactory<subjectSelectionData,String>("agri"));

            this.tableSubjectSel.setItems(null);
            this.tableSubjectSel.setItems(this.tableList);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    private void classFilter(){
        String sqlSel = "SELECT * FROM tbl_subject_selection WHERE class=?";
        try{
            Connection connection = Database.DBConnection.getConnection();
            this.tableList= FXCollections.observableArrayList();
            PreparedStatement statement = connection.prepareStatement(sqlSel);
            statement.setString(1,this.classFilter.getText().toUpperCase());
            ResultSet set = statement.executeQuery();
            while (set.next()){
                this.tableList.addAll(new subjectSelectionData(set.getString(1),set.getString(2),set.getString(3)+" "+set.getString(4)+" "+set.getString(5),set.getString(7),set.getString(8),set.getString(9),set.getString(10),set.getString(11),set.getString(12),set.getString(13),set.getString(14),set.getString(15),set.getString(16),set.getString(17),set.getString(18)));
            }

            this.idColumn.setCellValueFactory(new PropertyValueFactory<subjectSelectionData,String>("id"));
            this.admColumn.setCellValueFactory(new PropertyValueFactory<subjectSelectionData,String>("adm"));
            this.nameColumn.setCellValueFactory(new PropertyValueFactory<subjectSelectionData,String>("name"));
            this.classColumn.setCellValueFactory(new PropertyValueFactory<subjectSelectionData,String>("classs"));
            this.engColumn.setCellValueFactory(new PropertyValueFactory<subjectSelectionData,String>("eng"));
            this.kisColumn.setCellValueFactory(new PropertyValueFactory<subjectSelectionData,String>("kis"));
            this.matColumn.setCellValueFactory(new PropertyValueFactory<subjectSelectionData,String>("mat"));
            this.bioColumn.setCellValueFactory(new PropertyValueFactory<subjectSelectionData,String>("bio"));
            this.chemColumn.setCellValueFactory(new PropertyValueFactory<subjectSelectionData,String>("chem"));
            this.phyColumn.setCellValueFactory(new PropertyValueFactory<subjectSelectionData,String>("phy"));
            this.hisColumn.setCellValueFactory(new PropertyValueFactory<subjectSelectionData,String>("his"));
            this.creColumn.setCellValueFactory(new PropertyValueFactory<subjectSelectionData,String>("cre"));
            this.geoColumn.setCellValueFactory(new PropertyValueFactory<subjectSelectionData,String>("geo"));
            this.busColumn.setCellValueFactory(new PropertyValueFactory<subjectSelectionData,String>("bus"));
            this.agriColumn.setCellValueFactory(new PropertyValueFactory<subjectSelectionData,String>("agri"));

            this.tableSubjectSel.setItems(null);
            this.tableSubjectSel.setItems(this.tableList);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    private void searchAdm(){
        String sqlSel = "SELECT * FROM tbl_subject_selection WHERE adm=?";
        try{
            Connection connection = Database.DBConnection.getConnection();
            this.tableList= FXCollections.observableArrayList();
            PreparedStatement statement = connection.prepareStatement(sqlSel);
            statement.setString(1,this.admSearch.getText().toUpperCase());
            ResultSet set = statement.executeQuery();
            while (set.next()){
                this.tableList.addAll(new subjectSelectionData(set.getString(1),set.getString(2),set.getString(3)+" "+set.getString(4)+" "+set.getString(5),set.getString(7),set.getString(8),set.getString(9),set.getString(10),set.getString(11),set.getString(12),set.getString(13),set.getString(14),set.getString(15),set.getString(16),set.getString(17),set.getString(18)));
            }

            this.idColumn.setCellValueFactory(new PropertyValueFactory<subjectSelectionData,String>("id"));
            this.admColumn.setCellValueFactory(new PropertyValueFactory<subjectSelectionData,String>("adm"));
            this.nameColumn.setCellValueFactory(new PropertyValueFactory<subjectSelectionData,String>("name"));
            this.classColumn.setCellValueFactory(new PropertyValueFactory<subjectSelectionData,String>("classs"));
            this.engColumn.setCellValueFactory(new PropertyValueFactory<subjectSelectionData,String>("eng"));
            this.kisColumn.setCellValueFactory(new PropertyValueFactory<subjectSelectionData,String>("kis"));
            this.matColumn.setCellValueFactory(new PropertyValueFactory<subjectSelectionData,String>("mat"));
            this.bioColumn.setCellValueFactory(new PropertyValueFactory<subjectSelectionData,String>("bio"));
            this.chemColumn.setCellValueFactory(new PropertyValueFactory<subjectSelectionData,String>("chem"));
            this.phyColumn.setCellValueFactory(new PropertyValueFactory<subjectSelectionData,String>("phy"));
            this.hisColumn.setCellValueFactory(new PropertyValueFactory<subjectSelectionData,String>("his"));
            this.creColumn.setCellValueFactory(new PropertyValueFactory<subjectSelectionData,String>("cre"));
            this.geoColumn.setCellValueFactory(new PropertyValueFactory<subjectSelectionData,String>("geo"));
            this.busColumn.setCellValueFactory(new PropertyValueFactory<subjectSelectionData,String>("bus"));
            this.agriColumn.setCellValueFactory(new PropertyValueFactory<subjectSelectionData,String>("agri"));

            this.tableSubjectSel.setItems(null);
            this.tableSubjectSel.setItems(this.tableList);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    private void engUpdate(TableColumn.CellEditEvent cellEditEvent){
        subjectSelectionData tableDataSelected = tableSubjectSel.getSelectionModel().getSelectedItem();
        String selection= tableDataSelected.setEng(cellEditEvent.getNewValue().toString().toUpperCase());
        String adm=tableDataSelected.getAdm();
        String sqlSel = "UPDATE tbl_subject_selection SET english=? WHERE adm=?";
        try{
            Connection connection = Database.DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sqlSel);

            statement.setString(1,selection.toUpperCase());
            statement.setString(2,adm.toUpperCase());

            statement.execute();
            connection.close();
            //loadData();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    private void kisUpdate(TableColumn.CellEditEvent cellEditEvent){
        subjectSelectionData tableDataSelected = tableSubjectSel.getSelectionModel().getSelectedItem();
        String selection= tableDataSelected.setKis(cellEditEvent.getNewValue().toString().toUpperCase());
        String adm=tableDataSelected.getAdm();
        String sqlSel = "UPDATE tbl_subject_selection SET kiswahili=? WHERE adm=?";
        try{
            Connection connection = Database.DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sqlSel);

            statement.setString(1,selection.toUpperCase());
            statement.setString(2,adm.toUpperCase());

            statement.execute();
            connection.close();
            //loadData();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    private void matUpdate(TableColumn.CellEditEvent cellEditEvent){
        subjectSelectionData tableDataSelected = tableSubjectSel.getSelectionModel().getSelectedItem();
        String selection= tableDataSelected.setMat(cellEditEvent.getNewValue().toString().toUpperCase());
        String adm=tableDataSelected.getAdm();
        String sqlSel = "UPDATE tbl_subject_selection SET mathematics=? WHERE adm=?";
        try{
            Connection connection = Database.DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sqlSel);

            statement.setString(1,selection.toUpperCase());
            statement.setString(2,adm.toUpperCase());

            statement.execute();
            connection.close();
            //loadData();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    private void bioUpdate(TableColumn.CellEditEvent cellEditEvent){
        subjectSelectionData tableDataSelected = tableSubjectSel.getSelectionModel().getSelectedItem();
        String selection= tableDataSelected.setBio(cellEditEvent.getNewValue().toString().toUpperCase());
        String adm=tableDataSelected.getAdm();
        String sqlSel = "UPDATE tbl_subject_selection SET biology=? WHERE adm=?";
        try{
            Connection connection = Database.DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sqlSel);

            statement.setString(1,selection.toUpperCase());
            statement.setString(2,adm.toUpperCase());

            statement.execute();
            connection.close();
            //loadData();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    private void chemUpdate(TableColumn.CellEditEvent cellEditEvent){
        subjectSelectionData tableDataSelected = tableSubjectSel.getSelectionModel().getSelectedItem();
        String selection= tableDataSelected.setChem(cellEditEvent.getNewValue().toString().toUpperCase());
        String adm=tableDataSelected.getAdm();
        String sqlSel = "UPDATE tbl_subject_selection SET chemistry=? WHERE adm=?";
        try{
            Connection connection = Database.DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sqlSel);

            statement.setString(1,selection.toUpperCase());
            statement.setString(2,adm.toUpperCase());

            statement.execute();
            connection.close();
            //loadData();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    private void phyUpdate(TableColumn.CellEditEvent cellEditEvent){
        subjectSelectionData tableDataSelected = tableSubjectSel.getSelectionModel().getSelectedItem();
        String selection= tableDataSelected.setPhy(cellEditEvent.getNewValue().toString().toUpperCase());
        String adm=tableDataSelected.getAdm();
        String sqlSel = "UPDATE tbl_subject_selection SET physics=? WHERE adm=?";
        try{
            Connection connection = Database.DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sqlSel);

            statement.setString(1,selection.toUpperCase());
            statement.setString(2,adm.toUpperCase());

            statement.execute();
            connection.close();
            //loadData();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    private void hisUpdate(TableColumn.CellEditEvent cellEditEvent){
        subjectSelectionData tableDataSelected = tableSubjectSel.getSelectionModel().getSelectedItem();
        String selection= tableDataSelected.setHis(cellEditEvent.getNewValue().toString().toUpperCase());
        String adm=tableDataSelected.getAdm();
        String sqlSel = "UPDATE tbl_subject_selection SET history=? WHERE adm=?";
        try{
            Connection connection = Database.DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sqlSel);

            statement.setString(1,selection.toUpperCase());
            statement.setString(2,adm.toUpperCase());

            statement.execute();
            connection.close();
           // loadData();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    private void creUpdate(TableColumn.CellEditEvent cellEditEvent){
        subjectSelectionData tableDataSelected = tableSubjectSel.getSelectionModel().getSelectedItem();
        String selection= tableDataSelected.setCre(cellEditEvent.getNewValue().toString().toUpperCase());
        String adm=tableDataSelected.getAdm();
        String sqlSel = "UPDATE tbl_subject_selection SET cre=? WHERE adm=?";
        try{
            Connection connection = Database.DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sqlSel);

            statement.setString(1,selection.toUpperCase());
            statement.setString(2,adm.toUpperCase());

            statement.execute();
            connection.close();
            //loadData();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    private void geoUpdate(TableColumn.CellEditEvent cellEditEvent){
        subjectSelectionData tableDataSelected = tableSubjectSel.getSelectionModel().getSelectedItem();
        String selection= tableDataSelected.setGeo(cellEditEvent.getNewValue().toString().toUpperCase());
        String adm=tableDataSelected.getAdm();
        String sqlSel = "UPDATE tbl_subject_selection SET geography=? WHERE adm=?";
        try{
            Connection connection = Database.DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sqlSel);

            statement.setString(1,selection.toUpperCase());
            statement.setString(2,adm.toUpperCase());

            statement.execute();
            connection.close();
            //loadData();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    private void busUpdate(TableColumn.CellEditEvent cellEditEvent){
        subjectSelectionData tableDataSelected = tableSubjectSel.getSelectionModel().getSelectedItem();
        String selection= tableDataSelected.setBus(cellEditEvent.getNewValue().toString().toUpperCase());
        String adm=tableDataSelected.getAdm();
        String sqlSel = "UPDATE tbl_subject_selection SET business=? WHERE adm=?";
        try{
            Connection connection = Database.DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sqlSel);

            statement.setString(1,selection.toUpperCase());
            statement.setString(2,adm.toUpperCase());

            statement.execute();
            connection.close();
            //loadData();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    private void agriUpdate(TableColumn.CellEditEvent cellEditEvent){
        subjectSelectionData tableDataSelected = tableSubjectSel.getSelectionModel().getSelectedItem();
        String selection= tableDataSelected.setAgri(cellEditEvent.getNewValue().toString().toUpperCase());
        String adm=tableDataSelected.getAdm();
        String sqlSel = "UPDATE tbl_subject_selection SET agriculture=? WHERE adm=?";
        try{
            Connection connection = Database.DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sqlSel);

            statement.setString(1,selection.toUpperCase());
            statement.setString(2,adm.toUpperCase());

            statement.execute();
            connection.close();
            //loadData();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadData();

        tableSubjectSel.setEditable(true);
        engColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        kisColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        matColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        bioColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        chemColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        phyColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        geoColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        hisColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        creColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        busColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        agriColumn.setCellFactory(TextFieldTableCell.forTableColumn());
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
            Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
            stage.getIcons().add(applicationIcon);
            Pane root = (Pane)loader.load(getClass().getResource("/F1/exams/marksEntry.fxml"));

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
            Pane root = (Pane)loader.load(getClass().getResource("/F1/classlist/showClasslist.fxml"));
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
            Pane root = (Pane)loader.load(getClass().getResource("../password.fxml"));
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
