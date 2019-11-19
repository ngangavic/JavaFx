package backup;

import javafx.scene.control.Alert;
import start.SplashScreen;

import java.io.File;
import java.util.Calendar;

public class AutoBackup {
    //create a directory called system
    //backup one file always
    Calendar now = Calendar.getInstance();
    String cname = System.getProperty("user.home");

    public void Backup(){
        try {

            //String path = cname+"\\HS Results\\backup"+now.get(Calendar.YEAR)+now.get(Calendar.MONTH)+".sql";
            String path = "systemfiles\\autobackup"+now.get(Calendar.YEAR)+now.get(Calendar.MONTH)+".sql";
            Runtime runtime = Runtime.getRuntime();

            System.out.println(path);
            //Process p = runtime.exec("C:\\xampp\\mysql\\bin\\mysqldump -u root -p android -r backup2.sql");
            //Process p = runtime.exec("C:\\xampp\\mysql\\bin\\mysqldump -u root   android -r "+path);
            Process p = runtime.exec("C:\\xampp\\mysql\\bin\\mysqldump -u root   hsresults -r "+path);
            //Process p = runtime.exec("mysqldump -u root hsresults -r "+path);
            //change the dbpass and dbname with your dbpass and dbname
            int processComplete = p.waitFor();

            if (processComplete == 0) {
              /*  Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText(null);
                alert.setContentText("Backup created successfully");*/
               // alert.showAndWait();
                System.out.println("Backup created successfully");
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Could not create the backup");
                alert.showAndWait();
                System.out.println("Could not create the backup");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
