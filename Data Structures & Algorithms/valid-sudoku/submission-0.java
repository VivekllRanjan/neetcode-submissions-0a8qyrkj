class Solution {
    public boolean isValidSudoku(char[][] board) {
        //Step 1: Verify all rows
        for(int row = 0; row < 9; row++) {
            Set<Character> seen = new HashSet<>();
            for(int i = 0; i < 9; i++) {
                if(board[row][i] == '.') continue;
                if(seen.contains(board[row][i])) return false;
                seen.add(board[row][i]);
            }
            
        }
        
        //Step 2: Verify all cols
        for(int col = 0; col < 9; col++) {
            Set<Character> seen = new HashSet<>();
            for(int i = 0; i < 9; i++) {
                if(board[i][col] == '.') continue;
                if(seen.contains(board[i][col])) return false;
                seen.add(board[i][col]);
            }
        }

        //Step 3: Verify all the sub 3X3 squares
        // row changes as per / by 3 : 1 2 3
        // col changes as per % by 3 : 1 4 7
        for(int sq = 0; sq < 9; sq++) {
            Set<Character> seen = new HashSet<>();
            for(int i = 0; i < 3; i++) {
                for(int j = 0; j < 3; j++) {
                    int r = (sq / 3) * 3 + i;
                    int c = (sq % 3) * 3 + j;
                    if(board[r][c] == '.') continue;
                    if(seen.contains(board[r][c])) return false;
                    seen.add(board[r][c]);
                }
            }
        }

        return true;
    }
}
