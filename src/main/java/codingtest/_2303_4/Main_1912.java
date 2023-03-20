package codingtest._2303_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1912 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        int[] dp = new int[n];
        int max = arr[0];
        dp[0] = arr[0];

        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i-1] + arr[i], arr[i]);
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}