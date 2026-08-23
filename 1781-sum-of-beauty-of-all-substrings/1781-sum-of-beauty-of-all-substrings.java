class Solution {
    public int beautySum(String s) {
        int sum = 0;
        int n = s.length();

        for(int i = 0; i < n; i++) {
            int map[] = new int[26];
            for(int j = i; j < n; j++) {
                map[s.charAt(j) - 'a']++;

                int mini = Integer.MAX_VALUE;
                int maxi = 0;

                for(int val : map) {
                    if(val > 0) { 
                        mini = Math.min(val , mini);
                        maxi = Math.max(val, maxi);
                    }
                }
                sum += (maxi - mini);
            }
        }
        return sum;
    }
}