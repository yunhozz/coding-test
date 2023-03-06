package codingtest._2303_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main_1302 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String book = br.readLine();
            if (map.containsKey(book)) {
                map.replace(book, map.get(book) + 1);
            } else {
                map.put(book, 1);
            }
        }

        String ans = map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .min((o1, o2) -> (o2.getValue() - o1.getValue()))
                .get().getKey();

        System.out.println(ans);
    }
}