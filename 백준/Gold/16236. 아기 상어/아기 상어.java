import java.io.*;
import java.util.*;

public class Main {
    static int N, sharkSize = 2, numberOfEatingFish = 0, time = 0;
    static Shark cur;
    static int[] dx={-1,0,1,0}, dy={0,-1,0,1};
    static int[][] board;
    static boolean[][] vis;
    static boolean isEatFish;

    public static void main(String[] args) throws Exception {
        // System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());

        board = new int[N][N];
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 9) {
                	cur = new Shark(i,j,0);
                    board[i][j] = 0;
                }
            }
        }

        while (true) {
        	PriorityQueue<Shark> pq = new PriorityQueue<>();
            vis = new boolean[N][N];
            
            pq.add(new Shark(cur.x, cur.y, 0));
            vis[cur.x][cur.y] = true;

            isEatFish = false;

            while (!pq.isEmpty()) {
            	cur = pq.poll();
                if (0 < board[cur.x][cur.y] && board[cur.x][cur.y] < sharkSize) { 
                    board[cur.x][cur.y] = 0; 
                    numberOfEatingFish++;
                    time += cur.time; 
                    isEatFish = true;
                    break;
                }

                for (int i=0; i<4; i++) {
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];

                    if (nx < 0 || ny < 0 || N <= nx || N <= ny)
                        continue;
                        
                    if(vis[nx][ny])
                    	continue;
                    
                    if(sharkSize < board[nx][ny] )
                    	continue;
                    
                    pq.add(new Shark(nx, ny, cur.time + 1));
                    vis[nx][ny] = true;
                }
            }

            if (!isEatFish)
                break;

            if (sharkSize == numberOfEatingFish) {
                sharkSize++;
                numberOfEatingFish = 0;
            }
        }
        System.out.println(time);
    }
}

class Shark implements Comparable<Shark>{
	int x, y, time;
	
	public Shark(int x, int y, int time) {
		this.x = x;
		this.y = y;
		this.time = time;
	}

	@Override
	public int compareTo(Shark o) {
		if (this.time != o.time) {
            return Integer.compare(this.time, o.time);
        } else if (this.x != o.x) {
            return Integer.compare(this.x, o.x);
        } else {
            return Integer.compare(this.y, o.y);
        }
	}
}