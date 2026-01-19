class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int n1 = ransomNote.length();
        int n2 = magazine.length();
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i=0;i<n2;i++){
    hm.put(magazine.charAt(i),hm.getOrDefault(magazine.charAt(i),0)+1);
        }
        for(int i=0;i<n1;i++){
            char ch = ransomNote.charAt(i);
            if(!hm.containsKey(ch) || hm.get(ch)==0){
                return false;
            }
            hm.put(ch,hm.get(ch)-1);
        }
        return true;
    }
}