class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int left = 0, right = 0; // sliding window boundaries
        int maxLength = 0;
        HashSet<Character> set = new HashSet<>();

        while (right < n) {
            char c = s.charAt(right);
            
            // If duplicate found, move left pointer until it's removed
            while (set.contains(c)) {
                set.remove(s.charAt(left));
                left++;
            }

            // Add current character and update maxLength
            set.add(c);
            maxLength = Math.max(maxLength, right - left + 1);

            right++;
        }
        return maxLength;
    }
}
