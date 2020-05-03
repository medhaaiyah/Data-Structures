import java.io.*;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        //This buffered reader will call the name of the txt file with the ISBN

        BufferedReader inFile = new BufferedReader(new FileReader("Books.txt"));

        //These are the variables that are used for the AVL tree

        AVLTree tree = new AVLTree();
        String line;

        //This is going to read each line in the file and insert a particular node to determine the inbalance

        System.out.println("Determining inbalance:");

        while ((line = inFile.readLine()) != null)
        {
            String values[] = line.split(" ");
            Book book = new Book(values[1],values[2]);
            tree.insert(values[0], book);
        }

        //Close the buffered Reader

        inFile.close();

        //This is the when it prints out the ISBN numbers in order after all the balances

        System.out.println("\nOuput of results (In-order traversal): ");
        tree.inorder();
    }
}
