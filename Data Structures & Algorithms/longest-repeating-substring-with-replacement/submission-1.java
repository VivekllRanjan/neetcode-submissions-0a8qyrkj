class Solution {
    public int characterReplacement(String s, int k) {
        int maxFreq = 0, l = 0, res = 0;
        int[] freq = new int[26];

        for(int r = 0; r < s.length(); r++) {
            freq[s.charAt(r) - 'A']++;
            maxFreq = Math.max(maxFreq, freq[s.charAt(r) - 'A']);
            while((r - l + 1) - maxFreq > k) {
                freq[s.charAt(l) - 'A']--;
                l++;
            }

            res = Math.max(res, r-l+1);
        }
        return res;
    }
}