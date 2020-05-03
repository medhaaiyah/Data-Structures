# Data-Structures

# Project 1:

Overview of Results:

Comparisons = C
Movements = M

Experimental Results	InOrder (milliseconds)	ReverseOrder
(milliseconds)	AlmostOrder (80%)
(milliseconds)	AlmostOrder (20%)
(milliseconds)	Random
(milliseconds)	Array Size	Total Times
Insertion Sort	19
C: 4999
M: 0	39
C: 4999
M: 12248162	28
C: 4999
M: 6074159	26
C: 4999
M: 6097435	28
C: 4999
M: 6137658	5000	140 milliseconds
Selection Sort	22
C: 0
M: 0	36
C: 68660
M: 8390	44
C: 22188
M: 9796	44
C: 22654
M: 9780	37
C: 9798
M: 22537	5000	183 milliseconds
Quick Sort	40
C: 12752084
M: 0	45
C: 6802949
M: 4902	27
C: 1315780
M: 12948	25
C: 947287
M: 13422	21
C: 850834
M: 13166	5000	158 milliseconds
Merge Sort	103
C: 66807
M: 61808	112
C: 66807
M: 61808	102
C: 66807
M: 61808	104
C: 66807
M: 61808	115
C: 61808
M: 66807	5000	536 milliseconds
Heap Sort	29
C: 175556
M: 21734	34
C: 178512
M: 0	33
C: 185850
M: 11700	35
C: 187169
M: 11816	33
C: 186693
M: 12092	5000	164 milliseconds
Radix Sort	3
C: 20000
M: 0	3
C: 20000
M: 0	2
C: 20000
M: 0	1
C: 20000
M: 0	4
C: 20000
M: 0	5000	13 milliseconds

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

# Project 2 Part II:

# Project 3:
