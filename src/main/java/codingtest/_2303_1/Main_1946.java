package codingtest._2303_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main_1946 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            List<Score> scores = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                String[] input = br.readLine().split(" ");
                int document = Integer.parseInt(input[0]);
                int interview = Integer.parseInt(input[1]);
                scores.add(new Score(document, interview));
            }

            List<Score> sortedScores = scores.stream()
                    .sorted(Comparator.comparingInt(o -> o.document))
                    .toList();
            int first = sortedScores.get(0).interview;
            int count = 1;

            for (int j = 1; j < sortedScores.size(); j++) {
                int now = sortedScores.get(j).interview;
                if (now < first) {
                    first = now;
                    count++;
                }
            }

            System.out.println(count);
        }
    }

    static class Score {
        int document;
        int interview;

        public Score(int document, int interview) {
            this.document = document;
            this.interview = interview;
        }
    }
}