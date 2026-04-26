## Algorithms-and-Data-Structures 
Name : Korganbek Madiyar 
Group : IT - 2501 

## Project Overview

This project implements and compares three algorithms:
- Bubble Sort (basic sorting)
- Quick Sort (advanced sorting)
- Binary Search (searching)

The goal is to measure execution time for different array sizes and compare performance based on input type.

## Selected Algorithms

- Basic Sorting: Bubble Sort  
- Advanced Sorting: Quick Sort  
- Searching: Binary Search  


## Algorithm Descriptions

### Bubble Sort
Bubble Sort compares adjacent elements and swaps them if they are in the wrong order.

- Best Case: O(n)  
- Average Case: O(n²)  
- Worst Case: O(n²)  

### Quick Sort
Quick Sort selects a pivot and partitions the array into smaller parts, then sorts them recursively.

- Best Case: O(n log n)  
- Average Case: O(n log n)  
- Worst Case: O(n²)  

### Binary Search
Binary Search finds an element in a sorted array by repeatedly dividing the search space in half.

- Best Case: O(1)  
- Worst Case: O(log n)  

## Experimental Results

| Array Size | Input Type | Bubble Sort (ns) | Quick Sort (ns) | Binary Search (ns) |
|-----------|------------|------------------|-----------------|--------------------|
| 10        | Random     | 8700             | 6900            | 2700               |
| 10        | Sorted     | 1000             | 4000            | 2700               |
| 100       | Random     | 320000           | 51300           | 1500               |
| 100       | Sorted     | 5700             | 310600          | 1500               |
| 1000      | Random     | 6728800          | 141300          | 3600               |
| 1000      | Sorted     | 10100            | 1935300         | 3600               |

## Analysis

Quick Sort performed much faster than Bubble Sort on random arrays, especially for large input sizes. For example, at size 1000, Bubble Sort took significantly more time compared to Quick Sort. This is because Quick Sort has an average time complexity of O(n log n), while Bubble Sort is O(n²).

As the array size increased, Bubble Sort became much slower. This confirms that inefficient algorithms do not scale well with large data.

Sorted arrays improved the performance of Bubble Sort significantly, because fewer swaps were needed. However, Quick Sort became slower on sorted arrays. This is due to poor pivot selection (last element), which causes unbalanced partitions.

The results generally match the expected Big-O complexity. Bubble Sort behaves as O(n²), while Quick Sort behaves closer to O(n log n) on random data.

Binary Search was very fast in all cases because it uses O(log n) time complexity. It requires a sorted array because it compares the middle element and decides which half to search.

## Screenshots

<img width="687" height="653" alt="Screenshot 2026-04-20 180038" src="https://github.com/user-attachments/assets/436640b8-db03-4cee-afa9-8761c030c68e" />
<img width="459" height="485" alt="Screenshot 2026-04-20 180044" src="https://github.com/user-attachments/assets/e6bee660-e9c2-412c-83bb-2732916fb3b2" />

## Reflection

In this project, I learned how algorithm performance changes depending on input size and data type. Bubble Sort is easy to implement but becomes very slow for large datasets. Quick Sort is much more efficient for large random arrays.

I also learned that algorithm performance can vary depending on implementation details. For example, Quick Sort performed worse on sorted arrays due to pivot selection. This helped me understand the importance of both theoretical complexity and practical behavior.
