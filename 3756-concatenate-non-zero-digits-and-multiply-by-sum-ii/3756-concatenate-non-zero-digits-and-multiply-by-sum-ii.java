class Solution {
    static final long MOD = 1_000_000_007L;

    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();

        int[] nonZeroCount = new int[n];
        long[] numberUpTo = new long[n];
        long[] digitSumUpTo = new long[n];
        long[] pow10 = new long[n + 1];

        pow10[0] = 1;
        for (int i = 1; i <= n; i++) {
            pow10[i] = (pow10[i - 1] * 10) % MOD;
        }

        int first = s.charAt(0) - '0';
        nonZeroCount[0] = (first != 0) ? 1 : 0;
        numberUpTo[0] = (first != 0) ? first : 0;
        digitSumUpTo[0] = first;

        for (int i = 1; i < n; i++) {
            int digit = s.charAt(i) - '0';

            nonZeroCount[i] = nonZeroCount[i - 1] + (digit != 0 ? 1 : 0);

            if (digit != 0)
                numberUpTo[i] = (numberUpTo[i - 1] * 10 + digit) % MOD;
            else
                numberUpTo[i] = numberUpTo[i - 1];

            digitSumUpTo[i] = digitSumUpTo[i - 1] + digit;
        }

        int[] result = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            int beforeCount = (l == 0) ? 0 : nonZeroCount[l - 1];
            int totalCount = nonZeroCount[r];
            int subLen = totalCount - beforeCount;

            if (subLen == 0) {
                result[i] = 0;
                continue;
            }

            long beforeNum = (l == 0) ? 0 : numberUpTo[l - 1];

            long x = (numberUpTo[r]
                    - (beforeNum * pow10[subLen]) % MOD
                    + MOD) % MOD;

            long sum = digitSumUpTo[r]
                    - ((l == 0) ? 0 : digitSumUpTo[l - 1]);

            result[i] = (int) ((x * sum) % MOD);
        }

        return result;
    }
}