# Design

+ [Course Schedule](#course-schedule)

## Course Schedule

https://leetcode.com/problems/course-schedule/

```java
class Solution {
    static int WHITE = 1;//нетронутые
    static int GRAY = 2;//по которым прошлись в текущем заходе
    static int BLACK = 3;//положенные в стэк

    boolean isPossible;//проверка на цикл
    Map<Integer, Integer> color;//присваивание цвета
    Map<Integer, List<Integer>> adjList;//родитель-дети

    // numCourses - количество курсов
    private void init(int numCourses) {
        this.isPossible = true;
        this.color = new HashMap<Integer, Integer>();
        this.adjList = new HashMap<Integer, List<Integer>>();

    // By default all vertces are WHITE
    for (int i = 0; i < numCourses; i++) {
      this.color.put(i, WHITE);
    }
  }

  private void dfs(int node) {//проход в глубину

    // Don't recurse further if we found a cycle already
    if (!this.isPossible) {
      return;
    }

    // Start the recursion
    this.color.put(node, GRAY);

    // Traverse on neighboring vertices
    for (Integer neighbor : this.adjList.getOrDefault(node, new ArrayList<Integer>())) {
      if (this.color.get(neighbor) == WHITE) {
        this.dfs(neighbor);
      } else if (this.color.get(neighbor) == GRAY) {
        // An edge to a GRAY vertex represents a cycle
        this.isPossible = false;
      }
    }

    // Recursion ends. We mark it as black
    this.color.put(node, BLACK);
  }


    public boolean canFinish(int numCourses, int[][] prerequisites) {
        this.init(numCourses);

    // Create the adjacency list representation of the graph (соседство)
    for (int i = 0; i < prerequisites.length; i++) {
      int dest = prerequisites[i][0];//child
      int src = prerequisites[i][1];//parent
      List<Integer> lst = adjList.getOrDefault(src, new ArrayList<Integer>());
      lst.add(dest);
      adjList.put(src, lst);
    }

    // If the node is unprocessed, then call dfs on it.
    for (int i = 0; i < numCourses; i++) {
      if (this.color.get(i) == WHITE) {
        this.dfs(i);
      }
    }

    return this.isPossible;//result
  }
}


```