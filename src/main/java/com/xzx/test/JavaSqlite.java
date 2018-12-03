package com.xzx.test;

import java.sql.*;

import  org.sqlite.JDBC;
public class JavaSqlite {

    public static void main(String[] args) throws ClassNotFoundException {

        try {
            // 0 连接SQLite的JDBC
            String url="jdbc:sqlite:/Users/mac/test.db";
            Class.forName("org.sqlite.JDBC");

            Connection conn = DriverManager.getConnection(url);
            PreparedStatement prep = conn.prepareStatement(
                    "insert into demo values(9, '123123')");
            prep.executeUpdate();
            conn.close();


        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}


