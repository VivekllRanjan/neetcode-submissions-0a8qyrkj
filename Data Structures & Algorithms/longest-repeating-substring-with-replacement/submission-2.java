class Solution {
    public int characterReplacement(String s, int k) {
        Set<Character> set = new HashSet<>();
        for(char ch : s.toCharArray()){
            set.add(ch);
        }
        int res = 0;
        for(char ch : set) {
            int count = 0, l = 0;
            for(int r = 0; r < s.length(); r++) {
                if(s.charAt(r) == ch) {
                    count++;
                }
                while((r-l+1) - count > k) {
                    if(s.charAt(l) == ch){
                        count--;
                    }
                    l++;
                }
                res = Math.max(res, r - l + 1);
            }
        }

        return res;
    }
}
