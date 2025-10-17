class Solution {
    public int maxProduct(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int left_pro = 1;
        int right_pro = 1;
        for(int i=0;i<nums.length;i++){
            left_pro *= nums[i];
            right_pro *= nums[nums.length-1-i];
            ans = Math.max(ans,Math.max(left_pro,right_pro));
            if(left_pro == 0) left_pro = 1;
            if(right_pro==0) right_pro = 1; 
        }
        return ans;
    }
}