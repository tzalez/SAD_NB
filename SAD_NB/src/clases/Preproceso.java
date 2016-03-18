/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import weka.core.Instances;
import weka.filters.Filter;
import weka.filters.unsupervised.instance.Randomize;

/**
 *
 * @author Alvaro
 */
public class Preproceso {
    public static Instances randomize(Instances data) throws Exception {
        Randomize ran = new Randomize();
        //int a = (int) (Math.random() * 150 + 1);
        ran.setRandomSeed(42);
        ran.setInputFormat(data);
        return Filter.useFilter(data, ran);
    }
}
