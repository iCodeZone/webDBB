package Bean;

//���ﳵBean
public class TrolleyBean extends GoodsBean{
    private String cno;//�˿ͱ��
    private int tnumber;//����

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
