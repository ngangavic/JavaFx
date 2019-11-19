package Users;

public enum loginOption {
    Administrator,System_User;

    private loginOption(){

    }

    public String value(){
        return name();
    }

    public static loginOption fromvalue(String v){
        return valueOf(v);
    }
}
