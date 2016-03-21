/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sad_nb;

import clases.Baseline;
import clases.GestorFichero;
import weka.core.Instances;

public class SAD_NB {

    public static void main(String[] args) {
        GestorFichero.getGestorFichero().escribirFichero(GestorFichero.getGestorFichero().leerFichero("src/fichero/tweetSentiment.dev.csv"), "dev.arff");
        Instances dataDev = GestorFichero.getGestorFichero().cargarInstancias("src/fichero/dev.arff");
        
        GestorFichero.getGestorFichero().escribirFichero(GestorFichero.getGestorFichero().leerFichero("src/fichero/tweetSentiment.test_blind.csv"), "test.arff");
        Instances dataTest = GestorFichero.getGestorFichero().cargarInstancias("src/fichero/test.arff");
        
        GestorFichero.getGestorFichero().escribirFichero(GestorFichero.getGestorFichero().leerFichero("src/fichero/tweetSentiment.train.csv"), "train.arff");
        Instances dataTrain = GestorFichero.getGestorFichero().cargarInstancias("src/fichero/train.arff");
        
        Baseline b = new Baseline();
        
    }
}
