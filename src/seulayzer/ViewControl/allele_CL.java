/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package seulayzer.ViewControl;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import seulayzer.Control.Allele;
import seulayzer.Control.ConnectionDB;
import seulayzer.Modul.Admin;

/**
 *
 * @author abdullahalnawfal
 */
public class allele_CL {
    
    @FXML    
    public Statement st;
    public TextField txt_search;
    public TableView<Allele> tbl_allele = new TableView<Allele>();
    public ObservableList<Allele> data =
        FXCollections.observableArrayList();
    
    public void startSearch(Event e) throws IOException, SQLException {
        
        //st = ConnectionDB.checkConnection().createStatement();
        //ResultSet result = st.executeQuery("SELECT * FROM `Allele`");
        
    }
    
    public void printTable(Event e) throws SQLException { 
                 
        tbl_allele.setEditable(true);
        
        TableColumn id = new TableColumn("ID");
        id.setMinWidth(100);
        id.setCellValueFactory(
                new PropertyValueFactory<Allele, String>("ID"));
 
        TableColumn chr = new TableColumn("Chromosome");
        chr.setMinWidth(100);
        chr.setCellValueFactory(
                new PropertyValueFactory<Allele, String>("Chromosome"));
 
        TableColumn gene = new TableColumn("GENE");
        gene.setMinWidth(100);
        gene.setCellValueFactory(
                new PropertyValueFactory<Allele, String>("GENE"));
        
        TableColumn position = new TableColumn("Position");
        position.setMinWidth(100);
        position.setCellValueFactory(
                new PropertyValueFactory<Allele, String>("Position"));

        TableColumn ref_allele = new TableColumn("Ref_allele");
        ref_allele.setMinWidth(100);
        ref_allele.setCellValueFactory(
                new PropertyValueFactory<Allele, String>("Ref_allele"));
        
        TableColumn alt_allele = new TableColumn("Alt_allele");
        alt_allele.setMinWidth(100);
        alt_allele.setCellValueFactory(
                new PropertyValueFactory<Allele, String>("Alt_allele"));
        
        TableColumn num_of_pnt = new TableColumn("Number_of_patients");
        num_of_pnt.setMinWidth(100);
        num_of_pnt.setCellValueFactory(
                new PropertyValueFactory<Allele, String>("Number_of_patients"));
        
        TableColumn allele_frq = new TableColumn("Allele_Frequency");
        allele_frq.setMinWidth(100);
        allele_frq.setCellValueFactory(
                new PropertyValueFactory<Allele, String>("Allele_Frequency"));
        
        TableColumn het = new TableColumn("Het");
        het.setMinWidth(100);
        het.setCellValueFactory(
                new PropertyValueFactory<Allele, String>("Het"));
        
        TableColumn homo = new TableColumn("Homo");
        homo.setMinWidth(100);
        homo.setCellValueFactory(
                new PropertyValueFactory<Allele, String>("Homo"));
        
        TableColumn function = new TableColumn("Function");
        function.setMinWidth(100);
        function.setCellValueFactory(
                new PropertyValueFactory<Allele, String>("Function"));
        
        TableColumn exonic_fun = new TableColumn("ExonicFunc");
        exonic_fun.setMinWidth(100);
        exonic_fun.setCellValueFactory(
                new PropertyValueFactory<Allele, String>("ExonicFunc"));
        
        TableColumn dpsnp = new TableColumn("AVSNP147");
        dpsnp.setMinWidth(100);
        dpsnp.setCellValueFactory(
                new PropertyValueFactory<Allele, String>("AVSNP147"));
        
        TableColumn info = new TableColumn("INFO");
        info.setMinWidth(100);
        info.setCellValueFactory(
                new PropertyValueFactory<Allele, String>("INFO"));
        
        ObservableList<Allele> data = FXCollections.observableArrayList();        
        tbl_allele.setItems(data);
        tbl_allele.getColumns().addAll(id, chr, gene, position, ref_allele, alt_allele, num_of_pnt, allele_frq, het, homo, function, exonic_fun, dpsnp, info);

        	
        st = ConnectionDB.checkConnection().createStatement();
        ResultSet result = st.executeQuery("SELECT * FROM `Allele`");

        while(result.next()) {
                            
            Allele newA = new Allele();

            newA.ID = Integer.parseInt(result.getString(1));
            newA.Chromosome = result.getString(2);
            newA.GENE = result.getString(3);
            newA.Position = Integer.parseInt(result.getString(4));
            newA.Ref_allele = result.getString(5);
            newA.Alt_allele = result.getString(6);
            newA.Number_of_patients = Integer.parseInt(result.getString(7));
            newA.Allele_Frequency = Float.parseFloat(result.getString(8));
            newA.Het = Integer.parseInt(result.getString(9));
            newA.Homo = Integer.parseInt(result.getString(10));
            newA.Function = result.getString(11);
            newA.ExonicFunc = result.getString(12);
            newA.AVSNP147 = result.getString(13);
            newA.INFO = result.getString(14);
            
            System.out.println(newA.ID + " " + newA.Chromosome + " ");
            
            data.add(newA);
            
        }
        
        //System.out.println(data.get(0).ID);
	
        //tbl_allele.getItems().addAll(data);

    }
    
}
