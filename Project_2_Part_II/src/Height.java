import java.util.*;
import java.io.*;

public class Height
{
    //This is the global variable for this class

    int height = 0;

    //This is used to determine the height of the binary tree

    static int height(Node node)
    {
        //This is used to return the height value

        if (node == null)
        {
            return 0;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }

    static boolean checkAVLProperty(Node root,Height height)
    {
        //This is what will happen if the root does not exist

        if (root == null)
        {
            height.height = 0;
            return true;
        }

        //These variables are used to determine the height on the right and left side

        Height lheight = new Height();
        Height rheight = new Height();

        //This is used to check the AVL properties from both sides

        boolean l = checkAVLProperty(root.left, lheight);
        boolean r = checkAVLProperty(root.right, rheight);
        int lh = lheight.height;
        int rh = rheight.height;

        //This is used to determine whether or not it is following the condition based on the height

        height.height = (lh > rh? lh: rh) + 1;

        //This is used to return either true or false

        if (Math.abs(lh - rh)>=2)
        {
            return false;
        }
        else
        {
            return l && r;
        }
    }
}
