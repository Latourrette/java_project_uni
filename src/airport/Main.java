package airport;

public class Main {

    public static void main(String[] args) {

        airport.RedBlackBST<String, Airport> airportST = new airport.RedBlackBST<>();
        airport.RedBlackBST<String, Airplane> airplaneST = new airport.RedBlackBST<>();
        airport.RedBlackBST<String, Airline> airlineST = new airport.RedBlackBST<>();

        Airplane.loadFromFileAirplanes(airplaneST, ".//data//airplanes.txt");
        Airport.loadFromFileAirports(airportST, ".//data//airports.txt");
        Airline.loadFromFileAirlines(airlineST, ".//data//airlines.txt");
        Airport.loadFromFileAirportFlights(airportST, ".//data//flights.txt");


        System.out.println(Airport.removeAirport(airportST));

        Airport.saveFileAirports(airportST, ".//data//airports.txt");
    }


}
