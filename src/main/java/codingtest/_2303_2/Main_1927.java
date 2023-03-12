package codingtest._2303_2;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main_1927 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        Queue<Integer> pq = new PriorityQueue<>();
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            if (x > 0) {
                pq.offer(x);
            } else {
                if (pq.isEmpty()) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(pq.poll()).append("\n");
                }
            }
        }

        System.out.println(sb);
    }
}