import java.awt.*; // to create a custom panel + drawing area + other imports
import javax.swing.*; // contains important graphic and UI tools

public class MyPanel extends JPanel{ //containing from Swing to holdb buttons + labels + other panels
    private Polygon polygon; //creating an instance variable of Object type Polygon
    //Constructor
    public MyPanel(){
        this.setBackground(Color.WHITE); //setting background color of panel to white

        polygon = null; //initializing the polygon object

    }

    public void setPolygonSides(int sides){ // a method to set the number of sides of polygon
        int w = getWidth();
        int h = getHeight();

        int center_x = w/2; //calculating x_coordinate of center of panel
        int center_y = h/2; //calculating y_coordinate of center of panel

        //we want the polygon to appear in the middle of the panel
        //all vertices of the polygon will be equidistant from the center

        int radius = Math.min(w, h) / 2 - 10;
        //how far each point of the polygon will be from the center

        int x[] = new int[sides];
        int y[] = new int[sides];

        double angleIncrement = 2 * Math.PI / sides; //angle between each vertex

        for(int i = 0; i<sides; i++){
            double angle = i *angleIncrement - Math.PI / 2; //starting from the top vertex
            x[i] = center_x + (int)(radius * Math.cos(angle)); //calculating x coordinate of each vertex
            y[i] = center_y + (int)(radius * Math.sin(angle)); //calculating y coordinate of each vertex        
        }
        polygon = new Polygon(x, y, sides);   //creating and storing the Polygon object with calculated vertices
        repaint(); //requesting a repaint to update the panel with new polygon

    }
    @Override
    protected void paintComponent(Graphics g){ //overriding paintComponent method to draw the polygon
        super.paintComponent(g); //clear panel, background color, fresh drawing
        if(polygon == null){
            return; // if no polygon to draw, draw nothing
        }
        Graphics2D g2d = (Graphics2D) g; //casting Graphics object to Graphics2D for advanced features
        g2d.setColor(Color.BLUE); //setting drawing color to blue
        g2d.setStroke(new BasicStroke(3)); //setting stroke thickness to 3
        g2d.drawPolygon(polygon); //drawing the polygon on the panel
        }
    }
        /*polygon.reset();
        if (sides < 3) return;
        int width = getWidth();
        int height = getHeight();
        int radius = Math.max(10, Math.min(width, height) / 2 - 10);
        int cx = width / 2;
        int cy = height / 2;
        for (int i = 0; i < sides; i++) {
            double angle = 2 * Math.PI * i / sides - Math.PI / 2;
            int x = cx + (int) (radius * Math.cos(angle));
            int y = cy + (int) (radius * Math.sin(angle));
            polygon.addPoint(x, y);
        }
        repaint();
    }*/