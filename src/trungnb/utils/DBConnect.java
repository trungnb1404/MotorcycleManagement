/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trungnb.utils;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author PC
 */
public class DBConnect implements Serializable {

    public static Connection makeConnection() throws SQLException, ClassNotFoundException {
        //1.load driver
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        //2.Create Connection string
        String url = "jdbc:sqlserver://localhost:1433; databaseName=MotorcycleManagement";
        //3. open connection
        Connection con = DriverManager.getConnection(url, "sa", "123456");
        return con;
    }
}
