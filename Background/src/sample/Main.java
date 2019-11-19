package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application implements Runnable {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
        run();
    }


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void run() {
        System.out.println("Doing heavy processes");
        try{
            Thread.sleep(2000);
            ///do a database process
            doDBProcess();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Done with doing the heavy process");
    }

    private void doDBProcess() throws InterruptedException {
        Thread.sleep(5000);
    }

}
