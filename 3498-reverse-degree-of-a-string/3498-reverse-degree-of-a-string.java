class Solution {
    public int reverseDegree(String s) {
        int sum=0;
        for(int i=0; i<s.length(); i++){
            int value=s.charAt(i)-'a' +1;
            int reverseValue = 27- value;
            sum += reverseValue *(i + 1);
        }
        return sum;
        
    }
}