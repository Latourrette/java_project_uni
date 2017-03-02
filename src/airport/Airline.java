package airport;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;

import java.util.Scanner;

public class Airline {
    private String name;
    private RedBlackBST<String, Airplane> airlinePlanesST = new RedBlackBST<>();


    public static void loadFromFileAirline(RedBlackBST<String, Airline> airlinesST, String path) {
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

    public RedBlackBST<String, Airplane> getairlinePlanesST() {
        return airlinePlanesST;
    }

    public void setairlinePlanesST(RedBlackBST<String, Airplane> airlinePlanesST) {
        this.airlinePlanesST = airlinePlanesST;
    }

    public Airline(String name) {

        this.name = name;
    }

    @Override
    public String toString() {
        return "Airline{" +
                "name='" + name + '\'' +
                ", airlinePlanesST=" + airlinePlanesST +
                '}';
    }

}
