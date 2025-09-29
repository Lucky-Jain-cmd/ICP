class Solution {
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        int arr[][]= new int[n][n];
        int k=1;
        for(int i=0;i<n;i++){
               
            for(int j=0;j<n;j++){
                    arr[j][n-k]=matrix[i][j];
                    }
                    k++;
        }
          for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                matrix[i][j]=arr[i][j];
            }}
    }
}