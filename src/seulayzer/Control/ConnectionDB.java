/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package seulayzer.Control;

import java.sql.*;



public class ConnectionDB {
   public static Connection connect = null;
    
    public ConnectionDB(){
    }
    
    public static Connection checkConnection() throws SQLException
    {
        if(connect == null)
        {
            //connect = DriverManager.getConnection("jdbc:mysql://localhost:3380/SEUlyzer", "root", "");
            connect = DriverManager.getConnection("jdbc:mysql://188.40.205.234:3306/ktby_SEUlyzer", "ktby_SEUlyzer", "ywhvg1btf1");

        return connect;
        }
       return null;
    }
    public static void closeConnection()
    {
        if(connect != null)
            connect = null;
    }
}
