package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Ex22 {
    private static class FlowerDate {
        int start;
        int end;
        public FlowerDate(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        ArrayList<FlowerDate> flowerDates = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int startMonth = Integer.parseInt(st.nextToken());
            int startDay = Integer.parseInt(st.nextToken());
            int endMonth = Integer.parseInt(st.nextToken());
            int endDay = Integer.parseInt(st.nextToken());
            flowerDates.add(new FlowerDate(startMonth * 100 + startDay, endMonth * 100 + endDay));
        }
        Collections.sort(flowerDates, new Comparator<FlowerDate>() {
            @Override
            public int compare(FlowerDate o1, FlowerDate o2) {
                if (o1.start == o2.start) {
                    return o1.end - o2.end;
                }
                return o1.start - o2.start;
            }
        });

        int prev = 0;
        int end = 301;
        int max = 0;
        int cnt = 0;
        while (max <= 1130) {
            for (FlowerDate flowerDate : flowerDates) {
                if (flowerDate.start > end) break;
                if (flowerDate.start < prev) continue;
                System.out.println(flowerDate.start + " ~ " + flowerDate.end);
                max = Math.max(max, flowerDate.end);
            }
            if (max == 0) {
                System.out.println(cnt);
                return;
            }
            System.out.println(max);
            prev = end;
            end = max;
            cnt++;
        }
        System.out.println(cnt);
    }
}
//4
//1 1 5 31
//1 1 6 30
//5 15 8 31
//6 10 12 10