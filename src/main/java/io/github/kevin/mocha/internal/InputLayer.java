package io.github.kevin.mocha.internal;

public class InputLayer extends AbstractLayer {

    /**
     * Create a layer
     * @param size The number of neurons in this layer
     */
    public InputLayer(int size) {
        neurons = new InputNeuron[size];
    }

}
