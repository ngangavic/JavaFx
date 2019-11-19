package F1.ClassLists.T2;


import F1.ClassLists.T2.ClasslistT2Avg;
import F1.ClassLists.T2.ClasslistT2E1;
import F1.ClassLists.T2.ClasslistT2E2;
import F1.ClassLists.T2.ClasslistT2E3;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;

import static Alerts.informationBox.infoBoxError;

public class Printpass {
    @FXML
    private PasswordField printPass;
    public static int avg;
    public static int ex1;
    public static int ex2;
    public static int ex3;
    public static int printT2Avg;
    public static int printT2E1;
    public static int printT2E2;
    public static int printT2E3;

    private void clearVar(){
        Printpass.avg=0;
        Printpass.ex1=0;
        Printpass.ex2=0;
        Printpass.ex3=0;
        Printpass.printT2Avg=0;
        Printpass.printT2E1=0;
        Printpass.printT2E2=0;
        Printpass.printT2E3=0;
    }

    public void checkPassword(){
        if (avg==1) {
            ClasslistT2Avg.printPassword=printPass.getText().toString();
            ClasslistT2Avg ClasslistT2Avg = new ClasslistT2Avg();
            clearVar();
            ClasslistT2Avg.printClassResults();
        }else if (ex1==1){
            ClasslistT2E1.printPassword=printPass.getText().toString();
            ClasslistT2E1 ClasslistT2E1 = new ClasslistT2E1();
            clearVar();
            ClasslistT2E1.printClassResults();
        }else if (ex2==1){
            ClasslistT2E2.printPassword=printPass.getText().toString();
            ClasslistT2E2 ClasslistT2E2 = new ClasslistT2E2();
            clearVar();
            ClasslistT2E2.printClassResults();
        }else if (ex3==1){
            ClasslistT2E3.printPassword=printPass.getText().toString();
            ClasslistT2E3 ClasslistT2E3 = new ClasslistT2E3();
            clearVar();
            ClasslistT2E3.printClassResults();

        }else if (printT2Avg==1){
            ClasslistT2Avg.printPassword=printPass.getText().toString();
            ClasslistT2Avg ClasslistT2Avg = new ClasslistT2Avg();
            clearVar();
            ClasslistT2Avg.printAllResults();
        }else if (printT2E1==1){
            ClasslistT2E1.printPassword=printPass.getText().toString();
            ClasslistT2E1 ClasslistT2E1 = new ClasslistT2E1();
            clearVar();
            ClasslistT2E1.printAllResults();
        }else if (printT2E2==1){
            ClasslistT2E2.printPassword=printPass.getText().toString();
            ClasslistT2E2 ClasslistT2E2 = new ClasslistT2E2();
            clearVar();
            ClasslistT2E2.printAllResults();
        }else if (printT2E3==1){
            ClasslistT2E3.printPassword=printPass.getText().toString();
            ClasslistT2E3 ClasslistT2E3 = new ClasslistT2E3();
            clearVar();
            ClasslistT2E3.printAllResults();
        }else{
            infoBoxError("An error occurred. Please try again.","Error",null);
        }
    }
}
