class Solution {
    public boolean contains(int arr[],int original){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==original) return true;
        }
        return false;
    }
    public int findFinalValue(int[] nums, int original) {
        int ans=-1;
         while(contains(nums, original)) {
                original = original * 2;
            }
        
        return original;
    }
}