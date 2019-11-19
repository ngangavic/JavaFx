package Database;

import javafx.scene.control.Alert;
import javafx.stage.Modality;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection {
    /*private static final String SQLITECONN="jdbc:sqlite:HSdb.sqlite";
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
            return DriverManager.getConnection(SQLITECONN);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }*/
    /*public static Connection getConnection() {
        try{
            InetAddress ip = InetAddress.getLocalHost();
            String host = ip.getHostName();
            String hostAddress = ip.getHostAddress();
            Runtime runtime = Runtime.getRuntime();
            Process p = runtime.exec("ipconfig");
            System.out.println("This is the host address" + hostAddress);

            int processComplete = p.waitFor();

            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/hsresults","root","");
           //Connection connection = DriverManager.getConnection("jdbc:mysql://"+hostAddress+":3306/hsresults","needle","");
            return connection;
            //connection.
        } catch (SQLException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Connection not successfull");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.show();
            try {
                Thread.sleep(10000);
                System.exit(0);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }*/
    public static Connection getConnection()throws SQLException {
        try{
            Class.forName("org.h2.Driver");
            //Connection connection = DriverManager.getConnection("jdbc:h2:~/hsresults", "sa", "");
           // Connection connection = DriverManager.getConnection("jdbc:h2:file:C:\\Users\\Ng'ang'a Victor\\IdeaProjects\\HS Results Management System\\src\\Database\\hsresults", "sa", "");
            Connection connection = DriverManager.getConnection("jdbc:h2:./dataB/hsresults", "sa", "");
            //Connection connection = DriverManager.getConnection("jdbc:h2:/dataB/hsresults", "sa", "");
            //Connection connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~\\C:\\Users\\Ng'ang'a Victor\\IdeaProjects\\HS Results Management System\\out\\artifacts\\HS_Results_Management_System_jar\\hsresults", "sa", "");
            return connection;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
