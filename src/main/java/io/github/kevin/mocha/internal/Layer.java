package io.github.kevin.mocha.internal;

public class Layer {
    
    private Neuron[] neurons;
    
    /**
     * Create a layer
     * @param size The number of neurons in this layer
     */
    public Layer(int size) {
        neurons = new Neuron[size];
    }

}
