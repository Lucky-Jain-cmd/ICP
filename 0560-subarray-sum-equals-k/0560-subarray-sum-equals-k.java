class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Long,Integer> hm = new HashMap<>();
        int count=0;
        long prefix=0;
        hm.put(0L,1);
        for(int num :nums){
            prefix += num;
            long need = prefix-k;
            if(hm.containsKey(need)){
                count += hm.get(need);
            }
            hm.put(prefix,hm.getOrDefault(prefix,0)+1);
        }
        return count;
    }
}