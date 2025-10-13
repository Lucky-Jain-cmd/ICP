class Solution {
    public boolean checkInclusion(String st1, String st2) {
        int s1 =st1.length();
        int s2 =st2.length();
        if(s1>s2) return false;
        char ch[] = st1.toCharArray();
        Arrays.sort(ch);
        for(int i=0;i<=s2-s1;i++){
            String sb = st2.substring(i,i+s1);
            char ch2[] = sb.toCharArray();
            Arrays.sort(ch2);
            if(Arrays.equals(ch,ch2)){
                return true;
            }
        }

            return false;
     }
}