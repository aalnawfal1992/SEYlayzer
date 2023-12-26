/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package seulayzer.ViewControl;

import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import seulayzer.Control.UserControl;
import seulayzer.Modul.UserCreat;

public class UserManagmentControl {
    
    @FXML
    private Button btnSubmit;  
    @FXML
    private Button btnClear;  
    @FXML
    private TextField txtUserName;  
    @FXML
    private TextField txtRealName; 
    @FXML
    private TextField txtPassword;
    @FXML
    private TextField txtConPassword;
    @FXML
    private Label lblPassMassage;
    
    public void logoff(Event e) throws IOException
    {
        Node node = (Node) e.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
    }
    public void privouspage(Event e) throws IOException
    {
        Node node = (Node) e.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/seulayzer/View/Home.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void cleartextdata(Event e)
    {
        if(e.getSource() == btnClear)
        {
            txtUserName.setText("");
            txtRealName.setText("");
            txtPassword.setText("");
            txtConPassword.setText("");
            lblPassMassage.setText("");
        }
    }
    
    UserCreat account = new UserCreat();
    UserControl userControl = new UserControl();
     
    public void adduser (Event e)
    {
        
            account.setUsername(txtUserName.getText());
            account.setPassword(txtPassword.getText());
            account.setConPassword(txtConPassword.getText());
            account.setRealname(txtRealName.getText());
            if (txtPassword.getText().equals(txtConPassword.getText()))
            {
                userControl.insert(account);
                    txtUserName.setText("");
                    txtRealName.setText("");
                     txtPassword.setText("");
                    txtConPassword.setText("");
                        lblPassMassage.setText("User has been created successfully");
                
            }
            else
            {
                lblPassMassage.setText("Password and its confirmation are Not matchs, Kindly pick a Password and write it in both coressponding fileds");
            }
            
            //txtPassword.setText("");
            //txtRealName.setText("");
            //txtConPassword.setText("");
            //lblPassMassage.setText(" User has been created");
            //lblPassMassage.setText("Password and its confirmation are Not matchs, Kindly pick a Password and write it in both coressponding fileds");
        
    }

}
