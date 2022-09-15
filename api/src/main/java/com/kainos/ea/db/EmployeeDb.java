package com.kainos.ea.db;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class EmployeeDb {

    private static Connection conn;

    public static Connection getConnection() {
        String user;
        String password;
        String host;
        String db;

        if ( conn != null ) return conn;

        try {

            FileInputStream propsStream =
                    new FileInputStream("src/main/resources/db.properties");

            Properties props = new Properties();
            props.load(propsStream);

            user            = props.getProperty("user");
            password        = props.getProperty("password");
            host            = props.getProperty("host");
            db              = props.getProperty("db");

            if ( user == null || password == null || host == null )
                throw new IllegalArgumentException(
                        "Properties file must exist and must contain "
                                + "user, password, and host properties.");


            conn = DriverManager.getConnection("jdbc:mysql://"
                    + host + "/" + db + "?useSSL=false", user, password);
            return conn;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public int executeQuery(String query) throws ClassNotFoundException, SQLException {
        return conn.createStatement().executeUpdate(query);
    }
}
