package Start;

//import F1.Exams.EntrySelection;
import F2.Exams.EntrySelection;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

import static Alerts.informationBox.infoBoxError;

public class SelectClass {


    public void clickForm1(){
        try{
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/Exams/entrySelection.fxml"));

            F1.Exams.EntrySelection entrySelection = (F1.Exams.EntrySelection) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 1 Marks Entry");
            stage.setResizable(true);
            stage.show();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    public void clickForm2(){
            try{
                Stage stage = new Stage();
                FXMLLoader loader = new FXMLLoader();
                Pane root = (Pane)loader.load(getClass().getResourceAsStream("/F2/Exams/entrySelection.fxml"));

                F2.Exams.EntrySelection entrySelection = (F2.Exams.EntrySelection) loader.getController();


                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.setTitle("FORM 2 Marks Entry");
                stage.setResizable(true);
                stage.show();
            }catch (IOException e){
                infoBoxError("An error occurred" + e ,"ERROR",null);
            }
    }

    public void clickForm3(){
        try{
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResourceAsStream("/F3/Exams/entrySelection.fxml"));

            //EntrySelection entrySelection = (EntrySelection) loader.getController();
            F3.Exams.EntrySelection entrySelection = (F3.Exams.EntrySelection)loader.getController();


            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 3 Marks Entry");
            stage.setResizable(true);
            stage.show();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    public void clickForm4(){
        try{
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResourceAsStream("/F4/Exams/entrySelection.fxml"));

            //EntrySelection entrySelection = (EntrySelection) loader.getController();
            F4.Exams.EntrySelection entrySelection = (F4.Exams.EntrySelection)loader.getController();


            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 4 Marks Entry");
            stage.setResizable(true);
            stage.show();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }


}
