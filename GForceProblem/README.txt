
Problem Statement
    
A primary limitation of fighter plane performance is the ability of the pilot to remain conscious. We have determined that pilots can withstand large accelerations for short time periods, but that they cannot handle an extended time period during which the average acceleration is high.
Create a class GForce that contains a method avgAccel that will be given the period as an int, and int[]'s accel and time giving a piecewise-linear approximation to the acceleration experienced over time during a flight. The method will return the greatest average acceleration experienced over any interval of length equal to period. The return value should be the average acceleration as a double.
The piecewise-linear acceleration function is given in order of increasing times, starting with the beginning of the flight and ending at the end of the flight. The graph of acceleration versus time is the sequence of straight-line segments joining adjacent points (timei, acceli).
The average acceleration over an interval is the area under the graph between the beginning and ending times, divided by the length of the interval.
Definition
    
Class:
GForce
Method:
avgAccel
Parameters:
int, int[], int[]
Returns:
double
Method signature:
double avgAccel(int period, int[] accel, int[] time)
(be sure your method is public)
Limits
    
Time limit (s):
2.000
Memory limit (MB):
64
Notes
-
The returned result must only be relatively close to the correct answer. Specifically, if the returned value either has a relative error or an absolute error less than 10^-9 it is accepted as correct.
Constraints
-
accel contains between 2 and 50 elements inclusive
-
time contains the same number of elements as accel
-
the elements of time are strictly increasing
-
the elements of time and of accel are between 0 and 10,000 inclusive
-
period is greater than 0 and less than the difference between the first and last elements of time
Examples
0)

    
100
{1500,1500,500,2000}
{0,100,150,225}
Returns: 1500.0
 accel                        
  2000 +            X   
  1500 +   X---X   /    
  1000 +        \ /   
   500 +         X                          
       +-+-+-+-+-+-+-+-+-+---- time
     -100  0  100 200 300
The four points determine a piecewise linear function with three segments, whose graph is shown. The interval from 0 to 100 is the one with the biggest average accel. In this region the average is obviously 1500.
The highest accel value is at t=225, but if we compute the area under the curve between 125 and 225 we get 112,500 so the average on that interval is 1125 which is not as high as 1500.
1)

    
500
{5,30,5}
{0,1000,2000}
Returns: 26.875
By symmetry the interval with the highest average must be 750 to 1250. The area under the curve in this interval consists of two trapezoids, each with width 250 and heights 23.75 and 30. The sum of their areas is 26.875.
2)

    
11
{0,5,5,0,6}
{0,5,15,25,31}
Returns: 4.984848484848485

This problem statement is the exclusive and proprietary property of TopCoder, Inc. Any unauthorized use or reproduction of this information without the prior written consent of TopCoder, Inc. is strictly prohibited. (c)2003, TopCoder, Inc. All rights reserved.