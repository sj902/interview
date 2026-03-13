package com.sj0902.dp;

public class MinSteps {
    int target;
    Integer[][] dp;

    public int minSteps(int n) {
        dp = new Integer[n + 1][n + 1];
        target = n;
        if (n == 1) {
            return 0;
        }
        return 1 + aux(1, 1);
    }

    private int aux(int screen, int clipboard) {
        if (screen == target) return 0;
        if(dp[screen][clipboard] != null) return dp[screen][clipboard];
        if (screen > target) return target;

        if (screen == clipboard) {
            return dp[screen][clipboard] = 1 + aux(screen + clipboard, clipboard);
        }

        return dp[screen][clipboard] = 1 + Math.min(aux(screen, screen), aux(screen + clipboard, clipboard));
    }
}
