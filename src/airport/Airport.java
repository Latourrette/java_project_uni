package airport;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;

import java.util.Scanner;

public class Airport {
    private String name; //key
    private String lat;
    private String lon;
    private RedBlackBST<String, Flights> airportFlightsST = new RedBlackBST<>();

    public static void loadFromFileAirport(RedBlackBST<String, Airport> airportST, String path) {
        In in = new In(path);
        try {
            while (!in.isEmpty()) {
                String[] text = in.readLine().split(";");
                String name = text[0];
                String lat = text[1];
                String lon = text[2];
                Airport aux = new Airport(name, lat, lon);
                airportST.put(name, aux);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void loadFromFileAirportFlight(RedBlackBST<String, Airport> airportST, String path) {
        In in = new In(path);
        try {
            while (!in.isEmpty()) {
                String[] text = in.readLine().split(";");
                String aux1 = text[0];
                String aux2 = text[1];
                String aux3 = text[2];
                String aux4 = text[3];
                String aux5 = text[4];
                Flights auxObj = new Flights(aux2, aux3, aux4, Integer.parseInt(aux5));
                airportST.get(aux1).getAirportFlightsST().put(aux2, auxObj);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static boolean removeAirport(RedBlackBST<String, Airport> airportRedBlackBST) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Choose airport to delete: ");
        String aux = scan.nextLine();
        for (String key : airportRedBlackBST.get(aux).getAirportFlightsST().keys()) {
            if (airportRedBlackBST.get(aux).getAirportFlightsST().get(key).getLocalOfArrival().equals(aux) ||
                    airportRedBlackBST.get(aux).getAirportFlightsST().get(key).getLocalOfArrival().equals(aux)) {
                airportRedBlackBST.get(aux).getAirportFlightsST().delete(key);
            }
        }
        airportRedBlackBST.delete(aux);

        for (String air : airportRedBlackBST.keys()) {
            if (air.equals(aux)) {
                return false;
            }
        }
        return true;
    }

    public static void saveToFileAirport(RedBlackBST<String, Airport> airportRedBlackBST, String path) {
        Out o = new Out(path);
        for (String aux : airportRedBlackBST.keys()) {
            Airport air = airportRedBlackBST.get(aux);
            o.println(air.getName() + ";" + air.getLat() + ";" + air.getLon());
        }
    }

    public static void addAirport(RedBlackBST<String, Airport> airportST) {
        Scanner scan = new Scanner(System.in);
        try {
            System.out.println("Airport name: ");
            String aux = scan.nextLine();
            System.out.println("Lat: ");
            String aux2 = scan.nextLine();
            System.out.println("Lon: ");
            String aux3 = scan.nextLine();
            Airport auxObj = new Airport(aux, aux2, aux3);
            airportST.put(aux, auxObj);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public RedBlackBST<String, Flights> getAirportFlightsST() {
        return airportFlightsST;
    }

    public void setAirportFlightsST(RedBlackBST<String, Flights> airportFlightsST) {
        this.airportFlightsST = airportFlightsST;
    }

    public Airport(String name, String lat, String lon) {
        this.name = name;
        this.lat = lat;
        this.lon = lon;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "name='" + name + '\'' +
                ", lat='" + lat + '\'' +
                ", lon='" + lon + '\'' +
                ", airportFlightsST=" + airportFlightsST +
                '}';
    }

}
