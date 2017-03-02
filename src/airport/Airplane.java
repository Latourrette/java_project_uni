package airport;

import edu.princeton.cs.algs4.In;

public class Airplane {
    private String id; //key
    private String name;
    private int cruiseSpeed;
    private int cruiseAltitude;
    private int consumption;

    public Airplane(String id, String name, int cruiseSpeed, int cruiseAltitude, int consumption) {
        this.id = id;
        this.name = name;
        this.cruiseSpeed = cruiseSpeed;
        this.cruiseAltitude = cruiseAltitude;
        this.consumption = consumption;
    }

    @Override
    public String toString() {
        return "Airplane{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", cruiseSpeed=" + cruiseSpeed +
                ", cruiseAltitude=" + cruiseAltitude +
                ", consumption=" + consumption +
                '}';
    }



    public static void loadFromFileAirplanes(airport.RedBlackBST<String, Airplane> airplaneST, String path) {
        In in = new In(path);
        try {
            while (!in.isEmpty()) {
                String[] text = in.readLine().split(";");
                String aux1 = text[0];
                String aux2 = text[1];
                String aux3 = text[2];
                String aux4 = text[3];
                String aux5 = text[4];
                Airplane aux = new Airplane(aux1, aux2, Integer.parseInt(aux3), Integer.parseInt(aux4), Integer.parseInt(aux5));
                airplaneST.put(aux1, aux);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getConsumption() {
        return consumption;
    }

    public void setConsumption(int consumption) {
        this.consumption = consumption;
    }


}
