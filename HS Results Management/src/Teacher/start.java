package Teacher;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class start extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("teacher.fxml"));
        primaryStage.setTitle("Teachers");
        primaryStage.setScene(new Scene(root, 1366, 700));
        primaryStage.show();
    }
}
