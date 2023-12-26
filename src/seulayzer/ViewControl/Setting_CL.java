/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package seulayzer.ViewControl;

import java.io.IOException;
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

/**
 *
 * @author abdullahalnawfal
 */
public class Setting_CL {
    
    public static int CPU = 4;
    public static int RAM = 8;
    
    @FXML
    public Button btnHome, btnExit;
    public Button btnCPURAMSUB; 
    public TextField txtCPU, txtRAM;
    public Label labtest;
    
    
    public void Exit(Event e) throws IOException
    {
        Node node = (Node) e.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
    }
    public void goHome(Event e) throws IOException
    {
        Node node = (Node) e.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/seulayzer/View/Home.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void getResource(Event e)
    {
       CPU = Integer.parseInt(txtCPU.getText());
       RAM = Integer.parseInt(txtRAM.getText());
    }

}
