class Ball {
    private double x;//Ball position X coordinate
    private double y;//Ball position Y coordinate
    private double speed;//Ball Speed
    private double angleOfSpeedWithX;//Ball moving angle with X axis

    /*
      Ball object constructor

      x                 X position coordinate
      y                 Y position coordinate
      speed             ball speed
      angleOfSpeedWithX ball moving direction angle with X axis
     */

    public Ball(double x, double y, double speed, double angleOfSpeedWithX) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.angleOfSpeedWithX = angleOfSpeedWithX;
    }

    /*
     * Update the position after given time period
       time shift
     */
    public void updateTime(double time) {
        x += time * speed * Math.cos(angleOfSpeedWithX);
        y += time * speed * Math.sin(angleOfSpeedWithX);

    }

    /*
     * is ball1 collied with this ball?
     *
     * b1 ball1
     * return collied or not
     */
    public boolean willCollide(Ball b1) {
        return b1.getX() == x & b1.getY() == y;
    }

    /*
     * Get current position X coordinate
     *
     * return X coordinate value
     */
    public double getX() {
        return x;
    }

    /*
     * Get current position Y coordinate
     *
     * return Y coordinate value
     */
    public double getY() {
        return y;
    }
}


public class E15243Ball {
    public static void main(String[] args) {

        //create ball b1
        Ball b1 = new Ball(0.0, 1.0, 10.0, 45);
        //update time by +5
        b1.updateTime(5.0);

        //create ball 2
        Ball b2 = new Ball(0.0, 1.0, 20.0, 45);
        //update time by +5
        b1.updateTime(5.0);
        b2.updateTime(5.0);

        //Check ball 1,2 are collide or not
        if (b1.willCollide(b2)) {
            System.out.println("B1 and B2 will colide");
        } else {
            System.out.println("B1 and B2 won't collide");
        }

        //create ball3
        Ball b3 = new Ball(10.0, 5.0, 3.0, 30);
        //update time by +20
        b1.updateTime(20);
        b2.updateTime(20);
        b3.updateTime(20);

        //Check ball 2 & 3 are collide or not
        if(b2.willCollide(b3)) {
            System.out.println("B2 and B3 will collide");
        }else{
            System.out.println("B2 and B3 won't collide");
        }
    }
}
