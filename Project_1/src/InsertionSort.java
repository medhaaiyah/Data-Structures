public class InsertionSort {
    public static InsertionSort insertionSort(int [] list)
    {
        int movements = 0;
        int comparison = 0;
        for(int i = 1; i < list.length; i++)
        {
            int currentElement = list[i];
            int k;
            comparison++;
            for(k = i -1; k >= 0 && list[k] > currentElement; k--)
            {
                movements++;
                list[k + 1] = list[k];
            }
            list[k + 1] = currentElement;
        }
        System.out.println("InsertionSort: Movements >>> " + movements + " Comparisons >>> " + comparison);
        return null;
    }
}
