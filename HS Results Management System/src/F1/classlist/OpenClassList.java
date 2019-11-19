package F1.classlist;

import F1.reports.PrintPassword;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class OpenClassList {
    public void open(String DBTableName,String CLSName){
        try{
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane) loader.load(getClass().getResource("../reports/printPassword.fxml"));

            PrintPassword printPassword = (PrintPassword) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Print Password");
            stage.setResizable(false);
            stage.show();

        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
