import java.util.*;
import java.io.*;

public class Main{
    //1. int형 변수 N, M, result, 배열(int형 2차원 배열 map[M][N], 최댓값만 가질 int형 1차원 배열 maxList) 선언
    static int N,M,result=0;
    static int[][] map;
    static int[] combList; // maxList,

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        //2. 입력값을 받아 2차원 배열(map)에 저장
        map = new int[N][M];
        for (int n = 0; n < N; n++){
            st = new StringTokenizer(br.readLine());
            for (int m = 0; m < M; m++) {
                map[n][m] = Integer.parseInt(st.nextToken());
            }
        }

        combList = new int[3];

//        maxList = new int[N];

//        //3. map을 이중반복문으로 돌며 Max를 추출하여 maxList에 저장 및 max아닌 map요소는 0으로 치환
//        for (int n = 0; n < N; n++) {
//            int max = 0;
//            for (int m = 0; m < M; m++) {
//                max = Math.max(max, map[n][m]);
//            }
//            maxList[n] = max;
//            for (int m = 0; m < M; m++) {
//                if (max != map[n][m]) {
//                    map[n][m] = 0;
//                }
//            }
//        }

        comb(0,0);

        //5. 출력
        System.out.println(result);
    }

    // 조합을 이용해 3개 뽑기 - 재귀
    public static void comb(int cnt, int s){
        if(cnt==3){
            int sum = 0;
            for (int n = 0; n < N; n++) {
                sum += getMax(n);
            }
            if(sum>result)
                result = sum;
            return;
        }

        for (int m = 0; m < M; m++) {
            combList[cnt] = m;
            comb(cnt+1, m+1);
        }
    }

    private static int getMax(int n) {
        int max = 0;
        //4. maxList를 조합을 이용해 3개를 뽑는 경우의 수만큼 반복
        for (int i = 0; i < 3; i++) {
            int tmp = map[n][combList[i]];
            //4-1. 해당 경우의 수의 max값과 이전의 max값을 비교하여 큰값을 저장
            if (tmp>max)
                max  = tmp;
        }
        return max;
    }
}