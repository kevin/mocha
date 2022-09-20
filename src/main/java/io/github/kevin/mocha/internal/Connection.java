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
    
    /**
     * Set the Neuron this connection comes from
     * 
     * @param from The neuron to come from
     */
    public void setFrom(Neuron from) {
        this.from = from;
    }

    /**
     * Set the Neuron this connection goes to
     * 
     * @param to The neuron to point to
     */
    public void setTo(Neuron to) {
        this.to = to;
    }

}
