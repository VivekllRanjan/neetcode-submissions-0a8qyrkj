class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder st = new StringBuilder();
        generate(0, 0, n,res, st);
        return res;
    }

    private void generate(int openN, int closeN, int n, List<String> res, StringBuilder curr) {
        if(openN == closeN && openN == n) {
            res.add(curr.toString());
            return;
        }

        if(openN < n) {
            curr.append('(');
            generate(openN+1, closeN, n, res, curr);

            curr.deleteCharAt(curr.length() - 1);
        }

        if(closeN < openN) {
            curr.append(')');
            generate(openN, closeN+1, n, res, curr);

            curr.deleteCharAt(curr.length() - 1);
        }
    }
}
