class Solution {
    public boolean isPalindrome(int x) {
        int store = 0;
        int k = x;
        while(x > 0){
            int a = x%10;
            store = store* 10 + a;
            x = x/10;        
        }
        if(store == k){
            return true;
        }else{
            return false;
        }
    }
}