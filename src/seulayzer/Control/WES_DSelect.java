/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package seulayzer.Control;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class WES_DSelect {
    
    public node addSample() {
        
        node newNode = new node();
        
        FileChooser reference = new FileChooser();
        
        List<File> files = reference.showOpenMultipleDialog(new Stage());
        newNode.firstFile = files.get(0);
        newNode.secondFile = files.get(1);

        
        //String pnt_num = txt_pnt_num.getText();

        newNode.firstPath = newNode.firstFile.getPath();
        newNode.secondPath = newNode.secondFile.getPath();
        
        return newNode;
    }
    
}
