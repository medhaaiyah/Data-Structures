public class AVLTree
{
    private AVLNode root;

    //This is the constructor of the AVL tree

    public AVLTree()
    {
        root = null;
    }

    //This is the insert function to insert a certain node based on the ISBN number

    public void insert(String isbn, Book book)
    {
        root = insert(isbn, book, root);
    }

    //This function is used to determine

    private int height(AVLNode t)
    {
        //This is what will happen when the node is empty

        if (t == null)
        {
            return -1;
        }

        //This is what will happen if there is a particular node

        else
        {
            return t.height;
        }
    }

    private int max(int left, int right)
    {
        //This is what will happen if the left node is greater than the right node

        if (left > right)
        {
            return left;
        }

        //This is what will happen if the right node is greater than the left node

        else
        {
            return right;
        }
    }

    private int compare(String s1, String s2)
    {
        //This is for loop is used to compare different strings

        for(int i = 0; i < s1.length(); i++)
        {
            if(s1.charAt(i)!='-')
            {
                //These if statements are used to compare the two strings and return a particular ISBN number

                if(s1.charAt(i) > s2.charAt(i))
                {
                    return 1;
                }
                else if (s2.charAt(i) > s1.charAt(i))
                {
                    return 0;
                }
            }
        }
        return 0;
    }

    private AVLNode insert(String isbn, Book book, AVLNode top)
    {
        //It will create a top if it does not already exist

        if (top == null)
        {
            top = new AVLNode(isbn, book);
        }

        //This is what will happen if the top exists

        else if (compare(top.key, isbn) == 1)
        {
            //We are creating a left pointer to insert the particular book and isbn

            top.leftPointer = insert(isbn, book, top.leftPointer);

            //These statement is used to determine the inbalance

            if (height(top.leftPointer) - height(top.rightPointer) == 2)
            {
                System.out.print("Imbalance occurred at inserting ISBN " + isbn);

                //This is showing that the imbalance is occuring left left

                if (compare(top.leftPointer.key, isbn) == 1)
                {
                    System.out.println("; fixed in Left Rotation");
                    top = rotateWithLeftChild(top );
                }

                //This is showing that the imbalance is occuring right left

                else
                {
                    System.out.println("; fixed in RightLeft Rotation");
                    top = doubleWithLeftChild(top);
                }
            }
        }
        else if (compare(top.key, isbn) == 0)
        {
            //This is going to analyze the imbalance dealing with the right pointer insertions in the tree

            top.rightPointer = insert(isbn, book, top.rightPointer);

            if (height(top.rightPointer) - height(top.leftPointer) == 2)
            {
                System.out.print("Imbalance occurred at inserting ISBN " + isbn);

                //This is showing that the imbalance is occuring right right

                if (compare(top.rightPointer.key, isbn) == 0)
                {
                    System.out.println("; fixed in Right Rotation");
                    top = rotateWithRightChild(top);
                }

                //This is showing that the imbalance is occuring left right

                else
                {
                    System.out.println("; fixed in LeftRight Rotation");
                    top = doubleWithRightChild(top);
                }
            }
        }

        //This is creating the variable height

        top.height = max(height(top.leftPointer), height(top.rightPointer)) + 1;
        return top;
    }

    private AVLNode rotateWithLeftChild(AVLNode k2)
    {
        //These are used to rotate once figuring out that it is a left right rotation

        AVLNode k1 = k2.leftPointer;
        k2.leftPointer = k1.rightPointer;
        k1.rightPointer = k2;

        //This is where the rotation occurs

        k2.height = max(height(k2.leftPointer), height(k2.rightPointer)) + 1;
        k1.height = max(height(k1.leftPointer), k2.height) + 1;

        return k1;
    }

    private AVLNode rotateWithRightChild(AVLNode k1)
    {
        //These are used to rotate once figuring out that it is a right left rotation

        AVLNode k2 = k1.rightPointer;
        k1.rightPointer = k2.leftPointer;
        k2.leftPointer = k1;

        //This is where the rotation occurs

        k1.height = max(height(k1.leftPointer), height(k1.rightPointer)) + 1;
        k2.height = max(height(k2.rightPointer), k1.height) + 1;

        return k2;
    }

    private AVLNode doubleWithLeftChild(AVLNode k3)
    {
        //These are used to rotate once figuring out that it is a left left rotation

        k3.leftPointer = rotateWithRightChild(k3.leftPointer);

        return rotateWithLeftChild(k3);
    }

    private AVLNode doubleWithRightChild(AVLNode k1)
    {
        //These are used to rotate once figuring out that it is a right right rotation

        k1.rightPointer = rotateWithLeftChild(k1.rightPointer);

        return rotateWithRightChild(k1);
    }


    public void inorder()
    {
        inorder(root);
    }

    //This is used to look at the tree once is dealt with all the imbalances and will print the tree in order

    private void inorder(AVLNode r)
    {
        if (r != null)
        {
            //Looking at the left side of tree

            inorder(r.leftPointer);

            System.out.print(r.key + " ");

            //Looking at the right side of the tree

            inorder(r.rightPointer);
        }
    }
}