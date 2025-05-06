import java.util.*;

class Solution {
    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        int[] parent = new int[n];
        
        for (int i = 0; i < n; i++) parent[i] = i;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isSimilar(strs[i], strs[j])) {
                    union(parent, i, j);
                }
            }
        }

        Set<Integer> groups = new HashSet<>();
        for (int i = 0; i < n; i++) {
            groups.add(find(parent, i));
        }

        return groups.size();
    }

    private boolean isSimilar(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
                if (diff > 2) return false;
            }
        }
        return diff == 0 || diff == 2;
    }

    private int find(int[] parent, int x) {
        if (parent[x] != x) parent[x] = find(parent, parent[x]);
        return parent[x];
    }

    private void union(int[] parent, int x, int y) {
        int rootX = find(parent, x);
        int rootY = find(parent, y);
        if (rootX != rootY) parent[rootX] = rootY;
    }
}
