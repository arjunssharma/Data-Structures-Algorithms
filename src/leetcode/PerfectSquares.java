package leetcode;

import java.util.Arrays;

public class PerfectSquares {
    public int numSquares(int n) {
        int dp[] = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= (int)Math.sqrt(n); j++) {
                if(i == j * j)
                    dp[i] = 1;
                else if(i > j * j)
                    dp[i] = Math.min(dp[i], dp[i - j*j] + 1);
            }
        }
        
        return dp[n];
    }
}
