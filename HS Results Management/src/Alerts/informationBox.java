package Alerts;

import javafx.scene.control.Alert;

public class informationBox {
    public static void infoBox(String infoMessage, String titleBar, String headerMessage){

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titleBar);
        alert.setHeaderText(headerMessage);
        alert.setContentText(infoMessage);
        alert.showAndWait();

    }

    public static void infoBoxError(String infoMessage, String titleBar, String headerMessage){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titleBar);
        alert.setHeaderText(headerMessage);
        alert.setContentText(infoMessage);
        alert.showAndWait();

    }

    public static void infoBoxConfirm(String infoMessage, String titleBar, String headerMessage){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(titleBar);
        alert.setHeaderText(headerMessage);
        alert.setContentText(infoMessage);
        alert.showAndWait();

    }

    public static void infoBoxWarning(String infoMessage, String titleBar, String headerMessage){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(titleBar);
        alert.setHeaderText(headerMessage);
        alert.setContentText(infoMessage);
        alert.showAndWait();

    }
}
