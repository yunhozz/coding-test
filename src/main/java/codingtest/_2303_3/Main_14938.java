package codingtest._2303_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14938 {

    static List<List<int[]>> tree;
    static int max = 0;

    static void bfs(int start, int n, int m) {
        Queue<int[]> q = new LinkedList<>();
        boolean[] visit = new boolean[n+1];

        q.offer(new int[]{start, tree.get(start).get(0)[1], 0});
        visit[start] = true;
        int sum = 0;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int locate = now[0];
            int items = now[1];
            int move = now[2];
            List<int[]> branches = tree.get(locate);

            for (int[] branch : branches) {
                int goal = branch[0];
                int itemNum = branch[1];
                int length = branch[2];

                if (!visit[goal] && m >= move + length) {
                    q.offer(new int[]{goal, items + itemNum, move + length});
                    visit[goal] = true;
                    continue;
                }

                sum += itemNum;
            }
        }

        max = Math.max(max, sum);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 지역의 개수
        int m = Integer.parseInt(st.nextToken()); // 수색 범위
        int r = Integer.parseInt(st.nextToken()); // 길의 개수

        int[] itemNumbers = new int[n+1];
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            itemNumbers[i] = Integer.parseInt(st.nextToken());
        }

        tree = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 1; i <= r; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            
            tree.get(a).add(new int[] {b, itemNumbers[a], l});
            tree.get(b).add(new int[] {a, itemNumbers[b], l});
        }

        for (int i = 1; i <= n; i++) {
            bfs(i, n, m);
        }

        System.out.println(max);
    }
}