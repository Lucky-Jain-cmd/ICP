class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> al=new ArrayList<>();
        int m=matrix.length,n=matrix[0].length;
        int left=0,right=n-1;
        int top=0,bottom=m-1;
        while(left<=right && top<=bottom){
            for(int i=left;i<=right;i++){
                al.add(matrix[top][i]);
            } top++;
            for(int j=top;j<=bottom;j++){
                al.add(matrix[j][right]);
            } right--;
            if(top<=bottom){
                for(int k=right;k>=left;k--){
                    al.add(matrix[bottom][k]);
                } }bottom--;
                if(left<=right){
                    for(int i=bottom;i>=top;i--){
                        al.add(matrix[i][left]);
                    } left++;
                }
            }
            return al;
        
    }
}