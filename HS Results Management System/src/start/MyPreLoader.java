package start;

import javafx.application.Preloader;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MyPreLoader extends Preloader {

    private Stage preloaderStage;
    private Scene scene;

    public MyPreLoader() {

    }

    @Override
    public void init() throws Exception {
        //super.init();
        Parent root1 = FXMLLoader.load(getClass().getResource("splashScreen.fxml"));
        scene = new Scene(root1);
    }

    @Override
    public void handleStateChangeNotification(Preloader.StateChangeNotification info) {
        // super.handleStateChangeNotification(info);
        StateChangeNotification.Type type = info.getType();
        switch (type) {

            case BEFORE_START:
                // Called after MyApplication#init and before MyApplication#start is called.
                System.out.println("BEFORE_START");
                preloaderStage.hide();
                break;
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.preloaderStage = primaryStage;

        // Set preloader scene and show stage.
        preloaderStage.setScene(scene);
        preloaderStage.initStyle(StageStyle.UNDECORATED);
        Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
        preloaderStage.getIcons().add(applicationIcon);
        preloaderStage.show();

    }
}

