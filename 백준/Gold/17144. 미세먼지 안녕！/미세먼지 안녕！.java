import java.util.*;
import java.io.*;

/*
 * 1 초	512 MB
 * 
 * [입력]
 * 1> R, C, T (6 ≤ R, C ≤ 50, 1 ≤ T ≤ 1,000)
 * R>  Ar,c (-1 ≤ Ar,c ≤ 1,000) (설치된 곳은 Ar,c가 -1이고, 나머지 값은 미세먼지의 양)
 * 			(-1은 2번 위아래로 붙어져 있고, 가장 윗 행, 아랫 행과 두 칸이상 떨어져 있다.)
 * => T초가 지난 후 구사과 방에 남아있는 미세먼지의 양
 * 
 * 공기청정기는 항상 1번 열에 설치
 * 
 * 1. 미세먼지가 확산
 * 확산은 미세먼지가 있는 모든 칸에서 동시 (공기청정기가 있거나, 칸이 없으면 그 방향으로는 확산이 일어나지 않음)
 * 확산되는 양은 Ar,c/5
 * (r, c)에 남은 미세먼지의 양은 Ar,c - (Ar,c/5)×(확산된 방향의 개수)
 * 
 * 2. 공기청정기가 작동
 * 위쪽 공기청정기의 바람은 반시계방향으로 순환하고, 아래쪽 공기청정기의 바람은 시계방향으로 순환
 * 바람이 불면 미세먼지가 바람의 방향대로 모두 한 칸씩 이동
 * 
 * 그대로 구현
 * 
 */

public class Main{
	static int R,C,T,top=-1,ans;
	static int[][] map;
	static Queue<int[]> dusts;
	static int[] dx = {-1,1,0,0}, dy = {0,0,-1,1};
	
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		for(int r=0; r<R; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<C; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if(map[r][c] == -1 && top == -1) {
					top = r;
				}
			}
		}
		
		for(int t=0; t<T; t++) {
			checkDust();
			dustSpread();
			windSpread();
		}
		
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				ans+=map[r][c];
			}
		}
		System.out.println(ans+2);
	}

	public static void checkDust() {
		dusts = new LinkedList<>();
		
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				if(map[r][c] != 0 && map[r][c] != -1) {
					dusts.add(new int[] {r,c, map[r][c]});
				}
			}
		}
	}
	
	public static void dustSpread() {
		while(!dusts.isEmpty()) {
			int[] now = dusts.poll();
            if(now[2] < 5) 
            	continue;

            int cnt = 0;
            int amount = now[2] / 5;
            for (int i=0; i<4; i++) {
                int nr = now[0] + dx[i];
                int nc = now[1] + dy[i];
                if(0<=nr && nr<R && 0<=nc && nc<C && map[nr][nc]!=-1) {
	                map[nr][nc] += amount;
	                cnt+=1;
                }
            }
            map[now[0]][now[1]] -= amount * cnt;
        }
	}
	
	public static void windSpread() {
        for (int r=top-1; r>0; r--) {
            map[r][0] = map[r-1][0];
        }
        
        for (int c=0; c<C-1; c++) {
            map[0][c] = map[0][c+1];
        }

        for (int r=0; r<top; r++) {
            map[r][C-1] = map[r+1][C-1];
        }
        
        for (int c=C-1; c>1; c--) {
            map[top][c] = map[top][c-1];
        }
        map[top][1] = 0;

        for (int r=top+2; r<R-1; r++) {
            map[r][0] = map[r+1][0];
        }

        for (int c=0; c<C-1; c++) {
            map[R-1][c] = map[R-1][c+1];
        }

        for (int r=R-1; r>top+1; r--) {
            map[r][C-1] = map[r-1][C-1];
        }

        for (int c=C-1; c>1; c--) {
            map[top+1][c] = map[top+1][c-1];
        }
        map[top+1][1] = 0;
	}
}