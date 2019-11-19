package Grade;

public enum classParam {
    FORM_1,FORM_2,FORM_3,FORM_4;

    private classParam(){

    }
    public String value(){
        return name();
    }
    public static classParam fromvalue(String v){
        return valueOf(v);
    }
}
