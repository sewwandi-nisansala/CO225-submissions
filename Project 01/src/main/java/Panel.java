import java.awt.*;
import javax.swing.*;
import java.awt.geom.Line2D;

class Panel extends JPanel { // inherit JPanel

    /**
     * Width of frame
     */
    private int width;
    /**
     * Height of frame
     */
    private int height;

    /**
     *  plot object
     */
    private static Fractal fractal;

    /**
     * Constructor of Panel
     *
     * @param width  Width of frame
     * @param height height of frame
     */
    public Panel(int width, int height) {
        // set the panel size
        this.width = width;
        this.height = height;
        setPreferredSize(new Dimension(width, height));

    }

    /**
     * Method to color a point of the frame
     *
     * @param frame graphic frame
     * @param c     Color
     * @param p     coordinates of point, in Point format
     */
    private static void printPoint(Graphics2D frame, Color c, Point p) {
        frame.setColor(c);
        frame.draw(new Line2D.Double(p.getX(), p.getY(),
                p.getX(), p.getY()));
    }

    /**
     * Paint frame points
     *
     * @param g graphic plane
     */
    public void paintComponent(Graphics g) {
        // call paintComponent from parent class
        super.paintComponent(g);

        // Paint each points of the image
        for (int col = 0; col < this.height; col++) {
            for (int row = 0; row < this.width; row++) {
                printPoint((Graphics2D) g, fractal.setPointColor(col, row), new Point(col, row));
            }
        }

    }

    /**
     * This will run the main code
     *
     * @param args User arguments
     */
    public static void main(String[] args) {

        int height = 800;
        int width = 800;
        /*
         * If user arguments are correct, run the program
         */
        JFrame frame = null;
        //First create Mandelbrot plotting object
        //Check 1st argument
        if (args[0].equals("Mandelbrot")) {
            if (args.length < 5 || args.length > 6) {
                // Set default fractal object as Mandelbrot
                fractal = new Mandelbrot(width, height, -1, 1, -1, 1, 1000);
            } else if (args.length == 5) {
                // Set default iterations & user input bound
                fractal = new Mandelbrot(width, height, Double.valueOf(args[1]), Double.valueOf(args[2]), Double.valueOf(args[3]), Double.valueOf(args[4]), 1000);
            } else {
                // Set user input data
                fractal = new Mandelbrot(width, height, Double.valueOf(args[1]), Double.valueOf(args[2]), Double.valueOf(args[3]), Double.valueOf(args[4]), Integer.valueOf(args[5]));
            }
            // First argument is "Mandelbrot"
            frame = new JFrame("Mandelbrot Plot");

        } else if (args[0].equals("Julia")) {
            if (args.length < 3 || args.length > 4) {
                // Set default fractal object as Mandelbrot
                fractal = new Julia(width, height, -0.4, 0.6, 1000);
            } else if (args.length == 3) {
                // Set default iterations & user input bound
                fractal = new Julia(width, height, Double.valueOf(args[1]), Double.valueOf(args[2]), 1000);
            } else {
                // Set user input data
                fractal = new Julia(width, height, Double.valueOf(args[1]), Double.valueOf(args[2]), Integer.valueOf(args[3]));
            }
            // First argument is "Julia"
            frame = new JFrame("Julia Plot");
            // Set fractal object as "Julia"
            fractal = new Julia(width, height, -0.4, 0.6, 1000);
        } else {
            // First argument is wrong
            frame = new JFrame("Wrong Arguments entered");
        }
        // create a frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // set the content of the frame as one of this panel
        frame.setContentPane(new Panel(width, height));

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
