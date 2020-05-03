public class MergeSort {
    /** The method for sorting the numbers */
    static int comparisons = 0;
    static int movements = 0;
    public static void mergeSort(int[] list) {
        if (list.length > 1) {
            comparisons++;
            // Merge sort the first half
            int[] firstHalf = new int[list.length / 2];
            System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
            mergeSort(firstHalf);

            // Merge sort the second half
            int secondHalfLength = list.length - list.length / 2;
            int[] secondHalf = new int[secondHalfLength];
            System.arraycopy(list, list.length / 2,
                    secondHalf, 0, secondHalfLength);
            mergeSort(secondHalf);

            // Merge firstHalf with secondHalf into list
            merge(firstHalf, secondHalf, list);
        }
        System.out.println("MergeSort: movements >>> " + movements + " comparisons >>> " + comparisons);
    }

    /** Merge two sorted lists */
    public static void merge(int[] list1, int[] list2, int[] temp) {
        int current1 = 0; // Current index in list1
        int current2 = 0; // Current index in list2
        int current3 = 0; // Current index in temp

        while (current1 < list1.length && current2 < list2.length) {
            if (list1[current1] < list2[current2]){
                comparisons++;
                movements++;
                temp[current3++] = list1[current1++];
            }
            else
            {
                comparisons++;
                movements++;
                temp[current3++] = list2[current2++];
            }

        }

        while (current1 < list1.length)
        {
            comparisons++;
            movements++;
            temp[current3++] = list1[current1++];
        }

        while (current2 < list2.length)
        {
            comparisons++;
            movements++;
            temp[current3++] = list2[current2++];
        }
    }
}
