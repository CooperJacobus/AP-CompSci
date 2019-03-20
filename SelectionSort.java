import java.util.*;

public class SelectionSort{
  
    public static void selectionSort(int[] arr){   
        int sortIndex = 0;
        while(sortIndex < arr.length){
            int unsortedMin = sortIndex;
            for(int i = sortIndex+1; i < arr.length; i++){
                unsortedMin = (arr[unsortedMin] > arr[i]) ? i : unsortedMin;
            }
            swap(arr, unsortedMin, sortIndex);
            sortIndex++;
        }
    }   
    
    // swap arr[i] with arr[j]
    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    private static void print(int[] arr){
        System.out.print("[");
        for (int i =0; i < arr.length-1; i++)
            System.out.print(arr[i] + ",");
        System.out.println(arr[arr.length-1] + "]");
    }    
    
    //tester code  
    public static void main (String[] args){    
        int[] numbers = {3,1,4,5,9,2};
        int[] grades = {92,85,76,76,45,95,100,100,64,47,99};
        selectionSort(numbers);
        selectionSort(grades);
        print(numbers);
        print(grades);
                       
    }
}
    
    
    
    