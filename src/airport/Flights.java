package airport;

import java.util.Scanner;

public class Flights {
    private String flightCode; //key
    private String localOfDeparture;
    private String localOfArrival;
    private int windVelocity;

    public Flights(String flightCode, String localOfDeparture, String localOfArrival, int windVelocity) {
        this.flightCode = flightCode;
        this.localOfDeparture = localOfDeparture;
        this.localOfArrival = localOfArrival;
        this.windVelocity = windVelocity;
    }


    public static void makeAFlight(airport.RedBlackBST<String, Airport> airportST) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Airport name: ");
        String aux = scan.nextLine();
        System.out.println("Flight Code: ");
        String aux2 = scan.nextLine();
        System.out.println("Departure Airport: ");
        String aux3 = scan.nextLine();
        System.out.println("Arrival Airport: ");
        String aux4 = scan.nextLine();
        System.out.println("Wind Speed: ");
        int aux5 = scan.nextInt();
        Flights auxObj = new Flights(aux2, aux3, aux4, aux5);
        airportST.get(aux).getAirportFlightsST().put(aux2, auxObj);

        System.out.println(airportST.get(aux).getAirportFlightsST().get(aux2).getLocalOfArrival());
    }


    public String getFlightCode() {
        return flightCode;
    }

    public void setFlightCode(String flightCode) {
        this.flightCode = flightCode;
    }

    public String getLocalOfDeparture() {
        return localOfDeparture;
    }

    public void setLocalOfDeparture(String localOfDeparture) {
        this.localOfDeparture = localOfDeparture;
    }

    public String getLocalOfArrival() {
        return localOfArrival;
    }

    public void setLocalOfArrival(String localOfArrival) {
        this.localOfArrival = localOfArrival;
    }

    public int getWindVelocity() {
        return windVelocity;
    }

    public void setWindVelocity(int windVelocity) {
        this.windVelocity = windVelocity;
    }

    @Override
    public String toString() {
        return "Flights{" +
                "flightCode='" + flightCode + '\'' +
                ", localOfDeparture='" + localOfDeparture + '\'' +
                ", localOfArrival='" + localOfArrival + '\'' +
                ", windVelocity=" + windVelocity +
                '}';
    }

}
