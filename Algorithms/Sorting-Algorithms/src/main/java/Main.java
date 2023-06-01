import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = {4,2,6,5,1,3};
        System.out.println("Not sorted: " + Arrays.toString(array));
        insertionSort(array);
        System.out.println("Sorted: " + Arrays.toString(array));
    }

    public static void bubbleSort(int[] array){
        for(int i = array.length - 1; i > 0; i--){
            for(int j = 0; j < i; j++){
                if(array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }

    public static void selectionSort(int[] array){
        for(int i = 0; i < array.length; i++){
            int minIndex = i;
            for(int j = i + 1; j < array.length; j++){
                if(array[minIndex] > array[j]){
                    minIndex = j;
                }
            }
            if(minIndex != i){
                int temp = array[minIndex];
                array[minIndex] = array[i];
                array[i] = temp;
            }
        }
    }

    public static void insertionSort(int[] array){
        for(int i = 1; i < array.length; i++){              //starting with the 2nd number and looking backwards
            int temp = array[i];                            //obtains a temp copy of current value at index (i)
            int j = i - 1;                                  //represents the location to start the comparison with the temp value (currently index i)

            while(j > -1 && temp < array[j]){               //j > -1 must be placed first in order to ensure an out of bounds exception does not occur
                array[j+1] = array[j];                      //we must use j+1 here because the location of the temp value we are comparing may no longer be at the original at index of i
                array[j] = temp;                          
                j--;
            }
        }
    }
}
