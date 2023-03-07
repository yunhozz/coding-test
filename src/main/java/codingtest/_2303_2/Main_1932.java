package codingtest._2303_2;

import java.util.Scanner;

public class Main_1932 {

    static int func(int[][] arr, Integer[][] dp, int row, int col, int n) {
        if (row >= n) {
            return dp[row][col];
        }

        if (dp[row][col] == null) {
            dp[row][col] = Math.max(func(arr, dp, row + 1, col, n), func(arr, dp, row + 1, col + 1, n)) + arr[row][col];
        }

        return dp[row][col];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        Integer[][] dp = new Integer[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            dp[n-1][i] = arr[n-1][i];
        }

        System.out.println(func(arr, dp, 0, 0, n));
    }
}