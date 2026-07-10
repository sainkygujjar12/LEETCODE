class Solution {
    public int largestVariance(String s) {
        int res = 0;

        for (char a = 'a'; a <= 'z'; a++) {
            for (char b = 'a'; b <= 'z'; b++) {

                if (a == b) continue;
                if (!s.contains(String.valueOf(a)) || !s.contains(String.valueOf(b)))
                    continue;

                int first = 0;
                int second = 0;
                boolean past = false;

                for (int k = 0; k < s.length(); k++) {

                    if (s.charAt(k) == a) first++;
                    if (s.charAt(k) == b) second++;

                    if (second > 0) {
                        res = Math.max(res, first - second);
                    } else if (past) {
                        res = Math.max(res, first - 1);
                    }

                    if (second > first) {
                        first = 0;
                        second = 0;
                        past = true;
                    }
                }
            }
        }

        return res;
    }
}