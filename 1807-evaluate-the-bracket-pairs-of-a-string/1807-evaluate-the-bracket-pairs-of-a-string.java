import java.util.*;

class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        
        // Store key-value pairs for fast lookup
        Map<String, String> map = new HashMap<>();
        
        for (List<String> pair : knowledge) {
            map.put(pair.get(0), pair.get(1));
        }

        StringBuilder ans = new StringBuilder();
        StringBuilder key = new StringBuilder();
        boolean insideBracket = false;

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                insideBracket = true;
                key.setLength(0);
            }
            else if (ch == ')') {
                insideBracket = false;

                String value = map.getOrDefault(key.toString(), "?");
                ans.append(value);
            }
            else if (insideBracket) {
                key.append(ch);
            }
            else {
                ans.append(ch);
            }
        }

        return ans.toString();
    }
}