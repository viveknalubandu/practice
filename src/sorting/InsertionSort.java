package sorting;

/**
 * Created by vnalubandu on 5/23/18.
 */
public class InsertionSort {

    /**
     * // Sort an arr[] of size n
         insertionSort(arr, n)
         Loop from i = 1 to n-1.
         Pick element arr[i] and insert it into sorted sequence arr[0…i-1]
     * @param arry
     */
    public void sort(int arry[]){
        int n = arry.length;
        for(int i=1;i<arry.length;++i){
            int key = arry[i];
            int j= i-1;
            while (j>=0&&arry[j]>key){
                arry[j+1]=arry[j];
                j = j-1;
            }
            arry[j+1] = key;
            System.out.println("Element at position  "+i+"  is" + arry[i]);
        }
    }

    public void printArray(int arry[]){
        for(int i=0;i<arry.length;i++){
            System.out.println("Element in Array  " + arry[i]);
        }
    }

    public static void main(String[] args){
        int arr[] = {64,25,12,22,11};

        InsertionSort isrt = new InsertionSort();
        isrt.printArray(arr);
        isrt.sort(arr);
        isrt.printArray(arr);
    }
}
