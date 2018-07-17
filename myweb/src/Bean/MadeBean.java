package Bean;

//定制Bean
public class MadeBean extends BuyBean{
    private String cno;//顾客编号
    private double mprice;//价格
    private String mnote;//备注


    public double getMprice() {
        return mprice;
    }

    public String getMnote() {
        return mnote;
    }

    public void setMnote(String mnote) {
        this.mnote = mnote;
    }

    public void setMprice(double mprice) {
        this.mprice = mprice;
    }
}
