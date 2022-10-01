import java.util.*;
import java.io.*;

public class Main{
    static int N,M;
    static char[][] map;
    static int[] u;

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        u = new int[N*M];
        for (int i = 0; i < N*M; i++) {
            u[i] = i;
        }
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int curIdx = i*M+j;
                int nextIdx = findIdx(i,j);
                if(findRoot(curIdx) != findRoot(nextIdx)){
                    union(curIdx, nextIdx);
                }
            }
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < u.length; i++) {
            set.add(findRoot(i));
        }
        System.out.println(set.size());
    }

    private static int findIdx(int i, int j) {
        if(map[i][j] =='U'){
            i--;
        }else if(map[i][j] =='D'){
            i++;
        }else if(map[i][j] =='L'){
            j--;
        }else if(map[i][j] =='R'){
            j++;
        }
        return i*M+j;
    }

    private static void union(int curNode, int nextNode) {
        int cur = findRoot(curNode);
        int next = findRoot(nextNode);
        if(curNode>nextNode){
            u[cur] = next;
        }else{
            u[next] = cur;
        }
    }

    private static int findRoot(int idx) {
        if(u[idx] == idx)
            return idx;
        else
            return u[idx] = findRoot(u[idx]);
    }
}