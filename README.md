# Assignment 4: Graph Traversal and Representation System

## Project Overview

This project demonstrates the implementation of graph traversal algorithms using Java.  
The graph is represented using an adjacency list structure.  

A graph consists of:
- Vertices (nodes)
- Edges (connections between vertices)

The project implements:
- Breadth-First Search (BFS)
- Depth-First Search (DFS)

The purpose of this assignment is to understand graph structures, traversal algorithms, and algorithm performance analysis using Big-O notation.

---

# Graph Structure

The graph in this project is implemented using an adjacency list.

Example:

1 -> [2, 3]  
2 -> [1, 4, 5]  
3 -> [1, 6]

This representation is memory efficient and suitable for sparse graphs.

---

# Class Descriptions

## Vertex Class

The `Vertex` class represents a graph node.

### Fields
- `id` — unique identifier of the vertex

### Methods
- Constructor
- Getter
- `toString()`

---

## Edge Class

The `Edge` class represents a connection between two vertices.

### Fields
- `source`
- `destination`

### Methods
- Constructor
- Getters
- `toString()`

---

## Graph Class

The `Graph` class stores the graph structure using an adjacency list.

### Main Methods
- `addVertex(Vertex v)`
- `addEdge(int from, int to)`
- `printGraph()`
- `bfs(int start)`
- `dfs(int start)`

The class also contains the traversal logic for BFS and DFS.

---

## Experiment Class

The `Experiment` class performs:
- traversal execution
- performance testing
- execution time measurement

Execution time is measured using:

```java
long start = System.nanoTime();
long end = System.nanoTime();

<img width="1871" height="929" alt="Screenshot 2026-05-10 183243" src="https://github.com/user-attachments/assets/aaa32533-95f3-4ad0-bbe7-7c3f1c7db9c3" />
<img width="1825" height="931" alt="Screenshot 2026-05-10 183251" src="https://github.com/user-attachments/assets/7551ddd0-f41b-4511-b856-1ebd8571feea" />

