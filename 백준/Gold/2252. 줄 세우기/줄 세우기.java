import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] edgeCount =new int[N + 1];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i <= N+1; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int te0 = Integer.parseInt(st.nextToken());
            int te1 = Integer.parseInt(st.nextToken());
            graph.get(te0).add(te1);
            edgeCount[te1]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i < edgeCount.length; i++) {
            if (edgeCount[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int studentNo = q.poll();

            System.out.print(studentNo+" ");
            List<Integer> list = graph.get(studentNo);

            for (int i = 0; i < list.size(); i++) {
                int temp = list.get(i);
                edgeCount[temp] -- ;
                if (edgeCount[temp] == 0) {
                    q.offer(temp);
                }
            }
        }
    }
}