import java.sql.Date;

public class Sell_item {
    String selltxn_id;
    Date selltxn_date;
    String movs_id;
    String movs_reg_siteid;
    String movs_name;
    String selltxn_site_id;
    String stk_sellingprice;

    public String getMovs_id() {
        return movs_id;
    }

    public String getMovs_name() {
        return movs_name;
    }

    public String getMovs_reg_siteid() {
        return movs_reg_siteid;
    }

    public Date getSelltxn_date() {
        return selltxn_date;
    }

    public String getSelltxn_id() {
        return selltxn_id;
    }

    public String getSelltxn_site_id() {
        return selltxn_site_id;
    }

    public String getStk_sellingprice() {
        return stk_sellingprice;
    }

    public void setMovs_id(String movs_id) {
        this.movs_id = movs_id;
    }

    public void setMovs_name(String movs_name) {
        this.movs_name = movs_name;
    }

    public void setMovs_reg_siteid(String movs_reg_siteid) {
        this.movs_reg_siteid = movs_reg_siteid;
    }

    public void setSelltxn_date(Date selltxn_date) {
        this.selltxn_date = selltxn_date;
    }

    public void setSelltxn_id(String selltxn_id) {
        this.selltxn_id = selltxn_id;
    }

    public void setSelltxn_site_id(String selltxn_site_id) {
        this.selltxn_site_id = selltxn_site_id;
    }

    public void setStk_sellingprice(String stk_sellingprice) {
        this.stk_sellingprice = stk_sellingprice;
    }
    //public void DeleteRent
}
