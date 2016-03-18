/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sad_nb.SAD_NB;
import weka.core.Instances;

/**
 *
 * @author jimy
 */
public class GestorFichero {
    private static GestorFichero gestorFichero;
    private FileReader ficheroARFF=null;
    private static String firstLine = "";
    private GestorFichero(){
    }
    public static GestorFichero getGestorFichero(){
        if(gestorFichero==null){
            gestorFichero= new GestorFichero();
        }
        return gestorFichero;
    }
    
    private void abrirFichero(String dirFichero){
        try {
            ficheroARFF = new FileReader(dirFichero);
        } catch (FileNotFoundException ex) {
            System.out.println("Error: Revisar la dirección del fichero --> "+dirFichero);
        }
    }
    
    private void cerrarFichero(){
        try {
            ficheroARFF.close();
        } catch (IOException ex) {
            System.out.println("Error al cerrar el fichero.");
        }
    }
    
    public Instances cargarInstancias (String dirFichero){
        try {
            abrirFichero(dirFichero);
            if(ficheroARFF!=null){
                Instances instancias = new Instances(ficheroARFF);
                asignarClase(instancias);
                ficheroARFF.close();
                return instancias;
            }else
                return null;
        } catch (IOException ex) {
            System.out.println("Error al cargar las instancias del fichero."+ex.getMessage().toString());
            return null;
        }
    }
    private void asignarClase(Instances data){
        for (int i = 0; i < data.numInstances(); i++) {
            if(data.attribute(i).name().equals(" class")){
                data.setClassIndex(i);
                break;
            }
        }
    }

    public static LinkedList<List<String>> leerFichero(String dir) {
        FileReader f = null;
        try {
            LinkedList<List<String>> data = new LinkedList();
            String cadena;
            f = new FileReader(dir);
            BufferedReader b = new BufferedReader(f);
            firstLine = b.readLine();
            firstLine=firstLine.replace("\"", "");
            while ((cadena = b.readLine()) != null) {
                cadena = cadena.replace("\"", "");
                String arrayCad[] = cadena.split(",");
                if (arrayCad[0].indexOf("google")==0 || arrayCad[0].indexOf("microsoft")==0 || arrayCad[0].indexOf("apple")==0 || arrayCad[0].indexOf("twitter")==0) {
                    List<String> temp = Arrays.asList(arrayCad);
                    data.addLast(temp);
                }

            }
            b.close();
            return data;
        } catch (Exception ex) {
            Logger.getLogger(SAD_NB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static void escribirFichero(LinkedList<List<String>> data, String newFile) {
        try {
            String cadT = "", dir="src/fichero/" + newFile;
            File f = new File(dir);
            System.out.println(f.getAbsolutePath());
            if(!f.exists())
                f.createNewFile();
            BufferedWriter bw = new BufferedWriter(new FileWriter(dir));
            String t[] = firstLine.split(",");
            bw.write("@relation tuits\n\n");
            bw.write("@attribute ' "+t[0]+"' {' google', ' apple', ' twitter', ' microsoft'}\n");
            bw.write("@attribute ' class' {' positive', ' neutral',' negative', ' irrelevant'}\n");
            bw.write("@attribute ' "+t[2]+"' numeric\n");
            bw.write("@attribute ' "+t[3]+"' string\n");
            bw.write("@attribute ' "+t[4]+"' string\n\n\n");
            bw.write("@data\n");
            for (List<String> temp : data) {
                cadT="";
                for(int j=0;j<temp.size(); j++){
                    if(j==0)
                        cadT="' "+temp.get(j)+"'";
                    else if(j==2)
                        cadT=cadT+","+temp.get(j);
                    else if (j==1 || j==3 || j==4){ 
                        String te=temp.get(j).replace("'", "");
                        cadT=cadT+",' "+te+"'";
                    }
                }
                bw.write(cadT+"\n");
            }
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(SAD_NB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
