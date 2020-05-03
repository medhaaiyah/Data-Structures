import java.util.*;
import java.io.*;

public class Node {

    //These are the global variables for this class

    int key;
    Node left, right;

    //This is the constructor and initializing the variables

    public Node(int key)
    {
        this.key = key;
        left = null;
        right = null;
    }

    public static void insert(Node root, int key)
    {
        //This is going to create a random number
        Random rand = new Random();
        int num = rand.nextInt(2);

        //This is what will happen when the number is 0

        if (num == 0) {
            if (root.left != null) {
                insert(root.left, key);
                return;
            }
            else {
                Node temp = new Node(key);
                root.left = temp;
                return;
            }
        }

        //This is what will happen if the number is not zero

        else {
            if (root.right != null) {
                insert(root.right, key);
                return;
            }
            else {
                Node temp = new Node(key);
                root.right = temp;
                return;
            }
        }
    }

    //This is used to check whether or not it is in BST order property

    static boolean checkBSTOrder(Node root)
    {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    //This is used to determine the value of whether or not it is in BST order

    static boolean isBST(Node node, int min, int max)
    {
        //This is what will happen if the root does not exist
        if (node == null) {
            return true;
        }
        //This is what will happen if the there is the node
        if (node.key < min || node.key > max) {
            return false;
        }

        //It will determine the value from the left AND right side

        return (isBST(node.left, min, node.key - 1) && isBST(node.right, node.key + 1, max));
    }
}

