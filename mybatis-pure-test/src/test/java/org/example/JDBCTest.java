package org.example;

import org.junit.Test;

import java.sql.*;

/**
 * @author XuHan
 * @date 2023/7/5 10:05
 */

public class JDBCTest {
    @Test
    public void jDBCTest() throws ClassNotFoundException, SQLException {
        //jdbc

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("找不到驱动类");
            throw new RuntimeException(e);
        }

        String url="jdbc:mysql://localhost:3306/xuhan_learning?useUnicode=true&useSSL=false&characterEncoding=UTF-8&serverTimezone=GMT%2B8";
        String username="root";
        String password="xh123456";
        //注册驱动程序，用java.lang包下面的class类里面的Class.froName();方法 此处的driver就是1里面定义的driver
        Connection con= DriverManager.getConnection(url,username,password);
        //获取数据库连接,使用java.sql里面的DriverManager的getConnectin(String url , String username ,String password )来完成

        //定义查询语句
        String sql="select * from account where id = 1";

        //构造一个statement对象来执行sql语句：主要有Statement，PreparedStatement，CallableStatement三种实例来实现
        // 1.执行静态语句，通畅通过statement实例实现
        Statement stmt=con.createStatement();
        // 2.执行动态语句，通常通过prepareStatement实现
        // PreparedStatement pstmt = conn.prepareStatement(sql) ;
        // 3.执行数据库存储过程，通常通过callableStatement实现
        //CallableStatement cstmt =  conn.prepareCall("{CALL demoSp(? , ?)}") ;

        //执行查询
        ResultSet rs=stmt.executeQuery(sql);//执行sql并返还结束 ；ResultSet executeQuery(String sqlString)：用于返还一个结果集（ResultSet）对象。

        //遍历结果集
        while(rs.next()){
            System.out.println("学生编号："+rs.getInt("id"));//使用getString()方法获取你表里的资料名
            System.out.println("学生编号："+rs.getString("realName"));
        }

        //关闭连接
        rs.close();
    }


}
