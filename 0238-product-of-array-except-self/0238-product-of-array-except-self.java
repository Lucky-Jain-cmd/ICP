class Solution {
    public int[] productExceptSelf(int[] nums) {
        int c=0;
        int n = nums.length;
        int ans[] = new int[n];
        int m = 1;
        int mm = 1 ;
        if(n==1) {
            ans[0] = nums[0];
            return ans;
        }
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                 c++;
            }
            else{
                m *= nums[i];
            }
        }
        if(c==0){
            for(int i=0;i<n;i++){
                mm *= nums[i];
            }
        }
        if(c>1){
            return ans;
        }

        else if(c==0){
            for(int i=0;i<n;i++)
            ans[i]=mm/nums[i];
        }
        else{
            for(int i=0;i<n;i++){
                if(nums[i]!=0){
                    ans[i]=0;
                }
                else{
                    ans[i]=m;
                }
            }
        }
        return ans;
    }
}
