package start;

import org.h2.tools.Server;

import java.net.InetAddress;

public class ServerStart {

    /*public void StartServer(){
        try{
            Runtime runtime = Runtime.getRuntime();
            Process p = runtime.exec("C:\\xampp\\xampp_control.exe");
            //Process p = runtime.exec("C:\\xampp\\mysql\\bin\\mysqld.exe");
            //change the dbpass and dbname with your dbpass and dbname
            int processComplete = p.waitFor();

            if (processComplete == 0) {
                System.out.println("Server started successfully");
            } else {
                System.out.println("Could not start server");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }*/

    public void GetIp(){
        try{
            InetAddress ip = InetAddress.getLocalHost();
            String host = ip.getHostName();
            String hostAddress = ip.getHostAddress();
            Runtime runtime = Runtime.getRuntime();
            Process p = runtime.exec("ipconfig");
            //Process p = runtime.exec("C:\\xampp\\mysql\\bin\\mysqld.exe");
            //change the dbpass and dbname with your dbpass and dbname
System.out.println("This is the host name" + host);
System.out.println("This is the host address" + hostAddress);
System.out.println("This is the ip address" + ip);

            int processComplete = p.waitFor();
           // System.out.println(p.);
            if (processComplete == 0) {
                System.out.println("Ip got");
            } else {
                System.out.println("Ip not got");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void StartServer(){
        try{
            Server server = Server.createTcpServer().start();


        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
