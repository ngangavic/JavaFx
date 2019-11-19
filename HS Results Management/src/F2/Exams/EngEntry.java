package F2.Exams;

import F2.Exams.marksData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static Alerts.informationBox.infoBoxError;

public class EngEntry implements Initializable{
    @FXML
    private TableView<marksData> tableMarks;
    @FXML private TableColumn<marksData,String> idColumn,admColumn,fnameColumn,mnameColumn,lnameColumn;
    @FXML private TableColumn<marksData,String> term1Exam1Column,term1Exam2Column,term1Exam3Column;
    @FXML private TableColumn<marksData,String> term2Exam1Column,term2Exam2Column,term2Exam3Column;
    @FXML private TableColumn<marksData,String> term3Exam1Column,term3Exam2Column,term3Exam3Column;
    private ObservableList<marksData> tableList;

    public void loadData(){
        String sql = "SELECT * FROM tbl_f2_eng WHERE class='FORM_1'";

        try{
            Connection connection = Database.DBConnection.getConnection();
            this.tableList = FXCollections.observableArrayList();
            ResultSet resultSet = connection.createStatement().executeQuery(sql);

            while(resultSet.next()){
                this.tableList.addAll(new marksData(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(8),resultSet.getString(10),resultSet.getString(12),resultSet.getString(14),resultSet.getString(16),resultSet.getString(18),resultSet.getString(20),resultSet.getString(22),resultSet.getString(24)));
            }

            this.idColumn.setCellValueFactory(new PropertyValueFactory<marksData,String>("id"));
            this.admColumn.setCellValueFactory(new PropertyValueFactory<marksData,String>("adm"));
            this.fnameColumn.setCellValueFactory(new PropertyValueFactory<marksData,String>("fname"));
            this.mnameColumn.setCellValueFactory(new PropertyValueFactory<marksData,String>("mname"));
            this.lnameColumn.setCellValueFactory(new PropertyValueFactory<marksData,String>("lname"));
            this.term1Exam1Column.setCellValueFactory(new PropertyValueFactory<marksData,String>("ex1t1"));
            this.term1Exam2Column.setCellValueFactory(new PropertyValueFactory<marksData,String>("ex2t1"));
            this.term1Exam3Column.setCellValueFactory(new PropertyValueFactory<marksData,String>("ex3t1"));
            this.term2Exam1Column.setCellValueFactory(new PropertyValueFactory<marksData,String>("ex1t2"));
            this.term2Exam2Column.setCellValueFactory(new PropertyValueFactory<marksData,String>("ex2t2"));
            this.term2Exam3Column.setCellValueFactory(new PropertyValueFactory<marksData,String>("ex3t2"));
            this.term3Exam1Column.setCellValueFactory(new PropertyValueFactory<marksData,String>("ex1t3"));
            this.term3Exam2Column.setCellValueFactory(new PropertyValueFactory<marksData,String>("ex2t3"));
            this.term3Exam3Column.setCellValueFactory(new PropertyValueFactory<marksData,String>("ex3t3"));

            this.tableMarks.setItems(null);
            this.tableMarks.setItems(this.tableList);

        }catch (Exception e){
            infoBoxError("An error occurred " + e,"Error",null);
        }

    }

    public void ex1t1Update(TableColumn.CellEditEvent cellEditEvent){

        marksData tableDataSelected = tableMarks.getSelectionModel().getSelectedItem();
        int marks= Integer.parseInt(tableDataSelected.setEx1t1(cellEditEvent.getNewValue().toString().toUpperCase()));
        String idCode=tableDataSelected.getId();

        String sql= "UPDATE tbl_f2_eng SET ex1=?,g1=? WHERE id=?";
        String sqlGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='ENGLISH'";
        String sqlEx = "UPDATE tbl_f2_t1_ex1 SET eng=?,engg=? WHERE id=?";

        try{
            Connection connection = Database.DBConnection.getConnection();
            PreparedStatement preparedStatement =connection.prepareStatement(sql);
            PreparedStatement statementEx =connection.prepareStatement(sqlEx);
            ResultSet set = connection.createStatement().executeQuery(sqlGrade);
            String marksE = "";
            if (marks >= Integer.parseInt(set.getString(4))) {marksE = "A"; } else if (marks >= Integer.parseInt(set.getString(5))) { marksE = "A-"; }else if (marks >=Integer.parseInt(set.getString(6))){ marksE = "B+";}else if (marks >=Integer.parseInt(set.getString(7))){
                marksE = "B"; }else if (marks >=Integer.parseInt(set.getString(8))){  marksE = "B-"; }else if (marks >=Integer.parseInt(set.getString(9))){ marksE = "C+"; }else if (marks >=Integer.parseInt(set.getString(10))){ marksE = "C";
            }else if (marks >=Integer.parseInt(set.getString(11))){ marksE = "C-";}else if (marks >=Integer.parseInt(set.getString(12))){ marksE = "D+";}else if (marks >=Integer.parseInt(set.getString(13))){ marksE = "D";}else if (marks >=Integer.parseInt(set.getString(14))){
                marksE = "D-";}else {marksE="E"; }

            preparedStatement.setString(1, String.valueOf(marks));
            preparedStatement.setString(2,marksE.toUpperCase());
            preparedStatement.setString(3,idCode.toUpperCase());

            statementEx.setString(1, String.valueOf(marks));
            statementEx.setString(2,marksE.toUpperCase());
            statementEx.setString(3,idCode.toUpperCase());

            statementEx.execute();
            preparedStatement.execute();
            connection.close();
            loadData();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void ex2t1Update(TableColumn.CellEditEvent cellEditEvent){

        marksData tableDataSelected = tableMarks.getSelectionModel().getSelectedItem();
        int marks= Integer.parseInt(tableDataSelected.setEx2t1(cellEditEvent.getNewValue().toString().toUpperCase()));
        String idCode=tableDataSelected.getId();

        String sql= "UPDATE tbl_f2_eng SET ex2=?,g2=? WHERE id=?";
        String sqlGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='ENGLISH'";
        String sqlEx = "UPDATE tbl_f2_t1_ex2 SET eng=?,engg=? WHERE id=?";

        try{
            Connection connection = Database.DBConnection.getConnection();
            PreparedStatement preparedStatement =connection.prepareStatement(sql);
            PreparedStatement statementEx =connection.prepareStatement(sqlEx);
            ResultSet set = connection.createStatement().executeQuery(sqlGrade);
            String marksE = "";
            if (marks >= Integer.parseInt(set.getString(4))) {marksE = "A"; } else if (marks >= Integer.parseInt(set.getString(5))) { marksE = "A-"; }else if (marks >=Integer.parseInt(set.getString(6))){ marksE = "B+";}else if (marks >=Integer.parseInt(set.getString(7))){
                marksE = "B"; }else if (marks >=Integer.parseInt(set.getString(8))){  marksE = "B-"; }else if (marks >=Integer.parseInt(set.getString(9))){ marksE = "C+"; }else if (marks >=Integer.parseInt(set.getString(10))){ marksE = "C";
            }else if (marks >=Integer.parseInt(set.getString(11))){ marksE = "C-";}else if (marks >=Integer.parseInt(set.getString(12))){ marksE = "D+";}else if (marks >=Integer.parseInt(set.getString(13))){ marksE = "D";}else if (marks >=Integer.parseInt(set.getString(14))){
                marksE = "D-";}else {marksE="E"; }

            preparedStatement.setString(1, String.valueOf(marks));
            preparedStatement.setString(2,marksE.toUpperCase());
            preparedStatement.setString(3,idCode.toUpperCase());

            statementEx.setString(1, String.valueOf(marks));
            statementEx.setString(2,marksE.toUpperCase());
            statementEx.setString(3,idCode.toUpperCase());

            statementEx.execute();
            preparedStatement.execute();
            connection.close();
            loadData();

        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public void ex3t1Update(TableColumn.CellEditEvent cellEditEvent){

        marksData tableDataSelected = tableMarks.getSelectionModel().getSelectedItem();
        int marks= Integer.parseInt(tableDataSelected.setEx3t1(cellEditEvent.getNewValue().toString().toUpperCase()));
        int ex1 = Integer.parseInt(tableDataSelected.getEx1t1());
        int ex2 = Integer.parseInt(tableDataSelected.getEx2t1());
        int ex3 = Integer.parseInt(tableDataSelected.getEx3t1());
        float avg = Math.round((ex1+ex2+ex3)/3);
        String idCode=tableDataSelected.getId();

        String sql= "UPDATE tbl_f2_eng SET ex3=?,g3=? WHERE id=?";
        String sqlGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='ENGLISH'";
        String sqlAvg = "UPDATE tbl_f2_t1_avg SET eng=?,engg=? WHERE id=?";
        String sqlEx = "UPDATE tbl_f2_t1_ex3 SET eng=?,engg=? WHERE id=?";

        try{
            Connection connection = Database.DBConnection.getConnection();
            PreparedStatement preparedStatement =connection.prepareStatement(sql);
            PreparedStatement statementEx =connection.prepareStatement(sqlEx);
            PreparedStatement preparedStatementAvg =connection.prepareStatement(sqlAvg);
            ResultSet set = connection.createStatement().executeQuery(sqlGrade);
            String marksE = "";
            if (marks >= Integer.parseInt(set.getString(4))) {marksE = "A"; } else if (marks >= Integer.parseInt(set.getString(5))) { marksE = "A-"; }else if (marks >=Integer.parseInt(set.getString(6))){ marksE = "B+";}else if (marks >=Integer.parseInt(set.getString(7))){
                marksE = "B"; }else if (marks >=Integer.parseInt(set.getString(8))){  marksE = "B-"; }else if (marks >=Integer.parseInt(set.getString(9))){ marksE = "C+"; }else if (marks >=Integer.parseInt(set.getString(10))){ marksE = "C";
            }else if (marks >=Integer.parseInt(set.getString(11))){ marksE = "C-";}else if (marks >=Integer.parseInt(set.getString(12))){ marksE = "D+";}else if (marks >=Integer.parseInt(set.getString(13))){ marksE = "D";}else if (marks >=Integer.parseInt(set.getString(14))){
                marksE = "D-";}else {marksE="E"; }

            String g = "";
            if (avg >= Integer.parseInt(set.getString(4))) {g = "A"; } else if (avg >= Integer.parseInt(set.getString(5))) { g = "A-"; }else if (avg >=Integer.parseInt(set.getString(6))){ g = "B+";}else if (avg >=Integer.parseInt(set.getString(7))){
                g = "B"; }else if (avg >=Integer.parseInt(set.getString(8))){  g = "B-"; }else if (avg >=Integer.parseInt(set.getString(9))){ g = "C+"; }else if (avg >=Integer.parseInt(set.getString(10))){ g = "C";
            }else if (avg >=Integer.parseInt(set.getString(11))){ g = "C-";}else if (avg >=Integer.parseInt(set.getString(12))){ g = "D+";}else if (avg >=Integer.parseInt(set.getString(13))){ g = "D";}else if (avg >=Integer.parseInt(set.getString(14))){
                g = "D-";}else {g="E"; }

            preparedStatement.setString(1, String.valueOf(marks));
            preparedStatement.setString(2,marksE.toUpperCase());
            preparedStatement.setString(3,idCode.toUpperCase());

            preparedStatementAvg.setString(1,String.valueOf(String.format("%.0f",avg)));
            preparedStatementAvg.setString(2,g.toUpperCase());
            preparedStatementAvg.setString(3,idCode.toUpperCase());

            statementEx.setString(1, String.valueOf(marks));
            statementEx.setString(2,marksE.toUpperCase());
            statementEx.setString(3,idCode.toUpperCase());

            statementEx.execute();
            preparedStatement.execute();
            preparedStatementAvg.execute();
            connection.close();
            loadData();

        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public void ex1t2Update(TableColumn.CellEditEvent cellEditEvent){

        marksData tableDataSelected = tableMarks.getSelectionModel().getSelectedItem();
        int marks= Integer.parseInt(tableDataSelected.setEx1t2(cellEditEvent.getNewValue().toString().toUpperCase()));
        String idCode=tableDataSelected.getId();

        String sql= "UPDATE tbl_f2_eng SET ex4=?,g4=? WHERE id=?";
        String sqlGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='ENGLISH'";
        String sqlEx = "UPDATE tbl_f2_t2_ex1 SET eng=?,engg=? WHERE id=?";

        try{
            Connection connection = Database.DBConnection.getConnection();
            PreparedStatement preparedStatement =connection.prepareStatement(sql);
            PreparedStatement statementEx =connection.prepareStatement(sqlEx);
            ResultSet set = connection.createStatement().executeQuery(sqlGrade);
            String marksE = "";
            if (marks >= Integer.parseInt(set.getString(4))) {marksE = "A"; } else if (marks >= Integer.parseInt(set.getString(5))) { marksE = "A-"; }else if (marks >=Integer.parseInt(set.getString(6))){ marksE = "B+";}else if (marks >=Integer.parseInt(set.getString(7))){
                marksE = "B"; }else if (marks >=Integer.parseInt(set.getString(8))){  marksE = "B-"; }else if (marks >=Integer.parseInt(set.getString(9))){ marksE = "C+"; }else if (marks >=Integer.parseInt(set.getString(10))){ marksE = "C";
            }else if (marks >=Integer.parseInt(set.getString(11))){ marksE = "C-";}else if (marks >=Integer.parseInt(set.getString(12))){ marksE = "D+";}else if (marks >=Integer.parseInt(set.getString(13))){ marksE = "D";}else if (marks >=Integer.parseInt(set.getString(14))){
                marksE = "D-";}else {marksE="E"; }

            preparedStatement.setString(1, String.valueOf(marks));
            preparedStatement.setString(2,marksE.toUpperCase());
            preparedStatement.setString(3,idCode.toUpperCase());

            statementEx.setString(1, String.valueOf(marks));
            statementEx.setString(2,marksE.toUpperCase());
            statementEx.setString(3,idCode.toUpperCase());

            statementEx.execute();
            preparedStatement.execute();
            connection.close();
            loadData();

        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public void ex2t2Update(TableColumn.CellEditEvent cellEditEvent){

        marksData tableDataSelected = tableMarks.getSelectionModel().getSelectedItem();
        int marks= Integer.parseInt(tableDataSelected.setEx2t2(cellEditEvent.getNewValue().toString().toUpperCase()));
        String idCode=tableDataSelected.getId();

        String sql= "UPDATE tbl_f2_eng SET ex5=?,g5=? WHERE id=?";
        String sqlGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='ENGLISH'";
        String sqlEx = "UPDATE tbl_f2_t2_ex2 SET eng=?,engg=? WHERE id=?";

        try{
            Connection connection = Database.DBConnection.getConnection();
            PreparedStatement preparedStatement =connection.prepareStatement(sql);
            PreparedStatement statementEx =connection.prepareStatement(sqlEx);
            ResultSet set = connection.createStatement().executeQuery(sqlGrade);
            String marksE = "";
            if (marks >= Integer.parseInt(set.getString(4))) {marksE = "A"; } else if (marks >= Integer.parseInt(set.getString(5))) { marksE = "A-"; }else if (marks >=Integer.parseInt(set.getString(6))){ marksE = "B+";}else if (marks >=Integer.parseInt(set.getString(7))){
                marksE = "B"; }else if (marks >=Integer.parseInt(set.getString(8))){  marksE = "B-"; }else if (marks >=Integer.parseInt(set.getString(9))){ marksE = "C+"; }else if (marks >=Integer.parseInt(set.getString(10))){ marksE = "C";
            }else if (marks >=Integer.parseInt(set.getString(11))){ marksE = "C-";}else if (marks >=Integer.parseInt(set.getString(12))){ marksE = "D+";}else if (marks >=Integer.parseInt(set.getString(13))){ marksE = "D";}else if (marks >=Integer.parseInt(set.getString(14))){
                marksE = "D-";}else {marksE="E"; }

            preparedStatement.setString(1, String.valueOf(marks));
            preparedStatement.setString(2,marksE.toUpperCase());
            preparedStatement.setString(3,idCode.toUpperCase());

            statementEx.setString(1, String.valueOf(marks));
            statementEx.setString(2,marksE.toUpperCase());
            statementEx.setString(3,idCode.toUpperCase());

            statementEx.execute();
            preparedStatement.execute();
            connection.close();
            loadData();

        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public void ex3t2Update(TableColumn.CellEditEvent cellEditEvent){

        marksData tableDataSelected = tableMarks.getSelectionModel().getSelectedItem();
        int marks= Integer.parseInt(tableDataSelected.setEx3t2(cellEditEvent.getNewValue().toString().toUpperCase()));
        int ex1 = Integer.parseInt(tableDataSelected.getEx1t2());
        int ex2 = Integer.parseInt(tableDataSelected.getEx2t2());
        int ex3 = Integer.parseInt(tableDataSelected.getEx3t2());
        float avg = Math.round((ex1+ex2+ex3)/3);
        String idCode=tableDataSelected.getId();

        String sql= "UPDATE tbl_f2_eng SET ex6=?,g6=? WHERE id=?";
        String sqlGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='ENGLISH'";
        String sqlAvg = "UPDATE tbl_f2_t2_avg SET eng=?,engg=? WHERE id=?";
        String sqlEx = "UPDATE tbl_f2_t2_ex3 SET eng=?,engg=? WHERE id=?";

        try{
            Connection connection = Database.DBConnection.getConnection();
            PreparedStatement preparedStatement =connection.prepareStatement(sql);
            PreparedStatement statementEx =connection.prepareStatement(sqlEx);
            PreparedStatement preparedStatementAvg =connection.prepareStatement(sqlAvg);
            ResultSet set = connection.createStatement().executeQuery(sqlGrade);
            String marksE = "";
            if (marks >= Integer.parseInt(set.getString(4))) {marksE = "A"; } else if (marks >= Integer.parseInt(set.getString(5))) { marksE = "A-"; }else if (marks >=Integer.parseInt(set.getString(6))){ marksE = "B+";}else if (marks >=Integer.parseInt(set.getString(7))){
                marksE = "B"; }else if (marks >=Integer.parseInt(set.getString(8))){  marksE = "B-"; }else if (marks >=Integer.parseInt(set.getString(9))){ marksE = "C+"; }else if (marks >=Integer.parseInt(set.getString(10))){ marksE = "C";
            }else if (marks >=Integer.parseInt(set.getString(11))){ marksE = "C-";}else if (marks >=Integer.parseInt(set.getString(12))){ marksE = "D+";}else if (marks >=Integer.parseInt(set.getString(13))){ marksE = "D";}else if (marks >=Integer.parseInt(set.getString(14))){
                marksE = "D-";}else {marksE="E"; }

            String g = "";
            if (avg >= Integer.parseInt(set.getString(4))) {g = "A"; } else if (avg >= Integer.parseInt(set.getString(5))) { g = "A-"; }else if (avg >=Integer.parseInt(set.getString(6))){ g = "B+";}else if (avg >=Integer.parseInt(set.getString(7))){
                g = "B"; }else if (avg >=Integer.parseInt(set.getString(8))){  g = "B-"; }else if (avg >=Integer.parseInt(set.getString(9))){ g = "C+"; }else if (avg >=Integer.parseInt(set.getString(10))){ g = "C";
            }else if (avg >=Integer.parseInt(set.getString(11))){ g = "C-";}else if (avg >=Integer.parseInt(set.getString(12))){ g = "D+";}else if (avg >=Integer.parseInt(set.getString(13))){ g = "D";}else if (avg >=Integer.parseInt(set.getString(14))){
                g = "D-";}else {g="E"; }

            preparedStatement.setString(1, String.valueOf(marks));
            preparedStatement.setString(2,marksE.toUpperCase());
            preparedStatement.setString(3,idCode.toUpperCase());

            preparedStatementAvg.setString(1,String.valueOf(String.format("%.0f",avg)));
            preparedStatementAvg.setString(2,g.toUpperCase());
            preparedStatementAvg.setString(3,idCode.toUpperCase());

            statementEx.setString(1, String.valueOf(marks));
            statementEx.setString(2,marksE.toUpperCase());
            statementEx.setString(3,idCode.toUpperCase());

            statementEx.execute();
            preparedStatement.execute();
            preparedStatementAvg.execute();
            connection.close();
            loadData();

        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public void ex1t3Update(TableColumn.CellEditEvent cellEditEvent){

        marksData tableDataSelected = tableMarks.getSelectionModel().getSelectedItem();
        int marks= Integer.parseInt(tableDataSelected.setEx1t3(cellEditEvent.getNewValue().toString().toUpperCase()));
        String idCode=tableDataSelected.getId();

        String sql= "UPDATE tbl_f2_eng SET ex7=?,g7=? WHERE id=?";
        String sqlGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='ENGLISH'";
        String sqlEx = "UPDATE tbl_f2_t3_ex1 SET eng=?,engg=? WHERE id=?";

        try{
            Connection connection = Database.DBConnection.getConnection();
            PreparedStatement preparedStatement =connection.prepareStatement(sql);
            PreparedStatement statementEx =connection.prepareStatement(sqlEx);
            ResultSet set = connection.createStatement().executeQuery(sqlGrade);
            String marksE = "";
            if (marks >= Integer.parseInt(set.getString(4))) {marksE = "A"; } else if (marks >= Integer.parseInt(set.getString(5))) { marksE = "A-"; }else if (marks >=Integer.parseInt(set.getString(6))){ marksE = "B+";}else if (marks >=Integer.parseInt(set.getString(7))){
                marksE = "B"; }else if (marks >=Integer.parseInt(set.getString(8))){  marksE = "B-"; }else if (marks >=Integer.parseInt(set.getString(9))){ marksE = "C+"; }else if (marks >=Integer.parseInt(set.getString(10))){ marksE = "C";
            }else if (marks >=Integer.parseInt(set.getString(11))){ marksE = "C-";}else if (marks >=Integer.parseInt(set.getString(12))){ marksE = "D+";}else if (marks >=Integer.parseInt(set.getString(13))){ marksE = "D";}else if (marks >=Integer.parseInt(set.getString(14))){
                marksE = "D-";}else {marksE="E"; }

            preparedStatement.setString(1, String.valueOf(marks));
            preparedStatement.setString(2,marksE.toUpperCase());
            preparedStatement.setString(3,idCode.toUpperCase());

            statementEx.setString(1, String.valueOf(marks));
            statementEx.setString(2,marksE.toUpperCase());
            statementEx.setString(3,idCode.toUpperCase());

            statementEx.execute();
            preparedStatement.execute();
            connection.close();
            loadData();

        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public void ex2t3Update(TableColumn.CellEditEvent cellEditEvent){

        marksData tableDataSelected = tableMarks.getSelectionModel().getSelectedItem();
        int marks= Integer.parseInt(tableDataSelected.setEx2t3(cellEditEvent.getNewValue().toString().toUpperCase()));
        String idCode=tableDataSelected.getId();

        String sql= "UPDATE tbl_f2_eng SET ex8=?,g8=? WHERE id=?";
        String sqlGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='ENGLISH'";
        String sqlEx = "UPDATE tbl_f2_t3_ex2 SET eng=?,engg=? WHERE id=?";

        try{
            Connection connection = Database.DBConnection.getConnection();
            PreparedStatement preparedStatement =connection.prepareStatement(sql);
            PreparedStatement statementEx =connection.prepareStatement(sqlEx);
            ResultSet set = connection.createStatement().executeQuery(sqlGrade);
            String marksE = "";
            if (marks >= Integer.parseInt(set.getString(4))) {marksE = "A"; } else if (marks >= Integer.parseInt(set.getString(5))) { marksE = "A-"; }else if (marks >=Integer.parseInt(set.getString(6))){ marksE = "B+";}else if (marks >=Integer.parseInt(set.getString(7))){
                marksE = "B"; }else if (marks >=Integer.parseInt(set.getString(8))){  marksE = "B-"; }else if (marks >=Integer.parseInt(set.getString(9))){ marksE = "C+"; }else if (marks >=Integer.parseInt(set.getString(10))){ marksE = "C";
            }else if (marks >=Integer.parseInt(set.getString(11))){ marksE = "C-";}else if (marks >=Integer.parseInt(set.getString(12))){ marksE = "D+";}else if (marks >=Integer.parseInt(set.getString(13))){ marksE = "D";}else if (marks >=Integer.parseInt(set.getString(14))){
                marksE = "D-";}else {marksE="E"; }

            preparedStatement.setString(1, String.valueOf(marks));
            preparedStatement.setString(2,marksE.toUpperCase());
            preparedStatement.setString(3,idCode.toUpperCase());

            statementEx.setString(1, String.valueOf(marks));
            statementEx.setString(2,marksE.toUpperCase());
            statementEx.setString(3,idCode.toUpperCase());

            statementEx.execute();
            preparedStatement.execute();
            connection.close();
            loadData();

        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public void ex3t3Update(TableColumn.CellEditEvent cellEditEvent){

        marksData tableDataSelected = tableMarks.getSelectionModel().getSelectedItem();
        int marks= Integer.parseInt(tableDataSelected.setEx3t3(cellEditEvent.getNewValue().toString().toUpperCase()));
        int ex1 = Integer.parseInt(tableDataSelected.getEx1t3());
        int ex2 = Integer.parseInt(tableDataSelected.getEx2t3());
        int ex3 = Integer.parseInt(tableDataSelected.getEx3t3());
        float avg = Math.round((ex1+ex2+ex3)/3);
        String idCode=tableDataSelected.getId();

        String sql= "UPDATE tbl_f2_eng SET ex9=?,g9=? WHERE id=?";
        String sqlGrade = "SELECT * FROM tbl_grades WHERE class='FORM_1' AND subject='ENGLISH'";
        String sqlAvg = "UPDATE tbl_f2_t3_avg SET eng=?,engg=? WHERE id=?";
        String sqlEx = "UPDATE tbl_f2_t3_ex3 SET eng=?,engg=? WHERE id=?";

        try{
            Connection connection = Database.DBConnection.getConnection();
            PreparedStatement preparedStatement =connection.prepareStatement(sql);
            PreparedStatement statementEx =connection.prepareStatement(sqlEx);
            PreparedStatement preparedStatementAvg =connection.prepareStatement(sqlAvg);
            ResultSet set = connection.createStatement().executeQuery(sqlGrade);
            String marksE = "";
            if (marks >= Integer.parseInt(set.getString(4))) {marksE = "A"; } else if (marks >= Integer.parseInt(set.getString(5))) { marksE = "A-"; }else if (marks >=Integer.parseInt(set.getString(6))){ marksE = "B+";}else if (marks >=Integer.parseInt(set.getString(7))){
                marksE = "B"; }else if (marks >=Integer.parseInt(set.getString(8))){  marksE = "B-"; }else if (marks >=Integer.parseInt(set.getString(9))){ marksE = "C+"; }else if (marks >=Integer.parseInt(set.getString(10))){ marksE = "C";
            }else if (marks >=Integer.parseInt(set.getString(11))){ marksE = "C-";}else if (marks >=Integer.parseInt(set.getString(12))){ marksE = "D+";}else if (marks >=Integer.parseInt(set.getString(13))){ marksE = "D";}else if (marks >=Integer.parseInt(set.getString(14))){
                marksE = "D-";}else {marksE="E"; }

            String g = "";
            if (avg >= Integer.parseInt(set.getString(4))) {g = "A"; } else if (avg >= Integer.parseInt(set.getString(5))) { g = "A-"; }else if (avg >=Integer.parseInt(set.getString(6))){ g = "B+";}else if (avg >=Integer.parseInt(set.getString(7))){
                g = "B"; }else if (avg >=Integer.parseInt(set.getString(8))){  g = "B-"; }else if (avg >=Integer.parseInt(set.getString(9))){ g = "C+"; }else if (avg >=Integer.parseInt(set.getString(10))){ g = "C";
            }else if (avg >=Integer.parseInt(set.getString(11))){ g = "C-";}else if (avg >=Integer.parseInt(set.getString(12))){ g = "D+";}else if (avg >=Integer.parseInt(set.getString(13))){ g = "D";}else if (avg >=Integer.parseInt(set.getString(14))){
                g = "D-";}else {g="E"; }

            preparedStatement.setString(1, String.valueOf(marks));
            preparedStatement.setString(2,marksE.toUpperCase());
            preparedStatement.setString(3,idCode.toUpperCase());

            preparedStatementAvg.setString(1,String.valueOf(String.format("%.0f",avg)));
            preparedStatementAvg.setString(2,g.toUpperCase());
            preparedStatementAvg.setString(3,idCode.toUpperCase());

            statementEx.setString(1, String.valueOf(marks));
            statementEx.setString(2,marksE.toUpperCase());
            statementEx.setString(3,idCode.toUpperCase());

            statementEx.execute();
            preparedStatement.execute();
            preparedStatementAvg.execute();
            connection.close();
            loadData();

        }catch (SQLException e){
            e.printStackTrace();
        }


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadData();

        tableMarks.setEditable(true);
        term1Exam1Column.setCellFactory(TextFieldTableCell.forTableColumn());
        term1Exam2Column.setCellFactory(TextFieldTableCell.forTableColumn());
        term1Exam3Column.setCellFactory(TextFieldTableCell.forTableColumn());

        term2Exam1Column.setCellFactory(TextFieldTableCell.forTableColumn());
        term2Exam2Column.setCellFactory(TextFieldTableCell.forTableColumn());
        term2Exam3Column.setCellFactory(TextFieldTableCell.forTableColumn());

        term3Exam1Column.setCellFactory(TextFieldTableCell.forTableColumn());
        term3Exam2Column.setCellFactory(TextFieldTableCell.forTableColumn());
        term3Exam3Column.setCellFactory(TextFieldTableCell.forTableColumn());

    }
}
