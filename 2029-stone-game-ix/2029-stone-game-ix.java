class Solution {
    public boolean stoneGameIX(int[] stones) {
        // Count frequencies of stones based on their remainders when divided by 3
        int[] count = new int[3];
        for (int stone : stones) {
            count[stone % 3]++;
        }
        
        // Case 1: The number of remainder 0 stones is even
        if (count[0] % 2 == 0) {
            // Alice can win if there is at least one stone of type 1 and one stone of type 2
            return Math.min(count[1], count[2]) > 0;
        }
        
        // Case 2: The number of remainder 0 stones is odd
        // Alice can win if one side has more than 2 extra stones to shift the final turn penalty
        return Math.abs(count[1] - count[2]) > 2;
    }
}