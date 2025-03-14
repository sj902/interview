import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Example {
    public static void main(String[] args) throws IOException {
        minCoinsAux();
    }

    private static void coinCombinations1() throws IOException {
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
        coinCombinations1(n, x, coins);
    }

    private static void coinCombinations1(int n, int x, int[] coins) {
        int[] dp = new int[x + 1];
        dp[0] = 1;
        int MOD = 1000000007;

        for (int i = 1; i <= x; i++) {
            for (int j = 0; j < n; j++) {
                if (i - coins[j] >= 0) {
                    dp[i] += dp[i - coins[j]];
                    if (dp[i] >= MOD) {
                        dp[i] -= MOD;
                    }
                }
            }
        }
        System.out.println(dp[x]);
    }

    private static void minCoinsAux() throws IOException {
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
        System.out.println(minCoins(n, x, coins));
    }

    private static long minCoins(int n, int x, int[] coins) {
        long[] dp = new long[x + 1];
        Arrays.fill(dp, Long.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= x; i++) {
            long res = Long.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if(i>=coins[j] && dp[i - coins[j]]!=Long.MAX_VALUE){
                    res = Math.min(res, 1 + dp[i - coins[j]]);
                }
            }
            dp[i] = res;
        }


        return dp[x] == Long.MAX_VALUE ? -1 : dp[x];
    }

    // https://cses.fi/problemset/task/1633/
    private static int dice(int n) {
        int mod = 1000000007;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 6; j++) {
                if (i - j >= 0) {
                    dp[i] += dp[i - j];
                }
                if (dp[i] >= mod) {
                    dp[i] = dp[i] % mod;
                }
            }
        }
        return dp[n];
    }
}
