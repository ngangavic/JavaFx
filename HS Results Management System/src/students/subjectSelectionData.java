package students;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class subjectSelectionData {
    private final StringProperty id;
    private final StringProperty adm;
    private final StringProperty name;
    private final StringProperty classs;
    private final StringProperty eng;
    private final StringProperty kis;
    private final StringProperty mat;
    private final StringProperty bio;
    private final StringProperty chem;
    private final StringProperty phy;
    private final StringProperty geo;
    private final StringProperty his;
    private final StringProperty cre;
    private final StringProperty bus;
    private final StringProperty agri;

    public subjectSelectionData(String id, String adm, String name, String classs, String eng, String kis, String mat, String bio, String chem, String phy, String geo, String his, String cre, String bus, String agri){

        this.id = new SimpleStringProperty(id);
        this.adm = new SimpleStringProperty(adm);
        this.name = new SimpleStringProperty(name);
        this.classs = new SimpleStringProperty(classs);
        this.eng = new SimpleStringProperty(eng);
        this.kis = new SimpleStringProperty(kis);
        this.mat = new SimpleStringProperty(mat);
        this.bio = new SimpleStringProperty(bio);
        this.chem = new SimpleStringProperty(chem);
        this.phy = new SimpleStringProperty(phy);
        this.geo = new SimpleStringProperty(geo);
        this.his = new SimpleStringProperty(his);
        this.cre = new SimpleStringProperty(cre);
        this.bus = new SimpleStringProperty(bus);
        this.agri = new SimpleStringProperty(agri);
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

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
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

    public String getEng() {
        return eng.get();
    }

    public StringProperty engProperty() {
        return eng;
    }

    public String setEng(String eng) {
        this.eng.set(eng);
        return eng;
    }

    public String getKis() {
        return kis.get();
    }

    public StringProperty kisProperty() {
        return kis;
    }

    public String setKis(String kis) {
        this.kis.set(kis);
        return kis;
    }

    public String getMat() {
        return mat.get();
    }

    public StringProperty matProperty() {
        return mat;
    }

    public String setMat(String mat) {
        this.mat.set(mat);
        return mat;
    }

    public String getBio() {
        return bio.get();
    }

    public StringProperty bioProperty() {
        return bio;
    }

    public String setBio(String bio) {
        this.bio.set(bio);
        return bio;
    }

    public String getChem() {
        return chem.get();
    }

    public StringProperty chemProperty() {
        return chem;
    }

    public String setChem(String chem) {
        this.chem.set(chem);
        return chem;
    }

    public String getPhy() {
        return phy.get();
    }

    public StringProperty phyProperty() {
        return phy;
    }

    public String setPhy(String phy) {
        this.phy.set(phy);
        return phy;
    }

    public String getHis() {
        return his.get();
    }

    public StringProperty hisProperty() {
        return his;
    }

    public String setHis(String his) {
        this.his.set(his);
        return his;
    }

    public String getCre() {
        return cre.get();
    }

    public StringProperty creProperty() {
        return cre;
    }

    public String setCre(String cre) {
        this.cre.set(cre);
        return cre;
    }

    public String getGeo() {
        return geo.get();
    }

    public StringProperty geoProperty() {
        return geo;
    }

    public String setGeo(String geo) {
        this.geo.set(geo);
        return geo;
    }

    public String getBus() {
        return bus.get();
    }

    public StringProperty busProperty() {
        return bus;
    }

    public String setBus(String bus) {
        this.bus.set(bus);
        return bus;
    }

    public String getAgri() {
        return agri.get();
    }

    public StringProperty agriProperty() {
        return agri;
    }

    public String setAgri(String agri) {
        this.agri.set(agri);
        return agri;
    }
}
