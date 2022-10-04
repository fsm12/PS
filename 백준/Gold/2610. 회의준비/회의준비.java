import java.io.*;
import java.util.*;

public class Main {
    static final int MAX_VALUE = 1000000000; // 정수 최댓값을 넣어두면 오버플로우로 연산이 이상해질 수 있음
    static int N, M;
    static int[][] dist;
    static int[] mdist;
    static PriorityQueue<Integer> pq;

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        mdist = new int[N + 1];
        dist = new int[N + 1][N + 1];

        // 인접행렬 - 본인과 본인과의 거리는 0이니 pass하고, 그게 아니라면 거리를 무한대로 초기화 한다.
        for(int n=1;n<=N;n++) {
            Arrays.fill(dist[n], MAX_VALUE);
            dist[n][n]=0;
        }

        // 문제에서 주어진 관계는 바로(1번만에) 갈수있다는 것이므로 1을 넣는다.
        for (int m = 0; m < M; m++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            // 양방향
            dist[x][y] = 1;
            dist[y][x] = 1;
        }

        //플로이드
        for(int k=1;k<=N;k++)
            for(int i=1;i<=N;i++)
                for(int j=1;j<=N;j++)
                    // K를 경유한 경우가 바로 간 경우보다 빠르다면
                    if(dist[i][j]>dist[i][k]+dist[k][j]) {
                        //거리(비용) 대입
                        dist[i][j]=dist[i][k]+dist[k][j];
                    }

        // mdist 만들기 - 한 행에서 MAX_VALUE 가 아닌 가장 큰수를 담은 배열
        for(int i=1;i<=N;i++)
            for(int j=1;j<=N;j++)
                if(dist[i][j]<MAX_VALUE && dist[i][j]>mdist[i])
                    mdist[i]=dist[i][j];

        pq = new PriorityQueue<>(); // 순서대로 꺼내기 위함
        boolean[] vis = new boolean[N+1];
        //1.연결되어있는가
        for(int i=1;i<=N;i++) {
            //2. 갈수있는가 - 방문하지 않았으면 가능
            if(!vis[i]) {
                int d=mdist[i];
                int cm=i;
                for(int j=1;j<=N;j++) {
                    //3. 갈수있는가 - 거리가 MAX_VALUE 가 아니라면 가능
                    if(dist[i][j]<MAX_VALUE) {
                        // 현재 사람보다 j번째 사람이 비용이 적다면
                        if(d>mdist[j]) {
                            // 대표는 j로 교체
                            d=mdist[j];
                            cm=j;
                        }
                        //4.체크인
                        vis[j]=true;
                    }
                }
                //5. 큐에넣음
                pq.add(cm);
            }
        }

        System.out.println(pq.size());
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }
}