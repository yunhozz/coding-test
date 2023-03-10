package codingtest._2303_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_22945 {

//    시간 초과
//    static int max = Integer.MIN_VALUE;
//
//    static void func(int[] arr, int left, int right) {
//        if (left == right - 1) {
//            return;
//        }
//
//        int power = (right - left - 1) * Math.min(arr[left], arr[right]);
//        max = Math.max(max, power);
//        func(arr, left + 1, right);
//        func(arr, left, right - 1);
//    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        int left = 0;
        int right = n - 1;
        int max = Integer.MIN_VALUE;

        while (left <= right) {
            max = Math.max(max, (right - left - 1) * Math.min(arr[left], arr[right]));
            if (arr[left] < arr[right]) {
                left++;
            } else {
                right--;
            }
        }

        System.out.println(max);
    }
}
