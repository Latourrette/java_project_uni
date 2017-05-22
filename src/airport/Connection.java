
package airport;

import edu.princeton.cs.algs4.*;


/**
 *
 * @author andredsnogueira
 */
public class Connection extends DirectedEdge {


    private float windVelocity;
    private float airTunnel;


    public Connection(int v, int w, double weight, float windVelocity, float airTunnel) {
        super(v, w, weight);
        this.airTunnel = airTunnel;
        this.windVelocity = windVelocity;

    }

    public float getWindVelocity() {
        return windVelocity;
    }

    public void setWindVelocity(float windVelocity) {
        this.windVelocity = windVelocity;
    }

    public float getAirTunnel() {
        return airTunnel;
    }

    public void setAirTunnel(float airTunnel) {
        this.airTunnel = airTunnel;
    }

    public double flightDuration(Airplane a){
        return a.getFlightDuration(super.weight());
    }

    public double flightCost(Airplane a){
        return a.getFlightCost(this.airTunnel, this.windVelocity, super.weight());
    }


}