import java.awt.*;

public class Fractal {

    /**
     * width of image
     */
    private int width;

    /**
     * Height of image
     */
    private int height;

    /**
     * Minimum & maximum complex number
     */
    private Complex minComplex;
    private Complex maxComplex;

    /**
     * Factor complex number
     */
    private Complex factorComplex;

    /**
     * Number of iterations
     */
    private int iterations;

    /**
     * Fractal constructor
     *
     * @param width      width of image
     * @param height     height of image
     * @param minRe      minimum real value
     * @param maxRe      maximum real value
     * @param minIm      minimum imaginary value
     * @param maxIm      maximum imaginary value
     * @param iterations number of iterations
     */
    public Fractal(int width, int height, double minRe, double maxRe, double minIm, double maxIm, int iterations) {
        this.width = width;
        this.height = height;
        this.minComplex = new Complex(minRe, minIm);
        this.maxComplex = new Complex(maxRe, maxIm);
        this.iterations = iterations;
        setFactorComplexes();
    }

    /**
     * Set Factor complex numbers
     */
    public void setFactorComplexes() {
        //Factor the complex plane to frame size
        this.factorComplex = new Complex((this.maxComplex.getReX() - this.minComplex.getReX()) / (this.width),
                (this.maxComplex.getImY() - this.minComplex.getImY()) / (this.height));
    }

    /**
     * Get the complex number corresponding to the given point
     *
     * @param x     x coordinate
     * @param y     y coordinate
     * @param moveX move figure in x axis
     * @param moveY move figure in y axis
     * @param zoomX zoom X axis
     * @param zoomY zoom Y axis
     * @return Complex number to corresponding x y coordinates
     */
    public Complex getPointComplexPoint(int x, int y, double moveX, double moveY, double zoomX, double zoomY) {
        return new Complex((moveX * this.minComplex.getReX() + x * this.factorComplex.getReX()) / zoomX,
                (moveY * this.maxComplex.getImY() - y * this.factorComplex.getImY()) / zoomY);
    }

    /**
     * Set color on selected coordinate
     *
     * @param x xCoordinate
     * @param y yCoordinate
     * @return color of the coordinate according it is a Mandelbrot point or not
     * Throw illegalArgumentException throws if this has not implemented
     */
    Color setPointColor(int x, int y) {
        throw new IllegalArgumentException("Not Implement!");
    }

    /**
     * Calculate the Fractal & get the color
     *
     * @param zComplex Z complex number
     * @param cComplex C complex number
     * @return color of the point
     */
    public Color getFractalColor(Complex zComplex, Complex cComplex) {
        //Do the calculations until number of iterations
        for (int n = 0; n < iterations; ++n) {

            // ABS(Zn) > 2  => this means |Zn| > 4 mathematically
            // If ABS(Zn)>2; then the this is not a Mandelbrot number
            if (zComplex.getComplexModules() > 4) {
                if (n == 0) {
                    n = 1;
                }
                //This is Not a Fractal
                return Color.getHSBColor((float) n *10.0f/ (float) iterations, 1.0f, 1.0f);

            }
            // Do the calculation
            // Zn+1 = Zn^2 + C
            zComplex = zComplex.square().plus(cComplex);
        }

        //This is a Fractal
        return Color.BLACK;
    }
}
