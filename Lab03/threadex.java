Here i will show how to multiply two matrices using two threads. The work is fairly divided among the two threads with the help of a for loop and conditional operator.


public class MMM {

 
 public static void main(String args[]) {

  int matrixOne[][] = { { 5, 6, 7, 33 }, { 5, 6, 7, 32 },
    { 5, 6, 7, 321 }, { 8, 9, 10, 3 }, { 88, 77, 66, -9 } };

  int matrixTwo[][] = { { 1, 4, 7, 66 }, { 2, 5, 8, 54 },
    { 3, 6, 9, 55 }, { 3, 6, 9, 55 } };

  Matrix result = calculate(matrixOne,matrixTwo);
  
  printMatrix(result);

 }
 
 public static void printMatrix(Matrix result){
 
  for (int i = 0; i < result.matrixValues.length; i++) {
   System.out.println(" ");
   for (int outer = 0; outer < result.matrixValues[0].length; outer++) {
    System.out.print(" " + result.matrixValues[i][outer]);
   }
  }
  
  
 }
 
 public static Matrix calculate(int matrixOne[][],int matrixTwo[][]){

  Matrix m1 = new Matrix(matrixOne);
  Matrix m2 = new Matrix(matrixTwo);
   
  Matrix m3 = MatrixCreator.getMatrix(m1, m2);
  
  Matrixthread mt[] = new Matrixthread[2];

  for (int i = 0; i < 2; i++) {
   mt[i] = new Matrixthread(m1,m2,m3);
   mt[i].setName(Integer.toString(i));
  }

  for (int i = 0; i < mt.length; i++) {
   mt[i].start();
  }

  for (int i = 0; i < mt.length; i++) {
   try {
    mt[i].join();
   } catch (InterruptedException e) {
    e.printStackTrace();
   }
  }

  return m3;
 }
}

class Matrix {

 int matrixValues[][];

 Matrix(int matrixValues[][]) {
  this.matrixValues = matrixValues;
 }
}

class MatrixCreator {

 public static Matrix getMatrix(Matrix m1, Matrix m2) {

  int matrixThree[][] = new int[m1.matrixValues.length][m2.matrixValues[1].length];

  for (int i = 0; i < m1.matrixValues.length; i++) {

   for (int j = 0; j < m2.matrixValues[0].length; j++) {
    matrixThree[i][j] = 0;
   }
  }

  Matrix m3 = new Matrix(matrixThree);
  return m3;

 }
}

class Matrixthread extends Thread {

 int row = 0;

 int matrixOne[][];
 int matrixTwo[][];
 int matrixThree[][];

 Matrixthread(Matrix m1, Matrix m2,Matrix m3) {

  this.matrixOne = m1.matrixValues;
  this.matrixTwo = m2.matrixValues;
  this.matrixThree = m3.matrixValues;

 }

 public void run() {

  for (int matrixOneRow = (Thread.currentThread().getName().equals("1") ? 0
    : 1); matrixOneRow < this.matrixOne.length; matrixOneRow += 2) {

   for (int matrixTwoCol = 0; matrixTwoCol < this.matrixTwo[0].length; matrixTwoCol++) {

    for (int columns = 0; columns < this.matrixTwo.length; columns++) {

     this.matrixThree[matrixOneRow][matrixTwoCol] = this.matrixThree[matrixOneRow][matrixTwoCol]
       + this.matrixOne[matrixOneRow][columns]
       * this.matrixTwo[columns][matrixTwoCol];

    }

   }

  }

 }

}