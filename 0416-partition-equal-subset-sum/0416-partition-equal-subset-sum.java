class Solution {
    public boolean canPartition(int[] nums) {
        int total=0;
        for(int i=0;i<nums.length;i++){
            total += nums[i];
        }
        int target = total/2;
        Boolean dp[][] = new Boolean[nums.length][target+1]; 
        if(total%2!=0) return false;
        return solve(dp,nums,target,0);
    }
    private Boolean solve(Boolean dp [][],int nums[] , int tar , int i){
        if(tar==0) return true;
        if(i>=nums.length) return false;
        if(dp[i][tar] != null) return dp[i][tar];
        boolean take = false;
        if(nums[i]<=tar){
            take=solve(dp,nums,tar-nums[i],i+1);      
              }
           boolean not_take=solve(dp,nums,tar,i+1); 
            return dp[i][tar] = take||not_take;
    }
    
}