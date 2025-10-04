class Solution {
    public static void parenthesis(ArrayList<String> ans,int n,int open,int close,String s){
        if(open+close==2*n && open==close){
            ans.add(s);
            return;
        }
        if(open<n){
             parenthesis(ans,n,open+1,close,s+"(");
        }
         if(close<open){
             parenthesis(ans,n,open,close+1,s+")");
        }

    }
    public List<String> generateParenthesis(int n) {
        ArrayList<String> ans = new ArrayList<>();
        parenthesis(ans,n,0,0,"");
        return ans;
    }
}