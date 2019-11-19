package sample;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Controller {

    public void insertData(){
        //String sql="SELECT (adm,fname,mname,lname,kcpe,class) INTO tbl_f4_agri FROM tbl_students";
        String sqlStudents = "SELECT * FROM tbl_temporary ";
        String checkExists="SELECT * FROM tbl_f1_agri";
        String sqlDlt = "DELETE FROM tbl_temporary";
        String sql="INSERT INTO tbl_f1_agri (adm,fname,mname,lname,kcpe,class) SELECT adm,fname,mname,lname,kcpe,class FROM tbl_temporary ";
        try {
            Connection connection = Database.DBConnection.getConnection();
            //check student from subject table
            //ResultSet checkStudents = connection.createStatement().executeQuery(checkExists);
            //String adm = checkStudents.getString(1);
            //String adm = checkStudents.getString(2);
            //PreparedStatement statementStudent = connection.prepareStatement(sqlStudents);
            //statementStudent.setString(1,adm);
            ResultSet setStudents = connection.createStatement().executeQuery(sqlStudents);

            //PreparedStatement statement = connection.prepareStatement(sql);
            //String adm = setStudents.getString(2);
            //statement.setString(1,adm);

           /// for (int i = 0; i < 1; i++) {

            //}
            //String adm = setStudents.getString(2);
            //while (setStudents.next()) {
                PreparedStatement statement = connection.prepareStatement(sql);
                //String adm = setStudents.getString(2);
                //System.out.print(adm);
                //statement.setString(1, String.valueOf(adm));
                statement.execute();
                PreparedStatement statementDlt = connection.prepareStatement(sqlDlt);
                //statementDlt.setString(1,adm);
                statementDlt.execute();
                // PreparedStatement checkStudentExists = connection.prepareStatement(sql);
                //checkStudentExists.setString(1,adm);

            //}

       // }
            //statement.execute();
            System.out.print("Am done...Check it out");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
