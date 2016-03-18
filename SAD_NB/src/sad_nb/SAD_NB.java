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
    }
}
