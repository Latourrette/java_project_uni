package airport;

import java.util.Date;
import edu.princeton.cs.algs4.*;


public class Network{

    RedBlackBST<String, Airport> airportST = new RedBlackBST<>();
    SeparateChainingHashST<String, Airplane> airplaneST = new SeparateChainingHashST<>();
    RedBlackBST<Date, Flight> flightST = new RedBlackBST<>();

    //private ArrayList<Connection> connections = new ArrayList<>();

    protected static String selectedCost = Network.Distance;

    public final static String Distance = "DISTANCE";
    public final static String WindVelocity = "WIND VELOCITY";
    public final static String AirTunnel = "AIR TUNNEL";

    public RedBlackBST<String, Airport> getAirportST() {
        return airportST;
    }

    public void setAirportST(RedBlackBST<String, Airport> airportST) {
        this.airportST = airportST;
    }

    public SeparateChainingHashST<String, Airplane> getAirplaneST() {
        return airplaneST;
    }

    public void setAirplaneST(SeparateChainingHashST<String, Airplane> airplaneST) {
        this.airplaneST = airplaneST;
    }

    public RedBlackBST<Date, Flight> getFlightST() {
        return flightST;
    }

    public void setFlightST(RedBlackBST<Date, Flight> flightST) {
        this.flightST = flightST;
    }


    public String shortestPath(RedBlackBST<String, Airport> airportST,
                               SeparateChainingHashST<String, Airplane> airplaneST,
                               EdgeWeightedDigraph g, int from, int to, String type) {


        String aviaoID = null;
        int velocidadeAviao = 0;
        int altitudeAviao = 0;

        Aeroporto aInit = aeroportoST.get(hmap.get(from));  //de  hmap.get(from) passar de int para string

        for ( String codigo: aviaoST.keys()) {  //avioes no aeroporto de partida
            Aviao a = aviaoST.get(codigo);
            if(a.getCod_aeroporto().equals(aInit.getCodigo_aeroporto())) {  //=
                aviaoID = a.getId_aviao();  //id do aviao
                velocidadeAviao = Integer.parseInt(a.getVelocidade_cruzeiro()); //velocidade cruzeiro do aviao
                altitudeAviao = a.getAltitude_cruzeiro();   //altitude cruzeiro do aviao
            }
            //System.out.println("aviao id = " + aviaoID);
        }
        StringBuilder sb = new StringBuilder();

        DijkstraSP sp = new DijkstraSP(g, from, type, aviaoID, velocidadeAviao, altitudeAviao);    //g = distancia //from destino //distancia


        Aeroporto aDest = aeroportoST.get(hmap.get(to));    //para  hmap.get(to) passar de int para string

        // print shortest path
        if (sp.hasPathTo(to)) { //se tiver caminho
            sb.append(aInit.getCodigo_aeroporto()).append(" to ").append(aDest.getCodigo_aeroporto()).append(":\n\n"); //imprimir partida / destino :
            if (sp.hasPathTo(to)) {
                for (DirectedEdge c : sp.pathTo(to)) {  //carregar directedEdge
                    int ifrom = c.from();   //receber o from em int
                    int ito = c.to();   //receber o to em int
                    Aeroporto a1 = aeroportoST.get(hmap.get(ifrom));    //passar de int para string e carregar o codigo nos avioes
                    Aeroporto a2 = aeroportoST.get(hmap.get(ito));  //passar de int para string e carregar o codigo nos avioes
                    sb.append(a1.getCodigo_aeroporto()).append(" > ").append(a2.getCodigo_aeroporto()).append("\n");    //print dos partida e destinos que vão aparecendo

                }
            }
            sb.append("\nDistancia total - ").append(String.format("%.2f",sp.distTo(to))).append("km ");    //print da distancia total
        }
        else {
            System.out.println("não há caminho entre os dois aeroportos");
        }
        return sb.toString();
    }

}
