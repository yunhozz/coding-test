package codingtest._2303_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1743 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean[][] board = new boolean[n+1][m+1];
        boolean[][] check = new boolean[n+1][m+1];

        for (int i = 0; i < k; i++) {
            String[] input = br.readLine().split(" ");
            int r = Integer.parseInt(input[0]);
            int c = Integer.parseInt(input[1]);
            board[r][c] = true;
        }

        int ans = 0;
        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                if (board[i][j] && !check[i][j]) {
                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[] {i, j});
                    check[i][j] = true;
                    int count = 1;

                    while (!q.isEmpty()) {
                        int[] now = q.poll();
                        int row = now[0];
                        int col = now[1];

                        for (int idx = 0; idx < 4; idx++) {
                            int nr = row + dr[idx];
                            int nc = col + dc[idx];

                            if (nr >= 0 && nc >= 0 && nr <= n && nc <= m) {
                                if (board[nr][nc] && !check[nr][nc]) {
                                    q.offer(new int[] {nr, nc});
                                    check[nr][nc] = true;
                                    count++;
                                }
                            }
                        }
                    }

                    ans = Math.max(ans, count);
                }
            }
        }

        System.out.println(ans);
    }
}