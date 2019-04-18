class Main { 
    public static int [][] a = {{1, 1, 1},
								{1, 1, 1},
								{1, 1, 1}};
    
    public static int [][] b = {{1 },
								{1 },
								{1 }};


    public static void print_matrix(int [][] a) {
	for(int i=0; i < a.length; i++) {
	    for(int j=0; j< a[i].length; j++) 
		System.out.print(a[i][j] + " "); 
	    System.out.println();
	}
    }
    

    public static void main(String [] args) {

    	//final long startTime = System.nanoTime();

	int [][] x = Matrix.multiply(a, b); 
	print_matrix(x); // see if the multipication is correct

		//final long duration = System.nanoTime() - startTime;
      //  System.out.println("time" + duration/1000000);

    }
}