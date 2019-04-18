package hanhnd.db;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;

public class MyConnection implements Serializable{
    public static Connection getMyConnection() throws Exception{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ProjectPRJ321","sa","123456");
        return conn; 
    }
}
