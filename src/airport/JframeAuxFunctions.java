/*

package airport;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Vector;
import edu.princeton.cs.algs4.DirectedEdge;

*/
/**
 *
 * @author eu
 *//*

public class JframeAuxFunctions {

    private static final double _eQuatorialEarthRadius = 6378.1370D;
    private static final double _d2r = (Math.PI / 180D);
    
    public static String getAirplaneID(String name, RedBlackBST<String, Airplane> airplaneST){
        for (String aux : airplaneST.inOrder()){
            if (name.compareTo(airplaneST.get(aux).getName())==0){
                return aux;
            }
        }
        return null;
    }
    
    
    public static double HaversineInKM(double lat1, double long1, double lat2, double long2) {
        
        double dlong = (long2 - long1) * _d2r;
        double dlat = (lat2 - lat1) * _d2r;
        double a = Math.pow(Math.sin(dlat / 2D), 2D) + Math.cos(lat1 * _d2r) * Math.cos(lat2 * _d2r) * Math.pow(Math.sin(dlong / 2D), 2D);
        double c = 2D * Math.atan2(Math.sqrt(a), Math.sqrt(1D - a));
        double d = _eQuatorialEarthRadius * c;

        return d;
    }
    public static String shortestPath(SymbolDigraph sd ,int departureAirport,int arrivalAirport,DesignMap map,RedBlackBST<String, Airport> airportST){
        String text = "";
        DijkstraSP shortestPath = new DijkstraSP(sd.digraph(), departureAirport, null);
        for(DirectedEdge g : shortestPath.pathTo(arrivalAirport)) {
            text=text+sd.nameOf(g.from()) + " -> " + sd.nameOf(g.to()) + ":" + g.weight()+"\n";
            map.addGraphConnection(sd.nameOf(g.from()), sd.nameOf(g.to()), airportST);
        }
        return text;
    }
    
    public static String shortestPathClient(SymbolDigraph grafo,String aer_origem,String aer_destino,DesignMap map,RedBlackBST<String, Airport> airportST) {
        return shortestPath(grafo, grafo.indexOf(aer_origem), grafo.indexOf(aer_destino),map,airportST);
    }
    
    public static String economicPath(SymbolDigraph sd ,int departureAirport,int arrivalAirport,DesignMap map,RedBlackBST<String, Airport> airportST, Airplane airplane){
        String text = "";
        DijkstraSP shortestPath = new DijkstraSP(sd.digraph(), departureAirport, airplane);
        for(DirectedEdge g : shortestPath.pathTo(arrivalAirport)) {
            text=text+sd.nameOf(g.from()) + " -> " + sd.nameOf(g.to())+"\n";
            map.addGraphConnection(sd.nameOf(g.from()), sd.nameOf(g.to()), airportST);
        }
        return text;
    }
    
    public static String economicPathClient(SymbolDigraph grafo,String aer_origem,String aer_destino,DesignMap map,RedBlackBST<String, Airport> airportST,Airplane airplane){
        return economicPath(grafo, grafo.indexOf(aer_origem), grafo.indexOf(aer_destino),map,airportST,airplane);
    }
    
    public static String fasterPath(SymbolDigraph sd ,int departureAirport,int arrivalAirport,DesignMap map,RedBlackBST<String, Airport> airportST,Airplane airplane){
        String text = "";
        DijkstraSP shortestPath = new DijkstraSP(sd.digraph(), departureAirport, airplane);
        for(DirectedEdge g : shortestPath.pathTo(arrivalAirport)) {
            text=text+sd.nameOf(g.from()) + " -> " + sd.nameOf(g.to())+"\n";
            map.addGraphConnection(sd.nameOf(g.from()), sd.nameOf(g.to()), airportST);
        }
        return text;
    }
    
    public static String fasterPathClient(SymbolDigraph grafo,String aer_origem,String aer_destino,DesignMap map,RedBlackBST<String, Airport> airportST,Airplane airplane){
        return fasterPath(grafo, grafo.indexOf(aer_origem), grafo.indexOf(aer_destino),map,airportST,airplane);
    }
    
    */
/**
     * Retorna uma string os voos efetuados num determinado espaço de tempo
     *
     * @param airportST
     * @throws ParseException
     *//*

    public static String printFlightsTimePeriod(RedBlackBST<Date, Flights> flightsST, String date1, String date2) throws ParseException {
        DateFormat ft = new SimpleDateFormat("HH:mm:ss yyyy.MM.dd");
        String text = "Voos entre " + ft.parse(date1) + " e " + ft.parse(date2) + "\n\n";
        for (Date date : flightsST.keys(ft.parse(date1), ft.parse(date2))) {
            text = text + flightsST.get(date).getFlightDate().toString()+ "\n";
        }
        if (text.compareTo("Voos entre " + ft.parse(date1) + " e " + ft.parse(date2) + "\n\n") == 0) {
            return "Não existem voos entre este periodo de tempo!\n";
        }
        return text;
    }

    */
/**
     * Retorna uma string os voos de um determinado avião
     *
     * @param airportST
     * @param airplaneST
     *//*

    public static String printFlightsAirplane(RedBlackBST<String, Airport> airportST, RedBlackBST<String, Airplane> airplaneST, String airplaneName) {
        String text = "";
        ArrayList<String> dupControl = new ArrayList<>();
        for (String s : airportST.inOrder()) {
            for (Date p : airportST.get(s).getFlightsST().inOrder()) {
                if (airportST.get(s).getFlightsST().get(p).getAirplaneCode().compareTo(airplaneName) == 0 && !dupControl.contains(p.toString())) {
                    text = text + p + "\n";
                    dupControl.add(p.toString());
                }
            }
        }
        return text;
    }

    */
/**
     * Retorna uma string os aviões num determinado aeroporto
     *
     * @param airportST
     * @param airplaneST
     *//*

    public static String printAirplanesInAirport(RedBlackBST<String, Airport> airportST, RedBlackBST<String, Airplane> airplaneST, String airport) {
        String text = "";

        if (airport != null) {
            for (String p : airplaneST.inOrder()) {
                if (airplaneST.get(p).getAirportCode().compareTo(airport) == 0) {
                    text = text + "Airplane ID: " + airplaneST.get(p).getId() + "\n"
                            + "Airplane Model: " + airplaneST.get(p).getAirplaneModel() + "\n"
                            + "Airplane Name: " + airplaneST.get(p).getName() + "\n";
                }
            }
        } else {
            return "Airport not found!";
        }
        return text;
    }

    */
/**
     * Retorna uma string com os códigos e nomes do(s) aeroporto(s) com mais
     * passageiros
     *
     * @param airportST
     *//*

    public static String mostsAirportPeople(RedBlackBST<String, Airport> airportST) {
        Map<String, Integer> aux = new HashMap<>();
        for (String s : airportST.inOrder()) {
            if (!aux.containsKey(s)) {
                aux.put(s, 0);
            }
            for (Date s1 : airportST.get(s).getFlightsST().inOrder()) {
                aux.put(s, (aux.get(s) + airportST.get(s).getFlightsST().get(s1).getNumberOfPeople()));
            }
        }

        int maxPeople = 0;

        for (String s : aux.keySet()) {
            if (aux.get(s) > maxPeople) {
                maxPeople = aux.get(s);
            }
        }
        String text = "";

        for (String s : aux.keySet()) {
            if (aux.get(s) == maxPeople) {
                text = text + s + "\n";
            }
        }
        text = text + "Com um total de " + maxPeople;
        return text;
    }

    */
/**
     * Retorna uma string com o(s) voo(s) com mais passageiros
     *
     * @param airportST
     *//*

    public static String mostPeopleFlights(RedBlackBST<Date, Flights> flightsST) {

        int maxValue = 0;
        String text = "";

        asdasd for (Date aux2 : flightsST.inOrder()) {
            if (maxValue < flightsST.get(aux2).getNumberOfPeople()) {
                maxValue = flightsST.get(aux2).getNumberOfPeople();
            }
        }

        ArrayList<String> FlightName = new ArrayList<>();
        for (Date aux2 : flightsST.inOrder()) {
            if (maxValue == flightasdadadad sST.get(aux2).getNumberOfPeople() && !FlightName.contains(flightsST.get(aux2).getFlightDate().toString())) {
                FlightName.add(flightsST.get(aux2).getFlightDate().toString());
            }
        }
        if (FlightName.size() > 1) {
            text = "Os voos com mais pessoas são\n";
            for (String code : FlightName) {
                text = text + code + "\n";
            }
            text = text + "Com um total de " + maxValue + " pessoas.";
        } else {
            text = "O voo com mais pessoas é: ";
            for (String code : FlightName) {
                text = text + code + " com um total de " + maxValue;
            }
        }
        return text;
    }

    */
/**
     * Retorna uma string com os códigos e nomes do(s) aeroporto(s) de um
     * determinado continente
     *
     * @param airportST
     * @throws IllegalAirportException
     *//*

    public static String continentAirports(RedBlackBST<String, Airport> airportST, String continent) {
        String text = "Continente: " + continent + "\n\n";
        if (!airportST.isEmpty()) {
            Scanner scan = new Scanner(System.in);
            System.out.print("Insira o continente: ");
            for (String aux : airportST.inOrder()) {
                if (airportST.get(aux).getContinent().compareTo(continent) == 0) {
                    text = text + airportST.get(aux).getName() + "\n";
                }
            }
        }
        if (text.compareTo("Continente: " + continent + "\n\n") == 0) {
            return "Não existem aeroportos neste continente!\n";
        }
        return text;
    }

    */
/**
     * Retorna uma string com os códigos e nomes do(s) aeroporto(s) de um
     * determinado país
     *
     * @param airportST
     * @throws IllegalAirportException
     *//*

    public static String countryAirports(RedBlackBST<String, Airport> airportST, String country) {
        String text = "País: " + country + "\n\n";
        if (!airportST.isEmpty()) {
            Scanner scan = new Scanner(System.in);
            for (String aux : airportST.inOrder()) {
                if (airportST.get(aux).getCountry().compareTo(country) == 0) {
                    text = text + aux + " (" + airportST.get(aux).getName() + ")\n";
                }
            }
        }
        if (text.compareTo("País: " + country + "\n\n") == 0) {
            return "Não existem aeroportos em " + country + "\n";
        }
        return text;
    }

    */
/**
     * Retorna uma string com os códigos e nomes do(s) aeroporto(s) com mais
     * voos
     *
     * @param airportST
     * @throws IllegalAirportException
     * @throws IllegalFlightException
     *//*

    public static String mostFlights(RedBlackBST<String, Airport> airportST) {
        int maxValue = 0;
        if (!airportST.isEmpty()) {
            for (String aux : airportST.inOrder()) {
                if (!airportST.get(aux).getFlightsST().isEmpty()) {
                    if (maxValue < airportST.get(aux).getFlightsST().size()) {
                        maxValue = airportST.get(aux).getFlightsST().size();
                    }
                }
            }
        }

        ArrayList<String> AirportsName = new ArrayList<>();
        for (String aux : airportST.inOrder()) {
            if (maxValue == airportST.get(aux).getFlightsST().size()) {
                if (!AirportsName.contains(aux)) {
                    AirportsName.add(aux);
                }
            }
        }
        String text = "";
        if (AirportsName.size() > 1) {
            text = "Os aeroportos com mais voos são: ";
            for (String code : AirportsName) {
                text = text + "\n" + code;
            }
            text = text + "\nCom um total de " + maxValue + " voos.";
        } else {
            text = "O aeroporto com vais voos é: ";
            for (String code : AirportsName) {
                text = text + code + " com um total de " + maxValue + " voos.";
            }
        }
        return text;
    }

    */
/**
     * Retorna uma string com os voos que estao de partida de um certo aeroporto
     *
     * @param airportST
     * @throws IllegalAirportException
     * @throws IllegalFlightException
     *//*

    public static String outcomingFlights(RedBlackBST<String, Airport> airportST, String aux) {
        Scanner scan = new Scanner(System.in);
        String text = "";
        if (airportST.contains(aux)) {
            if (!airportST.get(aux).getFlightsST().isEmpty()) {
                for (Date aux2 : airportST.get(aux).getFlightsST().inOrder()) {
                    if (airportST.get(aux).getFlightsST().get(aux2).getLocalOfDeparture().compareTo(aux) == 0) {
                        text = text + " localOfArrival: "
                                + airportST.get(aux).getFlightsST().get(aux2).getLocalOfArrival() + " localOfDeparture: " + airportST.get(aux).getFlightsST().get(aux2).getLocalOfDeparture()
                                + " windVelocity: " + airportST.get(aux).getFlightsST().get(aux2).getWindVelocity() + " cost: " + airportST.get(aux).getFlightsST().get(aux2).getCost()
                                + " numberOfPeople: " + airportST.get(aux).getFlightsST().get(aux2).getNumberOfPeople() + "\n";
                    }
                }
            }
        }
        if (text.compareTo("") == 0) {
            return "Não existem voos de partida neste aeroporto!";
        }
        return text;
    }

    */
/**
     * Retorna uma string com os voos que estão a chegar a um certo aeroporto
     *
     * @param airportST
     * @throws IllegalAirportException
     * @throws IllegalFlightException
     *//*

    public static String incomingFlights(RedBlackBST<String, Airport> airportST, String aux) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Airport name: ");
        String text = "";

        if (airportST.contains(aux)) {

            if (!airportST.get(aux).getFlightsST().isEmpty()) {
                for (Date aux2 : airportST.get(aux).getFlightsST().inOrder()) {
                    if (airportST.get(aux).getFlightsST().get(aux2).getLocalOfArrival().compareTo(aux) == 0) {
                        text = text + " localOfArrival: "
                                + airportST.get(aux).getFlightsST().get(aux2).getLocalOfArrival() + " localOfDeparture: " + airportST.get(aux).getFlightsST().get(aux2).getLocalOfDeparture()
                                + " windVelocity: " + airportST.get(aux).getFlightsST().get(aux2).getWindVelocity() + " cost: " + airportST.get(aux).getFlightsST().get(aux2).getCost()
                                + " numberOfPeople: " + airportST.get(aux).getFlightsST().get(aux2).getNumberOfPeople() + "\n";
                    }
                }
            }

        }
        if (text.compareTo("") == 0) {
            return "Não existem voos de chegada a este aeroporto!";
        }
        return text;
    }
    
    */
/**
     * Verifica se a informação do voo está correta e retorna true ou false
     * @param airplaneST
     *//*

    
    public static boolean verifyAirplane(String airplaneCode,String airport1, String airport2,RedBlackBST<String, Airplane> airplaneST, RedBlackBST<String, Airport> airportST){
        if (!airplaneST.contains(airplaneCode) || !airportST.contains(airport1) || !airportST.contains(airport2) || 
                !airportST.get(airport1).getAirlineST().contains(airplaneST.get(airplaneCode).getAirplaneCompany()) || 
                airport1.compareTo(airport2)==0){
            return false;
        }

        //Caso não exista a companhia aéria no aeroporto de chegada, adiciona-a!

        if (!airportST.get(airport2).getAirlineST().contains(airplaneST.get(airplaneCode).getAirplaneCompany())){
            airportST.get(airport2).getAirlineST().put(airplaneST.get(airplaneCode).getAirplaneCompany(), airportST.get(airport1).getAirlineST().get(airplaneST.get(airplaneCode).getAirplaneCompany()));
        }
        
        return true;
    }
    
    public static boolean moveAirplane(String airplaneCode,String airport1, String airport2,RedBlackBST<String, Airplane> airplaneST){
        if (airplaneST.get(airplaneCode).getAirportCode().compareTo(airport1)==0){
            airplaneST.get(airplaneCode).setAirportCode(airport2);
            if (airplaneST.get(airplaneCode).getAirportCode().compareTo(airport2)==0){
                return true;
            }
        }
        return false;
    }
    
    public static String flightsString(RedBlackBST<String, Airlink> tripST,RedBlackBST<Date, Flights> flightsST, String tripCode){
        String text="";
        Date aux = null;
        for (int i = 0; i<tripST.get(tripCode).getFlights().size();i++){
            aux=getDate(flightsST, tripST.get(tripCode).getFlights().get(i).toString());
            if (aux!=null){
                text=text+"Date: "+flightsST.get(aux).getFlightDate().toString()+
                    "  Partida: "+flightsST.get(aux).getLocalOfDeparture()+
                    "  Chegada: "+flightsST.get(aux).getLocalOfArrival()+"\n";
            }
        }
        return text;
    }
    
    public static String flightsVector(Vector flights, RedBlackBST<Date, Flights> flightsST){
        String flightCode;
        String text="";
        for (int i=0;i<flights.size();i++){
            text=text+"Date: "+flightsST.get(getDate(flightsST, flights.get(i).toString())).getFlightDate().toString()+
                    "  Partida: "+flightsST.get(getDate(flightsST, flights.get(i).toString())).getLocalOfDeparture()+
                    "  Chegada: "+flightsST.get(getDate(flightsST, flights.get(i).toString())).getLocalOfArrival()+"\n";
        }
        return text;
    }
    
    public static String flightInfo(Date flightsDate, RedBlackBST<Date, Flights> flightsST){
        return "Date: "+flightsST.get(flightsDate).getFlightDate().toString()+
                    "\nPartida: "+flightsST.get(flightsDate).getLocalOfDeparture()+
                    "\nChegada: "+flightsST.get(flightsDate).getLocalOfArrival();
    }
    
    public static Date getDate(RedBlackBST<Date, Flights> flightsST,String dateString){
        for (Date aux : flightsST.inOrder()){
            if (aux.toString().compareTo(dateString)==0){
                return aux;
            }
        }
        return null;
    }
    
    public static Vector createComboBox(String airportCode,RedBlackBST<String, Airport> airportST){
        Vector<String> aux = new Vector<>();
        for (Date date : airportST.get(airportCode).getFlightsST().inOrder()){
            if (airportST.get(airportCode).getFlightsST().get(date).getLocalOfDeparture().compareTo(airportCode)==0){
                aux.addElement(date.toString());
            }
        }
        return aux;
    }
    
    public static String getArrivalAirport(String flightDate,RedBlackBST<Date, Flights> flightsST){
        return flightsST.get(getDate(flightsST, flightDate)).getLocalOfArrival();
    }
    
    
}
*/
