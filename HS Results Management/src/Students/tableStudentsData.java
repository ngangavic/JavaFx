package Students;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class tableStudentsData {

    private final StringProperty id;
    private final StringProperty adm;
    private final StringProperty fname;
    private final StringProperty mname;
    private final StringProperty lname;
    private final StringProperty kcpe;
    private final StringProperty classes;
    private final StringProperty dob;

    public tableStudentsData(String IDS,String ADM,String FNAMES,String MNAMES,String LNAMES,String KCPE,String CLASSESS,String DOBS){
        this.id = new SimpleStringProperty(IDS);
        this.adm = new SimpleStringProperty(ADM);
        this.fname = new SimpleStringProperty(FNAMES);
        this.mname = new SimpleStringProperty(MNAMES);
        this.lname = new SimpleStringProperty(LNAMES);
        this.kcpe = new SimpleStringProperty(KCPE);
        this.classes = new SimpleStringProperty(CLASSESS);
        this.dob = new SimpleStringProperty(DOBS);
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

    public String getKcpe() {
        return kcpe.get();
    }

    public StringProperty kcpeProperty() {
        return kcpe;
    }

    public void setKcpe(String kcpe) {
        this.kcpe.set(kcpe);
    }

    public String getClasses() {
        return classes.get();
    }

    public StringProperty classesProperty() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes.set(classes);
    }

    public String getDob() {
        return dob.get();
    }

    public StringProperty dobProperty() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob.set(dob);
    }
}
