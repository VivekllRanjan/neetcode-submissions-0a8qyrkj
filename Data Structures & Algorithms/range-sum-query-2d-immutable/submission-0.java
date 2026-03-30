class NumMatrix {

    private int prefix[][];
    
    public NumMatrix(int[][] matrix) {
        int row = matrix.length + 1, col = matrix[0].length + 1;
        prefix = new int [row][col];
        for(int i = 1; i < row; i++) { 
            for(int j = 1; j < col; j++) {
                prefix[i][j] = prefix[i - 1][j] 
                                + prefix[i][j - 1] 
                                - prefix[i-1][j-1] 
                                + matrix[i - 1][j - 1];
            }
        }
        
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        row1++; row2++; col1++; col2++;

        int ans = prefix[row2][col2]
                    - prefix[row1 - 1][col2]
                    - prefix[row2][col1 - 1]
                    + prefix[row1 - 1][col1 - 1];

        return ans;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */