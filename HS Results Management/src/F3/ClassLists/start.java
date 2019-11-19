package F3.ClassLists;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class start extends Application {
    @Override
   public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("classListSelection.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 400, 300));
        primaryStage.show();
    }

   /* public static void main(String[] args) {
        try {
           ProcessBuilder pb = new ProcessBuilder("java", "-jar", "C:\\Users\\NG'ANG'A VICTOR\\Desktop\\school results management system\\tt\\HSResultsManagement.jar");
            Process p = pb.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
}
