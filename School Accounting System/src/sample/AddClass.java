package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AddClass {
    @FXML
    private TextField tfClassName;

    public void insertClass(){
        if (tfClassName.getText().isEmpty()){
            System.out.print("You have to fill the text field");
        }else{
            String sql = "INSERT INTO tbl_class(class,date)VALUES(?,?)";
            try{
                   Connection connection = DatabaseConn.getConnection();
                   PreparedStatement statementInsert = connection.prepareStatement(sql);
                   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                   LocalDateTime now = LocalDateTime.now();
                   statementInsert.setString(1,tfClassName.getText());
                   statementInsert.setString(2, dtf.format(now));
                   statementInsert.execute();
                   tfClassName.clear();
            }catch (Exception e){
                tfClassName.clear();
                e.printStackTrace();
            }

        }
    }
}
