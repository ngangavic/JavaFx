package sample;

public class MyRunnable implements Runnable {


    @Override
    public void run() {
          System.out.println("Doing heavy processes");
          try{
              Thread.sleep(2000);
              ///do a database process
              doDBProcess();
          }catch (InterruptedException e){
              e.printStackTrace();
          }
          System.out.println("Done with doing the heavy process");
    }

    private void doDBProcess() throws InterruptedException {
        Thread.sleep(5000);
    }


}
