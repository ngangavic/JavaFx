package search;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class Search {
    @FXML
    private TextField searchAdm;
    @FXML void closeSearchBox(){
        try{
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("search.fxml"));
            Search search = (Search) loader.getController();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setResizable(true);
            stage.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
