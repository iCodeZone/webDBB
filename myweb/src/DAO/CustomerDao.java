package DAO;

import Bean.*;

import javax.servlet.RequestDispatcher;
import java.sql.*;
import java.util.ArrayList;

public class CustomerDao {
    private Connection connection;//连接对象
    private PreparedStatement statement;//语句对象
    private ResultSet result;//结果集

    public CustomerDao() {
        connection = new BaseDao(1).getConnection();
    }

    //功能

    //验证登陆
    public boolean Login(String username, String password) {
        String sql = "select Cpassword from CUser where Cno = ?";    //从表中获取密码     //***********需要进行个性化修改
        try {
            statement = connection.prepareStatement(sql);  //创建预编译处理对象
            statement.setString(1, username);//加入参数
            result = statement.executeQuery();
            if (result.next()) {
                if (password.equals(result.getString(1).trim())) {
                    connection.close();
                    statement.close();
                    result.close();
                    return true;
                } else {
                    connection.close();
                    statement.close();
                    result.close();
                    return false;
                }
            } else {
                connection.close();
                statement.close();
                result.close();
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    //注册用户
    public void Register(String userid, String username, String tele, String password) {
        String upCustomer = "insert into Customer values(?,?,0,?,?,100)";
        String upCuser = "insert into CUser values (?,?)";
        try {
            //插入顾客表
            statement = connection.prepareStatement(upCustomer);
            statement.setString(1, userid);
            statement.setString(2, username);
            statement.setString(3, tele);
            statement.setString(4, "无");
            statement.execute();
            System.out.println("C表");
            //插入密码表
            statement = connection.prepareStatement(upCuser);
            statement.setString(1, userid);
            statement.setString(2, password);
            statement.execute();
            System.out.println("U表");
            connection.close();
            statement.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //获得客户信息  ok
    public CustomerBean getInfo(String cno) {
        String sql = "select * from Customer where Cno = ?";
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, cno);
            result = statement.executeQuery();
            if (result.next()) {
                CustomerBean customer = new CustomerBean();
                customer.setCno(result.getString(1));
                customer.setCname(result.getString(2));
                customer.setCexpenditure(result.getFloat(3));
                customer.setCtele(result.getString(4));
                customer.setCgrade(result.getString(5));
                customer.setCcredit(result.getDouble(6));
                return customer;
            } else {
                return new CustomerBean();
            }
        } catch (Exception e) {
            System.out.println(e);
            return new CustomerBean();
        }
    }

    //获得购物车信息  ok
    public ArrayList<TrolleyBean> getTro(String cno) {
        String sql = "select * from T_Goods where Cno=?";
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, cno);
            result = statement.executeQuery();
            ArrayList<TrolleyBean> trolleys = new ArrayList<TrolleyBean>();
            while (result.next()) {
                TrolleyBean trolley = new TrolleyBean();
                trolley.setGno(result.getString(1));
                trolley.setGname(result.getString(2));
                trolley.setGprice(result.getFloat(3));
                trolley.setGnote(result.getString(4));
                trolley.setGput(result.getString(5));
                trolley.setTnumber(result.getInt(6));
                trolley.setGtype(result.getString(7));
                trolley.setGtype(result.getString(8));

                trolleys.add(trolley);
            }
            connection.close();
            statement.close();
            result.close();
            return trolleys;
        } catch (Exception e) {
            System.out.println(e);
            return new ArrayList<TrolleyBean>();
        }
    }

    //获得定制信息  ok
    public ArrayList<MadeBean> getMade(String cno) {
        String sql = "select * from M_Goods where Cno=?";
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, cno);
            result = statement.executeQuery();
            ArrayList<MadeBean> mades = new ArrayList<MadeBean>();
            while (result.next()) {
                MadeBean made = new MadeBean();
                made.setGno(result.getString(2));
                made.setGname(result.getString(3));
                made.setGtype(result.getString(4));
                made.setGprice(result.getDouble(5));
                made.setGnote(result.getString(6));
                made.setGput(result.getString(7));
                made.setGaddr(result.getString(8));
                made.setDno(result.getString(9));
                made.setDaddr(result.getString(10));
                made.setMprice(result.getInt(11));
                made.setMnote(result.getString(12));
                made.setBnumber(result.getInt(13));
                made.setBno(result.getString(14));
                made.setBstate(result.getString(15));
                made.setBdate(result.getDate(16));
                made.setBaddr(result.getString(17));

                //检查订单是否失效
                if ((made.getBstate()).equals("待付款    ") && !checkDate(made.getBdate())) {
                    sql = "update Buy set Bstate=? where Bno=?";
                    statement = connection.prepareStatement(sql);
                    statement.setString(1, "交易失败");
                    statement.setString(2, made.getBno());
                    statement.executeUpdate();
                    continue;
                }

                mades.add(made);
            }
            connection.close();
            statement.close();
            result.close();
            return mades;
        } catch (Exception e) {
            System.out.println(e);
            return new ArrayList<MadeBean>();
        }
    }

    //获得购买信息   ok
    public ArrayList<BuyBean> getBuy(String cno) {
        String sql = "select * from B_Goods where Cno=?";
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, cno);
            result = statement.executeQuery();
            ArrayList<BuyBean> buys = new ArrayList<BuyBean>();
            while (result.next()) {
                BuyBean buy = new BuyBean();
                buy.setGno(result.getString(1));
                buy.setGname(result.getString(2));
                buy.setGtype(result.getString(3));
                buy.setGaddr(result.getString(4));
                buy.setDno(result.getString(5));
                buy.setDaddr(result.getString(6));
                buy.setGprice(result.getDouble(7));
                buy.setGnote(result.getString(8));
                buy.setGput(result.getString(9));
                buy.setBno(result.getString(10));
                buy.setBnumber(result.getInt(11));
                buy.setBstate(result.getString(13));
                buy.setBdate(result.getDate(14));
                buy.setBaddr(result.getString(15));

                //检查订单是否失效
                if ((buy.getBstate()).equals("待付款    ") && !checkDate(buy.getBdate())) {
                    sql = "update Buy set Bstate=? where Bno=?";
                    System.out.println("交易失败");
                    statement = connection.prepareStatement(sql);
                    statement.setString(1, "交易失败");
                    statement.setString(2, buy.getBno());
                    statement.executeUpdate();
                    upCre(cno, -5);//更新信用
                    continue;
                }

                buys.add(buy);
            }
            return buys;
        } catch (Exception e) {
            System.out.println(e);
            return new ArrayList<BuyBean>();
        }
    }

    //获得所有的商品信息   ok
    public ArrayList<GoodsBean> getGoods() {
        String sql = "select * from Goods";
        try {
            statement = connection.prepareStatement(sql);
            result = statement.executeQuery();
            ArrayList<GoodsBean> goods = new ArrayList<GoodsBean>();
            while (result.next()) {
                GoodsBean good = new GoodsBean();
                good.setGno(result.getString(1));
                good.setGname(result.getString(2));
                good.setGprice(result.getFloat(3));
                good.setGtype(result.getString(4));
                good.setGput(result.getString(5));
                good.setGnote(result.getString(6));
                good.setGaddr(result.getString(7));

                goods.add(good);
            }
            connection.close();
            statement.close();
            result.close();
            return goods;
        } catch (Exception e) {
            System.out.println(e);
            return new ArrayList<GoodsBean>();
        }
    }

    //修改密码    ok
    public void upPassword(String userid, String password) {
        String sql = "update CUser set Cpassword=? where Cno=?";
        try {
            //更新密码
            statement = connection.prepareStatement(sql);
            statement.setString(1, password);
            statement.setString(2, userid);
            statement.executeUpdate();

            connection.close();
            statement.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    //修改购物车信息  ok
    public void setTro(String cno, String gno, int num, String type) {
        //删除购物车
        if (num == 0) {
            String sql = "delete from Trolley where Cno=? and Gno=?";
            try {
                statement = connection.prepareStatement(sql);
                statement.setString(1, cno);
                statement.setString(2, gno);
                System.out.println(cno);
                System.out.println(gno);
                statement.executeUpdate();
                System.out.println("删除");
            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            String sql = "select * from Trolley where Cno=? and Gno=?";
            try {
                statement = connection.prepareStatement(sql);
                statement.setString(1, cno);
                statement.setString(2, gno);
                System.out.println(cno + "s" + gno);
                result = statement.executeQuery();
                if (result.next()) {
                    System.out.println("更新数量");
                    if (type.equals("1")) {
                        sql = "update Trolley set Tnumber=? where Cno=? and Gno=?";
                        statement = connection.prepareStatement(sql);
                        statement.setString(1, Integer.toString((num)));
                        statement.setString(2, cno);
                        statement.setString(3, gno);
                        statement.executeUpdate();
                    } else {
                        System.out.println("++++");
                        sql = "update Trolley set Tnumber=Tnumber+? where Cno=? and Gno=?";
                        statement = connection.prepareStatement(sql);
                        statement.setString(1, Integer.toString((num)));
                        statement.setString(2, cno);
                        statement.setString(3, gno);
                        statement.executeUpdate();
                    }
                } else {
                    System.out.println("加入新商品");
                    sql = "insert into  Trolley values(?,?,?)";
                    statement = connection.prepareStatement(sql);
                    statement.setString(1, cno);
                    statement.setString(2, gno);
                    statement.setString(3, new Integer(num).toString(num));
                    statement.executeUpdate();
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    //定制
    public boolean setMade(String cno, String gno, String baddr, int num, double mprice, String mnote) {
        if (setOrder(cno, gno, baddr, num)) {
            String sql = "insert into Made values(?,?,?,?)";
            try {
                statement = connection.prepareStatement(sql);
                statement.setString(1, cno);
                statement.setString(2, gno);
                statement.setString(3, Double.toString(mprice));
                statement.setString(4, mnote);
            } catch (Exception e) {
                System.out.println(e);
            }
            return true;
        }
        return false;
    }

    //下单：插入Buy表   ok
    public boolean setOrder(String cno, String gno, String baddr, int num) {
        String dno = calDno(new DealerBean().calLocal(baddr));
        if (num > calPnum(dno)) {
            return false;
        }
        String sql = "insert into Buy values(?,?,?,?,?,?,?,?)";
        try {
            long temp = System.currentTimeMillis();
            String bno = Long.toString(temp);
            Date date = new Date(System.currentTimeMillis());
            System.out.println("下单");
            statement = connection.prepareStatement(sql);
            statement.setString(1, cno);
            statement.setString(2, gno);
            statement.setString(3, baddr);
            statement.setString(4, dno);//根据顾客地址选择经销商地址
            statement.setString(5, bno);//生成订单编号
            statement.setString(6, date.toString());
            statement.setString(7, Integer.toString(num));
            statement.setString(8, "待付款");
            statement.executeUpdate();
            System.out.println("下单ok");
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    //支付：更新交易额、顾客等级、库存、订单状态   ok
    public void setPay(String bno) {
        String sql = "select Cno,Dno,Gno,Bnumber from Buy where Bno=?";
        String cno = null, dno = null, gno = null;
        int bnum = 0;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, bno);
            result = statement.executeQuery();
            if (result.next()) {
                cno = result.getString(1);
                dno = result.getString(2);
                gno = result.getString(3);
                bnum = result.getInt(4);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        sql = "update Buy set Bstate=? where Bno=?";
        try {
            System.out.println("支付");
            statement = connection.prepareStatement(sql);
            statement.setString(1, "已付款");
            statement.setString(2, bno);
            statement.executeUpdate();
            upCexpenditure(bno, cno, 1);//更新交易额
            upGrade(cno);//更新顾客等级
            upPnum(dno, gno, -bnum);//更新库存
            upCre(cno, 15);
            System.out.println("支付ok");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //退款：更新交易额、顾客等级、库存、订单状态   ok
    public void setRefund(String bno) {
        String sql = "select Dno,Gno,Cno,Bnumber from Buy where Bno=?";
        String cno = null, dno = null, gno = null;
        int bnum = 0;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, bno);
            result = statement.executeQuery();
            if (result.next()) {
                dno = result.getString(1);
                gno = result.getString(2);
                cno = result.getString(3);
                bnum = result.getInt(4);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        sql = "update Buy set Bstate=? where Bno=?";
        try {
            System.out.println("退款");
            statement = connection.prepareStatement(sql);
            statement.setString(1, "退款");
            statement.setString(2, bno);
            statement.executeUpdate();
            upCexpenditure(bno, cno, -1);//更新交易额
            upGrade(cno);//更新等级
            upPnum(dno, gno, bnum);//更新库存
            //更新信用
            upCre(cno, -10);
            System.out.println("退款ok");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //工具

    //检查支付超时
    private boolean checkDate(Date a) {
        //转换成天数
        long day = (System.currentTimeMillis() - a.getTime()) / (24 * 60 * 60 * 1000);
        System.out.println(day);
        return day >= 7 ? false : true;
    }

    //更新顾客等级
    public void upGrade(String cno) {
        CustomerBean customer = getInfo(cno);
        String sql = "update Customer set Cgrade=? where Cno=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, new CustomerBean().calLevel(customer.getCexpenditure()));
            ps.setString(2, cno);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //更新顾客交易额
    public void upCexpenditure(String bno, String cno, int op) {
        int num = getBuyPrice(bno);
        String sql = "update Customer set Cexpenditure=Cexpenditure+? where Cno=?";
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, Integer.toString(num * op));
            statement.setString(2, cno);
            statement.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //根据经销商地址获得经销商编号
    public String calDno(String daddr) {
        String sql = "select Dno from Dealer where Daddr=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, daddr);
            result = ps.executeQuery();
            if (result.next()) {
                System.out.println(result.getString(1));
                return result.getString(1);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return "unknown";
    }

    //获得每笔订单总额
    public int getBuyPrice(String bno) {
        String sql = "select Gprice,Bnumber from B_Goods where Bno=?";
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, bno);
            result = statement.executeQuery();
            if (result.next()) {
                int price = result.getInt(1);
                int num = result.getInt(2);
                return num * price;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    //查重
    public boolean checkUser(String userid) {
        String sql = "select * from CUser where Cno=?";
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, userid);
            result = statement.executeQuery();
            if (result.next()) {
                System.out.println("fail1");
                connection.close();
                statement.close();
                result.close();
                return false;
            } else {
                System.out.println("ok1");
                connection.close();
                statement.close();
                result.close();
                return true;
            }
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    //更新库存
    public void upPnum(String dno, String gno, int num) {
        String sql = "update Provide set Pnumber=Pnumber+? where Dno=? and Gno=?";
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, Integer.toString(num));
            statement.setString(2, dno);
            statement.setString(3, gno);
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //得到信用
    public int calCre(String cno) {
        String sql = "select Ccredit from Customer where Cno=?";
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, cno);
            result = statement.executeQuery();
            if (result.next()) {
                return result.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    //更新信用
    public void upCre(String cno, int num) {
        int cre = calCre(cno);
        if (cre + num > 100) cre = 100;
        else if (cre + num < 0) cre = 0;
        else cre += num;
        String sql = "update Customer set Ccredit=? where Cno=?";
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, Integer.toString(cre));
            statement.setString(2, cno);
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //检查库存
    public int calPnum(String dno) {
        String sql = "select Pnumber from Provide where Dno=?";
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, dno);
            result = statement.executeQuery();
            if (result.next()) {
                return result.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    //根据商品号检索
    public GoodsBean getGoods(String gno) {
        String sql = "select * from Goods where Gno=?";
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, gno);
            result = statement.executeQuery();
            if (result.next()) {
                GoodsBean good = new GoodsBean();
                good.setGno(result.getString(1));
                good.setGname(result.getString(2));
                good.setGprice(result.getFloat(3));
                good.setGtype(result.getString(4));
                good.setGput(result.getString(5));
                good.setGnote(result.getString(6));
                good.setGaddr(result.getString(7));
                return good;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return new GoodsBean();
    }

}
