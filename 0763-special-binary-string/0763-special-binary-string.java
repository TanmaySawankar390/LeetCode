import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public String makeLargestSpecial(String s) {
        if (s.length() <= 2) return s;
        
        ArrayList<String> specials = new ArrayList<>();
        int count = 0, start = 0;
        
        for (int i = 0; i < s.length(); i++) {
            count += s.charAt(i) == '1' ? 1 : -1;
            if (count == 0) {
                String inner = makeLargestSpecial(s.substring(start + 1, i));
                specials.add("1" + inner + "0");
                start = i + 1;
            }
        }
        
        Collections.sort(specials, Collections.reverseOrder());
        return String.join("", specials);
    }
}
