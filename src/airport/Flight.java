package airport;


public class Flight {
    private String code;
    private String airplaneID;
    private String origin;
    private String destination;
    private String airplaneName;

    public Flight(String code, String airplaneID, String origin, String destination, String airplaneName) {
        this.code = code;
        this.airplaneID = airplaneID;
        this.origin = origin;
        this.destination = destination;
        this.airplaneName = airplaneName;
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
}