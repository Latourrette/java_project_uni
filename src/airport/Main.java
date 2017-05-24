package airport;


import edu.princeton.cs.algs4.DirectedEdge;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;

/**
 * Main
 */
public class Main {

    public static RedBlackBST<String, Airport> airportST = new RedBlackBST<>();
    public static SeparateChainingHashST<String, Airplane> airplaneST = new SeparateChainingHashST<>();
    public static RedBlackBST<Date, Flight> flightST = new RedBlackBST<>();

    public static SymbolDigraph sd = new SymbolDigraph(".//data//graph.txt", ";");

    public static DesignMap map = new DesignMap(100, 100);


    public static void main(String[] args) throws ParseException {

        DateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm");

        loadFromFileAirport(airportST, "./data/airports.txt");
        loadFromFileAirplane(airportST, airplaneST, "./data/airplanes.txt");
        loadFromFileFlight(airportST, airplaneST, flightST, "./data/flights.txt");

        /**
         * Parte 1
         */

        //Airport a = new Airport("FCP", "Futebol Club Porto", "Porto", "Portugal","Europe", 10.0f, 41.248055, -8.681389);

        //Airplane ap = new Airplane("40", "Toshiba", "Grande Maquina", "Toshiba Airlines",958, 12000, 15190, "FCP", 120, 126206);

        //Flight f = new Flight(format.parse("15-01-1993 15:15"), "40", "FCP", "OPO",70, 20, 15000, -300);

        //insertAirport(airportST, a);
        //insertAirplane(airportST, airplaneST, ap);
        //insertFlight(airportST, airplaneST, flightST, f);

        //removeFlight(airportST,airplaneST,flightST,f);
        //removeAirplane(airportST,airplaneST,ap);
        //removeAirport(airportST, a);

        //printAllAirports(airportST);
        //printAirplanesByAirport(airportST);
        //printAirport(airportST, "FCP");
        //printCountryAirports(airportST, "Portugal");
        //printFlightFromAirport(airportST, "OPO");
        //printFlightToAirport(airportST, "CDG");
        //mostTrafficAirport(airportST);
        //airportWithMostPassengers(airportST);


        //printAirplane(airplaneST, "11");
        //printFlightByAirplane(airplaneST, "2");

        //flightsByTimePeriod(flightST, "03-11-2013 03:40", "03-12-2020 03:40");
        //flightWithMostPassengers(flightST);

        //saveToFileAirport(airportST, ".//data//airports.txt");
        //saveToFileAirplane(airplaneST, ".//data//airplanes.txt");
        //saveToFileFlight(flightST, ".//data//flights.txt");
        //editAfterFlight(airportST, airplaneST, flightST);

        /**
         * Parte 2
         */

        //System.out.println(shortestPathClient(sd, "OPO", "LAD", map));

        //shortestPath(sd, "OPO", "LAD", map, airportST);
        //economicPath(sd, "OPO", "LAD", map, returnFlightAirplane("OPO", "LAD"));
        //fastestPath(sd, "OPO", "BOG", map, returnFlightAirplane("OPO", "BOG"));


    }

    /**
     * Loads from airports.txt to airportST.
     *
     * @param airportST Symbol Table for airports.
     * @param path      File path for airports.txt.
     */
    public static void loadFromFileAirport(RedBlackBST<String, Airport> airportST, String path) {
        In in = new In(path);
        try {
            while (!in.isEmpty()) {
                String[] text = in.readLine().split(";");
                String code = text[1];
                String name = text[0];
                String city = text[2];
                String country = text[3];
                String continent = text[4];
                Float classification = Float.parseFloat(text[5]);
                Double xAxis = Double.parseDouble(text[6]);
                Double yAxis = Double.parseDouble(text[7]);


                Airport a = new Airport(code, name, city, country, continent, classification, xAxis, yAxis);
                airportST.put(code, a);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Loads from airplanes.txt to airplaneST and other ST's involving airports.
     *
     * @param airportST  Symbol Table for airports.
     * @param airplaneST Symbol Table for airplanes.
     * @param path       File path for airplanes.txt.
     */
    public static void loadFromFileAirplane(RedBlackBST<String, Airport> airportST,
                                            SeparateChainingHashST<String, Airplane> airplaneST, String path) {
        In in = new In(path);
        try {
            while (!in.isEmpty()) {
                String[] text = in.readLine().split(";");
                String id = text[0];
                String model = text[1];
                String name = text[2];
                String airline = text[3];
                Integer cruiseSpeed = Integer.parseInt(text[4]);
                Integer cruiseAltitude = Integer.parseInt(text[5]);
                Integer maxDistance = Integer.parseInt(text[6]);
                String currentAirport = text[7];
                Integer maxCapacity = Integer.parseInt(text[8]);
                Integer fuelCapacity = Integer.parseInt(text[9]);

                Airplane a = new Airplane(id, model, name, airline, cruiseSpeed, cruiseAltitude, maxDistance,
                        currentAirport, maxCapacity, fuelCapacity);

                airportST.get(currentAirport).getAirplaneST().put(id, a);
                airplaneST.put(id, a);

            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Loads from flights.txt to flightST and other ST's involving flights.
     *
     * @param airportST  Symbol Table for airports.
     * @param airplaneST Symbol Table for airplanes.
     * @param flightST   Symbol Table for flights.
     * @param path       File path for flights.txt.
     */
    public static void loadFromFileFlight(RedBlackBST<String, Airport> airportST,
                                          SeparateChainingHashST<String, Airplane> airplaneST,
                                          RedBlackBST<Date, Flight> flightST, String path) {

        In in = new In(path);
        try {

            while (!in.isEmpty()) {
                String[] text = in.readLine().split(";");
                DateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm");
                Date date = format.parse(text[0]);
                String airplaneID = text[1];
                String origin = text[2];
                String destination = text[3];
                Integer passengers = Integer.parseInt(text[4]);
                Integer distance = Integer.parseInt(text[5]);
                Integer flightAltitude = Integer.parseInt(text[6]);

                Flight f = new Flight(date, airplaneID, origin, destination, passengers, distance, flightAltitude);

                airportST.get(origin).getFlightOriST().put(date, f);
                airportST.get(destination).getFlightDestST().put(date, f);
                airplaneST.get(airplaneID).getFlightsAirplane().put(date, f);
                flightST.put(date, f);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Save from airportST to airports.txt.
     *
     * @param airportST Symbol Table for airports.
     * @param path      File path for airports.txt.
     */
    public static void saveToFileAirport(RedBlackBST<String, Airport> airportST, String path) {
        Out o = new Out(path);
        for (String i : airportST.inOrder()) {
            o.println(airportST.get(i).getName() + ";" +
                    airportST.get(i).getCode() + ";" +
                    airportST.get(i).getCity() + ";" +
                    airportST.get(i).getCountry() + ";" +
                    airportST.get(i).getContinent() + ";" +
                    airportST.get(i).getRating() + ";" +
                    airportST.get(i).getxAxis() + ";" +
                    airportST.get(i).getyAxis() + ";");
        }
    }

    /**
     * Save from airplaneST to airplane.txt.
     *
     * @param airplaneST Symbol Table for airplanes.
     * @param path       File path for airplane.txt.
     */
    public static void saveToFileAirplane(SeparateChainingHashST<String, Airplane> airplaneST, String path) {
        Out o = new Out(path);
        for (String i : airplaneST.keys()) {
            o.println(airplaneST.get(i).getId() + ";" +
                    airplaneST.get(i).getModel() + ";" +
                    airplaneST.get(i).getName() + ";" +
                    airplaneST.get(i).getAirline() + ";" +
                    airplaneST.get(i).getCruiseSpeed() + ";" +
                    airplaneST.get(i).getCruiseAltitude() + ";" +
                    airplaneST.get(i).getMaxDistance() + ";" +
                    airplaneST.get(i).getCurrentAirport() + ";" +
                    airplaneST.get(i).getMaxCapacity() + ";" +
                    airplaneST.get(i).getFuelCapacity() + ";");
        }

    }

    /**
     * Save from flightST to flights.txt.
     *
     * @param flightST Symbol Table for flights.
     * @param path     File path for flights.txt.
     */
    public static void saveToFileFlight(RedBlackBST<Date, Flight> flightST, String path) {
        Out o = new Out(path);
        DateFormat toString = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        String date = "";
        for (Date i : flightST.inOrder()) {
            date = toString.format(flightST.get(i).getDate());
            o.println(date + ";" +
                    flightST.get(i).getAirplaneID() + ";" +
                    flightST.get(i).getOrigin() + ";" +
                    flightST.get(i).getDestination() + ";" +
                    flightST.get(i).getPassengers() + ";" +
                    flightST.get(i).getDistance() + ";" +
                    flightST.get(i).getFlightAltitude() + ";");
        }
    }

    /**
     * Prints all the airports in the ST.
     *
     * @param airportST Symbol Table for airports.
     */
    public static void printAllAirports(RedBlackBST<String, Airport> airportST) {

        System.out.println("Airports list:");
        System.out.println("");

        for (String i : airportST.keys()) {
            System.out.println("\t" + airportST.get(i).toString());
        }
    }

    /**
     * Prints a specific airport.
     *
     * @param airportST Symbol Table for airports.
     * @param code      The id key of the airport.
     */
    public static void printAirport(RedBlackBST<String, Airport> airportST, String code) {

        System.out.println("");
        System.out.println("Information of Airport: " + airportST.get(code).getName());

        System.out.println("\t" + airportST.get(code).toString());
    }

    /**
     * Prints all airplanes by airports.
     *
     * @param airportST Symbol Table for airports.
     */
    public static void printAirplanesByAirport(RedBlackBST<String, Airport> airportST) {

        System.out.println("");
        for (String i : airportST.inOrder()) {
            if (!airportST.get(i).getAirplaneST().isEmpty()) {
                System.out.println("Airplanes in " + airportST.get(i).getCode());
                for (String j : airportST.get(i).getAirplaneST().keys()) {
                    System.out.println("\t" + airportST.get(i).getAirplaneST().get(j).toString());
                }
                System.out.println("");
            }
        }
    }

    /**
     * Prints a specific airplane.
     *
     * @param airplaneST Symbol Table for airplanes.
     * @param id         The id key of the airplane.
     */
    public static void printAirplane(SeparateChainingHashST<String, Airplane> airplaneST, String id) {

        System.out.println("");
        System.out.println("\t" + airplaneST.get(id).toString());
    }

    /**
     * Prints airports of a specific airport.
     *
     * @param airportST Symbol Table for airports.
     * @param country   Country name.
     */
    public static void printCountryAirports(RedBlackBST<String, Airport> airportST, String country) {

        System.out.println("Airports of " + country + ":");
        for (String i : airportST.keys()) {
            if (airportST.get(i).getCountry().equals(country)) {
                System.out.println("\t" + airportST.get(i).toString());

            }
        }
    }

    /**
     * Prints flights from a specific airport.
     *
     * @param airportST Symbol Table for airports.
     * @param code      Code name of an airport.
     */
    public static void printFlightFromAirport(RedBlackBST<String, Airport> airportST, String code) {

        System.out.println("Flights from " + airportST.get(code).getName());
        if (!airportST.get(code).getFlightOriST().isEmpty()) {
            for (Date i : airportST.get(code).getFlightOriST().keys()) {
                System.out.println("\t" + airportST.get(code).getFlightOriST().get(i).toString());
                System.out.println("");
            }
        } else System.out.println("That airport doesn't have flights.");
    }

    /**
     * Prints flights to a specific airport.
     *
     * @param airportST Symbol Table for airports.
     * @param code      Code name of an airport.
     */
    public static void printFlightToAirport(RedBlackBST<String, Airport> airportST, String code) {
        System.out.println("Flights to " + airportST.get(code).getName());
        if (!airportST.get(code).getFlightDestST().isEmpty()) {
            for (Date i : airportST.get(code).getFlightDestST().keys()) {
                System.out.println("\t" + airportST.get(code).getFlightDestST().get(i).toString());
                System.out.println("");
            }
        } else System.out.println("That airport doesn't have flights.");
    }

    /**
     * Prints flights of a specific airplane.
     *
     * @param airplaneST Symbol Table for airplanes.
     * @param code       Id code of a specific airplane.
     */
    public static void printFlightByAirplane(SeparateChainingHashST<String, Airplane> airplaneST, String code) {

        System.out.println("Flights of " + airplaneST.get(code).getName());
        try {
            if (!airplaneST.get(code).getFlightsAirplane().isEmpty()) {
                for (Date i : airplaneST.get(code).getFlightsAirplane().inOrder()) {
                    System.out.println("\tDate: " + airplaneST.get(code).getFlightsAirplane().get(i).toString());
                    System.out.println("");
                }
            } else throw new IllegalAirplaneException("This Airplane doesn't have any flights!");
        } catch (IllegalAirplaneException e) {
            e.printStackTrace();
        }
    }

    /**
     * Calculates the airport with more flights.
     *
     * @param airportST Symbol Table for airports.
     */
    public static void mostTrafficAirport(RedBlackBST<String, Airport> airportST) {
        int maxValue = 0;
        ArrayList<String> airportsName = new ArrayList<>();
        for (String i : airportST.keys()) {
            if (maxValue < (airportST.get(i).getFlightOriST().size() + airportST.get(i).getFlightDestST().size())) {
                maxValue = (airportST.get(i).getFlightOriST().size() + airportST.get(i).getFlightDestST().size());
            }
        }
        for (String i : airportST.keys()) {
            if (maxValue == (airportST.get(i).getFlightOriST().size() + airportST.get(i).getFlightDestST().size())) {
                if (!airportsName.contains(i)) {
                    airportsName.add(i);
                }
            }
        }
        if (airportsName.size() > 1) {
            System.out.println("The airports with most traffic are: ");
            System.out.println("");
            for (String i : airportsName) {
                System.out.println("\t" + airportST.get(i).toString());
                System.out.println("");
            }
            System.out.println("with a total of " + maxValue + " flights.");
        } else {
            System.out.println("The airport with most traffic is: ");
            for (String i : airportsName) {
                System.out.println("\t" + airportST.get(i).toString());
                System.out.println("\twith a total of " + maxValue + " flights.");
            }
        }
    }

    /**
     * Prints flights between two dates.
     *
     * @param flightST Symbol Table for flights.
     * @param date1    First Date.
     * @param date2    Last Date.
     * @throws ParseException Prints error whith the date parsing.
     */
    public static void flightsByTimePeriod(RedBlackBST<Date, Flight> flightST, String date1, String date2)
            throws ParseException {

        DateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        Date start = format.parse(date1);
        Date end = format.parse(date2);
        System.out.println("Flights between " + start + " and " + end + ":");
        for (Date i : flightST.keys(start, end)) {
            System.out.println("\t" + flightST.get(i).toString());
            System.out.println("");
        }

    }

    /**
     * Calculates the flights with most passengers.
     *
     * @param flightST Symbol Table for flights.
     */
    public static void flightWithMostPassengers(RedBlackBST<Date, Flight> flightST) {

        System.out.println("");
        int maxValue = 0;
        ArrayList<Date> flightAux = new ArrayList<>();
        for (Date i : flightST.inOrder()) {
            if (flightST.get(i).getPassengers() > maxValue) {
                maxValue = flightST.get(i).getPassengers();
            }
        }

        for (Date i : flightST.inOrder())

        {
            if (flightST.get(i).getPassengers().equals(maxValue)) {
                if (!flightAux.contains(i)) {
                    flightAux.add(i);
                }
            }
        }

        if (flightAux.size() > 1)

        {
            System.out.println("The flights with most passengers are: ");
            System.out.println("");
            for (Date j : flightAux) {
                System.out.println("\t" + flightST.get(j).toString());
                System.out.println("");
            }
            System.out.println("\twith a total of " + maxValue + " passengers.");
        } else

        {
            System.out.println("The flight with most passengers is: ");
            for (Date j : flightAux) {
                System.out.println("\t" + flightST.get(j).toString());
            }
            System.out.println("\twith a total of " + maxValue + " passengers.");
        }
    }

    /**
     * Calculates the airports withe most passengers.
     *
     * @param airportST Symbol Table for airports.
     */
    public static void airportWithMostPassengers(RedBlackBST<String, Airport> airportST) {

        int maxValue = 0;
        int maxAirport = 0;
        ArrayList<String> airportsName = new ArrayList<>();

        for (String i : airportST.inOrder()) {
            if (!airportST.get(i).getFlightOriST().isEmpty()) {
                for (Date j : airportST.get(i).getFlightOriST().inOrder()) {
                    maxAirport = maxAirport + airportST.get(i).getFlightOriST().get(j).getPassengers();
                }
            }
            if (!airportST.get(i).getFlightDestST().isEmpty()) {
                for (Date j : airportST.get(i).getFlightDestST().inOrder()) {
                    maxAirport = maxAirport + airportST.get(i).getFlightDestST().get(j).getPassengers();
                }
            }
            if (maxAirport > maxValue) {
                maxValue = maxAirport;
            }
            maxAirport = 0;
        }
        for (String i : airportST.inOrder()) {
            if (!airportST.get(i).getFlightOriST().isEmpty()) {
                for (Date j : airportST.get(i).getFlightOriST().inOrder()) {
                    maxAirport = maxAirport + airportST.get(i).getFlightOriST().get(j).getPassengers();
                }
            }
            if (!airportST.get(i).getFlightDestST().isEmpty()) {
                for (Date j : airportST.get(i).getFlightDestST().inOrder()) {
                    maxAirport = maxAirport + airportST.get(i).getFlightDestST().get(j).getPassengers();
                }
            }
            if (maxAirport == maxValue) {
                if (!airportsName.contains(i)) {
                    airportsName.add(i);
                }
            }
            maxAirport = 0;
        }
        if (airportsName.size() > 1) {
            System.out.println("The airports with most passenger are: ");
            for (String i : airportsName) {
                System.out.println("\t" + airportST.get(i).toString());
                System.out.println("");
            }
            System.out.println("\twith a total of " + maxValue + " passengers.");
        } else {
            System.out.println("The airport with most passengers is: ");
            for (String i : airportsName) {
                System.out.println("\t" + airportST.get(i).toString());
            }
            System.out.println("\twith a total of " + maxValue + " passengers.");
        }

    }

    /**
     * Inserts a new airport into the ST.
     *
     * @param airportST Symbol Table for airports.
     * @param a         Airport to be added.
     */
    public static void insertAirport(RedBlackBST<String, Airport> airportST, Airport a) {
        try {
            if (!airportST.contains(a.getCode())) {
                airportST.put(a.getCode(), a);
                System.out.println("Airport " + a.getName() + " inserted.");
            } else throw new
                    IllegalAirportException("This airport already exists!");
        } catch (IllegalAirportException e) {
            e.printStackTrace();
        }
    }


    /**
     * Inserts a new airplane into the ST's.
     *
     * @param airportST  Symbol Table for airports.
     * @param airplaneST Symbol Table for airplanes.
     * @param a          Airplane to be added.
     */
    public static void insertAirplane(RedBlackBST<String, Airport> airportST,
                                      SeparateChainingHashST<String, Airplane> airplaneST, Airplane a) {
        try {
            if (airportST.contains(a.getCurrentAirport())) {
                try {
                    if (!airplaneST.contains(a.getId())) {
                        airportST.get(a.getCurrentAirport()).getAirplaneST().put(a.getId(), a);
                        airplaneST.put(a.getId(), a);
                        System.out.println("Airplane " + a.getName() + " inserted.");
                    } else throw new
                            IllegalAirplaneException("This airplane already exists!");
                } catch (IllegalAirplaneException e) {
                    e.printStackTrace();
                }
            } else throw new
                    IllegalAirportException("This airport doesn't exists!");
        } catch (IllegalAirportException e) {
            e.printStackTrace();
        }


    }


    /**
     * Inserts a new flight into the ST's.
     *
     * @param airportST  Symbol Table for airports.
     * @param airplaneST Symbol Table for airplanes.
     * @param flightST   Symbol Table for flights.
     * @param f          Flight to be added.
     */

    public static void insertFlight(RedBlackBST<String, Airport> airportST,
                                    SeparateChainingHashST<String, Airplane> airplaneST,
                                    RedBlackBST<Date, Flight> flightST, Flight f) {

        try {
            if (airplaneST.contains(f.getAirplaneID())) {
                try {
                    if (airportST.contains(f.getOrigin()) && airportST.contains(f.getDestination())) {
                        try {
                            if (!flightST.contains(f.getDate())) {
                                airplaneST.get(f.getAirplaneID()).getFlightsAirplane().put(f.getDate(), f);
                                airportST.get(f.getOrigin()).getFlightOriST().put(f.getDate(), f);
                                airportST.get(f.getDestination()).getFlightDestST().put(f.getDate(), f);
                                flightST.put(f.getDate(), f);
                            } else throw new
                                    IllegalFlightException("This flight already exists!");
                        } catch (IllegalFlightException e) {
                            e.printStackTrace();
                        }
                    } else throw new
                            IllegalAirportException("This airport doesn't exists!");
                } catch (IllegalAirportException e) {
                    e.printStackTrace();
                }
            } else throw new
                    IllegalFlightException("This airport doesn't exist!");
        } catch (IllegalFlightException e) {
            e.printStackTrace();
        }


    }

    /**
     * Removes an airport from the ST.
     *
     * @param airportST Symbol Table for airports.
     * @param a         Airport to be removed.
     */
    public static void removeAirport(RedBlackBST<String, Airport> airportST, Airport a) {

        try {
            if (airportST.contains(a.getCode())) {
                airportST.delete(a.getCode());
                System.out.println("Airport " + a.getName() + " removed.");
            } else throw new
                    IllegalAirportException("This airport doesn't exists!");
        } catch (IllegalAirportException e) {
            e.printStackTrace();
        }
    }

    /**
     * Removes an airplane from the ST's.
     *
     * @param airportST  Symbol Table for airports.
     * @param airplaneST Symbol Table for airplanes.
     * @param a          Airplane to be removed.
     */
    public static void removeAirplane(RedBlackBST<String, Airport> airportST,
                                      SeparateChainingHashST<String, Airplane> airplaneST, Airplane a) {
        try {
            if (airplaneST.contains(a.getId())) {
                airplaneST.delete(a.getId());
                airportST.get(a.getCurrentAirport()).getAirplaneST().delete(a.getId());
                System.out.println("Airplane " + a.getName() + " removed.");
            } else throw new
                    IllegalAirplaneException("This airplane doesn't exist");
        } catch (IllegalAirplaneException e) {
            e.printStackTrace();
        }
    }

    /**
     * Removes a flight from the ST's.
     *
     * @param airportST  Symbol Table for airports.
     * @param airplaneST Symbol Table for airplanes.
     * @param flightST   Symbol Table for flights.
     * @param f          Flight to be removed.
     */
    public static void removeFlight(RedBlackBST<String, Airport> airportST,
                                    SeparateChainingHashST<String, Airplane> airplaneST,
                                    RedBlackBST<Date, Flight> flightST, Flight f) {

        try {
            if (flightST.contains(f.getDate())) {
                flightST.delete(f.getDate());
                airplaneST.get(f.getAirplaneID()).getFlightsAirplane().delete(f.getDate());
                airportST.get(f.getOrigin()).getFlightOriST().delete(f.getDate());
                airportST.get(f.getDestination()).getFlightDestST().delete(f.getDate());
                System.out.println("Flight of " + f.getDate() + " removed.");
            } else throw new
                    IllegalFlightException("This flight doesn't exist!");
        } catch (IllegalFlightException e) {
            e.printStackTrace();
        }
    }

    /**
     * Changes the current airport of the airplane after the flight.
     *
     * @param airportST  Symbol Table for airports.
     * @param airplaneST Symbol Table for airplanes.
     * @param flightST   Symbol Table for flights.
     */
    public static void editAfterFlight(RedBlackBST<String, Airport> airportST,
                                       SeparateChainingHashST<String, Airplane> airplaneST,
                                       RedBlackBST<Date, Flight> flightST) {

        for (Date i : flightST.inOrder()) {
            airportST.get(flightST.get(i).getOrigin()).getAirplaneST().delete(flightST.get(i).getAirplaneID());
            airportST.get(flightST.get(i).getDestination()).getAirplaneST().put(flightST.get(i).getAirplaneID(), airplaneST.get(flightST.get(i).getAirplaneID()));
        }

        for (Date i : flightST.inOrder()) {
            airplaneST.get(flightST.get(i).getAirplaneID()).setCurrentAirport(flightST.get(i).getDestination());
        }

    }


    public static String fastestPath(SymbolDigraph sd, Airport airportOrigin, Airport airportDestination, DesignMap map, Airplane a) {

        String result = "The fastest path is:\n";
        Integer origin = sd.indexOf(airportOrigin.getCode());
        Integer destination = sd.indexOf(airportDestination.getCode());


        DijkstraSP fastestPath = new DijkstraSP(sd.digraph(), origin, a, 1);
        for (DirectedEdge g : fastestPath.pathTo(destination)) {
           // System.out.println(sd.nameOf(g.from()) + " -> " + sd.nameOf(g.to()));
            result = result + "\t" + sd.nameOf(g.from()) + " -> " + sd.nameOf(g.to()) + "\n";
            map.addGraphConnection(sd.nameOf(g.from()), sd.nameOf(g.to()), airportST);
        }
        return result;
    }

    public static String shortestPath(SymbolDigraph sd, Airport airportOrigin, Airport airportDestination, DesignMap map) {

        String result = "The shortest path is:\n";
        Double total = 0.0;
        Integer origin = sd.indexOf(airportOrigin.getCode());
        Integer destination = sd.indexOf(airportDestination.getCode());

        DijkstraSP shortestPath = new DijkstraSP(sd.digraph(), origin, null, 2);
        for (DirectedEdge g : shortestPath.pathTo(destination)) {

           // System.out.println(sd.nameOf(g.from()) + " -> " + sd.nameOf(g.to()) + " : " + g.weight() + " km");
            total = total + g.weight();
            result = result + "\t" + sd.nameOf(g.from()) + " -> " + sd.nameOf(g.to()) + " : " + g.weight() + " km\n";
            map.addGraphConnection(sd.nameOf(g.from()), sd.nameOf(g.to()), airportST);

        }

        //System.out.println("The total distance, of the shortest path, from " + airportOrigin + " to " + airportDestination + " is " + total + " km.");
        result = result + "The total distance, of the shortest path, from " + airportOrigin.getCode() + " to " + airportDestination.getCode() + " is " + total + " km.";
        return result;
    }

    public static String economicPath(SymbolDigraph sd, Airport airportOrigin, Airport airportDestination, DesignMap map, Airplane a) {

        String result = "The most economic path is:\n";
        Integer origin = sd.indexOf(airportOrigin.getCode());
        Integer destination = sd.indexOf(airportDestination.getCode());

        DijkstraSP economicPath = new DijkstraSP(sd.digraph(), origin, a, 3);
        for (DirectedEdge g : economicPath.pathTo(destination)) {
            //System.out.println(sd.nameOf(g.from()) + " -> " + sd.nameOf(g.to()));
            result = result + "\t" + sd.nameOf(g.from()) + " -> " + sd.nameOf(g.to()) + "\n";
            map.addGraphConnection(sd.nameOf(g.from()), sd.nameOf(g.to()), airportST);
        }
        return result;
    }


    public static Airplane returnFlightAirplane(String origin, String destination) {

        for (Date f : flightST.inOrder()) {
            if (flightST.get(f).getOrigin().equals(origin) && flightST.get(f).getDestination().equals(destination)) {
                return airplaneST.get(flightST.get(f).getAirplaneID());
            }

        }
        return null;
    }
}




