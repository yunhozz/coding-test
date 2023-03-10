package codingtest._2303_2;

import java.util.Arrays;
import java.util.Scanner;

public class Main_2447 {

    static void makeStar(char[][] board, int size, int row, int col) {
        if (size == 1) {
            board[row][col] = '*';
            return;
        }

        int newSize = size / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i != 1 || j != 1) {
                    makeStar(board, newSize, row + i * newSize, col + j * newSize);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();
        char[][] board = new char[n][n];

        for (char[] b : board) {
            Arrays.fill(b, ' ');
        }

        makeStar(board, n, 0, 0);
        for (int i = 0; i < n; i++) {
            sb.append(board[i]).append("\n");
        }

        System.out.println(sb);
    }
}
