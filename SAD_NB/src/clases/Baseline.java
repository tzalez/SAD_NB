package clases;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.core.Instances;

public class Baseline {

    public Evaluation aplicarNaiveBayes(Instances data) {
        try {
            NaiveBayes nb = new NaiveBayes();
            nb.buildClassifier(data);
            
            
            Evaluation eval = new Evaluation(data);
            eval.crossValidateModel(nb, data, 2, new Random(1));
            return eval;
        } catch (Exception ex) {
            Logger.getLogger(Baseline.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al evaluar");
            return null;
        }
    }

}
