package Users;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class start extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        //primaryStage.setTitle("Hello World");
       // primaryStage.setScene(new Scene(root, 300, 275));
       // primaryStage.show();

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        // Image applicationIcon = new Image(getClass().getResourceAsStream("icon.png"));
        // stage.getIcons().add(applicationIcon);
        primaryStage.setTitle("SRMS login");
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
