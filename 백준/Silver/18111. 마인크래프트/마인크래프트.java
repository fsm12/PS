import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder("");
    static int M, N, B, MIN = Integer.MAX_VALUE, MAX = Integer.MIN_VALUE;
    static int[][] map;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int value = Integer.parseInt(st.nextToken());
                map[i][j] = value;

                MIN = Math.min(MIN,value);
                MAX = Math.max(MAX, value);
            }
        }

        int ansTime = Integer.MAX_VALUE;
        int ansHeight = -1;

        for(int i = MIN; i<= MAX; i++){
            int time = 0;
            int inventory = B;

            for(int j=0;j<N; j++){
                for(int k=0; k<M; k++){
                    int diff = map[j][k] - i;
                    if(diff > 0){
                        time += Math.abs(diff) * 2;
                        inventory += Math.abs(diff);
                    }else if(diff < 0){
                        time += Math.abs(diff);
                        inventory -= Math.abs(diff);
                    }
                }
            }

            if(inventory >= 0){
                if(time <= ansTime){
                    ansTime = time;
                    ansHeight = i;
                }
            }
        }
        System.out.println(ansTime + " " + ansHeight);
    }
}