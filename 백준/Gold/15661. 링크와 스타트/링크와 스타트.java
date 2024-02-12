import java.io.*;
import java.util.*;

public class Main {
    static int N,ans=Integer.MAX_VALUE;
    static int[][] map;
    static boolean[] vis;

    public static void main(String[] args) throws IOException {
    	// System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for(int i=0; i<N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	for(int j=0; j<N; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        vis = new boolean[N];
        rec(0);
        
        System.out.println(ans);
    }
    
    public static void rec(int cnt) {
    	if(cnt == N) {
    		int start=0, link=0;
    		for(int i=0; i<N; i++) {
            	for(int j=i+1; j<N; j++) {
            		if(vis[i] != vis[j])
            			continue;
            		if(vis[i]) {
            			start += map[i][j] + map[j][i];
            			continue;
            		}
        			link += map[i][j] + map[j][i];
            	}
            }
    		ans = Math.min(ans, Math.abs(start-link));
    		if(ans != Integer.MAX_VALUE)
    			return;
    	}
        vis[cnt]=true;
        rec(cnt+1);
        vis[cnt]=false;
        rec(cnt+1);
    }
}
