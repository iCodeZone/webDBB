package Bean;

public class StockBean {
    private String Gno;//商品编号
    private String Dno;//经销商编号
    private String Daddr;//经销商地址
    private int Pnumber;//库存

    public String getDno() {
        return Dno;
    }

    public String getGno() {
        return Gno;
    }

    public int getPnumber() {
        return Pnumber;
    }

    public String getDaddr() {
        return Daddr;
    }

    public void setPnumber(int pnumber) {
        Pnumber = pnumber;
    }

    public void setDno(String dno) {
        Dno = dno;
    }

    public void setGno(String gno) {
        Gno = gno;
    }

    public void setDaddr(String daddr) {
        Daddr = daddr;
    }
}
