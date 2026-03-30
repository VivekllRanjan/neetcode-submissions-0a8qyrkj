class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        int n = queries.length;
        int[][] q = new int[n][2];

        for (int i = 0; i < n; i++) {
            q[i][0] = queries[i];
            q[i][1] = i;
        }
        Arrays.sort(q, (a, b) -> a[0] - b[0]);

        int[] res = new int[n];
        Arrays.fill(res, -1);

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int i = 0;

        for (int[] query : q) {
            int val = query[0];
            int idx = query[1];

            //Add valid intervals
            while(i < intervals.length && intervals[i][0] <= val) {
                int l = intervals[i][0];
                int r = intervals[i][1];
                minHeap.offer(new int[] {r-l+1, r});
                i++;
            }

            // Remove intervals that cannot cover query
            while (!minHeap.isEmpty() && minHeap.peek()[1] < val) {
                minHeap.poll();
            }

            // Top = smallest valid interval
            if (!minHeap.isEmpty()) {
                res[idx] = minHeap.peek()[0];
            }
        }

        return res;
    }
}