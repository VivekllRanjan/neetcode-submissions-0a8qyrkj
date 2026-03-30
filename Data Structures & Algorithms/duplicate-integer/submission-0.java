class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set <Integer> seen = new HashSet<>();
        for(int a : nums) {
            if(seen.contains(a)) return true;
            seen.add(a);
        }

        return false;
    }
}