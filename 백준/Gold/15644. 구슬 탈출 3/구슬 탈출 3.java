import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
		static int N, M, ry, rx, by, bx;
		static char[][] map;
		static Queue<Ball> q = new LinkedList<>();
		static int[] dy = { -1, 1, 0, 0 }, dx = { 0, 0, -1, 1 };

		public static void main(String[] args) throws Exception {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new char[N][M];
			for (int i = 0; i < N; i++) {
				map[i] = br.readLine().toCharArray();
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 'R') {
						ry = i;
						rx = j;
						map[i][j] = '.';
					} else if (map[i][j] == 'B') {
						by = i;
						bx = j;
						map[i][j] = '.';
					}
				}
			}
			q.offer(new Ball(ry, rx, by, bx, 0, ""));
			bfs();
		}

		private static void bfs() {
			while (!q.isEmpty()) {
				Ball b = q.poll();
				if (b.cnt > 10) { // 10회 이상이므로 실패
					System.out.println(-1);
					return;
				}
				if(map[b.by][b.bx] == 'O') // 파란공이 골인한경우 다음으로 넘김
					continue;
				if(map[b.ry][b.rx] == 'O') { // 빨간공이 골인한 경우
					System.out.println(b.cnt);
					System.out.println(b.dir);
					return;
				}
				for (int i = 0; i < 4; i++) { // 파란공 빨간공 둘다 이동시켜줌
					by = b.by;
					bx = b.bx;
					while (true) {
						by += dy[i];
						bx += dx[i];
						if (map[by][bx] == '#') { // 벽을 만나면 뒤로 한칸 돌려보내고 멈춤
							by -= dy[i];
							bx -= dx[i];
							break;
						}
						if (map[by][bx] == 'O') { // 골인하면 멈춤
							break;
						}
					}
					ry = b.ry;
					rx = b.rx;
					while (true) {
						ry += dy[i];
						rx += dx[i];
						if (map[ry][rx] == '#') { // 벽을 만나면 뒤로 한칸 돌려보내고 멈춤
							ry -= dy[i];
							rx -= dx[i];
							break;
						}
						if (map[ry][rx] == 'O') { // 골인하면 멈춤
							break;
						}
					}
					if(ry == by && rx == bx && map[ry][rx] != 'O') { // 빨간공 파란공 위치가 같을경우
						// 시작에서 현재까지 이동 거리를 비교해서 둘중 하나를 뒤로 한칸 이동
	                    			int red = Math.abs(b.ry - ry) + Math.abs(b.rx - rx);
						int blue = Math.abs(b.by - by) + Math.abs(b.bx - bx);
						
						if(red > blue) { //레드가 크면 레드가 늦게 온거 더많이 이동했으니
							ry -= dy[i];
							rx -= dx[i];
						}else if(blue > red) { 
							by -= dy[i];
							bx -= dx[i];
						}
					}
					if(i == 0) //방향에 따른 이동 방향을 계속 추가해줌
						q.offer(new Ball(ry, rx, by, bx, b.cnt+1, b.dir+"U"));
					else if(i == 1)
						q.offer(new Ball(ry, rx, by, bx, b.cnt+1, b.dir+"D"));
					else if(i == 2)
						q.offer(new Ball(ry, rx, by, bx, b.cnt+1, b.dir+"L"));
					else 
						q.offer(new Ball(ry, rx, by, bx, b.cnt+1, b.dir+"R"));
				}
			}
		}

		static class Ball {
			int ry, rx, by, bx, cnt;
			String dir;
			public Ball(int ry, int rx, int by, int bx, int cnt, String dir) {
				this.ry = ry;
				this.rx = rx;
				this.by = by;
				this.bx = bx;
				this.cnt = cnt;
				this.dir = dir;
			}
		}
	}