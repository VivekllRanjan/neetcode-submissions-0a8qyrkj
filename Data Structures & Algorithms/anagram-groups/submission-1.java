class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String, List<String>> ans = new HashMap<>();

        for(String str : strs) {
            int[] count = new int[26];
            for(char c : str.toCharArray()) count[c - 'a']++;
            String k = Arrays.toString(count);
            ans.computeIfAbsent(k, key -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(ans.values());
    }
}
