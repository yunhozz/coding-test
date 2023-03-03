package codingtest._2303_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1244 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int switchNum = Integer.parseInt(br.readLine());
        int[] arr = new int[switchNum];

        String[] input1 = br.readLine().split(" ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(input1[i]);
        }

        int peopleNum = Integer.parseInt(br.readLine());
        for (int i = 0; i < peopleNum; i++) {
            String[] input2 = br.readLine().split(" ");
            int gender = Integer.parseInt(input2[0]);
            int num = Integer.parseInt(input2[1]);

            if (gender == 1) {
                for (int j = num - 1; j < arr.length; j += num) {
                    arr[j] = 1 - arr[j];
                }

            } else {
                arr[num-1] = 1 - arr[num-1];
                if (num == 1 || num == arr.length) continue;

                int left = num - 2;
                int right = num;

                while (arr[left] == arr[right]) {
                    arr[left] = 1 - arr[left];
                    arr[right] = 1 - arr[right];
                    left--;
                    right++;

                    if (left < 0 || right >= arr.length) break;
                }
            }
        }

        int size = 0;
        for (int n : arr) {
            if (size >= 20) {
                sb.append("\n");
                size = 0;
            }

            sb.append(n).append(" ");
            size++;
        }

        System.out.println(sb);
    }
}