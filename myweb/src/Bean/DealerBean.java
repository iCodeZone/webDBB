package Bean;

public class DealerBean {
    private String dno;//�����̱��
    private String daddr;//�����̵�ַ

    public String getDaddr() {
        return daddr;
    }

    public String getDno() {
        return dno;
    }

    public void setDaddr(String daddr) {
        this.daddr = daddr;
    }

    public void setDno(String dno) {
        this.dno = dno;
    }

    public String calLocal(String baddr) {
        for(int i=0;i<baddr.length();i++){
            if(baddr.charAt(i)=='ʡ'||baddr.charAt(i)=='��'||baddr.charAt(i)=='��'){
                return baddr.substring(0,i+1);
            }
        }
        return "unknown";
    }
}
