package com.xzx.test;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class sqliteUtil {
    /**
     * 数据源
     */
    @Resource
    private  DataSource sqliteDataSource;


    /**
     * 获取数据库连接
     * @return conn
     */
    public  Connection getConnection() throws SQLException {

        Connection conn = sqliteDataSource.getConnection();
        conn.setAutoCommit(false);
        return conn;
    }

    /**
     * 关闭数据库连接
     * @param conn
     */
    public  void close(Connection conn, PreparedStatement stmt, ResultSet rs) {
        if (null != rs) {
            try {
                rs.close();
            } catch (SQLException ex) {

            }
            rs = null;
        }
        if (null != stmt) {
            try {
                stmt.close();
            } catch (SQLException ex) {

            }
            stmt = null;
        }
        if (null != rs) {
            try {
                rs.close();
            } catch (SQLException ex) {

            }
            rs = null;
        }
    }



}
