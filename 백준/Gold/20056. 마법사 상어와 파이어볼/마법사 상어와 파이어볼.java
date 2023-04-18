import java.util.*;
import java.io.*;

/*
 * 1 초	512 MB
 * 
 * [입력]
 * 1> N(4 ≤ N ≤ 50), M(0 ≤ M ≤ N^2), i(1 ≤ i ≤ 1,000)
 * M> 파이어볼의 정보가 한 줄(ri, ci, mi, si, di)
 * 		i번 파이어볼의 위치는 (ri, ci), 질량은 mi이고, 방향은 di, 속력은 si
 * 		두 파이어볼의 위치가 같은 경우는 입력으로 주어지지 않는다.
 * => 마법사 상어가 이동을 K번 명령한 후, 남아있는 파이어볼 질량의 합
 * 
 * 마법사 상어가 크기가 N×N인 격자에 파이어볼 M개를 발사
 * 1번 행은 N번과 연결되어 있고, 1번 열은 N번 열과 연결
 * 
 * 마법사 상어가 모든 파이어볼에게 이동을 명령
 * 
 * 1. 모든 파이어볼이 자신의 방향 di로 속력 si칸 만큼 이동
 * 	이동하는 중에는 같은 칸에 여러 개의 파이어볼이 있을 수도 있다.
 * 
 * 2. 이동이 모두 끝난 뒤, 2개 이상의 파이어볼이 있는 칸에서
 * 	같은 칸에 있는 파이어볼은 모두 하나로 합쳐진다.
 * 	파이어볼은 4개의 파이어볼로 
 * 		[질량 :(합쳐진 파이어볼 질량의 합)/5
 * 		, 속력 :(합쳐진 파이어볼 속력의 합)/(합쳐진 파이어볼의 개수)
 * 		, 방향이 모두 홀 or 짝 => 방향은 0, 2, 4, 6, 그렇지 않으면 1, 3, 5, 7]
 * 		질량이 0인 파이어볼은 소멸되어 없어진
 * 
 */

public class Main{
	static int N,M,K,ans;
	static int[] dr = {-1,-1,0,1,1,1,0,-1}, dc = {0,1,1,1,0,-1,-1,-1};
	static Queue<FireBall>[][] map;
	static List<FireBall> fireballs;
	
	public static void main(String[] args) throws Exception{
		// System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		fireballs = new ArrayList<>();
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			fireballs.add(new FireBall(r,c,m,s,d));
		}
		
		map = new LinkedList[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = new LinkedList<>();
			}
		}
		
		while(K-->0) {
			// 1. 모든 파이어볼이 자신의 방향 di로 속력 si칸 만큼 이동
			for(FireBall fb : fireballs) {
				fb.r = (N + fb.r + dr[fb.d]*(fb.s % N)) % N;
				fb.c = (N + fb.c + dc[fb.d]*(fb.s % N)) % N;
				map[fb.r][fb.c].add(fb);
			}
			
			// 2. 같은 칸에 있는 파이어볼은 모두 하나로 합쳐진다.
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					if(map[r][c].size() >= 2) {
						int m_sum = 0, s_sum = 0;
	                    int cnt_sum = map[r][c].size();
	                    boolean odd = true, even = true;

	                    while (!map[r][c].isEmpty()) {
	                        FireBall fb = map[r][c].poll();
	                        m_sum += fb.m;
	                        s_sum += fb.s;

	                        if (fb.d % 2 == 0) {
	                            odd = false;
	                        } else {
	                            even = false;
	                        }
	                        fireballs.remove(fb);
	                    }

	                    int nm = m_sum / 5;
	                    if (nm == 0)
	                        continue;

	                    int ns = s_sum / cnt_sum;
	                    if (odd | even) { 
	                        for (int i=0; i<8; i+=2) {
	                        	fireballs.add(new FireBall(r,c,nm,ns,i));
	                        }
	                    } else {
	                        for (int i=1; i<8; i+=2) {
	                        	fireballs.add(new FireBall(r,c,nm,ns,i));
	                        }
	                    }
	                } else {
	                    map[r][c].clear();
	                }
					
				}
			}
		}

        for(FireBall fb : fireballs) {
            ans += fb.m;
        }
        bw.write(ans+"");
        bw.flush();
	}
	
	static class FireBall{
		int r,c,m,s,d;
		
		public FireBall(int r, int c, int m, int s, int d) {
			this.r = r;
			this.c = c;
			this.m = m;
			this.s = s;
			this.d = d;
		}
	}
}