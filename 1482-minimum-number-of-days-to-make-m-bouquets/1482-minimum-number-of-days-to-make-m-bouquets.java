class Solution {
    public int minDays(int[] bloomDay, int m, int k) {

        // Impossible to make m bouquets
        if ((long) m * k > bloomDay.length) {
            return -1;
        }

        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;

        // Find minimum and maximum bloom days
        for (int day : bloomDay) {
            left = Math.min(left, day);
            right = Math.max(right, day);
        }

        int ans = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            int bouquets = 0;
            int flowers = 0;

            for (int day : bloomDay) {

                if (day <= mid) {
                    // Flower has bloomed
                    flowers++;

                    if (flowers == k) {
                        bouquets++;
                        flowers = 0;
                    }
                } else {
                    // Cannot use this flower
                    flowers = 0;
                }
            }

            if (bouquets >= m) {
                // Possible to make m bouquets
                ans = mid;

                // Try fewer days
                right = mid - 1;
            } else {
                // Not enough bouquets
                // Need more days
                left = mid + 1;
            }
        }

        return ans;
    }
}