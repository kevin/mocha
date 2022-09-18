package io.github.kevin.mocha.internal;

public class HiddenLayer extends AbstractLayer {

    /**
     * Create a layer
     * @param size The number of neurons in this layer
     */
    public HiddenLayer(int size) {
        neurons = new HiddenNeuron[size];
    }

}
