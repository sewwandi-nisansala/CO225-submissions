import java.awt.*;

public class Julia extends Fractal {

    /**
     * Constent complex number
     */
    private Complex constComplex;

    /**
     * Julia plot constructor
     *
     * @param width                      width of image
     * @param height                     height of image
     * @param realConstComplexValue      Real value of constent complex number
     * @param imaginaryConstComplexValue imaginary value on constent complex value
     * @param iterations                 number of iterations
     */
    public Julia(int width, int height, double realConstComplexValue, double imaginaryConstComplexValue, int iterations) {
        super(width, height, -1, 1, -1, 1, iterations);
        this.constComplex = new Complex(realConstComplexValue, imaginaryConstComplexValue);
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
        //Calculate Zo complex number
        Complex zComplex = getPointComplexPoint(x,y,1.4,1,0.8,0.8);

        // Get the color
        return getFractalColor(zComplex,constComplex);
    }
}
