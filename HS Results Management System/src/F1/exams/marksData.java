package F1.exams;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class marksData {
    private final StringProperty adm;
    private final StringProperty fname;
    private final StringProperty mname;
    private final StringProperty lname;
    private final StringProperty term1Exam1;
    private final StringProperty term1Exam2;
    private final StringProperty term1Exam3;
    private final StringProperty term2Exam1;
    private final StringProperty term2Exam2;
    private final StringProperty term2Exam3;
    private final StringProperty term3Exam1;
    private final StringProperty term3Exam2;
    private final StringProperty term3Exam3;

    public marksData(String adm, String fname, String mname, String lname, String term1Exam1, String term1Exam2, String term1Exam3, String term2Exam1, String term2Exam2, String term2Exam3, String term3Exam1, String term3Exam2, String term3Exam3) {
        this.adm = new SimpleStringProperty(adm);
        this.fname = new SimpleStringProperty(fname);
        this.mname = new SimpleStringProperty(mname);
        this.lname = new SimpleStringProperty(lname);
        this.term1Exam1 = new SimpleStringProperty(term1Exam1);
        this.term1Exam2 = new SimpleStringProperty(term1Exam2);
        this.term1Exam3 = new SimpleStringProperty(term1Exam3);
        this.term2Exam1 = new SimpleStringProperty(term2Exam1);
        this.term2Exam2 = new SimpleStringProperty(term2Exam2);
        this.term2Exam3 = new SimpleStringProperty(term2Exam3);
        this.term3Exam1 = new SimpleStringProperty(term3Exam1);
        this.term3Exam2 = new SimpleStringProperty(term3Exam2);
        this.term3Exam3 = new SimpleStringProperty(term3Exam3);
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

    public String getTerm1Exam1() {
        return term1Exam1.get();
    }

    public StringProperty term1Exam1Property() {
        return term1Exam1;
    }

    public String setTerm1Exam1(String term1Exam1) {
        this.term1Exam1.set(term1Exam1);
        return term1Exam1;
    }

    public String getTerm1Exam2() {
        return term1Exam2.get();
    }

    public StringProperty term1Exam2Property() {
        return term1Exam2;
    }

    public String setTerm1Exam2(String term1Exam2) {
        this.term1Exam2.set(term1Exam2);
        return term1Exam2;
    }

    public String getTerm1Exam3() {
        return term1Exam3.get();
    }

    public StringProperty term1Exam3Property() {
        return term1Exam3;
    }

    public String setTerm1Exam3(String term1Exam3) {
        this.term1Exam3.set(term1Exam3);
        return term1Exam3;
    }

    public String getTerm2Exam1() {
        return term2Exam1.get();
    }

    public StringProperty term2Exam1Property() {
        return term2Exam1;
    }

    public String setTerm2Exam1(String term2Exam1) {
        this.term2Exam1.set(term2Exam1);
        return term2Exam1;
    }

    public String getTerm2Exam2() {
        return term2Exam2.get();
    }

    public StringProperty term2Exam2Property() {
        return term2Exam2;
    }

    public String setTerm2Exam2(String term2Exam2) {
        this.term2Exam2.set(term2Exam2);
        return term2Exam2;
    }

    public String getTerm2Exam3() {
        return term2Exam3.get();
    }

    public StringProperty term2Exam3Property() {
        return term2Exam3;
    }

    public String setTerm2Exam3(String term2Exam3) {
        this.term2Exam3.set(term2Exam3);
        return term2Exam3;
    }

    public String getTerm3Exam1() {
        return term3Exam1.get();
    }

    public StringProperty term3Exam1Property() {
        return term3Exam1;
    }

    public String setTerm3Exam1(String term3Exam1) {
        this.term3Exam1.set(term3Exam1);
        return term3Exam1;
    }

    public String getTerm3Exam2() {
        return term3Exam2.get();
    }

    public StringProperty term3Exam2Property() {
        return term3Exam2;
    }

    public String setTerm3Exam2(String term3Exam2) {
        this.term3Exam2.set(term3Exam2);
        return term3Exam2;
    }

    public String getTerm3Exam3() {
        return term3Exam3.get();
    }

    public StringProperty term3Exam3Property() {
        return term3Exam3;
    }

    public String setTerm3Exam3(String term3Exam3) {
        this.term3Exam3.set(term3Exam3);
        return term3Exam3;
    }
}
