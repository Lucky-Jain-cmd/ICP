class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
    //    int arr[]=new int[nums.length-k+1];
    //     for(int i=0;i<=nums.length-k;i++){
    //         int max=nums[i];
    //         for(int j=i;j<i+k;j++){
    //             if(nums[j]>max) max=nums[j];
    //         }
    //         arr[i]=max;
    //     }
    //     return arr;
        int n = nums.length;
        if(n == 0 || k == 0) return new int[0];
        int[] arr = new int[n - k + 1];
        Deque<Integer> dq = new LinkedList<>(); // stores indices

        for(int i = 0; i < n; i++){
            // Remove indices out of window
            while(!dq.isEmpty() && dq.peekFirst() < i - k + 1){
                dq.pollFirst();
            }
            // Remove smaller elements from back
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]){
                dq.pollLast();
            }
            dq.offerLast(i);
            // Store max for the window
            if(i >= k - 1){
                arr[i - k + 1] = nums[dq.peekFirst()];
            }
        }
        return arr;
    

    }
}