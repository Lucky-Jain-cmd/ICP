class Solution {
    public boolean palin(int i,int j, String s){
        while(i<j){
        if(s.charAt(i)!=s.charAt(j)){
            return false;
        }
        
            i++;
            j--;
        }
        return true;
    }
    public boolean validPalindrome(String s) {
        int i=0 , j=s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return palin(i+1,j,s)||palin(i,j-1,s);}
                else{
                    i++;
                    j--;
                }
            }
            return true;
        }
    }
