package students;

public enum classOption {
    FORM_1,FORM_2,FORM_3,FORM_4,COMPLETED;

    private classOption(){

    }
    public String value(){
        return name();
    }
    public static classOption fromvalue(String v){
        return valueOf(v);
    }
}
