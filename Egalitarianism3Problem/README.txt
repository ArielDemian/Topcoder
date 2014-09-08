
Problem Statement
    
In Treeland there are n cities, numbered 1 through n. The cities are linked by n-1 bidirectional roads. Each road connects a pair of cities. The roads are built in such a way that each city is reachable from each other city by roads. (In other words, the topology of the road network is a tree.)  You are given the int n and three int[]s that describe the road network: a, b, and len. For each i between 0 and n-2, inclusive, there is a road of length len[i] that connects the cities a[i] and b[i].  The distance between two cities is the sum of lengths of roads on the sequence of roads that connects them. (Note that this sequence of roads is always unique.)  You want to select k cities in such a way that all pairwise distances between the selected cities are the same. In other words, there must be a distance d such that the distance between every two selected cities is d. Return the largest possible value of k for which this is possible.
Definition
    
Class:
Egalitarianism3
Method:
maxCities
Parameters:
int, int[], int[], int[]
Returns:
int
Method signature:
int maxCities(int n, int[] a, int[] b, int[] len)
(be sure your method is public)
Limits
    
Time limit (s):
2.000
Memory limit (MB):
256
Constraints
-
n will be between 1 and 50, inclusive.
-
a will contain exactly n-1 elements.
-
b will contain exactly n-1 elements.
-
len will contain exactly n-1 elements.
-
Each element in a will be between 1 and n, inclusive.
-
Each element in b will be between 1 and n, inclusive.
-
Each element in len will be between 1 and 1,000, inclusive.
-
The graph described by a and b will be a tree.
Examples
0)

    
4
{1,1,1}
{2,3,4}
{1,1,1}
Returns: 3
There are 4 cities and 3 roads, each of length 1. The roads connect the following pairs of cities: (1,2), (1,3), and (1,4). The optimal answer is k=3. We can select three cities in the required way: we select the cities {2, 3, 4}. The distance between any two of these cities is 2.
1)

    
6
{1,2,3,2,3}
{2,3,4,5,6}
{2,1,3,2,3}
Returns: 3
Again, the largest possible k is 3. There are two ways to select three equidistant cities: {1, 4, 6} and {4, 5, 6}. (In both cases the common distance is 6.)
2)

    
10
{1,1,1,1,1,1,1,1,1}
{2,3,4,5,6,7,8,9,10}
{1000,1000,1000,1000,1000,1000,1000,1000,1000}
Returns: 9

3)

    
1
{}
{}
{}
Returns: 1
Note that n can be 1.
This problem statement is the exclusive and proprietary property of TopCoder, Inc. Any unauthorized use or reproduction of this information without the prior written consent of TopCoder, Inc. is strictly prohibited. (c)2003, TopCoder, Inc. All rights reserved.