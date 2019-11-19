package F3.ClassLists.T3;


import F3.ClassLists.T3.ClasslistT3Avg;
import F3.ClassLists.T3.ClasslistT3E1;
import F3.ClassLists.T3.ClasslistT3E2;
import F3.ClassLists.T3.ClasslistT3E3;
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
    public static int printT3Avg;
    public static int printT3E1;
    public static int printT3E2;
    public static int printT3E3;

    private void clearVar(){
        Printpass.avg=0;
        Printpass.ex1=0;
        Printpass.ex2=0;
        Printpass.ex3=0;
        Printpass.printT3Avg=0;
        Printpass.printT3E1=0;
        Printpass.printT3E2=0;
        Printpass.printT3E3=0;
    }

    public void checkPassword(){
        if (avg==1) {
            ClasslistT3Avg.printPassword=printPass.getText().toString();
            //ClasslistT3Avg classlistT3Avg = new ClasslistT3Avg();
            ClasslistT3Avg classlistT3Avg1 = new ClasslistT3Avg();
            clearVar();
            classlistT3Avg1.printClassResults();
        }else if (ex1==1){
            ClasslistT3E1.printPassword=printPass.getText().toString();
            ClasslistT3E1 classlistT3E1 = new ClasslistT3E1();
            clearVar();
            classlistT3E1.printClassResults();
        }else if (ex2==1){
            ClasslistT3E2.printPassword=printPass.getText().toString();
            ClasslistT3E2 classlistT3E2 = new ClasslistT3E2();
            clearVar();
            classlistT3E2.printClassResults();
        }else if (ex3==1){
            ClasslistT3E3.printPassword=printPass.getText().toString();
            ClasslistT3E3 classlistT3E3 = new ClasslistT3E3();
            clearVar();
            classlistT3E3.printClassResults();

        }else if (printT3Avg==1){
            ClasslistT3Avg.printPassword=printPass.getText().toString();
            ClasslistT3Avg classlistT3Avg = new ClasslistT3Avg();
            clearVar();
            classlistT3Avg.printAllResults();
        }else if (printT3E1==1){
            ClasslistT3E1.printPassword=printPass.getText().toString();
            ClasslistT3E1 classlistT3E1 = new ClasslistT3E1();
            clearVar();
            classlistT3E1.printAllResults();
        }else if (printT3E2==1){
            ClasslistT3E2.printPassword=printPass.getText().toString();
            ClasslistT3E2 classlistT3E2 = new ClasslistT3E2();
            clearVar();
            classlistT3E2.printAllResults();
        }else if (printT3E3==1){
            ClasslistT3E3.printPassword=printPass.getText().toString();
            ClasslistT3E3 classlistT3E3 = new ClasslistT3E3();
            clearVar();
            classlistT3E3.printAllResults();
        }else{
            infoBoxError("An error occurred. Please try again.","Error",null);
        }
    }
}
