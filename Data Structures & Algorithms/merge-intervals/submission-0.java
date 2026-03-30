class Solution {
    public int[][] merge(int[][] a) {
        Arrays.sort(a, (x, y) -> x[0] - y[0]);
        List<int[]> res = new ArrayList<>();

        for (int[] i : a) {
            if (res.isEmpty() || res.get(res.size()-1)[1] < i[0]) {
                res.add(i);
            } else {
                res.get(res.size()-1)[1] = Math.max(res.get(res.size()-1)[1], i[1]);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}