class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int i=0,j=nums.length-1;
        int maxi=0;
        while(i<j){
            int sum=nums[i]+nums[j];
            maxi=Math.max(maxi,sum);
            i++;
            j--;
        }
        return maxi;
    }
}