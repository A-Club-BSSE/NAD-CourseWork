/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.health.administration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author elijahokello
 */
public class DBConnection {
    
    public Connection getMyConnection() throws SQLException, ClassNotFoundException{
        Connection conn = null;
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            
            conn = DriverManager.getConnection("jdbc:mysql:localhost:3306/vaccination","root","");
            return conn;
        }catch(ClassNotFoundException | SQLException e){
            System.out.println(e);
        }
        return conn;
        
    
    }
    
}
