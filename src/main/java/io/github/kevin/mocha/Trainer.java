package io.github.kevin.mocha;

import io.github.kevin.mocha.internal.Layer;

/**
 * This class represents a learning algorithm implementation
 * 
 * @author kx
 */
public abstract class Trainer {

    // the NeuralNetwork object to train
    private NeuralNetwork nn;
    // the set of training data
    private float[][] allData;
    // the set of expected results
    private float[][] expectedData;

    /**
     * Create a trainer object
     * 
     * @param nn
     * @param allData      The set of training data, where any data[row].length
     *                     (size of one training example) == layers[0].getSize()
     *                     (input layer size)
     * @param expectedData The expected results corresponding to each dataset
     */
    public Trainer(NeuralNetwork nn, float[][] allData, float[][] expectedData) {
        // set variables
        this.nn = nn;
        this.allData = allData;
        this.expectedData = expectedData;

        // validate data
        validateData();
    }

    /**
     * Set new data for this trainer
     * 
     * @param allData      The set of training data, where any data[row].length
     *                     (size of one training example) == layers[0].getSize()
     *                     (input layer size)
     * @param expectedData The expected results corresponding to each dataset
     */
    public void setData(float[][] allData, float[][] expectedData) {
        this.allData = allData;
        this.expectedData = expectedData;

        validateData();
    }

    /**
     * Validate the data
     */
    private void validateData() {
        if (allData == null || allData.length == 0) {
            throw new IllegalArgumentException("Training data is invalid.");
        }
        if (expectedData == null || expectedData.length != allData.length) {
            throw new IllegalArgumentException("Expected results are invalid.");
        }

        // validate each set individually
        for (int data = 0; data < allData.length; data++) {
            // check parameters for each training case
            if (allData[data].length != getLayer(0).getSize()) {
                throw new IllegalArgumentException("Dataset @ index " + data + " is invalid.");
            }
            if (expectedData[data].length != getLayer(getNumLayers() - 1).getSize()) {
                throw new IllegalArgumentException("Expected results @ index " + data + " is invalid.");
            }
        }
    }

    public abstract void train();

    // wrap methods for learning algorithms and to prevent breaking the network
    
    /**
     * Get a layer object at an index
     * 
     * @param index The index of the layer
     * @return The layer
     */
    protected Layer getLayer(int index) {
        // parameters must be in bounds
        if (index < 0 || index >= nn.getLayers().length) {
            throw new IndexOutOfBoundsException();
        }
        return nn.getLayers()[index];
    }
    
    /**
     * @return The number of layers in the network
     */
    protected int getNumLayers() {
        return nn.getLayers().length;
    }
    
    /**
     * Populates all connection weights and neuron biases with random values. The
     * input layer will be left alone, meaning all 0 bias values
     */
    protected void randomizeWeightsAndBiases() {
        nn.randomizeWeightsAndBiases();
    }

}
