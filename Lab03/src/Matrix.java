public class Matrix extends Thread {


	private static int [][] a;
    private static int [][] b; 
    private static int [][] c;

    private  int z1;
    private int y;
    private int row;

	public Matrix(int[][] a, int [][]b,int [][]c,int row,int y,int z1) {
		this.a=a;
		this.b=b;
		this.c=c;

		this.row = row;
		this.y=y;
		this.z1=z1;

	}
	/*
	3) How to allocate work for each thread (recall it is the run function which all the threads execute)
	 The run() method will execute as if executed by a different CPU.
	 When the run() method executes it will loop the each thread.
	 */
	public void run() {
        int col, k, s;

        for (col = 0; col < y; col++) {
            for (s = 0, k = 0; k < z1; k++) {
                s += a[row][k] * b[k][col];
            }
            c[row][col] = s;
        }
    }


    public static int [][] multiply(int [][] a, int [][] b) {

	/* check if multipication can be done, if not 
	 * return null 
	 * allocate required memory 
	 * return a * b
	 */


        Matrix.a = a;
        Matrix.b = b;
        Matrix.c = c;
	int x = a.length; 
	int y = b[0].length; 

	int z1 = a[0].length; 
	int z2 = b.length; 

	if(z1 != z2) { 
	    System.out.println("Cannnot multiply");
	    return null;
	}

	int [][] c = new int [x][y]; 
	int i, j, k, s; 

	for(i=0; i<x; i++) 
	    for(j=0; j<y; j++) {
		for(s=0, k=0; k<z1; k++) 
		    s += a[i][k] * b[k][j];
		c[i][j] = s;
	    }
		/*
		1) How to use threads to parallelize the operation?
			In this operation a thread takes a block from A and B and multiply them,
			and then adds the result to the corresponding block in C. Since we have 3x3 matrix
			there are 3 parallel thread blocks are running
		 */

		/*
		3)How many threads to use?
		In this program I have used 3 threads since the thread is running row by row. Our mstrix is 3x3.
		Therefore there are three rows in the resultant. Then I have used three treads to finish the operation.
		 */

		//adding threads
		Matrix [] threads = new Matrix[x];

		for(i=0; i < x; i++) {
			threads[i] = new Matrix(a,b,c,i,y,z1);
			threads[i].start();
		}
		//joining threads
		for(i = 0; i < x; i++) {

            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

	return c; 
    }

}
/*
 4)How to synchronize?
  In our matrix operation code each thread passes a different array then no synchronization is needed,
  because the rest of the variables are local.
 */