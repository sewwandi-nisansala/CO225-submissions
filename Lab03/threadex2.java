import java.io.*;
02
import java.util.*;
03
 
04
/**
05
 *
06
 * @author Ryan Davis
07
 *
08
 * Multi Thread
09
 * This program will read a matrix from a data file, transpose it, and then
10
 * multiply them.  The program will output the time it took to multiply the
11
 * matrices.
12
 */
13
public class MatrixMultiThread {
14
 
15
    private static String file = "C:\\data1.txt";
16
    private static final int rows = getRows(file);
17
    private static final int columns = getColumns(file);
18
    private static int[] temp = new int[rows*columns];
19
    private static int[][] matrix = new int[rows][columns];
20
    private static int[][] transpose =  new int[columns][rows];

    private static int[][] result = new int[rows][rows];
22
    private static myThread[] threadPool;
23
 
24
    public static void main(String[] args){
        System.out.println("rows: " + rows);
        System.out.println("columns: " + columns);
        readFile(file);
        buildMatrices();
        multiply();

    }

    private static int getColumns(String f){...}
  private static int getRows(String f){...}
     private static void readFile(String f){...}
private static void buildMatrices(){...}

    /**
42
     * this method multiplies matrix and transpose together. the result matrix
43
     * is printed to the screen as well as the time in MS that it took to
44
     * perform the multiplication.  note: the time of printing to the screen is
45
     * not included - strictly the computation time.
46
     */

    private static void multiply(){
    threadPool = new myThread[rows]        
    long start = System.nanoTime();//computation begins
        for(int i=0; i<rows; i++){

            threadPool[i] = new myThread(i);
            threadPool[i].start();
            try{
            threadPool[i].join();
            }catch (InterruptedException e){

            //thread was interrupted
            }
        }
       long end = System.nanoTime();//computation ends
   double time = (end-start)/1000000.0;
              //print result matrix
       for(int i=0; i<rows; i++){
           for(int j=0; j<rows; j++){
               System.out.print(result[i][j] + " ");
           }
           System.out.println();
       }
       System.out.println();//blank line
       System.out.println("Multiplication took " + time + " milliseconds.");
    }
    private static class myThread extends Thread{
        int index;
        myThread(int index){
            this.index = index;
        }

        public void run(){
for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                result[index][i] += matrix[index][j] * transpose[j][i];
           }
       }
   }

    }
