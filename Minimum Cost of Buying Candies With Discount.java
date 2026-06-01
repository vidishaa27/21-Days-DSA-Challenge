class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int sum = 0;
        for (int i = 0, j = cost.length - 1; i < j; i++, j--) {
            int temp = cost[i];
            cost[i] = cost[j];
            cost[j] = temp;
        } 
        for (int i = 0; i < cost.length; i++) {
            if((i+1)%3 != 0) {
                sum += cost[i];
            }
            else continue;
        }
        return sum;
    }
}