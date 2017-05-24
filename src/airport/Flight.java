package airport;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Flight Class
 */
public class Flight {
    private Date date;
    private String airplaneID;
    private String origin;
    private String destination;
    private Integer passengers;
    private Integer distance;
    private Integer flightAltitude;

    /**
     * Flight Constructors
     *
     * @param date           Date of the flight, also the key
     * @param airplaneID     Id of the airplane doing the flight
     * @param origin         Origin of the flight
     * @param destination    Destination of the flight
     * @param passengers     Number of passengers in the flight
     * @param distance       Distance between of origin and destination of the flight
     * @param flightAltitude Altitude required for the flight
     * @param windVelocity   Wind velocity of the flight
     */
    public Flight(Date date, String airplaneID, String origin, String destination, Integer passengers, Integer distance, Integer flightAltitude) {
        this.date = date;
        this.airplaneID = airplaneID;
        this.origin = origin;
        this.destination = destination;
        this.passengers = passengers;
        this.distance = distance;
        this.flightAltitude = flightAltitude;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAirplaneID() {
        return airplaneID;
    }

    public void setAirplaneID(String airplaneID) {
        this.airplaneID = airplaneID;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Integer getPassengers() {
        return passengers;
    }

    public void setPassengers(Integer passengers) {
        this.passengers = passengers;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Integer getFlightAltitude() {
        return flightAltitude;
    }

    public void setFlightAltitude(Integer flightAltitude) {
        this.flightAltitude = flightAltitude;
    }


    @Override
    public String toString() {

        DateFormat toString = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        String newDate = toString.format(this.getDate());


        return "Date = " + newDate +
                ", Airplane ID '= " + airplaneID + '\'' +
                ", Origin = '" + origin + '\'' +
                ", Destination = '" + destination + '\'' +
                ", Passengers = " + passengers +
                ", Distance = " + distance +
                ", Flight Altitude = " + flightAltitude;
    }
}
