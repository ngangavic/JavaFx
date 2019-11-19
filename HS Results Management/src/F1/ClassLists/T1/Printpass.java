package F1.ClassLists.T1;


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
    public static int printT1Avg;
    public static int printT1E1;
    public static int printT1E2;
    public static int printT1E3;

    private void clearVar(){
        Printpass.avg=0;
        Printpass.ex1=0;
        Printpass.ex2=0;
        Printpass.ex3=0;
        Printpass.printT1Avg=0;
        Printpass.printT1E1=0;
        Printpass.printT1E2=0;
        Printpass.printT1E3=0;
    }

    public void checkPassword(){
        if (avg==1) {
            ClasslistT1Avg.printPassword=printPass.getText().toString();
            ClasslistT1Avg classlistT1Avg = new ClasslistT1Avg();
            clearVar();
            classlistT1Avg.printClassResults();
        }else if (ex1==1){
            ClasslistT1E1.printPassword=printPass.getText().toString();
            ClasslistT1E1 classlistT1E1 = new ClasslistT1E1();
            clearVar();
            classlistT1E1.printClassResults();
        }else if (ex2==1){
            ClasslistT1E2.printPassword=printPass.getText().toString();
            ClasslistT1E2 classlistT1E2 = new ClasslistT1E2();
            clearVar();
            classlistT1E2.printClassResults();
        }else if (ex3==1){
            ClasslistT1E3.printPassword=printPass.getText().toString();
            ClasslistT1E3 classlistT1E3 = new ClasslistT1E3();
            clearVar();
            classlistT1E3.printClassResults();

        }else if (printT1Avg==1){
            ClasslistT1Avg.printPassword=printPass.getText().toString();
            ClasslistT1Avg classlistT1Avg = new ClasslistT1Avg();
            clearVar();
            classlistT1Avg.printAllResults();
        }else if (printT1E1==1){
            ClasslistT1E1.printPassword=printPass.getText().toString();
            ClasslistT1E1 classlistT1E1 = new ClasslistT1E1();
            clearVar();
            classlistT1E1.printAllResults();
        }else if (printT1E2==1){
            ClasslistT1E2.printPassword=printPass.getText().toString();
            ClasslistT1E2 classlistT1E2 = new ClasslistT1E2();
            clearVar();
            classlistT1E2.printAllResults();
        }else if (printT1E3==1){
            ClasslistT1E3.printPassword=printPass.getText().toString();
            ClasslistT1E3 classlistT1E3 = new ClasslistT1E3();
            clearVar();
            classlistT1E3.printAllResults();
        }else{
            infoBoxError("An error occurred. Please try again.","Error",null);
        }
    }
}
