# Graph
https://leetcode.com/problems/number-of-islands/ 
https://leetcode.com/problems/course-schedule-ii/ (dfs и подсчет ссылок)
https://leetcode.com/problems/course-schedule/ (dfs и подсчет ссылок)

+ [Number of Islands](#number-of-islands)
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

## Number of Islands

https://leetcode.com/problems/number-of-islands/

```java
public int numIslands(char[][] grid) {
    if (grid == null || grid.length < 0) return 0;
    int result = 0;
    for (int i = 0; i < grid.length; i++) {
        for (int j = 0; j < grid[i].length; j++) {
            // будет обнуление остального острова
            if (grid[i][j] == '1') {
                result += islandCount(grid, i, j);
            }
        }
    }
    return result;
}

public int islandCount(char[][] grid, int i, int j) {
    if (i < 0 || i == grid.length || j < 0 || j == grid[i].length || grid[i][j] == '0') {
        return 0;
    }
    grid[i][j] = '0';
    islandCount(grid, i + 1, j); // уходя в рекурсию главная цель будет обнуление и нахождение границ, значение return будет не важно, важен момент его вызова
    islandCount(grid, i, j + 1);
    islandCount(grid, i - 1, j);
    islandCount(grid, i, j - 1);
    return 1;
}

```
