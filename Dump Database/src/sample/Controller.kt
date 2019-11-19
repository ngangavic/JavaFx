package sample

import java.util.Properties

class Controller {
    internal var cname = System.getProperty("user.home")

    fun backupDB() {
        val savePath = "$cname\\HS Results\\backup.sql"
        //String savePath = "C:\\Users\\Ng'ang'a Victor\\HS Results\\backup.sql";
        println(cname)
        println(savePath)
        //mysqldump -u Username -pPassword --add-drop-database -B databaseName -r backupPath
        //String executeCmd = "C:\\xampp\\mysql\\bin\\mysqldump -u root -p  --database android -r " + savePath;
        val executeCmd = "C:\\xampp\\mysql\\bin\\mysqldump -u root  java -r backup.sql"
        val process: Process
        try {
            process = Runtime.getRuntime().exec(executeCmd)
            val processComplete = process.waitFor()

            if (processComplete == 0) {
                println("Backup created")

            } else {
                println("Could not create backup")
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

}
