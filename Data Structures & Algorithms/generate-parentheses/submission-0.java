class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder st = new StringBuilder();
        backtrack(0, 0, n,res, st);
        return res;
    }

    private void backtrack(int openN, int closeN, int n, List<String> res, StringBuilder st) {
        if(openN == closeN && openN == n) {
            res.add(st.toString());
            return;
        }

        if(openN < n) {
            st.append('(');
            backtrack(openN + 1, closeN, n, res, st);
            
            st.deleteCharAt(st.length() - 1);
        }

        if(closeN < openN) {
            st.append(')');
            backtrack(openN, closeN + 1, n, res, st);

            st.deleteCharAt(st.length() - 1);
        }
    }
}
