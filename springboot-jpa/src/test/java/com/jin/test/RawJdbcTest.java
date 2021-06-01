package com.jin.test;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.*;

/**
 * @author shuai.jin
 * @date 2021/3/4 10:50
 */
public class RawJdbcTest {


    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        rawJdbcUse();

        Connection connection = baseDriverManagerGetConnection();

        rawJdbcUse(connection);
    }

    private static Connection baseDriverManagerGetConnection() throws SQLException {

        //这种方式对比baseClassForNameGetConnection方式，更加的面向对象

        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        driverManagerDataSource.setUsername("root");
        driverManagerDataSource.setPassword("root");
        driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/demo3");

        Connection connection = driverManagerDataSource.getConnection();

        return connection;
    }

    private static Connection baseClassForNameGetConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");

        Connection connection =
                DriverManager.getConnection("jdbc:mysql://localhost:3306/demo3", "root", "root");

        return connection;
    }

    private static void rawJdbcUse(Connection connection) throws ClassNotFoundException, SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("select * from user where id = ?");
        preparedStatement.setInt(1, 1);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");

            System.out.println(id);
            System.out.println(name);
            System.out.println(age);
        }
        if(connection != null) {
            connection.close();
        }
        if(resultSet != null) {
            resultSet.close();
        }
        if(preparedStatement != null) {
            preparedStatement.close();
        }
    }
}
