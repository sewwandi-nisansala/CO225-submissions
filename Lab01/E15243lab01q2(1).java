//Lab 01 task 02 e15243

import java.util.Scanner;
public class E15243lab01q2 {
    public static void main(String args[]) {

        //defining variable for values of red,green and blue colors
        int red,green,blue;

        //scanning input from keyboard
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter the color: ");
        red = keyboard.nextInt();
        green = keyboard.nextInt();
        blue = keyboard.nextInt();

        //defining variables for complement of red,green and blue colors
        int red_complement ,green_complement,blue_complement;

        //calculating the value of complement colors
        red_complement = 255 - red;
        blue_complement = 255 - blue;
        green_complement = 255 - green;



        int red_diff = red_complement - red;//difference of red complement and red value color
        int blue_diff = blue_complement - blue;//difference of blue complement and blue value color
        int green_diff = green_complement - green;//difference of green complement and green value color

        //calculating absolute values of red_diff, blue_diff and green_diff
        if(red_diff <0){
            red_diff = -1 * (red_diff);
        }

        if(blue_diff <0) {
            blue_diff = -1 * (blue_diff);
        }

        if(green_diff <0){
            green_diff = -1 * (green_diff);
        }

        //alternate complement for grey color code
        if((red_diff) <=32 && (blue_diff) <=32 && (green_diff) <=32) {
            //checking whether red complement is in 0-255
            if (red + 128 <= 255) {
                red_complement = red + 128;
            } else
                red_complement = red - 128;

            //checking whether blue complement is in 0-255
            if (blue + 128 <= 255) {
                blue_complement = blue + 128;
            } else
                blue_complement = blue - 128;


            //checking whether green complement is in 0-255
            if (green + 128 <= 255) {
                green_complement = green + 128;
            } else
                green_complement = green - 128;
        }

        System.out.printf("The complement: %d %d %d%n", red_complement, green_complement, blue_complement);
    }
}
