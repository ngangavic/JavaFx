package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Controller {

    @FXML
    private TextField fname;

    @FXML
    private TextField lname;

    @FXML
    private TextField kcpe;

    @FXML
    private TextField classes;

   public void insertData(){
       String [] queries = {
               "insert into employee (name, city, phone) values ('A', 'X', '123')",
               "insert into employee (name, city, phone) values ('B', 'Y', '234')",
               "insert into employee (name, city, phone) values ('C', 'Z', '345')",
       };
       try {
           Connection connection = Database.getConnection();
           PreparedStatement ps = connection.prepareStatement(queries[3]);

           final int batchSize = 1000;
           int count = 0;

          for (String queri : queries) {

               ps.setString(1, fname.getText());
               ps.setString(2, lname.getText());
               ps.setString(3, kcpe.getText());
               ps.setString(3, classes.getText());

               ps.addBatch();

               if (++count % batchSize == 0) {
                   ps.executeBatch();
               }
           }
           /*for (String query : queries) {
               ps.setString(1, fname.getText());
               ps.setString(2, lname.getText());
               ps.setString(3, kcpe.getText());
               ps.setString(3, classes.getText());
               ps.addBatch(query);
           }*/
           ps.executeBatch(); // insert remaining records
           ps.close();
           connection.close();
       }catch (Exception e){
           e.printStackTrace();
       }
   }


}
