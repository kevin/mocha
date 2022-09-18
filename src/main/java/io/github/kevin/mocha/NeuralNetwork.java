package io.github.kevin.mocha;

import io.github.kevin.mocha.internal.Connection;
import io.github.kevin.mocha.internal.Layer;

public class NeuralNetwork {

    private Layer[] layers;
    private Connection[][] connections;

    /**
     * Most basic constructor to create a network
     * 
     * @param sizes     An array representing the number of neurons in each layer,
     *                  where sizes[0] is the input layer, sizes[1] to
     *                  sizes[n-2] are hidden layers, and sizes[n-1]
     *                  is the output layer
     */
    public NeuralNetwork(int... sizes) {
        
        // sizes must be length 3 or greater (1 hidden layer)
        if (sizes ==  null) {
            throw new IllegalArgumentException("Parameter is null.");
        }
        if (sizes.length < 3) {
            throw new IllegalArgumentException("There must be at least 3 layers.");
        }
        
        layers = new Layer[sizes.length];
        
        // create layers with correct sizes
        for (int i = 0; i < sizes.length; i++) {
            layers[i] = new Layer(sizes[i]);
        }
        
    }

}
