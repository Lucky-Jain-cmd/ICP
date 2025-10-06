import java.util.*;
public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] flowers = {{1,6},{3,7},{9,12},{4,13}};
        int[] people = {2,3,7,11};

        int[] ans = sol.fullBloomFlowers(flowers, people);
        System.out.println(Arrays.toString(ans)); // [1,2,2,2]
    }
}

class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        // Step 1: Mark +1 at start, -1 at end+1
        for (int[] f : flowers) {
            map.put(f[0], map.getOrDefault(f[0], 0) + 1);
            map.put(f[1] + 1, map.getOrDefault(f[1] + 1, 0) - 1);
        }

        // Step 2: Compute prefix sums
        int sum = 0;
        for (int key : map.keySet()) {
            sum += map.get(key);
            map.put(key, sum); // now map stores: time → flowers in bloom till that time
        }

        // Step 3: For each person, find how many flowers blooming at that time
        int[] ans = new int[people.length];
        for (int i = 0; i < people.length; i++) {
            // find the largest time <= people[i]
            Map.Entry<Integer, Integer> entry = map.floorEntry(people[i]);
            ans[i] = (entry == null) ? 0 : entry.getValue();
        }

        return ans;
    }
}
