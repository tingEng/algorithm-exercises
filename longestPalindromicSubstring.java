class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int n = s.length();
        int longest = 1;
        int start = 0;
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (i == j) {
                    dp[i][j] = true;
                } else {
                    dp[i][j] = s.charAt(i) == s.charAt(j) && ( j == i + 1 || dp[i+ 1][j - 1]);
                }
                if (dp[i][j] && longest < j - i + 1) {
                    start = i;
                    longest = j - i + 1;
                }
            }
        }
        return s.substring(start, start + longest);
    }
}