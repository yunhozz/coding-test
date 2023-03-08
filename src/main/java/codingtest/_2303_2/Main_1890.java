package codingtest._2303_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1890 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(input[j]);
            }
        }

        long[][] dp = new long[n][n];
        dp[0][0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int now = board[i][j];
                if (now == 0)
                    break;

                if (i + now < n)
                    dp[i+now][j] += dp[i][j];
                if (j + now < n) {
                    dp[i][j+now] += dp[i][j];
                }
            }
        }

        System.out.println(dp[n-1][n-1]);
    }
}
