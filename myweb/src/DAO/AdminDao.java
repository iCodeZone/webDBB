package DAO;

import Bean.BuyBean;
import Bean.GoodsBean;
import Bean.StockBean;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AdminDao {
    private Connection connection;//连接对象
    private PreparedStatement statement;//语句对象
    private ResultSet result;//结果集

    public AdminDao() {
        connection = new BaseDao(2).getConnection();
    }

    //功能
    //添加商品
    public void addGoods(String gno, String gname, double gprice, String gtype, String gput, String gadder) {
        String sql = "insert into Goods values(?,?,?,?,?,NULL,?)";
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, gno);
            statement.setString(2, gname);
            statement.setDouble(3, gprice);
            statement.setString(4, gtype);
            statement.setString(5, gput);
            statement.setString(6, gadder);
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //查询商品库存
    public ArrayList<StockBean> getStock(String gno) {
        String sql = "select Dno,Daddr,Pnumber from P_Dealer where Gno=?";
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, gno);
            result = statement.executeQuery();
            ArrayList<StockBean> stocks = new ArrayList<StockBean>();
            while (result.next()) {
                StockBean stock = new StockBean();
                stock.setGno(gno);
                stock.setDno(result.getString(1));
                stock.setDaddr(result.getString(2));
                stock.setPnumber(result.getInt(3));
                stocks.add(stock);
            }
            return stocks;
        } catch (Exception e) {
            System.out.println(e);
        }
        return new ArrayList<StockBean>();
    }

    //查询所有商品
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
            return goods;
        } catch (Exception e) {
            System.out.println(e);
        }
        return new ArrayList<GoodsBean>();
    }

    //查看订单
    public ArrayList<BuyBean> getBuy() {
        String sql = "select * from B_Goods";
        try {
            statement = connection.prepareStatement(sql);
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
                buy.setCno(result.getString(12));
                buy.setBstate(result.getString(13));
                buy.setBdate(result.getDate(14));
                buy.setBaddr(result.getString(15));

                buys.add(buy);
            }
            return buys;
        } catch (Exception e) {
            System.out.println(e);
        }
        return new ArrayList<BuyBean>();
    }

    //修改单价
    public void setPrice(String gno, double price) {
        String sql = "update Goods set Gprice=? where Gno=?";
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, Double.toString(price));
            statement.setString(2, gno);
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //工具
    //商品编号是否存在
    public boolean calGno(String gno) {
        String sql = "select * from Goods where Gno=?";
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, gno);
            result = statement.executeQuery();
            System.out.println(gno+"aaa");
            if (result.next()) return true;
            else return false;
        } catch (Exception e) {
            System.out.println(e);
        }
        return true;
    }
}
