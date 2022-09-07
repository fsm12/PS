import java.io.*;
import java.util.*;

public class Main {
    static int n, m, v;
    static int a, b;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());   // 정점 수
        m = Integer.parseInt(st.nextToken());   // 간선 수
        v = Integer.parseInt(st.nextToken());   // 탐색을 시작할 정점의 번호
        
        isVisited = new boolean[n + 1];

        LinkedList<Integer>[] adjList = new LinkedList[n + 1];
        
        for (int i = 0; i <= n; i++) {
            adjList[i] = new LinkedList<>();
        }
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            
            adjList[a].add(b);
            adjList[b].add(a);
        }
        
        for (int i = 0; i <= n; i++) {
            Collections.sort(adjList[i]);
        }
        isVisited[v] = true;
        DFS(v, adjList);
        
        Arrays.fill(isVisited, false);
        System.out.println();

        isVisited[v] = true;
        BFS(v, adjList);
    }

    public static void DFS(int v, LinkedList<Integer>[] adjList) {
        System.out.print(v + " ");

        Iterator<Integer> iter = adjList[v].listIterator(); // 정점 인접리스트 순회

        while (iter.hasNext()) {
            int w = iter.next();
            if (!isVisited[w]) {
                isVisited[w] = true;
                DFS(w, adjList);
            }
        }
    }

    public static void BFS(int v, LinkedList<Integer>[] adjList) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(v);
        
        while (queue.size() != 0) {
            v = queue.poll();
            System.out.print(v + " ");

            Iterator<Integer> iter = adjList[v].listIterator();
            while (iter.hasNext()) {
                int w = iter.next();
                if (!isVisited[w]) {
                    isVisited[w] = true;
                    queue.add(w);
                }
            }
        }
    }
}