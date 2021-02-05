1. Understand requirements
2. Think the concept
3. Write unit test & Confirm edge cases
4. Use appropriated data structure
5. Use corresponded algorithms

# Recursive v.s. Iterative
If data structures used in your function are linkedlisted type not array types, using iterative to avoid uncertain length of your data to make stack overflow.

But your data structures are array type, if using iterative, you have to create objects for each position. Furthermore, using recursive just assigns other indexes to the recursive function. Otherwise, the length of data are visible.

# Memonization on Recursion
Giving a record to recursion parameter can reduce duplicated computing or avoid stack overflow by using the record as a result with a tail recursion.

# Tail Recursion
A function call will be allocated a space for three componets return address, parameters, and local variables. 

## With Non-Tail Recursion
You write a recursive function with returning variables and the function togather. A stack have to store current information until the recursive function called in current epoch is finished.

## With Tail Recursion
You return a recursive function without any other things. Because the information in the current epoch is useless, the stack don't have to store the information in it. The benefit is to avoid stack overflow.

# Back Tracking
1. Do sth sequencally
2. Check contents from previous results
3. Store the result from sth 

# Split Problem to sub-problem
You should split the problem as small as possible. For example, Split a problem with minusing one of which complexity is O(n) or with dividing two of which complexity is O(logn).
