package Bean;

import java.sql.Date;

//购买Bean
public class BuyBean extends GoodsBean {
    private String cno;//顾客编号
    private int bnumber;//购买数量
    private String bstate;//交易状态(已付款，待付款)
    private Date bdate;//交易日期
    private String baddr;//地址
    private String dno;//经销商编号
    private String daddr;//经销商地址
    private String bno;//订单编号

    public int getBnumber() {
        return bnumber;
    }

    public String getBno() {
        return bno;
    }

    public String getDno() {
        return dno;
    }

    public String getDaddr() {
        return daddr;
    }

    public String getCno() {
        return cno;
    }

    public Date getBdate() {
        return bdate;
    }

    public String getBaddr() {
        return baddr;
    }

    public String getBstate() {
        return bstate;
    }

    public void setBstate(String bstate) {
        this.bstate = bstate;
    }

    public void setBnumber(int bnumber) {
        this.bnumber = bnumber;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public void setBaddr(String baddr) {
        this.baddr = baddr;
    }

    public void setBdate(Date bdate) {
        this.bdate = bdate;
    }

    public void setDno(String dno) {
        this.dno = dno;
    }

    public void setDaddr(String daddr) {
        this.daddr = daddr;
    }

    public void setBno(String bno) {
        this.bno = bno;
    }
}