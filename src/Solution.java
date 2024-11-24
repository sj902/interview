import java.io.*;
import java.util.*;

public class Solution {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }
    }

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out);

        // Read number of test cases
        int t = fr.nextInt();

        while(t-- > 0) {
            // For each test case
            int n = fr.nextInt();
            int[] sizes = new int[n];

            // Read sizes array
            for(int i = 0; i < n; i++) {
                sizes[i] = fr.nextInt();
            }

            // Find maximum beautiful arrangement
            int maxModels = findMaxBeautifulArrangement(n, sizes);
            out.println(maxModels);
        }

        out.close();
    }

    static int findMaxBeautifulArrangement(int n, int[] a) {
       int[] dp = new int[n+1];
       Arrays.fill(dp, 1);

        for (int i = 1; i <=n; i++) {
            for (int j = 2*i; j <=n ; j=j+i) {
                if (a[i-1]<a[j-1]){
                    dp[j] = Math.max(dp[j], dp[i]+1);
                }
            }
        }

        int res = 1;

        for (int i = 0; i <= n; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}