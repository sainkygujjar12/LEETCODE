class Solution {
    public long sumAndMultiply(int n) {
        int digit = 0;
        int num = n;

        while (num > 0) {
            digit++;
            num /= 10;
        }

        int[] ans = new int[digit];

        for (int i = digit - 1; i >= 0; i--) {
            ans[i] = n % 10;
            n /= 10;
        }

        long res = 0;
        int sum = 0;

        for (int d : ans) {
            if (d != 0) {
                res = res * 10 + d;
                sum += d;
            }
        }

        return res * sum;
    }
}