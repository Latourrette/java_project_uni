package airport;


import java.util.Date;

public class Flight {
    private String airplaneID;
    private String airplaneName;
    private String origin;
    private String destination;
    private Integer passengers;
    private Integer distance;
    private Date date;


    public Flight(Date date,String airplaneID, String airplaneName, String origin, String destination,
                  Integer passengers, Integer distance) {
        this.date = date;
        this.airplaneID = airplaneID;
        this.airplaneName = airplaneName;
        this.origin = origin;
        this.destination = destination;
        this.passengers = passengers;
        this.distance = distance;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
