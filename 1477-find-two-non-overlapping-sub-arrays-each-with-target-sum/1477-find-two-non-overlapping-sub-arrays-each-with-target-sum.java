class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int INF = 1000000;

        // dp[i] = minimum length of a valid subarray
        // completely inside indices [0 ... i]
        int[] dp = new int[n];
        
        for (int i = 0; i < n; i++) {
            dp[i] = INF;
        }

        int left = 0;
        int sum = 0;
        int ans = INF;

        for (int right = 0; right < n; right++) {
            sum += arr[right];

            while (sum > target) {
                sum -= arr[left++];
            }

            if (sum == target) {
                int len = right - left + 1;

                // Previous non-overlapping subarray
                if (left > 0 && dp[left - 1] != INF) {
                    ans = Math.min(ans, len + dp[left - 1]);
                }

                dp[right] = len;
            }

            // Carry forward the best subarray found so far
            if (right > 0) {
                dp[right] = Math.min(dp[right], dp[right - 1]);
            }
        }

        return ans == INF ? -1 : ans;
    }
}