package sample;

public class RestoreDb {

    public void restore(){
        String [] executeCmd = new String[]{"C:\\xampp\\mysql\\bin\\mysqldump, -u root  java, -e, source backup.sql"};
        Process p;
        try {

            Runtime runtime = Runtime.getRuntime();
            //p = runtime.exec("C:\\xampp\\mysql\\bin\\mysqldump -u root -p android -r backup2.sql");
            p = runtime.exec(executeCmd);
            //change the dbpass and dbname with your dbpass and dbname
            int processComplete = p.waitFor();

            if (processComplete == 0) {
                System.out.println("restore created successfully");
            } else {
                System.out.println("Could not create the restore");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
