class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String, List<String>> map = new HashMap<>();
        for(String st : strs) {
            int[] count = new int[26];
            for(char c : st.toCharArray()) {
                count[c - 'a']++;
            }
            String key = Arrays.toString(count);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(st);
        }

        return new ArrayList<>(map.values());
    }
}
