
import java.io.*;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

public class Main
{
    public static void main(String[] args)
    {

        int arraySize = 5000;

        //This is the initialization of the four arrays we are going to use to compare the sorts

        //int[] inOrder = new int[arraySize];
        //int[] reverseOrder = new int[arraySize];
        int[] almostOrder = new int[arraySize];
        //int[] randomOrder = new int[arraySize];

        int random = -1;
        //This is storing the random contents in the array

        for(int i = 0; i < arraySize; i++)
        {
            random = (int)(Math.random() * 50 + 1);
            //inOrder[i] = random;
            //reverseOrder[i] = random;
            almostOrder[i] = random;
            //randomOrder[i] = random; //For random order array
        }

        //Arrays.sort(inOrder); //For in-order array
        //Arrays.sort(almostOrder, 0, arraySize * (int)0.8); //For almost order 80%
        Arrays.sort(almostOrder, 0, arraySize * (int)0.2); //For almost order 20%
        //for(int i = arraySize - 1, j = 0; i >= 0; i--, j++) {
            //reverseOrder[j] = inOrder[i]; //For reverse order array
        //}
        Long start = System.currentTimeMillis();
        //System.out.println("Current time before sort: " + System.currentTimeMillis());

        //This is calling the appropriate insertion sorts

        InsertionSort.insertionSort(almostOrder);
        //InsertionSort.insertionSort(reverseOrder);
        //InsertionSort.insertionSort(inOrder);
        //InsertionSort.insertionSort(randomOrder);

        //SelectionSort.selectionSort(almostOrder);
        //SelectionSort.selectionSort(reverseOrder);
        //SelectionSort.selectionSort(inOrder);
        //SelectionSort.selectionSort(randomOrder);

        //QuickSort.quickSort(almostOrder);
        //QuickSort.quickSort(reverseOrder);
        //QuickSort.quickSort(inOrder);
        //QuickSort.quickSort(randomOrder);

        //MergeSort.mergeSort(almostOrder);
        //MergeSort.mergeSort(reverseOrder);
        //MergeSort.mergeSort(inOrder);
        //MergeSort.mergeSort(randomOrder);

        //HeapSort.heapSort(almostOrder);
        //HeapSort.heapSort(reverseOrder);
        //HeapSort.heapSort(inOrder);
        //HeapSort.heapSort(randomOrder);

        //Radix.radixsort(almostOrder, arraySize);
        //Radix.radixsort(reverseOrder, arraySize);
        //Radix.radixsort(inOrder, arraySize);
        //Radix.radixsort(randomOrder, arraySize);

        //System.out.println("Current time after sort: " + System.currentTimeMillis());
        Long end = System.currentTimeMillis();

        //This will print out the number of comparisons and movements
        System.out.println("Duration: " + (end - start));

    }
}

