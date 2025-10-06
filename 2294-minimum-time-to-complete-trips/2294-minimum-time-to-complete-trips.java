public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] time = {1, 2, 3};
        int totalTrips = 5;
        System.out.println(sol.minimumTime(time, totalTrips)); // Output: 3
    }
}

class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long low = 1;
        long high = (long) getMin(time) * totalTrips;
        long ans = high;

        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (canComplete(time, mid, totalTrips)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private boolean canComplete(int[] time, long mid, int totalTrips) {
        long trips = 0;
        for (int t : time) {
            trips += mid / t;
            if (trips >= totalTrips) return true;
        }
        return false;
    }

    private int getMin(int[] time) {
        int min = Integer.MAX_VALUE;
        for (int t : time) min = Math.min(min, t);
        return min;
    }
}
