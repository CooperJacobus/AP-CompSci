public class Array2DExercises {
    // returns the maximum value in the 2d parameter array 
    public static int max(int[][] a){
        int max = a[0][0];
        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < a[i].length; j++){
                max = Math.max(max,a[i][j]);
            }   
        }
        return max;
    }

    // returns the sum of the elements in row r of a. 
    public static int rowSum(int[][] a, int r){
        int sum = 0;
        for(int i = 0; i < a[r].length; i++){
            sum += a[r][i];
        }
        return sum;
    }

    // returns the sum of the elements in column c of a (careful with rows of different lengths!).
    public static int columnSum(int[][] a, int c){
        int sum = 0;
        for(int i = 0; i < a.length; i++){
            if(a[i].length > c)
                sum += a[i][c];    
        }
        return sum;
    }

    // calculates the row sum for every row and returns each of the values in an array. 
    // index i of the return array contains the sum of elements in row i.
    public static int[] allRowSums(int[][] a){
        int[] sums = new int[a.length];
        for(int i = 0; i < a.length; i++){
            sums[i] = rowSum(a, i);
        }
        return sums;
    }
        
    // checks if the array is row-magic (this means that every row has the same row sum).
    public static boolean isRowMagic(int[][] a){
        boolean magic = true;
        int firstSum = rowSum(a, 0);
        for(int i = 1; i < a.length; i++){
            magic = (rowSum(a, i) == firstSum) ? magic : false;
        }
        return magic;
    }

    // checks if the array is column-magic (this means that every column has the same column sum).
    public static boolean isColumnMagic(int[][] a){
        boolean magic = true;
        int firstSum = columnSum(a, 0);
        for(int i = 1; i < a.length; i++){
            magic = (columnSum(a, i) == firstSum) ? magic : false;
        }
        return magic;
    }
    
    // checks if the array is square (i.e. every row has the same length as a itself).
    public static boolean isSquare(int[][] a){
        boolean square = true;
        for(int i = 0; i < a.length; i++){
            square = (a.length == a[i].length) ? square : false;
        }
        return false;
    }

    // checks if the array is a magic square. This means that it must be square, 
    // and that all row sums, all column sums, and the two diagonal-sums must all be equal.
    public static boolean isMagic(int[][] a){
        return isSquare(a) && isColumnMagic(a) && isRowMagic(a);
    }

    // checks to see if the array is a Latin square. This means that it must be square 
    // (suppose it is n x n), and that each row and each column must contain the values 
    // 1, 2, ..., n with no repeats.
    // Some helper methods you may need for this method and the next are suggested in
    // the tester code. Uncomment and run these tests if you implement these helper methods.
    public static boolean isLatin(int[][] a){
        if(isSquare(a) == true){
            boolean latin = true;
            for(int i = 0; i < a.length; i++){
                int[] instances = new int[a[i].length];
                for(int j = 0; j < a[i].length; j++){
                    if(a[i][j] -1 < instances.length)
                        instances[a[i][j] -1]++;
                }
                for(int k = 0; k < instances.length; i++){
                    latin = (instances[k] == 1) ? latin : false;
                }
            }
            
            for(int i = 0; i < a[0].length; i++){
                int[] instances = new int[a[i].length];
                for(int j = 0; j < a.length; j++){
                    if(a[j][i] -1 < instances.length)
                        instances[a[j][i] -1]++;
                }
                for(int k = 0; k < instances.length; k++){
                    latin = (instances[k] == 1) ? latin : false;
                }
            }
            
            return latin;
        }

        else{
        return false;
        }
    }

    // checks to see if the array is square (suppose it is n x n), and contains each 
    // of the digits from 1 to n^2, eg. 1, 2, ..., 16 for a 4 x 4 array.
    public static boolean isSequence(int[][] a){
        if(isSquare(a) == true){
            int[] instances = new int[a.length*a[0].length];
            boolean sequence = true;
            for(int i = 0; i < a.length; i++){
               for(int j = 0; j < a[i].length; j++){
                   if(a[i][j] -1 < instances.length)
                        instances[a[i][j] -1]++;
               }
            }
            
            for(int k = 0; k < instances.length; k++){
                sequence = (instances[k] == 1) ? sequence : false;
            }
            
            return sequence;
        }
        else
            return false;
    }

 
}