package sorting;


/**
 * Created by vnalubandu on 5/23/18.
 */
public class SelectionSort {
    /**
     * finding the minimum element (considering ascending order) from unsorted part and putting it at the beginning
     * @param arry
     * @param
     */

    public  void sort(int arry[]){
        int min_index;
        int n = arry.length;

        for(int i=0;i<n;i++){
            min_index=i;
            for(int j =i+1;j<n;j++){
                if(arry[j]<arry[min_index]){
                    min_index = j;
                }
            }
            System.out.println("Swapping Elements " + arry[i]+ "   with   " + arry[min_index]);
            int temp = arry[min_index];
            arry[min_index] = arry[i];
            arry[i] = temp;
        }

    }

    public void printArray(int arry[]){
        for(int i=0;i<arry.length;i++){
            System.out.println("Element in Array  " + arry[i]);
        }
    }

    public static void main(String[] args){
        int arr[] = {64,25,12,22,11};

        SelectionSort ssrt = new SelectionSort();
        ssrt.printArray(arr);
        ssrt.sort(arr);
        ssrt.printArray(arr);
    }
}
