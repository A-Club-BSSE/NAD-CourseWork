/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.health.health;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author IPERU
 */
public class Connecting {
   
    
    public Connection getMyConnection() throws SQLException, ClassNotFoundException{
        Connection conn  = null;
    try{
            Class.forName("com.mysql.jdbc.Driver");

            conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/healthCentres", "root", "");
//             Statement st= con.createStatement();
//             st.executeUpdate("insert into hospitals set Name='"+n+"',Location='"+l+"'");
//             out.print("successfully inserted ");
//            
//                               }catch(SQLException e){
//                        out.print("the error is "+e.getMessage());
//                    }
//
    
    return conn;
    
    }
    
    catch(SQLException s){
    }
        return conn;
    
}
}
