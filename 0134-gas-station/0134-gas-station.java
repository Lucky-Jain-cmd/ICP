class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int tgas=0;
        int tcost=0;
        int capacity=0;
        int start = 0;
        for(int i=0;i<gas.length;i++){
            tgas += gas[i];
            tcost += cost[i];
            capacity += gas[i]-cost[i];
            if(capacity<0){
                start=i+1;
                capacity=0;
            }
        }
        return tgas<tcost ? -1 : start;
    }
}