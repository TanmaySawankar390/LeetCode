class Solution {
    public String reorganizeString(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                if (freq[i] > (s.length() + 1) / 2) {
                    return "";
                }
                pq.add(new int[]{i, freq[i]});
            }
        }

        StringBuilder result = new StringBuilder();
        while (pq.size() > 1) {
            int[] first = pq.poll();
            int[] second = pq.poll();

            result.append((char) (first[0] + 'a'));
            result.append((char) (second[0] + 'a'));

            if (--first[1] > 0) pq.add(first);
            if (--second[1] > 0) pq.add(second);
        }

        if (!pq.isEmpty()) {
            result.append((char) (pq.poll()[0] + 'a'));
        }

        return result.toString();
    }
}
