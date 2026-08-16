class Solution {
public:
    bool stoneGameIX(vector<int>& stones) {
        // Count frequencies of stone values modulo 3
        vector<int> count(3, 0);
        for (int stone : stones) {
            count[stone % 3]++;
        }
        
        // Case 1: The number of stones with remainder 0 is even
        if (count[0] % 2 == 0) {
            // Alice needs at least one of each to play optimally and win
            return min(count[1], count[2]) > 0;
        }
        
        // Case 2: The number of stones with remainder 0 is odd
        // Alice needs a significant difference to force Bob into losing
        return abs(count[1] - count[2]) > 2;
    }
};