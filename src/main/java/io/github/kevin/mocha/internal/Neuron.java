package io.github.kevin.mocha.internal;

public class Neuron {

    // the value of this neuron
    private float value;
    
    private float bias;

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
        
        bias = 0.0f;

        // connection arrays will be null if there is no incoming (input layer) or no
        // outgoing (output layer)
        if (connectionsIn > 0) {
            in = new Connection[connectionsIn];
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

    /**
     * 
     * @return The current value of this neuron
     */
    public float getValue() {
        return value;
    }

    /**
     * Set a new value for this neuron
     * 
     * @param value The new value
     */
    public void setValue(float value) {
        this.value = value;
    }

    /**
     * Get the incoming connection at an index
     * 
     * @param index The index of the connection
     * @return The connection object at the index
     */
    public Connection getIn(int index) {
        // index must be in bounds
        if (index < 0 || index >= in.length) {
            throw new IndexOutOfBoundsException();
        }

        return in[index];
    }
    
    /**
     * Set a incoming connection object
     * 
     * @param index The index of the connection to set
     * @param con   The Connection object to set it to
     */
    public void setIn(int index, Connection con) {
        // index must be in bounds
        if (index < 0 || index >= in.length) {
            throw new IndexOutOfBoundsException();
        }

        in[index] = con;
    }

    /**
     * Get the outgoing connection at an index
     * 
     * @param index The index of the connection
     * @return The connection object at the index
     */
    public Connection getOut(int index) {
        // index must be in bounds
        if (index < 0 || index >= out.length) {
            throw new IndexOutOfBoundsException();
        }

        return out[index];
    }
    
    /**
     * Set a outgoing connection object
     * 
     * @param index The index of the connection to set
     * @param con   The Connection object to set it to
     */
    public void setOut(int index, Connection con) {
        // index must be in bounds
        if (index < 0 || index >= out.length) {
            throw new IndexOutOfBoundsException();
        }

        out[index] = con;
    }

    public String toString() {
        return "IN " + (in == null ? 0 : in.length) + " OUT " + (out == null ? 0 : out.length);
    }

    /**
     * Calculate the activation of this neuron
     */
    public void calcActivation() {
        float a = 0.0f;
        for (Connection c : in) {
            a += c.getWeight() * c.getFrom().getValue();
        }
        value = a + bias;
    }

}
