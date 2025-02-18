import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.nio.Buffer;
import java.util.HashMap;
import java.util.Map;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    HashMap<BufferedImage,Point> images = new HashMap<>();
    // Just a single image, TODO: Generalize

    BufferedImage volvoImage;
    BufferedImage saabImage;
    BufferedImage scaniaImage;
    BufferedImage volvoWorkshopImage;
    // To keep track of a single car's position
    Point volvoPoint = new Point();


    Point volvoWorkshopPoint = new Point(300,300);

    // TODO: Make this general for all cars
    void moveit(int x, int y, Car car){ // VAD GÖR VI MED CAR??
        for (Map.Entry<BufferedImage, Point> point : images.entrySet()){
            point.getValue().x = x;
            point.getValue().y = y;
        }
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        // Print an error message in case file is not found with a try/catch block
        try {
            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
            volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
            volvoWorkshopImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/VolvoBrand.jpg"));
            saabImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"));

        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
        images.put(volvoImage, volvoPoint);

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (HashMap.Entry<BufferedImage, Point> entry : images.entrySet())
            g.drawImage(entry.getKey(), entry.getValue().x, entry.getValue().y, null);
        // TODO: Make loop to paint all cars
        /*g.drawImage(volvoImage, volvoPoint.x, volvoPoint.y, null); // see javadoc for more info on the parameters
        g.drawImage(volvoWorkshopImage, volvoWorkshopPoint.x, volvoWorkshopPoint.y, null);*/
    }
}
