class Solution {
    public int smallestNumber(int n, int t) {
        for(int i = n; i <= 100; i++) {
            if(check(i,t))
                return i;
        }
        return -1;
    }

    private boolean check(int x, int t) {
        int prod = 1;
        while(x > 0) {
            prod *= x % 10;
            x /= 10;
        }
        return prod % t == 0;
    }
}