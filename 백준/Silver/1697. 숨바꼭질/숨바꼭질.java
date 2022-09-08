import java.util.*;
import java.io.*;

public class Main{
    static int N,K;
    static int[] vis;
    static Queue<Integer> queue;

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        vis = new int[100001];
        queue = new LinkedList<>();

        BFS(N);

        System.out.println(vis[K]);
    }

    private static void BFS(int n) {
        queue.add(n);
        vis[n]=0;
        while(!queue.isEmpty()) {
            //System.out.println(queue);
            //1.큐에서 꺼내옴
            int node = queue.poll();
            //2.목적지인가
            if(node == K){
                return;
            }

            //3.연결된곳을 순회
            if(0<=node-1 && vis[node-1]==0){
                queue.add(node-1);
                vis[node-1] = vis[node]+1;
            }
            if(node+1<=100000 && vis[node+1]==0){
                queue.add(node+1);
                vis[node+1] = vis[node]+1;
            }
            if(node*2<=100000 && vis[node*2]==0){
                queue.add(node*2);
                vis[node*2] = vis[node]+1;
            }
        }
    }
}