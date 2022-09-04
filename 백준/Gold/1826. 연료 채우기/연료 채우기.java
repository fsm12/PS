import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Gas> stations = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            stations.add(new Gas(a, b));
        }

        st = new StringTokenizer(br.readLine());
        int L = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> fuels = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0;

        while (P < L) {
            while (!stations.isEmpty() && stations.peek().a <= P) {
                fuels.add(stations.poll().b);
            }

            if (fuels.isEmpty()) {
                System.out.println(-1);
                return;
            }

            answer++;
            P += fuels.poll();
        }

        System.out.println(answer);
    }

    public static class Gas implements Comparable<Gas> {
        int a;
        int b;

        public Gas(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Gas o) {
            return this.a - o.a;
        }
    }
}