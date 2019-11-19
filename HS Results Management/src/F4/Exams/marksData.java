package F4.Exams;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class marksData {
    private final StringProperty id;
    private final StringProperty adm;
    private final StringProperty fname;
    private final StringProperty mname;
    private final StringProperty lname;
    private final StringProperty ex1t1;
    private final StringProperty ex2t1;
    private final StringProperty ex3t1;
    private final StringProperty ex1t2;
    private final StringProperty ex2t2;
    private final StringProperty ex3t2;
    private final StringProperty ex1t3;
    private final StringProperty ex2t3;
    private final StringProperty ex3t3;

    public marksData(String ID,String ADM,String FNAME,String MNAME, String LNAME,String EX1T1,String EX2T1,String EX3T1,String EX1T2,String EX2T2,String EX3T2,String EX1T3,String EX2T3,String EX3T3){
        this.id = new SimpleStringProperty(ID);
        this.adm = new SimpleStringProperty(ADM);
        this.fname = new SimpleStringProperty(FNAME);
        this.mname = new SimpleStringProperty(MNAME);
        this.lname = new SimpleStringProperty(LNAME);
        this.ex1t1 = new SimpleStringProperty(EX1T1);
        this.ex2t1 = new SimpleStringProperty(EX2T1);
        this.ex3t1 = new SimpleStringProperty(EX3T1);
        this.ex1t2 = new SimpleStringProperty(EX1T2);
        this.ex2t2 = new SimpleStringProperty(EX2T2);
        this.ex3t2 = new SimpleStringProperty(EX3T2);
        this.ex1t3 = new SimpleStringProperty(EX1T3);
        this.ex2t3 = new SimpleStringProperty(EX2T3);
        this.ex3t3 = new SimpleStringProperty(EX3T3);
    }

    public String getId() {
        return id.get();
    }

    public StringProperty idProperty() {
        return id;
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public String getAdm() {
        return adm.get();
    }

    public StringProperty admProperty() {
        return adm;
    }

    public void setAdm(String adm) {
        this.adm.set(adm);
    }

    public String getFname() {
        return fname.get();
    }

    public StringProperty fnameProperty() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname.set(fname);
    }

    public String getMname() {
        return mname.get();
    }

    public StringProperty mnameProperty() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname.set(mname);
    }

    public String getLname() {
        return lname.get();
    }

    public StringProperty lnameProperty() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname.set(lname);
    }

    public String getEx1t1() {
        return ex1t1.get();
    }

    public StringProperty ex1t1Property() {
        return ex1t1;
    }

    public String setEx1t1(String ex1t1) {
        this.ex1t1.set(ex1t1);
        return ex1t1;
    }

    public String getEx2t1() {
        return ex2t1.get();
    }

    public StringProperty ex2t1Property() {
        return ex2t1;
    }

    public String setEx2t1(String ex2t1) {
        this.ex2t1.set(ex2t1);
        return ex2t1;
    }

    public String getEx3t1() {
        return ex3t1.get();
    }

    public StringProperty ex3t1Property() {
        return ex3t1;
    }

    public String setEx3t1(String ex3t1) {
        this.ex3t1.set(ex3t1);
        return ex3t1;
    }

    public String getEx1t2() {
        return ex1t2.get();
    }

    public StringProperty ex1t2Property() {
        return ex1t2;
    }

    public String setEx1t2(String ex1t2) {
        this.ex1t2.set(ex1t2);
        return ex1t2;
    }

    public String getEx2t2() {
        return ex2t2.get();
    }

    public StringProperty ex2t2Property() {
        return ex2t2;
    }

    public String setEx2t2(String ex2t2) {
        this.ex2t2.set(ex2t2);
        return ex2t2;
    }

    public String getEx3t2() {
        return ex3t2.get();
    }

    public StringProperty ex3t2Property() {
        return ex3t2;
    }

    public String setEx3t2(String ex3t2) {
        this.ex3t2.set(ex3t2);
        return ex3t2;
    }

    public String getEx1t3() {
        return ex1t3.get();
    }

    public StringProperty ex1t3Property() {
        return ex1t3;
    }

    public String setEx1t3(String ex1t3) {
        this.ex1t3.set(ex1t3);
        return ex1t3;
    }

    public String getEx2t3() {
        return ex2t3.get();
    }

    public StringProperty ex2t3Property() {
        return ex2t3;
    }

    public String setEx2t3(String ex2t3) {
        this.ex2t3.set(ex2t3);
        return ex2t3;
    }

    public String getEx3t3() {
        return ex3t3.get();
    }

    public StringProperty ex3t3Property() {
        return ex3t3;
    }

    public String setEx3t3(String ex3t3) {
        this.ex3t3.set(ex3t3);
        return ex3t3;
    }
}
