import java.util.*;
import java.io.*;

public class Main{
    static int N,sum=0;
    static String[] lights, startEnd;
    static List<String> combList;
    static int[] changeLights;
    static boolean[] vis;

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        lights = new String[N];
        startEnd = new String[N+1];
        combList = new ArrayList<>();
        changeLights = new int[N];

        startEnd[0]="";
        for (int n = 0; n < N; n++) {
            lights[n] = br.readLine();
            //입력과 동시에 몇번 바뀌는지 저장
            for (int len = 0; len < lights[n].length()-1; len++) {
                if(lights[n].charAt(len)!=lights[n].charAt(len+1)){
                    changeLights[n]+=1;
                }
            }
            sum+=changeLights[n];
            //System.out.println(changeLights[n]+" "+sum);
            startEnd[n+1] = lights[n].charAt(0)+""+lights[n].charAt(lights[n].length()-1);
        }

        // startEnd의 순열조합을 리스트로 만들기
        vis = new boolean[N+1];
        DFS(0, 1,"");
        //System.out.println("combList : "+combList);

        int res = Integer.MAX_VALUE;
        for (int combNumberOf = 0; combNumberOf < combList.size(); combNumberOf++) {
            int localSum = 0;
            for (int ch = 1; ch < combList.get(combNumberOf).length()-1; ch+=2) {
                if(combList.get(combNumberOf).charAt(ch)!=combList.get(combNumberOf).charAt(ch+1)){
                    localSum+=1;
                }
            }
            res = Math.min(res,localSum);
            if(res==0){
                break;
            }
        }
        System.out.println(res+sum);
    }

    private static void DFS(int i, int depth, String comb) {
        //1.체크인
        vis[i] = true;
        comb += startEnd[i];
        //2.목적지인가
        if(depth==N+1){
            combList.add(comb);
        }
        //3.연결되어있는가
        for (int j = 0; j < N+1; j++) {
            //4.갈수있는가
            if(!vis[j]){
                //5.간다
                DFS(j,depth+1,comb);
            }
        }
        //6.체크아웃
        vis[i] = false;
    }
}