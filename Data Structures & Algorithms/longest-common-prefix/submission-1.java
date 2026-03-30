class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        Arrays.sort(strs);

        String f = strs[0];
        String l = strs[strs.length - 1];

        //shrink f
        while(!l.startsWith(f)) {
            if (f.isEmpty()) return "";
            f = f.substring(0, f.length() - 1);
        }

        return f;
    }
}