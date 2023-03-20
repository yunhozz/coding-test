package codingtest._2303_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1495 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 곡의 개수
        int s = Integer.parseInt(st.nextToken()); // 시작 볼륨
        int m = Integer.parseInt(st.nextToken()); // 최대 볼륨

        int[] volume = new int[m+1];
        Arrays.fill(volume, -1);
        volume[s] = 0;

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            int vol = Integer.parseInt(input[i]);
            List<Integer> list = new ArrayList<>();

            for (int j = 0; j <= m; j++) {
                if (volume[j] == i) {
                    int v1 = j + vol;
                    int v2 = j - vol;

                    if (0 <= v1 && v1 <= m) {
                        list.add(v1);
                    }

                    if (0 <= v2 && v2 <= m) {
                        list.add(v2);
                    }
                }
            }

            for (Integer v : list) {
                volume[v] = i + 1;
            }
        }

        int max = -1;
        for (int i = 0; i <= m; i++) {
            if (volume[i] == n) {
                max = Math.max(max, i);
            }
        }

        System.out.println(max);
    }
}