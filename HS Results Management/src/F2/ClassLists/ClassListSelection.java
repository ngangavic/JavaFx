package F2.ClassLists;

import F2.ClassLists.T1.ClasslistT1Avg;
import F2.ClassLists.T1.ClasslistT1E1;
import F2.ClassLists.T1.ClasslistT1E2;
import F2.ClassLists.T1.ClasslistT1E3;
import F2.ClassLists.T2.ClasslistT2Avg;
import F2.ClassLists.T2.ClasslistT2E1;
import F2.ClassLists.T2.ClasslistT2E2;
import F2.ClassLists.T2.ClasslistT2E3;
import F2.ClassLists.T3.ClasslistT3Avg;
import F2.ClassLists.T3.ClasslistT3E1;
import F2.ClassLists.T3.ClasslistT3E2;
import F2.ClassLists.T3.ClasslistT3E3;
import F2.ClassLists.exam;
import F2.ClassLists.term;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static Alerts.informationBox.infoBoxError;

public class ClassListSelection implements Initializable {
    @FXML
    private ComboBox<F2.ClassLists.term> cbTerm;
    @FXML
    private ComboBox<F2.ClassLists.exam> cbExam;

    @FXML
    private void selection(){
        if (cbTerm.getValue().toString().equals("TERM1")&&cbExam.getValue().toString().equals("EXAM1")){
            T1E1();
        }else if (cbTerm.getValue().toString().equals("TERM1")&&cbExam.getValue().toString().equals("EXAM2")){
            T1E2();
        }else if (cbTerm.getValue().toString().equals("TERM1")&&cbExam.getValue().toString().equals("EXAM3")){
            T1E3();
        }else if (cbTerm.getValue().toString().equals("TERM1")&&cbExam.getValue().toString().equals("AVG")){
            T1AVG();
        }else if (cbTerm.getValue().toString().equals("TERM2")&&cbExam.getValue().toString().equals("EXAM1")){
            T2E1();
        }else if (cbTerm.getValue().toString().equals("TERM2")&&cbExam.getValue().toString().equals("EXAM2")){
            T2E2();
        }else if (cbTerm.getValue().toString().equals("TERM2")&&cbExam.getValue().toString().equals("EXAM3")){
            T2E3();
        }else if (cbTerm.getValue().toString().equals("TERM2")&&cbExam.getValue().toString().equals("AVG")){
            T2AVG();
        }else if (cbTerm.getValue().toString().equals("TERM3")&&cbExam.getValue().toString().equals("EXAM1")){
            T3E1();
        }else if (cbTerm.getValue().toString().equals("TERM3")&&cbExam.getValue().toString().equals("EXAM2")){
            T3E2();
        }else if (cbTerm.getValue().toString().equals("TERM3")&&cbExam.getValue().toString().equals("EXAM3")){
            T3E3();
        }else if (cbTerm.getValue().toString().equals("TERM3")&&cbExam.getValue().toString().equals("AVG")){
            T3AVG();
        }
    }

    private void T1E1(){
        try{
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("T1/classlistT1E1.fxml"));

            ClasslistT1E1 classlistT1E1 = (ClasslistT1E1) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 2 TERM 1 EXAM 1");
            stage.setResizable(true);
            stage.show();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    private void T1E2(){
        try{
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("T1/classlistT1E2.fxml"));

            ClasslistT1E2 classlistT1E2 = (ClasslistT1E2) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 2 TERM 1 EXAM 2");
            stage.setResizable(true);
            stage.show();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    private void T1E3(){
        try{
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("T1/classlistT1E3.fxml"));

            ClasslistT1E3 classlistT1E3 = (ClasslistT1E3) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 2 TERM 1 EXAM 3");
            stage.setResizable(true);
            stage.show();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    private void T1AVG(){
        try{
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("T1/classlistT1Avg.fxml"));

            ClasslistT1Avg classlistT1Avg = (ClasslistT1Avg) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 2 TERM 1 AVG");
            stage.setResizable(true);
            stage.show();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }


    private void T2E1(){
        try{
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("T2/classlistT2E1.fxml"));

            ClasslistT2E1 classlistT2E1 = (ClasslistT2E1) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 2 TERM 2 EXAM 1");
            stage.setResizable(true);
            stage.show();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    private void T2E2(){
        try{
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("T2/classlistT2E2.fxml"));

            ClasslistT2E2 classlistT2E2 = (ClasslistT2E2) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 2 TERM 2 EXAM 2");
            stage.setResizable(true);
            stage.show();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    private void T2E3(){
        try{
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("T2/classlistT2E3.fxml"));

            ClasslistT2E3 classlistT2E3 = (ClasslistT2E3) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 2 TERM 2 EXAM 3");
            stage.setResizable(true);
            stage.show();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    private void T2AVG(){
        try{
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("T2/classlistT2Avg.fxml"));

            ClasslistT2Avg classlistT2Avg = (ClasslistT2Avg) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 2 TERM 2 AVG");
            stage.setResizable(true);
            stage.show();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }


    private void T3E1(){
        try{
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("T3/classlistT3E1.fxml"));

            ClasslistT3E1 classlistT3E1 = (ClasslistT3E1) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 2 TERM 3 EXAM 1");
            stage.setResizable(true);
            stage.show();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    private void T3E2(){
        try{
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("T3/classlistT3E2.fxml"));

            ClasslistT3E2 classlistT3E2 = (ClasslistT3E2) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 2 TERM 3 EXAM 2");
            stage.setResizable(true);
            stage.show();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    private void T3E3(){
        try{
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("T3/classlistT3E3.fxml"));

            ClasslistT3E3 classlistT3E3 = (ClasslistT3E3) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 2 TERM 3 EXAM 3");
            stage.setResizable(true);
            stage.show();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    private void T3AVG(){
        try{
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("T3/classlistT3Avg.fxml"));

            ClasslistT3Avg classlistT3Avg = (ClasslistT3Avg) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 2 TERM 3 AVG");
            stage.setResizable(true);
            stage.show();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.cbTerm.setItems(FXCollections.observableArrayList(term.values()));
        this.cbExam.setItems(FXCollections.observableArrayList(exam.values()));
    }
}
