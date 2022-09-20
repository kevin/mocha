package io.github.kevin.mocha;

import io.github.kevin.mocha.internal.Connection;
import io.github.kevin.mocha.internal.Layer;
import io.github.kevin.mocha.internal.Neuron;

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
            // the size of this layer (last layer will be left null) and add outgoing
            // connections to the previous layer connected to this layer
            for (int j = 0; j < sizes[i - 1]; j++) {
                layers[i - 1].get(j).setOutgoingConnections(sizes[i]);
                for (int k = 0; k < sizes[i]; k++) {
                    layers[i - 1].get(j).setOut(k,
                            new Connection(layers[i - 1].get(j), layers[i].get(k)));
                }
            }

            // add incoming connections to this layer based on the previous layer's outgoing connections
            for (int j = 0; j < sizes[i]; j++) {
                for (int k = 0; k < sizes[i - 1]; k++) {
                    layers[i].get(j).setIn(k, layers[i - 1].get(k).getOut(j));
                    layers[i - 1].get(k).getOut(j).setTo(layers[i].get(j));
                }
            }
        }
    }
    
    /**
     * Get the neuron at a specific layer and index
     * @param layer
     * @param index
     * @return
     */
    public Neuron getNeuron(int layer, int index) {
        // parameters must be in bounds
        if (layer < 0 || layer >= layers.length) {
            throw new IndexOutOfBoundsException();
        }
        return layers[layer].get(index);
    }
    
    public String toString() {
        String out = "";
        for (Layer l : layers)
            out += l.toString() + "\n";
        return out;
    }

}
