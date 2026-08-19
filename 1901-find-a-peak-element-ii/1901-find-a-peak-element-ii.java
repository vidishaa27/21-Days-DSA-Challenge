class Solution {
    public int[] findPeakGrid(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;

        int low = 0;
        int high = n - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            // Find the maximum element in column mid
            int maxRow = 0;

            for (int i = 1; i < m; i++) {
                if (mat[i][mid] > mat[maxRow][mid]) {
                    maxRow = i;
                }
            }

            // Check left and right neighbors
            int left = (mid == 0) ? -1 : mat[maxRow][mid - 1];
            int right = (mid == n - 1) ? -1 : mat[maxRow][mid + 1];

            // Current element is greater than both
            if (mat[maxRow][mid] > left &&
                mat[maxRow][mid] > right) {

                return new int[]{maxRow, mid};
            }

            // Right neighbor is greater -> search right half
            if (right > mat[maxRow][mid]) {
                low = mid + 1;
            }

            // Left neighbor is greater -> search left half
            else {
                high = mid - 1;
            }
        }

        return new int[]{-1, -1};
    }
}