
Problem Statement
    
In Chapter 7 of W.V. Quine's book "Mathematical Logic", Quine speaks about the necessity of parentheses but also of their obsfucating nature. To combat this he introduces "a graphical notation of dots". Where parentheses determine the outside boundaries of operands by marking them directly, dot notation does this by placing dots on each side of the operator. The left operand of the operator is determined by the number of dots prefixed to the operator; the operand is the substring with its end at the beginning of the prefixed dots and with its beginning at the end of the next larger grouping of dots suffixed to another operator, or at the beginning of the expression whichever comes first. The right side of the operator is determined likewise; it is the substring starting at the end of the suffixed dots and has its end at the beginning of the next larger grouping of dots prefixed to another operator or at the end of the expression, whichever comes first.
To be specific, all dot notation will be a <DotNotation> of this form (quotes added for clarity):
<DotNotation> := <Number> | <DotNotation><Dots><Operator><Dots><Number>
<Dots> := "" | <Dots>"."
<Operator> := "+" | "-" | "*" | "/"
<Number> := exactly one of "0123456789"
If an operator's operands reach across the entire expression, the operator is said to be dominant. Evaluation in dot notation involves finding the dominant operator, evaluating the left and right operands of that operator, and then evaluating that operator last. For example: in the dot notation expression "2*.1+3", "2" is the left operand of the '*' (consider no dots as a grouping of 0 dots) and "1+3" is the right operand of the '*', so this can be read with parentheses as "2*(1+3)", the '*' is dominant, and the expression evaluates to 8. Likewise, "2*.1..+3" refers to the expression "(2*1)+3", the '+' is dominant, and the expression evaluates to 5.  Dot notation can be ambiguous if there is more than one dominating operator. For example, in the expression "3+.5.*7" either operator may be dominant (both operators reach across the entire expression unopposed) so this could be parenthesized as either "3+(5*7)" or "(3+5)*7" and the expression could evaluate to either 38 or 56 respectively. There are even expressions that have no dominating operator, such as "1+...2....*.8..+7". Since there is no way to parenthesize this expression consistent with its dot notation, it cannot be legally evaluated.
You will be given a String in dot form, and you'll need to return the number of unique integers that the expression can evaluate to. For this problem, a specific evaluation is illegal if any part of the evaluation involves division by 0, any operand evaluates to a value that is less than -2000000000 or greater than 2000000000, or if the expression has no dominating operator thus preventing evaluation. If all possible evaluations of the dot notation are illegal return 0.
Definition
    
Class:
DotNotation
Method:
countAmbiguity
Parameters:
String
Returns:
int
Method signature:
int countAmbiguity(String dotForm)
(be sure your method is public)
Limits
    
Time limit (s):
2.000
Memory limit (MB):
64
Notes
-
There is no normal order of operations in this problem; thus a+b*c is ambiguous.
Constraints
-
dotForm will be between 1 and 25 characters long, inclusive.
-
dotForm will be a <DotNotation> as described above.
Examples
0)

    
"2"
Returns: 1
A single digit by itself has only one interpretation.
1)

    
"9+5*3"
Returns: 2
This could be read (9+5)*3 or as 9+(5*3). Keep in mind that no order of operations is to be assumed.
2)

    
"9+5.*3"
Returns: 1
Here, the dot prefixed to the * gives it dominance, and this can only be read as (9+5)*3.
3)

    
"1+2.*.3+4"
Returns: 1
The * is dominant here, so this is read as (1+2)*(3+4), and 21 is the only number it can be evaluated to.
4)

    
"9*8+7*6-5+4*3/2./9"
Returns: 99

5)

    
"1+...2....*.8..+7"
Returns: 0
Notice here how none of the operators in the expression can be dominating. Since none of these operators are dominating, none of these operators may be evaluated last, meaning that there is no valid interpretation of this expression.
This problem statement is the exclusive and proprietary property of TopCoder, Inc. Any unauthorized use or reproduction of this information without the prior written consent of TopCoder, Inc. is strictly prohibited. (c)2003, TopCoder, Inc. All rights reserved.