class Solution {
    public int beautySum(String s) {
        int sum = 0;
        int n = s.length();

        for(int i = 0; i < n; i++) {
            HashMap<Character, Integer> map = new HashMap<>();
            for(int j = i; j < n; j++) {
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0)+1);

                int mini = Integer.MAX_VALUE;
                int maxi = Integer.MIN_VALUE;

                for(int val : map.values()) {
                    mini = Math.min(val , mini);
                    maxi = Math.max(val, maxi);
                }
                sum += (maxi - mini);
            }
        }
        return sum;
    }
}