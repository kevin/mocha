package io.github.kevin.mocha.learning;

import io.github.kevin.mocha.NeuralNetwork;
import io.github.kevin.mocha.Trainer;

/**
 * This class implements standard gradient descent
 * 
 * The derivative of the cost function with respect to weight. z(L) = w(L) *
 * a(L−1) + b(L)
 * 
 * (change in z with respect to w) * (change in activation with respect to z) *
 * (change in C (cost) with respect to activation)
 * 
 * Which works out to dz(L)/dw(L) * da(L)/dz(L) * dC(L)/dz(L) = dC(L)/dw(L)
 * 
 * @author kevin
 */
public class GradientDescent extends Trainer {
    
    // the number of epochs to train with
    private int epochs;

    public GradientDescent(NeuralNetwork nn, float[][] allData, float[][] expectedData) {
        super(nn, allData, expectedData);
        // by default use 1 epoch
        this.epochs = 1;
    }
    
    /**
     * Set the number of epochs to train with
     * @param num The number of epochs
     */
    public void setEpochs(int num) {
        this.epochs = num;
    }

    /**
     * The derivative of the cost function with respect to weight is z(L) = w(L) *
     * a(L−1) + b(L)
     * 
     * (change in z with respect to w) * (change in activation with respect to z) *
     * (change in C (cost) with respect to activation)
     * 
     * Which works out to dz(L)/dw(L) * da(L)/dz(L) * dC(L)/dz(L) = dC(L)/dw(L)
     */
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
