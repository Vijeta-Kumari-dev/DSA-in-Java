import java.util.HashMap;
import java.util.Map;

class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;

        Map<String, Integer> map = new HashMap<>();

        // Store coordinates of 1s in img1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (img1[i][j] == 1) {
                    for (int x = 0; x < n; x++) {
                        for (int y = 0; y < n; y++) {
                            if (img2[x][y] == 1) {
                                int dx = i - x;
                                int dy = j - y;

                                String key = dx + "," + dy;
                                map.put(key, map.getOrDefault(key, 0) + 1);
                            }
                        }
                    }
                }
            }
        }

        int answer = 0;

        for (int count : map.values()) {
            answer = Math.max(answer, count);
        }

        return answer;
    }
}