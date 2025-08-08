class Solution {
    public void reverseString(char[] s) {
        int start = 0;
        int close = s.length-1;
        while(start < close){
            char temp = s[start];
            s[start] = s[close];
            s[close] = temp;
            start++;
            close--;
        }
        System.out.println(Arrays.toString(s));
    }
}