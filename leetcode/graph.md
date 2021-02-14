# Graph

+ [Number of Islands](#number-of-islands)

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