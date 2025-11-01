# Algorithms implemented:

- SCC (Kosaraju) - finding strongly connected components
- Topological sort (Kahn) - ordering DAG vertices
- DAG shortest paths - using topological sort
- Longest path - for finding critical path

# Test data:
## Generated 9 graphs  in "data" folder:

- 3 small (6-10 vertices)
- 3 medium (10-20 vertices)
- 3 large (20-50 vertices)

# How it work:
1) Read the graph from "tasks.json"
2) Find SCCs - groups of vertices where all are reachable from each other
3) Sort the vertices topologically - so that all arrows point forward
4) Calculate the shortest and longest paths from the starting vertex

# Test results
"GraphTest.java" - unit test result:
## Test 1: testCSS - pass

- Checks for strongly connected components
- Graph with cycle 0-1-2 and separate vertices 3,4

## Test 2: testTopologicalSort - pass

- Checks for topological sorting for a DAG 
- Graph: 0 -> 1 -> 2 -> 3 (no cycles)

## Test 3: testShortestPath - pass

- Checks shortest paths in a DAG 
- Graph: 0 -> 1(2), 1 -> 2(3), 0 -> 2(10)

## All three tests passed successfully

# Summary

## When to use what:

- SCC - for connectivity analysis, cycle detection
- Topological sorting - for scheduling tasks with dependencies
- DAG shortest paths - for optimal routing without cycles
- Longest paths - for finding the "critical path" in projects