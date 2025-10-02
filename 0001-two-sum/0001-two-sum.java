class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n=nums.length;
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<n;i++){
            int remaining=target-nums[i];
            if(hm.containsKey(remaining)){
                return new int[]{i,hm.get(remaining)};
            }
            hm.put(nums[i],i);
        }
        return new int[]{};
    }
}