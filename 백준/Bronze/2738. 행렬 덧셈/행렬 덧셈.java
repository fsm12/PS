import java.util.*;
import java.io.*;

public class Main{
    static int N,M;
    static int[][] map1, map2;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map1 = new int[N][M];
        map2 = new int[N][M];

        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            for (int m = 0; m < M; m++) {
                map1[n][m] = Integer.parseInt(st.nextToken());
            }
        }

        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            for (int m = 0; m < M; m++) {
                sb.append(map1[n][m]+Integer.parseInt(st.nextToken())+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}