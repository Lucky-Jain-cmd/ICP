class Solution {
    public int rob(int[] arr) {
         int n=arr.length;
        int m[] = new int[n];
        m[0]=arr[0];
        if(n!=1)
        m[1]=Math.max(arr[0],arr[1]);
        for(int i=2;i<n;i++){
            m[i]=Math.max(arr[i]+m[i-2],m[i-1]);
            
        }
        return m[n-1];
    }
}