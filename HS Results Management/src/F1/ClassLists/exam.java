package F1.ClassLists;

public enum exam {
    EXAM1,EXAM2,EXAM3,AVG;

    private exam(){

    }

    public String value(){
        return name();
    }

    public static exam fromvalue(String v){
        return valueOf(v);
    }
}
