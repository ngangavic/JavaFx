package F1.reports;

import com.itextpdf.text.DocumentException;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

import java.io.IOException;

public class PrintPassword {
    //public static String password;
    @FXML
    private PasswordField tfPassword;

    public void checkPass(){
        if (tfPassword.getText().toString().equals("vic")){
            ClassReport classReport = new ClassReport();
            try {
                classReport.printClassResults(tfPassword.getText().toString());
                //classReport.printClassResults();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (DocumentException e) {
                e.printStackTrace();
            }
        }else {
            System.out.print("You entered the wrong password");
        }
    }
    @FXML
    void check(){
        if (tfPassword.getText().toString().equals("Vic")){

        }else{

        }
    }

    public void cancel(){
        Stage stageToClose = (Stage)tfPassword.getScene().getWindow();
        stageToClose.close();

    }
}
