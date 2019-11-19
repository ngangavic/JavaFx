package F1.ReportForms.T2;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;

import static Alerts.informationBox.infoBoxError;

public class PrintPass {
    @FXML
    private PasswordField printPass;
    public static int allSubjects;
    public static int bioCreAgri;
    public static int bioCreBus;
    public static int bioGeoAgri;
    public static int bioGeoBus;
    public static int bioHisAgri;
    public static int bioHisBus;
    public static int phyCreAgri;
    public static int phyCreBus;
    public static int phyGeoAgri;
    public static int phyGeoBus;
    public static int phyHisAgri;
    public static int phyHisBus;

    public static int ex1;
    public static int ex2;
    public static int ex3;
    public static int avg;
    private void clearVar(){
        PrintPass.allSubjects=0;
        PrintPass.bioCreAgri=0;
        PrintPass.bioCreBus=0;
        PrintPass.bioGeoAgri=0;
        PrintPass.bioGeoBus=0;
        PrintPass.bioHisAgri=0;
        PrintPass.bioHisBus=0;
        PrintPass.phyCreAgri=0;
        PrintPass.phyCreBus=0;
        PrintPass.phyGeoAgri=0;
        PrintPass.phyGeoBus=0;
        PrintPass.phyHisAgri=0;
        PrintPass.phyHisBus=0;
    }

    public void checkPassword(){

        //printPass.getText();
        // ClasslistT1Avg.printPassword=printPass.getText().toString();
        if (allSubjects==1) {
            AllSubjects.printPassword=printPass.getText().toString();
            AllSubjects allSubjects = new AllSubjects();
            if(ex1==1) {
                clearVar();
                allSubjects.printExam1();
            }else if (ex2==1){
                clearVar();
                allSubjects.printExam2();
            }else if (ex3==1){
                clearVar();
                allSubjects.printExam3();
            }else {
                clearVar();
                allSubjects.printExamAvg();
            }
        }else if (bioCreAgri==1){
            BioCreAgri.printPassword=printPass.getText().toString();
            BioCreAgri bioCreAgri = new BioCreAgri();
            if(ex1==1) {
                clearVar();
                bioCreAgri.printExam1();
            }else if (ex2==1){
                clearVar();
                bioCreAgri.printExam2();
            }else if (ex3==1){
                clearVar();
                bioCreAgri.printExam3();
            }else {
                clearVar();
                bioCreAgri.printExamAvg();
            }
        }else if (bioCreBus==1){
            BioCreBus.printPassword=printPass.getText().toString();
            BioCreBus bioCreBus = new BioCreBus();
            if(ex1==1) {
                clearVar();
                bioCreBus.printExam1();
            }else if (ex2==1){
                clearVar();
                bioCreBus.printExam2();
            }else if (ex3==1){
                clearVar();
                bioCreBus.printExam3();
            }else {
                clearVar();
                bioCreBus.printExamAvg();
            }
        }else if (bioGeoAgri==1){
            BioGeoAgri.printPassword=printPass.getText().toString();
            BioGeoAgri bioGeoAgri = new BioGeoAgri();
            if(ex1==1) {
                clearVar();
                bioGeoAgri.printExam1();
            }else if (ex2==1){
                clearVar();
                bioGeoAgri.printExam2();
            }else if (ex3==1){
                clearVar();
                bioGeoAgri.printExam3();
            }else {
                clearVar();
                bioGeoAgri.printExamAvg();
            }
        }else if (bioGeoBus==1){
            BioGeoBus.printPassword=printPass.getText().toString();
            BioGeoBus bioGeoBus = new BioGeoBus();
            if(ex1==1) {
                clearVar();
                bioGeoBus.printExam1();
            }else if (ex2==1){
                clearVar();
                bioGeoBus.printExam2();
            }else if (ex3==1){
                clearVar();
                bioGeoBus.printExam3();
            }else {
                clearVar();
                bioGeoBus.printExamAvg();
            }

        }else if (bioHisAgri==1){
            BioHisAgri.printPassword=printPass.getText().toString();
            BioHisAgri bioHisAgri = new BioHisAgri();
            if(ex1==1) {
                clearVar();
                bioHisAgri.printExam1();
            }else if (ex2==1){
                clearVar();
                bioHisAgri.printExam2();
            }else if (ex3==1){
                clearVar();
                bioHisAgri.printExam3();
            }else {
                clearVar();
                bioHisAgri.printExamAvg();
            }

        }else if (bioHisBus==1){
            BioHisBus.printPassword=printPass.getText().toString();
            BioHisBus bioHisBus = new BioHisBus();
            if(ex1==1) {
                clearVar();
                bioHisBus.printExam1();
            }else if (ex2==1){
                clearVar();
                bioHisBus.printExam2();
            }else if (ex3==1){
                clearVar();
                bioHisBus.printExam3();
            }else {
                clearVar();
                bioHisBus.printExamAvg();
            }

        }else if (phyCreAgri==1){
            PhyCreAgri.printPassword=printPass.getText().toString();
            PhyCreAgri phyCreAgri = new PhyCreAgri();
            if(ex1==1) {
                clearVar();
                phyCreAgri.printExam1();
            }else if (ex2==1){
                clearVar();
                phyCreAgri.printExam2();
            }else if (ex3==1){
                clearVar();
                phyCreAgri.printExam3();
            }else {
                clearVar();
                phyCreAgri.printExamAvg();
            }

        }else if (phyCreBus==1){
            PhyCreBus.printPassword=printPass.getText().toString();
            PhyCreBus phyCreBus = new PhyCreBus();
            if(ex1==1) {
                clearVar();
                phyCreBus.printExam1();
            }else if (ex2==1){
                clearVar();
                phyCreBus.printExam2();
            }else if (ex3==1){
                clearVar();
                phyCreBus.printExam3();
            }else {
                clearVar();
                phyCreBus.printExamAvg();
            }

        }else if (phyGeoAgri==1){
            PhyGeoAgri.printPassword=printPass.getText().toString();
            PhyGeoAgri phyGeoAgri = new PhyGeoAgri();
            if(ex1==1) {
                clearVar();
                phyGeoAgri.printExam1();
            }else if (ex2==1){
                clearVar();
                phyGeoAgri.printExam2();
            }else if (ex3==1){
                clearVar();
                phyGeoAgri.printExam3();
            }else {
                clearVar();
                phyGeoAgri.printExamAvg();
            }

        }else if (phyGeoBus==1){
            PhyGeoBus.printPassword=printPass.getText().toString();
            PhyGeoBus phyGeoBus = new PhyGeoBus();
            if(ex1==1) {
                clearVar();
                phyGeoBus.printExam1();
            }else if (ex2==1){
                clearVar();
                phyGeoBus.printExam2();
            }else if (ex3==1){
                clearVar();
                phyGeoBus.printExam3();
            }else {
                clearVar();
                phyGeoBus.printExamAvg();
            }

        }else if (phyHisAgri==1){
            PhyHisAgri.printPassword=printPass.getText().toString();
            PhyHisAgri phyHisAgri = new PhyHisAgri();
            if(ex1==1) {
                clearVar();
                phyHisAgri.printExam1();
            }else if (ex2==1){
                clearVar();
                phyHisAgri.printExam2();
            }else if (ex3==1){
                clearVar();
                phyHisAgri.printExam3();
            }else {
                clearVar();
                phyHisAgri.printExamAvg();
            }

        }else if (phyHisBus==1){
            PhyHisBus.printPassword=printPass.getText().toString();
            PhyHisBus phyHisBus = new PhyHisBus();
            if(ex1==1) {
                clearVar();
                phyHisBus.printExam1();
            }else if (ex2==1){
                clearVar();
                phyHisBus.printExam2();
            }else if (ex3==1){
                clearVar();
                phyHisBus.printExam3();
            }else {
                clearVar();
                phyHisBus.printExamAvg();
            }

        }else{
            infoBoxError("An error occurred. Please try again.","Error",null);
        }
    }
}
