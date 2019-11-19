package grade;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class gradesData {
    private final StringProperty id;
    private final StringProperty classs;
    private final StringProperty subject;
    private final StringProperty a;
    private final StringProperty aminus;
    private final StringProperty bplus;
    private final StringProperty b;
    private final StringProperty bminus;
    private final StringProperty cplus;
    private final StringProperty c;
    private final StringProperty cminus;
    private final StringProperty dplus;
    private final StringProperty d;
    private final StringProperty dminus;
    private final StringProperty e;

    public gradesData(String ID,String CLASS,String SUBJECT,String A,String AMINUS,String BPLUS,String B,String BMINUS,String CPLUS,String C,String CMINUS,String DPLUS,String D,String DMINUS,String E){
        this.id = new SimpleStringProperty(ID);
        this.classs = new SimpleStringProperty(CLASS);
        this.subject = new SimpleStringProperty(SUBJECT);

        this.a = new SimpleStringProperty(A);
        this.aminus = new SimpleStringProperty(AMINUS);
        this.bplus = new SimpleStringProperty(BPLUS);
        this.b = new SimpleStringProperty(B);
        this.bminus = new SimpleStringProperty(BMINUS);
        this.cplus = new SimpleStringProperty(CPLUS);
        this.c = new SimpleStringProperty(C);
        this.cminus = new SimpleStringProperty(CMINUS);
        this.dplus = new SimpleStringProperty(DPLUS);
        this.d = new SimpleStringProperty(D);
        this.dminus = new SimpleStringProperty(DMINUS);
        this.e = new SimpleStringProperty(E);
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

    public String getClasss() {
        return classs.get();
    }

    public StringProperty classsProperty() {
        return classs;
    }

    public void setClasss(String classs) {
        this.classs.set(classs);
    }

    public String getSubject() {
        return subject.get();
    }

    public StringProperty subjectProperty() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject.set(subject);
    }

    public String getA() {
        return a.get();
    }

    public StringProperty aProperty() {
        return a;
    }

    public void setA(String a) {
        this.a.set(a);
    }

    public String getAminus() {
        return aminus.get();
    }

    public StringProperty aminusProperty() {
        return aminus;
    }

    public void setAminus(String aminus) {
        this.aminus.set(aminus);
    }

    public String getBplus() {
        return bplus.get();
    }

    public StringProperty bplusProperty() {
        return bplus;
    }

    public void setBplus(String bplus) {
        this.bplus.set(bplus);
    }

    public String getB() {
        return b.get();
    }

    public StringProperty bProperty() {
        return b;
    }

    public void setB(String b) {
        this.b.set(b);
    }

    public String getBminus() {
        return bminus.get();
    }

    public StringProperty bminusProperty() {
        return bminus;
    }

    public void setBminus(String bminus) {
        this.bminus.set(bminus);
    }

    public String getCplus() {
        return cplus.get();
    }

    public StringProperty cplusProperty() {
        return cplus;
    }

    public void setCplus(String cplus) {
        this.cplus.set(cplus);
    }

    public String getC() {
        return c.get();
    }

    public StringProperty cProperty() {
        return c;
    }

    public void setC(String c) {
        this.c.set(c);
    }

    public String getCminus() {
        return cminus.get();
    }

    public StringProperty cminusProperty() {
        return cminus;
    }

    public void setCminus(String cminus) {
        this.cminus.set(cminus);
    }

    public String getDplus() {
        return dplus.get();
    }

    public StringProperty dplusProperty() {
        return dplus;
    }

    public void setDplus(String dplus) {
        this.dplus.set(dplus);
    }

    public String getD() {
        return d.get();
    }

    public StringProperty dProperty() {
        return d;
    }

    public void setD(String d) {
        this.d.set(d);
    }

    public String getDminus() {
        return dminus.get();
    }

    public StringProperty dminusProperty() {
        return dminus;
    }

    public void setDminus(String dminus) {
        this.dminus.set(dminus);
    }

    public String getE() {
        return e.get();
    }

    public StringProperty eProperty() {
        return e;
    }

    public void setE(String e) {
        this.e.set(e);
    }
}
