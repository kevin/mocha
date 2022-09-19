package io.github.kevin.mocha.internal;

public class Neuron {

    // the value of this neuron
    private float value;

    // the incoming and outgoing connections
    private Connection[] in;
    private Connection[] out;

    /**
     * 
     * @param value         The initial value of this neuron
     * @param connectionsIn The number of incoming connections to this neuron
     */
    public Neuron(float value, int connectionsIn) {
        this.value = value;
        
        // connection arrays will be null if there is no incoming (input layer) or no outgoing (output layer)
        if (connectionsIn > 0) {
            in = new Connection[0];
        }
    }

    /**
     * Set the number of outgoing connections. Separate from constructor because the
     * outgoing size isn't known until the next layer is made.
     * 
     * @param connectionsOut The number of outgoing connections
     */
    public void setOutgoingConnections(int connectionsOut) {
        out = new Connection[connectionsOut];
    }

}
