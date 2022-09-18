package io.github.kevin.mocha.internal;

public class Connection {

    private Neuron from;
    private Neuron to;
    private float weight;

    /**
     * Generate an empty connection
     * 
     * @param from
     * @param to
     */
    public Connection(Neuron from, Neuron to) {
        this.from = from;
        this.to = to;
        weight = 0;
    }

}
