class Solution {
    public int[] sortedSquares(int[] nums) {
        int l=nums.length;
        int result[] = new int[l];
        int i=0,j=l-1,k=l-1;
        while(i<=j){
            if(Math.abs(nums[i])>Math.abs(nums[j])){
                result[k--]=nums[i]*nums[i];
                i++;
            }
            else{
                result[k--]=nums[j]*nums[j];
                j--;
            }
        }
        return result;
    }
}