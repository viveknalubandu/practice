package sorting;

/**
 * Created by vnalubandu on 5/23/18.
 */
public class BubbleSort {

    // 7 8 9 1 2 3


    /**
     * Bubble sort
     * i iteration
     * 1 8 9 7 2 3
     * 1 2 9 7 8 3
     * 1 2 3 7 8 9
     * @param arry
     */

    public void sort(int[] arry){
        for(int i=0;i<arry.length-1;i++){
            for(int j=0;j<arry.length-i-1;j++){
                if(arry[j]>arry[j+1]){
                    int temp = arry[j];
                    arry[j]=arry[j+1];
                    arry[j+1]=temp;
                }
            }
        }
    }

    public static void main(String[] args){
        int arr[] = {64,25,12,22,11};

        BubbleSort bbst = new BubbleSort();

        SelectionSort ssrt = new SelectionSort();
        System.out.println("Before Sort");
        ssrt.printArray(arr);
        bbst.sort(arr);
        System.out.println("After Sort");
        ssrt.printArray(arr);
    }
}
