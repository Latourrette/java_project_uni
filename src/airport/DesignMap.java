
package airport;

import java.awt.image.BufferedImage;
import java.awt.*;
import static java.lang.Math.PI;
import static java.lang.Math.log;
import static java.lang.Math.tan;
import javax.swing.*;


public class DesignMap extends JPanel {
    public JLabel view;
    private BufferedImage surface;
    private int mapHeight;
    private int mapWidth;
    
    
    public DesignMap(int x, int y){
        this.mapWidth=x;
        this.mapHeight=y;
        surface = new BufferedImage(x,y,BufferedImage.OPAQUE);
        view = new JLabel(new ImageIcon(surface));
        Graphics g = surface.getGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0,0,x,y);
        g.dispose();
    }
    
    public void addNewAirport(Double x, Double y) {
        
        Graphics g = surface.getGraphics();
        g.setColor(Color.RED);
        g.fillOval(longitudeToX(x)+300, latitudeToY(y), 6, 6);
        g.drawOval(longitudeToX(x)+300, latitudeToY(y), 6, 6);
        g.dispose();
        view.repaint();
    }
    
    public void addNewConnection(Double x1, Double y1, Double x2, Double y2) {
        Graphics g = surface.getGraphics();
        g.setColor(Color.GREEN);
        g.drawLine(longitudeToX(x1)+300, latitudeToY(y1), longitudeToX(x2)+300, latitudeToY(y2));
        g.dispose();
        view.repaint();
    }
    
    public Integer longitudeToX(Double log){
        return (int)((log)*(mapWidth/360));
    }
    
    public Integer latitudeToY(Double lat){
        Double latRad = (lat*PI/180);
        Double mercN = log(tan((PI/4)+(latRad/2)));
        return (int) ((mapHeight/2)-(mapWidth*mercN/(2*PI)));
    }
    
    public void resetMap(){
        surface = new BufferedImage(mapWidth,mapHeight,BufferedImage.OPAQUE);
        view = new JLabel(new ImageIcon(surface));
        Graphics g = surface.getGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0,0,mapWidth,mapHeight);
        g.dispose();
    }
    
    public void addGraphConnection(String  airport1,String  airport2,RedBlackBST<String, Airport> airportST){
        addNewAirport(airportST.get(airport1).getXAxis(), airportST.get(airport1).getYAxis());
        addNewAirport(airportST.get(airport2).getXAxis(), airportST.get(airport2).getYAxis());
        addNewConnection(airportST.get(airport1).getXAxis(), airportST.get(airport1).getYAxis(), airportST.get(airport2).getXAxis(),
                airportST.get(airport2).getYAxis());
    }
}
