package about;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

public class About{

    @FXML
    private AnchorPane aboutWindow;
    @FXML
    private ImageView applicationIcon;

    public void closeAbout(){
        try{
            Stage stageToClose = (Stage)aboutWindow.getScene().getWindow();
            stageToClose.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
