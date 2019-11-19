package F1.Exams;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static Alerts.informationBox.infoBoxError;

public class EntrySelection implements Initializable{
    @FXML
    private ComboBox<subjectOption> cbSubject;

    @FXML
    private void subClicked(){
        if (((subjectOption)this.cbSubject.getValue()).toString().equals("English")){
            eng();
        }else if (((subjectOption)this.cbSubject.getValue()).toString().equals("Kiswahili")){
            kis();
        }else if (((subjectOption)this.cbSubject.getValue()).toString().equals("Mathematics")){
            mat();
        }else if (((subjectOption)this.cbSubject.getValue()).toString().equals("Biology")){
            bio();
        }else if (((subjectOption)this.cbSubject.getValue()).toString().equals("Physics")){
            phy();
        }else if (((subjectOption)this.cbSubject.getValue()).toString().equals("Chemistry")){
            chem();
        }else if (((subjectOption)this.cbSubject.getValue()).toString().equals("Geography")){
            geo();
        }else if (((subjectOption)this.cbSubject.getValue()).toString().equals("History")){
            his();
        }else if (((subjectOption)this.cbSubject.getValue()).toString().equals("CRE")){
            cre();
        }else if (((subjectOption)this.cbSubject.getValue()).toString().equals("Business")){
            bus();
        }else if (((subjectOption)this.cbSubject.getValue()).toString().equals("Agriculture")){
            agri();
        }
    }

    private void eng(){
        try{
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("engEntry.fxml"));

            EngEntry engEntry = (EngEntry) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 1 ENGLISH");
            stage.setResizable(true);
            stage.show();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }
    private void kis(){
        try{
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("kisEntry.fxml"));

            KisEntry kisEntry = (KisEntry) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 1 KISWAHILI");
            stage.setResizable(true);
            stage.show();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }
    private void mat(){
        try{
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("matEntry.fxml"));

            MatEntry matgEntry = (MatEntry) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 1 MATHEMATICS");
            stage.setResizable(true);
            stage.show();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }
    private void bio(){
        try{
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("bioEntry.fxml"));

            BioEntry bioEntry = (BioEntry) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 1 BIOLOGY");
            stage.setResizable(true);
            stage.show();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }
    private void chem(){
        try{
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("chemEntry.fxml"));

            ChemEntry chemEntry = (ChemEntry) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 1 CHEMISTRY");
            stage.setResizable(true);
            stage.show();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }
    private void phy(){
        try{
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("phyEntry.fxml"));

            PhyEntry phyEntry = (PhyEntry) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 1 PHYSICS");
            stage.setResizable(true);
            stage.show();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }
    private void geo(){
        try{
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("geoEntry.fxml"));

            GeoEntry geoEntry = (GeoEntry) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 1 GEOGRAPHY");
            stage.setResizable(true);
            stage.show();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }
    private void his(){
        try{
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("hisEntry.fxml"));

            HisEntry hisEntry = (HisEntry) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 1 HISTORY");
            stage.setResizable(true);
            stage.show();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }
    private void cre(){
        try{
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("creEntry.fxml"));

            CreEntry creEntry = (CreEntry) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 1 CRE");
            stage.setResizable(true);
            stage.show();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }
    private void bus(){
        try{
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("busEntry.fxml"));

            BusEntry busEntry = (BusEntry) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 1 BUSINESS");
            stage.setResizable(true);
            stage.show();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }
    private void agri(){
        try{
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("agriEntry.fxml"));

            AgriEntry agriEntry = (AgriEntry) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 1 AGRICULTURE");
            stage.setResizable(true);
            stage.show();
        }catch (IOException e){
            infoBoxError("An error occurred" + e ,"ERROR",null);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.cbSubject.setItems(FXCollections.observableArrayList(subjectOption.values()));
    }
}
