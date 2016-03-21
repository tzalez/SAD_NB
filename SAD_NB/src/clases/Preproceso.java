/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import weka.core.Instances;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Remove;
import weka.filters.unsupervised.attribute.StringToNominal;
import weka.filters.unsupervised.instance.Randomize;

/**
 *
 * @author Alvaro
 */
public class Preproceso {

    public static Instances randomize(Instances data) throws Exception {
        Randomize ran = new Randomize();
        ran.setRandomSeed(42);
        ran.setInputFormat(data);
        return Filter.useFilter(data, ran);
    }

    public static Instances filterStringToNominal(Instances data , String i){
        try {
            StringToNominal sn= new StringToNominal();
            sn.setAttributeRange(i);
            sn.setInputFormat(data);
            return Filter.useFilter(data, sn);
        } catch (Exception ex) {
            Logger.getLogger(Preproceso.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    
    public static Instances filterRemoveAttribute(Instances data, List<String> indices) {
        String ind = "";
        boolean a = false;
        for (String atrib : indices) {
            for (int i = 0; i < data.numAttributes(); i++) {
                if (data.attribute(i).name().equals(atrib)) {
        /*            if(!a)
                        ind=""+i;
                    else*/
                      ind = ind + "," + i;
                    break;
                }
            }
        }
        Remove rm = new Remove();
        rm.setAttributeIndices(ind.substring(1, ind.length()));
        
        try {
            rm.setInputFormat(data);
            return Filter.useFilter(data, rm);
        } catch (Exception ex) {
            Logger.getLogger(Preproceso.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

}
