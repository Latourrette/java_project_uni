package airport;


import edu.princeton.cs.algs4.Date;
import sun.util.calendar.LocalGregorianCalendar;

public class Flight {
    private String code;
    private String airplaneID;
    private String airplaneName;
    private String origin;
    private String destination;
    private Integer passengers;
    private Integer distance;


    public Flight(String code, String airplaneID, String airplaneName, String origin, String destination,
                  Integer passengers, Integer distance) {
        this.code = code;
        this.airplaneID = airplaneID;
        this.airplaneName = airplaneName;
        this.origin = origin;
        this.destination = destination;
        this.passengers = passengers;
        this.distance = distance;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public String getAirplaneName() {
        return airplaneName;
    }

    public void setAirplaneName(String airplaneName) {
        this.airplaneName = airplaneName;
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
}
