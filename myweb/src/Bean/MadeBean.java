package Bean;

//����Bean
public class MadeBean extends BuyBean{
    private String cno;//�˿ͱ��
    private double mprice;//�۸�
    private String mnote;//��ע


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
