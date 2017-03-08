package airport;

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

    public Airplane(String id, String model, String name, String airline, int cruiseSpeed, int cruiseAltitude, int maxDistance, String currentAirport, int maxCapacity, int fuelCapacity) {
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

    public int getCruiseSpeed() {
        return cruiseSpeed;
    }

    public void setCruiseSpeed(int cruiseSpeed) {
        this.cruiseSpeed = cruiseSpeed;
    }

    public int getCruiseAltitude() {
        return cruiseAltitude;
    }

    public void setCruiseAltitude(int cruiseAltitude) {
        this.cruiseAltitude = cruiseAltitude;
    }

    public int getMaxDistance() {
        return maxDistance;
    }

    public void setMaxDistance(int maxDistance) {
        this.maxDistance = maxDistance;
    }

    public String getCurrentAirport() {
        return currentAirport;
    }

    public void setCurrentAirport(String currentAirport) {
        this.currentAirport = currentAirport;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public int getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(int fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
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
