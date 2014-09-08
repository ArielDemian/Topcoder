You are given n integers a1, a2, . . . , an and you have to find the sum of f(i, j) for all pair of i and j such that 1 ≤ i ≤ j ≤ n.

f(i, j) = |m − ai| + |m − ai+1| + . . . + |m − aj | where m = minimum of ai, ai+1, . . . , aj .
|x| = absolute value of x.

Input
First line contains 1 ≤ T ≤ 10 test cases. Each test case contains two lines. First line contains an integer 1 ≤ n ≤ 50000 and second line contain n space separated integers. Absolute value of those n integers will be smaller than or equals to 50000.

Output
Output a single line containing the sum. Please see output format for more information.

Sample Input
1
5
1 2 3 4 5
Sample Output
Case 1: 35