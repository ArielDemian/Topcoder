
Problem Statement
    
There is a small cube planet somewhere. On each side of the cube there lives a four-armed dragon. It is time for dinner now. Each dragon sits in front of his bowl with food.
During each round, the following happens: Each dragon is trying to steal food from his neighbors (living on four neighboring sides of the cube). He spreads his four arms there (each arm goes to each separate neighbor). As other dragons do the same, four hands meet in each bowl of food. Four hands fight for a while and each takes one quarter of the food in this bowl to its own bowl. Hence, each round the food distribution changes.
Given the initial amount of food in each bowl and the number of rounds, return the amount of food the dragons' boss Snaug will have after these rounds.
In more detail:
The initial amount of food will be given in the following order: front, back, up, down, left, right. The dragons' boss Snaug lives on the "up" side of the cube. If the answer is an integer, return this integer. If the answer is a fraction, return the answer in the format X/Y, where X and Y are integers without common factors. Extra leading zeroes shouldn't be present in your answer.
Example.
Suppose that the initial distribution of food is the following: 0, 0, 4, 0, 0, 0. That is Snaug has 4 and everybody else has 0 amount of food in their bowls. After the first round the distribution of food will be the following: 1, 1, 0, 0, 1, 1, that is every neighbor of Snaug steals from him one quarter of his food. After the second round the distribution of food will be the following: 1/2, 1/2, 1, 1, 1/2, 1/2.
Definition
    
Class:
Dragons
Method:
snaug
Parameters:
int[], int
Returns:
String
Method signature:
String snaug(int[] initialFood, int rounds)
(be sure your method is public)
Limits
    
Time limit (s):
2.000
Memory limit (MB):
64
Constraints
-
initialFood has exactly 6 elements
-
each element of initialFood is between 0 and 1,000 inclusive
-
rounds is between 0 and 45 inclusive
Examples
0)

    
{0, 0, 4, 0, 0, 0}
2
Returns: "1"
See the explanation above
1)

    
{0, 0, 4, 0, 0, 0}
3
Returns: "1/2"

2)

    
{1000, 1000, 1000, 1000, 1000, 1000}
45
Returns: "1000"
When everybody has the same amount of food, they continue to have the same amount of food after each round
3)

    
{1, 2, 3, 4, 5, 6}
45
Returns: "7/2"

This problem statement is the exclusive and proprietary property of TopCoder, Inc. Any unauthorized use or reproduction of this information without the prior written consent of TopCoder, Inc. is strictly prohibited. (c)2003, TopCoder, Inc. All rights reserved.