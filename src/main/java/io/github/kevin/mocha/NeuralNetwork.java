package io.github.kevin.mocha;

import io.github.kevin.mocha.internal.Layer;

public class NeuralNetwork {

    private Layer[] layers;

    /**
     * Most basic constructor to create a network
     * 
     * @param sizes An array representing the number of neurons in each layer, where
     *              sizes[0] is the input layer, sizes[1] to sizes[n-2] are hidden
     *              layers, and sizes[n-1] is the output layer
     */
    public NeuralNetwork(int... sizes) {
        // sizes must be length 3 or greater (1 hidden layer)
        if (sizes == null) {
            throw new IllegalArgumentException("Parameter is null.");
        }
        if (sizes.length < 3) {
            throw new IllegalArgumentException("There must be at least 3 layers.");
        }

        layers = new Layer[sizes.length];

        // create layers and connections with correct sizes
        layers[0] = new Layer(sizes[0], 0);
        for (int i = 1; i < sizes.length; i++) {
            layers[i] = new Layer(sizes[i], sizes[i - 1]);
            // set the number of outgoing connections for the previous layer's neurons to
            // the size of this layer (last layer will be left null)
            for (int j = 0; j < sizes[i - 1]; j++) {
                layers[i - 1].get(j).setOutgoingConnections(sizes[i]);
            }
        }
    }

}
