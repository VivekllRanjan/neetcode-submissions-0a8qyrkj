class Solution {

    List<String> res = new ArrayList<>();
        
        String[] mapping = {
            "", "", "abc", "def", "ghi", "jkl",
            "mno", "qprs", "tuv", "wxyz"
        };

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return new ArrayList<>();
        backtrack(0, new StringBuilder(), digits);
        return res;
    }

    private void backtrack(int idx, StringBuilder curr, String d) {
        if(idx == d.length()) {
            res.add(curr.toString());
            return;
        }

        String letters = mapping[d.charAt(idx) - '0'];

        for(char ch : letters.toCharArray()) {
            curr.append(ch); //Choose
            backtrack(idx+1, curr, d); //Build
            curr.deleteCharAt(curr.length() -1); //Backtrack
        }
    }
}
