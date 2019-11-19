package start;

import Database.CheckConnection;
import Database.DBConnection;
import backup.AutoBackup;
import com.sun.javafx.application.LauncherImpl;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("/F1/classlist/showClasslist2.fxml"));
        Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
        stage.getIcons().add(applicationIcon);
        stage.setTitle("WELCOME");
        stage.setScene(new Scene(root));
        stage.setResizable(true);
        stage.setMaximized(true);
        stage.show();
    }

    @Override
    public void init() throws Exception {
        ServerStart serverStart = new ServerStart();
        serverStart.StartServer();
        Installation installation = new Installation();
        installation.makeDirectories();
        ConfigureApplication configureApplication = new ConfigureApplication();
        configureApplication.CheckGrading();
        configureApplication.CheckComments();
        configureApplication.CheckTeachers();
        AutoBackup autoBackup = new AutoBackup();
        autoBackup.Backup();
        DatabaseSync databaseSync = new DatabaseSync();

        databaseSync.addStudent();
        databaseSync.updateStudent();
    }

    public static void main(String[] args) {
        // launch(args);
        LauncherImpl.launchApplication(Main.class, MyPreLoader.class, args);
    }
}

