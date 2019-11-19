package sample;

import com.sun.javafx.application.LauncherImpl;
import javafx.application.Application;
import javafx.application.Preloader;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    private static final int COUNT_LIMIT = 500000;

    @Override
    public void start(Stage stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
       // primaryStage.setTitle("Hello World");
        stage.setScene(new Scene(root, 300, 275));
        stage.show();
    }


    @Override
    public void init() throws Exception {
        for (int i = 0; i < COUNT_LIMIT; i++) {
            double progress =(100 * i) /COUNT_LIMIT;
            //System.out.println("progress: " +  progress);
            LauncherImpl.notifyPreloader(this, new Preloader.ProgressNotification(progress));
           // Thread.sleep(2000);
        }
    }

    public static void main(String[] args) {
       // launch(args);
        LauncherImpl.launchApplication(Main.class, MyPreLoader.class, args);
    }
}
