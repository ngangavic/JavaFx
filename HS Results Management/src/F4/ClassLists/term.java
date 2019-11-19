package F4.ClassLists;

public enum term {
    TERM1,TERM2,TERM3;

    private term(){

    }

    public String value(){
        return name();
    }

    public static term fromvalue(String v){
        return valueOf(v);
    }
}
