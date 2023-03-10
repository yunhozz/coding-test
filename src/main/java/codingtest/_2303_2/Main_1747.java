package codingtest._2303_2;

import java.util.Arrays;
import java.util.Scanner;

public class Main_1747 {

    static boolean isPalindrome(int num) {
        String str = String.valueOf(num);
        String[] arr = str.split("");

        for (int i = 0; i < arr.length / 2; i++) {
            if (!arr[i].equals(arr[arr.length-1-i]))
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        boolean[] isSosu = new boolean[2000000];
        Arrays.fill(isSosu, true);
        isSosu[0] = isSosu[1] = false;

        for (int i = 2; i < isSosu.length; i++) {
            if (isSosu[i]) {
                for (int j = i * 2; j < isSosu.length; j += i) {
                    isSosu[j] = false;
                }
            }
        }

        for (int num = n; num <= 2000000; num++) {
            if (isSosu[num] && isPalindrome(num)) {
                System.out.println(num);
                break;
            }
        }
    }
}
