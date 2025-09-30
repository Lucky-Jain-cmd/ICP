import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) return result;

        int[] freqP = new int[26];
        int[] freqS = new int[26];
        for (char c : p.toCharArray()) {
            freqP[c - 'a']++;
        }

        int windowSize = p.length();

        for (int i = 0; i < s.length(); i++) {
            freqS[s.charAt(i) - 'a']++;

            if (i >= windowSize) {
                freqS[s.charAt(i - windowSize) - 'a']--;
            }

            if (Arrays.equals(freqP, freqS)) {
                result.add(i - windowSize + 1);
            }
        }

        return result;
    }
}
