package sorting;

/**
 * Created by vnalubandu on 5/23/18.
 */
public class QuickSort {

    public void quickSort(int[] array,int start,int end){
        if (array == null || array.length == 0)
            return;

        if (start >= end)
            return;
        int partitionIndex = partition(array,start,end);
        quickSort(array,start,partitionIndex-1);
        quickSort(array,partitionIndex,end);
    }

    public int partition(int[] arry, int start,int end){
        int index = start+(end-start)/2;
        int pivot = arry[index];

        while (start<=end){
            while (arry[start]<pivot){
                start++;
            }

            while (arry[end]>pivot){
                end--;
            }

            if(start<=end){
                System.out.println("Swapping Element  " + arry[start]+" and  " + arry[end]);
                int temp = arry[end];
                arry[end]=arry[start];
                arry[start]=temp;
                start++;
                end--;
            }
        }
        return start;
    }
    public static void main(String[] args){
        int arr[] = {64,32,1325,12,22,72,17,11};

        QuickSort qst = new QuickSort();
        SelectionSort ssrt = new SelectionSort();
        System.out.println("Before Sort");
        ssrt.printArray(arr);
        qst.quickSort(arr,0,arr.length-1);
        System.out.println("After Sort");
        ssrt.printArray(arr);
    }
}
