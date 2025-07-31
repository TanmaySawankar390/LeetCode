class Solution {
    public int maxProfit(int[] prices) {
        int max = prices[0];
        int min = prices[0];
        int globalsum = 0;
        for(int i = 1; i< prices.length;i++){
            if(min > prices[i]){
                min = prices[i];
            }else{
                int sum = prices[i]- min;
                if(sum > globalsum){
                    globalsum = sum;
                }
            }

        }
        return globalsum;
        
    }
}