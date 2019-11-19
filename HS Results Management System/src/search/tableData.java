package search;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class tableData {

    private final StringProperty adm;
    private final StringProperty name;
    private final StringProperty eng;
    private final StringProperty engg;
    private final StringProperty kis;
    private final StringProperty kisg;
    private final StringProperty mat;
    private final StringProperty matg;
    private final StringProperty bio;
    private final StringProperty biog;
    private final StringProperty phy;
    private final StringProperty phyg;
    private final StringProperty chem;
    private final StringProperty chemg;
    private final StringProperty geo;
    private final StringProperty geog;
    private final StringProperty his;
    private final StringProperty hisg;
    private final StringProperty cre;
    private final StringProperty creg;
    private final StringProperty bus;
    private final StringProperty busg;
    private final StringProperty agri;
    private final StringProperty agrig;
    private final StringProperty total;
    private final StringProperty avg;
    private  StringProperty points;
    private final StringProperty kcpe;

    public tableData(String adm, String name, String eng, String engg, String kis, String kisg, String mat, String matg, String bio, String biog, String phy, String phyg, String chem, String chemg, String geo, String geog, String his, String hisg, String cre, String creg, String bus, String busg, String agri, String agrig, String total, String avg, String points, String kcpe) {
        this.adm = new SimpleStringProperty(adm);
        this.name = new SimpleStringProperty(name);
        this.eng = new SimpleStringProperty(eng);
        this.engg = new SimpleStringProperty(engg);
        this.kis = new SimpleStringProperty(kis);
        this.kisg = new SimpleStringProperty(kisg);
        this.mat = new SimpleStringProperty(mat);
        this.matg = new SimpleStringProperty(matg);
        this.bio = new SimpleStringProperty(bio);
        this.biog = new SimpleStringProperty(biog);
        this.phy = new SimpleStringProperty(phy);
        this.phyg = new SimpleStringProperty(phyg);
        this.chem = new SimpleStringProperty(chem);
        this.chemg = new SimpleStringProperty(chemg);
        this.geo = new SimpleStringProperty(geo);
        this.geog = new SimpleStringProperty(geog);
        this.his = new SimpleStringProperty(his);
        this.hisg = new SimpleStringProperty(hisg);
        this.cre = new SimpleStringProperty(cre);
        this.creg = new SimpleStringProperty(creg);
        this.bus = new SimpleStringProperty(bus);
        this.busg = new SimpleStringProperty(busg);
        this.agri = new SimpleStringProperty(agri);
        this.agrig = new SimpleStringProperty(agrig);
        this.total = new SimpleStringProperty(total);
        this.avg = new SimpleStringProperty(avg);
        this.points = new SimpleStringProperty(points);
        this.kcpe = new SimpleStringProperty(kcpe);
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

    public String getEng() {
        return eng.get();
    }

    public StringProperty engProperty() {
        return eng;
    }

    public void setEng(String eng) {
        this.eng.set(eng);
    }

    public String getEngg() {
        return engg.get();
    }

    public StringProperty enggProperty() {
        return engg;
    }

    public void setEngg(String engg) {
        this.engg.set(engg);
    }

    public String getKis() {
        return kis.get();
    }

    public StringProperty kisProperty() {
        return kis;
    }

    public void setKis(String kis) {
        this.kis.set(kis);
    }

    public String getKisg() {
        return kisg.get();
    }

    public StringProperty kisgProperty() {
        return kisg;
    }

    public void setKisg(String kisg) {
        this.kisg.set(kisg);
    }

    public String getMat() {
        return mat.get();
    }

    public StringProperty matProperty() {
        return mat;
    }

    public void setMat(String mat) {
        this.mat.set(mat);
    }

    public String getMatg() {
        return matg.get();
    }

    public StringProperty matgProperty() {
        return matg;
    }

    public void setMatg(String matg) {
        this.matg.set(matg);
    }

    public String getBio() {
        return bio.get();
    }

    public StringProperty bioProperty() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio.set(bio);
    }

    public String getBiog() {
        return biog.get();
    }

    public StringProperty biogProperty() {
        return biog;
    }

    public void setBiog(String biog) {
        this.biog.set(biog);
    }

    public String getPhy() {
        return phy.get();
    }

    public StringProperty phyProperty() {
        return phy;
    }

    public void setPhy(String phy) {
        this.phy.set(phy);
    }

    public String getPhyg() {
        return phyg.get();
    }

    public StringProperty phygProperty() {
        return phyg;
    }

    public void setPhyg(String phyg) {
        this.phyg.set(phyg);
    }

    public String getChem() {
        return chem.get();
    }

    public StringProperty chemProperty() {
        return chem;
    }

    public void setChem(String chem) {
        this.chem.set(chem);
    }

    public String getChemg() {
        return chemg.get();
    }

    public StringProperty chemgProperty() {
        return chemg;
    }

    public void setChemg(String chemg) {
        this.chemg.set(chemg);
    }

    public String getGeo() {
        return geo.get();
    }

    public StringProperty geoProperty() {
        return geo;
    }

    public void setGeo(String geo) {
        this.geo.set(geo);
    }

    public String getGeog() {
        return geog.get();
    }

    public StringProperty geogProperty() {
        return geog;
    }

    public void setGeog(String geog) {
        this.geog.set(geog);
    }

    public String getHis() {
        return his.get();
    }

    public StringProperty hisProperty() {
        return his;
    }

    public void setHis(String his) {
        this.his.set(his);
    }

    public String getHisg() {
        return hisg.get();
    }

    public StringProperty hisgProperty() {
        return hisg;
    }

    public void setHisg(String hisg) {
        this.hisg.set(hisg);
    }

    public String getCre() {
        return cre.get();
    }

    public StringProperty creProperty() {
        return cre;
    }

    public void setCre(String cre) {
        this.cre.set(cre);
    }

    public String getCreg() {
        return creg.get();
    }

    public StringProperty cregProperty() {
        return creg;
    }

    public void setCreg(String creg) {
        this.creg.set(creg);
    }

    public String getBus() {
        return bus.get();
    }

    public StringProperty busProperty() {
        return bus;
    }

    public void setBus(String bus) {
        this.bus.set(bus);
    }

    public String getBusg() {
        return busg.get();
    }

    public StringProperty busgProperty() {
        return busg;
    }

    public void setBusg(String busg) {
        this.busg.set(busg);
    }

    public String getAgri() {
        return agri.get();
    }

    public StringProperty agriProperty() {
        return agri;
    }

    public void setAgri(String agri) {
        this.agri.set(agri);
    }

    public String getAgrig() {
        return agrig.get();
    }

    public StringProperty agrigProperty() {
        return agrig;
    }

    public void setAgrig(String agrig) {
        this.agrig.set(agrig);
    }

    public String getTotal() {
        return total.get();
    }

    public StringProperty totalProperty() {
        return total;
    }

    public void setTotal(String total) {
        this.total.set(total);
    }

    public String getAvg() {
        return avg.get();
    }

    public StringProperty avgProperty() {
        return avg;
    }

    public void setAvg(String avg) {
        this.avg.set(avg);
    }

    public String getPoints() {
        return points.get();
    }

    public StringProperty pointsProperty() {
        return points;
    }

    public void setPoints(String points) {
        this.points.set(points);
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
}
