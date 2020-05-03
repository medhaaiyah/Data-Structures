import java.util.ArrayList;

public class Heap<E extends Comparable<E>> {
    private ArrayList<Integer> list = new java.util.ArrayList<>();
    static int comparisons = 0;
    static int movements = 0;
    public Heap()
    {
    }

    public Heap(E[] objects)
    {
        for(int i = 0; i < objects.length; i++)
        {
            add((Integer) objects[i]);
        }
    }

    public void add(int newObject)
    {
        list.add(newObject);
        int currentIndex = list.size() - 1;

        while(currentIndex > 0)
        {
            comparisons++;
            int parentIndex = (currentIndex - 1) / 2;
            if(list.get(currentIndex).compareTo(list.get(parentIndex)) > 0)
            {
                Integer temp = list.get(currentIndex);
                list.set(currentIndex, list.get(parentIndex));
                list.set(parentIndex, temp);
                movements+=2;
            }
            else
            {
                break;
            }

            currentIndex = parentIndex;
        }
    }

    public Integer remove()
    {
        if(list.size() == 0)
        {
            return null;
        }
        Integer removedObject = list.get(0);
        list.set(0, list.get(list.size() - 1));
        list.remove(list.size() - 1);

        int currentIndex = 0;
        while(currentIndex < list.size())
        {
            comparisons++;
            int leftChildIndex = 2 * currentIndex + 1;
            int rightChildIndex = 2 * currentIndex + 2;

            if(leftChildIndex >= list.size())
            {
                comparisons++;
                break;
            }
            int maxIndex = leftChildIndex;
            if(rightChildIndex < list.size())
            {
                comparisons++;
                if(list.get(maxIndex).compareTo(list.get(rightChildIndex)) < 0)
                {
                    comparisons++;
                    maxIndex = rightChildIndex;
                }
            }

            if(list.get(currentIndex).compareTo(list.get(maxIndex)) < 0)
            {
                comparisons++;
                Integer temp = list.get(maxIndex);
                list.set(maxIndex, list.get(currentIndex));
                list.set(currentIndex, temp);
                currentIndex = maxIndex;
            }
            else
            {
                break;
            }
        }

        return removedObject;
    }
    public static void output(int[] list){
        System.out.println("Heapsort:  Movements >>> " + movements + " Comparisons >>> " + comparisons);
    }
}
