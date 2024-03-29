package mocha.learning;

import mocha.MochaMath;
import mocha.NeuralNetwork;
import mocha.Trainer;

/**
 * This class implements standard gradient descent.
 * 
 * @author kevin
 */
public class GradientDescent extends Trainer {
    
    public GradientDescent(NeuralNetwork nn, float[][] allData, float[][] expectedData) {
        super(nn, allData, expectedData);
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
     * @param learningRate Learning rate for gradient descent optimization
     */
    @Override
    public void train(float learningRate) {
        randomizeWeightsAndBiases();
        
        for (int data = 0; data < getData().length; data++) {
            // process this case

            // set the input layer to this dataset
            for (int i = 0; i < getLayer(0).getSize(); i++) {
                getLayer(0).get(i).setValue(getData()[data][i]);
            }

            // forward propagate to calculate error
            forwardPropagate();
            
            // back propagate and update weights/biases
            
            float cost = MochaMath.mse(getOutputLayer(), getExpectedData()[data]);
//            System.out.println("Dataset #" + data + " cost: " + cost);
//            for (int i = 0; i < getOutputLayer().length; i++) {
//                System.out.println("Output: " + getOutputLayer()[i] + " Expected: " + getExpectedData()[data][i]);
//            }
        }
    }

}
