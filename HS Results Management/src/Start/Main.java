package Start;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("graphs.fxml"));
        Image applicationIcon = new Image(getClass().getResourceAsStream("/icon.jpg"));
        primaryStage.getIcons().add(applicationIcon);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("HSRM");
        //primaryStage.setFullScreen(true);
        primaryStage.setMaximized(true);
        primaryStage.setResizable(true);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
