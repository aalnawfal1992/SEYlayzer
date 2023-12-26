/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package seulayzer.ViewControl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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
import seulayzer.Control.WES_DSelect;

/**
 *
 * @author abdullahalnawfal
 */
public class WES_Ref_CL {
    
    @FXML
    public Button nxtButton;
    public TextField txtWESpath, txtBedpath;
    public String refPath;
    public static String bedPath;
    public @FXML
    Label lblerror, lblerrorbed;
    
    public void refSelect(Event e) throws IOException {
        
        FileChooser ref = new FileChooser();
        FileChooser.ExtensionFilter fileExtensions = 
        new FileChooser.ExtensionFilter("*.fa.gz", "*.Fasta.gz", "*.fa", "*.Fasta");
        ref.getExtensionFilters().add(fileExtensions);

        File file = ref.showOpenDialog(new Stage());
        
        txtWESpath.setText(file.getPath());
        
        refPath = file.getPath();
        
    
    }
    
    public void refBed(Event e) throws IOException {
        
        FileChooser ref = new FileChooser();
        
        File file = ref.showOpenDialog(new Stage());
        
        txtBedpath.setText(file.getPath());
        
        bedPath = file.getPath();
    
    }
    
    public void toWESData(Event e) throws IOException
    {
        
        if (txtWESpath.getText().toString().isEmpty())
        {
            lblerror.setText("Please Select your data");
            return;
        }
        if(txtBedpath.getText().toString().isEmpty())
        {
            lblerrorbed.setText("Please Select your data");
            return;
        }
        else{
        Node node = (Node) e.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/seulayzer/View/WES_Data.fxml"));
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
