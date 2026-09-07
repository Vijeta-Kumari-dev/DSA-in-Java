class Solution {
public:
    int distinctSubseqII(string s) {
        const long long MOD = 1e9 + 7;
        long long last[26] = {0};   // last dp value (before update) for each char, 0 = not seen
        long long dp = 1;           // dp represents (count + 1), so "not seen" naturally = 0 contributes correctly

        for (char ch : s) {
            int c = ch - 'a';
            long long newDp = (2 * dp - last[c] + MOD) % MOD;
            last[c] = dp;
            dp = newDp;
        }

        return (int)((dp - 1 + MOD) % MOD); // subtract 1 for the empty subsequence
    }
};