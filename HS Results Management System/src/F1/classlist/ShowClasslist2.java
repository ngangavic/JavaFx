package F1.classlist;

import F1.exams.MarksEntry;
import about.About;
import alert.AlertBox;
import backup.ManualBackup;
import grade.Grade;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
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
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class ShowClasslist2 implements Initializable {

    @FXML
    private Label f1engt1,f1kist1,f1matt1,f1chemt1,f1biot1,f1phyt1,f1geot1,f1hist1,f1cret1,f1bust1,f1agrit1,f1meant1;

    @FXML
    private Label f1engt2,f1kist2,f1matt2,f1chemt2,f1biot2,f1phyt2,f1geot2,f1hist2,f1cret2,f1bust2,f1agrit2,f1meant2;

    @FXML
    private Label f1engt3,f1kist3,f1matt3,f1chemt3,f1biot3,f1phyt3,f1geot3,f1hist3,f1cret3,f1bust3,f1agrit3,f1meant3;

    @FXML
    private Label f2engt1,f2kist1,f2matt1,f2chemt1,f2biot1,f2phyt1,f2geot1,f2hist1,f2cret1,f2bust1,f2agrit1,f2meant1;

    @FXML
    private Label f2engt2,f2kist2,f2matt2,f2chemt2,f2biot2,f2phyt2,f2geot2,f2hist2,f2cret2,f2bust2,f2agrit2,f2meant2;

    @FXML
    private Label f2engt3,f2kist3,f2matt3,f2chemt3,f2biot3,f2phyt3,f2geot3,f2hist3,f2cret3,f2bust3,f2agrit3,f2meant3;

    @FXML
    private Label f3engt1,f3kist1,f3matt1,f3chemt1,f3biot1,f3phyt1,f3geot1,f3hist1,f3cret1,f3bust1,f3agrit1,f3meant1;

    @FXML
    private Label f3engt2,f3kist2,f3matt2,f3chemt2,f3biot2,f3phyt2,f3geot2,f3hist2,f3cret2,f3bust2,f3agrit2,f3meant2;

    @FXML
    private Label f3engt3,f3kist3,f3matt3,f3chemt3,f3biot3,f3phyt3,f3geot3,f3hist3,f3cret3,f3bust3,f3agrit3,f3meant3;

    @FXML
    private Label f4engt1,f4kist1,f4matt1,f4chemt1,f4biot1,f4phyt1,f4geot1,f4hist1,f4cret1,f4bust1,f4agrit1,f4meant1;

    @FXML
    private Label f4engt2,f4kist2,f4matt2,f4chemt2,f4biot2,f4phyt2,f4geot2,f4hist2,f4cret2,f4bust2,f4agrit2,f4meant2;

    @FXML
    private Label f4engt3,f4kist3,f4matt3,f4chemt3,f4biot3,f4phyt3,f4geot3,f4hist3,f4cret3,f4bust3,f4agrit3,f4meant3;

    @FXML
    private AnchorPane windowCurrent;

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

    public void showSummaryf1(){
try{
    Connection connection = Database.DBConnection.getConnection();
    String f1t1 = "SELECT AVG(eng),AVG(kis),AVG(mat),AVG(chem),AVG(phy),AVG(bio),AVG(geo),AVG(his),AVG(cre),AVG(bus),AVG(agri),AVG(total) FROM tbl_f1_t1_avg WHERE class='FORM_1'";
    String f1t2 = "SELECT AVG(eng),AVG(kis),AVG(mat),AVG(chem),AVG(phy),AVG(bio),AVG(geo),AVG(his),AVG(cre),AVG(bus),AVG(agri),AVG(total) FROM tbl_f1_t2_avg WHERE class='FORM_1'";
    String f1t3 = "SELECT AVG(eng),AVG(kis),AVG(mat),AVG(chem),AVG(phy),AVG(bio),AVG(geo),AVG(his),AVG(cre),AVG(bus),AVG(agri),AVG(total) FROM tbl_f1_t3_avg WHERE class='FORM_1'";
    String f2t1 = "SELECT AVG(eng),AVG(kis),AVG(mat),AVG(chem),AVG(phy),AVG(bio),AVG(geo),AVG(his),AVG(cre),AVG(bus),AVG(agri),AVG(total) FROM tbl_f2_t1_avg WHERE class='FORM_2'";
    String f2t2 = "SELECT AVG(eng),AVG(kis),AVG(mat),AVG(chem),AVG(phy),AVG(bio),AVG(geo),AVG(his),AVG(cre),AVG(bus),AVG(agri),AVG(total) FROM tbl_f2_t2_avg WHERE class='FORM_2'";
    String f2t3 = "SELECT AVG(eng),AVG(kis),AVG(mat),AVG(chem),AVG(phy),AVG(bio),AVG(geo),AVG(his),AVG(cre),AVG(bus),AVG(agri),AVG(total) FROM tbl_f2_t3_avg WHERE class='FORM_2'";
    ResultSet setF1T1 = connection.createStatement().executeQuery(f1t1);
    while (setF1T1.next()) {
        float f1t1eng = Float.parseFloat(setF1T1.getString(1));
        float f1t1kis = Float.parseFloat(setF1T1.getString(2));
        float f1t1mat = Float.parseFloat(setF1T1.getString(3));
        float f1t1chem = Float.parseFloat(setF1T1.getString(4));
        float f1t1phy = Float.parseFloat(setF1T1.getString(5));
        float f1t1bio = Float.parseFloat(setF1T1.getString(6));
        float f1t1geo = Float.parseFloat(setF1T1.getString(7));
        float f1t1his = Float.parseFloat(setF1T1.getString(8));
        float f1t1cre = Float.parseFloat(setF1T1.getString(9));
        float f1t1bus = Float.parseFloat(setF1T1.getString(10));
        float f1t1agri = Float.parseFloat(setF1T1.getString(11));
        float f1t1mean = Float.parseFloat(setF1T1.getString(12));
       // f1engt1.setText(setF1T1Ex1.getString(1));
        f1engt1.setText(String.format("%.1f",f1t1eng));
        f1kist1.setText(String.format("%.1f",f1t1kis));
        f1matt1.setText(String.format("%.1f",f1t1mat));
        f1chemt1.setText(String.format("%.1f",f1t1chem));
        f1phyt1.setText(String.format("%.1f",f1t1phy));
        f1biot1.setText(String.format("%.1f",f1t1bio));
        f1geot1.setText(String.format("%.1f",f1t1geo));
        f1hist1.setText(String.format("%.1f",f1t1his));
        f1cret1.setText(String.format("%.1f",f1t1cre));
        f1bust1.setText(String.format("%.1f",f1t1bus));
        f1agrit1.setText(String.format("%.1f",f1t1agri));
        f1meant1.setText(String.format("%.1f",f1t1mean));
    }
    ResultSet setF1T2 = connection.createStatement().executeQuery(f1t2);
    while (setF1T2.next()) {
        float f1t2eng = Float.parseFloat(setF1T2.getString(1));
        float f1t2kis = Float.parseFloat(setF1T2.getString(2));
        float f1t2mat = Float.parseFloat(setF1T2.getString(3));
        float f1t2chem = Float.parseFloat(setF1T2.getString(4));
        float f1t2phy = Float.parseFloat(setF1T2.getString(5));
        float f1t2bio = Float.parseFloat(setF1T2.getString(6));
        float f1t2geo = Float.parseFloat(setF1T2.getString(7));
        float f1t2his = Float.parseFloat(setF1T2.getString(8));
        float f1t2cre = Float.parseFloat(setF1T2.getString(9));
        float f1t2bus = Float.parseFloat(setF1T2.getString(10));
        float f1t2agri = Float.parseFloat(setF1T2.getString(11));
        float f1t2mean = Float.parseFloat(setF1T2.getString(12));
        // f1engt1.setText(setF1T1Ex1.getString(1));
        f1engt2.setText(String.format("%.1f",f1t2eng));
        f1kist2.setText(String.format("%.1f",f1t2kis));
        f1matt2.setText(String.format("%.1f",f1t2mat));
        f1chemt2.setText(String.format("%.1f",f1t2chem));
        f1phyt2.setText(String.format("%.1f",f1t2phy));
        f1biot2.setText(String.format("%.1f",f1t2bio));
        f1geot2.setText(String.format("%.1f",f1t2geo));
        f1hist2.setText(String.format("%.1f",f1t2his));
        f1cret2.setText(String.format("%.1f",f1t2cre));
        f1bust2.setText(String.format("%.1f",f1t2bus));
        f1agrit2.setText(String.format("%.1f",f1t2agri));
        f1meant2.setText(String.format("%.1f",f1t2mean));
    }
    ResultSet setF1T3 = connection.createStatement().executeQuery(f1t3);
    while (setF1T3.next()) {
        float f1t3eng = Float.parseFloat(setF1T3.getString(1));
        float f1t3kis = Float.parseFloat(setF1T3.getString(2));
        float f1t3mat = Float.parseFloat(setF1T3.getString(3));
        float f1t3chem = Float.parseFloat(setF1T3.getString(4));
        float f1t3phy = Float.parseFloat(setF1T3.getString(5));
        float f1t3bio = Float.parseFloat(setF1T3.getString(6));
        float f1t3geo = Float.parseFloat(setF1T3.getString(7));
        float f1t3his = Float.parseFloat(setF1T3.getString(8));
        float f1t3cre = Float.parseFloat(setF1T3.getString(9));
        float f1t3bus = Float.parseFloat(setF1T3.getString(10));
        float f1t3agri = Float.parseFloat(setF1T3.getString(11));
        float f1t3mean = Float.parseFloat(setF1T3.getString(12));
        // f1engt1.setText(setF1T1Ex1.getString(1));
        f1engt3.setText(String.format("%.1f",f1t3eng));
        f1kist3.setText(String.format("%.1f",f1t3kis));
        f1matt3.setText(String.format("%.1f",f1t3mat));
        f1chemt3.setText(String.format("%.1f",f1t3chem));
        f1phyt3.setText(String.format("%.1f",f1t3phy));
        f1biot3.setText(String.format("%.1f",f1t3bio));
        f1geot3.setText(String.format("%.1f",f1t3geo));
        f1hist3.setText(String.format("%.1f",f1t3his));
        f1cret3.setText(String.format("%.1f",f1t3cre));
        f1bust3.setText(String.format("%.1f",f1t3bus));
        f1agrit3.setText(String.format("%.1f",f1t3agri));
        f1meant3.setText(String.format("%.1f",f1t3mean));
    }

}catch (Exception e){
    e.printStackTrace();
}
    }

    public void showSummaryf2(){
        try{
            Connection connection = Database.DBConnection.getConnection();
            String f2t1 = "SELECT AVG(eng),AVG(kis),AVG(mat),AVG(chem),AVG(phy),AVG(bio),AVG(geo),AVG(his),AVG(cre),AVG(bus),AVG(agri),AVG(total) FROM tbl_f2_t1_avg WHERE class='FORM_2'";
            String f2t2 = "SELECT AVG(eng),AVG(kis),AVG(mat),AVG(chem),AVG(phy),AVG(bio),AVG(geo),AVG(his),AVG(cre),AVG(bus),AVG(agri),AVG(total) FROM tbl_f2_t2_avg WHERE class='FORM_2'";
            String f2t3 = "SELECT AVG(eng),AVG(kis),AVG(mat),AVG(chem),AVG(phy),AVG(bio),AVG(geo),AVG(his),AVG(cre),AVG(bus),AVG(agri),AVG(total) FROM tbl_f2_t3_avg WHERE class='FORM_2'";
            ResultSet setF2T1 = connection.createStatement().executeQuery(f2t1);
            while (setF2T1.next()) {
                float f2t1eng = Float.parseFloat(setF2T1.getString(1));
                float f2t1kis = Float.parseFloat(setF2T1.getString(2));
                float f2t1mat = Float.parseFloat(setF2T1.getString(3));
                float f2t1chem = Float.parseFloat(setF2T1.getString(4));
                float f2t1phy = Float.parseFloat(setF2T1.getString(5));
                float f2t1bio = Float.parseFloat(setF2T1.getString(6));
                float f2t1geo = Float.parseFloat(setF2T1.getString(7));
                float f2t1his = Float.parseFloat(setF2T1.getString(8));
                float f2t1cre = Float.parseFloat(setF2T1.getString(9));
                float f2t1bus = Float.parseFloat(setF2T1.getString(10));
                float f2t1agri = Float.parseFloat(setF2T1.getString(11));
                float f2t1mean = Float.parseFloat(setF2T1.getString(12));
                // f1engt1.setText(setF1T1Ex1.getString(1));
                f2engt1.setText(String.format("%.1f",f2t1eng));
                f2kist1.setText(String.format("%.1f",f2t1kis));
                f2matt1.setText(String.format("%.1f",f2t1mat));
                f2chemt1.setText(String.format("%.1f",f2t1chem));
                f2phyt1.setText(String.format("%.1f",f2t1phy));
                f2biot1.setText(String.format("%.1f",f2t1bio));
                f2geot1.setText(String.format("%.1f",f2t1geo));
                f2hist1.setText(String.format("%.1f",f2t1his));
                f2cret1.setText(String.format("%.1f",f2t1cre));
                f2bust1.setText(String.format("%.1f",f2t1bus));
                f2agrit1.setText(String.format("%.1f",f2t1agri));
                f2meant1.setText(String.format("%.1f",f2t1mean));
            }
            ResultSet setF2T2 = connection.createStatement().executeQuery(f2t2);
            while (setF2T2.next()) {
                float f2t2eng = Float.parseFloat(setF2T2.getString(1));
                float f2t2kis = Float.parseFloat(setF2T2.getString(2));
                float f2t2mat = Float.parseFloat(setF2T2.getString(3));
                float f2t2chem = Float.parseFloat(setF2T2.getString(4));
                float f2t2phy = Float.parseFloat(setF2T2.getString(5));
                float f2t2bio = Float.parseFloat(setF2T2.getString(6));
                float f2t2geo = Float.parseFloat(setF2T2.getString(7));
                float f2t2his = Float.parseFloat(setF2T2.getString(8));
                float f2t2cre = Float.parseFloat(setF2T2.getString(9));
                float f2t2bus = Float.parseFloat(setF2T2.getString(10));
                float f2t2agri = Float.parseFloat(setF2T2.getString(11));
                float f2t2mean = Float.parseFloat(setF2T2.getString(12));
                // f1engt1.setText(setF1T1Ex1.getString(1));
                f2engt2.setText(String.format("%.1f",f2t2eng));
                f2kist2.setText(String.format("%.1f",f2t2kis));
                f2matt2.setText(String.format("%.1f",f2t2mat));
                f2chemt2.setText(String.format("%.1f",f2t2chem));
                f2phyt2.setText(String.format("%.1f",f2t2phy));
                f2biot2.setText(String.format("%.1f",f2t2bio));
                f2geot2.setText(String.format("%.1f",f2t2geo));
                f2hist2.setText(String.format("%.1f",f2t2his));
                f2cret2.setText(String.format("%.1f",f2t2cre));
                f2bust2.setText(String.format("%.1f",f2t2bus));
                f2agrit2.setText(String.format("%.1f",f2t2agri));
                f2meant2.setText(String.format("%.1f",f2t2mean));
            }
            ResultSet setF2T3 = connection.createStatement().executeQuery(f2t3);
            while (setF2T3.next()) {
                float f2t3eng = Float.parseFloat(setF2T3.getString(1));
                float f2t3kis = Float.parseFloat(setF2T3.getString(2));
                float f2t3mat = Float.parseFloat(setF2T3.getString(3));
                float f2t3chem = Float.parseFloat(setF2T3.getString(4));
                float f2t3phy = Float.parseFloat(setF2T3.getString(5));
                float f2t3bio = Float.parseFloat(setF2T3.getString(6));
                float f2t3geo = Float.parseFloat(setF2T3.getString(7));
                float f2t3his = Float.parseFloat(setF2T3.getString(8));
                float f2t3cre = Float.parseFloat(setF2T3.getString(9));
                float f2t3bus = Float.parseFloat(setF2T3.getString(10));
                float f2t3agri = Float.parseFloat(setF2T3.getString(11));
                float f2t3mean = Float.parseFloat(setF2T3.getString(12));
                // f1engt1.setText(setF1T1Ex1.getString(1));
                f2engt3.setText(String.format("%.1f",f2t3eng));
                f2kist3.setText(String.format("%.1f",f2t3kis));
                f2matt3.setText(String.format("%.1f",f2t3mat));
                f2chemt3.setText(String.format("%.1f",f2t3chem));
                f2phyt3.setText(String.format("%.1f",f2t3phy));
                f2biot3.setText(String.format("%.1f",f2t3bio));
                f2geot3.setText(String.format("%.1f",f2t3geo));
                f2hist3.setText(String.format("%.1f",f2t3his));
                f2cret3.setText(String.format("%.1f",f2t3cre));
                f2bust3.setText(String.format("%.1f",f2t3bus));
                f2agrit3.setText(String.format("%.1f",f2t3agri));
                f2meant3.setText(String.format("%.1f",f2t3mean));
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void showSummaryf3(){
        try{
            Connection connection = Database.DBConnection.getConnection();
            String f3t1 = "SELECT AVG(eng),AVG(kis),AVG(mat),AVG(chem),AVG(phy),AVG(bio),AVG(geo),AVG(his),AVG(cre),AVG(bus),AVG(agri),AVG(total) FROM tbl_f3_t1_avg WHERE class='FORM_3'";
            String f3t2 = "SELECT AVG(eng),AVG(kis),AVG(mat),AVG(chem),AVG(phy),AVG(bio),AVG(geo),AVG(his),AVG(cre),AVG(bus),AVG(agri),AVG(total) FROM tbl_f3_t2_avg WHERE class='FORM_3'";
            String f3t3 = "SELECT AVG(eng),AVG(kis),AVG(mat),AVG(chem),AVG(phy),AVG(bio),AVG(geo),AVG(his),AVG(cre),AVG(bus),AVG(agri),AVG(total) FROM tbl_f3_t3_avg WHERE class='FORM_3'";
            ResultSet setF3T1 = connection.createStatement().executeQuery(f3t1);
            while (setF3T1.next()) {
                float f3t1eng = Float.parseFloat(setF3T1.getString(1));
                float f3t1kis = Float.parseFloat(setF3T1.getString(2));
                float f3t1mat = Float.parseFloat(setF3T1.getString(3));
                float f3t1chem = Float.parseFloat(setF3T1.getString(4));
                float f3t1phy = Float.parseFloat(setF3T1.getString(5));
                float f3t1bio = Float.parseFloat(setF3T1.getString(6));
                float f3t1geo = Float.parseFloat(setF3T1.getString(7));
                float f3t1his = Float.parseFloat(setF3T1.getString(8));
                float f3t1cre = Float.parseFloat(setF3T1.getString(9));
                float f3t1bus = Float.parseFloat(setF3T1.getString(10));
                float f3t1agri = Float.parseFloat(setF3T1.getString(11));
                float f3t1mean = Float.parseFloat(setF3T1.getString(12));
                // f1engt1.setText(setF1T1Ex1.getString(1));""||||
                f3engt1.setText(String.format("%.1f",f3t1eng));
                f3kist1.setText(String.format("%.1f",f3t1kis));
                f3matt1.setText(String.format("%.1f",f3t1mat));
                f3chemt1.setText(String.format("%.1f",f3t1chem));
                f3phyt1.setText(String.format("%.1f",f3t1phy));
                f3biot1.setText(String.format("%.1f",f3t1bio));
                f3geot1.setText(String.format("%.1f",f3t1geo));
                f3hist1.setText(String.format("%.1f",f3t1his));
                f3cret1.setText(String.format("%.1f",f3t1cre));
                f3bust1.setText(String.format("%.1f",f3t1bus));
                f3agrit1.setText(String.format("%.1f",f3t1agri));
                f3meant1.setText(String.format("%.1f",f3t1mean));
            }
            ResultSet setF3T2 = connection.createStatement().executeQuery(f3t2);
            while (setF3T2.next()) {
                float f3t2eng = Float.parseFloat(setF3T2.getString(1));
                float f3t2kis = Float.parseFloat(setF3T2.getString(2));
                float f3t2mat = Float.parseFloat(setF3T2.getString(3));
                float f3t2chem = Float.parseFloat(setF3T2.getString(4));
                float f3t2phy = Float.parseFloat(setF3T2.getString(5));
                float f3t2bio = Float.parseFloat(setF3T2.getString(6));
                float f3t2geo = Float.parseFloat(setF3T2.getString(7));
                float f3t2his = Float.parseFloat(setF3T2.getString(8));
                float f3t2cre = Float.parseFloat(setF3T2.getString(9));
                float f3t2bus = Float.parseFloat(setF3T2.getString(10));
                float f3t2agri = Float.parseFloat(setF3T2.getString(11));
                float f3t2mean = Float.parseFloat(setF3T2.getString(12));
                // f1engt1.setText(setF1T1Ex1.getString(1));
                f3engt2.setText(String.format("%.1f",f3t2eng));
                f3kist2.setText(String.format("%.1f",f3t2kis));
                f3matt2.setText(String.format("%.1f",f3t2mat));
                f3chemt2.setText(String.format("%.1f",f3t2chem));
                f3phyt2.setText(String.format("%.1f",f3t2phy));
                f3biot2.setText(String.format("%.1f",f3t2bio));
                f3geot2.setText(String.format("%.1f",f3t2geo));
                f3hist2.setText(String.format("%.1f",f3t2his));
                f3cret2.setText(String.format("%.1f",f3t2cre));
                f3bust2.setText(String.format("%.1f",f3t2bus));
                f3agrit2.setText(String.format("%.1f",f3t2agri));
                f3meant2.setText(String.format("%.1f",f3t2mean));
            }
            ResultSet setF3T3 = connection.createStatement().executeQuery(f3t3);
            while (setF3T3.next()) {
                float f3t3eng = Float.parseFloat(setF3T3.getString(1));
                float f3t3kis = Float.parseFloat(setF3T3.getString(2));
                float f3t3mat = Float.parseFloat(setF3T3.getString(3));
                float f3t3chem = Float.parseFloat(setF3T3.getString(4));
                float f3t3phy = Float.parseFloat(setF3T3.getString(5));
                float f3t3bio = Float.parseFloat(setF3T3.getString(6));
                float f3t3geo = Float.parseFloat(setF3T3.getString(7));
                float f3t3his = Float.parseFloat(setF3T3.getString(8));
                float f3t3cre = Float.parseFloat(setF3T3.getString(9));
                float f3t3bus = Float.parseFloat(setF3T3.getString(10));
                float f3t3agri = Float.parseFloat(setF3T3.getString(11));
                float f3t3mean = Float.parseFloat(setF3T3.getString(12));
                // f1engt1.setText(setF1T1Ex1.getString(1));
                f3engt3.setText(String.format("%.1f",f3t3eng));
                f3kist3.setText(String.format("%.1f",f3t3kis));
                f3matt3.setText(String.format("%.1f",f3t3mat));
                f3chemt3.setText(String.format("%.1f",f3t3chem));
                f3phyt3.setText(String.format("%.1f",f3t3phy));
                f3biot3.setText(String.format("%.1f",f3t3bio));
                f3geot3.setText(String.format("%.1f",f3t3geo));
                f3hist3.setText(String.format("%.1f",f3t3his));
                f3cret3.setText(String.format("%.1f",f3t3cre));
                f3bust3.setText(String.format("%.1f",f3t3bus));
                f3agrit3.setText(String.format("%.1f",f3t3agri));
                f3meant3.setText(String.format("%.1f",f3t3mean));
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void showSummaryf4(){
        try{
            Connection connection = Database.DBConnection.getConnection();
            String f4t1 = "SELECT AVG(eng),AVG(kis),AVG(mat),AVG(chem),AVG(phy),AVG(bio),AVG(geo),AVG(his),AVG(cre),AVG(bus),AVG(agri),AVG(total) FROM tbl_f4_t1_avg WHERE class='FORM_4'";
            String f4t2 = "SELECT AVG(eng),AVG(kis),AVG(mat),AVG(chem),AVG(phy),AVG(bio),AVG(geo),AVG(his),AVG(cre),AVG(bus),AVG(agri),AVG(total) FROM tbl_f4_t2_avg WHERE class='FORM_4'";
            String f4t3 = "SELECT AVG(eng),AVG(kis),AVG(mat),AVG(chem),AVG(phy),AVG(bio),AVG(geo),AVG(his),AVG(cre),AVG(bus),AVG(agri),AVG(total) FROM tbl_f4_t3_avg WHERE class='FORM_4'";
            ResultSet setF4T1 = connection.createStatement().executeQuery(f4t1);
            while (setF4T1.next()) {
                float f4t1eng = Float.parseFloat(setF4T1.getString(1));
                float f4t1kis = Float.parseFloat(setF4T1.getString(2));
                float f4t1mat = Float.parseFloat(setF4T1.getString(3));
                float f4t1chem = Float.parseFloat(setF4T1.getString(4));
                float f4t1phy = Float.parseFloat(setF4T1.getString(5));
                float f4t1bio = Float.parseFloat(setF4T1.getString(6));
                float f4t1geo = Float.parseFloat(setF4T1.getString(7));
                float f4t1his = Float.parseFloat(setF4T1.getString(8));
                float f4t1cre = Float.parseFloat(setF4T1.getString(9));
                float f4t1bus = Float.parseFloat(setF4T1.getString(10));
                float f4t1agri = Float.parseFloat(setF4T1.getString(11));
                float f4t1mean = Float.parseFloat(setF4T1.getString(12));
                // f1engt1.setText(setF1T1Ex1.getString(1));""||||
                f4engt1.setText(String.format("%.1f",f4t1eng));
                f4kist1.setText(String.format("%.1f",f4t1kis));
                f4matt1.setText(String.format("%.1f",f4t1mat));
                f4chemt1.setText(String.format("%.1f",f4t1chem));
                f4phyt1.setText(String.format("%.1f",f4t1phy));
                f4biot1.setText(String.format("%.1f",f4t1bio));
                f4geot1.setText(String.format("%.1f",f4t1geo));
                f4hist1.setText(String.format("%.1f",f4t1his));
                f4cret1.setText(String.format("%.1f",f4t1cre));
                f4bust1.setText(String.format("%.1f",f4t1bus));
                f4agrit1.setText(String.format("%.1f",f4t1agri));
                f4meant1.setText(String.format("%.1f",f4t1mean));
            }
            ResultSet setF4T2 = connection.createStatement().executeQuery(f4t2);
            while (setF4T2.next()) {
                float f4t2eng = Float.parseFloat(setF4T2.getString(1));
                float f4t2kis = Float.parseFloat(setF4T2.getString(2));
                float f4t2mat = Float.parseFloat(setF4T2.getString(3));
                float f4t2chem = Float.parseFloat(setF4T2.getString(4));
                float f4t2phy = Float.parseFloat(setF4T2.getString(5));
                float f4t2bio = Float.parseFloat(setF4T2.getString(6));
                float f4t2geo = Float.parseFloat(setF4T2.getString(7));
                float f4t2his = Float.parseFloat(setF4T2.getString(8));
                float f4t2cre = Float.parseFloat(setF4T2.getString(9));
                float f4t2bus = Float.parseFloat(setF4T2.getString(10));
                float f4t2agri = Float.parseFloat(setF4T2.getString(11));
                float f4t2mean = Float.parseFloat(setF4T2.getString(12));
                // f1engt1.setText(setF1T1Ex1.getString(1));
                f4engt2.setText(String.format("%.1f",f4t2eng));
                f4kist2.setText(String.format("%.1f",f4t2kis));
                f4matt2.setText(String.format("%.1f",f4t2mat));
                f4chemt2.setText(String.format("%.1f",f4t2chem));
                f4phyt2.setText(String.format("%.1f",f4t2phy));
                f4biot2.setText(String.format("%.1f",f4t2bio));
                f4geot2.setText(String.format("%.1f",f4t2geo));
                f4hist2.setText(String.format("%.1f",f4t2his));
                f4cret2.setText(String.format("%.1f",f4t2cre));
                f4bust2.setText(String.format("%.1f",f4t2bus));
                f4agrit2.setText(String.format("%.1f",f4t2agri));
                f4meant2.setText(String.format("%.1f",f4t2mean));
            }
            ResultSet setF4T3 = connection.createStatement().executeQuery(f4t3);
            while (setF4T3.next()) {
                float f4t3eng = Float.parseFloat(setF4T3.getString(1));
                float f4t3kis = Float.parseFloat(setF4T3.getString(2));
                float f4t3mat = Float.parseFloat(setF4T3.getString(3));
                float f4t3chem = Float.parseFloat(setF4T3.getString(4));
                float f4t3phy = Float.parseFloat(setF4T3.getString(5));
                float f4t3bio = Float.parseFloat(setF4T3.getString(6));
                float f4t3geo = Float.parseFloat(setF4T3.getString(7));
                float f4t3his = Float.parseFloat(setF4T3.getString(8));
                float f4t3cre = Float.parseFloat(setF4T3.getString(9));
                float f4t3bus = Float.parseFloat(setF4T3.getString(10));
                float f4t3agri = Float.parseFloat(setF4T3.getString(11));
                float f4t3mean = Float.parseFloat(setF4T3.getString(12));
                // f1engt1.setText(setF1T1Ex1.getString(1));
                f4engt3.setText(String.format("%.1f",f4t3eng));
                f4kist3.setText(String.format("%.1f",f4t3kis));
                f4matt3.setText(String.format("%.1f",f4t3mat));
                f4chemt3.setText(String.format("%.1f",f4t3chem));
                f4phyt3.setText(String.format("%.1f",f4t3phy));
                f4biot3.setText(String.format("%.1f",f4t3bio));
                f4geot3.setText(String.format("%.1f",f4t3geo));
                f4hist3.setText(String.format("%.1f",f4t3his));
                f4cret3.setText(String.format("%.1f",f4t3cre));
                f4bust3.setText(String.format("%.1f",f4t3bus));
                f4agrit3.setText(String.format("%.1f",f4t3agri));
                f4meant3.setText(String.format("%.1f",f4t3mean));
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void refreshSummary(){
        showSummaryf1();
        showSummaryf2();
        showSummaryf3();
        showSummaryf4();
    }

    public void onCloseSystem(){
        Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
        stageToClose.setOnCloseRequest(event -> {
            event.consume();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Close System.");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to exit the system.");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.showAndWait();
            if (alert.getResult().getButtonData().isCancelButton()){
                alert.close();
            }else {
                closeSystem();
            }

        });
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        showSummaryf1();
        showSummaryf2();
        showSummaryf3();
        showSummaryf4();
    }
}
