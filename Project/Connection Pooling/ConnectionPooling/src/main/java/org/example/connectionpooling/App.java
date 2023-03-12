package org.example.connectionpooling;
/**
 * Connection Pooling using BasicDataSource
 * @author pradeeptiwari
 */

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.commons.dbcp2.BasicDataSource;

public class App {
    private static BasicDataSource dataSource = null;

    static {
        dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/empdb?useSSL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("Yy3$d7!W20235@");

        dataSource.setMinIdle(5);
        dataSource.setMaxIdle(10);
        dataSource.setMaxTotal(20);
    }

    public static void main(String[] args) throws Exception {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = dataSource.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from tblemployee");
            while (resultSet.next()) {
                System.out.println("empId: " + resultSet.getInt("empId"));
                System.out.println("empName: " + resultSet.getString("empName"));
                System.out.println("dob: " + resultSet.getDate("dob"));
                System.out.println("designation" + resultSet.getString("designation"));
            }
        } finally {
            connection.close();
            statement.close();
            resultSet.close();
        }
        System.out.println("connection pooling object created using Object:dataSource of class:BasicDataSource");

    }
}
