package Bean;

public class StockBean {
    private String Gno;//��Ʒ���
    private String Dno;//�����̱��
    private String Daddr;//�����̵�ַ
    private int Pnumber;//���

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
