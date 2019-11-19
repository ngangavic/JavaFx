package teacher;

public enum classOption {
    FORM_1,FORM_2,FORM_3,FORM_4;

    private classOption(){

    }
    public String value(){
        return name();
    }
    public static classOption fromvalue(String v){
        return valueOf(v);
    }
}
