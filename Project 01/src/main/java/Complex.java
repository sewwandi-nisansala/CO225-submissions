public class Complex {

    /**
     * Real part of Complex number
     */
    private double reX;

    /**
     * Imaginary part of Complex number
     */
    private double imY;

    /**
     * Complex number constructor
     *
     * @param reX Real part of Complex number
     * @param imY Imaginary part of Complex number
     */
    public Complex(double reX, double imY) {
        this.reX = reX;
        this.imY = imY;
    }

    /**
     * Get Imaginary value of Complex number
     *
     * @return Imaginary part of Complex number
     */
    public double getImY() {
        return imY;
    }

    /**
     * Get Real value of Complex number
     *
     * @return Real part of Complex number
     */
    public double getReX() {
        return reX;
    }

    /**
     * Get Square value of Modules of Complex number
     * Let Z = x+yi
     * |Z|^2 = x^2 + y^2
     *
     * @return Squre value of complex number
     */
    public double getComplexModules() {
        return this.reX * this.reX + this.imY * this.imY;
    }

    /**
     * Get the Square value of the complex number
     * Let Z = x + yi
     * Z^2 = (x+yi)^2 = x^2 - y^2 + 2xyi
     *
     * @return Square value of the complex number
     */
    public Complex square() {
        return new Complex(this.reX * this.reX - this.imY * this.imY, 2 * this.reX * this.imY);
    }

    /**
     * Add complex number to current complex number
     *
     * @param complex Adding complex number
     * @return new complex number after adding current complex number with new complex number
     */
    public Complex plus(Complex complex) {
        return new Complex(this.reX + complex.getReX(), this.imY + complex.getImY());
    }
}
