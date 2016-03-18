/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sad_nb;

import clases.GestorFichero;
import weka.core.Instances;

public class SAD_NB {

    public static void main(String[] args) {
        GestorFichero.getGestorFichero().escribirFichero(GestorFichero.getGestorFichero().leerFichero("src/fichero/tweetSentiment.dev.csv"), "dev.arff");
        Instances data = GestorFichero.getGestorFichero().cargarInstancias("src/fichero/dev.arff");
        System.out.println(data.numInstances());
        System.out.println(data.attribute(data.classIndex()).name());
        
        GestorFichero.getGestorFichero().escribirFichero(GestorFichero.getGestorFichero().leerFichero("src/fichero/tweetSentiment.test_blind.csv"), "test.arff");
        Instances data2 = GestorFichero.getGestorFichero().cargarInstancias("src/fichero/test.arff");
        System.out.println(data2.numInstances());
        System.out.println(data2.attribute(data.classIndex()).name());
        
        GestorFichero.getGestorFichero().escribirFichero(GestorFichero.getGestorFichero().leerFichero("src/fichero/tweetSentiment.train.csv"), "train.arff");
        Instances data3 = GestorFichero.getGestorFichero().cargarInstancias("src/fichero/train.arff");
        System.out.println(data3.numInstances());
        System.out.println(data3.attribute(data.classIndex()).name());
        
        
    
    }
}
