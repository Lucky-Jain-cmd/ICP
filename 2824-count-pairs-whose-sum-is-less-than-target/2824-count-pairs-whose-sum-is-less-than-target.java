class Solution {
    public int countPairs(List<Integer> nums, int target) {
        int c=0;
     for(int i=0;i<nums.size();i++){
        int sum=0;
        for(int j=i+1;j<nums.size();j++){
            sum = nums.get(i) + nums.get(j);
             if(sum<target) c++;
        }
       
     }
     return c;   
    }
}