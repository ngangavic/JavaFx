package F1.reports;

import com.itextpdf.text.*;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.*;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Calendar;

public class ClassReport {
    public static String dbTableName;
    public static String className;
    public static String docName;
    public static String schoolNm;
    public static String reportTp;
    public static byte[] userPassword = "vicUser".getBytes();
    public static byte[] ownerPassword = "vicOwner".getBytes();
    String cname = System.getProperty("user.home");
    Calendar now = Calendar.getInstance();

    public void printClassResults(String printPassword)throws IOException, DocumentException{

        if(printPassword.toString().equals("vic")) {
            String sql = "SELECT * FROM " +dbTableName+" WHERE class='"+className+"' ORDER BY pt DESC";
            String engSum = "SELECT AVG(eng) SUM_ENG FROM " +dbTableName+" WHERE class='"+className+"'";
            String kisSum = "SELECT AVG(kis) SUM_KIS FROM " +dbTableName+" WHERE class='"+className+"'";
            String matSum = "SELECT AVG(mat) SUM_MAT FROM " +dbTableName+" WHERE class='"+className+"'";
            String chemSum = "SELECT AVG(chem) SUM_CHEM FROM " +dbTableName+" WHERE class='"+className+"'";
            String bioSum = "SELECT AVG(bio) SUM_BIO FROM " +dbTableName+" WHERE class='"+className+"'";
            String phySum = "SELECT AVG(phy) SUM_PHY FROM " +dbTableName+" WHERE class='"+className+"'";
            String geoSum = "SELECT AVG(geo) SUM_GEO FROM " +dbTableName+" WHERE class='"+className+"'";
            String hisSum = "SELECT AVG(his) SUM_HIS FROM " +dbTableName+" WHERE class='"+className+"'";
            String creSum = "SELECT AVG(cre) SUM_CRE FROM " +dbTableName+" WHERE class='"+className+"'";
            String busSum = "SELECT AVG(bus) SUM_BUS FROM " +dbTableName+" WHERE class='"+className+"'";
            String agriSum = "SELECT AVG(agri) SUM_AGRI FROM " +dbTableName+" WHERE class='"+className+"'";
            String totalSum = "SELECT AVG(total) SUM_TOTAL FROM " +dbTableName+" WHERE class='"+className+"'";
            String avgSum = "SELECT AVG(pt) SUM_PT FROM " +dbTableName+" WHERE class='"+className+"'";
            //String kcpeSum = "SELECT AVG(kcpe) SUM_KCPE FROM " +dbTableName+" WHERE class='"+className+"'";
            String kcpeSum = "SELECT AVG(kcpe) FROM " +dbTableName+" WHERE class='"+className+"'";
            try {
                Connection connection = Database.DBConnection.getConnection();
                ResultSet set = connection.createStatement().executeQuery(sql);
                ResultSet setEng = connection.createStatement().executeQuery(engSum);
                ResultSet setKis = connection.createStatement().executeQuery(kisSum);
                ResultSet setMat = connection.createStatement().executeQuery(matSum);
                ResultSet setChem = connection.createStatement().executeQuery(chemSum);
                ResultSet setBio = connection.createStatement().executeQuery(bioSum);
                ResultSet setPhy = connection.createStatement().executeQuery(phySum);
                ResultSet setGeo = connection.createStatement().executeQuery(geoSum);
                ResultSet setHis = connection.createStatement().executeQuery(hisSum);
                ResultSet setCre = connection.createStatement().executeQuery(creSum);
                ResultSet setBus = connection.createStatement().executeQuery(busSum);
                ResultSet setAgri = connection.createStatement().executeQuery(agriSum);
                ResultSet setTotal = connection.createStatement().executeQuery(totalSum);
                ResultSet setAvg = connection.createStatement().executeQuery(avgSum);
                ResultSet setKcpe = connection.createStatement().executeQuery(kcpeSum);

                Document document = new Document(PageSize.A4.rotate());
                PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(cname+"\\HS Results\\"+docName));
                writer.setEncryption(userPassword, ownerPassword,PdfWriter.ALLOW_PRINTING,PdfWriter.STANDARD_ENCRYPTION_128);
                writer.createXmpMetadata();
                document.open();
                Paragraph schoolName = new Paragraph(schoolNm, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.BOLD));
                Paragraph address = new Paragraph("P.O BOX 22332, LOCATION", new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.BOLD));
                Paragraph tell = new Paragraph("PHONE: 073293874", new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.BOLD));
                Paragraph reportType = new Paragraph(reportTp, new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.BOLD));
                schoolName.setAlignment(Element.ALIGN_CENTER);
                address.setAlignment(Element.ALIGN_CENTER);
                tell.setAlignment(Element.ALIGN_CENTER);
                reportType.setAlignment(Element.ALIGN_CENTER);
                document.add(schoolName);
                document.add(address);
                document.add(tell);
                document.add(reportType);
                document.add((new Paragraph(" ")));
                /**
                 * logo
                 * */
                Image img = Image.getInstance(cname+"\\HS Results\\logo.png");
                img.scaleAbsolute(100, 50);
                img.setAbsolutePosition(30, 500);
                document.add(img);

                PdfPTable table = new PdfPTable(17);
                table.setWidthPercentage(105);
                table.setSpacingBefore(0f);
                table.setSpacingAfter(0f);

                float[] colWidth = {0.4f, 0.5f, 3f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.6f, 0.5f, 0.5f};
                table.setWidths(colWidth);
                PdfPCell c17 = new PdfPCell(new Paragraph("#", new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD)));
                PdfPCell c1 = new PdfPCell(new Paragraph("ADM", new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD)));
                PdfPCell c2 = new PdfPCell(new Paragraph("NAME", new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD)));
                PdfPCell c3 = new PdfPCell(new Paragraph("ENG", new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD)));
                PdfPCell c4 = new PdfPCell(new Paragraph("KIS", new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD)));
                PdfPCell c5 = new PdfPCell(new Paragraph("MAT", new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD)));
                PdfPCell c6 = new PdfPCell(new Paragraph("CHEM", new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD)));
                PdfPCell c7 = new PdfPCell(new Paragraph("BIO", new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD)));
                PdfPCell c8 = new PdfPCell(new Paragraph("PHY", new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD)));
                PdfPCell c9 = new PdfPCell(new Paragraph("GEO", new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD)));
                PdfPCell c10 = new PdfPCell(new Paragraph("HIS", new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD)));
                PdfPCell c11 = new PdfPCell(new Paragraph("CRE", new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD)));
                PdfPCell c12 = new PdfPCell(new Paragraph("BUS", new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD)));
                PdfPCell c13 = new PdfPCell(new Paragraph("AGRI", new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD)));
                PdfPCell c14 = new PdfPCell(new Paragraph("TOTAL", new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD)));
                PdfPCell c15 = new PdfPCell(new Paragraph("AVG", new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD)));
                PdfPCell c16 = new PdfPCell(new Paragraph("KCPE", new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD)));

                table.addCell(c17);
                table.addCell(c1);
                table.addCell(c2);
                table.addCell(c3);
                table.addCell(c4);
                table.addCell(c5);
                table.addCell(c6);
                table.addCell(c7);
                table.addCell(c8);
                table.addCell(c9);
                table.addCell(c10);
                table.addCell(c11);
                table.addCell(c12);
                table.addCell(c13);
                table.addCell(c14);
                table.addCell(c15);
                table.addCell(c16);

                Font font =  new Font(Font.FontFamily.HELVETICA, 9, Font.NORMAL);

                int Count = 0;

                while (set.next()) {
                    Count++;
                    PdfPCell r17 = new PdfPCell(new Paragraph(String.valueOf(Count),font));
                    PdfPCell r1 = new PdfPCell(new Paragraph(set.getString(2),font));
                    PdfPCell r2 = new PdfPCell(new Paragraph(set.getString(3) + " " + set.getString(4) + " " + set.getString(5),font));
                    PdfPCell r3 = new PdfPCell(new Paragraph(set.getString(8) + " " + set.getString(9),font));
                    PdfPCell r4 = new PdfPCell(new Paragraph(set.getString(11) + " " + set.getString(12),font));
                    PdfPCell r5 = new PdfPCell(new Paragraph(set.getString(14) + " " + set.getString(15),font));
                    PdfPCell r6 = new PdfPCell(new Paragraph(set.getString(17) + " " + set.getString(18),font));
                    PdfPCell r7 = new PdfPCell(new Paragraph(set.getString(20) + " " + set.getString(21),font));
                    PdfPCell r8 = new PdfPCell(new Paragraph(set.getString(23) + " " + set.getString(24),font));
                    PdfPCell r9 = new PdfPCell(new Paragraph(set.getString(26) + " " + set.getString(27),font));
                    PdfPCell r10 = new PdfPCell(new Paragraph(set.getString(29) + " " + set.getString(30),font));
                    PdfPCell r11 = new PdfPCell(new Paragraph(set.getString(32) + " " + set.getString(33),font));
                    PdfPCell r12 = new PdfPCell(new Paragraph(set.getString(35) + " " + set.getString(36),font));
                    PdfPCell r13 = new PdfPCell(new Paragraph(set.getString(38) + " " + set.getString(39),font));
                    PdfPCell r14 = new PdfPCell(new Paragraph(set.getString(41),font));
                    PdfPCell r15 = new PdfPCell(new Paragraph(String.format("%.1f",Float.parseFloat(set.getString(43)))+ " " + set.getString(42),font));
                    PdfPCell r16 = new PdfPCell(new Paragraph(set.getString(6),font));

                    table.addCell(r17);
                    table.addCell(r1);
                    table.addCell(r2);
                    table.addCell(r3);
                    table.addCell(r4);
                    table.addCell(r5);
                    table.addCell(r6);
                    table.addCell(r7);
                    table.addCell(r8);
                    table.addCell(r9);
                    table.addCell(r10);
                    table.addCell(r11);
                    table.addCell(r12);
                    table.addCell(r13);
                    table.addCell(r14);
                    table.addCell(r15);
                    table.addCell(r16);
                }
                PdfPTable table2 = new PdfPTable(17);
                table2.setWidthPercentage(105);
                table2.setSpacingBefore(0f);
                table2.setSpacingAfter(0f);

                float[] colWidth2 = {0.4f, 0.5f, 3f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.6f, 0.5f, 0.5f};
                table2.setWidths(colWidth2);
                PdfPCell s1 = new PdfPCell(new Paragraph(" "));
                PdfPCell s2 = new PdfPCell(new Paragraph(" "));
                PdfPCell s3 = new PdfPCell(new Paragraph(" "));

                table2.addCell(s1);
                table2.addCell(s2);
                table2.addCell(s3);

                while (setEng.next()) {
                    float value = Float.parseFloat(setEng.getString(1));
                    PdfPCell s4 = new PdfPCell(new Paragraph(String.valueOf(Math.round(value)),font));
                    table2.addCell(s4);
                }
                while (setKis.next()) {
                    float value = Float.parseFloat(setKis.getString(1));
                    PdfPCell s5 = new PdfPCell(new Paragraph(String.valueOf(Math.round(value)),font));
                    table2.addCell(s5);
                }
                while (setMat.next()) {
                    float value = Float.parseFloat(setMat.getString(1));
                    PdfPCell s6 = new PdfPCell(new Paragraph(String.valueOf(Math.round(value)),font));
                    table2.addCell(s6);
                }
                while (setChem.next()) {
                    float value = Float.parseFloat(setChem.getString(1));
                    PdfPCell s7 = new PdfPCell(new Paragraph(String.valueOf(Math.round(value)),font));
                    table2.addCell(s7);
                }
                while (setBio.next()) {
                    float value = Float.parseFloat(setBio.getString(1));
                    PdfPCell s8 = new PdfPCell(new Paragraph(String.valueOf(Math.round(value)),font));
                    table2.addCell(s8);
                }
                while (setPhy.next()) {
                    float value = Float.parseFloat(setPhy.getString(1));
                    PdfPCell s9 = new PdfPCell(new Paragraph(String.valueOf(Math.round(value)),font));
                    table2.addCell(s9);
                }
                while (setGeo.next()) {
                    float value = Float.parseFloat(setGeo.getString(1));
                    PdfPCell s10 = new PdfPCell(new Paragraph(String.valueOf(Math.round(value)),font));
                    table2.addCell(s10);
                }
                while (setHis.next()) {
                    float value = Float.parseFloat(setHis.getString(1));
                    PdfPCell s11 = new PdfPCell(new Paragraph(String.valueOf(Math.round(value)),font));
                    table2.addCell(s11);
                }
                while (setCre.next()) {
                    float value = Float.parseFloat(setCre.getString(1));
                    PdfPCell s12 = new PdfPCell(new Paragraph(String.valueOf(Math.round(value)),font));
                    table2.addCell(s12);
                }
                while (setBus.next()) {
                    float value = Float.parseFloat(setBus.getString(1));
                    PdfPCell s13 = new PdfPCell(new Paragraph(String.valueOf(Math.round(value)),font));
                    table2.addCell(s13);
                }
                while (setAgri.next()) {
                    float value = Float.parseFloat(setAgri.getString(1));
                    PdfPCell s14 = new PdfPCell(new Paragraph(String.valueOf(Math.round(value)),font));
                    table2.addCell(s14);
                }
                while (setTotal.next()) {
                    float value = Float.parseFloat(setTotal.getString(1));
                    PdfPCell s15 = new PdfPCell(new Paragraph(String.valueOf(Math.round(value)),font));
                    table2.addCell(s15);
                }
                while (setAvg.next()) {
                    float value = (Float.parseFloat(setAvg.getString(1))) ;
                    PdfPCell s16 = new PdfPCell(new Paragraph(String.valueOf(String.format("%.2f",value)),font));
                    table2.addCell(s16);
                }
                while (setKcpe.next()) {
                    float value = Float.parseFloat(setKcpe.getString(1));
                    PdfPCell s17 = new PdfPCell(new Paragraph(String.valueOf(Math.round(value)),font));
                    table2.addCell(s17);
                }

                document.add(table);
                document.add(table2);
                document.close();
                writer.close();

                Desktop.getDesktop().open(new File(cname+"\\HS Results\\"+docName));
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
           System.out.println("An error occurred");
        }
    }

}
