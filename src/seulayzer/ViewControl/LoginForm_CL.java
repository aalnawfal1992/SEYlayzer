/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package seulayzer.ViewControl;

import java.io.IOException;
import java.sql.SQLException;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import seulayzer.Control.LoginControl;
import seulayzer.Modul.Admin;

public class LoginForm_CL {
    @FXML 
    TextField txtusername;
    @FXML 
    PasswordField txtpass;
    @FXML
    Label lblmassage;
    
    Admin ad = new Admin();
    LoginControl lg = new LoginControl();
    
    public void isSign(Event e ) throws SQLException, IOException{
        ad.setUsername(txtusername.getText());
        ad.setPassword(txtpass.getText());
        if (lg.isLogin(ad))
        {
            Node node = (Node) e.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/seulayzer/View/Home.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else
        {
            lblmassage.setText("User Name Or Password is Wrong");
        }
    }
    public void exit(Event e)
    {
        Node node = (Node) e.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
    }
}
