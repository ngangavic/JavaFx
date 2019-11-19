package start;

import java.io.File;

public class Installation {

    public void makeDirectories(){

        File file = new File("systemfiles");
        if (!file.exists()) {
            if (file.mkdir()) {
                System.out.println("Directory is created!");
            } else {
                System.out.println("Failed to create directory!");
            }
        }


    }


}
