package Bean;

import java.sql.Date;

//����Bean
public class BuyBean extends GoodsBean {
    private String cno;//�˿ͱ��
    private int bnumber;//��������
    private String bstate;//����״̬(�Ѹ��������)
    private Date bdate;//��������
    private String baddr;//��ַ
    private String dno;//�����̱��
    private String daddr;//�����̵�ַ
    private String bno;//�������

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