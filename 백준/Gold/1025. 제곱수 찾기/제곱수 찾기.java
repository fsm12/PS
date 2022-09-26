import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int ans = -1;

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int n=0; n<N; n++){
            String str = br.readLine();
            for(int m=0; m<M; m++){
                map[n][m] = str.charAt(m) - '0';
            }
        }

        for(int i=0; i<N; ++i){
            for(int j=0; j<M; ++j){
                slv(j, i);
            }
        }
        System.out.println(ans);
    }

    public static void slv(int c, int r){
        for(int i=-N; i<N; ++i){
            for(int j=-M; j<M; ++j){
                if(i == 0 && j == 0) continue;

                int x = c;
                int y = r; 

                int sqr = 0;

                while (0<=x && x<M && 0<=y && y<N){
                    sqr *= 10;
                    sqr += map[y][x];

                    if( Math.sqrt(sqr)-(int)Math.sqrt(sqr) == 0 )
                        ans = Math.max(ans, sqr);

                    x += j;
                    y += i;
                }
            }
        }
    }
}