public class SelectionSort
{

    public static void selectionSort(int[] list)
    {
        int comparisons = 0;
        int movements = 0;
        for(int i = 0; i < list.length -1; i++)
        {
            int currentMin = list[i];
            int currentMinIndex = i;

            for(int j = i + 1; j < list.length; j++)
            {
                if(currentMin > list[j])
                {
                    comparisons++;
                    currentMin = list[j];
                    currentMinIndex = j;
                }
            }

            if(currentMinIndex != i)
            {
                comparisons++;
                movements+=2;
                list[currentMinIndex] = list[i];
                list[i] = currentMin;
            }
        }
        System.out.println("SelctionSort: movements >> " + movements + " comparisons >> " + comparisons);
    }
}
