import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Example {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // Read n (number of coins) and x (desired sum)
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        // Read coin values
        int[] coins = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(minCoins(n,x,coins));
    }

    private static int minCoins(int n, int x, int[] coins) {
        if(x == 0){
            return 0;
        }
        return 0;
    }

    // https://cses.fi/problemset/task/1633/
    private static int dice(int n) {
        int mod = 1000000007;
        int[] dp = new int[n+1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <=6 ; j++) {
                if(i-j>=0){
                    dp[i] += dp[i-j];
                }
                if(dp[i]>=mod){
                    dp[i] = dp[i]%mod;
                }
            }
        }
        return dp[n];
    }
}
