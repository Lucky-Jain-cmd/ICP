class Solution {
    public static int sum(int n){
         int sum=0;
        while(n!=0){
            int rem=n%10;
            sum += rem*rem;
            n=n/10;
        }
        return sum;
    }
    public boolean isHappy(int n) {
        HashSet<Integer> hs = new HashSet<>();
      while(n!=1 && !hs.contains(n)){
       hs.add(n);
       n = sum(n);
      } 
      return n==1 ;
  
    } 
}