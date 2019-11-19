package F1.exams;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AverageHelper {
    public void UpdateData(PreparedStatement preparedStatement, PreparedStatement statementEx, PreparedStatement statementAvg, ResultSet set,float avg,int marks,String admCode) throws SQLException {
        while (set.next()){
            System.out.println(marks);
            String marksE, points,pointsAvg,g = "";
            if (marks >= Integer.parseInt(set.getString(4))) {
                marksE = "A";
                points = "12";
            } else if (marks >= Integer.parseInt(set.getString(5))) {
                marksE = "A-";
                points = "11";
            } else if (marks >= Integer.parseInt(set.getString(6))) {
                marksE = "B+";
                points = "10";
            } else if (marks >= Integer.parseInt(set.getString(7))) {
                marksE = "B";
                points = "9";
            } else if (marks >= Integer.parseInt(set.getString(8))) {
                marksE = "B-";
                points = "8";
            } else if (marks >= Integer.parseInt(set.getString(9))) {
                marksE = "C+";
                points = "7";
            } else if (marks >= Integer.parseInt(set.getString(10))) {
                marksE = "C";
                points = "6";
            } else if (marks >= Integer.parseInt(set.getString(11))) {
                marksE = "C-";
                points = "5";
            } else if (marks >= Integer.parseInt(set.getString(12))) {
                marksE = "D+";
                points = "4";
            } else if (marks >= Integer.parseInt(set.getString(13))) {
                marksE = "D";
                points = "3";
            } else if (marks >= Integer.parseInt(set.getString(14))) {
                marksE = "D-";
                points = "2";
            } else {
                marksE = "E";
                points = "1";
            }

            if (avg >= Integer.parseInt(set.getString(4))) {
                pointsAvg = "12";
                g = "A";
            } else if (avg >= Integer.parseInt(set.getString(5))) {
                pointsAvg = "11";
                g = "A-";
            } else if (avg >= Integer.parseInt(set.getString(6))) {
                pointsAvg = "10";
                g = "B+";
            } else if (avg >= Integer.parseInt(set.getString(7))) {
                pointsAvg = "9";
                g = "B";
            } else if (avg >= Integer.parseInt(set.getString(8))) {
                pointsAvg = "8";
                g = "B-";
            } else if (avg >= Integer.parseInt(set.getString(9))) {
                pointsAvg = "7";
                g = "C+";
            } else if (avg >= Integer.parseInt(set.getString(10))) {
                pointsAvg = "6";
                g = "C";
            } else if (avg >= Integer.parseInt(set.getString(11))) {
                pointsAvg = "5";
                g = "C-";
            } else if (avg >= Integer.parseInt(set.getString(12))) {
                pointsAvg = "4";
                g = "D+";
            } else if (avg >= Integer.parseInt(set.getString(13))) {
                pointsAvg = "3";
                g = "D";
            } else if (avg >= Integer.parseInt(set.getString(14))) {
                pointsAvg = "2";
                g = "D-";
            } else {
                pointsAvg = "1";
                g = "E";
            }

            preparedStatement.setString(1, String.valueOf(marks));
            preparedStatement.setString(2, marksE.toUpperCase());
            preparedStatement.setString(3, points.toUpperCase());
            preparedStatement.setString(4, admCode.toUpperCase());

            statementEx.setString(1, String.valueOf(marks));
            statementEx.setString(2, marksE.toUpperCase());
            statementEx.setString(3, points.toUpperCase());
            statementEx.setString(4, admCode.toUpperCase());

            statementAvg.setString(1, String.valueOf(String.format("%.0f", avg)));
            statementAvg.setString(2, g.toUpperCase());
            statementAvg.setString(3, pointsAvg.toUpperCase());
            statementAvg.setString(4, admCode.toUpperCase());



            statementEx.execute();
            preparedStatement.execute();
            statementAvg.execute();
        }
    }

}
