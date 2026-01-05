class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        long total_Sum=0;
        int c_Neg = 0;
          int min = Integer.MAX_VALUE;
          boolean zero=false;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                total_Sum += Math.abs(matrix[i][j]);
                if(min>Math.abs(matrix[i][j]))
                min = Math.min(Math.abs(matrix[i][j]),min);
                 if(matrix[i][j]<0) c_Neg++;
                 if(matrix[i][j]==0){
                    zero=true;
                 }
                 
            }
        }
        if(zero){
            return total_Sum;
        }
      
        if(c_Neg%2!=0){
            return total_Sum-2*min;
        }
        return total_Sum;
    }
}