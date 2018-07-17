package Bean;

//顾客Bean
public class CustomerBean {
    private String cno;//顾客编号
    private String cname;//顾客姓名
    private double cexpenditure;//消费额
    private String ctele;//客户电话
    private double ccredit;//信用积分
    private String cgrade;//等级

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
        if (num < 50000) return "普通";
        else if (num < 100000) return "白银";
        else if (num < 200000) return "黄金";
        else if (num < 400000) return "铂金";
        else if (num < 800000) return "钻石";
        else if (num < 1000000) return "皇冠";
        else return "至尊VIP";
    }
}
