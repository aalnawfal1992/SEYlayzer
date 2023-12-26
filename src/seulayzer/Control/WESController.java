/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package seulayzer.Control;

import java.io.File;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author abdullahalnawfal
 */
public class WESController {
    
    @FXML
    private TextField txtWESpath;
    
    public void select(){
        
        FileChooser ref = new FileChooser();
        
        File file=ref.showOpenDialog(new Stage());
        
        txtWESpath.setText(file.getPath());
    
    }
    
    public void nxtButton(Stage stage){
        
        Stage test = new Stage();
        test.show();
       //stage.show();
       
    }
    
    
}
