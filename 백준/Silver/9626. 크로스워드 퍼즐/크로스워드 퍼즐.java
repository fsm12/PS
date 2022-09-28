import java.util.*;
import java.io.*;

public class Main{
    static int M,N,U,L,R,D,mapN,mapM;
    static char[][] map;
    
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        U = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        mapN = U+M+D;
        mapM = R+N+L;
        map = new char[mapN][mapM];
        for (int r = 0; r < mapN; r++) {
            for (int c = 0; c < mapM; c++) {
                if((r%2==0 && c%2==0) || (r%2==1 && c%2==1)){
                    map[r][c] = '#';
                }else{
                    map[r][c] = '.';
                }
            }
        }
        for (int r = U; r < U+M; r++) {
            String str = br.readLine();
            int cnt=0;
            for (int c = L; c < L+N; c++) {
                map[r][c] = str.charAt(cnt);
                cnt+=1;
            }
        }

        for (int i = 0; i < mapN; i++) {
            for (int j = 0; j < mapM; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
}