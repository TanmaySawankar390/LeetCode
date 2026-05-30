class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int n = words.length;
        int i = 0;

        while (i < n) {
            int j = i;
            int wordsLen = 0;

            // Find words that fit in current line
            while (j < n &&
                   wordsLen + words[j].length() + (j - i) <= maxWidth) {
                wordsLen += words[j].length();
                j++;
            }

            int numWords = j - i;
            StringBuilder line = new StringBuilder();

            // Last line OR only one word
            if (j == n || numWords == 1) {
                for (int k = i; k < j; k++) {
                    line.append(words[k]);
                    if (k < j - 1) {
                        line.append(" ");
                    }
                }

                while (line.length() < maxWidth) {
                    line.append(" ");
                }
            } 
            else {
                int totalSpaces = maxWidth - wordsLen;
                int gaps = numWords - 1;

                int spacePerGap = totalSpaces / gaps;
                int extraSpaces = totalSpaces % gaps;

                for (int k = i; k < j; k++) {
                    line.append(words[k]);

                    if (k < j - 1) {
                        int spaces = spacePerGap;

                        if (extraSpaces > 0) {
                            spaces++;
                            extraSpaces--;
                        }

                        for (int s = 0; s < spaces; s++) {
                            line.append(" ");
                        }
                    }
                }
            }

            result.add(line.toString());
            i = j;
        }

        return result;
    }
}