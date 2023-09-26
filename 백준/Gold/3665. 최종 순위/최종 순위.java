import java.io.*;
import java.util.*;

public class Main {
	static int T,N,M;
	static int[] indegree;
	static boolean[][] adjMatrix;

	public static void main(String[] args) throws IOException {
		// System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			N = Integer.parseInt(br.readLine());
			indegree = new int[N+1];
			adjMatrix = new boolean[N+1][N+1];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i=0; i<N; i++) {
				int num = Integer.parseInt(st.nextToken());
				indegree[num] = i;
				for (int j=1; j<=N; j++) {
					if (j!=num && !adjMatrix[j][num]) {
						adjMatrix[num][j] = true;
					}
				}
			}

			M = Integer.parseInt(br.readLine());
			for (int m=0; m<M; m++) {
				st = new StringTokenizer(br.readLine());
				int n1 = Integer.parseInt(st.nextToken());
				int n2 = Integer.parseInt(st.nextToken());
				swap(n1, n2);
			}
			sb.append(topologicalSort()).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static String topologicalSort() {
		Queue<Integer> q = new LinkedList<>();
		for (int i=1; i<=N; i++) {
			if (indegree[i] == 0)
				q.offer(i);
		}

		StringBuilder sb = new StringBuilder();
		for (int i=1; i<=N; i++) {
			if (q.size() == 0)
				return "IMPOSSIBLE";
			if (q.size() > 1)
				return "?";
			int cur = q.poll();
			sb.append(cur + " ");

			for (int j=1; j<=N; j++) {
				if (adjMatrix[cur][j]) {
					adjMatrix[cur][j] = false;
					if (--indegree[j] == 0)
						q.offer(j);
				}
			}
		}
		return sb.toString();
	}

	private static void swap(int n1, int n2) {
		if (adjMatrix[n1][n2]) {
			adjMatrix[n1][n2] = false;
			adjMatrix[n2][n1] = true;
			indegree[n1]++;
			indegree[n2]--;

		} else {
			adjMatrix[n1][n2] = true;
			adjMatrix[n2][n1] = false;
			indegree[n1]--;
			indegree[n2]++;
		}
	}
}