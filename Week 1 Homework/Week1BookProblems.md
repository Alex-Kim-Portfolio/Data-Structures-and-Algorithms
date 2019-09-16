Alexander Kim
CIS 112 ONLN2 Summer 2019 Week 1 Homework
Jason Wertz

Pages 64 & 65

42.(a) Since N^2 is the highest polynomial, this algorithm is O(N^2).
   (b) Since 3N^2 is the highest polynomial, this algorithm is O(N^2).
   (c) Since N^5 is the highest polynomial, this algorithm is O(N^5).
   (d) Since N^2 is the highest polynomial, this algorithm is O(N^2).
   (e) Since N^4 is the highest polynomial, this algorithm is O(N^4).
   (f) (N*(N-1))/2 = (1/2)(N^2)-(1/2)N. Since N^2 is the highest polynomial, this algorithm is O(N^2).
   
43.(a) This algorithm is O(N). It is linear and the size of input is directly correlated to the number of times the for loop is executed. 
   (b) This algorithm is O(N^2). The for loop within a for loop is proportional to the square size of the input data set. 
   (c) This algorithm is O(log N). The range of the data set is cut in half every time when value = value/2.
   (d) This algorithm is O(N^2). The value variable = N^2-N. count = count + value is the same as count = 0 + N^2-N. Since N^2 is the highest polynomial, the algorithm is O(N^2).
   (e) This algorithm is O(1). The algorithm goes through the input data twice (once up the list and once down the list), and so the amount of work is bounded by a constant.
   (f) This algorithm is O(N). The inside for loop will force the outer for loop to be multiplied by a fixed number. In this case, the input is multiplied by 5 each time it iterates, meaning 5N. This means it grows linearly and does not grow exponentially.
