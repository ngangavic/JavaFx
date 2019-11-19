package F2.Exams;

public enum subjectOption {
    English,Kiswahili,Mathematics,Biology,Chemistry,Physics,Geography,CRE,History,Business,Agriculture;

    private subjectOption(){

    }
    public String value(){
        return name();
    }
    public static subjectOption fromvalue(String v){
        return valueOf(v);
    }
}
