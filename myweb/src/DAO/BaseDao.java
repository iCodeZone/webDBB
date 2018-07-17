package DAO;

import Bean.GoodsBean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDao {
    Connection connection;

    public BaseDao() {
        connection = null;
    }

    public BaseDao(int n) {
        String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String username = null;
        String password = null;
        String dburl = "jdbc:sqlserver://localhost:1433;database=DBB";
        if (n == 1) {
            username = "CUSER";
            password = "CUSER-CUSER";
        } else {
            username="AUSER";
            password="AUSER-AUSER";
        }
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(dburl, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return this.connection;
    }
}