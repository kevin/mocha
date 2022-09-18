package io.github.kevin.mocha;

import io.github.kevin.mocha.internal.Layer;

public class NeuralNetwork {

    private Layer[] layers;

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
        layers[0] = new InputLayer(sizes[0]);
        for (int i = 1; i < sizes.length-1; i++) {
            layers[i] = new HiddenLayer(sizes[i]);
        }
        layers[sizes.length-1] = new OutputLayer(sizes[sizes.length-1]);
        
    }

}
