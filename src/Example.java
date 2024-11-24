import java.util.*;

public class Example {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        System.out.println(dice(n));
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
