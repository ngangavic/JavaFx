package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.WindowEvent;

public class Main extends Application {

    TabPane root;

    @Override
    public void start(Stage stage) throws IOException {
        Parent browser = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Tab browserTab = new Tab("New Tab", browser);
        Tab addTab = new Tab("+", null);
        addTab.setClosable(false);
        addTab.setOnSelectionChanged(new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
                addNewTab();
            }
        });
        root = new TabPane(browserTab, addTab);
        Scene scene = new Scene(root);
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent t) {
                Platform.exit();
                System.exit(0);
            }
        });
        stage.setScene(scene);
        Image applicationIcon = new Image(getClass().getResourceAsStream("icon.png"));
        stage.getIcons().add(applicationIcon);
        stage.setTitle("My Browser");
        stage.setIconified(true);
        stage.show();

    }

    final void addNewTab() {
        try {
            Parent browser = FXMLLoader.load(getClass().getResource("sample.fxml"));
            Tab browserTab = new Tab("New Tab", browser);
            root.getTabs().add(root.getTabs().size() - 1, browserTab);
            root.getSelectionModel().select(browserTab);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
