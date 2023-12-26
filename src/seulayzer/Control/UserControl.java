/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package seulayzer.Control;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import seulayzer.Modul.UserCreat;

/**
 *
 * @author abdullahalnawfal
 */
public class UserControl {
    Statement st;
    public void insert (UserCreat user)
    {
        try{
            st = ConnectionDB.checkConnection().createStatement();
            st.executeUpdate("INSERT INTO `Users`(`User_Name`, `Password`, `Real_Name`) VALUES ('"+user.getUsername()+"', '"+user.getPassword()+"', '"+user.getRealname()+"')");
            ConnectionDB.closeConnection();
        }
        catch(SQLException ex)
        {
            Logger.getLogger(UserControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
}
