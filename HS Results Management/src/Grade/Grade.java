package Grade;

import Users.loginOption;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import static Alerts.informationBox.infoBox;
import static Alerts.informationBox.infoBoxError;

public class Grade implements Initializable {

    @FXML private ComboBox<classParam> classCB;
    @FXML private ComboBox<subjectParam> subjectCB;
    @FXML private TextField a,aminus,bplus,b,bminus,cplus,c,cminus,dplus,d,dminus,e;
    @FXML private TableView<gradesData> tableGrades;
    @FXML private TableColumn<gradesData,String> classColumn,subjectColumn,aColumn,aMinusColumn,bPlusColumn,bColumn,bMinusColumn,cPlusColumn,cColumn,cMinusColumn,dPlusColumn,dColumn,dMinusColumn,eColumn;
    private ObservableList<gradesData> tableList;
    @FXML private TextField aComment,aMinusComment,bPlusComment,bComment,bMinusComment,cPlusComment,cComment,cMinusComment,dPlusComment,dComment,dMinusComment,eComment;

    public void insertGrades(){
        String sql ="INSERT INTO tbl_grades(class,subject,a,aminus,bplus,b,bminus,cplus,c,cminus,dplus,d,dminus,e)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        String sqlCheck = "SELECT * FROM tbl_grades WHERE class=? AND subject=?";
        if(((subjectParam)this.subjectCB.getValue()).equals("")||((classParam)this.classCB.getValue()).equals("")||a.getText().equals("")||aminus.getText().equals("")||bplus.getText().equals("")||b.getText().equals("")||bminus.getText().equals("")||cplus.getText().equals("")||c.getText().equals("")||cminus.getText().equals("")||dplus.getText().equals("")||d.getText().equals("")||dminus.getText().equals("")||e.getText().equals("")){
            infoBoxError("All fields must be filled","Error","Empty fields");
        }else {
            try {
                Connection connection = Database.DBConnection.getConnection();
                ResultSet set = null;
                PreparedStatement statementCheck = connection.prepareStatement(sqlCheck);
                statementCheck.setString(1,classCB.getValue().toString().toUpperCase());
                statementCheck.setString(2,subjectCB.getValue().toString().toUpperCase());
                set = statementCheck.executeQuery();
                int Count = 0;
                while (set.next()){
                    Count++;
                    if(Count > 0 ){
                        infoBoxError("The class and subject already exist","Error","Duplicate");
                        connection.close();
                        clearTextFileds();
                    }
                }
                PreparedStatement statement =connection.prepareStatement(sql);
                statement.setString(1,classCB.getValue().toString().toUpperCase());
                statement.setString(2,subjectCB.getValue().toString().toUpperCase());
                statement.setString(3,a.getText().toUpperCase());
                statement.setString(4,aminus.getText().toUpperCase());
                statement.setString(5,bplus.getText().toUpperCase());
                statement.setString(6,b.getText().toUpperCase());
                statement.setString(7,bminus.getText().toUpperCase());
                statement.setString(8,cplus.getText().toUpperCase());
                statement.setString(9,c.getText().toUpperCase());
                statement.setString(10,cminus.getText().toUpperCase());
                statement.setString(11,dplus.getText().toUpperCase());
                statement.setString(12,d.getText().toUpperCase());
                statement.setString(13,dminus.getText().toUpperCase());
                statement.setString(14,e.getText().toUpperCase());
                statement.execute();
                clearTextFileds();
                infoBox("Data has been inserted","Success",null);
                connection.close();
                loadData();

            } catch (Exception e) {
                infoBoxError("An error occurred", "Error", null);
            }
        }
    }

    public void clearTextFileds(){
        a.clear();
        aminus.clear();
        bplus.clear();
        b.clear();
        bminus.clear();
        cplus.clear();
        c.clear();
        cminus.clear();
        dplus.clear();
        d.clear();
        dminus.clear();
        e.clear();
        classCB.setPromptText("--select class--");
        subjectCB.setPromptText("--select subject--");
      }

    public void loadData(){
        String sql = "SELECT * FROM tbl_grades";
        try{
            Connection connection = Database.DBConnection.getConnection();
            this.tableList= FXCollections.observableArrayList();
            ResultSet set = connection.createStatement().executeQuery(sql);
            while (set.next()){
                this.tableList.addAll(new gradesData(set.getString(1),set.getString(2),set.getString(3),set.getString(4),set.getString(5),set.getString(6),set.getString(7),set.getString(8),set.getString(9),set.getString(10),set.getString(11),set.getString(12),set.getString(13),set.getString(14),set.getString(15)));
            }
            this.classColumn.setCellValueFactory(new PropertyValueFactory<gradesData,String>("classs"));
            this.subjectColumn.setCellValueFactory(new PropertyValueFactory<gradesData,String>("subject"));
            this.aColumn.setCellValueFactory(new PropertyValueFactory<gradesData,String>("a"));
            this.aMinusColumn.setCellValueFactory(new PropertyValueFactory<gradesData,String>("aminus"));
            this.bPlusColumn.setCellValueFactory(new PropertyValueFactory<gradesData,String>("bplus"));
            this.bColumn.setCellValueFactory(new PropertyValueFactory<gradesData,String>("b"));
            this.bMinusColumn.setCellValueFactory(new PropertyValueFactory<gradesData,String>("bminus"));
            this.cPlusColumn.setCellValueFactory(new PropertyValueFactory<gradesData,String>("cplus"));
            this.cColumn.setCellValueFactory(new PropertyValueFactory<gradesData,String>("c"));
            this.cMinusColumn.setCellValueFactory(new PropertyValueFactory<gradesData,String>("cminus"));
            this.dPlusColumn.setCellValueFactory(new PropertyValueFactory<gradesData,String>("dplus"));
            this.dColumn.setCellValueFactory(new PropertyValueFactory<gradesData,String>("d"));
            this.dMinusColumn.setCellValueFactory(new PropertyValueFactory<gradesData,String>("dminus"));
            this.eColumn.setCellValueFactory(new PropertyValueFactory<gradesData,String>("e"));

            this.tableGrades.setItems(null);
            this.tableGrades.setItems(this.tableList);

        }catch (Exception e){
            infoBoxError("An error occurred " + e,"Error",null);
        }
    }

    public void setEdit(){
        gradesData gradesdata = tableGrades.getSelectionModel().getSelectedItem();
        classCB.setValue(classParam.fromvalue(gradesdata.getClasss()));
        subjectCB.setValue(subjectParam.fromvalue(gradesdata.getSubject()));
        a.setText(gradesdata.getA());
        aminus.setText(gradesdata.getAminus());
        bplus.setText(gradesdata.getBplus());
        b.setText(gradesdata.getB());
        bminus.setText(gradesdata.getBminus());
        cplus.setText(gradesdata.getCplus());
        c.setText(gradesdata.getC());
        cminus.setText(gradesdata.getCminus());
        dplus.setText(gradesdata.getDplus());
        d.setText(gradesdata.getD());
        dminus.setText(gradesdata.getDminus());
        e.setText(gradesdata.getE());

    }

    public void updateData(){
        String sql = "UPDATE tbl_grades SET class=?,subject=?,A=?,Aminus=?,Bplus=?,B=?,Bminus=?,Cplus=?,C=?,Cminus=?,Dplus=?,D=?,Dminus=?,E=? WHERE id=? ";
        try{
            if(((subjectParam)this.subjectCB.getValue()).equals("")||((classParam)this.classCB.getValue()).equals("")||a.getText().equals("")||aminus.getText().equals("")||bplus.getText().equals("")||b.getText().equals("")||bminus.getText().equals("")||cplus.getText().equals("")||c.getText().equals("")||cminus.getText().equals("")||dplus.getText().equals("")||d.getText().equals("")||dminus.getText().equals("")||e.getText().equals("")){
                infoBoxError("All fields must be filled","Error","Empty fields");
            }else {
                Connection connection = Database.DBConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
                gradesData gradesdata = tableGrades.getSelectionModel().getSelectedItem();

                statement.setString(1,classCB.getValue().toString().toUpperCase());
                statement.setString(2,subjectCB.getValue().toString().toUpperCase());
                statement.setString(3,a.getText().toUpperCase());
                statement.setString(4,aminus.getText().toUpperCase());
                statement.setString(5,bplus.getText().toUpperCase());
                statement.setString(6,b.getText().toUpperCase());
                statement.setString(7,bminus.getText().toUpperCase());
                statement.setString(8,cplus.getText().toUpperCase());
                statement.setString(9,c.getText().toUpperCase());
                statement.setString(10,cminus.getText().toUpperCase());
                statement.setString(11,dplus.getText().toUpperCase());
                statement.setString(12,d.getText().toUpperCase());
                statement.setString(13,dminus.getText().toUpperCase());
                statement.setString(14,e.getText().toUpperCase());
                statement.setString(15,gradesdata.getId().toUpperCase());

                statement.execute();
                connection.close();
                clearTextFileds();
                infoBox("Grades were updated successfully","Success",null);
                loadData();
            }
        }catch (Exception e){
            infoBoxError("An error occurred " + e,"Error",null);
        }
    }

    public void setComments(){
        if (this.aComment.getText().equals("")||this.aMinusComment.getText().equals("")||this.bPlusComment.getText().equals("")||this.bComment.getText().equals("")||this.bMinusComment.getText().equals("")||this.cPlusComment.getText().equals("")||this.cComment.getText().equals("")||this.cMinusComment.getText().equals("")||this.dPlusComment.getText().equals("")||this.dComment.getText().equals("")||this.dMinusComment.getText().equals("")||this.eComment.getText().equals("")){
            infoBoxError("All fields must be filled","Error","Empty fields");
        }else {
            try{
                String sql = "INSERT INTO tbl_comments(a,aMinus,bPlus,b,bMinus,cPlus,c,cMinus,dPlus,d,dMinus,e)VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
                Connection connection = Database.DBConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1,aComment.getText().toString());
                statement.setString(2,aMinusComment.getText().toString());
                statement.setString(3,bPlusComment.getText().toString());
                statement.setString(4,bComment.getText().toString());
                statement.setString(5,bMinusComment.getText().toString());
                statement.setString(6,cPlusComment.getText().toString());
                statement.setString(7,cComment.getText().toString());
                statement.setString(8,cMinusComment.getText().toString());
                statement.setString(9,dPlusComment.getText().toString());
                statement.setString(10,dComment.getText().toString());
                statement.setString(11,dMinusComment.getText().toString());
                statement.setString(12,eComment.getText().toString());

                statement.execute();
                infoBox("Comments set successfully","Success",null);
                connection.close();

            }catch (Exception e){
                infoBoxError("An error occurred " + e,"Error",null);
            }
        }
    }

    public void updateComments(){
        if (this.aComment.getText().equals("")||this.aMinusComment.getText().equals("")||this.bPlusComment.getText().equals("")||this.bComment.getText().equals("")||this.bMinusComment.getText().equals("")||this.cPlusComment.getText().equals("")||this.cComment.getText().equals("")||this.cMinusComment.getText().equals("")||this.dPlusComment.getText().equals("")||this.dComment.getText().equals("")||this.dMinusComment.getText().equals("")||this.eComment.getText().equals("")){
            infoBoxError("All fields must be filled","Error","Empty fields");
        }else {
            try{
                String sql = "UPDATE tbl_comments SET a=?,aMinus=?,bPlus=?,b=?,bMinus=?,cPlus=?,c=?,cMinus=?,dPlus=?,d=?,dMinus=?,e=? WHERE id=?";
                Connection connection = Database.DBConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1,aComment.getText().toString());
                statement.setString(2,aMinusComment.getText().toString());
                statement.setString(3,bPlusComment.getText().toString());
                statement.setString(4,bComment.getText().toString());
                statement.setString(5,bMinusComment.getText().toString());
                statement.setString(6,cPlusComment.getText().toString());
                statement.setString(7,cComment.getText().toString());
                statement.setString(8,cMinusComment.getText().toString());
                statement.setString(9,dPlusComment.getText().toString());
                statement.setString(10,dComment.getText().toString());
                statement.setString(11,dMinusComment.getText().toString());
                statement.setString(12,eComment.getText().toString());
                int id = 1;
                statement.setString(13, String.valueOf(id));

                statement.execute();
                infoBox("Comments set successfully","Success",null);
                connection.close();

            }catch (Exception e){
                infoBoxError("An error occurred " + e,"Error",null);
            }
        }
    }

    public void loadComments(){
        String sql = "SELECT * FROM tbl_comments";
        try{
            Connection connection = Database.DBConnection.getConnection();
            ResultSet set = connection.createStatement().executeQuery(sql);
           aComment.setText(set.getString(2));
           aMinusComment.setText(set.getString(3));
           bPlusComment.setText(set.getString(4));
           bComment.setText(set.getString(5));
           bMinusComment.setText(set.getString(6));
           cPlusComment.setText(set.getString(7));
           cComment.setText(set.getString(8));
           cMinusComment.setText(set.getString(9));
           dPlusComment.setText(set.getString(10));
           dComment.setText(set.getString(11));
           dMinusComment.setText(set.getString(12));
           eComment.setText(set.getString(13));

        }catch (Exception e){
            infoBoxError("An error occurred " + e,"Error",null);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.classCB.setItems(FXCollections.observableArrayList(classParam.values()));
        this.subjectCB.setItems(FXCollections.observableArrayList(subjectParam.values()));
        loadData();
        loadComments();
    }
}
