package Students;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import static Alerts.informationBox.infoBoxError;

public class SubjectSelection implements Initializable{
    @FXML
    private TableView<subjectSelectionData> tableSubjectSel;
    @FXML
    private TableColumn<subjectSelectionData,String> idColumn,admColumn,nameColumn,classColumn,engColumn,kisColumn,matColumn,bioColumn,chemColumn,phyColumn,hisColumn,creColumn,geoColumn,busColumn,agriColumn;
    @FXML
    private TextField classFilter,admSearch;
    private ObservableList<subjectSelectionData> tableList;

    @FXML
    private void loadData(){
        String sqlSel = "SELECT * FROM tbl_subject_selection";
        try{
            Connection connection = Database.DBConnection.getConnection();
            this.tableList = FXCollections.observableArrayList();
            ResultSet set = connection.createStatement().executeQuery(sqlSel);
            while (set.next()){
                this.tableList.addAll(new subjectSelectionData(set.getString(1),set.getString(2),set.getString(3)+" "+set.getString(4)+" "+set.getString(5),set.getString(7),set.getString(8),set.getString(9),set.getString(10),set.getString(11),set.getString(12),set.getString(13),set.getString(14),set.getString(15),set.getString(16),set.getString(17),set.getString(18)));
            }

            this.idColumn.setCellValueFactory(new PropertyValueFactory<subjectSelectionData,String>("id"));
            this.admColumn.setCellValueFactory(new PropertyValueFactory<subjectSelectionData,String>("adm"));
            this.nameColumn.setCellValueFactory(new PropertyValueFactory<subjectSelectionData,String>("name"));
            this.classColumn.setCellValueFactory(new PropertyValueFactory<subjectSelectionData,String>("classs"));
            this.engColumn.setCellValueFactory(new PropertyValueFactory<subjectSelectionData,String>("eng"));
            this.kisColumn.setCellValueFactory(new PropertyValueFactory<subjectSelectionData,String>("kis"));
            this.matColumn.setCellValueFactory(new PropertyValueFactory<subjectSelectionData,String>("mat"));
            this.bioColumn.setCellValueFactory(new PropertyValueFactory<subjectSelectionData,String>("bio"));
            this.chemColumn.setCellValueFactory(new PropertyValueFactory<subjectSelectionData,String>("chem"));
            this.phyColumn.setCellValueFactory(new PropertyValueFactory<subjectSelectionData,String>("phy"));
            this.geoColumn.setCellValueFactory(new PropertyValueFactory<subjectSelectionData,String>("geo"));
            this.hisColumn.setCellValueFactory(new PropertyValueFactory<subjectSelectionData,String>("his"));
            this.creColumn.setCellValueFactory(new PropertyValueFactory<subjectSelectionData,String>("cre"));
            this.busColumn.setCellValueFactory(new PropertyValueFactory<subjectSelectionData,String>("bus"));
            this.agriColumn.setCellValueFactory(new PropertyValueFactory<subjectSelectionData,String>("agri"));

            this.tableSubjectSel.setItems(null);
            this.tableSubjectSel.setItems(this.tableList);

        }catch (Exception e){
            e.printStackTrace();
            infoBoxError("An error occurred " + e,"Error",null);
        }
    }

    @FXML
    private void classFilter(){
        String sqlSel = "SELECT * FROM tbl_subject_selection WHERE class=?";
        try{
            Connection connection = Database.DBConnection.getConnection();
            this.tableList= FXCollections.observableArrayList();
            PreparedStatement statement = connection.prepareStatement(sqlSel);
            statement.setString(1,this.classFilter.getText().toUpperCase());
            ResultSet set = statement.executeQuery();
            while (set.next()){
                this.tableList.addAll(new subjectSelectionData(set.getString(1),set.getString(2),set.getString(3)+" "+set.getString(4)+" "+set.getString(5),set.getString(7),set.getString(8),set.getString(9),set.getString(10),set.getString(11),set.getString(12),set.getString(13),set.getString(14),set.getString(15),set.getString(16),set.getString(17),set.getString(18)));
            }

            this.idColumn.setCellValueFactory(new PropertyValueFactory<subjectSelectionData,String>("id"));
            this.admColumn.setCellValueFactory(new PropertyValueFactory<subjectSelectionData,String>("adm"));
            this.nameColumn.setCellValueFactory(new PropertyValueFactory<subjectSelectionData,String>("name"));
            this.classColumn.setCellValueFactory(new PropertyValueFactory<subjectSelectionData,String>("classs"));
            this.engColumn.setCellValueFactory(new PropertyValueFactory<subjectSelectionData,String>("eng"));
            this.kisColumn.setCellValueFactory(new PropertyValueFactory<subjectSelectionData,String>("kis"));
            this.matColumn.setCellValueFactory(new PropertyValueFactory<subjectSelectionData,String>("mat"));
            this.bioColumn.setCellValueFactory(new PropertyValueFactory<subjectSelectionData,String>("bio"));
            this.chemColumn.setCellValueFactory(new PropertyValueFactory<subjectSelectionData,String>("chem"));
            this.phyColumn.setCellValueFactory(new PropertyValueFactory<subjectSelectionData,String>("phy"));
            this.hisColumn.setCellValueFactory(new PropertyValueFactory<subjectSelectionData,String>("his"));
            this.creColumn.setCellValueFactory(new PropertyValueFactory<subjectSelectionData,String>("cre"));
            this.geoColumn.setCellValueFactory(new PropertyValueFactory<subjectSelectionData,String>("geo"));
            this.busColumn.setCellValueFactory(new PropertyValueFactory<subjectSelectionData,String>("bus"));
            this.agriColumn.setCellValueFactory(new PropertyValueFactory<subjectSelectionData,String>("agri"));

            this.tableSubjectSel.setItems(null);
            this.tableSubjectSel.setItems(this.tableList);
        }catch (Exception e){
            e.printStackTrace();
            infoBoxError("An error occurred " + e,"Error",null);
        }
    }

    @FXML
    private void searchAdm(){
        String sqlSel = "SELECT * FROM tbl_subject_selection WHERE adm=?";
        try{
            Connection connection = Database.DBConnection.getConnection();
            this.tableList= FXCollections.observableArrayList();
            PreparedStatement statement = connection.prepareStatement(sqlSel);
            statement.setString(1,this.admSearch.getText().toUpperCase());
            ResultSet set = statement.executeQuery();
            while (set.next()){
                this.tableList.addAll(new subjectSelectionData(set.getString(1),set.getString(2),set.getString(3)+" "+set.getString(4)+" "+set.getString(5),set.getString(7),set.getString(8),set.getString(9),set.getString(10),set.getString(11),set.getString(12),set.getString(13),set.getString(14),set.getString(15),set.getString(16),set.getString(17),set.getString(18)));
            }

            this.idColumn.setCellValueFactory(new PropertyValueFactory<subjectSelectionData,String>("id"));
            this.admColumn.setCellValueFactory(new PropertyValueFactory<subjectSelectionData,String>("adm"));
            this.nameColumn.setCellValueFactory(new PropertyValueFactory<subjectSelectionData,String>("name"));
            this.classColumn.setCellValueFactory(new PropertyValueFactory<subjectSelectionData,String>("classs"));
            this.engColumn.setCellValueFactory(new PropertyValueFactory<subjectSelectionData,String>("eng"));
            this.kisColumn.setCellValueFactory(new PropertyValueFactory<subjectSelectionData,String>("kis"));
            this.matColumn.setCellValueFactory(new PropertyValueFactory<subjectSelectionData,String>("mat"));
            this.bioColumn.setCellValueFactory(new PropertyValueFactory<subjectSelectionData,String>("bio"));
            this.chemColumn.setCellValueFactory(new PropertyValueFactory<subjectSelectionData,String>("chem"));
            this.phyColumn.setCellValueFactory(new PropertyValueFactory<subjectSelectionData,String>("phy"));
            this.hisColumn.setCellValueFactory(new PropertyValueFactory<subjectSelectionData,String>("his"));
            this.creColumn.setCellValueFactory(new PropertyValueFactory<subjectSelectionData,String>("cre"));
            this.geoColumn.setCellValueFactory(new PropertyValueFactory<subjectSelectionData,String>("geo"));
            this.busColumn.setCellValueFactory(new PropertyValueFactory<subjectSelectionData,String>("bus"));
            this.agriColumn.setCellValueFactory(new PropertyValueFactory<subjectSelectionData,String>("agri"));

            this.tableSubjectSel.setItems(null);
            this.tableSubjectSel.setItems(this.tableList);
        }catch (Exception e){
            e.printStackTrace();
            infoBoxError("An error occurred " + e,"Error",null);
        }
    }

    @FXML
    private void engUpdate(TableColumn.CellEditEvent cellEditEvent){
        subjectSelectionData tableDataSelected = tableSubjectSel.getSelectionModel().getSelectedItem();
        String selection= tableDataSelected.setEng(cellEditEvent.getNewValue().toString().toUpperCase());
        String adm=tableDataSelected.getAdm();
        String sqlSel = "UPDATE tbl_subject_selection SET english=? WHERE adm=?";
        try{
            Connection connection = Database.DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sqlSel);

            statement.setString(1,selection.toUpperCase());
            statement.setString(2,adm.toUpperCase());

            statement.execute();
            connection.close();
            loadData();
        }catch (Exception e){
            e.printStackTrace();
            infoBoxError("An error occurred " + e,"Error",null);
        }
    }

    @FXML
    private void kisUpdate(TableColumn.CellEditEvent cellEditEvent){
        subjectSelectionData tableDataSelected = tableSubjectSel.getSelectionModel().getSelectedItem();
        String selection= tableDataSelected.setKis(cellEditEvent.getNewValue().toString().toUpperCase());
        String adm=tableDataSelected.getAdm();
        String sqlSel = "UPDATE tbl_subject_selection SET kiswahili=? WHERE adm=?";
        try{
            Connection connection = Database.DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sqlSel);

            statement.setString(1,selection.toUpperCase());
            statement.setString(2,adm.toUpperCase());

            statement.execute();
            connection.close();
            loadData();
        }catch (Exception e){
            e.printStackTrace();
            infoBoxError("An error occurred " + e,"Error",null);
        }
    }

    @FXML
    private void matUpdate(TableColumn.CellEditEvent cellEditEvent){
        subjectSelectionData tableDataSelected = tableSubjectSel.getSelectionModel().getSelectedItem();
        String selection= tableDataSelected.setMat(cellEditEvent.getNewValue().toString().toUpperCase());
        String adm=tableDataSelected.getAdm();
        String sqlSel = "UPDATE tbl_subject_selection SET mathematics=? WHERE adm=?";
        try{
            Connection connection = Database.DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sqlSel);

            statement.setString(1,selection.toUpperCase());
            statement.setString(2,adm.toUpperCase());

            statement.execute();
            connection.close();
            loadData();
        }catch (Exception e){
            e.printStackTrace();
            infoBoxError("An error occurred " + e,"Error",null);
        }
    }

    @FXML
    private void bioUpdate(TableColumn.CellEditEvent cellEditEvent){
        subjectSelectionData tableDataSelected = tableSubjectSel.getSelectionModel().getSelectedItem();
        String selection= tableDataSelected.setBio(cellEditEvent.getNewValue().toString().toUpperCase());
        String adm=tableDataSelected.getAdm();
        String sqlSel = "UPDATE tbl_subject_selection SET biology=? WHERE adm=?";
        try{
            Connection connection = Database.DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sqlSel);

            statement.setString(1,selection.toUpperCase());
            statement.setString(2,adm.toUpperCase());

            statement.execute();
            connection.close();
            loadData();
        }catch (Exception e){
            e.printStackTrace();
            infoBoxError("An error occurred " + e,"Error",null);
        }
    }

    @FXML
    private void chemUpdate(TableColumn.CellEditEvent cellEditEvent){
        subjectSelectionData tableDataSelected = tableSubjectSel.getSelectionModel().getSelectedItem();
        String selection= tableDataSelected.setChem(cellEditEvent.getNewValue().toString().toUpperCase());
        String adm=tableDataSelected.getAdm();
        String sqlSel = "UPDATE tbl_subject_selection SET chemistry=? WHERE adm=?";
        try{
            Connection connection = Database.DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sqlSel);

            statement.setString(1,selection.toUpperCase());
            statement.setString(2,adm.toUpperCase());

            statement.execute();
            connection.close();
            loadData();
        }catch (Exception e){
            e.printStackTrace();
            infoBoxError("An error occurred " + e,"Error",null);
        }
    }

    @FXML
    private void phyUpdate(TableColumn.CellEditEvent cellEditEvent){
        subjectSelectionData tableDataSelected = tableSubjectSel.getSelectionModel().getSelectedItem();
        String selection= tableDataSelected.setPhy(cellEditEvent.getNewValue().toString().toUpperCase());
        String adm=tableDataSelected.getAdm();
        String sqlSel = "UPDATE tbl_subject_selection SET physics=? WHERE adm=?";
        try{
            Connection connection = Database.DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sqlSel);

            statement.setString(1,selection.toUpperCase());
            statement.setString(2,adm.toUpperCase());

            statement.execute();
            connection.close();
            loadData();
        }catch (Exception e){
            e.printStackTrace();
            infoBoxError("An error occurred " + e,"Error",null);
        }
    }

    @FXML
    private void hisUpdate(TableColumn.CellEditEvent cellEditEvent){
        subjectSelectionData tableDataSelected = tableSubjectSel.getSelectionModel().getSelectedItem();
        String selection= tableDataSelected.setHis(cellEditEvent.getNewValue().toString().toUpperCase());
        String adm=tableDataSelected.getAdm();
        String sqlSel = "UPDATE tbl_subject_selection SET history=? WHERE adm=?";
        try{
            Connection connection = Database.DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sqlSel);

            statement.setString(1,selection.toUpperCase());
            statement.setString(2,adm.toUpperCase());

            statement.execute();
            connection.close();
            loadData();
        }catch (Exception e){
            e.printStackTrace();
            infoBoxError("An error occurred " + e,"Error",null);
        }
    }

    @FXML
    private void creUpdate(TableColumn.CellEditEvent cellEditEvent){
        subjectSelectionData tableDataSelected = tableSubjectSel.getSelectionModel().getSelectedItem();
        String selection= tableDataSelected.setCre(cellEditEvent.getNewValue().toString().toUpperCase());
        String adm=tableDataSelected.getAdm();
        String sqlSel = "UPDATE tbl_subject_selection SET cre=? WHERE adm=?";
        try{
            Connection connection = Database.DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sqlSel);

            statement.setString(1,selection.toUpperCase());
            statement.setString(2,adm.toUpperCase());

            statement.execute();
            connection.close();
            loadData();
        }catch (Exception e){
            e.printStackTrace();
            infoBoxError("An error occurred " + e,"Error",null);
        }
    }

    @FXML
    private void geoUpdate(TableColumn.CellEditEvent cellEditEvent){
        subjectSelectionData tableDataSelected = tableSubjectSel.getSelectionModel().getSelectedItem();
        String selection= tableDataSelected.setGeo(cellEditEvent.getNewValue().toString().toUpperCase());
        String adm=tableDataSelected.getAdm();
        String sqlSel = "UPDATE tbl_subject_selection SET geography=? WHERE adm=?";
        try{
            Connection connection = Database.DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sqlSel);

            statement.setString(1,selection.toUpperCase());
            statement.setString(2,adm.toUpperCase());

            statement.execute();
            connection.close();
            loadData();
        }catch (Exception e){
            e.printStackTrace();
            infoBoxError("An error occurred " + e,"Error",null);
        }
    }

    @FXML
    private void busUpdate(TableColumn.CellEditEvent cellEditEvent){
        subjectSelectionData tableDataSelected = tableSubjectSel.getSelectionModel().getSelectedItem();
        String selection= tableDataSelected.setBus(cellEditEvent.getNewValue().toString().toUpperCase());
        String adm=tableDataSelected.getAdm();
        String sqlSel = "UPDATE tbl_subject_selection SET business=? WHERE adm=?";
        try{
            Connection connection = Database.DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sqlSel);

            statement.setString(1,selection.toUpperCase());
            statement.setString(2,adm.toUpperCase());

            statement.execute();
            connection.close();
            loadData();
        }catch (Exception e){
            e.printStackTrace();
            infoBoxError("An error occurred " + e,"Error",null);
        }
    }

    @FXML
    private void agriUpdate(TableColumn.CellEditEvent cellEditEvent){
        subjectSelectionData tableDataSelected = tableSubjectSel.getSelectionModel().getSelectedItem();
        String selection= tableDataSelected.setAgri(cellEditEvent.getNewValue().toString().toUpperCase());
        String adm=tableDataSelected.getAdm();
        String sqlSel = "UPDATE tbl_subject_selection SET agriculture=? WHERE adm=?";
        try{
            Connection connection = Database.DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sqlSel);

            statement.setString(1,selection.toUpperCase());
            statement.setString(2,adm.toUpperCase());

            statement.execute();
            connection.close();
            loadData();
        }catch (Exception e){
            e.printStackTrace();
            infoBoxError("An error occurred " + e,"Error",null);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadData();

        tableSubjectSel.setEditable(true);
        engColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        kisColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        matColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        bioColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        chemColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        phyColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        geoColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        hisColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        creColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        busColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        agriColumn.setCellFactory(TextFieldTableCell.forTableColumn());
    }
}
