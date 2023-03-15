package codingtest._2303_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1711 {

    static class Dot {
        long x;
        long y;

        public Dot(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Dot[] dots = new Dot[n];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            long x = Integer.parseInt(input[0]);
            long y = Integer.parseInt(input[1]);
            dots[i] = new Dot(x, y);
        }

        int count = 0;

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    Dot a = dots[i];
                    Dot b = dots[j];
                    Dot c = dots[k];
                    double v1 = Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2);
                    double v2 = Math.pow(a.x - c.x, 2) + Math.pow(a.y - c.y, 2);
                    double v3 = Math.pow(b.x - c.x, 2) + Math.pow(b.y - c.y, 2);

                    if (v1 == v2 + v3 || v2 == v1 + v3 || v3 == v1 + v2) {
                        count++;
                    }
                }
            }
        }

        System.out.println(count);
    }
}