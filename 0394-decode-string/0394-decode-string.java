import java.util.Stack;

class Solution {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> resultStack = new Stack<>();
        StringBuilder current = new StringBuilder();
        int k = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                k = k * 10 + (c - '0');
            } else if (c == '[') {
                countStack.push(k);
                resultStack.push(current);
                k = 0;
                current = new StringBuilder();
            } else if (c == ']') {
                int repeatTimes = countStack.pop();
                StringBuilder previous = resultStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    previous.append(current);
                }
                current = previous;
            } else {
                current.append(c);
            }
        }

        return current.toString();
    }
}
