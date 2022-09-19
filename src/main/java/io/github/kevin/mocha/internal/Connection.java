package io.github.kevin.mocha.internal;

public class Connection {

    private Neuron from;
    private Neuron to;
    private float weight;

    /**
     * Create an empty connection
     * 
     * @param from
     * @param to
     */
    public Connection(Neuron from, Neuron to) {
        this.from = from;
        this.to = to;
        weight = 0;
    }

    /**
     * Set the value of this connection's weight
     * 
     * @param f The new weight
     */
    public void setWeight(float f) {
        this.weight = f;
    }

}
