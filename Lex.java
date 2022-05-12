/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LEXERPJ;

import java.util.List;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author SERVER
 */
public class Lex {
    private List<String> variable = new ArrayList<String>();
    private List<String> variableOrden = new ArrayList<String>();
    // ^^ porque se necesitan las variables aunque sean repetidas por si existen dos o mas producciones por variable
    private List<String> archivoTxt = new ArrayList<String>();
    private List<String> terminal = new ArrayList<String>();
    public List<String> produccion = new ArrayList<String>();
    public List<String> varxPro = new ArrayList<String>();
    // ^^ porque pueden haber dos o mas producciones por variable separadas por una --> |
    
    public void setLimpiarListas(){
        this.variable.clear();
        this.variableOrden.clear();
        this.archivoTxt.clear();
        this.terminal.clear(); 
        this.produccion.clear();  
        this.varxPro.clear();        
    }
    
    
    public String getArchivo(){
        String resultado="";
        for (int i = 0; i < archivoTxt.size(); i++) {
            resultado += archivoTxt.get(i) + "\n" ;
        }
        return resultado;
    }
    
    public String getVariable(){
        String resultadoV = "";
        for (int i = 0; i < variable.size(); i++) {
            resultadoV += variable.get(i) + "\n";
            
        }
        return resultadoV;
    }
    public String getTerminal(){
        String resultadoT = "";
        for (int i = 0; i < terminal.size(); i++) {
            resultadoT += terminal.get(i) + "\n";
            
        }
        return resultadoT;
    }
    public String getProduccion(){
        String resultadoP = "";
        for (int i = 0; i < produccion.size(); i++) {
            resultadoP += produccion.get(i) + "\n";
            
        }
        return resultadoP;
    }
    public String getVarxprod(){
        String resultadoX = "";
        for (int i = 0; i < varxPro.size(); i++) {
            resultadoX += varxPro.get(i) + "\n";
            
        }
        return resultadoX;
    }
     
    public void agregaVariable(String var){
        boolean flag=false;
        if (variable.size()==0){
            variable.add(var);
        }
        for (int i = 0; i < variable.size(); i++) {
            if(var.equals(variable.get(i))){
                flag=true;
            }
        }
        if(flag == false){
            variable.add(var);
        }
            variableOrden.add(var);
       
    }
        public void agregaTerminal(String var){
        boolean flag=false;
        if (terminal.size()==0){
            terminal.add(var);
        }
        for (int i = 0; i < terminal.size(); i++) {
            if(var.equals(terminal.get(i))){
                flag=true;
            }
        }
        if(flag == false){
            terminal.add(var);
        }
    }
    
    public String abrirArchivo(){
        String path="";
        String variable_="";
        String lineaOriginal="";
        String terminal_="";
        String produccion_="";
        int varActual =0;
        
        JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView());
        int valO = j.showOpenDialog(null);
        if(valO == JFileChooser.APPROVE_OPTION){
            try {
                 File arch = new File(j.getCurrentDirectory()+"\\"+j.getSelectedFile().getName());
                 Scanner read = new Scanner(arch);
                 path = j.getCurrentDirectory()+"\\"+j.getSelectedFile().getName();
                    while (read.hasNextLine()) {
                      String[] varDesglozada={};
                     
                      String[] terDesglozada={};
                      String[] prodDesglozada={};
                      
                      lineaOriginal = read.nextLine();
                      archivoTxt.add(lineaOriginal);
                     
                      //variable_ = lineaOriginal.replaceAll("[^A-Z0-9]+"," ");
                      //cuando se trabaje epsilon hay que establecer aca que no es un terminal ya sea un $ o una e
                      terminal_ = lineaOriginal.replaceAll("[A-Z0-9:'\\|]+", " ");
                      produccion_ = lineaOriginal.replaceAll("^[A-Z0-9]+[:]", " ");
                      produccion_ = produccion_.trim();
                      
                      // la variable se obtiene separandola de la produccion, los dos puntos la separan
                      varDesglozada = lineaOriginal.split("[:]+");
                      terDesglozada = terminal_.split("[\\s]+");
                      prodDesglozada = produccion_.split("[\\|]");
                      //este flag sirve para que se vaya solo la linea impar al separar la variable del terminal
                      boolean flagVar = false;
                       for (String envio: varDesglozada) { 
                          
                           if(flagVar == false){
                               agregaVariable(envio);
                               flagVar = true;
                            
                           }
                           
                       }
                       for (String enviot: terDesglozada) {
                           if(!enviot.isEmpty()){
                              agregaTerminal(enviot); 
                           }
                       }
                         for (String enviop: prodDesglozada) {
                            produccion.add(enviop);
               //la variable actual se duplica en otra lista porque hay un --> | hay dos o mas producciones para la variable
                            varxPro.add(variableOrden.get(varActual));
                       }
                      
                      varActual++;  
                      
                    }
                    read.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Error inesperado: " + e);
            }
        }
      return path;
    }
    public String variablex(String txt){
        
        
        return "";
    }
    
    
}
