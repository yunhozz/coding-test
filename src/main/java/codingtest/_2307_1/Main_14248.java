package codingtest._2307_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_14248 {
    static int[][] stone;
    static boolean[] check;
    static int size;

    static void func(int now, int count) {
        if (now >= size || now < 0) {
            return;
        } else {
            if (check[now]) return;
        }
        check[now] = true;
        func(now + stone[now][1], count + 1);
        func(now - stone[now][1], count + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        stone = new int[size][2];
        check = new boolean[size];
        String[] input = br.readLine().split(" ");

        for (int i = 0; i < size; i++) {
            stone[i] = new int[] {i, Integer.parseInt(input[i])};
        }
        int start = Integer.parseInt(br.readLine());
        func(start - 1, 1);

        int ans = 0;
        for (boolean c : check) {
            if (c) ans++;
        }
        System.out.println(ans);
    }
}