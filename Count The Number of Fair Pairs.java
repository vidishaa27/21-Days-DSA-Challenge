class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
         Arrays.sort(nums);

        return countPairs(nums, upper) - countPairs(nums, (long) lower - 1);
    }

    private long countPairs(int[] nums, long target) {
        int left = 0;
        int right = nums.length - 1;
        long count = 0;

        while (left < right) {
            long sum = (long) nums[left] + nums[right];

            if (sum <= target) {
                count += (right - left);
                left++;
            } else {
                right--;
            }
        }

        return count;
    }
}