import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = {4,2,6,5,1,3};
        System.out.println("Not sorted: " + Arrays.toString(array));
        selectionSort(array);
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
}
