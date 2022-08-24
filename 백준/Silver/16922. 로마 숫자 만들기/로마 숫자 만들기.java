import java.io.*;

public class Main{
    static int N, ans;
    static int[] list = {1,5,10,50}, tree;
    static boolean[] vis;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        tree = new int[N];
        vis = new boolean[1001];
        ans = 0;

        dfs(N,0,0);
        sb.append(ans);
        System.out.println(sb);
    }

    private static void dfs(int N, int idx, int sum) {
        //1.체크인 : 생략가능
        //2.목적지인가
        if(N==0){
            if (!vis[sum]){
                ans+=1;
                vis[sum]=true;
            }
            return;
        }
        //3.연결되어있는가 : 1, 5, 10, 15가 연결되어있다.
        for (int i = idx; i < 4; i++) {
            //4.갈수있는가 : 다 갈 수 있으므로 패스
            //5.간다
            dfs(N-1, i, sum+list[i]);
        }
        //6.체크아웃 : 생략가능
    }
}