package Bean;

public class DealerBean {
    private String dno;//经销商编号
    private String daddr;//经销商地址

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
            if(baddr.charAt(i)=='省'||baddr.charAt(i)=='市'||baddr.charAt(i)=='区'){
                return baddr.substring(0,i+1);
            }
        }
        return "unknown";
    }
}
