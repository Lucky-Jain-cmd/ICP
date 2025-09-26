class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start=0;
        int end=nums.length-1;
        int ans_first_occu=-1,ans_sec_occu=-1;
        int arr[] = new int[2];
        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums[mid]==target){
                ans_first_occu=mid;
                end=mid-1;
            }
            else if(nums[mid]<target){
                start=mid+1;
            }
            else{
                end=mid-1;
            }
            }
        arr[0]=ans_first_occu;
        int s=0,e=nums.length-1;
         while(s<=e){
            int mid=s+(e-s)/2;
            if(nums[mid]==target){
                ans_sec_occu=mid;
                s=mid+1;
            }
            else if(nums[mid]>target){
                e=mid-1;
               
            }
            else{
                 s=mid+1;
            }
            }
        arr[1]=ans_sec_occu;
        return arr;
    }
}