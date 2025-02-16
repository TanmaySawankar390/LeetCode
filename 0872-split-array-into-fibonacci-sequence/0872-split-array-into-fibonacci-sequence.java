import java.util.*;

class Solution {
    public List<Integer> splitIntoFibonacci(String num) {
        List<Integer> result = new ArrayList<>();
        backtrack(num, 0, result);
        return result;
    }

    private boolean backtrack(String num, int index, List<Integer> result) {
        if (index == num.length() && result.size() >= 3) {
            return true;
        }

        for (int i = index; i < num.length(); i++) {
            if (num.charAt(index) == '0' && i > index) break;
            
            long numValue = Long.parseLong(num.substring(index, i + 1));
            if (numValue > Integer.MAX_VALUE) break;
            
            int size = result.size();
            if (size >= 2 && numValue > (long) result.get(size - 1) + result.get(size - 2)) {
                break;
            }

            if (size < 2 || numValue == (long) result.get(size - 1) + result.get(size - 2)) {
                result.add((int) numValue);
                if (backtrack(num, i + 1, result)) {
                    return true;
                }
                result.remove(result.size() - 1);
            }
        }
        return false;
    }
}
