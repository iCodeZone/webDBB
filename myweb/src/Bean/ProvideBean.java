package Bean;

public class ProvideBean extends GoodsBean{
    private String dno;//经销商编号
    private String daddr;//经销商地址
    private String pnumber;//库存

    public String getDaddr() {
        return daddr;
    }

    public String getDno() {
        return dno;
    }

    public String getPnumber() {
        return pnumber;
    }

    public void setDaddr(String daddr) {
        this.daddr = daddr;
    }

    public void setDno(String dno) {
        this.dno = dno;
    }

    public void setPnumber(String pnumber) {
        this.pnumber = pnumber;
    }
}
