package io.github.kevin.mocha.internal;

public class MochaMath {

    // this class provides math functions for the neural network

    /**
     * Sigmoid function for non-linearity
     * 
     * @param f The value to be
     * @return 1 / (1 + e^-x)
     */
    public static float sigmoid(float f) {
        return (float) (1 / (1 + Math.pow(Math.E, -f)));
    }

}
