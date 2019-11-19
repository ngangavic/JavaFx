package sample;

import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.jmx.MXNodeAlgorithm;
import com.sun.javafx.jmx.MXNodeAlgorithmContext;
import com.sun.javafx.sg.prism.NGNode;
import javafx.concurrent.Worker;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.io.File;
import java.net.URL;
import java.util.Base64;
import java.util.ResourceBundle;

import javafx.stage.Stage;
import org.apache.commons.io.FileUtils;
import sun.plugin.javascript.JSObject;


public class Controller implements Initializable {
    @FXML
    private WebView web;

    @FXML
    private Button btn,btn2;
    private final Label jobStatus = new Label();
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        WebEngine engine = web.getEngine();
        String url = getClass().getResource("resources/web/viewer.html").toExternalForm();

        // connect CSS styles to customize pdf.js appearance
//        engine.setUserStyleSheetLocation(getClass().getResource("/web.css").toExternalForm());

        engine.setJavaScriptEnabled(true);
        //engine.load(url);

        engine.getLoadWorker()
                .stateProperty()
                .addListener((observable, oldValue, newValue) -> {
                    // to debug JS code by showing console.log() calls in IDE console
                   // JSObject window = (JSObject) engine.executeScript("window");
                   // window.setMember("java", new Main());
                    //engine.executeScript("console.log = function(message){ java.log(message); };");

                    // this pdf file will be opened on application startup
                    if (newValue == Worker.State.SUCCEEDED) {
                        try {
                            // readFileToByteArray() comes from commons-io library
                            //byte[] data = FileUtils.readFileToByteArray(new File("C:\\Users\\Ng'ang'a Victor\\IdeaProjects\\JavaFx pdf viewer\\52407724916-860301455-ticket.pdf"));
                            //byte[] data = FileUtils.readFileToByteArray(new File("C:\\Users\\Ng'ang'a Victor\\IdeaProjects\\JavaFx pdf viewer\\classReport.pdf"));
                            byte[] data = FileUtils.readFileToByteArray(new File("classReport.pdf"));
                            String base64 = Base64.getEncoder().encodeToString(data);
                            // call JS function from Java code
                            //engine.executeScript("openFileFromBase64('" + base64 + "')");
                            web.getEngine().executeScript("openFileFromBase64('" + base64 + "')");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });

        // this file will be opened on button click
        btn.setOnAction(actionEvent -> {
            try {
                //byte[] data = FileUtils.readFileToByteArray(new File("/path/to/another/file"));
                byte[] data = FileUtils.readFileToByteArray(new File("classReport.pdf"));
                String base64 = Base64.getEncoder().encodeToString(data);
                web.getEngine().executeScript("openFileFromBase64('" + base64 + "')");
//                engine.executeScript("openFileFromBase64('" + base64 + "')");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
       /* btn2.setOnAction((ActionEvent e) -> {
            PrinterJob job = PrinterJob.createPrinterJob();
            if (job != null) {
                engine.print(job);
                job.endJob();
            }
            });*/

        btn2.setOnAction((ActionEvent e) -> {
            Stage stage = new Stage();
            File file = new File("classReport.pdf");
            Node node = new Node() {
                @Override
                protected NGNode impl_createPeer() {
                    return null;
                }

                @Override
                public BaseBounds impl_computeGeomBounds(BaseBounds bounds, BaseTransform tx) {
                    return null;
                }

                @Override
                protected boolean impl_computeContains(double localX, double localY) {
                    return false;
                }

                @Override
                public Object impl_processMXNode(MXNodeAlgorithm alg, MXNodeAlgorithmContext ctx) {
                    return null;
                }
            };

            // Create the Text Label
            Label textLabel = new Label("Please insert your Text:");

            // Create the TextArea
            final TextArea textArea = new TextArea();

            // Create the Buttons
            Button printSetupButton = new Button("Print Setup and Print");

            // Create the Event-Handlers for the Button
            printSetupButton.setOnAction(new EventHandler<ActionEvent>()
            {
                public void handle(ActionEvent event)
                {
                    printSetup(textArea, stage);
                }
            });

            // Create the Status Box
            HBox jobStatusBox = new HBox(5, new Label("Job Status: "), jobStatus);
            // Create the Button Box
            HBox buttonBox = new HBox(printSetupButton);

            // Create the VBox
            VBox root = new VBox(5);

            // Add the Children to the VBox
            root.getChildren().addAll(textLabel, textArea, buttonBox, jobStatusBox);
            // Set the Size of the VBox
            root.setPrefSize(400, 300);

            // Set the Style-properties of the VBox
            root.setStyle("-fx-padding: 10;" +
                    "-fx-border-style: solid inside;" +
                    "-fx-border-width: 2;" +
                    "-fx-border-insets: 5;" +
                    "-fx-border-radius: 5;" +
                    "-fx-border-color: blue;");

            // Create the Scene
            Scene scene = new Scene(root);
            // Add the scene to the Stage
            stage.setScene(scene);
            // Set the title of the Stage
            stage.setTitle("A Printing Dialog Example");
            // Display the Stage
            stage.show();
            // Create the PrinterJob
            PrinterJob job = PrinterJob.createPrinterJob();

            if (job == null)
            {
                return;
            }

            // Show the print setup dialog
            boolean proceed = job.showPrintDialog(stage);

            if (proceed)
            {
                print(job, node);
            }
        });

    }

    @FXML private void printPdf(){
        Stage stage = new Stage();
        Label textLabel = new Label("Please insert your Text:");

        // Create the TextArea
        final TextArea textArea = new TextArea();

        // Create the Buttons
        Button printSetupButton = new Button("Print Setup and Print");

        // Create the Event-Handlers for the Button
        printSetupButton.setOnAction(new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent event)
            {
                printSetup(textArea, stage);
            }
        });

        // Create the Status Box
        HBox jobStatusBox = new HBox(5, new Label("Job Status: "), jobStatus);
        // Create the Button Box
        HBox buttonBox = new HBox(printSetupButton);

        // Create the VBox
        VBox root = new VBox(5);

        // Add the Children to the VBox
        root.getChildren().addAll(textLabel, textArea, buttonBox, jobStatusBox);
        // Set the Size of the VBox
        root.setPrefSize(400, 300);

        // Set the Style-properties of the VBox
        root.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");

        // Create the Scene
        Scene scene = new Scene(root);
        // Add the scene to the Stage
        stage.setScene(scene);
        // Set the title of the Stage
        stage.setTitle("A Printing Dialog Example");
        // Display the Stage
        stage.show();


    }

    private void printSetup(Node node, Stage owner) {
        // Create the PrinterJob
        PrinterJob job = PrinterJob.createPrinterJob();

        if (job == null)
        {
            return;
        }

        // Show the print setup dialog
        boolean proceed = job.showPrintDialog(owner);

        if (proceed)
        {
            print(job, node);
        }
    }

    private void print(PrinterJob job, Node node) {
        // Set the Job Status Message
        jobStatus.textProperty().bind(job.jobStatusProperty().asString());

        // Print the node
        boolean printed = job.printPage(node);

        if (printed)
        {
            job.endJob();
        }
    }

}
