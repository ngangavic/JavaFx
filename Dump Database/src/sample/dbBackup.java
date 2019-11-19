package sample;

public class dbBackup {

    public void backup(){
        Process p = null;
        try {

            Runtime runtime = Runtime.getRuntime();
            p = runtime.exec("C:\\xampp\\mysql\\bin\\mysqldump -u root -p java -r backup2.sql");
            //change the dbpass and dbname with your dbpass and dbname
            int processComplete = p.waitFor();

            if (processComplete == 0) {
                System.out.println("Backup created successfully");
            } else {
                System.out.println("Could not create the backup");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
