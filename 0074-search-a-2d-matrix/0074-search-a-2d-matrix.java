class Solution {
    public boolean row(int arr[],int target){
          int start=0,end=arr.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]==target) return true;
            else if(arr[mid]>target){
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return false;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length, n=matrix[0].length;
      
        for(int i=0;i<m;i++){
            if(target>=matrix[i][0] && target<=matrix[i][n-1] ){
                return row(matrix[i],target);
            }
        }
        return false;
    }
}