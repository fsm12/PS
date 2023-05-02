import java.util.*;
import java.io.*;

/*
 * Shark > 좌표, 방향, 얼마나 먹었는가
 * Fish > 좌표, 방향, 고유아이디, 살아있는가
 * 
 * 1. 상어 0,0에 넣기
 * 	- 0,0 물고기 죽이기
 * 	- 상어가 먹은 물고기 추가
 *  - 맵에 물고기 번호와 비교할 수 있게 -1 넣기
 *  
 * 2. 물고기 이동
 * 	- 2,3과정 거치면서 맵의 상태가 변화함 (깊은 복사로 전 상태 저장) ->체크인/체크아웃으로 관리
 * 	- 작은 아이디의 물고기부터 순회하며(배열로 넣어두면 편할듯) 이동 가능할때 까지 8방향 회전
 * 	- 움직일 수 있으면 물고기 위치 교환
 * 
 * 3. 상어 이동 
 * 	- 상어는 최대 3칸까지 이동 가능
 * 	- 해당 칸의 물고기를 죽이고 dfs (체크아웃으로 살리기)
 * 
 */
public class Main {
	static final int N=4;
	static int ans = 0;
	static int[][] map;
	static Fish[] fish;
	static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1}, dy = {0, -1, -1, -1, 0, 1, 1, 1};

	public static void main(String[] args) throws IOException {
		// System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		map = new int[N][N];
		fish = new Fish[N*N+1];
		for(int i = 0; i < N; i++) {
			StringTokenizer st  = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				int id = Integer.parseInt(st.nextToken()); 
				int d = Integer.parseInt(st.nextToken())-1; 
				fish[id] = new Fish(id, i, j, d, true); 
				map[i][j] = id; 
			}
		}

		Shark shark = new Shark(0, 0, fish[map[0][0]].d, map[0][0]);
		fish[map[0][0]].isAlive = false; 
		map[0][0] = -1;

		dfs(shark);

		bw.write(ans+"");
		bw.flush();
	}

	public static void dfs(Shark shark) {
		ans = Math.max(ans, shark.eat); 

		int[][] copy_map = new int[N][N];
		for(int i = 0; i < N; i++) {
			System.arraycopy(map[i], 0, copy_map[i], 0, N);
		}

		Fish[] copy_fish = new Fish[N*N+1];
		for(int i = 1; i <= N*N; i++) { 
			copy_fish[i] = new Fish(fish[i].id, fish[i].x, fish[i].y, fish[i].d, fish[i].isAlive);
		}

		moveFish();

		for(int i = 1; i < N; i++) {
			int nx = shark.x + dx[shark.d] * i;
			int ny = shark.y + dy[shark.d] * i;

			if(0<=nx && nx<N && 0<=ny && ny<N && map[nx][ny] != 0) { 
				int eatFish = map[nx][ny];
				int nd = fish[eatFish].d;
				
				fish[eatFish].isAlive = false;
				map[shark.x][shark.y] = 0;
				map[nx][ny] = -1;

				dfs(new Shark(nx, ny, nd, shark.eat+eatFish));

				fish[eatFish].isAlive = true;
				map[shark.x][shark.y] = -1;
				map[nx][ny] = eatFish;
			}
		}

		for(int j = 0; j < N; j++) { 
			System.arraycopy(copy_map[j], 0, map[j], 0, N);
		}

		for(int i=1; i<=N*N; i++) {
			fish[i] = new Fish(copy_fish[i].id, copy_fish[i].x, copy_fish[i].y, copy_fish[i].d, copy_fish[i].isAlive);
	
		}
	}

	public static void moveFish() {
		for(int n = 1; n <= N*N; n++) {  
			if(!fish[n].isAlive) { 
				continue;
			}

			int d = fish[n].d;
			int nx = 0, ny = 0; 
			for(int i=0; i<8; i++) { 
				fish[n].d = d; 

				nx = fish[n].x + dx[d]; 
				ny = fish[n].y + dy[d];

				if(0<=nx && nx<N && 0<=ny && ny<N && map[nx][ny] != -1) { 
					if(map[nx][ny] == 0) {
						map[fish[n].x][fish[n].y] = 0; 
						fish[n].x = nx;
						fish[n].y = ny;
						map[nx][ny] = n; 
					} else { 
						int changeFish = fish[map[nx][ny]].id;
						fish[changeFish].x = fish[n].x;
						fish[changeFish].y = fish[n].y;
						map[fish[changeFish].x][fish[changeFish].y] = changeFish;

						fish[n].x = nx;
						fish[n].y = ny;
						map[nx][ny] = n;
					}
					break;
				}else {
					d = (d+1)%8; 
				}
			}
		}
	}
}

class Shark{
	int x,y,d,eat;
	
	public Shark(int x, int y, int d, int eat) {
		this.x=x;
		this.y=y;
		this.d=d;
		this.eat=eat;
	}
}
class Fish {
	int id,x,y,d;
	boolean isAlive; 

	public Fish(int id, int x, int y, int d, boolean isAlive) {
		this.id = id;
		this.x = x;
		this.y = y;
		this.d = d;
		this.isAlive = isAlive;
	}
}