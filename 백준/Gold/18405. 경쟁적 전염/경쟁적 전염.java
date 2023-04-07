import java.util.*;
import java.io.*;

/*
 * 1 초	256 MB
 * 
 * [입력]
 * 1> N, i (1 ≤ N ≤ 200, 1 ≤ i ≤ 1,000) 
 * N> 시험관의 정보
 * 1>  S, X, Y (0 ≤ S ≤ 10,000, 1 ≤ X, Y ≤ N)
 * => S초 뒤에 (X,Y)에 존재하는 바이러스의 종류 (존재하지 않는다면, 0을 출력)
 * 
 * 1초마다 상, 하, 좌, 우의 방향으로 증식
 * 번호가 낮은 종류의 바이러스부터 먼저 증식
 * 
 * sol)
 * 바이러스 오름차순
 * bfs
 */

public class Main{
	static int N,K,S,X,Y;
	static int[][] map;
	static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
	static List<Virus> virus_list;
	
	public static void main(String[] args) throws Exception{
		// System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		virus_list = new ArrayList<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0) {
                	virus_list.add(new Virus(i, j, map[i][j], 0));
                }
			}
		}
		
		Collections.sort(virus_list);
		
		Queue<Virus> q = new LinkedList<>();
		for(Virus v : virus_list) {
			q.add(v);
		}
		
		st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		
		while (!q.isEmpty()) {
            Virus now = q.poll();
            int x = now.x;
            int y = now.y;

            if (now.time == S) {
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (0 <= nx && nx < N && 0 <= ny && ny < N) {
                    if (map[nx][ny] == 0) {
                        map[nx][ny] = now.virus;
                        q.add(new Virus(nx, ny, now.virus, now.time + 1));
                    }
                }
            }
        }
		
		System.out.println(map[X-1][Y-1]);
	}
}

class Virus implements Comparable<Virus>{
	int x,y,virus,time;
	
	public Virus(int x, int y, int virus, int time) {
		this.x = x;
		this.y = y;
		this.virus = virus;
		this.time = time;
	}

	@Override
	public int compareTo(Virus o) {
		return virus - o.virus;
	}
	
}