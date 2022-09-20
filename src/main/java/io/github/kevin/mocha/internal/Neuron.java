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
    
    /**
     * Get the incoming connection at an index
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
     * Get the outgoing connection at an index
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
    
    public String toString() {
        return "IN " + (in == null ? 0 : in.length) + " OUT " + (out == null ? 0 : out.length);
    }

}
