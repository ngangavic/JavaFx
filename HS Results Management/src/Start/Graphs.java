package Start;


import Admin.Main;
import F1.ClassLists.T1.ClasslistT1Avg;
import F1.ClassLists.T1.ClasslistT1E1;
import F1.ClassLists.T1.ClasslistT1E2;
import F1.ClassLists.T1.ClasslistT1E3;
import F1.ClassLists.T2.ClasslistT2Avg;
import F1.ClassLists.T2.ClasslistT2E1;
import F1.ClassLists.T2.ClasslistT2E2;
import F1.ClassLists.T2.ClasslistT2E3;
import F1.ClassLists.T3.ClasslistT3Avg;
import F1.ClassLists.T3.ClasslistT3E1;
import F1.ClassLists.T3.ClasslistT3E2;
import F1.ClassLists.T3.ClasslistT3E3;
import F1.Exams.AgriEntry;
import F1.Exams.BioEntry;
import F1.Exams.BusEntry;
import F1.Exams.CreEntry;
import F1.Exams.EngEntry;
import F1.Exams.GeoEntry;
import F1.Exams.HisEntry;
import F1.Exams.KisEntry;
import F1.Exams.MatEntry;
import F1.Exams.PhyEntry;

import F2.Exams.ChemEntry;
import Grade.Grade;
import Students.AddStudents;
import Students.SubjectSelection;
import Teacher.Teacher;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static Alerts.informationBox.infoBox;
import static Alerts.informationBox.infoBoxError;

public class Graphs implements Initializable{

    @FXML
    private MenuBar menuBar;

    public void closeSystem(){
        System.exit(0);
    }

    public void clickAddStudents(){

        try{
            Stage stageToClose = (Stage)menuBar.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane) loader.load(getClass().getResource("/Students/addStudents.fxml"));

            AddStudents addStudents = (AddStudents) loader.getController();

            Image applicationIcon = new Image(getClass().getResourceAsStream("/icon.jpg"));
            stage.getIcons().add(applicationIcon);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("HSRM-ADD STUDENTS");
            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
            stageToClose.close();

        }catch (IOException e){
            e.printStackTrace();
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    public void clickViewStudents(){
        try{
            Stage stageToClose = (Stage)menuBar.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/Students/addStudents.fxml"));

            AddStudents addStudents = (AddStudents) loader.getController();

            Image applicationIcon = new Image(getClass().getResourceAsStream("/icon.jpg"));
            stage.getIcons().add(applicationIcon);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("HSRM-VIEW STUDENTS");
            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    public void clickSubjectSelection(){
        try{
            Stage stageToClose = (Stage)menuBar.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/Students/subjectSelection.fxml"));

            SubjectSelection subjectSelection = (SubjectSelection) loader.getController();

            Image applicationIcon = new Image(getClass().getResourceAsStream("/icon.jpg"));
            stage.getIcons().add(applicationIcon);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("HSRM-SUBJECT SELECTION");
            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    public void clickGrades(){
        try{
            Stage stageToClose = (Stage)menuBar.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/Grade/grade.fxml"));

            Grade grade = (Grade) loader.getController();

            Image applicationIcon = new Image(getClass().getResourceAsStream("/icon.jpg"));
            stage.getIcons().add(applicationIcon);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("HSRM-GRADE SETTINGS");
            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    public void clickTeachers(){
        try{
            Stage stageToClose = (Stage)menuBar.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/Teacher/teacher.fxml"));

            Teacher teacher = (Teacher) loader.getController();

            Image applicationIcon = new Image(getClass().getResourceAsStream("/icon.jpg"));
            stage.getIcons().add(applicationIcon);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("HSRM-TEACHERS SETTING");
            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    public void clickForm1EnglishEntry(){
        try{
            Stage stageToClose = (Stage)menuBar.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/Exams/engEntry.fxml"));

            EngEntry engEntry = (EngEntry) loader.getController();

            Image applicationIcon = new Image(getClass().getResourceAsStream("/icon.jpg"));
            stage.getIcons().add(applicationIcon);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("HSRM-FORM 1 ENGLISH [Marks Entry]");
            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    public void clickForm1KiswahiliEntry(){
        try{
            Stage stageToClose = (Stage)menuBar.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/Exams/kisEntry.fxml"));

            KisEntry kisEntry = (KisEntry) loader.getController();

            Image applicationIcon = new Image(getClass().getResourceAsStream("/icon.jpg"));
            stage.getIcons().add(applicationIcon);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("HSRM-FORM 1 KISWAHILI [Marks Entry]");
            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    public void clickForm1MathsEntry(){
        try{
            Stage stageToClose = (Stage)menuBar.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/Exams/matEntry.fxml"));

            MatEntry matEntry = (MatEntry) loader.getController();

            Image applicationIcon = new Image(getClass().getResourceAsStream("/icon.jpg"));
            stage.getIcons().add(applicationIcon);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("HSRM-FORM 1 MATHEMATICS [Marks Entry]");
            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    public void clickForm1ChemistryEntry(){
        try{
            Stage stageToClose = (Stage)menuBar.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/Exams/chemEntry.fxml"));

            ChemEntry chemEntry = (ChemEntry) loader.getController();

            Image applicationIcon = new Image(getClass().getResourceAsStream("/icon.jpg"));
            stage.getIcons().add(applicationIcon);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("HSRM-FORM 1 CHEMISTRY [Marks Entry]");
            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    public void clickForm1BiologyEntry(){
        try{
            Stage stageToClose = (Stage)menuBar.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/Exams/bioEntry.fxml"));

            BioEntry bioEntry = (BioEntry) loader.getController();

            Image applicationIcon = new Image(getClass().getResourceAsStream("/icon.jpg"));
            stage.getIcons().add(applicationIcon);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("HSRM-FORM 1 BIOLOGY [Marks Entry]");
            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    public void clickForm1PhysicsEntry(){
        try{
            Stage stageToClose = (Stage)menuBar.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/Exams/phyEntry.fxml"));

            PhyEntry phyEntry = (PhyEntry) loader.getController();

            Image applicationIcon = new Image(getClass().getResourceAsStream("/icon.jpg"));
            stage.getIcons().add(applicationIcon);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("HSRM-FORM 1 PHYSICS [Marks Entry]");
            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    public void clickForm1HistoryEntry(){
        try{
            Stage stageToClose = (Stage)menuBar.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/Exams/hisEntry.fxml"));

            HisEntry hisEntry = (HisEntry) loader.getController();

            Image applicationIcon = new Image(getClass().getResourceAsStream("/icon.jpg"));
            stage.getIcons().add(applicationIcon);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("HSRM-FORM 1 HISTORY [Marks Entry]");
            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    public void clickForm1GeographyEntry(){
        try{
            Stage stageToClose = (Stage)menuBar.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/Exams/geoEntry.fxml"));

            GeoEntry geoEntry = (GeoEntry) loader.getController();

            Image applicationIcon = new Image(getClass().getResourceAsStream("/icon.jpg"));
            stage.getIcons().add(applicationIcon);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("HSRM-FORM 1 GEOGRAPHY [Marks Entry]");
            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    public void clickForm1CreEntry(){
        try{
            Stage stageToClose = (Stage)menuBar.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/Exams/creEntry.fxml"));

            CreEntry creEntry = (CreEntry) loader.getController();

            Image applicationIcon = new Image(getClass().getResourceAsStream("/icon.jpg"));
            stage.getIcons().add(applicationIcon);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("HSRM-FORM 1 CRE [Marks Entry]");
            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    public void clickForm1BusinessEntry(){
        try{
            Stage stageToClose = (Stage)menuBar.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/Exams/busEntry.fxml"));

            BusEntry busEntry = (BusEntry) loader.getController();

            Image applicationIcon = new Image(getClass().getResourceAsStream("/icon.jpg"));
            stage.getIcons().add(applicationIcon);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("HSRM-FORM 1 BUSINESS [Marks Entry]");
            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    public void clickForm1AgricultureEntry(){
        try{
            Stage stageToClose = (Stage)menuBar.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/Exams/agriEntry.fxml"));

            AgriEntry agriEntry = (AgriEntry) loader.getController();

            Image applicationIcon = new Image(getClass().getResourceAsStream("/icon.jpg"));
            stage.getIcons().add(applicationIcon);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("HSRM-FORM 1 AGRICULTURE [Marks Entry]");
            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    public void clickForm2EnglishEntry(){
        try{
            Stage stageToClose = (Stage)menuBar.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F2/Exams/engEntry.fxml"));

            EngEntry engEntry = (EngEntry) loader.getController();

            Image applicationIcon = new Image(getClass().getResourceAsStream("/icon.jpg"));
            stage.getIcons().add(applicationIcon);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("HSRM-FORM 2 ENGLISH [Marks Entry]");
            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    public void clickForm2KiswahiliEntry(){
        try{
            Stage stageToClose = (Stage)menuBar.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F2/Exams/kisEntry.fxml"));

            KisEntry kisEntry = (KisEntry) loader.getController();

            Image applicationIcon = new Image(getClass().getResourceAsStream("/icon.jpg"));
            stage.getIcons().add(applicationIcon);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("HSRM-FORM 2 KISWAHILI [Marks Entry]");
            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    public void clickForm2MathsEntry(){
        try{
            Stage stageToClose = (Stage)menuBar.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F2/Exams/matEntry.fxml"));

            MatEntry matEntry = (MatEntry) loader.getController();

            Image applicationIcon = new Image(getClass().getResourceAsStream("/icon.jpg"));
            stage.getIcons().add(applicationIcon);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("HSRM-FORM 2 MATHEMATICS [Marks Entry]");
            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    public void clickForm2ChemistryEntry(){
        try{
            Stage stageToClose = (Stage)menuBar.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F2/Exams/chemEntry.fxml"));

            ChemEntry chemEntry = (ChemEntry) loader.getController();

            Image applicationIcon = new Image(getClass().getResourceAsStream("/icon.jpg"));
            stage.getIcons().add(applicationIcon);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("HSRM-FORM 2 CHEMISTRY [Marks Entry]");
            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    public void clickForm2BiologyEntry(){
        try{
            Stage stageToClose = (Stage)menuBar.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F2/Exams/bioEntry.fxml"));

            BioEntry bioEntry = (BioEntry) loader.getController();

            Image applicationIcon = new Image(getClass().getResourceAsStream("/icon.jpg"));
            stage.getIcons().add(applicationIcon);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("HSRM-FORM 2 BIOLOGY [Marks Entry]");
            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    public void clickForm2PhysicsEntry(){
        try{
            Stage stageToClose = (Stage)menuBar.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F2/Exams/phyEntry.fxml"));

            PhyEntry phyEntry = (PhyEntry) loader.getController();

            Image applicationIcon = new Image(getClass().getResourceAsStream("/icon.jpg"));
            stage.getIcons().add(applicationIcon);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("HSRM-FORM 2 PHYSICS [Marks Entry]");
            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    public void clickForm2HistoryEntry(){
        try{
            Stage stageToClose = (Stage)menuBar.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F2/Exams/hisEntry.fxml"));

            HisEntry hisEntry = (HisEntry) loader.getController();

            Image applicationIcon = new Image(getClass().getResourceAsStream("/icon.jpg"));
            stage.getIcons().add(applicationIcon);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("HSRM-FORM 2 HISTORY [Marks Entry]");
            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    public void clickForm2GeographyEntry(){
        try{
            Stage stageToClose = (Stage)menuBar.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F2/Exams/geoEntry.fxml"));

            GeoEntry geoEntry = (GeoEntry) loader.getController();

            Image applicationIcon = new Image(getClass().getResourceAsStream("/icon.jpg"));
            stage.getIcons().add(applicationIcon);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("HSRM-FORM 2 GEOGRAPHY [Marks Entry]");
            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    public void clickForm2CreEntry(){
        try{
            Stage stageToClose = (Stage)menuBar.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F2/Exams/creEntry.fxml"));

            CreEntry creEntry = (CreEntry) loader.getController();

            Image applicationIcon = new Image(getClass().getResourceAsStream("/icon.jpg"));
            stage.getIcons().add(applicationIcon);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("HSRM-FORM 2 CRE [Marks Entry]");
            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    public void clickForm2BusinessEntry(){
        try{
            Stage stageToClose = (Stage)menuBar.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F2/Exams/busEntry.fxml"));

            BusEntry busEntry = (BusEntry) loader.getController();

            Image applicationIcon = new Image(getClass().getResourceAsStream("/icon.jpg"));
            stage.getIcons().add(applicationIcon);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("HSRM-FORM 2 BUSINESS [Marks Entry]");
            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    public void clickForm2AgricultureEntry(){
        try{
            Stage stageToClose = (Stage)menuBar.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F2/Exams/agriEntry.fxml"));

            AgriEntry agriEntry = (AgriEntry) loader.getController();

            Image applicationIcon = new Image(getClass().getResourceAsStream("/icon.jpg"));
            stage.getIcons().add(applicationIcon);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("HSRM-FORM 2 AGRICULTURE [Marks Entry]");
            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    public void clickForm3EnglishEntry(){
        try{
            Stage stageToClose = (Stage)menuBar.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F3/Exams/engEntry.fxml"));

            EngEntry engEntry = (EngEntry) loader.getController();

            Image applicationIcon = new Image(getClass().getResourceAsStream("/icon.jpg"));
            stage.getIcons().add(applicationIcon);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("HSRM-FORM 3 ENGLISH [Marks Entry]");
            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    public void clickForm3KiswahiliEntry(){
        try{
            Stage stageToClose = (Stage)menuBar.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F3/Exams/kisEntry.fxml"));

            KisEntry kisEntry = (KisEntry) loader.getController();

            Image applicationIcon = new Image(getClass().getResourceAsStream("/icon.jpg"));
            stage.getIcons().add(applicationIcon);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("HSRM-FORM 3 KISWAHILI [Marks Entry]");
            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    public void clickForm3MathsEntry(){
        try{
            Stage stageToClose = (Stage)menuBar.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F3/Exams/matEntry.fxml"));

            MatEntry matEntry = (MatEntry) loader.getController();

            Image applicationIcon = new Image(getClass().getResourceAsStream("/icon.jpg"));
            stage.getIcons().add(applicationIcon);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("HSRM-FORM 3 MATHEMATICS [Marks Entry]");
            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    public void clickForm3ChemistryEntry(){
        try{
            Stage stageToClose = (Stage)menuBar.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F3/Exams/chemEntry.fxml"));

            ChemEntry chemEntry = (ChemEntry) loader.getController();

            Image applicationIcon = new Image(getClass().getResourceAsStream("/icon.jpg"));
            stage.getIcons().add(applicationIcon);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("HSRM-FORM 3 CHEMISTRY [Marks Entry]");
            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    public void clickForm3BiologyEntry(){
        try{
            Stage stageToClose = (Stage)menuBar.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F3/Exams/bioEntry.fxml"));

            BioEntry bioEntry = (BioEntry) loader.getController();

            Image applicationIcon = new Image(getClass().getResourceAsStream("/icon.jpg"));
            stage.getIcons().add(applicationIcon);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("HSRM-FORM 3 BIOLOGY [Marks Entry]");
            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    public void clickForm3PhysicsEntry(){
        try{
            Stage stageToClose = (Stage)menuBar.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F3/Exams/phyEntry.fxml"));

            PhyEntry phyEntry = (PhyEntry) loader.getController();

            Image applicationIcon = new Image(getClass().getResourceAsStream("/icon.jpg"));
            stage.getIcons().add(applicationIcon);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("HSRM-FORM 3 PHYSICS [Marks Entry]");
            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    public void clickForm3HistoryEntry(){
        try{
            Stage stageToClose = (Stage)menuBar.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F3/Exams/hisEntry.fxml"));

            HisEntry hisEntry = (HisEntry) loader.getController();

            Image applicationIcon = new Image(getClass().getResourceAsStream("/icon.jpg"));
            stage.getIcons().add(applicationIcon);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("HSRM-FORM 3 HISTORY [Marks Entry]");
            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    public void clickForm3GeographyEntry(){
        try{
            Stage stageToClose = (Stage)menuBar.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F3/Exams/geoEntry.fxml"));

            GeoEntry geoEntry = (GeoEntry) loader.getController();

            Image applicationIcon = new Image(getClass().getResourceAsStream("/icon.jpg"));
            stage.getIcons().add(applicationIcon);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("HSRM-FORM 3 GEOGRAPHY [Marks Entry]");
            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    public void clickForm3CreEntry(){
        try{
            Stage stageToClose = (Stage)menuBar.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F3/Exams/creEntry.fxml"));

            CreEntry creEntry = (CreEntry) loader.getController();

            Image applicationIcon = new Image(getClass().getResourceAsStream("/icon.jpg"));
            stage.getIcons().add(applicationIcon);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("HSRM-FORM 3 CRE [Marks Entry]");
            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    public void clickForm3BusinessEntry(){
        try{
            Stage stageToClose = (Stage)menuBar.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F3/Exams/busEntry.fxml"));

            BusEntry busEntry = (BusEntry) loader.getController();

            Image applicationIcon = new Image(getClass().getResourceAsStream("/icon.jpg"));
            stage.getIcons().add(applicationIcon);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("HSRM-FORM 3 BUSINESS [Marks Entry]");
            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    public void clickForm3AgricultureEntry(){
        try{
            Stage stageToClose = (Stage)menuBar.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F3/Exams/agriEntry.fxml"));

            AgriEntry agriEntry = (AgriEntry) loader.getController();

            Image applicationIcon = new Image(getClass().getResourceAsStream("/icon.jpg"));
            stage.getIcons().add(applicationIcon);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("HSRM-FORM 3 AGRICULTURE [Marks Entry]");
            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    public void clickForm4EnglishEntry(){
        try{
            Stage stageToClose = (Stage)menuBar.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F4/Exams/engEntry.fxml"));

            EngEntry engEntry = (EngEntry) loader.getController();

            Image applicationIcon = new Image(getClass().getResourceAsStream("/icon.jpg"));
            stage.getIcons().add(applicationIcon);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("HSRM-FORM 4 ENGLISH [Marks Entry]");
            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    public void clickForm4KiswahiliEntry(){
        try{
            Stage stageToClose = (Stage)menuBar.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F4/Exams/kisEntry.fxml"));

            KisEntry kisEntry = (KisEntry) loader.getController();

            Image applicationIcon = new Image(getClass().getResourceAsStream("/icon.jpg"));
            stage.getIcons().add(applicationIcon);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("HSRM-FORM 4 KISWAHILI [Marks Entry]");
            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    public void clickForm4MathsEntry(){
        try{
            Stage stageToClose = (Stage)menuBar.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F4/Exams/matEntry.fxml"));

            MatEntry matEntry = (MatEntry) loader.getController();

            Image applicationIcon = new Image(getClass().getResourceAsStream("/icon.jpg"));
            stage.getIcons().add(applicationIcon);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("HSRM-FORM 4 MATHEMATICS [Marks Entry]");
            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    public void clickForm4ChemistryEntry(){
        try{
            Stage stageToClose = (Stage)menuBar.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F4/Exams/chemEntry.fxml"));

            ChemEntry chemEntry = (ChemEntry) loader.getController();

            Image applicationIcon = new Image(getClass().getResourceAsStream("/icon.jpg"));
            stage.getIcons().add(applicationIcon);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("HSRM-FORM 4 CHEMISTRY [Marks Entry]");
            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    public void clickForm4BiologyEntry(){
        try{
            Stage stageToClose = (Stage)menuBar.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F4/Exams/bioEntry.fxml"));

            BioEntry bioEntry = (BioEntry) loader.getController();

            Image applicationIcon = new Image(getClass().getResourceAsStream("/icon.jpg"));
            stage.getIcons().add(applicationIcon);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("HSRM-FORM 4 BIOLOGY [Marks Entry]");
            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    public void clickForm4PhysicsEntry(){
        try{
            Stage stageToClose = (Stage)menuBar.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F4/Exams/phyEntry.fxml"));

            PhyEntry phyEntry = (PhyEntry) loader.getController();

            Image applicationIcon = new Image(getClass().getResourceAsStream("/icon.jpg"));
            stage.getIcons().add(applicationIcon);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("HSRM-FORM 4 PHYSICS [Marks Entry]");
            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    public void clickForm4HistoryEntry(){
        try{
            Stage stageToClose = (Stage)menuBar.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F4/Exams/hisEntry.fxml"));

            HisEntry hisEntry = (HisEntry) loader.getController();

            Image applicationIcon = new Image(getClass().getResourceAsStream("/icon.jpg"));
            stage.getIcons().add(applicationIcon);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("HSRM-FORM 4 HISTORY [Marks Entry]");
            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    public void clickForm4GeographyEntry(){
        try{
            Stage stageToClose = (Stage)menuBar.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F4/Exams/geoEntry.fxml"));

            GeoEntry geoEntry = (GeoEntry) loader.getController();

            Image applicationIcon = new Image(getClass().getResourceAsStream("/icon.jpg"));
            stage.getIcons().add(applicationIcon);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("HSRM-FORM 4 GEOGRAPHY [Marks Entry]");
            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    public void clickForm4CreEntry(){
        try{
            Stage stageToClose = (Stage)menuBar.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F4/Exams/creEntry.fxml"));

            CreEntry creEntry = (CreEntry) loader.getController();

            Image applicationIcon = new Image(getClass().getResourceAsStream("/icon.jpg"));
            stage.getIcons().add(applicationIcon);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("HSRM-FORM 4 CRE [Marks Entry]");
            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    public void clickForm4BusinessEntry(){
        try{
            Stage stageToClose = (Stage)menuBar.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F4/Exams/busEntry.fxml"));

            BusEntry busEntry = (BusEntry) loader.getController();

            Image applicationIcon = new Image(getClass().getResourceAsStream("/icon.jpg"));
            stage.getIcons().add(applicationIcon);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("HSRM-FORM 4 BUSINESS [Marks Entry]");
            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    public void clickForm4AgricultureEntry(){
        try{
            Stage stageToClose = (Stage)menuBar.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F4/Exams/agriEntry.fxml"));

            AgriEntry agriEntry = (AgriEntry) loader.getController();

            Image applicationIcon = new Image(getClass().getResourceAsStream("/icon.jpg"));
            stage.getIcons().add(applicationIcon);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("HSRM-FORM 4 AGRICULTURE [Marks Entry]");
            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    public void clickForm1Term1AvgResults(){
        try{
            Stage stageToClose = (Stage)menuBar.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/ClassLists/T1/classlistT1Avg.fxml"));

            ClasslistT1Avg classlistT1Avg = (ClasslistT1Avg) loader.getController();

            Image applicationIcon = new Image(getClass().getResourceAsStream("/icon.jpg"));
            stage.getIcons().add(applicationIcon);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("HSRM-FORM 1 TERM 1 AVERAGE [Exam Results]");
            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    public void clickForm1Term1Exam1Results(){
        try{
            Stage stageToClose = (Stage)menuBar.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/ClassLists/T1/classlistT1E1.fxml"));

            ClasslistT1E1 classlistT1E1 = (ClasslistT1E1) loader.getController();

            Image applicationIcon = new Image(getClass().getResourceAsStream("/icon.jpg"));
            stage.getIcons().add(applicationIcon);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("HSRM-FORM 1 TERM 1 EXAM 1 [Exam Results]");
            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    public void clickForm1Term1Exam2Results(){
        try{
            Stage stageToClose = (Stage)menuBar.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/ClassLists/T1/classlistT1E2.fxml"));

            ClasslistT1E2 classlistT1E2 = (ClasslistT1E2) loader.getController();

            Image applicationIcon = new Image(getClass().getResourceAsStream("/icon.jpg"));
            stage.getIcons().add(applicationIcon);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("HSRM-FORM 1 TERM 1 EXAM 2 [Exam Results]");
            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    public void clickForm1Term1Exam3Results(){
        try{
            Stage stageToClose = (Stage)menuBar.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/ClassLists/T1/classlistT1E3.fxml"));

            ClasslistT1E3 classlistT1E3 = (ClasslistT1E3) loader.getController();

            Image applicationIcon = new Image(getClass().getResourceAsStream("/icon.jpg"));
            stage.getIcons().add(applicationIcon);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("HSRM-FORM 1 TERM 1 EXAM 3 [Exam Results]");
            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    public void clickForm1Term2AvgResults(){
        try{
            Stage stageToClose = (Stage)menuBar.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/ClassLists/T2/classlistT2Avg.fxml"));

            ClasslistT2Avg classlistT2Avg = (ClasslistT2Avg) loader.getController();

            Image applicationIcon = new Image(getClass().getResourceAsStream("/icon.jpg"));
            stage.getIcons().add(applicationIcon);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("HSRM-FORM 1 TERM 2 AVERAGE [Exam Results]");
            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    public void clickForm1Term2Exam1Results(){
        try{
            Stage stageToClose = (Stage)menuBar.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/ClassLists/T2/classlistT2E1.fxml"));

            ClasslistT2E1 classlistT2E1 = (ClasslistT2E1) loader.getController();

            Image applicationIcon = new Image(getClass().getResourceAsStream("/icon.jpg"));
            stage.getIcons().add(applicationIcon);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("HSRM-FORM 1 TERM 2 EXAM 1 [Exam Results]");
            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    public void clickForm1Term2Exam2Results(){
        try{
            Stage stageToClose = (Stage)menuBar.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/ClassLists/T2/classlistT2E2.fxml"));

            ClasslistT2E2 classlistT2E2 = (ClasslistT2E2) loader.getController();

            Image applicationIcon = new Image(getClass().getResourceAsStream("/icon.jpg"));
            stage.getIcons().add(applicationIcon);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("HSRM-FORM 1 TERM 2 EXAM 2 [Exam Results]");
            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    public void clickForm1Term2Exam3Results(){
        try{
            Stage stageToClose = (Stage)menuBar.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/ClassLists/T2/classlistT2E3.fxml"));

            ClasslistT2E3 classlistT2E3 = (ClasslistT2E3) loader.getController();

            Image applicationIcon = new Image(getClass().getResourceAsStream("/icon.jpg"));
            stage.getIcons().add(applicationIcon);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("HSRM-FORM 1 TERM 2 EXAM 3 [Exam Results]");
            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    public void clickForm1Term3AvgResults(){
        try{
            Stage stageToClose = (Stage)menuBar.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/ClassLists/T3/classlistT3Avg.fxml"));

            ClasslistT3Avg classlistT3Avg = (ClasslistT3Avg) loader.getController();

            Image applicationIcon = new Image(getClass().getResourceAsStream("/icon.jpg"));
            stage.getIcons().add(applicationIcon);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("HSRM-FORM 1 TERM 3 AVERAGE [Exam Results]");
            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    public void clickForm1Term3Exam1Results(){
        try{
            Stage stageToClose = (Stage)menuBar.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/ClassLists/T3/classlistT3E1.fxml"));

            ClasslistT3E1 classlistT3E1 = (ClasslistT3E1) loader.getController();

            Image applicationIcon = new Image(getClass().getResourceAsStream("/icon.jpg"));
            stage.getIcons().add(applicationIcon);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("HSRM-FORM 1 TERM 3 EXAM 1 [Exam Results]");
            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    public void clickForm1Term3Exam2Results(){
        try{
            Stage stageToClose = (Stage)menuBar.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/ClassLists/T3/classlistT3E2.fxml"));

            ClasslistT3E2 classlistT3E2 = (ClasslistT3E2) loader.getController();

            Image applicationIcon = new Image(getClass().getResourceAsStream("/icon.jpg"));
            stage.getIcons().add(applicationIcon);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("HSRM-FORM 1 TERM 3 EXAM 2 [Exam Results]");
            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    public void clickForm1Term3Exam3Results(){
        try{
            Stage stageToClose = (Stage)menuBar.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/ClassLists/T3/classlistT3E3.fxml"));

            ClasslistT3E3 classlistT3E3 = (ClasslistT3E3) loader.getController();

            Image applicationIcon = new Image(getClass().getResourceAsStream("/icon.jpg"));
            stage.getIcons().add(applicationIcon);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("HSRM-FORM 1 TERM 3 EXAM 3 [Exam Results]");
            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    public void clickForm2Term1AvgResults(){
        try{
            Stage stageToClose = (Stage)menuBar.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F2/ClassLists/T1/classlistT1Avg.fxml"));

            ClasslistT1Avg classlistT1Avg = (ClasslistT1Avg) loader.getController();

            Image applicationIcon = new Image(getClass().getResourceAsStream("/icon.jpg"));
            stage.getIcons().add(applicationIcon);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("HSRM-FORM 2 TERM 1 AVERAGE [Exam Results]");
            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    public void clickForm2Term1Exam1Results(){
        try{
            Stage stageToClose = (Stage)menuBar.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F2/ClassLists/T1/classlistT1E1.fxml"));

            ClasslistT1E1 classlistT1E1 = (ClasslistT1E1) loader.getController();

            Image applicationIcon = new Image(getClass().getResourceAsStream("/icon.jpg"));
            stage.getIcons().add(applicationIcon);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("HSRM-FORM 2 TERM 1 EXAM 1 [Exam Results]");
            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    public void clickForm2Term1Exam2Results(){
        try{
            Stage stageToClose = (Stage)menuBar.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F2/ClassLists/T1/classlistT1E2.fxml"));

            ClasslistT1E2 classlistT1E2 = (ClasslistT1E2) loader.getController();

            Image applicationIcon = new Image(getClass().getResourceAsStream("/icon.jpg"));
            stage.getIcons().add(applicationIcon);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("HSRM-FORM 2 TERM 1 EXAM 2 [Exam Results]");
            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    public void clickForm2Term1Exam3Results(){
        try{
            Stage stageToClose = (Stage)menuBar.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F2/ClassLists/T1/classlistT1E3.fxml"));

            ClasslistT1E3 classlistT1E3 = (ClasslistT1E3) loader.getController();

            Image applicationIcon = new Image(getClass().getResourceAsStream("/icon.jpg"));
            stage.getIcons().add(applicationIcon);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("HSRM-FORM 2 TERM 1 EXAM 3 [Exam Results]");
            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    public void clickForm2Term2AvgResults(){
        try{
            Stage stageToClose = (Stage)menuBar.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F2/ClassLists/T2/classlistT2Avg.fxml"));

            ClasslistT2Avg classlistT2Avg = (ClasslistT2Avg) loader.getController();

            Image applicationIcon = new Image(getClass().getResourceAsStream("/icon.jpg"));
            stage.getIcons().add(applicationIcon);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("HSRM-FORM 2 TERM 2 AVERAGE [Exam Results]");
            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    public void clickForm2Term2Exam1Results(){
        try{
            Stage stageToClose = (Stage)menuBar.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F2/ClassLists/T2/classlistT2E1.fxml"));

            ClasslistT2E1 classlistT2E1 = (ClasslistT2E1) loader.getController();

            Image applicationIcon = new Image(getClass().getResourceAsStream("/icon.jpg"));
            stage.getIcons().add(applicationIcon);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("HSRM-FORM 2 TERM 2 EXAM 1 [Exam Results]");
            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    public void clickForm2Term2Exam2Results(){
        try{
            Stage stageToClose = (Stage)menuBar.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F2/ClassLists/T2/classlistT2E2.fxml"));

            ClasslistT2E2 classlistT2E2 = (ClasslistT2E2) loader.getController();

            Image applicationIcon = new Image(getClass().getResourceAsStream("/icon.jpg"));
            stage.getIcons().add(applicationIcon);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("HSRM-FORM 2 TERM 2 EXAM 2 [Exam Results]");
            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    public void clickForm2Term2Exam3Results(){
        try{
            Stage stageToClose = (Stage)menuBar.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F2/ClassLists/T2/classlistT2E3.fxml"));

            ClasslistT2E3 classlistT2E3 = (ClasslistT2E3) loader.getController();

            Image applicationIcon = new Image(getClass().getResourceAsStream("/icon.jpg"));
            stage.getIcons().add(applicationIcon);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("HSRM-FORM 2 TERM 2 EXAM 3 [Exam Results]");
            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    public void clickForm2Term3AvgResults(){
        try{
            Stage stageToClose = (Stage)menuBar.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F2/ClassLists/T3/classlistT3Avg.fxml"));

            ClasslistT3Avg classlistT3Avg = (ClasslistT3Avg) loader.getController();

            Image applicationIcon = new Image(getClass().getResourceAsStream("/icon.jpg"));
            stage.getIcons().add(applicationIcon);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("HSRM-FORM 2 TERM 3 AVERAGE [Exam Results]");
            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    public void clickForm2Term3Exam1Results(){
        try{
            Stage stageToClose = (Stage)menuBar.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F2/ClassLists/T3/classlistT3E1.fxml"));

            ClasslistT3E1 classlistT3E1 = (ClasslistT3E1) loader.getController();

            Image applicationIcon = new Image(getClass().getResourceAsStream("/icon.jpg"));
            stage.getIcons().add(applicationIcon);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("HSRM-FORM 2 TERM 3 EXAM 1 [Exam Results]");
            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    public void clickForm2Term3Exam2Results(){
        try{
            Stage stageToClose = (Stage)menuBar.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F2/ClassLists/T3/classlistT3E2.fxml"));

            ClasslistT3E2 classlistT3E2 = (ClasslistT3E2) loader.getController();

            Image applicationIcon = new Image(getClass().getResourceAsStream("/icon.jpg"));
            stage.getIcons().add(applicationIcon);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("HSRM-FORM 2 TERM 3 EXAM 2 [Exam Results]");
            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    public void clickForm2Term3Exam3Results(){
        try{
            Stage stageToClose = (Stage)menuBar.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F2/ClassLists/T3/classlistT3E3.fxml"));

            ClasslistT3E3 classlistT3E3 = (ClasslistT3E3) loader.getController();

            Image applicationIcon = new Image(getClass().getResourceAsStream("/icon.jpg"));
            stage.getIcons().add(applicationIcon);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("HSRM-FORM 2 TERM 3 EXAM 3 [Exam Results]");
            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    public void clickForm3Term1AvgResults(){
        try{
            Stage stageToClose = (Stage)menuBar.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F3/ClassLists/T1/classlistT1Avg.fxml"));

            ClasslistT1Avg classlistT1Avg = (ClasslistT1Avg) loader.getController();

            Image applicationIcon = new Image(getClass().getResourceAsStream("/icon.jpg"));
            stage.getIcons().add(applicationIcon);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("HSRM-FORM 3 TERM 1 AVERAGE [Exam Results]");
            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    public void clickForm3Term1Exam1Results(){
        try{
            Stage stageToClose = (Stage)menuBar.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F3/ClassLists/T1/classlistT1E1.fxml"));

            ClasslistT1E1 classlistT1E1 = (ClasslistT1E1) loader.getController();

            Image applicationIcon = new Image(getClass().getResourceAsStream("/icon.jpg"));
            stage.getIcons().add(applicationIcon);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("HSRM-FORM 3 TERM 1 EXAM 1 [Exam Results]");
            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    public void clickForm3Term1Exam2Results(){
        try{
            Stage stageToClose = (Stage)menuBar.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F3/ClassLists/T1/classlistT1E2.fxml"));

            ClasslistT1E2 classlistT1E2 = (ClasslistT1E2) loader.getController();

            Image applicationIcon = new Image(getClass().getResourceAsStream("/icon.jpg"));
            stage.getIcons().add(applicationIcon);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("HSRM-FORM 3 TERM 1 EXAM 2 [Exam Results]");
            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    public void clickForm3Term1Exam3Results(){
        try{
            Stage stageToClose = (Stage)menuBar.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F3/ClassLists/T1/classlistT1E3.fxml"));

            ClasslistT1E3 classlistT1E3 = (ClasslistT1E3) loader.getController();

            Image applicationIcon = new Image(getClass().getResourceAsStream("/icon.jpg"));
            stage.getIcons().add(applicationIcon);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("HSRM-FORM 3 TERM 1 EXAM 3 [Exam Results]");
            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    public void clickForm3Term2AvgResults(){
        try{
            Stage stageToClose = (Stage)menuBar.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F3/ClassLists/T2/classlistT2Avg.fxml"));

            ClasslistT2Avg classlistT2Avg = (ClasslistT2Avg) loader.getController();

            Image applicationIcon = new Image(getClass().getResourceAsStream("/icon.jpg"));
            stage.getIcons().add(applicationIcon);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("HSRM-FORM 3 TERM 2 AVERAGE [Exam Results]");
            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    public void clickForm3Term2Exam1Results(){
        try{
            Stage stageToClose = (Stage)menuBar.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F3/ClassLists/T2/classlistT2E1.fxml"));

            ClasslistT2E1 classlistT2E1 = (ClasslistT2E1) loader.getController();

            Image applicationIcon = new Image(getClass().getResourceAsStream("/icon.jpg"));
            stage.getIcons().add(applicationIcon);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("HSRM-FORM 3 TERM 2 EXAM 1 [Exam Results]");
            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    public void clickForm3Term2Exam2Results(){
        try{
            Stage stageToClose = (Stage)menuBar.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F3/ClassLists/T2/classlistT2E2.fxml"));

            ClasslistT2E2 classlistT2E2 = (ClasslistT2E2) loader.getController();

            Image applicationIcon = new Image(getClass().getResourceAsStream("/icon.jpg"));
            stage.getIcons().add(applicationIcon);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("HSRM-FORM 3 TERM 2 EXAM 2 [Exam Results]");
            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    public void clickForm3Term2Exam3Results(){
        try{
            Stage stageToClose = (Stage)menuBar.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F3/ClassLists/T2/classlistT2E3.fxml"));

            ClasslistT2E3 classlistT2E3 = (ClasslistT2E3) loader.getController();

            Image applicationIcon = new Image(getClass().getResourceAsStream("/icon.jpg"));
            stage.getIcons().add(applicationIcon);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("HSRM-FORM 3 TERM 2 EXAM 3 [Exam Results]");
            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    public void clickForm3Term3AvgResults(){
        try{
            Stage stageToClose = (Stage)menuBar.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F3/ClassLists/T3/classlistT3Avg.fxml"));

            ClasslistT3Avg classlistT3Avg = (ClasslistT3Avg) loader.getController();

            Image applicationIcon = new Image(getClass().getResourceAsStream("/icon.jpg"));
            stage.getIcons().add(applicationIcon);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("HSRM-FORM 3 TERM 3 AVERAGE [Exam Results]");
            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    public void clickForm3Term3Exam1Results(){
        try{
            Stage stageToClose = (Stage)menuBar.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F3/ClassLists/T3/classlistT3E1.fxml"));

            ClasslistT3E1 classlistT3E1 = (ClasslistT3E1) loader.getController();

            Image applicationIcon = new Image(getClass().getResourceAsStream("/icon.jpg"));
            stage.getIcons().add(applicationIcon);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("HSRM-FORM 3 TERM 3 EXAM 1 [Exam Results]");
            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    public void clickForm3Term3Exam2Results(){
        try{
            Stage stageToClose = (Stage)menuBar.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F3/ClassLists/T3/classlistT3E2.fxml"));

            ClasslistT3E2 classlistT3E2 = (ClasslistT3E2) loader.getController();

            Image applicationIcon = new Image(getClass().getResourceAsStream("/icon.jpg"));
            stage.getIcons().add(applicationIcon);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("HSRM-FORM 3 TERM 3 EXAM 2 [Exam Results]");
            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    public void clickForm3Term3Exam3Results(){
        try{
            Stage stageToClose = (Stage)menuBar.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F3/ClassLists/T3/classlistT3E3.fxml"));

            ClasslistT3E3 classlistT3E3 = (ClasslistT3E3) loader.getController();

            Image applicationIcon = new Image(getClass().getResourceAsStream("/icon.jpg"));
            stage.getIcons().add(applicationIcon);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("HSRM-FORM 3 TERM 3 EXAM 3 [Exam Results]");
            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    public void clickForm4Term1AvgResults(){
        try{
            Stage stageToClose = (Stage)menuBar.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F4/ClassLists/T1/classlistT1Avg.fxml"));

            ClasslistT1Avg classlistT1Avg = (ClasslistT1Avg) loader.getController();

            Image applicationIcon = new Image(getClass().getResourceAsStream("/icon.jpg"));
            stage.getIcons().add(applicationIcon);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("HSRM-FORM 4 TERM 1 AVERAGE [Exam Results]");
            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    public void clickForm4Term1Exam1Results(){
        try{
            Stage stageToClose = (Stage)menuBar.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F4/ClassLists/T1/classlistT1E1.fxml"));

            ClasslistT1E1 classlistT1E1 = (ClasslistT1E1) loader.getController();

            Image applicationIcon = new Image(getClass().getResourceAsStream("/icon.jpg"));
            stage.getIcons().add(applicationIcon);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("HSRM-FORM 4 TERM 1 EXAM 1 [Exam Results]");
            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    public void clickForm4Term1Exam2Results(){
        try{
            Stage stageToClose = (Stage)menuBar.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F4/ClassLists/T1/classlistT1E2.fxml"));

            ClasslistT1E2 classlistT1E2 = (ClasslistT1E2) loader.getController();

            Image applicationIcon = new Image(getClass().getResourceAsStream("/icon.jpg"));
            stage.getIcons().add(applicationIcon);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("HSRM-FORM 4 TERM 1 EXAM 2 [Exam Results]");
            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    public void clickForm4Term1Exam3Results(){
        try{
            Stage stageToClose = (Stage)menuBar.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F4/ClassLists/T1/classlistT1E3.fxml"));

            ClasslistT1E3 classlistT1E3 = (ClasslistT1E3) loader.getController();

            Image applicationIcon = new Image(getClass().getResourceAsStream("/icon.jpg"));
            stage.getIcons().add(applicationIcon);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("HSRM-FORM 4 TERM 1 EXAM 3 [Exam Results]");
            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    public void clickForm4Term2AvgResults(){
        try{
            Stage stageToClose = (Stage)menuBar.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F4/ClassLists/T2/classlistT2Avg.fxml"));

            ClasslistT2Avg classlistT2Avg = (ClasslistT2Avg) loader.getController();

            Image applicationIcon = new Image(getClass().getResourceAsStream("/icon.jpg"));
            stage.getIcons().add(applicationIcon);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("HSRM-FORM 4 TERM 2 AVERAGE [Exam Results]");
            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    public void clickForm4Term2Exam1Results(){
        try{
            Stage stageToClose = (Stage)menuBar.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F4/ClassLists/T2/classlistT2E1.fxml"));

            ClasslistT2E1 classlistT2E1 = (ClasslistT2E1) loader.getController();

            Image applicationIcon = new Image(getClass().getResourceAsStream("/icon.jpg"));
            stage.getIcons().add(applicationIcon);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("HSRM-FORM 4 TERM 2 EXAM 1 [Exam Results]");
            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    public void clickForm4Term2Exam2Results(){
        try{
            Stage stageToClose = (Stage)menuBar.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F4/ClassLists/T2/classlistT2E2.fxml"));

            ClasslistT2E2 classlistT2E2 = (ClasslistT2E2) loader.getController();

            Image applicationIcon = new Image(getClass().getResourceAsStream("/icon.jpg"));
            stage.getIcons().add(applicationIcon);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("HSRM-FORM 4 TERM 2 EXAM 2 [Exam Results]");
            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    public void clickForm4Term2Exam3Results(){
        try{
            Stage stageToClose = (Stage)menuBar.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F4/ClassLists/T2/classlistT2E3.fxml"));

            ClasslistT2E3 classlistT2E3 = (ClasslistT2E3) loader.getController();

            Image applicationIcon = new Image(getClass().getResourceAsStream("/icon.jpg"));
            stage.getIcons().add(applicationIcon);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("HSRM-FORM 4 TERM 2 EXAM 3 [Exam Results]");
            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    public void clickForm4Term3AvgResults(){
        try{
            Stage stageToClose = (Stage)menuBar.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F4/ClassLists/T3/classlistT3Avg.fxml"));

            ClasslistT3Avg classlistT3Avg = (ClasslistT3Avg) loader.getController();

            Image applicationIcon = new Image(getClass().getResourceAsStream("/icon.jpg"));
            stage.getIcons().add(applicationIcon);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("HSRM-FORM 4 TERM 3 AVERAGE [Exam Results]");
            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    public void clickForm4Term3Exam1Results(){
        try{
            Stage stageToClose = (Stage)menuBar.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F4/ClassLists/T3/classlistT3E1.fxml"));

            ClasslistT3E1 classlistT3E1 = (ClasslistT3E1) loader.getController();

            Image applicationIcon = new Image(getClass().getResourceAsStream("/icon.jpg"));
            stage.getIcons().add(applicationIcon);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("HSRM-FORM 4 TERM 3 EXAM 1 [Exam Results]");
            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    public void clickForm4Term3Exam2Results(){
        try{
            Stage stageToClose = (Stage)menuBar.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F4/ClassLists/T3/classlistT3E2.fxml"));

            ClasslistT3E2 classlistT3E2 = (ClasslistT3E2) loader.getController();

            Image applicationIcon = new Image(getClass().getResourceAsStream("/icon.jpg"));
            stage.getIcons().add(applicationIcon);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("HSRM-FORM 4 TERM 3 EXAM 2 [Exam Results]");
            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    public void clickForm4Term3Exam3Results(){

        try{
            Stage stageToClose = (Stage)menuBar.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F4/ClassLists/T3/classlistT3E3.fxml"));

            ClasslistT3E3 classlistT3E3 = (ClasslistT3E3) loader.getController();

            Image applicationIcon = new Image(getClass().getResourceAsStream("/icon.jpg"));
            stage.getIcons().add(applicationIcon);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("HSRM-FORM 4 TERM 3 EXAM 3 [Exam Results]");
            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    public void clickHelpAbout() throws Exception{
        try{
            Stage stageToClose = (Stage)menuBar.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/Admin/main.fxml"));

            Main main = (Main) loader.getController();

            Image applicationIcon = new Image(getClass().getResourceAsStream("/icon.jpg"));
            stage.getIcons().add(applicationIcon);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("About HSRM");
            stage.setMaximized(false);
            stage.setResizable(false);
            stage.show();
            stageToClose.toBack();
            stage.toFront();
            //stage.close();
        }catch (IOException e) {
            infoBoxError("An error occurred" + e, "ERROR", null);
        }
    }

    public void registered(){
        int regCode =22280007;
        if (String.valueOf(regCode).equals("22280007")){
            System.out.println("Your system is registered");
            infoBox("Your system is registred","Registration",null);
        }else{
            System.out.println("You system is not registered");
            infoBoxError("Your system is not registred","Registration",null);
            System.exit(1);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        registered();
    }
}
