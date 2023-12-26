/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package seulayzer.ViewControl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import seulayzer.Control.WES_DSelect;
import seulayzer.Control.node;

/**
 *
 * @author abdullahalnawfal
 */
public class WGS_DATA_CL {
    
        @FXML
    public TextField txt_pnt_num, oPath;
    public TextArea all_txt, all_txt_pnt;
    public Button btn_add_sample, button_next;
    WES_DSelect wes = new WES_DSelect();
    List<node> nodes = new ArrayList();
    String txt = "";
    String pnt_txt = "";
    int index = 0;
    
    public void addSample(Event e) throws IOException
    {
        node newNode = wes.addSample();

        Node node = (Node) e.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        newNode.ref_path = (String) stage.getUserData();
        
        newNode.firstPath = newNode.firstFile.getPath() + txt_pnt_num.getText();
        newNode.secondPath = newNode.secondFile.getPath() + txt_pnt_num.getText();
        
        txt = txt + newNode.firstFile.getPath() + txt_pnt_num.getText() + "\n";
        txt = txt + newNode.secondFile.getPath() + txt_pnt_num.getText() + "\n";
        pnt_txt = pnt_txt + txt_pnt_num.getText() + "\n";
        pnt_txt = pnt_txt + txt_pnt_num.getText() + "\n";
        all_txt.setText(txt);
        all_txt_pnt.setText(pnt_txt);
        
        newNode.pntNumber = txt_pnt_num.getText();
        nodes.add(newNode);
        System.out.println(nodes.size());
        index++;
    }
    
    public void outPath(Event e) throws IOException
    {

        DirectoryChooser ref = new DirectoryChooser();
        
        File folder = ref.showDialog(new Stage());
        
        oPath.setText(folder.getPath());
        
        nodes.get(0).output_path = folder.getPath();

    }
    
    public void buttonNext(Event e) throws IOException
    {
        Node node = (Node) e.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/seulayzer/View/preview_g.fxml"));
        stage.setUserData(nodes);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void buttonBack(Event e) throws IOException
    {
        Node node = (Node) e.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/seulayzer/View/WGS_Worflow_Reference&bed_Selection.fxml"));
        stage.setUserData(nodes);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
}
