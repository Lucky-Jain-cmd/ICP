class Solution {
    public int countPairs(List<Integer> nums, int target) {
        Collections.sort(nums);
        int i=0;
        int j=nums.size()-1;
        int c=0;
        while(i<j){
            if((nums.get(i)+nums.get(j))<target){
            c += j-i;
            i++;
            }
            else
            j--;
        }
    return c;

    }
}