package Teacher;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import static Alerts.informationBox.infoBox;
import static Alerts.informationBox.infoBoxError;

public class Teacher implements Initializable{
    @FXML
    private TextField teacherCode,fname,mname,lname,shortName;
    @FXML
    private ComboBox<classOption> cbClass;
    @FXML
    private TableView<teacherData> tableTeachers;
    @FXML
    private TableColumn<teacherData, String> idColumn,codeColumn,fnameColumn,mnameColumn,lnameColumn,shortNameColumn,classColumn,subjectColumn;
    @FXML
    private TableColumn<teacherData, Boolean> deleteColumn;
    @FXML
    private TextField classFilter,codeSearch;
    @FXML
    private ComboBox<subjectOption> cbSubject;
    private ObservableList<teacherData> tableList;

    @FXML
    void classFilter(ActionEvent event) {
        String sql = "SELECT  * FROM tbl_teacher WHERE class=?";
        try{
            Connection connection = Database.DBConnection.getConnection();
            this.tableList= FXCollections.observableArrayList();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,this.classFilter.getText().toUpperCase());
            ResultSet set = statement.executeQuery();
            while (set.next()){
                this.tableList.addAll(new teacherData(set.getString(1),set.getString(2),set.getString(3),set.getString(4),set.getString(5),set.getString(6),set.getString(7),set.getString(8)));
            }
            this.idColumn.setCellValueFactory(new PropertyValueFactory<teacherData,String>("id"));
            this.codeColumn.setCellValueFactory(new PropertyValueFactory<teacherData,String>("code"));
            this.fnameColumn.setCellValueFactory(new PropertyValueFactory<teacherData,String>("fname"));
            this.mnameColumn.setCellValueFactory(new PropertyValueFactory<teacherData,String>("mname"));
            this.lnameColumn.setCellValueFactory(new PropertyValueFactory<teacherData,String>("lname"));
            this.shortNameColumn.setCellValueFactory(new PropertyValueFactory<teacherData,String>("shortname"));
            this.classColumn.setCellValueFactory(new PropertyValueFactory<teacherData,String>("classs"));
            this.subjectColumn.setCellValueFactory(new PropertyValueFactory<teacherData,String>("subject"));
            this.deleteColumn.setCellFactory((Callback<TableColumn<teacherData, Boolean>, TableCell<teacherData, Boolean>>) p ->  new ButtonCell());


            this.tableTeachers.setItems(null);
            this.tableTeachers.setItems(this.tableList);
        }catch (Exception e){
            e.printStackTrace();
            infoBoxError("An error occurred","Error",null);
        }

    }

    @FXML
    void insertData(ActionEvent event) {
        if (teacherCode.getText().toString().equals("")||fname.getText().toString().equals("")||mname.getText().toString().equals("")||lname.getText().toString().equals("")||shortName.getText().toString().equals("")||cbClass.getValue().toString().equals("")||cbSubject.getValue().toString().equals("")){
            infoBoxError("All fields must be filled","Error","Empty fields");
        }else {
            String sqlCheck = "SELECT * FROM tbl_teacher WHERE class=? AND subject=?";
            String sql = "INSERT INTO tbl_teacher(code,fname,mname,lname,short,class,subject)VALUES(?,?,?,?,?,?,?)";
            try{
                Connection connection = Database.DBConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
                PreparedStatement statementCheck = connection.prepareStatement(sqlCheck);
                statementCheck.setString(1,cbClass.getValue().toString().toUpperCase());
                statementCheck.setString(2,cbSubject.getValue().toString());
                ResultSet set =statementCheck.executeQuery();
                int Count = 0;
                while (set.next()){
                    Count++;
                    if (Count > 0 ){
                        infoBoxError("Teacher already exist","Error",null);
                        clearTextFields();
                        connection.close();
                    }
                }

                statement.setString(1,teacherCode.getText().toUpperCase());
                statement.setString(2,fname.getText().toUpperCase());
                statement.setString(3,mname.getText().toUpperCase());
                statement.setString(4,lname.getText().toUpperCase());
                statement.setString(5,shortName.getText().toUpperCase());
                statement.setString(6,cbClass.getValue().toString());
                statement.setString(7,cbSubject.getValue().toString());

                statement.execute();
                connection.close();
                clearTextFields();
                loadData();

            }catch (Exception e){
                infoBoxError("An error occurred " + e,"Error",null);
            }
        }
    }

    @FXML
    void loadData() {
        String sql = "SELECT * FROM tbl_teacher";
        try{
            Connection  connection = Database.DBConnection.getConnection();
            this.tableList = FXCollections.observableArrayList();
            ResultSet set = connection.createStatement().executeQuery(sql);
            while (set.next()){
                this.tableList.addAll(new teacherData(set.getString(1),set.getString(2),set.getString(3),set.getString(4),set.getString(5),set.getString(6),set.getString(7),set.getString(8)));
            }
            this.idColumn.setCellValueFactory(new PropertyValueFactory<teacherData,String>("id"));
            this.codeColumn.setCellValueFactory(new PropertyValueFactory<teacherData,String>("code"));
            this.fnameColumn.setCellValueFactory(new PropertyValueFactory<teacherData,String>("fname"));
            this.mnameColumn.setCellValueFactory(new PropertyValueFactory<teacherData,String>("mname"));
            this.lnameColumn.setCellValueFactory(new PropertyValueFactory<teacherData,String>("lname"));
            this.shortNameColumn.setCellValueFactory(new PropertyValueFactory<teacherData,String>("shortname"));
            this.classColumn.setCellValueFactory(new PropertyValueFactory<teacherData,String>("classs"));
            this.subjectColumn.setCellValueFactory(new PropertyValueFactory<teacherData,String>("subject"));
            this.deleteColumn.setCellFactory((Callback<TableColumn<teacherData, Boolean>, TableCell<teacherData, Boolean>>) p ->  new ButtonCell());


            this.tableTeachers.setItems(null);
            this.tableTeachers.setItems(this.tableList);

        }catch (Exception e){
            e.printStackTrace();
            infoBoxError("An error occurred " + e,"Error",null);
        }
    }

    private class ButtonCell extends TableCell<teacherData, Boolean> {
        final Button cellButton = new Button("Delete");
        ButtonCell(){
            cellButton.setOnAction(new EventHandler<ActionEvent>(){
                @Override
                public void handle(ActionEvent t) {
                    String sql = "DELETE FROM tbl_teacher WHERE id=?";



                    try {
                        Connection connection = Database.DBConnection.getConnection();
                        PreparedStatement statement = connection.prepareStatement(sql);
                        teacherData toRemove = (teacherData) tableTeachers.getItems().get(getTableRow().getIndex());

                        statement.setString(1,toRemove.getId().toUpperCase());

                        statement.execute();
                        connection.close();
                        infoBox("Teacher deleted successfully","Success",null);
                        loadData();
                    }catch (Exception e){
                        infoBoxError("An error occurred " + e,"Error",null);
                    }
                }
            });
        }
        //Display button if the row is not empty
        @Override
        protected void updateItem(Boolean t, boolean empty) {
            super.updateItem(t, empty);
            if(!empty){
                setGraphic(cellButton);
            }
        }
    }

    @FXML
    void searchCode(ActionEvent event) {
        String sql = "SELECT  * FROM tbl_teacher WHERE code=?";
        try{
            Connection connection = Database.DBConnection.getConnection();
            this.tableList= FXCollections.observableArrayList();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,this.codeSearch.getText().toUpperCase());
            ResultSet set = statement.executeQuery();
            while (set.next()){
                this.tableList.addAll(new teacherData(set.getString(1),set.getString(2),set.getString(3),set.getString(4),set.getString(5),set.getString(6),set.getString(7),set.getString(8)));
            }
            this.idColumn.setCellValueFactory(new PropertyValueFactory<teacherData,String>("id"));
            this.codeColumn.setCellValueFactory(new PropertyValueFactory<teacherData,String>("code"));
            this.fnameColumn.setCellValueFactory(new PropertyValueFactory<teacherData,String>("fname"));
            this.mnameColumn.setCellValueFactory(new PropertyValueFactory<teacherData,String>("mname"));
            this.lnameColumn.setCellValueFactory(new PropertyValueFactory<teacherData,String>("lname"));
            this.shortNameColumn.setCellValueFactory(new PropertyValueFactory<teacherData,String>("shortname"));
            this.classColumn.setCellValueFactory(new PropertyValueFactory<teacherData,String>("classs"));
            this.subjectColumn.setCellValueFactory(new PropertyValueFactory<teacherData,String>("subject"));
            this.deleteColumn.setCellFactory((Callback<TableColumn<teacherData, Boolean>, TableCell<teacherData, Boolean>>) p ->  new ButtonCell());


            this.tableTeachers.setItems(null);
            this.tableTeachers.setItems(this.tableList);
        }catch (Exception e){
            e.printStackTrace();
            infoBoxError("An error occurred","Error",null);
        }

    }

    @FXML
    void setEdit(MouseEvent event) {
        teacherData tableTeacherUpdate = tableTeachers.getSelectionModel().getSelectedItem();
        teacherCode.setText(tableTeacherUpdate.getCode());
        fname.setText(tableTeacherUpdate.getFname());
        mname.setText(tableTeacherUpdate.getMname());
        lname.setText(tableTeacherUpdate.getLname());
        shortName.setText(tableTeacherUpdate.getShortname());
        cbClass.setValue(classOption.fromvalue(tableTeacherUpdate.getClasss()));
        cbSubject.setValue(subjectOption.fromvalue(tableTeacherUpdate.getSubject()));
    }

    @FXML
    void updateTeacher(ActionEvent event) {
        teacherData tableStudentsUpdate = tableTeachers.getSelectionModel().getSelectedItem();
        String idCode = tableStudentsUpdate.getId();
        if (teacherCode.getText().toString().equals("")||fname.getText().toString().equals("")||mname.getText().toString().equals("")||lname.getText().toString().equals("")||shortName.getText().toString().equals("")||cbClass.getValue().toString().equals("")||cbSubject.getValue().toString().equals("")){
            infoBoxError("All fields must be filled","Error","Empty fields");
        }else {
            String sql = "UPDATE tbl_teacher SET code=?,fname=?,mname=?,lname=?,short=?,class=?,subject=? WHERE id=?";
            try{
                Connection connection = Database.DBConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);

                statement.setString(1,teacherCode.getText().toUpperCase());
                statement.setString(2,fname.getText().toUpperCase());
                statement.setString(3,mname.getText().toUpperCase());
                statement.setString(4,lname.getText().toUpperCase());
                statement.setString(5,shortName.getText().toUpperCase());
                statement.setString(6,cbClass.getValue().toString());
                statement.setString(7,cbSubject.getValue().toString());
                statement.setString(8,idCode.toUpperCase());

                statement.execute();
                connection.close();
                clearTextFields();
                loadData();

            }catch (Exception e){
                infoBoxError("An error occurred " + e,"Error",null);
            }
        }

    }

    private void clearTextFields(){
        this.teacherCode.clear();
        this.fname.clear();
        this.mname.clear();
        this.lname.clear();
        this.shortName.clear();
        this.cbClass.getEditor().clear();
        this.cbSubject.getEditor().clear();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.cbSubject.setItems(FXCollections.observableArrayList(subjectOption.values()));
        this.cbClass.setItems(FXCollections.observableArrayList(classOption.values()));
        loadData();
    }
}
