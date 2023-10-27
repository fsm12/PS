import java.io.*;
import java.util.*;

public class Main {
    static int[] dx, dy;
    static int n, m;
    static int answer = Integer.MAX_VALUE;
    static int[][] map;
    
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j ++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        dx = new int[]{1, 1, 1};
        dy = new int[]{-1, 0, 1};
        for(int l = 0; l < m; l++) {
            int ans = 0;
            ans += map[0][l];
            dfs(0, l, ans, 3);
        }
        System.out.println(answer);
    }
    
    private static void dfs(int x, int y, int ans, int dir){
        if(x == n-1){
            if(ans < answer) answer = ans;
            return;
        }
        for (int i = 0; i < 3; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if( (dir != i) && isIn(nx,ny)){
                dfs(nx, ny, ans + map[nx][ny], i);
            }
        }
    }
    
    private static boolean isIn(int x, int y){
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}