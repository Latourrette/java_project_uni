package airport;

import edu.princeton.cs.algs4.In;

public class Airline {
    private String name;
    private airport.RedBlackBST<String, Airplane> airLinePlanesST = new airport.RedBlackBST<>();

    @Override
    public String toString() {
        return "Airline{" +
                "name='" + name + '\'' +
                ", airLinePlanesST=" + airLinePlanesST +
                '}';
    }

    public static void loadFromFileAirlines(airport.RedBlackBST<String, Airline> airlinesST, String path) {
        In in = new In(path);
        try {
            while (!in.isEmpty()) {
                String[] text = in.readLine().split(";");
                String aux1 = text[0];
                Airline aux = new Airline(aux1);
                airlinesST.put(aux1, aux);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public airport.RedBlackBST<String, Airplane> getAirLinePlanesST() {
        return airLinePlanesST;
    }

    public void setAirLinePlanesST(airport.RedBlackBST<String, Airplane> airLinePlanesST) {
        this.airLinePlanesST = airLinePlanesST;
    }

    public Airline(String name) {

        this.name = name;
    }

}
