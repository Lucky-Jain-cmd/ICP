import java.util.*;

public class Solution {

    public static boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        Integer[][] memo = new Integer[n][n];
        return score(nums, 0, n - 1, memo) >= 0;
    }

    private static int score(int[] nums, int start, int end, Integer[][] memo) {
        if (start > end) return 0; // no numbers left
        if (memo[start][end] != null) return memo[start][end];

        // Pick start
        int pickStart = nums[start] - score(nums, start + 1, end, memo);
        // Pick end
        int pickEnd = nums[end] - score(nums, start, end - 1, memo);

        memo[start][end] = Math.max(pickStart, pickEnd);
        return memo[start][end];
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 5, 2};
        int[] nums2 = {1, 5, 233, 7};

        System.out.println("Can Player 1 win nums1? " + predictTheWinner(nums1)); // false
        System.out.println("Can Player 1 win nums2? " + predictTheWinner(nums2)); // true
    }
}
