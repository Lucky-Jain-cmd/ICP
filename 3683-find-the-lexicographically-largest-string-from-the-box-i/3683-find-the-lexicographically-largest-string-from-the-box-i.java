class Solution {
    public String answerString(String word, int numFriends) {
        int n = word.length();
        if (numFriends == 1) return word;

        String ans = "";
        for (int i = 0; i < n; i++) {
            
            int end = Math.min(n, i + (n - numFriends + 1));
            String prefix = word.substring(i, end);
            if (prefix.compareTo(ans) > 0) {
                ans = prefix;
            }
        }
        return ans;
    }
}
