class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        char arr1[] = s.toCharArray();
        char arr2[] = t.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int n1 = arr1.length;
        int n2 = arr2.length;
        int i=0;
        while(i<n1 && i<n2){
            if(arr1[i]!=arr2[i]){
                return false;
            }
            i++;
        }
        
        return true;
    }
}