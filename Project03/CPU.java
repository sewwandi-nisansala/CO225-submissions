import java.io.*;
import java.util.Scanner;

public class CPU {

    public static void main(String args[]) {
        String fileName = "ins.txt";
        Scanner inputFile;
        String lineData = "";
        try {
            // Scan file to input file
            inputFile = new Scanner(new File(fileName));

            //This is the Ram of our PC
            RegisterFile ram = new RegisterFile();

            // Check file data has a next line
            while (inputFile.hasNextLine()) {

                // Get a line data
                lineData = inputFile.nextLine();

                int instruciton[] = new int[32];
                //Read the line data 1 by 1
                for (int i = 0; i < lineData.length(); i++) {
                    // get the ith bit of the line as an integer (1 or 0)
                    int value = Integer.parseInt(String.valueOf(lineData.charAt(i)));
                    instruciton[i] = value;
                    //Print that value
                    System.out.print(value);
                }
                System.out.println();

                InstructionMemory.findInstructionType(ram,instruciton);

                //Print an empty line
                System.out.println("\n");
            }
        } catch (IOException iox) {
            System.out.println("Problem reading with " + fileName);
        }
    }


}
