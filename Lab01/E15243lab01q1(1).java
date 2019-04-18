//Lab 01 -task 01 -e15243
import java.util.Scanner;

public class E15243lab01q1 {
    public static void main(String args[]) {

        //defining the integer variable as number
        int num;

        //scanning number from keyboard
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter a number:");
        num = keyboard.nextInt();


        if (num % 15 == 0) {
            //checking for which satisfies special, big, weird,scary
            if ((num > 999) && (num % 5 == 0 && num % 6 == 0 && num % 18 != 0)) {
                System.out.println(num + " is special, big, weird, scary.");
            }
            //checking for which satisfies special, big,scary
            else if (num > 999) {
                System.out.println(num + " is special, big, scary, but not weird.");
            }
            //checking for which satisfies special, weird,scary
            else if (num % 5 == 0 && num % 6 == 0 && num % 18 != 0) {
                System.out.println(num + " is special, weird, scary, but not big.");
            }
            //checking for which satisfies special, but not scary
            else
                System.out.println(num + " is special but not scary.");

        } else {
            if (num > 999) {
                //checking for which satisfies big weird scary
                if (num % 5 == 0 && num % 6 == 0 && num % 18 != 0) {
                    System.out.println(num + " is big, weird, scary.");
                } else
                    //checking for which satisfies big and scary
                    System.out.println(num + " is big, scary but not weird.");

            }
            else {
                if (num % 5 == 0 && num % 6 == 0 && num % 18 != 0) {
                    //checking for which satisfies weird scary
                    System.out.println(num + "is weird, scary but not big.");
                } else
                    //checking for which satisfies  neither special, big, weird,scary
                    System.out.println(num + " is not special,not big,not weird,not scary.");
            }
        }
    }

}
