class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int prefixproduct = 1;
        int suffixproduct = 1;
        int result[] = new int[n];
        for(int i = 0; i < n; i++) {
            result[i] = prefixproduct;
            prefixproduct *= nums[i];
        }
        for(int i = nums.length-1; i >= 0; i--) {
            result[i] *= suffixproduct;
            suffixproduct *= nums[i];
        }
        return result;
    }
}