package Bean;

public class ProvideBean extends GoodsBean{
    private String dno;//�����̱��
    private String daddr;//�����̵�ַ
    private String pnumber;//���

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
