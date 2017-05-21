/*
 *
 * Projeto (projeto_lp2_1516) - Linguagens de Programaçao 2
 * 
 * edu.ufp.inf.lp2.project.gui
 * AppMainJFrame.java
 *
 * 2015/2016 (c) Universidade Fernando Pessoa
 *
 *//*

package airport;

import edu.princeton.cs.algs4.*;

public class Connection extends DirectedEdge {


    private double windVelocityWeight;
    private double airTunnelWeight;

    public Connection(int l1, int l2, double distance, double windVelocity, double airTunnel) {
        super(l1, l2, distance);
        this.windVelocityWeight = windVelocity;
        this.airTunnelWeight = airTunnel;
    }

    public double getWindVelocityWeight() {
        return windVelocityWeight;
    }

    public void setWindVelocityWeight(double windVelocityWeight) {
        this.windVelocityWeight = windVelocityWeight;
    }

    public double getAirTunnelWeight() {
        return airTunnelWeight;
    }

    public void setAirTunnelWeight(double airTunnelWeight) {
        this.airTunnelWeight = airTunnelWeight;
    }

    @Override
    public String toString() {
        return super.from() + "->" + super.to() +
                " - {Distance: " + super.weight() + " , Wind Velocity: " + this.windVelocityWeight
                + " , Air Tunnel: " + this.airTunnelWeight + "}";
    }

    @Override
    public double weight() {
        switch (Network.selectedCost) {
            case Network.Distance:
                return super.weight();
            case Network.WindVelocity:
                return this.windVelocityWeight;
            case Network.AirTunnel:
                return this.airTunnelWeight;
            default:
                return super.weight();
        }
    }
}
*/
