package sample;

import java.sql.*;

public class Database {
    public static Statement clientData() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://172.23.204.251:3306/sajjad1","root","sajjaddg");
        Statement statement = connection.createStatement();
        return statement;
    }
    //172.23.204.251
}
