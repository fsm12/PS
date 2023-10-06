import java.io.*;
import java.util.*;

/* sol 1)
 * 그대로 인접리스트를 생성했을 때 인접 차수가 0인 가장 작은 노드부터 삭제
 */

public class Main {
	static int N,M,cnt;
	static List<Integer>[] adjList;
	static int[] indegree;

	public static void main(String[] args) throws IOException {
		// System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		adjList = new ArrayList[N];
		for(int n=0; n<N; n++) {
			adjList[n] = new ArrayList<>();
		}
		
		indegree = new int[N];
		for(int m=0; m<M; m++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			adjList[a].add(b);
			indegree[b] += 1;
		}

		StringBuilder sb = new StringBuilder();
		cnt = N;
		while(0<cnt) {
			for(int n=0; n<N; n++) {
				if(indegree[n]!=0) {
					continue;
				}
				indegree[n]=-1;
				for(int i=0; i<adjList[n].size(); i++) {
					int idx = adjList[n].get(i);
					indegree[idx]--;
				}
				sb.append(n+1).append(" ");
				cnt--;
				break;
			}
		}
		System.out.println(sb.toString());
	}
}
