# ADS_3
Aidyn Yeskendirov IT-2504
Assignment 3 Sorting and Searching


A. Project Overview
Basic sort - Bubble sort.

Advanced Sort - Quick sort. 

Purpose of the experiment - analyze how much time basic and advanced sorts, as well as searching algorithms(linear and binary) take time based on small(10), medium(100) and large(1000) sizes of arrays.

B. Algorithm Descriptions
Bubble sort - Repeated swapping pairs of array if in wrong order, at each i`th iteration of the outer loop the maximum element is moved to the position of n-i-1. Big O - O(n^2).
Quick sort - Select random pivot (first, last or middle element), partition the other elements into two subarrays, according to whether they are less or greater than the pivot point. 
Time complexity: Quick Sort > Bubble Sort
                  O(nlogn) < O(n^2)   -   nlogn faster, takes less time than n^2

C. Experimental Results.
Sorting: 
<img width="886" height="282" alt="image" src="https://github.com/user-attachments/assets/e86ac0d2-b050-4551-935b-2fcc102c76ca" />

Searching:
<img width="885" height="280" alt="image" src="https://github.com/user-attachments/assets/c531268d-7492-4f0d-a274-9c9303fccb9e" />


D. Screenshots.
Results of sorting and searching algorithms in ns
THREE DIFFERENT RANDOM ARRAYS AND THEIR RESULTS:
1) <img width="648" height="639" alt="image" src="https://github.com/user-attachments/assets/5284952b-fdb0-4c8d-b5da-23743f850e28" />
2) <img width="600" height="537" alt="image" src="https://github.com/user-attachments/assets/dab39305-a2c4-4e93-8bad-876e1a1e7a04" />
3) <img width="615" height="514" alt="image" src="https://github.com/user-attachments/assets/3c6ff768-dccd-452e-92dd-6867067a1665" />

E. Reflection.
Algorithm efficiency: Through benchmarking, I learned that algorithmic efficiency is highly context-dependent — the "better" algorithm on paper can easily lose to a simpler one at small input sizes due to overhead, and input characteristics like sortedness matter as much as the algorithm itself.

Theoretical vs practical performance: Big-O ratios only aligned with real measurements at larger input sizes (n=1000), while small inputs were dominated by JVM warmup and constant-factor overhead, showing that theoretical complexity is a long-run predictor, not a guarantee for any given run.

Implementation challenges: The trickiest part was correctly implementing quicksort's partition logic — particularly getting the pivot swap and index boundaries right without introducing off-by-one errors — and realizing that simply changing the pivot strategy (last vs middle element) has almost no effect on random data but a dramatic one on sorted data.


Which sorting algorithm performed faster? Why? How does performance change with input size?
Advanced algorithm perform faster, because quick sort divide array into two subarrays, based on whether the element is smaller than or greater than pivot, and basic sort takes two loops to succesfully sort the array. Moreover: advanced > sort  ->  O(nlog(n)) > O(n^2), looking at big O notation graph at the bottom of readme it is clear that as far as size of elements is increased, the time of basic sort will be increased squarely than advanced sort which will be faster than bubble sort.  


How does sorted vs unsorted data affect performance?
Basic sort (bubble) on sorted data is faster than on random - it can exit early once no swaps occur in a pass, approaching O(n) best case
Advanced sort (quicksort, last-element pivot) on sorted data is slower - the last element is always the maximum, producing maximally unbalanced partitions and hitting O(n²) worst case.

Do the results match the expected Big-O complexity?
Basic: Ratios are lower than pure O(n²) predicts, because JIT warming and small-n overhead distort small measurements. The trend is clearly superlinear though.
Advanced: The 10 -> 100 jump is anomalous (the JVM overhead dominates at n=10, making it look artificially fast). The 100 -> 1000 ratio of ~14× matches O(n log n) well.

Which searching algorithm is more efficient? Why?
Binary search's real superiority only becomes undeniable at much larger n (tens of thousands or more), where O(log n) vs O(n) becomes the decisive factor. At n=1,000,000 binary search takes ~20 comparisons; linear search takes ~500,000 on average — no constant factor can save it.

Why does Binary Search require a sorted array?
Because it halfs array every iteration and checks if the target is greater than or less than middle element

Big O growth rates: 
<img width="1180" height="720" alt="image" src="https://github.com/user-attachments/assets/98a4bdce-90c1-4a28-8fa2-1487bfa6549e" />
