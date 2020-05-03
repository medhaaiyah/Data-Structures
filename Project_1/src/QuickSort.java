public class QuickSort {
    public static int comparisons = 0;
    public static int movements = 0;
    public static void quickSort(int[] list)
    {
        quickSort(list, 0, list.length - 1);
        System.out.println("QuickSort: movements >> " + movements + " comparisons >> " + comparisons);
    }
    public static void quickSort(int[] list, int first, int last)
    {
        if(last > first)
        {
            int pivotIndex = partition(list, first, last);
            quickSort(list, first, pivotIndex -1);
            quickSort(list, pivotIndex + 1, last);
            comparisons++;
        }
    }
    public static int partition(int[] list, int first, int last)
    {
        int pivot = list[first];
        int low = first + 1;
        int high = last;

        while(high > low)
        {
            while(low <= high && list[low] <= pivot)
            {
                low++;
                comparisons++;
            }
            while(low <= high && list[high] > pivot)
            {
                high--;
                comparisons++;
            }
            if(high > low)
            {
                int temp = list[high];
                list[high] = list[low];
                list[low] = temp;
                comparisons++;
                movements+=2;
            }
        }

        while(high > first && list[high] >= pivot)
        {
            high--;
            comparisons++;
        }

        if(pivot > list[high])
        {
            list[first] = list[high];
            list[high] = pivot;
            comparisons++;
            movements+=2;
            return high;
        }
        else
        {
            return first;
        }
    }
}
