/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package seulayzer.ViewControl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import seulayzer.Control.node;

/**
 *
 * @author abdullahalnawfal
 */
public class execute_g_CL {
    
    @FXML
    public TextArea f_txt;
    
    public void startCMD(Event e) throws IOException {
        
        Node node = (Node) e.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        List<node> my_nodes = (List<node>) stage.getUserData();
        
        
        
        String firstPath = my_nodes.get(0).ref_path;
        String bedPath = WES_Ref_CL.bedPath;
        String output = my_nodes.get(0).output_path + "/";
        
        //System.out.print(my_nodes.size());
        
        int cpu = Setting_CL.CPU;
        int ram = Setting_CL.RAM;
                
        for(int i = 0; i < my_nodes.size(); i++) {
            
            String pnt_num = my_nodes.get(i).pntNumber;
            String secondPath = my_nodes.get(i).firstFile.getPath();
            String thirdPath = my_nodes.get(i).secondFile.getPath();
            String outputPath = output + pnt_num;
            String w = "\"@RG\\tID:Novaseq\\tSM:" + pnt_num + "\\tPL:ILLUMINA\\tPI:330\"";
            //align Fastq files
            String cmd = "/usr/local/bin/bwa mem -t " + cpu + " " + "-R " + w.replaceAll("\\s", "") + " " + firstPath + " " + secondPath + " " + thirdPath + " " + " > " + outputPath + ".sam";
            //String cmd = "echo A";
            System.out.println(cmd);
            ProcessBuilder pb = new ProcessBuilder("/bin/bash", "-c", cmd);
            pb.redirectErrorStream(true);
            Process process = null;
            try {
                process = pb.start();
                InputStreamReader isReader = new InputStreamReader(process.getInputStream());
                BufferedReader reader = new BufferedReader(isReader);
                StringBuffer sb = new StringBuffer();
                String str;
                while((str = reader.readLine())!= null){
                   sb.append(str + "\n");
                }
                System.out.println(sb.toString());
                f_txt.setText(sb.toString());
                int rc = process.waitFor();
            } catch (IOException | InterruptedException ex) {
                Logger.getLogger(execute_CL.class.getName()).log(Level.SEVERE, null, ex);
            }
            //Convert SAM to BAM
            String cmd2 = "/usr/local/bin/sambamba view  -t " + cpu + " --format=bam -S " + outputPath + ".sam" + " " +"--output-filename=" + " " +outputPath + ".bam";
            //String cmd2 = "echo B";
            ProcessBuilder pb2 = new ProcessBuilder("/bin/bash", "-c", cmd2);
            pb2.redirectErrorStream(true);
            Process process2 = null;
            try {
                process2 = pb2.start();
                InputStreamReader isReader = new InputStreamReader(process2.getInputStream());
                BufferedReader reader = new BufferedReader(isReader);
                StringBuffer sb = new StringBuffer();
                String str;
                while((str = reader.readLine())!= null){
                   sb.append(str + "\n");
                }
                System.out.println(sb.toString());
                f_txt.setText(sb.toString());
                int rc = process.waitFor();
            } catch (IOException | InterruptedException ex) {
                Logger.getLogger(execute_CL.class.getName()).log(Level.SEVERE, null, ex);
            }
            //Sort BAM file
            String cmd3 = "/usr/local/bin/sambamba sort -t " + cpu + " " + "-m " + ram + "G -o" + " " + outputPath +"_Sorted.bam" + " " +outputPath+ ".bam";
            //String cmd3 = "echo C";
            ProcessBuilder pb3 = new ProcessBuilder("/bin/bash", "-c", cmd3);
            pb3.redirectErrorStream(true);
            Process process3 = null;
            try {
                process3 = pb3.start();
                InputStreamReader isReader = new InputStreamReader(process3.getInputStream());
                BufferedReader reader = new BufferedReader(isReader);
                StringBuffer sb = new StringBuffer();
                String str;
                while((str = reader.readLine())!= null){
                   sb.append(str + "\n");
                }
                System.out.println(sb.toString());
                f_txt.setText(sb.toString());
                int rc = process.waitFor();
            } catch (IOException | InterruptedException ex) {
                Logger.getLogger(execute_CL.class.getName()).log(Level.SEVERE, null, ex);
            }
   
            //Statistics result
            String cmd6 = "/usr/local/bin/sambamba flagstat -t " + cpu + " " + outputPath + "_Sorted.bam" + " " + " > " +  " " + outputPath + "_QC.txt";
            //String cmd6 = "echo E";
            ProcessBuilder pb6 = new ProcessBuilder("/bin/bash", "-c", cmd6);
            pb6.redirectErrorStream(true);
            Process process6 = null;
            try {
                process6 = pb6.start();
                InputStreamReader isReader = new InputStreamReader(process6.getInputStream());
                BufferedReader reader = new BufferedReader(isReader);
                StringBuffer sb = new StringBuffer();
                String str;
                while((str = reader.readLine())!= null){
                   sb.append(str + "\n");
                }
                System.out.println(sb.toString());
                f_txt.setText(sb.toString());
                int rc = process.waitFor();
            } catch (IOException | InterruptedException ex) {
                Logger.getLogger(execute_CL.class.getName()).log(Level.SEVERE, null, ex);
            }
            //Varients Calling
            String cmd7 = "python3 /Users/abdullahalnawfal/Downloads/gatk-4.4.0.0/gatk HaplotypeCaller --native-pair-hmm-threads " + cpu + " -I " + outputPath + "_Sorted.bam" + " -O " + outputPath + ".vcf" + " -R " + firstPath;
            ProcessBuilder pb7 = new ProcessBuilder("/bin/bash", "-c", cmd7);
            pb7.redirectErrorStream(true);
            Process process7 = null;
            try {
                process7 = pb7.start();
                InputStreamReader isReader = new InputStreamReader(process7.getInputStream());
                BufferedReader reader = new BufferedReader(isReader);
                StringBuffer sb = new StringBuffer();
                String str;
                while((str = reader.readLine())!= null){
                   sb.append(str + "\n");
                }
                System.out.println(sb.toString());
                f_txt.setText(sb.toString());
                int rc = process.waitFor();
            } catch (IOException | InterruptedException ex) {
                Logger.getLogger(execute_CL.class.getName()).log(Level.SEVERE, null, ex);
            }
            //Varients Calling
            String cmd8 = "echo process finished for: " + outputPath ;
            ProcessBuilder pb8 = new ProcessBuilder("/bin/bash", "-c", cmd8);
            pb8.redirectErrorStream(true);
            Process process8 = null;
            try {
                process8 = pb8.start();
                InputStreamReader isReader = new InputStreamReader(process8.getInputStream());
                BufferedReader reader = new BufferedReader(isReader);
                StringBuffer sb = new StringBuffer();
                String str;
                while((str = reader.readLine())!= null){
                   sb.append(str + "\n");
                }
                System.out.println(sb.toString());
                f_txt.setText(sb.toString());
                int rc = process.waitFor();
            } catch (IOException | InterruptedException ex) {
                Logger.getLogger(execute_CL.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
    }
}
