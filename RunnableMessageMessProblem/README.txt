
Problem Statement
    
It is a common practice in cryptography to remove the spaces from a message before encoding it to help to disguise its structure. Even after it is then decoded, we are left with the problem of putting the spaces back in the message.
Create a class MessageMess that contains a method restore that takes a String[] dictionary of possible words and a String message as inputs. It returns the message with single spaces inserted to divide the message into words from the dictionary. If there is more than one way to insert spaces, it returns "AMBIGUOUS!" If there is no way to insert spaces, it returns "IMPOSSIBLE!" The return should never have any leading or trailing spaces.
Definition
    
Class:
MessageMess
Method:
restore
Parameters:
String[], String
Returns:
String
Method signature:
String restore(String[] dictionary, String message)
(be sure your method is public)
Limits
    
Time limit (s):
2.000
Memory limit (MB):
64
Notes
-
Don't forget the '!' at the end of the two special returns
-
A proper message may require 0 spaces to be inserted
Constraints
-
dictionary will contain between 1 and 50 elements inclusive
-
the elements of dictionary will be distinct
-
each element of dictionary will contain between 1 and 50 characters
-
message will contain between 1 and 50 characters
-
every character in message and in each element of dictionary will be an uppercase letter 'A'-'Z'
Examples
0)

    
{"HI", "YOU", "SAY"}
"HIYOUSAYHI"
Returns: "HI YOU SAY HI"
A word from dictionary may appear multiple times in the message.
1)

    
{"ABC", "BCD", "CD", "ABCB"}
"ABCBCD"
Returns: "AMBIGUOUS!"
"ABC BCD" and "ABCB CD" are both possible interpretations of message.
2)

    
{"IMPOSS", "SIBLE", "S"}
"IMPOSSIBLE"
Returns: "IMPOSSIBLE!"
There is no way to concatenate words from this dictionary to form "IMPOSSIBLE"
3)

    
{"IMPOSS", "SIBLE", "S", "IMPOSSIBLE"}
"IMPOSSIBLE"
Returns: "IMPOSSIBLE"
This message can be decoded without ambiguity. This requires the insertion of no spaces since the entire message appears as a word in the dictionary.
This problem statement is the exclusive and proprietary property of TopCoder, Inc. Any unauthorized use or reproduction of this information without the prior written consent of TopCoder, Inc. is strictly prohibited. (c)2003, TopCoder, Inc. All rights reserved.