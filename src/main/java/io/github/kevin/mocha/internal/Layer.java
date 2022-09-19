package io.github.kevin.mocha.internal;

public class Layer {

    private Neuron[] neurons;

    /**
     * Create a layer
     * 
     * @param size              The number of neurons in this layer
     * @param previousLayerSize The size of the previous layer to determine how many
     *                          connections to make
     */
    public Layer(int size, int previousLayerSize) {
        neurons = new Neuron[size];
        for (int i = 0; i < neurons.length; i++) {
            neurons[i] = new Neuron(0.0f, previousLayerSize);
        }
    }

    /**
     * Get the neuron at an index of this layer
     * 
     * @param id The index of the neuron
     * @return the Neuron object
     */
    public Neuron get(int id) {
        // sizes must be length 3 or greater (1 hidden layer)
        if (id < 0 || id >= neurons.length) {
            throw new IndexOutOfBoundsException();
        }
        return neurons[id];
    }

}
