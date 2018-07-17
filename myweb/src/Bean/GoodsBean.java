package Bean;

//商品Bean
public class GoodsBean {
    private String gno;//商品编号
    private String gname;//商品名称
    private double gprice;//单价
    private String gnote;//备注
    private String gput;//是否上架
    private String gtype;//商品类型
    private String gaddr;//图片路径

    public String getGno() {
        return gno;
    }

    public String getGaddr() {
        return gaddr;
    }

    public String getGtype() {
        return gtype;
    }

    public double getGprice() {
        return gprice;
    }

    public String getGname() {
        return gname;
    }

    public String getGnote() {
        return gnote;
    }

    public String getGput() {
        return gput;
    }

    public void setGno(String gno) {
        this.gno = gno;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public void setGnote(String gnote) {
        this.gnote = gnote;
    }

    public void setGprice(double gprice) {
        this.gprice = gprice;
    }

    public void setGput(String gput) {
        this.gput = gput;
    }

    public void setGtype(String gtype) {
        this.gtype = gtype;
    }

    public void setGaddr(String gaddr) {
        this.gaddr = gaddr;
    }
}
