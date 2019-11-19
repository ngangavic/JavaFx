package sample;

import com.itextpdf.text.*;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.PdfWriter;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class FeesPayment implements Initializable{
    @FXML
    private TextField tfAdm;

    @FXML
    private TextField tfAmount;

    @FXML
    private ComboBox cbAccount;

    @FXML
    private ComboBox cbMode;


    public void feesPayment2(){
        if (tfAdm.getText().isEmpty()||tfAmount.getText().isEmpty()||cbAccount.getSelectionModel().isEmpty()||cbMode.getSelectionModel().isEmpty()){
            System.out.print("Fill all fields");
        }else {



            try{
                String sql = "SELECT * FROM tbl_students WHERE adm=?";
                String sqlGetId = "SELECT id FROM tbl_paid ORDER BY id DESC LIMIT 1";
                Connection connection = DatabaseConn.getConnection();
                //get last id
                ResultSet setId = connection.createStatement().executeQuery(sqlGetId);
                while (setId.next()) {
                    int recNo = Integer.parseInt(setId.getString(1)) + 1;
                    PreparedStatement statement = connection.prepareStatement(sql);
                    statement.setString(1, tfAdm.getText());
                    ResultSet set = statement.executeQuery();
                    //get year of entry of the student and current year
                    while (set.next()) {
                        String year_of_entry = set.getString(7);
                        String current_year = set.getString(6);
                        //get fees to be paid for current years
                        String sumFees = "SELECT sum(fees) SUM_FEES FROM tbl_fees WHERE year BETWEEN ? AND ?";
                        PreparedStatement statementSumFees = connection.prepareStatement(sumFees);
                        statementSumFees.setString(1, year_of_entry);
                        statementSumFees.setString(2, current_year);
                        ResultSet setSum = statementSumFees.executeQuery();
                        while (setSum.next()) {
                            float value = Float.parseFloat(setSum.getString(1));
                            System.out.print(value);
                            //calculate the fees paid
                            String feePaid = "SELECT sum(amount) FROM tbl_paid WHERE adm=?";
                            PreparedStatement statementFeePaid = connection.prepareStatement(feePaid);
                            statementFeePaid.setString(1, tfAdm.getText());
                            ResultSet setFeePaid = statementFeePaid.executeQuery();
                            while (setFeePaid.next()) {
                                if (setFeePaid.getString(1) == null) {
                                    System.out.print("0");
                                    //calculate balance
                                    float balance = value - Float.parseFloat(tfAmount.getText());
                                    //insert into tbl_paid
                                    String insertPaid = "INSERT INTO tbl_paid(adm,amount,balance,account,method,date)VALUES(?,?,?,?,?,?)";
                                    PreparedStatement statementInsert = connection.prepareStatement(insertPaid);
                                    statementInsert.setString(1, tfAdm.getText());
                                    statementInsert.setString(2, tfAmount.getText());
                                    statementInsert.setString(3, String.valueOf(balance));
                                    statementInsert.setString(4, cbAccount.getValue().toString());
                                    statementInsert.setString(5, cbMode.getValue().toString());
                                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                                    LocalDateTime now = LocalDateTime.now();
                                    statementInsert.setString(6, dtf.format(now));
                                    statementInsert.execute();
                                } else {
                                    float valueFeePaid = Float.parseFloat(setFeePaid.getString(1));
                                    System.out.print(valueFeePaid);
                                    //calculate balance
                                    float balance = value - (valueFeePaid + Float.parseFloat(tfAmount.getText()));
                                    //insert into tbl_paid
                                    String insertPaid = "INSERT INTO tbl_paid(adm,amount,balance,account,method,date)VALUES(?,?,?,?,?,?)";
                                    PreparedStatement statementInsert = connection.prepareStatement(insertPaid);
                                    statementInsert.setString(1, tfAdm.getText());
                                    statementInsert.setString(2, tfAmount.getText());
                                    statementInsert.setString(3, String.valueOf(balance));
                                    statementInsert.setString(4, cbAccount.getValue().toString());
                                    statementInsert.setString(5, cbMode.getValue().toString());
                                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                                    LocalDateTime now = LocalDateTime.now();
                                    statementInsert.setString(6, dtf.format(now));
                                    statementInsert.execute();
                                    printReceipt(String.valueOf(recNo), "Caps lock", tfAdm.getText(), dtf.format(now), tfAmount.getText(), "form 1", cbMode.getValue(), balance);
                                    clearTextFields();

                                }
                            }
                        }
                    }
                }
            }catch (Exception e){
                clearTextFields();
                e.printStackTrace();
            }
        }

    }

    private void comboMode(){
        try {
            Connection connection = DatabaseConn.getConnection();
            String sql = "SELECT * FROM tbl_mode";
            ResultSet rs = connection.createStatement().executeQuery(sql);
            while (rs.next()){
                cbMode.getItems().addAll(rs.getString("name"));
            }
            //connection.close();
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    private void comboAcc(){
        try {
            Connection connection = DatabaseConn.getConnection();
            String sql = "SELECT * FROM tbl_accounts";
            ResultSet rs = connection.createStatement().executeQuery(sql);
            while (rs.next()){
                cbAccount.getItems().addAll(rs.getString("name"));
            }
            //connection.close();
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    private void clearTextFields(){
        tfAmount.clear();
        tfAdm.clear();
        cbAccount.getSelectionModel().clearSelection();
        cbMode.getSelectionModel().clearSelection();
    }

    public void printReceipt(String receiptNo, String name, String adm, String date, String amount, String classs, Object mode, float balance){
        try {
            Document document = new Document(PageSize.A6);
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("Receipt.pdf"));
            document.open();
            Paragraph schoolName = new Paragraph("SAMPLE SCHOOL NAME", new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.BOLD));
            Paragraph schoolAddress = new Paragraph("P.O BOX 3434 TOWN", new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.BOLD));
            Paragraph reportTitle = new Paragraph("SCHOOL OFFICIAL RECEIPT", new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.BOLD));
            schoolName.setAlignment(Element.ALIGN_CENTER);
            schoolAddress.setAlignment(Element.ALIGN_CENTER);
            reportTitle.setAlignment(Element.ALIGN_CENTER);
            document.add(schoolName);
            document.add(schoolAddress);
            document.add(reportTitle);
            document.add((new Paragraph(" ")));
            document.add((new Paragraph("Receipt No: "+receiptNo+"  "+"Adm No: "+adm+ " Date:"+date+" ",new Font(Font.FontFamily.TIMES_ROMAN, 9,Font.BOLD))));
            document.add((new Paragraph("Name: "+name+  " Class:"+classs+" ",new Font(Font.FontFamily.TIMES_ROMAN, 9,Font.BOLD))));

            document.add((new Paragraph(" ")));
            document.add((new Paragraph(" ")));
            document.add((new Paragraph("amount:"+amount)));
            document.add((new Paragraph("Mode"+mode)));
            document.add((new Paragraph("Balance"+balance)));
            document.close();
            writer.close();
           System.out.print("Receipt printed");
            Desktop.getDesktop().open(new File("C:\\Users\\Ng'ang'a Victor\\IdeaProjects\\School Accounting System\\Receipt.pdf"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        comboAcc();
        comboMode();
    }
}
