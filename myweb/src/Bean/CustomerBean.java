package Bean;

//�˿�Bean
public class CustomerBean {
    private String cno;//�˿ͱ��
    private String cname;//�˿�����
    private double cexpenditure;//���Ѷ�
    private String ctele;//�ͻ��绰
    private double ccredit;//���û���
    private String cgrade;//�ȼ�

    public String getCno() {
        return cno;
    }

    public String getCtele() {
        return ctele;
    }

    public double getCcredit() {
        return ccredit;
    }

    public double getCexpenditure() {
        return cexpenditure;
    }

    public String getCgrade() {
        return cgrade;
    }

    public String getCname() {
        return cname;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public void setCcredit(double ccredit) {
        this.ccredit = ccredit;
    }

    public void setCexpenditure(double cexpenditure) {
        this.cexpenditure = cexpenditure;
    }

    public void setCgrade(String cgrade) {
        this.cgrade = cgrade;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public void setCtele(String ctele) {
        this.ctele = ctele;
    }

    public String calLevel(double num) {
        if (num < 50000) return "��ͨ";
        else if (num < 100000) return "����";
        else if (num < 200000) return "�ƽ�";
        else if (num < 400000) return "����";
        else if (num < 800000) return "��ʯ";
        else if (num < 1000000) return "�ʹ�";
        else return "����VIP";
    }
}
