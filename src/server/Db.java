/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Roxana
 */
public class Db {
    private static Connection con = null;
    
    public Connection getConnection(String dbName) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        if (con == null) {
            String connectionURL = "jdbc:mysql://localhost:3306/"+dbName;
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            
            Db.con = DriverManager.getConnection(connectionURL, "root", "root");
            
            return Db.con;
        }
        
        return con;
    }
    
    
}
