public class Available_Movies {

    private String movr_id;
    private String movr_name;
    private String movr_type;
    private String movr_reg_siteid;

    public Available_Movies(){
        this.movr_id = "";
        this.movr_name = "";
        this.movr_type = "";
        this.movr_reg_siteid="";
    }

    public Available_Movies(String name, String price, String quantity,String test){
        this.movr_id = name;
        this.movr_name = price;
        this.movr_type = quantity;
        this.movr_reg_siteid=test;
    }

    public String getMovr_id() {
        return movr_id;
    }

    public void setMovr_id(String name) {
        this.movr_id = name;
    }

    public String getMovr_name() {
        return movr_name;
    }

    public void setMovr_name(String name) {
        this.movr_name = name;
    }

    public String getMovr_type() {
        return movr_type;
    }

    public void setMovr_type(String name) {
        this.movr_type = name;
    }

    public String getMovr_reg_siteid() {
        return movr_reg_siteid;
    }

    public void setMovr_reg_siteid(String name) {
        this.movr_reg_siteid = name;
    }

}

