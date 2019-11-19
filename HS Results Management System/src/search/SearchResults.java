package search;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class SearchResults {

    @FXML
    private Label schoolName;

    @FXML
    private TableView<tableData> tableResults,tableResultsF2,tableResultsF3,tableResultsF4;

    @FXML
    private TableColumn<tableData, String> admCol,nameCol,engCol,engGr,kisCol,kisGr,matCol,matGr,chemCol,chemGr,bioCol,bioGr,phyCol,phyGr,geoCol,geoGr,hisCol,hisGr,creCol,creGr,busCol,busGr,agriCol,agriGr,totalCol,avgCol,pointsCol,kcpeCol;

    @FXML
    private TableColumn<tableData, String> admColF2,nameColF2,engColF2,engGrF2,kisColF2,kisGrF2,matColF2,matGrF2,chemColF2,chemGrF2,bioColF2,bioGrF2,phyColF2,phyGrF2,geoColF2,geoGrF2,hisColF2,hisGrF2,creColF2,creGrF2,busColF2,busGrF2,agriColF2,agriGrF2,totalColF2,avgColF2,pointsColF2,kcpeColF2;

    @FXML
    private TableColumn<tableData, String> admColF3,nameColF3,engColF3,engGrF3,kisColF3,kisGrF3,matColF3,matGrF3,chemColF3,chemGrF3,bioColF3,bioGrF3,phyColF3,phyGrF3,geoColF3,geoGrF3,hisColF3,hisGrF3,creColF3,creGrF3,busColF3,busGrF3,agriColF3, agriGrF3,totalColF3,avgColF3,pointsColF3,kcpeColF3;

    @FXML
    private TableColumn<tableData, String> admColF4,nameColF4,engColF4,engGrF4,kisColF4,kisGrF4,matColF4,matGrF4,chemColF4,chemGrF4,bioColF4,bioGrF4,phyColF4,phyGrF4,geoColF4,geoGrF4,hisColF4,hisGrF4,creColF4,creGrF4,busColF4,busGrF4,agriColF4,agriGrF4,totalColF4,avgColF4,pointsColF4,kcpeColF4;

    @FXML
    private MenuBar menuBar;

    @FXML
    private MenuItem addBar;

    @FXML
    private Label admLabel;

    @FXML
    private Label nameLabel;

    @FXML
    private Label dobLabel;

    @FXML
    private Label kcseLabel;

    @FXML
    void printClassReport(ActionEvent event) {

    }

    @FXML
    void printReportForms(ActionEvent event) {

    }


}
