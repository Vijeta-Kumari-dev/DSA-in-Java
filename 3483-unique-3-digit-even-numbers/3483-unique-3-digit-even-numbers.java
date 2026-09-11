class Solution{
public int totalNumbers(int[] digits) {
        int[] freq = new int[10];

        for (int d : digits) {
            freq[d]++;
        }

        int count = 0;

        for (int num = 100; num <= 998; num += 2) {
            int x = num;
            int a = x / 100;
            int b = (x / 10) % 10;
            int c = x % 10;

            // Check whether digits are available with correct frequencies
            if (a == b && b == c) {
                if (freq[a] >= 3) count++;
            } 
            else if (a == b) {
                if (freq[a] >= 2 && freq[c] >= 1) count++;
            } 
            else if (a == c) {
                if (freq[a] >= 2 && freq[b] >= 1) count++;
            } 
            else if (b == c) {
                if (freq[b] >= 2 && freq[a] >= 1) count++;
            } 
            else {
                if (freq[a] >= 1 && freq[b] >= 1 && freq[c] >= 1) {
                    count++;
                }
            }
        }

        return count;
    }
}