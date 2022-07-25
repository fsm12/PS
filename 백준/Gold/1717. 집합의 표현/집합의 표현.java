import java.io.*;
import java.util.*;
public class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parent = new int[N+1];

        initialize(N);
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int cond = Integer.parseInt(st.nextToken());
            if(cond==1){
                if(find(Integer.parseInt(st.nextToken())) == find(Integer.parseInt(st.nextToken()))){
                    System.out.println("YES");
                }else{
                    System.out.println("NO");
                }
            }else if(cond==0){
                union(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            }
        }

    }
    public static void initialize(int N){
        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }
    }
    public static void union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);
        parent[aRoot] = bRoot;
    }
    public static int find(int a){
        if(parent[a]==a){
            return a;
        }else{
            return parent[a] = find(parent[a]);
        }
    }
}