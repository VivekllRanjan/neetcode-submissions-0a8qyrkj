class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        compute(0, s, new ArrayList<>(), res);
        return res;
    }

    private void compute(int start, String s, List<String> curr, List<List<String>> res) {
        // base case
        if (start == s.length()) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int end = start; end < s.length(); end++) {
            if (isPalindrome(s, start, end)) {
                curr.add(s.substring(start, end + 1));
                compute(end + 1, s, curr, res);
                curr.remove(curr.size() - 1); // backtrack
            }
        }
    }
    private boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }
}
