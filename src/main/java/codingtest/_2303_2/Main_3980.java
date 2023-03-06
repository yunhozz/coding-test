package codingtest._2303_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_3980 {

    static int max = Integer.MIN_VALUE;

    static void func(int[][] board, int row, boolean[] check, int sum) {
        if (row >= 11) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < 11; i++) {
            if (!check[i] && board[row][i] != 0) {
                check[i] = true;
                func(board, row + 1, check, sum + board[row][i]);
                check[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int c = Integer.parseInt(br.readLine());

        for (int t = 0; t < c; t++) {
            int[][] board = new int[11][11];
            boolean[] check = new boolean[11];

            for (int i = 0; i < 11; i++) {
                String[] input = br.readLine().split(" ");
                for (int j = 0; j < 11; j++) {
                    board[i][j] = Integer.parseInt(input[j]);
                }
            }

            func(board, 0, check, 0);
            System.out.println(max);
            max = Integer.MIN_VALUE;
        }
    }
}