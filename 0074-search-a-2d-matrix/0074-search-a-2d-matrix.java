class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length, n=matrix[0].length;

        int start=0;
        int end=n*m-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            int row = mid/n;
            int column = mid%n;
            int value = matrix[row][column];
            if(value==target) return true;
            else if(value>target) end=mid-1;
            else start=mid+1;
        }
        return false;
        
    }
}