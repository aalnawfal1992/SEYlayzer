/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package seulayzer.Control;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import seulayzer.Modul.Admin;

public class LoginControl {
    Statement st;
    public boolean isLogin (Admin ad) throws SQLException{
        st = ConnectionDB.checkConnection().createStatement();
        ResultSet result = st.executeQuery("SELECT * FROM Users where User_Name='"+ad.getUsername()+"' and Password='"+ad.getPassword()+"' ");
        if (result.next())
            return true;
        return false;
    }
    
    
}
