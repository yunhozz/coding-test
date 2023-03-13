package codingtest._2303_3;

import java.util.Arrays;
import java.util.Scanner;

public class Main_4779 {

    static String[] arr;

    static void makeBar(int start, int size) {
        if (size == 1) {
            arr[start] = "-";
            return;
        }

        int newSize = size / 3;
        for (int i = 0; i < 3; i++) {
            if (i != 1) {
                makeBar(start + i * newSize, newSize);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            StringBuilder sb = new StringBuilder();
            int n = sc.nextInt();

            arr = new String[(int) Math.pow(3, n)];
            Arrays.fill(arr, " ");
            makeBar(0, arr.length);

            for (String s : arr) {
                sb.append(s);
            }

            System.out.println(sb);
        }
    }
}