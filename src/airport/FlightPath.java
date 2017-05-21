package airport;

import edu.princeton.cs.algs4.Out;

import java.util.ArrayList;

public class FlightPath {

    private int id;
    private ArrayList<Airport> airports = new ArrayList<>();

    public FlightPath(int id) {
        this.id = id;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Airport> getAirports() {
        return airports;
    }

    public void setAirports(ArrayList<Airport> airports) {
        this.airports = airports;
    }


    @Override
    public String toString() {
        return "FlightPath{" +
                "id=" + id +
                ", airports=" + airports +
                '}';
    }

    public void saveFlightPath(String path) {
        Out o = new Out(path);
        o.println(this.id + ";" + this.airports.size());
        for (Airport a : this.airports) {
            o.println(a.toString());
        }
    }

}
