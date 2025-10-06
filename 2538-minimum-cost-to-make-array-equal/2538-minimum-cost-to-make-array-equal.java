import java.util.*;

class Solution {
    public long minCost(int[] nums, int[] cost) {
        int n = nums.length;
        long[][] arr = new long[n][2];  // [num, cost]

        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = cost[i];
        }

        // Step 1: Sort by num
        Arrays.sort(arr, (a, b) -> Long.compare(a[0], b[0]));

        // Step 2: Compute prefix sum of cost
        long[] prefixCost = new long[n];
        prefixCost[0] = arr[0][1];
        for (int i = 1; i < n; i++) {
            prefixCost[i] = prefixCost[i - 1] + arr[i][1];
        }

        // Step 3: Find weighted median using greedy prefix sum
        long totalCost = prefixCost[n - 1];
        long half = (totalCost + 1) / 2;
        long median = 0;

        for (int i = 0; i < n; i++) {
            if (prefixCost[i] >= half) {
                median = arr[i][0];
                break;
            }
        }

        // Step 4: Compute minimum total cost to make all = median
        long result = 0;
        for (int i = 0; i < n; i++) {
            result += Math.abs(arr[i][0] - median) * arr[i][1];
        }

        return result;
    }

    // Test main
    public static void main(String[] args) {
        Solution s = new Solution();

        int[] nums1 = {1, 3, 5, 2};
        int[] cost1 = {2, 3, 1, 14};
        System.out.println(s.minCost(nums1, cost1)); // ✅ 8

        int[] nums2 = {2, 2, 2, 2, 2};
        int[] cost2 = {4, 2, 8, 1, 3};
        System.out.println(s.minCost(nums2, cost2)); // ✅ 0

        int[] nums3 = {7, 4};
        int[] cost3 = {7, 6};
        System.out.println(s.minCost(nums3, cost3)); // ✅ 18
    }
}
