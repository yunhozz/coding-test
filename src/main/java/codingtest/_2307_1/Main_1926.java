package codingtest._2307_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1926 {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int num = 0, max = 1;

    static void bfs(int[][] board, boolean[][] check, int n, int m) {
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 1 && !check[i][j]) {
                    q.offer(new int[] {i, j});
                    int count = 0;

                    while (!q.isEmpty()) {
                        int[] now = q.poll();
                        int row = now[0];
                        int col = now[1];

                        for (int k = 0; k < 4; k++) {
                            int nx = row + dx[k];
                            int ny = col + dy[k];

                            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                                if (board[nx][ny] == 1 && !check[nx][ny]) {
                                    check[nx][ny] = true;
                                    q.offer(new int[] {nx, ny});
                                    count++;
                                }
                            }
                        }
                    }
                    num++;
                    max = Math.max(count, max);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] board = new int[n][m];
        boolean[][] check = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int j = 0;
            for (String s : input) {
                board[i][j++] = Integer.parseInt(s);
            }
        }
        bfs(board, check, n, m);
        int ans;

        if (num == 0) ans = 0;
        else ans = max;
        System.out.print(num + "\n" + ans);
    }
}