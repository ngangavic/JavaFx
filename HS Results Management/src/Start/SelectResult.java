package Start;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

import static Alerts.informationBox.infoBoxError;

public class SelectResult {

    public void clickForm1(){
        try{
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/ClassLists/classListSelection.fxml"));

            F1.ClassLists.ClassListSelection classListSelection = (F1.ClassLists.ClassListSelection) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 1 Results");
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
            Pane root = (Pane)loader.load(getClass().getResourceAsStream("/F2/ClassLists/classListSelection.fxml"));

            F2.ClassLists.ClassListSelection classListSelection = (F2.ClassLists.ClassListSelection) loader.getController();


            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 2 Results");
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
            Pane root = (Pane)loader.load(getClass().getResourceAsStream("/F3/ClassLists/classListSelection.fxml"));

            //EntrySelection entrySelection = (EntrySelection) loader.getController();
            F3.ClassLists.ClassListSelection classListSelection = (F3.ClassLists.ClassListSelection)loader.getController();


            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 3 Results");
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
            Pane root = (Pane)loader.load(getClass().getResourceAsStream("/F4/ClassLists/classListSelection.fxml"));

            //EntrySelection entrySelection = (EntrySelection) loader.getController();
            F4.ClassLists.ClassListSelection classListSelection = (F4.ClassLists.ClassListSelection)loader.getController();


            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 4 Results");
            stage.setResizable(true);
            stage.show();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }
}
