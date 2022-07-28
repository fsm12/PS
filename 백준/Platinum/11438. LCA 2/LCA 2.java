import java.io.*;
import java.util.*;

public class Main {
	static int N,M;
    static int[][] dp;
    static int[] depth;
    static boolean[] vst;
    static Queue<Integer> q;
    static ArrayList<Integer>[] adj;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws Exception {
    	//System.setIn(new FileInputStream("src/input.txt"));
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        dp = new int[18][N+1];	// N의 범위(10만)에서 나올 수 있는 K의 최댓값은 2^17이므로 (크게 잡아도 상관 무, 다만 작을수록 좋다)
        depth = new int[N+1];
        vst = new boolean[N+1];	// 방문배열 - BFS에서 쓰임
        
        adj = new ArrayList[N+1]; // 인접리스트 생성과정
        for(int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        StringTokenizer tk;
        int a, b;
        for(int i = 1; i < N; i++) {
            tk = new StringTokenizer(br.readLine());
            a = Integer.parseInt(tk.nextToken());
            b = Integer.parseInt(tk.nextToken());
            // 양방향이니까
            adj[a].add(b);
            adj[b].add(a);
        }

        q = new LinkedList<>();
        q.add(1);
        vst[1] = true;
        
        // BFS : 큐(링크드리스트)에 방문 할 곳을 저장하여, 큐에서 꺼내오고 저장을 반복하며 탐색
        while(!q.isEmpty()) {
        	// 1. 큐에서 꺼내옴
            int curr = q.poll();
            // 2. 목적지인가 (전체 다 해줘야하므로 딱히 없다)
            // 3. 연결된 곳을 순회
            for(int i = 0; i < adj[curr].size(); i++) {
                int next = adj[curr].get(i);
                // 4. 갈 수 있는가 ( 여기서는 갈 필요가 있는가로 보는게 맞음 - 시간줄이기 위함 )
                if(vst[next]) {
                    continue;
                }
                // 5. 체크인 
                dp[0][next] = curr; // next노드의 2의0승 번째 조상이 curr이다.
                vst[next] = true;
                depth[next] = depth[curr] + 1; // 자식의 깊이는 바로 앞 부모의 높이에 + 1 이다.
                // 6. 큐에 넣음
                q.add(next);
            }
        }
        
        // 점화식임
        for(int i = 1; i <= 17; i++) {	//2의 17승 정도만 해도 10만이 커버되므로
            for(int j = 1; j <= N; j++) {	// 노드는 문제에서 N개라 주어짐
                dp[i][j] = dp[i-1][dp[i-1][j]];
            }
        }

        M = Integer.parseInt(br.readLine());
        while(M-- > 0) {
            tk = new StringTokenizer(br.readLine());
            a = Integer.parseInt(tk.nextToken());
            b = Integer.parseInt(tk.nextToken());
            sb.append(lca(a, b) + "\n");
        }
        System.out.print(sb);
    }

    static int lca(int a, int b) {
    	// 1. 깊이부터 맞춰주자
        if(depth[a] > depth[b]) { // 이 과정을 실행하면 b의 깊이가 a보다 깊어진다
            int tmp = b;
            b = a;
            a = tmp;
        }
        int gap = depth[b] - depth[a];
        
        for(int i = 0; i <= 17; i++) {
            if((gap & (1 << i)) > 0) {	// diff가 11이라면 이진수로 변환했을때 1011(2)이므로, 2의 0승, 2의 1승, 2의 3승 올라가면 도착한다.
                b = dp[i][b]; // dp[k][v] = 노드v의 2의k승 위치 값
            }
        }
        
        // 2. 최소공통조상(LCA)를 구해보자
        if(a == b) { // 부모가 같다는 말 => 찾은거니까 return
            return a;
        }
        for(int i = 17; i >= 0; i--) {
            if(dp[i][a] != dp[i][b]) {
            	// 똑같이 점프하자
                a = dp[i][a];
                b = dp[i][b];
            }
        }
        return dp[0][a]; // 어짜피 같으니 하나만 리턴
    }
}