package airport;

import java.util.Date;

public class Airplane {
    private String id; //key
    private String model;
    private String name;
    private String airline;
    private Integer cruiseSpeed;
    private Integer cruiseAltitude;
    private Integer maxDistance;
    private String currentAirport;
    private Integer maxCapacity;
    private Integer fuelCapacity;
    private RedBlackBST<Date, Flight> flightsAirplane = new RedBlackBST<>();

    public Airplane(String id, String model, String name, String airline, Integer cruiseSpeed, Integer cruiseAltitude,
                    Integer maxDistance, String currentAirport, Integer maxCapacity, Integer fuelCapacity) {
        this.id = id;
        this.model = model;
        this.name = name;
        this.airline = airline;
        this.cruiseSpeed = cruiseSpeed;
        this.cruiseAltitude = cruiseAltitude;
        this.maxDistance = maxDistance;
        this.currentAirport = currentAirport;
        this.maxCapacity = maxCapacity;
        this.fuelCapacity = fuelCapacity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public Integer getCruiseSpeed() {
        return cruiseSpeed;
    }

    public void setCruiseSpeed(Integer cruiseSpeed) {
        this.cruiseSpeed = cruiseSpeed;
    }

    public Integer getCruiseAltitude() {
        return cruiseAltitude;
    }

    public void setCruiseAltitude(Integer cruiseAltitude) {
        this.cruiseAltitude = cruiseAltitude;
    }

    public Integer getMaxDistance() {
        return maxDistance;
    }

    public void setMaxDistance(Integer maxDistance) {
        this.maxDistance = maxDistance;
    }

    public String getCurrentAirport() {
        return currentAirport;
    }

    public void setCurrentAirport(String currentAirport) {
        this.currentAirport = currentAirport;
    }

    public Integer getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(Integer maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public Integer getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(Integer fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public RedBlackBST<Date, Flight> getFlightsAirplane() {
        return flightsAirplane;
    }

    public void setFlightsAirplane(RedBlackBST<Date, Flight> flightsAirplane) {
        this.flightsAirplane = flightsAirplane;
    }

    @Override
    public String toString() {
        return "Airplane{" +
                "id='" + id + '\'' +
                ", model='" + model + '\'' +
                ", name='" + name + '\'' +
                ", airline='" + airline + '\'' +
                ", cruiseSpeed=" + cruiseSpeed +
                ", cruiseAltitude=" + cruiseAltitude +
                ", maxDistance=" + maxDistance +
                ", currentAirport='" + currentAirport + '\'' +
                ", maxCapacity=" + maxCapacity +
                ", fuelCapacity=" + fuelCapacity +
                '}';
    }
}
