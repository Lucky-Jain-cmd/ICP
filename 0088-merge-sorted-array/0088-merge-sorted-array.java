class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        ArrayList<Integer> al = new ArrayList<>();
        int i=0,j=0;
        while(i<m && j<n){
            if(nums1[i]<nums2[j]){
                al.add(nums1[i++]);
            }
            else{
                al.add(nums2[j++]);
            }}
            while(i<m){
                al.add(nums1[i++]);
            }
            while(j<n){
                al.add(nums2[j++]);
            }
        int k=al.size();
        for(i=0;i<k;i++){
            nums1[i]=al.get(i);
        }
    }
}