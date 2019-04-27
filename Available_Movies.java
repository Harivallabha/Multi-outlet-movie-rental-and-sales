import javafx.collections.ObservableList;

public class Available_Movies {
    String movr_id,movr_name,movr_type,movr_reg_siteid;

    Available_Movies()
    {
        movr_id = "TEST";
        movr_name = "TEST";
        movr_type = "TEST";
        movr_reg_siteid = "TEST";


    }

    public void setMovr_id(String movr_id) {
        this.movr_id = movr_id;
    }

    public void setMovr_name(String movr_name) {
        this.movr_name = movr_name;
    }

    public void setMovr_reg_siteid(String w) {
        this.movr_reg_siteid=w;
    }

    public void setMovr_type(String movr_type) {
        this.movr_type = movr_type;
    }
}
