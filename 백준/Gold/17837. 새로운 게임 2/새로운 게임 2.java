import java.util.*;
import java.io.*;

public class Main {
    static int N, K, nx, ny, nd;
    static int[][] map;
    static ArrayList<Integer>[][] chessPiecesInPos;
    static int[][] dir = {{0,1},{0,-1},{-1,0},{1,0}}; //오 왼 상 하
    static int[] change_dir = {1,0,3,2}; // 왼 오 하 상
    static Chess[] chess;
    static Deque<Integer> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        chessPiecesInPos = new ArrayList[N][N];

        for(int ni=0; ni<N; ni++) {
            st = new StringTokenizer(br.readLine());
            for(int nj=0; nj<N; nj++) {
                map[ni][nj] = Integer.parseInt(st.nextToken());
                chessPiecesInPos[ni][nj] = new ArrayList<>();
            }
        }

        chess = new Chess[K+1];
        for(int k=1; k<=K; k++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            int dir = Integer.parseInt(st.nextToken())-1;
            chess[k] = new Chess(x, y, dir);
            chessPiecesInPos[x][y].add(k);
        }

        int turn = 0;
        while(true) {
            turn ++;
            for(int i=1; i<=K; i++) {
                Chess h = chess[i];
                int idx = -1;
                int size = chessPiecesInPos[h.x][h.y].size();

                for(int j=0; j<size; j++) {
                    if(chessPiecesInPos[h.x][h.y].get(j) == i) {
                        idx = j;
                        break;
                    }
                }

                queue = new ArrayDeque();
                for(int j=idx; j<size; j++) {
                    queue.offer(chessPiecesInPos[h.x][h.y].get(j));
                }
                for(int j=idx; j<size; j++) {
                    chessPiecesInPos[h.x][h.y].remove(idx);
                }

                nx = h.x+dir[h.direction][0];
                ny = h.y+dir[h.direction][1];
                nd = h.direction;

                if((nx<0 || N<=nx || ny<0 || N<=ny) || map[nx][ny] == 2) {
                    nd = change_dir[h.direction];
                    nx += (dir[nd][0]*2);
                    ny += (dir[nd][1]*2);
                }

                if((nx<0 || N<=nx || ny<0 || N<=ny) || map[nx][ny] == 2) {
                    nx -= dir[nd][0];
                    ny -= dir[nd][1];
                    while(!queue.isEmpty())
                        chessPiecesInPos[nx][ny].add(queue.poll());
                } else if(map[nx][ny] == 0) {
                    while(!queue.isEmpty())
                        chessPiecesInPos[nx][ny].add(queue.poll());
                } else if(map[nx][ny] == 1) {
                    while(!queue.isEmpty())
                        chessPiecesInPos[nx][ny].add(queue.pollLast());
                }

                if(chessPiecesInPos[nx][ny].size() >= 4 || turn > 1000) {
                    System.out.println(turn > 1000 ? -1 : turn);
                    return;
                }

                for(int j=0; j<chessPiecesInPos[nx][ny].size(); j++) {
                    int hn = chessPiecesInPos[nx][ny].get(j);
                    Chess ch = chess[hn];
                    if(hn == i)
                        chess[hn] = new Chess(nx, ny, nd);
                    else
                        chess[hn] = new Chess(nx, ny, ch.direction);
                }
            }
        }
    }
}


class Chess {
    int x;
    int y;
    int direction;

    public Chess(int x, int y, int direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }
}