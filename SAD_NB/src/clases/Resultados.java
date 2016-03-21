/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import weka.classifiers.Evaluation;

/**
 *
 * @author Alvaro
 */
public class Resultados {
    public static void imprimirResultados(Evaluation evaluador) {
        try {
            System.out.println("==================================================");
            System.out.println("Las figuras de mérito del clasificador óptimo son:");
            System.out.println("==================================================");

            System.out.println(evaluador.toSummaryString());

            System.out.println(evaluador.toClassDetailsString());

            System.out.println(evaluador.toMatrixString());

        } catch (Exception ex) {
            System.out.println("Error al mostrar los resultados: "+ex);
        }
    }
    
}
