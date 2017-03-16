package airport;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import edu.princeton.cs.algs4.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        RedBlackBST<String, Airport> airportST = new RedBlackBST<>();


        loadFromFileAirport(airportST, ".//data//airports.txt");
        loadFromFileAirplane(airportST, ".//data//airplanes.txt");
        loadFromFileFlight(airportST, ".//data//flights.txt");

        //printAllAirports(airportST);
        //printAirplanesByAirport(airportST);
        //printAirport(airportST);
        //printAirplane(airportST);
        //printCountryAirports(airportST);
        //printFlightToAirport(flightST, airportST);
        //printFlightByAirplane(flightST);
        //mostTraficAirport(airportST);

        saveToFileAirport(airportST, ".//data//airports.txt");
        saveToFileAirplane(airportST, ".//data//airplanes.txt");
        saveToFileFLight(airportST, ".//data//flights.txt");
    }

    public static void loadFromFileAirport(RedBlackBST<String, Airport> airportST, String path) {
        In in = new In(path);
        try {
            while (!in.isEmpty()) {
                String[] text = in.readLine().split(";");
                String name = text[0];
                String code = text[1];
                String city = text[2];
                String country = text[3];
                String continent = text[4];
                Float classification = Float.parseFloat(text[5]);


                Airport a = new Airport(name, code, city, country, continent, classification);
                airportST.put(code, a);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void loadFromFileAirplane(RedBlackBST<String, Airport> airportST, String path) {
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

            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void loadFromFileFlight(RedBlackBST<String, Airport> airportST, String path) {

        In in = new In(path);
        try {

            while (!in.isEmpty()) {
                String[] text = in.readLine().split(";");
                String code = text[0];
                String airplaneID = text[1];
                String airplaneName = text[2];
                String origin = text[3];
                String destination = text[4];
                Integer passengers = Integer.parseInt(text[5]);
                Integer distance = Integer.parseInt(text[6]);


                Flight f = new Flight(code, airplaneID, airplaneName, origin, destination, passengers, distance);
                airportST.get(origin).getFlightST().put(code, f);
                airportST.get(destination).getFlightST().put(code, f);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void saveToFileAirport(RedBlackBST<String, Airport> airportST, String path) {
        Out o = new Out(path);
        for (String i : airportST.keys()) {
            o.println(airportST.get(i).getName() + ";" +
                    airportST.get(i).getCode() + ";" +
                    airportST.get(i).getCity() + ";" +
                    airportST.get(i).getCountry() + ";" +
                    airportST.get(i).getContinent() + ";" +
                    airportST.get(i).getRating() + ";");
        }
    }

    public static void saveToFileAirplane(RedBlackBST<String, Airport> airportST, String path) {
        Out o = new Out(path);
        for (String i : airportST.keys()) {
            for (String j : airportST.get(i).getAirplaneST().keys()) {
                o.println(airportST.get(i).getAirplaneST().get(j).getId() + ";" +
                        airportST.get(i).getAirplaneST().get(j).getModel() + ";" +
                        airportST.get(i).getAirplaneST().get(j).getName() + ";" +
                        airportST.get(i).getAirplaneST().get(j).getAirline() + ";" +
                        airportST.get(i).getAirplaneST().get(j).getCruiseSpeed() + ";" +
                        airportST.get(i).getAirplaneST().get(j).getCruiseAltitude() + ";" +
                        airportST.get(i).getAirplaneST().get(j).getMaxDistance() + ";" +
                        airportST.get(i).getAirplaneST().get(j).getCurrentAirport() + ";" +
                        airportST.get(i).getAirplaneST().get(j).getMaxDistance() + ";" +
                        airportST.get(i).getAirplaneST().get(j).getFuelCapacity() + ";");
            }
        }
    }

    public static void saveToFileFLight(RedBlackBST<String, Airport> airportST, String path) {
        Out o = new Out(path);
        for (String i : airportST.keys()) {
            for (String j : airportST.get(i).getFlightST().keys()) {
                o.println(airportST.get(i).getFlightST().get(j).getCode() + ";" +
                        airportST.get(i).getFlightST().get(j).getAirplaneID() + ";" +
                        airportST.get(i).getFlightST().get(j).getAirplaneName() + ";" +
                        airportST.get(i).getFlightST().get(j).getOrigin() + ";" +
                        airportST.get(i).getFlightST().get(j).getDestination() + ";" +
                        airportST.get(i).getFlightST().get(j).getPassengers() + ";" +
                        airportST.get(i).getFlightST().get(j).getDistance() + ";");
            }
        }
    }

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

    public static void printAirport(RedBlackBST<String, Airport> airportST) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Choose the airport code to get information: ");
        String code = scan.nextLine();

        System.out.println("Information of Airport: " + airportST.get(code).getName());

        System.out.println("\tName: " + airportST.get(code).getName());
        System.out.println("\tCode: " + airportST.get(code).getCode());
        System.out.println("\tCity: " + airportST.get(code).getCity());
        System.out.println("\tCountry: " + airportST.get(code).getCountry());
        System.out.println("\tContinent: " + airportST.get(code).getContinent());
        System.out.println("\tRating: " + airportST.get(code).getRating());
        System.out.println("");
    }

    public static void printAirplanesByAirport(RedBlackBST<String, Airport> airportST) {

        for (String i : airportST.keys()) {
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

    public static void printAirplane(RedBlackBST<String, Airport> airportST) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Choose the airplane id to get information: ");
        String id = scan.nextLine();
        for (String i : airportST.keys()) {
            for (String j : airportST.get(i).getAirplaneST().keys())
                if (airportST.get(i).getAirplaneST().get(j).getId().equals(id)) {
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

    public static void printCountryAirports(RedBlackBST<String, Airport> airportST) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Choose the country name to get airports information: ");
        String c = scan.nextLine();

        for (String i : airportST.keys()) {
            //System.out.println(c + " airports :");
            if (airportST.get(i).getCountry().equals(c)) {
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

    public static void printFlightToAirport(RedBlackBST<String, Airport> airportST) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Choose the airport code to get the flights: ");
        String code = scan.nextLine();

        System.out.println("Flights of " + airportST.get(code).getName());

        if (!airportST.get(code).getFlightST().isEmpty()) {
            for (String i : airportST.get(code).getFlightST().keys()) {
                System.out.println("\tCode: " + airportST.get(code).getFlightST().get(i).getCode());
                System.out.println("\tAirplane ID: " + airportST.get(code).getFlightST().get(i).getAirplaneID());
                System.out.println("\tAiprlane name: " + airportST.get(code).getFlightST().get(i).getAirplaneName());
                System.out.println("\tOrigin: " + airportST.get(code).getFlightST().get(i).getOrigin());
                System.out.println("\tDestination: " + airportST.get(code).getFlightST().get(i).getDestination());
                System.out.println("\tPassengers: " + airportST.get(code).getFlightST().get(i).getPassengers());
                System.out.println("\tDistance: " + airportST.get(code).getFlightST().get(i).getDistance());
            }
        } else System.out.println("That airport doesn't have flights.");
    }

    public static void printFlightByAirplane(RedBlackBST<String, Airport> airportST) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Choose the airplane id: ");
        String code = scan.nextLine();


        for (String i : airportST.keys()) {
            for (String j : airportST.get(i).getFlightST().keys()) {
                if (airportST.get(i).getFlightST().get(j).getAirplaneID().equals(code)) {
                    System.out.println("\tCode: " + airportST.get(i).getFlightST().get(j).getCode());
                    System.out.println("\tAirplane ID: " + airportST.get(i).getFlightST().get(j).getAirplaneID());
                    System.out.println("\tAiprlane name: " + airportST.get(i).getFlightST().get(j).getAirplaneName());
                    System.out.println("\tOrigin: " + airportST.get(i).getFlightST().get(j).getOrigin());
                    System.out.println("\tDestination: " + airportST.get(i).getFlightST().get(j).getDestination());
                    System.out.println("\tPassengers: " + airportST.get(i).getFlightST().get(j).getPassengers());
                    System.out.println("\tDistance: " + airportST.get(i).getFlightST().get(j).getDistance());
                }
            }
        }
    }
    
    public static void mostTraficAirport(RedBlackBST<String, Airport> airportST) {
        int maxValue = 0;
        ArrayList<String> AirportsName = new ArrayList<>();

        for (String i : airportST.keys()) {
            if (maxValue < airportST.get(i).getFlightST().size()) {
                maxValue = airportST.get(i).getFlightST().size();
            }
        }
        for (String i : airportST.keys()) {
            if (maxValue == airportST.get(i).getFlightST().size()) {
                if (!AirportsName.contains(i)) {
                    AirportsName.add(i);
                }
            }
        }
        if (AirportsName.size() > 1) {
            System.out.println("The airports with most traffic are: ");
            System.out.println("");
            for (String i : AirportsName) {
                System.out.println(i + " ");
            }
            System.out.println("com um total de " + maxValue + " voos.");
        } else {
            System.out.println("O aeroporto com vais voos é ");
            for (String i : AirportsName) {
                System.out.println(i + " com um total de " + maxValue);
            }
        }
    }
}
