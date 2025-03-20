import java.util.*;

class Solution {
    int[] nums;
    int[] tree;
    boolean[] peaks;
    int n;

    public List<Integer> countOfPeaks(int[] nums, int[][] queries) {
        this.nums = nums;
        this.n = nums.length;
        this.peaks = new boolean[n];
        this.tree = new int[4 * n];
        for (int i = 1; i < n - 1; i++) {
            peaks[i] = isPeak(i);
        }
        build(0, 0, n - 1);

        List<Integer> result = new ArrayList<>();

        for (int[] query : queries) {
            if (query[0] == 1) {
                int l = query[1];
                int r = query[2];
                if (l >= r) {
                    result.add(0);
                } else {
                    result.add(query(0, 0, n - 1, l + 1, r - 1));
                }
            } else if (query[0] == 2) {
                int index = query[1];
                int value = query[2];
                update(index, value);
            }
        }

        return result;
    }
    private boolean isPeak(int i) {
        if (i <= 0 || i >= n - 1) return false;
        return nums[i] > nums[i - 1] && nums[i] > nums[i + 1];
    }
    private void build(int node, int left, int right) {
        if (left == right) {
            tree[node] = peaks[left] ? 1 : 0;
            return;
        }
        int mid = (left + right) / 2;
        build(2 * node + 1, left, mid);
        build(2 * node + 2, mid + 1, right);
        tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
    }
    private int query(int node, int left, int right, int l, int r) {
        if (left > r || right < l) return 0;
        if (left >= l && right <= r) return tree[node];
        int mid = (left + right) / 2;
        return query(2 * node + 1, left, mid, l, r) + query(2 * node + 2, mid + 1, right, l, r);
    }
    private void update(int index, int value) {
        nums[index] = value;
        updatePeak(index - 1);
        updatePeak(index);
        updatePeak(index + 1);
    }

    private void updatePeak(int index) {
        if (index <= 0 || index >= n - 1) return;

        boolean newPeak = isPeak(index);
        if (peaks[index] != newPeak) {
            peaks[index] = newPeak;
            updateTree(0, 0, n - 1, index, newPeak ? 1 : 0);
        }
    }

    private void updateTree(int node, int left, int right, int index, int value) {
        if (left == right) {
            tree[node] = value;
            return;
        }
        int mid = (left + right) / 2;
        if (index <= mid) {
            updateTree(2 * node + 1, left, mid, index, value);
        } else {
            updateTree(2 * node + 2, mid + 1, right, index, value);
        }
        tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
    }
}
