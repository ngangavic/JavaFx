package Database;

import javafx.scene.control.Alert;
import javafx.stage.Modality;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CheckConnection {

    public static Connection getConnection() {
        try{
            InetAddress ip = InetAddress.getLocalHost();
            String host = ip.getHostName();
            String hostAddress = ip.getHostAddress();
            Runtime runtime = Runtime.getRuntime();
            Process p = runtime.exec("ipconfig");
            System.out.println("This is the host address" + hostAddress);

            int processComplete = p.waitFor();
            // System.out.println(p.);
            if (processComplete == 0) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Success");
                alert.setContentText("Connection successful");
                alert.setHeaderText(null);
                alert.initModality(Modality.APPLICATION_MODAL);
                alert.show();
                Thread.sleep(10000);
                alert.close();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("Cannot find ip address.\n Check your connection and try again");
                alert.setHeaderText(null);
                alert.initModality(Modality.APPLICATION_MODAL);
                alert.show();
            }
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/hsresults","root","");
            //Connection connection = DriverManager.getConnection("jdbc:mysql://"+hostAddress+":3306/hsresults","needle","");

            //connection.
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Success");
            alert.setContentText("Connection successful2");
            alert.setHeaderText(null);
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.show();
            Thread.sleep(10000);
            alert.close();
            return connection;

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
    }
}
