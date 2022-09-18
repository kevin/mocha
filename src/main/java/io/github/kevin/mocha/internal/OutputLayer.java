package io.github.kevin.mocha.internal;

public class OutputLayer extends AbstractLayer {

    /**
     * Create a layer
     * @param size The number of neurons in this layer
     */
    public OutputLayer(int size) {
        neurons = new OutputNeuron[size];
    }

}
