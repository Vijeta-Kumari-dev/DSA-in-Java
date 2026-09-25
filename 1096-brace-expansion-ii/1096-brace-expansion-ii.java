import java.util.*;

class Solution {

    private Set<String> parse(String s, int[] index) {
        Set<String> result = new TreeSet<>();
        Set<String> current = new TreeSet<>();
        current.add("");

        while (index[0] < s.length() && s.charAt(index[0]) != '}') {

            if (s.charAt(index[0]) == ',') {
                result.addAll(current);
                current.clear();
                current.add("");
                index[0]++;
            } 
            else {
                Set<String> next = new TreeSet<>();

                if (s.charAt(index[0]) == '{') {
                    index[0]++; // skip {
                    next = parse(s, index);
                    index[0]++; // skip }
                } 
                else {
                    next.add(String.valueOf(s.charAt(index[0])));
                    index[0]++;
                }

                Set<String> temp = new TreeSet<>();

                for (String a : current) {
                    for (String b : next) {
                        temp.add(a + b);
                    }
                }

                current = temp;
            }
        }

        result.addAll(current);
        return result;
    }

    public List<String> braceExpansionII(String expression) {
        int[] index = {0};

        Set<String> result = parse(expression, index);

        return new ArrayList<>(result);
    }
}