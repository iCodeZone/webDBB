package Bean;

//��ƷBean
public class GoodsBean {
    private String gno;//��Ʒ���
    private String gname;//��Ʒ����
    private double gprice;//����
    private String gnote;//��ע
    private String gput;//�Ƿ��ϼ�
    private String gtype;//��Ʒ����
    private String gaddr;//ͼƬ·��

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
