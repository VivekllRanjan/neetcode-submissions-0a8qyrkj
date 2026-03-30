class Solution {
    public int characterReplacement(String s, int k) {
        HashSet<Character> charSet = new HashSet<>();
        for(char c : s.toCharArray()) {
            charSet.add(c);
        }
        int res = 0;

        for(char c : charSet) {
            int count = 0, l = 0;
            for(int r = 0; r < s.length(); r++) {
                if(s.charAt(r) == c) count++;
                while((r - l + 1) - count > k) {
                    if(s.charAt(l) == c) count--;
                    l++;
                }
                res = Math.max(res, r - l + 1);
            }
        }

        return res;
    }
}

//0 1 2 3 4 5 6
//X Y X X Z Z X  k=1       X Y Z
//1 1 2 3 3
//total char - count should be less than k so that window is valid