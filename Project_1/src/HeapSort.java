import java.sql.SQLOutput;

public class HeapSort {
    public static <E extends Comparable<E>> void heapSort(int[] list)
    {
        Heap<E> heap = new Heap<>();
        for(int i = 0; i < list.length; i++)
        {
            heap.add(list[i]);
        }
        for(int i = list.length - 1; i >= 0; i--)
        {
            list[i] = (int) heap.remove();
        }
        Heap.output(list);
    }
}
