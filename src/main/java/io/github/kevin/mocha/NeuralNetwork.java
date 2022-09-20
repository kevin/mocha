package io.github.kevin.mocha;

import java.util.Random;

import io.github.kevin.mocha.internal.Connection;
import io.github.kevin.mocha.internal.Layer;
import io.github.kevin.mocha.internal.Neuron;

public class NeuralNetwork {

    private Layer[] layers;

    /**
     * Most basic constructor to create a network
     * 
     * @param sizes An array representing the number of neurons in each layer, where
     *              sizes[0] is the input layer, sizes[n-1] is the output layer, and
     *              anything in between is a hidden layer
     */
    public NeuralNetwork(int... sizes) {
        // sizes must be length 2 or greater (1 hidden layer)
        if (sizes == null) {
            throw new IllegalArgumentException("Parameter is null.");
        }
        if (sizes.length < 2) {
            throw new IllegalArgumentException("There must be at least 2 layers.");
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

            // add incoming connections to this layer based on the previous layer's outgoing
            // connections
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
     * 
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

    /**
     * Train the network on given data
     * 
     * @param data     The set of training data, where any data[row].length (size of
     *                 one training example) == layers[0].getSize() (input layer
     *                 size)
     * @param expected The expected results corresponding to each dataset
     */
    public void train(float[][] allData, float[][] expected) {
        // check parameters
        if (allData == null || allData.length == 0) {
            throw new IllegalArgumentException("Data is invalid.");
        }
        if (expected == null || expected.length != allData.length) {
            throw new IllegalArgumentException("Expected results are invalid.");
        }

        randomizeWeights();

        for (int data = 0; data < allData.length; data++) {
            // check parameters for each training case
            if (allData[data].length != layers[0].getSize()) {
                throw new IllegalArgumentException("Dataset @ index " + data + " is invalid.");
            }
            if (expected[data].length != layers[layers.length - 1].getSize()) {
                throw new IllegalArgumentException(
                        "Expected results @ index " + data + " is invalid.");
            }

            // process this case
        }
    }

    /**
     * Populates all connection weights with random values
     */
    private void randomizeWeights() {
        Random rng = new Random();
        for (int i = 1; i <= layers.length; i++) {
            for (int j = 0; j < layers[i].getSize(); j++) {
                for (int k = 0; k < layers[i - 1].getSize(); k++) {
                    layers[i].get(j).getIn(k).setWeight(rng.nextFloat());
                }
            }
        }
    }

    /**
     * 
     * @return The total number of connections in this network
     */
    private int getNumConnections() {
        int n = 0;
        for (int i = 1; i < layers.length; i++) {
            n += layers[i].getSize() * layers[i - 1].getSize();
        }
        return n;
    }

    public String toString() {
        String out = "NEURAL NETWORK:\n\tNUM CONNECTIONS: " + getNumConnections() + "\n";
        for (Layer l : layers)
            out += l.toString() + "\n";
        return out;
    }

}
