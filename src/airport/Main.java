package airport;

import edu.princeton.cs.algs4.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;

public class Main {

    public static void main(String[] args) throws ParseException {

        RedBlackBST<String, Airport> airportST = new RedBlackBST<>();
        SeparateChainingHashST<String, Airplane> airplaneST = new SeparateChainingHashST<>();
        RedBlackBST<Date, Flight> flightST = new RedBlackBST<>();


        loadFromFileAirport(airportST, ".//data//airports.txt");
        loadFromFileAirplane(airportST, airplaneST, ".//data//airplanes.txt");
        loadFromFileFlight(airportST, airplaneST, flightST, ".//data//flights.txt");

        Airport a = new Airport("FCP", "Futebol Club Porto", "Porto", "Portugal",
                "Europe", 10.0f);
        Airplane ap = new Airplane("40", "Toshiba", "Grande Maquina", "Toshiba Airlines",
                958, 12000, 15190, "FCP", 120, 126206);

        insertAirport(airportST, a);
       // insertAirplane(airportST, airplaneST, ap);
       // printAirplanesByAirport(airportST);
       // printAirport(airportST,"FCP");
        removeAirport(airportST,airportST.get("FCP"));
        printAirport(airportST,"FCP");

        //printCountryAirports(airportST, "Portugal");
        //printFlightFromAirport(airportST, "OPO");
        //printFlightToAirport(airportST, "CDG");
        //printFlightByAirplane(airplaneST, "1");
        //mostTraficAirport(airportST);
        //flightsByTimePeriod(flightST, "201311030340", "201511030340");
        //flightWithMostPassengers(flightST);
        //airportWithMostPassengers(airportST);

        saveToFileAirport(airportST, ".//data//airports.txt");
        saveToFileAirplane(airplaneST, ".//data//airplanes.txt");
        saveToFileFlight(flightST, ".//data//flights.txt");
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
                String code = text[0];
                String name = text[1];
                String city = text[2];
                String country = text[3];
                String continent = text[4];
                Float classification = Float.parseFloat(text[5]);


                Airport a = new Airport(code, name, city, country, continent, classification);
                airportST.put(code, a);
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
                airplaneST.put(id, a);
                airportST.get(currentAirport).getAirplaneST().put(id, a);

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
                DateFormat format = new SimpleDateFormat("dd-MM-yy hh:mm");
                Date date = format.parse(text[0]);
                String code = text[1];
                String airplaneID = text[2];
                String airplaneName = text[3];
                String origin = text[4];
                String destination = text[5];
                Integer passengers = Integer.parseInt(text[6]);
                Integer distance = Integer.parseInt(text[7]);

                Flight f = new Flight(date, code, airplaneID, airplaneName, origin, destination, passengers, distance);
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
            o.println(airportST.get(i).getCode() + ";" +
                    airportST.get(i).getName() + ";" +
                    airportST.get(i).getCity() + ";" +
                    airportST.get(i).getCountry() + ";" +
                    airportST.get(i).getContinent() + ";" +
                    airportST.get(i).getRating() + ";");
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
        DateFormat toString = new SimpleDateFormat("dd-MM-yy hh:mm");
        String date = "";
        for (Date i : flightST.inOrder()) {
            date = toString.format(flightST.get(i).getDate());
            o.println(date + ";" +
                    flightST.get(i).getAirplaneID() + ";" +
                    flightST.get(i).getAirplaneName() + ";" +
                    flightST.get(i).getOrigin() + ";" +
                    flightST.get(i).getDestination() + ";" +
                    flightST.get(i).getPassengers() + ";" +
                    flightST.get(i).getDistance() + ";");
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
            System.out.println("Name: " + airportST.get(i).getName());
            System.out.println("Key: " + airportST.get(i).getCode());
            System.out.println("City: " + airportST.get(i).getCity());
            System.out.println("Country: " + airportST.get(i).getCountry());
            System.out.println("Continent: " + airportST.get(i).getContinent());
            System.out.println("Rating: " + airportST.get(i).getRating());
            System.out.println("");
        }
    }

    /**
     * Prints a specific airport.
     *
     * @param airportST Symbol Table for airports.
     * @param code      The id key of the airport.
     */
    public static void printAirport(RedBlackBST<String, Airport> airportST, String code) {

        System.out.println("Information of Airport: " + airportST.get(code).getName());

        System.out.println("\tName: " + airportST.get(code).getName());
        System.out.println("\tCode: " + airportST.get(code).getCode());
        System.out.println("\tCity: " + airportST.get(code).getCity());
        System.out.println("\tCountry: " + airportST.get(code).getCountry());
        System.out.println("\tContinent: " + airportST.get(code).getContinent());
        System.out.println("\tRating: " + airportST.get(code).getRating());
        System.out.println("");
    }

    /**
     * Prints all airplanes by airports.
     *
     * @param airportST Symbol Table for airports.
     */
    public static void printAirplanesByAirport(RedBlackBST<String, Airport> airportST) {

        for (String i : airportST.inOrder()) {
            System.out.println("Airplanes in " + airportST.get(i).getName());
            for (String j : airportST.get(i).getAirplaneST().keys()) {
                System.out.println("\tID: " + airportST.get(i).getAirplaneST().get(j).getId());
                System.out.println("\tModel: " + airportST.get(i).getAirplaneST().get(j).getModel());
                System.out.println("\tName: " + airportST.get(i).getAirplaneST().get(j).getName());
                System.out.println("\tAirline: " + airportST.get(i).getAirplaneST().get(j).getAirline());
                System.out.println("\tCruise Speed: " + airportST.get(i).getAirplaneST().get(j).getCruiseSpeed());
                System.out.println("\tCruise Altitude: " + airportST.get(i).getAirplaneST().get(j).getCruiseAltitude());
                System.out.println("\tMax Distance: " + airportST.get(i).getAirplaneST().get(j).getMaxDistance());
                System.out.println("\tCurrent Airport: " + airportST.get(i).getAirplaneST().get(j).getCurrentAirport());
                System.out.println("\tMax Capacity: " + airportST.get(i).getAirplaneST().get(j).getMaxCapacity());
                System.out.println("\tFuel Capacity: " + airportST.get(i).getAirplaneST().get(j).getFuelCapacity());
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

        for (String i : airplaneST.keys()) {
            if (airplaneST.get(i).getId().equals(id)) {
                System.out.println("\tID: " + airplaneST.get(i).getId());
                System.out.println("\tModel: " + airplaneST.get(i).getModel());
                System.out.println("\tName: " + airplaneST.get(i).getName());
                System.out.println("\tAirline: " + airplaneST.get(i).getAirline());
                System.out.println("\tCruise Speed: " + airplaneST.get(i).getCruiseSpeed());
                System.out.println("\tCruise Altitude: " + airplaneST.get(i).getCruiseAltitude());
                System.out.println("\tMax Distance: " + airplaneST.get(i).getMaxDistance());
                System.out.println("\tCurrent Airport: " + airplaneST.get(i).getCurrentAirport());
                System.out.println("\tMax Capacity: " + airplaneST.get(i).getMaxCapacity());
                System.out.println("\tFuel Capacity: " + airplaneST.get(i).getFuelCapacity());
                System.out.println("");
            }
        }

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
                System.out.println("\tName: " + airportST.get(i).getName());
                System.out.println("\tCode: " + airportST.get(i).getCode());
                System.out.println("\tCity: " + airportST.get(i).getCity());
                System.out.println("\tCountry: " + airportST.get(i).getCountry());
                System.out.println("\tContinent: " + airportST.get(i).getContinent());
                System.out.println("\tRating: " + airportST.get(i).getRating());
                System.out.println("");
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
                System.out.println("\tDate: " + airportST.get(code).getFlightOriST().get(i).getDate());
                System.out.println("\tCode: " + airportST.get(code).getFlightOriST().get(i).getCode());
                System.out.println("\tAirplane ID: " + airportST.get(code).getFlightOriST().get(i).getAirplaneID());
                System.out.println("\tAirplane name: " + airportST.get(code).getFlightOriST().get(i).getAirplaneName());
                System.out.println("\tOrigin: " + airportST.get(code).getFlightOriST().get(i).getOrigin());
                System.out.println("\tDestination: " + airportST.get(code).getFlightOriST().get(i).getDestination());
                System.out.println("\tPassengers: " + airportST.get(code).getFlightOriST().get(i).getPassengers());
                System.out.println("\tDistance: " + airportST.get(code).getFlightOriST().get(i).getDistance());
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
                System.out.println("\tDate: " + airportST.get(code).getFlightDestST().get(i).getDate());
                System.out.println("\tCode: " + airportST.get(code).getFlightDestST().get(i).getCode());
                System.out.println("\tAirplane ID: " + airportST.get(code).getFlightDestST().get(i).getAirplaneID());
                System.out.println("\tAiprlane name: " + airportST.get(code).getFlightDestST().get(i).getAirplaneName());
                System.out.println("\tOrigin: " + airportST.get(code).getFlightDestST().get(i).getOrigin());
                System.out.println("\tDestination: " + airportST.get(code).getFlightDestST().get(i).getDestination());
                System.out.println("\tPassengers: " + airportST.get(code).getFlightDestST().get(i).getPassengers());
                System.out.println("\tDistance: " + airportST.get(code).getFlightDestST().get(i).getDistance());
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
        if (!airplaneST.get(code).getFlightsAirplane().isEmpty()) {
            for (Date j : airplaneST.get(code).getFlightsAirplane().inOrder()) {
                System.out.println("\tDate: " + airplaneST.get(code).getFlightsAirplane().get(j).getDate());
                System.out.println("\tCode: " + airplaneST.get(code).getFlightsAirplane().get(j).getCode());
                System.out.println("\tAirplane ID: " + airplaneST.get(code).getFlightsAirplane().get(j).getAirplaneID());
                System.out.println("\tAirplane name: " + airplaneST.get(code).getFlightsAirplane().get(j).getAirplaneName());
                System.out.println("\tOrigin: " + airplaneST.get(code).getFlightsAirplane().get(j).getOrigin());
                System.out.println("\tDestination: " + airplaneST.get(code).getFlightsAirplane().get(j).getDestination());
                System.out.println("\tPassengers: " + airplaneST.get(code).getFlightsAirplane().get(j).getPassengers());
                System.out.println("\tDistance: " + airplaneST.get(code).getFlightsAirplane().get(j).getDistance());

            }
        }
    }

    /**
     * Calculates the airport with more flights.
     *
     * @param airportST Symbol Table for airports.
     */
    public static void mostTraficAirport(RedBlackBST<String, Airport> airportST) {
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
                System.out.println(i + " ");
            }
            System.out.println("with a total of " + maxValue + " flights.");
        } else {
            System.out.println("The airport with most traffic is: ");
            System.out.println("");
            for (String i : airportsName) {
                System.out.println(i + " with a total of " + maxValue + " flights.");
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

        DateFormat format = new SimpleDateFormat("dd-MM-yy hh:mm");
        Date start = format.parse(date1);
        Date end = format.parse(date2);
        System.out.println("Flights between " + start + " and " + end + ":");
        System.out.println("");
        for (Date i : flightST.keys(start, end)) {
            System.out.println("\tDate: " + flightST.get(i).getDate());
            System.out.println("\tAirplane ID: " + flightST.get(i).getAirplaneID());
            System.out.println("\tAirplane name: " + flightST.get(i).getAirplaneName());
            System.out.println("\tOrigin: " + flightST.get(i).getOrigin());
            System.out.println("\tDestination: " + flightST.get(i).getDestination());
            System.out.println("\tPassengers: " + flightST.get(i).getPassengers());
            System.out.println("\tDistance: " + flightST.get(i).getDistance());
            System.out.println("");
        }

    }

    /**
     * Calculates the flights with most passengers.
     *
     * @param flightST Symbol Table for flights.
     */
    public static void flightWithMostPassengers(RedBlackBST<Date, Flight> flightST) {

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
                System.out.println("\tDate: " + flightST.get(j).getDate());
                System.out.println("\tCode: " + flightST.get(j).getCode());
            }
            System.out.println("");
            System.out.println("with a total of " + maxValue + " passengers.");
        } else

        {
            System.out.println("The flight with most passengers is: ");
            System.out.println("");
            for (Date j : flightAux) {
                System.out.println("\tDate: " + flightST.get(j).getDate());
                System.out.println("\tCode: " + flightST.get(j).getCode());
            }
            System.out.println("");
            System.out.println(" with a total of " + maxValue + " passengers.");
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

        System.out.println("The airport(s) with most passenger is: ");
        for (String i : airportsName) {
            System.out.println(i);
        }
        System.out.println("with " + maxValue + " passengers.");
    }

    /**
     * Inserts a new airport into the ST.
     *
     * @param airportST Symbol Table for airports.
     * @param a         Airport to be added.
     */
    public static void insertAirport(RedBlackBST<String, Airport> airportST, Airport a) {
        airportST.put(a.getCode(), a);
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
        airplaneST.put(a.getId(), a);
        airportST.get(a.getCurrentAirport()).getAirplaneST().put(a.getId(), a);
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
        flightST.put(f.getDate(), f);
        airportST.get(f.getOrigin()).getFlightOriST().put(f.getDate(), f);
        airportST.get(f.getDestination()).getFlightDestST().put(f.getDate(), f);
        airplaneST.get(f.getAirplaneID()).getFlightsAirplane().put(f.getDate(), f);
    }

    /**
     * Removes an airport from the ST.
     *
     * @param airportST Symbol Table for airports.
     * @param a         Airport to be removed.
     */
    public static void removeAirport(RedBlackBST<String, Airport> airportST, Airport a) {
        airportST.delete(a.getCode());
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
        airplaneST.delete(a.getId());
        airportST.get(a.getCurrentAirport()).getAirplaneST().delete(a.getId());
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
        flightST.delete(f.getDate());
        airplaneST.get(f.getAirplaneID()).getFlightsAirplane().delete(f.getDate());
        airportST.get(f.getOrigin()).getFlightOriST().delete(f.getDate());
        airportST.get(f.getDestination()).getFlightDestST().delete(f.getDate());
    }

    //public static void editAiport(RedBlackBST<String, Airport> airportST, )

}