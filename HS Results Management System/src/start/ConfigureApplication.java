package start;

import grade.Grade;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import teacher.Teacher;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;

public class ConfigureApplication {
    //1.Check if there is any connection to the database
    public void CheckConnection(){
        try{
            Connection connection = Database.DBConnection.getConnection();
            if (connection.equals(true)){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setTitle("Connected");
                alert.setContentText("Connected successfully");
                alert.show();
                alert.wait(5000);
                alert.close();
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Connection failure");
                alert.showAndWait();
            }
        }catch (Exception e){
e.printStackTrace();
        }
    }

    //2.check if the grading is done
    //public void CheckGrading(Stage ps){
    public void CheckGrading(){
        try{
            String sql = "SELECT COUNT(*) FROM tbl_grades";
            Connection connection = Database.DBConnection.getConnection();
            ResultSet set = connection.createStatement().executeQuery(sql);
            while (set.next()){
                System.out.println(set.getString(1));
                //return set.getString(1);
                if (set.getString(1).equals("48")){
                   System.out.println("system is okay");
                   CheckComments();
                }else{
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setHeaderText(null);
                    alert.setTitle("System error");
                    alert.setContentText("You have not completed setting grades. The system will not work properly.\n Do you want to set now?");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.showAndWait();
                    if (alert.getResult().getButtonData().isCancelButton()){
                        System.out.println("system cannot work");
                        System.exit(0);
                    }else {
                        try{
                            Stage stage = new Stage();
                            FXMLLoader loader = new FXMLLoader();
                            Pane root = (Pane)loader.load(getClass().getResource("/grade/grade.fxml"));
                            Grade grade = (Grade) loader.getController();
                            Scene scene = new Scene(root);
                            stage.setScene(scene);
                            stage.setTitle("GRADING and REMARKS");
                            stage.setResizable(true);
                            //stage.wait(5000);
                            stage.show();
                        }catch (IOException e){
                            e.printStackTrace();
                        }
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //3.check comments
    public void CheckComments(){
        String sql = "SELECT * FROM tbl_comments WHERE id='1'";
        try{
            Connection connection = Database.DBConnection.getConnection();
            ResultSet set = connection.createStatement().executeQuery(sql);
            while (set.next()){
                if (set.getString(2).equals(null)||
                set.getString(3).equals(null)||
                        set.getString(4).equals(null)||
                        set.getString(5).equals(null)||
                set.getString(6).equals(null)||
                set.getString(7).equals(null)||
                        set.getString(8).equals(null)||
                        set.getString(9).equals(null)||
                set.getString(10).equals(null)||
                set.getString(11).equals(null)||
                set.getString(12).equals(null)||
                set.getString(13).equals(null)){
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setHeaderText(null);
                    alert.setTitle("System error");
                    alert.setContentText("You have not completed setting comments. The system will not work properly.\n Do you want to set now?");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.showAndWait();
                    if (alert.getResult().getButtonData().isCancelButton()){
                        System.out.println("system cannot work without comments");
                        System.exit(0);
                    }else {
                        try{
                            Stage stage = new Stage();
                            FXMLLoader loader = new FXMLLoader();
                            Pane root = (Pane)loader.load(getClass().getResource("/grade/grade.fxml"));
                            Grade grade = (Grade) loader.getController();
                            Scene scene = new Scene(root);
                            stage.setScene(scene);
                            stage.setTitle("GRADING and REMARKS");
                            stage.setResizable(true);
                            //stage.wait();
                            stage.show();
                        }catch (IOException e){
                            e.printStackTrace();
                        }
                    }
                }else{
                    //open sys
                    System.out.println("System is okay for comments");
                    CheckTeachers();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //4.check teachers
    public void CheckTeachers(){
        String sql = "SELECT COUNT(*) FROM tbl_teacher";
        try{
            Connection connection = Database.DBConnection.getConnection();
            ResultSet set = connection.createStatement().executeQuery(sql);
            while (set.next()){
                if (set.getString(1).equals("44")){
                    System.out.println("System is okay for teachers");
                }else{
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setHeaderText(null);
                    alert.setTitle("System error");
                    alert.setContentText("You have not completed entering teachers. The system will not work properly.\n Do you want to complete now?");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.showAndWait();
                    if (alert.getResult().getButtonData().isCancelButton()){
                        System.out.println("system cannot work without teachers");
                        System.exit(0);
                    }else {
                        try{
                            Stage stage = new Stage();
                            FXMLLoader loader = new FXMLLoader();
                            Pane root = (Pane)loader.load(getClass().getResource("/teacher/teacher.fxml"));
                            //Pane root = (Pane)loader.load(getClass().getResource("../../teacher/teacher.fxml"));

                            Teacher teacher = (Teacher) loader.getController();

                            Scene scene = new Scene(root);
                            stage.setScene(scene);
                            stage.setTitle("TEACHERS");
                            stage.setResizable(true);
                            stage.show();
                        }catch (IOException e){
                            e.printStackTrace();
                        }
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }



}
