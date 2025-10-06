public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int n = 2;
        System.out.println(sol.countArrangement(n)); // Output: 2
    }
}

class Solution {
    public int countArrangement(int n) {
        boolean[] visited = new boolean[n + 1];
        return backtrack(1, n, visited);
    }

    private int backtrack(int pos, int n, boolean[] visited) {
        if (pos > n) return 1;

        int count = 0;
        for (int num = 1; num <= n; num++) {
            if (!visited[num] && (num % pos == 0 || pos % num == 0)) {
                visited[num] = true;
                count += backtrack(pos + 1, n, visited);
                visited[num] = false;
            }
        }
        return count;
    }
}
