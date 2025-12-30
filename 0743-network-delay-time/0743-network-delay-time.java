class Solution {
    public int networkDelayTime(int[][] times, int n, int k){
        
         List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for (int[] t : times) {
            graph.get(t[0] - 1).add(new int[]{t[1] - 1, t[2]});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, k - 1});

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k - 1] = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int time = curr[0], node = curr[1];
            if (time > dist[node]) continue;

            for (int[] edge : graph.get(node)) {
                int nei = edge[0], wt = edge[1];
                if (time + wt < dist[nei]) {
                    dist[nei] = time + wt;
                    pq.offer(new int[]{dist[nei], nei});
                }
            }
        }

        int maxTime = 0;
        for (int d : dist) {
            if (d == Integer.MAX_VALUE) return -1;
            maxTime = Math.max(maxTime, d);
        }
        return maxTime;
    }
}