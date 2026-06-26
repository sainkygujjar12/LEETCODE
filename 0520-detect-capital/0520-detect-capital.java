class Solution {
    public boolean detectCapitalUse(String word) {

        int n = word.length();

        if (n == 1)
            return true;

        boolean case1 = false; // ALL UPPERCASE
        boolean case2 = false; // all lowercase
        boolean case3 = false; // First uppercase, rest lowercase

        if (Character.isLowerCase(word.charAt(0))) {
            case2 = true;
        } else if (Character.isUpperCase(word.charAt(1))) {
            case1 = true;
        } else {
            case3 = true;
        }

        for (int i = 1; i < n; i++) {

            if (case1 && Character.isLowerCase(word.charAt(i)))
                return false;

            if ((case2 || case3) && Character.isUpperCase(word.charAt(i)))
                return false;
        }

        return true;
    }
}