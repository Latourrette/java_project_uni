package airport;


import java.util.Date;

/**
 * Airport Class
 */
public class Airport {
    private String code;
    private String name;
    private String city;
    private String country;
    private String continent;
    private Float rating;
    private SeparateChainingHashST<String, Airplane> airplaneST = new SeparateChainingHashST<>();
    private RedBlackBST<Date, Flight> flightOriST = new RedBlackBST<>();
    private RedBlackBST<Date, Flight> flightDestST = new RedBlackBST<>();

    /**
     * Airport Constructors
     * @param code Id key
     * @param name Name of the airport
     * @param city City of the airport
     * @param country Country of the airport
     * @param continent Continent of the airport
     * @param rating Rating of the airport
     */
    public Airport(String code, String name, String city, String country, String continent, Float rating) {
        this.code = code;
        this.name = name;
        this.city = city;
        this.country = country;
        this.continent = continent;
        this.rating = rating;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public SeparateChainingHashST<String, Airplane> getAirplaneST() {
        return airplaneST;
    }

    public void setAirplaneST(SeparateChainingHashST<String, Airplane> airplaneST) {
        this.airplaneST = airplaneST;
    }

    public RedBlackBST<Date, Flight> getFlightOriST() {
        return flightOriST;
    }

    public void setFlightOriST(RedBlackBST<Date, Flight> flightOriST) {
        this.flightOriST = flightOriST;
    }

    public RedBlackBST<Date, Flight> getFlightDestST() {
        return flightDestST;
    }

    public void setFlightDestST(RedBlackBST<Date, Flight> flightDestST) {
        this.flightDestST = flightDestST;
    }
}
