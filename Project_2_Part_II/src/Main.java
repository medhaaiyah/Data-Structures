import java.util.*;
import java.io.*;

public class Main
{
    public static void main(String[] args)
    {
        //This used to create the random integer numbers

        Random rand = new Random();
        int num = rand.nextInt(50);

        Node root = new Node(num);

        //This is the array to store the numbers and it has a max size of 50 elements

        int array[] = new int[50];
        array[num] = 1;

        //This for loop is going to insert 27 randomly generated keys

        for (int i = 0; i < 27; i++)
        {
            while (true)
            {
                //This is used to generate a random number

                num = rand.nextInt(50);
                if (array[num] == 0)
                {
                    array[num] = 1;
                    break;
                }

            }

            //This is used to insert the node

            Node.insert(root, num);

            System.out.println("Properties for " + (i+1) + " element:");

            //Checking to see if it is following the BST order property

            if (Node.checkBSTOrder(root)) {

                System.out.println("It is following BST order property.");

            }
            else {

                System.out.println("It is not following BST order property.");

            }

            Height height = new Height();

            //Checking to see if it is following the AVL balance condition

            if (Height.checkAVLProperty(root, height)) {

                System.out.println("It is following AVL balance condition.");

            }
            else {

                System.out.println("It is not following AVL balance condition.");

            }

            System.out.println();
        }
    }
}
