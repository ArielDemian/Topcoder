
Problem Statement
    
Your mailbox is a mess: it contains e-mails from weeks ago and you want to archive them. You know which folder you want to move each e-mail to. The names of the destination folders are given in a String[] destFolders and consist of letters (both upper- and lowercase) and spaces. The names are case sensitive. The i-th element of destFolders corresponds to the i-th element of your inbox.  To archive the e-mails you can just select the first one and move it to the appropriate folder, then select the second one, etc. Using this method, you need to make exactly the same number of selections as the number of e-mails you have. By selecting contiguous ranges of e-mails (that have to be moved to the same folder) and moving them at once, you can often do better. After moving one or more e-mails, they disappear from your inbox, so other e-mails may become adjacent.  Return the minimal number of selections you need to make to archive all your e-mails.
Definition
    
Class:
MailArchiving
Method:
minSelections
Parameters:
String[]
Returns:
int
Method signature:
int minSelections(String[] destFolders)
(be sure your method is public)
Limits
    
Time limit (s):
2.000
Memory limit (MB):
64
Constraints
-
destFolders contains between 1 and 50 elements, inclusive.
-
Each element of destFolders has length between 1 and 50, inclusive.
-
Each element of destFolders consists of letters and spaces.
Examples
0)

    
{"Deleted messages","Saved messages","Deleted messages"}
Returns: 2
First move the second e-mail to its destination. The other two become adjacent then and can be moved at once.
1)

    
{"Folder A","Folder B","Folder C","Folder D","Folder E","Folder F"}
Returns: 6
When all the destination folders different, you can't do anything smart.
2)

    
{"FOLDER","folder"}
Returns: 2
The names are case sensitive.
3)

    
{"a","b","a","c","a","a","b","a","c","d","a"}
Returns: 6
First move the e-mails to folders "b", "c", and "d" all separately and then move the e-mails to folder "a" at once.
4)

    
{"a","b","b","c","d","e","d","e","d","e",
 "c","c","a","a","a","f","g","g","f","a",
 "h","h","i","j","i","j","a","a","k","k",
 "l","m","k","l","m","a","o","o","p","a"}
Returns: 20

This problem statement is the exclusive and proprietary property of TopCoder, Inc. Any unauthorized use or reproduction of this information without the prior written consent of TopCoder, Inc. is strictly prohibited. (c)2003, TopCoder, Inc. All rights reserved.