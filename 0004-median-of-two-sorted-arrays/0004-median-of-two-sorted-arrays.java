class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i=0,j=0;
        int n=nums1.length,m=nums2.length;
        int k= 0;
        double result =0;
        int arr[] = new int[m+n];
        while(i<n && j<m){
            if(nums1[i]<nums2[j]){
                arr[k++]=nums1[i++];
            }
            else{
                arr[k++]=nums2[j++];
            }
        }
        while(i<n){
            arr[k++]=nums1[i++];
        }
        while(j<m){
            arr[k++]=nums2[j++];
        }
       
        if(k%2==0){
            int ans = arr[k/2-1]+arr[k/2];
            result=(double) ans/2;
        }
        else{
          double ans = (double)arr[k/2];
          result=ans;
        }
        return result;
    }
}