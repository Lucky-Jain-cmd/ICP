import java.util.*;

public class Solution {

    public static int uniquePathsIII(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int emptyCount = 0;
        int startRow = 0, startCol = 0;

        // Count empty cells and find start
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0) emptyCount++;
                else if (grid[i][j] == 1) {
                    startRow = i;
                    startCol = j;
                }
            }
        }

        // Include start cell in steps
        return dfs(grid, startRow, startCol, emptyCount + 1);
    }

    private static int dfs(int[][] grid, int row, int col, int remaining) {
        // Out of bounds or obstacle
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == -1) {
            return 0;
        }

        // Reached end
        if (grid[row][col] == 2) {
            return remaining == 0 ? 1 : 0; // Only valid if all squares visited
        }

        int temp = grid[row][col];
        grid[row][col] = -1; // Mark visited

        int paths = dfs(grid, row + 1, col, remaining - 1)
                  + dfs(grid, row - 1, col, remaining - 1)
                  + dfs(grid, row, col + 1, remaining - 1)
                  + dfs(grid, row, col - 1, remaining - 1);

        grid[row][col] = temp; // Backtrack

        return paths;
    }

    public static void main(String[] args) {
        int[][] grid1 = {{1,0,0,0},{0,0,0,0},{0,0,2,-1}};
        int[][] grid2 = {{1,0,0,0},{0,0,0,0},{0,0,0,2}};
        int[][] grid3 = {{0,1},{2,0}};

        System.out.println("Unique Paths 1: " + uniquePathsIII(grid1)); // 2
        System.out.println("Unique Paths 2: " + uniquePathsIII(grid2)); // 4
        System.out.println("Unique Paths 3: " + uniquePathsIII(grid3)); // 0
    }
}
