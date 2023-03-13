package codingtest._2303_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_14719 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = br.readLine().split(" ");
        int height = Integer.parseInt(input1[0]);
        int width = Integer.parseInt(input1[1]);
        boolean[][] board = new boolean[height][width];

        String[] input2 = br.readLine().split(" ");
        for (int i = 0; i < input2.length; i++) {
            int num = Integer.parseInt(input2[i]);
            for (int j = height - 1; j >= height - num; j--) {
                board[j][i] = true;
            }
        }

        int ans = 0;
        for (int h = height - 1; h >= 0; h--) {
            int count = 0;
            boolean start = false;

            for (int w = 1; w < width; w++) {
                if (!start && (!board[h][w] && board[h][w-1])) {
                    start = true;
                    count++;

                } else if (start) {
                    if (board[h][w]) {
                        ans += count;
                        count = 0;
                        start = false;

                    } else {
                        count++;
                    }
                }
            }
        }

        System.out.println(ans);
    }
}