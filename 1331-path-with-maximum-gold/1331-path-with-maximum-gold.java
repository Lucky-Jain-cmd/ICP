import java.util.*;

public class Solution {
    
    public static int getMaximumGold(int[][] grid) {
        int maxGold = 0;
        
        // Traverse every cell
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // Start DFS if gold exists
                if (grid[i][j] != 0) {
                    maxGold = Math.max(maxGold, dfs(grid, i, j));
                }
            }
        }
        
        return maxGold;
    }

    private static int dfs(int[][] grid, int i, int j) {
        // Base condition: out of bounds or 0 gold
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }

        int gold = grid[i][j];
        grid[i][j] = 0; // mark visited

        // Move in all 4 directions
        int up = dfs(grid, i - 1, j);
        int down = dfs(grid, i + 1, j);
        int left = dfs(grid, i, j - 1);
        int right = dfs(grid, i, j + 1);

        // Restore gold (backtrack)
        grid[i][j] = gold;

        // Return max path sum including this cell
        return gold + Math.max(Math.max(up, down), Math.max(left, right));
    }

    public static void main(String[] args) {
        int[][] grid1 = {{0,6,0},{5,8,7},{0,9,0}};
         int[][] grid2 = {{1,0,7},{2,0,6},{3,4,5},{0,3,0},{9,0,20}};

        System.out.println("Maximum Gold 1: " + getMaximumGold(grid1)); // Output: 24
        System.out.println("Maximum Gold 2: " + getMaximumGold(grid2)); // Output: 28
    }
}
