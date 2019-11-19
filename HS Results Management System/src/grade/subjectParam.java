package grade;

public enum subjectParam {
    ENGLISH,KISWAHILI,MATHEMATICS,BIOLOGY,CHEMISTRY,PHYSICS,GEOGRAPHY,HISTORY,CRE,BUSINESS,AGRICULTURE,TOTAL;

    private subjectParam(){

    }
    public String value(){
        return name();
    }
    public static subjectParam fromvalue(String v){
        return valueOf(v);
    }
}
