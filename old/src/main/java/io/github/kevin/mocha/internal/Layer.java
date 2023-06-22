package io.github.kevin.mocha.internal;

/**
 * This class represents a layer of neurons.
 * 
 * @author kevin
 */
public class Layer {

    private Neuron[] neurons;

    /**
     * Create a layer.
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
     * Get the neuron at an index of this layer.
     * 
     * @param index The index of the neuron
     * @return the Neuron object
     */
    public Neuron get(int index) {
        // index must be in bounds
        if (index < 0 || index >= neurons.length) {
            throw new IndexOutOfBoundsException();
        }
        return neurons[index];
    }

    /**
     * 
     * @return The number of neurons in this layer
     */
    public int getSize() {
        return neurons.length;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LAYER:\n");
        sb.append("SIZE: " + neurons.length + "\n");
        for (Neuron n : neurons) {
            sb.append("\t" + n + "\n");
        }
        sb.append("------");
        return sb.toString();
    }

}
