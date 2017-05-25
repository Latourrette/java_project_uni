
package airport;

import edu.princeton.cs.algs4.*;


public class Connection extends DirectedEdge {


    private double windVelocity;
    private double airTunnel;


    public Connection(int v, int w, double weight, double windVelocity, double airTunnel) {
        super(v, w, weight);
        this.airTunnel = airTunnel;
        this.windVelocity = windVelocity;

    }

    public double getWindVelocity() {
        return windVelocity;
    }

    public void setWindVelocity(double windVelocity) {
        this.windVelocity = windVelocity;
    }

    public double getAirTunnel() {
        return airTunnel;
    }

    public void setAirTunnel(double airTunnel) {
        this.airTunnel = airTunnel;
    }

    public double flightDuration(Airplane a){
        return a.getFlightDuration(super.weight());
    }

    public double flightCost(Airplane a){
        return a.getFlightCost(this.airTunnel, this.windVelocity, super.weight());
    }


}