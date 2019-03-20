
/**
 * Write a description of class QuickSort here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class QuickSort{
    // instance variables - replace the example below with your own
    

    /**
     * Constructor for objects of class QuickSort
     */
    public static void QuickSort(int[] arr,int low,int high){
        if(low < high-1){
            int pIndex = partition(arr,low,high);
            QuickSort(arr,low,pIndex-1);
            QuickSort(arr,pIndex+1,high);
        }
    }

    public static int partition(int[] arr, int lowIndex, int highIndex){
        int partitionIndex = 0;
        int direction = 1;
        for(int i = lowIndex+1; i < highIndex; i+= direction){
            if((arr[i] > arr[partitionIndex] && i < partitionIndex) || (arr[i] < arr[partitionIndex] && i > partitionIndex)){
      
                int temp = arr[i];
                arr[i] = arr[partitionIndex];
                arr[partitionIndex] = temp;
      
                temp = i;
                i = partitionIndex;
                partitionIndex = temp;
      
                direction *= -1;
            }
            if(i==lowIndex){
                direction = 1;
            }   
        }
        print(arr);
        return partitionIndex;
        
    }
    
    private static void print(int[] arr){
        System.out.print("[");
        for (int i =0; i < arr.length-1; i++)
            System.out.print(arr[i] + ",");
        System.out.println(arr[arr.length-1] + "]");
    }    
    
    public static void main (String[] args){    
        int[] numbers = {3,1,4,5,9,2};
        int[] grades = {92,85,76,76,45,95,100,100,64,47,99};
        //selectionSort(numbers);
        //selectionSort(grades);
        QuickSort(numbers,0,numbers.length-1);
        QuickSort(grades, 0,numbers.length-1);
        print(numbers);
        print(grades);
                       
    }
}
