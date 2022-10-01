package io.github.kevin.mocha.internal;

/**
 * This class provides math functions for the neural network
 * 
 * @author kevin
 */
public class MochaMath {

    /**
     * Sigmoid function for non-linearity
     * 
     * @param f The value to be squishified
     * @return 1 / (1 + e^-x)
     */
    public static float sigmoid(float f) {
        return (float) (1 / (1 + Math.pow(Math.E, -f)));
    }

    /**
     * ReLU function for non-linearity
     * 
     * @param f The value to to be changed
     * @return
     */
    public static float relu(float f) {
        return Math.max(0, f);
    }

    /**
     * Cost function using mean squared error
     * 
     * @param out      The output layer
     * @param expected The expected output
     * @return The mean difference of output and expected values
     */
    public static float mse(float[] out, float[] expected) {
        float sum = 0.0f;

        for (int i = 0; i < out.length; i++) {
            sum += Math.pow(out[i] - expected[i], 2);
        }

        return sum / out.length;
    }

}
