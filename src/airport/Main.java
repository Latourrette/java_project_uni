package airport;

public class Main {

    public static void main(String[] args) {

        RedBlackBST<String, Airport> airportST = new RedBlackBST<>();
        RedBlackBST<String, Airline> airlineST = new RedBlackBST<>();
        SeparateChainingHashST<String, Airplane> airplaneST = new SeparateChainingHashST<>();

        Airplane.loadFromFileAirplane(airplaneST, ".//data//airplanes.txt");
        Airport.loadFromFileAirport(airportST, ".//data//airports.txt");
        Airline.loadFromFileAirline(airlineST, ".//data//airlines.txt");
        Airport.loadFromFileAirportFlight(airportST, ".//data//flights.txt");


        //System.out.println(Airport.removeAirport(airportST));

        //Airport.saveToFileAirport(airportST, ".//data//airports.txt");
    }


}
