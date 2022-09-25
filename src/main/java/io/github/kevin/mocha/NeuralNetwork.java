package io.github.kevin.mocha;

import java.util.Random;

import io.github.kevin.mocha.internal.Connection;
import io.github.kevin.mocha.internal.Layer;
import io.github.kevin.mocha.internal.Neuron;

/**
 * This class represents a whole network, which the end user can use
 * 
 * @author kevin
 */
public class NeuralNetwork {

    private Layer[] layers;
    private float learningRate;

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
        
        // set a default learning rate`
        learningRate = 0.01f;

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
                    layers[i - 1].get(j).setOut(k, new Connection(layers[i - 1].get(j), layers[i].get(k)));
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
     * @param layer The layer of the desired neuron
     * @param index The index of the desired neuron between 0 and the layer size - 1
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
     * Get the layers
     * @return All layers
     */
    protected Layer[] getLayers() {
        return layers;
    }

    /**
     * 
     * @return Get the current learning rate for this neural network
     */
    public float getLearningRate() {
        return learningRate;
    }

    /**
     * Set a new learning rate for this neural network
     * 
     * @param rate The new learning rate to train with
     */
    public void setLearningRate(float rate) {
        this.learningRate = rate;
    }

    /**
     * Populates all connection weights and neuron biases with random values. The
     * input layer will be left alone, meaning all 0 bias values
     */
    protected void randomizeWeightsAndBiases() {
        Random rng = new Random();
        for (int i = 1; i < layers.length; i++) {
            for (int j = 0; j < layers[i].getSize(); j++) {
                for (int k = 0; k < layers[i - 1].getSize(); k++) {
                    layers[i].get(j).getIn(k).setWeight(rng.nextFloat());
                }
                layers[i].get(j).setBias(rng.nextFloat());
            }
        }
    }

    /**
     * Run the neural network on a given dataset
     * 
     * @param data The data to predict from (input)
     * @return The results
     */
    public float[] predict(float[] data) {
        // check parameters
        if (data == null || data.length != layers[0].getSize()) {
            throw new IllegalArgumentException("Data is invalid.");
        }

        // set input layer to the data
        for (int i = 0; i < data.length; i++) {
            layers[0].get(i).setValue(data[i]);
        }

        // forward propagate with data
        forwardPropagate();

        // return the output layer
        float[] output = new float[layers[layers.length - 1].getSize()];
        for (int i = 0; i < output.length; i++) {
            output[i] = layers[layers.length - 1].get(i).getValue();
        }

        return output;
    }

    /**
     * Calculates forward propagation in the network with the current input layer
     */
    protected void forwardPropagate() {
        // calculate activation for each neuron layer by later
        for (int i = 1; i < layers.length; i++) {
            for (int j = 0; j < layers[i].getSize(); j++) {
                // set this neuron value to its calculated activation
                layers[i].get(j).setValue(layers[i].get(j).calcActivation());
            }
        }
    }

    /**
     * @return The total number of connections in this network
     */
    protected int getNumConnections() {
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
