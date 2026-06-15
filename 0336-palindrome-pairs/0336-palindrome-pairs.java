class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ans = new ArrayList<>();

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int n = word.length();

            for (int cut = 0; cut <= n; cut++) {
                String left = word.substring(0, cut);
                String right = word.substring(cut);

                if (isPalindrome(left)) {
                    String revRight = new StringBuilder(right).reverse().toString();
                    Integer idx = map.get(revRight);

                    if (idx != null && idx != i) {
                        ans.add(Arrays.asList(idx, i));
                    }
                }

                if (cut != n && isPalindrome(right)) {
                    String revLeft = new StringBuilder(left).reverse().toString();
                    Integer idx = map.get(revLeft);

                    if (idx != null && idx != i) {
                        ans.add(Arrays.asList(i, idx));
                    }
                }
            }
        }

        return ans;
    }

    private boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;

        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) {
                return false;
            }
        }
        return true;
    }
}