class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for(int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] freq = new ArrayList[nums.length + 1];
        for(int i = 0; i < freq.length; i++){
            freq[i] = new ArrayList<>();
        }

        for(Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            int f = entry.getValue();
            int n = entry.getKey();

            freq[f].add(n);
        }

        int[] ans = new int[k];
        int idx = 0;

        for(int i = freq.length - 1; i>=0 && idx < k; i--) {
            for(int n : freq[i]) {
                ans[idx++] = n;
                if(idx == k) return ans;
            }
        }

        return ans;
    }
}
