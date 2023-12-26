/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package seulayzer.ViewControl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import seulayzer.Control.WES_DSelect;
import seulayzer.Control.node;

/**
 *
 * @author abdullahalnawfal
 */
public class preview_CL {
    
    @FXML
    public List<node> nodes = new ArrayList();
    public TextArea p_txt;
    public String text = "";
    
    public void p_button(Event e) throws IOException
    {
        Node node = (Node) e.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        List<node> my_nodes = (List<node>) stage.getUserData();
        
        nodes = my_nodes;
        
        for(int i = 0; i < my_nodes.size(); i++) {
            
            text = text + my_nodes.get(i).firstPath + "\n" + my_nodes.get(i).secondPath + "\n";
            
        }
        
        p_txt.setText(text);
        System.out.println(text);
        
    }
    
    public void startButton(Event e) throws IOException {
        
        Node node = (Node) e.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/seulayzer/View/execute_cmd.fxml"));
        stage.setUserData(nodes);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
    }
    
}
