package airport;


import java.util.Date;

public class Airport {
    private String name;
    private String code;
    private String city;
    private String country;
    private String continent;
    private Float rating;
    private RedBlackBST<String, Airplane> airplaneST = new RedBlackBST<>();
    private RedBlackBST<Date, Flight> flightST = new RedBlackBST<>();


    public Airport(String name, String code, String city, String country, String continent, Float rating) {
        this.name = name;

        this.code = code;
        this.city = city;
        this.country = country;
        this.continent = continent;
        this.rating = rating;
    }

    /*


    public static boolean removeAirport(RedBlackBST<String, Airport> airportRedBlackBST) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Choose airport to delete: ");
        String aux = scan.nextLine();
        for (String key : airportRedBlackBST.get(aux).getAirportFlightsST().keys()) {
            if (airportRedBlackBST.get(aux).getAirportFlightsST().get(key).getLocalOfArrival().equals(aux) ||
                    airportRedBlackBST.get(aux).getAirportFlightsST().get(key).getLocalOfArrival().equals(aux)) {
                airportRedBlackBST.get(aux).getAirportFlightsST().delete(key);
            }
        }
        airportRedBlackBST.delete(aux);

        for (String air : airportRedBlackBST.keys()) {
            if (air.equals(aux)) {
                return false;
            }
        }
        return true;
    }

    public static void saveToFileAirport(RedBlackBST<String, Airport> airportRedBlackBST, String path) {
        Out o = new Out(path);
        for (String aux : airportRedBlackBST.keys()) {
            Airport air = airportRedBlackBST.get(aux);
            o.println(air.getName() + ";" + air.getLat() + ";" + air.getLon());
        }
    }

    public static void addAirport(RedBlackBST<String, Airport> airportST) {
        Scanner scan = new Scanner(System.in);
        try {
            System.out.println("Airport name: ");
            String aux = scan.nextLine();
            System.out.println("Lat: ");
            String aux2 = scan.nextLine();
            System.out.println("Lon: ");
            String aux3 = scan.nextLine();
            Airport auxObj = new Airport(aux, aux2, aux3);
            airportST.put(aux, auxObj);
        } catch (Exception e) {
            System.out.println(e);
        }
    }*/

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

    public RedBlackBST<String, Airplane> getAirplaneST() {
        return airplaneST;
    }

    public void setAirplaneST(RedBlackBST<String, Airplane> airplaneST) {
        this.airplaneST = airplaneST;
    }

    public RedBlackBST<Date, Flight> getFlightST() {
        return flightST;
    }

    public void setFlightST(RedBlackBST<Date, Flight> flightST) {
        this.flightST = flightST;
    }
}
