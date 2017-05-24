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


public class JframeAuxFunctions {





    



    
*
     * Verifica se a informação do voo está correta e retorna true ou false
     * @param airplaneST


    
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
