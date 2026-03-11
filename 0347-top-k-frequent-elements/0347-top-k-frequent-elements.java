class Solution {
    public int[] topKFrequent(int[] arr, int k) {
        

         int n = arr.length;
            HashMap<Integer,Integer> hm = new HashMap<>();
            for(int i=0;i<n;i++){
                hm.put(arr[i],hm.getOrDefault(arr[i],0)+1);
            }
            List<Integer> al = new ArrayList<>(hm.keySet());
            Collections.sort(al,(a,b)-> {
                int fa = hm.get(a);
                int fb = hm.get(b);
            if(fa!=fb){
                return fb-fa;  }
            else {
                return b-a; 
        }});
            int res[] = new int[k];
            for(int i=0;i<k;i++){
                res[i]=al.get(i);
            }
            return res;
        
    }
}