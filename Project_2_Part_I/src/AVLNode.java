public class AVLNode
{
    //These are the global variables used to deal with a node
    String key;
    Book value;
    int height;

    //These pointers are used to parse through the left and the right portions of the tree

    AVLNode leftPointer;
    AVLNode rightPointer;

    //This is the constructor to initialize the node

    public AVLNode(String ISBN, Book book)
    {
        key = ISBN;
        leftPointer = null;
        rightPointer = null;
        value = book;
        height = 0;
    }
}
