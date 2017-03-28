package airport;

import java.util.Date;

public class Flight {
    public String code;
    public String airplaneID;
    public String origin;
    public String destination;
    public String airplaneName;
    public Date date;

    public Flight(String code, String airplaneID, String origin, String destination, String airplaneName, Date date) {
        this.code = code;
        this.airplaneID = airplaneID;
        this.origin = origin;
        this.destination = destination;
        this.airplaneName = airplaneName;
        this.date = date;

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


}
