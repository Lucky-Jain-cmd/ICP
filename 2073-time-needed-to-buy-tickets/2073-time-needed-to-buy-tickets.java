class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int n = tickets.length;
        Queue<Integer> q = new LinkedList<>();
        int t = 0;
        for(int i=0;i<n;i++){
            q.add(i);
        }
        while(!q.isEmpty()){
            t++;
            int front = q.poll();
            tickets[front]--;
            if(tickets[front]!=0){
                q.add(front);
            }
            else if(front==k){
                return t;
            }
        }
        return t;
    }
}