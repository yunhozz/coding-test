package codingtest._2303_2;

import java.util.Arrays;
import java.util.Scanner;

public class Main_16400 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        boolean[] isPrime = new boolean[40001];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i < isPrime.length; i++) {
            if (isPrime[i]) {
                for (int j = i * 2; j < isPrime.length; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int[] dp = new int[n+1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i; j <= n; j++) {
                    dp[j] = (dp[j] + dp[j-i]) % 123456789;
                }
            }
        }

        System.out.println(dp[n]);
    }
}
