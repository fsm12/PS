import java.io.*;
import java.util.*;

public class Main {
    static int N, M, inCnt[], outCnt[];
    static StringTokenizer st;
    static ArrayList<Integer> adj[];
    static boolean visited[];

    public static void main(String[] args) throws IOException {
    	//System.setIn(new FileInputStream("src/input.txt"));
    	
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 
    	
        st = new StringTokenizer(in.readLine());
        N = Integer.valueOf(st.nextToken());
        M = Integer.valueOf(st.nextToken());

        inCnt = new int[N + 1];
        outCnt = new int[N + 1];
        
        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(in.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
        }
        
        for (int i = 1; i <= N; i++) {
        	//체크인
            visited = new boolean[N + 1];
            //outCnt = 벗어나는 횟수 
            outCnt[i] = dfs(i) - 1;
        }
        
        int answer = 0;
        for (int i = 1; i <= N; i++) {
        	// 자신의 키가 몇번째인지 알려면, 나보다 키큰 학생수 + 나보다 작은 학생수 + 나 = 전체학생수 여야함.
            if ((inCnt[i] + outCnt[i]) == N - 1) {
                answer++;
            }
        }
        System.out.println(answer);
    }
    
    static int dfs(int curr) {
        int outCnt = 0;
        //3. 연결된 곳을 순회하기
        for (int next : adj[curr]) { // curr -> next 에서 next 가져오기
            //4.갈 수 있는가? => 갈 필요가 있는가
        	if (visited[next]) {
            	continue;
            }
            inCnt[next]++; // curr을 지나 next로 가므로 next는 curr방문순서 + 1임
            visited[next] = true;
            //5.간다
            outCnt += dfs(next);
        }
        return outCnt + 1; // 부모 카운트 + 나(1)
    }
}