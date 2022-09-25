package io.github.kevin.mocha.learning;

import io.github.kevin.mocha.NeuralNetwork;
import io.github.kevin.mocha.Trainer;

/**
 * This class implements standard gradient descent
 * 
 * @author kx
 */
public class GradientDescent extends Trainer {

    public GradientDescent(NeuralNetwork nn, float[][] allData, float[][] expectedData) {
        super(nn, allData, expectedData);
    }

    @Override
    public void train() {
        randomizeWeightsAndBiases();

//        for (int data = 0; data < allData.length; data++) {
//            // process this case
//
//            // set the input layer to this dataset
//            for (int i = 0; i < layers[0].getSize(); i++) {
//                layers[0].get(i).setValue(allData[data][i]);
//            }
//
//            // forward propagate to calculate error
//            forwardPropagate();
//        }
    }

}
