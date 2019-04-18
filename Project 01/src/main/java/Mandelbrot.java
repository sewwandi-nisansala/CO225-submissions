import java.awt.*;

public class Mandelbrot extends Fractal {

    /**
     * Mandelbrot consturctor
     *
     * @param width      image width
     * @param height     image height
     * @param minRe      minimum real number
     * @param maxRe      maximum real number
     * @param minIm      minimum imaginary number
     * @param maxIm      maximum imaginary number
     * @param iterations number of iterations
     */
    public Mandelbrot(int width, int height, double minRe, double maxRe, double minIm, double maxIm, int iterations) {
        super(width, height, minRe, maxRe, minIm, maxIm, iterations);
    }

    /**
     * Set color on selected coordinate
     *
     * @param x xCoordinate
     * @param y yCoordinate
     * @return color of the coordinate acording it is a Mandelbrot point or not
     */
    @Override
    Color setPointColor(int x, int y) {
        //First calculate Complex number "C" for given x,y coordinates
        Complex cComplex = getPointComplexPoint(x, y,1.5,1,1,1);

        //Create the Z complex number. (Z = 0)
        Complex zComplex = new Complex(0, 0);

        //Get the color
        return getFractalColor(zComplex,cComplex);
    }
}
