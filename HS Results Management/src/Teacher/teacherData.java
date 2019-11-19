package Teacher;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class teacherData {
    private final StringProperty id;
    private final StringProperty code;
    private final StringProperty fname;
    private final StringProperty mname;
    private final StringProperty lname;
    private final StringProperty shortname;
    private final StringProperty classs;
    private final StringProperty subject;
    public teacherData(String id,String code,String fname,String mname,String lname,String shortname,String classs,String subject){
        this.id = new SimpleStringProperty(id);
        this.code = new SimpleStringProperty(code);
        this.fname = new SimpleStringProperty(fname);
        this.mname = new SimpleStringProperty(mname);
        this.lname = new SimpleStringProperty(lname);
        this.shortname = new SimpleStringProperty(shortname);
        this.classs = new SimpleStringProperty(classs);
        this.subject = new SimpleStringProperty(subject);
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

    public String getCode() {
        return code.get();
    }

    public StringProperty codeProperty() {
        return code;
    }

    public void setCode(String code) {
        this.code.set(code);
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

    public String getShortname() {
        return shortname.get();
    }

    public StringProperty shortnameProperty() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname.set(shortname);
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
}
