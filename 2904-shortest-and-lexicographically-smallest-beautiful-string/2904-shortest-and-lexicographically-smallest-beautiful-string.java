class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        String answer = "";

        int left = 0;
        int right = 0;
        int n = s.length();
        int ones = 0;

        while(right<n){
            if(s.charAt(right)=='1') ones++;

            while(ones>k){
                if(s.charAt(left)=='1') ones--;
                left++;
            }

            if (ones == k) {

                // Remove unnecessary zeros from the left
                while (s.charAt(left) == '0') {
                    left++;
                }

                String current = s.substring(left, right + 1);

                // First valid answer
                if (answer.equals("")) {
                    answer = current;
                }

                // Shorter substring
                else if (current.length() < answer.length()) {
                    answer = current;
                }

                // Same length -> lexicographically smaller
                else if (current.length() == answer.length()
                        && current.compareTo(answer) < 0) {
                    answer = current;
                }
            }
            right++;
        }
        return answer;
    }
}