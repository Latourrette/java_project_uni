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
    private Image newimg;


    public DesignMap(int x, int y) {
        this.mapWidth = x;
        this.mapHeight = y;
        System.out.println(x + "   " + y);
        String imageName = ".//data/World-Map.jpg";
        ImageIcon icon = new ImageIcon(imageName);
        icon.getImage().flush();
        Image image = icon.getImage(); // transform it
        newimg = image.getScaledInstance(x, y, java.awt.Image.SCALE_SMOOTH);
        surface = convertToBufferedImage();
        view = new JLabel(new ImageIcon(surface));
        Graphics g = surface.getGraphics();
        g.dispose();
        view.repaint();
    }

    public void addNewAirport(Double x, Double y, String name) {

        Graphics g = surface.getGraphics();
        g.setColor(Color.GREEN);
        System.out.println(longitudeToX(x) + "  " + latitudeToY(y));
        g.fillOval(longitudeToX(x+5), latitudeToY(y-1), 4, 4);
        g.drawOval(longitudeToX(x+5), latitudeToY(y-1), 4, 4);
        g.drawString(name, longitudeToX(x+5) + 10, latitudeToY(y-1));
        g.dispose();
        view.repaint();
    }

    public void addNewConnection(Double x1, Double y1, Double x2, Double y2) {
        Graphics g = surface.getGraphics();
        g.setColor(Color.ORANGE);
        g.drawLine(longitudeToX(x1), latitudeToY(y1), longitudeToX(x2), latitudeToY(y2));
        g.dispose();
        view.repaint();
    }

    public Integer longitudeToX(Double log) {
        return (int) ((log) * (mapWidth / 360)) + 380;
    }

    public Integer latitudeToY(Double lat) {
        Double latRad = (lat * PI / 180);
        Double mercN = log(tan((PI / 4) + (latRad / 2)));
        return (int) ((mapHeight / 2) - (mapWidth * mercN / (2 * PI))) + 5;
    }

    public void resetMap() {
        surface = convertToBufferedImage();
        view = new JLabel(new ImageIcon(surface));
    }

    public void addGraphConnection(String airport1, String airport2, RedBlackBST<String, Airport> airportST) {
        addNewAirport(airportST.get(airport1).getxAxis(), airportST.get(airport1).getyAxis(), airportST.get(airport1).getCode());
        addNewAirport(airportST.get(airport2).getxAxis(), airportST.get(airport2).getyAxis(), airportST.get(airport1).getCode());
        addNewConnection(airportST.get(airport1).getxAxis(), airportST.get(airport1).getyAxis(), airportST.get(airport2).getxAxis(),
                airportST.get(airport2).getyAxis());
    }

    public BufferedImage convertToBufferedImage() {
        BufferedImage newImage = new BufferedImage(mapWidth, mapHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = newImage.createGraphics();
        g.drawImage(newimg, 0, 0, null);
        g.dispose();
        return newImage;
    }
}
