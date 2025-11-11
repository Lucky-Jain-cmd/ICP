class Solution {
    public int helper(String [] strs,int m,int n,int i,Integer dp[][][]){
        if(i==strs.length){
            return 0;
        }
        if(dp[i][m][n]!=null){
            return dp[i][m][n];
        }
        int not_Pick = helper(strs,m,n,i+1,dp);
        int zeroes =0;
        int ones =0;
        for(char c : strs[i].toCharArray()){
            if(c=='0') zeroes++;
            else ones++;
        }
        int pick=0;
        if(m>=zeroes && n>=ones){
            pick = 1+helper(strs,m-zeroes,n-ones,i+1,dp);
        }
        int result=Math.max(pick,not_Pick);
        dp[i][m][n]=result;
        return dp[i][m][n];
    }
    public int findMaxForm(String[] strs, int m, int n) {
        Integer dp[][][]=new Integer[strs.length+1][m+1][n+1];
        return helper(strs,m,n,0,dp);
    }
}