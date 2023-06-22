package io.github.kevin.mocha.internal;

/**
 * This class represents one connection between two neurons.
 * 
 * @author kevin
 */
public class Connection {

    private Neuron from;
    private Neuron to;
    private float weight;

    /**
     * Create an empty connection.
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
     * @return The current weight of this connection
     */
    public float getWeight() {
        return weight;
    }

    /**
     * Set the value of this connection's weight.
     * 
     * @param f The new weight
     */
    public void setWeight(float f) {
        this.weight = f;
    }

    /**
     * @return The neuron this connection comes from.
     */
    public Neuron getFrom() {
        return from;
    }

    /**
     * Set the Neuron this connection comes from.
     * 
     * @param from The neuron to come from
     */
    public void setFrom(Neuron from) {
        this.from = from;
    }

    /**
     * @return the Neuron this connection goes to.
     */
    public Neuron getTo() {
        return to;
    }

    /**
     * Set the Neuron this connection goes to.
     * 
     * @param to The neuron to point to
     */
    public void setTo(Neuron to) {
        this.to = to;
    }

}
