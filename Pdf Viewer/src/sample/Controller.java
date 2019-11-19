package sample;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import org.apache.commons.io.FileUtils;
import sun.misc.IOUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Base64;
import java.util.ResourceBundle;

import org.apache.commons.io.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;


public class Controller implements Initializable {
    @FXML
    Button btnTest;
    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }

    @FXML
    private void openPdf() {
        WebView webView = new WebView();
        WebEngine engine = webView.getEngine();
//Change the path according to yours.
        String url = this.getClass().getResource("resources/web/viewer.html").toExternalForm();
//We add our stylesheet.
        //engine.setUserStyleSheetLocation(getClass().getResource("resources/web/web.css").toExternalForm());
        engine.setJavaScriptEnabled(true);
        engine.load(url);

        InputStream stream = null;
        try {

            // readFileToByteArray() comes from commons-io library
            byte[] data = FileUtils.readFileToByteArray(new File("C:\\Users\\Ng'ang'a Victor\\IdeaProjects\\JavaFx pdf viewer\\classReport.pdf"));


//            stream = myUrl.openStream();
            //I use IOUtils from org.​apache.​commons.​io
//            byte[] data = IOUtils.toByteArray(stream);
            //Base64 from java.util
            String base64 = Base64.getEncoder().encodeToString(data);
           // boolean bool = Platform.isFxApplicationThread();
           // if (bool) {
                //This must be ran on FXApplicationThread - previous bool confirms it
                //webView.getEngine().executeScript("openFileFromBase64('" + base64 + "')");
                engine.executeScript("openFileFromBase64('" + base64 + "')");
           // }else{
                System.out.println("NOT --FX-- APPLICATION THREAD");
           // }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (stream != null) {
                try {
                    stream.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

}


