package airport;

import edu.princeton.cs.algs4.Out;

import java.util.ArrayList;

public class FlightPath {

        private int id;
        private ArrayList<Airport> airports = new ArrayList<>();

    public FlightPath(int id, ArrayList<Airport> airports) {
        this.id = id;
        this.airports = airports;
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

    public void addAirport(Airport a) {
            for (Airport airport : this.airports) {
                if (airport.equals(a)) {
                    return;
                }
            }
            this.airports.add(a);
        }

        public Airport removeAiport(Airport a) {
            for (Airport airport : this.airports) {
                if (airport.equals(a)) {
                    this.airports.remove(a);
                    return airport;
                }
            }
            return null;
        }

        public Airport removeAiport(String id) {
            for (Airport airport : this.airports) {
                if (airport.getCode().equals(id)) {
                    this.airports.remove(airport);
                    return airport;
                }
            }
            return null;
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
