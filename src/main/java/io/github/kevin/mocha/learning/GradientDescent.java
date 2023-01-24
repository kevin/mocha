package io.github.kevin.mocha.learning;

import io.github.kevin.mocha.NeuralNetwork;
import io.github.kevin.mocha.Trainer;
import io.github.kevin.mocha.internal.MochaMath;

/**
 * This class implements standard gradient descent.
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
     * Set the number of epochs to train with.
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
     * 
     * @param trainingThreshold A threshold to stop training; probably convergence
     *                          of weight/biases
     */
    @Override
    public void train(float trainingThreshold) {
        randomizeWeightsAndBiases();
        
        for (int data = 0; data < getData().length; data++) {
            // process this case

            // set the input layer to this dataset
            for (int i = 0; i < getLayer(0).getSize(); i++) {
                getLayer(0).get(i).setValue(getData()[data][i]);
            }

            // forward propagate to calculate error
            forwardPropagate();
            
            float cost = MochaMath.mse(getOutputLayer(), getExpectedData()[data]);
//            System.out.println("Dataset #" + data + " cost: " + cost);
//            for (int i = 0; i < getOutputLayer().length; i++) {
//                System.out.println("Output: " + getOutputLayer()[i] + " Expected: " + getExpectedData()[data][i]);
//            }
        }
    }

}
