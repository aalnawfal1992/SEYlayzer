/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package seulayzer.ViewControl;

import java.io.File;
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
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author abdullahalnawfal
 */
public class WGS_Ref_CL {
    @FXML
    public Button nxtButton;
    public TextField txtWESpath;
    public String refPath;
    public @FXML
    Label lblerror, lblerrorbed;
    
    public void refSelect(Event e) throws IOException {
        
        FileChooser ref = new FileChooser();

        File file = ref.showOpenDialog(new Stage());
        
        txtWESpath.setText(file.getPath());
        
        refPath = file.getPath();
        
    
    }
    
    public void toWGSData(Event e) throws IOException
    {
        
        if (txtWESpath.getText().toString().isEmpty())
        {
            lblerror.setText("Please Select your data");
            return;
        }
        else{
        Node node = (Node) e.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/seulayzer/View/WGS_Data.fxml"));
        stage.setUserData(refPath);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        }
    }
    public void goHome(Event e) throws IOException
    {
        
        Node node = (Node) e.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/seulayzer/View/Home.fxml"));
        stage.setUserData(refPath);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    } 
}
