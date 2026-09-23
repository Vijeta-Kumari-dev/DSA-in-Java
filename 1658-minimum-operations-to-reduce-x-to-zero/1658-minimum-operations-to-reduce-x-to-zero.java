class Solution {
    public int minOperations(int[] nums, int x) {
        int total = 0;

        // Calculate total sum
        for (int num : nums) {
            total += num;
        }

        int target = total - x;

        // If target is negative, impossible
        if (target < 0) {
            return -1;
        }

        int left = 0;
        int sum = 0;
        int maxLen = -1;

        // Find the longest subarray with sum = target
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (sum > target && left <= right) {
                sum -= nums[left];
                left++;
            }

            if (sum == target) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }

        // If no such subarray exists
        if (maxLen == -1) {
            return -1;
        }

        return nums.length - maxLen;
    }
}