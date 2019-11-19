package grade;

import F1.classlist.Password;
import F1.classlist.ShowClasslist;
import F1.exams.MarksEntry;
import about.About;
import backup.ManualBackup;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import start.DatabaseSync;
import students.StudentUpdated;
import students.SubjectSelection;
import teacher.Teacher;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class Grade implements Initializable {

    @FXML private ComboBox<classParam> classCB;
    @FXML private ComboBox<subjectParam> subjectCB;
    @FXML private TextField a,aminus,bplus,b,bminus,cplus,c,cminus,dplus,d,dminus,e;
    @FXML private TableView<gradesData> tableGrades;
    @FXML private TableColumn<gradesData,String> classColumn,subjectColumn,aColumn,aMinusColumn,bPlusColumn,bColumn,bMinusColumn,cPlusColumn,cColumn,cMinusColumn,dPlusColumn,dColumn,dMinusColumn,eColumn;
    private ObservableList<gradesData> tableList;
    @FXML private TextField aComment,aMinusComment,bPlusComment,bComment,bMinusComment,cPlusComment,cComment,cMinusComment,dPlusComment,dComment,dMinusComment,eComment;
    @FXML
    private AnchorPane windowCurrent;

    public void insertGrades(){
        String sql ="INSERT INTO tbl_grades(class,subject,a,aminus,bplus,b,bminus,cplus,c,cminus,dplus,d,dminus,e)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        String sqlCheck = "SELECT * FROM tbl_grades WHERE class=? AND subject=?";
        if(((subjectParam)this.subjectCB.getValue()).equals("")||((classParam)this.classCB.getValue()).equals("")||a.getText().equals("")||aminus.getText().equals("")||bplus.getText().equals("")||b.getText().equals("")||bminus.getText().equals("")||cplus.getText().equals("")||c.getText().equals("")||cminus.getText().equals("")||dplus.getText().equals("")||d.getText().equals("")||dminus.getText().equals("")||e.getText().equals("")){
            System.out.println("All fields must be filled");
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
                        System.out.println("The class and subject already exist");
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
                System.out.println("Data has been inserted");
                connection.close();
                loadData();

            } catch (Exception e) {
                e.printStackTrace();
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
            e.printStackTrace();
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
                System.out.println("All fields must be filled");
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
                System.out.println("Grades were updated successfully");
                loadData();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void setComments(){
        if (this.aComment.getText().equals("")||this.aMinusComment.getText().equals("")||this.bPlusComment.getText().equals("")||this.bComment.getText().equals("")||this.bMinusComment.getText().equals("")||this.cPlusComment.getText().equals("")||this.cComment.getText().equals("")||this.cMinusComment.getText().equals("")||this.dPlusComment.getText().equals("")||this.dComment.getText().equals("")||this.dMinusComment.getText().equals("")||this.eComment.getText().equals("")){
            System.out.println("All fields must be filled");
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
                System.out.println("Comments set successfully");
                connection.close();

            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public void updateComments(){
        if (this.aComment.getText().equals("")||this.aMinusComment.getText().equals("")||this.bPlusComment.getText().equals("")||this.bComment.getText().equals("")||this.bMinusComment.getText().equals("")||this.cPlusComment.getText().equals("")||this.cComment.getText().equals("")||this.cMinusComment.getText().equals("")||this.dPlusComment.getText().equals("")||this.dComment.getText().equals("")||this.dMinusComment.getText().equals("")||this.eComment.getText().equals("")){
            System.out.println("All fields must be filled");
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
                System.out.println("Comments set successfully");
                connection.close();

            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public void loadComments(){
        String sql = "SELECT * FROM tbl_comments";
        try{
            Connection connection = Database.DBConnection.getConnection();
            ResultSet set = connection.createStatement().executeQuery(sql);
            while (set.next()) {
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
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.classCB.setItems(FXCollections.observableArrayList(classParam.values()));
        this.subjectCB.setItems(FXCollections.observableArrayList(subjectParam.values()));
        loadData();
        loadComments();
    }


    @FXML void openF4T1Avg(){
        ShowClasslist showClasslist = new ShowClasslist();
        showClasslist.dbTableName="tbl_f4_t1_avg";
        showClasslist.dbClassName="FORM_4";
        showClasslist.schName="WAVES ACADEMY LTD";
        showClasslist.clsName="Form 4";
        showClasslist.tmName="Term 1";
        showClasslist.exName="Exam Avg";
        showClasslist.currentSetting="F4T1AVG";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/classlist/showClasslist.fxml"));
            Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
            stage.getIcons().add(applicationIcon);

            ShowClasslist showClasslist1 = (ShowClasslist) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 4 TERM 1 AVERAGE");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML void openF4T1Ex1(){
        ShowClasslist showClasslist = new ShowClasslist();
        showClasslist.dbTableName="tbl_f4_t1_ex1";
        showClasslist.dbClassName="FORM_4";
        showClasslist.schName="WAVES ACADEMY LTD";
        showClasslist.clsName="Form 4";
        showClasslist.tmName="Term 1";
        showClasslist.exName="Exam 1";
        showClasslist.currentSetting="F4T1E1";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/classlist/showClasslist.fxml"));
            Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
            stage.getIcons().add(applicationIcon);

            ShowClasslist showClasslist3 = (ShowClasslist) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 4 TERM 1 EXAM 1");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML void openF4T1Ex2(){
        ShowClasslist showClasslist = new ShowClasslist();
        showClasslist.dbTableName="tbl_f4_t1_ex2";
        showClasslist.dbClassName="FORM_4";
        showClasslist.schName="WAVES ACADEMY LTD";
        showClasslist.clsName="Form 4";
        showClasslist.tmName="Term 1";
        showClasslist.exName="Exam 2";
        showClasslist.currentSetting="F4T1E2";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/classlist/showClasslist.fxml"));
            Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
            stage.getIcons().add(applicationIcon);

            ShowClasslist showClasslist3 = (ShowClasslist) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 4 TERM 1 EXAM 2");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML void openF4T1Ex3(){
        ShowClasslist showClasslist = new ShowClasslist();
        showClasslist.dbTableName="tbl_f4_t1_ex3";
        showClasslist.dbClassName="FORM_4";
        showClasslist.schName="WAVES ACADEMY LTD";
        showClasslist.clsName="Form 4";
        showClasslist.tmName="Term 1";
        showClasslist.exName="Exam 3";
        showClasslist.currentSetting="F4T1E3";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/classlist/showClasslist.fxml"));
            Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
            stage.getIcons().add(applicationIcon);

            ShowClasslist showClasslist3 = (ShowClasslist) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 4 TERM 1 EXAM 3");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML void openF4T2Avg(){
        ShowClasslist showClasslist = new ShowClasslist();
        showClasslist.dbTableName="tbl_f4_t2_avg";
        showClasslist.dbClassName="FORM_4";
        showClasslist.schName="WAVES ACADEMY LTD";
        showClasslist.clsName="Form 4";
        showClasslist.tmName="Term 2";
        showClasslist.exName="Exam Avg";
        showClasslist.currentSetting="F4T2AVG";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/classlist/showClasslist.fxml"));
            Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
            stage.getIcons().add(applicationIcon);

            ShowClasslist showClasslist3 = (ShowClasslist) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 4 TERM 2 AVERAGE");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML void openF4T2Ex1(){
        ShowClasslist showClasslist = new ShowClasslist();
        showClasslist.dbTableName="tbl_f4_t2_ex1";
        showClasslist.dbClassName="FORM_4";
        showClasslist.schName="WAVES ACADEMY LTD";
        showClasslist.clsName="Form 4";
        showClasslist.tmName="Term 2";
        showClasslist.exName="Exam 1";
        showClasslist.currentSetting="F4T2E1";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/classlist/showClasslist.fxml"));
            Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
            stage.getIcons().add(applicationIcon);

            ShowClasslist showClasslist3 = (ShowClasslist) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 4 TERM 2 EXAM 1");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML void openF4T2Ex2(){
        ShowClasslist showClasslist = new ShowClasslist();
        showClasslist.dbTableName="tbl_f4_t2_ex2";
        showClasslist.dbClassName="FORM_4";
        showClasslist.schName="WAVES ACADEMY LTD";
        showClasslist.clsName="Form 4";
        showClasslist.tmName="Term 2";
        showClasslist.exName="Exam 2";
        showClasslist.currentSetting="F4T2E2";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/classlist/showClasslist.fxml"));
            Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
            stage.getIcons().add(applicationIcon);

            ShowClasslist showClasslist3 = (ShowClasslist) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 4 TERM 2 EXAM 2");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML void openF4T2Ex3(){
        ShowClasslist showClasslist = new ShowClasslist();
        showClasslist.dbTableName="tbl_f4_t2_ex3";
        showClasslist.dbClassName="FORM_4";
        showClasslist.schName="WAVES ACADEMY LTD";
        showClasslist.clsName="Form 4";
        showClasslist.tmName="Term 2";
        showClasslist.exName="Exam 3";
        showClasslist.currentSetting="F4T2E3";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/classlist/showClasslist.fxml"));
            Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
            stage.getIcons().add(applicationIcon);

            ShowClasslist showClasslist3 = (ShowClasslist) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 4 TERM 2 EXAM 3");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML void openF4T3Avg(){
        ShowClasslist showClasslist = new ShowClasslist();
        showClasslist.dbTableName="tbl_f4_t3_avg";
        showClasslist.dbClassName="FORM_4";
        showClasslist.schName="WAVES ACADEMY LTD";
        showClasslist.clsName="Form 4";
        showClasslist.tmName="Term 3";
        showClasslist.exName="Exam Avg";
        showClasslist.currentSetting="F4T3AVG";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/classlist/showClasslist.fxml"));
            Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
            stage.getIcons().add(applicationIcon);

            ShowClasslist showClasslist3 = (ShowClasslist) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 4 TERM 3 AVERAGE");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML void openF4T3Ex1(){
        ShowClasslist showClasslist = new ShowClasslist();
        showClasslist.dbTableName="tbl_f4_t3_ex1";
        showClasslist.dbClassName="FORM_4";
        showClasslist.schName="WAVES ACADEMY LTD";
        showClasslist.clsName="Form 4";
        showClasslist.tmName="Term 3";
        showClasslist.exName="Exam 1";
        showClasslist.currentSetting="F4T3E3";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/classlist/showClasslist.fxml"));
            Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
            stage.getIcons().add(applicationIcon);

            ShowClasslist showClasslist3 = (ShowClasslist) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 4 TERM 3 EXAM 1");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML void openF4T3Ex2(){
        ShowClasslist showClasslist = new ShowClasslist();
        showClasslist.dbTableName="tbl_f4_t3_ex2";
        showClasslist.dbClassName="FORM_4";
        showClasslist.schName="WAVES ACADEMY LTD";
        showClasslist.clsName="Form 4";
        showClasslist.tmName="Term 3";
        showClasslist.exName="Exam 2";
        showClasslist.currentSetting="F4T3E2";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/classlist/showClasslist.fxml"));
            Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
            stage.getIcons().add(applicationIcon);

            ShowClasslist showClasslist3 = (ShowClasslist) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 4 TERM 3 EXAM 2");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML void openF4T3Ex3(){
        ShowClasslist showClasslist = new ShowClasslist();
        showClasslist.dbTableName="tbl_f4_t3_ex3";
        showClasslist.dbClassName="FORM_4";
        showClasslist.schName="WAVES ACADEMY LTD";
        showClasslist.clsName="Form 4";
        showClasslist.tmName="Term 3";
        showClasslist.exName="Exam 3";
        showClasslist.currentSetting="F4T3E3";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/classlist/showClasslist.fxml"));
            Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
            stage.getIcons().add(applicationIcon);

            ShowClasslist showClasslist3 = (ShowClasslist) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 4 TERM 3 EXAM 3");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML void openF3T1Avg(){
        ShowClasslist showClasslist = new ShowClasslist();
        showClasslist.dbTableName="tbl_f3_t1_avg";
        showClasslist.dbClassName="FORM_3";
        showClasslist.schName="WAVES ACADEMY LTD";
        showClasslist.clsName="Form 3";
        showClasslist.tmName="Term 1";
        showClasslist.exName="Exam Avg";
        showClasslist.currentSetting="F3T1AVG";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/classlist/showClasslist.fxml"));
            Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
            stage.getIcons().add(applicationIcon);

            ShowClasslist showClasslist3 = (ShowClasslist) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 3 TERM 1 AVERAGE");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML void openF3T1Ex1(){
        ShowClasslist showClasslist = new ShowClasslist();
        showClasslist.dbTableName="tbl_f3_t1_ex1";
        showClasslist.dbClassName="FORM_3";
        showClasslist.schName="WAVES ACADEMY LTD";
        showClasslist.clsName="Form 3";
        showClasslist.tmName="Term 1";
        showClasslist.exName="Exam 1";
        showClasslist.currentSetting="F3T1E1";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/classlist/showClasslist.fxml"));
            Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
            stage.getIcons().add(applicationIcon);

            ShowClasslist showClasslist3 = (ShowClasslist) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 3 TERM 1 EXAM 1");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML void openF3T1Ex2(){
        ShowClasslist showClasslist = new ShowClasslist();
        showClasslist.dbTableName="tbl_f3_t1_ex2";
        showClasslist.dbClassName="FORM_3";
        showClasslist.schName="WAVES ACADEMY LTD";
        showClasslist.clsName="Form 3";
        showClasslist.tmName="Term 1";
        showClasslist.exName="Exam 2";
        showClasslist.currentSetting="F3T1E2";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/classlist/showClasslist.fxml"));
            Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
            stage.getIcons().add(applicationIcon);

            ShowClasslist showClasslist3 = (ShowClasslist) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 3 TERM 1 EXAM 2");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML void openF3T1Ex3(){
        ShowClasslist showClasslist = new ShowClasslist();
        showClasslist.dbTableName="tbl_f3_t1_ex3";
        showClasslist.dbClassName="FORM_3";
        showClasslist.schName="WAVES ACADEMY LTD";
        showClasslist.clsName="Form 3";
        showClasslist.tmName="Term 1";
        showClasslist.exName="Exam 3";
        showClasslist.currentSetting="F3T1E3";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/classlist/showClasslist.fxml"));
            Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
            stage.getIcons().add(applicationIcon);

            ShowClasslist showClasslist3 = (ShowClasslist) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 3 TERM 1 EXAM 3");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML void openF3T2Avg(){
        ShowClasslist showClasslist = new ShowClasslist();
        showClasslist.dbTableName="tbl_f3_t2_avg";
        showClasslist.dbClassName="FORM_3";
        showClasslist.schName="WAVES ACADEMY LTD";
        showClasslist.clsName="Form 3";
        showClasslist.tmName="Term 2";
        showClasslist.exName="Exam Avg";
        showClasslist.currentSetting="F3T2AVG";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/classlist/showClasslist.fxml"));
            Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
            stage.getIcons().add(applicationIcon);

            ShowClasslist showClasslist3 = (ShowClasslist) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 3 TERM 2 AVERAGE");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML void openF3T2Ex1(){
        ShowClasslist showClasslist = new ShowClasslist();
        showClasslist.dbTableName="tbl_f3_t2_ex1";
        showClasslist.dbClassName="FORM_3";
        showClasslist.schName="WAVES ACADEMY LTD";
        showClasslist.clsName="Form 3";
        showClasslist.tmName="Term 2";
        showClasslist.exName="Exam 1";
        showClasslist.currentSetting="F3T2E1";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/classlist/showClasslist.fxml"));
            Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
            stage.getIcons().add(applicationIcon);

            ShowClasslist showClasslist3 = (ShowClasslist) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 3 TERM 2 EXAM 1");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML void openF3T2Ex2(){
        ShowClasslist showClasslist = new ShowClasslist();
        showClasslist.dbTableName="tbl_f3_t2_ex2";
        showClasslist.dbClassName="FORM_3";
        showClasslist.schName="WAVES ACADEMY LTD";
        showClasslist.clsName="Form 3";
        showClasslist.tmName="Term 2";
        showClasslist.exName="Exam 2";
        showClasslist.currentSetting="F3T2E2";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/classlist/showClasslist.fxml"));
            Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
            stage.getIcons().add(applicationIcon);

            ShowClasslist showClasslist3 = (ShowClasslist) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 3 TERM 2 EXAM 2");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML void openF3T2Ex3(){
        ShowClasslist showClasslist = new ShowClasslist();
        showClasslist.dbTableName="tbl_f3_t2_ex3";
        showClasslist.dbClassName="FORM_3";
        showClasslist.schName="WAVES ACADEMY LTD";
        showClasslist.clsName="Form 3";
        showClasslist.tmName="Term 2";
        showClasslist.exName="Exam 3";
        showClasslist.currentSetting="F3T2E3";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/classlist/showClasslist.fxml"));
            Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
            stage.getIcons().add(applicationIcon);

            ShowClasslist showClasslist3 = (ShowClasslist) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 3 TERM 2 EXAM 3");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML void openF3T3Avg(){
        ShowClasslist showClasslist = new ShowClasslist();
        showClasslist.dbTableName="tbl_f3_t3_avg";
        showClasslist.dbClassName="FORM_3";
        showClasslist.schName="WAVES ACADEMY LTD";
        showClasslist.clsName="Form 3";
        showClasslist.tmName="Term 3";
        showClasslist.exName="Exam Avg";
        showClasslist.currentSetting="F3T3AVG";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/classlist/showClasslist.fxml"));
            Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
            stage.getIcons().add(applicationIcon);

            ShowClasslist showClasslist3 = (ShowClasslist) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 3 TERM 3 AVERAGE");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML void openF3T3Ex1(){
        ShowClasslist showClasslist = new ShowClasslist();
        showClasslist.dbTableName="tbl_f3_t3_ex1";
        showClasslist.dbClassName="FORM_3";
        showClasslist.schName="WAVES ACADEMY LTD";
        showClasslist.clsName="Form 3";
        showClasslist.tmName="Term 3";
        showClasslist.exName="Exam 1";
        showClasslist.currentSetting="F3T3E3";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/classlist/showClasslist.fxml"));
            Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
            stage.getIcons().add(applicationIcon);

            ShowClasslist showClasslist3 = (ShowClasslist) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 3 TERM 3 EXAM 1");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML void openF3T3Ex2(){
        ShowClasslist showClasslist = new ShowClasslist();
        showClasslist.dbTableName="tbl_f3_t3_ex2";
        showClasslist.dbClassName="FORM_3";
        showClasslist.schName="WAVES ACADEMY LTD";
        showClasslist.clsName="Form 3";
        showClasslist.tmName="Term 3";
        showClasslist.exName="Exam 2";
        showClasslist.currentSetting="F3T3E2";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/classlist/showClasslist.fxml"));
            Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
            stage.getIcons().add(applicationIcon);

            ShowClasslist showClasslist3 = (ShowClasslist) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 3 TERM 3 EXAM 2");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML void openF3T3Ex3(){
        ShowClasslist showClasslist = new ShowClasslist();
        showClasslist.dbTableName="tbl_f3_t3_ex3";
        showClasslist.dbClassName="FORM_3";
        showClasslist.schName="WAVES ACADEMY LTD";
        showClasslist.clsName="Form 3";
        showClasslist.tmName="Term 3";
        showClasslist.exName="Exam 3";
        showClasslist.currentSetting="F3T3E3";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/classlist/showClasslist.fxml"));
            Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
            stage.getIcons().add(applicationIcon);

            ShowClasslist showClasslist3 = (ShowClasslist) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 3 TERM 3 EXAM 3");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML void openF2T1Avg(){
        ShowClasslist showClasslist = new ShowClasslist();
        showClasslist.dbTableName="tbl_f2_t1_avg";
        showClasslist.dbClassName="FORM_2";
        showClasslist.schName="WAVES ACADEMY LTD";
        showClasslist.clsName="Form 2";
        showClasslist.tmName="Term 1";
        showClasslist.exName="Exam Avg";
        showClasslist.currentSetting="F2T1AVG";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/classlist/showClasslist.fxml"));
            Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
            stage.getIcons().add(applicationIcon);

            ShowClasslist showClasslist3 = (ShowClasslist) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 2 TERM 1 AVERAGE");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML void openF2T1Ex1(){
        ShowClasslist showClasslist = new ShowClasslist();
        showClasslist.dbTableName="tbl_f2_t1_ex1";
        showClasslist.dbClassName="FORM_2";
        showClasslist.schName="WAVES ACADEMY LTD";
        showClasslist.clsName="Form 2";
        showClasslist.tmName="Term 1";
        showClasslist.exName="Exam 1";
        showClasslist.currentSetting="F2T1E1";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/classlist/showClasslist.fxml"));
            Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
            stage.getIcons().add(applicationIcon);

            ShowClasslist showClasslist3 = (ShowClasslist) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 2 TERM 1 EXAM 1");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML void openF2T1Ex2(){
        ShowClasslist showClasslist = new ShowClasslist();
        showClasslist.dbTableName="tbl_f2_t1_ex2";
        showClasslist.dbClassName="FORM_2";
        showClasslist.schName="WAVES ACADEMY LTD";
        showClasslist.clsName="Form 2";
        showClasslist.tmName="Term 1";
        showClasslist.exName="Exam 2";
        showClasslist.currentSetting="F2T1E2";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/classlist/showClasslist.fxml"));
            Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
            stage.getIcons().add(applicationIcon);

            ShowClasslist showClasslist3 = (ShowClasslist) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 2 TERM 1 EXAM 2");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML void openF2T1Ex3(){
        ShowClasslist showClasslist = new ShowClasslist();
        showClasslist.dbTableName="tbl_f2_t1_ex3";
        showClasslist.dbClassName="FORM_2";
        showClasslist.schName="WAVES ACADEMY LTD";
        showClasslist.clsName="Form 2";
        showClasslist.tmName="Term 1";
        showClasslist.exName="Exam 3";
        showClasslist.currentSetting="F2T1E3";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/classlist/showClasslist.fxml"));
            Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
            stage.getIcons().add(applicationIcon);

            ShowClasslist showClasslist3 = (ShowClasslist) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 2 TERM 1 EXAM 3");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML void openF2T2Avg(){
        ShowClasslist showClasslist = new ShowClasslist();
        showClasslist.dbTableName="tbl_f2_t2_avg";
        showClasslist.dbClassName="FORM_2";
        showClasslist.schName="WAVES ACADEMY LTD";
        showClasslist.clsName="Form 2";
        showClasslist.tmName="Term 2";
        showClasslist.exName="Exam Avg";
        showClasslist.currentSetting="F2T2AVG";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/classlist/showClasslist.fxml"));
            Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
            stage.getIcons().add(applicationIcon);

            ShowClasslist showClasslist3 = (ShowClasslist) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 2 TERM 2 AVERAGE");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML void openF2T2Ex1(){
        ShowClasslist showClasslist = new ShowClasslist();
        showClasslist.dbTableName="tbl_f2_t2_ex1";
        showClasslist.dbClassName="FORM_2";
        showClasslist.schName="WAVES ACADEMY LTD";
        showClasslist.clsName="Form 2";
        showClasslist.tmName="Term 2";
        showClasslist.exName="Exam 1";
        showClasslist.currentSetting="F2T2E1";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/classlist/showClasslist.fxml"));
            Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
            stage.getIcons().add(applicationIcon);

            ShowClasslist showClasslist3 = (ShowClasslist) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 2 TERM 2 EXAM 1");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML void openF2T2Ex2(){
        ShowClasslist showClasslist = new ShowClasslist();
        showClasslist.dbTableName="tbl_f2_t2_ex2";
        showClasslist.dbClassName="FORM_2";
        showClasslist.schName="WAVES ACADEMY LTD";
        showClasslist.clsName="Form 2";
        showClasslist.tmName="Term 2";
        showClasslist.exName="Exam 2";
        showClasslist.currentSetting="F2T2E2";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/classlist/showClasslist.fxml"));
            Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
            stage.getIcons().add(applicationIcon);

            ShowClasslist showClasslist3 = (ShowClasslist) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 2 TERM 2 EXAM 2");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML void openF2T2Ex3(){
        ShowClasslist showClasslist = new ShowClasslist();
        showClasslist.dbTableName="tbl_f2_t2_ex3";
        showClasslist.dbClassName="FORM_2";
        showClasslist.schName="WAVES ACADEMY LTD";
        showClasslist.clsName="Form 2";
        showClasslist.tmName="Term 2";
        showClasslist.exName="Exam 3";
        showClasslist.currentSetting="F2T2E3";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/classlist/showClasslist.fxml"));
            Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
            stage.getIcons().add(applicationIcon);

            ShowClasslist showClasslist3 = (ShowClasslist) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 2 TERM 2 EXAM 3");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML void openF2T3Avg(){
        ShowClasslist showClasslist = new ShowClasslist();
        showClasslist.dbTableName="tbl_f2_t3_avg";
        showClasslist.dbClassName="FORM_2";
        showClasslist.schName="WAVES ACADEMY LTD";
        showClasslist.clsName="Form 2";
        showClasslist.tmName="Term 3";
        showClasslist.exName="Exam Avg";
        showClasslist.currentSetting="F2T3AVG";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/classlist/showClasslist.fxml"));
            Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
            stage.getIcons().add(applicationIcon);

            ShowClasslist showClasslist3 = (ShowClasslist) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 2 TERM 3 AVERAGE");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML void openF2T3Ex1(){
        ShowClasslist showClasslist = new ShowClasslist();
        showClasslist.dbTableName="tbl_f2_t3_ex1";
        showClasslist.dbClassName="FORM_2";
        showClasslist.schName="WAVES ACADEMY LTD";
        showClasslist.clsName="Form 2";
        showClasslist.tmName="Term 3";
        showClasslist.exName="Exam 1";
        showClasslist.currentSetting="F2T3E3";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/classlist/showClasslist.fxml"));
            Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
            stage.getIcons().add(applicationIcon);

            ShowClasslist showClasslist3 = (ShowClasslist) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 2 TERM 3 EXAM 1");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML void openF2T3Ex2(){
        ShowClasslist showClasslist = new ShowClasslist();
        showClasslist.dbTableName="tbl_f2_t3_ex2";
        showClasslist.dbClassName="FORM_2";
        showClasslist.schName="WAVES ACADEMY LTD";
        showClasslist.clsName="Form 2";
        showClasslist.tmName="Term 3";
        showClasslist.exName="Exam 2";
        showClasslist.currentSetting="F2T3E2";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/classlist/showClasslist.fxml"));
            Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
            stage.getIcons().add(applicationIcon);

            ShowClasslist showClasslist3 = (ShowClasslist) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 2 TERM 3 EXAM 2");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML void openF2T3Ex3(){
        ShowClasslist showClasslist = new ShowClasslist();
        showClasslist.dbTableName="tbl_f2_t3_ex3";
        showClasslist.dbClassName="FORM_2";
        showClasslist.schName="WAVES ACADEMY LTD";
        showClasslist.clsName="Form 2";
        showClasslist.tmName="Term 3";
        showClasslist.exName="Exam 3";
        showClasslist.currentSetting="F2T3E3";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/classlist/showClasslist.fxml"));
            Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
            stage.getIcons().add(applicationIcon);

            ShowClasslist showClasslist3 = (ShowClasslist) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 2 TERM 3 EXAM 3");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML void openF1T1Avg(){
        ShowClasslist showClasslist = new ShowClasslist();
        showClasslist.dbTableName="tbl_f1_t1_avg";
        showClasslist.dbClassName="FORM_1";
        showClasslist.schName="WAVES ACADEMY LTD";
        showClasslist.clsName="Form 1";
        showClasslist.tmName="Term 1";
        showClasslist.exName="Exam Avg";
        showClasslist.currentSetting="F1T1AVG";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/classlist/showClasslist.fxml"));
            Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
            stage.getIcons().add(applicationIcon);

            ShowClasslist showClasslist3 = (ShowClasslist) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 1 TERM 1 AVERAGE");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML void openF1T1Ex1(){
        ShowClasslist showClasslist = new ShowClasslist();
        showClasslist.dbTableName="tbl_f1_t1_ex1";
        showClasslist.dbClassName="FORM_1";
        showClasslist.schName="WAVES ACADEMY LTD";
        showClasslist.clsName="Form 1";
        showClasslist.tmName="Term 1";
        showClasslist.exName="Exam 1";
        showClasslist.currentSetting="F1T1E1";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/classlist/showClasslist.fxml"));
            Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
            stage.getIcons().add(applicationIcon);

            ShowClasslist showClasslist3 = (ShowClasslist) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 1 TERM 1 EXAM 1");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML void openF1T1Ex2(){
        ShowClasslist showClasslist = new ShowClasslist();
        showClasslist.dbTableName="tbl_f1_t1_ex2";
        showClasslist.dbClassName="FORM_1";
        showClasslist.schName="WAVES ACADEMY LTD";
        showClasslist.clsName="Form 1";
        showClasslist.tmName="Term 1";
        showClasslist.exName="Exam 2";
        showClasslist.currentSetting="F1T1E2";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/classlist/showClasslist.fxml"));
            Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
            stage.getIcons().add(applicationIcon);

            ShowClasslist showClasslist3 = (ShowClasslist) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 1 TERM 1 EXAM 2");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML void openF1T1Ex3(){
        ShowClasslist showClasslist = new ShowClasslist();
        showClasslist.dbTableName="tbl_f1_t1_ex3";
        showClasslist.dbClassName="FORM_1";
        showClasslist.schName="WAVES ACADEMY LTD";
        showClasslist.clsName="Form 1";
        showClasslist.tmName="Term 1";
        showClasslist.exName="Exam 3";
        showClasslist.currentSetting="F1T1E3";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/classlist/showClasslist.fxml"));
            Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
            stage.getIcons().add(applicationIcon);

            ShowClasslist showClasslist3 = (ShowClasslist) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 1 TERM 1 EXAM 3");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML void openF1T2Avg(){
        ShowClasslist showClasslist = new ShowClasslist();
        showClasslist.dbTableName="tbl_f1_t2_avg";
        showClasslist.dbClassName="FORM_1";
        showClasslist.schName="WAVES ACADEMY LTD";
        showClasslist.clsName="Form 1";
        showClasslist.tmName="Term 2";
        showClasslist.exName="Exam Avg";
        showClasslist.currentSetting="F1T2AVG";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/classlist/showClasslist.fxml"));
            Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
            stage.getIcons().add(applicationIcon);

            ShowClasslist showClasslist3 = (ShowClasslist) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 1 TERM 2 AVERAGE");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML void openF1T2Ex1(){
        ShowClasslist showClasslist = new ShowClasslist();
        showClasslist.dbTableName="tbl_f1_t2_ex1";
        showClasslist.dbClassName="FORM_1";
        showClasslist.schName="WAVES ACADEMY LTD";
        showClasslist.clsName="Form 1";
        showClasslist.tmName="Term 2";
        showClasslist.exName="Exam 1";
        showClasslist.currentSetting="F1T2E1";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/classlist/showClasslist.fxml"));
            Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
            stage.getIcons().add(applicationIcon);

            ShowClasslist showClasslist3 = (ShowClasslist) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 1 TERM 2 EXAM 1");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML void openF1T2Ex2(){
        ShowClasslist showClasslist = new ShowClasslist();
        showClasslist.dbTableName="tbl_f1_t2_ex2";
        showClasslist.dbClassName="FORM_1";
        showClasslist.schName="WAVES ACADEMY LTD";
        showClasslist.clsName="Form 1";
        showClasslist.tmName="Term 2";
        showClasslist.exName="Exam 2";
        showClasslist.currentSetting="F1T2E2";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/classlist/showClasslist.fxml"));
            Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
            stage.getIcons().add(applicationIcon);

            ShowClasslist showClasslist3 = (ShowClasslist) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 1 TERM 2 EXAM 2");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML void openF1T2Ex3(){
        ShowClasslist showClasslist = new ShowClasslist();
        showClasslist.dbTableName="tbl_f1_t2_ex3";
        showClasslist.dbClassName="FORM_1";
        showClasslist.schName="WAVES ACADEMY LTD";
        showClasslist.clsName="Form 1";
        showClasslist.tmName="Term 2";
        showClasslist.exName="Exam 3";
        showClasslist.currentSetting="F1T2E3";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/classlist/showClasslist.fxml"));
            Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
            stage.getIcons().add(applicationIcon);

            ShowClasslist showClasslist3 = (ShowClasslist) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 1 TERM 2 EXAM 3");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML void openF1T3Avg(){
        ShowClasslist showClasslist = new ShowClasslist();
        showClasslist.dbTableName="tbl_f1_t3_avg";
        showClasslist.dbClassName="FORM_1";
        showClasslist.schName="WAVES ACADEMY LTD";
        showClasslist.clsName="Form 1";
        showClasslist.tmName="Term 3";
        showClasslist.exName="Exam Avg";
        showClasslist.currentSetting="F1T3AVG";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/classlist/showClasslist.fxml"));
            Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
            stage.getIcons().add(applicationIcon);

            ShowClasslist showClasslist3 = (ShowClasslist) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 1 TERM 3 AVERAGE");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML void openF1T3Ex1(){
        ShowClasslist showClasslist = new ShowClasslist();
        showClasslist.dbTableName="tbl_f1_t3_ex1";
        showClasslist.dbClassName="FORM_1";
        showClasslist.schName="WAVES ACADEMY LTD";
        showClasslist.clsName="Form 1";
        showClasslist.tmName="Term 3";
        showClasslist.exName="Exam 1";
        showClasslist.currentSetting="F1T3E1";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/classlist/showClasslist.fxml"));
            Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
            stage.getIcons().add(applicationIcon);

            ShowClasslist showClasslist3 = (ShowClasslist) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 1 TERM 3 EXAM 1");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML void openF1T3Ex2(){
        ShowClasslist showClasslist = new ShowClasslist();
        showClasslist.dbTableName="tbl_f1_t3_ex2";
        showClasslist.dbClassName="FORM_1";
        showClasslist.schName="WAVES ACADEMY LTD";
        showClasslist.clsName="Form 1";
        showClasslist.tmName="Term 3";
        showClasslist.exName="Exam 2";
        showClasslist.currentSetting="F1T3E2";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/classlist/showClasslist.fxml"));
            Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
            stage.getIcons().add(applicationIcon);

            ShowClasslist showClasslist3 = (ShowClasslist) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 1 TERM 3 EXAM 2");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML void openF1T3Ex3(){
        ShowClasslist showClasslist = new ShowClasslist();
        showClasslist.dbTableName="tbl_f1_t3_ex3";
        showClasslist.dbClassName="FORM_1";
        showClasslist.schName="WAVES ACADEMY LTD";
        showClasslist.clsName="Form 1";
        showClasslist.tmName="Term 3";
        showClasslist.exName="Exam 3";
        showClasslist.currentSetting="F1T3E3";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/classlist/showClasslist.fxml"));
            Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
            stage.getIcons().add(applicationIcon);

            ShowClasslist showClasslist3 = (ShowClasslist) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 1 TERM 3 EXAM 3");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void openSubjectSelection(){
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/students/subjectSelection.fxml"));
            //Pane root = (Pane)loader.load(getClass().getResource("../../students/subjectSelection.fxml"));
            Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
            stage.getIcons().add(applicationIcon);
            SubjectSelection subjectSelection = (SubjectSelection) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("SUBJECT SELECTION");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void openTeacher(){
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/teacher/teacher.fxml"));
            //Pane root = (Pane)loader.load(getClass().getResource("../../teacher/teacher.fxml"));
            Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
            stage.getIcons().add(applicationIcon);
            Teacher teacher = (Teacher) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("TEACHERS");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void addStudent(){
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/students/StudentsUpdated.fxml"));
            // Pane root = (Pane)loader.load(getClass().getResource("../../students/StudentsUpdated.fxml"));
            Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
            stage.getIcons().add(applicationIcon);
            StudentUpdated studentUpdated = (StudentUpdated) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("ADD/EDIT STUDENT");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void openF4T1EntryAgri(){
        MarksEntry marksEntry = new MarksEntry();
        marksEntry.dbTableNameT1E1="tbl_f4_t1_ex1";
        marksEntry.dbTableNameT1E2="tbl_f4_t1_ex2";
        marksEntry.dbTableNameT1E3="tbl_f4_t1_ex3";
        marksEntry.dbTableNameT2E1="tbl_f4_t2_ex1";
        marksEntry.dbTableNameT2E2="tbl_f4_t2_ex2";
        marksEntry.dbTableNameT2E3="tbl_f4_t2_ex3";
        marksEntry.dbTableNameT3E1="tbl_f4_t3_ex1";
        marksEntry.dbTableNameT3E2="tbl_f4_t3_ex2";
        marksEntry.dbTableNameT3E3="tbl_f4_t3_ex3";
        marksEntry.dbTableNameT1Avg="tbl_f4_t1_avg";
        marksEntry.dbTableNameT2Avg="tbl_f4_t2_avg";
        marksEntry.dbTableNameT3Avg="tbl_f4_t3_avg";
        marksEntry.dbClassName="FORM_4";
        marksEntry.schName="WAVES ACADEMY LTD";
        marksEntry.clsName="Form 4";
        marksEntry.dbSubjectTable="tbl_f4_agri";
        marksEntry.subName="AGRICULTURE";
        marksEntry.sbj="agri";
        marksEntry.sbjg="agrig";
        marksEntry.pn="p11";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            //Pane root = (Pane)loader.load(getClass().getResource("/F1/exams/marksEntry.fxml"));
            Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
            stage.getIcons().add(applicationIcon);
            Pane root = (Pane)loader.load(getClass().getResource("/F1/exams/marksEntry.fxml"));

            MarksEntry marksEntry1 = (MarksEntry) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 4 AGRICULTURE[Marks Entry]");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void openF4T1EntryBio(){
        MarksEntry marksEntry = new MarksEntry();
        marksEntry.dbTableNameT1E1="tbl_f4_t1_ex1";
        marksEntry.dbTableNameT1E2="tbl_f4_t1_ex2";
        marksEntry.dbTableNameT1E3="tbl_f4_t1_ex3";
        marksEntry.dbTableNameT2E1="tbl_f4_t2_ex1";
        marksEntry.dbTableNameT2E2="tbl_f4_t2_ex2";
        marksEntry.dbTableNameT2E3="tbl_f4_t2_ex3";
        marksEntry.dbTableNameT3E1="tbl_f4_t3_ex1";
        marksEntry.dbTableNameT3E2="tbl_f4_t3_ex2";
        marksEntry.dbTableNameT3E3="tbl_f4_t3_ex3";
        marksEntry.dbTableNameT1Avg="tbl_f4_t1_avg";
        marksEntry.dbTableNameT2Avg="tbl_f4_t2_avg";
        marksEntry.dbTableNameT3Avg="tbl_f4_t3_avg";
        marksEntry.dbClassName="FORM_4";
        marksEntry.schName="WAVES ACADEMY LTD";
        marksEntry.clsName="Form 4";
        marksEntry.dbSubjectTable="tbl_f4_bio";
        marksEntry.subName="BIOLOGY";
        marksEntry.sbj="bio";
        marksEntry.sbjg="biog";
        marksEntry.pn="p4";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            //Pane root = (Pane)loader.load(getClass().getResource("/F1/exams/marksEntry.fxml"));
            Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
            stage.getIcons().add(applicationIcon);
            Pane root = (Pane)loader.load(getClass().getResource("/F1/exams/marksEntry.fxml"));

            MarksEntry marksEntry1 = (MarksEntry) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 4 BIOLOGY[Marks Entry]");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void openF4T1EntryBus(){
        MarksEntry marksEntry = new MarksEntry();
        marksEntry.dbTableNameT1E1="tbl_f4_t1_ex1";
        marksEntry.dbTableNameT1E2="tbl_f4_t1_ex2";
        marksEntry.dbTableNameT1E3="tbl_f4_t1_ex3";
        marksEntry.dbTableNameT2E1="tbl_f4_t2_ex1";
        marksEntry.dbTableNameT2E2="tbl_f4_t2_ex2";
        marksEntry.dbTableNameT2E3="tbl_f4_t2_ex3";
        marksEntry.dbTableNameT3E1="tbl_f4_t3_ex1";
        marksEntry.dbTableNameT3E2="tbl_f4_t3_ex2";
        marksEntry.dbTableNameT3E3="tbl_f4_t3_ex3";
        marksEntry.dbTableNameT1Avg="tbl_f4_t1_avg";
        marksEntry.dbTableNameT2Avg="tbl_f4_t2_avg";
        marksEntry.dbTableNameT3Avg="tbl_f4_t3_avg";
        marksEntry.dbClassName="FORM_4";
        marksEntry.schName="WAVES ACADEMY LTD";
        marksEntry.clsName="Form 4";
        marksEntry.dbSubjectTable="tbl_f4_bus";
        marksEntry.subName="BUSINESS";
        marksEntry.sbj="bus";
        marksEntry.sbjg="busg";
        marksEntry.pn="p10";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            //Pane root = (Pane)loader.load(getClass().getResource("/F1/exams/marksEntry.fxml"));
            Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
            stage.getIcons().add(applicationIcon);
            Pane root = (Pane)loader.load(getClass().getResource("/F1/exams/marksEntry.fxml"));

            MarksEntry marksEntry1 = (MarksEntry) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 4 BUSINESS[Marks Entry]");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void openF4T1EntryChem(){
        MarksEntry marksEntry = new MarksEntry();
        marksEntry.dbTableNameT1E1="tbl_f4_t1_ex1";
        marksEntry.dbTableNameT1E2="tbl_f4_t1_ex2";
        marksEntry.dbTableNameT1E3="tbl_f4_t1_ex3";
        marksEntry.dbTableNameT2E1="tbl_f4_t2_ex1";
        marksEntry.dbTableNameT2E2="tbl_f4_t2_ex2";
        marksEntry.dbTableNameT2E3="tbl_f4_t2_ex3";
        marksEntry.dbTableNameT3E1="tbl_f4_t3_ex1";
        marksEntry.dbTableNameT3E2="tbl_f4_t3_ex2";
        marksEntry.dbTableNameT3E3="tbl_f4_t3_ex3";
        marksEntry.dbTableNameT1Avg="tbl_f4_t1_avg";
        marksEntry.dbTableNameT2Avg="tbl_f4_t2_avg";
        marksEntry.dbTableNameT3Avg="tbl_f4_t3_avg";
        marksEntry.dbClassName="FORM_4";
        marksEntry.schName="WAVES ACADEMY LTD";
        marksEntry.clsName="Form 4";
        marksEntry.dbSubjectTable="tbl_f4_chem";
        marksEntry.subName="CHEMISTRY";
        marksEntry.sbj="chem";
        marksEntry.sbjg="chemg";
        marksEntry.pn="p5";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/exams/marksEntry.fxml"));
            Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
            stage.getIcons().add(applicationIcon);

            MarksEntry marksEntry1 = (MarksEntry) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 4 CHEMISTRY[Marks Entry]");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void openF4T1EntryCre(){
        MarksEntry marksEntry = new MarksEntry();
        marksEntry.dbTableNameT1E1="tbl_f4_t1_ex1";
        marksEntry.dbTableNameT1E2="tbl_f4_t1_ex2";
        marksEntry.dbTableNameT1E3="tbl_f4_t1_ex3";
        marksEntry.dbTableNameT2E1="tbl_f4_t2_ex1";
        marksEntry.dbTableNameT2E2="tbl_f4_t2_ex2";
        marksEntry.dbTableNameT2E3="tbl_f4_t2_ex3";
        marksEntry.dbTableNameT3E1="tbl_f4_t3_ex1";
        marksEntry.dbTableNameT3E2="tbl_f4_t3_ex2";
        marksEntry.dbTableNameT3E3="tbl_f4_t3_ex3";
        marksEntry.dbTableNameT1Avg="tbl_f4_t1_avg";
        marksEntry.dbTableNameT2Avg="tbl_f4_t2_avg";
        marksEntry.dbTableNameT3Avg="tbl_f4_t3_avg";
        marksEntry.dbClassName="FORM_4";
        marksEntry.schName="WAVES ACADEMY LTD";
        marksEntry.clsName="Form 4";
        marksEntry.dbSubjectTable="tbl_f4_cre";
        marksEntry.subName="CRE";
        marksEntry.sbj="cre";
        marksEntry.sbjg="creg";
        marksEntry.pn="p9";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/exams/marksEntry.fxml"));
            Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
            stage.getIcons().add(applicationIcon);

            MarksEntry marksEntry1 = (MarksEntry) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 4 CRE[Marks Entry]");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void openF4T1EntryEng(){
        MarksEntry marksEntry = new MarksEntry();
        marksEntry.dbTableNameT1E1="tbl_f4_t1_ex1";
        marksEntry.dbTableNameT1E2="tbl_f4_t1_ex2";
        marksEntry.dbTableNameT1E3="tbl_f4_t1_ex3";
        marksEntry.dbTableNameT2E1="tbl_f4_t2_ex1";
        marksEntry.dbTableNameT2E2="tbl_f4_t2_ex2";
        marksEntry.dbTableNameT2E3="tbl_f4_t2_ex3";
        marksEntry.dbTableNameT3E1="tbl_f4_t3_ex1";
        marksEntry.dbTableNameT3E2="tbl_f4_t3_ex2";
        marksEntry.dbTableNameT3E3="tbl_f4_t3_ex3";
        marksEntry.dbTableNameT1Avg="tbl_f4_t1_avg";
        marksEntry.dbTableNameT2Avg="tbl_f4_t2_avg";
        marksEntry.dbTableNameT3Avg="tbl_f4_t3_avg";
        marksEntry.dbClassName="FORM_4";
        marksEntry.schName="WAVES ACADEMY LTD";
        marksEntry.clsName="Form 4";
        marksEntry.dbSubjectTable="tbl_f4_eng";
        marksEntry.subName="ENGLISH";
        marksEntry.sbj="eng";
        marksEntry.sbjg="engg";
        marksEntry.pn="p1";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/exams/marksEntry.fxml"));
            Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
            stage.getIcons().add(applicationIcon);

            MarksEntry marksEntry1 = (MarksEntry) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 4 ENGLISH[Marks Entry]");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void openF4T1EntryGeo(){
        MarksEntry marksEntry = new MarksEntry();
        marksEntry.dbTableNameT1E1="tbl_f4_t1_ex1";
        marksEntry.dbTableNameT1E2="tbl_f4_t1_ex2";
        marksEntry.dbTableNameT1E3="tbl_f4_t1_ex3";
        marksEntry.dbTableNameT2E1="tbl_f4_t2_ex1";
        marksEntry.dbTableNameT2E2="tbl_f4_t2_ex2";
        marksEntry.dbTableNameT2E3="tbl_f4_t2_ex3";
        marksEntry.dbTableNameT3E1="tbl_f4_t3_ex1";
        marksEntry.dbTableNameT3E2="tbl_f4_t3_ex2";
        marksEntry.dbTableNameT3E3="tbl_f4_t3_ex3";
        marksEntry.dbTableNameT1Avg="tbl_f4_t1_avg";
        marksEntry.dbTableNameT2Avg="tbl_f4_t2_avg";
        marksEntry.dbTableNameT3Avg="tbl_f4_t3_avg";
        marksEntry.dbClassName="FORM_4";
        marksEntry.schName="WAVES ACADEMY LTD";
        marksEntry.clsName="Form 4";
        marksEntry.dbSubjectTable="tbl_f4_geo";
        marksEntry.subName="GEOGRAPHY";
        marksEntry.sbj="geo";
        marksEntry.sbjg="geog";
        marksEntry.pn="p7";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/exams/marksEntry.fxml"));
            Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
            stage.getIcons().add(applicationIcon);

            MarksEntry marksEntry1 = (MarksEntry) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 4 GEOGRAPHY[Marks Entry]");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void openF4T1EntryHis(){
        MarksEntry marksEntry = new MarksEntry();
        marksEntry.dbTableNameT1E1="tbl_f4_t1_ex1";
        marksEntry.dbTableNameT1E2="tbl_f4_t1_ex2";
        marksEntry.dbTableNameT1E3="tbl_f4_t1_ex3";
        marksEntry.dbTableNameT2E1="tbl_f4_t2_ex1";
        marksEntry.dbTableNameT2E2="tbl_f4_t2_ex2";
        marksEntry.dbTableNameT2E3="tbl_f4_t2_ex3";
        marksEntry.dbTableNameT3E1="tbl_f4_t3_ex1";
        marksEntry.dbTableNameT3E2="tbl_f4_t3_ex2";
        marksEntry.dbTableNameT3E3="tbl_f4_t3_ex3";
        marksEntry.dbTableNameT1Avg="tbl_f4_t1_avg";
        marksEntry.dbTableNameT2Avg="tbl_f4_t2_avg";
        marksEntry.dbTableNameT3Avg="tbl_f4_t3_avg";
        marksEntry.dbClassName="FORM_4";
        marksEntry.schName="WAVES ACADEMY LTD";
        marksEntry.clsName="Form 4";
        marksEntry.dbSubjectTable="tbl_f4_his";
        marksEntry.subName="HISTORY";
        marksEntry.sbj="his";
        marksEntry.sbjg="hisg";
        marksEntry.pn="p8";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/exams/marksEntry.fxml"));
            Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
            stage.getIcons().add(applicationIcon);

            MarksEntry marksEntry1 = (MarksEntry) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 4 HISTORY[Marks Entry]");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void openF4T1EntryKis(){
        MarksEntry marksEntry = new MarksEntry();
        marksEntry.dbTableNameT1E1="tbl_f4_t1_ex1";
        marksEntry.dbTableNameT1E2="tbl_f4_t1_ex2";
        marksEntry.dbTableNameT1E3="tbl_f4_t1_ex3";
        marksEntry.dbTableNameT2E1="tbl_f4_t2_ex1";
        marksEntry.dbTableNameT2E2="tbl_f4_t2_ex2";
        marksEntry.dbTableNameT2E3="tbl_f4_t2_ex3";
        marksEntry.dbTableNameT3E1="tbl_f4_t3_ex1";
        marksEntry.dbTableNameT3E2="tbl_f4_t3_ex2";
        marksEntry.dbTableNameT3E3="tbl_f4_t3_ex3";
        marksEntry.dbTableNameT1Avg="tbl_f4_t1_avg";
        marksEntry.dbTableNameT2Avg="tbl_f4_t2_avg";
        marksEntry.dbTableNameT3Avg="tbl_f4_t3_avg";
        marksEntry.dbClassName="FORM_4";
        marksEntry.schName="WAVES ACADEMY LTD";
        marksEntry.clsName="Form 4";
        marksEntry.dbSubjectTable="tbl_f4_kis";
        marksEntry.subName="KISWAHILI";
        marksEntry.sbj="kis";
        marksEntry.sbjg="kisg";
        marksEntry.pn="p2";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/exams/marksEntry.fxml"));
            Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
            stage.getIcons().add(applicationIcon);

            MarksEntry marksEntry1 = (MarksEntry) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 4 KISWAHILI[Marks Entry]");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void openF4T1EntryMat(){
        MarksEntry marksEntry = new MarksEntry();
        marksEntry.dbTableNameT1E1="tbl_f4_t1_ex1";
        marksEntry.dbTableNameT1E2="tbl_f4_t1_ex2";
        marksEntry.dbTableNameT1E3="tbl_f4_t1_ex3";
        marksEntry.dbTableNameT2E1="tbl_f4_t2_ex1";
        marksEntry.dbTableNameT2E2="tbl_f4_t2_ex2";
        marksEntry.dbTableNameT2E3="tbl_f4_t2_ex3";
        marksEntry.dbTableNameT3E1="tbl_f4_t3_ex1";
        marksEntry.dbTableNameT3E2="tbl_f4_t3_ex2";
        marksEntry.dbTableNameT3E3="tbl_f4_t3_ex3";
        marksEntry.dbTableNameT1Avg="tbl_f4_t1_avg";
        marksEntry.dbTableNameT2Avg="tbl_f4_t2_avg";
        marksEntry.dbTableNameT3Avg="tbl_f4_t3_avg";
        marksEntry.dbClassName="FORM_4";
        marksEntry.schName="WAVES ACADEMY LTD";
        marksEntry.clsName="Form 4";
        marksEntry.dbSubjectTable="tbl_f4_mat";
        marksEntry.subName="MATHEMATICS";
        marksEntry.sbj="mat";
        marksEntry.sbjg="matg";
        marksEntry.pn="p3";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/exams/marksEntry.fxml"));
            Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
            stage.getIcons().add(applicationIcon);

            MarksEntry marksEntry1 = (MarksEntry) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 4 MATHEMATICS[Marks Entry]");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void openF4T1EntryPhy(){
        MarksEntry marksEntry = new MarksEntry();
        marksEntry.dbTableNameT1E1="tbl_f4_t1_ex1";
        marksEntry.dbTableNameT1E2="tbl_f4_t1_ex2";
        marksEntry.dbTableNameT1E3="tbl_f4_t1_ex3";
        marksEntry.dbTableNameT2E1="tbl_f4_t2_ex1";
        marksEntry.dbTableNameT2E2="tbl_f4_t2_ex2";
        marksEntry.dbTableNameT2E3="tbl_f4_t2_ex3";
        marksEntry.dbTableNameT3E1="tbl_f4_t3_ex1";
        marksEntry.dbTableNameT3E2="tbl_f4_t3_ex2";
        marksEntry.dbTableNameT3E3="tbl_f4_t3_ex3";
        marksEntry.dbTableNameT1Avg="tbl_f4_t1_avg";
        marksEntry.dbTableNameT2Avg="tbl_f4_t2_avg";
        marksEntry.dbTableNameT3Avg="tbl_f4_t3_avg";
        marksEntry.dbClassName="FORM_4";
        marksEntry.schName="WAVES ACADEMY LTD";
        marksEntry.clsName="Form 4";
        marksEntry.dbSubjectTable="tbl_f4_phy";
        marksEntry.subName="PHYSICS";
        marksEntry.sbj="phy";
        marksEntry.sbjg="phyg";
        marksEntry.pn="p6";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/exams/marksEntry.fxml"));
            Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
            stage.getIcons().add(applicationIcon);

            MarksEntry marksEntry1 = (MarksEntry) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 4 PHYSICS[Marks Entry]");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void openF3T1EntryAgri(){
        MarksEntry marksEntry = new MarksEntry();
        marksEntry.dbTableNameT1E1="tbl_f3_t1_ex1";
        marksEntry.dbTableNameT1E2="tbl_f3_t1_ex2";
        marksEntry.dbTableNameT1E3="tbl_f3_t1_ex3";
        marksEntry.dbTableNameT2E1="tbl_f3_t2_ex1";
        marksEntry.dbTableNameT2E2="tbl_f3_t2_ex2";
        marksEntry.dbTableNameT2E3="tbl_f3_t2_ex3";
        marksEntry.dbTableNameT3E1="tbl_f3_t3_ex1";
        marksEntry.dbTableNameT3E2="tbl_f3_t3_ex2";
        marksEntry.dbTableNameT3E3="tbl_f3_t3_ex3";
        marksEntry.dbTableNameT1Avg="tbl_f3_t1_avg";
        marksEntry.dbTableNameT2Avg="tbl_f3_t2_avg";
        marksEntry.dbTableNameT3Avg="tbl_f3_t3_avg";
        marksEntry.dbClassName="FORM_3";
        marksEntry.schName="WAVES ACADEMY LTD";
        marksEntry.clsName="Form 3";
        marksEntry.dbSubjectTable="tbl_f3_agri";
        marksEntry.subName="AGRICULTURE";
        marksEntry.sbj="agri";
        marksEntry.sbjg="agrig";
        marksEntry.pn="p11";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/exams/marksEntry.fxml"));
            Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
            stage.getIcons().add(applicationIcon);

            MarksEntry marksEntry1 = (MarksEntry) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 3 AGRICULTURE[Marks Entry]");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void openF3T1EntryBio(){
        MarksEntry marksEntry = new MarksEntry();
        marksEntry.dbTableNameT1E1="tbl_f3_t1_ex1";
        marksEntry.dbTableNameT1E2="tbl_f3_t1_ex2";
        marksEntry.dbTableNameT1E3="tbl_f3_t1_ex3";
        marksEntry.dbTableNameT2E1="tbl_f3_t2_ex1";
        marksEntry.dbTableNameT2E2="tbl_f3_t2_ex2";
        marksEntry.dbTableNameT2E3="tbl_f3_t2_ex3";
        marksEntry.dbTableNameT3E1="tbl_f3_t3_ex1";
        marksEntry.dbTableNameT3E2="tbl_f3_t3_ex2";
        marksEntry.dbTableNameT3E3="tbl_f3_t3_ex3";
        marksEntry.dbTableNameT1Avg="tbl_f3_t1_avg";
        marksEntry.dbTableNameT2Avg="tbl_f3_t2_avg";
        marksEntry.dbTableNameT3Avg="tbl_f3_t3_avg";
        marksEntry.dbClassName="FORM_3";
        marksEntry.schName="WAVES ACADEMY LTD";
        marksEntry.clsName="Form 3";
        marksEntry.dbSubjectTable="tbl_f3_bio";
        marksEntry.subName="BIOLOGY";
        marksEntry.sbj="bio";
        marksEntry.sbjg="biog";
        marksEntry.pn="p4";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/exams/marksEntry.fxml"));
            Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
            stage.getIcons().add(applicationIcon);

            MarksEntry marksEntry1 = (MarksEntry) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 3 BIOLOGY[Marks Entry]");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void openF3T1EntryBus(){
        MarksEntry marksEntry = new MarksEntry();
        marksEntry.dbTableNameT1E1="tbl_f3_t1_ex1";
        marksEntry.dbTableNameT1E2="tbl_f3_t1_ex2";
        marksEntry.dbTableNameT1E3="tbl_f3_t1_ex3";
        marksEntry.dbTableNameT2E1="tbl_f3_t2_ex1";
        marksEntry.dbTableNameT2E2="tbl_f3_t2_ex2";
        marksEntry.dbTableNameT2E3="tbl_f3_t2_ex3";
        marksEntry.dbTableNameT3E1="tbl_f3_t3_ex1";
        marksEntry.dbTableNameT3E2="tbl_f3_t3_ex2";
        marksEntry.dbTableNameT3E3="tbl_f3_t3_ex3";
        marksEntry.dbTableNameT1Avg="tbl_f3_t1_avg";
        marksEntry.dbTableNameT2Avg="tbl_f3_t2_avg";
        marksEntry.dbTableNameT3Avg="tbl_f3_t3_avg";
        marksEntry.dbClassName="FORM_3";
        marksEntry.schName="WAVES ACADEMY LTD";
        marksEntry.clsName="Form 3";
        marksEntry.dbSubjectTable="tbl_f3_bus";
        marksEntry.subName="BUSINESS";
        marksEntry.sbj="bus";
        marksEntry.sbjg="busg";
        marksEntry.pn="p10";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/exams/marksEntry.fxml"));
            Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
            stage.getIcons().add(applicationIcon);

            MarksEntry marksEntry1 = (MarksEntry) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 3 BUSINESS[Marks Entry]");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void openF3T1EntryChem(){
        MarksEntry marksEntry = new MarksEntry();
        marksEntry.dbTableNameT1E1="tbl_f3_t1_ex1";
        marksEntry.dbTableNameT1E2="tbl_f3_t1_ex2";
        marksEntry.dbTableNameT1E3="tbl_f3_t1_ex3";
        marksEntry.dbTableNameT2E1="tbl_f3_t2_ex1";
        marksEntry.dbTableNameT2E2="tbl_f3_t2_ex2";
        marksEntry.dbTableNameT2E3="tbl_f3_t2_ex3";
        marksEntry.dbTableNameT3E1="tbl_f3_t3_ex1";
        marksEntry.dbTableNameT3E2="tbl_f3_t3_ex2";
        marksEntry.dbTableNameT3E3="tbl_f3_t3_ex3";
        marksEntry.dbTableNameT1Avg="tbl_f3_t1_avg";
        marksEntry.dbTableNameT2Avg="tbl_f3_t2_avg";
        marksEntry.dbTableNameT3Avg="tbl_f3_t3_avg";
        marksEntry.dbClassName="FORM_3";
        marksEntry.schName="WAVES ACADEMY LTD";
        marksEntry.clsName="Form 3";
        marksEntry.dbSubjectTable="tbl_f3_chem";
        marksEntry.subName="CHEMISTRY";
        marksEntry.sbj="chem";
        marksEntry.sbjg="chemg";
        marksEntry.pn="p5";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/exams/marksEntry.fxml"));
            Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
            stage.getIcons().add(applicationIcon);

            MarksEntry marksEntry1 = (MarksEntry) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 3 CHEMISTRY[Marks Entry]");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void openF3T1EntryCre(){
        MarksEntry marksEntry = new MarksEntry();
        marksEntry.dbTableNameT1E1="tbl_f3_t1_ex1";
        marksEntry.dbTableNameT1E2="tbl_f3_t1_ex2";
        marksEntry.dbTableNameT1E3="tbl_f3_t1_ex3";
        marksEntry.dbTableNameT2E1="tbl_f3_t2_ex1";
        marksEntry.dbTableNameT2E2="tbl_f3_t2_ex2";
        marksEntry.dbTableNameT2E3="tbl_f3_t2_ex3";
        marksEntry.dbTableNameT3E1="tbl_f3_t3_ex1";
        marksEntry.dbTableNameT3E2="tbl_f3_t3_ex2";
        marksEntry.dbTableNameT3E3="tbl_f3_t3_ex3";
        marksEntry.dbTableNameT1Avg="tbl_f3_t1_avg";
        marksEntry.dbTableNameT2Avg="tbl_f3_t2_avg";
        marksEntry.dbTableNameT3Avg="tbl_f3_t3_avg";
        marksEntry.dbClassName="FORM_3";
        marksEntry.schName="WAVES ACADEMY LTD";
        marksEntry.clsName="Form 3";
        marksEntry.dbSubjectTable="tbl_f3_cre";
        marksEntry.subName="CRE";
        marksEntry.sbj="cre";
        marksEntry.sbjg="creg";
        marksEntry.pn="p9";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/exams/marksEntry.fxml"));
            Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
            stage.getIcons().add(applicationIcon);

            MarksEntry marksEntry1 = (MarksEntry) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 3 CRE[Marks Entry]");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void openF3T1EntryEng(){
        MarksEntry marksEntry = new MarksEntry();
        marksEntry.dbTableNameT1E1="tbl_f3_t1_ex1";
        marksEntry.dbTableNameT1E2="tbl_f3_t1_ex2";
        marksEntry.dbTableNameT1E3="tbl_f3_t1_ex3";
        marksEntry.dbTableNameT2E1="tbl_f3_t2_ex1";
        marksEntry.dbTableNameT2E2="tbl_f3_t2_ex2";
        marksEntry.dbTableNameT2E3="tbl_f3_t2_ex3";
        marksEntry.dbTableNameT3E1="tbl_f3_t3_ex1";
        marksEntry.dbTableNameT3E2="tbl_f3_t3_ex2";
        marksEntry.dbTableNameT3E3="tbl_f3_t3_ex3";
        marksEntry.dbTableNameT1Avg="tbl_f3_t1_avg";
        marksEntry.dbTableNameT2Avg="tbl_f3_t2_avg";
        marksEntry.dbTableNameT3Avg="tbl_f3_t3_avg";
        marksEntry.dbClassName="FORM_3";
        marksEntry.schName="WAVES ACADEMY LTD";
        marksEntry.clsName="Form 3";
        marksEntry.dbSubjectTable="tbl_f3_eng";
        marksEntry.subName="ENGLISH";
        marksEntry.sbj="eng";
        marksEntry.sbjg="engg";
        marksEntry.pn="p1";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/exams/marksEntry.fxml"));
            Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
            stage.getIcons().add(applicationIcon);

            MarksEntry marksEntry1 = (MarksEntry) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 3 ENGLISH[Marks Entry]");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void openF3T1EntryGeo(){
        MarksEntry marksEntry = new MarksEntry();
        marksEntry.dbTableNameT1E1="tbl_f3_t1_ex1";
        marksEntry.dbTableNameT1E2="tbl_f3_t1_ex2";
        marksEntry.dbTableNameT1E3="tbl_f3_t1_ex3";
        marksEntry.dbTableNameT2E1="tbl_f3_t2_ex1";
        marksEntry.dbTableNameT2E2="tbl_f3_t2_ex2";
        marksEntry.dbTableNameT2E3="tbl_f3_t2_ex3";
        marksEntry.dbTableNameT3E1="tbl_f3_t3_ex1";
        marksEntry.dbTableNameT3E2="tbl_f3_t3_ex2";
        marksEntry.dbTableNameT3E3="tbl_f3_t3_ex3";
        marksEntry.dbTableNameT1Avg="tbl_f3_t1_avg";
        marksEntry.dbTableNameT2Avg="tbl_f3_t2_avg";
        marksEntry.dbTableNameT3Avg="tbl_f3_t3_avg";
        marksEntry.dbClassName="FORM_3";
        marksEntry.schName="WAVES ACADEMY LTD";
        marksEntry.clsName="Form 3";
        marksEntry.dbSubjectTable="tbl_f3_geo";
        marksEntry.subName="GEOGRAPHY";
        marksEntry.sbj="geo";
        marksEntry.sbjg="geog";
        marksEntry.pn="p7";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/exams/marksEntry.fxml"));
            Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
            stage.getIcons().add(applicationIcon);

            MarksEntry marksEntry1 = (MarksEntry) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 3 GEOGRAPHY[Marks Entry]");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void openF3T1EntryHis(){
        MarksEntry marksEntry = new MarksEntry();
        marksEntry.dbTableNameT1E1="tbl_f3_t1_ex1";
        marksEntry.dbTableNameT1E2="tbl_f3_t1_ex2";
        marksEntry.dbTableNameT1E3="tbl_f3_t1_ex3";
        marksEntry.dbTableNameT2E1="tbl_f3_t2_ex1";
        marksEntry.dbTableNameT2E2="tbl_f3_t2_ex2";
        marksEntry.dbTableNameT2E3="tbl_f3_t2_ex3";
        marksEntry.dbTableNameT3E1="tbl_f3_t3_ex1";
        marksEntry.dbTableNameT3E2="tbl_f3_t3_ex2";
        marksEntry.dbTableNameT3E3="tbl_f3_t3_ex3";
        marksEntry.dbTableNameT1Avg="tbl_f3_t1_avg";
        marksEntry.dbTableNameT2Avg="tbl_f3_t2_avg";
        marksEntry.dbTableNameT3Avg="tbl_f3_t3_avg";
        marksEntry.dbClassName="FORM_3";
        marksEntry.schName="WAVES ACADEMY LTD";
        marksEntry.clsName="Form 3";
        marksEntry.dbSubjectTable="tbl_f3_his";
        marksEntry.subName="HISTORY";
        marksEntry.sbj="his";
        marksEntry.sbjg="hisg";
        marksEntry.pn="p8";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/exams/marksEntry.fxml"));
            Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
            stage.getIcons().add(applicationIcon);

            MarksEntry marksEntry1 = (MarksEntry) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 3 HISTORY[Marks Entry]");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void openF3T1EntryKis(){
        MarksEntry marksEntry = new MarksEntry();
        marksEntry.dbTableNameT1E1="tbl_f3_t1_ex1";
        marksEntry.dbTableNameT1E2="tbl_f3_t1_ex2";
        marksEntry.dbTableNameT1E3="tbl_f3_t1_ex3";
        marksEntry.dbTableNameT2E1="tbl_f3_t2_ex1";
        marksEntry.dbTableNameT2E2="tbl_f3_t2_ex2";
        marksEntry.dbTableNameT2E3="tbl_f3_t2_ex3";
        marksEntry.dbTableNameT3E1="tbl_f3_t3_ex1";
        marksEntry.dbTableNameT3E2="tbl_f3_t3_ex2";
        marksEntry.dbTableNameT3E3="tbl_f3_t3_ex3";
        marksEntry.dbTableNameT1Avg="tbl_f3_t1_avg";
        marksEntry.dbTableNameT2Avg="tbl_f3_t2_avg";
        marksEntry.dbTableNameT3Avg="tbl_f3_t3_avg";
        marksEntry.dbClassName="FORM_3";
        marksEntry.schName="WAVES ACADEMY LTD";
        marksEntry.clsName="Form 3";
        marksEntry.dbSubjectTable="tbl_f3_kis";
        marksEntry.subName="KISWAHILI";
        marksEntry.sbj="kis";
        marksEntry.sbjg="kisg";
        marksEntry.pn="p2";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/exams/marksEntry.fxml"));
            Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
            stage.getIcons().add(applicationIcon);

            MarksEntry marksEntry1 = (MarksEntry) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 3 KISWAHILI[Marks Entry]");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void openF3T1EntryMat(){
        MarksEntry marksEntry = new MarksEntry();
        marksEntry.dbTableNameT1E1="tbl_f3_t1_ex1";
        marksEntry.dbTableNameT1E2="tbl_f3_t1_ex2";
        marksEntry.dbTableNameT1E3="tbl_f3_t1_ex3";
        marksEntry.dbTableNameT2E1="tbl_f3_t2_ex1";
        marksEntry.dbTableNameT2E2="tbl_f3_t2_ex2";
        marksEntry.dbTableNameT2E3="tbl_f3_t2_ex3";
        marksEntry.dbTableNameT3E1="tbl_f3_t3_ex1";
        marksEntry.dbTableNameT3E2="tbl_f3_t3_ex2";
        marksEntry.dbTableNameT3E3="tbl_f3_t3_ex3";
        marksEntry.dbTableNameT1Avg="tbl_f3_t1_avg";
        marksEntry.dbTableNameT2Avg="tbl_f3_t2_avg";
        marksEntry.dbTableNameT3Avg="tbl_f3_t3_avg";
        marksEntry.dbClassName="FORM_3";
        marksEntry.schName="WAVES ACADEMY LTD";
        marksEntry.clsName="Form 3";
        marksEntry.dbSubjectTable="tbl_f3_mat";
        marksEntry.subName="MATHEMATICS";
        marksEntry.sbj="mat";
        marksEntry.sbjg="matg";
        marksEntry.pn="p3";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/exams/marksEntry.fxml"));
            Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
            stage.getIcons().add(applicationIcon);

            MarksEntry marksEntry1 = (MarksEntry) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 3 MATHEMATICS[Marks Entry]");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void openF3T1EntryPhy(){
        MarksEntry marksEntry = new MarksEntry();
        marksEntry.dbTableNameT1E1="tbl_f3_t1_ex1";
        marksEntry.dbTableNameT1E2="tbl_f3_t1_ex2";
        marksEntry.dbTableNameT1E3="tbl_f3_t1_ex3";
        marksEntry.dbTableNameT2E1="tbl_f3_t2_ex1";
        marksEntry.dbTableNameT2E2="tbl_f3_t2_ex2";
        marksEntry.dbTableNameT2E3="tbl_f3_t2_ex3";
        marksEntry.dbTableNameT3E1="tbl_f3_t3_ex1";
        marksEntry.dbTableNameT3E2="tbl_f3_t3_ex2";
        marksEntry.dbTableNameT3E3="tbl_f3_t3_ex3";
        marksEntry.dbTableNameT1Avg="tbl_f3_t1_avg";
        marksEntry.dbTableNameT2Avg="tbl_f3_t2_avg";
        marksEntry.dbTableNameT3Avg="tbl_f3_t3_avg";
        marksEntry.dbClassName="FORM_3";
        marksEntry.schName="WAVES ACADEMY LTD";
        marksEntry.clsName="Form 3";
        marksEntry.dbSubjectTable="tbl_f3_phy";
        marksEntry.subName="PHYSICS";
        marksEntry.sbj="phy";
        marksEntry.sbjg="phyg";
        marksEntry.pn="p6";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/exams/marksEntry.fxml"));
            Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
            stage.getIcons().add(applicationIcon);

            MarksEntry marksEntry1 = (MarksEntry) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 3 PHYSICS[Marks Entry]");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void openF2T1EntryAgri(){
        MarksEntry marksEntry = new MarksEntry();
        marksEntry.dbTableNameT1E1="tbl_f2_t1_ex1";
        marksEntry.dbTableNameT1E2="tbl_f2_t1_ex2";
        marksEntry.dbTableNameT1E3="tbl_f2_t1_ex3";
        marksEntry.dbTableNameT2E1="tbl_f2_t2_ex1";
        marksEntry.dbTableNameT2E2="tbl_f2_t2_ex2";
        marksEntry.dbTableNameT2E3="tbl_f2_t2_ex3";
        marksEntry.dbTableNameT3E1="tbl_f2_t3_ex1";
        marksEntry.dbTableNameT3E2="tbl_f2_t3_ex2";
        marksEntry.dbTableNameT3E3="tbl_f2_t3_ex3";
        marksEntry.dbTableNameT1Avg="tbl_f2_t1_avg";
        marksEntry.dbTableNameT2Avg="tbl_f2_t2_avg";
        marksEntry.dbTableNameT3Avg="tbl_f2_t3_avg";
        marksEntry.dbClassName="FORM_2";
        marksEntry.schName="WAVES ACADEMY LTD";
        marksEntry.clsName="Form 2";
        marksEntry.dbSubjectTable="tbl_f2_agri";
        marksEntry.subName="AGRICULTURE";
        marksEntry.sbj="agri";
        marksEntry.sbjg="agrig";
        marksEntry.pn="p11";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/exams/marksEntry.fxml"));
            Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
            stage.getIcons().add(applicationIcon);

            MarksEntry marksEntry1 = (MarksEntry) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 2 AGRICULTURE[Marks Entry]");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void openF2T1EntryBio(){
        MarksEntry marksEntry = new MarksEntry();
        marksEntry.dbTableNameT1E1="tbl_f2_t1_ex1";
        marksEntry.dbTableNameT1E2="tbl_f2_t1_ex2";
        marksEntry.dbTableNameT1E3="tbl_f2_t1_ex3";
        marksEntry.dbTableNameT2E1="tbl_f2_t2_ex1";
        marksEntry.dbTableNameT2E2="tbl_f2_t2_ex2";
        marksEntry.dbTableNameT2E3="tbl_f2_t2_ex3";
        marksEntry.dbTableNameT3E1="tbl_f2_t3_ex1";
        marksEntry.dbTableNameT3E2="tbl_f2_t3_ex2";
        marksEntry.dbTableNameT3E3="tbl_f2_t3_ex3";
        marksEntry.dbTableNameT1Avg="tbl_f2_t1_avg";
        marksEntry.dbTableNameT2Avg="tbl_f2_t2_avg";
        marksEntry.dbTableNameT3Avg="tbl_f2_t3_avg";
        marksEntry.dbClassName="FORM_2";
        marksEntry.schName="WAVES ACADEMY LTD";
        marksEntry.clsName="Form 2";
        marksEntry.dbSubjectTable="tbl_f2_bio";
        marksEntry.subName="BIOLOGY";
        marksEntry.sbj="bio";
        marksEntry.sbjg="biog";
        marksEntry.pn="p4";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/exams/marksEntry.fxml"));
            Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
            stage.getIcons().add(applicationIcon);

            MarksEntry marksEntry1 = (MarksEntry) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 2 BIOLOGY[Marks Entry]");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void openF2T1EntryBus(){
        MarksEntry marksEntry = new MarksEntry();
        marksEntry.dbTableNameT1E1="tbl_f2_t1_ex1";
        marksEntry.dbTableNameT1E2="tbl_f2_t1_ex2";
        marksEntry.dbTableNameT1E3="tbl_f2_t1_ex3";
        marksEntry.dbTableNameT2E1="tbl_f2_t2_ex1";
        marksEntry.dbTableNameT2E2="tbl_f2_t2_ex2";
        marksEntry.dbTableNameT2E3="tbl_f2_t2_ex3";
        marksEntry.dbTableNameT3E1="tbl_f2_t3_ex1";
        marksEntry.dbTableNameT3E2="tbl_f2_t3_ex2";
        marksEntry.dbTableNameT3E3="tbl_f2_t3_ex3";
        marksEntry.dbTableNameT1Avg="tbl_f2_t1_avg";
        marksEntry.dbTableNameT2Avg="tbl_f2_t2_avg";
        marksEntry.dbTableNameT3Avg="tbl_f2_t3_avg";
        marksEntry.dbClassName="FORM_2";
        marksEntry.schName="WAVES ACADEMY LTD";
        marksEntry.clsName="Form 2";
        marksEntry.dbSubjectTable="tbl_f2_bus";
        marksEntry.subName="BUSINESS";
        marksEntry.sbj="bus";
        marksEntry.sbjg="busg";
        marksEntry.pn="p10";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/exams/marksEntry.fxml"));
            Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
            stage.getIcons().add(applicationIcon);

            MarksEntry marksEntry1 = (MarksEntry) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 2 BUSINESS[Marks Entry]");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void openF2T1EntryChem(){
        MarksEntry marksEntry = new MarksEntry();
        marksEntry.dbTableNameT1E1="tbl_f2_t1_ex1";
        marksEntry.dbTableNameT1E2="tbl_f2_t1_ex2";
        marksEntry.dbTableNameT1E3="tbl_f2_t1_ex3";
        marksEntry.dbTableNameT2E1="tbl_f2_t2_ex1";
        marksEntry.dbTableNameT2E2="tbl_f2_t2_ex2";
        marksEntry.dbTableNameT2E3="tbl_f2_t2_ex3";
        marksEntry.dbTableNameT3E1="tbl_f2_t3_ex1";
        marksEntry.dbTableNameT3E2="tbl_f2_t3_ex2";
        marksEntry.dbTableNameT3E3="tbl_f2_t3_ex3";
        marksEntry.dbTableNameT1Avg="tbl_f2_t1_avg";
        marksEntry.dbTableNameT2Avg="tbl_f2_t2_avg";
        marksEntry.dbTableNameT3Avg="tbl_f2_t3_avg";
        marksEntry.dbClassName="FORM_2";
        marksEntry.schName="WAVES ACADEMY LTD";
        marksEntry.clsName="Form 2";
        marksEntry.dbSubjectTable="tbl_f2_chem";
        marksEntry.subName="CHEMISTRY";
        marksEntry.sbj="chem";
        marksEntry.sbjg="chemg";
        marksEntry.pn="p5";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/exams/marksEntry.fxml"));
            Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
            stage.getIcons().add(applicationIcon);

            MarksEntry marksEntry1 = (MarksEntry) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 2 CHEMISTRY[Marks Entry]");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void openF2T1EntryCre(){
        MarksEntry marksEntry = new MarksEntry();
        marksEntry.dbTableNameT1E1="tbl_f2_t1_ex1";
        marksEntry.dbTableNameT1E2="tbl_f2_t1_ex2";
        marksEntry.dbTableNameT1E3="tbl_f2_t1_ex3";
        marksEntry.dbTableNameT2E1="tbl_f2_t2_ex1";
        marksEntry.dbTableNameT2E2="tbl_f2_t2_ex2";
        marksEntry.dbTableNameT2E3="tbl_f2_t2_ex3";
        marksEntry.dbTableNameT3E1="tbl_f2_t3_ex1";
        marksEntry.dbTableNameT3E2="tbl_f2_t3_ex2";
        marksEntry.dbTableNameT3E3="tbl_f2_t3_ex3";
        marksEntry.dbTableNameT1Avg="tbl_f2_t1_avg";
        marksEntry.dbTableNameT2Avg="tbl_f2_t2_avg";
        marksEntry.dbTableNameT3Avg="tbl_f2_t3_avg";
        marksEntry.dbClassName="FORM_2";
        marksEntry.schName="WAVES ACADEMY LTD";
        marksEntry.clsName="Form 2";
        marksEntry.dbSubjectTable="tbl_f2_cre";
        marksEntry.subName="CRE";
        marksEntry.sbj="cre";
        marksEntry.sbjg="creg";
        marksEntry.pn="p9";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/exams/marksEntry.fxml"));
            Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
            stage.getIcons().add(applicationIcon);

            MarksEntry marksEntry1 = (MarksEntry) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 2 CRE[Marks Entry]");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void openF2T1EntryEng(){
        MarksEntry marksEntry = new MarksEntry();
        marksEntry.dbTableNameT1E1="tbl_f2_t1_ex1";
        marksEntry.dbTableNameT1E2="tbl_f2_t1_ex2";
        marksEntry.dbTableNameT1E3="tbl_f2_t1_ex3";
        marksEntry.dbTableNameT2E1="tbl_f2_t2_ex1";
        marksEntry.dbTableNameT2E2="tbl_f2_t2_ex2";
        marksEntry.dbTableNameT2E3="tbl_f2_t2_ex3";
        marksEntry.dbTableNameT3E1="tbl_f2_t3_ex1";
        marksEntry.dbTableNameT3E2="tbl_f2_t3_ex2";
        marksEntry.dbTableNameT3E3="tbl_f2_t3_ex3";
        marksEntry.dbTableNameT1Avg="tbl_f2_t1_avg";
        marksEntry.dbTableNameT2Avg="tbl_f2_t2_avg";
        marksEntry.dbTableNameT3Avg="tbl_f2_t3_avg";
        marksEntry.dbClassName="FORM_2";
        marksEntry.schName="WAVES ACADEMY LTD";
        marksEntry.clsName="Form 2";
        marksEntry.dbSubjectTable="tbl_f2_eng";
        marksEntry.subName="ENGLISH";
        marksEntry.sbj="eng";
        marksEntry.sbjg="engg";
        marksEntry.pn="p1";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/exams/marksEntry.fxml"));
            Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
            stage.getIcons().add(applicationIcon);

            MarksEntry marksEntry1 = (MarksEntry) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 2 ENGLISH[Marks Entry]");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void openF2T1EntryGeo(){
        MarksEntry marksEntry = new MarksEntry();
        marksEntry.dbTableNameT1E1="tbl_f2_t1_ex1";
        marksEntry.dbTableNameT1E2="tbl_f2_t1_ex2";
        marksEntry.dbTableNameT1E3="tbl_f2_t1_ex3";
        marksEntry.dbTableNameT2E1="tbl_f2_t2_ex1";
        marksEntry.dbTableNameT2E2="tbl_f2_t2_ex2";
        marksEntry.dbTableNameT2E3="tbl_f2_t2_ex3";
        marksEntry.dbTableNameT3E1="tbl_f2_t3_ex1";
        marksEntry.dbTableNameT3E2="tbl_f2_t3_ex2";
        marksEntry.dbTableNameT3E3="tbl_f2_t3_ex3";
        marksEntry.dbTableNameT1Avg="tbl_f2_t1_avg";
        marksEntry.dbTableNameT2Avg="tbl_f2_t2_avg";
        marksEntry.dbTableNameT3Avg="tbl_f2_t3_avg";
        marksEntry.dbClassName="FORM_2";
        marksEntry.schName="WAVES ACADEMY LTD";
        marksEntry.clsName="Form 2";
        marksEntry.dbSubjectTable="tbl_f2_geo";
        marksEntry.subName="GEOGRAPHY";
        marksEntry.sbj="geo";
        marksEntry.sbjg="geog";
        marksEntry.pn="p7";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/exams/marksEntry.fxml"));
            Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
            stage.getIcons().add(applicationIcon);

            MarksEntry marksEntry1 = (MarksEntry) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 2 GEOGRAPHY[Marks Entry]");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void openF2T1EntryHis(){
        MarksEntry marksEntry = new MarksEntry();
        marksEntry.dbTableNameT1E1="tbl_f2_t1_ex1";
        marksEntry.dbTableNameT1E2="tbl_f2_t1_ex2";
        marksEntry.dbTableNameT1E3="tbl_f2_t1_ex3";
        marksEntry.dbTableNameT2E1="tbl_f2_t2_ex1";
        marksEntry.dbTableNameT2E2="tbl_f2_t2_ex2";
        marksEntry.dbTableNameT2E3="tbl_f2_t2_ex3";
        marksEntry.dbTableNameT3E1="tbl_f2_t3_ex1";
        marksEntry.dbTableNameT3E2="tbl_f2_t3_ex2";
        marksEntry.dbTableNameT3E3="tbl_f2_t3_ex3";
        marksEntry.dbTableNameT1Avg="tbl_f2_t1_avg";
        marksEntry.dbTableNameT2Avg="tbl_f2_t2_avg";
        marksEntry.dbTableNameT3Avg="tbl_f2_t3_avg";
        marksEntry.dbClassName="FORM_2";
        marksEntry.schName="WAVES ACADEMY LTD";
        marksEntry.clsName="Form 2";
        marksEntry.dbSubjectTable="tbl_f2_his";
        marksEntry.subName="HISTORY";
        marksEntry.sbj="his";
        marksEntry.sbjg="hisg";
        marksEntry.pn="p8";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/exams/marksEntry.fxml"));
            Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
            stage.getIcons().add(applicationIcon);

            MarksEntry marksEntry1 = (MarksEntry) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 2 HISTORY[Marks Entry]");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void openF2T1EntryKis(){
        MarksEntry marksEntry = new MarksEntry();
        marksEntry.dbTableNameT1E1="tbl_f2_t1_ex1";
        marksEntry.dbTableNameT1E2="tbl_f2_t1_ex2";
        marksEntry.dbTableNameT1E3="tbl_f2_t1_ex3";
        marksEntry.dbTableNameT2E1="tbl_f2_t2_ex1";
        marksEntry.dbTableNameT2E2="tbl_f2_t2_ex2";
        marksEntry.dbTableNameT2E3="tbl_f2_t2_ex3";
        marksEntry.dbTableNameT3E1="tbl_f2_t3_ex1";
        marksEntry.dbTableNameT3E2="tbl_f2_t3_ex2";
        marksEntry.dbTableNameT3E3="tbl_f2_t3_ex3";
        marksEntry.dbTableNameT1Avg="tbl_f2_t1_avg";
        marksEntry.dbTableNameT2Avg="tbl_f2_t2_avg";
        marksEntry.dbTableNameT3Avg="tbl_f2_t3_avg";
        marksEntry.dbClassName="FORM_2";
        marksEntry.schName="WAVES ACADEMY LTD";
        marksEntry.clsName="Form 2";
        marksEntry.dbSubjectTable="tbl_f2_kis";
        marksEntry.subName="KISWAHILI";
        marksEntry.sbj="kis";
        marksEntry.sbjg="kisg";
        marksEntry.pn="p2";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/exams/marksEntry.fxml"));
            Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
            stage.getIcons().add(applicationIcon);

            MarksEntry marksEntry1 = (MarksEntry) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 2 KISWAHILI[Marks Entry]");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void openF2T1EntryMat(){
        MarksEntry marksEntry = new MarksEntry();
        marksEntry.dbTableNameT1E1="tbl_f2_t1_ex1";
        marksEntry.dbTableNameT1E2="tbl_f2_t1_ex2";
        marksEntry.dbTableNameT1E3="tbl_f2_t1_ex3";
        marksEntry.dbTableNameT2E1="tbl_f2_t2_ex1";
        marksEntry.dbTableNameT2E2="tbl_f2_t2_ex2";
        marksEntry.dbTableNameT2E3="tbl_f2_t2_ex3";
        marksEntry.dbTableNameT3E1="tbl_f2_t3_ex1";
        marksEntry.dbTableNameT3E2="tbl_f2_t3_ex2";
        marksEntry.dbTableNameT3E3="tbl_f2_t3_ex3";
        marksEntry.dbTableNameT1Avg="tbl_f2_t1_avg";
        marksEntry.dbTableNameT2Avg="tbl_f2_t2_avg";
        marksEntry.dbTableNameT3Avg="tbl_f2_t3_avg";
        marksEntry.dbClassName="FORM_2";
        marksEntry.schName="WAVES ACADEMY LTD";
        marksEntry.clsName="Form 2";
        marksEntry.dbSubjectTable="tbl_f2_mat";
        marksEntry.subName="MATHEMATICS";
        marksEntry.sbj="mat";
        marksEntry.sbjg="matg";
        marksEntry.pn="p3";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/exams/marksEntry.fxml"));
            Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
            stage.getIcons().add(applicationIcon);

            MarksEntry marksEntry1 = (MarksEntry) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 2 MATHEMATICS[Marks Entry]");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void openF2T1EntryPhy(){
        MarksEntry marksEntry = new MarksEntry();
        marksEntry.dbTableNameT1E1="tbl_f2_t1_ex1";
        marksEntry.dbTableNameT1E2="tbl_f2_t1_ex2";
        marksEntry.dbTableNameT1E3="tbl_f2_t1_ex3";
        marksEntry.dbTableNameT2E1="tbl_f2_t2_ex1";
        marksEntry.dbTableNameT2E2="tbl_f2_t2_ex2";
        marksEntry.dbTableNameT2E3="tbl_f2_t2_ex3";
        marksEntry.dbTableNameT3E1="tbl_f2_t3_ex1";
        marksEntry.dbTableNameT3E2="tbl_f2_t3_ex2";
        marksEntry.dbTableNameT3E3="tbl_f2_t3_ex3";
        marksEntry.dbTableNameT1Avg="tbl_f2_t1_avg";
        marksEntry.dbTableNameT2Avg="tbl_f2_t2_avg";
        marksEntry.dbTableNameT3Avg="tbl_f2_t3_avg";
        marksEntry.dbClassName="FORM_2";
        marksEntry.schName="WAVES ACADEMY LTD";
        marksEntry.clsName="Form 2";
        marksEntry.dbSubjectTable="tbl_f2_phy";
        marksEntry.subName="PHYSICS";
        marksEntry.sbj="phy";
        marksEntry.sbjg="phyg";
        marksEntry.pn="p6";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/exams/marksEntry.fxml"));
            Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
            stage.getIcons().add(applicationIcon);

            MarksEntry marksEntry1 = (MarksEntry) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 2 PHYSICS[Marks Entry]");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void openF1T1EntryAgri(){
        MarksEntry marksEntry = new MarksEntry();
        marksEntry.dbTableNameT1E1="tbl_f1_t1_ex1";
        marksEntry.dbTableNameT1E2="tbl_f1_t1_ex2";
        marksEntry.dbTableNameT1E3="tbl_f1_t1_ex3";
        marksEntry.dbTableNameT2E1="tbl_f1_t2_ex1";
        marksEntry.dbTableNameT2E2="tbl_f1_t2_ex2";
        marksEntry.dbTableNameT2E3="tbl_f1_t2_ex3";
        marksEntry.dbTableNameT3E1="tbl_f1_t3_ex1";
        marksEntry.dbTableNameT3E2="tbl_f1_t3_ex2";
        marksEntry.dbTableNameT3E3="tbl_f1_t3_ex3";
        marksEntry.dbTableNameT1Avg="tbl_f1_t1_avg";
        marksEntry.dbTableNameT2Avg="tbl_f1_t2_avg";
        marksEntry.dbTableNameT3Avg="tbl_f1_t3_avg";
        marksEntry.dbClassName="FORM_1";
        marksEntry.schName="WAVES ACADEMY LTD";
        marksEntry.clsName="Form 1";
        marksEntry.dbSubjectTable="tbl_f1_agri";
        marksEntry.subName="AGRICULTURE";
        marksEntry.sbj="agri";
        marksEntry.sbjg="agrig";
        marksEntry.pn="p11";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/exams/marksEntry.fxml"));
            Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
            stage.getIcons().add(applicationIcon);

            MarksEntry marksEntry1 = (MarksEntry) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 1 AGRICULTURE[Marks Entry]");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void openF1T1EntryBio(){
        MarksEntry marksEntry = new MarksEntry();
        marksEntry.dbTableNameT1E1="tbl_f1_t1_ex1";
        marksEntry.dbTableNameT1E2="tbl_f1_t1_ex2";
        marksEntry.dbTableNameT1E3="tbl_f1_t1_ex3";
        marksEntry.dbTableNameT2E1="tbl_f1_t2_ex1";
        marksEntry.dbTableNameT2E2="tbl_f1_t2_ex2";
        marksEntry.dbTableNameT2E3="tbl_f1_t2_ex3";
        marksEntry.dbTableNameT3E1="tbl_f1_t3_ex1";
        marksEntry.dbTableNameT3E2="tbl_f1_t3_ex2";
        marksEntry.dbTableNameT3E3="tbl_f1_t3_ex3";
        marksEntry.dbTableNameT1Avg="tbl_f1_t1_avg";
        marksEntry.dbTableNameT2Avg="tbl_f1_t2_avg";
        marksEntry.dbTableNameT3Avg="tbl_f1_t3_avg";
        marksEntry.dbClassName="FORM_1";
        marksEntry.schName="WAVES ACADEMY LTD";
        marksEntry.clsName="Form 1";
        marksEntry.dbSubjectTable="tbl_f1_bio";
        marksEntry.subName="BIOLOGY";
        marksEntry.sbj="bio";
        marksEntry.sbjg="biog";
        marksEntry.pn="p4";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/exams/marksEntry.fxml"));
            Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
            stage.getIcons().add(applicationIcon);

            MarksEntry marksEntry1 = (MarksEntry) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 1 BIOLOGY[Marks Entry]");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void openF1T1EntryBus(){
        MarksEntry marksEntry = new MarksEntry();
        marksEntry.dbTableNameT1E1="tbl_f1_t1_ex1";
        marksEntry.dbTableNameT1E2="tbl_f1_t1_ex2";
        marksEntry.dbTableNameT1E3="tbl_f1_t1_ex3";
        marksEntry.dbTableNameT2E1="tbl_f1_t2_ex1";
        marksEntry.dbTableNameT2E2="tbl_f1_t2_ex2";
        marksEntry.dbTableNameT2E3="tbl_f1_t2_ex3";
        marksEntry.dbTableNameT3E1="tbl_f1_t3_ex1";
        marksEntry.dbTableNameT3E2="tbl_f1_t3_ex2";
        marksEntry.dbTableNameT3E3="tbl_f1_t3_ex3";
        marksEntry.dbTableNameT1Avg="tbl_f1_t1_avg";
        marksEntry.dbTableNameT2Avg="tbl_f1_t2_avg";
        marksEntry.dbTableNameT3Avg="tbl_f1_t3_avg";
        marksEntry.dbClassName="FORM_1";
        marksEntry.schName="WAVES ACADEMY LTD";
        marksEntry.clsName="Form 1";
        marksEntry.dbSubjectTable="tbl_f1_bus";
        marksEntry.subName="BUSINESS";
        marksEntry.sbj="bus";
        marksEntry.sbjg="busg";
        marksEntry.pn="p10";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/exams/marksEntry.fxml"));
            Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
            stage.getIcons().add(applicationIcon);

            MarksEntry marksEntry1 = (MarksEntry) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 1 BUSINESS[Marks Entry]");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void openF1T1EntryChem(){
        MarksEntry marksEntry = new MarksEntry();
        marksEntry.dbTableNameT1E1="tbl_f1_t1_ex1";
        marksEntry.dbTableNameT1E2="tbl_f1_t1_ex2";
        marksEntry.dbTableNameT1E3="tbl_f1_t1_ex3";
        marksEntry.dbTableNameT2E1="tbl_f1_t2_ex1";
        marksEntry.dbTableNameT2E2="tbl_f1_t2_ex2";
        marksEntry.dbTableNameT2E3="tbl_f1_t2_ex3";
        marksEntry.dbTableNameT3E1="tbl_f1_t3_ex1";
        marksEntry.dbTableNameT3E2="tbl_f1_t3_ex2";
        marksEntry.dbTableNameT3E3="tbl_f1_t3_ex3";
        marksEntry.dbTableNameT1Avg="tbl_f1_t1_avg";
        marksEntry.dbTableNameT2Avg="tbl_f1_t2_avg";
        marksEntry.dbTableNameT3Avg="tbl_f1_t3_avg";
        marksEntry.dbClassName="FORM_1";
        marksEntry.schName="WAVES ACADEMY LTD";
        marksEntry.clsName="Form 1";
        marksEntry.dbSubjectTable="tbl_f1_chem";
        marksEntry.subName="CHEMISTRY";
        marksEntry.sbj="chem";
        marksEntry.sbjg="chemg";
        marksEntry.pn="p5";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/exams/marksEntry.fxml"));
            Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
            stage.getIcons().add(applicationIcon);

            MarksEntry marksEntry1 = (MarksEntry) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 1 CHEMISTRY[Marks Entry]");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void openF1T1EntryCre(){
        MarksEntry marksEntry = new MarksEntry();
        marksEntry.dbTableNameT1E1="tbl_f1_t1_ex1";
        marksEntry.dbTableNameT1E2="tbl_f1_t1_ex2";
        marksEntry.dbTableNameT1E3="tbl_f1_t1_ex3";
        marksEntry.dbTableNameT2E1="tbl_f1_t2_ex1";
        marksEntry.dbTableNameT2E2="tbl_f1_t2_ex2";
        marksEntry.dbTableNameT2E3="tbl_f1_t2_ex3";
        marksEntry.dbTableNameT3E1="tbl_f1_t3_ex1";
        marksEntry.dbTableNameT3E2="tbl_f1_t3_ex2";
        marksEntry.dbTableNameT3E3="tbl_f1_t3_ex3";
        marksEntry.dbTableNameT1Avg="tbl_f1_t1_avg";
        marksEntry.dbTableNameT2Avg="tbl_f1_t2_avg";
        marksEntry.dbTableNameT3Avg="tbl_f1_t3_avg";
        marksEntry.dbClassName="FORM_1";
        marksEntry.schName="WAVES ACADEMY LTD";
        marksEntry.clsName="Form 1";
        marksEntry.dbSubjectTable="tbl_f1_cre";
        marksEntry.subName="CRE";
        marksEntry.sbj="cre";
        marksEntry.sbjg="creg";
        marksEntry.pn="p9";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/exams/marksEntry.fxml"));
            Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
            stage.getIcons().add(applicationIcon);

            MarksEntry marksEntry1 = (MarksEntry) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 1 CRE[Marks Entry]");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void openF1T1EntryEng(){
        MarksEntry marksEntry = new MarksEntry();
        marksEntry.dbTableNameT1E1="tbl_f1_t1_ex1";
        marksEntry.dbTableNameT1E2="tbl_f1_t1_ex2";
        marksEntry.dbTableNameT1E3="tbl_f1_t1_ex3";
        marksEntry.dbTableNameT2E1="tbl_f1_t2_ex1";
        marksEntry.dbTableNameT2E2="tbl_f1_t2_ex2";
        marksEntry.dbTableNameT2E3="tbl_f1_t2_ex3";
        marksEntry.dbTableNameT3E1="tbl_f1_t3_ex1";
        marksEntry.dbTableNameT3E2="tbl_f1_t3_ex2";
        marksEntry.dbTableNameT3E3="tbl_f1_t3_ex3";
        marksEntry.dbTableNameT1Avg="tbl_f1_t1_avg";
        marksEntry.dbTableNameT2Avg="tbl_f1_t2_avg";
        marksEntry.dbTableNameT3Avg="tbl_f1_t3_avg";
        marksEntry.dbClassName="FORM_1";
        marksEntry.schName="WAVES ACADEMY LTD";
        marksEntry.clsName="Form 1";
        marksEntry.dbSubjectTable="tbl_f1_eng";
        marksEntry.subName="ENGLISH";
        marksEntry.sbj="eng";
        marksEntry.sbjg="engg";
        marksEntry.pn="p1";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/exams/marksEntry.fxml"));
            Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
            stage.getIcons().add(applicationIcon);
            //Pane root = (Pane)loader.load(getClass().getResource("../marksEntry.fxml"));

            MarksEntry marksEntry1 = (MarksEntry) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 1 ENGLISH[Marks Entry]");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();

        }
    }

    public void openF1T1EntryGeo(){
        MarksEntry marksEntry = new MarksEntry();
        marksEntry.dbTableNameT1E1="tbl_f1_t1_ex1";
        marksEntry.dbTableNameT1E2="tbl_f1_t1_ex2";
        marksEntry.dbTableNameT1E3="tbl_f1_t1_ex3";
        marksEntry.dbTableNameT2E1="tbl_f1_t2_ex1";
        marksEntry.dbTableNameT2E2="tbl_f1_t2_ex2";
        marksEntry.dbTableNameT2E3="tbl_f1_t2_ex3";
        marksEntry.dbTableNameT3E1="tbl_f1_t3_ex1";
        marksEntry.dbTableNameT3E2="tbl_f1_t3_ex2";
        marksEntry.dbTableNameT3E3="tbl_f1_t3_ex3";
        marksEntry.dbTableNameT1Avg="tbl_f1_t1_avg";
        marksEntry.dbTableNameT2Avg="tbl_f1_t2_avg";
        marksEntry.dbTableNameT3Avg="tbl_f1_t3_avg";
        marksEntry.dbClassName="FORM_1";
        marksEntry.schName="WAVES ACADEMY LTD";
        marksEntry.clsName="Form 1";
        marksEntry.dbSubjectTable="tbl_f1_geo";
        marksEntry.subName="GEOGRAPHY";
        marksEntry.sbj="geo";
        marksEntry.sbjg="geog";
        marksEntry.pn="p7";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/exams/marksEntry.fxml"));
            Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
            stage.getIcons().add(applicationIcon);

            MarksEntry marksEntry1 = (MarksEntry) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 1 GEOGRAPHY[Marks Entry]");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void openF1T1EntryHis(){
        MarksEntry marksEntry = new MarksEntry();
        marksEntry.dbTableNameT1E1="tbl_f1_t1_ex1";
        marksEntry.dbTableNameT1E2="tbl_f1_t1_ex2";
        marksEntry.dbTableNameT1E3="tbl_f1_t1_ex3";
        marksEntry.dbTableNameT2E1="tbl_f1_t2_ex1";
        marksEntry.dbTableNameT2E2="tbl_f1_t2_ex2";
        marksEntry.dbTableNameT2E3="tbl_f1_t2_ex3";
        marksEntry.dbTableNameT3E1="tbl_f1_t3_ex1";
        marksEntry.dbTableNameT3E2="tbl_f1_t3_ex2";
        marksEntry.dbTableNameT3E3="tbl_f1_t3_ex3";
        marksEntry.dbTableNameT1Avg="tbl_f1_t1_avg";
        marksEntry.dbTableNameT2Avg="tbl_f1_t2_avg";
        marksEntry.dbTableNameT3Avg="tbl_f1_t3_avg";
        marksEntry.dbClassName="FORM_1";
        marksEntry.schName="WAVES ACADEMY LTD";
        marksEntry.clsName="Form 1";
        marksEntry.dbSubjectTable="tbl_f1_his";
        marksEntry.subName="HISTORY";
        marksEntry.sbj="his";
        marksEntry.sbjg="hisg";
        marksEntry.pn="p8";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/exams/marksEntry.fxml"));
            Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
            stage.getIcons().add(applicationIcon);

            MarksEntry marksEntry1 = (MarksEntry) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 1 HISTORY[Marks Entry]");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void openF1T1EntryKis(){
        MarksEntry marksEntry = new MarksEntry();
        marksEntry.dbTableNameT1E1="tbl_f1_t1_ex1";
        marksEntry.dbTableNameT1E2="tbl_f1_t1_ex2";
        marksEntry.dbTableNameT1E3="tbl_f1_t1_ex3";
        marksEntry.dbTableNameT2E1="tbl_f1_t2_ex1";
        marksEntry.dbTableNameT2E2="tbl_f1_t2_ex2";
        marksEntry.dbTableNameT2E3="tbl_f1_t2_ex3";
        marksEntry.dbTableNameT3E1="tbl_f1_t3_ex1";
        marksEntry.dbTableNameT3E2="tbl_f1_t3_ex2";
        marksEntry.dbTableNameT3E3="tbl_f1_t3_ex3";
        marksEntry.dbTableNameT1Avg="tbl_f1_t1_avg";
        marksEntry.dbTableNameT2Avg="tbl_f1_t2_avg";
        marksEntry.dbTableNameT3Avg="tbl_f1_t3_avg";
        marksEntry.dbClassName="FORM_1";
        marksEntry.schName="WAVES ACADEMY LTD";
        marksEntry.clsName="Form 1";
        marksEntry.dbSubjectTable="tbl_f1_kis";
        marksEntry.subName="KISWAHILI";
        marksEntry.sbj="kis";
        marksEntry.sbjg="kisg";
        marksEntry.pn="p2";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/exams/marksEntry.fxml"));
            Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
            stage.getIcons().add(applicationIcon);

            MarksEntry marksEntry1 = (MarksEntry) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 1 KISWAHILI[Marks Entry]");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void openF1T1EntryMat(){
        MarksEntry marksEntry = new MarksEntry();
        marksEntry.dbTableNameT1E1="tbl_f1_t1_ex1";
        marksEntry.dbTableNameT1E2="tbl_f1_t1_ex2";
        marksEntry.dbTableNameT1E3="tbl_f1_t1_ex3";
        marksEntry.dbTableNameT2E1="tbl_f1_t2_ex1";
        marksEntry.dbTableNameT2E2="tbl_f1_t2_ex2";
        marksEntry.dbTableNameT2E3="tbl_f1_t2_ex3";
        marksEntry.dbTableNameT3E1="tbl_f1_t3_ex1";
        marksEntry.dbTableNameT3E2="tbl_f1_t3_ex2";
        marksEntry.dbTableNameT3E3="tbl_f1_t3_ex3";
        marksEntry.dbTableNameT1Avg="tbl_f1_t1_avg";
        marksEntry.dbTableNameT2Avg="tbl_f1_t2_avg";
        marksEntry.dbTableNameT3Avg="tbl_f1_t3_avg";
        marksEntry.dbClassName="FORM_1";
        marksEntry.schName="WAVES ACADEMY LTD";
        marksEntry.clsName="Form 1";
        marksEntry.dbSubjectTable="tbl_f1_mat";
        marksEntry.subName="MATHEMATICS";
        marksEntry.sbj="mat";
        marksEntry.sbjg="matg";
        marksEntry.pn="p3";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/exams/marksEntry.fxml"));
            Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
            stage.getIcons().add(applicationIcon);

            MarksEntry marksEntry1 = (MarksEntry) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 1 MATHEMATICS[Marks Entry]");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void openF1T1EntryPhy(){
        MarksEntry marksEntry = new MarksEntry();
        marksEntry.dbTableNameT1E1="tbl_f1_t1_ex1";
        marksEntry.dbTableNameT1E2="tbl_f1_t1_ex2";
        marksEntry.dbTableNameT1E3="tbl_f1_t1_ex3";
        marksEntry.dbTableNameT2E1="tbl_f1_t2_ex1";
        marksEntry.dbTableNameT2E2="tbl_f1_t2_ex2";
        marksEntry.dbTableNameT2E3="tbl_f1_t2_ex3";
        marksEntry.dbTableNameT3E1="tbl_f1_t3_ex1";
        marksEntry.dbTableNameT3E2="tbl_f1_t3_ex2";
        marksEntry.dbTableNameT3E3="tbl_f1_t3_ex3";
        marksEntry.dbTableNameT1Avg="tbl_f1_t1_avg";
        marksEntry.dbTableNameT2Avg="tbl_f1_t2_avg";
        marksEntry.dbTableNameT3Avg="tbl_f1_t3_avg";
        marksEntry.dbClassName="FORM_1";
        marksEntry.schName="WAVES ACADEMY LTD";
        marksEntry.clsName="Form 1";
        marksEntry.dbSubjectTable="tbl_f1_phy";
        marksEntry.subName="PHYSICS";
        marksEntry.sbj="phy";
        marksEntry.sbjg="phyg";
        marksEntry.pn="p6";
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/F1/classlist/showClasslist.fxml"));
            Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
            stage.getIcons().add(applicationIcon);

            MarksEntry marksEntry1 = (MarksEntry) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("FORM 1 PHYSICS[Marks Entry]");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void synchronize(){
        DatabaseSync databaseSync = new DatabaseSync();
        databaseSync.updateStudent();
        //databaseSync.addStudent(null,null);
    }

    public void openGrading(){
        try{
            Stage stageToClose = (Stage)windowCurrent.getScene().getWindow();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            //Pane root = (Pane)loader.load(getClass().getResource("../../grade/grade.fxml"));
            Pane root = (Pane)loader.load(getClass().getResource("/grade/grade.fxml"));
            Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
            stage.getIcons().add(applicationIcon);

            Grade grade = (Grade) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("GRADING and REMARKS");
            stage.setResizable(true);
            stage.show();
            stageToClose.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void Backup(){
        try{
            ManualBackup manualBackup = new ManualBackup();
            manualBackup.Backup();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void closeSystem(){
        System.exit(0);
    }

    public void openAbout(){
        try {
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/about/about.fxml"));

            About about = (About) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("ABOUT");
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setResizable(false);
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void adminMode(){
        try {
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("../password.fxml"));
            Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
            stage.getIcons().add(applicationIcon);

            Password password = (Password) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Admin Password");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(false);
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
