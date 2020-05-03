# Data-Structures

# Project 1:

Overview of Results:

//Will include a table

Sorting Analysis:

Note: I have been doing every sorting option one at a time and I have been commenting out portions of my code so I can analyze each type of sort for a particular array.

Insertion Sort:

In the insertion sort, the worst-case running time for this type of array is O(N^2) since it compares every element with the prior one. For an array that is implemented in order, it compares at a rate of N-1 therefore for an ordered array it is linear and has a running time of O(N). For a reverse Order array, the running time is O(N^2) because it realizes that the prior element will be greater than the current element most of the time. Therefore, in the table, the in-Order timing is faster than the reverse Order timing. The timings for the almost Orders’ and random will be in between the timings for the in-Order and the reverse Order because each element is less than half of the elements to the left. 

Selection Sort:

The first step for selection sort is to set the minimum location to an index of zero. From there, search for the minimum element in the list. After finding the minimum element, then swap the index value of location of the minimum element. Then increment the index by one and repeat the process until the implemented array is completely sorted. For this particular sort, the time it takes to swap the index position is O(1) but the worst-case running time it takes for this sort to occur is O(N^2). Since this type of sort requires very minimal movement, the timings between all four arrays are very similar.

Quick Sort:

In the quick sort array, the highest index value will be represented as the pivot. So, in this sort, you will take two variables that will act as pointers and will point to the left and right sides of the array. The left pointer will have a lower index and the right pointer will have a higher index. If the element at the left is less than the pivot, then it will move the value to the right and if the element at the right is greater than the pivot, it will move that element to the left. The process that is being followed through this sort is called partitioning. The worst-case running time complexity is O(N^2) since it is going through loops to analyze the values in certain spots. The average-running time complexity is O(log(N)) since it depends on the number of partitions that might occur. 

Merge Sort: 

The merge sort essentially divides the implemented array recursively into two subarrays until it cannot be divided. From there it will look at the particular list and merge each list back together until it creates the sorted array. The worst-case running time complexity is Nlog(N) + O(N) comparisons. This sort has a faster worst-case running time compared to the quick sort, selection sort, and insertion sort since it is using a dividing mechanism.

Heap Sort:

The heap sort uses the biggest element as the root of the heap which will eventually be replaced as the last element of the array. To order the implemented array in ascending order, max heaps will be implemented. The time complexity to heapify is O(logN) and the time complexity to build the heap is O(N). If we merge both of these steps to execute the heap sort, it will form a total of O(NlogN) for the worst-case running time complexity.

Radix Sort:

The radix sort is sorting algorithm that is specifically used to sort integers. It will sort the implemented array by first sorting by the least significant digit (the one’s place), then by the next digit (the ten’s place), and it keep on going. This is, in general, one of the most efficient algorithms as it has a overall worst-case time complexity of O(Nlog(N)). It is shown that the Radix sort is more efficient since you can see the stark difference of the results between the timings of the heap sort and those of the radix sort. Even though the radix sort is a subroutine to the count sort, it is a lot more efficient to the counting sort which has a worst-case time complexity of O(N^2).

# Project 2 Part I:

In this report, I created a file called Books.txt which includes the ISBN which is going to the be the key for the Node, the name of the book, and the last name of the author. In this report, I will go through the process that they ordered the following books and how they balanced the values by creating a balanced tree.
Below are the contents in my Books.txt file:
Books.txt 
978-0262033848 Empowerment in the STEM fields Aiyah
978-0980232776 How to make excellent Tic Toks Maruf
978-0812548051 How to give good advice Penupala
978-0812348099 How to efficiently communicate with your voice Sapre
978-0812451471 Ways to create an app Srikara
978-0812551488 The theory of Bharatanatyam Sivakumar

1.	Insert Empowerment in the STEM fields Aiyah (ISBN: 978-0262033848). This will be the root node of the AVL tree for now

2.	Next, insert How to make excellent Tic Toks Maruf (ISBN: 978-0980232776). Since AVL trees must follow the BST property, this will go to the right of Empowerment in the STEM fields. 

3.	Next, insert How to give good advice Penupala (ISBN: 978-0812548051). This will go to the right of How to make excellent Tic Toks Maruf. However, this violates the AVL property and requires a left-right rotation. 

4.	Next, insert How to efficiently communicate with your voice Sapre (ISBN: 978-0812348099). This book will go the right of Empowerment in the STEM fields Aiyah (ISBN: 978-0262033848)

5.	Next, insert Ways to create an app Srikara (ISBN: 978-0812451471). This book will go to the right of How to efficiently communicate with your voice Sapre (ISBN: 978-0812348099). This, however, violates the AVL property because the difference between the right and left subtrees of Empowerment in the STEM fields Aiyah is 2. Therefore, this requires a right-right rotation.

6.	Finally, insert The theory of Bharatanatyam Sivakumar (ISBN: 978-0812551488)

After creating the following AVL tree you can therefore display these results by printing out the traversal. In this situation I used the in-order traversal which looks at the left node, then the center, and then the right node. These results match my answer that I got through my program. 

These are the results below:

Part of output from console: 
978-0262033848 (Aiyah), 978-0812348099 (Sapre), 978-0812451471 (Srikara), 978-0812548051 (Penupala), 978-0812551488 (Sivakumar), 978-0980232776 (Maruf)

# Project 2 Part II:

In this portion of the project, I had to generate a random binary tree to determine whether the BST order property is being applied and the AVL balance condition is being followed for each number that is being inserted in the tree. The BST order property follows this guideline: for every parent and left and right child pair, the right child must be greater than the parent and the left child should be less than the parent. The AVL balance condition follows this guideline: the difference between subtree heights should be no more than one. In this project, I first randomly generated an array that can hold 50 values. From that array I generated a binary tree that inserts 27 nodes from the randomly generated array. Since the node values of the tree is randomized, the BST order property and the AVL balance condition will vary for each node for every single run. Since there is a variance of the output content for every run, one will have to assume that the randomly generated number does indeed follow the certain condition while being inserted in. 

# Project 3:

In this report, I would like to discuss the process that I took for this project. In this project, I printed out the three most efficient paths for the requested paths. If a particular flight plan was not able to work, it will print out an error message. In order to understand the flights, I will like to first show the contents of both of my input files that I incorporated in project.
Below are the contents in my FlightData.txt file:

FlightData.txt 
7
Dallas|Austin|98|47
Austin|Houston|95|39
Dallas|Houston|101|51
Austin|Chicago|144|192
Chicago|Austin|155|200
Austin|Dallas|100|50
Houston|Dallas|100|50

Below are the contents in my RequestedFlightData.txt file:

RequestedFlightData.txt
2
Dallas|Houston|T
Chicago|Dallas|C

Now that we have taken a look at the input files I would like to describe the strategy I used to get the output with the right paths.

I first created a class called FlightData which will store the city, cost, and time of a particular flight and whether or not it is found. I also created another class called Path which will use the information that we received in FlightData and called appropriate functions that will get the appropriate time and cost for an appropriate path. The Path class also has a function called print which will print the time and cost that is calculated in this class. These constructors and functions created FlightData and Path classes will be called in the FlightPlanner class which consists of the main() function which is needed to run our code.

Since we created two classes to receive the appropriate information, now its delve into the functionality of the FlightPlanner class. The first function that is called in the class is the find() to make sure that we are able to find the first city is equal to what is in the requested flight data. The next function is the resetFound(). It will essentially reset it so it can look at the next flight and print out the appropriate content. Finally, the next function that will piece it all together is the main function. This main function is used to open the two input files and parse through it. After figuring out the what are the requested flight, it will implement the Dijkstra's algorithm to find the most efficient top three paths. This algorithm will find the shortest paths between nodes in a graph. Once we do that, we print out the paths appropriately by looking at the particular flight.

These are the results below:

Output generated from the Output.txt file: 
Flight 1: Dallas, Houston (Time)
Path 1: Dallas -> Houston. Time: 51 Cost: 101
Path 2: Dallas -> Austin -> Houston. Time: 86 Cost: 193

Flight 1: Chicago, Dallas (Cost)
Path 1: Chicago -> Austin -> Dallas. Time: 250 Cost: 255
Path 2: Chicago -> Austin -> Dallas. Time: 250 Cost: 255

