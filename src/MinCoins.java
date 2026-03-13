import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MinCoins {
    public static void main(String[] args) throws IOException {
        minCoinsAux();
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
                if (i >= coins[j] && dp[i - coins[j]] != Long.MAX_VALUE) {
                    res = Math.min(res, 1 + dp[i - coins[j]]);
                }
            }
            dp[i] = res;
        }


        return dp[x] == Long.MAX_VALUE ? -1 : dp[x];
    }
}
