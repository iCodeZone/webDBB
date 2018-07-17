package Bean;

//购物车Bean
public class TrolleyBean extends GoodsBean{
    private String cno;//顾客编号
    private int tnumber;//数量

    public String getCno() {
        return cno;
    }

    public int getTnumber() {
        return tnumber;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public void setTnumber(int tnumber) {
        this.tnumber = tnumber;
    }
}
